package com.larus.bmhome.view.actionbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.view.f2;
import com.larus.chat.common.databinding.LarusLayoutTextMessageActionBarBinding;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import rs8.g;
import rs8.h;
import rs8.p;
import rs8.q;
import rs8.r;
import rs8.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u0001<B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u001b2\b\u0010%\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0002\u0010&J7\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001e2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001b0+2\b\u0010%\u001a\u0004\u0018\u00010\u001e2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016¢\u0006\u0002\u0010.J\u0016\u0010/\u001a\u00020(2\f\u00100\u001a\b\u0012\u0004\u0012\u0002010+H\u0016J\n\u00102\u001a\u0004\u0018\u000103H\u0016J\u0010\u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u000206H\u0016J\u0016\u00107\u001a\u00020\u001e2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001b0+H\u0014J\b\u00108\u001a\u00020\u001eH\u0014J,\u00109\u001a\u00020(2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001b0+2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001b0+2\u0006\u0010\u001d\u001a\u00020\u001eH\u0014R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00128DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0017\u0010\u0014R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006="}, d2 = {"Lcom/larus/bmhome/view/actionbar/NonPriorityMessageActionBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/bmhome/view/actionbar/IMessageActionBar;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/chat/common/databinding/LarusLayoutTextMessageActionBarBinding;", "getBinding", "()Lcom/larus/chat/common/databinding/LarusLayoutTextMessageActionBarBinding;", "binding$delegate", "Lkotlin/Lazy;", "startActionContainer", "Landroid/widget/LinearLayout;", "getStartActionContainer", "()Landroid/widget/LinearLayout;", "startActionContainer$delegate", "endActionContainer", "getEndActionContainer", "endActionContainer$delegate", "oldStartActions", "", "Lcom/larus/bmhome/view/actionbar/IAction;", "oldEndActions", "compactActions", "", "getCompactActions", "()Z", "setCompactActions", "(Z)V", "update", "action", "useSubscribedColor", "(Lcom/larus/bmhome/view/actionbar/IAction;Ljava/lang/Boolean;)Z", "refresh", "", "addReplaceRegen", "actions", "", "fragment", "Landroidx/fragment/app/Fragment;", "(ZLjava/util/List;Ljava/lang/Boolean;Landroidx/fragment/app/Fragment;)V", "setUpPriorityList", "priorityList", "", "parentView", "Landroid/view/ViewParent;", "getViewGlobalVisibleRect", "rect", "Landroid/graphics/Rect;", "shouldUseCompactActions", "shouldSetActionTag", "onActionsRefreshed", "newStartActions", "newEndActions", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class NonPriorityMessageActionBar extends ConstraintLayout implements h {
    public static final /* synthetic */ int g = 0;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final List<g> d;
    public final List<g> e;
    public boolean f;

    public static final class a {
    }

    static {
    }

    public NonPriorityMessageActionBar(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public NonPriorityMessageActionBar(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public void T5(List<? extends g> r1, List<? extends g> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "newStartActions");
        Intrinsics.checkNotNullParameter(r2, "newEndActions");
    }

    public boolean U5(List<? extends g> r2) {
        Intrinsics.checkNotNullParameter(r2, "actions");
        return false;
    }

    @Override // rs8.h
    public void setUpPriorityList(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "priorityList");
    }

    public Integer y3() {
        return null;
    }

    private final LarusLayoutTextMessageActionBarBinding getBinding() {
        return (LarusLayoutTextMessageActionBarBinding) this.a.getValue();
    }

    public final LinearLayout getEndActionContainer() {
        return (LinearLayout) this.c.getValue();
    }

    public final LinearLayout getStartActionContainer() {
        return (LinearLayout) this.b.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // rs8.h
    public final ViewParent f5() {
        return getParent();
    }

    public final boolean getCompactActions() {
        return this.f;
    }

    public static LinearLayout R5(NonPriorityMessageActionBar r0) {
        return r0.getBinding().d;
    }

    public static LinearLayout S5(NonPriorityMessageActionBar r0) {
        return r0.getBinding().c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // rs8.h
    public final boolean b0(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "rect");
        return getGlobalVisibleRect(r2);
    }

    public final void setCompactActions(boolean r1) {
        this.f = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // rs8.h
    public boolean update(g r5, Boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "action");
        View r0 = findViewById(r5.getId());
        f2 r2 = null;
        if ((r0 instanceof LinearLayout) == false) goto L5;
        LinearLayout r1 = (LinearLayout) r0;
    L6:
        boolean r3 = false;
        if (r1 != null) goto L10;
        return false;
    L10:
        if ((r1 instanceof f2) == false) goto L12;
        r2 = (f2) r1;
    L12:
        if (r2 != null) goto L14;
        return false;
    L14:
        if (r6 == null) goto L16;
        r3 = r6.booleanValue();
    L16:
        r2.a(r5, r3, this.f);
        return true;
    L5:
        r1 = null;
        goto L6
    }

    public NonPriorityMessageActionBar(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new p(r2, this));
        this.b = LazyKt.lazy(new q(this));
        this.c = LazyKt.lazy(new r(this));
        this.d = new ArrayList();
        this.e = new ArrayList();
    }

    public /* synthetic */ NonPriorityMessageActionBar(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // rs8.h
    public final void q5(boolean r11, List<? extends g> r12, Boolean r13, Fragment r14) {
        Intrinsics.checkNotNullParameter(r12, "actions");
        ArrayList r15 = new ArrayList();
        ArrayList r16 = new ArrayList();
        Iterator<T> r0 = r12.iterator();
    L3:
        boolean r2 = false;
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((g) r1).b() != MessageActionBarAlign.START) goto L8;
        r2 = true;
    L8:
        if (r2 == true) goto L9;
        r16.add(r1);
        goto L3
    L9:
        r15.add(r1);
        goto L3
    L11:
        Pair r3 = new Pair(r15, r16);
        List r17 = (List) r3.component1();
        List r18 = (List) r3.component2();
        this.f = U5(r12);
        boolean r19 = this instanceof AdaptiveMessageActionBar;
        Context r4 = getContext();
        List<g> r6 = this.d;
        LinearLayout r7 = getStartActionContainer();
        if (r13 == null) goto L14;
        boolean r8 = r13.booleanValue();
    L15:
        x.a(r19, r4, r17, r6, r7, r8, this.f);
        Context r5 = getContext();
        List<g> r9 = this.e;
        LinearLayout r10 = getEndActionContainer();
        if (r13 == null) goto L18;
        boolean r20 = r13.booleanValue();
    L19:
        x.a(r19, r5, r18, r9, r10, r20, this.f);
        ((ArrayList) this.d).clear();
        ArrayList r110 = (ArrayList) this.d;
        r110.addAll(r17);
        ((ArrayList) this.e).clear();
        ArrayList r111 = (ArrayList) this.e;
        r111.addAll(r18);
        T5(r17, r18, this.f);
        return;
    L18:
        r20 = false;
        goto L19
    L14:
        r8 = false;
        goto L15
    }
}

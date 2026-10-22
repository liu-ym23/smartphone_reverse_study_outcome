package com.obric.oui.swipeaction;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.google.common.reflect.w;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/swipeaction/OSwipeDeleteAnimator;", "Landroidx/recyclerview/widget/DefaultItemAnimator;", "<init>", "()V", "com/obric/oui/swipeaction/c", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSwipeDeleteAnimator extends DefaultItemAnimator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f14588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f14589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f14590c;
    public final ArrayList d;
    public final HashMap e;

    public OSwipeDeleteAnimator() {
        this.f14588a = new ArrayList();
        this.f14589b = new ArrayList();
        this.f14590c = new ArrayList();
        this.d = new ArrayList();
        this.e = new HashMap();
        setMoveDuration(300);
    }

    public static jp.d b(float r10, final Function1 r11, final Function0 r12) {
        com.obric.common.oea.foundation.animation.spec.spring.b r5 = ug.a.m(Token$Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_2);
        Intrinsics.checkNotNullParameter(r5, "spec");
        hp.a r13 = new hp.a(r5, Float.valueOf(r10), Float.valueOf(0.0f), null, "valueAnimationPlaceholder", Reflection.getOrCreateKotlinClass(Float.TYPE));
        Function3<String, Object, Object, Unit> r14 = new OSwipeDeleteAnimator$startOeaAnimation$1(r11);
        Intrinsics.checkNotNullParameter(r14, "callback");
        Function2<Boolean, Throwable, Unit> r15 = new OSwipeDeleteAnimator$startOeaAnimation$2(r12);
        Intrinsics.checkNotNullParameter(r15, "callback");
        return new w(r13, r14, r15).x();
    }

    public final void a(RecyclerView.ViewHolder r5, boolean r10) {
        if (this.f14589b.remove(r5) == true) goto L5;
        return;
    L5:
        if (r10 == false) goto L7;
        this.e.remove(r5);
    L7:
        View r11 = r5.itemView;
        r11.setClipBounds(null);
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        r12.height = -2;
        r11.setLayoutParams(r12);
        dispatchRemoveFinished(r5);
        if (isRunning() == true) goto L11;
        dispatchAnimationsFinished();
        return;
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.SimpleItemAnimator
    public final boolean animateMove(RecyclerView.ViewHolder r5, int r10, int r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        View r14 = r5.itemView;
        int r15 = MathKt.roundToInt(r14.getTranslationX() + r10);
        int r16 = MathKt.roundToInt(r14.getTranslationY() + r11);
        endAnimation(r5);
        int r17 = r15 - r12;
        int r18 = r16 - r13;
        if (r17 != 0) goto L7;
        if (r18 != 0) goto L7;
        dispatchMoveFinished(r5);
        return false;
    L7:
        r14.setTranslationX(r17);
        r14.setTranslationY(r18);
        this.f14590c.add(new c(r5, r17, r18));
        return true;
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.SimpleItemAnimator
    public final boolean animateRemove(RecyclerView.ViewHolder r5) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        endAnimation(r5);
        this.f14588a.add(r5);
        return true;
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final void endAnimation(RecyclerView.ViewHolder r10) {
        Intrinsics.checkNotNullParameter(r10, "item");
        super.endAnimation(r10);
        if (this.f14588a.remove(r10) == false) goto L5;
        dispatchRemoveFinished(r10);
    L5:
        Iterator r5 = this.f14590c.iterator();
    L7:
        if (r5.hasNext() == false) goto L11;
        if (Intrinsics.areEqual(((c) r5.next()).f14614a, r10) == false) goto L7;
        r10.itemView.setTranslationX(0.0f);
        r10.itemView.setTranslationY(0.0f);
        r5.remove();
        dispatchMoveFinished(r10);
        goto L7
    L11:
        jp.d r11 = (jp.d) this.e.remove(r10);
        if (r11 == null) goto L16;
        int r12 = jp.d.d;
        r11.a(false);
    L16:
        if (this.f14589b.contains(r10) == false) goto L18;
        a(r10, false);
    L18:
        ArrayList r13 = this.d;
        Iterator r14 = r13.iterator();
    L20:
        if (r14.hasNext() == false) goto L24;
        Object r15 = r14.next();
        if (Intrinsics.areEqual(((c) r15).f14614a, r10) == false) goto L20;
    L25:
        c r16 = (c) r15;
        if (r16 == null) goto L34;
        if (r13.remove(r16) == false) goto L34;
        RecyclerView.ViewHolder r17 = r16.f14614a;
        r17.itemView.setTranslationX(0.0f);
        r17.itemView.setTranslationY(0.0f);
        dispatchMoveFinished(r17);
        if (isRunning() == true) goto L34;
        dispatchAnimationsFinished();
    L34:
        if (isRunning() == true) goto L45;
        dispatchAnimationsFinished();
        return;
    L45:
        return;
    L24:
        r15 = null;
        goto L25
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final void endAnimations() {
        super.endAnimations();
        LinkedHashSet r5 = new LinkedHashSet();
        r5.addAll(this.f14588a);
        r5.addAll(this.f14589b);
        ArrayList r10 = this.f14590c;
        ArrayList r11 = new ArrayList(CollectionsKt.h(r10));
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.add(((c) r12.next()).f14614a);
        goto L4
    L6:
        r5.addAll(r11);
        ArrayList r13 = this.d;
        ArrayList r14 = new ArrayList(CollectionsKt.h(r13));
        Iterator r15 = r13.iterator();
    L8:
        if (r15.hasNext() == false) goto L10;
        r14.add(((c) r15.next()).f14614a);
        goto L8
    L10:
        r5.addAll(r14);
        Iterator r16 = r5.iterator();
    L12:
        if (r16.hasNext() == false) goto L15;
        endAnimation((RecyclerView.ViewHolder) r16.next());
        goto L12
    L15:
        if (isRunning() == true) goto L21;
        dispatchAnimationsFinished();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final long getRemoveDuration() {
        return 0;
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final boolean isRunning() {
        if (super.isRunning() == false) goto L5;
    L14:
        return true;
    L5:
        if (this.f14588a.isEmpty() == false) goto L14;
        if (this.f14589b.isEmpty() == false) goto L14;
        if (this.f14590c.isEmpty() == false) goto L14;
        if (this.d.isEmpty() == false) goto L14;
        return false;
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final void runPendingAnimations() {
        ArrayList r5 = this.f14588a;
        ArrayList r10 = new ArrayList(r5);
        ArrayList r11 = this.f14590c;
        ArrayList r12 = new ArrayList(r11);
        r5.clear();
        r11.clear();
        Iterator r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        final RecyclerView.ViewHolder r14 = (RecyclerView.ViewHolder) r13.next();
        final View r15 = r14.itemView;
        this.f14589b.add(r14);
        final int r16 = r15.getHeight();
        dispatchRemoveStarting(r14);
        this.e.put(r14, b(r16, new OSwipeDeleteAnimator$animateRemoveImpl$1(this, r14, r16, r15), new OSwipeDeleteAnimator$animateRemoveImpl$2(this, r14)));
        goto L4
    L6:
        Iterator r17 = r12.iterator();
    L8:
        if (r17.hasNext() == false) goto L10;
        final c r18 = (c) r17.next();
        RecyclerView.ViewHolder r19 = r18.f14614a;
        final View r20 = r19.itemView;
        this.d.add(r18);
        dispatchMoveStarting(r19);
        this.e.put(r19, b(1.0f, new OSwipeDeleteAnimator$animateMoveImpl$1(this, r18, r20), new OSwipeDeleteAnimator$animateMoveImpl$2(this, r18)));
        goto L8
    L10:
        super.runPendingAnimations();
    }
}

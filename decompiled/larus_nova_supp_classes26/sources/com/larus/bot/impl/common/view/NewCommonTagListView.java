package com.larus.bot.impl.common.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.h;
import v19.i5;
import zp9.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/bot/impl/common/view/NewCommonTagListView;", "Lcom/larus/bot/impl/common/view/AbsCommonTagListView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "scrollAnimator", "Landroid/animation/ObjectAnimator;", "select", "", "index", "", "scrollable", "", "bindData", "list", "", "Lcom/larus/platform/api/creation/TabTag;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NewCommonTagListView extends AbsCommonTagListView {
    public ObjectAnimator f;

    public static final class a implements View.OnLayoutChangeListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ NewCommonTagListView b;
        public final /* synthetic */ boolean c;

        public a(View r1, NewCommonTagListView r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            r1.removeOnLayoutChangeListener(this);
            if (this.a.getWidth() > 0) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(this.a.getParent(), this.b.getContainer()) == false) goto L15;
            int r10 = ((this.a.getLeft() + (this.a.getWidth() / 2)) - (this.b.getWidth() / 2)) + i5.g();
            if (this.c == true) goto L9;
            this.b.scrollTo(r10, 0);
            return;
        L9:
            ObjectAnimator r11 = this.b.f;
            if (r11 == null) goto L12;
            r11.cancel();
        L12:
            NewCommonTagListView r12 = this.b;
            ObjectAnimator r13 = ObjectAnimator.ofInt(r12, "scrollX", new int[]{r12.getScrollX(), r10});
            r13.setDuration(200);
            r13.start();
            r12.f = r13;
            return;
        }
    }

    public NewCommonTagListView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.view.View, android.view.ViewGroup, com.larus.bot.impl.common.view.NewBotTagItemView] */
    public final void d(List<w> r11) {
        Intrinsics.checkNotNullParameter(r11, "list");
        getContainer().removeAllViews();
        ArrayList r1 = new ArrayList();
        Iterator<T> r0 = r11.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r2 = r0.next();
        if ((true ^ ((w) r2).a()) == false) goto L4;
        r1.add(r2);
        goto L4
    L8:
        Iterator r3 = r1.iterator();
        int r4 = 0;
        int r5 = 0;
    L10:
        if (r3.hasNext() == false) goto L39;
        Object r6 = r3.next();
        int r7 = r5 + 1;
        if (r5 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        w r8 = (w) r6;
        ?? r9 = new NewBotTagItemView(getContext(), null);
        String r10 = r8.b;
        if (r10 != null) goto L17;
        r10 = "";
    L17:
        r9.setText(r10);
        boolean r12 = h.a;
        if (h.a(null) == false) goto L20;
        String r13 = r8.d;
    L22:
        if (h.a(null) == false) goto L24;
        String r14 = r8.f;
    L25:
        if (r13 == null) goto L27;
        r9.setIcon(r13);
    L27:
        if (r14 == null) goto L29;
        r9.setTagColor(r14);
    L29:
        r9.setTag(Integer.valueOf(r5));
        r9.setOnClickListener(getClickListener());
        r9.setClickable(!r8.a());
        LinearLayout.LayoutParams r15 = new LinearLayout.LayoutParams(-2, -2);
        if (r5 != 0) goto L32;
        int r16 = i5.q();
    L33:
        r15.setMarginStart(r16);
        if (r5 != (r1.size() - 1)) goto L36;
        int r17 = i5.q();
    L37:
        r15.setMarginEnd(r17);
        getContainer().addView(r9, r15);
        r5 = r7;
        goto L10
    L36:
        r17 = i5.h();
        goto L37
    L32:
        r16 = i5.h();
        goto L33
    L24:
        r14 = r8.e;
        goto L25
    L20:
        r13 = r8.c;
        goto L22
    L39:
        if ((!r11.isEmpty()) == true) goto L42;
        r4 = 8;
    L42:
        setVisibility(r4);
        b(getCurrent(), true);
    }

    public NewCommonTagListView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(-1, -2);
        r4.bottomMargin = i5.z();
        r4.topMargin = i5.c();
        getContainer().setOrientation(0);
        addView(getContainer(), r4);
        setHorizontalScrollBarEnabled(false);
    }

    public final void b(int r8, boolean r9) {
        if (r8 >= 0) goto L4;
        return;
    L4:
        if (r8 >= getContainer().getChildCount()) goto L40;
        setInnerCurrent(r8);
        View r10 = ViewGroupKt.get(getContainer(), r8);
        LinearLayout r0 = getContainer();
        int r1 = r0.getChildCount();
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L16;
        View r4 = r0.getChildAt(r3);
        r4.setSelected(Intrinsics.areEqual(r4, r10));
        if ((r4 instanceof TextView) == false) goto L11;
        TextView r5 = (TextView) r4;
    L12:
        if (r5 == null) goto L14;
        r5.setTypeface(Typeface.DEFAULT, Intrinsics.areEqual(r4, r10) ? 1 : 0);
    L14:
        r3 = r3 + 1;
        goto L7
    L11:
        r5 = null;
        goto L12
    L16:
        if (isLaidOut() == true) goto L18;
    L30:
        addOnLayoutChangeListener(new a(r10, this, r9));
        return;
    L18:
        if (isLayoutRequested() == true) goto L30;
        if (r10.getWidth() > 0) goto L22;
        return;
    L22:
        if (Intrinsics.areEqual(r10.getParent(), getContainer()) == false) goto L37;
        int r2 = ((r10.getLeft() + (r10.getWidth() / 2)) - (getWidth() / 2)) + i5.g();
        if (r9 == true) goto L26;
        scrollTo(r2, 0);
        return;
    L26:
        ObjectAnimator r11 = this.f;
        if (r11 == null) goto L29;
        r11.cancel();
    L29:
        ObjectAnimator r12 = ObjectAnimator.ofInt(this, "scrollX", new int[]{getScrollX(), r2});
        r12.setDuration(200);
        r12.start();
        this.f = r12;
        return;
    L37:
        return;
    }
}

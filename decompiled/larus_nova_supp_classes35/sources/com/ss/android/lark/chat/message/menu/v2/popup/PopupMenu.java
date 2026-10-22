package com.ss.android.lark.chat.message.menu.v2.popup;

import android.R;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import androidx.core.view.OneShotPreDrawListener;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.message.menu.v2.PanelType;
import com.ss.android.lark.chat.message.menu.v2.o0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class PopupMenu implements com.ss.android.lark.chat.message.menu.v2.popup.a {
    public final Activity a;
    public final Point b;
    public final d c;
    public final o0 d;
    public final b e;
    public final Lazy f;
    public PopupMenuMainContent g;
    public PopupMenuSubContent h;
    public PopupMenuPartialContent i;
    public final Lazy j;

    public static final class a {
        public final Activity a;
        public final yya.a b;
        public final com.ss.android.lark.chat.message.menu.d c;
        public o0 d;
        public Point e;
        public b f;
        public boolean g;
        public com.ss.android.lark.biz.im.api.message.params.m h;
        public Integer i;
        public boolean j;

        public final Activity getActivity() {
            return this.a;
        }

        public a(Activity r2, yya.a r3, com.ss.android.lark.chat.message.menu.d r4) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            Intrinsics.checkNotNullParameter(r3, "actionContext");
            Intrinsics.checkNotNullParameter(r4, "actions");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public interface b {
        void a(boolean r1, MessageActionType r2, boolean r3);

        void onShow();
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.j0
    public final void c(zya.b r2, List<zya.b> r3) {
        Intrinsics.checkNotNullParameter(r2, "parentAction");
        Intrinsics.checkNotNullParameter(r3, "childActions");
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.popup.a
    public final void e() {
        PopupMenuSubContent r0 = this.h;
        if (r0 == null) goto L13;
        PopupMenuRootView r3 = f();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r0, "view");
        int r4 = r3.getChildCount();
        int r5 = 0;
    L5:
        if (r5 >= r4) goto L10;
        View r6 = r3.getChildAt(r5);
        if (Intrinsics.areEqual(r6, r0.getParent()) == true) goto L11;
        r5 = r5 + 1;
    L11:
        if (r6 == null) goto L13;
        r6.animate().alpha(0.0f).setDuration(200).withEndAction(new o(r3, r6)).start();
        goto L13
    L10:
        r6 = null;
    L13:
        this.h = null;
        PopupMenuMainContent r1 = this.g;
        if (r1 == null) goto L22;
        ValueAnimator r7 = r1.h;
        if (r7 == null) goto L18;
        r7.cancel();
    L18:
        r1.e = true;
        r1.g = 1.0f;
        r1.invalidate();
        ValueAnimator r8 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r8.setDuration(150);
        r8.setInterpolator(new DecelerateInterpolator());
        r8.addUpdateListener(new i(r1));
        Intrinsics.checkNotNull(r8);
        r8.addListener(new j(r1));
        r8.start();
        r1.h = r8;
        r1.setOnClickListener(null);
        r1.setClickable(false);
        return;
    }

    public final PopupMenuRootView f() {
        return (PopupMenuRootView) this.f.getValue();
    }

    public final void g() {
        ViewParent r0 = f().getParent();
        if ((r0 instanceof ViewGroup) == false) goto L5;
        ViewGroup r1 = (ViewGroup) r0;
    L6:
        if (r1 == null) goto L9;
        r1.removeView(f());
    L9:
        if (this.c.e == false) goto L11;
        f().setBackgroundColorRes(R.color.transparent);
    L11:
        ((ViewGroup) this.j.getValue()).addView(f(), new ViewGroup.LayoutParams(-1, -1));
        int r4 = 0;
        if (this.c.e == false) goto L14;
        PopupMenuPartialContent r2 = new PopupMenuPartialContent(this.a, null, 6, 0);
        r2.setMenuContext(this.c);
        this.i = r2;
        PopupMenuRootView.b(f(), r2, this.b, 28);
    L15:
        PopupMenuRootView r3 = f();
        if (r3.isAttachedToWindow() == false) goto L23;
        r3.e.setAlpha(0.0f);
        r3.e.animate().alpha(1.0f).setDuration(200).start();
        int r5 = r3.getChildCount();
    L18:
        if (r4 >= r5) goto L24;
        View r7 = r3.getChildAt(r4);
        if (Intrinsics.areEqual(r7, r3.e) == true) goto L22;
        r7.setAlpha(0.0f);
        r7.setScaleX(0.98f);
        r7.setScaleY(0.98f);
        r7.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(200).start();
    L22:
        r4 = r4 + 1;
    L24:
        f().post(new c(this));
        return;
    L23:
        r3.addOnAttachStateChangeListener(new p(r3, r3));
        goto L24
    L14:
        PopupMenuMainContent r6 = new PopupMenuMainContent(this.a, null, 6, 0);
        r6.setMenuContext(this.c);
        r6.setOnReactionClickListener(this.d);
        this.g = r6;
        PopupMenuRootView.b(f(), r6, this.b, 28);
        goto L15
    L5:
        r1 = null;
        goto L6
    }

    public PopupMenu(final a r5) {
        this.a = r5.getActivity();
        this.b = r5.e;
        int r0 = d.f;
        Intrinsics.checkNotNullParameter(r5, "builder");
        d r1 = new d(r5.b, r5.c, r5.h);
        r1.e = r5.g;
        Intrinsics.checkNotNullParameter(this, "<set-?>");
        r1.d = this;
        this.c = r1;
        this.d = r5.d;
        this.e = r5.f;
        this.f = LazyKt.lazy(new PopupMenu$rootView$2(this, r5));
        this.j = LazyKt.lazy(new PopupMenu$decorView$2(this));
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.j0
    public final void a(PanelType r10) {
        Intrinsics.checkNotNullParameter(r10, "toType");
        if (r10 != PanelType.EMOJI) goto L26;
        PopupMenuEmojiPanelContent r0 = new PopupMenuEmojiPanelContent(this.a, null, 6, 0);
        r0.setMenuContext(this.c);
        r0.setOnReactionClickListener(this.d);
        PopupMenuRootView.b(f(), r0, null, 30);
        PopupMenuRootView r1 = f();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, "toPanelType");
        int r2 = r1.getChildCount();
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L34;
        View r5 = r1.getChildAt(r3);
        if (Intrinsics.areEqual(r5, r1.e) == true) goto L25;
        if ((r5 instanceof PopupMenuContentContainer) == false) goto L11;
        PopupMenuContentContainer r6 = (PopupMenuContentContainer) r5;
    L12:
        if (r6 == null) goto L25;
        PanelType r7 = r6.getPanelType();
        if (r7 != r10) goto L17;
        boolean r8 = true;
    L18:
        if (r8 == false) goto L23;
        if (r7 != PanelType.EMOJI) goto L25;
        OneShotPreDrawListener.add(r6, new n(r6, r6));
        goto L25
    L23:
        if (r7 != PanelType.ACTION) goto L25;
        r6.animate().alpha(0.0f).setDuration(200).withEndAction(new m(r1, r6)).start();
        goto L25
    L17:
        r8 = false;
        goto L18
    L11:
        r6 = null;
    L25:
        r3 = r3 + 1;
        goto L5
    L34:
        return;
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.popup.a
    public final void b(List r10, PopupMenuItem r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "actions");
        Intrinsics.checkNotNullParameter(r11, "parentItemView");
        if (this.h == null) goto L5;
        e();
    L5:
        View r7 = null;
        PopupMenuSubContent r0 = new PopupMenuSubContent(this.a, null, 6, 0);
        r0.setMenuContext(this.c);
        r0.setParentItemWidth(r11.getMeasuredWidth());
        r0.setActions(r10);
        int[] r1 = new int[2];
        r11.getLocationInWindow(r1);
        int r2 = r1[0];
        Rect r4 = new Rect(r2, r1[1], r11.getMeasuredWidth() + r2, r1[1] + r11.getMeasuredHeight());
        f().a(r0, null, r4, PopupMenuContentContainer.AnchorStyle.OVERLAY, r12);
        this.h = r0;
        PopupMenuMainContent r13 = this.g;
        if (r13 == null) goto L11;
        ValueAnimator r3 = r13.h;
        if (r3 == null) goto L10;
        r3.cancel();
    L10:
        r13.e = true;
        r13.g = 0.0f;
        r13.invalidate();
        ValueAnimator r14 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r14.setDuration(150);
        r14.setInterpolator(new DecelerateInterpolator());
        r14.addUpdateListener(new l(r13));
        r14.start();
        r13.h = r14;
        r13.setOnClickListener(new k(r13));
    L11:
        Object r15 = r0.getParent();
        if ((r15 instanceof View) == false) goto L14;
        r7 = (View) r15;
    L14:
        if (r7 == null) goto L17;
        r7.setAlpha(0.0f);
        r7.animate().alpha(1.0f).setDuration(200).start();
        return;
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.j0
    public final void d(final boolean r6, final MessageActionType r7, final boolean r8) {
        PopupMenuRootView r0 = f();
        Function0<Unit> r1 = new PopupMenu$dismiss$1(this, r6, r7, r8);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "completion");
        r0.e.animate().alpha(0.0f).setDuration(200).withEndAction(new PopupMenuRootView.a(r1)).start();
        int r9 = r0.getChildCount();
        int r10 = 0;
    L3:
        if (r10 >= r9) goto L8;
        View r2 = r0.getChildAt(r10);
        if (Intrinsics.areEqual(r2, r0.e) == true) goto L7;
        r2.animate().alpha(0.0f).setDuration(200).start();
    L7:
        r10 = r10 + 1;
        goto L3
    }
}

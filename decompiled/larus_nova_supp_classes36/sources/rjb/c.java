package rjb;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.larksuite.framework.ui.BasePopupWindow;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.ss.android.lark.guide.ui.common.popup.view.MaskView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.StatusBarUtil;
import com.ss.android.lark.utils.ViewUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class c implements g {
    public final rjb.a a;
    public int b;
    public int c;
    public int d;
    public int e;
    public sjb.a f;
    public LinearLayout g;
    public Size h;
    public MaskView i;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            Log.d("GuidePopup", "MaskView click");
        }
    }

    /* JADX INFO: renamed from: rjb.c$c, reason: collision with other inner class name */
    public static final class C0321c implements PopupWindow.OnDismissListener {
        public final /* synthetic */ c a;

        public C0321c(c r1) {
            this.a = r1;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            c r0 = this.a;
            MaskView r1 = r0.i;
            if (r1 == null) goto L7;
            ViewParent r2 = r1.getParent();
            if (r2 == null) goto L7;
            AlphaAnimation r3 = new AlphaAnimation(1.0f, 0.0f);
            r3.setDuration(200);
            r3.setInterpolator(new DecelerateInterpolator());
            r3.setAnimationListener(new d(r2, r0));
            r1.startAnimation(r3);
        L7:
            PopupWindow.OnDismissListener r4 = this.a.a.m;
            if (r4 == null) goto L11;
            r4.onDismiss();
            return;
        }
    }

    static {
    }

    @Override // rjb.g
    public void close() {
        sjb.a r0 = this.f;
        if (r0 == null) goto L6;
        PopupWindowLancet.handleDismissBeforeOrigin(r0);
        r0.dismiss();
        return;
    }

    @Override // rjb.g
    public boolean isShowing() {
        BasePopupWindow r0 = this.f;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isShowing();
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [android.widget.PopupWindow, com.larksuite.framework.ui.BasePopupWindow, java.lang.Object, sjb.a] */
    @Override // rjb.g
    public boolean show() {
        View r2 = this.a.b;
        if (r2 != null) goto L7;
        Log.i("GuidePopup", "params.anchorView is null");
        return false;
    L7:
        if (r2.getWindowToken() != null) goto L10;
        Log.i("GuidePopup", "anchorView.windowToken is null, anchorView.isAttachedToWindow=" + r2.isAttachedToWindow());
        return false;
    L10:
        rjb.b r3 = this.a.a;
        if (r3 != null) goto L14;
        Log.i("GuidePopup", "params.component is null");
        return false;
    L14:
        int r4 = h.b;
        Intrinsics.checkNotNullParameter(r3, "component");
        h r5 = new h(r3);
        Context r6 = r2.getContext();
        if ((r6 instanceof Activity) == false) goto L19;
        Activity r7 = (Activity) r6;
    L17:
        Activity r11 = r7;
        Intrinsics.checkNotNull(r6);
        e(r6);
        this.g = d(r6, r5);
        Rect r12 = b(r2);
        LinearLayout r8 = this.g;
        Intrinsics.checkNotNull(r8);
        Point r9 = c(r5.a(r8, this.h, r12), r5);
        int r10 = this.h.getWidth();     // Catch: Exception -> L58
        int r13 = this.h.getHeight();     // Catch: Exception -> L58
        if (r10 <= 0) goto L55;
        if (r13 <= 0) goto L55;
        ?? r0 = new sjb.a(this.g, r10, r13);     // Catch: Exception -> L58
        Boolean r14 = this.a.l;     // Catch: Exception -> L58
        if (r14 == null) goto L33;
        boolean r15 = r14.booleanValue();     // Catch: Exception -> L58
    L34:
        r0.setFocusable(r15);     // Catch: Exception -> L58
        Boolean r16 = this.a.c;     // Catch: Exception -> L58
        if (r16 == null) goto L37;
        boolean r17 = r16.booleanValue();     // Catch: Exception -> L58
    L38:
        r0.setOutsideTouchable(r17);     // Catch: Exception -> L58
        this.a.getClass();     // Catch: Exception -> L58
        r0.setBackgroundDrawable(new ColorDrawable(0));     // Catch: Exception -> L58
        r0.setAnimationStyle(2131952395);     // Catch: Exception -> L58
        r0.setOnDismissListener(new C0321c(this));     // Catch: Exception -> L58
        int r18 = r9.x;     // Catch: Exception -> L58
        int r19 = r9.y;     // Catch: Exception -> L58
        if (PopupWindowLancet.hasSubWindowToken(r2) == false) goto L42;
    L48:
        this.f = r0;     // Catch: Exception -> L58
        if (r0.isShowing() != true) goto L51;
        boolean r1 = true;
    L52:
        if (r1 == false) goto L63;
        a(r11, r2, r12);     // Catch: Exception -> L58
        return true;
    L63:
        return false;
    L51:
        r1 = false;
        goto L52
    L42:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r0) == false) goto L44;
        r0.showAtLocation(r2, 8388659, r18, r19);     // Catch: Exception -> L58
        goto L48
    L44:
        OverlaySource r20 = PopupWindowLancet.resolveSource(r2);     // Catch: Exception -> L58
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r0, r2, r20, 8388659, r18, r19) == true) goto L48;
        r0.showAtLocation(r2, 8388659, r18, r19);     // Catch: Exception -> L58
        PopupWindowLancet.trackAfterShow(r0, r20, r2);     // Catch: Exception -> L58
        goto L48
    L37:
        r17 = true;
        goto L38
    L33:
        r15 = true;
    L55:
        Log.w("GuidePopup", "show error, width=" + r10 + ", height=" + r13);     // Catch: Exception -> L58
        return false;
    L58:
        e = move-exception;
        Log.e("GuidePopup", "show error", e);
        return false;
    L19:
        if (this.a.getActivity() == null) goto L21;
        r7 = this.a.getActivity();
        goto L17
    L21:
        r7 = ViewUtils.getActivityByContext(r6);
        if (r7 != null) goto L17;
        Log.i("GuidePopup", "not found activity");
        return false;
    }

    public c(rjb.a r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        this.a = r2;
        this.h = new Size(0, 0);
    }

    public static Rect b(View r5) {
        Intrinsics.checkNotNullParameter(r5, "anchorView");
        int r0 = r5.getMeasuredWidth();
        int r1 = r5.getMeasuredHeight();
        int[] r2 = new int[2];
        r5.getLocationInWindow(r2);
        Rect r6 = new Rect();
        int r3 = r2[0];
        r6.left = r3;
        int r4 = r2[1];
        r6.top = r4;
        r6.right = r3 + r0;
        r6.bottom = r4 + r1;
        return r6;
    }

    public final void e(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        int r0 = DeviceUtils.getScreenWidth(r4);
        int r1 = DeviceUtils.getScreenHeight(r4);
        int r2 = UIUtils.dp2px(r4, 12.0f);
        this.b = r2;
        this.c = r0 - r2;
        this.d = StatusBarUtil.getStatusBarHeight(r4) + r2;
        this.e = r1 - r2;
    }

    public final Point c(Point r9, h r10) {
        Intrinsics.checkNotNullParameter(r9, "targetPoint");
        Intrinsics.checkNotNullParameter(r10, "popupCell");
        Rect r0 = r10.d();
        int r2 = 0;
        if (r0.left == 0) goto L5;
    L33:
        Point r1 = new Point();
        r1.x = r9.x;
        r1.y = r9.y;
        int r11 = r10.e();
        if ((r11 & 48) != 48) goto L36;
    L37:
        int r5 = r1.x;
        int r6 = r0.left + r5;
        int r7 = (r5 + this.h.getWidth()) - r0.right;
        int r8 = this.b;
        if (r6 >= r8) goto L40;
        r2 = r6 - r8;
        r1.x = r8 - r0.left;
    L44:
        if ((r11 & 3) != 3) goto L46;
    L47:
        int r12 = r1.y;
        int r3 = r0.top + r12;
        int r13 = (r12 + this.h.getHeight()) - r0.bottom;
        int r4 = this.d;
        if (r3 >= r4) goto L50;
        r2 = r3 - r4;
        r1.y = r4 - r0.top;
    L53:
        LinearLayout r14 = this.g;
        Intrinsics.checkNotNull(r14);
        r10.f(r14, this.h, r2);
        return r1;
    L50:
        int r15 = this.e;
        if (r13 <= r15) goto L53;
        r2 = r13 - r15;
        r1.y = (r15 - this.h.getHeight()) + r0.bottom;
        goto L53
    L46:
        if ((r11 & 5) != 5) goto L53;
    L40:
        int r16 = this.c;
        if (r7 <= r16) goto L44;
        r2 = r7 - r16;
        r1.x = (r16 - this.h.getWidth()) + r0.right;
        goto L44
    L36:
        if ((r11 & 80) != 80) goto L44;
    L5:
        if (r0.top != 0) goto L33;
        if (r0.right != 0) goto L33;
        if (r0.bottom != 0) goto L33;
        Point r17 = new Point();
        r17.x = r9.x;
        r17.y = r9.y;
        int r18 = r10.e();
        if ((r18 & 48) != 48) goto L14;
    L15:
        int r19 = r17.x;
        int r20 = this.b;
        if (r19 >= r20) goto L19;
        r2 = r19 - r20;
        r17.x = r20;
    L22:
        if ((r18 & 3) != 3) goto L24;
    L25:
        int r21 = r17.y;
        int r22 = this.d;
        if (r21 >= r22) goto L29;
        r2 = r21 - r22;
        r17.y = r22;
    L31:
        LinearLayout r23 = this.g;
        Intrinsics.checkNotNull(r23);
        r10.f(r23, this.h, r2);
        return r17;
    L29:
        if ((r21 + this.h.getHeight()) <= this.e) goto L31;
        int r24 = r17.y + this.h.getHeight();
        int r25 = this.e;
        r2 = r24 - r25;
        r17.y = r25 - this.h.getHeight();
        goto L31
    L24:
        if ((r18 & 5) != 5) goto L31;
    L19:
        if ((r19 + this.h.getWidth()) <= this.c) goto L22;
        int r26 = r17.x + this.h.getWidth();
        int r27 = this.c;
        int r28 = r26 - r27;
        r17.x = r27 - this.h.getWidth();
        r2 = r28;
        goto L22
    L14:
        if ((r18 & 80) != 80) goto L22;
        goto L15
    }

    public final LinearLayout d(Context r3, h r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "component");
        LinearLayout r0 = new LinearLayout(r3);
        r4.g(r3, r0, this);
        this.h = new Size(UIUtils.getWidth(r0), UIUtils.getHeight(r0));
        r0.setFocusable(true);
        r0.setFocusableInTouchMode(true);
        return r0;
    }

    public final void a(Activity r3, View r4, Rect r5) {
        Boolean r0 = this.a.d;
        Boolean r1 = Boolean.TRUE;
        if (Intrinsics.areEqual(r0, r1) == false) goto L14;
        Integer r2 = this.a.f;
        if (r2 != null) goto L8;
    L9:
        Integer r6 = this.a.g;
        if (r6 == null) goto L14;
        if (r6.intValue() == 0) goto L14;
        boolean r7 = true;
    L15:
        if (r7 == false) goto L44;
        this.i = new MaskView(r4.getContext());
        Integer r8 = this.a.g;
        if (r8 == null) goto L19;
        int r9 = r8.intValue();
        MaskView r10 = this.i;
        Intrinsics.checkNotNull(r10);
        r10.setFullingColor(r9);
    L19:
        Integer r11 = this.a.f;
        if (r11 == null) goto L22;
        int r12 = r11.intValue();
        MaskView r13 = this.i;
        Intrinsics.checkNotNull(r13);
        r13.setFullingAlpha(r12);
    L22:
        Boolean r14 = this.a.h;
        if (r14 == null) goto L25;
        boolean r15 = r14.booleanValue();
        MaskView r16 = this.i;
        Intrinsics.checkNotNull(r16);
        r16.setTargetHighlight(r15);
    L25:
        f r17 = this.a.k;
        if (r17 == null) goto L28;
        Rect r18 = r17.a(r5);
        MaskView r19 = this.i;
        Intrinsics.checkNotNull(r19);
        r19.setTargetRect(r18);
    L28:
        Integer r20 = this.a.i;
        if (r20 == null) goto L31;
        int r21 = r20.intValue();
        MaskView r22 = this.i;
        Intrinsics.checkNotNull(r22);
        r22.setHighlightTargetCorner(r21);
    L31:
        Integer r23 = this.a.j;
        if (r23 == null) goto L35;
        int r24 = r23.intValue();
        MaskView r25 = this.i;
        Intrinsics.checkNotNull(r25);
        r25.setHighTargetGraphStyle(r24);
    L35:
        if (Intrinsics.areEqual(this.a.c, r1) == true) goto L37;
        MaskView r26 = this.i;
        Intrinsics.checkNotNull(r26);
        r26.setOnClickListener(b.a);
    L37:
        View r27 = r3.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L42;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r28 = ThreadMethodProxy.currentThread();
        if (r28 == com.larus.home.impl.utils.c.a) goto L42;
        com.larus.home.impl.utils.c.a(r28, "getDecorView");
    L42:
        Intrinsics.checkNotNull(r27, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r27).addView(this.i);
        MaskView r29 = this.i;
        Intrinsics.checkNotNull(r29);
        AlphaAnimation r30 = new AlphaAnimation(0.0f, 1.0f);
        r30.setDuration(200);
        r30.setInterpolator(new DecelerateInterpolator());
        r29.startAnimation(r30);
        return;
    L44:
        return;
    L8:
        if (r2.intValue() != 0) goto L9;
    L14:
        r7 = false;
        goto L15
    }
}

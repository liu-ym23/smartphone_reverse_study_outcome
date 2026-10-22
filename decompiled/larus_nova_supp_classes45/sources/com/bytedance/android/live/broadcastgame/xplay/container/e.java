package com.bytedance.android.live.broadcastgame.xplay.container;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayScene;
import com.bytedance.android.live.broadcastgame.api.xplay.k;
import com.bytedance.android.live.broadcastgame.api.xplay.p;
import com.bytedance.android.live.broadcastgame.xplay.XplayInternalContext;
import com.bytedance.android.live.broadcastgame.xplay.XplayLog;
import com.bytedance.android.live.broadcastgame.xplay.g;
import com.bytedance.android.live.broadcastgame.xplay.g0;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.config.ot;
import io.reactivex.functions.Consumer;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e extends k {
    public final FrameLayout b;
    public final FrameLayout c;
    public final View d;
    public final TextView e;
    public boolean f;
    public boolean g;
    public final g h;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ e a;

        public a(e r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            Long r8 = (Long) r7;
            if (r8.longValue() > 0) goto L10;
            View r9 = this.a.d;
            if (r9 == null) goto L7;
            r9.setVisibility(8);
        L7:
            TextView r11 = this.a.e;
            if (r11 == null) goto L20;
            r11.setVisibility(8);
            return;
        L20:
            return;
        L10:
            View r0 = this.a.d;
            if (r0 == null) goto L13;
            r0.setVisibility(0);
        L13:
            TextView r1 = this.a.e;
            if (r1 == null) goto L16;
            r1.setVisibility(0);
        L16:
            TextView r2 = this.a.e;
            if (r2 == null) goto L22;
            StringCompanionObject r3 = StringCompanionObject.INSTANCE;
            r2.setText(String.format("%sms", Arrays.copyOf(new Object[]{String.valueOf(r8.longValue())}, 1)));
            return;
        }
    }

    public static final class b {
    }

    static {
    }

    public final ViewGroup getAnchorPreviewContainer() {
        return this.c;
    }

    public final boolean getBlockTouchEvents() {
        return this.f;
    }

    public final ViewGroup getXplayContainer() {
        return this.b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "ev");
        if (this.f == false) goto L9;
        if (r5.getAction() != 0) goto L9;
        int r0 = XplayLog.a;
        XplayLog.a("InteractPlayView", "blocked touch event " + r5);
        return false;
    L9:
        if (this.g == false) goto L25;
        int r1 = r5.getAction();
        if (r1 == 0) goto L21;
        if (r1 != 1) goto L14;
    L18:
        ViewParent r2 = getParent();
        if (r2 == null) goto L25;
        r2.requestDisallowInterceptTouchEvent(false);
        goto L25
    L14:
        if (r1 == 2) goto L21;
        if (r1 == 3) goto L18;
    L21:
        ViewParent r3 = getParent();
        if (r3 == null) goto L25;
        r3.requestDisallowInterceptTouchEvent(true);
    L25:
        return super.dispatchTouchEvent(r5);
    }

    public final void setBlockTouchEvents(boolean r1) {
        this.f = r1;
    }

    public final void setParentDisallowInterceptTouchEvent(boolean r1) {
        this.g = r1;
    }

    public e(Context r4, g r5, g0 r6, XplayInternalContext r7, p r8) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "xplayToolbarService");
        Intrinsics.checkNotNullParameter(r6, "xplayLogService");
        Intrinsics.checkNotNullParameter(r7, "xplayInternalContext");
        Intrinsics.checkNotNullParameter(r8, "newEnv");
        super(r4);
        this.h = r5;
        FrameLayout.inflate(r4, 2131566211, this);
        setBackgroundColor(-16777216);
        FrameLayout r9 = (FrameLayout) findViewById(2131362597);
        this.c = r9;
        this.b = (FrameLayout) findViewById(2131393376);
        View r11 = findViewById(2131374709);
        this.d = r11;
        TextView r0 = (TextView) findViewById(2131391373);
        this.e = r0;
        if (((XplayScene) r7.getCurrentScene().getValue()) != XplayScene.RevenueLink) goto L6;
        if (r9 == null) goto L9;
        UtilityKotlinExtentionsKt.t(r9);
    L9:
        if (r8.d == true) goto L14;
        ImageView r12 = (ImageView) findViewById(2131376104);
        TextView r1 = (TextView) findViewById(2131390313);
        IInteractService r2 = jc1.k.f(IInteractService.class);
        if (r2 == null) goto L14;
        r2.changeExitCleanScreenStyle(r12, r1);
    L14:
        if (r8.l == false) goto L48;
        if (((Boolean) ot.a.getValue()).booleanValue() == false) goto L48;
        r7.getSeiDelay().a().subscribe(new a(this));
        IInteractService r13 = jc1.k.f(IInteractService.class);
        if (r13 != null) goto L20;
        return;
    L20:
        if (r13.isXplayFullScreenMode() == true) goto L22;
        return;
    L22:
        if (r8.d == false) goto L24;
    L26:
        int r14 = 0;
    L27:
        ViewGroup.LayoutParams r15 = null;
        if (r11 == null) goto L30;
        ViewGroup.LayoutParams r16 = r11.getLayoutParams();
    L32:
        if ((r16 instanceof FrameLayout.LayoutParams) == true) goto L34;
        r16 = null;
    L34:
        FrameLayout.LayoutParams r17 = (FrameLayout.LayoutParams) r16;
        if (r17 == null) goto L37;
        r17.topMargin = s1.f(45.0f) + r14;
    L37:
        if (r0 == null) goto L39;
        ViewGroup.LayoutParams r18 = r0.getLayoutParams();
    L41:
        if ((r18 instanceof FrameLayout.LayoutParams) == false) goto L44;
        r15 = r18;
    L44:
        FrameLayout.LayoutParams r19 = (FrameLayout.LayoutParams) r15;
        if (r19 == null) goto L55;
        r19.topMargin = s1.f(46.0f) + r14;
        return;
    L55:
        return;
    L39:
        r18 = null;
        goto L41
    L30:
        r16 = null;
        goto L32
    L24:
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L26;
        r14 = StatusBarUtil.getStatusBarHeight(r4);
    L48:
        if (r11 == null) goto L50;
        r11.setVisibility(8);
    L50:
        if (r0 == null) goto L57;
        r0.setVisibility(8);
        return;
    L57:
        return;
    L6:
        if (r9 == null) goto L9;
        UtilityKotlinExtentionsKt.w(r9);
        goto L9
    }
}

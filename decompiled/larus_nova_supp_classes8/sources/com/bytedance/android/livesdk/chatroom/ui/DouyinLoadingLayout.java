package com.bytedance.android.livesdk.chatroom.ui;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livesdk.chatroom.utils.LoadingViewInflateUtil;
import com.bytedance.android.livesdk.config.PerformanceTestSettings;
import com.bytedance.android.livesdk.config.gx0;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class DouyinLoadingLayout extends FrameLayout {
    public LiveDoubleColorBallAnimationView a;
    public TextView b;

    public final void b() {
        LiveDoubleColorBallAnimationView r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.b();
    }

    public final void c() {
        LiveDoubleColorBallAnimationView r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.c();
    }

    public DouyinLoadingLayout(Context r2) {
        super(r2);
        a(r2, null);
    }

    public void setLoadingText(String r3) {
        if (this.b != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r3) == false) goto L8;
        this.b.setVisibility(8);
        return;
    L8:
        this.b.setVisibility(0);
        this.b.setText(r3);
    }

    @Override // android.view.View
    public void setVisibility(int r2) {
        super.setVisibility(r2);
        LiveDoubleColorBallAnimationView r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setVisibility(r2);
    }

    public void setLoadingText(int r1) {
        setLoadingText(com.bytedance.android.live.core.utils.s1.B(r1));
    }

    public DouyinLoadingLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        a(r1, r2);
    }

    public final void a(Context r14, AttributeSet r15) {
        if (PerformanceTestSettings.TEST_DISABLE_DOUBLE_COLOR_BALL.getValue().booleanValue() == false) goto L5;
        return;
    L5:
        if (r14 != null) goto L7;
        return;
    L7:
        boolean r1 = false;
        if (r15 == null) goto L11;
        r1 = r14.obtainStyledAttributes(r15, new int[]{2130975012}).getBoolean(0, false);
        ALogger.i("LiveViewInflate", "DouyinLoadingLayout useNitaInflate=" + r1);
    L11:
        if (r1 == false) goto L30;
        Activity r5 = com.bytedance.android.live.core.utils.a.d();
        if (r5 == null) goto L30;
        Lazy r2 = LoadingViewInflateUtil.a;
        Intrinsics.checkNotNullParameter("TTLIVE_LAYOUT_DOUYIN_LOADING_VIEW", "nitaTag");
        Intrinsics.checkNotNullParameter(r5, "activity");
        if (gx0.a.getValue().getLoading() == false) goto L30;
        long r10 = System.currentTimeMillis();
        Lazy r3 = LoadingViewInflateUtil.b;
        if (((IMiddlewareHostBusiness) r3.getValue()) != null) goto L20;
    L28:
        ALogger.w("LoadingViewInflateUtil", "hostBusiness is null or nitaInflaterEnabled is closed or activity is not LivePlayActivity");
        View r4 = LayoutInflater.from(r5).inflate(2131566644, this, true);
    L29:
        ALogger.i("LoadingViewInflateUtil", "NitaInflate: enabled: " + ((Boolean) LoadingViewInflateUtil.a.getValue()).booleanValue() + ", duration: " + (System.currentTimeMillis() - r10) + "ms");
    L31:
        if (r4 != null) goto L33;
        r4 = LayoutInflater.from(r14).inflate(2131566644, this, true);
    L33:
        this.a = (LiveDoubleColorBallAnimationView) r4.findViewById(2131370123);
        this.b = (TextView) r4.findViewById(2131370122);
        return;
    L20:
        if (((Boolean) LoadingViewInflateUtil.a.getValue()).booleanValue() == false) goto L28;
        if (Intrinsics.areEqual(r5.getClass().getCanonicalName(), "com.ss.android.ugc.aweme.live.LivePlayActivity") == false) goto L24;
    L27:
        IMiddlewareHostBusiness r6 = (IMiddlewareHostBusiness) r3.getValue();
        Intrinsics.checkNotNull(r6);
        Boolean r8 = Boolean.TRUE;
        r4 = r6.tryGetPreLoadLiveLayouts(2131566644, "TTLIVE_LAYOUT_DOUYIN_LOADING_VIEW", r5, this, r8, r8, null);
        goto L29
    L24:
        if (Intrinsics.areEqual(r5.getClass().getCanonicalName(), "com.ss.android.ugc.aweme.live.LivePlayActivityV2") == true) goto L27;
        if (Intrinsics.areEqual(r5.getClass().getCanonicalName(), "com.ss.android.ugc.aweme.live.multitask.LivePlayShadowActivity") == false) goto L28;
    L30:
        r4 = null;
        goto L31
    }
}

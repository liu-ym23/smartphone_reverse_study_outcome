package com.bytedance.android.livesdk.floatview.inner;

import android.content.res.Configuration;
import android.view.View;
import android.view.WindowManager;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.floatview.IInnerFloatWindowManager;
import com.bytedance.android.livesdkapi.floatview.InnerFloatWindowHelper;
import com.bytedance.common.utility.UIUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j implements com.bytedance.android.livesdk.floatview.e {
    public final /* synthetic */ VideoWatchingInnerFloatWindowManager a;

    @Override // com.bytedance.android.livesdk.floatview.e
    public final void c(View r2) {
        Intrinsics.checkNotNullParameter(r2, "releasedChild");
    }

    @Override // com.bytedance.android.livesdk.floatview.e
    public final void d(View r2) {
        Intrinsics.checkNotNullParameter(r2, "changedView");
    }

    @Override // com.bytedance.android.livesdk.floatview.e
    public final void onClick() {
    }

    @Override // com.bytedance.android.livesdk.floatview.e
    public final /* synthetic */ void onMuteButtonClick(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.floatview.e
    public final /* synthetic */ void onReturnClick() {
    }

    @Override // com.bytedance.android.livesdk.floatview.e
    public final void onShow() {
    }

    @Override // com.bytedance.android.livesdk.floatview.e
    public final /* synthetic */ void onShow(int r1, int r2, int r3, int r4) {
    }

    @Override // com.bytedance.android.livesdk.floatview.e
    public final void b() {
        VideoWatchingInnerFloatWindowManager r0 = this.a;
        com.bytedance.android.livesdk.floatview.mob.b r1 = r0.i;
        if (r1 == null) goto L5;
        Room r2 = r0.b;
        int r3 = com.bytedance.android.livesdk.floatview.mob.b.o;
        r1.l(true, false, r2, null);
    L5:
        IInnerFloatWindowManager.DefaultImpls.dismissFloatWindow$default(this.a, 0, null, false, 7, null);
        f.a("live end");
        InnerFloatWindowHelper.INSTANCE.triggerWindowCallBack(this.a.m, InnerFloatWindowHelper.ActionType.CLOSE, false);
    }

    @Override // com.bytedance.android.livesdk.floatview.e
    public final void onClose() {
        VideoWatchingInnerFloatWindowManager r0 = this.a;
        com.bytedance.android.livesdk.floatview.mob.b r1 = r0.i;
        if (r1 == null) goto L5;
        Room r2 = r0.b;
        int r3 = com.bytedance.android.livesdk.floatview.mob.b.o;
        r1.l(false, false, r2, null);
    L5:
        IInnerFloatWindowManager.DefaultImpls.dismissFloatWindow$default(this.a, 0, null, false, 7, null);
        f.a("user close");
        InnerFloatWindowHelper.INSTANCE.triggerWindowCallBack(this.a.m, InnerFloatWindowHelper.ActionType.CLOSE, true);
    }

    public j(VideoWatchingInnerFloatWindowManager r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.floatview.e
    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        rx1.g r0 = this.a.c();
        if (r0 == null) goto L6;
        r0.d(r2);
        return;
    }

    @Override // com.bytedance.android.livesdk.floatview.e
    public final void a(int r10, int r11) {
        rx1.g r0 = this.a.c();
        if (r0 == null) goto L28;
        rx1.f r1 = r0.a;
        if (r1.f == true) goto L9;
        WindowManager.LayoutParams r2 = r1.b;
        r2.width = r10;
        r2.height = r11;
        r1.a.updateViewLayout(r1.c, r2);
    L9:
        if (r0.l == true) goto L11;
        int r12 = (Math.min(UIUtils.getScreenWidth(jc1.a.b()), UIUtils.getScreenHeight(jc1.a.b())) - r10) - ((int) UIUtils.dip2Px(jc1.a.b(), this.a.g));
        int r13 = (int) UIUtils.dip2Px(jc1.a.b(), this.a.h);
        r0.a.a(r12, r13);
    L26:
        r0.e();
        int r14 = f.a;
        Intrinsics.checkNotNullParameter("window become visible", "msg");
        ALogger.i("InnerFloatWindowTracker", "window become visible");
        return;
    L11:
        rx1.f r3 = r0.a;
        int r4 = r3.d;
        int r5 = r3.e;
        int r6 = UIUtils.getScreenWidth(jc1.a.b());
        int r7 = UIUtils.getScreenHeight(jc1.a.b());
        int r8 = (int) UIUtils.dip2Px(jc1.a.b(), this.a.g);
        boolean r9 = true;
        if (r4 >= r8) goto L14;
        r4 = r8;
        boolean r15 = true;
    L15:
        int r16 = (r6 - r10) - r8;
        if (r4 <= r16) goto L18;
        r4 = r16;
        r15 = true;
    L18:
        if (r5 >= 0) goto L20;
        r5 = 0;
        r15 = true;
    L20:
        int r17 = r7 - r11;
        if (r5 <= r17) goto L23;
        r5 = r17;
    L24:
        if (r9 == false) goto L26;
        r0.a.a(r4, r5);
        goto L26
    L23:
        r9 = r15;
        goto L24
    L14:
        r15 = false;
        goto L15
    }
}

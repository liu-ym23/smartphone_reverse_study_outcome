package com.bytedance.android.livesdk.floatview;

import android.content.res.Configuration;
import android.view.View;
import android.view.WindowManager;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s implements e {
    public final /* synthetic */ VideoFloatWindowManager a;

    @Override // com.bytedance.android.livesdk.floatview.e
    public final void c(View r2) {
        Intrinsics.checkNotNullParameter(r2, "releasedChild");
    }

    @Override // com.bytedance.android.livesdk.floatview.e
    public final void d(View r2) {
        Intrinsics.checkNotNullParameter(r2, "changedView");
    }

    @Override // com.bytedance.android.livesdk.floatview.e
    public final /* synthetic */ void onMuteButtonClick(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.floatview.e
    public final /* synthetic */ void onShow(int r1, int r2, int r3, int r4) {
    }

    @Override // com.bytedance.android.livesdk.floatview.e
    public final void b() {
        IFloatWindowManager.a.a(this.a, false, 3);
        VideoFloatWindowManager.g(this.a.d, VideoFloatWindowManager.ActionType.CLOSE, false);
    }

    @Override // com.bytedance.android.livesdk.floatview.e
    public final void onClick() {
        VideoFloatWindowManager.g(this.a.d, VideoFloatWindowManager.ActionType.CLICK, false);
    }

    @Override // com.bytedance.android.livesdk.floatview.e
    public final void onClose() {
        IFloatWindowManager.a.a(this.a, false, 2);
        VideoFloatWindowManager.g(this.a.d, VideoFloatWindowManager.ActionType.CLOSE, true);
    }

    @Override // com.bytedance.android.livesdk.floatview.e
    public final void onReturnClick() {
        int r0 = l.a;
        l.b(jc1.a.b(), jc1.a.b().getPackageName());
    }

    @Override // com.bytedance.android.livesdk.floatview.e
    public final void onShow() {
        VideoFloatWindowManager.g(this.a.d, VideoFloatWindowManager.ActionType.SHOW, false);
    }

    public s(VideoFloatWindowManager r1) {
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
    public final void a(int r6, int r7) {
        rx1.g r0 = this.a.c();
        if (r0 == null) goto L33;
        boolean r1 = false;
        if (r6 >= r7) goto L7;
        boolean r3 = true;
    L9:
        if (VrUtils.d(VideoFloatWindowManager.b(this.a)) == false) goto L21;
        DataCenter r4 = VideoFloatWindowManager.b(this.a);
        if (r4 != null) goto L13;
    L15:
        DataCenter r5 = VideoFloatWindowManager.b(this.a);
        if (r5 != null) goto L18;
    L19:
        if (r3 == false) goto L21;
    L20:
        r1 = true;
        goto L21
    L18:
        if (com.bytedance.android.live.core.utils.z.m(r5, true) == true) goto L21;
    L13:
        if (com.bytedance.android.live.core.utils.z.m(r4, true) != true) goto L15;
        if (r3 == false) goto L20;
    L21:
        if (r1 == false) goto L23;
        int r2 = r7;
    L24:
        if (r1 == true) goto L27;
        r6 = r7;
    L27:
        rx1.f r8 = r0.a;
        if (r8.f == true) goto L31;
        WindowManager.LayoutParams r9 = r8.b;
        r9.width = r2;
        r9.height = r6;
        r8.a.updateViewLayout(r8.c, r9);
    L31:
        int r10 = UIUtils.getScreenWidth(jc1.a.b());
        int r11 = UIUtils.getScreenHeight(jc1.a.b());
        int r12 = (Math.min(r10, r11) - r2) - ((int) UIUtils.dip2Px(jc1.a.b(), VideoFloatWindowManager.h));
        int r13 = (Math.max(r10, r11) - r6) - ((int) UIUtils.dip2Px(jc1.a.b(), VideoFloatWindowManager.i));
        r0.a.a(r12, r13);
        r0.e();
        return;
    L23:
        r2 = r6;
        goto L24
    L7:
        r3 = false;
        goto L9
    }
}

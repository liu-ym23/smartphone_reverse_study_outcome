package com.bytedance.android.livesdk.chatroom.vs_host.business;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s implements yr1.l, com.bytedance.android.scope.o {
    public s() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // yr1.l
    public final r d() {
        return new r();
    }

    @Override // yr1.l
    public final void c(IBaseUser r2, boolean r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.getAdversaryUserStatus() != 3) goto L9;
        if (r3 == true) goto L10;
        f2.c(((ss0.e) rs0.v.a.getValue()).userpreviewToast, 0);
        return;
    L10:
        return;
    }

    @Override // yr1.l
    public final boolean f(Integer r3, String r4) {
        int r0 = gn2.b.a;
        if (r3 != null) goto L5;
        if (r4 != null) goto L5;
        return false;
    L5:
        if (r3 != null) goto L8;
        return false;
    L8:
        if (r3.intValue() != 2131373113) goto L16;
        if (r4 == null) goto L11;
        boolean r5 = Intrinsics.areEqual("anchor_recommend", r4);
    L12:
        if (r5 == false) goto L17;
        return true;
    L17:
        return false;
    L11:
        r5 = false;
        goto L12
    L16:
        return false;
    }

    @Override // yr1.l
    public final void showManagePoiDialog(Context r7, boolean r8, long r9, DialogInterface.OnDismissListener r11) {
        IHostBusiness r0 = jc1.k.f(IHostBusiness.class);
        if (r0 == null) goto L6;
        r0.showManagePoiDialog(r7, true, r9, null);
        return;
    }

    @Override // yr1.l
    public final void showPoiInfoDialogForAudience(Context r2, String r3, String r4, String r5) {
        IHostBusiness r0 = jc1.k.f(IHostBusiness.class);
        if (r0 == null) goto L6;
        r0.showPoiInfoDialogForAudience(r2, r3, r4, r5);
        return;
    }

    @Override // yr1.l
    public final q a(Activity r8, String r9, String r10, IBaseUser r11, long r12, boolean r14) {
        return new q(r9, r10, r11, r12, r14);
    }
}

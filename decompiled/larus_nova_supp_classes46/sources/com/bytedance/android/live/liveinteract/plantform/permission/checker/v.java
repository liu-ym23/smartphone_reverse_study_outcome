package com.bytedance.android.live.liveinteract.plantform.permission.checker;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class v<T> implements Consumer {
    public final /* synthetic */ t a;
    public final /* synthetic */ long b;

    public v(t r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r8) {
        final ApiServerException r5 = (Throwable) r8;
        t r9 = this.a;
        r9.b = false;
        TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
        qh0.f.h r10 = r9.c;
        String r1 = r10.f;
        int r11 = r10.c;
        long r2 = this.b;
        r0.getClass();
        TalkRoomBusinessFullLinkMonitor.C0(r1, r11, r2, r5);
        ALogger.i("ttlive_link", "checkServerPermission failure");
        qh0.f.h r12 = this.a.c;
        int r3 = r12.c;
        String r13 = r12.f;
        long r4 = this.b;
        InteractLinkFullLinkMonitor.r0(r3, r13, System.currentTimeMillis() - r4, r5);
        qh0.f.h r6 = this.a.c;
        int r7 = r6.d;
        new qh0.h(r6.c, new ServerCameraChecker$checkServerPermission$2$1(this), new ServerCameraChecker$checkServerPermission$2$2(this, r5)).c(r5);
        if ((r5 instanceof ApiServerException) == true) goto L5;
    L6:
        qh0.d<rh0.a> r14 = this.a.a;
        if (r14 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L9:
        qh0.f.h r15 = this.a.c;
        r14.b(new BaseCheckException(r15.c, r15.b, BaseCheckException.CheckType.ServerPermission, "check server permission failed.", r5));
        return;
    L5:
        if (r5.getErrorCode() != 30010) goto L6;
    }
}

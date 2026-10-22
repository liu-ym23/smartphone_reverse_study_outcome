package com.bytedance.android.livesdk.gamecp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livesdk.gamecp.utils.PermissionUtils;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.ies.ezpermission.EzPermission;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.Arrays;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g implements yv.a {
    public g() {
    }

    public final void Z0(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        Intrinsics.checkNotNullParameter(r3, "p1");
    }

    public final boolean isGranted(Context r4, String... r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "permissions");
        String[] r6 = (String[]) Arrays.copyOf(r5, r5.length);
        int r2 = PermissionUtils.a;
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r6, "permissions");
        return EzPermission.isAllGranted(r4, (String[]) Arrays.copyOf(r6, r6.length));
    }

    public final boolean handleSchema(Context r2, String r3, Bundle r4) {
        return jc1.k.n(IHostAction.class).handleSchema(r2, r3, r4);
    }

    public void requestPermissions(Activity r2, yv.a.b r3, Cert r4, String... r5) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r4, "cert");
        Intrinsics.checkNotNullParameter(r5, "permissions");
        PermissionUtils.a(r2, r3, r4, (String[]) Arrays.copyOf(r5, r5.length));
    }

    public final void A2(String r8, String r9, Long r10, String r11, com.bytedance.android.gamecp.business.gamedetail.component.fansgroup.c.a r12) {
        long r0 = 0;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        if (r11 == null) goto L6;
        r0 = CastLongProtector.parseLong(r11);     // Catch: Throwable -> L8
    L6:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        jc1.k.n(IHostAction.class).addGroupMemberListForFans(r8, r9, r10, Long.valueOf(r0), 7, new f(r12));
        return;
    L8:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }
}

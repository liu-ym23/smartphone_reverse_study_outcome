package com.bytedance.android.live.liveinteract.plantform.permission.checker;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.cert.token.TokenCert;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k implements o60.e {
    public final /* synthetic */ i a;
    public final /* synthetic */ Cert b;

    public final void onPermissionDenied(String... r11) {
        Intrinsics.checkNotNullParameter(r11, "permissions");
        qh0.d<rh0.a> r0 = this.a.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        qh0.f.c r2 = this.a.b;
        r0.b(new BaseCheckException(r2.c, r2.b, BaseCheckException.CheckType.AndroidPermission, "android permission denied.", null, 16, null));
        if (ArraysKt.contains(r11, "android.permission.RECORD_AUDIO") != true) goto L8;
        boolean r1 = true;
    L10:
        if (ArraysKt.contains(r11, "android.permission.CAMERA") != true) goto L12;
        boolean r12 = true;
    L13:
        int r3 = this.a.b.c;
        if (r3 != 1) goto L23;
        if (r1 == false) goto L18;
        if (r12 == false) goto L18;
        f2.b(2131917553, 0);
        return;
    L18:
        if (r12 == false) goto L20;
        f2.b(2131917583, 0);
        return;
    L20:
        if (r1 == false) goto L29;
        f2.b(2131917556, 0);
        return;
    L29:
        return;
    L23:
        if (r3 != 2) goto L31;
        if (r1 == false) goto L32;
        f2.b(2131917555, 0);
        return;
    L32:
        return;
    L31:
        return;
    L12:
        r12 = false;
        goto L13
    L8:
        r1 = false;
        goto L10
    }

    public final void onPermissionGrant(String... r2) {
        Intrinsics.checkNotNullParameter(r2, "permissions");
        qh0.d<rh0.a> r3 = this.a.a;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r3.onResult(null);
    }

    public k(i r1, TokenCert r2) {
        this.a = r1;
        this.b = r2;
    }
}

package com.obric.aikernel.service.res;

import com.obric.aikernel.res.update.MetadataRequestException;
import com.obric.aikernel.res.update.MetadataRequestFailureKind;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class k {
    public static final MetadataRequestException a(com.obric.aikernel.model.cloud.common.c r10) {
        Intrinsics.checkNotNullParameter(r10, "result");
        if (r10.i() == false) goto L6;
        return null;
    L6:
        if (r10.f() == (-200)) goto L22;
        int r11 = r10.f();
        boolean r12 = false;
        if (400 <= r11) goto L11;
    L13:
        if (r12 == false) goto L16;
        return new MetadataRequestException(MetadataRequestFailureKind.HTTP_STATUS_FAILURE, "metadata request http failure status=" + r10.f() + " message=" + r10.e(), r10.c());
    L16:
        if (r10.c() == null) goto L21;
        Throwable r13 = r10.c();
        if (r13 != null) goto L25;
        return null;
    L25:
        return b(r13);
    L21:
        return new MetadataRequestException(MetadataRequestFailureKind.UNKNOWN_TRANSPORT, "metadata request unexpected status=" + r10.f() + " message=" + r10.e(), null, 4, null);
    L11:
        if (r11 >= 600) goto L13;
        r12 = true;
        goto L13
    L22:
        return new MetadataRequestException(MetadataRequestFailureKind.NO_NETWORK, "metadata request network unavailable status=" + r10.f() + " message=" + r10.e(), r10.c());
    }

    public static final MetadataRequestException b(Throwable r10) {
        Intrinsics.checkNotNullParameter(r10, "throwable");
        if ((r10 instanceof MetadataRequestException) == true) goto L5;
        String r11 = r10.getMessage();
        if (r11 != null) goto L10;
        r11 = "";
    L10:
        if (StringsKt.contains(r11, "tls not ready", true) == false) goto L13;
        return new MetadataRequestException(MetadataRequestFailureKind.TLS_BOOTSTRAP_PENDING, "metadata request tls bootstrap pending: " + r11, r10);
    L13:
        if (StringsKt.contains(r11, "not allowed at device standby", true) == false) goto L16;
        return new MetadataRequestException(MetadataRequestFailureKind.STANDBY_REJECTED, "metadata request blocked by standby gate: " + r11, r10);
    L16:
        return new MetadataRequestException(MetadataRequestFailureKind.UNKNOWN_TRANSPORT, "metadata request transport failure: " + r10.getClass().getSimpleName() + ": " + r11, r10);
    L5:
        return (MetadataRequestException) r10;
    }
}

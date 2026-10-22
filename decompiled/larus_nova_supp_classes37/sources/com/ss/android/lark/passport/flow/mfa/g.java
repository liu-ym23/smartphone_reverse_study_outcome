package com.ss.android.lark.passport.flow.mfa;

import com.ss.android.lark.passport.flow.core.network.PassportHttpBusinessException;
import com.ss.android.lark.passport.flow.core.network.PassportHttpDeviceIdException;
import com.ss.android.lark.passport.flow.core.network.PassportHttpStatusException;
import com.ss.android.lark.passport.flow.core.network.PassportHttpTransportException;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static FlowMfaError d() {
        return new FlowMfaError(FlowMfaErrorCategory.UNSUPPORTED_IDP_CHANNEL, "Only BIDP is supported by Flow MFA", null, null, null, null, 60, null);
    }

    public static FlowMfaError a(Throwable r10) {
        Intrinsics.checkNotNullParameter(r10, "throwable");
        if ((r10 instanceof FlowMfaException) == false) goto L6;
        return ((FlowMfaException) r10).getError();
    L6:
        if ((r10 instanceof CancellationException) == false) goto L9;
        return new FlowMfaError(FlowMfaErrorCategory.USER_CANCEL, "MFA flow was cancelled", null, null, null, null, 60, null);
    L9:
        if ((r10 instanceof PassportHttpStatusException) == false) goto L23;
        PassportHttpStatusException r4 = (PassportHttpStatusException) r10;
        if (r4.getStatusCode() != 401) goto L13;
        FlowMfaErrorCategory r11 = FlowMfaErrorCategory.AUTH_EXPIRED;
    L14:
        FlowMfaErrorCategory r2 = r11;
        String r12 = r4.getServerMessage();
        if (r12 != null) goto L17;
        r12 = "Passport server returned HTTP " + r4.getStatusCode();
    L17:
        String r3 = r12;
        Integer r13 = r4.getServerCode();
        if (r13 == null) goto L20;
        int r14 = r13.intValue();
    L21:
        FlowMfaError r0 = new FlowMfaError(r2, r3, r4, null, Integer.valueOf(r14), r4.getLogId(), 8, null);
    L51:
        return r0;
    L20:
        r14 = r4.getStatusCode();
        goto L21
    L13:
        r11 = FlowMfaErrorCategory.SERVER;
        goto L14
    L23:
        if ((r10 instanceof PassportHttpBusinessException) == false) goto L30;
        FlowMfaErrorCategory r5 = FlowMfaErrorCategory.SERVER;
        String r1 = r10.getMessage();
        if (r1 != null) goto L27;
        r1 = "Passport business response requires unsupported handling";
    L27:
        PassportHttpBusinessException r6 = (PassportHttpBusinessException) r10;
        int r15 = r6.getCode();
        r0 = new FlowMfaError(r5, r1, r6, r6.getNextStep(), Integer.valueOf(r15), r6.getLogId());
        goto L51
    L30:
        if ((r10 instanceof PassportHttpDeviceIdException) == false) goto L36;
        FlowMfaErrorCategory r7 = FlowMfaErrorCategory.NETWORK;
        String r8 = r10.getMessage();
        if (r8 != null) goto L34;
        r8 = "Passport device id is unavailable";
    L34:
        r0 = new FlowMfaError(r7, r8, r10, null, null, null, 56, null);
        goto L51
    L36:
        if ((r10 instanceof PassportHttpTransportException) == false) goto L39;
        PassportHttpTransportException r9 = (PassportHttpTransportException) r10;
        return new FlowMfaError(FlowMfaErrorCategory.NETWORK, "Passport network request failed", r9, null, r9.getRustCode(), r9.getLogId(), 8, null);
    L39:
        if ((r10 instanceof IOException) == false) goto L44;
        FlowMfaErrorCategory r16 = FlowMfaErrorCategory.NETWORK;
        String r17 = r10.getMessage();
        if (r17 != null) goto L43;
        r17 = "Passport network request failed";
    L43:
        r0 = new FlowMfaError(r16, r17, r10, null, null, null, 56, null);
        goto L51
    L44:
        String r18 = r10.getMessage();
        if (r18 != null) goto L48;
        r18 = "Flow MFA failed";
    L48:
        return b(r18, r10);
    }

    public static FlowMfaError c(String r10) {
        Intrinsics.checkNotNullParameter(r10, "message");
        return new FlowMfaError(FlowMfaErrorCategory.INVALID_ARGUMENT, r10, null, null, null, null, 60, null);
    }

    public static FlowMfaError e(String r10) {
        return new FlowMfaError(FlowMfaErrorCategory.UNSUPPORTED_STEP, "Unsupported MFA step", null, r10, null, null, 52, null);
    }

    public static FlowMfaError b(String r10, Throwable r11) {
        Intrinsics.checkNotNullParameter(r10, "message");
        return new FlowMfaError(FlowMfaErrorCategory.INTERNAL, r10, r11, null, null, null, 56, null);
    }
}

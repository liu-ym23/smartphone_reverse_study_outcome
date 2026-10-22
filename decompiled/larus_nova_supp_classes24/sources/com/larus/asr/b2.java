package com.larus.asr;

import com.larus.audio.audiov3.asr.AsrCallBackType;
import com.larus.home.impl.sdk.ChatServiceImpl;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.f0;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;
import n58.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b2 implements b {
    public final f0 a;

    public static final class a {
    }

    static {
    }

    public b2() {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L5;
        r0.P();
        ChatServiceImpl r1 = ChatServiceImpl.a;
    L6:
        this.a = r1;
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // n58.b
    public final void b(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r4, "convId");
        f0 r0 = this.a;
        if (r0 == null) goto L5;
        r0.c(r3, r4);
    L5:
        FLogger.a.b("ASR", "AsrStart", r3);
    }

    @Override // n58.b
    public final void a(String r11, AsrCallBackType r12, String r13, String r14, long r15, String r17, int r19, String r110, String r20, String r21) {
        Intrinsics.checkNotNullParameter(r17, "vid");
        if (r11 != null) goto L5;
        return;
    L5:
        AsrCallBackType r9 = AsrCallBackType.AS_SUCCESS;
        if (r12 != r9) goto L14;
        if (r13 != null) goto L9;
    L12:
        boolean r1 = true;
    L13:
        if (r1 == true) goto L14;
    L17:
        if (r12 != r9) goto L19;
    L28:
        if (r12 != r9) goto L30;
    L36:
        FLogger.a.c("ASR", r12.name(), r11);
        return;
    L30:
        if (r12 == AsrCallBackType.ASR_CANCEL) goto L36;
        AsrCallBackType r2 = AsrCallBackType.ASR_FAILED_TOKEN;
        if (r12 == r2) goto L36;
        if (r12 == r2) goto L36;
        if (r12 == AsrCallBackType.ASR_FAILED) goto L36;
        return;
    L19:
        if (r12 == AsrCallBackType.ASR_CANCEL) goto L28;
        if (r12 == AsrCallBackType.ASR_FAILED_TOKEN) goto L28;
        f0 r3 = this.a;
        if (r3 == null) goto L28;
        if (r14 != null) goto L26;
        String r4 = "";
    L27:
        r3.b(r11, r4, r15, r17);
        goto L28
    L26:
        r4 = r14;
        goto L27
    L9:
        if (r13.length() == 0) goto L12;
        r1 = false;
    L14:
        f0 r5 = this.a;
        if (r5 == null) goto L17;
        r5.setScene(r11);
        goto L17
    }
}

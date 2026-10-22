package com.larus.audio.asr;

import com.bytedance.flow_audio.api.business.asr.error.FlowAsrErrorType;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class k0 {
    public static final hw5.a a(h68.a.C0110a r5, FlowAsrErrorType r6) {
        String r0 = r5.b;
        String r1 = null;
        if (r0 != null) goto L5;
    L9:
        int r2 = r5.a;
        if (r2 == (-1004)) goto L17;
        switch(r2) {
            case -2004: goto L16;
            case -2003: goto L15;
            case -2002: goto L14;
            case -2001: goto L13;
            default: goto L12;
        };
    L12:
        r0 = "ASR audio data source failed, code=" + r5.a;
    L18:
        int r3 = r5.a;
        if (r3 == (-1004)) goto L26;
        switch(r3) {
            case -2004: goto L25;
            case -2003: goto L24;
            case -2002: goto L23;
            case -2001: goto L22;
            default: goto L27;
        };
    L22:
        r6 = FlowAsrErrorType.SOURCE_START_FAILED;
        goto L27
    L23:
        r6 = FlowAsrErrorType.SOURCE_STOP_FAILED;
        goto L27
    L24:
        r6 = FlowAsrErrorType.SOURCE_RELEASE_FAILED;
        goto L27
    L25:
        r6 = FlowAsrErrorType.SOURCE_START_FAILED;
    L27:
        Throwable r4 = r5.c;
        if (r4 == null) goto L36;
        String r7 = r4.toString();
        if (r7 == null) goto L36;
        if ((!StringsKt.isBlank(r7)) == false) goto L34;
        r1 = r7;
    L34:
        if (r1 == null) goto L36;
    L38:
        return new hw5.a(r6, r0, r3, r1);
    L36:
        r1 = "errorCode=" + r5.a + ",errorMessage=" + r0;
        goto L38
    L26:
        r6 = FlowAsrErrorType.CLIENT_ERROR;
        goto L27
    L13:
        r0 = "ASR audio recorder captured only silence";
        goto L18
    L14:
        r0 = "ASR audio recorder stop failed";
        goto L18
    L15:
        r0 = "ASR audio recorder release failed";
        goto L18
    L16:
        r0 = "ASR audio recorder start failed";
        goto L18
    L17:
        r0 = "ASR audio data source read failed";
        goto L18
    L5:
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 != null) goto L18;
        goto L9
    }
}

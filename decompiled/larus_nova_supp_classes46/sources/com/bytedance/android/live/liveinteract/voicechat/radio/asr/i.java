package com.bytedance.android.live.liveinteract.voicechat.radio.asr;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.speech.speechengine.SpeechEngine;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i implements SpeechEngine.SpeechListener {
    public final /* synthetic */ h a;

    public i(h r1) {
        this.a = r1;
    }

    public final void onSpeechMessage(int r5, byte[] r6, int r7) {
        h r8 = this.a;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r6, "data");
        Intrinsics.checkNotNullParameter(r6, "data");
        switch(r5) {
            case 1001: goto L16;
            case 1002: goto L13;
            case 1003: goto L39;
            default: goto L20;
        };
    L13:
        String r1 = new String(r6, Charsets.UTF_8);
        r8.a.set(1);
        r8.c(r8.e + " on engine stop. reqId=" + r1);
        T r2 = r8.d;
        if (r2 == 0) goto L20;
        r2.onStop(r1);
        goto L20
    L16:
        String r3 = new String(r6, Charsets.UTF_8);
        r8.a.set(3);
        r8.c(r8.e + " on engine start. req=" + r3);
        T r4 = r8.d;
        if (r4 == 0) goto L20;
        r4.onStart(r3);
        goto L20
    L39:
        e r9 = (e) GsonHelper.get().fromJson(new String(r6, Charsets.UTF_8), e.class);     // Catch: Exception -> L7
    L9:
        if (r9 == null) goto L20;
        r8.a.set(4);
        r8.d(r8.e + " on engine error. " + GsonProtectorUtils.toJson(GsonHelper.get(), r9));
        T r10 = r8.d;
        if (r10 == 0) goto L20;
        r10.c(r9);
    L7:
        e = move-exception;
        SafetyGuard.a("AnchorAsr get engine error failed", e, null);
        r9 = null;
    L20:
        if (r5 != 1201) goto L22;
        Pair r11 = h.f(r6);
        if (r11 == null) goto L47;
        f r12 = (f) r8.d;
        if (r12 == null) goto L48;
        r12.b((String) r11.getFirst(), (String) r11.getSecond());
        return;
    L48:
        return;
    L47:
        return;
    L22:
        if (r5 == 1204) goto L28;
        switch(r5) {
            case 1001: goto L27;
            case 1002: goto L26;
            case 1003: goto L25;
            default: goto L49;
        };
    L25:
        r8.c("on engine error:".concat(new String(r6, Charsets.UTF_8)));
        return;
    L26:
        r8.c("on engine stop");
        return;
    L27:
        r8.c("on engine start");
        return;
    L49:
        return;
    L28:
        Pair r13 = h.f(r6);
        if (r13 == null) goto L44;
        r8.a.set(4);
        f r14 = (f) r8.d;
        if (r14 == null) goto L45;
        r14.a((String) r13.getFirst(), (String) r13.getSecond());
        return;
    L45:
        return;
    }
}

package com.bytedance.android.live.liveinteract.voicechat.radio.asr;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m implements b.InterfaceC0109b {
    public final /* synthetic */ k a;

    public m(k r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.radio.asr.b.InterfaceC0109b
    public final void onPCMDataReceived(byte[] r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "pcmData");
        if (this.a.f == false) goto L5;
        return;
    L5:
        if (this.a.e == false) goto L48;
        h r0 = this.a.b;
        if (r0 == null) goto L49;
        boolean r2 = false;
        if (r0.f == true) goto L11;
    L13:
        boolean r1 = false;
    L14:
        if (r1 != true) goto L50;
        h r3 = this.a.b;
        if (r3 == null) goto L51;
        Integer r7 = Integer.valueOf(r6);
        if (r3.c == true) goto L20;
        return;
    L20:
        if (r3.f == true) goto L22;
    L24:
        if (r2 == false) goto L53;
        if (r7 == null) goto L27;
        int r8 = r7.intValue();
    L28:
        int r9 = r3.b.feedAudio(r5, r8);
        if (r9 == 0) goto L54;
        StringBuilder r10 = new StringBuilder("feed audio error. ret=");
        r10.append(r9);
        r10.append(" state=");
        int r11 = r3.a.get();
        if (r11 == 0) goto L44;
        if (r11 != 1) goto L34;
        String r12 = "idle";
    L45:
        r10.append(r12);
        r3.d(r10.toString());
        return;
    L34:
        if (r11 != 2) goto L36;
        r12 = "starting";
        goto L45
    L36:
        if (r11 != 3) goto L38;
        r12 = "running";
        goto L45
    L38:
        if (r11 == 4) goto L40;
        r12 = "unknown";
        goto L45
    L40:
        r12 = "stopping";
        goto L45
    L44:
        r12 = "invalid";
        goto L45
    L54:
        return;
    L27:
        r8 = r5.length;
        goto L28
    L53:
        return;
    L22:
        if (r3.b() == false) goto L24;
        r2 = true;
        goto L24
    L51:
        return;
    L50:
        return;
    L11:
        if (r0.b() == false) goto L13;
        r1 = true;
        goto L14
    L49:
        return;
    }
}

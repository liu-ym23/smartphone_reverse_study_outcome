package com.larus.dora.impl.serviceimpl;

import java.util.Arrays;
import kj4.a;
import kotlin.jvm.internal.Intrinsics;
import sk4.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class v implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ byte[] b;
    public final /* synthetic */ Integer c;

    public /* synthetic */ v(String r1, byte[] r2, Integer r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r0 = this.a;
        byte[] r1 = this.b;
        Integer r2 = this.c;
        String r5 = null;
        if (Intrinsics.areEqual(r0, "RESET") == false) goto L10;
        StringBuilder r4 = new StringBuilder("syncVUIEvent: ");
        r4.append(r0);
        r4.append(", extra=");
        if (r1 == null) goto L7;
        String r6 = Arrays.toString(r1);
    L8:
        r4.append(r6);
        r4.append(", scene=");
        r4.append(r2);
        g49.d.d("DoraTimerPlugin", r4.toString());
        goto L10
    L7:
        r6 = null;
    L10:
        switch(r0.hashCode()) {
            case -1982756138: goto L38;
            case -1949140315: goto L35;
            case -1722007898: goto L32;
            case -336206429: goto L29;
            case -274702257: goto L24;
            case 13044316: goto L19;
            case 77866287: goto L16;
            case 1097398238: goto L13;
            default: goto L45;
        };
    L13:
        if (r0.equals("SPEECH_END") == false) goto L45;
        g r3 = g.l;
    L40:
        if (r1 == null) goto L42;
        a.g().syncVUIEvent(r3, r1);
        return;
    L42:
        a.g().syncVUIEvent(r3);
        return;
    L16:
        if (r0.equals("RESET") == false) goto L45;
        r3 = g.i;
        goto L40
    L19:
        if (r0.equals("ASR_END") == false) goto L45;
        if (r1 == null) goto L22;
        r5 = Arrays.toString(r1);
    L22:
        r3 = g.a(r5);
        goto L40
    L24:
        if (r0.equals("TTS_END") == false) goto L45;
        if (r1 == null) goto L27;
        r5 = Arrays.toString(r1);
    L27:
        r3 = g.b(r5);
        goto L40
    L29:
        if (r0.equals("ASR_START") == false) goto L45;
        r3 = g.g;
        goto L40
    L32:
        if (r0.equals("DATA_END") == false) goto L45;
        r3 = g.f;
        goto L40
    L35:
        if (r0.equals("SPEECH_START") == false) goto L45;
        r3 = g.k;
        goto L40
    L38:
        if (r0.equals("TTS_START") == false) goto L45;
        r3 = g.e;
    L45:
        throw new IllegalAccessException("args invalid");
    }
}

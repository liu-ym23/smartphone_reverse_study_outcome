package com.bytedance.android.live.revenuelink.rtc;

import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o {
    public String a;
    public final String b;
    public Object c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public Pair<Integer, Integer> i;
    public boolean j;
    public boolean k;
    public Boolean l;
    public boolean m;
    public Integer n;

    public static final class a {
    }

    static {
    }

    public o() {
        throw null;
    }

    public final int a() {
        Integer r0 = this.n;
        if (r0 != null) goto L5;
        return 0;
    L5:
        if ((r0.intValue() & 1) == 1) goto L11;
        return 2;
    L11:
        return 1;
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("RtcUser{");
        r0.append(this.b);
        r0.append(",");
        boolean r2 = true;
        if (this.c == null) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L9;
        r0.append("NoFirstFrame,");
    L12:
        if ((!Intrinsics.areEqual(this.l, Boolean.TRUE)) == false) goto L15;
        r0.append("renderVideo=" + this.l + ',');
    L15:
        if (this.e == false) goto L18;
        r0.append("remoteVideoMute,");
    L18:
        if (this.f == false) goto L21;
        r0.append("remoteAudioMute,");
    L21:
        if (this.g == false) goto L29;
        r0.append("audioMuteBySelf,");
        if (this.a.length() > 0) goto L26;
        r2 = false;
    L26:
        if (r2 == false) goto L29;
        r0.append("audioMuteReason=" + this.a + ',');
    L29:
        if (this.h == false) goto L32;
        r0.append("videoMuteBySelf,");
    L32:
        if (this.m == false) goto L35;
        r0.append("mutePlayVolume,");
    L35:
        if (this.j == false) goto L37;
        r0.append("chorusMuteBySelf,");
    L37:
        r0.append("videoSize=");
        r0.append(this.i);
        r0.append("}");
        return r0.toString();
    L9:
        if (this.d == true) goto L12;
        r0.append("FrameNotRender,");
        goto L12
    L5:
        r1 = false;
        goto L6
    }

    public o(String r3, Object r4, boolean r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 4) == 0) goto L8;
        r5 = false;
    L8:
        Intrinsics.checkNotNullParameter(r3, "linkMicId");
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = null;
        this.j = false;
        this.k = false;
        this.l = null;
        this.m = false;
        this.n = null;
        this.a = "";
    }
}

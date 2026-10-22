package com.bytedance.android.livesdk.chatroom.vsplayer.model;

import com.bytedance.bmmt.base.DeviceInfoAndroid;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e implements Comparable<e> {
    public float a;
    public float b;
    public boolean c;
    public boolean d;
    public final String e;
    public long f;
    public final long g;
    public final long h;
    public long i;
    public final int j;
    public final k k;
    public final int l;
    public final int m;
    public final boolean n;
    public final boolean o;
    public final boolean p;
    public final boolean q;

    public static final class a {
    }

    static {
    }

    public e() {
        this(null, 0, 0, 0, 0, 0, null, 0, false, false, false, 16383);
    }

    @Override // java.lang.Comparable
    public final int compareTo(e r5) {
        e r6 = r5;
        Intrinsics.checkNotNullParameter(r6, "other");
        int r0 = this.l;
        int r1 = r6.l;
        if (r0 != r1) goto L6;
        return (int) (this.g - r6.g);
    L6:
        return r0 - r1;
    }

    public e(String r17, long r18, long r20, long r22, long r24, int r26, k r27, int r28, boolean r29, boolean r30, boolean r31, int r32) {
        if ((r32 & 1) == 0) goto L5;
        String r2 = "";
    L7:
        if ((r32 & 2) == 0) goto L9;
        long r3 = 1;
    L10:
        long r6 = 0;
        if ((r32 & 4) == 0) goto L13;
        long r8 = 0;
    L15:
        if ((r32 & 8) == 0) goto L17;
        long r10 = r8;
    L19:
        if ((r32 & 16) != 0) goto L23;
        r6 = r24;
    L23:
        if ((r32 & 32) == 0) goto L25;
        int r5 = ColorProtector.parseColor("#FFFFFF");
    L27:
        if ((r32 & 128) == 0) goto L29;
        k r12 = null;
    L31:
        if ((r32 & 512) == 0) goto L33;
        int r13 = 1;
    L35:
        if ((r32 & 1024) == 0) goto L37;
        boolean r14 = false;
    L39:
        if ((r32 & 4096) == 0) goto L41;
        boolean r15 = false;
    L43:
        if ((r32 & DeviceInfoAndroid.BUFFER_SIZE) == 0) goto L45;
        boolean r19 = false;
    L46:
        Intrinsics.checkNotNullParameter(r2, "tag");
        this.e = r2;
        this.f = r3;
        this.g = r8;
        this.h = r10;
        this.i = r6;
        this.j = r5;
        this.k = r12;
        this.l = 0;
        this.m = r13;
        this.n = r14;
        this.o = false;
        this.p = r15;
        this.q = r19;
        return;
    L45:
        r19 = r31;
        goto L46
    L41:
        r15 = r30;
        goto L43
    L37:
        r14 = r29;
        goto L39
    L33:
        r13 = r28;
        goto L35
    L29:
        r12 = r27;
        goto L31
    L25:
        r5 = r26;
        goto L27
    L17:
        r10 = r22;
        goto L19
    L13:
        r8 = r20;
        goto L15
    L9:
        r3 = r18;
        goto L10
    L5:
        r2 = r17;
        goto L7
    }
}

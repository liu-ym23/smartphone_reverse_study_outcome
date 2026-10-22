package com.larus.bmhome.music.save_video;

import com.larus.bmhome.share.panel.ShareType;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class q {
    public final File a;
    public int b;
    public int c;
    public final String d;
    public final int e;
    public final float f;
    public final int g;
    public final int h;
    public final long i;
    public final boolean j;
    public b k;

    public /* synthetic */ q(File r15, int r16, int r17, String r18, int r19, float r20, int r21, int r22, int r23) {
        if ((r23 & 2) == 0) goto L5;
        int r4 = 320;
    L7:
        if ((r23 & 4) == 0) goto L9;
        int r5 = 240;
    L11:
        if ((r23 & 8) == 0) goto L13;
        String r6 = "video/avc";
    L15:
        if ((r23 & 16) == 0) goto L17;
        int r7 = 1;
    L19:
        if ((r23 & 32) == 0) goto L21;
        float r8 = 10.0f;
    L23:
        if ((r23 & 64) == 0) goto L25;
        int r9 = 1500000;
    L27:
        if ((r23 & 128) == 0) goto L29;
        int r10 = 10;
    L31:
        if ((r23 & 256) == 0) goto L33;
        long r0 = 1000;
    L34:
        this(r15, r4, r5, r6, r7, r8, r9, r10, r0, false);
        return;
    L33:
        r0 = 0;
        goto L34
    L29:
        r10 = r22;
        goto L31
    L25:
        r9 = r21;
        goto L27
    L21:
        r8 = r20;
        goto L23
    L17:
        r7 = r19;
        goto L19
    L13:
        r6 = r18;
        goto L15
    L9:
        r5 = r17;
        goto L11
    L5:
        r4 = r16;
        goto L7
    }

    public q(File r2, int r3, int r4, String r5, int r6, float r7, int r8, int r9, long r10, boolean r12) {
        Intrinsics.checkNotNullParameter(r2, ShareType.FILE);
        Intrinsics.checkNotNullParameter(r5, "mimeType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r12;
    }
}

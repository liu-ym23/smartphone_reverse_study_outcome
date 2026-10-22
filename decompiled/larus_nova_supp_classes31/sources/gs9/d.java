package gs9;

import kotlin.jvm.internal.Intrinsics;
import zp9.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d {
    public final e a;
    public final a b;
    public final f c;
    public final boolean d;
    public final boolean e;
    public final b f;
    public final m g;
    public final String h;
    public final String i;

    public /* synthetic */ d(e r14, a r15, f r16, b r17, m r18, int r19) {
        String r2 = null;
        if ((r19 & 1) == 0) goto L5;
        e r4 = null;
    L7:
        if ((r19 & 2) == 0) goto L9;
        a r5 = null;
    L11:
        if ((r19 & 4) == 0) goto L13;
        f r6 = null;
    L15:
        if ((r19 & 8) == 0) goto L17;
        boolean r1 = false;
    L19:
        if ((r19 & 16) == 0) goto L21;
        boolean r8 = false;
    L23:
        if ((r19 & 32) == 0) goto L25;
        b r9 = null;
    L27:
        if ((r19 & 64) == 0) goto L29;
        m r10 = null;
    L31:
        if ((r19 & 128) == 0) goto L33;
        String r11 = "ugc_video";
    L35:
        if ((r19 & 256) == 0) goto L37;
        r2 = "immersive_preview";
    L37:
        this(r4, r5, r6, r1, r8, r9, r10, r11, r2);
        return;
    L33:
        r11 = null;
        goto L35
    L29:
        r10 = r18;
        goto L31
    L25:
        r9 = r17;
        goto L27
    L21:
        r8 = true;
        goto L23
    L17:
        r1 = true;
        goto L19
    L13:
        r6 = r16;
        goto L15
    L9:
        r5 = r15;
        goto L11
    L5:
        r4 = r14;
        goto L7
    }

    public d(e r2, a r3, f r4, boolean r5, boolean r6, b r7, m r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "detailVideoEngineTag");
        Intrinsics.checkNotNullParameter(r10, "detailVideoEngineSubTag");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }
}

package mw1;

import com.bytedance.android.livesdkapi.feed.model.LiveCoverConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b extends LiveCoverConfig {
    public Integer a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final Integer e;
    public final boolean f;
    public final boolean g;

    public b() {
        boolean r0 = false;
        this(r0, r0, r0, 127);
    }

    public final boolean getEnableCategoryLabel() {
        return this.d;
    }

    public final boolean getEnableContentLabel() {
        return this.c;
    }

    public final boolean getEnableOperationLabel() {
        return this.b;
    }

    public /* synthetic */ b(boolean r11, boolean r12, boolean r13, int r14) {
        if ((r14 & 1) == 0) goto L5;
        boolean r4 = true;
    L7:
        if ((r14 & 2) == 0) goto L9;
        boolean r5 = true;
    L11:
        if ((r14 & 8) == 0) goto L13;
        Integer r15 = 0;
    L14:
        Integer r7 = r15;
        if ((r14 & 32) == 0) goto L17;
        boolean r8 = false;
    L19:
        if ((r14 & 64) == 0) goto L21;
        boolean r9 = true;
    L22:
        this(r4, r5, false, r7, r8, r9);
        return;
    L21:
        r9 = r13;
        goto L22
    L17:
        r8 = r12;
        goto L19
    L13:
        r15 = null;
        goto L14
    L9:
        r5 = r11;
        goto L11
    L5:
        r4 = false;
        goto L7
    }

    public b(boolean r1, boolean r2, boolean r3, Integer r4, boolean r5, boolean r6) {
        super(r1, r2, r3);
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
    }
}

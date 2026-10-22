package com.bytedance.android.live.revlink.impl.multianchor.match;

import com.bytedance.android.live.revlink.impl.multianchor.utils.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class c {
    public final boolean a;
    public final int b;
    public final boolean c;
    public final boolean d;
    public final int e;

    public static final class a extends c {
        @Override // com.bytedance.android.live.revlink.impl.multianchor.match.c
        public final String a() {
            return "ActiveMatching";
        }

        public a(int r8, int r9) {
            super(true, r8, false, false, r9, 32);
        }
    }

    public static final class b extends c {
        @Override // com.bytedance.android.live.revlink.impl.multianchor.match.c
        public final String a() {
            return "ActiveSpeedUpMatching";
        }

        public b(int r8, int r9) {
            super(true, r8, true, false, r9, 32);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.multianchor.match.c$c, reason: collision with other inner class name */
    public static final class C0146c extends c {
        public C0146c() {
            super(false, 0, false, false, 0, 48);
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.match.c
        public final String a() {
            return "NotMatching";
        }
    }

    public static final class d extends c {
        @Override // com.bytedance.android.live.revlink.impl.multianchor.match.c
        public final String a() {
            return "PassiveMatching";
        }

        public d(int r8) {
            super(true, r8, false, true, 0, 48);
        }
    }

    public static final class e extends c {
        @Override // com.bytedance.android.live.revlink.impl.multianchor.match.c
        public final String a() {
            return "Waiting2v2Match";
        }

        public e(int r7) {
            super(false, 11, false, false, r7);
        }
    }

    public abstract String a();

    public final String toString() {
        if (this.a == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L11;
        return "TeamPk" + a();
    L11:
        return a();
    L5:
        if (x.d(this.b) == false) goto L7;
        r0 = true;
        goto L8
    }

    public c(boolean r1, int r2, boolean r3, boolean r4, int r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public /* synthetic */ c(boolean r9, int r10, boolean r12, boolean r13, int r14, int r15) {
        if ((r15 & 4) == 0) goto L5;
        boolean r5 = false;
    L7:
        if ((r15 & 8) == 0) goto L9;
        boolean r6 = false;
    L11:
        if ((r15 & 16) == 0) goto L13;
        int r7 = 0;
    L14:
        this(r9, r10, r5, r6, r7);
        return;
    L13:
        r7 = r14;
        goto L14
    L9:
        r6 = r13;
        goto L11
    L5:
        r5 = r12;
        goto L7
    }
}

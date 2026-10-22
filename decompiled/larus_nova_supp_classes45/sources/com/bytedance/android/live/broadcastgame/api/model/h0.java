package com.bytedance.android.live.broadcastgame.api.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class h0 {

    public static final class a extends c {
        public final String a;

        public a() {
            this(null);
        }

        public a(String r1) {
            this.a = r1;
        }
    }

    public static final class b extends h0 {
        public final int a;

        public b() {
            this(0);
        }

        public b(int r1) {
            this.a = r1;
        }
    }

    public static class c extends h0 {
        public c() {
        }
    }

    public static final class d extends c {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }
    }

    public static final class e extends c {
        public boolean a;
        public boolean b;
        public boolean c;

        public e() {
            boolean r0 = false;
            this(r0, r0, r0, 7);
        }

        public e(boolean r1, boolean r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public /* synthetic */ e(boolean r3, boolean r4, boolean r5, int r6) {
            if ((r6 & 1) == 0) goto L6;
            r3 = false;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r4 = false;
        L9:
            if ((r6 & 4) == 0) goto L11;
            r5 = false;
        L11:
            this(r3, r4, r5);
        }
    }

    public h0() {
    }
}

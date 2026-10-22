package h0;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f7884a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f7885b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f7886c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f7887d = null;

    public static class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f7888a = null;

        static {
            f7888a = new a();
        }

        @Override // h0.e.b
        public final int a(CharSequence r8, int r10) {
            int r11 = 0;
            int r12 = r10 + 0;
            int r13 = 0;
            r11 = 2;
        L3:
            if (r13 >= r12) goto L14;
            if (r11 != 2) goto L14;
            byte r14 = Character.getDirectionality(r8.charAt(r13));
            d r15 = e.f7884a;
            if (r14 == 0) goto L12;
            if (r14 == 1) goto L13;
            if (r14 == 2) goto L13;
            switch(r14) {
                case 14: goto L12;
                case 15: goto L12;
                case 16: goto L13;
                case 17: goto L13;
                default: goto L10;
            };
        L10:
            r11 = 2;
        L13:
            r13 = r13 + 1;
        L12:
            r11 = 1;
        L14:
            return r11;
        }
    }

    public interface b {
        int a(CharSequence r8, int r10);
    }

    public static abstract class c implements h0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f7889a;

        public c(a r8) {
            this.f7889a = r8;
        }

        public abstract boolean a();

        public final boolean b(CharSequence r8, int r10) {
            if (r8 == null) goto L17;
            if (r10 < 0) goto L17;
            if ((r8.length() - r10) < 0) goto L17;
            b r11 = this.f7889a;
            if (r11 == null) goto L9;
            int r12 = r11.a(r8, r10);
            if (r12 == 0) goto L18;
            if (r12 != 1) goto L19;
            return false;
        L19:
            return a();
        L18:
            return true;
        L9:
            return a();
        L17:
            throw new IllegalArgumentException();
        }
    }

    public static class d extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f7890b;

        public d(a r8, boolean r10) {
            super(r8);
            this.f7890b = r10;
        }

        @Override // h0.e.c
        public final boolean a() {
            return this.f7890b;
        }
    }

    static {
        f7884a = new d(null, false);
        f7885b = new d(null, true);
        a r8 = a.f7888a;
        f7886c = new d(r8, false);
        f7887d = new d(r8, true);
    }
}

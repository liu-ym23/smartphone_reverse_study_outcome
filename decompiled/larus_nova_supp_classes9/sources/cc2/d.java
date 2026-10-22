package cc2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class d extends o {
    public final String a;

    public static final class a extends d {
        public static final String b = null;
        public static final a c = null;

        static {
            c = new a();
            b = "PublicScreenStretch";
        }

        public a() {
        }

        @Override // cc2.o
        public final String b() {
            return b;
        }
    }

    public d() {
        this.a = "CarnivalTray";
    }

    @Override // cc2.o
    public final String a() {
        return this.a;
    }
}

package cc2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class i extends o {
    public final String a;

    public static final class a extends i {
        public static final String b = null;
        public static final a c = null;

        static {
            c = new a();
            b = "LandscapeInteractLayerHide";
        }

        public a() {
        }

        @Override // cc2.o
        public final String b() {
            return b;
        }
    }

    public static final class b extends i {
        public static final String b = null;
        public static final b c = null;

        static {
            c = new b();
            b = "PanelCover";
        }

        public b() {
        }

        @Override // cc2.o
        public final String b() {
            return b;
        }
    }

    public static final class c extends i {
        public static final String b = null;
        public static final c c = null;

        static {
            c = new c();
            b = "RightBottomCardShow";
        }

        public c() {
        }

        @Override // cc2.o
        public final String b() {
            return b;
        }
    }

    public i() {
        this.a = "FlowLike";
    }

    @Override // cc2.o
    public final String a() {
        return this.a;
    }
}

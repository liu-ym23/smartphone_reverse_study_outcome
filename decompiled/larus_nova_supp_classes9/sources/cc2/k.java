package cc2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class k extends o {
    public final String a;

    public static final class a extends k {
        public static final String b = null;
        public static final a c = null;

        static {
            c = new a();
            b = "AnswerQuestionContainer";
        }

        public a() {
        }

        @Override // cc2.o
        public final String b() {
            return b;
        }
    }

    public static final class b extends k {
        public static final String b = null;
        public static final b c = null;

        static {
            c = new b();
            b = "PublicScreenStretch";
        }

        public b() {
        }

        @Override // cc2.o
        public final String b() {
            return b;
        }
    }

    public k() {
        this.a = "PinContainer";
    }

    @Override // cc2.o
    public final String a() {
        return this.a;
    }
}

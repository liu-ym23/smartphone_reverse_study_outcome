package cc2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class j extends o {
    public final String a;

    public static final class a extends j {
        public static final String b = null;
        public static final a c = null;

        static {
            c = new a();
            b = "ChatChannelEvent";
        }

        public a() {
        }

        @Override // cc2.o
        public final String b() {
            return b;
        }
    }

    public static final class b extends j {
        public static final String b = null;
        public static final b c = null;

        static {
            c = new b();
            b = "IMEmojiShow";
        }

        public b() {
        }

        @Override // cc2.o
        public final String b() {
            return b;
        }
    }

    public j() {
        this.a = "imemoji_entrance";
    }

    @Override // cc2.o
    public final String a() {
        return this.a;
    }
}

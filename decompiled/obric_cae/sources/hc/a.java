package hc;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements f {

    /* JADX INFO: renamed from: hc.a$a, reason: collision with other inner class name */
    public static final enum EnumC0088a extends Enum<EnumC0088a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EnumC0088a[] f8028a = null;

        static {
            f8028a = new EnumC0088a[]{new EnumC0088a("TextReverse", 0), new EnumC0088a("TextReverse2", 1), new EnumC0088a("Negative", 2)};
        }

        public EnumC0088a(String r8, int r10) {
            super(r8, r10);
        }

        public static EnumC0088a valueOf(String r8) {
            return (EnumC0088a) Enum.valueOf(EnumC0088a.class, r8);
        }

        public static EnumC0088a[] values() {
            return (EnumC0088a[]) f8028a.clone();
        }
    }

    public a() {
    }
}

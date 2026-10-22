package ha;

import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public abstract enum c extends Enum<c> implements ha.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f7964a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ c[] f7965b = null;

    public final enum a extends c {
        public a() {
            super("IDENTITY", 0);
        }

        @Override // ha.d
        public final String a(Field r8) {
            return r8.getName();
        }
    }

    static {
        a r8 = new a();
        f7964a = r8;
        f7965b = new c[]{r8, new b(), new C0087c(), new d(), new e(), new f(), new g()};
    }

    public c() {
        throw null;
    }

    public c(String r8, int r10) {
        super(r8, r10);
    }

    public static String b(String r8, char r10) {
        StringBuilder r11 = new StringBuilder();
        int r12 = r8.length();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L11;
        char r14 = r8.charAt(r13);
        if (Character.isUpperCase(r14) == false) goto L9;
        if (r11.length() == 0) goto L9;
        r11.append(r10);
    L9:
        r11.append(r14);
        r13 = r13 + 1;
        goto L3
    L11:
        return r11.toString();
    }

    public static String c(String r8) {
        int r10 = r8.length();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L16;
        char r12 = r8.charAt(r11);
        if (Character.isLetter(r12) == true) goto L7;
        r11 = r11 + 1;
        goto L3
    L7:
        if (Character.isUpperCase(r12) == false) goto L9;
        return r8;
    L9:
        char r13 = Character.toUpperCase(r12);
        if (r11 != 0) goto L14;
        return r13 + r8.substring(1);
    L14:
        return r8.substring(0, r11) + r13 + r8.substring(r11 + 1);
    L16:
        return r8;
    }

    public static c valueOf(String r8) {
        return (c) Enum.valueOf(c.class, r8);
    }

    public static c[] values() {
        return (c[]) f7965b.clone();
    }
}

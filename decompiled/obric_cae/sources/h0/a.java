package h0;

import android.text.SpannableStringBuilder;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e.d f7864d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f7865e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f7866f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f7867g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f7868h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f7869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f7870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f7871c;

    /* JADX INFO: renamed from: h0.a$a, reason: collision with other inner class name */
    public static final class C0082a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f7872a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7873b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public e.d f7874c;

        public C0082a() {
            Locale r8 = Locale.getDefault();
            int r10 = f.f7891a;
            boolean r11 = true;
            if (f.a.a(r8) == 1) goto L6;
            r11 = false;
        L6:
            this.f7872a = r11;
            this.f7874c = a.f7864d;
            this.f7873b = 2;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final byte[] f7875e = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CharSequence f7876a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f7877b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7878c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public char f7879d;

        static {
            f7875e = new byte[1792];
            int r8 = 0;
        L3:
            if (r8 >= 1792) goto L5;
            f7875e[r8] = Character.getDirectionality(r8);
            r8 = r8 + 1;
            goto L3
        }

        public b(CharSequence r8) {
            this.f7876a = r8;
            this.f7877b = r8.length();
        }

        public final byte a() {
            int r8 = this.f7878c - 1;
            CharSequence r10 = this.f7876a;
            char r11 = r10.charAt(r8);
            this.f7879d = r11;
            if (Character.isLowSurrogate(r11) == false) goto L6;
            int r12 = Character.codePointBefore(r10, this.f7878c);
            this.f7878c -= Character.charCount(r12);
            return Character.getDirectionality(r12);
        L6:
            this.f7878c--;
            char r13 = this.f7879d;
            if (r13 >= 1792) goto L10;
            return f7875e[r13];
        L10:
            return Character.getDirectionality(r13);
        }
    }

    static {
        e.d r8 = e.f7886c;
        f7864d = r8;
        f7865e = Character.toString(8206);
        f7866f = Character.toString(8207);
        f7867g = new a(false, 2, r8);
        f7868h = new a(true, 2, r8);
    }

    public a(boolean r8, int r10, e.d r11) {
        this.f7869a = r8;
        this.f7870b = r10;
        this.f7871c = r11;
    }

    public static int a(CharSequence r10) {
        b r8 = new b(r10);
        r8.f7878c = 0;
        int r11 = 0;
        int r12 = 0;
        int r13 = 0;
    L3:
        int r14 = r8.f7878c;
        if (r14 >= r8.f7877b) goto L29;
        if (r11 != 0) goto L29;
        CharSequence r15 = r8.f7876a;
        char r16 = r15.charAt(r14);
        r8.f7879d = r16;
        if (Character.isHighSurrogate(r16) == false) goto L9;
        int r17 = Character.codePointAt(r15, r8.f7878c);
        r8.f7878c = Character.charCount(r17) + r8.f7878c;
        byte r18 = Character.getDirectionality(r17);
    L13:
        if (r18 == 0) goto L26;
        if (r18 == 1) goto L24;
        if (r18 == 2) goto L24;
        if (r18 == 9) goto L3;
        switch(r18) {
            case 14: goto L23;
            case 15: goto L23;
            case 16: goto L22;
            case 17: goto L22;
            case 18: goto L21;
            default: goto L28;
        };
    L22:
        r13 = r13 + 1;
        r12 = 1;
        goto L3
    L23:
        r13 = r13 + 1;
        r12 = -1;
    L28:
        r11 = r13;
        goto L3
    L21:
        r13 = r13 - 1;
        r12 = 0;
    L24:
        if (r13 != 0) goto L28;
    L73:
        return 1;
    L26:
        if (r13 != 0) goto L28;
    L74:
        return -1;
    L9:
        r8.f7878c++;
        char r19 = r8.f7879d;
        if (r19 >= 1792) goto L12;
        r18 = b.f7875e[r19];
        goto L13
    L12:
        r18 = Character.getDirectionality(r19);
    L29:
        if (r11 == 0) goto L75;
        if (r12 == 0) goto L34;
        return r12;
    L34:
        if (r8.f7878c <= 0) goto L76;
        switch(r8.a()) {
            case 14: goto L41;
            case 15: goto L41;
            case 16: goto L39;
            case 17: goto L39;
            case 18: goto L38;
            default: goto L34;
        };
    L38:
        r13 = r13 + 1;
        goto L34
    L39:
        if (r11 == r13) goto L73;
    L43:
        r13 = r13 - 1;
        goto L34
    L41:
        if (r11 != r13) goto L43;
    L76:
        return 0;
    L75:
        return 0;
    }

    public static int b(CharSequence r8) {
        b r10 = new b(r8);
        r10.f7878c = r10.f7877b;
        int r11 = 0;
    L3:
        int r12 = r11;
    L5:
        if (r10.f7878c <= 0) goto L58;
        byte r13 = r10.a();
        if (r13 != 0) goto L9;
        if (r12 == 0) goto L28;
        if (r11 != 0) goto L5;
    L30:
        r11 = r12;
    L28:
        return -1;
    L9:
        if (r13 == 1) goto L23;
        if (r13 == 2) goto L23;
        if (r13 == 9) goto L5;
        switch(r13) {
            case 14: goto L20;
            case 15: goto L20;
            case 16: goto L18;
            case 17: goto L18;
            case 18: goto L17;
            default: goto L15;
        };
    L17:
        r12 = r12 + 1;
        goto L5
    L18:
        if (r11 == r12) goto L31;
    L22:
        r12 = r12 - 1;
    L31:
        return 1;
    L20:
        if (r11 != r12) goto L22;
    L15:
        if (r11 != 0) goto L5;
    L23:
        if (r12 == 0) goto L31;
        if (r11 != 0) goto L5;
    L58:
        return 0;
    }

    public static a c() {
        C0082a r8 = new C0082a();
        int r10 = r8.f7873b;
        if (r10 != 2) goto L11;
        if (r8.f7874c != f7864d) goto L11;
        if (r8.f7872a == false) goto L13;
        return f7868h;
    L13:
        return f7867g;
    L11:
        return new a(r8.f7872a, r10, r8.f7874c);
    }

    public final SpannableStringBuilder d(CharSequence r10, d r11) {
        if (r10 != null) goto L5;
        return null;
    L5:
        boolean r12 = ((e.c) r11).b(r10, r10.length());
        SpannableStringBuilder r8 = new SpannableStringBuilder();
        if ((this.f7870b & 2) == 0) goto L8;
        boolean r13 = true;
    L9:
        String r14 = f7866f;
        String r15 = f7865e;
        boolean r16 = this.f7869a;
        if (r13 == false) goto L27;
        if (r12 == false) goto L13;
        e.d r17 = e.f7885b;
    L14:
        boolean r18 = r17.b(r10, r10.length());
        if (r16 == true) goto L20;
        if (r18 == false) goto L18;
    L19:
        String r19 = r15;
    L26:
        r8.append(r19);
        goto L27
    L18:
        if (a(r10) == 1) goto L19;
    L20:
        if (r16 == false) goto L25;
        if (r18 == true) goto L23;
    L24:
        r19 = r14;
        goto L26
    L23:
        if (a(r10) == (-1)) goto L24;
    L25:
        r19 = "";
        goto L26
    L13:
        r17 = e.f7884a;
    L27:
        if (r12 == r16) goto L32;
        if (r12 == false) goto L30;
        char r20 = 8235;
    L31:
        r8.append(r20);
        r8.append(r10);
        r8.append(8236);
    L33:
        if (r12 == false) goto L35;
        e.d r110 = e.f7885b;
    L36:
        boolean r111 = r110.b(r10, r10.length());
        if (r16 == true) goto L42;
        if (r111 == false) goto L40;
    L41:
        r14 = r15;
    L48:
        r8.append(r14);
        return r8;
    L40:
        if (b(r10) == 1) goto L41;
    L42:
        if (r16 == false) goto L47;
        if (r111 == false) goto L48;
        if (b(r10) == (-1)) goto L48;
    L47:
        r14 = "";
        goto L48
    L35:
        r110 = e.f7884a;
        goto L36
    L30:
        r20 = 8234;
        goto L31
    L32:
        r8.append(r10);
        goto L33
    L8:
        r13 = false;
        goto L9
    }
}

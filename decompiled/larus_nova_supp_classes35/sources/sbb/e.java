package sbb;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.lark.chat.export.ui.message.style.BubbleStyle;
import com.ss.android.lark.contact.base.entity.api.ContactMobileApi$From;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e {
    public static final List<String> d = null;
    public static final e e = null;
    public static final e f = null;
    public static final e g = null;
    public static final e h = null;
    public static final e i = null;
    public static final e j = null;
    public static final e k = null;
    public static final e l = null;
    public static final e m = null;
    public static final e n = null;
    public static final e o = null;
    public static final e p = null;
    public static final e q = null;
    public static final e r = null;
    public static final e s = null;
    public static final e t = null;
    public static final e u = null;
    public static final e v = null;
    public static final e w = null;
    public static final e x = null;
    public static final e y = null;
    public static final Integer[] z = null;
    public final String a;
    public final int b;
    public String c;

    public final int hashCode() {
        return Objects.hash(new Object[]{this.a, Integer.valueOf(this.b)});
    }

    static {
        ArrayList r0 = new ArrayList();
        d = r0;
        f = new e(0, "folder", "folder");
        e r1 = new e(2, ContactMobileApi$From.DOC, ContactMobileApi$From.DOC);
        g = r1;
        e r2 = new e(3, "sheet", "sheet");
        h = r2;
        e r5 = new e(8, "bitable", "bitable");
        i = r5;
        e r7 = new e(84, "baseAdd", "base/add");
        j = r7;
        e r9 = new e(11, "mindnote", "mindnote");
        k = r9;
        l = new e(12, "file", "file");
        e r10 = new e(30, "slides", "slides");
        m = r10;
        n = new e(16, "wiki", "wiki");
        e r12 = new e(22, "docx", "docx");
        o = r12;
        p = new e(38, "catalog", "catalog");
        q = new e(28, "minutes", "minutes");
        r = new e(80, "form", "form");
        s = new e(BubbleStyle.ColorType.PURPLE_HEADER_WHITE_BORDER, "catalog", "catalog");
        t = new e(BubbleStyle.ColorType.SINGLE_URL_CARD, "miaodaCreative", "page");
        u = new e(BubbleStyle.ColorType.SINGLE_URL_CARD_IN_THREAD_CHAT, "miaodaApplication", "app");
        v = new e(125, "doubao_conversation_sharing", "unknown");
        w = new e(200, "open_platform", "open_platform");
        x = new e(998, "im_file", "im_file");
        e r11 = new e(44, "sync", "sync");
        y = r11;
        e = new e(-1, "unknown", "unknown");
        r0.add(r1.getType());
        r0.add(r2.getType());
        r0.add(r9.getType());
        r0.add(r12.getType());
        r0.add(r5.getType());
        r0.add(r7.getType());
        r0.add(r10.getType());
        r0.add(r11.getType());
        z = new Integer[]{2, 3, 8, 11, 12, 30, 16, 0, 22, 44};
    }

    public String getType() {
        return this.a;
    }

    public final int h() {
        return this.b;
    }

    public static String b(String r3) {
        String r0 = e.c;
        e r1 = g;
        if (TextUtils.equals(r3, r1.getType()) == true) goto L97;
        if (TextUtils.equals(r3, r1.c) == true) goto L97;
        e r2 = h;
        if (TextUtils.equals(r3, r2.getType()) == true) goto L113;
        if (TextUtils.equals(r3, r2.c) == true) goto L113;
        e r4 = k;
        if (TextUtils.equals(r3, r4.getType()) == true) goto L112;
        if (TextUtils.equals(r3, r4.c) == true) goto L112;
        e r5 = i;
        if (TextUtils.equals(r3, r5.getType()) == true) goto L111;
        if (TextUtils.equals(r3, r5.c) == true) goto L111;
        e r6 = j;
        if (TextUtils.equals(r3, r6.getType()) == true) goto L110;
        if (TextUtils.equals(r3, r6.c) == true) goto L110;
        e r7 = l;
        if (TextUtils.equals(r3, r7.getType()) == true) goto L109;
        if (TextUtils.equals(r3, r7.c) == true) goto L109;
        e r8 = m;
        if (TextUtils.equals(r3, r8.getType()) == true) goto L108;
        if (TextUtils.equals(r3, r8.c) == true) goto L108;
        e r9 = f;
        if (TextUtils.equals(r3, r9.getType()) == true) goto L107;
        if (TextUtils.equals(r3, r9.c) == true) goto L107;
        e r10 = n;
        if (TextUtils.equals(r3, r10.getType()) == true) goto L106;
        if (TextUtils.equals(r3, r10.c) == true) goto L106;
        e r11 = o;
        if (TextUtils.equals(r3, r11.getType()) == true) goto L105;
        if (TextUtils.equals(r3, r11.c) == true) goto L105;
        e r12 = q;
        if (TextUtils.equals(r3, r12.getType()) == true) goto L104;
        if (TextUtils.equals(r3, r12.c) == true) goto L104;
        e r13 = t;
        if (TextUtils.equals(r3, r13.getType()) == true) goto L103;
        if (TextUtils.equals(r3, r13.c) == true) goto L103;
        e r14 = u;
        if (TextUtils.equals(r3, r14.getType()) == true) goto L102;
        if (TextUtils.equals(r3, r14.c) == true) goto L102;
        e r15 = w;
        if (TextUtils.equals(r3, r15.getType()) == true) goto L101;
        if (TextUtils.equals(r3, r15.c) == true) goto L101;
        e r16 = x;
        if (TextUtils.equals(r3, r16.getType()) == true) goto L100;
        if (TextUtils.equals(r3, r16.c) == true) goto L100;
        e r17 = y;
        if (TextUtils.equals(r3, r17.getType()) == true) goto L99;
        if (TextUtils.equals(r3, r17.c) == true) goto L99;
        return r0;
    L99:
        return r17.c;
    L100:
        return r16.c;
    L101:
        return r15.c;
    L102:
        return r14.c;
    L103:
        return r13.c;
    L104:
        return r12.c;
    L105:
        return r11.c;
    L106:
        return r10.c;
    L107:
        return r9.c;
    L108:
        return r8.c;
    L109:
        return r7.c;
    L110:
        return r6.c;
    L111:
        return r5.c;
    L112:
        return r4.c;
    L113:
        return r2.c;
    L97:
        return r1.c;
    }

    public static String c(int r1) {
        if (r1 != l.b) goto L7;
        return "drive";
    L7:
        return f(r1);
    }

    public static e d(int r2) {
        e r0 = g;
        if (r2 != r0.b) goto L5;
        return r0;
    L5:
        e r1 = f;
        if (r2 != r1.b) goto L8;
        return r1;
    L8:
        e r3 = h;
        if (r2 != r3.b) goto L11;
        return r3;
    L11:
        e r4 = i;
        if (r2 != r4.b) goto L14;
        return r4;
    L14:
        e r5 = j;
        if (r2 != r5.b) goto L17;
        return r5;
    L17:
        e r6 = k;
        if (r2 != r6.b) goto L20;
        return r6;
    L20:
        e r7 = l;
        if (r2 != r7.b) goto L23;
        return r7;
    L23:
        e r8 = m;
        if (r2 != r8.b) goto L26;
        return r8;
    L26:
        e r9 = n;
        if (r2 != r9.b) goto L29;
        return r9;
    L29:
        e r10 = o;
        if (r2 != r10.b) goto L32;
        return r10;
    L32:
        e r11 = q;
        if (r2 != r11.b) goto L35;
        return r11;
    L35:
        e r12 = r;
        if (r2 != r12.b) goto L38;
        return r12;
    L38:
        e r13 = t;
        if (r2 != r13.b) goto L41;
        return r13;
    L41:
        e r14 = u;
        if (r2 != r14.b) goto L44;
        return r14;
    L44:
        e r15 = v;
        if (r2 != r15.b) goto L47;
        return r15;
    L47:
        e r16 = w;
        if (r2 != r16.b) goto L50;
        return r16;
    L50:
        e r17 = x;
        if (r2 != r17.b) goto L53;
        return r17;
    L53:
        e r18 = y;
        if (r2 != r18.b) goto L57;
        return r18;
    L57:
        return e;
    }

    public static e e(String r3) {
        e r0 = e;
        e r1 = g;
        if (TextUtils.equals(r3, r1.getType()) == true) goto L56;
        r1 = h;
        if (TextUtils.equals(r3, r1.getType()) == true) goto L56;
        r1 = k;
        if (TextUtils.equals(r3, r1.getType()) == true) goto L56;
        r1 = i;
        if (TextUtils.equals(r3, r1.getType()) == true) goto L56;
        r1 = j;
        if (TextUtils.equals(r3, r1.getType()) == true) goto L56;
        r1 = l;
        if (TextUtils.equals(r3, r1.getType()) == true) goto L56;
        r1 = m;
        if (TextUtils.equals(r3, r1.getType()) == true) goto L56;
        r1 = f;
        if (TextUtils.equals(r3, r1.getType()) == true) goto L56;
        r1 = n;
        if (TextUtils.equals(r3, r1.getType()) == true) goto L56;
        r1 = o;
        if (TextUtils.equals(r3, r1.getType()) == true) goto L56;
        r1 = q;
        if (TextUtils.equals(r3, r1.getType()) == true) goto L56;
        r1 = r;
        if (TextUtils.equals(r3, r1.getType()) == true) goto L56;
        r1 = t;
        if (TextUtils.equals(r3, r1.getType()) == true) goto L56;
        r1 = u;
        if (TextUtils.equals(r3, r1.getType()) == true) goto L56;
        r1 = v;
        if (TextUtils.equals(r3, r1.getType()) == true) goto L56;
        r1 = w;
        if (TextUtils.equals(r3, r1.getType()) == true) goto L56;
        r1 = x;
        if (TextUtils.equals(r3, r1.getType()) == true) goto L56;
        r1 = y;
        if (TextUtils.equals(r3, r1.getType()) == true) goto L56;
        return r0;
    L56:
        return r1;
    }

    public static String f(int r2) {
        e r0 = g;
        if (r2 == r0.b) goto L5;
        e r1 = f;
        if (r2 == r1.b) goto L9;
        e r3 = h;
        if (r2 == r3.b) goto L13;
        e r4 = i;
        if (r2 == r4.b) goto L17;
        e r5 = k;
        if (r2 == r5.b) goto L21;
        e r6 = l;
        if (r2 == r6.b) goto L25;
        e r7 = m;
        if (r2 == r7.b) goto L29;
        e r8 = n;
        if (r2 == r8.b) goto L33;
        e r9 = o;
        if (r2 == r9.b) goto L37;
        e r10 = q;
        if (r2 == r10.b) goto L41;
        e r11 = r;
        if (r2 == r11.b) goto L45;
        e r12 = t;
        if (r2 == r12.b) goto L49;
        e r13 = u;
        if (r2 == r13.b) goto L53;
        e r14 = v;
        if (r2 == r14.b) goto L57;
        e r15 = w;
        if (r2 == r15.b) goto L61;
        e r16 = x;
        if (r2 != r16.b) goto L67;
        return r16.getType();
    L67:
        if (r2 == 44) goto L69;
        e r17 = s;
        if (r2 != r17.b) goto L75;
        return r17.getType();
    L75:
        return e.getType();
    L69:
        return y.getType();
    L61:
        return r15.getType();
    L57:
        return r14.getType();
    L53:
        return r13.getType();
    L49:
        return r12.getType();
    L45:
        return r11.getType();
    L41:
        return r10.getType();
    L37:
        return r9.getType();
    L33:
        return r8.getType();
    L29:
        return r7.getType();
    L25:
        return r6.getType();
    L21:
        return r5.getType();
    L17:
        return r4.getType();
    L13:
        return r3.getType();
    L9:
        return r1.getType();
    L5:
        return r0.getType();
    }

    public static int g(String r3) {
        int r0 = e.b;
        e r1 = g;
        if (TextUtils.equals(r3, r1.getType()) == true) goto L57;
        e r2 = h;
        if (TextUtils.equals(r3, r2.getType()) == true) goto L58;
        e r4 = k;
        if (TextUtils.equals(r3, r4.getType()) == true) goto L59;
        e r5 = i;
        if (TextUtils.equals(r3, r5.getType()) == true) goto L60;
        e r6 = j;
        if (TextUtils.equals(r3, r6.getType()) == true) goto L61;
        e r7 = l;
        if (TextUtils.equals(r3, r7.getType()) == true) goto L62;
        e r8 = m;
        if (TextUtils.equals(r3, r8.getType()) == true) goto L63;
        e r9 = f;
        if (TextUtils.equals(r3, r9.getType()) == true) goto L64;
        e r10 = n;
        if (TextUtils.equals(r3, r10.getType()) == true) goto L65;
        e r11 = o;
        if (TextUtils.equals(r3, r11.getType()) == true) goto L66;
        e r12 = q;
        if (TextUtils.equals(r3, r12.getType()) == true) goto L67;
        e r13 = r;
        if (TextUtils.equals(r3, r13.getType()) == true) goto L68;
        e r14 = t;
        if (TextUtils.equals(r3, r14.getType()) == true) goto L69;
        e r15 = u;
        if (TextUtils.equals(r3, r15.getType()) == true) goto L70;
        e r16 = v;
        if (TextUtils.equals(r3, r16.getType()) == true) goto L71;
        e r17 = w;
        if (TextUtils.equals(r3, r17.getType()) == true) goto L72;
        e r18 = x;
        if (TextUtils.equals(r3, r18.getType()) == true) goto L73;
        e r19 = y;
        if (TextUtils.equals(r3, r19.getType()) == true) goto L56;
        return r0;
    L56:
        return r19.b;
    L73:
        return r18.b;
    L72:
        return r17.b;
    L71:
        return r16.b;
    L70:
        return r15.b;
    L69:
        return r14.b;
    L68:
        return r13.b;
    L67:
        return r12.b;
    L66:
        return r11.b;
    L65:
        return r10.b;
    L64:
        return r9.b;
    L63:
        return r8.b;
    L62:
        return r7.b;
    L61:
        return r6.b;
    L60:
        return r5.b;
    L59:
        return r4.b;
    L58:
        return r2.b;
    L57:
        return r1.b;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L17:
        return false;
    L8:
        if (e.class != r5.getClass()) goto L17;
        e r6 = (e) r5;
        if (this.b == r6.b) goto L13;
    L15:
        return false;
    L13:
        if (Objects.equals(this.a, r6.a) == false) goto L15;
        return true;
    }

    public static String a(Context r3, int r4) {
        if (r3 != null) goto L6;
        return BuildConfig.FLAVOR;
    L6:
        if (r4 != g.b) goto L10;
        return r3.getResources().getString(2131888007);
    L10:
        if (r4 != h.b) goto L14;
        return r3.getResources().getString(2131888010);
    L14:
        if (r4 != i.b) goto L18;
        return r3.getResources().getString(2131888006);
    L18:
        if (r4 != j.b) goto L22;
        return r3.getResources().getString(2131888006);
    L22:
        if (r4 != k.b) goto L26;
        return r3.getResources().getString(2131888009);
    L26:
        if (r4 != l.b) goto L30;
        return r3.getResources().getString(2131888008);
    L30:
        if (r4 != m.b) goto L34;
        return r3.getResources().getString(2131889771);
    L34:
        if (r4 == f.b) goto L41;
        if (r4 == 111) goto L41;
        return r3.getResources().getString(2131888007);
    L41:
        return r3.getResources().getString(2131887142);
    }

    public e(int r1, String r2, String r3) {
        this.b = r1;
        this.a = r2;
        this.c = r3;
    }
}

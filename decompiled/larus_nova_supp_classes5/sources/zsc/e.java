package zsc;

import java.util.Locale;
import java.util.regex.Pattern;
import org.commonmark.node.Image;
import org.commonmark.node.Link;
import org.commonmark.node.LinkReferenceDefinition;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class e extends i {
    public static final Pattern e = null;

    @Override // zsc.i
    public final char d() {
        return ']';
    }

    static {
        e = j.o;
    }

    @Override // zsc.i
    public final uvc.b b() {
        boolean r1 = true;
        int r0 = this.d + 1;
        this.d = r0;
        k r2 = this.a;
        org.commonmark.internal.e r3 = ((j) r2).j;
        if (r3 != null) goto L7;
        return f("]");
    L7:
        if (r3.f == true) goto L10;
        j r4 = (j) r2;
        r4.j = r4.j.d;
        return f("]");
    L10:
        LinkReferenceDefinition r8 = null;
        if (c() != '(') goto L35;
        this.d++;
        e();
        k r5 = this.a;
        int r7 = this.d;
        j r6 = (j) r5;
        r6.h = r7;
        int r9 = tvc.c.a(r6.g, r7);
        if (r9 != (-1)) goto L16;
        String r10 = null;
    L20:
        this.d = ((j) this.a).h;
        if (r10 == null) goto L34;
        e();
        Pattern r11 = e;
        String r12 = this.c;
        int r13 = this.d;
        if (r11.matcher(r12.substring(r13 - 1, r13)).matches() == false) goto L29;
        k r14 = this.a;
        int r15 = this.d;
        j r16 = (j) r14;
        r16.h = r15;
        int r17 = tvc.c.c(r16.g, r15);
        if (r17 != (-1)) goto L27;
        String r18 = null;
    L28:
        this.d = ((j) this.a).h;
        e();
    L31:
        if (c() != ')') goto L33;
        this.d++;
        boolean r19 = true;
    L37:
        if (r19 == true) goto L67;
        int r110 = this.d;
        j r111 = (j) this.a;
        r111.h = r110;
        if (r110 < r111.g.length()) goto L41;
    L54:
        int r20 = ((j) this.a).h;
        this.d = r20;
        int r21 = r20 - r110;
        if (r21 <= 2) goto L58;
        String r22 = this.c.substring(r110, r21 + r110);
    L61:
        if (r22 == null) goto L67;
        Pattern r112 = tvc.a.a;
        String r23 = tvc.a.c.matcher(r22.substring(1, r22.length() - 1).trim().toLowerCase(Locale.ROOT)).replaceAll(" ");
        j r113 = (j) this.a;
        if (r113.b == false) goto L65;
        r8 = ((org.commonmark.internal.m) r113.a).b.get(r23);
    L65:
        if (r8 == null) goto L67;
        r10 = r8.i;
        r18 = r8.j;
    L68:
        if (r1 == true) goto L70;
        this.d = r0;
        j r24 = (j) this.a;
        r24.j = r24.j.d;
        return f("]");
    L70:
        if (r3.c == false) goto L72;
        uvc.b r25 = new Image(r10, r18);
    L73:
        uvc.b r26 = r3.a.e;
    L74:
        if (r26 == null) goto L76;
        uvc.b r27 = r26.e;
        r25.b(r26);
        r26 = r27;
        goto L74
    L76:
        org.commonmark.internal.f r28 = r3.e;
        j r29 = (j) this.a;
        r29.h = this.d;
        r29.e(r28);
        this.d = ((j) this.a).h;
        uvc.b r30 = r25.b;
        uvc.b r31 = r25.c;
        if (r30 == r31) goto L80;
        h.b(r30, r31);
    L80:
        r3.a.g();
        k r32 = this.a;
        j r33 = (j) r32;
        r33.j = r33.j.d;
        if (r3.c == true) goto L88;
        org.commonmark.internal.e r34 = ((j) r32).j;
    L83:
        if (r34 == null) goto L88;
        if (r34.c == true) goto L87;
        r34.f = false;
    L87:
        r34 = r34.d;
    L88:
        return r25;
    L72:
        r25 = new Link(r10, r18);
        goto L73
    L58:
        if (r3.g == true) goto L60;
        r22 = this.c.substring(r3.b, r0);
        goto L61
    L60:
        r22 = null;
        goto L61
    L41:
        if (r111.g.charAt(r111.h) != '[') goto L54;
        int r114 = r111.h + 1;
        int r115 = tvc.c.b(r111.g, r114);
        int r116 = r115 - r114;
        if (r115 == (-1)) goto L54;
        if (r116 > 999) goto L54;
        if (r115 >= r111.g.length()) goto L54;
        if (r111.g.charAt(r115) != ']') goto L54;
        r111.h = r115 + 1;
    L67:
        r1 = r19;
        goto L68
    L33:
        this.d = r0;
    L36:
        r19 = false;
        goto L37
    L27:
        String r117 = r16.g.substring(r16.h + 1, r17 - 1);
        r16.h = r17;
        r18 = tvc.a.a(r117);
        goto L28
    L29:
        r18 = null;
        goto L31
    L34:
        r18 = null;
        goto L36
    L16:
        if (r6.d() != '<') goto L18;
        String r35 = r6.g.substring(r6.h + 1, r9 - 1);
    L19:
        r6.h = r9;
        r10 = tvc.a.a(r35);
        goto L20
    L18:
        r35 = r6.g.substring(r6.h, r9);
        goto L19
    L35:
        r10 = null;
        r18 = null;
        goto L36
    }

    public e() {
    }
}

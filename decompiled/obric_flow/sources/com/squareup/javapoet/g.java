package com.squareup.javapoet;

import ai.j0;
import java.lang.reflect.Type;
import java.util.ArrayList;
import javax.lang.model.element.Element;
import javax.lang.model.type.TypeMirror;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f14965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f14966b;

    public g() {
        this.f14965a = new ArrayList();
        this.f14966b = new ArrayList();
    }

    public static x d(Object r5) {
        if ((r5 instanceof x) == false) goto L7;
        return (x) r5;
    L7:
        if ((r5 instanceof TypeMirror) == false) goto L11;
        return x.g((TypeMirror) r5);
    L11:
        if ((r5 instanceof Element) == false) goto L15;
        return x.g(((Element) r5).asType());
    L15:
        if ((r5 instanceof Type) == false) goto L19;
        return x.e((Type) r5);
    L19:
        throw new IllegalArgumentException("expected type but was " + r5);
    }

    public final void a(i r5) {
        this.f14965a.addAll(r5.f14971a);
        this.f14966b.addAll(r5.f14972b);
    }

    public final void b(String r18, Object... r19) {
        int[] r5 = new int[r19.length];
        int r10 = 0;
        boolean r11 = false;
        int r12 = 0;
        boolean r13 = false;
    L4:
        if (r10 >= r18.length()) goto L93;
        char r14 = r18.charAt(r10);
        ArrayList r15 = this.f14965a;
        if (r14 != '$') goto L7;
        int r16 = r10 + 1;
        int r17 = r16;
    L13:
        if (r17 >= r18.length()) goto L15;
        boolean r110 = true;
    L16:
        com.bytedance.android.anniex.base.service.f.r(r110, "dangling format characters in '%s'", new Object[]{r18});
        int r20 = r17 + 1;
        char r111 = r18.charAt(r17);
        if (r111 < '0') goto L22;
        if (r111 > '9') goto L22;
        r17 = r20;
    L22:
        if (r111 == '$') goto L88;
        if (r111 == '>') goto L88;
        if (r111 == '<') goto L88;
        if (r111 == '[') goto L88;
        if (r111 == ']') goto L88;
        if (r111 == 'W') goto L88;
        if (r111 == 'Z') goto L88;
        if (r16 >= r17) goto L41;
        int r21 = Integer.parseInt(r18.substring(r16, r17)) - 1;
        if (r19.length <= 0) goto L40;
        int r112 = r21 % r19.length;
        r5[r112] = r5[r112] + 1;
    L40:
        boolean r22 = true;
        int r23 = r12;
        r12 = r21;
    L42:
        if (r12 >= 0) goto L44;
    L46:
        boolean r113 = false;
    L47:
        com.bytedance.android.anniex.base.service.f.r(r113, "index %d for '%s' not in range (received %s arguments)", new Object[]{Integer.valueOf(r12 + 1), r18.substring(r10, r20), Integer.valueOf(r19.length)});
        if (r22 == false) goto L52;
        if (r11 == false) goto L52;
        boolean r24 = false;
    L53:
        com.bytedance.android.anniex.base.service.f.r(r24, "cannot mix indexed and positional parameters", new Object[0]);
        Object r25 = r19[r12];
        ArrayList r26 = this.f14966b;
        if (r111 != 'L') goto L56;
        r26.add(r25);
    L87:
        r15.add("$" + r111);
        r10 = r20;
        r12 = r23;
        r13 = r22;
        goto L4
    L56:
        if (r111 == 'N') goto L69;
        if (r111 != 'S') goto L60;
        if (r25 == null) goto L66;
        String r27 = String.valueOf(r25);
    L67:
        r26.add(r27);
        goto L87
    L66:
        r27 = null;
        goto L67
    L60:
        if (r111 != 'T') goto L63;
        r26.add(d(r25));
        goto L87
    L63:
        throw new IllegalArgumentException(j0.k("invalid format string: '", r18, "'"));
    L69:
        if ((r25 instanceof CharSequence) == false) goto L72;
        String r28 = r25.toString();
    L83:
        r26.add(r28);
        goto L87
    L72:
        if ((r25 instanceof u) == false) goto L75;
        r28 = ((u) r25).f15017a;
        goto L83
    L75:
        if ((r25 instanceof m) == false) goto L78;
        r28 = ((m) r25).f14992b;
        goto L83
    L78:
        if ((r25 instanceof t) == false) goto L81;
        r28 = ((t) r25).f15010a;
        goto L83
    L81:
        if ((r25 instanceof z) == false) goto L85;
        r28 = ((z) r25).f15054b;
        goto L83
    L85:
        throw new IllegalArgumentException("expected name but was " + r25);
    L52:
        r24 = true;
        goto L53
    L44:
        if (r12 >= r19.length) goto L46;
        r113 = true;
        goto L47
    L41:
        r22 = r13;
        r23 = r12 + 1;
        r11 = true;
    L88:
        if (r16 != r17) goto L90;
        boolean r29 = true;
    L91:
        com.bytedance.android.anniex.base.service.f.r(r29, "$$, $>, $<, $[, $], $W, and $Z may not have an index", new Object[0]);
        r15.add("$" + r111);
        r10 = r20;
        goto L4
    L90:
        r29 = false;
        goto L91
    L15:
        r110 = false;
        goto L16
    L7:
        int r30 = r18.indexOf(36, r10 + 1);
        if (r30 != (-1)) goto L10;
        r30 = r18.length();
    L10:
        r15.add(r18.substring(r10, r30));
        r10 = r30;
        goto L4
    L93:
        if (r11 == true) goto L95;
    L99:
        if (r13 == false) goto L135;
        ArrayList r31 = new ArrayList();
        int r32 = 0;
    L102:
        if (r32 >= r19.length) goto L108;
        if (r5[r32] != 0) goto L106;
        r31.add("$" + (r32 + 1));
    L106:
        r32 = r32 + 1;
        goto L102
    L108:
        if (r31.size() != 1) goto L110;
        String r33 = "";
    L111:
        com.bytedance.android.anniex.base.service.f.r(r31.isEmpty(), "unused argument%s: %s", new Object[]{r33, String.join(", ", r31)});
        return;
    L110:
        r33 = "s";
        goto L111
    L135:
        return;
    L95:
        if (r12 < r19.length) goto L97;
        boolean r34 = true;
    L98:
        com.bytedance.android.anniex.base.service.f.r(r34, "unused arguments: expected %s, received %s", new Object[]{Integer.valueOf(r12), Integer.valueOf(r19.length)});
        goto L99
    L97:
        r34 = false;
        goto L98
    }

    public final void c(String r5, Object... r10) {
        b("$[", new Object[0]);
        b(r5, r10);
        b(";\n$]", new Object[0]);
    }

    public final void e(String r5, Object... r10) {
        b(r5 + " {\n", r10);
        this.f14965a.add("$>");
    }

    public final i f() {
        return new i(this);
    }

    public final void g() {
        this.f14965a.add("$<");
        b("}\n", new Object[0]);
    }

    public final void h(String r5, Object... r10) {
        ArrayList r11 = this.f14965a;
        r11.add("$<");
        b("} " + r5 + " {\n", r10);
        r11.add("$>");
    }
}

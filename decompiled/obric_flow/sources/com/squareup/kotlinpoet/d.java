package com.squareup.kotlinpoet;

import ai.j0;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import javax.lang.model.element.Element;
import javax.lang.model.type.TypeMirror;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f15113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f15114b;

    public d() {
        this.f15113a = new ArrayList();
        this.f15114b = new ArrayList();
    }

    public static a0 c(Object r5) {
        if ((r5 instanceof a0) == false) goto L6;
        return (a0) r5;
    L6:
        if ((r5 instanceof TypeMirror) == false) goto L9;
        System.out.println("Deprecation warning: converting " + r5 + " to TypeName. Conversion of TypeMirror and TypeElement is deprecated in KotlinPoet, use kotlin-metadata APIs instead.");
        return b0.c((TypeMirror) r5);
    L9:
        if ((r5 instanceof Element) == false) goto L12;
        System.out.println("Deprecation warning: converting " + r5 + " to TypeName. Conversion of TypeMirror and TypeElement is deprecated in KotlinPoet, use kotlin-metadata APIs instead.");
        return b0.c(((Element) r5).asType());
    L12:
        if ((r5 instanceof Type) == false) goto L15;
        return b0.b((Type) r5);
    L15:
        if ((r5 instanceof KClass) == false) goto L19;
        return b0.a((KClass) r5);
    L19:
        throw new IllegalArgumentException("expected type but was " + r5);
    }

    public final void a(String r19, Object... r20) {
        d r5 = this;
        int r10 = 1;
        Intrinsics.checkNotNullParameter(r19, "format");
        Intrinsics.checkNotNullParameter(r20, "args");
        int[] r11 = new int[r20.length];
        int r12 = 0;
        boolean r13 = false;
        int r14 = 0;
        boolean r15 = false;
    L4:
        if (r12 >= r19.length()) goto L139;
        Set r16 = e.f15130c;
        boolean r17 = com.bytedance.apm.util.a.o(r19.charAt(r12));
        ArrayList r18 = r5.f15113a;
        if (r17 == true) goto L7;
        if (r19.charAt(r12) != '%') goto L10;
        int r110 = r12 + 1;
        int r111 = r110;
    L16:
        if (r111 >= r19.length()) goto L138;
        r12 = r111 + 1;
        char r21 = r19.charAt(r111);
        if ('0' > r21) goto L22;
        if (r21 >= ':') goto L22;
        r111 = r12;
    L22:
        Set r112 = e.f15130c;
        if (r21 != '%') goto L29;
        if (r110 != r111) goto L28;
        r18.add("%" + r21);
    L26:
        r10 = 1;
        goto L4
    L28:
        throw new IllegalArgumentException("%% may not have an index");
    L29:
        if (r110 >= r111) goto L35;
        int r22 = Integer.parseInt(r19.substring(r110, r111));
        boolean r113 = true;
        int r23 = r22 - 1;
        if (r20.length == 0) goto L34;
        int r114 = r23 % r20.length;
        r11[r114] = r11[r114] + 1;
    L34:
        int r24 = r14;
        r14 = r23;
    L36:
        if (r14 < 0) goto L135;
        if (r14 >= r20.length) goto L135;
        if (r113 == false) goto L44;
        if (r13 == false) goto L44;
        throw new IllegalArgumentException("cannot mix indexed and positional parameters");
    L44:
        Object r25 = r20[r14];
        ArrayList r26 = r5.f15114b;
        if (r21 == 'N') goto L47;
        boolean r115 = r13;
        if (r21 != 'L') goto L112;
        r26.add(r25);
    L132:
        r18.add("%" + r21);
        r5 = this;
        r14 = r24;
        r15 = r113;
        r13 = r115;
        goto L26
    L112:
        String r27 = null;
        if (r21 != 'S') goto L118;
        if (r25 == null) goto L116;
        r27 = r25.toString();
    L116:
        r26.add(r27);
        goto L132
    L118:
        if (r21 != 'P') goto L127;
        if ((r25 instanceof e) == true) goto L125;
        if (r25 == null) goto L124;
        r25 = r25.toString();
        goto L125
    L124:
        r25 = null;
    L125:
        r26.add(r25);
        goto L132
    L127:
        if (r21 != 'T') goto L130;
        r26.add(c(r25));
        goto L132
    L130:
        if (r21 != 'M') goto L133;
        r26.add(r25);
        goto L132
    L133:
        StringCompanionObject r28 = StringCompanionObject.INSTANCE;
        throw new IllegalArgumentException(String.format("invalid format string: '%s'", Arrays.copyOf(new Object[]{r19}, 1)));
    L47:
        if ((r25 instanceof CharSequence) == false) goto L50;
        String r29 = r25.toString();
    L61:
        Intrinsics.checkNotNullParameter(r29, "<this>");
        if (Character.isJavaIdentifierStart(StringsKt.n(r29)) == false) goto L70;
        String r30 = StringsKt.drop(r29, 1);
        r115 = r13;
        int r116 = 0;
    L65:
        if (r116 >= r30.length()) goto L74;
        if (Character.isJavaIdentifierPart(r30.charAt(r116)) == false) goto L72;
        r116 = r116 + 1;
    L72:
        if (f0.a(r29) == true) goto L74;
        r29 = StringsKt.E("`" + r29 + '`', ' ', Typography.middleDot);
    L74:
        Intrinsics.checkNotNullParameter(r29, "<this>");
        if (f0.f15149b.contains(r29) == true) goto L77;
    L79:
        Intrinsics.checkNotNullParameter(r29, "<this>");
        int r31 = 0;
    L81:
        if (r31 >= r29.length()) goto L89;
        if (r29.charAt(r31) == '$') goto L85;
        r31 = r31 + 1;
        goto L81
    L85:
        if (f0.a(r29) == true) goto L89;
        r29 = androidx.room.jarjarred.org.antlr.runtime.a.p("`", '`', r29);
    L89:
        Intrinsics.checkNotNullParameter(r29, "<this>");
        int r32 = 0;
    L91:
        if (r32 >= r29.length()) goto L96;
        if (r29.charAt(r32) != '_') goto L98;
        r32 = r32 + 1;
    L98:
        int r33 = 0;
    L100:
        if (r33 >= r29.length()) goto L106;
        Character r34 = Character.valueOf(r29.charAt(r33));
        Set r117 = f0.f15150c;
        if (r117.contains(r34) == true) goto L104;
        r33 = r33 + 1;
        goto L100
    L104:
        StringBuilder r35 = j0.x("Can't escape identifier ", r29, " because it contains illegal characters: ");
        r35.append(CollectionsKt.q(CollectionsKt.intersect(r117, StringsKt.e0(r29)), "", null, null, 0, null, null, 62));
        throw new IllegalArgumentException(r35.toString().toString());
    L106:
        r26.add(r29);
        goto L132
    L96:
        if (f0.a(r29) == true) goto L98;
        r29 = androidx.room.jarjarred.org.antlr.runtime.a.p("`", '`', r29);
        goto L98
    L77:
        if (f0.a(r29) == true) goto L79;
        r29 = androidx.room.jarjarred.org.antlr.runtime.a.p("`", '`', r29);
        goto L79
    L70:
        r115 = r13;
        goto L72
    L50:
        if ((r25 instanceof s) == false) goto L53;
        r29 = ((s) r25).f15192a;
        goto L61
    L53:
        if ((r25 instanceof w) == false) goto L56;
        r29 = ((w) r25).f15205c;
        goto L61
    L56:
        if ((r25 instanceof k) == false) goto L59;
        r29 = ((k) r25).f15173b;
        goto L61
    L59:
        if ((r25 instanceof d0) == false) goto L108;
        r29 = ((d0) r25).f15117c;
        Intrinsics.checkNotNull(r29);
        goto L61
    L108:
        throw new IllegalArgumentException("expected name but was " + r25);
    L135:
        StringBuilder r36 = new StringBuilder("index ");
        r36.append(r14 + 1);
        r36.append(" for '");
        r36.append(r19.substring(r12, r12));
        r36.append("' not in range (received ");
        throw new IllegalArgumentException(androidx.constraintlayout.motion.widget.a.s(r36, r20.length, " arguments)").toString());
    L35:
        r113 = r15;
        r24 = r14 + 1;
        r13 = true;
        goto L36
    L138:
        throw new IllegalArgumentException(androidx.room.jarjarred.org.antlr.runtime.a.p("dangling format characters in '", '\'', r19).toString());
    L10:
        Intrinsics.checkNotNullParameter(r19, "<this>");
        int r118 = StringsKt.s(r19, new char[]{'%', 171, 187, 8677, 8676}, r12 + 1);
        if (r118 != (-1)) goto L13;
        r118 = r19.length();
    L13:
        r18.add(r19.substring(r12, r118));
        r12 = r118;
        goto L4
    L7:
        r18.add(String.valueOf(r19.charAt(r12)));
        r12 = r12 + r10;
        goto L4
    L139:
        if (r13 == true) goto L141;
    L145:
        if (r15 == false) goto L162;
        ArrayList r37 = new ArrayList();
        int r38 = r20.length;
        int r39 = 0;
    L147:
        if (r39 >= r38) goto L154;
        if (r11[r39] != 0) goto L151;
        StringBuilder r40 = new StringBuilder("%");
        int r41 = 1;
        r40.append(r39 + 1);
        r37.add(r40.toString());
    L152:
        r39 = r39 + r41;
        goto L147
    L151:
        r41 = 1;
        goto L152
    L154:
        if (r37.size() != 1) goto L156;
        String r42 = "";
    L158:
        if (r37.isEmpty() == true) goto L192;
        StringBuilder r43 = j0.x("unused argument", r42, ": ");
        r43.append(CollectionsKt.q(r37, ", ", null, null, 0, null, null, 62));
        throw new IllegalArgumentException(r43.toString().toString());
    L192:
        return;
    L156:
        r42 = "s";
        goto L158
    L162:
        return;
    L141:
        if (r14 >= r20.length) goto L145;
        StringBuilder r44 = j0.s(r14, "unused arguments: expected ", ", received ");
        r44.append(r20.length);
        throw new IllegalArgumentException(r44.toString().toString());
    }

    public final void b(String r5, Object... r10) {
        Intrinsics.checkNotNullParameter(r5, "format");
        Intrinsics.checkNotNullParameter(r10, "args");
        a("«", new Object[0]);
        a(r5, Arrays.copyOf(r10, r10.length));
        a("\n»", new Object[0]);
    }

    public final e d() {
        return new e(f0.i(this.f15113a), f0.i(this.f15114b));
    }
}

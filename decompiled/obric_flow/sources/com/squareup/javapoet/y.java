package com.squareup.javapoet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Modifier;

/* JADX INFO: loaded from: classes3.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TypeSpec$Kind f15040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f15042c;
    public final g d;
    public x e;
    public final g f;
    public final g g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinkedHashMap f15043h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList f15044i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList f15045j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f15046k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList f15047l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList f15048m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayList f15049n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList f15050o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ArrayList f15051p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final LinkedHashSet f15052q;

    public y(TypeSpec$Kind r5, String r10, i r11) {
        this.d = i.a();
        this.e = e.B;
        this.f = i.a();
        this.g = i.a();
        this.f15043h = new LinkedHashMap();
        this.f15044i = new ArrayList();
        this.f15045j = new ArrayList();
        this.f15046k = new ArrayList();
        this.f15047l = new ArrayList();
        this.f15048m = new ArrayList();
        this.f15049n = new ArrayList();
        this.f15050o = new ArrayList();
        this.f15051p = new ArrayList();
        this.f15052q = new LinkedHashSet();
        if (r10 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        com.bytedance.android.anniex.base.service.f.r(r12, "not a valid name: %s", new Object[]{r10});
        this.f15040a = r5;
        this.f15041b = r10;
        this.f15042c = r11;
        return;
    L5:
        if (SourceVersion.isName(r10) == true) goto L8;
        r12 = false;
        goto L9
    }

    public final void a(m r5) {
        this.f15048m.add(r5);
    }

    public final void b(t r5) {
        this.f15049n.add(r5);
    }

    public final void c(Modifier... r5) {
        Collections.addAll(this.f15045j, r5);
    }

    public final void d(x r5) {
        if (r5 == null) goto L5;
        boolean r10 = true;
    L6:
        com.bytedance.android.anniex.base.service.f.r(r10, "superinterface == null", new Object[0]);
        this.f15047l.add(r5);
        return;
    L5:
        r10 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final z e() {
        Iterator r5 = this.f15044i.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        com.bytedance.android.anniex.base.service.f.s((b) r5.next(), "annotationSpec == null", new Object[0]);
        goto L4
    L6:
        boolean r10 = true;
        if (this.f15045j.isEmpty() == true) goto L21;
        if (this.f15042c != null) goto L11;
        boolean r11 = true;
    L12:
        com.bytedance.android.anniex.base.service.f.t(r11, "forbidden on anonymous types.", new Object[0]);
        Iterator r12 = this.f15045j.iterator();
    L14:
        if (r12.hasNext() == false) goto L21;
        if (((Modifier) r12.next()) == null) goto L18;
        boolean r13 = true;
    L19:
        com.bytedance.android.anniex.base.service.f.r(r13, "modifiers contain null", new Object[0]);
        goto L14
    L18:
        r13 = false;
        goto L19
    L11:
        r11 = false;
    L21:
        if (this.f15040a == TypeSpec$Kind.ENUM) goto L23;
    L26:
        boolean r14 = true;
    L27:
        com.bytedance.android.anniex.base.service.f.r(r14, "at least one enum constant is required for %s", new Object[]{this.f15041b});
        Iterator r15 = this.f15047l.iterator();
    L29:
        if (r15.hasNext() == false) goto L36;
        if (((x) r15.next()) == null) goto L33;
        boolean r16 = true;
    L34:
        com.bytedance.android.anniex.base.service.f.r(r16, "superinterfaces contains null", new Object[0]);
        goto L29
    L33:
        r16 = false;
        goto L34
    L36:
        if (this.f15046k.isEmpty() == false) goto L38;
    L49:
        Iterator r17 = this.f15043h.entrySet().iterator();
    L51:
        if (r17.hasNext() == false) goto L61;
        Map.Entry r18 = (Map.Entry) r17.next();
        if (this.f15040a != TypeSpec$Kind.ENUM) goto L55;
        boolean r19 = true;
    L56:
        com.bytedance.android.anniex.base.service.f.t(r19, "%s is not enum", new Object[]{this.f15041b});
        if (((z) r18.getValue()).f15055c == null) goto L59;
        boolean r20 = true;
    L60:
        com.bytedance.android.anniex.base.service.f.r(r20, "enum constants must have anonymous type arguments", new Object[0]);
        com.bytedance.android.anniex.base.service.f.r(SourceVersion.isName(this.f15041b), "not a valid enum constant: %s", new Object[]{this.f15041b});
        goto L51
    L59:
        r20 = false;
        goto L60
    L55:
        r19 = false;
        goto L56
    L61:
        Iterator r21 = this.f15048m.iterator();
    L63:
        if (r21.hasNext() == false) goto L69;
        m r22 = (m) r21.next();
        TypeSpec$Kind r23 = this.f15040a;
        if (r23 == TypeSpec$Kind.INTERFACE) goto L68;
        if (r23 != TypeSpec$Kind.ANNOTATION) goto L63;
    L68:
        com.bytedance.android.anniex.base.service.f.A(r22.e, new Modifier[]{Modifier.PUBLIC, Modifier.PRIVATE});
        EnumSet r24 = EnumSet.of(Modifier.STATIC, Modifier.FINAL);
        com.bytedance.android.anniex.base.service.f.t(r22.e.containsAll(r24), "%s %s.%s requires modifiers %s", new Object[]{this.f15040a, this.f15041b, r22.f14992b, r24});
        goto L63
    L69:
        Iterator r25 = this.f15049n.iterator();
    L71:
        if (r25.hasNext() == false) goto L88;
        t r26 = (t) r25.next();
        TypeSpec$Kind r27 = this.f15040a;
        TypeSpec$Kind r28 = TypeSpec$Kind.INTERFACE;
        if (r27 != r28) goto L76;
        com.bytedance.android.anniex.base.service.f.A(r26.d, new Modifier[]{Modifier.ABSTRACT, Modifier.STATIC, Modifier.DEFAULT});
        com.bytedance.android.anniex.base.service.f.A(r26.d, new Modifier[]{Modifier.PUBLIC, Modifier.PRIVATE});
    L78:
        TypeSpec$Kind r29 = this.f15040a;
        if (r29 == TypeSpec$Kind.ANNOTATION) goto L86;
        if (r26.f15016k != null) goto L83;
        boolean r30 = true;
    L84:
        com.bytedance.android.anniex.base.service.f.t(r30, "%s %s.%s cannot have a default value", new Object[]{r29, this.f15041b, r26.f15010a});
        goto L86
    L83:
        r30 = false;
    L86:
        if (this.f15040a == r28) goto L71;
        com.bytedance.android.anniex.base.service.f.t(!r26.c(Modifier.DEFAULT), "%s %s.%s cannot be default", new Object[]{this.f15040a, this.f15041b, r26.f15010a});
        goto L71
    L76:
        if (r27 != TypeSpec$Kind.ANNOTATION) goto L78;
        boolean r31 = r26.d.equals(TypeSpec$Kind.access$1000(r27));
        TypeSpec$Kind r32 = this.f15040a;
        com.bytedance.android.anniex.base.service.f.t(r31, "%s %s.%s requires modifiers %s", new Object[]{r32, this.f15041b, r26.f15010a, TypeSpec$Kind.access$1000(r32)});
        goto L78
    L88:
        Iterator r33 = this.f15050o.iterator();
    L90:
        if (r33.hasNext() == false) goto L93;
        z r34 = (z) r33.next();
        boolean r35 = r34.f.containsAll(TypeSpec$Kind.access$1100(this.f15040a));
        TypeSpec$Kind r36 = this.f15040a;
        com.bytedance.android.anniex.base.service.f.r(r35, "%s %s.%s requires modifiers %s", new Object[]{r36, this.f15041b, r34.f15054b, TypeSpec$Kind.access$1100(r36)});
        goto L90
    L93:
        if (this.f15045j.contains(Modifier.ABSTRACT) == false) goto L95;
    L98:
        Object[] r37 = true;
    L99:
        Iterator r38 = this.f15049n.iterator();
    L101:
        if (r38.hasNext() == false) goto L110;
        t r39 = (t) r38.next();
        if (r37 == false) goto L105;
    L108:
        boolean r40 = true;
    L109:
        com.bytedance.android.anniex.base.service.f.r(r40, "non-abstract type %s cannot declare abstract method %s", new Object[]{this.f15041b, r39.f15010a});
        goto L101
    L105:
        if (r39.c(Modifier.ABSTRACT) == false) goto L108;
        r40 = false;
        goto L109
    L110:
        int r41 = this.f15047l.size() + (!this.e.equals(e.B) ? 1 : 0);
        if (this.f15042c == null) goto L115;
        if (r41 <= 1) goto L115;
        r10 = false;
    L115:
        com.bytedance.android.anniex.base.service.f.r(r10, "anonymous type has too many supertypes", new Object[0]);
        return new z(this);
    L95:
        if (this.f15040a != TypeSpec$Kind.CLASS) goto L98;
        r37 = false;
        goto L99
    L38:
        if (this.f15042c != null) goto L40;
        boolean r42 = true;
    L41:
        com.bytedance.android.anniex.base.service.f.t(r42, "typevariables are forbidden on anonymous types.", new Object[0]);
        Iterator r43 = this.f15046k.iterator();
    L43:
        if (r43.hasNext() == false) goto L49;
        if (((a0) r43.next()) == null) goto L47;
        boolean r44 = true;
    L48:
        com.bytedance.android.anniex.base.service.f.r(r44, "typeVariables contain null", new Object[0]);
        goto L43
    L47:
        r44 = false;
        goto L48
    L40:
        r42 = false;
        goto L41
    L23:
        if (this.f15043h.isEmpty() == false) goto L26;
        r14 = false;
        goto L27
    }

    public final void f(x r10) {
        TypeSpec$Kind r5 = TypeSpec$Kind.CLASS;
        TypeSpec$Kind r11 = this.f15040a;
        if (r11 != r5) goto L5;
        boolean r12 = true;
    L6:
        com.bytedance.android.anniex.base.service.f.t(r12, "only classes have super classes, not " + r11, new Object[0]);
        if (this.e != e.B) goto L9;
        boolean r13 = true;
    L10:
        com.bytedance.android.anniex.base.service.f.t(r13, "superclass already set to " + this.e, new Object[0]);
        com.bytedance.android.anniex.base.service.f.r(r10.k() ^ true, "superclass may not be a primitive", new Object[0]);
        this.e = r10;
        return;
    L9:
        r13 = false;
        goto L10
    L5:
        r12 = false;
        goto L6
    }
}

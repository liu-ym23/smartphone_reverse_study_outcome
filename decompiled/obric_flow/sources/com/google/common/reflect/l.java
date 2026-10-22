package com.google.common.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Constructor f9365c;
    public final /* synthetic */ TypeToken d;

    public l(TypeToken r5, Constructor r10) {
        this.d = r5;
        super(r10);
        this.f9365c = r10;
    }

    @Override // com.google.common.reflect.a
    public final TypeToken a() {
        return this.d;
    }

    public final String toString() {
        TypeToken r5 = this.d;
        String r10 = String.valueOf(r5);
        com.google.common.base.u r11 = new com.google.common.base.u(", ", 0);
        j r12 = TypeToken.access$100(r5);
        Constructor r13 = this.f9365c;
        Type[] r14 = r13.getGenericParameterTypes();
        int r15 = 0;
        if (r14.length <= 0) goto L22;
        Class r16 = r13.getDeclaringClass();
        if (r16.getEnclosingConstructor() == null) goto L7;
    L6:
        boolean r17 = true;
    L16:
        if (r17 == false) goto L22;
        Class<?>[] r18 = r13.getParameterTypes();
        if (r14.length != r18.length) goto L22;
        if (r18[0] != this.f9355b.getDeclaringClass().getEnclosingClass()) goto L22;
        r14 = (Type[]) Arrays.copyOfRange(r14, 1, r14.length);
        goto L22
    L7:
        Method r19 = r16.getEnclosingMethod();
        if (r19 == null) goto L11;
        r17 = !Modifier.isStatic(r19.getModifiers());
        goto L16
    L11:
        if (r16.getEnclosingClass() != null) goto L13;
    L15:
        r17 = false;
        goto L16
    L13:
        if (Modifier.isStatic(r16.getModifiers()) == true) goto L15;
    L22:
        r12.getClass();
    L24:
        if (r15 >= r14.length) goto L26;
        r14[r15] = r12.b(r14[r15]);
        r15 = r15 + 1;
        goto L24
    L26:
        String r20 = r11.a(Arrays.asList(r14));
        StringBuilder r21 = new StringBuilder(androidx.room.jarjarred.org.antlr.runtime.a.g(r10.length() + 2, r20));
        r21.append(r10);
        r21.append("(");
        r21.append(r20);
        r21.append(")");
        return r21.toString();
    }
}

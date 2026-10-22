package com.google.common.reflect;

import com.google.common.base.b0;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends um.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ HashMap f9356c;
    public final /* synthetic */ Type d;

    public d(HashMap r5, Type r10) {
        this.f9356c = r5;
        this.d = r10;
        super(4);
    }

    @Override // um.a
    public final void A(Class r5) {
        Type r10 = this.d;
        if ((r10 instanceof WildcardType) == false) goto L5;
        return;
    L5:
        String r11 = String.valueOf(r5);
        String r12 = String.valueOf(r10);
        int r13 = r11.length() + 25;
        StringBuilder r14 = new StringBuilder(r12.length() + r13);
        r14.append("No type mapping from ");
        r14.append(r11);
        r14.append(" to ");
        r14.append(r12);
        throw new IllegalArgumentException(r14.toString());
    }

    @Override // um.a
    public final void B(GenericArrayType r5) {
        Type r10 = this.d;
        if ((r10 instanceof WildcardType) == false) goto L5;
        return;
    L5:
        Type r11 = y.c(r10);
        if (r11 == null) goto L8;
        boolean r12 = true;
    L9:
        b0.h("%s is not an array type.", r12, r10);
        Type r13 = r5.getGenericComponentType();
        j.a(this.f9356c, r13, r11);
        return;
    L8:
        r12 = false;
        goto L9
    }

    @Override // um.a
    public final void C(ParameterizedType r10) {
        Type r5 = this.d;
        if ((r5 instanceof WildcardType) == false) goto L23;
        return;
    L23:
        ParameterizedType r11 = (ParameterizedType) ParameterizedType.class.cast(r5);
        Type r12 = r10.getOwnerType();
        HashMap r13 = this.f9356c;
        if (r12 != null) goto L10;
    L12:
        b0.k(r10.getRawType().equals(r11.getRawType()), "Inconsistent raw type: %s vs. %s", r10, r5);
        Type[] r14 = r10.getActualTypeArguments();
        Type[] r15 = r11.getActualTypeArguments();
        int r16 = 0;
        if (r14.length != r15.length) goto L15;
        boolean r17 = true;
    L16:
        b0.k(r17, "%s not compatible with %s", r10, r11);
    L18:
        if (r16 >= r14.length) goto L20;
        j.a(r13, r14[r16], r15[r16]);
        r16 = r16 + 1;
        goto L18
    L20:
        return;
    L15:
        r17 = false;
        goto L16
    L10:
        if (r11.getOwnerType() == null) goto L12;
        j.a(r13, r10.getOwnerType(), r11.getOwnerType());
    L21:
        String r18 = String.valueOf(r5);
        throw new IllegalArgumentException(androidx.room.jarjarred.org.antlr.runtime.a.l(r18.length() + 27, r18, " is not a ParameterizedType"));
    }

    @Override // um.a
    public final void D(TypeVariable r5) {
        g r10 = new g(r5);
        this.f9356c.put(r10, this.d);
    }

    @Override // um.a
    public final void E(WildcardType r10) {
        Type r5 = this.d;
        if ((r5 instanceof WildcardType) == true) goto L5;
        return;
    L5:
        WildcardType r11 = (WildcardType) r5;
        Type[] r12 = r10.getUpperBounds();
        Type[] r13 = r11.getUpperBounds();
        Type[] r14 = r10.getLowerBounds();
        Type[] r15 = r11.getLowerBounds();
        int r16 = 0;
        if (r12.length == r13.length) goto L8;
    L10:
        boolean r17 = false;
    L11:
        b0.k(r17, "Incompatible type: %s vs. %s", r10, r5);
        int r18 = 0;
    L12:
        int r19 = r12.length;
        HashMap r20 = this.f9356c;
        if (r18 >= r19) goto L16;
        j.a(r20, r12[r18], r13[r18]);
        r18 = r18 + 1;
    L16:
        if (r16 >= r14.length) goto L18;
        j.a(r20, r14[r16], r15[r16]);
        r16 = r16 + 1;
        goto L16
    L18:
        return;
    L8:
        if (r14.length != r15.length) goto L10;
        r17 = true;
        goto L11
    }
}

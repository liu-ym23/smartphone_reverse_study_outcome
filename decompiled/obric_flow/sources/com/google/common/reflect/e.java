package com.google.common.reflect;

import com.google.common.base.b0;
import com.google.common.collect.n4;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends um.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9357c;
    public final Object d;

    public /* synthetic */ e(Object r5, int r10) {
        this.f9357c = r10;
        this.d = r5;
        super(4);
    }

    @Override // um.a
    public void A(Class r5) {
        switch(this.f9357c) {
            case 0: goto L7;
            case 1: goto L4;
            case 2: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        ((n4) this.d).B0(r5);
        return;
    L7:
        z(new Type[]{r5.getGenericSuperclass()});
        z(r5.getGenericInterfaces());
    }

    @Override // um.a
    public void B(GenericArrayType r5) {
        switch(this.f9357c) {
            case 1: goto L7;
            case 2: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        Class<? super Object> r10 = TypeToken.of(r5.getGenericComponentType()).getRawType();
        com.google.common.base.t r11 = y.f9380a;
        ((n4) this.d).B0(Array.newInstance(r10, 0).getClass());
        return;
    L7:
        z(new Type[]{r5.getGenericComponentType()});
    }

    @Override // um.a
    public final void C(ParameterizedType r15) {
        Object r5 = this.d;
        switch(this.f9357c) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        ((n4) r5).B0((Class) r15.getRawType());
        return;
    L6:
        z(r15.getActualTypeArguments());
        z(new Type[]{r15.getOwnerType()});
        return;
    L8:
        Class r10 = (Class) r15.getRawType();
        TypeVariable[] r11 = r10.getTypeParameters();
        Type[] r12 = r15.getActualTypeArguments();
        if (r11.length != r12.length) goto L11;
        boolean r13 = true;
    L12:
        b0.t(r13);
        int r14 = 0;
    L14:
        if (r14 >= r11.length) goto L37;
        g r16 = new g(r11[r14]);
        Type r17 = r12[r14];
        HashMap r18 = (HashMap) r5;
        if (r18.containsKey(r16) == true) goto L36;
        Type r19 = r17;
    L19:
        if (r19 == null) goto L35;
        boolean r110 = r19 instanceof TypeVariable;
        if (r110 == false) goto L23;
        boolean r111 = r16.a((TypeVariable) r19);
    L24:
        g r112 = null;
        if (r111 == true) goto L26;
        if (r110 == false) goto L34;
        r112 = new g((TypeVariable) r19);
    L34:
        r19 = (Type) r18.get(r112);
    L26:
        if (r17 == null) goto L36;
        if ((r17 instanceof TypeVariable) == false) goto L30;
        g r20 = new g((TypeVariable) r17);
    L31:
        r17 = (Type) r18.remove(r20);
        goto L26
    L30:
        r20 = null;
        goto L31
    L23:
        r111 = false;
        goto L24
    L35:
        r18.put(r16, r17);
    L36:
        r14 = r14 + 1;
        goto L14
    L37:
        z(new Type[]{r10});
        z(new Type[]{r15.getOwnerType()});
        return;
    L11:
        r13 = false;
        goto L12
    }

    @Override // um.a
    public final void D(TypeVariable r5) {
        switch(this.f9357c) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        z(r5.getBounds());
        return;
    L6:
        String r10 = String.valueOf(TypeToken.access$500((TypeToken) this.d));
        throw new IllegalArgumentException(androidx.room.jarjarred.org.antlr.runtime.a.l(r10.length() + 58, r10, "contains a type variable and is not safe for the operation"));
    L8:
        z(r5.getBounds());
    }

    @Override // um.a
    public final void E(WildcardType r5) {
        switch(this.f9357c) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        z(r5.getUpperBounds());
        return;
    L6:
        z(r5.getLowerBounds());
        z(r5.getUpperBounds());
        return;
    L8:
        z(r5.getUpperBounds());
    }

    public e() {
        this.f9357c = 0;
        super(4);
        this.d = new HashMap();
    }
}

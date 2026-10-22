package ai;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class u0 implements ParameterizedType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Type f299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Type[] f300c;

    public u0(Type r5, Type r10, Type... r11) {
        int r12 = 0;
        if ((r10 instanceof Class) == false) goto L16;
        boolean r13 = true;
        if (r5 != null) goto L7;
        boolean r14 = true;
    L9:
        if (((Class) r10).getEnclosingClass() == null) goto L12;
        r13 = false;
    L12:
        if (r14 == r13) goto L16;
        throw new IllegalArgumentException();
    L7:
        r14 = false;
    L16:
        this.f298a = r5;
        this.f299b = r10;
        Type[] r15 = (Type[]) r11.clone();
        this.f300c = r15;
        int r16 = r15.length;
    L17:
        if (r12 >= r16) goto L19;
        Type r17 = r15[r12];
        r17.getClass();
        w0.c(r17);
        r12 = r12 + 1;
        goto L17
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof ParameterizedType) == true) goto L5;
    L7:
        return false;
    L5:
        if (w0.d(this, (ParameterizedType) r5) == false) goto L7;
        return true;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type[] getActualTypeArguments() {
        return (Type[]) this.f300c.clone();
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getOwnerType() {
        return this.f298a;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getRawType() {
        return this.f299b;
    }

    public final int hashCode() {
        int r5 = Arrays.hashCode(this.f300c) ^ this.f299b.hashCode();
        Type r10 = this.f298a;
        if (r10 == null) goto L5;
        int r11 = r10.hashCode();
    L7:
        return r11 ^ r5;
    L5:
        r11 = 0;
        goto L7
    }

    public final String toString() {
        Type[] r5 = this.f300c;
        int r10 = 1;
        StringBuilder r11 = new StringBuilder((r5.length + 1) * 30);
        r11.append(w0.k(this.f299b));
        if (r5.length == 0) goto L5;
        r11.append("<");
        r11.append(w0.k(r5[0]));
    L8:
        if (r10 >= r5.length) goto L10;
        r11.append(", ");
        r11.append(w0.k(r5[r10]));
        r10 = r10 + 1;
        goto L8
    L10:
        r11.append(">");
        return r11.toString();
    L5:
        return r11.toString();
    }
}

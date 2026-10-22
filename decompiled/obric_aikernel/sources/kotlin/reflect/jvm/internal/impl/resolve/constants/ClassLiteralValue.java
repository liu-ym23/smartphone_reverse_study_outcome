package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* JADX INFO: loaded from: classes3.dex */
public final class ClassLiteralValue {
    private final int arrayNestedness;
    private final ClassId classId;

    public ClassLiteralValue(ClassId r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "classId");
        this.classId = r10;
        this.arrayNestedness = r11;
    }

    public final ClassId component1() {
        return this.classId;
    }

    public final int component2() {
        return this.arrayNestedness;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ClassLiteralValue) == true) goto L8;
        return false;
    L8:
        ClassLiteralValue r11 = (ClassLiteralValue) r10;
        if (Intrinsics.areEqual(this.classId, r11.classId) == true) goto L12;
        return false;
    L12:
        if (this.arrayNestedness == r11.arrayNestedness) goto L14;
        return false;
    L14:
        return true;
    }

    public final int getArrayNestedness() {
        return this.arrayNestedness;
    }

    public final ClassId getClassId() {
        return this.classId;
    }

    public int hashCode() {
        return (this.classId.hashCode() * 31) + this.arrayNestedness;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        int r11 = this.arrayNestedness;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L5;
        r10.append("kotlin/Array<");
        r13 = r13 + 1;
        goto L3
    L5:
        r10.append(this.classId);
        int r14 = this.arrayNestedness;
    L6:
        if (r12 >= r14) goto L8;
        r10.append(">");
        r12 = r12 + 1;
        goto L6
    L8:
        String r15 = r10.toString();
        Intrinsics.checkNotNullExpressionValue(r15, "StringBuilder().apply(builderAction).toString()");
        return r15;
    }
}

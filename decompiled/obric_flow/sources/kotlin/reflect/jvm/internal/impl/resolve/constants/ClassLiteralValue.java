package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nClassLiteralValue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassLiteralValue.kt\norg/jetbrains/kotlin/resolve/constants/ClassLiteralValue\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,17:1\n1#2:18\n*E\n"})
public final class ClassLiteralValue {
    private final int arrayNestedness;
    private final ClassId classId;

    public ClassLiteralValue(ClassId r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "classId");
        this.classId = r5;
        this.arrayNestedness = r10;
    }

    public final ClassId component1() {
        return this.classId;
    }

    public final int component2() {
        return this.arrayNestedness;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ClassLiteralValue) == true) goto L8;
        return false;
    L8:
        ClassLiteralValue r10 = (ClassLiteralValue) r5;
        if (Intrinsics.areEqual(this.classId, r10.classId) == true) goto L12;
        return false;
    L12:
        if (this.arrayNestedness == r10.arrayNestedness) goto L14;
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
        int r5 = this.classId.hashCode() * 31;
        return Integer.hashCode(this.arrayNestedness) + r5;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder();
        int r10 = this.arrayNestedness;
        int r11 = 0;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L5;
        r5.append("kotlin/Array<");
        r12 = r12 + 1;
        goto L3
    L5:
        r5.append(this.classId);
        int r13 = this.arrayNestedness;
    L6:
        if (r11 >= r13) goto L9;
        r5.append(">");
        r11 = r11 + 1;
        goto L6
    L9:
        return r5.toString();
    }
}

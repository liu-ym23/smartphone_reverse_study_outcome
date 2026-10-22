package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import androidx.constraintlayout.motion.widget.a;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* JADX INFO: loaded from: classes3.dex */
public final class IncompatibleVersionErrorData<T> {
    private final T actualVersion;
    private final ClassId classId;
    private final T compilerVersion;
    private final T expectedVersion;
    private final String filePath;
    private final T languageVersion;

    public IncompatibleVersionErrorData(T r5, T r10, T r11, T r12, String r13, ClassId r14) {
        Intrinsics.checkNotNullParameter(r13, "filePath");
        Intrinsics.checkNotNullParameter(r14, "classId");
        this.actualVersion = r5;
        this.compilerVersion = r10;
        this.languageVersion = r11;
        this.expectedVersion = r12;
        this.filePath = r13;
        this.classId = r14;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IncompatibleVersionErrorData) == true) goto L8;
        return false;
    L8:
        IncompatibleVersionErrorData r10 = (IncompatibleVersionErrorData) r5;
        if (Intrinsics.areEqual(this.actualVersion, r10.actualVersion) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.compilerVersion, r10.compilerVersion) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.languageVersion, r10.languageVersion) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.expectedVersion, r10.expectedVersion) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.filePath, r10.filePath) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.classId, r10.classId) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        T r5 = this.actualVersion;
        int r10 = 0;
        if (r5 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        T r13 = this.compilerVersion;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        T r16 = this.languageVersion;
        if (r16 != null) goto L13;
        int r17 = 0;
    L14:
        int r18 = (r15 + r17) * 31;
        T r19 = this.expectedVersion;
        if (r19 == null) goto L19;
        r10 = r19.hashCode();
    L19:
        return this.classId.hashCode() + a.c((r18 + r10) * 31, 31, this.filePath);
    L13:
        r17 = r16.hashCode();
        goto L14
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r5.hashCode();
        goto L6
    }

    public String toString() {
        return "IncompatibleVersionErrorData(actualVersion=" + this.actualVersion + ", compilerVersion=" + this.compilerVersion + ", languageVersion=" + this.languageVersion + ", expectedVersion=" + this.expectedVersion + ", filePath=" + this.filePath + ", classId=" + this.classId + ')';
    }
}

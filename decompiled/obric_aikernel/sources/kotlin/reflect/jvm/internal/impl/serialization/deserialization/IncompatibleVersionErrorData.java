package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* JADX INFO: loaded from: classes3.dex */
public final class IncompatibleVersionErrorData<T> {
    private final T actualVersion;
    private final ClassId classId;
    private final T expectedVersion;
    private final String filePath;

    public IncompatibleVersionErrorData(T r10, T r11, String r12, ClassId r13) {
        Intrinsics.checkNotNullParameter(r12, "filePath");
        Intrinsics.checkNotNullParameter(r13, "classId");
        this.actualVersion = r10;
        this.expectedVersion = r11;
        this.filePath = r12;
        this.classId = r13;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof IncompatibleVersionErrorData) == true) goto L8;
        return false;
    L8:
        IncompatibleVersionErrorData r11 = (IncompatibleVersionErrorData) r10;
        if (Intrinsics.areEqual(this.actualVersion, r11.actualVersion) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.expectedVersion, r11.expectedVersion) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.filePath, r11.filePath) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.classId, r11.classId) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        T r10 = this.actualVersion;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        T r14 = this.expectedVersion;
        if (r14 == null) goto L11;
        r11 = r14.hashCode();
    L11:
        return ((((r13 + r11) * 31) + this.filePath.hashCode()) * 31) + this.classId.hashCode();
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public String toString() {
        return "IncompatibleVersionErrorData(actualVersion=" + this.actualVersion + ", expectedVersion=" + this.expectedVersion + ", filePath=" + this.filePath + ", classId=" + this.classId + ')';
    }
}

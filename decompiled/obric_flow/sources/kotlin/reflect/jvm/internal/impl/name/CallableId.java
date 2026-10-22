package kotlin.reflect.jvm.internal.impl.name;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class CallableId {
    private static final Companion Companion = null;
    private static final Name LOCAL_NAME = null;
    private static final FqName PACKAGE_FQ_NAME_FOR_LOCAL = null;
    private final Name callableName;
    private final FqName className;
    private final FqName packageName;
    private final FqName pathToLocal;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        Name r5 = SpecialNames.LOCAL;
        LOCAL_NAME = r5;
        PACKAGE_FQ_NAME_FOR_LOCAL = FqName.topLevel(r5);
    }

    public CallableId(FqName r5, FqName r10, Name r11, FqName r12) {
        Intrinsics.checkNotNullParameter(r5, "packageName");
        Intrinsics.checkNotNullParameter(r11, "callableName");
        this.packageName = r5;
        this.className = r10;
        this.callableName = r11;
        this.pathToLocal = r12;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CallableId) == true) goto L8;
        return false;
    L8:
        CallableId r10 = (CallableId) r5;
        if (Intrinsics.areEqual(this.packageName, r10.packageName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.className, r10.className) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.callableName, r10.callableName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.pathToLocal, r10.pathToLocal) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r5 = this.packageName.hashCode() * 31;
        FqName r10 = this.className;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = (this.callableName.hashCode() + ((r5 + r12) * 31)) * 31;
        FqName r14 = this.pathToLocal;
        if (r14 == null) goto L11;
        r11 = r14.hashCode();
    L11:
        return r13 + r11;
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder();
        r5.append(StringsKt.E(this.packageName.asString(), '.', '/'));
        r5.append("/");
        FqName r10 = this.className;
        if (r10 == null) goto L5;
        r5.append(r10);
        r5.append(".");
    L5:
        r5.append(this.callableName);
        return r5.toString();
    }

    public /* synthetic */ CallableId(FqName r5, FqName r10, Name r11, FqName r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 8) == 0) goto L5;
        r12 = null;
    L5:
        this(r5, r10, r11, r12);
    }

    public CallableId(FqName r10, Name r11) {
        Intrinsics.checkNotNullParameter(r10, "packageName");
        Intrinsics.checkNotNullParameter(r11, "callableName");
        FqName r5 = null;
        FqName r12 = null;
        this(r10, r5, r11, r12, 8, null);
    }
}

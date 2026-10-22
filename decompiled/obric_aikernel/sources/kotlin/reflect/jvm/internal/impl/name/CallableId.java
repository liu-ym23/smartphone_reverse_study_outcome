package kotlin.reflect.jvm.internal.impl.name;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class CallableId {
    private static final Companion Companion = null;

    @Deprecated
    private static final Name LOCAL_NAME = null;

    @Deprecated
    private static final FqName PACKAGE_FQ_NAME_FOR_LOCAL = null;
    private final Name callableName;
    private final FqName className;
    private final FqName packageName;
    private final FqName pathToLocal;

    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        Name r10 = SpecialNames.LOCAL;
        LOCAL_NAME = r10;
        FqName r11 = FqName.topLevel(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "topLevel(LOCAL_NAME)");
        PACKAGE_FQ_NAME_FOR_LOCAL = r11;
    }

    public CallableId(FqName r10, FqName r11, Name r12, FqName r13) {
        Intrinsics.checkNotNullParameter(r10, "packageName");
        Intrinsics.checkNotNullParameter(r12, "callableName");
        this.packageName = r10;
        this.className = r11;
        this.callableName = r12;
        this.pathToLocal = r13;
    }

    public /* synthetic */ CallableId(FqName r10, FqName r11, Name r12, FqName r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 8) == 0) goto L5;
        r13 = null;
    L5:
        this(r10, r11, r12, r13);
    }

    public CallableId(FqName r10, Name r11) {
        Intrinsics.checkNotNullParameter(r10, "packageName");
        Intrinsics.checkNotNullParameter(r11, "callableName");
        this(r10, null, r11, null, 8, null);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof CallableId) == true) goto L8;
        return false;
    L8:
        CallableId r11 = (CallableId) r10;
        if (Intrinsics.areEqual(this.packageName, r11.packageName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.className, r11.className) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.callableName, r11.callableName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.pathToLocal, r11.pathToLocal) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r10 = this.packageName.hashCode() * 31;
        FqName r11 = this.className;
        int r12 = 0;
        if (r11 != null) goto L5;
        int r13 = 0;
    L6:
        int r14 = (((r10 + r13) * 31) + this.callableName.hashCode()) * 31;
        FqName r15 = this.pathToLocal;
        if (r15 == null) goto L11;
        r12 = r15.hashCode();
    L11:
        return r14 + r12;
    L5:
        r13 = r11.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        String r11 = this.packageName.asString();
        Intrinsics.checkNotNullExpressionValue(r11, "packageName.asString()");
        r10.append(StringsKt.replace$default(r11, '.', '/', false, 4, null));
        r10.append("/");
        FqName r12 = this.className;
        if (r12 == null) goto L5;
        r10.append(r12);
        r10.append(".");
    L5:
        r10.append(this.callableName);
        String r13 = r10.toString();
        Intrinsics.checkNotNullExpressionValue(r13, "StringBuilder().apply(builderAction).toString()");
        return r13;
    }
}

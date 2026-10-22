package kotlin.reflect.jvm.internal.impl.name;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class CallableId {
    public static final Companion Companion = null;
    private static final Name LOCAL_NAME = null;
    private static final FqName PACKAGE_FQ_NAME_FOR_LOCAL = null;
    private final Name callableName;
    private final ClassId classId;
    private final FqName className;
    private final FqName packageName;
    private final FqName pathToLocal;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        Name r0 = SpecialNames.LOCAL;
        LOCAL_NAME = r0;
        PACKAGE_FQ_NAME_FOR_LOCAL = FqName.topLevel(r0);
    }

    public int hashCode() {
        int r1 = (527 + this.packageName.hashCode()) * 31;
        FqName r0 = this.className;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L7:
        return ((r1 + r2) * 31) + this.callableName.hashCode();
    L5:
        r2 = 0;
        goto L7
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(StringsKt.replace$default(this.packageName.asString(), '.', '/', false, 4, null));
        r0.append("/");
        FqName r1 = this.className;
        if (r1 == null) goto L5;
        r0.append(r1);
        r0.append(".");
    L5:
        r0.append(this.callableName);
        return r0.toString();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CallableId) == true) goto L8;
    L7:
        return false;
    L8:
        CallableId r6 = (CallableId) r5;
        if (Intrinsics.areEqual(this.packageName, r6.packageName) == false) goto L7;
        if (Intrinsics.areEqual(this.className, r6.className) == false) goto L7;
        if (Intrinsics.areEqual(this.callableName, r6.callableName) == false) goto L7;
        return true;
    }

    public CallableId(FqName r8, Name r9) {
        Intrinsics.checkNotNullParameter(r8, DBDefinition.PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r9, "callableName");
        this(r8, null, r9, null, null);
    }

    private CallableId(FqName r1, FqName r2, Name r3, ClassId r4, FqName r5) {
        this.packageName = r1;
        this.className = r2;
        this.callableName = r3;
        this.classId = r4;
        this.pathToLocal = r5;
    }
}

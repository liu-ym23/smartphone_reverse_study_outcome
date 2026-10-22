package kotlin.reflect.jvm.internal.impl.name;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ClassId {
    public static final Companion Companion = null;
    private final boolean isLocal;
    private final FqName packageFqName;
    private final FqName relativeClassName;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final ClassId topLevel(FqName r3) {
            Intrinsics.checkNotNullParameter(r3, "topLevelFqName");
            return new ClassId(r3.parent(), r3.shortName());
        }

        @JvmStatic
        public final ClassId fromString(String r9, boolean r10) {
            Intrinsics.checkNotNullParameter(r9, "string");
            int r0 = StringsKt.indexOf$default(r9, '`', 0, false, 6, null);
            if (r0 != (-1)) goto L5;
            r0 = r9.length();
        L5:
            int r1 = StringsKt.lastIndexOf$default(r9, "/", r0, false, 4, null);
            if (r1 != (-1)) goto L8;
            String r11 = StringsKt.replace$default(r9, "`", "", false, 4, null);
            String r2 = "";
        L10:
            return new ClassId(new FqName(r2), new FqName(r11), r10);
        L8:
            String r3 = StringsKt.replace$default(r9.substring(0, r1), '/', '.', false, 4, null);
            r11 = StringsKt.replace$default(r9.substring(r1 + 1), "`", "", false, 4, null);
            r2 = r3;
            goto L10
        }

        public static /* synthetic */ ClassId fromString$default(Companion r0, String r1, boolean r2, int r3, Object r4) {
            if ((r3 & 2) == 0) goto L6;
            r2 = false;
        L6:
            return r0.fromString(r1, r2);
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final ClassId topLevel(FqName r1) {
        return Companion.topLevel(r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ClassId) == true) goto L8;
        return false;
    L8:
        ClassId r6 = (ClassId) r5;
        if (Intrinsics.areEqual(this.packageFqName, r6.packageFqName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.relativeClassName, r6.relativeClassName) == true) goto L15;
        return false;
    L15:
        if (this.isLocal == r6.isLocal) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.packageFqName.hashCode() * 31) + this.relativeClassName.hashCode()) * 31;
        if (this.isLocal == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final FqName asSingleFqName() {
        if (this.packageFqName.isRoot() == false) goto L6;
        return this.relativeClassName;
    L6:
        return new FqName(this.packageFqName.asString() + '.' + this.relativeClassName.asString());
    }

    public final String asString() {
        if (this.packageFqName.isRoot() == false) goto L6;
        return asString$escapeSlashes(this.relativeClassName);
    L6:
        return StringsKt.replace$default(this.packageFqName.asString(), '.', '/', false, 4, null) + "/" + asString$escapeSlashes(this.relativeClassName);
    }

    public final ClassId getOuterClassId() {
        FqName r0 = this.relativeClassName.parent();
        if ((!r0.isRoot()) == true) goto L7;
        return null;
    L7:
        return new ClassId(this.packageFqName, r0, this.isLocal);
    }

    public final Name getShortClassName() {
        return this.relativeClassName.shortName();
    }

    public final boolean isNestedClass() {
        return !this.relativeClassName.parent().isRoot();
    }

    public String toString() {
        if (this.packageFqName.isRoot() == false) goto L6;
        return "/" + asString();
    L6:
        return asString();
    }

    public final FqName getPackageFqName() {
        return this.packageFqName;
    }

    public final FqName getRelativeClassName() {
        return this.relativeClassName;
    }

    public final boolean isLocal() {
        return this.isLocal;
    }

    private static final String asString$escapeSlashes(FqName r4) {
        String r5 = r4.asString();
        if (StringsKt.contains$default(r5, '/', false, 2, null) == true) goto L5;
        return r5;
    L5:
        return "`" + r5 + '`';
    }

    public final ClassId createNestedClassId(Name r4) {
        Intrinsics.checkNotNullParameter(r4, DBDefinition.NAME);
        return new ClassId(this.packageFqName, this.relativeClassName.child(r4), this.isLocal);
    }

    public ClassId(FqName r2, Name r3) {
        Intrinsics.checkNotNullParameter(r2, "packageFqName");
        Intrinsics.checkNotNullParameter(r3, "topLevelName");
        this(r2, FqName.topLevel(r3), false);
    }

    public ClassId(FqName r2, FqName r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "packageFqName");
        Intrinsics.checkNotNullParameter(r3, "relativeClassName");
        this.packageFqName = r2;
        this.relativeClassName = r3;
        this.isLocal = r4;
        r3.isRoot();
    }
}

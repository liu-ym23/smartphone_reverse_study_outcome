package kotlin.reflect.jvm.internal.impl.builtins.functions;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final enum FunctionClassKind extends Enum<FunctionClassKind> {
    private static final /* synthetic */ FunctionClassKind[] $VALUES = null;
    public static final Companion Companion = null;
    public static final FunctionClassKind Function = null;
    public static final FunctionClassKind KFunction = null;
    public static final FunctionClassKind KSuspendFunction = null;
    public static final FunctionClassKind SuspendFunction = null;
    private final String classNamePrefix;
    private final boolean isReflectType;
    private final boolean isSuspendType;
    private final FqName packageFqName;

    public static final class Companion {

        public static final class KindWithArity {
            private final int arity;
            private final FunctionClassKind kind;

            public KindWithArity(FunctionClassKind r10, int r11) {
                Intrinsics.checkNotNullParameter(r10, "kind");
                this.kind = r10;
                this.arity = r11;
            }

            public final FunctionClassKind component1() {
                return this.kind;
            }

            public final int component2() {
                return this.arity;
            }

            public boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof KindWithArity) == true) goto L8;
                return false;
            L8:
                KindWithArity r11 = (KindWithArity) r10;
                if (this.kind == r11.kind) goto L12;
                return false;
            L12:
                if (this.arity == r11.arity) goto L14;
                return false;
            L14:
                return true;
            }

            public final FunctionClassKind getKind() {
                return this.kind;
            }

            public int hashCode() {
                return (this.kind.hashCode() * 31) + this.arity;
            }

            public String toString() {
                return "KindWithArity(kind=" + this.kind + ", arity=" + this.arity + ')';
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        private final Integer toInt(String r10) {
            if (r10.length() != 0) goto L5;
            boolean r11 = true;
        L7:
            if (r11 == false) goto L9;
            return null;
        L9:
            int r12 = r10.length();
            int r13 = 0;
            int r14 = 0;
        L10:
            if (r13 >= r12) goto L21;
            int r15 = r10.charAt(r13) - '0';
            if (r15 >= 0) goto L14;
        L16:
            boolean r16 = false;
        L17:
            if (r16 == false) goto L18;
            r14 = (r14 * 10) + r15;
            r13 = r13 + 1;
            goto L10
        L18:
            return null;
        L14:
            if (r15 >= 10) goto L16;
            r16 = true;
            goto L17
        L21:
            return Integer.valueOf(r14);
        L5:
            r11 = false;
            goto L7
        }

        public final FunctionClassKind byClassNamePrefix(FqName r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "packageFqName");
            Intrinsics.checkNotNullParameter(r11, "className");
            FunctionClassKind[] r12 = FunctionClassKind.values();
            int r13 = r12.length;
            int r14 = 0;
        L4:
            if (r14 >= r13) goto L17;
            FunctionClassKind r15 = r12[r14];
            if (Intrinsics.areEqual(r15.getPackageFqName(), r10) == true) goto L8;
        L10:
            boolean r16 = false;
        L11:
            if (r16 == true) goto L14;
            r14 = r14 + 1;
            goto L4
        L14:
            return r15;
        L8:
            if (StringsKt.startsWith$default(r11, r15.getClassNamePrefix(), false, 2, null) == false) goto L10;
            r16 = true;
            goto L11
        L17:
            return null;
        }

        @JvmStatic
        public final FunctionClassKind getFunctionalClassKind(String r10, FqName r11) {
            Intrinsics.checkNotNullParameter(r10, "className");
            Intrinsics.checkNotNullParameter(r11, "packageFqName");
            KindWithArity r12 = parseClassName(r10, r11);
            if (r12 != null) goto L7;
            return null;
        L7:
            return r12.getKind();
        }

        public final KindWithArity parseClassName(String r10, FqName r11) {
            Intrinsics.checkNotNullParameter(r10, "className");
            Intrinsics.checkNotNullParameter(r11, "packageFqName");
            FunctionClassKind r12 = byClassNamePrefix(r11, r10);
            if (r12 != null) goto L5;
            return null;
        L5:
            String r13 = r10.substring(r12.getClassNamePrefix().length());
            Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String).substring(startIndex)");
            Integer r14 = toInt(r13);
            if (r14 != null) goto L8;
            return null;
        L8:
            return new KindWithArity(r12, r14.intValue());
        }
    }

    private static final /* synthetic */ FunctionClassKind[] $values() {
        return new FunctionClassKind[]{Function, SuspendFunction, KFunction, KSuspendFunction};
    }

    static {
        Function = new FunctionClassKind("Function", 0, StandardNames.BUILT_INS_PACKAGE_FQ_NAME, "Function", false, false);
        SuspendFunction = new FunctionClassKind("SuspendFunction", 1, StandardNames.COROUTINES_PACKAGE_FQ_NAME, "SuspendFunction", true, false);
        FqName r10 = StandardNames.KOTLIN_REFLECT_FQ_NAME;
        KFunction = new FunctionClassKind("KFunction", 2, r10, "KFunction", false, true);
        KSuspendFunction = new FunctionClassKind("KSuspendFunction", 3, r10, "KSuspendFunction", true, true);
        $VALUES = $values();
        Companion = new Companion(null);
    }

    private FunctionClassKind(String r10, int r11, FqName r12, String r13, boolean r14, boolean r15) {
        super(r10, r11);
        this.packageFqName = r12;
        this.classNamePrefix = r13;
        this.isSuspendType = r14;
        this.isReflectType = r15;
    }

    public static FunctionClassKind valueOf(String r10) {
        return (FunctionClassKind) Enum.valueOf(FunctionClassKind.class, r10);
    }

    public static FunctionClassKind[] values() {
        return (FunctionClassKind[]) $VALUES.clone();
    }

    public final String getClassNamePrefix() {
        return this.classNamePrefix;
    }

    public final FqName getPackageFqName() {
        return this.packageFqName;
    }

    public final Name numberedClassName(int r10) {
        Name r11 = Name.identifier(this.classNamePrefix + r10);
        Intrinsics.checkNotNullExpressionValue(r11, "identifier(\"$classNamePrefix$arity\")");
        return r11;
    }
}

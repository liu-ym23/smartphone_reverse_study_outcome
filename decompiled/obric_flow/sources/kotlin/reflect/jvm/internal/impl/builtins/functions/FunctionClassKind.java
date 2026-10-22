package kotlin.reflect.jvm.internal.impl.builtins.functions;

import ai.j0;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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

    @SourceDebugExtension({"SMAP\nFunctionClassKind.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FunctionClassKind.kt\norg/jetbrains/kotlin/builtins/functions/FunctionClassKind$Companion\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,59:1\n1282#2,2:60\n*S KotlinDebug\n*F\n+ 1 FunctionClassKind.kt\norg/jetbrains/kotlin/builtins/functions/FunctionClassKind$Companion\n*L\n27#1:60,2\n*E\n"})
    public static final class Companion {

        public static final class KindWithArity {
            private final int arity;
            private final FunctionClassKind kind;

            public KindWithArity(FunctionClassKind r5, int r10) {
                Intrinsics.checkNotNullParameter(r5, "kind");
                this.kind = r5;
                this.arity = r10;
            }

            public final FunctionClassKind component1() {
                return this.kind;
            }

            public final int component2() {
                return this.arity;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof KindWithArity) == true) goto L8;
                return false;
            L8:
                KindWithArity r10 = (KindWithArity) r5;
                if (this.kind == r10.kind) goto L12;
                return false;
            L12:
                if (this.arity == r10.arity) goto L14;
                return false;
            L14:
                return true;
            }

            public final FunctionClassKind getKind() {
                return this.kind;
            }

            public int hashCode() {
                int r5 = this.kind.hashCode() * 31;
                return Integer.hashCode(this.arity) + r5;
            }

            public String toString() {
                StringBuilder r5 = new StringBuilder("KindWithArity(kind=");
                r5.append(this.kind);
                r5.append(", arity=");
                return j0.n(r5, this.arity, ')');
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private final Integer toInt(String r10) {
            if (r10.length() != 0) goto L5;
            return null;
        L5:
            int r5 = r10.length();
            int r11 = 0;
            int r12 = 0;
        L6:
            if (r11 >= r5) goto L14;
            int r13 = r10.charAt(r11) - '0';
            if (r13 < 0) goto L12;
            if (r13 >= 10) goto L12;
            r12 = (r12 * 10) + r13;
            r11 = r11 + 1;
        L12:
            return null;
        L14:
            return Integer.valueOf(r12);
        }

        public final FunctionClassKind byClassNamePrefix(FqName r5, String r10) {
            Intrinsics.checkNotNullParameter(r5, "packageFqName");
            Intrinsics.checkNotNullParameter(r10, "className");
            FunctionClassKind[] r11 = FunctionClassKind.values();
            int r12 = r11.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L10;
            FunctionClassKind r14 = r11[r13];
            if (Intrinsics.areEqual(r14.getPackageFqName(), r5) == false) goto L9;
            if (StringsKt.P(r10, r14.getClassNamePrefix()) == false) goto L9;
            return r14;
        L9:
            r13 = r13 + 1;
            goto L3
        L10:
            return null;
        }

        @JvmStatic
        public final FunctionClassKind getFunctionalClassKind(String r5, FqName r10) {
            Intrinsics.checkNotNullParameter(r5, "className");
            Intrinsics.checkNotNullParameter(r10, "packageFqName");
            KindWithArity r11 = parseClassName(r5, r10);
            if (r11 != null) goto L7;
            return null;
        L7:
            return r11.getKind();
        }

        public final KindWithArity parseClassName(String r5, FqName r10) {
            Intrinsics.checkNotNullParameter(r5, "className");
            Intrinsics.checkNotNullParameter(r10, "packageFqName");
            FunctionClassKind r11 = byClassNamePrefix(r10, r5);
            if (r11 != null) goto L5;
            return null;
        L5:
            Integer r12 = toInt(r5.substring(r11.getClassNamePrefix().length()));
            if (r12 != null) goto L8;
            return null;
        L8:
            return new KindWithArity(r11, r12.intValue());
        }

        private Companion() {
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

    private FunctionClassKind(String r5, int r10, FqName r11, String r12, boolean r13, boolean r14) {
        super(r5, r10);
        this.packageFqName = r11;
        this.classNamePrefix = r12;
        this.isSuspendType = r13;
        this.isReflectType = r14;
    }

    public static FunctionClassKind valueOf(String r5) {
        return (FunctionClassKind) Enum.valueOf(FunctionClassKind.class, r5);
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

    public final Name numberedClassName(int r5) {
        return Name.identifier(this.classNamePrefix + r5);
    }
}

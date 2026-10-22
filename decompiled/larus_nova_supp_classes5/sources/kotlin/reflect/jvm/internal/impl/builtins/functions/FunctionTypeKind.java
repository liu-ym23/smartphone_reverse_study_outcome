package kotlin.reflect.jvm.internal.impl.builtins.functions;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class FunctionTypeKind {
    private final ClassId annotationOnInvokeClassId;
    private final String classNamePrefix;
    private final boolean isReflectType;
    private final FqName packageFqName;

    public static final class Function extends FunctionTypeKind {
        public static final Function INSTANCE = null;

        static {
            INSTANCE = new Function();
        }

        private Function() {
            super(StandardNames.BUILT_INS_PACKAGE_FQ_NAME, "Function", false, null);
        }
    }

    public static final class KFunction extends FunctionTypeKind {
        public static final KFunction INSTANCE = null;

        static {
            INSTANCE = new KFunction();
        }

        private KFunction() {
            super(StandardNames.KOTLIN_REFLECT_FQ_NAME, "KFunction", true, null);
        }
    }

    public static final class KSuspendFunction extends FunctionTypeKind {
        public static final KSuspendFunction INSTANCE = null;

        static {
            INSTANCE = new KSuspendFunction();
        }

        private KSuspendFunction() {
            super(StandardNames.KOTLIN_REFLECT_FQ_NAME, "KSuspendFunction", true, null);
        }
    }

    public static final class SuspendFunction extends FunctionTypeKind {
        public static final SuspendFunction INSTANCE = null;

        static {
            INSTANCE = new SuspendFunction();
        }

        private SuspendFunction() {
            super(StandardNames.COROUTINES_PACKAGE_FQ_NAME, "SuspendFunction", false, null);
        }
    }

    public String toString() {
        return this.packageFqName + '.' + this.classNamePrefix + 'N';
    }

    public final String getClassNamePrefix() {
        return this.classNamePrefix;
    }

    public final FqName getPackageFqName() {
        return this.packageFqName;
    }

    public final Name numberedClassName(int r3) {
        return Name.identifier(this.classNamePrefix + r3);
    }

    public FunctionTypeKind(FqName r2, String r3, boolean r4, ClassId r5) {
        Intrinsics.checkNotNullParameter(r2, "packageFqName");
        Intrinsics.checkNotNullParameter(r3, "classNamePrefix");
        this.packageFqName = r2;
        this.classNamePrefix = r3;
        this.isReflectType = r4;
        this.annotationOnInvokeClassId = r5;
    }
}

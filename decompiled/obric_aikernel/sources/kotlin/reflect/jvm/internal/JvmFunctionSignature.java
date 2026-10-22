package kotlin.reflect.jvm.internal;

import com.bytedance.crash.event.EnsureReportData;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;

/* JADX INFO: loaded from: classes3.dex */
public abstract class JvmFunctionSignature {

    public static final class FakeJavaAnnotationConstructor extends JvmFunctionSignature {
        private final Class<?> jClass;
        private final List<Method> methods;

        public FakeJavaAnnotationConstructor(Class<?> r10) {
            Intrinsics.checkNotNullParameter(r10, "jClass");
            super(null);
            this.jClass = r10;
            Method[] r11 = r10.getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(r11, "jClass.declaredMethods");
            this.methods = ArraysKt.sortedWith(r11, new JvmFunctionSignature$FakeJavaAnnotationConstructor$special$$inlined$sortedBy$1());
        }

        @Override // kotlin.reflect.jvm.internal.JvmFunctionSignature
        public String asString() {
            return CollectionsKt.joinToString$default(this.methods, "", "<init>(", ")V", 0, null, JvmFunctionSignature$FakeJavaAnnotationConstructor$asString$1.INSTANCE, 24, null);
        }

        public final List<Method> getMethods() {
            return this.methods;
        }
    }

    public static final class JavaConstructor extends JvmFunctionSignature {
        private final Constructor<?> constructor;

        public JavaConstructor(Constructor<?> r10) {
            Intrinsics.checkNotNullParameter(r10, "constructor");
            super(null);
            this.constructor = r10;
        }

        @Override // kotlin.reflect.jvm.internal.JvmFunctionSignature
        public String asString() {
            Class<?>[] r10 = this.constructor.getParameterTypes();
            Intrinsics.checkNotNullExpressionValue(r10, "constructor.parameterTypes");
            return ArraysKt.joinToString$default(r10, "", "<init>(", ")V", 0, null, JvmFunctionSignature$JavaConstructor$asString$1.INSTANCE, 24, null);
        }

        public final Constructor<?> getConstructor() {
            return this.constructor;
        }
    }

    public static final class JavaMethod extends JvmFunctionSignature {
        private final Method method;

        public JavaMethod(Method r10) {
            Intrinsics.checkNotNullParameter(r10, EnsureReportData.METHOD);
            super(null);
            this.method = r10;
        }

        @Override // kotlin.reflect.jvm.internal.JvmFunctionSignature
        public String asString() {
            return RuntimeTypeMapperKt.access$getSignature(this.method);
        }

        public final Method getMethod() {
            return this.method;
        }
    }

    public static final class KotlinConstructor extends JvmFunctionSignature {
        private final String _signature;
        private final JvmMemberSignature.Method signature;

        public KotlinConstructor(JvmMemberSignature.Method r10) {
            Intrinsics.checkNotNullParameter(r10, "signature");
            super(null);
            this.signature = r10;
            this._signature = r10.asString();
        }

        @Override // kotlin.reflect.jvm.internal.JvmFunctionSignature
        public String asString() {
            return this._signature;
        }

        public final String getConstructorDesc() {
            return this.signature.getDesc();
        }
    }

    public static final class KotlinFunction extends JvmFunctionSignature {
        private final String _signature;
        private final JvmMemberSignature.Method signature;

        public KotlinFunction(JvmMemberSignature.Method r10) {
            Intrinsics.checkNotNullParameter(r10, "signature");
            super(null);
            this.signature = r10;
            this._signature = r10.asString();
        }

        @Override // kotlin.reflect.jvm.internal.JvmFunctionSignature
        public String asString() {
            return this._signature;
        }

        public final String getMethodDesc() {
            return this.signature.getDesc();
        }

        public final String getMethodName() {
            return this.signature.getName();
        }
    }

    private JvmFunctionSignature() {
    }

    public /* synthetic */ JvmFunctionSignature(DefaultConstructorMarker r10) {
        this();
    }

    public abstract String asString();
}

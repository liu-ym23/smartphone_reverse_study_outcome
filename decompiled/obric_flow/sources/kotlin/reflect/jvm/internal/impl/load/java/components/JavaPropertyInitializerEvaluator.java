package kotlin.reflect.jvm.internal.impl.load.java.components;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;

/* JADX INFO: loaded from: classes3.dex */
public interface JavaPropertyInitializerEvaluator {

    public static final class DoNothing implements JavaPropertyInitializerEvaluator {
        public static final DoNothing INSTANCE = null;

        static {
            INSTANCE = new DoNothing();
        }

        private DoNothing() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator
        public ConstantValue<?> getInitializerConstant(JavaField r5, PropertyDescriptor r10) {
            Intrinsics.checkNotNullParameter(r5, "field");
            Intrinsics.checkNotNullParameter(r10, "descriptor");
            return null;
        }
    }

    ConstantValue<?> getInitializerConstant(JavaField r5, PropertyDescriptor r10);
}

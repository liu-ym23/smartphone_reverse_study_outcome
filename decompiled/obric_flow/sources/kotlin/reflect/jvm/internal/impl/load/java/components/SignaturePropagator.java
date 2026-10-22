package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
public interface SignaturePropagator {
    public static final SignaturePropagator DO_NOTHING = null;

    public static class PropagatedSignature {
        private final boolean hasStableParameterNames;
        private final KotlinType receiverType;
        private final KotlinType returnType;
        private final List<String> signatureErrors;
        private final List<TypeParameterDescriptor> typeParameters;
        private final List<ValueParameterDescriptor> valueParameters;

        private static /* synthetic */ void $$$reportNull$$$0(int r10) {
            if (r10 == 4) goto L8;
            if (r10 == 5) goto L8;
            if (r10 == 6) goto L8;
            if (r10 == 7) goto L8;
            String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L10:
            if (r10 == 4) goto L15;
            if (r10 == 5) goto L15;
            if (r10 == 6) goto L15;
            if (r10 == 7) goto L15;
            int r11 = 3;
        L16:
            Object[] r12 = new Object[r11];
            switch(r10) {
                case 1: goto L22;
                case 2: goto L21;
                case 3: goto L20;
                case 4: goto L19;
                case 5: goto L19;
                case 6: goto L19;
                case 7: goto L19;
                default: goto L18;
            };
        L18:
            r12[0] = "returnType";
        L24:
            if (r10 == 4) goto L32;
            if (r10 == 5) goto L31;
            if (r10 == 6) goto L30;
            if (r10 == 7) goto L29;
            r12[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
        L33:
            if (r10 == 4) goto L38;
            if (r10 == 5) goto L38;
            if (r10 == 6) goto L38;
            if (r10 == 7) goto L38;
            r12[2] = "<init>";
        L38:
            String r13 = String.format(r5, r12);
            if (r10 == 4) goto L45;
            if (r10 == 5) goto L45;
            if (r10 == 6) goto L45;
            if (r10 == 7) goto L45;
            throw new IllegalArgumentException(r13);
        L45:
            throw new IllegalStateException(r13);
        L29:
            r12[1] = "getErrors";
            goto L33
        L30:
            r12[1] = "getTypeParameters";
            goto L33
        L31:
            r12[1] = "getValueParameters";
            goto L33
        L32:
            r12[1] = "getReturnType";
            goto L33
        L19:
            r12[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
            goto L24
        L20:
            r12[0] = "signatureErrors";
            goto L24
        L21:
            r12[0] = "typeParameters";
            goto L24
        L22:
            r12[0] = "valueParameters";
        L15:
            r11 = 2;
        L8:
            r5 = "@NotNull method %s.%s must not return null";
            goto L10
        }

        public PropagatedSignature(KotlinType r5, KotlinType r10, List<ValueParameterDescriptor> r11, List<TypeParameterDescriptor> r12, List<String> r13, boolean r14) {
            if (r5 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r11 != null) goto L6;
            $$$reportNull$$$0(1);
        L6:
            if (r12 != null) goto L8;
            $$$reportNull$$$0(2);
        L8:
            if (r13 != null) goto L10;
            $$$reportNull$$$0(3);
        L10:
            this.returnType = r5;
            this.receiverType = r10;
            this.valueParameters = r11;
            this.typeParameters = r12;
            this.signatureErrors = r13;
            this.hasStableParameterNames = r14;
        }

        public List<String> getErrors() {
            List<String> r5 = this.signatureErrors;
            if (r5 != null) goto L5;
            $$$reportNull$$$0(7);
        L5:
            return r5;
        }

        public KotlinType getReceiverType() {
            return this.receiverType;
        }

        public KotlinType getReturnType() {
            KotlinType r5 = this.returnType;
            if (r5 != null) goto L5;
            $$$reportNull$$$0(4);
        L5:
            return r5;
        }

        public List<TypeParameterDescriptor> getTypeParameters() {
            List<TypeParameterDescriptor> r5 = this.typeParameters;
            if (r5 != null) goto L5;
            $$$reportNull$$$0(6);
        L5:
            return r5;
        }

        public List<ValueParameterDescriptor> getValueParameters() {
            List<ValueParameterDescriptor> r5 = this.valueParameters;
            if (r5 != null) goto L5;
            $$$reportNull$$$0(5);
        L5:
            return r5;
        }

        public boolean hasStableParameterNames() {
            return this.hasStableParameterNames;
        }
    }

    static {
        DO_NOTHING = new AnonymousClass1();
    }

    void reportSignatureErrors(CallableMemberDescriptor r5, List<String> r10);

    PropagatedSignature resolvePropagatedSignature(JavaMethod r5, ClassDescriptor r10, KotlinType r11, KotlinType r12, List<ValueParameterDescriptor> r13, List<TypeParameterDescriptor> r14);
}

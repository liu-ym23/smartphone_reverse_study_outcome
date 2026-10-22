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
            String r11 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L10:
            if (r10 == 4) goto L15;
            if (r10 == 5) goto L15;
            if (r10 == 6) goto L15;
            if (r10 == 7) goto L15;
            int r12 = 3;
        L16:
            Object[] r13 = new Object[r12];
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
            r13[0] = "returnType";
        L24:
            if (r10 == 4) goto L32;
            if (r10 == 5) goto L31;
            if (r10 == 6) goto L30;
            if (r10 == 7) goto L29;
            r13[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
        L33:
            if (r10 == 4) goto L38;
            if (r10 == 5) goto L38;
            if (r10 == 6) goto L38;
            if (r10 == 7) goto L38;
            r13[2] = "<init>";
        L38:
            String r14 = String.format(r11, r13);
            if (r10 == 4) goto L45;
            if (r10 == 5) goto L45;
            if (r10 == 6) goto L45;
            if (r10 == 7) goto L45;
            throw new IllegalArgumentException(r14);
        L45:
            throw new IllegalStateException(r14);
        L29:
            r13[1] = "getErrors";
            goto L33
        L30:
            r13[1] = "getTypeParameters";
            goto L33
        L31:
            r13[1] = "getValueParameters";
            goto L33
        L32:
            r13[1] = "getReturnType";
            goto L33
        L19:
            r13[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
            goto L24
        L20:
            r13[0] = "signatureErrors";
            goto L24
        L21:
            r13[0] = "typeParameters";
            goto L24
        L22:
            r13[0] = "valueParameters";
        L15:
            r12 = 2;
        L8:
            r11 = "@NotNull method %s.%s must not return null";
            goto L10
        }

        public PropagatedSignature(KotlinType r10, KotlinType r11, List<ValueParameterDescriptor> r12, List<TypeParameterDescriptor> r13, List<String> r14, boolean r15) {
            if (r10 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r12 != null) goto L6;
            $$$reportNull$$$0(1);
        L6:
            if (r13 != null) goto L8;
            $$$reportNull$$$0(2);
        L8:
            if (r14 != null) goto L10;
            $$$reportNull$$$0(3);
        L10:
            this.returnType = r10;
            this.receiverType = r11;
            this.valueParameters = r12;
            this.typeParameters = r13;
            this.signatureErrors = r14;
            this.hasStableParameterNames = r15;
        }

        public List<String> getErrors() {
            List<String> r10 = this.signatureErrors;
            if (r10 != null) goto L5;
            $$$reportNull$$$0(7);
        L5:
            return r10;
        }

        public KotlinType getReceiverType() {
            return this.receiverType;
        }

        public KotlinType getReturnType() {
            KotlinType r10 = this.returnType;
            if (r10 != null) goto L5;
            $$$reportNull$$$0(4);
        L5:
            return r10;
        }

        public List<TypeParameterDescriptor> getTypeParameters() {
            List<TypeParameterDescriptor> r10 = this.typeParameters;
            if (r10 != null) goto L5;
            $$$reportNull$$$0(6);
        L5:
            return r10;
        }

        public List<ValueParameterDescriptor> getValueParameters() {
            List<ValueParameterDescriptor> r10 = this.valueParameters;
            if (r10 != null) goto L5;
            $$$reportNull$$$0(5);
        L5:
            return r10;
        }

        public boolean hasStableParameterNames() {
            return this.hasStableParameterNames;
        }
    }

    static {
        DO_NOTHING = new AnonymousClass1();
    }

    void reportSignatureErrors(CallableMemberDescriptor r10, List<String> r11);

    PropagatedSignature resolvePropagatedSignature(JavaMethod r10, ClassDescriptor r11, KotlinType r12, KotlinType r13, List<ValueParameterDescriptor> r14, List<TypeParameterDescriptor> r15);
}

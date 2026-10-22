package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* JADX INFO: loaded from: classes3.dex */
public interface TypeAttributeTranslator {

    public static final class DefaultImpls {
        public static /* synthetic */ TypeAttributes toAttributes$default(TypeAttributeTranslator r10, Annotations r11, TypeConstructor r12, DeclarationDescriptor r13, int r14, Object r15) {
            if (r15 != null) goto L12;
            if ((r14 & 2) == 0) goto L7;
            r12 = null;
        L7:
            if ((r14 & 4) == 0) goto L10;
            r13 = null;
        L10:
            return r10.toAttributes(r11, r12, r13);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toAttributes");
        }
    }

    TypeAttributes toAttributes(Annotations r10, TypeConstructor r11, DeclarationDescriptor r12);
}

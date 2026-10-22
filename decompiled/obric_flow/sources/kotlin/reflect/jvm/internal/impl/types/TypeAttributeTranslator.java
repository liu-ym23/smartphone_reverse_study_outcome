package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* JADX INFO: loaded from: classes3.dex */
public interface TypeAttributeTranslator {

    public static final class DefaultImpls {
        public static /* synthetic */ TypeAttributes toAttributes$default(TypeAttributeTranslator r5, Annotations r10, TypeConstructor r11, DeclarationDescriptor r12, int r13, Object r14) {
            if (r14 != null) goto L12;
            if ((r13 & 2) == 0) goto L7;
            r11 = null;
        L7:
            if ((r13 & 4) == 0) goto L10;
            r12 = null;
        L10:
            return r5.toAttributes(r10, r11, r12);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toAttributes");
        }
    }

    TypeAttributes toAttributes(Annotations r5, TypeConstructor r10, DeclarationDescriptor r11);
}

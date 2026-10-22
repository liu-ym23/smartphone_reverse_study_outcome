package kotlin.reflect.jvm.internal.impl.types.extensions;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributeTranslator;

/* JADX INFO: loaded from: classes3.dex */
public final class TypeAttributeTranslators {
    private final List<TypeAttributeTranslator> translators;

    /* JADX WARN: Multi-variable type inference failed */
    public TypeAttributeTranslators(List<? extends TypeAttributeTranslator> r10) {
        Intrinsics.checkNotNullParameter(r10, "translators");
        this.translators = r10;
    }

    public final List<TypeAttributeTranslator> getTranslators() {
        return this.translators;
    }
}

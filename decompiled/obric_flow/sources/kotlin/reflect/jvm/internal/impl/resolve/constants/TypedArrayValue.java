package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
public final class TypedArrayValue extends ArrayValue {
    private final KotlinType type;

    public TypedArrayValue(List<? extends ConstantValue<?>> r5, final KotlinType r10) {
        Intrinsics.checkNotNullParameter(r5, "value");
        Intrinsics.checkNotNullParameter(r10, "type");
        super(r5, new AnonymousClass1(r10));
        this.type = r10;
    }

    public final KotlinType getType() {
        return this.type;
    }
}

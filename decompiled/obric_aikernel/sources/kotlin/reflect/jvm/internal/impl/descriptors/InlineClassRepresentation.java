package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class InlineClassRepresentation<Type extends SimpleTypeMarker> extends ValueClassRepresentation<Type> {
    private final Name underlyingPropertyName;
    private final Type underlyingType;

    public InlineClassRepresentation(Name r10, Type r11) {
        Intrinsics.checkNotNullParameter(r10, "underlyingPropertyName");
        Intrinsics.checkNotNullParameter(r11, "underlyingType");
        super(null);
        this.underlyingPropertyName = r10;
        this.underlyingType = r11;
    }

    public final Name getUnderlyingPropertyName() {
        return this.underlyingPropertyName;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation
    public List<Pair<Name, Type>> getUnderlyingPropertyNamesToTypes() {
        return CollectionsKt.listOf(TuplesKt.to(this.underlyingPropertyName, this.underlyingType));
    }

    public final Type getUnderlyingType() {
        return this.underlyingType;
    }
}

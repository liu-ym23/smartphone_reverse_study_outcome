package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class MultiFieldValueClassRepresentation<Type extends SimpleTypeMarker> extends ValueClassRepresentation<Type> {
    private final Map<Name, Type> map;
    private final List<Pair<Name, Type>> underlyingPropertyNamesToTypes;

    /* JADX WARN: Multi-variable type inference failed */
    public MultiFieldValueClassRepresentation(List<? extends Pair<Name, ? extends Type>> r10) {
        Intrinsics.checkNotNullParameter(r10, "underlyingPropertyNamesToTypes");
        super(null);
        this.underlyingPropertyNamesToTypes = r10;
        Map<Name, Type> r11 = MapsKt.toMap(getUnderlyingPropertyNamesToTypes());
        if (r11.size() != getUnderlyingPropertyNamesToTypes().size()) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L10;
        this.map = r11;
        return;
    L10:
        throw new IllegalArgumentException("Some properties have the same names".toString());
    L5:
        r12 = false;
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation
    public List<Pair<Name, Type>> getUnderlyingPropertyNamesToTypes() {
        return this.underlyingPropertyNamesToTypes;
    }
}

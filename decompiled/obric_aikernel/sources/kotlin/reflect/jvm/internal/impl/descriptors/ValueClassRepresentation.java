package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ValueClassRepresentation<Type extends SimpleTypeMarker> {
    private ValueClassRepresentation() {
    }

    public /* synthetic */ ValueClassRepresentation(DefaultConstructorMarker r10) {
        this();
    }

    public abstract List<Pair<Name, Type>> getUnderlyingPropertyNamesToTypes();

    public final <Other extends SimpleTypeMarker> ValueClassRepresentation<Other> mapUnderlyingType(Function1<? super Type, ? extends Other> r10) {
        Intrinsics.checkNotNullParameter(r10, "transform");
        if ((this instanceof InlineClassRepresentation) == false) goto L6;
        InlineClassRepresentation r11 = (InlineClassRepresentation) this;
        return new InlineClassRepresentation(r11.getUnderlyingPropertyName(), r10.invoke(r11.getUnderlyingType()));
    L6:
        if ((this instanceof MultiFieldValueClassRepresentation) == false) goto L14;
        List<Pair<Name, Type>> r12 = getUnderlyingPropertyNamesToTypes();
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r14 = r12.iterator();
    L9:
        if (r14.hasNext() == false) goto L12;
        Pair r15 = (Pair) r14.next();
        r13.add(TuplesKt.to((Name) r15.component1(), r10.invoke((SimpleTypeMarker) r15.component2())));
        goto L9
    L12:
        return new MultiFieldValueClassRepresentation(r13);
    L14:
        throw new NoWhenBranchMatchedException();
    }
}

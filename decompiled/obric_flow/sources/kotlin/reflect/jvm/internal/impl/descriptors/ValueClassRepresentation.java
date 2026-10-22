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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nValueClassRepresentation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ValueClassRepresentation.kt\norg/jetbrains/kotlin/descriptors/ValueClassRepresentation\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,50:1\n1549#2:51\n1620#2,3:52\n*S KotlinDebug\n*F\n+ 1 ValueClassRepresentation.kt\norg/jetbrains/kotlin/descriptors/ValueClassRepresentation\n*L\n22#1:51\n22#1:52,3\n*E\n"})
public abstract class ValueClassRepresentation<Type extends SimpleTypeMarker> {
    public /* synthetic */ ValueClassRepresentation(DefaultConstructorMarker r5) {
        this();
    }

    public abstract List<Pair<Name, Type>> getUnderlyingPropertyNamesToTypes();

    public final <Other extends SimpleTypeMarker> ValueClassRepresentation<Other> mapUnderlyingType(Function1<? super Type, ? extends Other> r5) {
        Intrinsics.checkNotNullParameter(r5, "transform");
        if ((this instanceof InlineClassRepresentation) == false) goto L6;
        InlineClassRepresentation r10 = (InlineClassRepresentation) this;
        return new InlineClassRepresentation(r10.getUnderlyingPropertyName(), r5.invoke(r10.getUnderlyingType()));
    L6:
        if ((this instanceof MultiFieldValueClassRepresentation) == false) goto L14;
        List<Pair<Name, Type>> r11 = getUnderlyingPropertyNamesToTypes();
        ArrayList r12 = new ArrayList(CollectionsKt.h(r11));
        Iterator<T> r13 = r11.iterator();
    L9:
        if (r13.hasNext() == false) goto L12;
        Pair r14 = (Pair) r13.next();
        r12.add(TuplesKt.to((Name) r14.component1(), r5.invoke((SimpleTypeMarker) r14.component2())));
        goto L9
    L12:
        return new MultiFieldValueClassRepresentation(r12);
    L14:
        throw new NoWhenBranchMatchedException();
    }

    private ValueClassRepresentation() {
    }
}

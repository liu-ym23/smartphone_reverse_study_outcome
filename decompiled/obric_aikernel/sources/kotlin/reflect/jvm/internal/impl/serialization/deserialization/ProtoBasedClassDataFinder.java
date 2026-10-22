package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* JADX INFO: loaded from: classes3.dex */
public final class ProtoBasedClassDataFinder implements ClassDataFinder {
    private final Map<ClassId, ProtoBuf.Class> classIdToProto;
    private final Function1<ClassId, SourceElement> classSource;
    private final BinaryVersion metadataVersion;
    private final NameResolver nameResolver;

    /* JADX WARN: Multi-variable type inference failed */
    public ProtoBasedClassDataFinder(ProtoBuf.PackageFragment r10, NameResolver r11, BinaryVersion r12, Function1<? super ClassId, ? extends SourceElement> r13) {
        Intrinsics.checkNotNullParameter(r10, "proto");
        Intrinsics.checkNotNullParameter(r11, "nameResolver");
        Intrinsics.checkNotNullParameter(r12, "metadataVersion");
        Intrinsics.checkNotNullParameter(r13, "classSource");
        this.nameResolver = r11;
        this.metadataVersion = r12;
        this.classSource = r13;
        List<ProtoBuf.Class> r14 = r10.getClass_List();
        Intrinsics.checkNotNullExpressionValue(r14, "proto.class_List");
        LinkedHashMap r15 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r14, 10)), 16));
        Iterator<T> r16 = r14.iterator();
    L4:
        if (r16.hasNext() == false) goto L6;
        Object r17 = r16.next();
        r15.put(NameResolverUtilKt.getClassId(this.nameResolver, ((ProtoBuf.Class) r17).getFqName()), r17);
        goto L4
    L6:
        this.classIdToProto = r15;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder
    public ClassData findClassData(ClassId r10) {
        Intrinsics.checkNotNullParameter(r10, "classId");
        ProtoBuf.Class r11 = this.classIdToProto.get(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return new ClassData(this.nameResolver, r11, this.metadataVersion, this.classSource.invoke(r10));
    }

    public final Collection<ClassId> getAllClassIds() {
        return this.classIdToProto.keySet();
    }
}

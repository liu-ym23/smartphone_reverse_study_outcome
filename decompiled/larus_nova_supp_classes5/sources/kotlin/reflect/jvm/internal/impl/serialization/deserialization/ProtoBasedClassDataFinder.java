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
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ProtoBasedClassDataFinder implements ClassDataFinder {
    private final Map<ClassId, ProtoBuf$Class> classIdToProto;
    private final Function1<ClassId, SourceElement> classSource;
    private final BinaryVersion metadataVersion;
    private final NameResolver nameResolver;

    public final Collection<ClassId> getAllClassIds() {
        return this.classIdToProto.keySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder
    public ClassData findClassData(ClassId r6) {
        Intrinsics.checkNotNullParameter(r6, "classId");
        ProtoBuf$Class r0 = this.classIdToProto.get(r6);
        if (r0 != null) goto L7;
        return null;
    L7:
        return new ClassData(this.nameResolver, r0, this.metadataVersion, (SourceElement) this.classSource.invoke(r6));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProtoBasedClassDataFinder(ProtoBuf$PackageFragment r2, NameResolver r3, BinaryVersion r4, Function1<? super ClassId, ? extends SourceElement> r5) {
        Intrinsics.checkNotNullParameter(r2, "proto");
        Intrinsics.checkNotNullParameter(r3, "nameResolver");
        Intrinsics.checkNotNullParameter(r4, "metadataVersion");
        Intrinsics.checkNotNullParameter(r5, "classSource");
        this.nameResolver = r3;
        this.metadataVersion = r4;
        this.classSource = r5;
        List<ProtoBuf$Class> r6 = r2.getClass_List();
        LinkedHashMap r7 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r6, 10)), 16));
        Iterator<T> r8 = r6.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        Object r9 = r8.next();
        r7.put(NameResolverUtilKt.getClassId(this.nameResolver, ((ProtoBuf$Class) r9).getFqName()), r9);
        goto L4
    L6:
        this.classIdToProto = r7;
    }
}

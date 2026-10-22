package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import androidx.constraintlayout.motion.widget.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nProtoBasedClassDataFinder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProtoBasedClassDataFinder.kt\norg/jetbrains/kotlin/serialization/deserialization/ProtoBasedClassDataFinder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,43:1\n1194#2,2:44\n1222#2,4:46\n*S KotlinDebug\n*F\n+ 1 ProtoBasedClassDataFinder.kt\norg/jetbrains/kotlin/serialization/deserialization/ProtoBasedClassDataFinder\n*L\n32#1:44,2\n32#1:46,4\n*E\n"})
public final class ProtoBasedClassDataFinder implements ClassDataFinder {
    private final Map<ClassId, ProtoBuf.Class> classIdToProto;
    private final Function1<ClassId, SourceElement> classSource;
    private final BinaryVersion metadataVersion;
    private final NameResolver nameResolver;

    /* JADX WARN: Multi-variable type inference failed */
    public ProtoBasedClassDataFinder(ProtoBuf.PackageFragment r5, NameResolver r10, BinaryVersion r11, Function1<? super ClassId, ? extends SourceElement> r12) {
        Intrinsics.checkNotNullParameter(r5, "proto");
        Intrinsics.checkNotNullParameter(r10, "nameResolver");
        Intrinsics.checkNotNullParameter(r11, "metadataVersion");
        Intrinsics.checkNotNullParameter(r12, "classSource");
        this.nameResolver = r10;
        this.metadataVersion = r11;
        this.classSource = r12;
        List<ProtoBuf.Class> r13 = r5.getClass_List();
        LinkedHashMap r14 = new LinkedHashMap(a.e(r13, 16));
        Iterator<T> r15 = r13.iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        Object r16 = r15.next();
        r14.put(NameResolverUtilKt.getClassId(this.nameResolver, ((ProtoBuf.Class) r16).getFqName()), r16);
        goto L4
    L6:
        this.classIdToProto = r14;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder
    public ClassData findClassData(ClassId r5) {
        Intrinsics.checkNotNullParameter(r5, "classId");
        ProtoBuf.Class r10 = this.classIdToProto.get(r5);
        if (r10 != null) goto L7;
        return null;
    L7:
        return new ClassData(this.nameResolver, r10, this.metadataVersion, this.classSource.invoke(r5));
    }

    public final Collection<ClassId> getAllClassIds() {
        return this.classIdToProto.keySet();
    }
}

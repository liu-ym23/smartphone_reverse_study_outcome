package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.SerializerExtensionProtocol;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class AbstractAnnotationLoader<A> implements AnnotationLoader<A> {
    private final SerializerExtensionProtocol protocol;

    public final SerializerExtensionProtocol getProtocol() {
        return this.protocol;
    }

    public AbstractAnnotationLoader(SerializerExtensionProtocol r2) {
        Intrinsics.checkNotNullParameter(r2, "protocol");
        this.protocol = r2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadClassAnnotations(ProtoContainer.Class r5) {
        Intrinsics.checkNotNullParameter(r5, "container");
        List r0 = (List) r5.getClassProto().getExtension(this.protocol.getClassAnnotation());
        if (r0 != null) goto L5;
        r0 = CollectionsKt.emptyList();
    L5:
        List r1 = r0;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r3 = r1.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        r2.add(loadAnnotation((ProtoBuf$Annotation) r3.next(), r5.getNameResolver()));
        goto L7
    L9:
        return r2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadEnumEntryAnnotations(ProtoContainer r4, ProtoBuf$EnumEntry r5) {
        Intrinsics.checkNotNullParameter(r4, "container");
        Intrinsics.checkNotNullParameter(r5, "proto");
        List r6 = (List) r5.getExtension(this.protocol.getEnumEntryAnnotation());
        if (r6 != null) goto L5;
        r6 = CollectionsKt.emptyList();
    L5:
        List r7 = r6;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L9;
        r0.add(loadAnnotation((ProtoBuf$Annotation) r8.next(), r4.getNameResolver()));
        goto L7
    L9:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadPropertyBackingFieldAnnotations(ProtoContainer r4, ProtoBuf$Property r5) {
        Intrinsics.checkNotNullParameter(r4, "container");
        Intrinsics.checkNotNullParameter(r5, "proto");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf$Property, List<ProtoBuf$Annotation>> r0 = this.protocol.getPropertyBackingFieldAnnotation();
        if (r0 == null) goto L5;
        List r6 = (List) r5.getExtension(r0);
    L6:
        if (r6 != null) goto L8;
        r6 = CollectionsKt.emptyList();
    L8:
        List r7 = r6;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r8 = r7.iterator();
    L10:
        if (r8.hasNext() == false) goto L12;
        r1.add(loadAnnotation((ProtoBuf$Annotation) r8.next(), r4.getNameResolver()));
        goto L10
    L12:
        return r1;
    L5:
        r6 = null;
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadPropertyDelegateFieldAnnotations(ProtoContainer r4, ProtoBuf$Property r5) {
        Intrinsics.checkNotNullParameter(r4, "container");
        Intrinsics.checkNotNullParameter(r5, "proto");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf$Property, List<ProtoBuf$Annotation>> r0 = this.protocol.getPropertyDelegatedFieldAnnotation();
        if (r0 == null) goto L5;
        List r6 = (List) r5.getExtension(r0);
    L6:
        if (r6 != null) goto L8;
        r6 = CollectionsKt.emptyList();
    L8:
        List r7 = r6;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r8 = r7.iterator();
    L10:
        if (r8.hasNext() == false) goto L12;
        r1.add(loadAnnotation((ProtoBuf$Annotation) r8.next(), r4.getNameResolver()));
        goto L10
    L12:
        return r1;
    L5:
        r6 = null;
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadTypeAnnotations(ProtoBuf$Type r3, NameResolver r4) {
        Intrinsics.checkNotNullParameter(r3, "proto");
        Intrinsics.checkNotNullParameter(r4, "nameResolver");
        List r5 = (List) r3.getExtension(this.protocol.getTypeAnnotation());
        if (r5 != null) goto L5;
        r5 = CollectionsKt.emptyList();
    L5:
        List r6 = r5;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r7 = r6.iterator();
    L7:
        if (r7.hasNext() == false) goto L9;
        r0.add(loadAnnotation((ProtoBuf$Annotation) r7.next(), r4));
        goto L7
    L9:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadTypeParameterAnnotations(ProtoBuf$TypeParameter r3, NameResolver r4) {
        Intrinsics.checkNotNullParameter(r3, "proto");
        Intrinsics.checkNotNullParameter(r4, "nameResolver");
        List r5 = (List) r3.getExtension(this.protocol.getTypeParameterAnnotation());
        if (r5 != null) goto L5;
        r5 = CollectionsKt.emptyList();
    L5:
        List r6 = r5;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r7 = r6.iterator();
    L7:
        if (r7.hasNext() == false) goto L9;
        r0.add(loadAnnotation((ProtoBuf$Annotation) r7.next(), r4));
        goto L7
    L9:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadCallableAnnotations(ProtoContainer r3, MessageLite r4, AnnotatedCallableKind r5) {
        Intrinsics.checkNotNullParameter(r3, "container");
        Intrinsics.checkNotNullParameter(r4, "proto");
        Intrinsics.checkNotNullParameter(r5, "kind");
        if ((r4 instanceof ProtoBuf$Constructor) == false) goto L6;
        List r6 = (List) ((ProtoBuf$Constructor) r4).getExtension(this.protocol.getConstructorAnnotation());
    L21:
        if (r6 != null) goto L23;
        r6 = CollectionsKt.emptyList();
    L23:
        List r7 = r6;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r9 = r7.iterator();
    L25:
        if (r9.hasNext() == false) goto L27;
        r8.add(loadAnnotation((ProtoBuf$Annotation) r9.next(), r3.getNameResolver()));
        goto L25
    L27:
        return r8;
    L6:
        if ((r4 instanceof ProtoBuf$Function) == false) goto L9;
        r6 = (List) ((ProtoBuf$Function) r4).getExtension(this.protocol.getFunctionAnnotation());
        goto L21
    L9:
        if ((r4 instanceof ProtoBuf$Property) == false) goto L29;
        int r10 = WhenMappings.$EnumSwitchMapping$0[r5.ordinal()];
        if (r10 != 1) goto L13;
        r6 = (List) ((ProtoBuf$Property) r4).getExtension(this.protocol.getPropertyAnnotation());
        goto L21
    L13:
        if (r10 != 2) goto L15;
        r6 = (List) ((ProtoBuf$Property) r4).getExtension(this.protocol.getPropertyGetterAnnotation());
        goto L21
    L15:
        if (r10 != 3) goto L18;
        r6 = (List) ((ProtoBuf$Property) r4).getExtension(this.protocol.getPropertySetterAnnotation());
        goto L21
    L18:
        throw new IllegalStateException("Unsupported callable kind with property proto".toString());
    L29:
        throw new IllegalStateException(("Unknown message: " + r4).toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadExtensionReceiverParameterAnnotations(ProtoContainer r4, MessageLite r5, AnnotatedCallableKind r6) {
        Intrinsics.checkNotNullParameter(r4, "container");
        Intrinsics.checkNotNullParameter(r5, "proto");
        Intrinsics.checkNotNullParameter(r6, "kind");
        List r1 = null;
        if ((r5 instanceof ProtoBuf$Function) == false) goto L8;
        GeneratedMessageLite.GeneratedExtension<ProtoBuf$Function, List<ProtoBuf$Annotation>> r7 = this.protocol.getFunctionExtensionReceiverAnnotation();
        if (r7 == null) goto L21;
        r1 = (List) ((ProtoBuf$Function) r5).getExtension(r7);
    L21:
        if (r1 != null) goto L23;
        r1 = CollectionsKt.emptyList();
    L23:
        List r2 = r1;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r9 = r2.iterator();
    L25:
        if (r9.hasNext() == false) goto L27;
        r8.add(loadAnnotation((ProtoBuf$Annotation) r9.next(), r4.getNameResolver()));
        goto L25
    L27:
        return r8;
    L8:
        if ((r5 instanceof ProtoBuf$Property) == false) goto L29;
        int r0 = WhenMappings.$EnumSwitchMapping$0[r6.ordinal()];
        if (r0 != 1) goto L12;
    L18:
        GeneratedMessageLite.GeneratedExtension<ProtoBuf$Property, List<ProtoBuf$Annotation>> r10 = this.protocol.getPropertyExtensionReceiverAnnotation();
        if (r10 == null) goto L21;
        r1 = (List) ((ProtoBuf$Property) r5).getExtension(r10);
        goto L21
    L12:
        if (r0 == 2) goto L18;
        if (r0 == 3) goto L18;
        throw new IllegalStateException(("Unsupported callable kind with property proto for receiver annotations: " + r6).toString());
    L29:
        throw new IllegalStateException(("Unknown message: " + r5).toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadValueParameterAnnotations(ProtoContainer r1, MessageLite r2, AnnotatedCallableKind r3, int r4, ProtoBuf$ValueParameter r5) {
        Intrinsics.checkNotNullParameter(r1, "container");
        Intrinsics.checkNotNullParameter(r2, "callableProto");
        Intrinsics.checkNotNullParameter(r3, "kind");
        Intrinsics.checkNotNullParameter(r5, "proto");
        List r6 = (List) r5.getExtension(this.protocol.getParameterAnnotation());
        if (r6 != null) goto L5;
        r6 = CollectionsKt.emptyList();
    L5:
        List r7 = r6;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r9 = r7.iterator();
    L7:
        if (r9.hasNext() == false) goto L9;
        r8.add(loadAnnotation((ProtoBuf$Annotation) r9.next(), r1.getNameResolver()));
        goto L7
    L9:
        return r8;
    }
}

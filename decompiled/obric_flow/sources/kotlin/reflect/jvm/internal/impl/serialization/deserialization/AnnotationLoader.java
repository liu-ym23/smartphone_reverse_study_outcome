package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* JADX INFO: loaded from: classes3.dex */
public interface AnnotationLoader<A> {
    List<A> loadCallableAnnotations(ProtoContainer r5, MessageLite r10, AnnotatedCallableKind r11);

    List<A> loadClassAnnotations(ProtoContainer.Class r5);

    List<A> loadEnumEntryAnnotations(ProtoContainer r5, ProtoBuf.EnumEntry r10);

    List<A> loadExtensionReceiverParameterAnnotations(ProtoContainer r5, MessageLite r10, AnnotatedCallableKind r11);

    List<A> loadPropertyBackingFieldAnnotations(ProtoContainer r5, ProtoBuf.Property r10);

    List<A> loadPropertyDelegateFieldAnnotations(ProtoContainer r5, ProtoBuf.Property r10);

    List<A> loadTypeAnnotations(ProtoBuf.Type r5, NameResolver r10);

    List<A> loadTypeParameterAnnotations(ProtoBuf.TypeParameter r5, NameResolver r10);

    List<A> loadValueParameterAnnotations(ProtoContainer r5, MessageLite r10, AnnotatedCallableKind r11, int r12, ProtoBuf.ValueParameter r13);
}

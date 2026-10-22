package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* JADX INFO: loaded from: classes3.dex */
public interface AnnotationLoader<A> {
    List<A> loadCallableAnnotations(ProtoContainer r10, MessageLite r11, AnnotatedCallableKind r12);

    List<A> loadClassAnnotations(ProtoContainer.Class r10);

    List<A> loadEnumEntryAnnotations(ProtoContainer r10, ProtoBuf.EnumEntry r11);

    List<A> loadExtensionReceiverParameterAnnotations(ProtoContainer r10, MessageLite r11, AnnotatedCallableKind r12);

    List<A> loadPropertyBackingFieldAnnotations(ProtoContainer r10, ProtoBuf.Property r11);

    List<A> loadPropertyDelegateFieldAnnotations(ProtoContainer r10, ProtoBuf.Property r11);

    List<A> loadTypeAnnotations(ProtoBuf.Type r10, NameResolver r11);

    List<A> loadTypeParameterAnnotations(ProtoBuf.TypeParameter r10, NameResolver r11);

    List<A> loadValueParameterAnnotations(ProtoContainer r10, MessageLite r11, AnnotatedCallableKind r12, int r13, ProtoBuf.ValueParameter r14);
}

package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractLazyTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
public final class DeserializedTypeParameterDescriptor extends AbstractLazyTypeParameterDescriptor {
    private final DeserializedAnnotations annotations;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DeserializationContext f10222c;
    private final ProtoBuf.TypeParameter proto;

    public DeserializedTypeParameterDescriptor(DeserializationContext r12, ProtoBuf.TypeParameter r13, int r14) {
        Intrinsics.checkNotNullParameter(r12, "c");
        Intrinsics.checkNotNullParameter(r13, "proto");
        StorageManager r10 = r12.getStorageManager();
        DeclarationDescriptor r11 = r12.getContainingDeclaration();
        Annotations r15 = Annotations.Companion.getEMPTY();
        Name r16 = NameResolverUtilKt.getName(r12.getNameResolver(), r13.getName());
        ProtoEnumFlags r17 = ProtoEnumFlags.INSTANCE;
        ProtoBuf.TypeParameter.Variance r18 = r13.getVariance();
        Intrinsics.checkNotNullExpressionValue(r18, "proto.variance");
        super(r10, r11, r15, r16, r17.variance(r18), r13.getReified(), r14, SourceElement.NO_SOURCE, SupertypeLoopChecker.EMPTY.INSTANCE);
        this.f10222c = r12;
        this.proto = r13;
        this.annotations = new DeserializedAnnotations(r12.getStorageManager(), new DeserializedTypeParameterDescriptor$annotations$1(this));
    }

    public static final /* synthetic */ DeserializationContext access$getC$p(DeserializedTypeParameterDescriptor r10) {
        return r10.f10222c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotatedImpl, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public /* bridge */ /* synthetic */ Annotations getAnnotations() {
        return getAnnotations();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotatedImpl, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public DeserializedAnnotations getAnnotations() {
        return this.annotations;
    }

    public final ProtoBuf.TypeParameter getProto() {
        return this.proto;
    }

    protected Void reportSupertypeLoopError(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
        throw new IllegalStateException("There should be no cycles for deserialized type parameters, but found for: " + this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    /* JADX INFO: renamed from: reportSupertypeLoopError, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ void mo1326reportSupertypeLoopError(KotlinType r10) {
        reportSupertypeLoopError(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    protected List<KotlinType> resolveUpperBounds() {
        List<ProtoBuf.Type> r10 = ProtoTypeTableUtilKt.upperBounds(this.proto, this.f10222c.getTypeTable());
        if (r10.isEmpty() == true) goto L5;
        TypeDeserializer r11 = this.f10222c.getTypeDeserializer();
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r13 = r10.iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        r12.add(r11.type((ProtoBuf.Type) r13.next()));
        goto L8
    L10:
        return r12;
    L5:
        return CollectionsKt.listOf(DescriptorUtilsKt.getBuiltIns(this).getDefaultBound());
    }
}

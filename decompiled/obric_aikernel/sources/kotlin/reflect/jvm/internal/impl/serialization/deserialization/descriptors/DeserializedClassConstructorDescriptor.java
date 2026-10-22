package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* JADX INFO: loaded from: classes3.dex */
public final class DeserializedClassConstructorDescriptor extends ClassConstructorDescriptorImpl implements DeserializedCallableMemberDescriptor {
    private final DeserializedContainerSource containerSource;
    private final NameResolver nameResolver;
    private final ProtoBuf.Constructor proto;
    private final TypeTable typeTable;
    private final VersionRequirementTable versionRequirementTable;

    public DeserializedClassConstructorDescriptor(ClassDescriptor r13, ConstructorDescriptor r14, Annotations r15, boolean r16, CallableMemberDescriptor.Kind r17, ProtoBuf.Constructor r18, NameResolver r19, TypeTable r20, VersionRequirementTable r21, DeserializedContainerSource r22, SourceElement r23) {
        Intrinsics.checkNotNullParameter(r13, "containingDeclaration");
        Intrinsics.checkNotNullParameter(r15, "annotations");
        Intrinsics.checkNotNullParameter(r17, "kind");
        Intrinsics.checkNotNullParameter(r18, "proto");
        Intrinsics.checkNotNullParameter(r19, "nameResolver");
        Intrinsics.checkNotNullParameter(r20, "typeTable");
        Intrinsics.checkNotNullParameter(r21, "versionRequirementTable");
        if (r23 != null) goto L5;
        SourceElement r10 = SourceElement.NO_SOURCE;
    L6:
        super(r13, r14, r15, r16, r17, r10);
        this.proto = r18;
        this.nameResolver = r19;
        this.typeTable = r20;
        this.versionRequirementTable = r21;
        this.containerSource = r22;
        return;
    L5:
        r10 = r23;
        goto L6
    }

    public /* synthetic */ DeserializedClassConstructorDescriptor(ClassDescriptor r14, ConstructorDescriptor r15, Annotations r16, boolean r17, CallableMemberDescriptor.Kind r18, ProtoBuf.Constructor r19, NameResolver r20, TypeTable r21, VersionRequirementTable r22, DeserializedContainerSource r23, SourceElement r24, int r25, DefaultConstructorMarker r26) {
        if ((r25 & 1024) == 0) goto L5;
        SourceElement r12 = null;
    L6:
        this(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r12);
        return;
    L5:
        r12 = r24;
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public /* bridge */ /* synthetic */ ClassConstructorDescriptorImpl createSubstitutedCopy(DeclarationDescriptor r10, FunctionDescriptor r11, CallableMemberDescriptor.Kind r12, Name r13, Annotations r14, SourceElement r15) {
        return createSubstitutedCopy(r10, r11, r12, r13, r14, r15);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public /* bridge */ /* synthetic */ FunctionDescriptorImpl createSubstitutedCopy(DeclarationDescriptor r10, FunctionDescriptor r11, CallableMemberDescriptor.Kind r12, Name r13, Annotations r14, SourceElement r15) {
        return createSubstitutedCopy(r10, r11, r12, r13, r14, r15);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    protected DeserializedClassConstructorDescriptor createSubstitutedCopy(DeclarationDescriptor r15, FunctionDescriptor r16, CallableMemberDescriptor.Kind r17, Name r18, Annotations r19, SourceElement r20) {
        Intrinsics.checkNotNullParameter(r15, "newOwner");
        Intrinsics.checkNotNullParameter(r17, "kind");
        Intrinsics.checkNotNullParameter(r19, "annotations");
        Intrinsics.checkNotNullParameter(r20, "source");
        DeserializedClassConstructorDescriptor r10 = new DeserializedClassConstructorDescriptor((ClassDescriptor) r15, (ConstructorDescriptor) r16, r19, this.isPrimary, r17, getProto(), getNameResolver(), getTypeTable(), getVersionRequirementTable(), getContainerSource(), r20);
        r10.setHasStableParameterNames(hasStableParameterNames());
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    public DeserializedContainerSource getContainerSource() {
        return this.containerSource;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    public NameResolver getNameResolver() {
        return this.nameResolver;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    public ProtoBuf.Constructor getProto() {
        return this.proto;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    public /* bridge */ /* synthetic */ MessageLite getProto() {
        return getProto();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    public TypeTable getTypeTable() {
        return this.typeTable;
    }

    public VersionRequirementTable getVersionRequirementTable() {
        return this.versionRequirementTable;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isSuspend() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isTailrec() {
        return false;
    }
}

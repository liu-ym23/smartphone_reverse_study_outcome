package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionSpecificBehaviorKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public final class DeserializationContext {
    private final DeserializationComponents components;
    private final DeserializedContainerSource containerSource;
    private final DeclarationDescriptor containingDeclaration;
    private final MemberDeserializer memberDeserializer;
    private final BinaryVersion metadataVersion;
    private final NameResolver nameResolver;
    private final TypeDeserializer typeDeserializer;
    private final TypeTable typeTable;
    private final VersionRequirementTable versionRequirementTable;

    public DeserializationContext(DeserializationComponents r10, NameResolver r11, DeclarationDescriptor r12, TypeTable r13, VersionRequirementTable r14, BinaryVersion r15, DeserializedContainerSource r16, TypeDeserializer r17, List<ProtoBuf.TypeParameter> r18) {
        Intrinsics.checkNotNullParameter(r10, "components");
        Intrinsics.checkNotNullParameter(r11, "nameResolver");
        Intrinsics.checkNotNullParameter(r12, "containingDeclaration");
        Intrinsics.checkNotNullParameter(r13, "typeTable");
        Intrinsics.checkNotNullParameter(r14, "versionRequirementTable");
        Intrinsics.checkNotNullParameter(r15, "metadataVersion");
        Intrinsics.checkNotNullParameter(r18, "typeParameters");
        this.components = r10;
        this.nameResolver = r11;
        this.containingDeclaration = r12;
        this.typeTable = r13;
        this.versionRequirementTable = r14;
        this.metadataVersion = r15;
        this.containerSource = r16;
        String r19 = "Deserializer for \"" + r12.getName() + Typography.quote;
        if (r16 == null) goto L6;
        String r20 = r16.getPresentableString();
        if (r20 == null) goto L6;
    L7:
        this.typeDeserializer = new TypeDeserializer(this, r17, r18, r19, r20);
        this.memberDeserializer = new MemberDeserializer(this);
        return;
    L6:
        r20 = "[container not found]";
        goto L7
    }

    public static /* synthetic */ DeserializationContext childContext$default(DeserializationContext r10, DeclarationDescriptor r11, List r12, NameResolver r13, TypeTable r14, VersionRequirementTable r15, BinaryVersion r16, int r17, Object r18) {
        if ((r17 & 4) == 0) goto L5;
        r13 = r10.nameResolver;
    L5:
        NameResolver r19 = r13;
        if ((r17 & 8) == 0) goto L8;
        r14 = r10.typeTable;
    L8:
        TypeTable r20 = r14;
        if ((r17 & 16) == 0) goto L11;
        r15 = r10.versionRequirementTable;
    L11:
        VersionRequirementTable r21 = r15;
        if ((r17 & 32) == 0) goto L15;
        r16 = r10.metadataVersion;
    L15:
        return r10.childContext(r11, r12, r19, r20, r21, r16);
    }

    public final DeserializationContext childContext(DeclarationDescriptor r13, List<ProtoBuf.TypeParameter> r14, NameResolver r15, TypeTable r16, VersionRequirementTable r17, BinaryVersion r18) {
        Intrinsics.checkNotNullParameter(r13, "descriptor");
        Intrinsics.checkNotNullParameter(r14, "typeParameterProtos");
        Intrinsics.checkNotNullParameter(r15, "nameResolver");
        Intrinsics.checkNotNullParameter(r16, "typeTable");
        VersionRequirementTable r10 = r17;
        Intrinsics.checkNotNullParameter(r10, "versionRequirementTable");
        Intrinsics.checkNotNullParameter(r18, "metadataVersion");
        DeserializationComponents r11 = this.components;
        if (VersionSpecificBehaviorKt.isVersionRequirementTableWrittenCorrectly(r18) == true) goto L7;
        r10 = this.versionRequirementTable;
    L7:
        return new DeserializationContext(r11, r15, r13, r16, r10, r18, this.containerSource, this.typeDeserializer, r14);
    }

    public final DeserializationComponents getComponents() {
        return this.components;
    }

    public final DeserializedContainerSource getContainerSource() {
        return this.containerSource;
    }

    public final DeclarationDescriptor getContainingDeclaration() {
        return this.containingDeclaration;
    }

    public final MemberDeserializer getMemberDeserializer() {
        return this.memberDeserializer;
    }

    public final NameResolver getNameResolver() {
        return this.nameResolver;
    }

    public final StorageManager getStorageManager() {
        return this.components.getStorageManager();
    }

    public final TypeDeserializer getTypeDeserializer() {
        return this.typeDeserializer;
    }

    public final TypeTable getTypeTable() {
        return this.typeTable;
    }

    public final VersionRequirementTable getVersionRequirementTable() {
        return this.versionRequirementTable;
    }
}

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

    public DeserializationContext(DeserializationComponents r5, NameResolver r10, DeclarationDescriptor r11, TypeTable r12, VersionRequirementTable r13, BinaryVersion r14, DeserializedContainerSource r15, TypeDeserializer r16, List<ProtoBuf.TypeParameter> r17) {
        Intrinsics.checkNotNullParameter(r5, "components");
        Intrinsics.checkNotNullParameter(r10, "nameResolver");
        Intrinsics.checkNotNullParameter(r11, "containingDeclaration");
        Intrinsics.checkNotNullParameter(r12, "typeTable");
        Intrinsics.checkNotNullParameter(r13, "versionRequirementTable");
        Intrinsics.checkNotNullParameter(r14, "metadataVersion");
        Intrinsics.checkNotNullParameter(r17, "typeParameters");
        this.components = r5;
        this.nameResolver = r10;
        this.containingDeclaration = r11;
        this.typeTable = r12;
        this.versionRequirementTable = r13;
        this.metadataVersion = r14;
        this.containerSource = r15;
        String r18 = "Deserializer for \"" + r11.getName() + Typography.quote;
        if (r15 == null) goto L8;
        String r19 = r15.getPresentableString();
        if (r19 == null) goto L8;
    L9:
        this.typeDeserializer = new TypeDeserializer(this, r16, r17, r18, r19);
        this.memberDeserializer = new MemberDeserializer(this);
        return;
    L8:
        r19 = "[container not found]";
        goto L9
    }

    public static /* synthetic */ DeserializationContext childContext$default(DeserializationContext r10, DeclarationDescriptor r11, List r12, NameResolver r13, TypeTable r14, VersionRequirementTable r15, BinaryVersion r16, int r17, Object r18) {
        if ((r17 & 4) == 0) goto L5;
        r13 = r10.nameResolver;
    L5:
        NameResolver r5 = r13;
        if ((r17 & 8) == 0) goto L8;
        r14 = r10.typeTable;
    L8:
        TypeTable r19 = r14;
        if ((r17 & 16) == 0) goto L11;
        r15 = r10.versionRequirementTable;
    L11:
        VersionRequirementTable r20 = r15;
        if ((r17 & 32) == 0) goto L15;
        r16 = r10.metadataVersion;
    L15:
        return r10.childContext(r11, r12, r5, r19, r20, r16);
    }

    public final DeserializationContext childContext(DeclarationDescriptor r13, List<ProtoBuf.TypeParameter> r14, NameResolver r15, TypeTable r16, VersionRequirementTable r17, BinaryVersion r18) {
        Intrinsics.checkNotNullParameter(r13, "descriptor");
        Intrinsics.checkNotNullParameter(r14, "typeParameterProtos");
        Intrinsics.checkNotNullParameter(r15, "nameResolver");
        Intrinsics.checkNotNullParameter(r16, "typeTable");
        VersionRequirementTable r5 = r17;
        Intrinsics.checkNotNullParameter(r5, "versionRequirementTable");
        Intrinsics.checkNotNullParameter(r18, "metadataVersion");
        DeserializationComponents r10 = this.components;
        if (VersionSpecificBehaviorKt.isVersionRequirementTableWrittenCorrectly(r18) == false) goto L5;
    L4:
        VersionRequirementTable r11 = r5;
        return new DeserializationContext(r10, r15, r13, r16, r11, r18, this.containerSource, this.typeDeserializer, r14);
    L5:
        r5 = this.versionRequirementTable;
        goto L4
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

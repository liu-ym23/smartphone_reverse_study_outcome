package androidx.room.jarjarred.kotlinx.metadata.impl;

import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.ProtoBuf;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization.NameResolver;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization.TypeTable;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization.VersionRequirementTable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0000\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0086\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\u00060\u0010j\u0002`\u00132\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0015\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u001a\u001a\u00020\u00002\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\t¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010\u0007\u001a\u00020\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010\"\u001a\u0004\b#\u0010$R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010%R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010&\u001a\u0004\b'\u0010(R \u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R \u0010-\u001a\b\u0012\u0004\u0012\u00020,0\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b-\u0010&\u001a\u0004\b.\u0010(¨\u0006/"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/impl/ReadContext;", "", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/deserialization/NameResolver;", "strings", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/deserialization/TypeTable;", "types", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/deserialization/VersionRequirementTable;", "versionRequirements", "parent", "", "Landroidx/room/jarjarred/kotlinx/metadata/impl/ReadContextExtension;", "contextExtensions", "<init>", "(Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;Lorg/jetbrains/kotlin/metadata/deserialization/VersionRequirementTable;Ljava/lang/Object;Ljava/util/List;)V", "", "index", "", "get", "(I)Ljava/lang/String;", "Landroidx/room/jarjarred/kotlinx/metadata/ClassName;", "className", "name", "getTypeParameterId", "(I)Ljava/lang/Integer;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$TypeParameter;", "typeParameters", "withTypeParameters", "(Ljava/util/List;)Landroidx/room/jarjarred/kotlinx/metadata/impl/ReadContext;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/deserialization/NameResolver;", "getStrings", "()Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/deserialization/TypeTable;", "getTypes", "()Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/deserialization/VersionRequirementTable;", "getVersionRequirements$kotlinx_metadata", "()Lorg/jetbrains/kotlin/metadata/deserialization/VersionRequirementTable;", "Landroidx/room/jarjarred/kotlinx/metadata/impl/ReadContext;", "Ljava/util/List;", "getContextExtensions", "()Ljava/util/List;", "", "typeParameterNameToId", "Ljava/util/Map;", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/MetadataExtensions;", "extensions", "getExtensions$kotlinx_metadata", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ReadContext {
    private final List<ReadContextExtension> contextExtensions;
    private final List<MetadataExtensions> extensions;
    private final ReadContext parent;
    private final NameResolver strings;
    private final Map<Integer, Integer> typeParameterNameToId;
    private final TypeTable types;
    private final VersionRequirementTable versionRequirements;

    /* JADX WARN: Multi-variable type inference failed */
    public ReadContext(NameResolver r5, TypeTable r10, VersionRequirementTable r11, ReadContext r12, List<? extends ReadContextExtension> r13) {
        Intrinsics.checkNotNullParameter(r5, "strings");
        Intrinsics.checkNotNullParameter(r10, "types");
        Intrinsics.checkNotNullParameter(r11, "versionRequirements");
        Intrinsics.checkNotNullParameter(r13, "contextExtensions");
        this.strings = r5;
        this.types = r10;
        this.versionRequirements = r11;
        this.parent = r12;
        this.contextExtensions = r13;
        this.typeParameterNameToId = new LinkedHashMap();
        this.extensions = MetadataExtensions.Companion.getINSTANCES();
    }

    public final String className(int r5) {
        return ReadUtilsKt.getClassName(this.strings, r5);
    }

    public final String get(int r5) {
        return this.strings.getString(r5);
    }

    public final List<ReadContextExtension> getContextExtensions() {
        return this.contextExtensions;
    }

    public final List<MetadataExtensions> getExtensions$kotlinx_metadata() {
        return this.extensions;
    }

    public final NameResolver getStrings() {
        return this.strings;
    }

    public final Integer getTypeParameterId(int r5) {
        Integer r10 = this.typeParameterNameToId.get(Integer.valueOf(r5));
        if (r10 != null) goto L9;
        ReadContext r11 = this.parent;
        if (r11 != null) goto L10;
        return null;
    L10:
        return r11.getTypeParameterId(r5);
    L9:
        return r10;
    }

    public final TypeTable getTypes() {
        return this.types;
    }

    public final VersionRequirementTable getVersionRequirements$kotlinx_metadata() {
        return this.versionRequirements;
    }

    public final ReadContext withTypeParameters(List<ProtoBuf.TypeParameter> r10) {
        Intrinsics.checkNotNullParameter(r10, "typeParameters");
        ReadContext r5 = new ReadContext(this.strings, this.types, this.versionRequirements, this, this.contextExtensions);
        Iterator<ProtoBuf.TypeParameter> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ProtoBuf.TypeParameter r12 = r11.next();
        r5.typeParameterNameToId.put(Integer.valueOf(r12.getName()), Integer.valueOf(r12.getId()));
        goto L4
    L6:
        return r5;
    }

    public /* synthetic */ ReadContext(NameResolver r10, TypeTable r11, VersionRequirementTable r12, ReadContext r13, List r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 8) == 0) goto L5;
        r13 = null;
    L5:
        ReadContext r5 = r13;
        if ((r15 & 16) == 0) goto L8;
        r14 = CollectionsKt.emptyList();
    L8:
        this(r10, r11, r12, r5, r14);
    }
}

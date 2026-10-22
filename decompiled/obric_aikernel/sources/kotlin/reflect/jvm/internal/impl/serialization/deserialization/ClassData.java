package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;

/* JADX INFO: loaded from: classes3.dex */
public final class ClassData {
    private final ProtoBuf.Class classProto;
    private final BinaryVersion metadataVersion;
    private final NameResolver nameResolver;
    private final SourceElement sourceElement;

    public ClassData(NameResolver r10, ProtoBuf.Class r11, BinaryVersion r12, SourceElement r13) {
        Intrinsics.checkNotNullParameter(r10, "nameResolver");
        Intrinsics.checkNotNullParameter(r11, "classProto");
        Intrinsics.checkNotNullParameter(r12, "metadataVersion");
        Intrinsics.checkNotNullParameter(r13, "sourceElement");
        this.nameResolver = r10;
        this.classProto = r11;
        this.metadataVersion = r12;
        this.sourceElement = r13;
    }

    public final NameResolver component1() {
        return this.nameResolver;
    }

    public final ProtoBuf.Class component2() {
        return this.classProto;
    }

    public final BinaryVersion component3() {
        return this.metadataVersion;
    }

    public final SourceElement component4() {
        return this.sourceElement;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ClassData) == true) goto L8;
        return false;
    L8:
        ClassData r11 = (ClassData) r10;
        if (Intrinsics.areEqual(this.nameResolver, r11.nameResolver) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.classProto, r11.classProto) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.metadataVersion, r11.metadataVersion) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.sourceElement, r11.sourceElement) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.nameResolver.hashCode() * 31) + this.classProto.hashCode()) * 31) + this.metadataVersion.hashCode()) * 31) + this.sourceElement.hashCode();
    }

    public String toString() {
        return "ClassData(nameResolver=" + this.nameResolver + ", classProto=" + this.classProto + ", metadataVersion=" + this.metadataVersion + ", sourceElement=" + this.sourceElement + ')';
    }
}

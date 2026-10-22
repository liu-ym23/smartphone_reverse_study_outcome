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

    public ClassData(NameResolver r5, ProtoBuf.Class r10, BinaryVersion r11, SourceElement r12) {
        Intrinsics.checkNotNullParameter(r5, "nameResolver");
        Intrinsics.checkNotNullParameter(r10, "classProto");
        Intrinsics.checkNotNullParameter(r11, "metadataVersion");
        Intrinsics.checkNotNullParameter(r12, "sourceElement");
        this.nameResolver = r5;
        this.classProto = r10;
        this.metadataVersion = r11;
        this.sourceElement = r12;
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

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ClassData) == true) goto L8;
        return false;
    L8:
        ClassData r10 = (ClassData) r5;
        if (Intrinsics.areEqual(this.nameResolver, r10.nameResolver) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.classProto, r10.classProto) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.metadataVersion, r10.metadataVersion) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.sourceElement, r10.sourceElement) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r5 = this.nameResolver.hashCode() * 31;
        int r10 = (this.classProto.hashCode() + r5) * 31;
        int r11 = (this.metadataVersion.hashCode() + r10) * 31;
        return this.sourceElement.hashCode() + r11;
    }

    public String toString() {
        return "ClassData(nameResolver=" + this.nameResolver + ", classProto=" + this.classProto + ", metadataVersion=" + this.metadataVersion + ", sourceElement=" + this.sourceElement + ')';
    }
}

package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ProtoContainer {
    private final NameResolver nameResolver;
    private final SourceElement source;
    private final TypeTable typeTable;

    public static final class Class extends ProtoContainer {
        private final ClassId classId;
        private final ProtoBuf.Class classProto;
        private final boolean isInner;
        private final ProtoBuf.Class.Kind kind;
        private final Class outerClass;

        public Class(ProtoBuf.Class r5, NameResolver r10, TypeTable r11, SourceElement r12, Class r13) {
            Intrinsics.checkNotNullParameter(r5, "classProto");
            Intrinsics.checkNotNullParameter(r10, "nameResolver");
            Intrinsics.checkNotNullParameter(r11, "typeTable");
            super(r10, r11, r12, null);
            this.classProto = r5;
            this.outerClass = r13;
            this.classId = NameResolverUtilKt.getClassId(r10, r5.getFqName());
            ProtoBuf.Class.Kind r14 = Flags.CLASS_KIND.get(r5.getFlags());
            if (r14 != null) goto L5;
            r14 = ProtoBuf.Class.Kind.CLASS;
        L5:
            this.kind = r14;
            this.isInner = Flags.IS_INNER.get(r5.getFlags()).booleanValue();
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer
        public FqName debugFqName() {
            return this.classId.asSingleFqName();
        }

        public final ClassId getClassId() {
            return this.classId;
        }

        public final ProtoBuf.Class getClassProto() {
            return this.classProto;
        }

        public final ProtoBuf.Class.Kind getKind() {
            return this.kind;
        }

        public final Class getOuterClass() {
            return this.outerClass;
        }

        public final boolean isInner() {
            return this.isInner;
        }
    }

    public static final class Package extends ProtoContainer {
        private final FqName fqName;

        public Package(FqName r5, NameResolver r10, TypeTable r11, SourceElement r12) {
            Intrinsics.checkNotNullParameter(r5, "fqName");
            Intrinsics.checkNotNullParameter(r10, "nameResolver");
            Intrinsics.checkNotNullParameter(r11, "typeTable");
            super(r10, r11, r12, null);
            this.fqName = r5;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer
        public FqName debugFqName() {
            return this.fqName;
        }
    }

    public /* synthetic */ ProtoContainer(NameResolver r5, TypeTable r10, SourceElement r11, DefaultConstructorMarker r12) {
        this(r5, r10, r11);
    }

    public abstract FqName debugFqName();

    public final NameResolver getNameResolver() {
        return this.nameResolver;
    }

    public final SourceElement getSource() {
        return this.source;
    }

    public final TypeTable getTypeTable() {
        return this.typeTable;
    }

    public String toString() {
        return getClass().getSimpleName() + ": " + debugFqName();
    }

    private ProtoContainer(NameResolver r5, TypeTable r10, SourceElement r11) {
        this.nameResolver = r5;
        this.typeTable = r10;
        this.source = r11;
    }
}

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

        public Class(ProtoBuf.Class r10, NameResolver r11, TypeTable r12, SourceElement r13, Class r14) {
            Intrinsics.checkNotNullParameter(r10, "classProto");
            Intrinsics.checkNotNullParameter(r11, "nameResolver");
            Intrinsics.checkNotNullParameter(r12, "typeTable");
            super(r11, r12, r13, null);
            this.classProto = r10;
            this.outerClass = r14;
            this.classId = NameResolverUtilKt.getClassId(r11, r10.getFqName());
            ProtoBuf.Class.Kind r15 = Flags.CLASS_KIND.get(r10.getFlags());
            if (r15 != null) goto L5;
            r15 = ProtoBuf.Class.Kind.CLASS;
        L5:
            this.kind = r15;
            Boolean r16 = Flags.IS_INNER.get(r10.getFlags());
            Intrinsics.checkNotNullExpressionValue(r16, "IS_INNER.get(classProto.flags)");
            this.isInner = r16.booleanValue();
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer
        public FqName debugFqName() {
            FqName r10 = this.classId.asSingleFqName();
            Intrinsics.checkNotNullExpressionValue(r10, "classId.asSingleFqName()");
            return r10;
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

        public Package(FqName r10, NameResolver r11, TypeTable r12, SourceElement r13) {
            Intrinsics.checkNotNullParameter(r10, "fqName");
            Intrinsics.checkNotNullParameter(r11, "nameResolver");
            Intrinsics.checkNotNullParameter(r12, "typeTable");
            super(r11, r12, r13, null);
            this.fqName = r10;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer
        public FqName debugFqName() {
            return this.fqName;
        }
    }

    private ProtoContainer(NameResolver r10, TypeTable r11, SourceElement r12) {
        this.nameResolver = r10;
        this.typeTable = r11;
        this.source = r12;
    }

    public /* synthetic */ ProtoContainer(NameResolver r10, TypeTable r11, SourceElement r12, DefaultConstructorMarker r13) {
        this(r10, r11, r12);
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
}

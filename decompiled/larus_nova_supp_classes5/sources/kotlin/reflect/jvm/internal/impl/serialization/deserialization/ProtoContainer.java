package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class ProtoContainer {
    private final NameResolver nameResolver;
    private final SourceElement source;
    private final TypeTable typeTable;

    public static final class Class extends ProtoContainer {
        private final ClassId classId;
        private final ProtoBuf$Class classProto;
        private final boolean isData;
        private final boolean isInner;
        private final ProtoBuf$Class.Kind kind;
        private final Class outerClass;

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer
        public FqName debugFqName() {
            return this.classId.asSingleFqName();
        }

        public final ClassId getClassId() {
            return this.classId;
        }

        public final ProtoBuf$Class getClassProto() {
            return this.classProto;
        }

        public final ProtoBuf$Class.Kind getKind() {
            return this.kind;
        }

        public final Class getOuterClass() {
            return this.outerClass;
        }

        public final boolean isInner() {
            return this.isInner;
        }

        public Class(ProtoBuf$Class r2, NameResolver r3, TypeTable r4, SourceElement r5, Class r6) {
            Intrinsics.checkNotNullParameter(r2, "classProto");
            Intrinsics.checkNotNullParameter(r3, "nameResolver");
            Intrinsics.checkNotNullParameter(r4, "typeTable");
            super(r3, r4, r5, null);
            this.classProto = r2;
            this.outerClass = r6;
            this.classId = NameResolverUtilKt.getClassId(r3, r2.getFqName());
            ProtoBuf$Class.Kind r7 = Flags.CLASS_KIND.get(r2.getFlags());
            if (r7 != null) goto L5;
            r7 = ProtoBuf$Class.Kind.CLASS;
        L5:
            this.kind = r7;
            this.isInner = Flags.IS_INNER.get(r2.getFlags()).booleanValue();
            this.isData = Flags.IS_DATA.get(r2.getFlags()).booleanValue();
        }
    }

    public /* synthetic */ ProtoContainer(NameResolver r1, TypeTable r2, SourceElement r3, DefaultConstructorMarker r4) {
        this(r1, r2, r3);
    }

    public abstract FqName debugFqName();

    public String toString() {
        return getClass().getSimpleName() + ": " + debugFqName();
    }

    public final NameResolver getNameResolver() {
        return this.nameResolver;
    }

    public final SourceElement getSource() {
        return this.source;
    }

    public final TypeTable getTypeTable() {
        return this.typeTable;
    }

    private ProtoContainer(NameResolver r1, TypeTable r2, SourceElement r3) {
        this.nameResolver = r1;
        this.typeTable = r2;
        this.source = r3;
    }
}

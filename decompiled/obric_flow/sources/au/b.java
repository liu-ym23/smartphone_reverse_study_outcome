package au;

import kotlinx.metadata.internal.metadata.ProtoBuf$Annotation;
import kotlinx.metadata.internal.metadata.ProtoBuf$Class;
import kotlinx.metadata.internal.metadata.ProtoBuf$Constructor;
import kotlinx.metadata.internal.metadata.ProtoBuf$Contract;
import kotlinx.metadata.internal.metadata.ProtoBuf$Effect;
import kotlinx.metadata.internal.metadata.ProtoBuf$EnumEntry;
import kotlinx.metadata.internal.metadata.ProtoBuf$Expression;
import kotlinx.metadata.internal.metadata.ProtoBuf$Function;
import kotlinx.metadata.internal.metadata.ProtoBuf$Package;
import kotlinx.metadata.internal.metadata.ProtoBuf$PackageFragment;
import kotlinx.metadata.internal.metadata.ProtoBuf$Property;
import kotlinx.metadata.internal.metadata.ProtoBuf$QualifiedNameTable;
import kotlinx.metadata.internal.metadata.ProtoBuf$StringTable;
import kotlinx.metadata.internal.metadata.ProtoBuf$Type;
import kotlinx.metadata.internal.metadata.ProtoBuf$TypeAlias;
import kotlinx.metadata.internal.metadata.ProtoBuf$TypeParameter;
import kotlinx.metadata.internal.metadata.ProtoBuf$TypeTable;
import kotlinx.metadata.internal.metadata.ProtoBuf$ValueParameter;
import kotlinx.metadata.internal.metadata.ProtoBuf$VersionRequirement;
import kotlinx.metadata.internal.metadata.ProtoBuf$VersionRequirementTable;
import kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf$Module;
import kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf$PackageParts;
import kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf$JvmFieldSignature;
import kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf$JvmMethodSignature;
import kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf$JvmPropertySignature;
import kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf$StringTableTypes;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends kotlinx.metadata.internal.protobuf.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f721b;

    public /* synthetic */ b(int r5) {
        this.f721b = r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.b0
    public final Object a(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) {
        switch(this.f721b) {
            case 0: goto L55;
            case 1: goto L53;
            case 2: goto L51;
            case 3: goto L49;
            case 4: goto L47;
            case 5: goto L45;
            case 6: goto L43;
            case 7: goto L41;
            case 8: goto L39;
            case 9: goto L37;
            case 10: goto L35;
            case 11: goto L33;
            case 12: goto L31;
            case 13: goto L29;
            case 14: goto L27;
            case 15: goto L25;
            case 16: goto L23;
            case 17: goto L21;
            case 18: goto L19;
            case 19: goto L17;
            case 20: goto L15;
            case 21: goto L13;
            case 22: goto L11;
            case 23: goto L9;
            case 24: goto L7;
            default: goto L5;
        };
    L5:
        return new JvmProtoBuf$StringTableTypes(r5, r10, null);
    L7:
        return new JvmProtoBuf$JvmPropertySignature(r5, r10, null);
    L9:
        return new JvmProtoBuf$JvmMethodSignature(r5, r10, null);
    L11:
        return new JvmProtoBuf$JvmFieldSignature(r5, r10, null);
    L13:
        return new JvmModuleProtoBuf$PackageParts(r5, r10, null);
    L15:
        return new JvmModuleProtoBuf$Module(r5, r10, null);
    L17:
        return new ProtoBuf$VersionRequirementTable(r5, r10, null);
    L19:
        return new ProtoBuf$VersionRequirement(r5, r10, null);
    L21:
        return new ProtoBuf$ValueParameter(r5, r10, null);
    L23:
        return new ProtoBuf$TypeTable(r5, r10, null);
    L25:
        return new ProtoBuf$TypeParameter(r5, r10, null);
    L27:
        return new ProtoBuf$TypeAlias(r5, r10, null);
    L29:
        return new ProtoBuf$Type(r5, r10, null);
    L31:
        return new ProtoBuf$StringTable(r5, r10, null);
    L33:
        return new ProtoBuf$QualifiedNameTable(r5, r10, null);
    L35:
        return new ProtoBuf$Property(r5, r10, null);
    L37:
        return new ProtoBuf$PackageFragment(r5, r10, null);
    L39:
        return new ProtoBuf$Package(r5, r10, null);
    L41:
        return new ProtoBuf$Function(r5, r10, null);
    L43:
        return new ProtoBuf$Expression(r5, r10, null);
    L45:
        return new ProtoBuf$EnumEntry(r5, r10, null);
    L47:
        return new ProtoBuf$Effect(r5, r10, null);
    L49:
        return new ProtoBuf$Contract(r5, r10, null);
    L51:
        return new ProtoBuf$Constructor(r5, r10, null);
    L53:
        return new ProtoBuf$Class(r5, r10, null);
    L55:
        return new ProtoBuf$Annotation(r5, r10, null);
    }
}

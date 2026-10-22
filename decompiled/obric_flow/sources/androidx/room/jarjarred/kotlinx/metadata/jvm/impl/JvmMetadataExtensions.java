package androidx.room.jarjarred.kotlinx.metadata.jvm.impl;

import androidx.room.jarjarred.kotlinx.metadata.KmClassExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmConstructorExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmConstructorVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmExtensionType;
import androidx.room.jarjarred.kotlinx.metadata.KmFunctionExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmFunctionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmModuleFragmentExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmModuleFragmentVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmPackageExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmPackageVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmPropertyExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmPropertyVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmTypeAliasExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmTypeAliasVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmTypeExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmTypeParameterExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmTypeParameterVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmTypeVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmValueParameterExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmValueParameterVisitor;
import androidx.room.jarjarred.kotlinx.metadata.impl.ReadContext;
import androidx.room.jarjarred.kotlinx.metadata.impl.ReadUtilsKt;
import androidx.room.jarjarred.kotlinx.metadata.impl.ReadersKt;
import androidx.room.jarjarred.kotlinx.metadata.impl.WriteContext;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.KmClassExtension;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.KmConstructorExtension;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.KmFunctionExtension;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.KmModuleFragmentExtension;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.KmPackageExtension;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.KmPropertyExtension;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.KmTypeAliasExtension;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.KmTypeExtension;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.KmTypeParameterExtension;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.KmValueParameterExtension;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.ProtoBuf;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization.ProtoBufUtilKt;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
import androidx.room.jarjarred.kotlinx.metadata.jvm.JvmClassExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.jvm.JvmConstructorExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.jvm.JvmFieldSignature;
import androidx.room.jarjarred.kotlinx.metadata.jvm.JvmFunctionExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.jvm.JvmMemberSignature;
import androidx.room.jarjarred.kotlinx.metadata.jvm.JvmMemberSignatureKt;
import androidx.room.jarjarred.kotlinx.metadata.jvm.JvmMethodSignature;
import androidx.room.jarjarred.kotlinx.metadata.jvm.JvmPackageExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.jvm.JvmPropertyExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.jvm.JvmTypeExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.jvm.JvmTypeParameterExtensionVisitor;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000²\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J \u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J \u0010\"\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J \u0010%\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020&2\u0006\u0010\u001b\u001a\u00020'2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J \u0010(\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020)2\u0006\u0010\u001b\u001a\u00020*2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J \u0010+\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020,2\u0006\u0010\u001b\u001a\u00020-2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J \u0010.\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020/2\u0006\u0010\u001b\u001a\u0002002\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J \u00101\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u0002022\u0006\u0010\u001b\u001a\u0002032\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J \u00104\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u0002052\u0006\u0010\u001b\u001a\u0002062\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J \u00107\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u0002082\u0006\u0010\u001b\u001a\u0002092\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\"\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020>2\u0006\u0010\u001d\u001a\u00020?H\u0016J\"\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010<\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020B2\u0006\u0010\u001d\u001a\u00020?H\u0016J\"\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010<\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020E2\u0006\u0010\u001d\u001a\u00020?H\u0016J\"\u0010F\u001a\u0004\u0018\u00010G2\u0006\u0010<\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020H2\u0006\u0010\u001d\u001a\u00020?H\u0016J\"\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010<\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020K2\u0006\u0010\u001d\u001a\u00020?H\u0016J\"\u0010L\u001a\u0004\u0018\u00010M2\u0006\u0010<\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020N2\u0006\u0010\u001d\u001a\u00020?H\u0016J\"\u0010O\u001a\u0004\u0018\u00010P2\u0006\u0010<\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020Q2\u0006\u0010\u001d\u001a\u00020?H\u0016J\"\u0010R\u001a\u0004\u0018\u00010S2\u0006\u0010<\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020T2\u0006\u0010\u001d\u001a\u00020?H\u0016J\"\u0010U\u001a\u0004\u0018\u00010V2\u0006\u0010<\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020W2\u0006\u0010\u001d\u001a\u00020?H\u0016J\"\u0010X\u001a\u0004\u0018\u00010Y2\u0006\u0010<\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020Z2\u0006\u0010\u001d\u001a\u00020?H\u0016J\u0014\u0010[\u001a\u00020\\*\u00020]2\u0006\u0010\u001d\u001a\u00020?H\u0002¨\u0006^"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/impl/JvmMetadataExtensions;", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/MetadataExtensions;", "()V", "createClassExtension", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/KmClassExtension;", "createConstructorExtension", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/KmConstructorExtension;", "createFunctionExtension", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/KmFunctionExtension;", "createModuleFragmentExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/KmModuleFragmentExtension;", "createPackageExtension", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/KmPackageExtension;", "createPropertyExtension", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/KmPropertyExtension;", "createTypeAliasExtension", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/KmTypeAliasExtension;", "createTypeExtension", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/KmTypeExtension;", "createTypeParameterExtension", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/KmTypeParameterExtension;", "createValueParameterExtension", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/KmValueParameterExtension;", "readClassExtensions", "", "v", "Landroidx/room/jarjarred/kotlinx/metadata/KmClassVisitor;", "proto", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Class;", "c", "Landroidx/room/jarjarred/kotlinx/metadata/impl/ReadContext;", "readConstructorExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmConstructorVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Constructor;", "readFunctionExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmFunctionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Function;", "readModuleFragmentExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmModuleFragmentVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$PackageFragment;", "readPackageExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmPackageVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Package;", "readPropertyExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmPropertyVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Property;", "readTypeAliasExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeAliasVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$TypeAlias;", "readTypeExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Type;", "readTypeParameterExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameterVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$TypeParameter;", "readValueParameterExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmValueParameterVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$ValueParameter;", "writeClassExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmClassExtensionVisitor;", "type", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Class$Builder;", "Landroidx/room/jarjarred/kotlinx/metadata/impl/WriteContext;", "writeConstructorExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmConstructorExtensionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Constructor$Builder;", "writeFunctionExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmFunctionExtensionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Function$Builder;", "writeModuleFragmentExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmModuleFragmentExtensionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$PackageFragment$Builder;", "writePackageExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmPackageExtensionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Package$Builder;", "writePropertyExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmPropertyExtensionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Property$Builder;", "writeTypeAliasExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeAliasExtensionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$TypeAlias$Builder;", "writeTypeExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeExtensionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Type$Builder;", "writeTypeParameterExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameterExtensionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$TypeParameter$Builder;", "writeValueParameterExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmValueParameterExtensionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$ValueParameter$Builder;", "toJvmMethodSignature", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/JvmProtoBuf$JvmMethodSignature;", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmMemberSignature;", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JvmMetadataExtensions implements MetadataExtensions {
    public JvmMetadataExtensions() {
    }

    public static final /* synthetic */ JvmProtoBuf.JvmMethodSignature access$toJvmMethodSignature(JvmMetadataExtensions r5, JvmMemberSignature r10, WriteContext r11) {
        return r5.toJvmMethodSignature(r10, r11);
    }

    private final JvmProtoBuf.JvmMethodSignature toJvmMethodSignature(JvmMemberSignature r5, WriteContext r10) {
        JvmProtoBuf.JvmMethodSignature.Builder r11 = JvmProtoBuf.JvmMethodSignature.newBuilder();
        r11.setName(r10.get(r5.getName()));
        r11.setDesc(r10.get(r5.getDesc()));
        return r11.build();
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions
    public KmClassExtension createClassExtension() {
        return new JvmClassExtension();
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions
    public KmConstructorExtension createConstructorExtension() {
        return new JvmConstructorExtension();
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions
    public KmFunctionExtension createFunctionExtension() {
        return new JvmFunctionExtension();
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions
    public KmModuleFragmentExtension createModuleFragmentExtensions() {
        return new AnonymousClass1();
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions
    public KmPackageExtension createPackageExtension() {
        return new JvmPackageExtension();
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions
    public KmPropertyExtension createPropertyExtension() {
        return new JvmPropertyExtension();
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions
    public KmTypeAliasExtension createTypeAliasExtension() {
        return null;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions
    public KmTypeExtension createTypeExtension() {
        return new JvmTypeExtension();
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions
    public KmTypeParameterExtension createTypeParameterExtension() {
        return new JvmTypeParameterExtension();
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions
    public KmValueParameterExtension createValueParameterExtension() {
        return null;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions
    public void readClassExtensions(KmClassVisitor r10, ProtoBuf.Class r11, ReadContext r12) {
        Intrinsics.checkNotNullParameter(r10, "v");
        Intrinsics.checkNotNullParameter(r11, "proto");
        Intrinsics.checkNotNullParameter(r12, "c");
        KmClassExtensionVisitor r5 = r10.visitExtensions(JvmClassExtensionVisitor.TYPE);
        if ((r5 instanceof JvmClassExtensionVisitor) == false) goto L5;
        JvmClassExtensionVisitor r13 = (JvmClassExtensionVisitor) r5;
    L6:
        if (r13 != null) goto L8;
        return;
    L8:
        Integer r14 = (Integer) ProtoBufUtilKt.getExtensionOrNull(r11, JvmProtoBuf.anonymousObjectOriginName);
        if (r14 == null) goto L11;
        r13.visitAnonymousObjectOriginName(r12.get(r14.intValue()));
    L11:
        Iterator r15 = ((List) r11.getExtension(JvmProtoBuf.classLocalVariable)).iterator();
    L13:
        if (r15.hasNext() == false) goto L17;
        ProtoBuf.Property r16 = (ProtoBuf.Property) r15.next();
        KmPropertyVisitor r17 = r13.visitLocalDelegatedProperty(r16.getFlags(), r12.get(r16.getName()), ReadersKt.getPropertyGetterFlags(r16), ReadersKt.getPropertySetterFlags(r16));
        if (r17 == null) goto L13;
        ReadersKt.accept(r16, r17, r12);
        goto L13
    L17:
        Integer r18 = (Integer) ProtoBufUtilKt.getExtensionOrNull(r11, JvmProtoBuf.classModuleName);
        if (r18 == null) goto L21;
        String r19 = r12.get(r18.intValue());
        if (r19 == null) goto L21;
    L22:
        r13.visitModuleName(r19);
        Integer r20 = (Integer) ProtoBufUtilKt.getExtensionOrNull(r11, JvmProtoBuf.jvmClassFlags);
        if (r20 == null) goto L25;
        r13.visitJvmFlags(r20.intValue());
    L25:
        r13.visitEnd();
        return;
    L21:
        r19 = JvmProtoBufUtil.DEFAULT_MODULE_NAME;
        goto L22
    L5:
        r13 = null;
        goto L6
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions
    public void readConstructorExtensions(KmConstructorVisitor r5, ProtoBuf.Constructor r10, ReadContext r11) {
        Intrinsics.checkNotNullParameter(r5, "v");
        Intrinsics.checkNotNullParameter(r10, "proto");
        Intrinsics.checkNotNullParameter(r11, "c");
        KmConstructorExtensionVisitor r12 = r5.visitExtensions(JvmConstructorExtensionVisitor.TYPE);
        JvmMethodSignature r13 = null;
        if ((r12 instanceof JvmConstructorExtensionVisitor) == false) goto L5;
        JvmConstructorExtensionVisitor r14 = (JvmConstructorExtensionVisitor) r12;
    L6:
        if (r14 != null) goto L8;
        return;
    L8:
        androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization.JvmMemberSignature.Method r15 = JvmProtoBufUtil.INSTANCE.getJvmConstructorSignature(r10, r11.getStrings(), r11.getTypes());
        if (r15 == null) goto L11;
        r13 = JvmMemberSignatureKt.wrapAsPublic(r15);
    L11:
        r14.visit(r13);
        return;
    L5:
        r14 = null;
        goto L6
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions
    public void readFunctionExtensions(KmFunctionVisitor r5, ProtoBuf.Function r10, ReadContext r11) {
        Intrinsics.checkNotNullParameter(r5, "v");
        Intrinsics.checkNotNullParameter(r10, "proto");
        Intrinsics.checkNotNullParameter(r11, "c");
        KmFunctionExtensionVisitor r12 = r5.visitExtensions(JvmFunctionExtensionVisitor.TYPE);
        JvmMethodSignature r13 = null;
        if ((r12 instanceof JvmFunctionExtensionVisitor) == false) goto L5;
        JvmFunctionExtensionVisitor r14 = (JvmFunctionExtensionVisitor) r12;
    L6:
        if (r14 != null) goto L8;
        return;
    L8:
        androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization.JvmMemberSignature.Method r15 = JvmProtoBufUtil.INSTANCE.getJvmMethodSignature(r10, r11.getStrings(), r11.getTypes());
        if (r15 == null) goto L11;
        r13 = JvmMemberSignatureKt.wrapAsPublic(r15);
    L11:
        r14.visit(r13);
        Integer r16 = (Integer) ProtoBufUtilKt.getExtensionOrNull(r10, JvmProtoBuf.lambdaClassOriginName);
        if (r16 == null) goto L14;
        r14.visitLambdaClassOriginName(r11.get(r16.intValue()));
    L14:
        r14.visitEnd();
        return;
    L5:
        r14 = null;
        goto L6
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions
    public void readModuleFragmentExtensions(KmModuleFragmentVisitor r5, ProtoBuf.PackageFragment r10, ReadContext r11) {
        Intrinsics.checkNotNullParameter(r5, "v");
        Intrinsics.checkNotNullParameter(r10, "proto");
        Intrinsics.checkNotNullParameter(r11, "c");
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions
    public void readPackageExtensions(KmPackageVisitor r10, ProtoBuf.Package r11, ReadContext r12) {
        Intrinsics.checkNotNullParameter(r10, "v");
        Intrinsics.checkNotNullParameter(r11, "proto");
        Intrinsics.checkNotNullParameter(r12, "c");
        KmPackageExtensionVisitor r5 = r10.visitExtensions(JvmPackageExtensionVisitor.TYPE);
        if ((r5 instanceof JvmPackageExtensionVisitor) == false) goto L5;
        JvmPackageExtensionVisitor r13 = (JvmPackageExtensionVisitor) r5;
    L6:
        if (r13 != null) goto L8;
        return;
    L8:
        Iterator r14 = ((List) r11.getExtension(JvmProtoBuf.packageLocalVariable)).iterator();
    L10:
        if (r14.hasNext() == false) goto L14;
        ProtoBuf.Property r15 = (ProtoBuf.Property) r14.next();
        KmPropertyVisitor r16 = r13.visitLocalDelegatedProperty(r15.getFlags(), r12.get(r15.getName()), ReadersKt.getPropertyGetterFlags(r15), ReadersKt.getPropertySetterFlags(r15));
        if (r16 == null) goto L10;
        ReadersKt.accept(r15, r16, r12);
        goto L10
    L14:
        Integer r17 = (Integer) ProtoBufUtilKt.getExtensionOrNull(r11, JvmProtoBuf.packageModuleName);
        if (r17 == null) goto L18;
        String r18 = r12.get(r17.intValue());
        if (r18 == null) goto L18;
    L19:
        r13.visitModuleName(r18);
        r13.visitEnd();
        return;
    L18:
        r18 = JvmProtoBufUtil.DEFAULT_MODULE_NAME;
        goto L19
    L5:
        r13 = null;
        goto L6
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions
    public void readPropertyExtensions(KmPropertyVisitor r10, ProtoBuf.Property r11, ReadContext r12) {
        Intrinsics.checkNotNullParameter(r10, "v");
        Intrinsics.checkNotNullParameter(r11, "proto");
        Intrinsics.checkNotNullParameter(r12, "c");
        KmPropertyExtensionVisitor r13 = r10.visitExtensions(JvmPropertyExtensionVisitor.TYPE);
        JvmMethodSignature r5 = null;
        if ((r13 instanceof JvmPropertyExtensionVisitor) == false) goto L5;
        JvmPropertyExtensionVisitor r14 = (JvmPropertyExtensionVisitor) r13;
    L6:
        if (r14 != null) goto L8;
        return;
    L8:
        androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization.JvmMemberSignature.Field r15 = JvmProtoBufUtil.getJvmFieldSignature$default(JvmProtoBufUtil.INSTANCE, r11, r12.getStrings(), r12.getTypes(), false, 8, null);
        JvmProtoBuf.JvmPropertySignature r16 = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull(r11, JvmProtoBuf.propertySignature);
        if (r16 != null) goto L11;
    L13:
        JvmProtoBuf.JvmMethodSignature r17 = null;
    L14:
        if (r16 != null) goto L16;
    L18:
        JvmProtoBuf.JvmMethodSignature r18 = null;
    L19:
        int r19 = ((Number) r11.getExtension(JvmProtoBuf.flags)).intValue();
        if (r15 == null) goto L22;
        JvmFieldSignature r20 = JvmMemberSignatureKt.wrapAsPublic(r15);
    L23:
        if (r17 == null) goto L25;
        JvmMethodSignature r21 = new JvmMethodSignature(r12.get(r17.getName()), r12.get(r17.getDesc()));
    L26:
        if (r18 == null) goto L28;
        JvmMethodSignature r22 = new JvmMethodSignature(r12.get(r18.getName()), r12.get(r18.getDesc()));
    L29:
        r14.visit(r19, r20, r21, r22);
        if (r16 != null) goto L32;
    L34:
        JvmProtoBuf.JvmMethodSignature r23 = null;
    L35:
        if (r23 == null) goto L37;
        JvmMethodSignature r110 = new JvmMethodSignature(r12.get(r23.getName()), r12.get(r23.getDesc()));
    L38:
        r14.visitSyntheticMethodForAnnotations(r110);
        if (r16 != null) goto L41;
    L43:
        JvmProtoBuf.JvmMethodSignature r24 = null;
    L44:
        if (r24 == null) goto L46;
        r5 = new JvmMethodSignature(r12.get(r24.getName()), r12.get(r24.getDesc()));
    L46:
        r14.visitSyntheticMethodForDelegate(r5);
        r14.visitEnd();
        return;
    L41:
        if (r16.hasDelegateMethod() == false) goto L43;
        r24 = r16.getDelegateMethod();
        goto L44
    L37:
        r110 = null;
        goto L38
    L32:
        if (r16.hasSyntheticMethod() == false) goto L34;
        r23 = r16.getSyntheticMethod();
        goto L35
    L28:
        r22 = null;
        goto L29
    L25:
        r21 = null;
        goto L26
    L22:
        r20 = null;
        goto L23
    L16:
        if (r16.hasSetter() == false) goto L18;
        r18 = r16.getSetter();
        goto L19
    L11:
        if (r16.hasGetter() == false) goto L13;
        r17 = r16.getGetter();
        goto L14
    L5:
        r14 = null;
        goto L6
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions
    public void readTypeAliasExtensions(KmTypeAliasVisitor r5, ProtoBuf.TypeAlias r10, ReadContext r11) {
        Intrinsics.checkNotNullParameter(r5, "v");
        Intrinsics.checkNotNullParameter(r10, "proto");
        Intrinsics.checkNotNullParameter(r11, "c");
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions
    public void readTypeExtensions(KmTypeVisitor r5, ProtoBuf.Type r10, ReadContext r11) {
        Intrinsics.checkNotNullParameter(r5, "v");
        Intrinsics.checkNotNullParameter(r10, "proto");
        Intrinsics.checkNotNullParameter(r11, "c");
        KmTypeExtensionVisitor r12 = r5.visitExtensions(JvmTypeExtensionVisitor.TYPE);
        if ((r12 instanceof JvmTypeExtensionVisitor) == false) goto L5;
        JvmTypeExtensionVisitor r13 = (JvmTypeExtensionVisitor) r12;
    L6:
        if (r13 != null) goto L8;
        return;
    L8:
        r13.visit(((Boolean) r10.getExtension(JvmProtoBuf.isRaw)).booleanValue());
        Iterator r14 = ((List) r10.getExtension(JvmProtoBuf.typeAnnotation)).iterator();
    L10:
        if (r14.hasNext() == false) goto L12;
        r13.visitAnnotation(ReadUtilsKt.readAnnotation((ProtoBuf.Annotation) r14.next(), r11.getStrings()));
        goto L10
    L12:
        r13.visitEnd();
        return;
    L5:
        r13 = null;
        goto L6
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions
    public void readTypeParameterExtensions(KmTypeParameterVisitor r5, ProtoBuf.TypeParameter r10, ReadContext r11) {
        Intrinsics.checkNotNullParameter(r5, "v");
        Intrinsics.checkNotNullParameter(r10, "proto");
        Intrinsics.checkNotNullParameter(r11, "c");
        KmTypeParameterExtensionVisitor r12 = r5.visitExtensions(JvmTypeParameterExtensionVisitor.TYPE);
        if ((r12 instanceof JvmTypeParameterExtensionVisitor) == false) goto L5;
        JvmTypeParameterExtensionVisitor r13 = (JvmTypeParameterExtensionVisitor) r12;
    L6:
        if (r13 != null) goto L8;
        return;
    L8:
        Iterator r14 = ((List) r10.getExtension(JvmProtoBuf.typeParameterAnnotation)).iterator();
    L10:
        if (r14.hasNext() == false) goto L12;
        r13.visitAnnotation(ReadUtilsKt.readAnnotation((ProtoBuf.Annotation) r14.next(), r11.getStrings()));
        goto L10
    L12:
        r13.visitEnd();
        return;
    L5:
        r13 = null;
        goto L6
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions
    public void readValueParameterExtensions(KmValueParameterVisitor r5, ProtoBuf.ValueParameter r10, ReadContext r11) {
        Intrinsics.checkNotNullParameter(r5, "v");
        Intrinsics.checkNotNullParameter(r10, "proto");
        Intrinsics.checkNotNullParameter(r11, "c");
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions
    public KmClassExtensionVisitor writeClassExtensions(KmExtensionType r5, final ProtoBuf.Class.Builder r10, final WriteContext r11) {
        Intrinsics.checkNotNullParameter(r5, "type");
        Intrinsics.checkNotNullParameter(r10, "proto");
        Intrinsics.checkNotNullParameter(r11, "c");
        if (Intrinsics.areEqual(r5, JvmClassExtensionVisitor.TYPE) == true) goto L7;
        return null;
    L7:
        return new C01291(r10, r11);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions
    public KmConstructorExtensionVisitor writeConstructorExtensions(KmExtensionType r5, final ProtoBuf.Constructor.Builder r10, final WriteContext r11) {
        Intrinsics.checkNotNullParameter(r5, "type");
        Intrinsics.checkNotNullParameter(r10, "proto");
        Intrinsics.checkNotNullParameter(r11, "c");
        if (Intrinsics.areEqual(r5, JvmConstructorExtensionVisitor.TYPE) == true) goto L7;
        return null;
    L7:
        return new C01301(r10, this, r11);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions
    public KmFunctionExtensionVisitor writeFunctionExtensions(KmExtensionType r5, final ProtoBuf.Function.Builder r10, final WriteContext r11) {
        Intrinsics.checkNotNullParameter(r5, "type");
        Intrinsics.checkNotNullParameter(r10, "proto");
        Intrinsics.checkNotNullParameter(r11, "c");
        if (Intrinsics.areEqual(r5, JvmFunctionExtensionVisitor.TYPE) == true) goto L7;
        return null;
    L7:
        return new C01311(r10, this, r11);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions
    public KmModuleFragmentExtensionVisitor writeModuleFragmentExtensions(KmExtensionType r5, ProtoBuf.PackageFragment.Builder r10, WriteContext r11) {
        Intrinsics.checkNotNullParameter(r5, "type");
        Intrinsics.checkNotNullParameter(r10, "proto");
        Intrinsics.checkNotNullParameter(r11, "c");
        return null;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions
    public KmPackageExtensionVisitor writePackageExtensions(KmExtensionType r5, final ProtoBuf.Package.Builder r10, final WriteContext r11) {
        Intrinsics.checkNotNullParameter(r5, "type");
        Intrinsics.checkNotNullParameter(r10, "proto");
        Intrinsics.checkNotNullParameter(r11, "c");
        if (Intrinsics.areEqual(r5, JvmPackageExtensionVisitor.TYPE) == true) goto L7;
        return null;
    L7:
        return new C01321(r11, r10);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions
    public KmPropertyExtensionVisitor writePropertyExtensions(KmExtensionType r5, final ProtoBuf.Property.Builder r10, final WriteContext r11) {
        Intrinsics.checkNotNullParameter(r5, "type");
        Intrinsics.checkNotNullParameter(r10, "proto");
        Intrinsics.checkNotNullParameter(r11, "c");
        if (Intrinsics.areEqual(r5, JvmPropertyExtensionVisitor.TYPE) == true) goto L7;
        return null;
    L7:
        return new C01331(this, r11, r10);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions
    public KmTypeAliasExtensionVisitor writeTypeAliasExtensions(KmExtensionType r5, ProtoBuf.TypeAlias.Builder r10, WriteContext r11) {
        Intrinsics.checkNotNullParameter(r5, "type");
        Intrinsics.checkNotNullParameter(r10, "proto");
        Intrinsics.checkNotNullParameter(r11, "c");
        return null;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions
    public KmTypeExtensionVisitor writeTypeExtensions(KmExtensionType r5, final ProtoBuf.Type.Builder r10, final WriteContext r11) {
        Intrinsics.checkNotNullParameter(r5, "type");
        Intrinsics.checkNotNullParameter(r10, "proto");
        Intrinsics.checkNotNullParameter(r11, "c");
        if (Intrinsics.areEqual(r5, JvmTypeExtensionVisitor.TYPE) == true) goto L7;
        return null;
    L7:
        return new C01341(r10, r11);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions
    public KmTypeParameterExtensionVisitor writeTypeParameterExtensions(KmExtensionType r5, final ProtoBuf.TypeParameter.Builder r10, final WriteContext r11) {
        Intrinsics.checkNotNullParameter(r5, "type");
        Intrinsics.checkNotNullParameter(r10, "proto");
        Intrinsics.checkNotNullParameter(r11, "c");
        if (Intrinsics.areEqual(r5, JvmTypeParameterExtensionVisitor.TYPE) == true) goto L7;
        return null;
    L7:
        return new C01351(r10, r11);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions
    public KmValueParameterExtensionVisitor writeValueParameterExtensions(KmExtensionType r5, ProtoBuf.ValueParameter.Builder r10, WriteContext r11) {
        Intrinsics.checkNotNullParameter(r5, "type");
        Intrinsics.checkNotNullParameter(r10, "proto");
        Intrinsics.checkNotNullParameter(r11, "c");
        return null;
    }
}

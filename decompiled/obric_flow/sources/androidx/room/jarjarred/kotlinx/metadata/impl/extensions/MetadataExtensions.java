package androidx.room.jarjarred.kotlinx.metadata.impl.extensions;

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
import androidx.room.jarjarred.kotlinx.metadata.impl.WriteContext;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.ProtoBuf;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¨\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 Z2\u00020\u0001:\u0001ZJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\b\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0013H&J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH&J \u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u001dH&J \u0010!\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\"2\u0006\u0010\u001a\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\u001dH&J \u0010$\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020&2\u0006\u0010\u001c\u001a\u00020\u001dH&J \u0010'\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020(2\u0006\u0010\u001a\u001a\u00020)2\u0006\u0010\u001c\u001a\u00020\u001dH&J \u0010*\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020+2\u0006\u0010\u001a\u001a\u00020,2\u0006\u0010\u001c\u001a\u00020\u001dH&J \u0010-\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020.2\u0006\u0010\u001a\u001a\u00020/2\u0006\u0010\u001c\u001a\u00020\u001dH&J \u00100\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u0002012\u0006\u0010\u001a\u001a\u0002022\u0006\u0010\u001c\u001a\u00020\u001dH&J \u00103\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u0002042\u0006\u0010\u001a\u001a\u0002052\u0006\u0010\u001c\u001a\u00020\u001dH&J \u00106\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u0002072\u0006\u0010\u001a\u001a\u0002082\u0006\u0010\u001c\u001a\u00020\u001dH&J\"\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u001a\u001a\u00020=2\u0006\u0010\u001c\u001a\u00020>H&J\"\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u001a\u001a\u00020A2\u0006\u0010\u001c\u001a\u00020>H&J\"\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u001a\u001a\u00020D2\u0006\u0010\u001c\u001a\u00020>H&J\"\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u001a\u001a\u00020G2\u0006\u0010\u001c\u001a\u00020>H&J\"\u0010H\u001a\u0004\u0018\u00010I2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u001a\u001a\u00020J2\u0006\u0010\u001c\u001a\u00020>H&J\"\u0010K\u001a\u0004\u0018\u00010L2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u001a\u001a\u00020M2\u0006\u0010\u001c\u001a\u00020>H&J\"\u0010N\u001a\u0004\u0018\u00010O2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u001a\u001a\u00020P2\u0006\u0010\u001c\u001a\u00020>H&J\"\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u001a\u001a\u00020S2\u0006\u0010\u001c\u001a\u00020>H&J\"\u0010T\u001a\u0004\u0018\u00010U2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u001a\u001a\u00020V2\u0006\u0010\u001c\u001a\u00020>H&J\"\u0010W\u001a\u0004\u0018\u00010X2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u001a\u001a\u00020Y2\u0006\u0010\u001c\u001a\u00020>H&¨\u0006["}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/MetadataExtensions;", "", "createClassExtension", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/KmClassExtension;", "createConstructorExtension", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/KmConstructorExtension;", "createFunctionExtension", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/KmFunctionExtension;", "createModuleFragmentExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/KmModuleFragmentExtension;", "createPackageExtension", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/KmPackageExtension;", "createPropertyExtension", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/KmPropertyExtension;", "createTypeAliasExtension", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/KmTypeAliasExtension;", "createTypeExtension", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/KmTypeExtension;", "createTypeParameterExtension", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/KmTypeParameterExtension;", "createValueParameterExtension", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/KmValueParameterExtension;", "readClassExtensions", "", "v", "Landroidx/room/jarjarred/kotlinx/metadata/KmClassVisitor;", "proto", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Class;", "c", "Landroidx/room/jarjarred/kotlinx/metadata/impl/ReadContext;", "readConstructorExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmConstructorVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Constructor;", "readFunctionExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmFunctionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Function;", "readModuleFragmentExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmModuleFragmentVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$PackageFragment;", "readPackageExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmPackageVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Package;", "readPropertyExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmPropertyVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Property;", "readTypeAliasExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeAliasVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$TypeAlias;", "readTypeExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Type;", "readTypeParameterExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameterVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$TypeParameter;", "readValueParameterExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmValueParameterVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$ValueParameter;", "writeClassExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmClassExtensionVisitor;", "type", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Class$Builder;", "Landroidx/room/jarjarred/kotlinx/metadata/impl/WriteContext;", "writeConstructorExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmConstructorExtensionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Constructor$Builder;", "writeFunctionExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmFunctionExtensionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Function$Builder;", "writeModuleFragmentExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmModuleFragmentExtensionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$PackageFragment$Builder;", "writePackageExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmPackageExtensionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Package$Builder;", "writePropertyExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmPropertyExtensionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Property$Builder;", "writeTypeAliasExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeAliasExtensionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$TypeAlias$Builder;", "writeTypeExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeExtensionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Type$Builder;", "writeTypeParameterExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameterExtensionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$TypeParameter$Builder;", "writeValueParameterExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmValueParameterExtensionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$ValueParameter$Builder;", "Companion", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface MetadataExtensions {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/MetadataExtensions$Companion;", "", "()V", "INSTANCES", "", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/MetadataExtensions;", "getINSTANCES", "()Ljava/util/List;", "INSTANCES$delegate", "Lkotlin/Lazy;", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final Lazy<List<MetadataExtensions>> INSTANCES$delegate = null;

        static {
            $$INSTANCE = new Companion();
            INSTANCES$delegate = LazyKt.lazy(MetadataExtensions$Companion$INSTANCES$2.INSTANCE);
        }

        private Companion() {
        }

        public final List<MetadataExtensions> getINSTANCES() {
            return INSTANCES$delegate.getValue();
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    KmClassExtension createClassExtension();

    KmConstructorExtension createConstructorExtension();

    KmFunctionExtension createFunctionExtension();

    KmModuleFragmentExtension createModuleFragmentExtensions();

    KmPackageExtension createPackageExtension();

    KmPropertyExtension createPropertyExtension();

    KmTypeAliasExtension createTypeAliasExtension();

    KmTypeExtension createTypeExtension();

    KmTypeParameterExtension createTypeParameterExtension();

    KmValueParameterExtension createValueParameterExtension();

    void readClassExtensions(KmClassVisitor r5, ProtoBuf.Class r10, ReadContext r11);

    void readConstructorExtensions(KmConstructorVisitor r5, ProtoBuf.Constructor r10, ReadContext r11);

    void readFunctionExtensions(KmFunctionVisitor r5, ProtoBuf.Function r10, ReadContext r11);

    void readModuleFragmentExtensions(KmModuleFragmentVisitor r5, ProtoBuf.PackageFragment r10, ReadContext r11);

    void readPackageExtensions(KmPackageVisitor r5, ProtoBuf.Package r10, ReadContext r11);

    void readPropertyExtensions(KmPropertyVisitor r5, ProtoBuf.Property r10, ReadContext r11);

    void readTypeAliasExtensions(KmTypeAliasVisitor r5, ProtoBuf.TypeAlias r10, ReadContext r11);

    void readTypeExtensions(KmTypeVisitor r5, ProtoBuf.Type r10, ReadContext r11);

    void readTypeParameterExtensions(KmTypeParameterVisitor r5, ProtoBuf.TypeParameter r10, ReadContext r11);

    void readValueParameterExtensions(KmValueParameterVisitor r5, ProtoBuf.ValueParameter r10, ReadContext r11);

    KmClassExtensionVisitor writeClassExtensions(KmExtensionType r5, ProtoBuf.Class.Builder r10, WriteContext r11);

    KmConstructorExtensionVisitor writeConstructorExtensions(KmExtensionType r5, ProtoBuf.Constructor.Builder r10, WriteContext r11);

    KmFunctionExtensionVisitor writeFunctionExtensions(KmExtensionType r5, ProtoBuf.Function.Builder r10, WriteContext r11);

    KmModuleFragmentExtensionVisitor writeModuleFragmentExtensions(KmExtensionType r5, ProtoBuf.PackageFragment.Builder r10, WriteContext r11);

    KmPackageExtensionVisitor writePackageExtensions(KmExtensionType r5, ProtoBuf.Package.Builder r10, WriteContext r11);

    KmPropertyExtensionVisitor writePropertyExtensions(KmExtensionType r5, ProtoBuf.Property.Builder r10, WriteContext r11);

    KmTypeAliasExtensionVisitor writeTypeAliasExtensions(KmExtensionType r5, ProtoBuf.TypeAlias.Builder r10, WriteContext r11);

    KmTypeExtensionVisitor writeTypeExtensions(KmExtensionType r5, ProtoBuf.Type.Builder r10, WriteContext r11);

    KmTypeParameterExtensionVisitor writeTypeParameterExtensions(KmExtensionType r5, ProtoBuf.TypeParameter.Builder r10, WriteContext r11);

    KmValueParameterExtensionVisitor writeValueParameterExtensions(KmExtensionType r5, ProtoBuf.ValueParameter.Builder r10, WriteContext r11);
}

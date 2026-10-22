package androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization;

import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.ProtoBuf;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.builtins.BuiltInsProtoBuf;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization.NameResolverImpl;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization.VersionSpecificBehaviorKt;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf;
import androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ExtensionRegistryLite;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B3\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u0006J\b\u0010\u0014\u001a\u00020\u0006H\u0016R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/deserialization/ModuleMapping;", "", "version", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/deserialization/JvmMetadataVersion;", "packageFqName2Parts", "", "", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/deserialization/PackageParts;", "moduleData", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/deserialization/BinaryModuleData;", "debugName", "(Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMetadataVersion;Ljava/util/Map;Lorg/jetbrains/kotlin/metadata/jvm/deserialization/BinaryModuleData;Ljava/lang/String;)V", "getModuleData", "()Lorg/jetbrains/kotlin/metadata/jvm/deserialization/BinaryModuleData;", "getPackageFqName2Parts", "()Ljava/util/Map;", "getVersion", "()Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMetadataVersion;", "findPackageParts", "packageFqName", "toString", "Companion", "metadata.jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ModuleMapping {

    @JvmField
    public static final ModuleMapping CORRUPTED = null;
    public static final Companion Companion = null;

    @JvmField
    public static final ModuleMapping EMPTY = null;
    public static final String MAPPING_FILE_EXT = "kotlin_module";
    public static final int STRICT_METADATA_VERSION_SEMANTICS_FLAG = 1;
    private final String debugName;
    private final BinaryModuleData moduleData;
    private final Map<String, PackageParts> packageFqName2Parts;
    private final JvmMetadataVersion version;

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J<\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014J6\u0010\u0017\u001a\u0004\u0018\u00010\u00072\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u00192\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/deserialization/ModuleMapping$Companion;", "", "()V", "CORRUPTED", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/deserialization/ModuleMapping;", "EMPTY", "MAPPING_FILE_EXT", "", "STRICT_METADATA_VERSION_SEMANTICS_FLAG", "", "emptyBinaryData", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/deserialization/BinaryModuleData;", "loadModuleMapping", "bytes", "", "debugName", "skipMetadataVersionCheck", "", "isJvmPackageNameSupported", "reportIncompatibleVersionError", "Lkotlin/Function1;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/deserialization/JvmMetadataVersion;", "", "loadMultiFileFacadeInternalName", "multifileFacadeIds", "", "multifileFacadeShortNames", "index", "packageFqName", "readVersionNumber", "", "stream", "Ljava/io/DataInputStream;", "metadata.jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public static final /* synthetic */ BinaryModuleData access$emptyBinaryData(Companion r5) {
            return r5.emptyBinaryData();
        }

        private final BinaryModuleData emptyBinaryData() {
            return new BinaryModuleData(CollectionsKt.emptyList(), CollectionsKt.emptyList(), new NameResolverImpl(ProtoBuf.StringTable.getDefaultInstance(), ProtoBuf.QualifiedNameTable.getDefaultInstance()));
        }

        private final String loadMultiFileFacadeInternalName(List<Integer> r5, List<String> r10, int r11, String r12) {
            Integer r13 = (Integer) CollectionsKt.getOrNull(r5, r11);
            if (r13 == null) goto L5;
            Integer r14 = Integer.valueOf(r13.intValue() - 1);
        L6:
            if (r14 == null) goto L8;
            String r15 = (String) CollectionsKt.getOrNull(r10, r14.intValue());
        L9:
            if (r15 != null) goto L11;
            return null;
        L11:
            return ModuleMappingKt.access$internalNameOf(r12, r15);
        L8:
            r15 = null;
            goto L9
        L5:
            r14 = null;
            goto L6
        }

        public final ModuleMapping loadModuleMapping(byte[] r17, String r18, boolean r19, boolean r20, Function1<? super JvmMetadataVersion, Unit> r21) {
            Intrinsics.checkNotNullParameter(r18, "debugName");
            Intrinsics.checkNotNullParameter(r21, "reportIncompatibleVersionError");
            if (r17 == null) goto L5;
            DataInputStream r5 = new DataInputStream(new ByteArrayInputStream(r17));
            int[] r10 = readVersionNumber(r5);
            if (r10 == null) goto L9;
            JvmMetadataVersion r11 = new JvmMetadataVersion(Arrays.copyOf(r10, r10.length));
            if (r19 == true) goto L17;
            if (r11.isCompatible() == true) goto L17;
            r21.invoke(r11);
            return ModuleMapping.EMPTY;
        L17:
            if (VersionSpecificBehaviorKt.isKotlin1Dot4OrLater(r11) == false) goto L19;
            int r12 = r5.readInt();
        L20:
            boolean r13 = true;
            if ((r12 & 1) != 0) goto L24;
            r13 = false;
        L24:
            JvmMetadataVersion r14 = new JvmMetadataVersion(r10, r13);
            if (r19 == false) goto L27;
        L30:
            ExtensionRegistryLite r15 = ExtensionRegistryLite.newInstance();
            BuiltInsProtoBuf.registerAllExtensions(r15);
            JvmModuleProtoBuf.Module r16 = JvmModuleProtoBuf.Module.parseFrom(r5, r15);
            if (r16 == null) goto L33;
            LinkedHashMap r22 = new LinkedHashMap();
            Iterator<JvmModuleProtoBuf.PackageParts> r23 = r16.getPackagePartsList().iterator();
        L36:
            if (r23.hasNext() == false) goto L59;
            JvmModuleProtoBuf.PackageParts r24 = r23.next();
            String r25 = r24.getPackageFqName();
            Object r26 = r22.get(r25);
            if (r26 != null) goto L40;
            r26 = new PackageParts(r25);
            r22.put(r25, r26);
        L40:
            PackageParts r27 = (PackageParts) r26;
            Iterator<String> r110 = r24.getShortClassNameList().iterator();
            int r111 = 0;
        L42:
            if (r110.hasNext() == false) goto L44;
            r27.addPart(ModuleMappingKt.access$internalNameOf(r25, r110.next()), loadMultiFileFacadeInternalName(r24.getMultifileFacadeShortNameIdList(), r24.getMultifileFacadeShortNameList(), r111, r25));
            r111 = r111 + 1;
            goto L42
        L44:
            if (r20 == false) goto L36;
            Iterator<String> r28 = r24.getClassWithJvmPackageNameShortNameList().iterator();
            int r112 = 0;
        L47:
            if (r28.hasNext() == false) goto L36;
            int r113 = r112 + 1;
            String r114 = r28.next();
            Integer r115 = (Integer) CollectionsKt.getOrNull(r24.getClassWithJvmPackageNamePackageIdList(), r112);
            if (r115 != null) goto L54;
            r115 = (Integer) CollectionsKt.lastOrNull(r24.getClassWithJvmPackageNamePackageIdList());
            if (r115 != null) goto L54;
        L58:
            r112 = r113;
        L54:
            String r116 = (String) CollectionsKt.getOrNull(r16.getJvmPackageNameList(), r115.intValue());
            if (r116 == null) goto L58;
            r27.addPart(ModuleMappingKt.access$internalNameOf(r116, r114), loadMultiFileFacadeInternalName(r24.getClassWithJvmPackageNameMultifileFacadeShortNameIdList(), r24.getMultifileFacadeShortNameList(), r112, r116));
            goto L58
        L59:
            Iterator<JvmModuleProtoBuf.PackageParts> r29 = r16.getMetadataPartsList().iterator();
        L61:
            if (r29.hasNext() == false) goto L69;
            JvmModuleProtoBuf.PackageParts r30 = r29.next();
            String r31 = r30.getPackageFqName();
            Object r32 = r22.get(r31);
            if (r32 != null) goto L65;
            r32 = new PackageParts(r30.getPackageFqName());
            r22.put(r31, r32);
        L65:
            PackageParts r33 = (PackageParts) r32;
            Iterator<String> r34 = r30.getShortClassNameList().iterator();
        L67:
            if (r34.hasNext() == false) goto L61;
            r33.addMetadataPart(r34.next());
            goto L67
        L69:
            NameResolverImpl r35 = new NameResolverImpl(r16.getStringTable(), r16.getQualifiedNameTable());
            List<ProtoBuf.Annotation> r36 = r16.getAnnotationList();
            ArrayList r37 = new ArrayList(CollectionsKt.h(r36));
            Iterator<T> r38 = r36.iterator();
        L71:
            if (r38.hasNext() == false) goto L74;
            r37.add(r35.getQualifiedClassName(((ProtoBuf.Annotation) r38.next()).getId()));
            goto L71
        L74:
            return new ModuleMapping(r14, r22, new BinaryModuleData(r37, r16.getOptionalAnnotationClassList(), r35), r18, null);
        L33:
            return ModuleMapping.EMPTY;
        L27:
            if (r14.isCompatible() == true) goto L30;
            r21.invoke(r14);
            return ModuleMapping.EMPTY;
        L19:
            r12 = 0;
            goto L20
        L9:
            return ModuleMapping.CORRUPTED;
        L5:
            return ModuleMapping.EMPTY;
        }

        public final int[] readVersionNumber(DataInputStream r5) {
            Intrinsics.checkNotNullParameter(r5, "stream");
            int r10 = r5.readInt();     // Catch: IOException -> L14
            if (r10 >= 0) goto L6;
            return null;
        L6:
            if (r10 > 1024) goto L19;
            int[] r11 = new int[r10];     // Catch: IOException -> L14
            int r12 = 0;
        L9:
            if (r12 >= r10) goto L13;
            r11[r12] = r5.readInt();     // Catch: IOException -> L14
            r12 = r12 + 1;
            goto L9
        L13:
            return r11;
        L19:
            return null;
        L20:
            return null;
        }

        private Companion() {
        }
    }

    static {
        Companion r5 = new Companion(null);
        Companion = r5;
        JvmMetadataVersion r10 = JvmMetadataVersion.INSTANCE;
        EMPTY = new ModuleMapping(r10, MapsKt.emptyMap(), Companion.access$emptyBinaryData(r5), "EMPTY");
        CORRUPTED = new ModuleMapping(r10, MapsKt.emptyMap(), Companion.access$emptyBinaryData(r5), "CORRUPTED");
    }

    public /* synthetic */ ModuleMapping(JvmMetadataVersion r5, Map r10, BinaryModuleData r11, String r12, DefaultConstructorMarker r13) {
        this(r5, r10, r11, r12);
    }

    public final PackageParts findPackageParts(String r5) {
        Intrinsics.checkNotNullParameter(r5, "packageFqName");
        return this.packageFqName2Parts.get(r5);
    }

    public final BinaryModuleData getModuleData() {
        return this.moduleData;
    }

    public final Map<String, PackageParts> getPackageFqName2Parts() {
        return this.packageFqName2Parts;
    }

    public final JvmMetadataVersion getVersion() {
        return this.version;
    }

    public String toString() {
        return this.debugName;
    }

    private ModuleMapping(JvmMetadataVersion r5, Map<String, PackageParts> r10, BinaryModuleData r11, String r12) {
        this.version = r5;
        this.packageFqName2Parts = r10;
        this.moduleData = r11;
        this.debugName = r12;
    }
}

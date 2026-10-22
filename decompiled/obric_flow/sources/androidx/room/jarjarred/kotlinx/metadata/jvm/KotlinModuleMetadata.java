package androidx.room.jarjarred.kotlinx.metadata.jvm;

import androidx.constraintlayout.motion.widget.a;
import androidx.room.jarjarred.kotlinx.metadata.InconsistentKotlinMetadataException;
import androidx.room.jarjarred.kotlinx.metadata.KmAnnotation;
import androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor;
import androidx.room.jarjarred.kotlinx.metadata.impl.ReadersKt;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.ProtoBuf;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization.JvmMetadataVersion;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization.ModuleMapping;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization.ModuleMappingKt;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization.PackageParts;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinModuleMetadata;", "", "bytes", "", "([B)V", "getBytes", "()[B", "data", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/deserialization/ModuleMapping;", "getData$kotlinx_metadata_jvm", "()Lorg/jetbrains/kotlin/metadata/jvm/deserialization/ModuleMapping;", "accept", "", "v", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/KmModuleVisitor;", "toKmModule", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/KmModule;", "Companion", "Writer", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KotlinModuleMetadata {
    public static final Companion Companion = null;
    private final byte[] bytes;
    private final ModuleMapping data;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinModuleMetadata$Companion;", "", "()V", "read", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinModuleMetadata;", "bytes", "", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        @JvmStatic
        public final KotlinModuleMetadata read(byte[] r5) {
            Intrinsics.checkNotNullParameter(r5, "bytes");
            KotlinModuleMetadata r10 = new KotlinModuleMetadata(r5);     // Catch: Throwable -> L11 InconsistentKotlinMetadataException -> L13
            if (Intrinsics.areEqual(r10.getData$kotlinx_metadata_jvm(), ModuleMapping.EMPTY) == false) goto L7;
            return null;
        L7:
            if (Intrinsics.areEqual(r10.getData$kotlinx_metadata_jvm(), ModuleMapping.CORRUPTED) == true) goto L10;
            return r10;
        L10:
            throw new InconsistentKotlinMetadataException("Data doesn't look like the content of a .kotlin_module file", null, 2, null);     // Catch: Throwable -> L11 InconsistentKotlinMetadataException -> L13
        L13:
            e = move-exception;
            throw e;
        L11:
            th = move-exception;
            throw new InconsistentKotlinMetadataException("Exception occurred when reading Kotlin metadata", th);
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J2\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinModuleMetadata$Writer;", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/KmModuleVisitor;", "()V", "b", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/JvmModuleProtoBuf$Module$Builder;", "kotlin.jvm.PlatformType", "visitAnnotation", "", "annotation", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotation;", "visitOptionalAnnotationClass", "Landroidx/room/jarjarred/kotlinx/metadata/KmClassVisitor;", "visitPackageParts", "fqName", "", "fileFacades", "", "multiFileClassParts", "", "write", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinModuleMetadata;", "metadataVersion", "", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Writer extends KmModuleVisitor {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final JvmModuleProtoBuf.Module.Builder f618b;

        public Writer() {
            super(null, 1, null);
            this.f618b = JvmModuleProtoBuf.Module.newBuilder();
        }

        public static /* synthetic */ KotlinModuleMetadata write$default(Writer r5, int[] r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r10 = KotlinClassHeader.COMPATIBLE_METADATA_VERSION;
        L6:
            return r5.write(r10);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.jvm.KmModuleVisitor
        public void visitAnnotation(KmAnnotation r5) {
            Intrinsics.checkNotNullParameter(r5, "annotation");
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.jvm.KmModuleVisitor
        public KmClassVisitor visitOptionalAnnotationClass() {
            return null;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.jvm.KmModuleVisitor
        public void visitPackageParts(String r5, List<String> r10, Map<String, String> r11) {
            Intrinsics.checkNotNullParameter(r5, "fqName");
            Intrinsics.checkNotNullParameter(r10, "fileFacades");
            Intrinsics.checkNotNullParameter(r11, "multiFileClassParts");
            PackageParts r12 = new PackageParts(r5);
            Iterator<String> r13 = r10.iterator();
        L4:
            if (r13.hasNext() == false) goto L6;
            r12.addPart(r13.next(), null);
            goto L4
        L6:
            Iterator<Map.Entry<String, String>> r14 = r11.entrySet().iterator();
        L8:
            if (r14.hasNext() == false) goto L10;
            Map.Entry<String, String> r15 = r14.next();
            r12.addPart(r15.getKey(), r15.getValue());
            goto L8
        L10:
            r12.addTo(this.f618b);
        }

        public final KotlinModuleMetadata write(int[] r5) {
            Intrinsics.checkNotNullParameter(r5, "metadataVersion");
            return new KotlinModuleMetadata(ModuleMappingKt.serializeToByteArray(this.f618b.build(), new JvmMetadataVersion(Arrays.copyOf(r5, r5.length)), 0));
        }
    }

    static {
        Companion = new Companion(null);
    }

    public KotlinModuleMetadata(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "bytes");
        this.bytes = r10;
        this.data = ModuleMapping.Companion.loadModuleMapping(r10, KotlinModuleMetadata.class.getName(), false, true, KotlinModuleMetadata$data$1.INSTANCE);
    }

    @JvmStatic
    public static final KotlinModuleMetadata read(byte[] r5) {
        return Companion.read(r5);
    }

    public final void accept(KmModuleVisitor r10) {
        Intrinsics.checkNotNullParameter(r10, "v");
        Iterator<Map.Entry<String, PackageParts>> r5 = this.data.getPackageFqName2Parts().entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L17;
        Map.Entry<String, PackageParts> r11 = r5.next();
        String r12 = r11.getKey();
        PackageParts r13 = r11.getValue();
        Set<String> r14 = r13.getParts();
        ArrayList r15 = new ArrayList();
        ArrayList r16 = new ArrayList();
        Iterator<T> r17 = r14.iterator();
    L7:
        if (r17.hasNext() == false) goto L12;
        Object r18 = r17.next();
        if (r13.getMultifileFacadeName((String) r18) == null) goto L10;
        r16.add(r18);
        goto L7
    L10:
        r15.add(r18);
        goto L7
    L12:
        Pair r19 = new Pair(r15, r16);
        List<String> r20 = (List) r19.component1();
        List r21 = (List) r19.component2();
        LinkedHashMap r22 = new LinkedHashMap(a.e(r21, 16));
        Iterator r23 = r21.iterator();
    L14:
        if (r23.hasNext() == false) goto L16;
        Object r24 = r23.next();
        String r25 = r13.getMultifileFacadeName((String) r24);
        Intrinsics.checkNotNull(r25);
        r22.put(r24, r25);
        goto L14
    L16:
        r10.visitPackageParts(r12, r20, r22);
        goto L4
    L17:
        Iterator<String> r26 = this.data.getModuleData().getAnnotations().iterator();
    L19:
        if (r26.hasNext() == false) goto L21;
        r10.visitAnnotation(new KmAnnotation(r26.next(), MapsKt.emptyMap()));
        goto L19
    L21:
        Iterator<ProtoBuf.Class> r27 = this.data.getModuleData().getOptionalAnnotations().iterator();
    L23:
        if (r27.hasNext() == false) goto L27;
        ProtoBuf.Class r28 = r27.next();
        KmClassVisitor r29 = r10.visitOptionalAnnotationClass();
        if (r29 == null) goto L23;
        ReadersKt.accept$default(r28, r29, this.data.getModuleData().getNameResolver(), null, 4, null);
        goto L23
    L27:
        r10.visitEnd();
    }

    public final byte[] getBytes() {
        return this.bytes;
    }

    public final ModuleMapping getData$kotlinx_metadata_jvm() {
        return this.data;
    }

    public final KmModule toKmModule() {
        KmModule r5 = new KmModule();
        accept(r5);
        return r5;
    }
}

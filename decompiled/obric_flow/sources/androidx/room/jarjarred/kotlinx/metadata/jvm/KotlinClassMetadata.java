package androidx.room.jarjarred.kotlinx.metadata.jvm;

import androidx.room.jarjarred.kotlinx.metadata.InconsistentKotlinMetadataException;
import androidx.room.jarjarred.kotlinx.metadata.KmClass;
import androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmLambda;
import androidx.room.jarjarred.kotlinx.metadata.KmLambdaVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmPackage;
import androidx.room.jarjarred.kotlinx.metadata.KmPackageVisitor;
import androidx.room.jarjarred.kotlinx.metadata.impl.ClassWriter;
import androidx.room.jarjarred.kotlinx.metadata.impl.LambdaWriter;
import androidx.room.jarjarred.kotlinx.metadata.impl.PackageWriter;
import androidx.room.jarjarred.kotlinx.metadata.impl.ReadersKt;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.ProtoBuf;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization.JvmMetadataVersion;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization.JvmNameResolver;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.serialization.JvmStringTable;
import androidx.room.jarjarred.kotlinx.metadata.jvm.impl.JvmWriteUtilsKt;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \t2\u00020\u0001:\u0007\n\t\u000b\f\r\u000e\u000fB\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0001\u0006\u0010\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassMetadata;", "", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassHeader;", "header", "<init>", "(Lkotlinx/metadata/jvm/a;)V", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassHeader;", "getHeader", "()Lkotlinx/metadata/jvm/a;", "Companion", "Class", "FileFacade", "MultiFileClassFacade", "MultiFileClassPart", "SyntheticClass", "Unknown", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassMetadata$Class;", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassMetadata$FileFacade;", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassMetadata$MultiFileClassFacade;", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassMetadata$MultiFileClassPart;", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassMetadata$SyntheticClass;", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassMetadata$Unknown;", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class KotlinClassMetadata {
    public static final Companion Companion = null;
    private final KotlinClassHeader header;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0016B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rR'\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassMetadata$Class;", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassMetadata;", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassHeader;", "header", "<init>", "(Lkotlinx/metadata/jvm/a;)V", "Landroidx/room/jarjarred/kotlinx/metadata/KmClass;", "toKmClass", "()Landroidx/room/jarjarred/kotlinx/metadata/KmClass;", "Landroidx/room/jarjarred/kotlinx/metadata/KmClassVisitor;", "v", "", "accept", "(Landroidx/room/jarjarred/kotlinx/metadata/KmClassVisitor;)V", "Lkotlin/Pair;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/deserialization/JvmNameResolver;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Class;", "classData$delegate", "Lkotlin/Lazy;", "getClassData", "()Lkotlin/Pair;", "classData", "Writer", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Class extends KotlinClassMetadata {
        private final Lazy classData$delegate;

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassMetadata$Class$Writer;", "Landroidx/room/jarjarred/kotlinx/metadata/impl/ClassWriter;", "()V", "write", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassMetadata$Class;", "metadataVersion", "", "extraInt", "", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Writer extends ClassWriter {
            /* JADX WARN: Multi-variable type inference failed */
            public Writer() {
                JvmStringTable r5 = new JvmStringTable(null, 1, null);
                super(r5, null, 2, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ Class write$default(Writer r5, int[] r10, int r11, int r12, Object r13) {
                if ((r12 & 1) == 0) goto L6;
                r10 = KotlinClassHeader.COMPATIBLE_METADATA_VERSION;
            L6:
                if ((r12 & 2) == 0) goto L9;
                r11 = 0;
            L9:
                return r5.write(r10, r11);
            }

            @JvmOverloads
            public final Class write() {
                return write$default(this, null, 0, 3, null);
            }

            @JvmOverloads
            public final Class write(int[] r5) {
                Intrinsics.checkNotNullParameter(r5, "metadataVersion");
                return write$default(this, r5, 0, 2, null);
            }

            @JvmOverloads
            public final Class write(int[] r10, int r11) {
                Intrinsics.checkNotNullParameter(r10, "metadataVersion");
                Companion.access$checkMetadataVersion(KotlinClassMetadata.Companion, r10);
                Pair<String[], String[]> r12 = JvmWriteUtilsKt.writeProtoBufData(getT().build(), getC());
                return new Class(new KotlinClassHeader(1, r10, r12.component1(), r12.component2(), null, null, Integer.valueOf(r11)));
            }
        }

        public Class(final KotlinClassHeader r5) {
            Intrinsics.checkNotNullParameter(r5, "header");
            super(r5, null);
            this.classData$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new KotlinClassMetadata$Class$classData$2(r5));
        }

        private final Pair<JvmNameResolver, ProtoBuf.Class> getClassData() {
            return (Pair) this.classData$delegate.getValue();
        }

        public final void accept(KmClassVisitor r10) {
            Intrinsics.checkNotNullParameter(r10, "v");
            Pair<JvmNameResolver, ProtoBuf.Class> r11 = getClassData();
            JvmNameResolver r5 = r11.component1();
            ReadersKt.accept$default(r11.component2(), r10, r5, null, 4, null);
        }

        public final KmClass toKmClass() {
            KmClass r5 = new KmClass();
            accept(r5);
            return r5;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassMetadata$Companion;", "", "()V", "checkMetadataVersion", "", "version", "", "read", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassMetadata;", "header", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassHeader;", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public static final /* synthetic */ void access$checkMetadataVersion(Companion r5, int[] r10) {
            r5.checkMetadataVersion(r10);
        }

        private final void checkMetadataVersion(int[] r5) {
            if (r5.length < 2) goto L11;
            int r10 = r5[0];
            if (r10 < 1) goto L11;
            if (r10 <= 1) goto L8;
            return;
        L8:
            if (r5[1] < 4) goto L11;
            return;
        L11:
            throw new IllegalArgumentException(("This version of kotlinx-metadata-jvm doesn't support writing Kotlin metadata of version earlier than 1.4. Please change the version from " + ArraysKt.toList(r5) + " to at least [1, 4].").toString());
        }

        @JvmStatic
        public final KotlinClassMetadata read(KotlinClassHeader r5) {
            Intrinsics.checkNotNullParameter(r5, "header");
            int[] r10 = r5.getMetadataVersion();
            if ((r5.getExtraInt() & 8) == 0) goto L5;
            boolean r11 = true;
        L7:
            if (new JvmMetadataVersion(r10, r11).isCompatible() == true) goto L34;
            return null;
        L34:
            int r12 = r5.getKind();     // Catch: Throwable -> L21 InconsistentKotlinMetadataException -> L23
            if (r12 == 1) goto L30;
            if (r12 == 2) goto L39;
            if (r12 == 3) goto L38;
            if (r12 == 4) goto L37;
            if (r12 == 5) goto L36;
            return new Unknown(r5);
        L36:
            return new MultiFileClassPart(r5);
        L37:
            return new MultiFileClassFacade(r5);
        L38:
            return new SyntheticClass(r5);
        L39:
            return new FileFacade(r5);
        L30:
            return new Class(r5);
        L23:
            e = move-exception;
            throw e;
        L21:
            th = move-exception;
            throw new InconsistentKotlinMetadataException("Exception occurred when reading Kotlin metadata", th);
        L5:
            r11 = false;
            goto L7
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0016B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rR'\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassMetadata$FileFacade;", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassMetadata;", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassHeader;", "header", "<init>", "(Lkotlinx/metadata/jvm/a;)V", "Landroidx/room/jarjarred/kotlinx/metadata/KmPackage;", "toKmPackage", "()Landroidx/room/jarjarred/kotlinx/metadata/KmPackage;", "Landroidx/room/jarjarred/kotlinx/metadata/KmPackageVisitor;", "v", "", "accept", "(Landroidx/room/jarjarred/kotlinx/metadata/KmPackageVisitor;)V", "Lkotlin/Pair;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/deserialization/JvmNameResolver;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Package;", "packageData$delegate", "Lkotlin/Lazy;", "getPackageData", "()Lkotlin/Pair;", "packageData", "Writer", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class FileFacade extends KotlinClassMetadata {
        private final Lazy packageData$delegate;

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassMetadata$FileFacade$Writer;", "Landroidx/room/jarjarred/kotlinx/metadata/impl/PackageWriter;", "()V", "write", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassMetadata$FileFacade;", "metadataVersion", "", "extraInt", "", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Writer extends PackageWriter {
            /* JADX WARN: Multi-variable type inference failed */
            public Writer() {
                JvmStringTable r5 = new JvmStringTable(null, 1, null);
                super(r5, null, 2, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ FileFacade write$default(Writer r5, int[] r10, int r11, int r12, Object r13) {
                if ((r12 & 1) == 0) goto L6;
                r10 = KotlinClassHeader.COMPATIBLE_METADATA_VERSION;
            L6:
                if ((r12 & 2) == 0) goto L9;
                r11 = 0;
            L9:
                return r5.write(r10, r11);
            }

            @JvmOverloads
            public final FileFacade write() {
                return write$default(this, null, 0, 3, null);
            }

            @JvmOverloads
            public final FileFacade write(int[] r5) {
                Intrinsics.checkNotNullParameter(r5, "metadataVersion");
                return write$default(this, r5, 0, 2, null);
            }

            @JvmOverloads
            public final FileFacade write(int[] r10, int r11) {
                Intrinsics.checkNotNullParameter(r10, "metadataVersion");
                Companion.access$checkMetadataVersion(KotlinClassMetadata.Companion, r10);
                Pair<String[], String[]> r12 = JvmWriteUtilsKt.writeProtoBufData(getT().build(), getC());
                return new FileFacade(new KotlinClassHeader(2, r10, r12.component1(), r12.component2(), null, null, Integer.valueOf(r11)));
            }
        }

        public FileFacade(final KotlinClassHeader r5) {
            Intrinsics.checkNotNullParameter(r5, "header");
            super(r5, null);
            this.packageData$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new KotlinClassMetadata$FileFacade$packageData$2(r5));
        }

        private final Pair<JvmNameResolver, ProtoBuf.Package> getPackageData() {
            return (Pair) this.packageData$delegate.getValue();
        }

        public final void accept(KmPackageVisitor r10) {
            Intrinsics.checkNotNullParameter(r10, "v");
            Pair<JvmNameResolver, ProtoBuf.Package> r11 = getPackageData();
            JvmNameResolver r5 = r11.component1();
            ReadersKt.accept$default(r11.component2(), r10, r5, null, 4, null);
        }

        public final KmPackage toKmPackage() {
            KmPackage r5 = new KmPackage();
            accept(r5);
            return r5;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\fB\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassMetadata$MultiFileClassFacade;", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassMetadata;", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassHeader;", "header", "<init>", "(Lkotlinx/metadata/jvm/a;)V", "", "", "partClassNames", "Ljava/util/List;", "getPartClassNames", "()Ljava/util/List;", "Writer", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class MultiFileClassFacade extends KotlinClassMetadata {
        private final List<String> partClassNames;

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassMetadata$MultiFileClassFacade$Writer;", "", "()V", "write", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassMetadata$MultiFileClassFacade;", "partClassNames", "", "", "metadataVersion", "", "extraInt", "", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Writer {
            public Writer() {
            }

            public static /* synthetic */ MultiFileClassFacade write$default(Writer r5, List r10, int[] r11, int r12, int r13, Object r14) {
                if ((r13 & 2) == 0) goto L6;
                r11 = KotlinClassHeader.COMPATIBLE_METADATA_VERSION;
            L6:
                if ((r13 & 4) == 0) goto L9;
                r12 = 0;
            L9:
                return r5.write(r10, r11, r12);
            }

            @JvmOverloads
            public final MultiFileClassFacade write(List<String> r10) {
                Intrinsics.checkNotNullParameter(r10, "partClassNames");
                return write$default(this, r10, null, 0, 6, null);
            }

            @JvmOverloads
            public final MultiFileClassFacade write(List<String> r10, int[] r11) {
                Intrinsics.checkNotNullParameter(r10, "partClassNames");
                Intrinsics.checkNotNullParameter(r11, "metadataVersion");
                return write$default(this, r10, r11, 0, 4, null);
            }

            @JvmOverloads
            public final MultiFileClassFacade write(List<String> r10, int[] r11, int r12) {
                Intrinsics.checkNotNullParameter(r10, "partClassNames");
                Intrinsics.checkNotNullParameter(r11, "metadataVersion");
                Companion.access$checkMetadataVersion(KotlinClassMetadata.Companion, r11);
                Object[] r13 = r10.toArray(new String[0]);
                Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                return new MultiFileClassFacade(new KotlinClassHeader(4, r11, (String[]) r13, null, null, null, Integer.valueOf(r12)));
            }
        }

        public MultiFileClassFacade(KotlinClassHeader r5) {
            Intrinsics.checkNotNullParameter(r5, "header");
            super(r5, null);
            this.partClassNames = ArraysKt.asList(r5.getData1());
        }

        public final List<String> getPartClassNames() {
            return this.partClassNames;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001aB\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rR'\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0019\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassMetadata$MultiFileClassPart;", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassMetadata;", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassHeader;", "header", "<init>", "(Lkotlinx/metadata/jvm/a;)V", "Landroidx/room/jarjarred/kotlinx/metadata/KmPackage;", "toKmPackage", "()Landroidx/room/jarjarred/kotlinx/metadata/KmPackage;", "Landroidx/room/jarjarred/kotlinx/metadata/KmPackageVisitor;", "v", "", "accept", "(Landroidx/room/jarjarred/kotlinx/metadata/KmPackageVisitor;)V", "Lkotlin/Pair;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/deserialization/JvmNameResolver;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Package;", "packageData$delegate", "Lkotlin/Lazy;", "getPackageData", "()Lkotlin/Pair;", "packageData", "", "getFacadeClassName", "()Ljava/lang/String;", "facadeClassName", "Writer", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class MultiFileClassPart extends KotlinClassMetadata {
        private final Lazy packageData$delegate;

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassMetadata$MultiFileClassPart$Writer;", "Landroidx/room/jarjarred/kotlinx/metadata/impl/PackageWriter;", "()V", "write", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassMetadata$MultiFileClassPart;", "facadeClassName", "", "metadataVersion", "", "extraInt", "", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Writer extends PackageWriter {
            /* JADX WARN: Multi-variable type inference failed */
            public Writer() {
                JvmStringTable r5 = new JvmStringTable(null, 1, null);
                super(r5, null, 2, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ MultiFileClassPart write$default(Writer r5, String r10, int[] r11, int r12, int r13, Object r14) {
                if ((r13 & 2) == 0) goto L6;
                r11 = KotlinClassHeader.COMPATIBLE_METADATA_VERSION;
            L6:
                if ((r13 & 4) == 0) goto L9;
                r12 = 0;
            L9:
                return r5.write(r10, r11, r12);
            }

            @JvmOverloads
            public final MultiFileClassPart write(String r10) {
                Intrinsics.checkNotNullParameter(r10, "facadeClassName");
                return write$default(this, r10, null, 0, 6, null);
            }

            @JvmOverloads
            public final MultiFileClassPart write(String r10, int[] r11) {
                Intrinsics.checkNotNullParameter(r10, "facadeClassName");
                Intrinsics.checkNotNullParameter(r11, "metadataVersion");
                return write$default(this, r10, r11, 0, 4, null);
            }

            @JvmOverloads
            public final MultiFileClassPart write(String r10, int[] r11, int r12) {
                Intrinsics.checkNotNullParameter(r10, "facadeClassName");
                Intrinsics.checkNotNullParameter(r11, "metadataVersion");
                Companion.access$checkMetadataVersion(KotlinClassMetadata.Companion, r11);
                Pair<String[], String[]> r13 = JvmWriteUtilsKt.writeProtoBufData(getT().build(), getC());
                return new MultiFileClassPart(new KotlinClassHeader(5, r11, r13.component1(), r13.component2(), r10, null, Integer.valueOf(r12)));
            }
        }

        public MultiFileClassPart(final KotlinClassHeader r5) {
            Intrinsics.checkNotNullParameter(r5, "header");
            super(r5, null);
            this.packageData$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new KotlinClassMetadata$MultiFileClassPart$packageData$2(r5));
        }

        private final Pair<JvmNameResolver, ProtoBuf.Package> getPackageData() {
            return (Pair) this.packageData$delegate.getValue();
        }

        public final void accept(KmPackageVisitor r10) {
            Intrinsics.checkNotNullParameter(r10, "v");
            Pair<JvmNameResolver, ProtoBuf.Package> r11 = getPackageData();
            JvmNameResolver r5 = r11.component1();
            ReadersKt.accept$default(r11.component2(), r10, r5, null, 4, null);
        }

        public final String getFacadeClassName() {
            return getHeader().getExtraString();
        }

        public final KmPackage toKmPackage() {
            KmPackage r5 = new KmPackage();
            accept(r5);
            return r5;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0019B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rR)\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0017\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassMetadata$SyntheticClass;", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassMetadata;", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassHeader;", "header", "<init>", "(Lkotlinx/metadata/jvm/a;)V", "Landroidx/room/jarjarred/kotlinx/metadata/KmLambda;", "toKmLambda", "()Landroidx/room/jarjarred/kotlinx/metadata/KmLambda;", "Landroidx/room/jarjarred/kotlinx/metadata/KmLambdaVisitor;", "v", "", "accept", "(Landroidx/room/jarjarred/kotlinx/metadata/KmLambdaVisitor;)V", "Lkotlin/Pair;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/deserialization/JvmNameResolver;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Function;", "functionData$delegate", "Lkotlin/Lazy;", "getFunctionData", "()Lkotlin/Pair;", "functionData", "", "isLambda", "()Z", "Writer", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class SyntheticClass extends KotlinClassMetadata {
        private final Lazy functionData$delegate;

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassMetadata$SyntheticClass$Writer;", "Landroidx/room/jarjarred/kotlinx/metadata/impl/LambdaWriter;", "()V", "write", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassMetadata$SyntheticClass;", "metadataVersion", "", "extraInt", "", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Writer extends LambdaWriter {
            public Writer() {
                super(new JvmStringTable(null, 1, null));
            }

            public static /* synthetic */ SyntheticClass write$default(Writer r5, int[] r10, int r11, int r12, Object r13) {
                if ((r12 & 1) == 0) goto L6;
                r10 = KotlinClassHeader.COMPATIBLE_METADATA_VERSION;
            L6:
                if ((r12 & 2) == 0) goto L9;
                r11 = 0;
            L9:
                return r5.write(r10, r11);
            }

            @JvmOverloads
            public final SyntheticClass write() {
                return write$default(this, null, 0, 3, null);
            }

            @JvmOverloads
            public final SyntheticClass write(int[] r5) {
                Intrinsics.checkNotNullParameter(r5, "metadataVersion");
                return write$default(this, r5, 0, 2, null);
            }

            @JvmOverloads
            public final SyntheticClass write(int[] r10, int r11) {
                Intrinsics.checkNotNullParameter(r10, "metadataVersion");
                Companion.access$checkMetadataVersion(KotlinClassMetadata.Companion, r10);
                ProtoBuf.Function.Builder r5 = getT();
                if (r5 == null) goto L5;
                ProtoBuf.Function r12 = r5.build();
            L6:
                if (r12 == null) goto L8;
                Pair<String[], String[]> r13 = JvmWriteUtilsKt.writeProtoBufData(r12, getC());
            L10:
                return new SyntheticClass(new KotlinClassHeader(3, r10, r13.component1(), r13.component2(), null, null, Integer.valueOf(r11)));
            L8:
                r13 = new Pair(new String[0], new String[0]);
                goto L10
            L5:
                r12 = null;
                goto L6
            }
        }

        public SyntheticClass(final KotlinClassHeader r5) {
            Intrinsics.checkNotNullParameter(r5, "header");
            super(r5, null);
            this.functionData$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new KotlinClassMetadata$SyntheticClass$functionData$2(r5));
        }

        private final Pair<JvmNameResolver, ProtoBuf.Function> getFunctionData() {
            return (Pair) this.functionData$delegate.getValue();
        }

        public final void accept(KmLambdaVisitor r5) {
            Intrinsics.checkNotNullParameter(r5, "v");
            if (isLambda() == false) goto L7;
            Pair<JvmNameResolver, ProtoBuf.Function> r10 = getFunctionData();
            Intrinsics.checkNotNull(r10);
            JvmNameResolver r11 = r10.component1();
            ReadersKt.accept(r10.component2(), r5, r11);
            return;
        L7:
            throw new IllegalStateException("accept(KmLambdaVisitor) is only possible for synthetic classes which are lambdas (isLambda = true)");
        }

        public final boolean isLambda() {
            if (getHeader().getData1().length != 0) goto L5;
            boolean r5 = true;
        L7:
            return !r5;
        L5:
            r5 = false;
            goto L7
        }

        public final KmLambda toKmLambda() {
            if (isLambda() == false) goto L5;
            KmLambda r5 = new KmLambda();
            accept(r5);
            return r5;
        L5:
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassMetadata$Unknown;", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassMetadata;", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassHeader;", "header", "<init>", "(Lkotlinx/metadata/jvm/a;)V", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Unknown extends KotlinClassMetadata {
        public Unknown(KotlinClassHeader r5) {
            Intrinsics.checkNotNullParameter(r5, "header");
            super(r5, null);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ KotlinClassMetadata(KotlinClassHeader r5, DefaultConstructorMarker r10) {
        this(r5);
    }

    @JvmStatic
    public static final KotlinClassMetadata read(KotlinClassHeader r5) {
        return Companion.read(r5);
    }

    public final KotlinClassHeader getHeader() {
        return this.header;
    }

    private KotlinClassMetadata(KotlinClassHeader r5) {
        this.header = r5;
    }
}

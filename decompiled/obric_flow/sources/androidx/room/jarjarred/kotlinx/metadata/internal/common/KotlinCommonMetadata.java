package androidx.room.jarjarred.kotlinx.metadata.internal.common;

import androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmModuleFragment;
import androidx.room.jarjarred.kotlinx.metadata.KmModuleFragmentVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmPackageVisitor;
import androidx.room.jarjarred.kotlinx.metadata.impl.ReadersKt;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.ProtoBuf;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.builtins.ReadPackageFragmentKt;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization.NameResolverImpl;
import java.io.ByteArrayInputStream;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000b2\u00020\u0001:\u0002\u000b\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/internal/common/KotlinCommonMetadata;", "", "proto", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$PackageFragment;", "(Lorg/jetbrains/kotlin/metadata/ProtoBuf$PackageFragment;)V", "accept", "", "v", "Landroidx/room/jarjarred/kotlinx/metadata/KmModuleFragmentVisitor;", "toKmModuleFragment", "Landroidx/room/jarjarred/kotlinx/metadata/KmModuleFragment;", "Companion", "Writer", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KotlinCommonMetadata {
    public static final Companion Companion = null;
    private final ProtoBuf.PackageFragment proto;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/internal/common/KotlinCommonMetadata$Companion;", "", "()V", "read", "Landroidx/room/jarjarred/kotlinx/metadata/internal/common/KotlinCommonMetadata;", "bytes", "", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        @JvmStatic
        public final KotlinCommonMetadata read(byte[] r5) {
            Intrinsics.checkNotNullParameter(r5, "bytes");
            ProtoBuf.PackageFragment r10 = ReadPackageFragmentKt.readBuiltinsPackageFragment(new ByteArrayInputStream(r5)).component1();
            DefaultConstructorMarker r11 = null;
            if (r10 != null) goto L6;
            return null;
        L6:
            return new KotlinCommonMetadata(r10, r11);
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/internal/common/KotlinCommonMetadata$Writer;", "Landroidx/room/jarjarred/kotlinx/metadata/KmModuleFragmentVisitor;", "()V", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Writer extends KmModuleFragmentVisitor {
        public Writer() {
            super(null, 1, null);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ KotlinCommonMetadata(ProtoBuf.PackageFragment r5, DefaultConstructorMarker r10) {
        this(r5);
    }

    @JvmStatic
    public static final KotlinCommonMetadata read(byte[] r5) {
        return Companion.read(r5);
    }

    public final void accept(KmModuleFragmentVisitor r10) {
        Intrinsics.checkNotNullParameter(r10, "v");
        NameResolverImpl r5 = new NameResolverImpl(this.proto.getStrings(), this.proto.getQualifiedNames());
        if (this.proto.hasPackage() == false) goto L7;
        KmPackageVisitor r11 = r10.visitPackage();
        if (r11 == null) goto L7;
        ReadersKt.accept$default(this.proto.getPackage(), r11, r5, null, 4, null);
    L7:
        Iterator<ProtoBuf.Class> r12 = this.proto.getClass_List().iterator();
    L9:
        if (r12.hasNext() == false) goto L13;
        ProtoBuf.Class r13 = r12.next();
        KmClassVisitor r14 = r10.visitClass();
        if (r14 == null) goto L9;
        ReadersKt.accept$default(r13, r14, r5, null, 4, null);
        goto L9
    L13:
        r10.visitEnd();
    }

    public final KmModuleFragment toKmModuleFragment() {
        KmModuleFragment r5 = new KmModuleFragment();
        accept(r5);
        return r5;
    }

    private KotlinCommonMetadata(ProtoBuf.PackageFragment r5) {
        this.proto = r5;
    }
}

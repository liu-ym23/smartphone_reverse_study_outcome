package androidx.room.jarjarred.kotlinx.metadata.impl;

import androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmExtensionType;
import androidx.room.jarjarred.kotlinx.metadata.KmModuleFragmentExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmModuleFragmentVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmPackageVisitor;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.ExtensionUtilsKt;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.ProtoBuf;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.serialization.StringTable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0015\u001a\u00020\u00148\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001a\u001a\u00020\u00198\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/impl/ModuleFragmentWriter;", "Landroidx/room/jarjarred/kotlinx/metadata/KmModuleFragmentVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/serialization/StringTable;", "stringTable", "", "Landroidx/room/jarjarred/kotlinx/metadata/impl/WriteContextExtension;", "contextExtensions", "<init>", "(Lorg/jetbrains/kotlin/metadata/serialization/StringTable;Ljava/util/List;)V", "Landroidx/room/jarjarred/kotlinx/metadata/KmPackageVisitor;", "visitPackage", "()Landroidx/room/jarjarred/kotlinx/metadata/KmPackageVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmClassVisitor;", "visitClass", "()Landroidx/room/jarjarred/kotlinx/metadata/KmClassVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "type", "Landroidx/room/jarjarred/kotlinx/metadata/KmModuleFragmentExtensionVisitor;", "visitExtensions", "(Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;)Landroidx/room/jarjarred/kotlinx/metadata/KmModuleFragmentExtensionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$PackageFragment$Builder;", "t", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$PackageFragment$Builder;", "getT", "()Lorg/jetbrains/kotlin/metadata/ProtoBuf$PackageFragment$Builder;", "Landroidx/room/jarjarred/kotlinx/metadata/impl/WriteContext;", "c", "Landroidx/room/jarjarred/kotlinx/metadata/impl/WriteContext;", "getC", "()Lkotlinx/metadata/impl/e;", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class ModuleFragmentWriter extends KmModuleFragmentVisitor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WriteContext f601c;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final ProtoBuf.PackageFragment.Builder f602t;

    public /* synthetic */ ModuleFragmentWriter(StringTable r5, List r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = CollectionsKt.emptyList();
    L5:
        this(r5, r10);
    }

    public final WriteContext getC() {
        return this.f601c;
    }

    public final ProtoBuf.PackageFragment.Builder getT() {
        return this.f602t;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmModuleFragmentVisitor
    public KmClassVisitor visitClass() {
        final StringTable r5 = this.f601c.getStrings();
        final List<WriteContextExtension> r10 = this.f601c.getContextExtensions();
        return new AnonymousClass1(this, r5, r10);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmModuleFragmentVisitor
    public KmModuleFragmentExtensionVisitor visitExtensions(final KmExtensionType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        return (KmModuleFragmentExtensionVisitor) ExtensionUtilsKt.applySingleExtension(r5, new C01141(r5, this));
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmModuleFragmentVisitor
    public KmPackageVisitor visitPackage() {
        final StringTable r5 = this.f601c.getStrings();
        final List<WriteContextExtension> r10 = this.f601c.getContextExtensions();
        return new C01151(this, r5, r10);
    }

    public ModuleFragmentWriter(StringTable r5, List<? extends WriteContextExtension> r10) {
        Intrinsics.checkNotNullParameter(r5, "stringTable");
        Intrinsics.checkNotNullParameter(r10, "contextExtensions");
        super(null, 1, null);
        ProtoBuf.PackageFragment.Builder r11 = ProtoBuf.PackageFragment.newBuilder();
        Intrinsics.checkNotNull(r11);
        this.f602t = r11;
        this.f601c = new WriteContext(r5, r10);
    }
}

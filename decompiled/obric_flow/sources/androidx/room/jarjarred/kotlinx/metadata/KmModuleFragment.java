package androidx.room.jarjarred.kotlinx.metadata;

import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.ExtensionUtilsKt;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.KmModuleFragmentExtension;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0001¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u001d¨\u0006#"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmModuleFragment;", "Landroidx/room/jarjarred/kotlinx/metadata/KmModuleFragmentVisitor;", "<init>", "()V", "Landroidx/room/jarjarred/kotlinx/metadata/KmPackageVisitor;", "visitPackage", "()Landroidx/room/jarjarred/kotlinx/metadata/KmPackageVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "type", "Landroidx/room/jarjarred/kotlinx/metadata/KmModuleFragmentExtensionVisitor;", "visitExtensions", "(Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;)Landroidx/room/jarjarred/kotlinx/metadata/KmModuleFragmentExtensionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmClassVisitor;", "visitClass", "()Landroidx/room/jarjarred/kotlinx/metadata/KmClassVisitor;", "visitor", "", "accept", "(Landroidx/room/jarjarred/kotlinx/metadata/KmModuleFragmentVisitor;)V", "Landroidx/room/jarjarred/kotlinx/metadata/KmPackage;", "pkg", "Landroidx/room/jarjarred/kotlinx/metadata/KmPackage;", "getPkg", "()Ljava/lang/Object;", "setPkg", "(Ljava/lang/Object;)V", "", "Landroidx/room/jarjarred/kotlinx/metadata/KmClass;", "classes", "Ljava/util/List;", "getClasses", "()Ljava/util/List;", "", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/KmModuleFragmentExtension;", "extensions", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KmModuleFragment extends KmModuleFragmentVisitor {
    private final List<KmClass> classes;
    private final List<KmModuleFragmentExtension> extensions;
    private KmPackage pkg;

    public KmModuleFragment() {
        super(null, 1, null);
        this.classes = new ArrayList();
        List<MetadataExtensions> r5 = MetadataExtensions.Companion.getINSTANCES();
        ArrayList r10 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(((MetadataExtensions) r11.next()).createModuleFragmentExtensions());
        goto L4
    L6:
        this.extensions = r10;
    }

    public final void accept(KmModuleFragmentVisitor r5) {
        Intrinsics.checkNotNullParameter(r5, "visitor");
        KmPackage r10 = this.pkg;
        if (r10 == null) goto L7;
        KmPackageVisitor r11 = r5.visitPackage();
        if (r11 == null) goto L7;
        r10.accept(r11);
    L7:
        Iterator<T> r12 = this.classes.iterator();
    L9:
        if (r12.hasNext() == false) goto L13;
        KmClass r13 = (KmClass) r12.next();
        KmClassVisitor r14 = r5.visitClass();
        if (r14 == null) goto L9;
        r13.accept(r14);
        goto L9
    L13:
        Iterator<T> r15 = this.extensions.iterator();
    L15:
        if (r15.hasNext() == false) goto L19;
        KmModuleFragmentExtension r16 = (KmModuleFragmentExtension) r15.next();
        KmModuleFragmentExtensionVisitor r17 = r5.visitExtensions(r16.getType());
        if (r17 == null) goto L15;
        r16.accept(r17);
        goto L15
    L19:
        r5.visitEnd();
    }

    public final List<KmClass> getClasses() {
        return this.classes;
    }

    public final KmPackage getPkg() {
        return this.pkg;
    }

    public final void setPkg(KmPackage r5) {
        this.pkg = r5;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmModuleFragmentVisitor
    public KmClassVisitor visitClass() {
        return (KmClassVisitor) NodesKt.addTo(new KmClass(), this.classes);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmModuleFragmentVisitor
    public KmModuleFragmentExtensionVisitor visitExtensions(KmExtensionType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        return (KmModuleFragmentExtensionVisitor) ExtensionUtilsKt.singleOfType(this.extensions, r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmModuleFragmentVisitor
    public KmPackageVisitor visitPackage() {
        KmPackage r5 = new KmPackage();
        this.pkg = r5;
        return r5;
    }
}

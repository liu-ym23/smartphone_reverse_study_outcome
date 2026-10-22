package androidx.room.jarjarred.kotlinx.metadata;

import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.ExtensionUtilsKt;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.KmTypeParameterExtension;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B)\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0001J\u0012\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'H\u0016J\u0014\u0010(\u001a\u00020)2\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\u0016R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006*"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameter;", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameterVisitor;", "flags", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "name", "", "id", "variance", "Landroidx/room/jarjarred/kotlinx/metadata/KmVariance;", "(ILjava/lang/String;ILkotlinx/metadata/KmVariance;)V", "extensions", "", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/KmTypeParameterExtension;", "getFlags", "()I", "setFlags", "(I)V", "getId", "setId", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "upperBounds", "", "Landroidx/room/jarjarred/kotlinx/metadata/KmType;", "getUpperBounds", "()Ljava/util/List;", "getVariance", "()Lkotlinx/metadata/KmVariance;", "setVariance", "(Lkotlinx/metadata/KmVariance;)V", "accept", "", "visitor", "visitExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameterExtensionVisitor;", "type", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "visitUpperBound", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KmTypeParameter extends KmTypeParameterVisitor {
    private final List<KmTypeParameterExtension> extensions;
    private int flags;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private int f596id;
    private String name;
    private final List<KmType> upperBounds;
    private KmVariance variance;

    public KmTypeParameter(int r5, String r10, int r11, KmVariance r12) {
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r12, "variance");
        super(null, 1, null);
        this.flags = r5;
        this.name = r10;
        this.f596id = r11;
        this.variance = r12;
        this.upperBounds = new ArrayList(1);
        List<MetadataExtensions> r13 = MetadataExtensions.Companion.getINSTANCES();
        ArrayList r14 = new ArrayList(CollectionsKt.h(r13));
        Iterator<T> r15 = r13.iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        r14.add(((MetadataExtensions) r15.next()).createTypeParameterExtension());
        goto L4
    L6:
        this.extensions = r14;
    }

    public final void accept(KmTypeParameterVisitor r5) {
        Intrinsics.checkNotNullParameter(r5, "visitor");
        Iterator<T> r10 = this.upperBounds.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        KmType r11 = (KmType) r10.next();
        KmTypeVisitor r12 = r5.visitUpperBound(r11.getFlags());
        if (r12 == null) goto L4;
        r11.accept(r12);
        goto L4
    L8:
        Iterator<T> r13 = this.extensions.iterator();
    L10:
        if (r13.hasNext() == false) goto L14;
        KmTypeParameterExtension r14 = (KmTypeParameterExtension) r13.next();
        KmTypeParameterExtensionVisitor r15 = r5.visitExtensions(r14.getType());
        if (r15 == null) goto L10;
        r14.accept(r15);
        goto L10
    L14:
        r5.visitEnd();
    }

    public final int getFlags() {
        return this.flags;
    }

    public final int getId() {
        return this.f596id;
    }

    public final String getName() {
        return this.name;
    }

    public final List<KmType> getUpperBounds() {
        return this.upperBounds;
    }

    public final KmVariance getVariance() {
        return this.variance;
    }

    public final void setFlags(int r5) {
        this.flags = r5;
    }

    public final void setId(int r5) {
        this.f596id = r5;
    }

    public final void setName(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.name = r5;
    }

    public final void setVariance(KmVariance r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.variance = r5;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeParameterVisitor
    public KmTypeParameterExtensionVisitor visitExtensions(KmExtensionType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        return (KmTypeParameterExtensionVisitor) ExtensionUtilsKt.singleOfType(this.extensions, r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeParameterVisitor
    public KmTypeVisitor visitUpperBound(int r5) {
        return (KmTypeVisitor) NodesKt.addTo(new KmType(r5), this.upperBounds);
    }
}

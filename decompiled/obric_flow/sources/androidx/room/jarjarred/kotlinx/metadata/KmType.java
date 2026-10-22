package androidx.room.jarjarred.kotlinx.metadata;

import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.ExtensionUtilsKt;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.KmTypeExtension;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u000b\u001a\u00020\n2\n\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u00020\n2\n\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0016¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0006J#\u0010\u0012\u001a\u00020\u00012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0016\u001a\u00020\u00012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0018\u001a\u00020\u00012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\u0018\u0010\u0017J%\u0010\u001a\u001a\u00020\u00012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\"\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u0001¢\u0006\u0004\b\"\u0010#R&\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010\u0006R\"\u0010)\u001a\u00020(8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001d\u00101\u001a\b\u0012\u0004\u0012\u0002000/8\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R$\u00105\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u0010,\"\u0004\b8\u0010.R$\u00109\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u00106\u001a\u0004\b:\u0010,\"\u0004\b;\u0010.R$\u0010=\u001a\u0004\u0018\u00010<8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010,\"\u0004\b@\u0010.R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020\u001e0A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u00102¨\u0006C"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmType;", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "flags", "<init>", "(I)V", "", "Landroidx/room/jarjarred/kotlinx/metadata/ClassName;", "name", "", "visitClass", "(Ljava/lang/String;)V", "visitTypeAlias", "id", "visitTypeParameter", "Landroidx/room/jarjarred/kotlinx/metadata/KmVariance;", "variance", "visitArgument", "(ILandroidx/room/jarjarred/kotlinx/metadata/KmVariance;)Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "visitStarProjection", "()V", "visitAbbreviatedType", "(I)Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "visitOuterType", "typeFlexibilityId", "visitFlexibleTypeUpperBound", "(ILjava/lang/String;)Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "type", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/KmTypeExtension;", "visitExtensions", "(Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;)Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/KmTypeExtension;", "visitor", "accept", "(Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;)V", "I", "getFlags", "()I", "setFlags", "Landroidx/room/jarjarred/kotlinx/metadata/KmClassifier;", "classifier", "Landroidx/room/jarjarred/kotlinx/metadata/KmClassifier;", "getClassifier", "()Ljava/lang/Object;", "setClassifier", "(Ljava/lang/Object;)V", "", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeProjection;", "arguments", "Ljava/util/List;", "getArguments", "()Ljava/util/List;", "abbreviatedType", "Landroidx/room/jarjarred/kotlinx/metadata/KmType;", "getAbbreviatedType", "setAbbreviatedType", "outerType", "getOuterType", "setOuterType", "Landroidx/room/jarjarred/kotlinx/metadata/KmFlexibleTypeUpperBound;", "flexibleTypeUpperBound", "Landroidx/room/jarjarred/kotlinx/metadata/KmFlexibleTypeUpperBound;", "getFlexibleTypeUpperBound", "setFlexibleTypeUpperBound", "", "extensions", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KmType extends KmTypeVisitor {
    private KmType abbreviatedType;
    private final List<KmTypeProjection> arguments;
    public KmClassifier classifier;
    private final List<KmTypeExtension> extensions;
    private int flags;
    private KmFlexibleTypeUpperBound flexibleTypeUpperBound;
    private KmType outerType;

    public KmType(int r5) {
        super(null, 1, null);
        this.flags = r5;
        this.arguments = new ArrayList(0);
        List<MetadataExtensions> r10 = MetadataExtensions.Companion.getINSTANCES();
        ArrayList r11 = new ArrayList(CollectionsKt.h(r10));
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.add(((MetadataExtensions) r12.next()).createTypeExtension());
        goto L4
    L6:
        this.extensions = r11;
    }

    public final void accept(KmTypeVisitor r5) {
        Intrinsics.checkNotNullParameter(r5, "visitor");
        KmClassifier r10 = getClassifier();
        if ((r10 instanceof KmClassifier.Class) == false) goto L6;
        r5.visitClass(((KmClassifier.Class) r10).getName());
    L11:
        Iterator<T> r11 = this.arguments.iterator();
    L13:
        if (r11.hasNext() == false) goto L25;
        KmTypeProjection r12 = (KmTypeProjection) r11.next();
        if (Intrinsics.areEqual(r12, KmTypeProjection.STAR) == true) goto L16;
        KmVariance r13 = r12.component1();
        KmType r14 = r12.component2();
        if (r13 == null) goto L24;
        if (r14 == null) goto L24;
        KmTypeVisitor r15 = r5.visitArgument(r14.flags, r13);
        if (r15 == null) goto L13;
        r14.accept(r15);
    L24:
        throw new InconsistentKotlinMetadataException("Variance and type must be set for non-star type projection", null, 2, null);
    L16:
        r5.visitStarProjection();
        goto L13
    L25:
        KmType r16 = this.abbreviatedType;
        if (r16 == null) goto L30;
        KmTypeVisitor r17 = r5.visitAbbreviatedType(r16.flags);
        if (r17 == null) goto L30;
        r16.accept(r17);
    L30:
        KmType r18 = this.outerType;
        if (r18 == null) goto L35;
        KmTypeVisitor r19 = r5.visitOuterType(r18.flags);
        if (r19 == null) goto L35;
        r18.accept(r19);
    L35:
        KmFlexibleTypeUpperBound r20 = this.flexibleTypeUpperBound;
        if (r20 == null) goto L40;
        KmTypeVisitor r21 = r5.visitFlexibleTypeUpperBound(r20.getType().flags, r20.getTypeFlexibilityId());
        if (r21 == null) goto L40;
        r20.getType().accept(r21);
    L40:
        Iterator<T> r22 = this.extensions.iterator();
    L42:
        if (r22.hasNext() == false) goto L46;
        KmTypeExtension r23 = (KmTypeExtension) r22.next();
        KmTypeExtensionVisitor r24 = r5.visitExtensions(r23.getType());
        if (r24 == null) goto L42;
        r23.accept(r24);
        goto L42
    L46:
        r5.visitEnd();
        return;
    L6:
        if ((r10 instanceof KmClassifier.TypeParameter) == false) goto L9;
        r5.visitTypeParameter(((KmClassifier.TypeParameter) r10).getId());
        goto L11
    L9:
        if ((r10 instanceof KmClassifier.TypeAlias) == false) goto L11;
        r5.visitTypeAlias(((KmClassifier.TypeAlias) r10).getName());
        goto L11
    }

    public final KmType getAbbreviatedType() {
        return this.abbreviatedType;
    }

    public final List<KmTypeProjection> getArguments() {
        return this.arguments;
    }

    public final KmClassifier getClassifier() {
        KmClassifier r5 = this.classifier;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("classifier");
        return null;
    }

    public final int getFlags() {
        return this.flags;
    }

    public final KmFlexibleTypeUpperBound getFlexibleTypeUpperBound() {
        return this.flexibleTypeUpperBound;
    }

    public final KmType getOuterType() {
        return this.outerType;
    }

    public final void setAbbreviatedType(KmType r5) {
        this.abbreviatedType = r5;
    }

    public final void setClassifier(KmClassifier r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.classifier = r5;
    }

    public final void setFlags(int r5) {
        this.flags = r5;
    }

    public final void setFlexibleTypeUpperBound(KmFlexibleTypeUpperBound r5) {
        this.flexibleTypeUpperBound = r5;
    }

    public final void setOuterType(KmType r5) {
        this.outerType = r5;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeVisitor
    public KmTypeVisitor visitAbbreviatedType(int r5) {
        KmType r10 = new KmType(r5);
        this.abbreviatedType = r10;
        return r10;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeVisitor
    public KmTypeVisitor visitArgument(int r5, KmVariance r10) {
        Intrinsics.checkNotNullParameter(r10, "variance");
        KmType r11 = new KmType(r5);
        this.arguments.add(new KmTypeProjection(r10, r11));
        return r11;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeVisitor
    public void visitClass(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        setClassifier(new KmClassifier.Class(r5));
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeVisitor
    public /* bridge */ /* synthetic */ KmTypeExtensionVisitor visitExtensions(KmExtensionType r5) {
        return visitExtensions(r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeVisitor
    public KmTypeVisitor visitFlexibleTypeUpperBound(int r5, String r10) {
        KmType r11 = new KmType(r5);
        this.flexibleTypeUpperBound = new KmFlexibleTypeUpperBound(r11, r10);
        return r11;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeVisitor
    public KmTypeVisitor visitOuterType(int r5) {
        KmType r10 = new KmType(r5);
        this.outerType = r10;
        return r10;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeVisitor
    public void visitStarProjection() {
        this.arguments.add(KmTypeProjection.STAR);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeVisitor
    public void visitTypeAlias(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        setClassifier(new KmClassifier.TypeAlias(r5));
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeVisitor
    public void visitTypeParameter(int r5) {
        setClassifier(new KmClassifier.TypeParameter(r5));
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeVisitor
    public KmTypeExtension visitExtensions(KmExtensionType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        return (KmTypeExtension) ExtensionUtilsKt.singleOfType(this.extensions, r5);
    }
}

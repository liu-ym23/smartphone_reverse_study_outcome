package androidx.room.jarjarred.kotlinx.metadata;

import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\t\u001a\u00020\b2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u00020\b2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0014\u001a\u0004\u0018\u00010\u00002\n\u0010\u0011\u001a\u00060\fj\u0002`\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00002\n\u0010\u0011\u001a\u00060\fj\u0002`\u0010H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u00002\n\u0010\u0011\u001a\u00060\fj\u0002`\u0010H\u0016¢\u0006\u0004\b\u001a\u0010\u0019J'\u0010\u001c\u001a\u0004\u0018\u00010\u00002\n\u0010\u0011\u001a\u00060\fj\u0002`\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\bH\u0016¢\u0006\u0004\b#\u0010\u0017R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010$¨\u0006%"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "", "delegate", "<init>", "(Lkotlinx/metadata/impl/l;)V", "", "Landroidx/room/jarjarred/kotlinx/metadata/ClassName;", "name", "", "visitClass", "(Ljava/lang/String;)V", "visitTypeAlias", "", "id", "visitTypeParameter", "(I)V", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "flags", "Landroidx/room/jarjarred/kotlinx/metadata/KmVariance;", "variance", "visitArgument", "(ILandroidx/room/jarjarred/kotlinx/metadata/KmVariance;)Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "visitStarProjection", "()V", "visitAbbreviatedType", "(I)Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "visitOuterType", "typeFlexibilityId", "visitFlexibleTypeUpperBound", "(ILjava/lang/String;)Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "type", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeExtensionVisitor;", "visitExtensions", "(Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;)Landroidx/room/jarjarred/kotlinx/metadata/KmTypeExtensionVisitor;", "visitEnd", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class KmTypeVisitor {
    private final KmTypeVisitor delegate;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public KmTypeVisitor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public KmTypeVisitor visitAbbreviatedType(int r5) {
        KmTypeVisitor r10 = this.delegate;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.visitAbbreviatedType(r5);
    }

    public KmTypeVisitor visitArgument(int r5, KmVariance r10) {
        Intrinsics.checkNotNullParameter(r10, "variance");
        KmTypeVisitor r11 = this.delegate;
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.visitArgument(r5, r10);
    }

    public void visitClass(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        KmTypeVisitor r10 = this.delegate;
        if (r10 == null) goto L6;
        r10.visitClass(r5);
        return;
    }

    public void visitEnd() {
        KmTypeVisitor r5 = this.delegate;
        if (r5 == null) goto L6;
        r5.visitEnd();
        return;
    }

    public KmTypeExtensionVisitor visitExtensions(KmExtensionType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        KmTypeVisitor r10 = this.delegate;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.visitExtensions(r5);
    }

    public KmTypeVisitor visitFlexibleTypeUpperBound(int r5, String r10) {
        KmTypeVisitor r11 = this.delegate;
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.visitFlexibleTypeUpperBound(r5, r10);
    }

    public KmTypeVisitor visitOuterType(int r5) {
        KmTypeVisitor r10 = this.delegate;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.visitOuterType(r5);
    }

    public void visitStarProjection() {
        KmTypeVisitor r5 = this.delegate;
        if (r5 == null) goto L6;
        r5.visitStarProjection();
        return;
    }

    public void visitTypeAlias(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        KmTypeVisitor r10 = this.delegate;
        if (r10 == null) goto L6;
        r10.visitTypeAlias(r5);
        return;
    }

    public void visitTypeParameter(int r5) {
        KmTypeVisitor r10 = this.delegate;
        if (r10 == null) goto L6;
        r10.visitTypeParameter(r5);
        return;
    }

    @JvmOverloads
    public KmTypeVisitor(KmTypeVisitor r5) {
        this.delegate = r5;
    }

    public /* synthetic */ KmTypeVisitor(KmTypeVisitor r5, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r5 = null;
    L5:
        this(r5);
    }
}

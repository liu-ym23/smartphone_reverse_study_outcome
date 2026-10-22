package androidx.room.jarjarred.kotlinx.metadata;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0001¢\u0006\u0004\b\f\u0010\rJ3\u0010\u0015\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000f\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010,\u001a\u00020+8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u00062"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirement;", "Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirementVisitor;", "<init>", "()V", "", "major", "minor", "patch", "", "visitVersion", "(III)V", "visitor", "accept", "(Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirementVisitor;)V", "Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirementVersionKind;", "kind", "Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirementLevel;", "level", "errorCode", "", "message", "visit", "(Lkotlinx/metadata/KmVersionRequirementVersionKind;Lkotlinx/metadata/KmVersionRequirementLevel;Ljava/lang/Integer;Ljava/lang/String;)V", "Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirementVersionKind;", "getKind", "()Lkotlinx/metadata/KmVersionRequirementVersionKind;", "setKind", "(Lkotlinx/metadata/KmVersionRequirementVersionKind;)V", "Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirementLevel;", "getLevel", "()Lkotlinx/metadata/KmVersionRequirementLevel;", "setLevel", "(Lkotlinx/metadata/KmVersionRequirementLevel;)V", "Ljava/lang/Integer;", "getErrorCode", "()Ljava/lang/Integer;", "setErrorCode", "(Ljava/lang/Integer;)V", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "Landroidx/room/jarjarred/kotlinx/metadata/KmVersion;", "version", "Landroidx/room/jarjarred/kotlinx/metadata/KmVersion;", "getVersion", "()Ljava/lang/Object;", "setVersion", "(Ljava/lang/Object;)V", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KmVersionRequirement extends KmVersionRequirementVisitor {
    private Integer errorCode;
    public KmVersionRequirementVersionKind kind;
    public KmVersionRequirementLevel level;
    private String message;
    public KmVersion version;

    public KmVersionRequirement() {
        super(null, 1, null);
    }

    public final void accept(KmVersionRequirementVisitor r5) {
        Intrinsics.checkNotNullParameter(r5, "visitor");
        r5.visit(getKind(), getLevel(), this.errorCode, this.message);
        r5.visitVersion(getVersion().getMajor(), getVersion().getMinor(), getVersion().getPatch());
        r5.visitEnd();
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public final KmVersionRequirementVersionKind getKind() {
        KmVersionRequirementVersionKind r5 = this.kind;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("kind");
        return null;
    }

    public final KmVersionRequirementLevel getLevel() {
        KmVersionRequirementLevel r5 = this.level;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("level");
        return null;
    }

    public final String getMessage() {
        return this.message;
    }

    public final KmVersion getVersion() {
        KmVersion r5 = this.version;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("version");
        return null;
    }

    public final void setErrorCode(Integer r5) {
        this.errorCode = r5;
    }

    public final void setKind(KmVersionRequirementVersionKind r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.kind = r5;
    }

    public final void setLevel(KmVersionRequirementLevel r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.level = r5;
    }

    public final void setMessage(String r5) {
        this.message = r5;
    }

    public final void setVersion(KmVersion r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.version = r5;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmVersionRequirementVisitor
    public void visit(KmVersionRequirementVersionKind r5, KmVersionRequirementLevel r10, Integer r11, String r12) {
        Intrinsics.checkNotNullParameter(r5, "kind");
        Intrinsics.checkNotNullParameter(r10, "level");
        setKind(r5);
        setLevel(r10);
        this.errorCode = r11;
        this.message = r12;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmVersionRequirementVisitor
    public void visitVersion(int r5, int r10, int r11) {
        setVersion(new KmVersion(r5, r10, r11));
    }
}

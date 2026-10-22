package androidx.paging;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Landroidx/paging/GenerationalViewportHint;", "", "generationId", "", "hint", "Landroidx/paging/ViewportHint;", "(ILandroidx/paging/ViewportHint;)V", "getGenerationId", "()I", "getHint", "()Landroidx/paging/ViewportHint;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GenerationalViewportHint {
    private final int generationId;
    private final ViewportHint hint;

    public GenerationalViewportHint(int r2, ViewportHint r3) {
        Intrinsics.checkNotNullParameter(r3, "hint");
        this.generationId = r2;
        this.hint = r3;
    }

    public static /* synthetic */ GenerationalViewportHint copy$default(GenerationalViewportHint r0, int r1, ViewportHint r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.generationId;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.hint;
    L9:
        return r0.copy(r1, r2);
    }

    public final int component1() {
        return this.generationId;
    }

    public final ViewportHint component2() {
        return this.hint;
    }

    public final GenerationalViewportHint copy(int r1, ViewportHint r2) {
        Intrinsics.checkNotNullParameter(r2, "hint");
        return new GenerationalViewportHint(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, GenerationalViewportHint.class) == true) goto L8;
        return false;
    L8:
        GenerationalViewportHint r6 = (GenerationalViewportHint) ZeusTransformUtils.preCheckCast(r5, GenerationalViewportHint.class, "com.obric.memorydata.plugin");
        if (this.generationId == r6.generationId) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.hint, r6.hint) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int getGenerationId() {
        return this.generationId;
    }

    public final ViewportHint getHint() {
        return this.hint;
    }

    public int hashCode() {
        return (Integer.hashCode(this.generationId) * 31) + this.hint.hashCode();
    }

    public String toString() {
        return "GenerationalViewportHint(generationId=" + this.generationId + ", hint=" + this.hint + ')';
    }
}

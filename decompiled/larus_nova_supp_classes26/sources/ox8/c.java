package ox8;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012J>\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lcom/larus/camera/impl/edulibs/cameraapi/idl/HorizontalBox;", "", "topLeft", "Lcom/larus/camera/impl/edulibs/cameraapi/idl/Point;", "bottomRight", "class", "", "score", "", "<init>", "(Lcom/larus/camera/impl/edulibs/cameraapi/idl/Point;Lcom/larus/camera/impl/edulibs/cameraapi/idl/Point;Ljava/lang/Integer;Ljava/lang/Double;)V", "getTopLeft", "()Lcom/larus/camera/impl/edulibs/cameraapi/idl/Point;", "getBottomRight", "getClass", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getScore", "()Ljava/lang/Double;", "Ljava/lang/Double;", "component1", "component2", "component3", "component4", "copy", "(Lcom/larus/camera/impl/edulibs/cameraapi/idl/Point;Lcom/larus/camera/impl/edulibs/cameraapi/idl/Point;Ljava/lang/Integer;Ljava/lang/Double;)Lcom/larus/camera/impl/edulibs/cameraapi/idl/HorizontalBox;", "equals", "", "other", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c {

    @SerializedName("bottomRight")
    private final d bottomRight;

    /* JADX INFO: renamed from: class, reason: not valid java name */
    @SerializedName("class")
    private final Integer f0class;

    @SerializedName("score")
    private final Double score;

    @SerializedName("topLeft")
    private final d topLeft;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (Intrinsics.areEqual(this.topLeft, r6.topLeft) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bottomRight, r6.bottomRight) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f0class, r6.f0class) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.score, r6.score) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        d r0 = this.topLeft;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        d r4 = this.bottomRight;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.f0class;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Double r10 = this.score;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "HorizontalBox(topLeft=" + this.topLeft + ", bottomRight=" + this.bottomRight + ", class=" + this.f0class + ", score=" + this.score + ')';
    }

    public c() {
        this.topLeft = null;
        this.bottomRight = null;
        this.f0class = null;
        this.score = null;
    }

    public final d a() {
        return this.bottomRight;
    }

    public final d b() {
        return this.topLeft;
    }
}

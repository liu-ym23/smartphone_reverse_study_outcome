package hq9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/larus/platform/model/CreationShareSettings;", "", "imageShare", "Lcom/larus/platform/model/ImageShare;", "videoShare", "Lcom/larus/platform/model/VideoShare;", "useSaveFileNewLoading", "", "<init>", "(Lcom/larus/platform/model/ImageShare;Lcom/larus/platform/model/VideoShare;Z)V", "getImageShare", "()Lcom/larus/platform/model/ImageShare;", "getVideoShare", "()Lcom/larus/platform/model/VideoShare;", "getUseSaveFileNewLoading", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class v0 {
    public static final v0 a = null;
    public static final v0 b = null;

    @SerializedName("image_share")
    private final v1 imageShare;

    @SerializedName("use_save_file_new_loading")
    private final boolean useSaveFileNewLoading;

    @SerializedName("video_share")
    private final a5 videoShare;

    public static final class a {
    }

    public v0() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof v0) == true) goto L8;
        return false;
    L8:
        v0 r6 = (v0) r5;
        if (Intrinsics.areEqual(this.imageShare, r6.imageShare) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.videoShare, r6.videoShare) == true) goto L15;
        return false;
    L15:
        if (this.useSaveFileNewLoading == r6.useSaveFileNewLoading) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        v1 r0 = this.imageShare;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        a5 r4 = this.videoShare;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        int r5 = (r3 + r1) * 31;
        if (this.useSaveFileNewLoading == false) goto L13;
        int r6 = 1231;
    L15:
        return r5 + r6;
    L13:
        r6 = 1237;
        goto L15
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreationShareSettings(imageShare=" + this.imageShare + ", videoShare=" + this.videoShare + ", useSaveFileNewLoading=" + this.useSaveFileNewLoading + ')';
    }

    static {
        a = new v0(new v1(true, 1, true, true, false, false), new a5(true), true);
        b = new v0(0);
    }

    public final v1 a() {
        return this.imageShare;
    }

    public final boolean b() {
        return this.useSaveFileNewLoading;
    }

    public final a5 c() {
        return this.videoShare;
    }

    public /* synthetic */ v0(int r2) {
        this(null, null, false);
    }

    public v0(v1 r1, a5 r2, boolean r3) {
        this.imageShare = r1;
        this.videoShare = r2;
        this.useSaveFileNewLoading = r3;
    }
}

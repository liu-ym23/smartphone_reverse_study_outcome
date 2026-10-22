package mq9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J9\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/larus/platform/model/avatar/DigitalAvatarAuthStyleConfigV2;", "", "createNewAvatarAuthStyle", "Lcom/larus/platform/model/avatar/UserAvatarAuthStyleConfigV2;", "appendAvatarVideoAuthStyle", "createNewAvatarGuideVideo", "Lcom/larus/platform/model/avatar/UserAvatarAuthVideoConfigV2;", "appendAvatarGuideVideo", "<init>", "(Lcom/larus/platform/model/avatar/UserAvatarAuthStyleConfigV2;Lcom/larus/platform/model/avatar/UserAvatarAuthStyleConfigV2;Lcom/larus/platform/model/avatar/UserAvatarAuthVideoConfigV2;Lcom/larus/platform/model/avatar/UserAvatarAuthVideoConfigV2;)V", "getCreateNewAvatarAuthStyle", "()Lcom/larus/platform/model/avatar/UserAvatarAuthStyleConfigV2;", "getAppendAvatarVideoAuthStyle", "getCreateNewAvatarGuideVideo", "()Lcom/larus/platform/model/avatar/UserAvatarAuthVideoConfigV2;", "getAppendAvatarGuideVideo", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class a {

    @SerializedName("appendAvatarGuideVideo")
    private final o appendAvatarGuideVideo;

    @SerializedName("appendAvatarVideoAuthStyle")
    private final m appendAvatarVideoAuthStyle;

    @SerializedName("createNewAvatarAuthStyle")
    private final m createNewAvatarAuthStyle;

    @SerializedName("createNewAvatarGuideVideo")
    private final o createNewAvatarGuideVideo;

    public a() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.createNewAvatarAuthStyle, r6.createNewAvatarAuthStyle) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appendAvatarVideoAuthStyle, r6.appendAvatarVideoAuthStyle) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.createNewAvatarGuideVideo, r6.createNewAvatarGuideVideo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.appendAvatarGuideVideo, r6.appendAvatarGuideVideo) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        m r0 = this.createNewAvatarAuthStyle;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        m r4 = this.appendAvatarVideoAuthStyle;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        o r7 = this.createNewAvatarGuideVideo;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        o r10 = this.appendAvatarGuideVideo;
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
        return "DigitalAvatarAuthStyleConfigV2(createNewAvatarAuthStyle=" + this.createNewAvatarAuthStyle + ", appendAvatarVideoAuthStyle=" + this.appendAvatarVideoAuthStyle + ", createNewAvatarGuideVideo=" + this.createNewAvatarGuideVideo + ", appendAvatarGuideVideo=" + this.appendAvatarGuideVideo + ')';
    }

    public final o a() {
        return this.appendAvatarGuideVideo;
    }

    public final m b() {
        return this.appendAvatarVideoAuthStyle;
    }

    public final m c() {
        return this.createNewAvatarAuthStyle;
    }

    public final o d() {
        return this.createNewAvatarGuideVideo;
    }

    public /* synthetic */ a(int r5) {
        this(new m(0), new m(0), new o(null, null, null, null), new o(null, null, null, null));
    }

    public a(m r1, m r2, o r3, o r4) {
        this.createNewAvatarAuthStyle = r1;
        this.appendAvatarVideoAuthStyle = r2;
        this.createNewAvatarGuideVideo = r3;
        this.appendAvatarGuideVideo = r4;
    }
}

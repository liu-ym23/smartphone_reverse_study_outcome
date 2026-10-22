package com.larus.platform.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/larus/platform/model/ProfileLikeCollectListConfig;", "Ljava/io/Serializable;", "likeCollectListStyle", "", "<init>", "(I)V", "getLikeCollectListStyle", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ProfileLikeCollectListConfig implements Serializable {

    @SerializedName("like_collect_list_style")
    private final int likeCollectListStyle;

    public ProfileLikeCollectListConfig() {
        int r2 = 0;
        this(r2, 1, null);
    }

    public static /* synthetic */ ProfileLikeCollectListConfig copy$default(ProfileLikeCollectListConfig r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.likeCollectListStyle;
    L6:
        return r0.copy(r1);
    }

    public final int component1() {
        return this.likeCollectListStyle;
    }

    public final ProfileLikeCollectListConfig copy(@LikeCollectListStyle int r2) {
        return new ProfileLikeCollectListConfig(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof ProfileLikeCollectListConfig) == true) goto L9;
        return false;
    L9:
        if (this.likeCollectListStyle == ((ProfileLikeCollectListConfig) r4).likeCollectListStyle) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.likeCollectListStyle;
    }

    public String toString() {
        return "ProfileLikeCollectListConfig(likeCollectListStyle=" + this.likeCollectListStyle + ')';
    }

    public final int getLikeCollectListStyle() {
        return this.likeCollectListStyle;
    }

    public ProfileLikeCollectListConfig(@LikeCollectListStyle int r1) {
        this.likeCollectListStyle = r1;
    }

    public /* synthetic */ ProfileLikeCollectListConfig(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 0;
    L5:
        this(r1);
    }
}

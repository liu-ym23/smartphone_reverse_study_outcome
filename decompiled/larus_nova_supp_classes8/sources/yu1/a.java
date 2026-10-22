package yu1;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class a {
    private String anchorId;
    private String enterFromMerge;
    private String enterMethod;
    private String followStatus;
    private String liveGuideStoreParam;
    private long roomID;

    public a() {
        this.anchorId = "0";
        this.enterFromMerge = "";
        this.enterMethod = "";
        this.followStatus = "";
        this.liveGuideStoreParam = "";
    }

    public final String getAnchorId() {
        return this.anchorId;
    }

    public final String getEnterFromMerge() {
        return this.enterFromMerge;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getFollowStatus() {
        return this.followStatus;
    }

    public final String getLiveGuideStoreParam() {
        return this.liveGuideStoreParam;
    }

    public final long getRoomID() {
        return this.roomID;
    }

    public final void setAnchorId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.anchorId = r2;
    }

    public final void setEnterFromMerge(String r1) {
        this.enterFromMerge = r1;
    }

    public final void setEnterMethod(String r1) {
        this.enterMethod = r1;
    }

    public final void setFollowStatus(String r1) {
        this.followStatus = r1;
    }

    public final void setLiveGuideStoreParam(String r1) {
        this.liveGuideStoreParam = r1;
    }

    public final void setRoomID(long r1) {
        this.roomID = r1;
    }
}

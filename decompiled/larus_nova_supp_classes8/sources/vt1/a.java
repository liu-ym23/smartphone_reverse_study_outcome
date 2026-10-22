package vt1;

import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lvt1/a;", "", "", "liveRoomRawData", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "groupId", "getGroupId", "", LiveEndPageData.TAG_RANK, "Ljava/lang/Long;", "getRank", "()Ljava/lang/Long;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("group_id")
    private final String groupId;

    @SerializedName("rawdata")
    private final String liveRoomRawData;

    @SerializedName(LiveEndPageData.TAG_RANK)
    private final Long rank;

    public a() {
        this.liveRoomRawData = null;
        this.groupId = null;
        this.rank = null;
    }

    public final String a() {
        return this.liveRoomRawData;
    }
}

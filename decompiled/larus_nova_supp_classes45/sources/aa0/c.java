package aa0;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Laa0/c;", "", "", "needModel", "Z", "a", "()Z", "setNeedModel", "(Z)V", "", "recentInnerFeedCount", "I", "c", "()I", "roomCount", "d", "", "", "producerNameList", "Ljava/util/List;", "b", "()Ljava/util/List;", "<init>", "()V", "livefeature-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("need_model_learning")
    private boolean needModel;

    @SerializedName("producer_name_list")
    private final List<String> producerNameList;

    @SerializedName("recent_inner_feed_count")
    private final int recentInnerFeedCount;

    @SerializedName("room_count")
    private final int roomCount;

    public c() {
        this.recentInnerFeedCount = 2;
        this.roomCount = 10;
    }

    public final boolean a() {
        return this.needModel;
    }

    public final List<String> b() {
        return this.producerNameList;
    }

    public final int c() {
        return this.recentInnerFeedCount;
    }

    public final int d() {
        return this.roomCount;
    }
}

package vt1;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u000b\u0018\u00002\u00020\u0001R.\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R(\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001e\u0010\u0012R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b \u0010\u0017R(\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u001a\u001a\u0004\b\"\u0010\u001c¨\u0006#"}, d2 = {"Lvt1/e;", "", "Ljava/util/ArrayList;", "Lvt1/d;", "Lkotlin/collections/ArrayList;", "liveList", "Ljava/util/ArrayList;", "d", "()Ljava/util/ArrayList;", "", "hasMore", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "", "cursor", "Ljava/lang/Long;", "a", "()Ljava/lang/Long;", "", "requestID", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "", "logPassback", "Ljava/util/Map;", "e", "()Ljava/util/Map;", "statusCode", "g", "statusMsg", "getStatusMsg", "globalDoodleConfig", "b", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("cursor")
    private final Long cursor;

    @SerializedName("global_doodle_config")
    private final Map<String, Object> globalDoodleConfig;

    @SerializedName("has_more")
    private final Boolean hasMore;

    @SerializedName("data")
    private final ArrayList<d> liveList;

    @SerializedName("log_pb")
    private final Map<String, Object> logPassback;

    @SerializedName("_AME_Header_RequestID")
    private final String requestID;

    @SerializedName("status_code")
    private final Long statusCode;

    @SerializedName("status_msg")
    private final String statusMsg;

    public e() {
        this.liveList = null;
        this.hasMore = null;
        this.cursor = null;
        this.requestID = null;
        this.logPassback = null;
        this.statusCode = null;
        this.statusMsg = null;
        this.globalDoodleConfig = null;
    }

    public final Long a() {
        return this.cursor;
    }

    public final Map<String, Object> b() {
        return this.globalDoodleConfig;
    }

    public final Boolean c() {
        return this.hasMore;
    }

    public final ArrayList<d> d() {
        return this.liveList;
    }

    public final Map<String, Object> e() {
        return this.logPassback;
    }

    public final String f() {
        return this.requestID;
    }

    public final Long g() {
        return this.statusCode;
    }
}

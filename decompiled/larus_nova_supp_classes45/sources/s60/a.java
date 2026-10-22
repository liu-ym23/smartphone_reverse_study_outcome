package s60;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R$\u0010\u0019\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015¨\u0006\u001f"}, d2 = {"Ls60/a;", "", "", "enabled", "Z", "getEnabled", "()Z", "setEnabled", "(Z)V", "reportEnabled", "getReportEnabled", "setReportEnabled", "callBackEnabled", "getCallBackEnabled", "setCallBackEnabled", "Ls60/a$a;", "audioPageConfig", "Ls60/a$a;", "getAudioPageConfig", "()Ls60/a$a;", "setAudioPageConfig", "(Ls60/a$a;)V", "videoPageConfig", "getVideoPageConfig", "setVideoPageConfig", "otherPageConfig", "getOtherPageConfig", "setOtherPageConfig", "<init>", "()V", "a", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("audio_page_config")
    private C0274a audioPageConfig;

    @SerializedName("enable_call_back")
    private boolean callBackEnabled;

    @SerializedName("enable")
    private boolean enabled;

    @SerializedName("other_page_config")
    private C0274a otherPageConfig;

    @SerializedName("enable_report")
    private boolean reportEnabled;

    @SerializedName("video_page_config")
    private C0274a videoPageConfig;

    /* JADX INFO: renamed from: s60.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR*\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0012"}, d2 = {"Ls60/a$a;", "", "", "", "blackList", "Ljava/util/List;", "getBlackList", "()Ljava/util/List;", "setBlackList", "(Ljava/util/List;)V", "whiteList", "getWhiteList", "setWhiteList", "urlBlackList", "getUrlBlackList", "setUrlBlackList", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class C0274a {

        @SerializedName("black_list")
        private List<String> blackList;

        @SerializedName("url_black_list")
        private List<String> urlBlackList;

        @SerializedName("white_list")
        private List<String> whiteList;

        public C0274a() {
            this.blackList = CollectionsKt.listOf("");
            this.whiteList = CollectionsKt.listOf(new String[]{"IBroadcastCoreFragment", "AbsInteractionFragment"});
            this.urlBlackList = CollectionsKt.listOf(new String[]{"/obj/static/webcast/mono/h5/revenue_honor_level/douyin/spyman_detail.html", "/goofy/revenue_honor_level/douyin/buff.html"});
        }
    }

    public a() {
        this.audioPageConfig = new C0274a();
        this.videoPageConfig = new C0274a();
        this.otherPageConfig = new C0274a();
    }
}

package com.larus.platform.model.video.business;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u0000  2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001 B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001aH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006!"}, d2 = {"Lcom/larus/platform/model/video/business/EnterVideoMethod;", "Landroid/os/Parcelable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NONE", "MAIN_DOUBLE_TAG", "INDEPENDENT_DOU_YIN_BOT", "BOTTOM_TAB", "OUTER_PUSH", "SEARCH_VIDEO_PAGE", "WELCOME_BACK_AWEME_VIDEO_CARD_LIST", "COLLECTION_VIDEO_PAGE", "CLICK_MUSIC_FLOAT_WINDOW", "CLICK_NOTIFY_BANNER", "FLOW_CLICK_ONLY_VIDEO", "VLM", "VLM_SEARCH_AWEME", "FLOW_CLICK_MIXED_VIDEO_CARD", "FLOW_CLICK_RECOMMEND_VIDEO_CARD", "POI_VIDEO_PAGE", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "CREATOR", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum EnterVideoMethod extends Enum<EnterVideoMethod> implements Parcelable {
    public static final EnterVideoMethod BOTTOM_TAB = null;
    public static final EnterVideoMethod CLICK_MUSIC_FLOAT_WINDOW = null;
    public static final EnterVideoMethod CLICK_NOTIFY_BANNER = null;
    public static final EnterVideoMethod COLLECTION_VIDEO_PAGE = null;
    public static final a CREATOR = null;
    public static final EnterVideoMethod FLOW_CLICK_MIXED_VIDEO_CARD = null;
    public static final EnterVideoMethod FLOW_CLICK_ONLY_VIDEO = null;
    public static final EnterVideoMethod FLOW_CLICK_RECOMMEND_VIDEO_CARD = null;
    public static final EnterVideoMethod INDEPENDENT_DOU_YIN_BOT = null;
    public static final EnterVideoMethod MAIN_DOUBLE_TAG = null;
    public static final EnterVideoMethod NONE = null;
    public static final EnterVideoMethod OUTER_PUSH = null;
    public static final EnterVideoMethod POI_VIDEO_PAGE = null;
    public static final EnterVideoMethod SEARCH_VIDEO_PAGE = null;
    public static final EnterVideoMethod VLM = null;
    public static final EnterVideoMethod VLM_SEARCH_AWEME = null;
    public static final EnterVideoMethod WELCOME_BACK_AWEME_VIDEO_CARD_LIST = null;
    public static final /* synthetic */ EnterVideoMethod[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<EnterVideoMethod> getEntries() {
        return b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [com.larus.platform.model.video.business.EnterVideoMethod$a] */
    static {
        EnterVideoMethod r0 = new EnterVideoMethod("NONE", 0, "");
        NONE = r0;
        EnterVideoMethod r1 = new EnterVideoMethod("MAIN_DOUBLE_TAG", 1, "chat_feed_tab");
        MAIN_DOUBLE_TAG = r1;
        EnterVideoMethod r3 = new EnterVideoMethod("INDEPENDENT_DOU_YIN_BOT", 2, "chat_list_landing");
        INDEPENDENT_DOU_YIN_BOT = r3;
        EnterVideoMethod r5 = new EnterVideoMethod("BOTTOM_TAB", 3, "flow_click_navigate_video");
        BOTTOM_TAB = r5;
        EnterVideoMethod r7 = new EnterVideoMethod("OUTER_PUSH", 4, "flow_outer_push");
        OUTER_PUSH = r7;
        EnterVideoMethod r9 = new EnterVideoMethod("SEARCH_VIDEO_PAGE", 5, "flow_click_video_card");
        SEARCH_VIDEO_PAGE = r9;
        EnterVideoMethod r11 = new EnterVideoMethod("WELCOME_BACK_AWEME_VIDEO_CARD_LIST", 6, "flow_click_onboarding");
        WELCOME_BACK_AWEME_VIDEO_CARD_LIST = r11;
        EnterVideoMethod r13 = new EnterVideoMethod("COLLECTION_VIDEO_PAGE", 7, "click_collection");
        COLLECTION_VIDEO_PAGE = r13;
        EnterVideoMethod r12 = new EnterVideoMethod("CLICK_MUSIC_FLOAT_WINDOW", 8, "click_music_float_window");
        CLICK_MUSIC_FLOAT_WINDOW = r12;
        EnterVideoMethod r10 = new EnterVideoMethod("CLICK_NOTIFY_BANNER", 9, "click_notify_banner");
        CLICK_NOTIFY_BANNER = r10;
        EnterVideoMethod r8 = new EnterVideoMethod("FLOW_CLICK_ONLY_VIDEO", 10, "flow_click_only_video");
        FLOW_CLICK_ONLY_VIDEO = r8;
        EnterVideoMethod r6 = new EnterVideoMethod("VLM", 11, "vlm");
        VLM = r6;
        EnterVideoMethod r4 = new EnterVideoMethod("VLM_SEARCH_AWEME", 12, "vlm_search_aweme");
        VLM_SEARCH_AWEME = r4;
        EnterVideoMethod r2 = new EnterVideoMethod("FLOW_CLICK_MIXED_VIDEO_CARD", 13, "flow_click_mixed_video_card");
        FLOW_CLICK_MIXED_VIDEO_CARD = r2;
        EnterVideoMethod r14 = new EnterVideoMethod("FLOW_CLICK_RECOMMEND_VIDEO_CARD", 14, "flow_click_recommend_video_card");
        FLOW_CLICK_RECOMMEND_VIDEO_CARD = r14;
        EnterVideoMethod r15 = new EnterVideoMethod("POI_VIDEO_PAGE", 15, "poi_video_page");
        POI_VIDEO_PAGE = r15;
        EnterVideoMethod[] r16 = {r0, r1, r3, r5, r7, r9, r11, r13, r12, r10, r8, r6, r4, r2, r14, r15};
        a = r16;
        b = EnumEntriesKt.enumEntries(r16);
        CREATOR = new a();
    }

    public static EnterVideoMethod[] values() {
        return (EnterVideoMethod[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static EnterVideoMethod valueOf(String r1) {
        return (EnterVideoMethod) r27.a.a(EnterVideoMethod.class, r1);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeInt(ordinal());
    }

    public EnterVideoMethod(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}

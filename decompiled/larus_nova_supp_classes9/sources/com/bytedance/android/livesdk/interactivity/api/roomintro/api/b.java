package com.bytedance.android.livesdk.interactivity.api.roomintro.api;

import com.bytedance.android.livesdkapi.depend.model.live.AnchorLocationPoiInfo;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.android.livesdkapi.service.com.bytedance.android.livesdkapi.message.AppointmentInfo;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000fR*\u0010\"\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R0\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010/\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0004\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u0010\bR$\u00102\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010\u000b\u001a\u0004\b3\u0010\r\"\u0004\b4\u0010\u000fR$\u00106\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R$\u0010<\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u0010\u000b\u001a\u0004\b=\u0010\r\"\u0004\b>\u0010\u000fR$\u0010?\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010\u000b\u001a\u0004\b@\u0010\r\"\u0004\bA\u0010\u000fR$\u0010B\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u00107\u001a\u0004\bC\u00109\"\u0004\bD\u0010;R*\u0010F\u001a\n\u0012\u0004\u0012\u00020E\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bF\u0010#\u001a\u0004\bG\u0010%\"\u0004\bH\u0010'R*\u0010I\u001a\n\u0012\u0004\u0012\u00020E\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bI\u0010#\u001a\u0004\bJ\u0010%\"\u0004\bK\u0010'R$\u0010L\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bL\u0010\u0018\u001a\u0004\bM\u0010\u001a\"\u0004\bN\u0010\u001cR*\u0010Q\u001a\n\u0012\u0004\u0012\u00020P\u0018\u00010O8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bQ\u0010#\u001a\u0004\bR\u0010%\"\u0004\bS\u0010'R*\u0010U\u001a\n\u0012\u0004\u0012\u00020T\u0018\u00010O8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bU\u0010#\u001a\u0004\bV\u0010%\"\u0004\bW\u0010'R$\u0010Y\u001a\u0004\u0018\u00010X8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R$\u0010`\u001a\u0004\u0018\u00010_8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR$\u0010g\u001a\u0004\u0018\u00010f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010l¨\u0006m"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/roomintro/api/b;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "status", "Ljava/lang/Integer;", "j", "()Ljava/lang/Integer;", "setStatus", "(Ljava/lang/Integer;)V", BuildConfig.FLAVOR, "desc", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", BuildConfig.FLAVOR, "switch", "Z", "k", "()Z", "setSwitch", "(Z)V", "isTemplate", "Ljava/lang/Boolean;", "l", "()Ljava/lang/Boolean;", "setTemplate", "(Ljava/lang/Boolean;)V", "introduction", "e", "setIntroduction", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/interactivity/api/roomintro/api/a;", "labels", "Ljava/util/List;", "getLabels", "()Ljava/util/List;", "setLabels", "(Ljava/util/List;)V", BuildConfig.FLAVOR, "defaultLabels", "Ljava/util/Map;", "getDefaultLabels", "()Ljava/util/Map;", "setDefaultLabels", "(Ljava/util/Map;)V", "introVideoSwitch", "getIntroVideoSwitch", "setIntroVideoSwitch", "videoLimitReason", "getVideoLimitReason", "setVideoLimitReason", BuildConfig.FLAVOR, "videoId", "Ljava/lang/Long;", "getVideoId", "()Ljava/lang/Long;", "setVideoId", "(Ljava/lang/Long;)V", "videoTitle", "getVideoTitle", "setVideoTitle", "videoCoverUrl", "getVideoCoverUrl", "setVideoCoverUrl", "videoDiggCount", "getVideoDiggCount", "setVideoDiggCount", "Lcom/bytedance/android/livesdkapi/depend/model/live/RoomIntroLabel;", "selectableLabels", "h", "setSelectableLabels", "selectedLabels", "i", "setSelectedLabels", "needPopupSave", "getNeedPopupSave", "setNeedPopupSave", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/interactivity/api/roomintro/api/LabelGroup;", "labelGroups", "f", "setLabelGroups", "Lcom/bytedance/android/livesdk/interactivity/api/roomintro/api/IntroGuideButton;", "introGuideButtons", "d", "setIntroGuideButtons", "Lcom/bytedance/android/livesdk/interactivity/api/roomintro/api/PoiInfo;", "poiInfo", "Lcom/bytedance/android/livesdk/interactivity/api/roomintro/api/PoiInfo;", "g", "()Lcom/bytedance/android/livesdk/interactivity/api/roomintro/api/PoiInfo;", "setPoiInfo", "(Lcom/bytedance/android/livesdk/interactivity/api/roomintro/api/PoiInfo;)V", "Lcom/bytedance/android/livesdkapi/service/com/bytedance/android/livesdkapi/message/AppointmentInfo;", "appointmentInfo", "Lcom/bytedance/android/livesdkapi/service/com/bytedance/android/livesdkapi/message/AppointmentInfo;", "b", "()Lcom/bytedance/android/livesdkapi/service/com/bytedance/android/livesdkapi/message/AppointmentInfo;", "setAppointmentInfo", "(Lcom/bytedance/android/livesdkapi/service/com/bytedance/android/livesdkapi/message/AppointmentInfo;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/AnchorLocationPoiInfo;", "anchorLocationPoiInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/AnchorLocationPoiInfo;", "a", "()Lcom/bytedance/android/livesdkapi/depend/model/live/AnchorLocationPoiInfo;", "setAnchorLocationPoiInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/AnchorLocationPoiInfo;)V", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("anchor_location_poi_info")
    private AnchorLocationPoiInfo anchorLocationPoiInfo;

    @SerializedName("appointment_info")
    private AppointmentInfo appointmentInfo;

    @SerializedName("default_labels")
    private Map<String, String> defaultLabels;

    @SerializedName("desc")
    private String desc;

    @SerializedName("intro_guide_buttons")
    private List<IntroGuideButton> introGuideButtons;

    @SerializedName("intro_video_switch")
    private Integer introVideoSwitch;

    @SerializedName("introduction")
    private String introduction;

    @SerializedName("is_template")
    private Boolean isTemplate;

    @SerializedName("label_groups")
    private List<LabelGroup> labelGroups;

    @SerializedName("labels")
    private List<a> labels;

    @SerializedName("need_pop_up_to_save")
    private Boolean needPopupSave;

    @SerializedName("poi_info")
    private PoiInfo poiInfo;

    @SerializedName("optional_labels")
    private List<RoomIntroLabel> selectableLabels;

    @SerializedName("intro_labels")
    private List<RoomIntroLabel> selectedLabels;

    @SerializedName("status")
    private Integer status;

    /* JADX INFO: renamed from: switch, reason: not valid java name */
    @SerializedName("intro_switch")
    private boolean f0switch;

    @SerializedName("intro_video_cover_url")
    private String videoCoverUrl;

    @SerializedName("intro_video_digg_count")
    private Long videoDiggCount;

    @SerializedName("intro_video_item_id")
    private Long videoId;

    @SerializedName("intro_video_limit_reason")
    private String videoLimitReason;

    @SerializedName("intro_video_title")
    private String videoTitle;

    public final AnchorLocationPoiInfo a() {
        return this.anchorLocationPoiInfo;
    }

    public final AppointmentInfo b() {
        return this.appointmentInfo;
    }

    public final String c() {
        return this.desc;
    }

    public final List<IntroGuideButton> d() {
        return this.introGuideButtons;
    }

    public final String e() {
        return this.introduction;
    }

    public final List<LabelGroup> f() {
        return this.labelGroups;
    }

    public final PoiInfo g() {
        return this.poiInfo;
    }

    public final List<RoomIntroLabel> h() {
        return this.selectableLabels;
    }

    public final List<RoomIntroLabel> i() {
        return this.selectedLabels;
    }

    public final Integer j() {
        return this.status;
    }

    public final boolean k() {
        return this.f0switch;
    }

    public final Boolean l() {
        return this.isTemplate;
    }
}

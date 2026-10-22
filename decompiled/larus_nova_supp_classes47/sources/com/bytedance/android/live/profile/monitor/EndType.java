package com.bytedance.android.live.profile.monitor;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/profile/monitor/EndType;", "", "", "stateCode", "I", "getStateCode", "()I", "", "description", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "Success", "DialogShowing", "ProfileLauncherShowing", "TransitionProfileLauncherShowing", "ActivityNullOrPause", "RoomIllegal", "HideProfile", "NetworkRequesting", "HostFragmentInfoErr", "NetworkRequestError", "Dismissed", "ClickFrequently", "ViewInvalid", "EventIsNull", "HideProfileWithReportDialog", "BroadcastPluginLoadFailed", "Unlogin", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EndType extends Enum<EndType> {
    public static final EndType ActivityNullOrPause = null;
    public static final EndType BroadcastPluginLoadFailed = null;
    public static final EndType ClickFrequently = null;
    public static final EndType DialogShowing = null;
    public static final EndType Dismissed = null;
    public static final EndType EventIsNull = null;
    public static final EndType HideProfile = null;
    public static final EndType HideProfileWithReportDialog = null;
    public static final EndType HostFragmentInfoErr = null;
    public static final EndType NetworkRequestError = null;
    public static final EndType NetworkRequesting = null;
    public static final EndType ProfileLauncherShowing = null;
    public static final EndType RoomIllegal = null;
    public static final EndType Success = null;
    public static final EndType TransitionProfileLauncherShowing = null;
    public static final EndType Unlogin = null;
    public static final EndType ViewInvalid = null;
    public static final /* synthetic */ EndType[] a = null;
    private final String description;
    private final int stateCode;

    public static EndType valueOf(String r1) {
        return (EndType) a.a(EndType.class, r1);
    }

    public static EndType[] values() {
        return (EndType[]) a.clone();
    }

    static {
        EndType r1 = new EndType("Success", 0, 0, "成功");
        Success = r1;
        EndType r2 = new EndType("DialogShowing", 1, 1, "资料卡面板正在展示");
        DialogShowing = r2;
        EndType r3 = new EndType("ProfileLauncherShowing", 2, 2, "接口launcher正在请求中，或面板正在展示");
        ProfileLauncherShowing = r3;
        EndType r4 = new EndType("TransitionProfileLauncherShowing", 3, 3, "过渡特效launcher正在请求中，或面板正在展示中");
        TransitionProfileLauncherShowing = r4;
        EndType r5 = new EndType("ActivityNullOrPause", 4, 4, "activity为空，或交互层被暂停");
        ActivityNullOrPause = r5;
        EndType r6 = new EndType("RoomIllegal", 5, 5, "room信息不合法");
        RoomIllegal = r6;
        EndType r7 = new EndType("HideProfile", 6, 6, "直播间不允许打开资料卡，toast拦截");
        HideProfile = r7;
        EndType r8 = new EndType("NetworkRequesting", 7, 7, "profile接口正在请求");
        NetworkRequesting = r8;
        EndType r9 = new EndType("HostFragmentInfoErr", 8, 8, "fragmentActivity信息错误");
        HostFragmentInfoErr = r9;
        EndType r10 = new EndType("NetworkRequestError", 9, 9, "profile接口报错");
        NetworkRequestError = r10;
        EndType r12 = new EndType("Dismissed", 10, 10, "请求成功，但是资料卡已经被取消");
        Dismissed = r12;
        EndType r13 = new EndType("ClickFrequently", 11, 11, "点击过于频繁");
        ClickFrequently = r13;
        EndType r14 = new EndType("ViewInvalid", 12, 12, "view无效");
        ViewInvalid = r14;
        EndType r15 = new EndType("EventIsNull", 13, 13, "UserProfileEvent为null");
        EventIsNull = r15;
        EndType r16 = new EndType("HideProfileWithReportDialog", 14, 14, "直播间不允许打开资料卡，吊起了举报面板");
        HideProfileWithReportDialog = r16;
        EndType r17 = new EndType("BroadcastPluginLoadFailed", 15, 15, "开播插件加载失败");
        BroadcastPluginLoadFailed = r17;
        EndType r18 = new EndType("Unlogin", 16, 16, "未登录时不支持打开资料卡");
        Unlogin = r18;
        a = new EndType[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13, r14, r15, r16, r17, r18};
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getStateCode() {
        return this.stateCode;
    }

    public EndType(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.stateCode = r3;
        this.description = r4;
    }
}

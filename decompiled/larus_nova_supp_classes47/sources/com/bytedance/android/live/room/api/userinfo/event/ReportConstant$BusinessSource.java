package com.bytedance.android.live.room.api.userinfo.event;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final enum ReportConstant$BusinessSource extends Enum<ReportConstant$BusinessSource> {
    public static final ReportConstant$BusinessSource AudienceOperatePanel = null;
    public static final ReportConstant$BusinessSource InputPanel = null;
    public static final ReportConstant$BusinessSource LandscapeScreenShot = null;
    public static final ReportConstant$BusinessSource LiveRoomFragmentDislikeMenu = null;
    public static final ReportConstant$BusinessSource LiveRoomFragmentDislikeOrHideMenu = null;
    public static final ReportConstant$BusinessSource LongPressPanel = null;
    public static final ReportConstant$BusinessSource ManagePanel = null;
    public static final ReportConstant$BusinessSource MorePanelReportButton = null;
    public static final ReportConstant$BusinessSource MorePanelShareButton = null;
    public static final ReportConstant$BusinessSource MultiLinkGuestLink = null;
    public static final ReportConstant$BusinessSource MysteriousManProfile = null;
    public static final ReportConstant$BusinessSource NewProfile = null;
    public static final ReportConstant$BusinessSource OldProfile = null;
    public static final ReportConstant$BusinessSource PreviewShareButton = null;
    public static final ReportConstant$BusinessSource ReportAnonymityComment = null;
    public static final ReportConstant$BusinessSource ReportJSB = null;
    public static final ReportConstant$BusinessSource RoomChannelLinkManagePanel = null;
    public static final ReportConstant$BusinessSource ScreenShot = null;
    public static final ReportConstant$BusinessSource ShareAction = null;
    public static final ReportConstant$BusinessSource VSMorePanelShareButton = null;
    public static final /* synthetic */ ReportConstant$BusinessSource[] a = null;
    private final String businessType;
    private final String description;

    static {
        ReportConstant$BusinessSource r0 = new ReportConstant$BusinessSource("MysteriousManProfile", 0, "MysteriousMan", "神秘人资料卡");
        MysteriousManProfile = r0;
        ReportConstant$BusinessSource r1 = new ReportConstant$BusinessSource("NewProfile", 1, "NewProfile", "新版资料卡");
        NewProfile = r1;
        ReportConstant$BusinessSource r2 = new ReportConstant$BusinessSource("OldProfile", 2, "OldProfile", "旧版资料卡");
        OldProfile = r2;
        ReportConstant$BusinessSource r3 = new ReportConstant$BusinessSource("ManagePanel", 3, "ManagePanel", "管理面板");
        ManagePanel = r3;
        ReportConstant$BusinessSource r6 = new ReportConstant$BusinessSource("AudienceOperatePanel", 4, "AudienceOperatePanel", "用户侧公屏操作面板");
        AudienceOperatePanel = r6;
        ReportConstant$BusinessSource r8 = new ReportConstant$BusinessSource("ReportAnonymityComment", 5, "ReportAnonymityComment", "举报匿名直播间评论");
        ReportAnonymityComment = r8;
        ReportConstant$BusinessSource r10 = new ReportConstant$BusinessSource("ReportJSB", 6, "ReportJSB", "前端调用举报JSB");
        ReportJSB = r10;
        ReportConstant$BusinessSource r12 = new ReportConstant$BusinessSource("InputPanel", 7, "CommentAssociation", "输入面板文字联想唤起举报页面");
        InputPanel = r12;
        ReportConstant$BusinessSource r13 = new ReportConstant$BusinessSource("ShareAction", 8, "ShareAction", "ShareAction");
        ShareAction = r13;
        ReportConstant$BusinessSource r14 = new ReportConstant$BusinessSource("MorePanelReportButton", 9, "MorePanelReportButton", "更多面板举报按钮");
        MorePanelReportButton = r14;
        ReportConstant$BusinessSource r15 = new ReportConstant$BusinessSource("MorePanelShareButton", 10, "MorePanelShareButton", "更多面板分享按钮");
        MorePanelShareButton = r15;
        ReportConstant$BusinessSource r16 = new ReportConstant$BusinessSource("PreviewShareButton", 11, "PreviewShareButton", "预览流分享按钮");
        PreviewShareButton = r16;
        ReportConstant$BusinessSource r5 = new ReportConstant$BusinessSource("LongPressPanel", 12, "LongPressPanel", "长按面板举报");
        LongPressPanel = r5;
        ReportConstant$BusinessSource r4 = new ReportConstant$BusinessSource("LiveRoomFragmentDislikeMenu", 13, "LiveRoomFragmentDislikeMenu", "LiveRoomFragment不喜欢菜单");
        LiveRoomFragmentDislikeMenu = r4;
        ReportConstant$BusinessSource r7 = new ReportConstant$BusinessSource("LiveRoomFragmentDislikeOrHideMenu", 14, "LiveRoomFragmentDislikeOrHideMenu", "LiveRoomFragment附带清屏功能的不喜欢菜单");
        LiveRoomFragmentDislikeOrHideMenu = r7;
        ReportConstant$BusinessSource r9 = new ReportConstant$BusinessSource("VSMorePanelShareButton", 15, "MorePanelShareButton", "VS侧更多面板分享按钮");
        VSMorePanelShareButton = r9;
        ReportConstant$BusinessSource r17 = new ReportConstant$BusinessSource("RoomChannelLinkManagePanel", 16, "RoomChannelLinkManagePanel", "频道房语音成员管理面板");
        RoomChannelLinkManagePanel = r17;
        ReportConstant$BusinessSource r18 = new ReportConstant$BusinessSource("ScreenShot", 17, "ScreenShot", "截屏举报");
        ScreenShot = r18;
        ReportConstant$BusinessSource r19 = new ReportConstant$BusinessSource("LandscapeScreenShot", 18, "LandscapeScreenShot", "横屏截屏举报");
        LandscapeScreenShot = r19;
        ReportConstant$BusinessSource r20 = new ReportConstant$BusinessSource("MultiLinkGuestLink", 19, "GuestLink", "多人场景嘉宾连线功能举报");
        MultiLinkGuestLink = r20;
        a = new ReportConstant$BusinessSource[]{r0, r1, r2, r3, r6, r8, r10, r12, r13, r14, r15, r16, r5, r4, r7, r9, r17, r18, r19, r20};
    }

    public static ReportConstant$BusinessSource[] values() {
        return (ReportConstant$BusinessSource[]) a.clone();
    }

    public String getBusinessType() {
        return this.businessType;
    }

    public static ReportConstant$BusinessSource valueOf(String r1) {
        return (ReportConstant$BusinessSource) a.a(ReportConstant$BusinessSource.class, r1);
    }

    public ReportConstant$BusinessSource(String r1, int r2, String r3, String r4) {
        super(r1, r2);
        this.businessType = r3;
        this.description = r4;
    }
}

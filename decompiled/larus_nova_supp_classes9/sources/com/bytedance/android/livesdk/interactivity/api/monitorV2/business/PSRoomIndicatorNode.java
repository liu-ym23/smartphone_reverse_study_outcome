package com.bytedance.android.livesdk.interactivity.api.monitorV2.business;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/monitorV2/business/PSRoomIndicatorNode;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "indicatorName", "Ljava/lang/String;", "getIndicatorName", "()Ljava/lang/String;", "PortraitCommentPanelShowDelay", "PortraitLongClickCommentPanelShowDelay", "LandscapeCommentPanelShowDelay", "PortraitAdminDanmakuShowDelay", "PortraitPrivilegeDanmakuShowDelay", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PSRoomIndicatorNode extends Enum<PSRoomIndicatorNode> {
    public static final PSRoomIndicatorNode LandscapeCommentPanelShowDelay = null;
    public static final PSRoomIndicatorNode PortraitAdminDanmakuShowDelay = null;
    public static final PSRoomIndicatorNode PortraitCommentPanelShowDelay = null;
    public static final PSRoomIndicatorNode PortraitLongClickCommentPanelShowDelay = null;
    public static final PSRoomIndicatorNode PortraitPrivilegeDanmakuShowDelay = null;
    public static final /* synthetic */ PSRoomIndicatorNode[] a = null;
    private final String indicatorName;

    static {
        PSRoomIndicatorNode r1 = new PSRoomIndicatorNode("PortraitCommentPanelShowDelay", 0, "portrait_comment_panel_show_delay");
        PortraitCommentPanelShowDelay = r1;
        PSRoomIndicatorNode r2 = new PSRoomIndicatorNode("PortraitLongClickCommentPanelShowDelay", 1, "portrait_long_click_panel_show_delay");
        PortraitLongClickCommentPanelShowDelay = r2;
        PSRoomIndicatorNode r3 = new PSRoomIndicatorNode("LandscapeCommentPanelShowDelay", 2, "landscape_comment_panel_show_delay");
        LandscapeCommentPanelShowDelay = r3;
        PSRoomIndicatorNode r4 = new PSRoomIndicatorNode("PortraitAdminDanmakuShowDelay", 3, "portrait_admin_danmaku_show_delay");
        PortraitAdminDanmakuShowDelay = r4;
        PSRoomIndicatorNode r5 = new PSRoomIndicatorNode("PortraitPrivilegeDanmakuShowDelay", 4, "portrait_privilege_danmaku_show_delay");
        PortraitPrivilegeDanmakuShowDelay = r5;
        a = new PSRoomIndicatorNode[]{r1, r2, r3, r4, r5};
    }

    public static PSRoomIndicatorNode valueOf(String r1) {
        return (PSRoomIndicatorNode) a.a(PSRoomIndicatorNode.class, r1);
    }

    public static PSRoomIndicatorNode[] values() {
        return (PSRoomIndicatorNode[]) a.clone();
    }

    public final String getIndicatorName() {
        return this.indicatorName;
    }

    public PSRoomIndicatorNode(String r1, int r2, String r3) {
        super(r1, r2);
        this.indicatorName = r3;
    }
}

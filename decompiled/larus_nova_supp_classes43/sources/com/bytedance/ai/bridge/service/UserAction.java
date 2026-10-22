package com.bytedance.ai.bridge.service;

import com.bytedance.ai.api.navi.AppletNaviThirdApp;
import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ai/bridge/service/UserAction;", "", a.KEY_LUBAN_VALUE, "", "humanStr", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "getHumanStr", "SELECT_MAP", "AUTONAVI", "INSTALL_AUTONAVI", "BAIDU", "TENCENT", "CANCEL", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UserAction extends Enum<UserAction> {
    public static final UserAction AUTONAVI = null;
    public static final UserAction BAIDU = null;
    public static final UserAction CANCEL = null;
    public static final UserAction INSTALL_AUTONAVI = null;
    public static final UserAction SELECT_MAP = null;
    public static final UserAction TENCENT = null;
    public static final /* synthetic */ UserAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String humanStr;
    private final String value;

    public static EnumEntries<UserAction> getEntries() {
        return b;
    }

    static {
        UserAction r0 = new UserAction("SELECT_MAP", 0, "selectMap", "选择地图");
        SELECT_MAP = r0;
        UserAction r1 = new UserAction("AUTONAVI", 1, "autonavi", "高德地图");
        AUTONAVI = r1;
        UserAction r10 = new UserAction("INSTALL_AUTONAVI", 2, "installAutonavi", "高德地图（未安装）");
        INSTALL_AUTONAVI = r10;
        UserAction r11 = new UserAction("BAIDU", 3, AppletNaviThirdApp.BAIDU, "百度地图");
        BAIDU = r11;
        UserAction r12 = new UserAction("TENCENT", 4, "tencent", "腾讯地图");
        TENCENT = r12;
        UserAction r13 = new UserAction("CANCEL", 5, "cancel", "取消");
        CANCEL = r13;
        UserAction[] r14 = {r0, r1, r10, r11, r12, r13};
        a = r14;
        b = EnumEntriesKt.enumEntries(r14);
    }

    public static UserAction[] values() {
        return (UserAction[]) a.clone();
    }

    public final String getHumanStr() {
        return this.humanStr;
    }

    public final String getValue() {
        return this.value;
    }

    public static UserAction valueOf(String r1) {
        return (UserAction) r27.a.a(UserAction.class, r1);
    }

    public UserAction(String r1, int r10, String r11, String r12) {
        super(r1, r10);
        this.value = r11;
        this.humanStr = r12;
    }
}

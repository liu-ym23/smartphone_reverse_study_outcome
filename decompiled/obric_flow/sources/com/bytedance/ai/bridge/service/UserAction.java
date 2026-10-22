package com.bytedance.ai.bridge.service;

import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/bridge/service/UserAction;", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum UserAction extends Enum<UserAction> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final UserAction f2082c = null;
    public static final UserAction d = null;
    public static final UserAction e = null;
    public static final UserAction f = null;
    public static final /* synthetic */ UserAction[] g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2084b;

    static {
        UserAction r5 = new UserAction("SELECT_MAP", 0, "selectMap", "选择地图");
        UserAction r10 = new UserAction("AUTONAVI", 1, "autonavi", "高德地图");
        f2082c = r10;
        UserAction r11 = new UserAction("INSTALL_AUTONAVI", 2, "installAutonavi", "高德地图（未安装）");
        d = r11;
        UserAction r12 = new UserAction("BAIDU", 3, "baidu", "百度地图");
        e = r12;
        UserAction r13 = new UserAction("TENCENT", 4, "tencent", "腾讯地图");
        f = r13;
        UserAction[] r14 = {r5, r10, r11, r12, r13, new UserAction("CANCEL", 5, "cancel", "取消")};
        g = r14;
        EnumEntriesKt.enumEntries(r14);
    }

    public UserAction(String r5, int r10, String r11, String r12) {
        super(r5, r10);
        this.f2083a = r11;
        this.f2084b = r12;
    }

    public static UserAction valueOf(String r5) {
        return (UserAction) Enum.valueOf(UserAction.class, r5);
    }

    public static UserAction[] values() {
        return (UserAction[]) g.clone();
    }
}

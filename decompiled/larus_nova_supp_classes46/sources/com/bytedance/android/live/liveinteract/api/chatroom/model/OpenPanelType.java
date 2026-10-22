package com.bytedance.android.live.liveinteract.api.chatroom.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/liveinteract/api/chatroom/model/OpenPanelType;", "", "", "value", "I", "getValue", "()I", "NONE", "LINK_METHOD_SETTING_PANEL", "PAID_LINK_SETTING_PANEL", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum OpenPanelType extends Enum<OpenPanelType> {
    public static final OpenPanelType LINK_METHOD_SETTING_PANEL = null;
    public static final OpenPanelType NONE = null;
    public static final OpenPanelType PAID_LINK_SETTING_PANEL = null;
    public static final /* synthetic */ OpenPanelType[] a = null;
    private final int value;

    static {
        OpenPanelType r1 = new OpenPanelType("NONE", 0, 0);
        NONE = r1;
        OpenPanelType r2 = new OpenPanelType("LINK_METHOD_SETTING_PANEL", 1, 1);
        LINK_METHOD_SETTING_PANEL = r2;
        OpenPanelType r3 = new OpenPanelType("PAID_LINK_SETTING_PANEL", 2, 2);
        PAID_LINK_SETTING_PANEL = r3;
        a = new OpenPanelType[]{r1, r2, r3};
    }

    public static OpenPanelType valueOf(String r1) {
        return (OpenPanelType) r27.a.a(OpenPanelType.class, r1);
    }

    public static OpenPanelType[] values() {
        return (OpenPanelType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public OpenPanelType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

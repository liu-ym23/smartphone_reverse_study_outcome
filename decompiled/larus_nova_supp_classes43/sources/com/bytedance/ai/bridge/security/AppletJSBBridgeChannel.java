package com.bytedance.ai.bridge.security;

import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ai/bridge/security/AppletJSBBridgeChannel;", "", a.KEY_LUBAN_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "AIBRIDGE", "XBRIDGE", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppletJSBBridgeChannel extends Enum<AppletJSBBridgeChannel> {
    public static final AppletJSBBridgeChannel AIBRIDGE = null;
    public static final AppletJSBBridgeChannel XBRIDGE = null;
    public static final /* synthetic */ AppletJSBBridgeChannel[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<AppletJSBBridgeChannel> getEntries() {
        return b;
    }

    static {
        AppletJSBBridgeChannel r0 = new AppletJSBBridgeChannel("AIBRIDGE", 0, "aibridge");
        AIBRIDGE = r0;
        AppletJSBBridgeChannel r1 = new AppletJSBBridgeChannel("XBRIDGE", 1, "xbridge");
        XBRIDGE = r1;
        AppletJSBBridgeChannel[] r10 = {r0, r1};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
    }

    public static AppletJSBBridgeChannel[] values() {
        return (AppletJSBBridgeChannel[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static AppletJSBBridgeChannel valueOf(String r1) {
        return (AppletJSBBridgeChannel) r27.a.a(AppletJSBBridgeChannel.class, r1);
    }

    public AppletJSBBridgeChannel(String r1, int r10, String r11) {
        super(r1, r10);
        this.value = r11;
    }
}

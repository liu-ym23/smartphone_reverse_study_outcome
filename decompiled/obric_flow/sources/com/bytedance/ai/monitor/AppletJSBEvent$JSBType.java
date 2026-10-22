package com.bytedance.ai.monitor;

import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/ai/monitor/AppletJSBEvent$JSBType", "", "Lcom/bytedance/ai/monitor/AppletJSBEvent$JSBType;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum AppletJSBEvent$JSBType extends Enum<AppletJSBEvent$JSBType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppletJSBEvent$JSBType f2381a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AppletJSBEvent$JSBType f2382b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AppletJSBEvent$JSBType[] f2383c = null;

    static {
        AppletJSBEvent$JSBType r5 = new AppletJSBEvent$JSBType("AppletJSB", 0);
        f2381a = r5;
        AppletJSBEvent$JSBType r10 = new AppletJSBEvent$JSBType("XBridge", 1);
        f2382b = r10;
        AppletJSBEvent$JSBType[] r11 = {r5, r10};
        f2383c = r11;
        EnumEntriesKt.enumEntries(r11);
    }

    public AppletJSBEvent$JSBType(String r5, int r10) {
        super(r5, r10);
    }

    public static AppletJSBEvent$JSBType valueOf(String r5) {
        return (AppletJSBEvent$JSBType) Enum.valueOf(AppletJSBEvent$JSBType.class, r5);
    }

    public static AppletJSBEvent$JSBType[] values() {
        return (AppletJSBEvent$JSBType[]) f2383c.clone();
    }
}

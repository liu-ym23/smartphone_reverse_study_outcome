package com.bytedance.ai.applet.app;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/applet/app/AppletShowMode;", "", "<init>", "(Ljava/lang/String;I)V", "FULL_SCREEN", "EIGHT_SCREEN", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppletShowMode extends Enum<AppletShowMode> {
    public static final AppletShowMode EIGHT_SCREEN = null;
    public static final AppletShowMode FULL_SCREEN = null;
    public static final /* synthetic */ AppletShowMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AppletShowMode> getEntries() {
        return b;
    }

    static {
        AppletShowMode r0 = new AppletShowMode("FULL_SCREEN", 0);
        FULL_SCREEN = r0;
        AppletShowMode r1 = new AppletShowMode("EIGHT_SCREEN", 1);
        EIGHT_SCREEN = r1;
        AppletShowMode[] r10 = {r0, r1};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
    }

    public static AppletShowMode[] values() {
        return (AppletShowMode[]) a.clone();
    }

    public static AppletShowMode valueOf(String r1) {
        return (AppletShowMode) r27.a.a(AppletShowMode.class, r1);
    }

    public AppletShowMode(String r1, int r10) {
        super(r1, r10);
    }
}

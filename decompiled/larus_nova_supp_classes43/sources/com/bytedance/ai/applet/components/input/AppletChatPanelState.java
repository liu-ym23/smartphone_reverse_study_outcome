package com.bytedance.ai.applet.components.input;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ai/applet/components/input/AppletChatPanelState;", "", "<init>", "(Ljava/lang/String;I)V", "COLLAPSED", "PREVIEW", "EXPANDED", "INVISIBLE", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppletChatPanelState extends Enum<AppletChatPanelState> {
    public static final AppletChatPanelState COLLAPSED = null;
    public static final AppletChatPanelState EXPANDED = null;
    public static final AppletChatPanelState INVISIBLE = null;
    public static final AppletChatPanelState PREVIEW = null;
    public static final /* synthetic */ AppletChatPanelState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AppletChatPanelState> getEntries() {
        return b;
    }

    static {
        AppletChatPanelState r0 = new AppletChatPanelState("COLLAPSED", 0);
        COLLAPSED = r0;
        AppletChatPanelState r1 = new AppletChatPanelState("PREVIEW", 1);
        PREVIEW = r1;
        AppletChatPanelState r10 = new AppletChatPanelState("EXPANDED", 2);
        EXPANDED = r10;
        AppletChatPanelState r11 = new AppletChatPanelState("INVISIBLE", 3);
        INVISIBLE = r11;
        AppletChatPanelState[] r12 = {r0, r1, r10, r11};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static AppletChatPanelState[] values() {
        return (AppletChatPanelState[]) a.clone();
    }

    public static AppletChatPanelState valueOf(String r1) {
        return (AppletChatPanelState) a.a(AppletChatPanelState.class, r1);
    }

    public AppletChatPanelState(String r1, int r10) {
        super(r1, r10);
    }
}

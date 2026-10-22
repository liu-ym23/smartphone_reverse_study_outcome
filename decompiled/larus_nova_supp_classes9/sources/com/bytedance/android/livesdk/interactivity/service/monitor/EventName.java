package com.bytedance.android.livesdk.interactivity.service.monitor;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/service/monitor/EventName;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "str", "Ljava/lang/String;", "getStr", "()Ljava/lang/String;", "Default", "InputPanelMonitorEvent", "PublicScreenRealtimeMonitorEvent", "PublicScreenRoomStatMonitorEvent", "PublicScreenNoMessageShowEvent", "HighLevelNoMessageShowEvent", "ChatApiTrigger", "CommentPanelShowDelay", "ChatSendToShowDelay", "community-service_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EventName extends Enum<EventName> {
    public static final EventName ChatApiTrigger = null;
    public static final EventName ChatSendToShowDelay = null;
    public static final EventName CommentPanelShowDelay = null;
    public static final EventName Default = null;
    public static final EventName HighLevelNoMessageShowEvent = null;
    public static final EventName InputPanelMonitorEvent = null;
    public static final EventName PublicScreenNoMessageShowEvent = null;
    public static final EventName PublicScreenRealtimeMonitorEvent = null;
    public static final EventName PublicScreenRoomStatMonitorEvent = null;
    public static final /* synthetic */ EventName[] a = null;
    private final String str;

    public static EventName valueOf(String r1) {
        return (EventName) r27.a.a(EventName.class, r1);
    }

    public static EventName[] values() {
        return (EventName[]) a.clone();
    }

    static {
        EventName r1 = new EventName("Default", 0, "default");
        Default = r1;
        EventName r2 = new EventName("InputPanelMonitorEvent", 1, "livesdk_message_link_input_monitor");
        InputPanelMonitorEvent = r2;
        EventName r3 = new EventName("PublicScreenRealtimeMonitorEvent", 2, "livesdk_public_screen_realtime_monitor");
        PublicScreenRealtimeMonitorEvent = r3;
        EventName r4 = new EventName("PublicScreenRoomStatMonitorEvent", 3, "livesdk_public_screen_room_stat_monitor");
        PublicScreenRoomStatMonitorEvent = r4;
        EventName r5 = new EventName("PublicScreenNoMessageShowEvent", 4, "livesdk_public_screen_no_message_show_event");
        PublicScreenNoMessageShowEvent = r5;
        EventName r6 = new EventName("HighLevelNoMessageShowEvent", 5, "ttlive_high_level_no_message_show_event");
        HighLevelNoMessageShowEvent = r6;
        EventName r7 = new EventName("ChatApiTrigger", 6, "livesdk_chat_api_trigger");
        ChatApiTrigger = r7;
        EventName r8 = new EventName("CommentPanelShowDelay", 7, "livesdk_comment_panel_show_delay");
        CommentPanelShowDelay = r8;
        EventName r9 = new EventName("ChatSendToShowDelay", 8, "livesdk_chat_send_to_show_delay");
        ChatSendToShowDelay = r9;
        a = new EventName[]{r1, r2, r3, r4, r5, r6, r7, r8, r9};
    }

    public final String getStr() {
        return this.str;
    }

    public EventName(String r1, int r2, String r3) {
        super(r1, r2);
        this.str = r3;
    }
}

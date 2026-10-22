package com.bytedance.android.live.profile.monitor;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/profile/monitor/EventType;", "", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "description", "getDescription", "EnterAnimTimeout", "ClickOutside", "ClickBackCode", "CallDismiss", "RoomUserInRespIsNull", "ProfileUserInRespIsNull", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EventType extends Enum<EventType> {
    public static final EventType CallDismiss = null;
    public static final EventType ClickBackCode = null;
    public static final EventType ClickOutside = null;
    public static final EventType EnterAnimTimeout = null;
    public static final EventType ProfileUserInRespIsNull = null;
    public static final EventType RoomUserInRespIsNull = null;
    public static final /* synthetic */ EventType[] a = null;
    private final String description;
    private final String key;

    static {
        EventType r1 = new EventType("EnterAnimTimeout", 0, "event_enter_anim_timeout", "进场动画等待超时");
        EnterAnimTimeout = r1;
        EventType r2 = new EventType("ClickOutside", 1, "event_click_out_side", "用户点击外部蒙层");
        ClickOutside = r2;
        EventType r3 = new EventType("ClickBackCode", 2, "event_click_back_code", "点击返回键");
        ClickBackCode = r3;
        EventType r4 = new EventType("CallDismiss", 3, "event_call_dismiss", "调用了dismiss方法");
        CallDismiss = r4;
        EventType r5 = new EventType("RoomUserInRespIsNull", 4, "event_room_user_is_null", "响应中的room_user为null");
        RoomUserInRespIsNull = r5;
        EventType r6 = new EventType("ProfileUserInRespIsNull", 5, "event_profile_user_is_null", "响应中的profile_user为null");
        ProfileUserInRespIsNull = r6;
        a = new EventType[]{r1, r2, r3, r4, r5, r6};
    }

    public static EventType valueOf(String r1) {
        return (EventType) a.a(EventType.class, r1);
    }

    public static EventType[] values() {
        return (EventType[]) a.clone();
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getKey() {
        return this.key;
    }

    public EventType(String r1, int r2, String r3, String r4) {
        super(r1, r2);
        this.key = r3;
        this.description = r4;
    }
}

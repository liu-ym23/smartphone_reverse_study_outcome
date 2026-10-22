package com.larus.voicecall.impl.component.vlm;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/voicecall/impl/component/vlm/ExitVideoModalReason;", NameKeys.UnloadStrategy_No_Strategy, "str", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getStr", "()Ljava/lang/String;", "OPEN_SHARE_SCREEN", "EXIT_FOR_RTC_ERROR", "REJECT_CAMERA_PERMISSION", "ON_REACH_VIDEO_CALL_DURATION_LIMIT", "REJECT_CAMERA_PERMISSION_ON_CLICK", "EXIT_FOR_DISCONNECT", "EXIT_FOR_ENTER_SCENE", "O_EXIT_VIDEO_MODAL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ExitVideoModalReason extends Enum<ExitVideoModalReason> {
    public static final ExitVideoModalReason EXIT_FOR_DISCONNECT = null;
    public static final ExitVideoModalReason EXIT_FOR_ENTER_SCENE = null;
    public static final ExitVideoModalReason EXIT_FOR_RTC_ERROR = null;
    public static final ExitVideoModalReason ON_REACH_VIDEO_CALL_DURATION_LIMIT = null;
    public static final ExitVideoModalReason OPEN_SHARE_SCREEN = null;
    public static final ExitVideoModalReason O_EXIT_VIDEO_MODAL = null;
    public static final ExitVideoModalReason REJECT_CAMERA_PERMISSION = null;
    public static final ExitVideoModalReason REJECT_CAMERA_PERMISSION_ON_CLICK = null;
    public static final /* synthetic */ ExitVideoModalReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String str;

    public static EnumEntries<ExitVideoModalReason> getEntries() {
        return b;
    }

    static {
        ExitVideoModalReason r0 = new ExitVideoModalReason("OPEN_SHARE_SCREEN", 0, "open_screen_share");
        OPEN_SHARE_SCREEN = r0;
        ExitVideoModalReason r1 = new ExitVideoModalReason("EXIT_FOR_RTC_ERROR", 1, "on_error_from_rtc");
        EXIT_FOR_RTC_ERROR = r1;
        ExitVideoModalReason r2 = new ExitVideoModalReason("REJECT_CAMERA_PERMISSION", 2, "reject_camera_permission");
        REJECT_CAMERA_PERMISSION = r2;
        ExitVideoModalReason r4 = new ExitVideoModalReason("ON_REACH_VIDEO_CALL_DURATION_LIMIT", 3, "on_reach_video_call_duration_limit");
        ON_REACH_VIDEO_CALL_DURATION_LIMIT = r4;
        ExitVideoModalReason r6 = new ExitVideoModalReason("REJECT_CAMERA_PERMISSION_ON_CLICK", 4, "reject_camera_permission_on_click");
        REJECT_CAMERA_PERMISSION_ON_CLICK = r6;
        ExitVideoModalReason r8 = new ExitVideoModalReason("EXIT_FOR_DISCONNECT", 5, "exit_for_disconnect");
        EXIT_FOR_DISCONNECT = r8;
        ExitVideoModalReason r10 = new ExitVideoModalReason("EXIT_FOR_ENTER_SCENE", 6, "exit_for_enter_scene");
        EXIT_FOR_ENTER_SCENE = r10;
        ExitVideoModalReason r12 = new ExitVideoModalReason("O_EXIT_VIDEO_MODAL", 7, "o_exit_video_modal");
        O_EXIT_VIDEO_MODAL = r12;
        ExitVideoModalReason[] r14 = {r0, r1, r2, r4, r6, r8, r10, r12};
        a = r14;
        b = EnumEntriesKt.enumEntries(r14);
    }

    public static ExitVideoModalReason[] values() {
        return (ExitVideoModalReason[]) a.clone();
    }

    public final String getStr() {
        return this.str;
    }

    public static ExitVideoModalReason valueOf(String r1) {
        return (ExitVideoModalReason) r27.a.a(ExitVideoModalReason.class, r1);
    }

    public ExitVideoModalReason(String r1, int r2, String r3) {
        super(r1, r2);
        this.str = r3;
    }
}

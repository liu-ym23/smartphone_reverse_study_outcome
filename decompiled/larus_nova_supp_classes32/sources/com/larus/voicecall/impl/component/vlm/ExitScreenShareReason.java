package com.larus.voicecall.impl.component.vlm;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/larus/voicecall/impl/component/vlm/ExitScreenShareReason;", NameKeys.UnloadStrategy_No_Strategy, "str", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getStr", "()Ljava/lang/String;", "USER_CLICK", "EXIT_FOR_RTC_ERROR", "SYSTEM_INTERRUPTED", "SERVER_LIMIT", "FRAGMENT_DESTROY", "SESSION_DISCONNECT", "ENGINE_FAILED", "ENTER_VIDEO_CALL", "EXIT_FOR_ENTER_SCENE", "O_EXIT_SCREEN_SHARE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ExitScreenShareReason extends Enum<ExitScreenShareReason> {
    public static final ExitScreenShareReason ENGINE_FAILED = null;
    public static final ExitScreenShareReason ENTER_VIDEO_CALL = null;
    public static final ExitScreenShareReason EXIT_FOR_ENTER_SCENE = null;
    public static final ExitScreenShareReason EXIT_FOR_RTC_ERROR = null;
    public static final ExitScreenShareReason FRAGMENT_DESTROY = null;
    public static final ExitScreenShareReason O_EXIT_SCREEN_SHARE = null;
    public static final ExitScreenShareReason SERVER_LIMIT = null;
    public static final ExitScreenShareReason SESSION_DISCONNECT = null;
    public static final ExitScreenShareReason SYSTEM_INTERRUPTED = null;
    public static final ExitScreenShareReason USER_CLICK = null;
    public static final /* synthetic */ ExitScreenShareReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String str;

    public static EnumEntries<ExitScreenShareReason> getEntries() {
        return b;
    }

    static {
        ExitScreenShareReason r0 = new ExitScreenShareReason("USER_CLICK", 0, "click_end_share_screen");
        USER_CLICK = r0;
        ExitScreenShareReason r1 = new ExitScreenShareReason("EXIT_FOR_RTC_ERROR", 1, "on_error_from_rtc");
        EXIT_FOR_RTC_ERROR = r1;
        ExitScreenShareReason r2 = new ExitScreenShareReason("SYSTEM_INTERRUPTED", 2, "system_interrupted");
        SYSTEM_INTERRUPTED = r2;
        ExitScreenShareReason r4 = new ExitScreenShareReason("SERVER_LIMIT", 3, "server_limit");
        SERVER_LIMIT = r4;
        ExitScreenShareReason r6 = new ExitScreenShareReason("FRAGMENT_DESTROY", 4, "fragment_destroy");
        FRAGMENT_DESTROY = r6;
        ExitScreenShareReason r8 = new ExitScreenShareReason("SESSION_DISCONNECT", 5, "session_disconnect");
        SESSION_DISCONNECT = r8;
        ExitScreenShareReason r10 = new ExitScreenShareReason("ENGINE_FAILED", 6, "engine_failed");
        ENGINE_FAILED = r10;
        ExitScreenShareReason r12 = new ExitScreenShareReason("ENTER_VIDEO_CALL", 7, "enter_video_call");
        ENTER_VIDEO_CALL = r12;
        ExitScreenShareReason r14 = new ExitScreenShareReason("EXIT_FOR_ENTER_SCENE", 8, "exit_for_enter_scene");
        EXIT_FOR_ENTER_SCENE = r14;
        ExitScreenShareReason r13 = new ExitScreenShareReason("O_EXIT_SCREEN_SHARE", 9, "o_exit_screen_share");
        O_EXIT_SCREEN_SHARE = r13;
        ExitScreenShareReason[] r11 = {r0, r1, r2, r4, r6, r8, r10, r12, r14, r13};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static ExitScreenShareReason[] values() {
        return (ExitScreenShareReason[]) a.clone();
    }

    public final String getStr() {
        return this.str;
    }

    public static ExitScreenShareReason valueOf(String r1) {
        return (ExitScreenShareReason) r27.a.a(ExitScreenShareReason.class, r1);
    }

    public ExitScreenShareReason(String r1, int r2, String r3) {
        super(r1, r2);
        this.str = r3;
    }
}

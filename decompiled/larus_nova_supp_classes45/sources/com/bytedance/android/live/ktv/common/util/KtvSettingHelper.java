package com.bytedance.android.live.ktv.common.util;

import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.livesdk.config.LiveKtvRealtimeChorusDynamicSettingConfig;
import com.bytedance.android.livesdk.config.RealTimeChorusDownloadOptConfig;
import com.bytedance.android.livesdk.config.d21;
import com.bytedance.android.livesdk.config.j81;
import com.bytedance.android.livesdk.config.pf1;
import com.bytedance.android.livesdk.config.t41;
import com.bytedance.android.livesdk.config.u41;
import com.bytedance.android.livesdk.config.y41;
import com.bytedance.android.livesdk.config.z41;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class KtvSettingHelper {
    public static final Lazy A = null;
    public static final Lazy A0 = null;
    public static final Lazy B = null;
    public static final Lazy B0 = null;
    public static final Lazy C = null;
    public static final Lazy C0 = null;
    public static final Lazy D = null;
    public static final Lazy D0 = null;
    public static final Lazy E = null;
    public static final Lazy E0 = null;
    public static final Lazy F = null;
    public static final Lazy F0 = null;
    public static final Lazy G = null;
    public static final Lazy G0 = null;
    public static final Lazy H = null;
    public static final Lazy H0 = null;
    public static final Lazy I = null;
    public static final Lazy I0 = null;
    public static final Lazy J = null;
    public static final Lazy J0 = null;
    public static final Lazy K = null;
    public static final Lazy K0 = null;
    public static final Lazy L = null;
    public static final Lazy L0 = null;
    public static final Lazy M = null;
    public static final Lazy M0 = null;
    public static final Lazy N = null;
    public static final Lazy N0 = null;
    public static final Lazy O = null;
    public static final Lazy O0 = null;
    public static final Lazy P = null;
    public static final Lazy P0 = null;
    public static final Lazy Q = null;
    public static final Lazy Q0 = null;
    public static final Lazy R = null;
    public static final Lazy R0 = null;
    public static final Lazy S = null;
    public static final Lazy S0 = null;
    public static final Lazy T = null;
    public static final Lazy T0 = null;
    public static final Lazy U = null;
    public static final Lazy U0 = null;
    public static final Lazy V = null;
    public static final Lazy V0 = null;
    public static final Lazy W = null;
    public static final Lazy W0 = null;
    public static final Lazy X = null;
    public static final Lazy X0 = null;
    public static final Lazy Y = null;
    public static final Lazy Y0 = null;
    public static final Lazy Z = null;
    public static final Lazy Z0 = null;
    public static final Lazy a = null;
    public static final Lazy a0 = null;
    public static final Lazy a1 = null;
    public static final Lazy b = null;
    public static final Lazy b0 = null;
    public static final Lazy b1 = null;
    public static final Lazy c = null;
    public static final Lazy c0 = null;
    public static final Lazy c1 = null;
    public static final Lazy d = null;
    public static final Lazy d0 = null;
    public static final Lazy d1 = null;
    public static final Lazy e = null;
    public static final Lazy e0 = null;
    public static final Lazy e1 = null;
    public static final Lazy f = null;
    public static final Lazy f0 = null;
    public static final Lazy f1 = null;
    public static final Lazy g = null;
    public static final Lazy g0 = null;
    public static final Lazy g1 = null;
    public static final Lazy h = null;
    public static final Lazy h0 = null;
    public static final Lazy h1 = null;
    public static final Lazy i = null;
    public static final Lazy i0 = null;
    public static final Lazy i1 = null;
    public static final Lazy j = null;
    public static final Lazy j0 = null;
    public static final Lazy j1 = null;
    public static final Lazy k = null;
    public static final Lazy k0 = null;
    public static final Lazy k1 = null;
    public static final Lazy l = null;
    public static final Lazy l0 = null;
    public static final Lazy l1 = null;
    public static final Lazy m = null;
    public static final Lazy m0 = null;
    public static final Lazy m1 = null;
    public static final Lazy n = null;
    public static final Lazy n0 = null;
    public static final Lazy n1 = null;
    public static final Lazy o = null;
    public static final Lazy o0 = null;
    public static final Lazy o1 = null;
    public static final Lazy p = null;
    public static final Lazy p0 = null;
    public static final Lazy p1 = null;
    public static final Lazy q = null;
    public static final Lazy q0 = null;
    public static final Lazy q1 = null;
    public static final Lazy r = null;
    public static final Lazy r0 = null;
    public static final Lazy r1 = null;
    public static final Lazy s = null;
    public static final Lazy s0 = null;
    public static final Lazy s1 = null;
    public static final Lazy t = null;
    public static final Lazy t0 = null;
    public static final Lazy t1 = null;
    public static final Lazy u = null;
    public static final Lazy u0 = null;
    public static final Lazy u1 = null;
    public static final Lazy v = null;
    public static final Lazy v0 = null;
    public static final Lazy v1 = null;
    public static final Lazy w = null;
    public static final Lazy w0 = null;
    public static final Lazy w1 = null;
    public static final Lazy x = null;
    public static final Lazy x0 = null;
    public static final Lazy x1 = null;
    public static final Lazy y = null;
    public static final Lazy y0 = null;
    public static final Lazy z = null;
    public static final Lazy z0 = null;

    public static j81 A() {
        return (j81) O0.getValue();
    }

    public static String B() {
        return (String) M.getValue();
    }

    public static Boolean b() {
        return (Boolean) g.getValue();
    }

    public static z41 c() {
        return (z41) N.getValue();
    }

    public static t41 d() {
        return (t41) O.getValue();
    }

    public static d21 e() {
        return (d21) C.getValue();
    }

    public static boolean f() {
        return ((Boolean) s0.getValue()).booleanValue();
    }

    public static u41 g() {
        return (u41) t.getValue();
    }

    public static boolean h() {
        return ((Boolean) u.getValue()).booleanValue();
    }

    public static boolean i() {
        return ((Boolean) n1.getValue()).booleanValue();
    }

    public static long j() {
        return ((Number) P.getValue()).longValue();
    }

    public static int k() {
        return ((Number) M0.getValue()).intValue();
    }

    public static int l() {
        return ((Number) K0.getValue()).intValue();
    }

    public static boolean m() {
        return ((Boolean) g1.getValue()).booleanValue();
    }

    public static Boolean n() {
        return (Boolean) b.getValue();
    }

    public static boolean o() {
        return ((Boolean) a0.getValue()).booleanValue();
    }

    public static LiveKtvRealtimeChorusDynamicSettingConfig p() {
        return (LiveKtvRealtimeChorusDynamicSettingConfig) P0.getValue();
    }

    public static y41 q() {
        return (y41) B.getValue();
    }

    public static Boolean r() {
        return (Boolean) y0.getValue();
    }

    public static long s() {
        return ((Number) A0.getValue()).longValue();
    }

    public static boolean t() {
        return ((Boolean) i0.getValue()).booleanValue();
    }

    public static boolean u() {
        return ((Boolean) j0.getValue()).booleanValue();
    }

    public static RealTimeChorusDownloadOptConfig v() {
        return (RealTimeChorusDownloadOptConfig) V0.getValue();
    }

    public static boolean w() {
        return ((Boolean) Z0.getValue()).booleanValue();
    }

    public static pf1 x() {
        return (pf1) n0.getValue();
    }

    public static boolean y() {
        return ((Boolean) h1.getValue()).booleanValue();
    }

    public static boolean z() {
        return ((Boolean) D0.getValue()).booleanValue();
    }

    static {
        a = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_ENTER_ROOM_WIDGET_CLEAR_FIX$2.INSTANCE);
        b = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_ORDER_SONG_PANEL_ENABLE$2.INSTANCE);
        c = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_CHORUS_ENTRY_ENABLE$2.INSTANCE);
        d = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_MIXER_ENABLE_FIX_FALLBACK$2.INSTANCE);
        e = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_ENTER_INFO_CLEAR_FIX$2.INSTANCE);
        f = LazyKt.lazy(KtvSettingHelper$KTV_CHORUS_ERROR_STOP_MUSIC_FIX$2.INSTANCE);
        g = LazyKt.lazy(KtvSettingHelper$KTV_CHORUS_LEAD_AVATAR_FIX$2.INSTANCE);
        h = LazyKt.lazy(KtvSettingHelper$KTV_DOWNLOAD_RESET_FIX$2.INSTANCE);
        i = LazyKt.lazy(KtvSettingHelper$KTV_CHORUS_SWITCH_SCENE_STAGE_FIX$2.INSTANCE);
        j = LazyKt.lazy(KtvSettingHelper$LIVE_LOAD_KTV_COMPONENT_ENTRANCE_ENABLE$2.INSTANCE);
        k = LazyKt.lazy(KtvSettingHelper$LIVE_REAL_TIME_CHORUS_ANIM_DELAY_MILLIS$2.INSTANCE);
        l = LazyKt.lazy(KtvSettingHelper$LIVE_RT_CHORUS_SUPPORT_LISTENER_CHANGE_SINGER_FROM_SING_STATE$2.INSTANCE);
        m = LazyKt.lazy(KtvSettingHelper$LIVE_RT_CHORUS_STAGE_UPGRADE_OPT$2.INSTANCE);
        n = LazyKt.lazy(KtvSettingHelper$LIVE_RT_CHORUS_SUPPORT_PRIORITY_DOWNLOAD_MUSIC$2.INSTANCE);
        o = LazyKt.lazy(KtvSettingHelper$LIVE_VIDEO_CHORUS_SUPPORT_PRIORITY_DOWNLOAD_MUSIC$2.INSTANCE);
        p = LazyKt.lazy(KtvSettingHelper$LIVE_RT_CHORUS_SYNC_ONLINE_LIST_CHANGE_ENABLE$2.INSTANCE);
        q = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_CHORUS_MIDI_SCORE_SYNC_TIME$2.INSTANCE);
        r = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_ROOM_SINGER_LYRICS_FREQUENT$2.INSTANCE);
        s = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_LYRICS_OPTIMIZE_OPTION$2.INSTANCE);
        t = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_CONFIG$2.INSTANCE);
        u = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_DELETE_FAKE_REQUEST_ENABLE$2.INSTANCE);
        v = LazyKt.lazy(KtvSettingHelper$LIVE_RT_CHORUS_FEEDBACK_VIEW_FIX$2.INSTANCE);
        w = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_ORDERED_SONG_CONTEXT_CRASH_SWITCH$2.INSTANCE);
        x = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_FORCE_CLOSE_KTV_COMPONENT_ENABLE$2.INSTANCE);
        y = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_FIX_KTV_MV_PRE_LOAD_ENABLE$2.INSTANCE);
        z = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_SORT_BUBBLE_VIEW_SHOW_OPT$2.INSTANCE);
        A = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_UPDATE_BGM_EAR_VOLUME_ENABLE$2.INSTANCE);
        B = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_REAL_TIME_CHORUS_BUSINESS_CONFIG$2.INSTANCE);
        C = LazyKt.lazy(KtvSettingHelper$LIVE_CHORUS_CONCERT_BUSSINESS_CONFIG$2.INSTANCE);
        D = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_REAL_TIME_CHORUS_ANCHOR_RESUME_UNMUTE$2.INSTANCE);
        E = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_REAL_TIME_CHORUS_NET_DETECT_CONFIG$2.INSTANCE);
        F = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_REAL_TIME_CHORUS_NET_CELLULAR_CONFIG$2.INSTANCE);
        G = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_REAL_TIME_CHORUS_AUDIO_SQUEAL_CONFIG$2.INSTANCE);
        H = LazyKt.lazy(KtvSettingHelper$LIVE_REAL_TIME_CHORUS_LEAD_VOICE_VOLUME_FIXED$2.INSTANCE);
        I = LazyKt.lazy(KtvSettingHelper$LIVE_REAL_TIME_CHORUS_LEAD_VOICE_VOLUME_SET$2.INSTANCE);
        J = LazyKt.lazy(KtvSettingHelper$LIVE_REAL_TIME_CHORUS_LEAD_DOWNLOAD_COUNT$2.INSTANCE);
        K = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_OPEN_CAMERA_COUNT_DOWN_TIME$2.INSTANCE);
        L = LazyKt.lazy(KtvSettingHelper$LIVE_REAL_TIME_CHORUS_VICE_PLAY_SONG_COMPATIBLE$2.INSTANCE);
        M = LazyKt.lazy(KtvSettingHelper$REA_TIME_CHORUS_CONFIG$2.INSTANCE);
        N = LazyKt.lazy(KtvSettingHelper$KTV_CHORUS_VOLUME_CONFIG$2.INSTANCE);
        O = LazyKt.lazy(KtvSettingHelper$KTV_CONCERT_VOLUME_CONFIG$2.INSTANCE);
        P = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_LYRIC_SHAKE_RANGE$2.INSTANCE);
        Q = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_MUSIC_TIME_SHAKE_RANGE$2.INSTANCE);
        R = LazyKt.lazy(KtvSettingHelper$KTV_CHORUS_ROLE_SWITCH_CHANGE$2.INSTANCE);
        S = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_CUT_SONG_CLEAR_SING_STATE_FIX$2.INSTANCE);
        T = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_PREPARE_DOWNLOAD_SONG_TIPS_SWITCH$2.INSTANCE);
        U = LazyKt.lazy(KtvSettingHelper$KTV_CHORUS_ROLE_SILENCE_LEAVE_FIX_CLOSE$2.INSTANCE);
        V = LazyKt.lazy(KtvSettingHelper$KTV_CHORUS_LINK_GUEST_PUSH_FIX$2.INSTANCE);
        W = LazyKt.lazy(KtvSettingHelper$KTV_CHORUS_OPEN_SINGLE_VIEW_MODE_DEFAULT$2.INSTANCE);
        X = LazyKt.lazy(KtvSettingHelper$KTV_CHORUS_ASSIGN_LEAD_AUTO_JOIN_FIX$2.INSTANCE);
        Y = LazyKt.lazy(KtvSettingHelper$KTV_CHORUS_BGM_PUSH_VOLUME_ADJUST$2.INSTANCE);
        Z = LazyKt.lazy(KtvSettingHelper$KTV_SEI_SINGING_STATE_JUDGE$2.INSTANCE);
        a0 = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_PERFORMANCE_OPT$2.INSTANCE);
        b0 = LazyKt.lazy(KtvSettingHelper$KTV_SINGING_HOT_RANK_ENABLED$2.INSTANCE);
        c0 = LazyKt.lazy(KtvSettingHelper$LIVE_PARTY_KTV_UPDATE_PUSH_OPTIMIZE_DICT$2.INSTANCE);
        d0 = LazyKt.lazy(KtvSettingHelper$KTV_CHORUS_HOME_PAGE_TEXT$2.INSTANCE);
        e0 = LazyKt.lazy(KtvSettingHelper$KTV_LYRICS_GL_OPT_PRELOAD_COUNT$2.INSTANCE);
        f0 = LazyKt.lazy(KtvSettingHelper$LIVE_VOICE_KTV_GL_RENDER_FPS$2.INSTANCE);
        g0 = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_LYRIC_GL_OPT_PRELOAD_INDEX$2.INSTANCE);
        h0 = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_RT_CHORUS_LIVE_ICON_URL$2.INSTANCE);
        i0 = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_RT_CHORUS_DISTRIBUTE_OPT$2.INSTANCE);
        j0 = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_RT_CHORUS_LAUNCH_PAGE_OPT$2.INSTANCE);
        k0 = LazyKt.lazy(KtvSettingHelper$LIVE_ENABLE_TASK_ID_LOCAL_BACKUP$2.INSTANCE);
        l0 = LazyKt.lazy(KtvSettingHelper$LIVE_CHORUS_PLAYER_ADVANCE_INIT$2.INSTANCE);
        m0 = LazyKt.lazy(KtvSettingHelper$LIVE_ENABLE_LYRIC_LOCAL_BACKUP$2.INSTANCE);
        n0 = LazyKt.lazy(KtvSettingHelper$LIVE_REAL_TIME_CHORUS_NET_SCORE_MOCK$2.INSTANCE);
        o0 = LazyKt.lazy(KtvSettingHelper$KTV_SING_RANK_CONFIG$2.INSTANCE);
        p0 = LazyKt.lazy(KtvSettingHelper$KTV_MULTI_CHORUS_SOUND_WAVE_OPT$2.INSTANCE);
        q0 = LazyKt.lazy(KtvSettingHelper$KTV_ANCHOR_SEI_DATA_CREATE_USE_NEW_PANEL$2.INSTANCE);
        r0 = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_MIDI_SCORE_DEBUG_ENABLE$2.INSTANCE);
        s0 = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_AUDIENCE_MIDI_LOAD_OPT$2.INSTANCE);
        t0 = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_VIVO_MIDI_COLOR_OPT$2.INSTANCE);
        u0 = LazyKt.lazy(KtvSettingHelper$LIVE_REAL_TIME_CHORUS_AUDIO_PULSE_ENABLE$2.INSTANCE);
        v0 = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_TUNING_EFFECT_SUPPORT_INCREASE_UPDATE$2.INSTANCE);
        w0 = LazyKt.lazy(KtvSettingHelper$KTV_ORDER_SONG_LIST_USE_INCREASE_UPDATE$2.INSTANCE);
        x0 = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_ROOM_MIDI_CAL_FACTOR$2.INSTANCE);
        y0 = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_ROOM_MEMORY_LEAK_FIX$2.INSTANCE);
        z0 = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_MIDI_CAL_FACTOR$2.INSTANCE);
        A0 = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_ROOM_MIDI_SCORE_GET_TIME$2.INSTANCE);
        B0 = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_DRAW_FREQUENCY$2.INSTANCE);
        C0 = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_SCORE_RANGE$2.INSTANCE);
        D0 = LazyKt.lazy(KtvSettingHelper$LIVE_VOICE_KTV_PERFORMANCE_OPT_V1$2.INSTANCE);
        E0 = LazyKt.lazy(KtvSettingHelper$LIVE_VOICE_KTV_FEED_VH_PAUSE_FIX$2.INSTANCE);
        F0 = LazyKt.lazy(KtvSettingHelper$LIVE_NORMAL_LYRIC_OPT_SETTING$2.INSTANCE);
        G0 = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_MIDI_SEI_RECEIVER_INTERVAL$2.INSTANCE);
        H0 = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_MUSIC_PROGRESS_UPDATE_INTERVAL$2.INSTANCE);
        I0 = LazyKt.lazy(KtvSettingHelper$LIVE_VOICE_KTV_CPU_OPT_USE_GL$2.INSTANCE);
        J0 = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_MIDI_HIT_PERFECT$2.INSTANCE);
        K0 = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_MIDI_HIT_COMBO_TARGET$2.INSTANCE);
        L0 = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_MIDI_HIT_EASY$2.INSTANCE);
        M0 = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_MIDI_ANIMATOR_DEGRADE$2.INSTANCE);
        N0 = LazyKt.lazy(KtvSettingHelper$LIVE_VOICE_KTV_MIDI_USE_SURFACE_VIEW$2.INSTANCE);
        O0 = LazyKt.lazy(KtvSettingHelper$LYRIC_RECOGNIZATION_CONFIG$2.INSTANCE);
        P0 = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_REALTIME_CHORUS_DYNAMIC_SETTING_CONFIG$2.INSTANCE);
        Q0 = LazyKt.lazy(KtvSettingHelper$LIVE_VOICE_KTV_LYRIC_USE_SURFACE_VIEW$2.INSTANCE);
        R0 = LazyKt.lazy(KtvSettingHelper$LIVE_SOLO_KTV_DANGEROUS_COPYRIGHT_SONG_PLAY_DURATION$2.INSTANCE);
        S0 = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_SING_FPS$2.INSTANCE);
        T0 = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_PLAYER_PROGRESS_FREQUENCY_OPT$2.INSTANCE);
        U0 = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_LYRIC_FILE_NOT_EXISTED_OPT$2.INSTANCE);
        V0 = LazyKt.lazy(KtvSettingHelper$LIVE_REAL_TIME_CHORUS_DOWNLOAD_OPT$2.INSTANCE);
        W0 = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_MOCK_OTHER_RESOURCE_DELAY_DOWNLOAD$2.INSTANCE);
        X0 = LazyKt.lazy(KtvSettingHelper$LIVE_VIDEO_CHORUS_CONFLICT_MULTI_CHORUS_ENABLE$2.INSTANCE);
        Y0 = LazyKt.lazy(KtvSettingHelper$LIVE_VIDEO_CHORUS_SING_STATE_VALID_CHECK$2.INSTANCE);
        Z0 = LazyKt.lazy(KtvSettingHelper$LIVE_REAL_TIME_CHORUS_ENTER_ROOM_OPT$2.INSTANCE);
        a1 = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_ANCHOR_PING_SEI_OPT$2.INSTANCE);
        b1 = LazyKt.lazy(KtvSettingHelper$LIVE_RESET_HAS_BGM_FLAG$2.INSTANCE);
        c1 = LazyKt.lazy(KtvSettingHelper$LIVE_REAL_TIME_CHORUS_PUSH_STREAM_FIX$2.INSTANCE);
        d1 = LazyKt.lazy(KtvSettingHelper$LIVE_RT_CHORUS_MIDI_ERROR_FIX$2.INSTANCE);
        e1 = LazyKt.lazy(KtvSettingHelper$LIVE_RT_CHORUS_STOP_AUDIO_CAPTURE_FIX$2.INSTANCE);
        f1 = LazyKt.lazy(KtvSettingHelper$LIVE_MULTI_LINK_VOICE_SWITCH_SCENE_PAUSE_STREAM_FIX$2.INSTANCE);
        g1 = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_ORDERED_DATA_CONTEXT_INIT_OPT$2.INSTANCE);
        h1 = LazyKt.lazy(KtvSettingHelper$LIVE_RT_CHORUS_NPT_VALID_CHECK$2.INSTANCE);
        i1 = LazyKt.lazy(KtvSettingHelper$LIVE_RT_CHORUS_CANCEL_PROCESS_RANGE_CHECK$2.INSTANCE);
        j1 = LazyKt.lazy(KtvSettingHelper$LIVE_RT_CHORUS_RTS_MIDI_SCORE_FIX$2.INSTANCE);
        k1 = LazyKt.lazy(KtvSettingHelper$LIVE_RT_CHORUS_UPDATE_SING_STATUS_FIX$2.INSTANCE);
        l1 = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_RENDER_CONTAINER_MEMORY_LEAK$2.INSTANCE);
        m1 = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_ADMIN_ROLE_CHANGE_REFRESH_WAITING_LIST$2.INSTANCE);
        n1 = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_INIT_WIDGET_MANAGER_OPT$2.INSTANCE);
        o1 = LazyKt.lazy(KtvSettingHelper$LIVE_KTV_RT_CHOURS_FEEDBACK_PANEL_FIX$2.INSTANCE);
        p1 = LazyKt.lazy(KtvSettingHelper$LIVE_RT_CHORUS_PAID_RED_DOT_SHOW_TS$2.INSTANCE);
        q1 = LazyKt.lazy(KtvSettingHelper$LIVE_RT_CHORUS_LIFECYCLE_ERROR_FIX$2.INSTANCE);
        r1 = LazyKt.lazy(KtvSettingHelper$LIVE_CHORUS_PAUSE_AND_PLAY_FIX$2.INSTANCE);
        s1 = LazyKt.lazy(KtvSettingHelper$LIVE_UPDATE_SINGER_ON_SONGE_CHANGE$2.INSTANCE);
        t1 = LazyKt.lazy(KtvSettingHelper$LIVE_ANCHOR_CONTINUE_LIVE_RESUME_STATE$2.INSTANCE);
        u1 = LazyKt.lazy(KtvSettingHelper$LIVE_CHORUS_ANCHOR_RESUME_JOIN_CHORUS$2.INSTANCE);
        v1 = LazyKt.lazy(KtvSettingHelper$LIVE_MULTI_CHORUS_ROLE_UPDATE$2.INSTANCE);
        w1 = LazyKt.lazy(KtvSettingHelper$REAL_TIME_CHORUS_SEND_SEI$2.INSTANCE);
        x1 = LazyKt.lazy(KtvSettingHelper$LIVE_KSONG_SECOND_LEVEL_TAB_VIEW_AUTO_SCROLL$2.INSTANCE);
    }

    public static boolean C() {
        Room r2 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        if (r2 == null) goto L5;
        String r3 = r2.getAnchorAbValue("real_time_chorus_gift");
    L7:
        if (Intrinsics.areEqual(r3, GamePromoteDataContext.GAME_TYPE_MINI) == true) goto L9;
    L13:
        return false;
    L9:
        if (a.g() == false) goto L11;
    L12:
        return true;
    L11:
        if (j.i() == false) goto L13;
    L5:
        r3 = null;
        goto L7
    }

    public static boolean a() {
        com.bytedance.android.livesdk.chatroom.o r2 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r2 == null) goto L11;
        com.bytedance.live.datacontext.m r3 = r2.getRoom();
        if (r3 == null) goto L11;
        IRoom r4 = (IRoom) r3.getValue();
        if (r4 == null) goto L11;
        Map r5 = r4.getAnchorABMap();
        if (r5 == null) goto L11;
        String r6 = (String) r5.get("ktv_profit_dress_bg");
    L13:
        return Intrinsics.areEqual(r6, GamePromoteDataContext.GAME_TYPE_MOBILE);
    L11:
        r6 = null;
        goto L13
    }
}

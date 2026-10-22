package com.bytedance.android.live.core.monitor;

import android.content.SharedPreferences;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.core.monitor.trace.TraceMonitor;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.livesdk.config.gh;
import com.bytedance.android.livesdk.config.ih;
import com.bytedance.android.livesdk.config.jh;
import com.bytedance.android.livesdk.config.kh;
import com.bytedance.android.livesdk.config.p00;
import com.bytedance.android.livesdk.config.pb;
import com.bytedance.android.livesdk.config.v90;
import com.bytedance.android.livesdk.performance.o;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICrashCallback;
import com.bytedance.crash.IOOMCallback;
import com.bytedance.crash.Npth;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import y50.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class NewBroadcastMonitor {
    public static final Boolean a = null;
    public static String b;
    public static String c;
    public static String d;
    public static final Map<String, String> e = null;
    public static final Map<String, String> f = null;
    public static e g;
    public static f h;
    public static final ConcurrentHashMap<String, Long> i = null;
    public static final Map<String, String> j = null;

    @Target({})
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0006B\b\u0012\u0006\u0010\u0003\u001a\u00020\u0002R\u0011\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/core/monitor/NewBroadcastMonitor$BUSINESSTYPE;", "", "", "type", "()Ljava/lang/String;", "Companion", "a", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.PROPERTY})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    public @interface BUSINESSTYPE {
        public static final String CORE = "start_broadcast";
        public static final a Companion = null;
        public static final String EFFECT = "broadcast_effect";
        public static final String PREVIEW = "broadcast_preview";
        public static final String STICKER = "broadcast_sticker";
        public static final String TOOLBAL = "broadcast_toolbar";

        public static final class a {
            public static final /* synthetic */ a a = null;

            public a() {
            }

            static {
                a = new a();
            }
        }

        static {
            Companion = a.a;
        }

        String type();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/core/monitor/NewBroadcastMonitor$CAPTURE;", "", "Companion", "a", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface CAPTURE {
        public static final String BACK = "back";
        public static final a Companion = null;
        public static final String FRONT = "front";

        public static final class a {
            public static final /* synthetic */ a a = null;

            public a() {
            }

            static {
                a = new a();
            }
        }

        static {
            Companion = a.a;
        }
    }

    @Target({})
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0006B\b\u0012\u0006\u0010\u0003\u001a\u00020\u0002R\u0011\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/core/monitor/NewBroadcastMonitor$GROUP;", "", "", "group", "()Ljava/lang/String;", "Companion", "a", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.PROPERTY})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    public @interface GROUP {
        public static final String ANCHOR_BIZ_PANEL = "service_anchor_biz_panel_merge_event";
        public static final a Companion = null;
        public static final String EFFECT = "ttlive_anchor_prefix_effect_merge";
        public static final String NETWORK = "ttlive_anchor_prefix_network_merge";
        public static final String SO = "ttlive_anchor_prefix_live_core_so_load_status_merge";
        public static final String TOOLBAR = "ttlive_anchor_prefix_toolbar_merge";

        public static final class a {
            public static final /* synthetic */ a a = null;

            public a() {
            }

            static {
                a = new a();
            }
        }

        static {
            Companion = a.a;
        }

        String group();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/core/monitor/NewBroadcastMonitor$PAGE;", "", "Companion", "a", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface PAGE {
        public static final a Companion = null;
        public static final String PREVIEW = "preview";
        public static final String ROOM = "room";
        public static final String SUBBROADCAST = "subBroadcast";

        public static final class a {
            public static final /* synthetic */ a a = null;

            public a() {
            }

            static {
                a = new a();
            }
        }

        static {
            Companion = a.a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/core/monitor/NewBroadcastMonitor$SERVICE;", "", "Companion", "a", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface SERVICE {

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.EXTERNALAMERA)
        public static final String ANCHOR_EXTERNAL_AUDIO_FPS = "ttlive_anchor_external_audio_fps";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.EXTERNALAMERA)
        public static final String ANCHOR_EXTERNAL_VIDEO_FPS = "ttlive_anchor_external_video_fps";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.MULTICAMERA)
        public static final String ANCHOR_MULTICAMERA_SUBBROADCAST_ONCREATE = "ttlive_anchor_multicamera_subbroadcast_oncreate";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.MULTICAMERA)
        public static final String ANCHOR_MULTICAMERA_SUBBROADCAST_RTC_CLOSE = "ttlive_anchor_multicamera_subbroadcast_rtc_close";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.MULTICAMERA)
        public static final String ANCHOR_MULTICAMERA_SUBBROADCAST_RTC_JOIN = "ttlive_anchor_multicamera_subbroadcast_rtc_join";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CAMERA)
        public static final String ANCHOR_SET_EXPOSURE = "ttlive_anchor_set_exposure";
        public static final a Companion = null;

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.NEWLINK)
        public static final String NEW_LINK_ANCHOR_JSB_JUMP = "ttlive_new_link_anchor_jsb_jump";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.NEWLINK)
        public static final String NEW_LINK_ANCHOR_JSB_JUMP_SUCCESS = "ttlive_new_link_anchor_jsb_jump_success";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.NEWLINK)
        public static final String NEW_LINK_ANCHOR_PING_PAUSE = "ttlive_new_link_anchor_ping_pause";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.NEWLINK)
        public static final String NEW_LINK_AUDIENCE_JSB_JUMP = "ttlive_new_link_audience_jsb_jump";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.NEWLINK)
        public static final String NEW_LINK_AUDIENCE_PING_START = "ttlive_new_link_audience_ping_start";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = STAGE.EFFECT)
        public static final String SERVICE_ANCHOR_ADJUST_STICKER_TAG_VALUE = "ttlive_anchor_adjust_sticker_tag_value";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.ANNOUNCEMENT)
        public static final String SERVICE_ANCHOR_ANNOUNCEMENT_HIGHLIGHT_AUDIENCE_CLOSE = "ttlive_anchor_prefix_announcement_audience_close";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.ANNOUNCEMENT)
        public static final String SERVICE_ANCHOR_ANNOUNCEMENT_HIGHLIGHT_AUTO_PUBLISH_STATUS = "ttlive_anchor_prefix_announcement_auto_publish";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.ANNOUNCEMENT)
        public static final String SERVICE_ANCHOR_ANNOUNCEMENT_HIGHLIGHT_HIDE = "ttlive_anchor_prefix_announcement_hide";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.ANNOUNCEMENT)
        public static final String SERVICE_ANCHOR_ANNOUNCEMENT_HIGHLIGHT_PUBLISH_STATUS = "ttlive_anchor_prefix_announcement_publish";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.ANNOUNCEMENT)
        public static final String SERVICE_ANCHOR_ANNOUNCEMENT_HIGHLIGHT_SHOW = "ttlive_anchor_prefix_announcement_show";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.ANNOUNCEMENT)
        public static final String SERVICE_ANCHOR_ANNOUNCEMENT_HIGHLIGHT_UN_PUBLISH_STATUS = "ttlive_anchor_prefix_announcement_unpublish";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = STAGE.EFFECT)
        public static final String SERVICE_ANCHOR_AV_ADJUST_EFFECT_STATUS = "ttlive_anchor_av_adjust_effect_status";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = STAGE.EFFECT)
        public static final String SERVICE_ANCHOR_BEAUTY_EFFECT_STATUS = "ttlive_anchor_beauty_effect_status";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "service_anchor_biz_panel_merge_event")
        @STAGE(stage = STAGE.START)
        public static final String SERVICE_ANCHOR_BIZ_PANEL_DATA_EVENT = "service_anchor_biz_panel_data_event";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.START)
        public static final String SERVICE_ANCHOR_BIZ_PANEL_MERGE_EVENT = "service_anchor_biz_panel_merge_event";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.START)
        public static final String SERVICE_ANCHOR_BIZ_PANEL_OPERATE_EVENT = "service_anchor_biz_panel_operate_event";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "service_anchor_biz_panel_merge_event")
        @STAGE(stage = STAGE.START)
        public static final String SERVICE_ANCHOR_BIZ_PANEL_UI_EVENT = "service_anchor_biz_panel_ui_event";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_ANCHOR_BLOCK_BACKPRESS_WITH_ROOM_CREATING = "ttlive_anchor_block_backpress_with_room_creating";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_ANCHOR_BLOCK_INFO = "ttlive_anchor_block_info";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = STAGE.EFFECT)
        public static final String SERVICE_ANCHOR_BODY_BEAUTY_EFFECT_STATUS = "ttlive_anchor_body_beauty_effect_status";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.STOP)
        public static final String SERVICE_ANCHOR_CANCEL_EDUCATION = "ttlive_anchor_prefix_cancel_education";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.STREAM)
        public static final String SERVICE_ANCHOR_CHANGE_BITRATE_DEGRADE_RATIO = "ttlive_anchor_prefix_change_bitrate_degrade_ratio";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.STREAM)
        public static final String SERVICE_ANCHOR_CHANGE_VIDEO_BITRATE = "ttlive_anchor_prefix_change_video_bitrate";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.STREAM)
        public static final String SERVICE_ANCHOR_CHANGE_VIDEO_FPS = "ttlive_anchor_prefix_change_video_fps";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.STREAM)
        public static final String SERVICE_ANCHOR_CLARITY_CHANGE = "ttlive_anchor_clarity_change";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CORE)
        public static final String SERVICE_ANCHOR_CRASH_LOG = "ttlive_anchor_crash_info";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "sticker")
        public static final String SERVICE_ANCHOR_CURRENT_EXISTED_DECORATIONS = "ttlive_anchor_current_existed_decorations";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "sticker")
        public static final String SERVICE_ANCHOR_DELETE_STICKER = "ttlive_anchor_delete_sticker";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CORE)
        public static final String SERVICE_ANCHOR_EXIT_LOG = "ttlive_anchor_exit_info";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = STAGE.EFFECT)
        public static final String SERVICE_ANCHOR_FETCH_STICKER_FAIL = "ttlive_anchor_prefix_fetch_sticker_fail";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = STAGE.EFFECT)
        public static final String SERVICE_ANCHOR_GET_CAMPAIGN_STICKER = "ttlive_anchor_prefix_get_campaign_sticker";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = STAGE.EFFECT)
        public static final String SERVICE_ANCHOR_GET_FAVORITE_STICKER = "ttlive_anchor_prefix_get_favorite_sticker";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = STAGE.EFFECT)
        public static final String SERVICE_ANCHOR_GET_RECOMMEND_STICKER = "ttlive_anchor_prefix_get_recommend_sticker";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = STAGE.EFFECT)
        public static final String SERVICE_ANCHOR_GIFT_EVENT_CHANNEL_STATUS_CHANGE = "ttlive_anchor_prefix_gift_event_channel_status_change";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = STAGE.EFFECT)
        public static final String SERVICE_ANCHOR_GIFT_MENU_STICKER_RENDER = "ttlive_anchor_prefix_gift_menu_sticker_render";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_toolbar_merge")
        @STAGE(stage = STAGE.TOOLBAR)
        public static final String SERVICE_ANCHOR_GUIDE_TOOLBAR_ADD_ITEM = "ttlive_anchor_guide_toolbar_add_item";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.TOOLBAR)
        public static final String SERVICE_ANCHOR_GUIDE_TOOLBAR_CLICK = "ttlive_anchor_guide_toolbar_click";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.TOOLBAR)
        public static final String SERVICE_ANCHOR_GUIDE_TOOLBAR_CONFIG = "ttlive_anchor_guide_toolbar_config";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_toolbar_merge")
        @STAGE(stage = STAGE.TOOLBAR)
        public static final String SERVICE_ANCHOR_GUIDE_TOOLBAR_EXCLUDE_ITEM = "ttlive_anchor_prefix_guide_toolbar_exclude_item";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_toolbar_merge")
        @STAGE(stage = STAGE.TOOLBAR)
        public static final String SERVICE_ANCHOR_GUIDE_TOOLBAR_FORCE_DELETE = "ttlive_anchor_prefix_guide_toolbar_force_delete";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_toolbar_merge")
        @STAGE(stage = STAGE.TOOLBAR)
        public static final String SERVICE_ANCHOR_GUIDE_TOOLBAR_REMOVE_ITEM = "ttlive_anchor_guide_toolbar_remove_item";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_toolbar_merge")
        @STAGE(stage = STAGE.TOOLBAR)
        public static final String SERVICE_ANCHOR_GUIDE_TOOLBAR_SHOW = "ttlive_anchor_prefix_guide_toolbar_show";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = STAGE.EFFECT)
        public static final String SERVICE_ANCHOR_MUTEX_EFFECT = "ttlive_anchor_mutex_effect";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = STAGE.EFFECT)
        public static final String SERVICE_ANCHOR_MV_BIND_STICKER_APPLY = "ttlive_anchor_prefix_mv_bind_sticker_apply";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = STAGE.EFFECT)
        public static final String SERVICE_ANCHOR_MV_BIND_STICKER_REMOVE = "ttlive_anchor_prefix_mv_bind_sticker_remove";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = STAGE.EFFECT)
        public static final String SERVICE_ANCHOR_NO_BEAUTIFY_STATUS = "ttlive_anchor_no_beautify_effect_status";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CORE)
        public static final String SERVICE_ANCHOR_OOM_LOG = "ttlive_anchor_oom_info";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = STAGE.EFFECT)
        public static final String SERVICE_ANCHOR_OPEN_STICKER_DIALOG_JSB = "ttlive_anchor_prefix_open_sticker_dialog_by_jsb";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = STAGE.EFFECT)
        public static final String SERVICE_ANCHOR_OPEN_STICKER_DIALOG_SCHEMA = "ttlive_anchor_prefix_open_sticker_dialog_by_schema";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = STAGE.EFFECT)
        public static final String SERVICE_ANCHOR_PERMEATE_STICKER = "ttlive_anchor_prefix_permeate_sticker";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = STAGE.EFFECT)
        public static final String SERVICE_ANCHOR_PREVIEW_BEAUTY_FAST_RESTORE = "ttlive_anchor_prefix_preview_beauty_fast_restore";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_ANCHOR_REAL_START_IN_ROOM = "ttlive_anchor_real_start_in_room";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CORE)
        public static final String SERVICE_ANCHOR_REBUILD = "ttlive_anchor_prefix_rebuild";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CORE)
        public static final String SERVICE_ANCHOR_REBUILD_RESULT = "ttlive_anchor_prefix_rebuild_result";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = STAGE.EFFECT)
        public static final String SERVICE_ANCHOR_RENDER_EFFECT = "ttlive_anchor_render_effect";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = STAGE.EFFECT)
        public static final String SERVICE_ANCHOR_RENDER_NO_CAMERA_EFFECT = "service_anchor_render_no_camera_effect";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.STREAM)
        public static final String SERVICE_ANCHOR_ROOM_STATE_REQUEST = "ttlive_anchor_room_state_request";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = STAGE.EFFECT)
        public static final String SERVICE_ANCHOR_SELECT_EFFECT = "ttlive_anchor_select_effect";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "sticker")
        public static final String SERVICE_ANCHOR_SELECT_STICKER = "ttlive_anchor_select_sticker";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = STAGE.EFFECT)
        public static final String SERVICE_ANCHOR_SEND_EFFECT_MSG = "ttlive_anchor_prefix_send_effect_msg";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_ANCHOR_SHOW_BROADCAST_STREAM_FRAGMENT = "ttlive_anchor_show_broadcast_stream_fragment";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_ANCHOR_SHOW_SUB_BROADCAST_STREAM_FRAGMENT = "ttlive_anchor_show_sub_broadcast_stream_fragment";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = STAGE.EFFECT)
        public static final String SERVICE_ANCHOR_START_LIVE_RESTORE_EFFECT = "ttlive_anchor_prefix_start_live_restore_effect";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "sticker")
        public static final String SERVICE_ANCHOR_STICKER_EVENT = "ttlive_anchor_sticker_event";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "sticker")
        public static final String SERVICE_ANCHOR_STICKER_PANEL_EVENT = "ttlive_anchor_sticker_panel_event";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = STAGE.EFFECT)
        public static final String SERVICE_ANCHOR_STICKER_PREVIEW_DOWNGRADE = "ttlive_anchor_sticker_preview_downgrade";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = STAGE.EFFECT)
        public static final String SERVICE_ANCHOR_STICKER_PREVIEW_START = "ttlive_anchor_sticker_preview_start";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "sticker")
        public static final String SERVICE_ANCHOR_STICKER_SET = "ttlive_anchor_sticker_set";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = STAGE.EFFECT)
        public static final String SERVICE_ANCHOR_STICKER_TRY_OUT_PARAMS = "ttlive_anchor_prefix_sticker_try_out_params";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = STAGE.EFFECT)
        public static final String SERVICE_ANCHOR_UNSELECT_EFFECT = "ttlive_anchor_unselect_effect";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CORE)
        public static final String SERVICE_AUDIO_CAPTURE_CHANGE = "ttlive_audio_capture_change";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "sticker")
        public static final String SERVICE_AUDIT_STICKER_TEXT_CONTENT = "ttlive_audit_text_content";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "sticker")
        public static final String SERVICE_AUDIT_STICKER_TEXT_CONTENT_HUMAN = "ttlive_audit_sticker_text_content_human";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "sticker")
        public static final String SERVICE_AUDIT_STICKER_TEXT_CONTENT_MACHINE = "ttlive_audit_sticker_text_content_machine";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CORE)
        public static final String SERVICE_CAMERA_CLICK_EXPOSURE = "ttlive_camera_click_exposure";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CORE)
        public static final String SERVICE_CAMERA_CLOSE = "ttlive_camera_close";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CORE)
        public static final String SERVICE_CAMERA_ERROR = "ttlive_camera_error";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CORE)
        public static final String SERVICE_CAMERA_OPEN = "ttlive_camera_open";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CORE)
        public static final String SERVICE_CAMERA_START_ZOOM = "ttlive_camera_start_zoom";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.STREAM)
        public static final String SERVICE_CAMERA_WATCHDOG_LOG = "ttlive_anchor_camera_watchdog_log";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CAST)
        public static final String SERVICE_CAST_MINIMIZE = "ttlive_anchor_prefix_cast_minimize";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CAST)
        public static final String SERVICE_CAST_RESUME = "ttlive_anchor_prefix_cast_resume";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CAST)
        public static final String SERVICE_CAST_START = "ttlive_anchor_prefix_cast_start";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CAST)
        public static final String SERVICE_CAST_START_ERROR = "ttlive_anchor_prefix_cast_start_error";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CAST)
        public static final String SERVICE_CAST_START_SUCCESS = "ttlive_anchor_prefix_cast_start_success";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CAST)
        public static final String SERVICE_CAST_STOP = "ttlive_anchor_prefix_cast_stop";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.STREAM)
        public static final String SERVICE_CDN_FETCH_SPEED_TEST_INFO = "ttlive_anchor_prefix_fetch_speed_test_info";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.STREAM)
        public static final String SERVICE_CDN_SPEED_TEST_RESULT = "ttlive_anchor_prefix_cdn_speed_test_result";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = STAGE.CORE)
        public static final String SERVICE_CHANGE_EFFECT_FAVORITE = "ttlive_change_effect_favorite";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_CHANGE_LIVE_MODE = "ttlive_anchor_profix_change_live_mode";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CORE)
        public static final String SERVICE_CLICK_OPEN_LIVE_FAILED = "ttlive_click_open_live_failed";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_CLICK_REPLACE_COVER = "ttlive_click_replace_cover";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CORE)
        public static final String SERVICE_CLOSE_ROOM_EXP = "ttlive_anchor_close_room_exception";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CORE)
        public static final String SERVICE_CLOSE_ROOM_FAILED = "ttlive_anchor_real_close_room_fail";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CORE)
        public static final String SERVICE_CLOSE_ROOM_REASON = "ttlive_anchor_close_room_reason";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.START)
        public static final String SERVICE_CONTINUE_DIALOG_CONFIRM = "ttlive_anchor_prefix_continue_dialog_confirm";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CORE)
        public static final String SERVICE_CONTINUE_DIALOG_SHOW = "ttlive_anchor_prefix_restart_live";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CORE)
        public static final String SERVICE_CREATE_ROOM_DURATION = "ttlive_live_success_total_time";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.STREAM)
        public static final String SERVICE_DELAY_SEND_START_EVENT = "ttlive_delay_send_start_event";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_ENTER_BACKGROUND = "ttlive_anchor_enter_background";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_ENTER_FOREGROUND = "ttlive_anchor_enter_foreground";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_FETCH_BARRAGE_SETTING = "ttlive_fetch_barrage_setting";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CORE)
        public static final String SERVICE_FETCH_CREATE_ROOM = "ttlive_fetch_create_room";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "sticker")
        public static final String SERVICE_FETCH_DECORATION_LIST = "ttlive_fetch_decoration_list";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = STAGE.CORE)
        public static final String SERVICE_FETCH_EFFECT_LIST = "ttlive_fetch_effect_list_new";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = STAGE.EFFECT)
        public static final String SERVICE_FETCH_EFFECT_LIST_BY_CATEGORY = "ttlive_anchor_fetch_effect_list_by_category";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = STAGE.EFFECT)
        public static final String SERVICE_FETCH_EFFECT_PANEL = "ttlive_anchor_fetch_effect_panel_info";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_FETCH_PREVIEW_CREATE_INFO = "ttlive_fetch_preview_room_create_info";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_FETCH_PREVIEW_PRE_CREATE_INFO = "ttlive_fetch_preview_pre_room_create_info";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_FETCH_PREVIEW_USER_PERMISSION = "ttlive_fetch_preview_user_permission";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CORE)
        public static final String SERVICE_FETCH_ROOM_CONTINUE = "ttlive_fetch_room_continue";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_FETCH_ROOM_MEMBER_COUNT_LIMIT_LIST = "ttlive_anchor_fetch_room_member_count_limit_list";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_FETCH_VISIBLE_LIST = "ttlive_anchor_prefix_fetch_visible_list";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_FRAGMENT_DESTROY = "ttlive_anchor_prefix_view_destroy";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_FRAGMENT_PAUSE = "ttlive_anchor_view_disappear";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_FRAGMENT_RESUME = "ttlive_anchor_view_appear";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CORE)
        public static final String SERVICE_GET_APP_EXIT_INFO_ERROR = "ttlive_anchor_prefix_exit_info_error";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_GET_COVER_IMAGE = "ttlive_get_cover_image";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CORE)
        public static final String SERVICE_GET_REAL_EXIT_INFO_ERROR = "ttlive_anchor_prefix_real_exit_info_error";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_GUIDE_LIVE_SUBTYPE = "ttlive_anchor_prefix_guide_live_subType";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_GUILD_LOCATION = "ttlive_guide_location";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_INTERACTION_CREATE = "ttlive_interaction_create";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_INTERACTION_PAUSE = "ttlive_interaction_fragment_pause";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_INTERACTION_RESUME = "ttlive_interaction_fragment_resume";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.STREAM)
        public static final String SERVICE_LIVE_AV_RESOURCE_REQUEST = "ttlive_live_av_resource_request";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_LIVE_BROADCAST_ACTIVITY_CREATE = "ttlive_anchor_view_did_load";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_network_merge")
        @STAGE(stage = STAGE.NETWORK)
        public static final String SERVICE_LIVE_STREAM_NETWORK_STATUS = "ttlive_on_live_stream_network_status_changed";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_LIVE_SUB_BROADCAST_ACTIVITY_CREATE = "ttlive_sub_anchor_view_did_load";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.EFFECT)
        public static final String SERVICE_MERGE_EFFECT = "ttlive_anchor_prefix_effect_merge";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.NETWORK)
        public static final String SERVICE_MERGE_NETWORK = "ttlive_anchor_prefix_network_merge";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.START)
        public static final String SERVICE_MERGE_SO = "ttlive_anchor_prefix_live_core_so_load_status_merge";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.TOOLBAR)
        public static final String SERVICE_MERGE_TOOLBAR = "ttlive_anchor_prefix_toolbar_merge";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.STREAM)
        public static final String SERVICE_ON_HANDLE_UPDATE_ROOM_STATUS = "ttlive_on_handle_update_room_status";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_live_core_so_load_status_merge")
        @STAGE(stage = STAGE.START)
        public static final String SERVICE_ON_LIVE_CORE_SO_LOAD_STATUS = "ttlive_live_core_so_load_status";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_ON_LIVE_MODE_CHANGE = "ttlive_on_live_mode_change";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.NETWORK)
        public static final String SERVICE_ON_LIVE_STREAM_NETWORK_LOW = "ttlive_on_live_stream_network_low";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.STOP)
        public static final String SERVICE_ON_NORMAL_CLOSE_ROOM_DIALOG_CONFIRM = "ttlive_close_live_manual";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CORE)
        public static final String SERVICE_ON_START_LIVE_BTN_CLICK = "ttlive_click_open_live";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CORE)
        public static final String SERVICE_ON_START_LIVE_MODE_NOT_MATCH = "ttlive_anchor_prefix_live_mode_not_match";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CORE)
        public static final String SERVICE_ON_START_LIVE_STREAM = "ttlive_start_live_stream";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.STREAM)
        public static final String SERVICE_ON_STOP_LIVE_STREAM = "ttlive_stop_live_stream";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_PAGE_DESTROY = "ttlive_anchor_prefix_page_destroy";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_PAGE_DISMISS = "ttlive_anchor_prefix_page_dismiss";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_PAGE_SHOW = "ttlive_anchor_prefix_page_show";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.STREAM)
        public static final String SERVICE_PAUSE_LIVE_STREAM = "ttlive_pause_live";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.STREAM)
        public static final String SERVICE_PAUSE_LIVE_STREAM_MANAGER = "ttlive_pause_live_stream_manager";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_PERMISSION_CHECK = "ttlive_anchor_prefix_permission_check";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CORE)
        public static final String SERVICE_PING_ANCHOR_FAILED = "ttlive_anchor_close_room_fail";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.STREAM)
        public static final String SERVICE_PREVIEW_CHANGE_SIZE_AND_LOCATION = "ttlive_anchor_prefix_preview_change_size_and_location";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.STREAM)
        public static final String SERVICE_PREVIEW_SET_DISPLAY = "ttlive_anchor_prefix_preview_set_display";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.STREAM)
        public static final String SERVICE_PREVIEW_UPDATE_PIPELINE = "ttlive_anchor_prefix_preview_update_pipeline";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CORE)
        public static final String SERVICE_PUSH_STREAM_FIRST_STREAM = "ttlive_push_first_frame";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.START)
        public static final String SERVICE_REALTIME_PANEL_DATA_MSG = "ttlive_anchor_prefix_status_center_handle_panel_data";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.START)
        public static final String SERVICE_REALTIME_SUGGEST_MSG = "ttlive_anchor_prefix_status_center_handle_suggest";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_RECEIVE_BLOCK_MSG = "ttlive_receive_block_msg";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_REPLACE_COVER_METHOD = "ttlive_replace_cover_method";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CORE)
        public static final String SERVICE_RESTART_MULTIPROCESS_START = "ttlive_restart_multiprocess_start";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CORE)
        public static final String SERVICE_RESTART_MULTIPROCESS_SUCCESS = "ttlive_restart_multiprocess_success";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.STREAM)
        public static final String SERVICE_RESUME_LIVE_STREAM = "ttlive_resume_live";

        @BUSINESSTYPE(type = STAGE.START)
        @STAGE(stage = STAGE.START)
        public static final String SERVICE_REVIEW_EDUCATION_MSG = "ttlive_anchor_prefix_education_msg";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_ROOM_MEMBER_COUNT_LIMIT_UPDATE = "ttlive_anchor_room_member_count_limit_update";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.STREAM)
        public static final String SERVICE_SEND_START_EVENT = "ttlive_send_start_event";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.STREAM)
        public static final String SERVICE_START_AUDIO_CAPTURE = "ttlive_start_audio_capture";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_START_LIVE_FRAGMENT_CREATE = "ttlive_anchor_guide_view_load";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_START_LIVE_FRAGMENT_PAUSE = "ttlive_anchor_guide_view_disappear";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_START_LIVE_FRAGMENT_RESUME = "ttlive_anchor_guide_view_appear";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CORE)
        public static final String SERVICE_START_PUSH_STREAM_DURATION = "ttlive_push_first_success_time";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.START)
        public static final String SERVICE_START_TRACE = "ttlive_start_trace";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.STREAM)
        public static final String SERVICE_START_VIDEO_CAPTURE = "ttlive_start_video_capture";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.START)
        public static final String SERVICE_STATUS_PANEL_BIZ_MSG = "ttlive_anchor_prefix_status_center_publish_biz_message";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.START)
        public static final String SERVICE_STATUS_PANEL_ENTRANCE_CLICK = "ttlive_anchor_prefix_status_center_entrance_click";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.START)
        public static final String SERVICE_STATUS_PANEL_REQUEST_DATA = "ttlive_anchor_prefix_status_center_request";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.START)
        public static final String SERVICE_STATUS_PANEL_SELECT = "ttlive_anchor_prefix_status_center_tab_select";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.STREAM)
        public static final String SERVICE_STOP_AUDIO_CAPTURE = "ttlive_stop_audio_capture";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.STREAM)
        public static final String SERVICE_STOP_VIDEO_CAPTURE = "ttlive_stop_video_capture";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CORE)
        public static final String SERVICE_STREAM_ON_ERROR_CODE = "ttlive_push_stream_error";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.STREAM)
        public static final String SERVICE_STREAM_ON_INFO_CODE = "ttlive_stream_info_code";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.STREAM)
        public static final String SERVICE_STREAM_STATE_AFTER_INTERACTION_SHOW = "ttlive_anchor_prefix_state_after_interaction_show";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.STREAM)
        public static final String SERVICE_STREAM_STATE_CHANGE = "ttlive_push_stream_state_change";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_SUB_ENTER_BACKGROUND = "ttlive_sub_anchor_enter_background";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_SUB_ENTER_FOREGROUND = "ttlive_sub_anchor_enter_foreground";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_SUB_FRAGMENT_DESTROY = "ttlive_anchor_sub_prefix_view_destroy";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_SUB_FRAGMENT_PAUSE = "ttlive_sub_anchor_view_disappear";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_SUB_FRAGMENT_RESUME = "ttlive_sub_anchor_view_appear";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.STREAM)
        public static final String SERVICE_SWITCH_VIDEO_CAPTURE = "ttlive_switch_video_capture";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_UPDATE_CREATE_INFO = "ttlive_anchor_prefix_update_create_info";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_UPLOAD_COVER_RESULT = "ttlive_upload_cover_result";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CORE)
        public static final String SERVICE_VIDEO_CAPTURE_CHANGE = "ttlive_video_capture_change";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.STREAM)
        public static final String SERVICE_VIDEO_FLOAT_WINDOW_CHANGE = "ttlive_video_float_window_change";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.STREAM)
        public static final String SERVICE_VIDEO_FLOAT_WINDOW_ERROR = "ttlive_video_float_window_error";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.STREAM)
        public static final String SERVICE_VIDEO_FLOAT_WINDOW_HIDE = "ttlive_video_float_window_hide";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_VIDEO_PROBE = "ttlive_anchor_prefix_video_probe";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_VISIBLE_MODIFY_SELECT_RANGE = "ttlive_anchor_prefix_visible_modify_select_range";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.NEWLINK)
        public static final String TTLIVE_ANCHOR_DIRECT_CONTINUE_ROOM = "ttlive_anchor_direct_continue_room";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.NEWLINK)
        public static final String TTLIVE_ANCHOR_DIRECT_SHOW_END_PAGE = "ttlive_anchor_direct_show_end_page";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String TTLIVE_ANCHOR_LANDING_SWITCH = "ttlive_anchor_landing_switch";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String TTLIVE_ANCHOR_PREFIX_FETCH_RELATIONSHIP_LIST = "ttlive_anchor_prefix_fetch_relationship_list";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = STAGE.EFFECT)
        public static final String TTLIVE_ANCHOR_PREFIX_GET_LINK_OBJ_STICKERS = "ttlive_anchor_prefix_get_link_obj_stickers";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = STAGE.EFFECT)
        public static final String TTLIVE_ANCHOR_PREFIX_UPDATE_LINK_OBJ_STICKERS = "ttlive_anchor_prefix_update_link_obj_stickers";

        public static final class a {
            public static final /* synthetic */ a a = null;

            public a() {
            }

            static {
                a = new a();
            }
        }

        static {
            Companion = a.a;
        }
    }

    @Target({})
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0006B\b\u0012\u0006\u0010\u0003\u001a\u00020\u0002R\u0011\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/core/monitor/NewBroadcastMonitor$STAGE;", "", "", "stage", "()Ljava/lang/String;", "Companion", "a", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.PROPERTY})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    public @interface STAGE {
        public static final String ANNOUNCEMENT = "announcement";
        public static final String CAMERA = "camera";
        public static final String CAST = "cast";
        public static final String CORE = "core";
        public static final a Companion = null;
        public static final String EFFECT = "effect";
        public static final String EXTERNALAMERA = "externalcamera";
        public static final String LIFECYCLE = "lifecycle";
        public static final String MULTICAMERA = "multicamera";
        public static final String NETWORK = "network";
        public static final String NEWLINK = "newlink";
        public static final String PREVIEW = "preview";
        public static final String START = "start";
        public static final String STICKER = "sticker";
        public static final String STOP = "stop";
        public static final String STREAM = "stream";
        public static final String TOOLBAR = "toolbar";

        public static final class a {
            public static final /* synthetic */ a a = null;

            public a() {
            }

            static {
                a = new a();
            }
        }

        static {
            Companion = a.a;
        }

        String stage();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/core/monitor/NewBroadcastMonitor$STATUS;", "", "Companion", "a", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface STATUS {
        public static final a Companion = null;
        public static final int FAIL = 1;
        public static final int SUCCESS = 0;

        public static final class a {
            public static final /* synthetic */ a a = null;

            public a() {
            }

            static {
                a = new a();
            }
        }

        static {
            Companion = a.a;
        }
    }

    public static final class a extends LiveMonitor.a {
        @Override // com.bytedance.android.live.core.monitor.LiveMonitor.a
        public final LiveMonitor a() {
            return new b(super.a());
        }

        public final void n(Throwable r6) {
            if (r6 != null) goto L5;
            return;
        L5:
            if ((r6 instanceof CustomApiServerException) == false) goto L8;
            CustomApiServerException r0 = (CustomApiServerException) r6;
            i("log_id", r0.getXTtLogId());
            l(r0.getErrorCode());
            i("err_msg", r0.getErrorMsg());
            i("err_msg_detail", r6.getMessage());
            return;
        L8:
            if ((r6 instanceof ApiServerException) == false) goto L11;
            ApiServerException r1 = (ApiServerException) r6;
            l(r1.getErrorCode());
            i("err_msg", r1.getErrorMsg());
            i("err_msg_detail", r6.getMessage());
            return;
        L11:
            if ((r6 instanceof ApiException) == false) goto L18;
            ApiException r2 = (ApiException) r6;
            if (r2.getErrorCode() == 0) goto L15;
            int r3 = r2.getErrorCode();
        L16:
            l(r3);
            i("err_msg", "api exception");
            i("err_msg_detail", r6.getMessage());
            return;
        L15:
            r3 = -998;
            goto L16
        L18:
            if ((r6 instanceof NetworkErrorException) == false) goto L25;
            int r4 = ((NetworkErrorException) r6).statusCode;
            if (r4 != 0) goto L23;
            r4 = -997;
        L23:
            l(r4);
            i("err_msg", "network error");
            i("err_msg_detail", r6.getMessage());
            return;
        L25:
            if ((r6 instanceof NetworkNotAvailabeException) == false) goto L27;
            l(((NetworkNotAvailabeException) r6).getCronetInternalErrorCode());
            i("err_msg", "network not available");
            i("err_msg_detail", r6.getMessage());
            return;
        L27:
            l(-999);
            i("err_msg", r6.getClass().getSimpleName());
            i("err_msg_detail", r6.getMessage());
        }

        public a(String r2, LiveTracingMonitor.EventModule r3) {
            Intrinsics.checkNotNullParameter(r2, "serviceName");
            Intrinsics.checkNotNullParameter(r3, "eventModule");
            super(r2, r3);
        }
    }

    public static final class b extends LiveMonitor {
        public final LiveMonitor a;

        @Override // com.bytedance.android.live.core.monitor.LiveMonitor
        public final void report() {
            Boolean r0 = NewBroadcastMonitor.a;
            if (NewBroadcastMonitor.a(this.a.mServiceName) == false) goto L6;
            this.a.report();
        L6:
            if (((Boolean) jh.a.getValue()).booleanValue() == false) goto L104;
            LiveMonitor r1 = this.a;
            String r2 = r1.mServiceName;
            if (r2 == null) goto L113;
            String r3 = (String) ((LinkedHashMap) NewBroadcastMonitor.f).get(r2);
            if (r3 != null) goto L13;
            r3 = BUSINESSTYPE.CORE;
        L13:
            String r4 = (String) ((LinkedHashMap) NewBroadcastMonitor.e).get(r2);
            if (r4 != null) goto L16;
            r4 = "";
        L16:
            int r5 = com.bytedance.android.live.core.monitor.trace.e.m;
            com.bytedance.android.live.core.monitor.trace.e.a r6 = com.bytedance.android.live.core.monitor.trace.e.b.a(r2, r3);
            r6.f = "";
            r6.g = "";
            JSONObject r7 = null;
            r6.e = null;
            r6.a = NewBroadcastMonitor.c;
            r6.b("stage", r4);
            r6.c = "webcast_client_broadcast";
            JSONObject r8 = r1.mExtraLog;
            r6.b = r8.optString("log_id");
            String r9 = r8.optString("err_msg");
            boolean r11 = false;
            if (r9.length() <= 0) goto L19;
            boolean r12 = true;
        L20:
            if (r12 == true) goto L23;
            r9 = null;
        L23:
            if (r9 == null) goto L25;
            r6.i = r9;
        L26:
            r8.put("trace_event_type", r2);
            String r13 = r8.optString("room_id");
            if (r13.length() <= 0) goto L29;
            boolean r14 = true;
        L30:
            if (r14 == true) goto L33;
            r13 = null;
        L33:
            if (r13 == null) goto L35;
            r6.e = r13;
        L35:
            JSONObject r15 = r1.mCategory;
            if (r15 == null) goto L39;
            r6.h = Integer.valueOf(r15.optInt("status_code", 0));
        L39:
            if (((Boolean) pb.a.getValue()).booleanValue() == true) goto L41;
            com.bytedance.android.live.core.monitor.trace.e r16 = r6.a();
            JSONObject r17 = r1.mCategory;
            JSONObject r18 = r1.mMetrics;
            JSONObject r19 = r1.mExtraLog;
            a60.e r21 = com.bytedance.android.live.core.monitor.trace.c.a;
            Intrinsics.checkNotNullParameter(r16, "traceMeta");
            TraceMonitor.i(r16, r17, r18, r19);
            return;
        L41:
            if (((Boolean) gh.a.getValue()).booleanValue() == false) goto L71;
            List<String> r22 = c.a;
            com.bytedance.android.live.core.monitor.trace.e r23 = r6.a();
            JSONObject r24 = r1.mCategory;
            JSONObject r110 = r1.mMetrics;
            JSONObject r25 = r1.mExtraLog;
            Intrinsics.checkNotNullParameter(r23, "traceMeta");
            if ((!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) == false) goto L45;
            a60.e r26 = com.bytedance.android.live.core.monitor.trace.c.a;
            Intrinsics.checkNotNullParameter(r23, "traceMeta");
            TraceMonitor.i(r23, r24, r110, r25);
            return;
        L45:
            String r27 = (String) ((LinkedHashMap) NewBroadcastMonitor.j).get(r23.a);
            if ((!Intrinsics.areEqual(c.d, r27)) == false) goto L49;
            c.b();
        L49:
            if (NewBroadcastMonitor.a(r23.a) == false) goto L52;
            if (r25 == null) goto L53;
            r7 = new JSONObject(r25.toString());
        L53:
            if (r27 != null) goto L55;
        L70:
            c.a(r23, r24, r110, r7);
            return;
        L55:
            if (r27.length() <= 0) goto L57;
            r11 = true;
        L57:
            if (r11 != true) goto L70;
            if (r25 == null) goto L60;
            c.h = r25;
        L60:
            c.d = r27;
            if (r7 == null) goto L67;
            Iterator<T> r28 = c.a.iterator();
        L64:
            if (r28.hasNext() == false) goto L66;
            r7.remove((String) r28.next());
            goto L64
        L66:
            r7.remove("trace_event_type");
        L67:
            c.g = r23;
            String r29 = c.i + '_' + r23.a;
            Map<String, d> r31 = c.f;
            d r32 = new d();
            r32.a = r24;
            r32.b = r110;
            r32.c = r7;
            Intrinsics.checkNotNullParameter(r29, "<set-?>");
            Unit r33 = Unit.INSTANCE;
            r31.put(r29, r32);
            int r34 = c.i + 1;
            c.i = r34;
            if (r34 < 10) goto L106;
            c.b();
            return;
        L106:
            return;
        L52:
            r7 = r25;
            goto L53
        L71:
            List<String> r35 = c.a;
            com.bytedance.android.live.core.monitor.trace.e r36 = r6.a();
            JSONObject r37 = r1.mCategory;
            JSONObject r111 = r1.mMetrics;
            JSONObject r38 = r1.mExtraLog;
            Intrinsics.checkNotNullParameter(r36, "traceMeta");
            if ((!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) == false) goto L74;
            a60.e r39 = com.bytedance.android.live.core.monitor.trace.c.a;
            Intrinsics.checkNotNullParameter(r36, "traceMeta");
            TraceMonitor.i(r36, r37, r111, r38);
            return;
        L74:
            String r41 = (String) ((LinkedHashMap) NewBroadcastMonitor.j).get(r36.a);
            if ((!Intrinsics.areEqual(c.d, r41)) == false) goto L77;
            c.b();
        L77:
            if (r38 == null) goto L79;
            r7 = new JSONObject(r38.toString());
        L79:
            if (r41 != null) goto L81;
        L99:
            c.a(r36, r37, r111, r7);
            return;
        L81:
            if (r41.length() <= 0) goto L83;
            r11 = true;
        L83:
            if (r11 != true) goto L99;
            if (r38 == null) goto L86;
            c.h = r38;
        L86:
            c.d = r41;
            if (r7 == null) goto L93;
            Iterator<T> r42 = c.a.iterator();
        L90:
            if (r42.hasNext() == false) goto L92;
            r7.remove((String) r42.next());
            goto L90
        L92:
            r7.remove("trace_event_type");
        L93:
            c.g = r36;
            String r43 = c.i + '_' + r36.a;
            Map<String, JSONObject> r44 = c.e;
            JSONObject r45 = new JSONObject();
            r45.put("timestamp", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss_SSS", Locale.CHINA).format(Long.valueOf(System.currentTimeMillis())));
            r45.put("metric", r111);
            r45.put("category", r37);
            if (r7 == null) goto L96;
            r45.put("extra", r7);
        L96:
            r44.put(r43, r45);
            int r46 = c.i + 1;
            c.i = r46;
            if (r46 < 10) goto L110;
            c.b();
            return;
        L110:
            return;
        L29:
            r14 = false;
            goto L30
        L25:
            r6.i = r8.optString("status_msg");
            goto L26
        L19:
            r12 = false;
            goto L20
        L113:
            return;
        }

        public b(LiveMonitor r2) {
            Intrinsics.checkNotNullParameter(r2, "liveMonitor");
            this.a = r2;
        }
    }

    public static final class c {
        public static final List<String> a = null;
        public static PthreadHandlerThreadV2 b;
        public static Handler c;
        public static String d;
        public static Map<String, JSONObject> e;
        public static final Map<String, d> f = null;
        public static com.bytedance.android.live.core.monitor.trace.e g;
        public static JSONObject h;
        public static int i;
        public static final SimpleDateFormat j = null;

        public static final class a implements Runnable {
            public final /* synthetic */ com.bytedance.android.live.core.monitor.trace.e a;
            public final /* synthetic */ JSONObject b;
            public final /* synthetic */ JSONObject c;
            public final /* synthetic */ JSONObject d;

            public a(com.bytedance.android.live.core.monitor.trace.e r1, JSONObject r2, JSONObject r3, JSONObject r4) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.bytedance.android.live.core.monitor.trace.e r0 = this.a;     // Catch: Throwable -> L4
                JSONObject r1 = this.b;     // Catch: Throwable -> L4
                JSONObject r2 = this.c;     // Catch: Throwable -> L4
                JSONObject r3 = this.d;     // Catch: Throwable -> L4
                a60.e r4 = com.bytedance.android.live.core.monitor.trace.c.a;     // Catch: Throwable -> L4
                Intrinsics.checkNotNullParameter(r0, "traceMeta");     // Catch: Throwable -> L4
                TraceMonitor.i(r0, r1, r2, r3);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public static final class b implements Runnable {
            public final /* synthetic */ com.bytedance.android.live.core.monitor.trace.e a;
            public final /* synthetic */ JSONObject b;
            public final /* synthetic */ JSONObject c;
            public final /* synthetic */ JSONObject d;

            public b(com.bytedance.android.live.core.monitor.trace.e r1, JSONObject r2, JSONObject r3, JSONObject r4) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.bytedance.android.live.core.monitor.trace.e r0 = this.a;     // Catch: Throwable -> L4
                JSONObject r1 = this.b;     // Catch: Throwable -> L4
                JSONObject r2 = this.c;     // Catch: Throwable -> L4
                JSONObject r3 = this.d;     // Catch: Throwable -> L4
                a60.e r4 = com.bytedance.android.live.core.monitor.trace.c.a;     // Catch: Throwable -> L4
                Intrinsics.checkNotNullParameter(r0, "traceMeta");     // Catch: Throwable -> L4
                TraceMonitor.i(r0, r1, r2, r3);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.core.monitor.NewBroadcastMonitor$c$c, reason: collision with other inner class name */
        public static final class RunnableC0143c implements Runnable {
            public final /* synthetic */ com.bytedance.android.live.core.monitor.trace.e a;
            public final /* synthetic */ JSONObject b;
            public final /* synthetic */ JSONObject c;

            public RunnableC0143c(com.bytedance.android.live.core.monitor.trace.e r1, JSONObject r2, JSONObject r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // java.lang.Runnable
            public final void run() {
                List<String> r0 = c.a;     // Catch: Throwable -> L4
                c.a(this.a, this.b, null, this.c);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        static {
            a = CollectionsKt.listOf(new String[]{"room_id", "live_mode", "tag", "device_performance", "monitor_by", "device_id", "webcast_sdk_version", "user_id", "os", "anchor_top_flag", "anchor_trace_uuid"});
            d = "";
            e = new LinkedHashMap();
            f = new LinkedHashMap();
            h = new JSONObject();
            j = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss_SSS", Locale.CHINA);
        }

        public static void b() {
            if (i != 0) goto L5;
            return;
        L5:
            com.bytedance.android.live.core.monitor.trace.e r0 = g;
            if (r0 != null) goto L8;
            return;
        L8:
            String r1 = d;
            Intrinsics.checkNotNullParameter(r1, "<set-?>");
            r0.a = r1;
            JSONObject r2 = new JSONObject();
            r2.put("count", i);
            JSONObject r3 = h;
            Object[] r4 = a.toArray(new String[0]);
            if (r4 == null) goto L33;
            JSONObject r5 = new JSONObject(r3, (String[]) r4);
            Boolean r6 = NewBroadcastMonitor.a;
            if (((Boolean) gh.a.getValue()).booleanValue() == false) goto L25;
            Map<String, d> r7 = f;
            if (b != null) goto L15;
            PthreadHandlerThreadV2 r8 = new PthreadHandlerThreadV2("broadcast monitor");
            b = r8;
            ThreadMethodProxy.start(r8);
            c = new Handler(r8.getLooper());
        L15:
            Iterator r9 = ((LinkedHashMap) r7).entrySet().iterator();
        L17:
            if (r9.hasNext() == false) goto L22;
            Map.Entry r11 = (Map.Entry) r9.next();
            String r12 = (String) r11.getKey();
            ((d) r11.getValue()).getClass();
            JSONObject r13 = ((d) r11.getValue()).a;
            JSONObject r14 = ((d) r11.getValue()).b;
            JSONObject r15 = ((d) r11.getValue()).c;
            JSONObject r16 = new JSONObject();
            r16.put("timestamp", j.format(0L));
            r16.put("metric", r14);
            r16.put("category", r13);
            if (r15 == null) goto L21;
            r16.put("extra", r15);
        L21:
            d60.b.a(r5, r12, r16);
            goto L17
        L22:
            Handler r17 = c;
            if (r17 == null) goto L30;
            r17.post(new RunnableC0143c(r0, r2, r5));
        L30:
            g = null;
            i = 0;
            e = new LinkedHashMap();
            return;
        L25:
            Iterator r18 = ((LinkedHashMap) e).entrySet().iterator();
        L27:
            if (r18.hasNext() == false) goto L29;
            Map.Entry r19 = (Map.Entry) r18.next();
            d60.b.a(r5, (String) r19.getKey(), r19.getValue());
            goto L27
        L29:
            a(r0, r2, null, r5);
            goto L30
        L33:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        public static void a(com.bytedance.android.live.core.monitor.trace.e r3, JSONObject r4, JSONObject r5, JSONObject r6) {
            if (((Boolean) kh.a.getValue()).booleanValue() == true) goto L5;
            a60.e r0 = com.bytedance.android.live.core.monitor.trace.c.a;
            Intrinsics.checkNotNullParameter(r3, "traceMeta");
            TraceMonitor.i(r3, r4, r5, r6);
            return;
        L5:
            if (b != null) goto L7;
            PthreadHandlerThreadV2 r1 = new PthreadHandlerThreadV2("broadcast monitor");
            b = r1;
            ThreadMethodProxy.start(r1);
            c = new Handler(r1.getLooper());
        L7:
            Boolean r2 = NewBroadcastMonitor.a;
            if (((Boolean) gh.a.getValue()).booleanValue() == true) goto L10;
            Handler r7 = c;
            if (r7 == null) goto L23;
            r7.post(new b(r3, r4, r5, r6));
            return;
        L23:
            return;
        L10:
            if ((!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) == false) goto L13;
            a60.e r8 = com.bytedance.android.live.core.monitor.trace.c.a;
            Intrinsics.checkNotNullParameter(r3, "traceMeta");
            TraceMonitor.i(r3, r4, r5, r6);
            return;
        L13:
            Handler r9 = c;
            if (r9 == null) goto L21;
            r9.post(new a(r3, r4, r5, r6));
            return;
        }
    }

    public static final class d {
        public JSONObject a;
        public JSONObject b;
        public JSONObject c;

        public d() {
        }
    }

    public static final class e implements ICrashCallback {
        public final /* synthetic */ LiveMode a;

        public e(LiveMode r1) {
            this.a = r1;
        }

        public final void onCrash(CrashType r8, String r9, Thread r11) {
            Intrinsics.checkNotNullParameter(r8, "type");
            Boolean r12 = NewBroadcastMonitor.a;
            ConcurrentHashMap<String, Long> r13 = NewBroadcastMonitor.i;
            Long r0 = r13.get(r8.getName());
            if (r0 != null) goto L5;
            r0 = 0L;
        L5:
            long r1 = r0.longValue();
            long r2 = System.currentTimeMillis();
            if (Math.abs(r2 - r1) >= 10000) goto L8;
            return;
        L8:
            r13.put(r8.getName(), Long.valueOf(r2));
            a r14 = NewBroadcastMonitor.c(SERVICE.SERVICE_ANCHOR_CRASH_LOG, this.a, null, 10);
            r14.l(-999);
            if (r9 == null) goto L11;
            r14.c(r8.getName());
            r14.i("crash", r9);
            r14.i("crash_type", r8.getName());
        L11:
            r14.a().report();
            if (r9 != null) goto L14;
            return;
        L14:
            if (StringsKt.contains$default(r9, "too much memory", false, 2, null) != true) goto L18;
            NewBroadcastMonitor.e(this.a);
            return;
        }
    }

    public static final class f implements IOOMCallback {
        public final /* synthetic */ LiveMode a;

        public f(LiveMode r1) {
            this.a = r1;
        }

        public final void onCrash(CrashType r2, Throwable r3, Thread r4, long r5) {
            Intrinsics.checkNotNullParameter(r2, "type");
            a r6 = NewBroadcastMonitor.c(SERVICE.SERVICE_ANCHOR_OOM_LOG, this.a, null, 10);
            r6.l(-999);
            if (r3 == null) goto L5;
            r6.i("crash", r3.getMessage());
            r6.i("crash_type", r2.getName());
        L5:
            r6.a().report();
            Boolean r7 = NewBroadcastMonitor.a;
            NewBroadcastMonitor.e(this.a);
        }
    }

    public NewBroadcastMonitor() {
    }

    static {
        a = (Boolean) v90.a.getValue();
        b = "";
        c = "";
        d = "";
        e = new LinkedHashMap();
        f = new LinkedHashMap();
        i = new ConcurrentHashMap();
        j = new LinkedHashMap();
    }

    public static final boolean a(String r1) {
        if (((Boolean) gh.a.getValue()).booleanValue() == true) goto L6;
        return true;
    L6:
        return Intrinsics.areEqual((String) ((LinkedHashMap) e).get(r1), STAGE.CORE);
    }

    public static void b(a r9) {
        r9.i("tag", "ttlive_sdk");
        r9.i("os", "android");
        boolean r1 = true;
        if (b.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L10;
        b = "";
    L10:
        if (d.length() == 0) goto L13;
        r1 = false;
    L13:
        if (r1 == false) goto L15;
        d = "";
    L15:
        r9.i("device_id", b);
        r9.i("user_id", "");
        r9.i("webcast_sdk_version", String.valueOf(com.bytedance.android.livesdk.paas.c.b()));
        r9.i("monitor_by", "new broadcast monitor");
        r9.i("anchor_trace_uuid", c);
        r9.i("multi_camera_status", null);
        if (0.0f < 8.0d) goto L19;
        String r2 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L22:
        r9.i("device_performance", r2);
        if (a.booleanValue() == false) goto L26;
        r9.e("isLiveEnd", "0");
        r9.i("isLiveEnd", "0");
        r9.e("processId", null);
        r9.e("appId", null);
        return;
    L26:
        return;
    L19:
        if (0.0f <= 0) goto L21;
        r2 = "3";
        goto L22
    L21:
        r2 = "0";
        goto L22
    L5:
        r0 = false;
        goto L7
    }

    public static int d(Throwable r2) {
        if (r2 != null) goto L6;
        return -999;
    L6:
        if ((r2 instanceof CustomApiServerException) == false) goto L9;
        return ((CustomApiServerException) r2).getErrorCode();
    L9:
        if ((r2 instanceof ApiServerException) == false) goto L12;
        return ((ApiServerException) r2).getErrorCode();
    L12:
        if ((r2 instanceof ApiException) == false) goto L18;
        ApiException r3 = (ApiException) r2;
        if (r3.getErrorCode() != 0) goto L29;
        return -998;
    L29:
        return r3.getErrorCode();
    L18:
        if ((r2 instanceof NetworkErrorException) == false) goto L24;
        int r0 = ((NetworkErrorException) r2).statusCode;
        if (r0 != 0) goto L33;
        return -997;
    L33:
        return r0;
    L24:
        if ((r2 instanceof NetworkNotAvailabeException) == true) goto L26;
        return -999;
    L26:
        return ((NetworkNotAvailabeException) r2).getCronetInternalErrorCode();
    }

    public static void e(LiveMode r14) {
        Integer r0 = (Integer) ih.a.getValue();
        int r1 = Random.Default.nextInt(1, 10);
        if (((o) p00.a.getValue()).dumpStrategy != 2) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L8;
        String r6 = "oom_npth";
    L10:
        if (r1 >= r0.intValue()) goto L47;
        String r2 = k.n(IPerformanceManager.class).getModule();
        JSONObject r4 = new JSONObject();
        r4.put("module", r2);
        r4.put("update_version_code", d);
        r4.put("dump_type", r6);
        Pair[] r7 = new Pair[8];
        r7[0] = TuplesKt.to("anchor_id", null);
        r7[1] = TuplesKt.to("room_id", null);
        if (r14 == null) goto L20;
        int r15 = p.a[r14.ordinal()];
        if (r15 == 1) goto L25;
        if (r15 == 2) goto L24;
        if (r15 == 3) goto L23;
        if (r15 == 4) goto L22;
        if (r15 != 5) goto L20;
        String r16 = "media";
    L26:
        r7[2] = TuplesKt.to("live_type", r16);
        r7[3] = TuplesKt.to("oom_time", Long.valueOf(System.currentTimeMillis()));
        r7[4] = TuplesKt.to("live_room_mode", null);
        r7[5] = TuplesKt.to("is_top", null);
        r7[6] = TuplesKt.to("extra_info", r4.toString());
        r7[7] = TuplesKt.to("dump_type", r6);
        Map r17 = MapsKt.mapOf(r7);
        SharedPreferences r5 = jc1.a.b().getSharedPreferences("ttlive_sdk_dump_hprof_meta", 0);
        if (r5 == null) goto L33;
        SharedPreferences.Editor r8 = r5.edit();
        if (r8 == null) goto L33;
        SharedPreferences.Editor r9 = r8.putLong("last_dump_time", System.currentTimeMillis());
        if (r9 == null) goto L33;
        r9.apply();
    L33:
        File r11 = jc1.a.b().getExternalFilesDir("dumpLiveCrashFileDir");
        if (r11 == null) goto L48;
        r11.mkdirs();
        PolarisFileWrapper r12 = new PolarisFileWrapper(r11, "livedump.hprof");
        if (r3 == false) goto L38;
        Npth.dumpHprof(r12.getAbsolutePath());
    L39:
        String r18 = new JSONObject(r17).toString();
        if (r5 == null) goto L49;
        SharedPreferences.Editor r13 = r5.edit();
        if (r13 == null) goto L50;
        SharedPreferences.Editor r19 = r13.putString("meta_info", r18);
        if (r19 == null) goto L51;
        r19.apply();
        return;
    L51:
        return;
    L50:
        return;
    L49:
        return;
    L38:
        Debug.dumpHprofData(r12.getAbsolutePath());
        goto L39
    L48:
        return;
    L22:
        r16 = "voice_live";
        goto L26
    L23:
        r16 = "third_party";
        goto L26
    L24:
        r16 = "game";
        goto L26
    L25:
        r16 = "video_live";
    L20:
        r16 = "";
        goto L26
    L47:
        return;
    L8:
        r6 = "oom_debug";
        goto L10
    L5:
        r3 = false;
        goto L6
    }

    @JvmStatic
    public static final void f(@SERVICE String r2) {
        Intrinsics.checkNotNullParameter(r2, "serviceName");
        a r0 = new a(r2, LiveTracingMonitor.EventModule.OPEN_LIVE);
        r0.l(0);
        b(r0);
        r0.g = true;
        r0.f = false;
        r0.a().report();
    }

    public static void i(LiveMode r2) {
        i.clear();
        e r0 = g;
        CrashType r1 = CrashType.ALL;
        Npth.unregisterCrashCallback(r0, r1);
        Npth.unregisterOOMCallback(h, r1);
        e r3 = new e(r2);
        g = r3;
        Npth.registerCrashCallback(r3, r1);
        f r4 = new f(r2);
        h = r4;
        Npth.registerOOMCallback(r4);
    }

    @JvmStatic
    public static final void g(@SERVICE String r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r3, "serviceName");
        Intrinsics.checkNotNullParameter(r4, "map");
        a r0 = new a(r3, LiveTracingMonitor.EventModule.OPEN_LIVE);
        r0.l(0);
        b(r0);
        Iterator<Map.Entry<String, String>> r5 = r4.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry<String, String> r1 = r5.next();
        r0.i(r1.getKey(), r1.getValue());
        goto L4
    L6:
        r0.g = true;
        r0.f = false;
        r0.a().report();
    }

    @JvmStatic
    public static final void h(@SERVICE String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "broadcastMonitor");
        Intrinsics.checkNotNullParameter(r4, "tag");
        a r0 = new a(r3, LiveTracingMonitor.EventModule.OPEN_LIVE);
        r0.l(0);
        r0.e("page", PAGE.ROOM);
        r0.i("custom_tag", r4);
        b(r0);
        r0.g = true;
        r0.f = false;
        r0.a().report();
    }

    public static a c(String r2, LiveMode r3, String r4, int r5) {
        if ((r5 & 4) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = null;
    L8:
        Intrinsics.checkNotNullParameter(r2, "serviceName");
        a r6 = new a(r2, LiveTracingMonitor.EventModule.OPEN_LIVE);
        r6.l(0);
        if (r3 == null) goto L11;
        r6.e("live_mode", r3.name());
        r6.i("live_mode", r3.name());
    L11:
        b(r6);
        if (r4 == null) goto L14;
        r6.e("page", r4);
        r6.i("page", r4);
    L14:
        r6.g = true;
        r6.f = false;
        return r6;
    }
}

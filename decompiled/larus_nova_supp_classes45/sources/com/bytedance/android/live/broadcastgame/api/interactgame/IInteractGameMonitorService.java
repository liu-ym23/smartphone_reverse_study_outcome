package com.bytedance.android.live.broadcastgame.api.interactgame;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.utility.ServiceLookup;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ServiceLookup("com.bytedance.android.live.broadcastgame.InteractGameMonitorService")
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0006\bg\u0018\u0000 *2\u00020\u0001:\u0001+J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&J\"\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&J&\u0010\u0012\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&J8\u0010\u0016\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u0002H&J\u001a\u0010\u0017\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&J\u001a\u0010\u0018\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&J&\u0010\u0019\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&J\"\u0010\u001c\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001b\u001a\u00020\u001aH&J8\u0010\u001f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001d\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u0002H&J8\u0010 \u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001d\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u0002H&J>\u0010%\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\t2\b\b\u0002\u0010#\u001a\u00020\u00072\b\b\u0002\u0010$\u001a\u00020\u0002H&J\u0016\u0010(\u001a\u00020\u00042\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000e0&H&J6\u0010)\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000e0&2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0002H&¨\u0006,"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/interactgame/IInteractGameMonitorService;", "Lcom/bytedance/android/live/base/IService;", "", "gameIdentifier", "", "recordGameIdentifier", "getCurrentGameIdentifier", "", "status", "", "duration", "", "throwable", "logFetchInteractItemList", "Lcom/bytedance/android/live/broadcastgame/api/model/u;", "gameItem", "Lorg/json/JSONObject;", "data", "logInteractGameItemClick", "failedCode", "switchId", "switchName", "logInteractGamePreCheck", "logGameIntroShow", "logGameIntroClick", "logGameStartupResult", "", "isCutShort", "logGameStop", "playId", "logId", "logGameStatusStart", "logGameStatusStop", "tryCount", "startLoadTime", "errorCode", "errorMsg", "logEffectGameResourceLoad", "", "games", "logEffectBatchLoadStart", "logEffectBatchLoadEnd", "Companion", "a", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IInteractGameMonitorService extends IService {
    public static final a Companion = null;
    public static final int ERROR_CODE_COMMON_UNKNOWN = -1;
    public static final int ERROR_CODE_LIMIT_GAME_ID = 4014029;
    public static final String ERROR_MSG_COMMON_UNKNOWN = "unknown error";
    public static final String FAILURE_CODE_EFFECT_GAME_START_RESOURCE_CANCEL = "402";
    public static final String FAILURE_CODE_EFFECT_GAME_START_RESOURCE_ERROR = "401";
    public static final String FAILURE_CODE_KTV_MUTEX = "101";
    public static final String FAILURE_CODE_LINK_MIC_MUTEX = "103";
    public static final String FAILURE_CODE_OTHER_GAME_MUTEX = "109";
    public static final String FAILURE_CODE_PK_MUTEX = "108";
    public static final String FAILURE_CODE_SWITCH_GAME_CHECK = "119";
    public static final String GECKO_SOURCE = "gecko";
    public static final String LOCAL_SOURCE = "local";
    public static final String SERVICE_EFFECT_GAME_RESOURCE_LOAD_ALL = "ttlive_effect_game_resource_load_all";
    public static final String SERVICE_EFFECT_GAME_RESOURCE_LOAD_ERROR = "ttlive_effect_game_resource_load_error";
    public static final String SERVICE_EFFECT_GAME_RESOURCE_PRELOAD_ALL = "ttlive_effect_game_resource_preload_all";
    public static final String SERVICE_EFFECT_GAME_RESOURCE_PRELOAD_ERROR = "ttlive_effect_game_resource_preload_error";
    public static final String SERVICE_EFFECT_GAME_RESOURCE_PRELOAD_START = "ttlive_effect_game_resource_preload_start_all";
    public static final String SERVICE_FETCH_INTERACT_GAME_LIST_ALL = "ttlive_fetch_interactive_game_list_all";
    public static final String SERVICE_FETCH_INTERACT_GAME_LIST_ERROR = "ttlive_fetch_interactive_game_list_error";
    public static final String SERVICE_INTERACT_GAME_CHECK_ALL = "ttlive_interactive_game_check_all";
    public static final String SERVICE_INTERACT_GAME_EXIT_ALL = "ttlive_interactive_game_exit_all";
    public static final String SERVICE_INTERACT_GAME_ICON_CLICK_ALL = "ttlive_interactive_game_icon_click_all";
    public static final String SERVICE_INTERACT_GAME_INTRO_CLICK_ALL = "ttlive_interactive_game_intro_click_all";
    public static final String SERVICE_INTERACT_GAME_INTRO_SHOW_ALL = "ttlive_interactive_game_intro_show_all";
    public static final String SERVICE_INTERACT_GAME_START_ALL = "ttlive_interactive_game_start_all";
    public static final String SERVICE_INTERACT_GAME_STATUS_START_ALL = "ttlive_interactive_game_status_start_all";
    public static final String SERVICE_INTERACT_GAME_STATUS_START_ERROR = "ttlive_interactive_game_status_start_error";
    public static final String SERVICE_INTERACT_GAME_STATUS_STOP_ALL = "ttlive_interactive_game_status_stop_all";
    public static final String SERVICE_INTERACT_GAME_STATUS_STOP_ERROR = "ttlive_interactive_game_status_stop_error";
    public static final String TAG = "IInteractGameMonitorService";

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    public static final class b {
        public static /* synthetic */ void c(IInteractGameMonitorService r8, int r9, u r11, String r12, int r13) {
            if ((r13 & 4) == 0) goto L5;
            String r5 = "";
        L7:
            if ((r13 & 8) == 0) goto L9;
            String r6 = "";
        L11:
            if ((r13 & 16) == 0) goto L13;
            String r7 = "";
        L14:
            r8.logInteractGamePreCheck(r9, r11, r5, r6, r7);
            return;
        L13:
            r7 = null;
            goto L14
        L9:
            r6 = null;
            goto L11
        L5:
            r5 = r12;
            goto L7
        }

        public static /* synthetic */ void a(IInteractGameMonitorService r9, int r11, u r12, long r13, Throwable r14, int r15) {
            String r1 = null;
            if ((r15 & 8) == 0) goto L5;
            Throwable r7 = null;
        L7:
            if ((r15 & 16) == 0) goto L9;
            r1 = "";
        L9:
            r9.logGameStatusStart(r11, r12, r13, r7, r1);
            return;
        L5:
            r7 = r14;
            goto L7
        }

        public static /* synthetic */ void b(IInteractGameMonitorService r9, int r11, u r12, long r13, Throwable r14, int r15) {
            String r1 = null;
            if ((r15 & 8) == 0) goto L5;
            Throwable r7 = null;
        L7:
            if ((r15 & 16) == 0) goto L9;
            r1 = "";
        L9:
            r9.logGameStatusStop(r11, r12, r13, r7, r1);
            return;
        L5:
            r7 = r14;
            goto L7
        }
    }

    static {
        Companion = a.a;
    }

    String getCurrentGameIdentifier();

    void logEffectBatchLoadEnd(int r1, List<u> r2, long r3, int r5, String r6);

    void logEffectBatchLoadStart(List<u> r1);

    void logEffectGameResourceLoad(int r1, u r2, int r3, long r4, int r6, String r7);

    void logFetchInteractItemList(int r1, long r2, Throwable r4);

    void logGameIntroClick(int r1, u r2);

    void logGameIntroShow(int r1, u r2);

    void logGameStartupResult(int r1, u r2, JSONObject r3);

    void logGameStatusStart(int r1, u r2, long r3, Throwable r5, String r6);

    void logGameStatusStop(int r1, u r2, long r3, Throwable r5, String r6);

    void logGameStop(int r1, u r2, boolean r3);

    void logInteractGameItemClick(int r1, u r2, JSONObject r3);

    void logInteractGamePreCheck(int r1, u r2, String r3, String r4, String r5);

    void recordGameIdentifier(String r1);
}

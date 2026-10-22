package com.ss.ttvideoengine.strategrycenter;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class StrategyEvent {
    private static final String EST_PLAYTIME = "est_play";
    private static final String FIRST_BLOCK_DECISION_TIME = "first_block_decision_time";
    private static final String FIRST_BLOCK_EXEC_TIME = "first_block_exec_time";
    public static final String LOG_KEY_ADAPTIVE_RANGE = "st_adaptive_range";
    private static final String LOG_KEY_ADAPTIVE_RANGE_BUFFER_LOG = "buffer_log";
    private static final String LOG_KEY_ADAPTIVE_RANGE_ENABLED = "enabled";
    private static final String LOG_KEY_BANDWIDTH_BITRATE_RATIO = "band_bitrate_ratio";
    public static final String LOG_KEY_BANDWIDTH_RANGE = "st_band_range";
    public static final String LOG_KEY_BUFFER_DURATION = "st_buf_dur";
    public static final String LOG_KEY_COMMON_EVENT_LOG = "st_common";
    private static final String LOG_KEY_CURRENT_BANDWIDTH = "current_bandwidth";
    private static final String LOG_KEY_FIRST_FRAME_LABEL = "first_frame_label";
    private static final String LOG_KEY_LOAD_CONTROL_SLIDING_WINDOW = "sliding_window";
    private static final String LOG_KEY_LOAD_CONTROL_VERSION = "lc_version";
    private static final String LOG_KEY_MODULE_ACTIVATED = "module_activated";
    private static final String LOG_KEY_PLAY_BUFFER_DIFF_COUNT = "diff_ret_count";
    public static final String LOG_KEY_PLAY_TASK_CONTROL = "st_play_task_op";
    public static final String LOG_KEY_PRELOAD = "st_preload";
    public static final String LOG_KEY_PRELOAD_DECISION_INFO = "st_preload_decision";
    public static final String LOG_KEY_PRELOAD_DECISION_INFO2 = "st_preload_decision2";
    public static final String LOG_KEY_PRELOAD_FINISHED_TIME = "st_preload_finished_time";
    public static final String LOG_KEY_PRELOAD_PERSONALIZED = "st_preload_personalized";
    private static final String LOG_KEY_PRELOAD_PERSONALIZED_OPTION = "preload_personalized_option";
    public static final String LOG_KEY_PRELOAD_STRATEGY = "st_preload_sc_info";
    public static final String LOG_KEY_REMAINING_BUFFER_DURATION = "st_remaining_buf_dur";
    private static final String LOG_KEY_RE_BUFFER_DURATION_INITIAL = "rebuf_dur_init";
    private static final String LOG_KEY_STALL_LABEL = "stall_label";
    private static final String LOG_KEY_STARTUP_BUFFER_DURATION = "startup_buf_dur";
    private static final String LOG_KEY_STARTUP_CACHE_SIZE = "startup_cache";
    public static final String LOG_KEY_THROWS = "st_throws";
    private static final String LOG_KEY_WATCH_DURATION_LABEL = "watch_duration_label";
    private static final String PAUSE = "pause";
    private static final String RANGE = "range";
    private static final String RANGE_DURATION = "range_dur";
    private static final String RESUME = "resume";
    private static final String SAFE_FACTOR = "safe_factor";
    private static final String SEEKLABEL = "seek_label";
    private static final String SMART_LEVEL = "smart_level";
    private static final String TAG = "StrategyEvent";
    private static final String TARGET_BUFFER = "target_buffer";
    private final ConcurrentMap<String, Object> mNoVidMap;
    private final Queue<Map<String, Object>> mUnexpectedThrowables;
    private final ConcurrentMap<String, ConcurrentMap<String, Object>> mVidMap;

    public StrategyEvent() {
        this.mVidMap = new ConcurrentHashMap();
        this.mNoVidMap = new ConcurrentHashMap();
        this.mUnexpectedThrowables = new ConcurrentLinkedQueue();
    }

    private static Map<String, Object> convertCounterMap(Map<String, Object> r3) {
        HashMap r0 = new HashMap();
        Iterator<Map.Entry<String, Object>> r4 = r3.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L12;
        Map.Entry<String, Object> r1 = r4.next();
        if ((r1.getValue() instanceof Map) == true) goto L7;
        if ((r1.getValue() instanceof AtomicInteger) == true) goto L10;
        r0.put(r1.getKey(), r1.getValue());
        goto L4
    L10:
        r0.put(r1.getKey(), Integer.valueOf(((AtomicInteger) r1.getValue()).get()));
        goto L4
    L7:
        r0.put(r1.getKey(), convertCounterMap((Map) r1.getValue()));
        goto L4
    L12:
        return r0;
    }

    public Map<String, Object> getLogData(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return null;
    L6:
        ConcurrentMap<String, Object> r0 = this.mVidMap.get(r4);
        if (r0 == null) goto L9;
        Map r1 = convertCounterMap(r0);
    L10:
        r1.putAll(this.mNoVidMap);
        String r2 = StrategyHelper.helper().getCenter().p(31301, r4);
        if (TextUtils.isEmpty(r2) == true) goto L14;
        r1.put(LOG_KEY_PRELOAD_STRATEGY, r2);
    L14:
        if (this.mUnexpectedThrowables.isEmpty() == true) goto L16;
        r1.put(LOG_KEY_THROWS, this.mUnexpectedThrowables);
        this.mUnexpectedThrowables.clear();
    L16:
        TTVideoEngineLog.i(TAG, "vid: " + r4 + ", gotten log data: " + r1);
        return r1;
    L9:
        r1 = new HashMap();
        goto L10
    }

    public void removeLogData(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        this.mVidMap.remove(r2);
    }

    private static ConcurrentMap<String, Object> putIfAbsentAndGetMap(ConcurrentMap<String, Object> r1, String r2) {
        r1.putIfAbsent(r2, new ConcurrentHashMap());
        return (ConcurrentMap) r1.get(r2);
    }

    public Map<String, Object> getLogData(String r3, String r4) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r4) == false) goto L8;
        return null;
    L8:
        if (r4.equals("st_play_task_op") == false) goto L14;
        Map r5 = (Map) this.mVidMap.get(r3).get(r4);
        if (r5 != null) goto L12;
        return null;
    L12:
        return convertCounterMap(r5);
    L14:
        return null;
    }

    public Map<String, Object> popLogData(int r7, String r8) {
        JSONObject r2 = new JSONObject(StrategyHelper.helper().getCenter().u(r7, r8));     // Catch: JSONException -> L9
        HashMap r1 = new HashMap();     // Catch: JSONException -> L9
        Iterator<String> r3 = r2.keys();     // Catch: JSONException -> L9
    L5:
        if (r3.hasNext() == false) goto L7;
        String r4 = r3.next();     // Catch: JSONException -> L9
        r1.put(r4, r2.get(r4));     // Catch: JSONException -> L9
        goto L5
    L7:
        TTVideoEngineLog.i(TAG, "traceId: " + r8 + ", type: " + r7 + ", gotten log data: " + r1);     // Catch: JSONException -> L9
        return r1;
    L9:
        e = move-exception;
        TTVideoEngineLog.e(TAG, "event log parse failed: " + e);
        return null;
    }

    private void eventImpl(String r23, int r24, int r25, String r26) {
        String r7 = RANGE_DURATION;
        if (TextUtils.isEmpty(r23) == true) goto L8;
        String r16 = LOG_KEY_PRELOAD_DECISION_INFO2;
        if ("unknown".equalsIgnoreCase(r23) == true) goto L9;
        ConcurrentMap<String, ConcurrentMap<String, Object>> r8 = this.mVidMap;
        r7 = RANGE_DURATION;
        r8.putIfAbsent(r23, new ConcurrentHashMap());
        ConcurrentMap<String, Object> r0 = this.mVidMap.get(r23);
    L10:
        ConcurrentMap<String, Object> r9 = r0;
        if (r24 != 2021) goto L13;
        if (r26 == null) goto L217;
        String r2 = r16;
        putIfAbsentAndGetMap(r9, r2).put("info", new JSONObject(r26));     // Catch: JSONException -> L142
        return;
    L142:
        e = move-exception;
        TTVideoEngineLog.w(TAG, "LOG_KEY_PRELOAD_DECISION_INFO2:\n" + e);
        putIfAbsentAndGetMap(r9, r2).put("info", r26);
        return;
    L217:
        return;
    L13:
        switch(r24) {
            case 2000: goto L64;
            case 2001: goto L62;
            case 2002: goto L60;
            case 2003: goto L54;
            case 2004: goto L53;
            case 2005: goto L52;
            case 2006: goto L51;
            case 2007: goto L50;
            case 2008: goto L49;
            case 2009: goto L42;
            case 2010: goto L41;
            case 2011: goto L35;
            case 2012: goto L153;
            case 2013: goto L26;
            case 2014: goto L25;
            case 2015: goto L20;
            case 2016: goto L19;
            case 2017: goto L18;
            case 2018: goto L16;
            default: goto L218;
        };
    L18:
        putIfAbsentAndGetMap(r9, LOG_KEY_BUFFER_DURATION).put(LOG_KEY_LOAD_CONTROL_SLIDING_WINDOW, Integer.valueOf(r25));
        return;
    L19:
        putIfAbsentAndGetMap(r9, LOG_KEY_BUFFER_DURATION).put(LOG_KEY_LOAD_CONTROL_VERSION, Integer.valueOf(r25));
        return;
    L20:
        if (r26 == null) goto L183;
        putIfAbsentAndGetMap(r9, LOG_KEY_PRELOAD_DECISION_INFO).put("info", new JSONObject(r26));     // Catch: JSONException -> L23
        return;
    L23:
        e = move-exception;
        TTVideoEngineLog.w(TAG, "LOG_KEY_PRELOAD_DECISION_INFO:\n" + e);
        putIfAbsentAndGetMap(r9, LOG_KEY_PRELOAD_DECISION_INFO).put("info", r26);
        return;
    L183:
        return;
    L25:
        this.mNoVidMap.put(LOG_KEY_COMMON_EVENT_LOG, Collections.singletonMap(LOG_KEY_MODULE_ACTIVATED, Integer.valueOf(r25)));
        return;
    L26:
        ConcurrentMap<String, Object> r3 = putIfAbsentAndGetMap(r9, LOG_KEY_BANDWIDTH_RANGE);
        r3.put(LOG_KEY_CURRENT_BANDWIDTH, Integer.valueOf(r25));
        r3.put(LOG_KEY_BANDWIDTH_BITRATE_RATIO, Float.valueOf(CastFloatProtector.parseFloat(r26)));     // Catch: NumberFormatException -> L29
        return;
    L29:
        e = move-exception;
        TTVideoEngineLog.e(TAG, "LOG_KEY_BANDWIDTH_BITRATE_RATIO:\n" + e);
        r3.put(LOG_KEY_BANDWIDTH_BITRATE_RATIO, r26);
        return;
    L35:
        Map r1 = (Map) r9.get(LOG_KEY_BUFFER_DURATION);
        if (r1 == null) goto L188;
        Integer r4 = (Integer) r1.get(LOG_KEY_PLAY_BUFFER_DIFF_COUNT);
        if (r4 != null) goto L40;
        r4 = 0;
    L40:
        r1.put(LOG_KEY_PLAY_BUFFER_DIFF_COUNT, Integer.valueOf(r4.intValue() + r25));
        return;
    L188:
        return;
    L41:
        r9.put(LOG_KEY_REMAINING_BUFFER_DURATION, Integer.valueOf(r25));
        return;
    L42:
        if (r26 != null) goto L159;
        TTVideoEngineLog.e(TAG, "EVENT_ADAPTIVE_RANGE_BUFFER: logInfo is null");
        return;
    L159:
        Object r5 = new JSONObject(r26);     // Catch: JSONException -> L46
    L48:
        putIfAbsentAndGetMap(r9, LOG_KEY_ADAPTIVE_RANGE).put(LOG_KEY_ADAPTIVE_RANGE_BUFFER_LOG, r5);
        return;
    L46:
        e = move-exception;
        TTVideoEngineLog.w(TAG, "EVENT_ADAPTIVE_RANGE_BUFFER:\n" + e);
        r5 = r26;
        goto L48
    L49:
        putIfAbsentAndGetMap(r9, LOG_KEY_ADAPTIVE_RANGE).put(LOG_KEY_ADAPTIVE_RANGE_ENABLED, Integer.valueOf(r25));
        return;
    L50:
        putIfAbsentAndGetMap(r9, LOG_KEY_PRELOAD_PERSONALIZED).put(LOG_KEY_FIRST_FRAME_LABEL, Integer.valueOf(r25));
        return;
    L51:
        putIfAbsentAndGetMap(r9, LOG_KEY_PRELOAD_PERSONALIZED).put(LOG_KEY_STALL_LABEL, Integer.valueOf(r25));
        return;
    L52:
        putIfAbsentAndGetMap(r9, LOG_KEY_PRELOAD_PERSONALIZED).put(LOG_KEY_WATCH_DURATION_LABEL, Integer.valueOf(r25));
        return;
    L53:
        putIfAbsentAndGetMap(r9, LOG_KEY_PRELOAD_PERSONALIZED).put(LOG_KEY_PRELOAD_PERSONALIZED_OPTION, Integer.valueOf(r25));
        return;
    L54:
        ConcurrentMap<String, Object> r6 = putIfAbsentAndGetMap(r9, LOG_KEY_BUFFER_DURATION);
        r6.put(LOG_KEY_STARTUP_BUFFER_DURATION, Integer.valueOf(r25));
        if (r26 == null) goto L198;
        r6.put(LOG_KEY_STARTUP_CACHE_SIZE, new JSONObject(r26));     // Catch: JSONException -> L58
        return;
    L58:
        e = move-exception;
        TTVideoEngineLog.w(TAG, "LOG_KEY_STARTUP_CACHE_SIZE:\n" + e);
        r6.put(LOG_KEY_STARTUP_CACHE_SIZE, r26);
        return;
    L198:
        return;
    L60:
        putIfAbsentAndGetMap(r9, LOG_KEY_BUFFER_DURATION).put(LOG_KEY_RE_BUFFER_DURATION_INITIAL, Integer.valueOf(r25));
        return;
    L64:
        r9.putIfAbsent("st_play_task_op", new ConcurrentHashMap());
        ConcurrentMap r10 = (ConcurrentMap) r9.get("st_play_task_op");
        if (r25 != 1) goto L67;
        r10.putIfAbsent(PAUSE, new AtomicInteger());
        ((AtomicInteger) r10.get(PAUSE)).incrementAndGet();
        return;
    L67:
        if (r25 != 2) goto L69;
        r10.putIfAbsent(RESUME, new AtomicInteger());
        ((AtomicInteger) r10.get(RESUME)).incrementAndGet();
        return;
    L69:
        if (r25 != 4) goto L71;
        r10.putIfAbsent(RANGE, new AtomicInteger());
        ((AtomicInteger) r10.get(RANGE)).incrementAndGet();
        return;
    L71:
        if (r25 != 5) goto L73;
        if (r26 != null) goto L155;
        TTVideoEngineLog.e(TAG, "PLAY_TASK_RANGE_DURATION: logInfo is null");
        return;
    L155:
        String r11 = r7;
        r10.put(r11, new JSONObject(r26));     // Catch: JSONException -> L130
        return;
    L130:
        e = e;
    L134:
        TTVideoEngineLog.w(TAG, "PLAY_TASK_RANGE_DURATION:\n" + e);
        r10.put(r11, r26);
        return;
    L132:
        e = e;
        r11 = r7;
        goto L134
    L73:
        if (r25 != 6) goto L75;
        if (r26 != null) goto L145;
        TTVideoEngineLog.e(TAG, "PLAY_TASK_TARGET_BUFFER");
        return;
    L145:
        JSONObject r12 = new JSONObject(r26);     // Catch: JSONException -> L121
        Object r13 = TARGET_BUFFER;
        r10.put(r13, r12);     // Catch: JSONException -> L119
        return;
    L119:
        e = e;
    L123:
        TTVideoEngineLog.w(TAG, "PLAY_TASK_TARGET_BUFFER:\n" + e);
        r10.put(r13, r26);
        return;
    L121:
        e = e;
        r13 = TARGET_BUFFER;
        goto L123
    L75:
        if (r25 == 7) goto L102;
        switch(r25) {
            case 100: goto L101;
            case 101: goto L149;
            case 102: goto L171;
            case 103: goto L147;
            case 104: goto L78;
            default: goto L223;
        };
    L78:
        r10.put(SMART_LEVEL, r26);
        return;
    L101:
        r10.put(SEEKLABEL, r26);
        return;
    L147:
        r10.put(EST_PLAYTIME, Long.valueOf(CastLongProtector.parseLong(r26)));     // Catch: NumberFormatException -> L81
        return;
    L81:
        e = move-exception;
        TTVideoEngineLog.e(TAG, "EST_PLAYTIME:\n" + e);
        r10.put(EST_PLAYTIME, r26);
        return;
    L149:
        Long r14 = Long.valueOf(CastLongProtector.parseLong(r26));     // Catch: NumberFormatException -> L98
        Object r15 = FIRST_BLOCK_DECISION_TIME;
        r10.put(r15, r14);     // Catch: NumberFormatException -> L96
        return;
    L96:
        e = e;
    L100:
        TTVideoEngineLog.e(TAG, "PLAY_TASK_FIRST_BLOCK_DECISION_TIME:\n" + e);
        r10.put(r15, r26);
        return;
    L98:
        e = e;
        r15 = FIRST_BLOCK_DECISION_TIME;
        goto L100
    L171:
        Long r17 = Long.valueOf(CastLongProtector.parseLong(r26));     // Catch: NumberFormatException -> L89
        Object r18 = FIRST_BLOCK_EXEC_TIME;
        r10.put(r18, r17);     // Catch: NumberFormatException -> L87
        return;
    L87:
        e = e;
    L91:
        TTVideoEngineLog.e(TAG, "PLAY_TASK_FIRST_BLOCK_EXEC_TIME:\n" + e);
        r10.put(r18, r26);
        return;
    L89:
        e = e;
        r18 = FIRST_BLOCK_EXEC_TIME;
        goto L91
    L223:
        return;
    L102:
        if (r26 != null) goto L157;
        TTVideoEngineLog.e(TAG, "PLAY_TASK_SAFE_FACTOR");
        return;
    L157:
        JSONObject r19 = new JSONObject(r26);     // Catch: JSONException -> L110
        Object r20 = SAFE_FACTOR;
        r10.put(r20, r19);     // Catch: JSONException -> L108
        return;
    L108:
        e = e;
    L112:
        TTVideoEngineLog.w(TAG, "PLAY_TASK_SAFE_FACTOR:\n" + e);
        r10.put(r20, r26);
        return;
    L110:
        e = e;
        r20 = SAFE_FACTOR;
        goto L112
    L153:
        r9.put(LOG_KEY_PRELOAD_FINISHED_TIME, Long.valueOf(CastLongProtector.parseLong(r26)));     // Catch: NumberFormatException -> L33
        return;
    L33:
        e = move-exception;
        TTVideoEngineLog.e(TAG, "EVENT_PLAY_RELATED_PRELOAD_FINISHED:\n" + e);
        r9.put(LOG_KEY_PRELOAD_FINISHED_TIME, r26);
        return;
    L218:
        return;
    L16:
        if (TextUtils.isEmpty(r26) == true) goto L179;
        putIfAbsentAndGetMap(this.mNoVidMap, LOG_KEY_PRELOAD).put("scene", r26);
        return;
    L179:
        return;
    L62:
        if (TextUtils.isEmpty(r26) == true) goto L201;
        putIfAbsentAndGetMap(this.mNoVidMap, LOG_KEY_PRELOAD).put(IPortraitService.NAME, r26);
        return;
    L201:
        return;
    L9:
        r0 = this.mNoVidMap;
        goto L10
    L8:
        r16 = LOG_KEY_PRELOAD_DECISION_INFO2;
        goto L9
    }

    public void event(final String r10, final int r11, final int r12, final String r13) {
        eventImpl(r10, r11, r12, r13);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        this.mUnexpectedThrowables.add(new AnonymousClass1(this, r10, r11, r12, r13, th));
    }
}

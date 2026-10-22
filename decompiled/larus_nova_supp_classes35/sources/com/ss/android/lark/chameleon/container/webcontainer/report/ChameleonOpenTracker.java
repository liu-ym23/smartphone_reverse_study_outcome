package com.ss.android.lark.chameleon.container.webcontainer.report;

import com.ss.android.lark.chameleon.api.ChameleonConfig;
import com.ss.android.lark.chameleon.api.PreloadConfig;
import com.ss.android.lark.chameleon.api.PreloadPolicy;
import com.ss.android.lark.chameleon.util.UUIDUtil;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0007\u000e\u000f\u0010\u0011\u0012\u0013\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/report/ChameleonOpenTracker;", BuildConfig.FLAVOR, "()V", "sessionTrackers", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lcom/ss/android/lark/chameleon/container/webcontainer/report/ChameleonOpenTracker$SessionTracker;", "getSessionTracker", "session", "newSessionTracker", "chameleonConfig", "Lcom/ss/android/lark/chameleon/api/ChameleonConfig;", "releaseTracker", BuildConfig.FLAVOR, "Event", "EventType", "OpenResult", "OpenResultCode", "ParamKey", "SessionTracker", "Stage", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ChameleonOpenTracker {
    public static final ChameleonOpenTracker INSTANCE = null;
    private static final Map<String, SessionTracker> sessionTrackers = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/report/ChameleonOpenTracker$Event;", BuildConfig.FLAVOR, "()V", "CHAMELEON_COMMON_ERROR_DEV", BuildConfig.FLAVOR, "Chameleon_OPEN_FINISH_DEV", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Event {
        public static final String CHAMELEON_COMMON_ERROR_DEV = "webapp_common_error_dev";
        public static final String Chameleon_OPEN_FINISH_DEV = "webapp_open_finish_dev";
        public static final Event INSTANCE = null;

        static {
            INSTANCE = new Event();
        }

        private Event() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/report/ChameleonOpenTracker$EventType;", BuildConfig.FLAVOR, "()V", EventType.PULL_DATA_END, BuildConfig.FLAVOR, EventType.PULL_DATA_START, EventType.RENDER_END, EventType.RENDER_START, EventType.RES_READY, "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class EventType {
        public static final EventType INSTANCE = null;
        public static final String PULL_DATA_END = "PULL_DATA_END";
        public static final String PULL_DATA_START = "PULL_DATA_START";
        public static final String RENDER_END = "RENDER_END";
        public static final String RENDER_START = "RENDER_START";
        public static final String RES_READY = "RES_READY";

        static {
            INSTANCE = new EventType();
        }

        private EventType() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/report/ChameleonOpenTracker$OpenResult;", BuildConfig.FLAVOR, "()V", "CANCEL", BuildConfig.FLAVOR, "FAILED", "SUCCESS", "TIMEOUT", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class OpenResult {
        public static final String CANCEL = "cancel";
        public static final String FAILED = "failed";
        public static final OpenResult INSTANCE = null;
        public static final String SUCCESS = "success";
        public static final String TIMEOUT = "timeout";

        static {
            INSTANCE = new OpenResult();
        }

        private OpenResult() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/report/ChameleonOpenTracker$OpenResultCode;", BuildConfig.FLAVOR, "()V", "CANCEL", BuildConfig.FLAVOR, "ERROR_PRELOAD", "ERROR_RENDER_GONE", "FRONT_ERROR", "SUCCESS", "TIMEOUT", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class OpenResultCode {
        public static final int CANCEL = -3;
        public static final int ERROR_PRELOAD = 200;
        public static final int ERROR_RENDER_GONE = 100;
        public static final int FRONT_ERROR = 10000;
        public static final OpenResultCode INSTANCE = null;
        public static final int SUCCESS = 0;
        public static final int TIMEOUT = -2;

        static {
            INSTANCE = new OpenResultCode();
        }

        private OpenResultCode() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/report/ChameleonOpenTracker$ParamKey;", BuildConfig.FLAVOR, "()V", "APP_ID", BuildConfig.FLAVOR, "APP_NAME", "CODE", "COST", "ERRORMSG", "ERROR_TYPE", "FROM", "IS_TT_WEBVIEW", "LOAD_TYPE", "PRELOAD_TYPE", "RESULT", "RES_VERSION", "TT_WEBVIEW_VERSION", "URL", "URL_TYPE", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ParamKey {
        public static final String APP_ID = "app_id";
        public static final String APP_NAME = "app_name";
        public static final String CODE = "code";
        public static final String COST = "cost";
        public static final String ERRORMSG = "errorMsg";
        public static final String ERROR_TYPE = "error_type";
        public static final String FROM = "from";
        public static final ParamKey INSTANCE = null;
        public static final String IS_TT_WEBVIEW = "is_tt_webview";
        public static final String LOAD_TYPE = "load_type";
        public static final String PRELOAD_TYPE = "preload_type";
        public static final String RESULT = "result";
        public static final String RES_VERSION = "res_version";
        public static final String TT_WEBVIEW_VERSION = "tt_webview_version";
        public static final String URL = "url";
        public static final String URL_TYPE = "url_type";

        static {
            INSTANCE = new ParamKey();
        }

        private ParamKey() {
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0007J\u0016\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0001J\u001e\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0015J\u0018\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u0007J\u0018\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00100\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/report/ChameleonOpenTracker$SessionTracker;", BuildConfig.FLAVOR, "session", BuildConfig.FLAVOR, "chameleonConfig", "Lcom/ss/android/lark/chameleon/api/ChameleonConfig;", "start", BuildConfig.FLAVOR, "(Ljava/lang/String;Lcom/ss/android/lark/chameleon/api/ChameleonConfig;J)V", "extraParams", BuildConfig.FLAVOR, "getExtraParams", "()Ljava/util/Map;", "isFinish", BuildConfig.FLAVOR, "stageMap", "Lkotlin/Pair;", "openFinish", BuildConfig.FLAVOR, ParamKey.RESULT, "code", BuildConfig.FLAVOR, "timeMills", "recordParam", "key", "value", "reportCommonError", "msg", "errorType", "stageEnd", "stage", "stageStart", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class SessionTracker {
        private final ChameleonConfig chameleonConfig;
        private final Map<String, Object> extraParams;
        private boolean isFinish;
        private final String session;
        private final Map<String, Pair<Long, Long>> stageMap;
        private final long start;

        public final Map<String, Object> getExtraParams() {
            return this.extraParams;
        }

        public final void recordParam(String r2, Object r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, "value");
            this.extraParams.put(r2, r3);
        }

        public final void stageEnd(String r4, long r5) {
            Intrinsics.checkNotNullParameter(r4, "stage");
            Pair<Long, Long> r0 = this.stageMap.get(r4);
            if (r0 == null) goto L6;
            this.stageMap.put(r4, new Pair(r0.getFirst(), Long.valueOf(r5)));
            return;
        }

        public final void stageStart(String r5, long r6) {
            Intrinsics.checkNotNullParameter(r5, "stage");
            this.stageMap.put(r5, new Pair(Long.valueOf(r6), 0L));
        }

        public SessionTracker(String r2, ChameleonConfig r3, long r4) {
            Intrinsics.checkNotNullParameter(r2, "session");
            Intrinsics.checkNotNullParameter(r3, "chameleonConfig");
            this.session = r2;
            this.chameleonConfig = r3;
            this.start = r4;
            this.stageMap = new LinkedHashMap();
            this.extraParams = new LinkedHashMap();
        }

        public final void openFinish(String r7, int r8, long r9) {
            Intrinsics.checkNotNullParameter(r7, ParamKey.RESULT);
            if (this.isFinish == false) goto L5;
            return;
        L5:
            this.isFinish = true;
            JSONObject r1 = new JSONObject();
            r1.put(ParamKey.RESULT, r7);
            r1.put("code", r8);
            r1.put(ParamKey.APP_ID, this.chameleonConfig.getAppID());
            r1.put(ParamKey.APP_NAME, this.chameleonConfig.getBizName());
            PreloadConfig r10 = this.chameleonConfig.getPreloadConfig();
            if (r10 == null) goto L9;
            PreloadPolicy r11 = r10.getPolicy();
            if (r11 == null) goto L9;
        L10:
            r1.put(ParamKey.PRELOAD_TYPE, r11);
            r1.put(ParamKey.COST, r9 - this.start);
            Iterator<T> r12 = this.stageMap.entrySet().iterator();
        L12:
            if (r12.hasNext() == false) goto L18;
            Map.Entry r13 = (Map.Entry) r12.next();
            if (((Number) ((Pair) r13.getValue()).getFirst()).longValue() <= 0) goto L12;
            if (((Number) ((Pair) r13.getValue()).getSecond()).longValue() <= ((Number) ((Pair) r13.getValue()).getFirst()).longValue()) goto L12;
            r1.put(((String) r13.getKey()) + "_stage_start", ((Number) ((Pair) r13.getValue()).getFirst()).longValue() - this.start);
            r1.put(((String) r13.getKey()) + "_stage_cost", ((Number) ((Pair) r13.getValue()).getSecond()).longValue() - ((Number) ((Pair) r13.getValue()).getFirst()).longValue());
            goto L12
        L18:
            Iterator<Map.Entry<String, Object>> r14 = this.extraParams.entrySet().iterator();
        L20:
            if (r14.hasNext() == false) goto L22;
            Map.Entry<String, Object> r15 = r14.next();
            r1.put(r15.getKey(), r15.getValue());
            goto L20
        L22:
            ChameleonReport.INSTANCE.trackEventExt(Event.Chameleon_OPEN_FINISH_DEV, r1);
            return;
        L9:
            r11 = PreloadPolicy.NO_PRELOAD;
            goto L10
        }

        public final void reportCommonError(int r3, String r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "msg");
            JSONObject r0 = new JSONObject();
            r0.put("code", r3);
            r0.put(ParamKey.APP_ID, this.chameleonConfig.getAppID());
            r0.put(ParamKey.APP_NAME, this.chameleonConfig.getBizName());
            r0.put(ParamKey.ERRORMSG, r4);
            r0.put(ParamKey.ERROR_TYPE, r5);
            ChameleonReport.INSTANCE.trackEventExt(Event.CHAMELEON_COMMON_ERROR_DEV, r0);
        }

        public /* synthetic */ SessionTracker(String r1, ChameleonConfig r2, long r3, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 4) == 0) goto L5;
            r3 = System.currentTimeMillis();
        L5:
            this(r1, r2, r3);
        }

        public static /* synthetic */ void stageEnd$default(SessionTracker r0, String r1, long r2, int r4, Object r5) {
            if ((r4 & 2) == 0) goto L5;
            r2 = System.currentTimeMillis();
        L5:
            r0.stageEnd(r1, r2);
        }

        public static /* synthetic */ void stageStart$default(SessionTracker r0, String r1, long r2, int r4, Object r5) {
            if ((r4 & 2) == 0) goto L5;
            r2 = System.currentTimeMillis();
        L5:
            r0.stageStart(r1, r2);
        }

        public static /* synthetic */ void openFinish$default(SessionTracker r0, String r1, int r2, long r3, int r5, Object r6) {
            if ((r5 & 4) == 0) goto L5;
            r3 = System.currentTimeMillis();
        L5:
            r0.openFinish(r1, r2, r3);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/report/ChameleonOpenTracker$Stage;", BuildConfig.FLAVOR, "()V", "PRELOAD", BuildConfig.FLAVOR, "PULLDATA", "RENDER", "UNZIP", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Stage {
        public static final Stage INSTANCE = null;
        public static final String PRELOAD = "preload";
        public static final String PULLDATA = "pulldata";
        public static final String RENDER = "render";
        public static final String UNZIP = "unzip";

        static {
            INSTANCE = new Stage();
        }

        private Stage() {
        }
    }

    private ChameleonOpenTracker() {
    }

    static {
        INSTANCE = new ChameleonOpenTracker();
        sessionTrackers = new LinkedHashMap();
    }

    public final SessionTracker getSessionTracker(String r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return sessionTrackers.get(r2);
    }

    public final String newSessionTracker(ChameleonConfig r11) {
        Intrinsics.checkNotNullParameter(r11, "chameleonConfig");
        String r0 = UUIDUtil.randomUUID().toString();
        sessionTrackers.put(r0, new SessionTracker(r0, r11, 0, 4, null));
        return r0;
    }

    public final void releaseTracker(String r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
        sessionTrackers.remove(r2);
    }
}

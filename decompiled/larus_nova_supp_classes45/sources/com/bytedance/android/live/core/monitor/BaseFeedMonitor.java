package com.bytedance.android.live.core.monitor;

import android.os.SystemClock;
import com.bytedance.android.live.api.exceptions.local.ResponseNoDataException;
import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.livesdk.config.q10;
import com.bytedance.crash.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class BaseFeedMonitor extends BaseMonitor {
    public final Boolean a;
    public long b;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/core/monitor/BaseFeedMonitor$RequestType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "SERVICE_REQUEST_TYPE_REFRESH", "SERVICE_REQUEST_TYPE_LOADMORE", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum RequestType extends Enum<RequestType> {
        public static final RequestType SERVICE_REQUEST_TYPE_LOADMORE = null;
        public static final RequestType SERVICE_REQUEST_TYPE_REFRESH = null;
        public static final /* synthetic */ RequestType[] a = null;
        private final String type;

        static {
            RequestType r1 = new RequestType("SERVICE_REQUEST_TYPE_REFRESH", 0, "refresh");
            SERVICE_REQUEST_TYPE_REFRESH = r1;
            RequestType r2 = new RequestType("SERVICE_REQUEST_TYPE_LOADMORE", 1, "load_more");
            SERVICE_REQUEST_TYPE_LOADMORE = r2;
            a = new RequestType[]{r1, r2};
        }

        public static RequestType valueOf(String r1) {
            return (RequestType) r27.a.a(RequestType.class, r1);
        }

        public static RequestType[] values() {
            return (RequestType[]) a.clone();
        }

        public final String getType() {
            return this.type;
        }

        public RequestType(String r1, int r2, String r3) {
            super(r1, r2);
            this.type = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/core/monitor/BaseFeedMonitor$Scene;", "", "", "scene", "Ljava/lang/String;", "getScene", "()Ljava/lang/String;", "desc", "getDesc", "SERVICE_SCENE_INNER_DRAW", "SERVICE_SCENE_DRAWER", "SERVICE_SCENE_ROOM_DRAW_SCHEMA", "SERVICE_SCENE_SKYLIGHT", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Scene extends Enum<Scene> {
        public static final Scene SERVICE_SCENE_DRAWER = null;
        public static final Scene SERVICE_SCENE_INNER_DRAW = null;
        public static final Scene SERVICE_SCENE_ROOM_DRAW_SCHEMA = null;
        public static final Scene SERVICE_SCENE_SKYLIGHT = null;
        public static final /* synthetic */ Scene[] a = null;
        private final String desc;
        private final String scene;

        static {
            Scene r1 = new Scene("SERVICE_SCENE_INNER_DRAW", 0, "inner_draw", "内流");
            SERVICE_SCENE_INNER_DRAW = r1;
            Scene r2 = new Scene("SERVICE_SCENE_DRAWER", 1, "drawer", "抽屉");
            SERVICE_SCENE_DRAWER = r2;
            Scene r3 = new Scene("SERVICE_SCENE_ROOM_DRAW_SCHEMA", 2, "live_merge", "直播广场");
            SERVICE_SCENE_ROOM_DRAW_SCHEMA = r3;
            Scene r4 = new Scene("SERVICE_SCENE_SKYLIGHT", 3, "skylight", "天窗");
            SERVICE_SCENE_SKYLIGHT = r4;
            a = new Scene[]{r1, r2, r3, r4};
        }

        public static Scene valueOf(String r1) {
            return (Scene) r27.a.a(Scene.class, r1);
        }

        public static Scene[] values() {
            return (Scene[]) a.clone();
        }

        public final String getDesc() {
            return this.desc;
        }

        public final String getScene() {
            return this.scene;
        }

        public Scene(String r1, int r2, String r3, String r4) {
            super(r1, r2);
            this.scene = r3;
            this.desc = r4;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/core/monitor/BaseFeedMonitor$SubScene;", "", "", "subScene", "Ljava/lang/String;", "getSubScene", "()Ljava/lang/String;", "desc", "getDesc", "SERVICE_SUB_SCENE_NONE", "SERVICE_SUB_SCENE_DRAWER_SJB", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum SubScene extends Enum<SubScene> {
        public static final SubScene SERVICE_SUB_SCENE_DRAWER_SJB = null;
        public static final SubScene SERVICE_SUB_SCENE_NONE = null;
        public static final /* synthetic */ SubScene[] a = null;
        private final String desc;
        private final String subScene;

        static {
            SubScene r1 = new SubScene("SERVICE_SUB_SCENE_NONE", 0, "none", "无");
            SERVICE_SUB_SCENE_NONE = r1;
            SubScene r2 = new SubScene("SERVICE_SUB_SCENE_DRAWER_SJB", 1, "drawer_sjb", "赛事抽屉");
            SERVICE_SUB_SCENE_DRAWER_SJB = r2;
            a = new SubScene[]{r1, r2};
        }

        public static SubScene valueOf(String r1) {
            return (SubScene) r27.a.a(SubScene.class, r1);
        }

        public static SubScene[] values() {
            return (SubScene[]) a.clone();
        }

        public final String getDesc() {
            return this.desc;
        }

        public final String getSubScene() {
            return this.subScene;
        }

        public SubScene(String r1, int r2, String r3, String r4) {
            super(r1, r2);
            this.subScene = r3;
            this.desc = r4;
        }
    }

    public static final class a {
    }

    static {
    }

    public BaseFeedMonitor() {
        this.a = (Boolean) q10.a.getValue();
    }

    public final void l() {
        this.b = SystemClock.uptimeMillis();
    }

    public final void n(String r11, Scene r12, SubScene r13) {
        Intrinsics.checkNotNullParameter(r11, "requestType");
        Intrinsics.checkNotNullParameter(r12, "scene");
        Intrinsics.checkNotNullParameter(r13, "subScene");
        JSONObject r5 = new JSONObject();
        JSONObject r6 = new JSONObject();
        JSONObject r7 = new JSONObject();
        if (this.b <= 0) goto L5;
        long r1 = SystemClock.uptimeMillis() - this.b;
    L6:
        this.b = 0;
        BaseMonitor.add(r5, "status_code", 0);
        BaseMonitor.add(r5, "status", 0);
        BaseMonitor.add(r5, "scene", r12.getScene());
        BaseMonitor.add(r5, "sub_scene", r13.getSubScene());
        if (r1 <= 0) goto L9;
        BaseMonitor.add(r6, "latency", r1);
    L9:
        BaseMonitor.add(r7, "request_type", r11);
        LiveTracingMonitor.e("ttlive_request_feed_api_all", LiveTracingMonitor.EventModule.FEED, LiveTracingMonitor.EventType.SERVER_API_CALL, r5, r6, r7);
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public final void m(Throwable r18, String r19, Scene r21, SubScene r22) {
        Intrinsics.checkNotNullParameter(r19, "requestType");
        Intrinsics.checkNotNullParameter(r21, "scene");
        Intrinsics.checkNotNullParameter(r22, "subScene");
        if (this.b <= 0) goto L5;
        SystemClock.uptimeMillis();
    L5:
        this.b = 0;
        JSONObject r5 = new JSONObject();
        JSONObject r7 = new JSONObject();
        JSONObject r8 = new JSONObject();
        String r11 = null;
        if ((r18 instanceof CustomApiServerException) == false) goto L9;
        String r9 = ((CustomApiServerException) r18).getXTtLogId();
    L14:
        boolean r12 = r18 instanceof ApiServerException;
        boolean r13 = false;
        if (r12 == false) goto L18;
        int r14 = ((ApiServerException) r18).getErrorCode();
    L24:
        if (r12 == false) goto L27;
        r11 = ((ApiServerException) r18).getErrorMsg();
    L32:
        BaseMonitor.add(r5, "status_code", r14);
        BaseMonitor.add(r5, "status", 1);
        BaseMonitor.add(r5, "scene", r21.getScene());
        BaseMonitor.add(r5, "sub_scene", r22.getSubScene());
        if (r9 != null) goto L35;
    L38:
        boolean r3 = true;
    L39:
        if (r3 == true) goto L41;
        BaseMonitor.add(r8, "logId", r9);
    L41:
        if (r11 != null) goto L43;
    L44:
        r13 = true;
    L45:
        if (r13 == true) goto L47;
        BaseMonitor.add(r8, LiveSlardarConstants.EXTRA_KEY_ERROR_MSG, r11);
    L47:
        BaseMonitor.add(r8, LiveSlardarConstants.EXTRA_KEY_ERROR_CODE, r14);
        BaseMonitor.add(r8, "request_type", r19);
        if (this.a.booleanValue() == false) goto L52;
        if (r18 == null) goto L52;
        d.d(new RuntimeException(r18), "feed request loadMore error");
    L52:
        LiveTracingMonitor.EventModule r1 = LiveTracingMonitor.EventModule.FEED;
        LiveTracingMonitor.EventType r2 = LiveTracingMonitor.EventType.SERVER_API_CALL;
        LiveTracingMonitor.e("ttlive_request_feed_api_error", r1, r2, r5, r7, r8);
        LiveTracingMonitor.e("ttlive_request_feed_api_all", r1, r2, r5, r7, r8);
        return;
    L43:
        if (r11.length() != 0) goto L45;
    L35:
        if (r9.length() == 0) goto L38;
        r3 = false;
        goto L39
    L27:
        if ((r18 instanceof NetworkErrorException) == false) goto L30;
        r11 = r18.getMessage();
        goto L32
    L30:
        if ((r18 instanceof Exception) == false) goto L32;
        r11 = r18.getMessage();
        goto L32
    L18:
        if ((r18 instanceof NetworkErrorException) == false) goto L21;
        r14 = ((NetworkErrorException) r18).statusCode;
        goto L24
    L21:
        if ((r18 instanceof ApiException) == false) goto L23;
        r14 = ((ApiException) r18).getErrorCode();
        goto L24
    L23:
        r14 = 0;
        goto L24
    L9:
        if ((r18 instanceof ResponseNoDataException) == false) goto L13;
        BaseResponse r15 = ((ResponseNoDataException) r18).getResponse();
        if (r15 == null) goto L13;
        r9 = r15.logId;
    L13:
        r9 = null;
        goto L14
    }
}

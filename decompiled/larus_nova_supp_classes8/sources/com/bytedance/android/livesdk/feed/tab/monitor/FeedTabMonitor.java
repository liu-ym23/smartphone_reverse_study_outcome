package com.bytedance.android.livesdk.feed.tab.monitor;

import android.os.SystemClock;
import com.bytedance.android.live.api.exceptions.local.ResponseNoDataException;
import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.network.response.BaseResponse;
import com.ss.android.http.legacy.client.HttpResponseException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class FeedTabMonitor extends BaseMonitor {
    public long a;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/feed/tab/monitor/FeedTabMonitor$Action;", "", "", "action", "Ljava/lang/String;", "getAction", "()Ljava/lang/String;", "desc", "getDesc", "TRIGGER_ACTION_BOOST", "TRIGGER_ACTION_BOOST_LATE", "TRIGGER_ACTION_ENTER_ROOM", "TRIGGER_ACTION_OPEN_TAB_PAGE", "DEFAULT", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Action extends Enum<Action> {
        public static final Action DEFAULT = null;
        public static final Action TRIGGER_ACTION_BOOST = null;
        public static final Action TRIGGER_ACTION_BOOST_LATE = null;
        public static final Action TRIGGER_ACTION_ENTER_ROOM = null;
        public static final Action TRIGGER_ACTION_OPEN_TAB_PAGE = null;
        public static final /* synthetic */ Action[] a = null;
        private final String action;
        private final String desc;

        static {
            Action r1 = new Action("TRIGGER_ACTION_BOOST", 0, "boost", "冷启");
            TRIGGER_ACTION_BOOST = r1;
            Action r2 = new Action("TRIGGER_ACTION_BOOST_LATE", 1, "boost_1min", "冷启1min");
            TRIGGER_ACTION_BOOST_LATE = r2;
            Action r3 = new Action("TRIGGER_ACTION_ENTER_ROOM", 2, "enter_room", "进房");
            TRIGGER_ACTION_ENTER_ROOM = r3;
            Action r4 = new Action("TRIGGER_ACTION_OPEN_TAB_PAGE", 3, "open_tab_page", "打开tab页面");
            TRIGGER_ACTION_OPEN_TAB_PAGE = r4;
            Action r5 = new Action("DEFAULT", 4, "default", "默认");
            DEFAULT = r5;
            a = new Action[]{r1, r2, r3, r4, r5};
        }

        public static Action valueOf(String r1) {
            return (Action) r27.a.a(Action.class, r1);
        }

        public static Action[] values() {
            return (Action[]) a.clone();
        }

        public final String getAction() {
            return this.action;
        }

        public final String getDesc() {
            return this.desc;
        }

        public Action(String r1, int r2, String r3, String r4) {
            super(r1, r2);
            this.action = r3;
            this.desc = r4;
        }
    }

    public static final class a {
    }

    static {
    }

    public FeedTabMonitor() {
    }

    public final void m(Action r9) {
        Intrinsics.checkNotNullParameter(r9, "action");
        JSONObject r4 = new JSONObject();
        BaseMonitor.add(r4, "status", 0);
        BaseMonitor.add(r4, "trigger_action", r9.getAction());
        JSONObject r5 = new JSONObject();
        if (this.a <= 0) goto L5;
        long r0 = SystemClock.uptimeMillis() - this.a;
    L6:
        this.a = 0;
        if (r0 <= 0) goto L9;
        BaseMonitor.add(r5, "latency", r0);
    L9:
        LiveTracingMonitor.e("ttlive_service_request_tab_api_all", LiveTracingMonitor.EventModule.FEED_TAB, LiveTracingMonitor.EventType.SERVER_API_CALL, r4, r5, null);
        return;
    L5:
        r0 = 0;
        goto L6
    }

    public final void l(Action r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r11, "action");
        if (this.a <= 0) goto L5;
        SystemClock.uptimeMillis();
    L5:
        this.a = 0;
        boolean r0 = r12 instanceof CustomApiServerException;
        if (r0 == false) goto L9;
        int r1 = ((CustomApiServerException) r12).getErrorCode();
    L18:
        JSONObject r8 = new JSONObject();
        boolean r3 = true;
        BaseMonitor.add(r8, "status", 1);
        BaseMonitor.add(r8, "status_code", r1);
        BaseMonitor.add(r8, "trigger_action", r11.getAction());
        JSONObject r13 = new JSONObject();
        if (r0 == false) goto L22;
        String r2 = ((CustomApiServerException) r12).getXTtLogId();
    L28:
        if (r2 != null) goto L30;
    L33:
        boolean r4 = true;
    L34:
        if (r4 == true) goto L36;
        BaseMonitor.add(r13, "logId", r2);
    L36:
        BaseMonitor.add(r13, "error_code", r1);
        if ((r12 instanceof ApiServerException) == false) goto L40;
        String r14 = ((ApiServerException) r12).getErrorMsg();
    L46:
        if (r14 != null) goto L48;
    L51:
        if (r3 == true) goto L53;
        BaseMonitor.add(r13, "error_msg", r14);
    L53:
        LiveTracingMonitor.EventModule r15 = LiveTracingMonitor.EventModule.FEED_TAB;
        LiveTracingMonitor.EventType r5 = LiveTracingMonitor.EventType.SERVER_API_CALL;
        LiveTracingMonitor.e("ttlive_service_request_tab_api_error", r15, r5, r8, null, r13);
        LiveTracingMonitor.e("ttlive_service_request_tab_api_all", r15, r5, r8, null, r13);
        return;
    L48:
        if (r14.length() == 0) goto L51;
        r3 = false;
        goto L51
    L40:
        if ((r12 instanceof NetworkErrorException) == false) goto L43;
        r14 = r12.getMessage();
        goto L46
    L43:
        if ((r12 instanceof Exception) == false) goto L45;
        r14 = r12.getMessage();
        goto L46
    L45:
        r14 = null;
        goto L46
    L30:
        if (r2.length() == 0) goto L33;
        r4 = false;
        goto L34
    L22:
        if ((r12 instanceof ResponseNoDataException) == false) goto L26;
        BaseResponse r6 = ((ResponseNoDataException) r12).getResponse();
        if (r6 == null) goto L26;
        r2 = r6.logId;
    L26:
        r2 = null;
        goto L28
    L9:
        if ((r12 instanceof HttpResponseException) == false) goto L12;
        r1 = ((HttpResponseException) r12).getStatusCode();
        goto L18
    L12:
        if ((r12 instanceof ApiException) == false) goto L15;
        r1 = ((ApiException) r12).getErrorCode();
        goto L18
    L15:
        if ((r12 instanceof NetworkErrorException) == false) goto L17;
        r1 = ((NetworkErrorException) r12).statusCode;
        goto L18
    L17:
        r1 = -1;
        goto L18
    }
}

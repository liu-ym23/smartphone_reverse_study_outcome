package com.larksuite.component.card.plugin;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.annotation.LKPluginFunction;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import com.ss.android.lark.opmonitor.model.OPMonitorLevel;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0004\u001d\u001e\u001f B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0007J \u0010\r\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002JT\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00112&\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017j\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0018`\u0019H\u0002J \u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002¨\u0006!"}, d2 = {"Lcom/larksuite/component/card/plugin/ReportCardMonitorPlugin;", "Lcom/larksuite/component/card/plugin/OPPlugin;", "<init>", "()V", "cardMonitorReport", "", "lkEvent", "Lcom/larksuite/framework/apiplugin/LKEvent;", "request", "Lcom/larksuite/component/card/plugin/ReportCardMonitorPlugin$CardMonitorReportRequestModel;", "invokeCallback", "Lcom/larksuite/framework/apiplugin/api/LKEventInvokeCallback;", "Lcom/larksuite/component/card/plugin/ReportCardMonitorPlugin$CardMonitorReportResponseModel;", "monitorEvents", "Lcom/alibaba/fastjson/JSONArray;", "report", "eventName", "", "monitorCode", "", "monitorMessage", "monitorDomain", ReportCardMonitorPlugin.CATEGORIES, "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "jsonToMap", "jsonObject", "Lcom/alibaba/fastjson/JSONObject;", "Companion", "CardMonitorReportRequestModel", "CardMonitorReportResponseModel", "MonitorEventsItemModel", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ReportCardMonitorPlugin extends OPPlugin {
    public static final String CARD_MONITOR_REPORT = "reportCardMonitor";
    public static final String CATEGORIES = "categories";
    public static final a Companion = null;
    public static final String EVENT_NAME = "event_name";
    public static final String MONITOR_CODE = "monitor_code";
    public static final String MONITOR_DOMAIN = "monitor_domain";
    public static final String MONITOR_MESSAGE = "monitor_message";
    public static final String TAG = "ReportCardMonitorPlugin";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/larksuite/component/card/plugin/ReportCardMonitorPlugin$CardMonitorReportRequestModel;", "Lcom/larksuite/framework/apiplugin/common/LKBaseRequestModel;", "<init>", "()V", "monitorEvents", "Lcom/alibaba/fastjson/JSONArray;", "getMonitorEvents", "()Lcom/alibaba/fastjson/JSONArray;", "setMonitorEvents", "(Lcom/alibaba/fastjson/JSONArray;)V", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class CardMonitorReportRequestModel extends LKBaseRequestModel {

        @JSONField(name = "monitorEvents")
        @LKRequiredParam
        private JSONArray monitorEvents;

        public CardMonitorReportRequestModel() {
        }

        public final JSONArray getMonitorEvents() {
            return this.monitorEvents;
        }

        public final void setMonitorEvents(JSONArray r1) {
            this.monitorEvents = r1;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larksuite/component/card/plugin/ReportCardMonitorPlugin$CardMonitorReportResponseModel;", "Lcom/larksuite/framework/apiplugin/common/LKBaseResponseModel;", "<init>", "()V", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class CardMonitorReportResponseModel extends LKBaseResponseModel {
        public CardMonitorReportResponseModel() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larksuite/component/card/plugin/ReportCardMonitorPlugin$MonitorEventsItemModel;", "Ljava/io/Serializable;", "<init>", "()V", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class MonitorEventsItemModel implements Serializable {
        public MonitorEventsItemModel() {
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ReportCardMonitorPlugin() {
    }

    private final HashMap<String, Object> jsonToMap(JSONObject r5) {
        HashMap<String, Object> r0 = new HashMap();
        if (r5 != null) goto L5;
    L11:
        return r0;
    L5:
        if (r5.size() <= 0) goto L11;
        Iterator r1 = r5.keySet().iterator();
    L9:
        if (r1.hasNext() == false) goto L11;
        String r2 = (String) r1.next();
        r0.put(r2, r5.get(r2));
        goto L9
    }

    private final void monitorEvents(JSONArray r12, j18.f<CardMonitorReportResponseModel> r13) {
        if (r12 != null) goto L5;
    L29:
        Log.i(TAG, "monitor events is empty");
        r13.callback(new CardMonitorReportResponseModel());
        return;
    L5:
        if (r12.size() <= 0) goto L29;
        int r1 = r12.size();
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L27;
        JSONObject r3 = r12.getJSONObject(r2);
        if (r3 == null) goto L26;
        String r6 = r3.getString(EVENT_NAME);
        HashMap<String, Object> r10 = jsonToMap(r3.getJSONObject(CATEGORIES));
        Object r4 = r10.get(MONITOR_CODE);
        if ((r4 instanceof Integer) == false) goto L14;
        Integer r5 = (Integer) r4;
    L15:
        Object r7 = r10.get(MONITOR_MESSAGE);
        if ((r7 instanceof String) == false) goto L18;
        String r8 = (String) r7;
    L19:
        Object r9 = r10.get(MONITOR_DOMAIN);
        if ((r9 instanceof String) == false) goto L22;
        String r11 = (String) r9;
    L23:
        if (r5 == null) goto L25;
        int r14 = r5.intValue();
        Intrinsics.checkNotNull(r6);
        report(r6, r14, r8, r11, r10);
        goto L26
    L25:
        Log.i(TAG, "monitorCode is null");
        goto L26
    L22:
        r11 = null;
        goto L23
    L18:
        r8 = null;
        goto L19
    L14:
        r5 = null;
    L26:
        r2 = r2 + 1;
        goto L8
    L27:
        r13.callback(new CardMonitorReportResponseModel());
    }

    @LKPluginFunction(async = true, eventName = {CARD_MONITOR_REPORT})
    public final void cardMonitorReport(LKEvent r1, CardMonitorReportRequestModel r2, j18.f<CardMonitorReportResponseModel> r3) {
        Intrinsics.checkNotNullParameter(r3, "invokeCallback");
        if (r2 == null) goto L5;
        JSONArray r4 = r2.getMonitorEvents();
    L6:
        monitorEvents(r4, r3);
        return;
    L5:
        r4 = null;
        goto L6
    }

    private final void report(String r3, int r4, String r5, String r6, HashMap<String, Object> r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        if (r7.size() != 0) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r6) == false) goto L9;
        ncb.c r8 = new ncb.c(r4, OPMonitorLevel.NORMAL, r5);
    L10:
        fyb.e r9 = com.larksuite.component.card.monitor.b.a;
        Intrinsics.checkNotNullParameter(r3, "name");
        new com.larksuite.component.card.monitor.b(r3, r8, 1).addMap(r7).flush();
        return;
    L9:
        r8 = new OPMonitorCode(r6, r4, OPMonitorLevel.NORMAL, r5);
        goto L10
    }
}

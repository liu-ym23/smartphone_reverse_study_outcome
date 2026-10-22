package com.bytedance.android.live.saas.middleware.middlelayer;

import android.text.TextUtils;
import com.bytedance.android.live.base.BaseServices;
import com.bytedance.android.livehostapi.platform.IHostMonitor;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.common.utility.Logger;
import com.bytedance.crash.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import wm0.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u001a\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b;\u0010<J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J(\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004H\u0002J2\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u001c\u0010\u0013\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0007H\u0016JH\u0010\u001d\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\u001f\u001a\u00020\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\u001f\u001a\u00020\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010!\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010!\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010$\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010 \u001a\u00020#H\u0016J$\u0010%\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010 \u001a\u00020#H\u0016J$\u0010&\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J.\u0010*\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010\u00042\b\u0010(\u001a\u0004\u0018\u00010\u00042\b\u0010)\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010+\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010+\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010 \u001a\u00020#H\u0016J$\u0010,\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010 \u001a\u00020#H\u0016J$\u0010-\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010 \u001a\u00020#H\u0016JH\u0010/\u001a\u00020\r2\u0006\u0010.\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0016J,\u00100\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J$\u00102\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u00101\u001a\u0004\u0018\u00010\u0004H\u0016R\u001a\u00103\u001a\u00020\u00078\u0006X\u0086D¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001a\u00107\u001a\u00020\u00158\u0006X\u0086D¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:¨\u0006="}, d2 = {"Lcom/bytedance/android/live/saas/middleware/middlelayer/MonitorServiceImpl;", "Lwm0/b;", "Lcom/bytedance/android/livehostapi/platform/IHostMonitor;", "monitor", "Lorg/json/JSONObject;", "extra", "generateFinalExtra", "", "method", "key", "", "status", "logExtr", "", "beforeMonitor", Constants.Keys.duration, "", "t", Constants.OperatorKey.MSG, "ensureNotReachHere", "serviceName", "", "isNotHitSampled", "", "sendTime", "sendUrl", "sendIp", "traceCode", "extJson", "monitorApiError", "logType", "monitorCommonLog", "value", "monitorDebugReal", "type", "", "monitorDirectOnCount", "monitorDirectOnTimer", "monitorDuration", "category", "metric", "extraLog", "monitorEvent", "monitorOnCount", "monitorOnStore", "monitorOnTimer", "sendDuration", "monitorSLA", "monitorStatusAndDuration", "logExtra", "monitorStatusRate", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "DEBUG", "Z", "getDEBUG", "()Z", "<init>", "()V", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class MonitorServiceImpl implements b {
    private final boolean DEBUG;
    private final String TAG;

    public boolean isNotHitSampled(String r2) {
        Intrinsics.checkNotNullParameter(r2, "serviceName");
        return false;
    }

    private final IHostMonitor monitor() {
        return (IHostMonitor) BaseServices.as(IHostMonitor.class);
    }

    public MonitorServiceImpl() {
        this.TAG = "LiveSlardarMonitor";
    }

    public final boolean getDEBUG() {
        return this.DEBUG;
    }

    public final String getTAG() {
        return this.TAG;
    }

    private final JSONObject generateFinalExtra(JSONObject r4) {
        JSONObject r0 = new JSONObject();
        r0.put("tag", "ttlive_sdk");     // Catch: JSONException -> L7
        r0.put("ttlive_sdk_version", String.valueOf(4210));     // Catch: JSONException -> L7
        if (r4 == null) goto L9;
        r0.put("extra", r4);     // Catch: JSONException -> L7
    L9:
        return r0;
    L7:
        e = move-exception;
        Logger.e(this.TAG, e.getMessage());
        goto L9
    }

    public void monitorDebugReal(String r2) {
        IHostMonitor r0 = monitor();
        if (r0 == null) goto L6;
        r0.monitorDebugReal(r2);
        return;
    }

    public void ensureNotReachHere(Throwable r1, String r2) {
        d.d(r1, r2);
    }

    public void monitorCommonLog(String r2, JSONObject r3) {
        if (r3 != null) goto L4;
        r3 = new JSONObject();
    L4:
        IHostMonitor r0 = monitor();
        if (r0 == null) goto L8;
        r0.monitorCommonLog(r2, r3);
        return;
    }

    public void monitorDebugReal(String r2, String r3) {
        IHostMonitor r0 = monitor();
        if (r0 == null) goto L6;
        r0.monitorDebugReal(r2, r3);
        return;
    }

    public void monitorOnCount(String r2, String r3) {
        IHostMonitor r0 = monitor();
        if (r0 == null) goto L6;
        r0.monitorOnCount(r2, r3);
        return;
    }

    public void monitorCommonLog(String r2, String r3, JSONObject r4) {
        if (r4 != null) goto L14;
        r4 = new JSONObject();
    L14:
    L8:
        e = move-exception;
        Logger.e(this.TAG, e.getMessage());
    L10:
        IHostMonitor r5 = monitor();
        if (r5 == null) goto L16;
        r5.monitorCommonLog(r2, r4);
        return;
    L16:
        return;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L10;
        r4.put("service", r3);     // Catch: JSONException -> L8
        goto L10
    }

    public void monitorDirectOnCount(String r2, String r3, float r4) {
        IHostMonitor r0 = monitor();
        if (r0 == null) goto L6;
        r0.monitorDirectOnCount(r2, r3, r4);
        return;
    }

    public void monitorDirectOnTimer(String r2, String r3, float r4) {
        IHostMonitor r0 = monitor();
        if (r0 == null) goto L6;
        r0.monitorDirectOnTimer(r2, r3, r4);
        return;
    }

    public void monitorDuration(String r2, JSONObject r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r2, "serviceName");
        IHostMonitor r0 = monitor();
        if (r0 == null) goto L6;
        r0.monitorDuration(r2, r3, r4);
        return;
    }

    public void monitorOnCount(String r2, String r3, float r4) {
        IHostMonitor r0 = monitor();
        if (r0 == null) goto L6;
        r0.monitorOnCount(r2, r3, r4);
        return;
    }

    public void monitorOnStore(String r2, String r3, float r4) {
        IHostMonitor r0 = monitor();
        if (r0 == null) goto L6;
        r0.monitorOnStore(r2, r3, r4);
        return;
    }

    public void monitorOnTimer(String r2, String r3, float r4) {
        IHostMonitor r0 = monitor();
        if (r0 == null) goto L6;
        r0.monitorOnTimer(r2, r3, r4);
        return;
    }

    public void monitorStatusRate(String r2, int r3, JSONObject r4) {
        IHostMonitor r0 = monitor();
        if (r0 == null) goto L6;
        r0.monitorStatusRate(r2, r3, r4);
        return;
    }

    private final void beforeMonitor(String r7, String r8, int r9, JSONObject r10) {
        beforeMonitor(r7, r8, r9, null, r10);
    }

    public void monitorEvent(String r2, JSONObject r3, JSONObject r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r2, "serviceName");
        IHostMonitor r0 = monitor();
        if (r0 == null) goto L6;
        r0.monitorEvent(r2, r3, r4, r5);
        return;
    }

    public void monitorStatusAndDuration(String r8, int r9, JSONObject r10, JSONObject r12) {
        Intrinsics.checkNotNullParameter(r8, "serviceName");
        JSONObject r13 = generateFinalExtra(r12);
        beforeMonitor("monitorStatusAndDuration", r8, r9, r10, r13);
        IHostMonitor r0 = monitor();
        if (r0 == null) goto L6;
        r0.monitorStatusAndDuration(r8, r9, r10, r13);
        return;
    }

    private final void beforeMonitor(String r3, String r4, int r5, JSONObject r6, JSONObject r7) {
        if (this.DEBUG == false) goto L6;
        Logger.e(this.TAG, "method = " + r3 + ",key = " + r4 + ",status = " + r5 + ",duration = " + r6 + ",logJson = " + r7);
        return;
    }

    public void monitorApiError(long r12, long r13, String r15, String r16, String r17, int r18, JSONObject r19) {
        IHostMonitor r0 = monitor();
        if (r0 == null) goto L6;
        r0.monitorApiError(r12, r13, r15, r16, r17, r18, r19);
        return;
    }

    public void monitorSLA(long r12, long r13, String r15, String r16, String r17, int r18, JSONObject r19) {
        IHostMonitor r0 = monitor();
        if (r0 == null) goto L6;
        r0.monitorSLA(r12, r13, r15, r16, r17, r18, r19);
        return;
    }
}

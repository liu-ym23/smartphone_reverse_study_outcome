package com.bytedance.lynx.service.memory.monitor;

import android.content.Context;
import androidx.annotation.AnyThread;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import cg.a;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.lynx.tasm.LynxEnv;
import com.ss.android.common.lib.AppLogNewUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import ko.c;
import ko.n;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mm.h;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001 B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0017¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006H\u0017¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/bytedance/lynx/service/memory/monitor/LynxMemoryMonitorService;", "Lko/c;", "<init>", "()V", "Lko/n;", "data", "Lorg/json/JSONObject;", "lynxInfoData", "imageInfoData", "imageMetric", LynxMonitorService.KEY_TIME_METRICS, "", "innerFormatData", "(Lko/n;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;)V", "formatDataForDevtool", "(Lko/n;)Lorg/json/JSONObject;", "formatDataForAppLog", "reportMemoryUsage", "(Lko/n;)V", "Landroid/content/Context;", "applicationContext", "startTrackMemoryAllocation", "(Landroid/content/Context;)V", "", "isBaseline", "payload", "dumpMemoryAllocationReport", "(ZLorg/json/JSONObject;)V", "", "event_name", "Ljava/lang/String;", "", "Lcg/a;", "reportTargetHandlers", "Ljava/util/List;", "LynxService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LynxMemoryMonitorService implements c {
    public static final LynxMemoryMonitorService INSTANCE = null;
    public static final String event_name = "lynx_allocate_memory";
    private static final List<a> reportTargetHandlers = null;

    static {
        INSTANCE = new LynxMemoryMonitorService();
        reportTargetHandlers = CollectionsKt.listOf(new a[]{new a(0), new a(1)});
    }

    private LynxMemoryMonitorService() {
    }

    public static final /* synthetic */ JSONObject access$formatDataForAppLog(LynxMemoryMonitorService r5, n r10) {
        return r5.formatDataForAppLog(r10);
    }

    public static final /* synthetic */ JSONObject access$formatDataForDevtool(LynxMemoryMonitorService r5, n r10) {
        return r5.formatDataForDevtool(r10);
    }

    private final JSONObject formatDataForAppLog(n r10) {
        JSONObject r11 = new JSONObject();
        JSONObject r12 = new JSONObject();
        innerFormatData(r10, r11, r12, new JSONObject(), new JSONObject());
        r11.put("image_info", r12.toString());
        r11.put("res_url", r10.f18722o);
        r11.put(LynxMonitorService.KEY_MEMORY_COST, Float.valueOf(r10.f18716i));
        return r11;
    }

    private final JSONObject formatDataForDevtool(n r11) {
        JSONObject r10 = new JSONObject();
        JSONObject r12 = new JSONObject();
        JSONObject r13 = new JSONObject();
        JSONObject r14 = new JSONObject();
        innerFormatData(r11, r10, r12, r13, r14);
        r10.put("image_info", r12);
        r10.put(LynxMonitorService.KEY_METRIC, r13);
        r10.put(LynxMonitorService.KEY_TIME_METRICS, r14);
        r10.put("res_url", r11.f18722o);
        r10.put(LynxMonitorService.KEY_IMAGE_URL, r11.f18722o);
        r10.put(LynxMonitorService.KEY_MEMORY_COST_FROM, Float.valueOf(r11.f18716i));
        r10.put("is_memory", false);
        return r10;
    }

    private final void innerFormatData(n r10, JSONObject r11, JSONObject r12, JSONObject r13, JSONObject r14) {
        r11.put("type", r10.f18715h);
        String r15 = r10.e;
        if (r15 == null) goto L5;
        r11.put("session_id", r15);
    L5:
        long r5 = r10.f18713b;
        r11.put("timestamp", String.valueOf(r5));
        String r16 = r10.f;
        if (r16 == null) goto L8;
        r11.put("phase", r16);
    L8:
        String r17 = r10.g;
        if (r17 == null) goto L11;
        r11.put("template_url", r17);
        r13.put("url", r17);
    L11:
        r12.put(LynxMonitorService.KEY_IMAGE_URL, r10.f18722o);
        r12.put(LynxMonitorService.KEY_MEMORY_COST_FROM, r10.f18716i);
        long r18 = r10.f18717j;
        long r19 = -1;
        if (r18 > 0) goto L15;
        r18 = -1;
    L15:
        r13.put("viewWidth", r18);
        long r20 = r10.f18718k;
        if (r20 > 0) goto L19;
        r20 = -1;
    L19:
        r13.put("viewHeight", r20);
        long r21 = r10.f18719l;
        if (r21 > 0) goto L23;
        r21 = -1;
    L23:
        r13.put("width", r21);
        long r22 = r10.f18720m;
        if (r22 <= 0) goto L26;
        r19 = r22;
    L26:
        r13.put("height", r19);
        String r23 = r10.f18721n;
        if (r23 == null) goto L29;
        r13.put("config", r23);
    L29:
        r13.put("flattenAnim", r10.f18724q);
        r12.put(LynxMonitorService.KEY_METRIC, r13);
        r12.put(LynxMonitorService.KEY_SUCCESS_RATE, r10.f18723p);
        r14.put("fetchTime", r10.f18712a / 1000.0d);
        r14.put("completeTime", r10.f18714c / 1000.0d);
        r14.put("fetchTimeStamp", r10.d / 1000.0d);
        r14.put("finishTimeStamp", r5 / 1000.0d);
        r12.put(LynxMonitorService.KEY_TIME_METRICS, r14);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @WorkerThread
    public void dumpMemoryAllocationReport(boolean r5, JSONObject r10) {
    }

    @Override // com.lynx.tasm.service.IServiceProvider
    @NonNull
    public /* bridge */ /* synthetic */ Class getServiceClass() {
        return c.class;
    }

    @Override // ko.c
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @WorkerThread
    public void reportMemoryUsage(n r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        Iterator<T> r10 = reportTargetHandlers.iterator();
    L4:
        if (r10.hasNext() == false) goto L22;
        a r11 = (a) r10.next();
        switch(r11.f1185a) {
            case 0: goto L8;
            default: goto L7;
        };
    L7:
        boolean r12 = LynxEnv.inst().enableImageMemoryReport();
    L9:
        if (r12 == false) goto L4;
        switch(r11.f1185a) {
            case 0: goto L13;
            default: goto L12;
        };
    L12:
        Intrinsics.checkNotNullParameter(r5, "data");
        JSONObject r13 = access$formatDataForAppLog(INSTANCE, r5);
    L15:
        switch(r11.f1185a) {
            case 0: goto L17;
            default: goto L16;
        };
    L17:
        Intrinsics.checkNotNullParameter(r13, "data");
        Iterator r14 = ((CopyOnWriteArrayList) h.f20114a.f17073b).iterator();
        if (r14.hasNext() == false) goto L4;
        throw mn.h.c(r14);
    L16:
        Intrinsics.checkNotNullParameter(r13, "data");
        AppLogNewUtils.onEventV3(event_name, r13);
        goto L4
    L13:
        Intrinsics.checkNotNullParameter(r5, "data");
        r13 = access$formatDataForDevtool(INSTANCE, r5);
        goto L15
    L8:
        r12 = !((CopyOnWriteArrayList) h.f20114a.f17073b).isEmpty();
        goto L9
    }

    @AnyThread
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void startTrackMemoryAllocation(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "applicationContext");
    }
}

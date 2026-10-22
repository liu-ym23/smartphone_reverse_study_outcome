package com.bytedance.lynx.service.reporter;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import co.e;
import com.bytedance.lynx.service.reporter.performance.b;
import com.bytedance.lynx.service.reporter.performance.g;
import com.bytedance.lynx.service.reporter.performance.h;
import com.lynx.tasm.base.TraceEvent;
import com.ss.android.common.lib.AppLogNewUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ko.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJI\u0010\u0011\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\r2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcom/bytedance/lynx/service/reporter/LynxEventReporterService;", "Lko/a;", "<init>", "()V", "Landroid/content/Context;", "context", "", "onInitialize", "(Landroid/content/Context;)V", "", "eventName", "", "instanceId", "", "", "props", "extraData", "onReportEvent", "(Ljava/lang/String;ILjava/util/Map;Ljava/util/Map;)V", "Lorg/json/JSONObject;", "jsonObject", "convertBooleanToInt", "(Lorg/json/JSONObject;)Lorg/json/JSONObject;", "Lco/e;", "entry", "onPerformanceEvent", "(Lco/e;)V", "TAG", "Ljava/lang/String;", "PERF_ENTRY_EVENT_NAME_PREFIX", "Lcom/bytedance/lynx/service/model/b;", "lynxServiceConfig", "Lcom/bytedance/lynx/service/model/b;", "", "Lcom/bytedance/lynx/service/reporter/performance/a;", "processorList", "Ljava/util/List;", "Lcom/bytedance/lynx/service/reporter/performance/b;", "defaultProcessor", "Lcom/bytedance/lynx/service/reporter/performance/b;", "LynxService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LynxEventReporterService implements a {
    public static final LynxEventReporterService INSTANCE = null;
    public static final String PERF_ENTRY_EVENT_NAME_PREFIX = "lynxsdk_performance_entry_";
    public static final String TAG = "LynxEventReporterService";
    private static b defaultProcessor;
    private static com.bytedance.lynx.service.model.b lynxServiceConfig;
    private static List<com.bytedance.lynx.service.reporter.performance.a> processorList;

    static {
        INSTANCE = new LynxEventReporterService();
        ArrayList r5 = new ArrayList();
        processorList = r5;
        defaultProcessor = new b();
        r5.add(new h());
        processorList.add(new g());
    }

    private LynxEventReporterService() {
    }

    public final JSONObject convertBooleanToInt(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "jsonObject");
        JSONObject r10 = new JSONObject();
        Iterator<String> r11 = r5.keys();
    L4:
        if (r11.hasNext() == false) goto L9;
        String r12 = r11.next();
        Object r13 = r5.get(r12);
        if ((r13 instanceof Boolean) == true) goto L7;
        r10.put(r12, r13);
        goto L4
    L7:
        r10.put(r12, ((Boolean) r13).booleanValue() ? 1 : 0);
        goto L4
    L9:
        return r10;
    }

    @Override // com.lynx.tasm.service.IServiceProvider
    @NonNull
    public /* bridge */ /* synthetic */ Class getServiceClass() {
        return a.class;
    }

    @Override // com.lynx.tasm.service.IServiceProvider
    public void onInitialize(Context r5) {
        super.onInitialize(r5);
        Iterator<com.bytedance.lynx.service.reporter.performance.a> r10 = processorList.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().onInitialize(r5);
        goto L4
    }

    @Override // ao.a
    public void onPerformanceEvent(e r5) {
        Intrinsics.checkNotNullParameter(r5, "entry");
        String r10 = PERF_ENTRY_EVENT_NAME_PREFIX + r5.f1227b;
        Iterator<com.bytedance.lynx.service.reporter.performance.a> r11 = processorList.iterator();
        boolean r12 = false;
    L4:
        if (r11.hasNext() == false) goto L12;
        com.bytedance.lynx.service.reporter.performance.a r13 = r11.next();
        if (r13.a(r5) == false) goto L4;
        Map r14 = r13.b(r5);
        if (r14 == null) goto L11;
        AppLogNewUtils.onEventV3(r10, INSTANCE.convertBooleanToInt(new JSONObject(r14)));
    L11:
        r12 = true;
        goto L4
    L12:
        if (r12 == false) goto L15;
        return;
    L15:
        if (defaultProcessor.a(r5) == true) goto L17;
        return;
    L17:
        AppLogNewUtils.onEventV3(r10, INSTANCE.convertBooleanToInt(new JSONObject(defaultProcessor.b(r5))));
    }

    @Override // pn.a
    public void onReportEvent(String r5, int r10, Map<String, ? extends Object> r11, Map<String, ? extends Object> r12) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        Intrinsics.checkNotNullParameter(r11, "props");
        TraceEvent.c("LynxEventReporterServiceProxy.onReportEvent");
        LinkedHashMap r13 = new LinkedHashMap();
        if (r12 == null) goto L5;
        r13.putAll(r12);
    L5:
        r13.putAll(r11);
        AppLogNewUtils.onEventV3(r5, convertBooleanToInt(new JSONObject(r13)));
        TraceEvent.a(0, "LynxEventReporterServiceProxy.onReportEvent");
    }
}

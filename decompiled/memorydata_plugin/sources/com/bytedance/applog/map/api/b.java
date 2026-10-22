package com.bytedance.applog.map.api;

import android.view.View;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.entity.CrashBody;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\tJ\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\tJ.\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ \u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00012\b\u0010\u0018\u001a\u0004\u0018\u00010\rJ\u0018\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00012\b\u0010\u0018\u001a\u0004\u0018\u00010\rJ\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\u001e\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0016\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020%J\u001e\u0010&\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\rJ\u0016\u0010(\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*J\u001e\u0010+\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\rJ\u001e\u0010-\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\rJ\u001e\u0010/\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\rJ\u001e\u00101\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\rJ\u001e\u00101\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\rJ\u001e\u00101\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u00105\u001a\u0002062\u0006\u00104\u001a\u00020\rJ\u0010\u00107\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u00108\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0006\u00109\u001a\u00020\u0010J\u0006\u0010:\u001a\u00020\u0010J\u0010\u0010;\u001a\u00020\u00102\b\b\u0002\u0010<\u001a\u00020\rJ\u0016\u0010=\u001a\u00020\u00102\u0006\u0010<\u001a\u00020\r2\u0006\u0010>\u001a\u00020?R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006@"}, d2 = {"Lcom/bytedance/applog/map/api/EventMap;", "", "()V", "service", "Lcom/bytedance/applog/map/api/EventMapService;", "getService$annotations", "getService", "()Lcom/bytedance/applog/map/api/EventMapService;", "addMapToEventParams", "Lorg/json/JSONObject;", "view", "Landroid/view/View;", "triggerTag", "", TrackerImpl.PARAMS, "appendMapToEventParams", "", "", "createService", "endViewClick", "enterPage", AILabCheckPermissionTask.KEY_SOURCE, "Lcom/bytedance/applog/map/api/IdSource;", "obj", LocationMonitorConst.TAG, "exitPage", "getTriggerConfig", "Lcom/bytedance/applog/map/api/MapConfig$MapTriggerConfig;", "getUuid", "Lcom/bytedance/applog/map/api/MapUuid;", "ignoreRootView", CommonConsts.APM_INNER_EVENT_COST_INIT, "app", "Landroid/app/Application;", "config", "Lcom/bytedance/applog/map/api/MapConfig;", "isEnabled", "", "setElementId", "eid", "setElementInfoProvider", "provider", "Lcom/bytedance/applog/map/api/ElementInfoProvider;", "setElementPageId", "pageId", "setElementPagePath", "pagePath", "setElementPath", "path", "setPid", "activity", "Landroid/app/Activity;", CrashBody.PID, "fragment", "Landroidx/fragment/app/Fragment;", "setViewHasClickListener", "startViewClick", "touchDown", "touchUp", "trackCurrentPage", "flag", "trackPageWithDelay", "delay", "", "map-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f1663a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final c f1664b = null;

    static {
        b r0 = new b();
        f1663a = r0;
        f1664b = r0.b();
    }

    private b() {
    }

    public static final c a() {
        return f1664b;
    }

    private final c b() {
    L16:
        th = move-exception;
        com.bytedance.applog.log.a r2 = d.f1665a.a();
        if (r2 == null) goto L21;
        r2.a("EventMap", th, (Function0) ZeusTransformUtils.preCheckCast(EventMap$createService$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
    L21:
        return (c) ZeusTransformUtils.preCheckCast(a.f1662a, c.class, "com.obric.memorydata.plugin");
    L23:
        Constructor r1 = ZeusTransformUtils.forName("com.bytedance.applog.map.impl.EventMapServiceImpl", "com.obric.memorydata.plugin").getDeclaredConstructor(new Class[0]);     // Catch: Throwable -> L11
        r1.setAccessible(true);     // Catch: Throwable -> L11
        Object r3 = r1.newInstance(new Object[0]);     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        return (c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.memorydata.plugin");
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.applog.map.api.EventMapService");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        com.bytedance.applog.log.a r4 = d.f1665a.a();     // Catch: Throwable -> L16
        if (r4 == null) goto L21;
        r4.a("EventMap", th, (Function0) ZeusTransformUtils.preCheckCast(EventMap$createService$1.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L16
        goto L21
    }

    public final JSONObject a(View r1, String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r1, "view");
        c r0 = f1664b;
        if (r2 != null) goto L6;
        r2 = "custom";
    L6:
        return r0.a(TuplesKt.to(r2, r1), r3);
    }

    public final JSONObject a(JSONObject r2) {
        return f1664b.a(null, r2);
    }
}

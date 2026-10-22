package com.bytedance.applog.map.api;

import android.view.View;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.entity.CrashBody;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import kotlin.Metadata;
import kotlin.Pair;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016J4\u0010\n\u001a\u00020\u000b2\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\bH\u0016J \u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J\u0018\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J \u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\bH\u0016J\b\u0010\u001d\u001a\u00020\u000bH\u0016J \u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u0007H\u0016J\u0018\u0010 \u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"H\u0016J \u0010#\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u0007H\u0016J \u0010%\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u0007H\u0016J \u0010'\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u0007H\u0016J \u0010)\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0007H\u0016J \u0010)\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u0007H\u0016J \u0010)\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010-\u001a\u00020.2\u0006\u0010,\u001a\u00020\u0007H\u0016J\u0010\u0010/\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u0010\u00100\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\bH\u0016J\b\u00101\u001a\u00020\u000bH\u0016J\b\u00102\u001a\u00020\u000bH\u0016J\u0010\u00103\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u0007H\u0016J\u0018\u00105\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u00072\u0006\u00106\u001a\u000207H\u0016¨\u00068"}, d2 = {"Lcom/bytedance/applog/map/api/EmptyEventMapServiceImpl;", "Lcom/bytedance/applog/map/api/EventMapService;", "()V", "addMapToEventParams", "Lorg/json/JSONObject;", "triggerView", "Lkotlin/Pair;", "", "Landroid/view/View;", TrackerImpl.PARAMS, "appendMapToEventParams", "", "", "", "enabled", "", "endViewClick", "view", "enterPage", AILabCheckPermissionTask.KEY_SOURCE, "Lcom/bytedance/applog/map/api/IdSource;", "obj", LocationMonitorConst.TAG, "exitPage", "getMapByView", "Lcom/bytedance/applog/map/api/ToJsonMap;", "getUuid", "Lcom/bytedance/applog/map/api/MapUuid;", "ignoreRootView", CommonConsts.APM_INNER_EVENT_COST_INIT, "setElementId", "eid", "setElementInfoProvider", "provider", "Lcom/bytedance/applog/map/api/ElementInfoProvider;", "setElementPageId", "pageId", "setElementPagePath", "pagePath", "setElementPath", "path", "setPid", "activity", "Landroid/app/Activity;", CrashBody.PID, "fragment", "Landroidx/fragment/app/Fragment;", "setViewHasClickListener", "startViewClick", "touchDown", "touchUp", "trackCurrentPage", "flag", "trackPageWithDelay", "delay", "", "map-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f1662a = null;

    static {
        f1662a = new a();
    }

    private a() {
    }

    @Override // com.bytedance.applog.map.api.c
    public JSONObject a(Pair<String, ? extends View> r1, JSONObject r2) {
        return r2;
    }
}

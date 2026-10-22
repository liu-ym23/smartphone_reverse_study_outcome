package com.bytedance.lynx.service.trail;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.k;
import com.lynx.tasm.l0;
import com.lynx.tasm.service.ILynxTrailService;
import com.lynx.tasm.service.ILynxTrailServiceExtension;
import com.lynx.tasm.t;
import com.lynx.tasm.u;
import com.lynx.tasm.utils.b;
import fg.c;
import gg.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import m.f0;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\bJ\u0019\u0010\u0017\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\fJ\u001d\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b&\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/bytedance/lynx/service/trail/LynxTrailService;", "Lcom/lynx/tasm/service/ILynxTrailService;", "Lcom/lynx/tasm/service/ILynxTrailServiceExtension;", "<init>", "()V", "", STGroup.DICT_KEY, "stringValueForTrailKeyFromLibra", "(Ljava/lang/String;)Ljava/lang/String;", "stringValueForTrailKeyFromSettings", "", "objectValueForTrailKeyFromSettings", "(Ljava/lang/String;)Ljava/lang/Object;", "Lgg/a;", "adapter", "", "setABExperimentAdapter", "(Lgg/a;)V", "Landroid/content/Context;", "context", "onInitialize", "(Landroid/content/Context;)V", "stringValueForTrailKey", "objectValueForTrailKey", "jsonString", "", "time", "setSettingsWithTime", "(Ljava/lang/String;J)V", "", "getAllValues", "()Ljava/util/Map;", "Lcom/lynx/tasm/l0;", "builder", "parseLynxViewBuilder", "(Lcom/lynx/tasm/l0;)V", "TAG", "Ljava/lang/String;", "TRACE_TRAIL_PROXY_STRING_VALUE_FOR_EXPERIMENT_KEY", "abExperimentAdapter", "Lgg/a;", "LynxService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LynxTrailService implements ILynxTrailService, ILynxTrailServiceExtension {
    public static final LynxTrailService INSTANCE = null;
    private static final String TAG = "LynxTrailService";
    public static final String TRACE_TRAIL_PROXY_STRING_VALUE_FOR_EXPERIMENT_KEY = "LynxTrailServiceProxy.stringValueForExperimentKey";
    private static a abExperimentAdapter;

    static {
        INSTANCE = new LynxTrailService();
    }

    private LynxTrailService() {
    }

    private final Object objectValueForTrailKeyFromSettings(String r5) {
        c r10 = c.a();
        if (r10.f16898b == null) goto L8;
        ReentrantReadWriteLock r11 = r10.f16899c;
        r11.readLock().lock();
        Object r12 = r10.f16898b.get("lynx_common");
        r11.readLock().unlock();
        if ((r12 instanceof Map) == true) goto L7;
        return null;
    L7:
        return ((Map) r12).get(r5);
    L8:
        return null;
    }

    private final String stringValueForTrailKeyFromLibra(String r5) {
        LynxLog.b(2, TAG, b.j("get ExperimentValue: ", null, ", for key: ", r5));
        return null;
    }

    private final String stringValueForTrailKeyFromSettings(String r5) {
        c r10 = c.a();
        if (r10.f16898b == null) goto L19;
        ReentrantReadWriteLock r11 = r10.f16899c;
        r11.readLock().lock();
        Object r12 = r10.f16898b.get("lynx_common");
        r11.readLock().unlock();
        if ((r12 instanceof Map) == false) goto L19;
        Object r13 = ((Map) r12).get(r5);
        if ((r13 instanceof String) == false) goto L11;
        return (String) r13;
    L11:
        if ((r13 instanceof Integer) == true) goto L18;
        if ((r13 instanceof Boolean) == true) goto L18;
        LynxLog.b(4, "LynxSettingsManager", "Unknown value type: " + r13);
        return null;
    L18:
        return r13.toString();
    L19:
        return null;
    }

    @Override // com.lynx.tasm.service.ILynxTrailService
    public Map<String, Object> getAllValues() {
        return c.b(c.a().e());
    }

    @Override // com.lynx.tasm.service.ILynxTrailService
    public Object objectValueForTrailKey(String r5) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        Object r10 = stringValueForTrailKeyFromLibra(r5);
        if (r10 != null) goto L5;
        r10 = objectValueForTrailKeyFromSettings(r5);
    L5:
        StringBuilder r11 = new StringBuilder("get objectValue: ");
        r11.append(r10);
        r11.append(", forTrailKey: ");
        r11.append(r5);
        r11.append(", valueType: ");
        if (r10 == null) goto L8;
        Object r12 = Reflection.getOrCreateKotlinClass(r10.getClass());
    L9:
        r11.append(r12);
        LynxLog.b(2, TAG, r11.toString());
        return r10;
    L8:
        r12 = "null";
        goto L9
    }

    @Override // com.lynx.tasm.service.IServiceProvider
    public void onInitialize(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        c r10 = c.a();
        if (r5 != null) goto L6;
        r10.getClass();
        return;
    L6:
        if (r10.f16897a != null) goto L25;
        TraceEvent.c("LynxSettingsManager.initialize");
        monitor-enter(r10);
    L12:
        th = move-exception;
        throw th;
    L10:
        if (r10.f16897a != null) goto L14;
        r10.d = r5;     // Catch: Throwable -> L12
        r10.f16897a = r5.getSharedPreferences("lynx_settings_manager_sp", 0);     // Catch: Throwable -> L12
        String r11 = r10.e();     // Catch: Throwable -> L12
    L15:
        monitor-exit(r10);     // Catch: Throwable -> L12
        HashMap r12 = c.b(r11);
        if (r12 == null) goto L19;
        r10.d(r12);
    L19:
        TraceEvent.a(0, "LynxSettingsManager.initialize");
        return;
    L14:
        r11 = null;
        goto L15
    }

    @Override // com.lynx.tasm.service.ILynxTrailServiceExtension
    public void parseLynxViewBuilder(l0 r10) {
        Intrinsics.checkNotNullParameter(r10, "builder");
        Intrinsics.checkNotNullParameter(r10, "builder");
        r10.getClass();
        HashMap r11 = r10.f10917y;
        if (r11 == null) goto L68;
        TraceEvent.b(0, "LynxViewConfigProcessor.setConfig", r11);
        Iterator r12 = r11.entrySet().iterator();
    L6:
        if (r12.hasNext() == false) goto L40;
        Map.Entry r5 = (Map.Entry) r12.next();
        String r13 = (String) r5.getKey();
        String r14 = (String) r5.getValue();
        if (r13 == null) goto L6;
        if (r14 == null) goto L6;
        if (Intrinsics.areEqual(r13, "platform_config") == true) goto L14;
        if (Intrinsics.areEqual(r13, "enable_unified_pipeline") == true) goto L21;
        if (Intrinsics.areEqual(r13, "enable_js_group_thread") == true) goto L26;
        if (Intrinsics.areEqual(r13, "enable_mts_module") == false) goto L6;
        Boolean r15 = f0.e(r14);
        if (r15 == null) goto L6;
        r10.f10913u = r15.booleanValue();
        goto L6
    L26:
        Boolean r16 = f0.e(r14);
        if (r16 == null) goto L6;
        boolean r17 = r16.booleanValue();
        k r18 = r10.f10900c;
        u r19 = r18.f10894c;
        if (r19 != null) goto L32;
        r19 = null;
    L32:
        if (r19 != null) goto L34;
        r19 = new u(new t());
    L34:
        r19.e = r17;
        r18.f10894c = r19;
        goto L6
    L21:
        Boolean r20 = f0.e(r14);
        if (r20 == null) goto L6;
        r10.f = r20.booleanValue();
        goto L6
    L14:
        if (r10.f10917y != null) goto L17;
        r10.f10917y = new HashMap();
    L17:
        if (r10.f10917y.get(r13) != null) goto L6;
        r10.f10917y.put(r13, r14);
        goto L6
    L40:
        TraceEvent.a(0, "LynxViewConfigProcessor.setConfig");
        return;
    }

    public final void setABExperimentAdapter(a r5) {
        Intrinsics.checkNotNullParameter(r5, "adapter");
    }

    public final void setSettingsWithTime(String r5, long r10) {
        Intrinsics.checkNotNullParameter(r5, "jsonString");
        c r11 = c.a();
        r11.getClass();
        LynxLog.b(2, "LynxSettingsManager", "Lynx setSettings " + r5);
        JsonObject r12 = (JsonObject) c.e.fromJson(r5, JsonObject.class);     // Catch: Throwable -> L9 JsonParseException -> L11
        if (r12 != null) goto L6;
        return;
    L6:
        if (r12.isJsonObject() == false) goto L19;
        r11.c(r12, r10);     // Catch: Throwable -> L9 JsonParseException -> L11
    L21:
        return;
    L19:
        return;
    L11:
        e = move-exception;
        LynxLog.b(4, "LynxSettingsManager", "Lynx set settings exception " + e);
        return;
    L9:
        th = move-exception;
        LynxLog.b(4, "LynxSettingsManager", "Lynx settings unexpected exception " + th);
    }

    @Override // com.lynx.tasm.service.ILynxTrailService
    public String stringValueForTrailKey(String r5) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        String r10 = stringValueForTrailKeyFromLibra(r5);
        if (r10 != null) goto L5;
        r10 = stringValueForTrailKeyFromSettings(r5);
    L5:
        LynxLog.b(2, TAG, b.j("get stringValue: ", r10, ", forTrailKey: ", r5));
        return r10;
    }
}

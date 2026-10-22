package com.bytedance.apm.h;

import com.bytedance.apm.util.JsonUtils;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.apm6.perf.base.model.LogTypeName;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.services.slardar.config.IConfigManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c implements com.bytedance.services.slardar.config.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, Boolean> f1354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, Boolean> f1355b;
    private List<String> c;
    private List<String> d;
    private List<String> e;
    private Map<String, String> f;
    private volatile JSONObject g;

    /* JADX INFO: renamed from: com.bytedance.apm.h.c$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f1356a = null;

        static {
            f1356a = new c(null);
        }

        static /* synthetic */ c a() {
            return f1356a;
        }
    }

    private c() {
        this.f1354a = new ConcurrentHashMap();
        this.f1355b = new ConcurrentHashMap();
        this.f = new HashMap();
        LinkedList r0 = new LinkedList();
        this.c = r0;
        r0.addAll(Arrays.asList(new String[]{Scraps.BATTERY, "smooth", "cpu", SlardarSettingsConstants.PERF_KEY_DISK, SlardarSettingsConstants.PERF_KEY_MEMORY, "thread", "fd", "page_load", "page_load_trace", CommonConsts.APM_INNER_EVENT_COST_START, "start_trace", "traffic", "ui"}));
        ArrayList r1 = new ArrayList();
        this.d = r1;
        r1.add(SlardarSettingsConstants.PERF_KEY_ENABLE_UPLOAD);
        this.d.add("drop_enable_upload");
        this.d.add("serious_block_enable_upload");
        this.d.add("block_enable_upload");
        this.d.add("slow_method_enable_upload");
        LinkedList r2 = new LinkedList();
        this.e = r2;
        r2.add("enable_perf_data_collect");
        this.f.put(SlardarSettingsConstants.PERF_KEY_ENABLE_UPLOAD, "fps");
        this.f.put("drop_enable_upload", "fps_drop");
        this.f.put("block_enable_upload", LogTypeName.MONITOR_TYPE_BLOCK);
        this.f.put("slow_method_enable_upload", LogTypeName.MONITOR_TYPE_DROP_FRAME_STACK);
        this.f.put("serious_block_enable_upload", LogTypeName.MONITOR_TYPE_SERIOUS_BLOCK);
        ((IConfigManager) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IConfigManager.class), IConfigManager.class, "com.obric.memorydata.plugin")).registerConfigListener(this);
    }

    /* synthetic */ c(AnonymousClass1 r1) {
        this();
    }

    public static c a() {
        return a.a();
    }

    private void a(JSONObject r6) {
        JSONObject r7 = r6.optJSONObject(SlardarSettingsConstants.SETTING_PERFORMANCE_MODULES);
        if (r7 != null) goto L5;
        return;
    L5:
        Iterator<String> r0 = this.c.iterator();
    L7:
        if (r0.hasNext() == false) goto L29;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        JSONObject r3 = r7.optJSONObject(r1);
        if ("smooth".equals(r1) == true) goto L10;
        if (SlardarSettingsConstants.PERF_KEY_MEMORY.equals(r1) == false) goto L15;
        d(r3);
    L15:
        if (Scraps.BATTERY.equals(r1) == false) goto L18;
        e(r3);
    L18:
        if ("cpu".equals(r1) == false) goto L21;
        f(r3);
    L21:
        if ("start_trace".equals(r1) == false) goto L24;
        b(r3);
    L24:
        if (r3 == null) goto L28;
        if (r3.optInt(SlardarSettingsConstants.PERF_KEY_ENABLE_UPLOAD, 0) != 1) goto L28;
        this.f1354a.put(r1, true);
    L28:
        this.f1354a.put(r1, false);
        goto L7
    L10:
        c(r3);
        goto L7
    L29:
        this.g = JsonUtils.a(r7, "smooth", "scene_enable_upload");
    }

    private void b(JSONObject r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        Iterator<String> r0 = this.e.iterator();
    L6:
        if (r0.hasNext() == false) goto L15;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        Map<String, Boolean> r2 = this.f1355b;     // Catch: Exception -> L13
        boolean r3 = false;
        if (r7.optInt(r1, 0) != 1) goto L11;
        r3 = true;
    L11:
        r2.put(r1, Boolean.valueOf(r3));     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }

    private void c(JSONObject r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        Iterator<String> r0 = this.d.iterator();
    L6:
        if (r0.hasNext() == false) goto L15;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        Map<String, Boolean> r2 = this.f1355b;     // Catch: Exception -> L13
        String r3 = this.f.get(r1);     // Catch: Exception -> L13
        boolean r4 = false;
        if (r7.optInt(r1, 0) != 1) goto L11;
        r4 = true;
    L11:
        r2.put(r3, Boolean.valueOf(r4));     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }

    private void d(JSONObject r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        Map<String, Boolean> r3 = this.f1355b;
        boolean r1 = false;
        if (r4.optInt(LogTypeName.MEMORY_OBJECT_MONITOR, 0) != 1) goto L7;
        r1 = true;
    L7:
        r3.put(LogTypeName.MEMORY_OBJECT_MONITOR, Boolean.valueOf(r1));
    }

    private void e(JSONObject r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        Map<String, Boolean> r0 = this.f1355b;
        boolean r2 = false;
        if (r6.optInt("temperature_enable_upload", 0) != 1) goto L7;
        boolean r1 = true;
    L8:
        r0.put("temperature", Boolean.valueOf(r1));
        Map<String, Boolean> r5 = this.f1355b;
        if (r6.optInt("exception_enable_upload", 0) != 1) goto L11;
        r2 = true;
    L11:
        r5.put("battery_trace", Boolean.valueOf(r2));
        return;
    L7:
        r1 = false;
        goto L8
    }

    private void f(JSONObject r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        Map<String, Boolean> r2 = this.f1355b;
        boolean r1 = false;
        if (r3.optInt(CommonConsts.LOG_REPORT_TYPE_EXCEPTION, 0) != 1) goto L7;
        r1 = true;
    L7:
        r2.put(LogTypeName.MONITOR_TYPE_CPU_TRACE, Boolean.valueOf(r1));
    }

    public boolean a(String r2) {
        Boolean r1 = (Boolean) ZeusTransformUtils.preCheckCast(this.f1355b.get(r2), Boolean.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.booleanValue();
    }

    @Override // com.bytedance.services.slardar.config.a
    public void onReady() {
    }

    @Override // com.bytedance.services.slardar.config.a
    public void onRefresh(JSONObject r1, boolean r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        a(r1);
    }
}

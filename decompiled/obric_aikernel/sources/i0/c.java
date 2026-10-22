package i0;

import androidx.annotation.NonNull;
import com.bytedance.apm.util.i;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.apm6.perf.base.model.LogTypeName;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.services.slardar.config.IConfigManager;
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
public class c implements u4.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, Boolean> f9292c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map<String, Boolean> f9293g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<String> f9294h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<String> f9295i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<String> f9296j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Map<String, String> f9297k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile JSONObject f9298l;

    static /* synthetic */ class a {
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f9299a = null;

        static {
            f9299a = new c(null);
        }

        static /* synthetic */ c a() {
            return f9299a;
        }
    }

    private c() {
        this.f9292c = new ConcurrentHashMap();
        this.f9293g = new ConcurrentHashMap();
        this.f9297k = new HashMap();
        LinkedList r10 = new LinkedList();
        this.f9294h = r10;
        r10.addAll(Arrays.asList(new String[]{Scraps.BATTERY, "smooth", "cpu", SlardarSettingsConstants.PERF_KEY_DISK, SlardarSettingsConstants.PERF_KEY_MEMORY, "thread", "fd", "page_load", "page_load_trace", CommonConsts.APM_INNER_EVENT_COST_START, "start_trace", "traffic", "ui"}));
        ArrayList r11 = new ArrayList();
        this.f9295i = r11;
        r11.add(SlardarSettingsConstants.PERF_KEY_ENABLE_UPLOAD);
        this.f9295i.add("drop_enable_upload");
        this.f9295i.add("serious_block_enable_upload");
        this.f9295i.add("block_enable_upload");
        this.f9295i.add("slow_method_enable_upload");
        LinkedList r12 = new LinkedList();
        this.f9296j = r12;
        r12.add("enable_perf_data_collect");
        this.f9297k.put(SlardarSettingsConstants.PERF_KEY_ENABLE_UPLOAD, "fps");
        this.f9297k.put("drop_enable_upload", "fps_drop");
        this.f9297k.put("block_enable_upload", LogTypeName.MONITOR_TYPE_BLOCK);
        this.f9297k.put("slow_method_enable_upload", LogTypeName.MONITOR_TYPE_DROP_FRAME_STACK);
        this.f9297k.put("serious_block_enable_upload", LogTypeName.MONITOR_TYPE_SERIOUS_BLOCK);
        ((IConfigManager) c4.d.a(IConfigManager.class)).registerConfigListener(this);
    }

    /* synthetic */ c(a r10) {
        this();
    }

    public static c a() {
        return b.a();
    }

    private void e(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        Map<String, Boolean> r11 = this.f9293g;
        boolean r12 = false;
        if (r10.optInt("temperature_enable_upload", 0) != 1) goto L7;
        boolean r13 = true;
    L8:
        r11.put("temperature", Boolean.valueOf(r13));
        Map<String, Boolean> r14 = this.f9293g;
        if (r10.optInt("exception_enable_upload", 0) != 1) goto L11;
        r12 = true;
    L11:
        r14.put("battery_trace", Boolean.valueOf(r12));
        return;
    L7:
        r13 = false;
        goto L8
    }

    private void f(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        Map<String, Boolean> r11 = this.f9293g;
        boolean r12 = false;
        if (r10.optInt(CommonConsts.LOG_REPORT_TYPE_EXCEPTION, 0) != 1) goto L7;
        r12 = true;
    L7:
        r11.put(LogTypeName.MONITOR_TYPE_CPU_TRACE, Boolean.valueOf(r12));
    }

    private void g(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        Map<String, Boolean> r11 = this.f9293g;
        boolean r12 = false;
        if (r10.optInt(LogTypeName.MEMORY_OBJECT_MONITOR, 0) != 1) goto L7;
        r12 = true;
    L7:
        r11.put(LogTypeName.MEMORY_OBJECT_MONITOR, Boolean.valueOf(r12));
    }

    private void h(@NonNull JSONObject r10) {
        JSONObject r11 = r10.optJSONObject(SlardarSettingsConstants.SETTING_PERFORMANCE_MODULES);
        if (r11 != null) goto L5;
        return;
    L5:
        Iterator<String> r12 = this.f9294h.iterator();
    L7:
        if (r12.hasNext() == false) goto L29;
        String r13 = r12.next();
        JSONObject r14 = r11.optJSONObject(r13);
        if ("smooth".equals(r13) == true) goto L10;
        if (SlardarSettingsConstants.PERF_KEY_MEMORY.equals(r13) == false) goto L15;
        g(r14);
    L15:
        if (Scraps.BATTERY.equals(r13) == false) goto L18;
        e(r14);
    L18:
        if ("cpu".equals(r13) == false) goto L21;
        f(r14);
    L21:
        if ("start_trace".equals(r13) == false) goto L23;
        j(r14);
    L23:
        if (r14 != null) goto L25;
    L27:
        Map<String, Boolean> r15 = this.f9292c;
        Boolean r16 = Boolean.FALSE;
    L28:
        r15.put(r13, r16);
        goto L7
    L25:
        if (r14.optInt(SlardarSettingsConstants.PERF_KEY_ENABLE_UPLOAD, 0) != 1) goto L27;
        r15 = this.f9292c;
        r16 = Boolean.TRUE;
        goto L28
    L10:
        i(r14);
        goto L7
    L29:
        this.f9298l = i.g(r11, "smooth", "scene_enable_upload");
    }

    private void i(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        Iterator<String> r11 = this.f9295i.iterator();
    L6:
        if (r11.hasNext() == false) goto L15;
        String r12 = r11.next();
        Map<String, Boolean> r13 = this.f9293g;     // Catch: Exception -> L13
        String r14 = this.f9297k.get(r12);     // Catch: Exception -> L13
        boolean r15 = false;
        if (r10.optInt(r12, 0) != 1) goto L11;
        r15 = true;
    L11:
        r13.put(r14, Boolean.valueOf(r15));     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }

    private void j(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        Iterator<String> r11 = this.f9296j.iterator();
    L6:
        if (r11.hasNext() == false) goto L15;
        String r12 = r11.next();
        Map<String, Boolean> r13 = this.f9293g;     // Catch: Exception -> L13
        boolean r14 = false;
        if (r10.optInt(r12, 0) != 1) goto L11;
        r14 = true;
    L11:
        r13.put(r12, Boolean.valueOf(r14));     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }

    public boolean b(String r10) {
        Boolean r11 = this.f9292c.get(r10);
        if (r11 != null) goto L7;
        return false;
    L7:
        return r11.booleanValue();
    }

    public boolean c(String r10, String r11) {
        Boolean r12 = this.f9293g.get(r10);
        if (this.f9298l != null) goto L5;
    L7:
        boolean r13 = false;
    L8:
        if (r12 != null) goto L10;
    L12:
        if (r13 == true) goto L14;
        return false;
    L14:
        return true;
    L10:
        if (r12.booleanValue() == false) goto L12;
    L5:
        if (this.f9298l.optInt(r11) != 1) goto L7;
        r13 = true;
        goto L8
    }

    public boolean d(String r10) {
        Boolean r11 = this.f9293g.get(r10);
        if (r11 != null) goto L7;
        return false;
    L7:
        return r11.booleanValue();
    }

    @Override // u4.a
    public void onReady() {
    }

    @Override // u4.a
    public void onRefresh(JSONObject r10, boolean r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        h(r10);
    }
}

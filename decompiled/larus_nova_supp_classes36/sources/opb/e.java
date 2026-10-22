package opb;

import com.bytedance.i18n.claymore.PluginServiceLoader;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.appsetting.api.InternalLocalDefaultConfigStorage;
import com.ss.android.lark.appsetting.api.SettingKeysCollector;
import com.ss.android.lark.framework.assembly.larksetting.LarkSettingModuleDependency;
import com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import idb.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e {
    public List<AbstractBaseSettingHandler> a;
    public final Set<String> b;
    public volatile Map<String, jpb.a> c;
    public final b d;
    public final ppb.a.InterfaceC0313a e;
    public boolean f;
    public final Object g;
    public boolean h;

    public static class a {
        public static final e a = null;

        static {
            a = new e();
        }
    }

    public final void a() {
        Iterator<AbstractBaseSettingHandler> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        AbstractBaseSettingHandler r1 = r0.next();
        ((HashSet) this.b).add(r1.a());
        goto L4
    L6:
        Set r2 = SettingKeysCollector.getKeySet();
        if (CollectionUtils.isNotEmpty(r2) == false) goto L9;
        this.b.addAll(r2);
    L9:
        Set<String> r3 = b().keySet();
        if (CollectionUtils.isNotEmpty(r3) == false) goto L12;
        this.b.addAll(r3);
    L12:
        ((LarkSettingModuleDependency.a) this.e).getClass();
        Set r4 = f.a().getSettingsFGKeys();
        if (CollectionUtils.isNotEmpty(r4) == false) goto L15;
        this.b.addAll(r4);
    L15:
        Log.i("AppSettingService", "mSettingKeySet size: " + ((HashSet) this.b).size());
    }

    public final Map<String, jpb.a> b() {
        if (this.c != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.c != null) goto L8;
        ConcurrentHashMap r0 = new ConcurrentHashMap();     // Catch: Throwable -> L10
        ((ppb.a) ApiUtils.getApi(ppb.a.class)).fillDefaultKey2LoadConfigMap(r0);     // Catch: Throwable -> L10
        this.c = r0;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.c;
    }

    public final void c() {
        Log.i("AppSettingService", "init called");
        if (this.f == false) goto L6;
        Log.i("AppSettingService", "mIsInit finish, return");
        return;
    L6:
        Object r0 = this.g;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L9:
        if (this.f == false) goto L13;
        Log.i("AppSettingService", "init done, return");     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L13:
        Log.i("AppSettingService", "init start");     // Catch: Throwable -> L16
        int r1 = com.ss.android.lark.appsetting.api.b.a;     // Catch: Throwable -> L16
        ((InternalLocalDefaultConfigStorage) InternalLocalDefaultConfigStorage.g.getValue()).c();     // Catch: Throwable -> L16
        d();     // Catch: Throwable -> L16
        final List<AbstractBaseSettingHandler> r2 = this.a;     // Catch: Throwable -> L16
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new c(r2));     // Catch: Throwable -> L16
        a();     // Catch: Throwable -> L16
        this.f = true;     // Catch: Throwable -> L16
        Log.i("AppSettingService", "init finish");     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
    }

    public final void d() {
        ArrayList r0 = new ArrayList();
        Iterator r1 = PluginServiceLoader.loadAll(npb.a.class);
    L4:
        if (r1.hasNext() == false) goto L6;
        npb.a r2 = (npb.a) r1.next();
        r2.a();
        r0.addAll(r2.b());
        Log.i("AppSettingService", "not ignored handler is: " + r2.getTag());
        goto L4
    L6:
        r0.add(qpb.a.C0318a.a);
        this.a = r0;
    }

    public final void e() {
        Log.i("AppSettingService", "pullAppSettingsInternal");
        c();
        com.ss.android.lark.appsetting.api.service.d.a.a.a(new ArrayList(this.b), new d(this));
    }

    public e() {
        this.b = new HashSet();
        this.d = new b();
        this.g = new Object();
        this.h = true;
        this.a = Collections.emptyList();
        this.e = ((ppb.a) ApiUtils.getApi(ppb.a.class)).getFeatureGatingDependency();
    }

    public static void f(int r7, boolean r8, long r9, Map r11) {
        int r0 = rpb.a.a;
        Long r10 = Long.valueOf(r9);
        Log.i("AppSettingTracker", "reportSyncUpdate start, scene: " + r7 + ", updateSuccess: " + r8 + ", syncCost: " + r10 + ", changedKeyMap: " + r11);
        JSONObject r12 = new JSONObject();
        if (r8 == true) goto L5;
        r12.put("update_success", r8);
        r12.put("scene", r7);
    L13:
        ((ppb.a) ApiUtils.getApi(ppb.a.class)).sendEvent("fg_sync_update", r12);
        Log.i("AppSettingTracker", "reportSyncUpdate finish, scene: " + r7 + ", updateSuccess: " + r8 + ", syncCost: " + r10 + ", changedKeyMap: " + r11);
        return;
    L5:
        r12.put("update_success", r8);
        r12.put("scene", r7);
        r12.put("sync_cost", r10);
        String r4 = null;
        if (r11 == null) goto L8;
        String r6 = (String) r11.get("added_keys");
    L9:
        r12.put("added_keys", r6);
        if (r11 == null) goto L12;
        r4 = (String) r11.get("removed_keys");
    L12:
        r12.put("removed_keys", r4);
        goto L13
    L8:
        r6 = null;
        goto L9
    }

    public final void g(Map r9, String r10, boolean r11, boolean r12) {
        c();
        Iterator<AbstractBaseSettingHandler> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().i(r9, true, r11, r12, r10);
        goto L4
    L6:
        com.ss.android.lark.appsetting.api.e.a.a.e(r9, true, r10);
        com.ss.android.lark.appsetting.api.service.d.a.a.b(r9, r10);
        b r1 = this.d;
        Map<String, jpb.a> r2 = b();
        ((LarkSettingModuleDependency.a) this.e).getClass();
        r1.a(r9, r2, r11, true, f.a().isEnable("common_settings_opt_close"));
    }
}

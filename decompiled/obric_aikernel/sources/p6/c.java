package p6;

import android.content.Context;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.services.slardar.config.IConfigManager;
import com.monitor.cloudmessage.entity.CloudMessageException;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c extends o6.a {

    class a implements u4.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ n6.a f12332c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ c f12333g;

        a(c r10, n6.a r11) {
            this.f12333g = r10;
            this.f12332c = r11;
        }

        @Override // u4.a
        public void onReady() {
        }

        @Override // u4.a
        public void onRefresh(JSONObject r10, boolean r11) {
            c.m(this.f12333g, r10, r11, this.f12332c);     // Catch: Throwable -> L5 Exception -> L7 CloudMessageException -> L9
        L4:
            ((IConfigManager) c4.d.a(IConfigManager.class)).unregisterConfigListener(this);
            return;
        L5:
            th = move-exception;
            ((IConfigManager) c4.d.a(IConfigManager.class)).unregisterConfigListener(this);
            throw th;
        L9:
            e = move-exception;
            c.n(this.f12333g, e.getMessage(), this.f12332c);     // Catch: Throwable -> L5
        L7:
            e = move-exception;
            c.o(this.f12333g, String.format("系统错误：%s", new Object[]{com.monitor.cloudmessage.utils.a.a(e)}), this.f12332c);     // Catch: Throwable -> L5
            goto L4
        }
    }

    public c() {
    }

    static /* synthetic */ void m(c r10, JSONObject r11, boolean r12, n6.a r13) {
        r10.p(r11, r12, r13);
    }

    static /* synthetic */ void n(c r10, String r11, n6.a r12) {
        r10.k(r11, r12);
    }

    static /* synthetic */ void o(c r10, String r11, n6.a r12) {
        r10.k(r11, r12);
    }

    private void p(JSONObject r10, boolean r11, n6.a r12) {
        JSONObject r13 = r10.optJSONObject(SlardarSettingsConstants.SETTING_PERFORMANCE_MODULES);
        if (r13 != null) goto L5;
        return;
    L5:
        JSONObject r14 = r13.optJSONObject(SlardarSettingsConstants.PERF_KEY_DISK);
        if (r14 != null) goto L8;
        return;
    L8:
        List<String> r15 = q(com.bytedance.apm.util.p.d(r14, SlardarSettingsConstants.PERF_DISK_KEY_COMPLIANCE_RELATIVE_PATHS));
        JSONObject r16 = r12.d();
        File r17 = com.monitor.cloudmessage.utils.b.j(r16.optString("rootNode"), r16.optString("relativeDirName"));
        if (r17 == null) goto L25;
        t6.a.c("handling dir upload:" + r17.getAbsolutePath(), r12);
        if (r17.exists() == false) goto L23;
        File r18 = t6.b.b().c();
        if (r18 == null) goto L21;
        File r19 = new File(r18, r12.b() + "_temp");
        com.monitor.cloudmessage.utils.b.g(r19);
        boolean r20 = r6.b.d(r17, new File(r19, "dir_tree.txt"), r15);
        e0.e.b("cloudmessage", new String[]{"dir tree generate result " + r20});
        if (r20 == false) goto L19;
        t6.b.b().e(r12, r19, "log_dir_tree");
        return;
    L19:
        throw new CloudMessageException("目录树文件生成失败");
    L21:
        throw new CloudMessageException("pending目录因拿不到context而未设置");
    L23:
        throw new CloudMessageException("目录不存在");
    L25:
        throw new CloudMessageException("目录参数解析失败");
    }

    private List<String> q(List<String> r10) {
        ArrayList r11 = new ArrayList();
        if (ListUtils.isEmpty(r10) == false) goto L5;
        return r11;
    L5:
        Context r12 = k6.a.k().i();
        Iterator<String> r13 = r10.iterator();
    L7:
        if (r13.hasNext() == false) goto L15;
        String r14 = r13.next();
        String r15 = "internal";
        if (r14.contains("internal") == true) goto L10;
        r15 = "external";
        if (r14.contains("external") == false) goto L7;
        File r16 = r12.getExternalFilesDir(null);
    L11:
        r11.add(r14.replace(r15, r16.getParentFile().getAbsolutePath()));
        goto L7
    L10:
        r16 = r12.getFilesDir();
        goto L11
    L15:
        return r11;
    }

    @Override // o6.a
    public String f() {
        return "new_diskdir";
    }

    @Override // o6.a
    public boolean g(n6.a r10) {
        a r11 = new a(this, r10);
        ((IConfigManager) c4.d.a(IConfigManager.class)).registerConfigListener(r11);
        return true;
    }
}

package com.monitor.cloudmessage.b.a;

import android.content.Context;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.services.slardar.config.IConfigManager;
import com.monitor.cloudmessage.CloudMessageManager;
import com.monitor.cloudmessage.entity.CloudMessageException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class c extends com.monitor.cloudmessage.b.a {
    public c() {
    }

    private List<String> a(List<String> r6) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        ArrayList r7 = new ArrayList();
        if (ListUtils.isEmpty(r5) == false) goto L5;
        return r7;
    L5:
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(CloudMessageManager.getInstance().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Iterator r8 = r5.iterator();
    L7:
        if (r8.hasNext() == false) goto L15;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
        String r3 = "internal";
        if (r2.contains("internal") == true) goto L10;
        r3 = "external";
        if (r2.contains("external") == false) goto L7;
        File r4 = r1.getExternalFilesDir(null);
    L11:
        r7.add(r2.replace(r3, r4.getParentFile().getAbsolutePath()));
        goto L7
    L10:
        r4 = r1.getFilesDir();
        goto L11
    L15:
        return r7;
    }

    static /* synthetic */ void a(c r0, String r1, com.monitor.cloudmessage.entity.a r2) {
        r0.a(r1, r2);
    }

    static /* synthetic */ void a(c r0, JSONObject r1, boolean r2, com.monitor.cloudmessage.entity.a r3) {
        r0.a(r1, r2, r3);
    }

    private void a(JSONObject r4, boolean r5, com.monitor.cloudmessage.entity.a r6) {
        JSONObject r7 = r4.optJSONObject(SlardarSettingsConstants.SETTING_PERFORMANCE_MODULES);
        if (r7 != null) goto L5;
        return;
    L5:
        JSONObject r8 = r7.optJSONObject(SlardarSettingsConstants.PERF_KEY_DISK);
        if (r8 != null) goto L8;
        return;
    L8:
        List<String> r3 = a(com.bytedance.apm.util.n.b(r8, SlardarSettingsConstants.PERF_DISK_KEY_COMPLIANCE_RELATIVE_PATHS));
        JSONObject r9 = r6.b();
        File r10 = com.monitor.cloudmessage.utils.c.b(r9.optString("rootNode"), r9.optString("relativeDirName"));
        if (r10 == null) goto L25;
        com.monitor.cloudmessage.e.a.a("handling dir upload:" + r10.getAbsolutePath(), r6);
        if (r10.exists() == false) goto L23;
        File r11 = com.monitor.cloudmessage.e.b.a().b();
        if (r11 == null) goto L21;
        File r0 = new File(r11, r6.d() + "_temp");
        com.monitor.cloudmessage.utils.c.a(r0);
        boolean r12 = com.monitor.cloudmessage.c.b.a.b.a(r10, new File(r0, "dir_tree.txt"), r3);
        com.bytedance.apm.e.e.d("cloudmessage", new String[]{"dir tree generate result " + r12});
        if (r12 == false) goto L19;
        com.monitor.cloudmessage.e.b.a().a(r6, r0, "log_dir_tree");
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

    static /* synthetic */ void b(c r0, String r1, com.monitor.cloudmessage.entity.a r2) {
        r0.a(r1, r2);
    }

    @Override // com.monitor.cloudmessage.b.a
    public String b() {
        return "new_diskdir";
    }

    @Override // com.monitor.cloudmessage.b.a
    public boolean d(final com.monitor.cloudmessage.entity.a r3) {
        com.bytedance.services.slardar.config.a r0 = new AnonymousClass1(this, r3);
        ((IConfigManager) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IConfigManager.class), IConfigManager.class, "com.obric.memorydata.plugin")).registerConfigListener(r0);
        return true;
    }
}

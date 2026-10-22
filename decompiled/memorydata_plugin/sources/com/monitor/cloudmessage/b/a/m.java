package com.monitor.cloudmessage.b.a;

import android.content.Context;
import com.monitor.cloudmessage.CloudMessageManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class m extends com.monitor.cloudmessage.b.a implements com.monitor.cloudmessage.f.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f5837a;

    public m() {
        this.f5837a = null;
    }

    @Override // com.monitor.cloudmessage.b.a
    public String b() {
        return "permission";
    }

    @Override // com.monitor.cloudmessage.f.a.a
    public List<String> c() {
        ArrayList r0 = new ArrayList(1);
        File r2 = this.f5837a;
        if (r2 == null) goto L5;
        r0.add(r2.getAbsolutePath());
    L5:
        return r0;
    }

    @Override // com.monitor.cloudmessage.b.a
    public boolean d(com.monitor.cloudmessage.entity.a r11) {
        if (a(new JSONObject(r11.a()), r11) == false) goto L5;
        return true;
    L5:
        File r0 = com.monitor.cloudmessage.c.b.a.f.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(CloudMessageManager.getInstance().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        if (r0 != null) goto L9;
        com.monitor.cloudmessage.f.b.b r10 = new com.monitor.cloudmessage.f.b.b(0, false, r11.d(), null);
        r10.a(3);
        r10.a("网络信息文件生成失败");
        com.monitor.cloudmessage.f.a.a(r10);
        return true;
    L9:
        this.f5837a = r0;
        com.monitor.cloudmessage.f.a.a(new com.monitor.cloudmessage.f.b.a("txt", 0, false, r11.d(), this, null));
        return true;
    }
}

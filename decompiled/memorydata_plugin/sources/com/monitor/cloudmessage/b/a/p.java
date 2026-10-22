package com.monitor.cloudmessage.b.a;

import android.content.Context;
import com.monitor.cloudmessage.CloudMessageManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class p extends com.monitor.cloudmessage.b.a {
    public p() {
    }

    @Override // com.monitor.cloudmessage.b.a
    public String b() {
        return "sp";
    }

    @Override // com.monitor.cloudmessage.b.a
    public synchronized boolean d(com.monitor.cloudmessage.entity.a r5) {
        monitor-enter(this);
        File r0 = com.monitor.cloudmessage.c.b.a.g.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(CloudMessageManager.getInstance().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        a("sp文件拷贝失败", r5);     // Catch: Throwable -> L11
        monitor-exit(this);
        return true;
    L8:
        com.monitor.cloudmessage.e.b.a().a(r5, r0.getParentFile(), "default_sp_file_type");     // Catch: Throwable -> L11
        monitor-exit(this);
        return true;
    L11:
        th = move-exception;
        throw th;
    }
}

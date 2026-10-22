package com.monitor.cloudmessage.b.a;

import com.monitor.cloudmessage.CloudMessageManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes3.dex */
public class k implements com.monitor.cloudmessage.b.b {
    public k() {
    }

    @Override // com.monitor.cloudmessage.b.b
    public boolean a(com.monitor.cloudmessage.entity.a r1) {
        return b(r1);
    }

    public boolean b(com.monitor.cloudmessage.entity.a r8) {
        Enumeration r7 = CloudMessageManager.getInstance().getObverserList();
        if (r7 != null) goto L5;
        return false;
    L5:
        if (r7.hasMoreElements() == false) goto L20;
        com.monitor.cloudmessage.d.a r0 = (com.monitor.cloudmessage.d.a) ZeusTransformUtils.preCheckCast(r7.nextElement(), com.monitor.cloudmessage.d.a.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        if (r0.a(r8) == false) goto L5;
        com.monitor.cloudmessage.f.a.a(new com.monitor.cloudmessage.f.b.b(0, false, r8.d(), null));
        return true;
    L20:
        return false;
    }
}

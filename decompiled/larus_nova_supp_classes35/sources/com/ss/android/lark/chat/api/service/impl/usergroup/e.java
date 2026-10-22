package com.ss.android.lark.chat.api.service.impl.usergroup;

import com.bytedance.lark.pb.im.v1.UserGroupEntity;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements Runnable {
    public final /* synthetic */ UserGroupService a;
    public final /* synthetic */ Map<Long, UserGroupEntity> b;

    public e(UserGroupService r1, Map<Long, UserGroupEntity> r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator<Map.Entry<com.ss.android.lark.biz.im.api.usergroup.a, Object>> r0 = this.a.e.entrySet().iterator();     // Catch: Throwable -> L7
    L4:
        if (r0.hasNext() == false) goto L16;
        r0.next().getKey().a(this.b);     // Catch: Throwable -> L7
        goto L4
    L16:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}

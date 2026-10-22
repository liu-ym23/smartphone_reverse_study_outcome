package com.ss.android.lark.chat.api.service.impl.usergroup;

import com.bytedance.lark.pb.im.v1.PushUserGroupEntitiesRequest;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements Runnable {
    public final /* synthetic */ UserGroupPush a;
    public final /* synthetic */ PushUserGroupEntitiesRequest b;

    public d(UserGroupPush r1, PushUserGroupEntitiesRequest r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        UserGroupPush r0 = this.a;
        PushUserGroupEntitiesRequest r1 = this.b;
        r0.getClass();
        Map r2 = r1.user_groups;
        ArrayList r3 = new ArrayList(r2.size());
        Iterator r4 = r2.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r3.add((Long) ((Map.Entry) r4.next()).getKey());
        goto L4
    L6:
        int r5 = c.a;
        c.b("UserGroupPush", "receive user group push. " + r3);
        r0.b.pe(r1.user_groups);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

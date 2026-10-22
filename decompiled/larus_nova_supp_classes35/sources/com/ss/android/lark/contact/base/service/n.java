package com.ss.android.lark.contact.base.service;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.im.v1.PushChatApplications;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class n implements com.ss.android.lark.sdk.f.a {
    public final /* synthetic */ q a;

    public class a implements com.ss.android.lark.sdk.g.b {
        public final /* synthetic */ n a;

        public a(n r1) {
            this.a = r1;
        }

        public final void a(byte[] r4) {
            q r0 = this.a.a;
            r0.getClass();
            PushChatApplications r5 = (PushChatApplications) PushChatApplications.ADAPTER.decode(r4);     // Catch: Exception -> L5
            Entity r1 = r5.entity;     // Catch: Exception -> L5
            List r6 = com.larksuite.framework.utils.y.a(r5.applications, new g9b.a());     // Catch: Exception -> L5
            CoreThreadPool.getDefault().getUIExecutor().execute(new o(r0, r6));     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            Log.e(e.getMessage());
        }
    }

    public final void a() {
        com.ss.android.lark.sdk.g.e.a.b(Command.PUSH_CHAT_APPLICATIONS, new a(this));
    }

    public n(q r1) {
        this.a = r1;
    }
}

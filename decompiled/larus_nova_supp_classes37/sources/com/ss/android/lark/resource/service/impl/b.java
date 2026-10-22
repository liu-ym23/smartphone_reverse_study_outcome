package com.ss.android.lark.resource.service.impl;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.media.v1.PushResourceResponse;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements com.ss.android.lark.sdk.f.a {
    public final /* synthetic */ ResourcePush a;

    public class a implements com.ss.android.lark.sdk.g.b {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        public final void a(byte[] r5) {
            ResourcePush r0 = this.a.a;
            r0.getClass();
            PushResourceResponse r6 = (PushResourceResponse) PushResourceResponse.ADAPTER.decode(r5);     // Catch: Exception -> L5
            String r1 = r6.key;     // Catch: Exception -> L5
            PushResourceResponse.Status r7 = r6.status;     // Catch: Exception -> L5
            CoreThreadPool.getDefault().getUIExecutor().execute(new c(r0, r1, r7));     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            Log.e(e.getMessage(), e);
        }
    }

    public final void a() {
        com.ss.android.lark.sdk.g.e.a.b(Command.PUSH_RESOURCE, new a(this));
    }

    public b(ResourcePush r1) {
        this.a = r1;
    }
}

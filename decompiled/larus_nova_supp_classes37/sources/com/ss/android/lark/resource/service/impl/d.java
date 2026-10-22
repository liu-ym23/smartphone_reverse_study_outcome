package com.ss.android.lark.resource.service.impl;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.media.v1.PushResourceProgressResponse;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d implements com.ss.android.lark.sdk.f.a {
    public final /* synthetic */ ResourcePush a;

    public class a implements com.ss.android.lark.sdk.g.b {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        public final void a(byte[] r10) {
            ResourcePush r2 = this.a.a;
            r2.getClass();
            PushResourceProgressResponse r11 = (PushResourceProgressResponse) PushResourceProgressResponse.ADAPTER.decode(r10);     // Catch: Exception -> L10
            String r3 = r11.key;     // Catch: Exception -> L10
            int r4 = r11.progress.intValue();     // Catch: Exception -> L10
            long r5 = r11.total_size.longValue();     // Catch: Exception -> L10
            long r7 = r11.transferred_size.longValue();     // Catch: Exception -> L10
            ResourcePush.Link r12 = ResourcePush.Link.valueOf(r11.link.getValue());     // Catch: Exception -> L10
            if (r12 != ResourcePush.Link.UPLOAD) goto L7;
            CoreThreadPool.getDefault().getUIExecutor().execute(new e(r2, r3, r4, r5, r7));     // Catch: Exception -> L10
        L13:
            return;
        L7:
            if (r12 != ResourcePush.Link.DOWNLOAD) goto L13;
            CoreThreadPool.getDefault().getUIExecutor().execute(new f(r2, r3, r4, r5, r7));     // Catch: Exception -> L10
        L10:
            e = move-exception;
            Log.e(e.getMessage(), e);
        }
    }

    public final void a() {
        com.ss.android.lark.sdk.g.e.a.b(Command.PUSH_RESOURCE_PROGRESS, new a(this));
    }

    public d(ResourcePush r1) {
        this.a = r1;
    }
}

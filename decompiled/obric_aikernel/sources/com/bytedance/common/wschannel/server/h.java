package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.os.HandlerThread;
import com.bytedance.common.wschannel.app.IWsApp;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.bytedance.common.wschannel.server.b f1434a;

    static class a implements f {
        a() {
        }

        @Override // com.bytedance.common.wschannel.server.f
        public void a() {
        }

        @Override // com.bytedance.common.wschannel.server.f
        public void b(f.a r10) {
        }

        @Override // com.bytedance.common.wschannel.server.f
        public boolean isEnable() {
            return true;
        }
    }

    static class b implements g {
        b() {
        }

        @Override // com.bytedance.common.wschannel.server.g
        public Map<Integer, IWsApp> a() {
            return Collections.emptyMap();
        }

        @Override // com.bytedance.common.wschannel.server.g
        public void b(Map<Integer, IWsApp> r10) {
        }
    }

    private static com.bytedance.common.wschannel.server.b a(Context r10) {
        HandlerThread r11 = new HandlerThread("wschannel");
        r11.start();
        com.bytedance.common.wschannel.server.a r12 = new com.bytedance.common.wschannel.server.a();
        i r13 = new i(r10, r12);
        a r14 = new a();
        com.bytedance.common.wschannel.server.b r15 = new com.bytedance.common.wschannel.server.b(r10, r11.getLooper(), new b(), r12, r13, r14);
        r13.k(r15);
        return r15;
    }

    public static com.bytedance.common.wschannel.server.b b(Context r10) {
        if (f1434a != null) goto L15;
        monitor-enter(com.bytedance.common.wschannel.server.b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f1434a != null) goto L9;
        f1434a = a(r10);     // Catch: Throwable -> L11
    L9:
        monitor-exit(com.bytedance.common.wschannel.server.b.class);     // Catch: Throwable -> L11
    L15:
        return f1434a;
    }
}

package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h0 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.d.a {
    public final /* synthetic */ i0.a a;
    public final /* synthetic */ i0.f b;

    public static final class a implements Runnable {
        public final /* synthetic */ h0 a;
        public final /* synthetic */ String b;

        public a(h0 r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            h0 r0 = this.a;     // Catch: Throwable -> L4
            r0.a.b = true;     // Catch: Throwable -> L4
            r0.b.onFinish();     // Catch: Throwable -> L4
            i0.e.getClass();     // Catch: Throwable -> L4
            List<String> r1 = i0.d;     // Catch: Throwable -> L4
            ArrayList r2 = (ArrayList) r1;     // Catch: Throwable -> L4
            r2.add(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public h0(i0.a r1, i0.g r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.d.a
    public final void a(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "fileName");
        Intrinsics.checkNotNullParameter(r4, "path");
        String r5 = FileUtils.readFromFile(new PolarisFileWrapper(r4));
        i0.a r0 = this.a;     // Catch: Throwable -> L5
        r0.c = new JSONObject(r5);     // Catch: Throwable -> L5
        com.bytedance.android.live.core.utils.i0.c().post(new a(this, r4));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        ALogger.e("LiveAnchorMusicEffect", th);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.d.a
    public final void onFail(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "fileName");
        Intrinsics.checkNotNullParameter(r3, "path");
        this.a.b = true;
        this.b.onFinish();
    }
}

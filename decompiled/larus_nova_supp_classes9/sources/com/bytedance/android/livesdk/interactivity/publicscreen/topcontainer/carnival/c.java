package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.carnival;

import android.os.Handler;
import com.bytedance.android.livesdk.interactivity.api.barrage.data.GeneralCarnivalDataSyncModel;
import com.bytedance.android.livesdk.interactivity.api.barrage.data.d;
import com.bytedance.android.livesdk.interactivity.api.barrage.data.k;
import com.bytedance.android.livesdk.interactivity.api.monitor.DanmakuMonitor;
import com.bytedance.android.livesdk.interactivity.textmessage.utils.f;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements f.a {
    public final /* synthetic */ DanmakuCarnivalTrayManager.d a;

    public static final class a implements Runnable {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        public final void a() {
            DanmakuMonitor.a("success");
            n22.a.d = true;
            this.a.a.a.getClass();
            DanmakuCarnivalTrayManager.m("Download Model Success");
            com.bytedance.android.livesdk.interactivity.api.publicscreen.b r1 = this.a.a.a.h;
            if (r1 == null) goto L32;
            m<Boolean> r2 = r1.isCarnivalStarted();
            if (r2 != null) goto L7;
            return;
        L7:
            if (((Boolean) r2.getValue()).booleanValue() != true) goto L34;
            com.bytedance.android.livesdk.interactivity.api.publicscreen.b r0 = this.a.a.a.h;
            if (r0 == null) goto L16;
            n<d> r3 = r0.getChatCarnivalMessage();
            if (r3 == null) goto L16;
            d r4 = (d) r3.getValue();
            if (r4 == null) goto L16;
            if (r4.p() != 1) goto L16;
        L30:
            this.a.a.a.k().b();
            return;
        L16:
            com.bytedance.android.livesdk.interactivity.api.publicscreen.b r5 = this.a.a.a.h;
            if (r5 == null) goto L35;
            j<GeneralCarnivalDataSyncModel> r6 = r5.getGeneralCarnivalSyncModel();
            if (r6 == null) goto L36;
            GeneralCarnivalDataSyncModel r7 = (GeneralCarnivalDataSyncModel) r6.getValue();
            if (r7 == null) goto L37;
            dc2.c<k> r8 = r7.getCarnivalMessage();
            if (r8 == null) goto L38;
            k r9 = r8.c();
            if (r9 == null) goto L39;
            com.bytedance.android.livesdk.interactivity.api.barrage.data.j r10 = r9.a();
            if (r10 != null) goto L29;
            return;
        L29:
            if (r10.q() == 1) goto L30;
            return;
        L39:
            return;
        L38:
            return;
        L37:
            return;
        L36:
            return;
        L35:
            return;
        L34:
            return;
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

    @Override // com.bytedance.android.livesdk.interactivity.textmessage.utils.f.a
    public final void onFailure() {
        ((Handler) this.a.a.g.getValue()).post(new b(this));
    }

    @Override // com.bytedance.android.livesdk.interactivity.textmessage.utils.f.a
    public final void onSuccess() {
        ((Handler) this.a.a.g.getValue()).post(new a(this));
    }

    public c(DanmakuCarnivalTrayManager.d r1) {
        this.a = r1;
    }
}

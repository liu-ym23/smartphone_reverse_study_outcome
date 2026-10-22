package com.bytedance.android.live.broadcastgame.opengame.sonicgame;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import com.bytedance.android.live.broadcastgame.opengame.q;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.profit.scoreboard.o;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k {
    public final IInteractGameService a;
    public final CompositeDisposable b;
    public final a c;
    public final PluginContext d;

    public static final class a implements Runnable {
        public final /* synthetic */ k a;

        public a(k r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IInteractGameService r0 = this.a.a;     // Catch: Throwable -> L4
            Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L4
            r0.stopRunningPlugin("invited_end");     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public k(PluginContext r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        this.d = r2;
        this.a = (IInteractGameService) jc1.k.f(IInteractGameService.class);
        this.b = new CompositeDisposable();
        this.c = new a(this);
    }

    public static final void a(k r5, int r6, o r7) {
        com.bytedance.android.live.broadcastgame.opengame.runtime.k r8 = r5.d.k();
        if (r8 == null) goto L13;
        JSONObject r0 = tv5.a.a(GsonHelper.get(), r7);
        r0.put("type", r6);     // Catch: JSONException -> L7
        r0.put("left_time", r7.a() - r7.d());     // Catch: JSONException -> L7
    L9:
        Unit r9 = Unit.INSTANCE;
        r8.sendEvent("onCounterStatusUpdate", r0);
        return;
    L7:
        e = move-exception;
        int r11 = q.a;
        q.e("BaseOpenMethodUsingCryptData", new Object[]{"sendScoreCountingEvent e = " + e.getMessage()});
        goto L9
    }
}

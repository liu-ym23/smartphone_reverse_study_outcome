package y60;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements Runnable {
    public final /* synthetic */ Context a;

    public static final class a implements Runnable {
        public final /* synthetic */ e a;

        public a(e r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            f.a(this.a.a);     // Catch: Throwable -> L4
            return;
        }
    }

    public e(Context r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (this.a.getSharedPreferences("ttlive_sdk_shared_pref_cache_v2_flags", 0).getBoolean("need_update_for_mini_process", false) == false) goto L9;
        ThreadMethodProxy.start(new PthreadThreadV2(new a(this), "SpRewriterKt$copySettingsForMiniProcessIfNeed$1"));     // Catch: Throwable -> L6
        return;
    }
}

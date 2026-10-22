package ox9;

import com.ss.android.ugc.bytex.pthread.base.convergence.SuperThreadPool;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a implements c {
    public a() {
    }

    public final void a() {
        SuperThreadPool r0 = SuperThreadPool.INSTANCE;
        r0.setEnableType(0);
        r0.setEnableThreadToStringOpt(false);
        r0.setEnablePriority(false);
        r0.setEnableHandlerThreadReuse(false);
        r0.setEnableThreadGroupOpt(false);
        r0.setEnableBlockFetchTask(true);
        r0.setAllowAllCoreThreadTimeOut(false);
    }
}

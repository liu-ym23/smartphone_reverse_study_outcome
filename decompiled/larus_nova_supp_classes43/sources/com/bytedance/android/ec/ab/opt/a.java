package com.bytedance.android.ec.ab.opt;

import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class a<Config> implements b {
    public final AtomicBoolean a;
    public Config b;

    public abstract Config b();

    public a() {
        this.a = new AtomicBoolean(false);
    }

    @Override // com.bytedance.android.ec.ab.opt.b
    public final Object a(ContinuationImpl r10) {
        boolean r1 = false;
        if (this.a.compareAndSet(false, true) == false) goto L13;
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L7;
        r1 = true;
    L7:
        if (r1 == false) goto L11;
        Object r11 = BuildersKt.withContext(Dispatchers.getIO(), new IDefaultLocalConfig$initConfig$2(this, null), r10);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        return r11;
    L11:
        this.b = b();
    L13:
        return Unit.INSTANCE;
    }
}

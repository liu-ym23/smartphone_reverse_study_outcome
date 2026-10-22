package com.bytedance.applog.params.lifecycle;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.applog.log.n;
import com.bytedance.applog.params.f;
import com.ss.android.common.applog.EventVerify;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/applog/params/lifecycle/LifecycleValueObserver;", "Landroidx/lifecycle/LifecycleEventObserver;", "params_release"}, k = 1, mv = {1, 6, 0})
public final class LifecycleValueObserver implements LifecycleEventObserver {
    public final void a() {
        destroy.1 r0 = new destroy.1(this);
        Intrinsics.checkNotNullParameter(r0, "f");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L5;
        new Handler(Looper.getMainLooper()).post(new f(r0));
        return;
    L5:
        r0.invoke();
    }

    public final void onStateChanged(LifecycleOwner r3, Lifecycle.Event r4) {
        Intrinsics.checkNotNullParameter(r3, "source");
        Intrinsics.checkNotNullParameter(r4, EventVerify.TYPE_EVENT_V1);
        if (r4 == Lifecycle.Event.ON_DESTROY) goto L5;
        return;
    L5:
        n.w().e(null, "params with lifecycle owner destroyed and onDestroy callback invoke start...", new Object[0]);
        throw null;
    }
}

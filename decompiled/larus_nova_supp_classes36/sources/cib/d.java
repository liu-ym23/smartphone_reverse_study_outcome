package cib;

import android.os.Looper;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    static {
    }

    public static void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, INotificationHitPoint.NoticeType.MESSAGE);
        if (Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException(r2.concat(", can't operate on non-main thread, ").toString());
    }
}

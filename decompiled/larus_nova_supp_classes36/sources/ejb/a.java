package ejb;

import cbb.d;
import com.bytedance.lark.pb.basic.v1.TriggerDataCleanRequest;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.framework.assembly.diskmanage.RustCleanTask$onRemoteCleanOnce$1;
import com.ss.android.lark.framework.assembly.diskmanage.c;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import qpc.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements Runnable {
    public static void a() {
        Log.i("TaskLaunchStrategy", "begin execute rust clean task on condition backgroud + plugin");
        AtomicBoolean r0 = c.a;
        c.b.a.getClass();
        d r1 = c.b();
        Intrinsics.checkNotNullParameter(r1, "remoteConfig");
        final cbb.a r2 = new cbb.a(false, 0, 7);
        cbb.c r3 = r1.a;
        int r4 = (int) r3.e;
        int r5 = (int) r3.c;
        ((e) ApiUtils.getApi(e.class)).triggerDataClean(Integer.valueOf(r4), Integer.valueOf(r5), TriggerDataCleanRequest.CleanType.AUTO, new RustCleanTask$onRemoteCleanOnce$1(r2));
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

    public a() {
    }
}

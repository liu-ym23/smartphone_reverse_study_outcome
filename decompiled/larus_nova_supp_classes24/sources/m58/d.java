package m58;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import o68.a;
import o68.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class d implements Function0 {
    public final /* synthetic */ Runnable a;
    public final /* synthetic */ Ref.ObjectRef b;
    public final /* synthetic */ Ref.ObjectRef c;

    public /* synthetic */ d(c r1, Ref.ObjectRef r2, Ref.ObjectRef r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object, m58.e] */
    public final Object invoke() {
        final Runnable r0 = this.a;
        final Ref.ObjectRef r1 = this.b;
        final Ref.ObjectRef r2 = this.c;
        Handler r3 = b.a;
        final ?? r4 = new e(r0, r1, r2);
        Intrinsics.checkNotNullParameter(r4, "block");
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        r4.invoke();
    L7:
        return Unit.INSTANCE;
    L5:
        b.a.post(new a(r4));
        goto L7
    }
}

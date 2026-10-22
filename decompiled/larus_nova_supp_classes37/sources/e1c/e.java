package e1c;

import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.chatwindow.chat.model.preload.v2.AudioResourceLoadTask;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e implements Runnable {
    public final /* synthetic */ Ref.ObjectRef<o1c.c<?, ?>> a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ IGetDataCallback<?> c;

    public e(Ref.ObjectRef r1, AudioResourceLoadTask.b r2, IGetDataCallback r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object r0 = this.a.element;     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.preload.v2.task.ITask<kotlin.Any?, kotlin.Any?>");     // Catch: Throwable -> L4
        ((o1c.c) r0).J1(this.b, this.c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

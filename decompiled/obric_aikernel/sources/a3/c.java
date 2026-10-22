package a3;

import com.bytedance.frameworks.baselib.network.dispatcher.IRequest;
import com.bytedance.retrofit2.b0;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class c implements Executor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile n2.b f80c;

    static {
    }

    public c() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r10) {
        if (r10 == null) goto L30;
        IRequest.Priority r11 = IRequest.Priority.NORMAL;
        boolean r12 = false;
        if ((r10 instanceof b0) == false) goto L21;
        b0 r13 = (b0) r10;
        int r14 = r13.D();
        if (r14 != 0) goto L9;
        r11 = IRequest.Priority.LOW;
    L20:
        r12 = r13.M();
        IRequest.Priority r15 = r11;
        int r16 = r13.v();
    L23:
        if (f80c != null) goto L25;
        f80c = com.bytedance.frameworks.baselib.network.dispatcher.c.c();
    L25:
        com.bytedance.frameworks.baselib.network.dispatcher.a r17 = new com.bytedance.frameworks.baselib.network.dispatcher.a("NetExecutor", r15, r16, r10, r12);
        n2.b r18 = f80c;
        if (r12 == false) goto L28;
        r18.b(r17);
        return;
    L28:
        r18.a(r17);
        return;
    L9:
        if (1 == r14) goto L20;
        if (2 != r14) goto L15;
        r11 = IRequest.Priority.HIGH;
        goto L20
    L15:
        if (3 != r14) goto L18;
        r11 = IRequest.Priority.IMMEDIATE;
        goto L20
    L18:
        if ((-1) != r14) goto L20;
        r11 = IRequest.Priority.LOWEST;
        goto L20
    L21:
        r15 = r11;
        r16 = 0;
        goto L23
    }
}

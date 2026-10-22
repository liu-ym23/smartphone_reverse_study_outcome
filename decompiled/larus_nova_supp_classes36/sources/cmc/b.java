package cmc;

import com.ss.ugc.live.sdk.msg.utils.g;
import com.ss.ugc.live.sdk.msg.utils.j;
import com.ss.ugc.live.sdk.msg.utils.k;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class b<T> implements com.ss.ugc.live.sdk.msg.utils.d, com.ss.ugc.live.sdk.msg.b {
    public com.ss.ugc.live.sdk.msg.c a;
    public final j b;
    public final d<T> c;

    @Override // com.ss.ugc.live.sdk.msg.b
    public void a(boolean r1) {
    }

    @Override // com.ss.ugc.live.sdk.msg.b
    public void onInit() {
    }

    @Override // com.ss.ugc.live.sdk.msg.b
    public void onRelease() {
    }

    @Override // com.ss.ugc.live.sdk.msg.b
    public void onResume() {
    }

    @Override // com.ss.ugc.live.sdk.msg.b
    public void onStart() {
    }

    public b(hm2.e r2) {
        Intrinsics.checkNotNullParameter(r2, "messageDecoder");
        this.c = r2;
        this.b = new j(this);
    }

    @Override // com.ss.ugc.live.sdk.msg.utils.d
    public final void b(k r3) {
        Intrinsics.checkNotNullParameter(r3, "whatResult");
        mmc.c r0 = r3.a;
        if ((r0 instanceof fmc.b) == false) goto L17;
        g<?, Throwable> r4 = r3.b;
        ((fmc.b) r0).getClass();
        Intrinsics.checkNotNullParameter(r4, "result");
        if ((r4 instanceof g.c) == false) goto L13;
        List<? extends tlc.d> r5 = (List) ((g.c) r4).b;
        Intrinsics.checkNotNullParameter(r5, "messages");
        com.ss.ugc.live.sdk.msg.c r1 = this.a;
        if (r1 == null) goto L18;
        com.ss.ugc.live.sdk.msg.dispatch.e r2 = r1.b;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("messageConsumer");
    L11:
        r2.c(r5);
        return;
    L18:
        return;
    L13:
        if ((r4 instanceof g.b) == false) goto L16;
        ((g.b) r4).getClass();
        return;
    L16:
        throw new NoWhenBranchMatchedException();
    }
}

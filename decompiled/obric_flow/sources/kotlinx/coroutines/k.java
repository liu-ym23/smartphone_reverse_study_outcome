package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class k implements Function3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f18972b;

    public /* synthetic */ k(Object r5, int r10) {
        this.f18971a = r10;
        this.f18972b = r5;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object r5, Object r10, final Object r11) {
        switch(this.f18971a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        Throwable r12 = (Throwable) r5;
        Unit r13 = (Unit) r10;
        CoroutineContext r14 = (CoroutineContext) r11;
        ((kotlinx.coroutines.sync.g) this.f18972b).b();
        return Unit.INSTANCE;
    L6:
        final kotlinx.coroutines.selects.g r15 = (kotlinx.coroutines.selects.g) r5;
        final kotlinx.coroutines.channels.f r16 = (kotlinx.coroutines.channels.f) this.f18972b;
        return new kotlinx.coroutines.channels.d(r16, r15, r11);
    L8:
        CoroutineContext r17 = (CoroutineContext) r11;
        com.bytedance.ai.model.widgets.d r18 = (com.bytedance.ai.model.widgets.d) this.f18972b;
        r18.invoke((Throwable) r5);
        return Unit.INSTANCE;
    }
}

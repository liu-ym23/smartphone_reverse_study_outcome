package kotlinx.coroutines.channels;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c implements Function3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f18781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f18782c;

    public /* synthetic */ c(int r5, Object r10, Object r11) {
        this.f18780a = r5;
        this.f18781b = r10;
        this.f18782c = r11;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object r5, Object r10, Object r11) {
        Throwable r12 = (Throwable) r5;
        switch(this.f18780a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        Unit r13 = (Unit) r10;
        CoroutineContext r14 = (CoroutineContext) r11;
        AtomicReferenceFieldUpdater r15 = kotlinx.coroutines.sync.d.g;
        ((kotlinx.coroutines.sync.b) this.f18782c).getClass();
        kotlinx.coroutines.sync.d r16 = (kotlinx.coroutines.sync.d) this.f18781b;
        r15.set(r16, null);
        r16.d(null);
        return Unit.INSTANCE;
    L6:
        Function1 r17 = (Function1) this.f18781b;
        Object r18 = this.f18782c;
        kotlinx.coroutines.internal.f.a(r17, r18, (CoroutineContext) r11);
        return Unit.INSTANCE;
    }
}

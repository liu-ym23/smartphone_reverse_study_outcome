package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.l1;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l1 f18873a;

    public l(l1 r5) {
        this.f18873a = r5;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r5) {
        Throwable r10 = (Throwable) r5;
        l1 r11 = this.f18873a;
        if (r11.isActive() == false) goto L6;
        r11.x(new AbortFlowException(r11));
    L6:
        return Unit.INSTANCE;
    }
}

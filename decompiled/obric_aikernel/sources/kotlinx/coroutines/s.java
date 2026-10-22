package kotlinx.coroutines;

import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.JvmField;

/* JADX INFO: loaded from: classes3.dex */
@PublishedApi
public final class s extends w1 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @JvmField
    public final o<?> f10629j;

    public s(o<?> r10) {
        this.f10629j = r10;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable r10) {
        q(r10);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.d0
    public void q(Throwable r10) {
        o<?> r11 = this.f10629j;
        r11.R(r11.x(r()));
    }
}

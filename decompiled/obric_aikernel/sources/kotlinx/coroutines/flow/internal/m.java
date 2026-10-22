package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements kotlinx.coroutines.flow.d<Object> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m f10494c = null;

    static {
        f10494c = new m();
    }

    private m() {
    }

    @Override // kotlinx.coroutines.flow.d
    public Object emit(Object r10, Continuation<? super Unit> r11) {
        return Unit.INSTANCE;
    }
}

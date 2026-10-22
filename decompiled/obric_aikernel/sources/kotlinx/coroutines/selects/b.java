package kotlinx.coroutines.selects;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public interface b<R> {
    void b(d r10, Function1<? super Continuation<? super R>, ? extends Object> r11);

    <Q> void e(f<? extends Q> r10, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> r11);
}

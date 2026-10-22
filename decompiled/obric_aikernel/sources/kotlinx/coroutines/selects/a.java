package kotlinx.coroutines.selects;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <R> void a(b<? super R> r10, long r11, Function1<? super Continuation<? super R>, ? extends Object> r12) {
        r10.b(new OnTimeout(r11).b(), r12);
    }

    public static final <R> void b(b<? super R> r10, long r11, Function1<? super Continuation<? super R>, ? extends Object> r12) {
        a(r10, DelayKt.d(r11), r12);
    }
}

package kotlin.sequences;

import java.util.Iterator;
import kotlin.BuilderInference;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
class SequencesKt__SequenceBuilderKt {
    private static final int State_Done = 4;
    private static final int State_Failed = 5;
    private static final int State_ManyNotReady = 1;
    private static final int State_ManyReady = 2;
    private static final int State_NotReady = 0;
    private static final int State_Ready = 3;

    public SequencesKt__SequenceBuilderKt() {
    }

    @SinceKotlin(version = "1.3")
    public static <T> Iterator<T> iterator(@BuilderInference Function2<? super SequenceScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "block");
        SequenceBuilderIterator r11 = new SequenceBuilderIterator();
        r11.setNextStep(IntrinsicsKt.createCoroutineUnintercepted(r10, r11, r11));
        return r11;
    }

    @SinceKotlin(version = "1.3")
    public static <T> Sequence<T> sequence(@BuilderInference final Function2<? super SequenceScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "block");
        return new SequencesKt__SequenceBuilderKt$sequence$$inlined$Sequence$1(r10);
    }
}

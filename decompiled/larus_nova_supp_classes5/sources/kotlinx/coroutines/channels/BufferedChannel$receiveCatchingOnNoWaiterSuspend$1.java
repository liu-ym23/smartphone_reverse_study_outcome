package kotlinx.coroutines.channels;

import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.IntCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.BufferedChannel", f = "BufferedChannel.kt", i = {0, 0, 0, 0}, l = {3087}, m = "receiveCatchingOnNoWaiterSuspend-GKJJFZk", n = {"this", "segment", "index", DownloadFileUtils.MODE_READ}, s = {"L$0", "L$1", "I$0", "J$0"})
public final class BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BufferedChannel<E> this$0;

    public BufferedChannel$receiveCatchingOnNoWaiterSuspend$1(BufferedChannel<E> r1, Continuation<? super BufferedChannel$receiveCatchingOnNoWaiterSuspend$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= IntCompanionObject.MIN_VALUE;
        BufferedChannel<E> r0 = this.this$0;
        AtomicLongFieldUpdater r8 = BufferedChannel.d;
        Object r9 = r0.D(null, 0, 0, (Continuation<? super g<? extends E>>) this);
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r9;
    L6:
        return new g(r9);
    }
}

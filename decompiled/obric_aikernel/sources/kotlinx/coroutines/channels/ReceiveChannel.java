package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.internal.LowPriorityInOverloadResolution;

/* JADX INFO: loaded from: classes3.dex */
public interface ReceiveChannel<E> {

    public static final class DefaultImpls {
        public static /* synthetic */ void a(ReceiveChannel r10, CancellationException r11, int r12, Object r13) {
            if (r13 != null) goto L9;
            if ((r12 & 1) == 0) goto L6;
            r11 = null;
        L6:
            r10.c(r11);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
        @LowPriorityInOverloadResolution
        public static <E> Object b(ReceiveChannel<? extends E> r10, Continuation<? super E> r11) {
            if ((r11 instanceof ReceiveChannel$receiveOrNull$1) == false) goto L7;
            ReceiveChannel$receiveOrNull$1 r12 = (ReceiveChannel$receiveOrNull$1) r11;
            int r13 = r12.label;
            if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
            r12.label = r13 - Integer.MIN_VALUE;
        L8:
            Object r14 = r12.result;
            Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r16 = r12.label;
            if (r16 == 0) goto L14;
            if (r16 != 1) goto L13;
            ResultKt.throwOnFailure(r14);
            Object r17 = ((g) r14).k();
        L18:
            return g.f(r17);
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r14);
            r12.label = 1;
            r17 = r10.g(r12);
            if (r17 != r15) goto L18;
            return r15;
        L7:
            r12 = new ReceiveChannel$receiveOrNull$1(r11);
            goto L8
        }
    }

    kotlinx.coroutines.selects.f<E> b();

    void c(CancellationException r10);

    kotlinx.coroutines.selects.f<g<E>> d();

    Object e();

    Object g(Continuation<? super g<? extends E>> r10);

    ChannelIterator<E> iterator();

    Object t(Continuation<? super E> r10);
}

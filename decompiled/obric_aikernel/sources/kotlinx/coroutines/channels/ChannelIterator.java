package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmName;

/* JADX INFO: loaded from: classes3.dex */
public interface ChannelIterator<E> {

    public static final class DefaultImpls {
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        @JvmName(name = "next")
        public static /* synthetic */ Object a(ChannelIterator r10, Continuation r11) {
            if ((r11 instanceof ChannelIterator$next0$1) == false) goto L7;
            ChannelIterator$next0$1 r12 = (ChannelIterator$next0$1) r11;
            int r13 = r12.label;
            if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
            r12.label = r13 - Integer.MIN_VALUE;
        L8:
            Object r14 = r12.result;
            Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r16 = r12.label;
            if (r16 == 0) goto L14;
            if (r16 != 1) goto L13;
            r10 = (ChannelIterator) r12.L$0;
            ResultKt.throwOnFailure(r14);
        L18:
            if (((Boolean) r14).booleanValue() == false) goto L22;
            return r10.next();
        L22:
            throw new ClosedReceiveChannelException("Channel was closed");
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r14);
            r12.L$0 = r10;
            r12.label = 1;
            r14 = r10.a(r12);
            if (r14 != r15) goto L18;
            return r15;
        L7:
            r12 = new ChannelIterator$next0$1(r11);
            goto L8
        }
    }

    Object a(Continuation<? super Boolean> r10);

    E next();
}

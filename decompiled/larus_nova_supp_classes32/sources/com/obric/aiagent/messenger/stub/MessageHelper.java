package com.obric.aiagent.messenger.stub;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class MessageHelper {
    public static final MessageHelper a = null;

    public static final class a implements IIMCallback<List<? extends Message>> {
        public final /* synthetic */ kotlinx.coroutines.i<List<Message>> a;

        public final boolean mustInMain() {
            return !com.larus.im.internal.delegate.y0.a();
        }

        public a(kotlinx.coroutines.j r1) {
            this.a = r1;
        }

        public final void onFailure(IIMError r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            Intrinsics.checkNotNullParameter(r2, "error");
            this.a.resumeWith(Result.constructor-impl(null));
        }

        public final void onSuccess(Object r2) {
            List r3 = (List) r2;
            Intrinsics.checkNotNullParameter(r3, "result");
            this.a.resumeWith(Result.constructor-impl(r3));
        }
    }

    static {
        a = new MessageHelper();
    }

    public MessageHelper() {
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.obric.aiagent.messenger.stub.l0] */
    public static void a(final String r4, final Function1 r5) {
        Intrinsics.checkNotNullParameter(r4, "questionId");
        Intrinsics.checkNotNullParameter(r5, "action");
        final long r0 = System.currentTimeMillis();
        ?? r2 = new l0(r4, r0, r5);
        Ref.BooleanRef r6 = new Ref.BooleanRef();
        n0 r1 = new n0(r4, r6, r2);
        com.larus.im.d.e().registerOnGlobalMessageObserver(r1);
        com.larus.im.d.e().m(r4, new m0(r6, r1, r2));
    }

    public final Object b(String r5, String r6, Continuation<? super List<Message>> r7) {
        if ((r7 instanceof MessageHelper$getAnswersByQueryId$1) == false) goto L7;
        MessageHelper$getAnswersByQueryId$1 r0 = (MessageHelper$getAnswersByQueryId$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        String r9 = (String) r0.L$1;
        String r10 = (String) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L19:
        List r11 = (List) r8;
        if (r11 == null) goto L22;
        return r11;
    L22:
        return CollectionsKt.emptyList();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        r0.L$0 = r5;
        r0.L$1 = r6;
        r0.label = 1;
        kotlinx.coroutines.j r12 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r0), 1);
        r12.C();
        com.larus.im.d.e().o(r5, r6, new a(r12));
        r8 = r12.B();
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L17:
        if (r8 != r2) goto L19;
        return r2;
    L7:
        r0 = new MessageHelper$getAnswersByQueryId$1(this, r7);
        goto L8
    }
}

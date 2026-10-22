package com.obric.assistant.chat.impl;

import bda.b$a;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.chat.impl.MessageApiImpl$getSendMessageExt$1", f = "MessageApiImpl.kt", i = {}, l = {144}, m = "invokeSuspend", n = {}, s = {})
public final class MessageApiImpl$getSendMessageExt$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, String> $extras;
    final /* synthetic */ Map<String, String> $originExt;
    final /* synthetic */ b$a $queryData;
    Object L$0;
    int label;

    /* JADX INFO: renamed from: com.obric.assistant.chat.impl.MessageApiImpl$getSendMessageExt$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.chat.impl.MessageApiImpl$getSendMessageExt$1$1", f = "MessageApiImpl.kt", i = {}, l = {145}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<String, ? extends String>>, Object> {
        final /* synthetic */ Map<String, String> $originExt;
        final /* synthetic */ b$a $queryData;
        int label;

        public AnonymousClass1(Map<String, String> r1, b$a r2, Continuation<? super AnonymousClass1> r3) {
            this.$originExt = r1;
            this.$queryData = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$originExt, this.$queryData, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Map<String, String>> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            MessageApiImpl r6 = MessageApiImpl.a;
            Map<String, String> r7 = this.$originExt;
            b$a r2 = this.$queryData;
            this.label = 1;
            r5 = CoroutineScopeKt.coroutineScope(new MessageApiImpl$loopGetSendMessageExt$2(r2, r7, null), this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    public MessageApiImpl$getSendMessageExt$1(Map<String, String> r1, Map<String, String> r2, b$a r3, Continuation<? super MessageApiImpl$getSendMessageExt$1> r4) {
        this.$extras = r1;
        this.$originExt = r2;
        this.$queryData = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MessageApiImpl$getSendMessageExt$1(this.$extras, this.$originExt, this.$queryData, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Map<String, String> r2 = (Map) this.L$0;
        ResultKt.throwOnFailure(r9);
    L12:
        r2.putAll((Map) r9);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        long r3 = ((long) RangesKt.coerceAtMost(MessageApiImpl.c.size(), 3)) * 1000;
        Map<String, String> r10 = this.$extras;
        AnonymousClass1 r4 = new AnonymousClass1(this.$originExt, this.$queryData, null);
        this.L$0 = r10;
        this.label = 1;
        Object r5 = TimeoutKt.b(r3, r4, this);
        if (r5 != r0) goto L11;
        return r0;
    L11:
        r2 = r10;
        r9 = r5;
        goto L12
    }
}

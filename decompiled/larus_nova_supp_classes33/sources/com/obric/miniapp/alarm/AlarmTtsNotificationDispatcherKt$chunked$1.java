package com.obric.miniapp.alarm;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/channels/ProducerScope;", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.alarm.AlarmTtsNotificationDispatcherKt$chunked$1", f = "AlarmTtsNotificationDispatcher.kt", i = {0, 0, 1, 1, 1, 1, 2, 2}, l = {393, 403, 410}, m = "invokeSuspend", n = {"$this$channelFlow", "upstream", "$this$channelFlow", "upstream", "chunk", "start", "$this$channelFlow", "upstream"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "J$0", "L$0", "L$1"})
final class AlarmTtsNotificationDispatcherKt$chunked$1 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.k<? super List<Object>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<Object> $this_chunked;
    final /* synthetic */ long $timeout;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public AlarmTtsNotificationDispatcherKt$chunked$1(Flow<Object> r1, long r2, Continuation<? super AlarmTtsNotificationDispatcherKt$chunked$1> r4) {
        this.$this_chunked = r1;
        this.$timeout = r2;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        AlarmTtsNotificationDispatcherKt$chunked$1 r0 = new AlarmTtsNotificationDispatcherKt$chunked$1(this.$this_chunked, this.$timeout, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((kotlinx.coroutines.channels.k) r1, (Continuation) r2);
    }

    public final Object invoke(kotlinx.coroutines.channels.k<? super List<Object>> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00c1 -> B:23:0x0098). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00d8 -> B:14:0x0067). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r21) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        ReceiveChannel r3 = (ReceiveChannel) this.L$1;
        kotlinx.coroutines.channels.k r7 = (kotlinx.coroutines.channels.k) this.L$0;
        ResultKt.throwOnFailure(r21);
    L13:
        AlarmTtsNotificationDispatcherKt$chunked$1 r8 = this;
    L14:
        r8.L$0 = r7;
        r8.L$1 = r3;
        r8.label = 1;
        Object r9 = r3.receiveCatching-JP2dKIU(r8);
        if (r9 != r1) goto L17;
        return r1;
    L17:
        AlarmTtsNotificationDispatcherKt$chunked$1 r10 = r8;
        Object r11 = r9;
    L18:
        Object r12 = kotlinx.coroutines.channels.g.b(r11);
        if (r12 == null) goto L21;
        ArrayList r13 = new ArrayList();
        r13.add(r12);
        ReceiveChannel r14 = r3;
        ArrayList r4 = r13;
        kotlinx.coroutines.channels.k r15 = r7;
        long r16 = System.currentTimeMillis();
    L23:
        long r17 = System.currentTimeMillis() - r16;
        long r18 = r10.$timeout - r17;
        if (r18 <= 0) goto L29;
        AlarmTtsNotificationDispatcherKt$chunked$1$next$1 r19 = new AlarmTtsNotificationDispatcherKt$chunked$1$next$1(r14, null);
        r10.L$0 = r15;
        r10.L$1 = r14;
        r10.L$2 = r4;
        r10.J$0 = r16;
        r10.label = 2;
        Object r110 = TimeoutKt.c(r18, r19, r10);
        if (r110 != r1) goto L28;
        return r1;
    L28:
        if (r110 == null) goto L29;
        r4.add(r110);
    L29:
        r8 = r10;
        r7 = r15;
        List r5 = CollectionsKt.toList(r4);
        r8.L$0 = r7;
        r8.L$1 = r14;
        r8.L$2 = null;
        r8.label = 3;
        if (r7.send(r5, r8) != r1) goto L34;
        return r1;
    L34:
        r3 = r14;
        goto L14
    L21:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r16 = this.J$0;
        r4 = (ArrayList) this.L$2;
        ReceiveChannel r20 = (ReceiveChannel) this.L$1;
        kotlinx.coroutines.channels.k r111 = (kotlinx.coroutines.channels.k) this.L$0;
        ResultKt.throwOnFailure(r21);
        r110 = r21;
        r15 = r111;
        r14 = r20;
        r10 = this;
        goto L28
    L11:
        r3 = (ReceiveChannel) this.L$1;
        r7 = (kotlinx.coroutines.channels.k) this.L$0;
        ResultKt.throwOnFailure(r21);
        r11 = ((kotlinx.coroutines.channels.g) r21).a;
        r10 = this;
        goto L18
    L12:
        ResultKt.throwOnFailure(r21);
        r7 = (kotlinx.coroutines.channels.k) this.L$0;
        r3 = kotlinx.coroutines.flow.e.z(kotlinx.coroutines.flow.e.d(this.$this_chunked, -2, 2), r7);
        goto L13
    }
}

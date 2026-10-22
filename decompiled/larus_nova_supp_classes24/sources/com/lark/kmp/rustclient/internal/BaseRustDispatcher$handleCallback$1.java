package com.lark.kmp.rustclient.internal;

import com.lark.kmp.pb.basic.v1.Packet;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.lark.kmp.rustclient.internal.BaseRustDispatcher$handleCallback$1", f = "BaseRustDispatcher.kt", i = {}, l = {82, 89}, m = "invokeSuspend", n = {}, s = {})
public final class BaseRustDispatcher$handleCallback$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ rpc.a $data;
    final /* synthetic */ MutableSharedFlow<rpc.a> $flow;
    int label;
    final /* synthetic */ BaseRustDispatcher this$0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Packet.StreamStatus.values().length];
            r0[Packet.StreamStatus.ACTIVE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[Packet.StreamStatus.FINAL_WITHOUT_PAYLOAD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public BaseRustDispatcher$handleCallback$1(rpc.a r1, MutableSharedFlow<rpc.a> r2, BaseRustDispatcher r3, Continuation<? super BaseRustDispatcher$handleCallback$1> r4) {
        this.$data = r1;
        this.$flow = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new BaseRustDispatcher$handleCallback$1(this.$data, this.$flow, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r6);
    L16:
        BaseRustDispatcher r7 = this.this$0;
        long r2 = this.$data.a;
        buc.e<Map<Long, MutableSharedFlow<rpc.a>>> r8 = r7.e;
    L17:
        Object r3 = r8.c();
        if (r8.a(r3, MapsKt.minus((Map) r3, Long.valueOf(r2))) == false) goto L17;
    L28:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
        goto L28
    L10:
        ResultKt.throwOnFailure(r6);
        Packet.StreamStatus r9 = this.$data.g;
        int r10 = a.a[r9.ordinal()];
        if (r10 == 1) goto L24;
        if (r10 == 2) goto L20;
        MutableSharedFlow<rpc.a> r11 = this.$flow;
        rpc.a r4 = this.$data;
        this.label = 2;
        if (r11.emit(r4, this) != r0) goto L16;
        return r0;
    L20:
        BaseRustDispatcher r12 = this.this$0;
        long r5 = this.$data.a;
        buc.e<Map<Long, MutableSharedFlow<rpc.a>>> r13 = r12.e;
    L21:
        Object r14 = r13.c();
        if (r13.a(r14, MapsKt.minus((Map) r14, Long.valueOf(r5))) == false) goto L21;
    L24:
        MutableSharedFlow<rpc.a> r15 = this.$flow;
        rpc.a r16 = this.$data;
        this.label = 1;
        if (r15.emit(r16, this) != r0) goto L28;
        return r0;
    }
}

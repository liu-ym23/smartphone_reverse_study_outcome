package com.ss.android.lark.compose.chatsetting.main.viewmodel;

import com.lark.kmp.pb.basic.v1.Chatter;
import com.lark.kmp.pb.basic.v1.Entity;
import com.lark.kmp.pb.im.v1.GetChatChattersResponse;
import com.ss.android.lark.compose.chatsetting.common.repository.ChatSettingRepository;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/lark/kmp/pb/basic/v1/Chatter;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.main.viewmodel.P2PInfoViewModel$p2pChatter$1", f = "P2PInfoViewModel.kt", i = {0, 1, 2, 3}, l = {31, 33, 34, 36, 38}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "$this$flow", "$this$flow"}, s = {"L$0", "L$0", "L$0", "L$0"})
public final class P2PInfoViewModel$p2pChatter$1 extends SuspendLambda implements Function2<FlowCollector<? super Chatter>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ P2PInfoViewModel this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ P2PInfoViewModel a;
        public final /* synthetic */ FlowCollector<Chatter> b;

        public a(P2PInfoViewModel r1, FlowCollector<? super Chatter> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object emit(Object r2, Continuation r3) {
            Chatter r4 = (Chatter) ((Entity) r2).getChatters().get(P2PInfoViewModel.access$getP2pChatterId$p(this.a));
            if (r4 == null) goto L8;
            Object r5 = this.b.emit(r4, r3);
            if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
            return r5;
        L8:
            return Unit.INSTANCE;
        }
    }

    public P2PInfoViewModel$p2pChatter$1(P2PInfoViewModel r1, Continuation<? super P2PInfoViewModel$p2pChatter$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        P2PInfoViewModel$p2pChatter$1 r0 = new P2PInfoViewModel$p2pChatter$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((FlowCollector) r1, (Continuation) r2);
    }

    public final Object invoke(FlowCollector<? super Chatter> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L16;
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L13;
        if (r1 == 4) goto L12;
        if (r1 != 5) goto L11;
        ResultKt.throwOnFailure(r13);
    L47:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        FlowCollector r2 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r13);
    L43:
        FlowKt__ErrorsKt$catch$.inlined.unsafeFlow.1 r14 = P2PInfoViewModel.access$getRepository$p(this.this$0).k();
        a r3 = new a(this.this$0, r2);
        this.L$0 = null;
        this.L$1 = null;
        this.label = 5;
        if (r14.collect(r3, this) != r0) goto L47;
        return r0;
    L13:
        r2 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r13);
        Object r15 = ((Result) r13).unbox-impl();
    L33:
        P2PInfoViewModel r4 = this.this$0;
        if (Result.isSuccess-impl(r15) == false) goto L36;
        r15 = a((GetChatChattersResponse) r15, r4);
    L36:
        Object r16 = Result.constructor-impl(r15);
        if (Result.isSuccess-impl(r16) == false) goto L43;
        Chatter r5 = (Chatter) r16;
        if (r5 == null) goto L43;
        this.L$0 = r2;
        this.L$1 = r16;
        this.label = 4;
        if (r2.emit(r5, this) != r0) goto L43;
        return r0;
    L14:
        r2 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r13);
    L30:
        ChatSettingRepository r17 = P2PInfoViewModel.access$getRepository$p(this.this$0);
        String r6 = P2PInfoViewModel.access$getP2pChatId$p(this.this$0);
        this.L$0 = r2;
        this.L$1 = null;
        this.label = 3;
        r15 = r17.g(r6, true, 20, this);
        if (r15 != r0) goto L33;
        return r0;
    L15:
        r2 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r13);
        Object r18 = ((Result) r13).unbox-impl();
    L20:
        P2PInfoViewModel r9 = this.this$0;
        if (Result.isSuccess-impl(r18) == false) goto L23;
        r18 = a((GetChatChattersResponse) r18, r9);
    L23:
        Object r19 = Result.constructor-impl(r18);
        if (Result.isSuccess-impl(r19) == false) goto L30;
        Chatter r10 = (Chatter) r19;
        if (r10 == null) goto L30;
        this.L$0 = r2;
        this.L$1 = r19;
        this.label = 2;
        if (r2.emit(r10, this) != r0) goto L30;
        return r0;
    L16:
        ResultKt.throwOnFailure(r13);
        FlowCollector r110 = (FlowCollector) this.L$0;
        ChatSettingRepository r7 = P2PInfoViewModel.access$getRepository$p(this.this$0);
        String r11 = P2PInfoViewModel.access$getP2pChatId$p(this.this$0);
        this.L$0 = r110;
        this.label = 1;
        Object r8 = r7.g(r11, false, 20, this);
        if (r8 != r0) goto L19;
        return r0;
    L19:
        r2 = r110;
        r18 = r8;
        goto L20
    }

    public static final Chatter a(GetChatChattersResponse r1, P2PInfoViewModel r2) {
        Entity.ChatChatter r3 = (Entity.ChatChatter) r1.getEntity().getChat_chatters().get(P2PInfoViewModel.access$getP2pChatId$p(r2));
        if (r3 == null) goto L7;
        Map r4 = r3.getChatters();
        if (r4 == null) goto L7;
        return (Chatter) r4.get(P2PInfoViewModel.access$getP2pChatterId$p(r2));
    L7:
        return null;
    }
}

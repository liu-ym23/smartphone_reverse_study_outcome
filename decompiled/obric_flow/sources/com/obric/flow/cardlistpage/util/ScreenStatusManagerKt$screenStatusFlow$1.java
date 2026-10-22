package com.obric.flow.cardlistpage.util;

import android.content.Context;
import android.content.IntentFilter;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.s;
import kotlinx.coroutines.channels.u;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/channels/u;", "Lcom/obric/flow/cardlistpage/util/f;", "", "<anonymous>", "(Lkotlinx/coroutines/channels/u;)V"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.obric.flow.cardlistpage.util.ScreenStatusManagerKt$screenStatusFlow$1", f = "ScreenStatusManager.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
final class ScreenStatusManagerKt$screenStatusFlow$1 extends SuspendLambda implements Function2<u, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $this_screenStatusFlow;
    private /* synthetic */ Object L$0;
    int label;

    public ScreenStatusManagerKt$screenStatusFlow$1(Context r5, Continuation<? super ScreenStatusManagerKt$screenStatusFlow$1> r10) {
        this.$this_screenStatusFlow = r5;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        ScreenStatusManagerKt$screenStatusFlow$1 r11 = new ScreenStatusManagerKt$screenStatusFlow$1(this.$this_screenStatusFlow, r10);
        r11.L$0 = r5;
        return r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(u r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.content.BroadcastReceiver, com.obric.flow.cardlistpage.util.ScreenStatusManagerKt$screenStatusFlow$1$receiver$1] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        final u r12 = (u) this.L$0;
        final ?? r13 = new ScreenStatusManagerKt$screenStatusFlow$1$receiver$1(r12);
        IntentFilter r14 = new IntentFilter();
        r14.addAction("android.intent.action.SCREEN_ON");
        r14.addAction("android.intent.action.SCREEN_OFF");
        this.$this_screenStatusFlow.registerReceiver(r13, r14);
        final Context r15 = this.$this_screenStatusFlow;
        Function0<Unit> r16 = new AnonymousClass1(r15, r13);
        this.label = 1;
        if (s.a(r12, r16, this) != r5) goto L12;
        return r5;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(u r5, Continuation<? super Unit> r10) {
        return ((ScreenStatusManagerKt$screenStatusFlow$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}

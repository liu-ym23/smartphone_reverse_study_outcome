package com.ss.android.lark.platform.dispatcher;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Landroidx/activity/result/ActivityResult;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.platform.dispatcher.OnActivityResultDispatcherKt$activityResultFlow$1", f = "OnActivityResultDispatcher.kt", i = {}, l = {ItemViewType.ITEM_VIEW_TYPE_AI_KNOWLEDGE}, m = "invokeSuspend", n = {}, s = {})
final class OnActivityResultDispatcherKt$activityResultFlow$1 extends SuspendLambda implements Function2<k<? super ActivityResult>, Continuation<? super Unit>, Object> {
    final /* synthetic */ c $this_activityResultFlow;
    private /* synthetic */ Object L$0;
    int label;

    public static final class a implements d {
        public final /* synthetic */ k<ActivityResult> a;

        public a(k<? super ActivityResult> r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.platform.dispatcher.d
        public final boolean onActivityResult(int r2, int r3, Intent r4) {
            if (r2 == 0) goto L5;
            return false;
        L5:
            Object r5 = this.a.trySend-JP2dKIU(new ActivityResult(r3, r4));
            if ((r5 instanceof kotlinx.coroutines.channels.g.c) == false) goto L10;
            kotlinx.coroutines.channels.g.a(r5);
            return true;
        L10:
            return true;
        }
    }

    public OnActivityResultDispatcherKt$activityResultFlow$1(c r1, Continuation<? super OnActivityResultDispatcherKt$activityResultFlow$1> r2) {
        this.$this_activityResultFlow = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        OnActivityResultDispatcherKt$activityResultFlow$1 r0 = new OnActivityResultDispatcherKt$activityResultFlow$1(this.$this_activityResultFlow, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((k) r1, (Continuation) r2);
    }

    public final Object invoke(k<? super ActivityResult> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        k r7 = (k) this.L$0;
        final a r2 = new a(r7);
        this.$this_activityResultFlow.a(r2);
        final c r4 = this.$this_activityResultFlow;
        Function0<Unit> r3 = new AnonymousClass1(r4, r2);
        this.label = 1;
        if (ProduceKt.a(r7, r3, this) != r0) goto L12;
        return r0;
    }
}

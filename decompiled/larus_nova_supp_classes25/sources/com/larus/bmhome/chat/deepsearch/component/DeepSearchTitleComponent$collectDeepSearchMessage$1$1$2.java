package com.larus.bmhome.chat.deepsearch.component;

import android.content.Context;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.home.impl.sdk.j1;
import com.larus.mainbot.impl.databinding.LarusPageDeepSearchBinding;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.deepsearch.component.DeepSearchTitleComponent$collectDeepSearchMessage$1$1$2", f = "DeepSearchTitleComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DeepSearchTitleComponent$collectDeepSearchMessage$1$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DeepSearchTitleComponent this$0;

    public DeepSearchTitleComponent$collectDeepSearchMessage$1$1$2(DeepSearchTitleComponent r1, Continuation<? super DeepSearchTitleComponent$collectDeepSearchMessage$1$1$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DeepSearchTitleComponent$collectDeepSearchMessage$1$1$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r3);
        DeepSearchTitleComponent r4 = this.this$0;
        int r0 = DeepSearchTitleComponent.r;
        LarusPageDeepSearchBinding r5 = r4.h3();
        if (r5 == null) goto L9;
        AppCompatImageView r6 = r5.c;
        if (r6 == null) goto L9;
        r6.setImageResource(2131242684);
    L9:
        IFlowSdkDepend r7 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r7 == null) goto L12;
        r7.getCollectService();
        j1 r8 = j1.a;
    L12:
        Context r9 = this.this$0.getContext();
        if (r9 == null) goto L15;
        String r10 = r9.getString(2131908413);
    L16:
        if (r10 != null) goto L18;
        r10 = "";
    L18:
        s r1 = s.a;
        Context r2 = this.this$0.getContext();
        r1.getClass();
        s.p(r2, r10);
        return Unit.INSTANCE;
    L15:
        r10 = null;
        goto L16
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

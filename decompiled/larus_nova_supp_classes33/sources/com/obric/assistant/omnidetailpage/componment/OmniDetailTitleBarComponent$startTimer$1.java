package com.obric.assistant.omnidetailpage.componment;

import android.widget.TextView;
import com.larus.common.apphost.AppHost;
import com.larus.utils.e1;
import com.obric.assistant.card.databinding.ObricFragmentOmniDetailBinding;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.memorydata.sdk.entity.search.SearchError;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.omnidetailpage.componment.OmniDetailTitleBarComponent$startTimer$1", f = "OmniDetailTitleBarComponent.kt", i = {0}, l = {ErrorCode.APP_VERSION_TOO_LOW}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class OmniDetailTitleBarComponent$startTimer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ OmniDetailTitleBarComponent this$0;

    public OmniDetailTitleBarComponent$startTimer$1(OmniDetailTitleBarComponent r1, Continuation<? super OmniDetailTitleBarComponent$startTimer$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        OmniDetailTitleBarComponent$startTimer$1 r0 = new OmniDetailTitleBarComponent$startTimer$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r10);
    L11:
        if (CoroutineScopeKt.isActive(r2) == false) goto L28;
        OmniDetailTitleBarComponent r3 = this.this$0;
        if (r3.n <= 0) goto L24;
        ObricFragmentOmniDetailBinding r4 = r3.h3();
        if (r4 == null) goto L19;
        TextView r5 = r4.m;
        if (r5 == null) goto L19;
        e1.x(r5);
    L19:
        long r6 = AppHost.a.getAppClock().currentTimeMillis() / ((long) SearchError.ERR_UNKNOWN);
        OmniDetailTitleBarComponent r7 = this.this$0;
        long r8 = r6 - r7.n;
        ObricFragmentOmniDetailBinding r9 = r7.h3();
        if (r9 == null) goto L24;
        TextView r11 = r9.m;
        if (r11 == null) goto L24;
        r11.setText(this.this$0.Y2(r8));
    L24:
        this.L$0 = r2;
        this.label = 1;
        if (DelayKt.delay(1000, this) != r0) goto L11;
        return r0;
    L28:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        r2 = (CoroutineScope) this.L$0;
        goto L11
    }
}

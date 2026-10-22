package com.ss.android.lark.forwardv3;

import android.app.Activity;
import android.content.Context;
import com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener;
import com.ss.android.lark.forwardv3.data.ForwardErrorResultV3;
import com.ss.android.lark.forwardv3.dependency.IExternalForwardExecutor;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.forwardv3.ExternalForwardSendHelper$executeExternalForward$1", f = "ExternalForwardSendHelper.kt", i = {}, l = {484}, m = "invokeSuspend", n = {}, s = {})
final class ExternalForwardSendHelper$executeExternalForward$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ IExternalForwardExecutor $executor;
    final /* synthetic */ OnForwardContentListener $forwardContentListener;
    final /* synthetic */ List<SearchBaseInfo> $items;
    final /* synthetic */ String $note;
    final /* synthetic */ y.a $resultCallback;
    final /* synthetic */ RichText $richText;
    int label;
    final /* synthetic */ ExternalForwardSendHelper this$0;

    public ExternalForwardSendHelper$executeExternalForward$1(OnForwardContentListener r1, ExternalForwardSendHelper r2, Context r3, y.a r4, List<? extends SearchBaseInfo> r5, IExternalForwardExecutor r6, String r7, RichText r8, Continuation<? super ExternalForwardSendHelper$executeExternalForward$1> r9) {
        this.$forwardContentListener = r1;
        this.this$0 = r2;
        this.$context = r3;
        this.$resultCallback = r4;
        this.$items = r5;
        this.$executor = r6;
        this.$note = r7;
        this.$richText = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new ExternalForwardSendHelper$executeExternalForward$1(this.$forwardContentListener, this.this$0, this.$context, this.$resultCallback, this.$items, this.$executor, this.$note, this.$richText, r12);
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
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        a r11 = (a) r10;
        if ((r11 instanceof a.b) == false) goto L24;
        OnForwardContentListener r3 = this.$forwardContentListener;
        if (r3 != null) goto L16;
        r3 = this.this$0.a.getForwardContentListener();
    L16:
        if (r3 == null) goto L22;
        Context r4 = this.$context;
        if ((r4 instanceof Activity) == false) goto L20;
        Activity r5 = (Activity) r4;
    L21:
        r2 = r3.m(r5, ((a.b) r11).a, true);
        goto L22
    L20:
        r5 = null;
    L22:
        Log.i("NewForward", "external forward success: resultCount=" + ((a.b) r11).a.size() + ", willFinish=" + r2);
        this.$resultCallback.b(new rib.d(r2), this.$items);
    L44:
        return Unit.INSTANCE;
    L24:
        if ((r11 instanceof a.C0071a) == false) goto L36;
        a.C0071a r12 = (a.C0071a) r11;
        Throwable r6 = r12.b;
        if (r6 == null) goto L28;
        Log.e("NewForward", "external forward executor threw an exception", r6);
    L29:
        ExternalForwardSendHelper r7 = this.this$0;
        y.a r8 = this.$resultCallback;
        OnForwardContentListener r9 = this.$forwardContentListener;
        IExternalForwardExecutor.ExternalForwardFailureReason r13 = r12.c;
        int r14 = ExternalForwardSendHelper.d;
        r7.getClass();
        ForwardErrorResultV3 r15 = ExternalForwardSendHelper.b(r13);
        if (r9 != null) goto L32;
        r9 = r7.a.getForwardContentListener();
    L32:
        if (r9 == null) goto L34;
        r9.onFailed(r15.getMessage());
    L34:
        r8.onError(r15);
        goto L44
    L28:
        Log.w("NewForward", "external forward failure: hasRawErrorMsg=" + (true ^ StringsKt.isBlank(r12.a)));
        goto L29
    L36:
        if (Intrinsics.areEqual(r11, a.c.a) == false) goto L46;
        Log.w("NewForward", "external forward timeout: timeoutMillis=15000, itemCount=" + this.$items.size());
        ExternalForwardSendHelper r16 = this.this$0;
        y.a r17 = this.$resultCallback;
        OnForwardContentListener r18 = this.$forwardContentListener;
        int r19 = ExternalForwardSendHelper.d;
        IExternalForwardExecutor.ExternalForwardFailureReason r20 = IExternalForwardExecutor.ExternalForwardFailureReason.UNKNOWN;
        r16.getClass();
        ForwardErrorResultV3 r21 = ExternalForwardSendHelper.b(r20);
        if (r18 != null) goto L40;
        r18 = r16.a.getForwardContentListener();
    L40:
        if (r18 == null) goto L42;
        r18.onFailed(r21.getMessage());
    L42:
        r17.onError(r21);
        goto L44
    L46:
        throw new NoWhenBranchMatchedException();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        final IExternalForwardExecutor r22 = this.$executor;
        final Context r23 = this.$context;
        final List<SearchBaseInfo> r24 = this.$items;
        final String r25 = this.$note;
        final RichText r26 = this.$richText;
        Function2<CoroutineScope, IExternalForwardExecutor.a, Unit> r110 = new ExternalForwardSendHelper$executeExternalForward$1$outcome$1(r22, r23, r24, r25, r26);
        this.label = 1;
        r10 = ExternalForwardSendHelperKt.a(15000, r110, this);
        if (r10 != r0) goto L11;
        return r0;
    }
}

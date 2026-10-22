package com.ss.android.lark.flow.chat.page.flow.plugin.tip;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.chats.BatchGetOnboardingHintRequest;
import com.ss.android.lark.pb.chats.BatchGetOnboardingHintResponse;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.page.flow.plugin.tip.FlowMentionDoubaoTipPlugin$onMentionDoubaoSent$2", f = "FlowMentionDoubaoTipPlugin.kt", i = {}, l = {100, 128}, m = "invokeSuspend", n = {}, s = {})
final class FlowMentionDoubaoTipPlugin$onMentionDoubaoSent$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.ss.android.lark.chat.chatwindow.chat.v2.component.c $chatApp;
    int label;
    final /* synthetic */ a this$0;

    public FlowMentionDoubaoTipPlugin$onMentionDoubaoSent$2(a r1, com.ss.android.lark.chat.chatwindow.chat.v2.component.c r2, Continuation<? super FlowMentionDoubaoTipPlugin$onMentionDoubaoSent$2> r3) {
        this.this$0 = r1;
        this.$chatApp = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new FlowMentionDoubaoTipPlugin$onMentionDoubaoSent$2(this.this$0, this.$chatApp, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        String r1 = null;
        if (r0 != 0) goto L5;
        ResultKt.throwOnFailure(r7);
        new BatchGetOnboardingHintRequest.Builder();
        a r8 = this.this$0;
        com.ss.android.lark.storage.a r2 = a.g;
        r8.getClass();
        throw null;
    L5:
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
        com.larksuite.rucket.job.base.b r9 = (com.larksuite.rucket.job.base.b) r7;
        r9.getClass();
        if ((!(r9 instanceof com.larksuite.rucket.job.base.b.b)) == false) goto L28;
        Map r10 = ((BatchGetOnboardingHintResponse) r9.b()).mconfig_values;
        LinkedHashMap r3 = new LinkedHashMap();
        Iterator r11 = r10.entrySet().iterator();
    L23:
        if (r11.hasNext() == false) goto L27;
        Map.Entry r4 = (Map.Entry) r11.next();
        if (Intrinsics.areEqual(r4.getKey(), "at_doubao_hint") == false) goto L23;
        r3.put(r4.getKey(), r4.getValue());
        goto L23
    L27:
        boolean r12 = Intrinsics.areEqual(CollectionsKt.firstOrNull(r3.values()), Boxing.boxBoolean(true));
    L33:
        if (r12 == false) goto L36;
        a r13 = this.this$0;
        com.ss.android.lark.storage.a r5 = a.g;
        r13.getClass();
        throw null;
    L36:
        a r14 = this.this$0;
        com.ss.android.lark.storage.a r6 = a.g;
        r14.getClass();
        throw null;
    L28:
        StringBuilder r15 = new StringBuilder("onMentionDoubaoSent: batch get onboarding hint failed, result=");
        ErrorResult r16 = r9.a();
        if (r16 == null) goto L31;
        String r17 = r16.getDisplayMsg();
    L32:
        r15.append(r17);
        Log.e("FlowMentionDoubaoTipPlugin", r15.toString());
        r12 = false;
        goto L33
    L31:
        r17 = null;
        goto L32
    L7:
        if (r0 != 2) goto L18;
        ResultKt.throwOnFailure(r7);
        com.larksuite.rucket.job.base.b r18 = (com.larksuite.rucket.job.base.b) r7;
        r18.getClass();
        if ((!(r18 instanceof com.larksuite.rucket.job.base.b.b)) == false) goto L11;
        Log.i("FlowMentionDoubaoTipPlugin", "onMentionDoubaoSent: ack onboarding hint success");
    L16:
        return Unit.INSTANCE;
    L11:
        StringBuilder r19 = new StringBuilder("onMentionDoubaoSent: ack onboarding hint failed, result=");
        ErrorResult r20 = r18.a();
        if (r20 == null) goto L14;
        r1 = r20.getDisplayMsg();
    L14:
        r19.append(r1);
        Log.e("FlowMentionDoubaoTipPlugin", r19.toString());
        goto L16
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

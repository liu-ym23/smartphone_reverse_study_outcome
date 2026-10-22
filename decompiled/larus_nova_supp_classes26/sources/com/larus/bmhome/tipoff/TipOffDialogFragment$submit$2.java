package com.larus.bmhome.tipoff;

import com.google.gson.Gson;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.platform.model.RecommendFrom;
import com.larus.utils.p0;
import com.larus.utils.z;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import tx9.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.tipoff.TipOffDialogFragment$submit$2", f = "TipOffDialogFragment.kt", i = {}, l = {337}, m = "invokeSuspend", n = {}, s = {})
final class TipOffDialogFragment$submit$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TipOffDialogFragment this$0;

    public TipOffDialogFragment$submit$2(TipOffDialogFragment r1, Continuation<? super TipOffDialogFragment$submit$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new TipOffDialogFragment$submit$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L15:
        if (((Boolean) r13).booleanValue() == false) goto L17;
        String r14 = "1";
    L18:
        String r7 = r14;
        TipOffDialogFragment r15 = this.this$0;
        int r2 = r15.g;
        if (r2 != 1) goto L21;
        String r3 = r15.h;
        Gson r4 = z.a;
        JSONObject r16 = z.b(r15.p);
        if (r16 != null) goto L39;
        r16 = new JSONObject();
    L39:
        JSONObject r8 = r16;
        TipOffDialogFragment r9 = this.this$0;
        String r5 = r9.o;
        RecommendFrom r17 = r9.j;
        if (r17 == null) goto L42;
        String r6 = r17.a;
    L43:
        if (r17 == null) goto L45;
        String r10 = r17.b;
    L46:
        f0.b(r3, r5, r6, r10, r7, r8, r9);
    L48:
        return Unit.INSTANCE;
    L45:
        r10 = null;
        goto L46
    L42:
        r6 = null;
        goto L43
    L21:
        if (r2 != 2) goto L48;
        String r11 = r15.i;
        Gson r12 = z.a;
        JSONObject r18 = z.b(r15.p);
        if (r18 != null) goto L26;
        r18 = new JSONObject();
    L26:
        JSONObject r19 = r18;
        TipOffDialogFragment r110 = this.this$0;
        String r20 = r110.o;
        RecommendFrom r111 = r110.j;
        if (r111 == null) goto L30;
        String r112 = r111.a;
        if (r112 == null) goto L30;
    L31:
        String r21 = r112;
        RecommendFrom r113 = this.this$0.j;
        if (r113 == null) goto L34;
        String r22 = r113.b;
    L35:
        ChatControlTrace.b.getClass();
        f0.c(r11, r20, r21, r22, r7, ChatControlTrace.L, ChatControlTrace.M, r19, this.this$0);
        goto L48
    L34:
        r22 = null;
    L30:
        ChatControlTrace.b.getClass();
        r112 = ChatControlTrace.P;
        goto L31
    L17:
        r14 = TriggerSendLoading.NO_LOADING;
        goto L18
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        int r114 = p0.a;
        String r115 = p0.a(this.this$0.i);
        if (r115 != null) goto L11;
        r115 = this.this$0.h;
    L11:
        com.larus.audio.p0 r23 = AudioServiceDelegate.a.getAudioConfig();
        this.label = 1;
        r13 = r23.u(r115, this);
        if (r13 != r0) goto L15;
        return r0;
    }
}

package com.larus.bmhome.chat.component.bottom.voice.service;

import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.voice.d0;
import com.larus.bmhome.utils.a4;
import com.larus.platform.service.i2;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.voice.service.VoiceMixInputService$startVoiceMixInput$1", f = "VoiceMixInputService.kt", i = {}, l = {109, 145}, m = "invokeSuspend", n = {}, s = {})
final class VoiceMixInputService$startVoiceMixInput$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ Function0<Unit> $onBeforeStart;
    final /* synthetic */ Function0<Unit> $onBeforeStop;
    final /* synthetic */ Function0<Unit> $onError;
    final /* synthetic */ Function0<Unit> $onTimeout;
    final /* synthetic */ f $param;
    final /* synthetic */ String $textContext;
    int label;
    final /* synthetic */ VoiceMixInputService this$0;

    public VoiceMixInputService$startVoiceMixInput$1(VoiceMixInputService r1, Function0<Unit> r2, String r3, f r4, FragmentActivity r5, Function0<Unit> r6, Function0<Unit> r7, Function0<Unit> r8, Continuation<? super VoiceMixInputService$startVoiceMixInput$1> r9) {
        this.this$0 = r1;
        this.$onBeforeStart = r2;
        this.$textContext = r3;
        this.$param = r4;
        this.$activity = r5;
        this.$onTimeout = r6;
        this.$onError = r7;
        this.$onBeforeStop = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new VoiceMixInputService$startVoiceMixInput$1(this.this$0, this.$onBeforeStart, this.$textContext, this.$param, this.$activity, this.$onTimeout, this.$onError, this.$onBeforeStop, r12);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r12v0, types: [com.larus.bmhome.chat.component.bottom.voice.service.y, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v0, types: [com.larus.bmhome.chat.component.bottom.voice.service.z, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v0, types: [com.larus.bmhome.chat.component.bottom.voice.service.a0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v21, types: [com.larus.bmhome.chat.component.bottom.voice.service.b0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v14, types: [com.larus.bmhome.chat.component.bottom.voice.service.j] */
    /* JADX WARN: Type inference failed for: r4v1, types: [com.larus.bmhome.chat.component.bottom.voice.service.c0, java.lang.Object] */
    public final Object invokeSuspend(Object r19) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        ResultKt.throwOnFailure(r19);
    L28:
        int r3 = d0.d;
        d0.a.a("real startVoiceMixInput");
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r19);
    L25:
        final VoiceMixInputManager r6 = (VoiceMixInputManager) this.this$0.b.getValue();
        final String r11 = this.$textContext;
        final f r4 = this.$param;
        final String r7 = r4.a;
        final String r8 = r4.b;
        final String r9 = r4.c;
        final FragmentActivity r15 = this.$activity;
        final VoiceMixInputService r5 = this.this$0;
        final Function0<Unit> r10 = this.$onTimeout;
        final ?? r12 = new y(r5, r4, r10, r11);
        final ?? r13 = new z(r5);
        final ?? r14 = new a0(r11, r5);
        final ?? r16 = new b0(r5, r11);
        final Function0<Unit> r17 = this.$onError;
        final Function0<Unit> r18 = this.$onBeforeStop;
        final ?? r20 = new c0(r17, r5, r18);
        r6.getClass();
        Intrinsics.checkNotNullParameter(r11, "textContext");
        Intrinsics.checkNotNullParameter(r7, "conversationId");
        Intrinsics.checkNotNullParameter(r8, "itemId");
        Intrinsics.checkNotNullParameter(r9, "botId");
        Intrinsics.checkNotNullParameter(r15, "activity");
        Intrinsics.checkNotNullParameter(r12, "onStart");
        Intrinsics.checkNotNullParameter(r13, "onAudioData");
        Intrinsics.checkNotNullParameter(r14, "onStream");
        Intrinsics.checkNotNullParameter(r16, "onSuccess");
        Intrinsics.checkNotNullParameter(r20, "onFail");
        int r21 = d0.d;
        d0.a.a("start voice mix input");
        final ?? r22 = new j(r6, r7, r8, r9, r15, r11, r12, r13, r14, r16, r20);
        List r23 = CollectionsKt.mutableListOf(new String[]{"android.permission.RECORD_AUDIO"});
        i2.b.a(r15, r23, new n(r22, r20));
        a4.a.getClass();
        a4.a(a4.b);
        z0<g> r24 = this.this$0.c();
        this.this$0.getClass();
        g r25 = new g(true, VoiceMixInputService.d());
        this.label = 2;
        if (r24.emit(r25, this) != r1) goto L28;
        return r1;
    L10:
        ResultKt.throwOnFailure(r19);
        g r26 = (g) this.this$0.c().getValue();
        if (r26 != null) goto L13;
    L15:
        boolean r27 = false;
    L16:
        if (r27 == true) goto L18;
        this.$onBeforeStart.invoke();
        VoiceMixInputService r28 = this.this$0;
        this.label = 1;
        Object r29 = ((z0) r28.c.getValue()).emit(new byte[0], this);
        if (r29 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L23;
        r29 = Unit.INSTANCE;
    L23:
        if (r29 != r1) goto L25;
        return r1;
    L18:
        return Unit.INSTANCE;
    L13:
        if (r26.a != true) goto L15;
        r27 = true;
        goto L16
    }

    public static final /* synthetic */ Object access$invokeSuspend$lambda$4$suspendConversion0(Function0 r0, Continuation r1) {
        r0.invoke();
        return Unit.INSTANCE;
    }
}

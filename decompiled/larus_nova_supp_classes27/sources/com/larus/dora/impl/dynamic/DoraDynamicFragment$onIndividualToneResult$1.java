package com.larus.dora.impl.dynamic;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.internal.core.conversation.bot.BotServiceImpl;
import com.larus.platform.service.z2;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.DoraDynamicFragment$onIndividualToneResult$1", f = "DoraDynamicFragment.kt", i = {1, 1, 1}, l = {1153, 1157}, m = "invokeSuspend", n = {"botInfo", "it", "fromVoiceId"}, s = {"L$0", "L$2", "L$3"})
final class DoraDynamicFragment$onIndividualToneResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bundle $bundle;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ DoraDynamicFragment this$0;

    public DoraDynamicFragment$onIndividualToneResult$1(Bundle r1, DoraDynamicFragment r2, Continuation<? super DoraDynamicFragment$onIndividualToneResult$1> r3) {
        this.$bundle = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraDynamicFragment$onIndividualToneResult$1(this.$bundle, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r80) {
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        SpeakerVoice r10 = null;
        if (r0 == 0) goto L10;
        if (r0 == 1) goto L9;
        if (r0 != 2) goto L8;
        String r1 = (String) this.L$3;
        w2a.f r2 = (w2a.f) this.L$2;
        LifecycleOwner r3 = (DoraDynamicFragment) this.L$1;
        BotModel r4 = (BotModel) this.L$0;
        ResultKt.throwOnFailure(r80);
        String r16 = r1;
        w2a.f r15 = r2;
        LifecycleOwner r13 = r3;
        BotModel r14 = r4;
        Object r5 = r80;
    L37:
        p2a.m r6 = (p2a.m) r5;
        final SpeakerVoice r12 = (SpeakerVoice) r6.a;
        if ((r6 instanceof p2a.o) == false) goto L43;
        BotServiceImpl r7 = com.larus.im.d.a();
        String r9 = r14.getBotId();
        if (r9 != null) goto L42;
        r9 = "";
    L42:
        r7.updateLocalBot(r9, new h0(r12), null);
        AudioServiceDelegate.a.i0().f(r12);
    L43:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r13), null, null, new DoraDynamicFragment$onIndividualToneResult$1$1$2(r12, r13, r14, r15, r16, r6, null), 3, null);
    L54:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r80);
        Object r11 = r80;
    L13:
        BotModel r17 = (BotModel) r11;
        if (r17 != null) goto L18;
        return Unit.INSTANCE;
    L18:
        if (z2.a.o3().a == false) goto L44;
        w2a.f r18 = w2a.h.a(this.$bundle);
        if (r18 == null) goto L54;
        LifecycleOwner r110 = this.this$0;
        SpeakerVoice r20 = r17.getVoiceType();
        if (r20 == null) goto L24;
        String r111 = r20.getId();
    L25:
        p2a.i r21 = p2a.i.b;
        SpeakerVoice r22 = r17.getVoiceType();
        if (r22 == null) goto L28;
        String r23 = r22.getId();
    L29:
        String r24 = r17.getBotId();
        SpeakerVoice r25 = r17.getVoiceType();
        if (r25 == null) goto L32;
        String r26 = r25.getLanguageCode();
    L33:
        this.L$0 = r17;
        this.L$1 = r110;
        this.L$2 = r18;
        this.L$3 = r111;
        this.label = 2;
        r5 = r21.y2(r18, r23, r24, r26, this);
        if (r5 != r8) goto L36;
        return r8;
    L36:
        r15 = r18;
        r14 = r17;
        r16 = r111;
        r13 = r110;
        goto L37
    L32:
        r26 = null;
        goto L33
    L28:
        r23 = null;
        goto L29
    L24:
        r111 = null;
        goto L25
    L44:
        Serializable r27 = this.$bundle.getSerializable("select_speaker_result");
        if ((r27 instanceof SpeakerVoice) == false) goto L47;
        r10 = (SpeakerVoice) r27;
    L47:
        SpeakerVoice r30 = r10;
        if (r30 == null) goto L54;
        DoraDynamicFragment r28 = this.this$0;
        if (Intrinsics.areEqual(r30.getId(), "none") == false) goto L52;
        DoraDynamicFragment.Y90(r28, BotModel.copy$default(r17, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, r30, null, true, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -655361, Integer.MAX_VALUE, null));
        goto L54
    L52:
        DoraDynamicFragment.Y90(r28, BotModel.copy$default(r17, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, r30, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -655361, Integer.MAX_VALUE, null));
        goto L54
    L10:
        ResultKt.throwOnFailure(r80);
        IBotRepoService r31 = zh8.a.e;
        this.label = 1;
        r11 = IBotRepoService.b.a(r31, "7234781073513644036", false, null, false, this, 30);
        if (r11 != r8) goto L13;
        return r8;
    }
}

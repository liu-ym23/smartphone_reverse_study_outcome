package com.larus.voice_setting.voice.base;

import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.SoundsSource;
import com.larus.audio.controller.GlobalAudioStateEnum;
import com.larus.audio.observer.GlobalAudioObserver;
import com.larus.im.bean.bot.AudioPreview;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.MixVoice;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.voice_setting.voice.TtsSpeakerSettingViewModel;
import com.larus.voice_setting.voice.VoiceItemAdapter;
import com.larus.voice_setting.voice.editvoice.VoicePitchAndRateManager;
import com.larus.voice_setting.voice.o2;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voice_setting.voice.base.VoiceListFragment$executeClick$2", f = "VoiceListFragment.kt", i = {}, l = {180}, m = "invokeSuspend", n = {}, s = {})
public final class VoiceListFragment$executeClick$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SpeakerVoice $voice;
    int label;
    final /* synthetic */ VoiceListFragment this$0;

    public static final class a implements p68.e {
        public final /* synthetic */ SpeakerVoice a;
        public final /* synthetic */ VoiceListFragment b;

        public final void onBegin() {
            GlobalAudioObserver r0 = GlobalAudioObserver.a;
            String r1 = this.a.getStyleId();
            if (r1 != null) goto L5;
            r1 = NameKeys.UnloadStrategy_No_Strategy;
        L5:
            VoiceListFragment r2 = this.b;
            int r3 = VoiceListFragment.x;
            r0.e("trail_listening", r1, r2.ea0());
            r0.c("trail_listening", GlobalAudioStateEnum.PLAYING, this.b.ea0());
        }

        public final void onEnd() {
            VoiceListFragment r0 = this.b;
            int r1 = VoiceListFragment.x;
            if (r0.ba0() == false) goto L38;
            VoiceItemAdapter r2 = this.b.ia0();
            Integer r3 = null;
            if (r2 == null) goto L7;
            List<o2> r4 = r2.a;
        L9:
            if (r4 == null) goto L28;
            SpeakerVoice r5 = this.a;
            Iterator<o2> r6 = r4.iterator();
            int r7 = 0;
        L12:
            if (r6.hasNext() == false) goto L26;
            o2 r8 = r6.next();
            SpeakerVoice r9 = r8.a;
            if (r9 == null) goto L16;
            String r10 = r9.getId();
        L18:
            if (Intrinsics.areEqual(r10, r5.getId()) == true) goto L20;
        L22:
            boolean r11 = false;
        L23:
            if (r11 == true) goto L27;
            r7 = r7 + 1;
        L27:
            r3 = Integer.valueOf(r7);
            goto L28
        L20:
            if (r8.d != 1) goto L22;
            r11 = true;
            goto L23
        L16:
            r10 = null;
            goto L18
        L26:
            r7 = -1;
        L28:
            if (r3 != null) goto L30;
        L34:
            ((TtsSpeakerSettingViewModel) this.b.o.getValue()).getSpeakerVoiceEditModel().t(this.a, "from_tts", 1);
            AudioServiceDelegate.a.O().c(SoundsSource.VOICE_TEST);
            GlobalAudioObserver.a.c("trail_listening", GlobalAudioStateEnum.STOPPED, this.b.ea0());
            return;
        L30:
            if (r3.intValue() == (-1)) goto L34;
            o2 r12 = (o2) CollectionsKt.getOrNull(r4, r3.intValue());
            if (r12 == null) goto L34;
            r12.d = 2;
            goto L34
        L7:
            r4 = null;
            goto L9
        }

        public final void onError() {
            final VoiceListFragment r0 = this.b;
            final SpeakerVoice r1 = this.a;
            com.larus.utils.t0.e(new o1(this, r0, r1));
        }

        public a(SpeakerVoice r1, VoiceListFragment r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public VoiceListFragment$executeClick$2(SpeakerVoice r1, VoiceListFragment r2, Continuation<? super VoiceListFragment$executeClick$2> r3) {
        this.$voice = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new VoiceListFragment$executeClick$2(this.$voice, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L11:
        com.larus.voice_setting.voice.editvoice.b1 r13 = (com.larus.voice_setting.voice.editvoice.b1) r12;
        p2a.q.a().stopAudio();
        a r3 = new a(this.$voice, this.this$0);
        String r4 = null;
        if (r13 != null) goto L14;
    L36:
        com.larus.audio.s0 r5 = p2a.q.a();
        String r6 = this.$voice.getStyleId();
        AudioPreview r14 = this.$voice.getPreview();
        if (r14 == null) goto L39;
        String r7 = r14.getPreviewAudio();
    L40:
        AudioPreview r15 = this.$voice.getPreview();
        if (r15 == null) goto L43;
        String r8 = r15.getMd5();
    L44:
        r5.l(r6, r7, r8, r3, this.$voice.getId(), this.$voice.getName());
    L46:
        return Unit.INSTANCE;
    L43:
        r8 = null;
        goto L44
    L39:
        r7 = null;
        goto L40
    L14:
        if (r13.b() != 0.0f) goto L16;
        boolean r9 = true;
    L17:
        if (r9 == true) goto L19;
    L23:
        com.larus.audio.s0 r10 = p2a.q.a();
        String r11 = this.$voice.getStyleId();
        AudioPreview r16 = this.$voice.getPreview();
        if (r16 == null) goto L26;
        String r17 = r16.getPreviewAudio();
    L27:
        AudioPreview r18 = this.$voice.getPreview();
        if (r18 == null) goto L30;
        r4 = r18.getMd5();
    L30:
        String r19 = r4;
        float r20 = r13.b();
        float r21 = r13.c();
        BotModel r110 = this.this$0.B0();
        if (r110 == null) goto L34;
        String r111 = r110.getBotId();
        if (r111 == null) goto L34;
    L35:
        r10.k(r11, r17, r19, r20, r21, r111, r3);
    L34:
        r111 = "0";
        goto L35
    L26:
        r17 = null;
        goto L27
    L19:
        if (r13.c() == 1.0f) goto L22;
        r2 = false;
    L22:
        if (r2 == true) goto L36;
    L16:
        r9 = false;
        goto L17
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        VoicePitchAndRateManager r112 = VoicePitchAndRateManager.a;
        List r22 = CollectionsKt.listOf(new MixVoice(this.$voice, 0, false, null, 14, null));
        this.label = 1;
        r112.getClass();
        r12 = VoicePitchAndRateManager.c(r22, this);
        if (r12 != r0) goto L11;
        return r0;
    }
}

package com.ss.android.lark.keyboard.plugin.tool.voice.utils;

import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.audio.voiceinput.AudioPluginFeature;
import com.ss.android.lark.audio.voiceinput.AudioPluginUseType;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.keyboard2.KeyboardMenuItemKey;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioKBPlugin;
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
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import y9c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.plugin.tool.voice.utils.AudioPluginHelper$rollbackToOldAudio$1", f = "AudioPluginHelper.kt", i = {}, l = {141, 144, 151}, m = "invokeSuspend", n = {}, s = {})
public final class AudioPluginHelper$rollbackToOldAudio$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AudioPluginHelper this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.voice.utils.AudioPluginHelper$rollbackToOldAudio$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.keyboard.plugin.tool.voice.utils.AudioPluginHelper$rollbackToOldAudio$1$1", f = "AudioPluginHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AudioPluginHelper this$0;

        public AnonymousClass1(AudioPluginHelper r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r5);
            AudioPluginHelper r6 = this.this$0;
            AudioKBPlugin r0 = r6.a;
            AudioKBPlugin r1 = (AudioKBPlugin) r0.n().H().i(KeyboardMenuItemKey.Voice, AudioKBPlugin.class);
            if (r1 == null) goto L7;
            r0.n().H().x(r1);
            r0.n().H().G(new AudioKBPlugin(r6.a));
            r0.n().H().m();
            r0.n().v().g(true);
        L7:
            UDToast.show(this.this$0.a.H(), d.h(2131891315));
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.voice.utils.AudioPluginHelper$rollbackToOldAudio$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.keyboard.plugin.tool.voice.utils.AudioPluginHelper$rollbackToOldAudio$1$2", f = "AudioPluginHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AudioPluginHelper this$0;

        public AnonymousClass2(AudioPluginHelper r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            UDToast.show(this.this$0.a.H(), d.h(2131890455));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public AudioPluginHelper$rollbackToOldAudio$1(AudioPluginHelper r1, Continuation<? super AudioPluginHelper$rollbackToOldAudio$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new AudioPluginHelper$rollbackToOldAudio$1(this.this$0, r3);
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
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 == 3) goto L10;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r10);
    L24:
        return Unit.INSTANCE;
    L11:
        ResultKt.throwOnFailure(r10);
    L16:
        if (((Number) r10).longValue() != AudioPluginUseType.OLD.getType()) goto L20;
        int r11 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.a;
        AudioPluginFeature r12 = AudioPluginFeature.RECORD;
        Intrinsics.checkNotNullParameter(r12, "feat");
        com.ss.android.lark.im.base.a.a().putInt("user_audio_send_tab", r12.getIndex());
        MainCoroutineDispatcher r13 = Dispatchers.getMain();
        AnonymousClass1 r2 = new AnonymousClass1(this.this$0, null);
        this.label = 2;
        if (BuildersKt.withContext(r13, r2, this) != r0) goto L24;
        return r0;
    L20:
        MainCoroutineDispatcher r14 = Dispatchers.getMain();
        AnonymousClass2 r3 = new AnonymousClass2(this.this$0, null);
        this.label = 3;
        if (BuildersKt.withContext(r14, r3, this) != r0) goto L24;
        return r0;
    L12:
        ResultKt.throwOnFailure(r10);
        AudioPluginHelper r15 = this.this$0;
        AudioPluginUseType r4 = AudioPluginUseType.OLD;
        this.label = 1;
        int r5 = AudioPluginHelper.f;
        r15.getClass();
        r10 = BuildersKt.withContext(Dispatchers.getIO(), new AudioPluginHelper$updateUserSettingAudioPluginType$2(r4, null), this);
        if (r10 != r0) goto L16;
        return r0;
    }
}

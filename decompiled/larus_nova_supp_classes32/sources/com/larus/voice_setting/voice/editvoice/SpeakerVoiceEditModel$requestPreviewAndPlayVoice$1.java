package com.larus.voice_setting.voice.editvoice;

import com.larus.im.bean.bot.MixVoice;
import com.larus.im.bean.bot.SpeakerVoice;
import com.obric.aivoice.core.data.NameKeys;
import java.util.List;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voice_setting.voice.editvoice.SpeakerVoiceEditModel$requestPreviewAndPlayVoice$1", f = "SpeakerVoiceEditModel.kt", i = {1}, l = {748, 752, 761}, m = "invokeSuspend", n = {"newVoiceList"}, s = {"L$0"})
final class SpeakerVoiceEditModel$requestPreviewAndPlayVoice$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SpeakerVoiceEditModel this$0;

    /* JADX INFO: renamed from: com.larus.voice_setting.voice.editvoice.SpeakerVoiceEditModel$requestPreviewAndPlayVoice$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voice_setting.voice.editvoice.SpeakerVoiceEditModel$requestPreviewAndPlayVoice$1$1", f = "SpeakerVoiceEditModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SpeakerVoiceEditModel this$0;

        public AnonymousClass1(SpeakerVoiceEditModel r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            this.this$0.x.setValue(Boxing.boxInt(2));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.voice_setting.voice.editvoice.SpeakerVoiceEditModel$requestPreviewAndPlayVoice$1$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voice_setting.voice.editvoice.SpeakerVoiceEditModel$requestPreviewAndPlayVoice$1$3", f = "SpeakerVoiceEditModel.kt", i = {}, l = {763}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SpeakerVoiceEditModel this$0;

        public AnonymousClass3(SpeakerVoiceEditModel r1, Continuation<? super AnonymousClass3> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass3(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            this.this$0.x.setValue(Boxing.boxInt(3));
            MutableSharedFlow<a1> r5 = this.this$0.z;
            a1.b r2 = a1.b.a;
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public SpeakerVoiceEditModel$requestPreviewAndPlayVoice$1(SpeakerVoiceEditModel r1, Continuation<? super SpeakerVoiceEditModel$requestPreviewAndPlayVoice$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new SpeakerVoiceEditModel$requestPreviewAndPlayVoice$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        SpeakerVoice r5 = null;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r9);
    L32:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        SpeakerVoiceEditModel r2 = (SpeakerVoiceEditModel) this.L$1;
        List<MixVoice> r3 = (List) this.L$0;
        ResultKt.throwOnFailure(r9);
    L19:
        r2.q = (w2a.c) r9;
        SpeakerVoiceEditModel r10 = this.this$0;
        w2a.c r4 = r10.q;
        if (r4 == null) goto L28;
        if (r4 == null) goto L32;
        boolean r6 = !r4.d();
        if (r4.d() == true) goto L27;
        MixVoice r7 = (MixVoice) CollectionsKt.getOrNull(r3, 0);
        if (r7 == null) goto L27;
        r5 = r7.getVoiceItem();
    L27:
        r10.m(r6, r5, r4);
        goto L32
    L28:
        MainCoroutineDispatcher r11 = Dispatchers.getMain();
        AnonymousClass3 r8 = new AnonymousClass3(this.this$0, null);
        this.L$0 = null;
        this.L$1 = null;
        this.label = 3;
        if (BuildersKt.withContext(r11, r8, this) != r0) goto L32;
        return r0;
    L11:
        ResultKt.throwOnFailure(r9);
    L15:
        List<MixVoice> r12 = this.this$0.f();
        r2 = this.this$0;
        this.L$0 = r12;
        this.L$1 = r2;
        this.label = 2;
        Object r13 = SpeakerVoiceEditModel.a(r2, r12, this);
        if (r13 != r0) goto L18;
        return r0;
    L18:
        r3 = r12;
        r9 = r13;
        goto L19
    L12:
        ResultKt.throwOnFailure(r9);
        MainCoroutineDispatcher r14 = Dispatchers.getMain();
        AnonymousClass1 r15 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        if (BuildersKt.withContext(r14, r15, this) != r0) goto L15;
        return r0;
    }
}

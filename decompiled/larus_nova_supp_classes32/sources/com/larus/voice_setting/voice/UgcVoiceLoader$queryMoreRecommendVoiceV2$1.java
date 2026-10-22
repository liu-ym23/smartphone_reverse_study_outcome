package com.larus.voice_setting.voice;

import android.os.SystemClock;
import com.larus.audio.bean.GetMatchVoiceRequest;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.voice_setting.voice.bean.RequestType;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voice_setting.voice.UgcVoiceLoader$queryMoreRecommendVoiceV2$1", f = "UgcVoiceLoader.kt", i = {0}, l = {951}, m = "invokeSuspend", n = {"status"}, s = {"I$0"})
public final class UgcVoiceLoader$queryMoreRecommendVoiceV2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isMainBot;
    final /* synthetic */ GetMatchVoiceRequest $param;
    final /* synthetic */ Ref.LongRef $startTime;
    int I$0;
    int label;

    public UgcVoiceLoader$queryMoreRecommendVoiceV2$1(GetMatchVoiceRequest r1, Ref.LongRef r2, boolean r3, Continuation<? super UgcVoiceLoader$queryMoreRecommendVoiceV2$1> r4) {
        this.$param = r1;
        this.$startTime = r2;
        this.$isMainBot = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new UgcVoiceLoader$queryMoreRecommendVoiceV2$1(this.$param, this.$startTime, this.$isMainBot, r5);
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
        int r2 = this.I$0;
        ResultKt.throwOnFailure(r13);
    L12:
        com.larus.network.http.y r14 = (com.larus.network.http.a) r13;
        int r4 = 0;
        if ((r14 instanceof com.larus.network.http.y) == false) goto L35;
        com.larus.network.http.y r15 = r14;
        r2a.g r3 = (r2a.g) ((com.larus.network.http.a) r15).b;
        if (r3 == null) goto L33;
        List<SpeakerVoice> r5 = r3.b();
        if (r5 == null) goto L33;
        r2a.e r6 = (r2a.e) UgcVoiceLoader.l.getValue();
        if (r6 == null) goto L24;
        List<SpeakerVoice> r7 = r6.a;
        if (r7 == null) goto L24;
        List r8 = CollectionsKt.toMutableList(r7);
        if (r8 == null) goto L24;
    L25:
        r8.addAll(r5);
        r2a.g r16 = (r2a.g) ((com.larus.network.http.a) r15).b;
        if (r16 == null) goto L28;
        boolean r17 = Intrinsics.areEqual(r16.a(), Boxing.boxBoolean(true));
    L29:
        if (r17 == true) goto L32;
        r4 = 2;
    L32:
        UgcVoiceLoader.k.postValue(new r2a.e(r8, Boxing.boxInt(r4), Boxing.boxInt(3), 16));
        goto L33
    L28:
        r17 = false;
    L24:
        r8 = new ArrayList();
    L33:
        int r9 = 1;
    L45:
        long r10 = SystemClock.uptimeMillis() - this.$startTime.element;
        com.larus.voice_setting.voice.base.g1 r18 = com.larus.voice_setting.voice.base.g1.a;
        com.larus.voice_setting.voice.base.g1.g(r10, RequestType.LOAD_MORE, r9, false, this.$isMainBot);
        return Unit.INSTANCE;
    L35:
        if ((r14 instanceof com.larus.network.http.f) == false) goto L44;
        r2a.e r19 = (r2a.e) UgcVoiceLoader.l.getValue();
        if (r19 == null) goto L42;
        List<SpeakerVoice> r110 = r19.a;
        if (r110 == null) goto L42;
        List r111 = CollectionsKt.toMutableList(r110);
        if (r111 == null) goto L42;
    L43:
        UgcVoiceLoader.k.postValue(new r2a.e(r111, Boxing.boxInt(1), Boxing.boxInt(1), 16));
        r9 = 0;
    L42:
        r111 = new ArrayList();
        goto L43
    L44:
        r9 = r2;
        goto L45
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        UgcVoiceLoader.c++;
        UgcVoiceLoader r112 = UgcVoiceLoader.a;
        GetMatchVoiceRequest r11 = this.$param;
        int r12 = UgcVoiceLoader.c;
        this.I$0 = -1;
        this.label = 1;
        r13 = UgcVoiceLoader.c(r112, r11, r12, this);
        if (r13 != r0) goto L11;
        return r0;
    L11:
        r2 = -1;
        goto L12
    }
}

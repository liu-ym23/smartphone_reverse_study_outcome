package com.larus.voice_setting.voice;

import android.os.SystemClock;
import com.larus.audio.bean.GetMatchVoiceRequest;
import com.larus.audio.bean.RecommendScene;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.voice_setting.voice.bean.CacheStatus;
import com.larus.voice_setting.voice.bean.RequestType;
import com.obric.aivoice.core.data.NameKeys;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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
@DebugMetadata(c = "com.larus.voice_setting.voice.UgcVoiceLoader$preLoadRecommendVoiceListV2$1", f = "UgcVoiceLoader.kt", i = {0}, l = {912}, m = "invokeSuspend", n = {"status"}, s = {"I$0"})
final class UgcVoiceLoader$preLoadRecommendVoiceListV2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isMainBot;
    final /* synthetic */ GetMatchVoiceRequest $param;
    final /* synthetic */ boolean $preload;
    final /* synthetic */ Ref.LongRef $startTime;
    int I$0;
    int label;

    public UgcVoiceLoader$preLoadRecommendVoiceListV2$1(GetMatchVoiceRequest r1, Ref.LongRef r2, boolean r3, boolean r4, Continuation<? super UgcVoiceLoader$preLoadRecommendVoiceListV2$1> r5) {
        this.$param = r1;
        this.$startTime = r2;
        this.$preload = r3;
        this.$isMainBot = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new UgcVoiceLoader$preLoadRecommendVoiceListV2$1(this.$param, this.$startTime, this.$preload, this.$isMainBot, r8);
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
        if ((r14 instanceof com.larus.network.http.y) == false) goto L32;
        com.larus.network.http.y r15 = r14;
        r2a.g r3 = (r2a.g) ((com.larus.network.http.a) r15).b;
        if (r3 == null) goto L30;
        List<SpeakerVoice> r5 = r3.b();
        if (r5 == null) goto L30;
        r2a.g r16 = (r2a.g) ((com.larus.network.http.a) r15).b;
        if (r16 == null) goto L21;
        boolean r17 = Intrinsics.areEqual(r16.a(), Boxing.boxBoolean(true));
    L22:
        if (r17 == true) goto L25;
        r4 = 2;
    L25:
        UgcVoiceLoader r18 = UgcVoiceLoader.a;
        if (r5.isEmpty() == false) goto L28;
        RecommendScene r19 = RecommendScene.NULL;
        Intrinsics.checkNotNullParameter(r19, "<set-?>");
        UgcVoiceLoader.n = r19;
        CacheStatus r110 = CacheStatus.EMPTY;
    L29:
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        UgcVoiceLoader.m = r110;
        UgcVoiceLoader.k.postValue(new r2a.e(r5, Boxing.boxInt(r4), Boxing.boxInt(3), 16));
        goto L30
    L28:
        r110 = CacheStatus.CACHED;
        goto L29
    L21:
        r17 = false;
    L30:
        int r9 = 1;
    L35:
        long r6 = SystemClock.uptimeMillis() - this.$startTime.element;
        com.larus.voice_setting.voice.base.g1 r111 = com.larus.voice_setting.voice.base.g1.a;
        com.larus.voice_setting.voice.base.g1.g(r6, RequestType.INIT, r9, this.$preload, this.$isMainBot);
        return Unit.INSTANCE;
    L32:
        if ((r14 instanceof com.larus.network.http.f) == false) goto L34;
        UgcVoiceLoader r112 = UgcVoiceLoader.a;
        CacheStatus r113 = CacheStatus.EMPTY;
        Intrinsics.checkNotNullParameter(r113, "<set-?>");
        UgcVoiceLoader.m = r113;
        RecommendScene r114 = RecommendScene.NULL;
        Intrinsics.checkNotNullParameter(r114, "<set-?>");
        UgcVoiceLoader.n = r114;
        UgcVoiceLoader.k.postValue(new r2a.e(null, Boxing.boxInt(1), Boxing.boxInt(1), 16));
        r9 = 0;
        goto L35
    L34:
        r9 = r2;
        goto L35
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        UgcVoiceLoader r115 = UgcVoiceLoader.a;
        GetMatchVoiceRequest r7 = this.$param;
        this.I$0 = -1;
        this.label = 1;
        r13 = UgcVoiceLoader.c(r115, r7, 1, this);
        if (r13 != r0) goto L11;
        return r0;
    L11:
        r2 = -1;
        goto L12
    }
}

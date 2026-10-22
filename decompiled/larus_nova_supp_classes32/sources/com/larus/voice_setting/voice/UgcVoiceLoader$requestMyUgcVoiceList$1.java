package com.larus.voice_setting.voice;

import com.larus.im.bean.bot.SpeakerVoice;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voice_setting.voice.UgcVoiceLoader$requestMyUgcVoiceList$1", f = "UgcVoiceLoader.kt", i = {}, l = {677}, m = "invokeSuspend", n = {}, s = {})
public final class UgcVoiceLoader$requestMyUgcVoiceList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $languageCode;
    int label;

    public UgcVoiceLoader$requestMyUgcVoiceList$1(String r1, Continuation<? super UgcVoiceLoader$requestMyUgcVoiceList$1> r2) {
        this.$languageCode = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new UgcVoiceLoader$requestMyUgcVoiceList$1(this.$languageCode, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L11:
        com.larus.network.http.y r9 = (com.larus.network.http.a) r8;
        if ((r9 instanceof com.larus.network.http.y) == false) goto L41;
        com.larus.network.http.y r10 = r9;
        r2a.g r2 = (r2a.g) ((com.larus.network.http.a) r10).b;
        if (r2 == null) goto L34;
        List<SpeakerVoice> r3 = r2.b();
        if (r3 == null) goto L34;
        ArrayList r4 = new ArrayList();
        Iterator<T> r5 = r3.iterator();
    L19:
        if (r5.hasNext() == false) goto L26;
        Object r6 = r5.next();
        if (((SpeakerVoice) r6).getStatus() == 2) goto L23;
        boolean r7 = true;
    L24:
        if (r7 == false) goto L19;
        r4.add(r6);
        goto L19
    L23:
        r7 = false;
        goto L24
    L26:
        UgcVoiceLoader r11 = UgcVoiceLoader.a;
        monitor-enter(r11);
        List<SpeakerVoice> r12 = UgcVoiceLoader.e;     // Catch: Throwable -> L31
        ((ArrayList) r12).clear();     // Catch: Throwable -> L31
        ((ArrayList) r12).addAll(r4);     // Catch: Throwable -> L31
        List<SpeakerVoice> r13 = UgcVoiceLoader.E;     // Catch: Throwable -> L31
        ((CopyOnWriteArrayList) r13).clear();     // Catch: Throwable -> L31
        ((CopyOnWriteArrayList) r13).addAll(r4);     // Catch: Throwable -> L31
        monitor-exit(r11);
        UgcVoiceLoader.i.postValue(new r2a.i(3, r4));
    L31:
        th = move-exception;
        throw th;
    L34:
        r2a.g r14 = (r2a.g) ((com.larus.network.http.a) r10).b;
        if (r14 == null) goto L37;
        boolean r15 = Intrinsics.areEqual(r14.a(), Boxing.boxBoolean(true));
    L38:
        if (r15 == false) goto L40;
        UgcVoiceLoader.C.postValue(Boxing.boxInt(0));
    L43:
        return Unit.INSTANCE;
    L40:
        UgcVoiceLoader.C.postValue(Boxing.boxInt(2));
        goto L43
    L37:
        r15 = false;
        goto L38
    L41:
        UgcVoiceLoader.i.postValue(new r2a.i(1, CollectionsKt.emptyList()));
        goto L43
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        UgcVoiceLoader.b = 1;
        String r16 = this.$languageCode;
        this.label = 1;
        r8 = UgcVoiceLoader.d(1, r16, this);
        if (r8 != r0) goto L11;
        return r0;
    }
}

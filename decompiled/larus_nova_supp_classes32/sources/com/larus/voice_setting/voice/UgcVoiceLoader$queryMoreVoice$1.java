package com.larus.voice_setting.voice;

import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.utils.logger.FLogger;
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
@DebugMetadata(c = "com.larus.voice_setting.voice.UgcVoiceLoader$queryMoreVoice$1", f = "UgcVoiceLoader.kt", i = {}, l = {703}, m = "invokeSuspend", n = {}, s = {})
public final class UgcVoiceLoader$queryMoreVoice$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $languageCode;
    int label;

    public UgcVoiceLoader$queryMoreVoice$1(String r1, Continuation<? super UgcVoiceLoader$queryMoreVoice$1> r2) {
        this.$languageCode = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new UgcVoiceLoader$queryMoreVoice$1(this.$languageCode, r3);
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
        if ((r9 instanceof com.larus.network.http.y) == false) goto L49;
        com.larus.network.http.y r10 = r9;
        r2a.g r2 = (r2a.g) ((com.larus.network.http.a) r10).b;
        if (r2 == null) goto L41;
        List<SpeakerVoice> r3 = r2.b();
        if (r3 == null) goto L41;
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
        if (r4.isEmpty() == true) goto L40;
        List<SpeakerVoice> r12 = UgcVoiceLoader.E;
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator r14 = ((CopyOnWriteArrayList) r12).iterator();
    L31:
        if (r14.hasNext() == false) goto L33;
        r13.add(((SpeakerVoice) r14.next()).getId());
        goto L31
    L33:
        Iterator r15 = r4.iterator();
    L35:
        if (r15.hasNext() == false) goto L39;
        SpeakerVoice r16 = (SpeakerVoice) r15.next();
        if (r13.contains(r16.getId()) == true) goto L35;
        ((CopyOnWriteArrayList) UgcVoiceLoader.E).add(r16);
        goto L35
    L39:
        FLogger.a.i("UgcVoiceLoader", "distinctVoiceList: before: " + r13.size() + ", after: " + ((CopyOnWriteArrayList) UgcVoiceLoader.E).size());
    L40:
        UgcVoiceLoader.i.postValue(new r2a.i(3, UgcVoiceLoader.E));
    L41:
        r2a.g r17 = (r2a.g) ((com.larus.network.http.a) r10).b;
        if (r17 == null) goto L44;
        boolean r18 = Intrinsics.areEqual(r17.a(), Boxing.boxBoolean(true));
    L45:
        if (r18 == false) goto L47;
        UgcVoiceLoader.C.postValue(Boxing.boxInt(0));
    L52:
        return Unit.INSTANCE;
    L47:
        UgcVoiceLoader.C.postValue(Boxing.boxInt(2));
        goto L52
    L44:
        r18 = false;
        goto L45
    L49:
        if ((r9 instanceof com.larus.network.http.f) == false) goto L52;
        UgcVoiceLoader.C.postValue(Boxing.boxInt(1));
        goto L52
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        int r19 = UgcVoiceLoader.b + 1;
        UgcVoiceLoader.b = r19;
        String r20 = this.$languageCode;
        this.label = 1;
        r8 = UgcVoiceLoader.d(r19, r20, this);
        if (r8 != r0) goto L11;
        return r0;
    }
}

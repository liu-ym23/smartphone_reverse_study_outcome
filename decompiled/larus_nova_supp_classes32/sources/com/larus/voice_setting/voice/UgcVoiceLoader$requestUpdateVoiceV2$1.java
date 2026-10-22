package com.larus.voice_setting.voice;

import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.network.http.HttpExtKt;
import com.miui.easygo.constant.EasyGoDbTable;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Iterator;
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
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voice_setting.voice.UgcVoiceLoader$requestUpdateVoiceV2$1", f = "UgcVoiceLoader.kt", i = {}, l = {651}, m = "invokeSuspend", n = {}, s = {})
final class UgcVoiceLoader$requestUpdateVoiceV2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isPublic;
    final /* synthetic */ String $voiceId;
    final /* synthetic */ String $voiceName;
    final /* synthetic */ String $voiceUri;
    int label;

    public UgcVoiceLoader$requestUpdateVoiceV2$1(String r1, String r2, String r3, boolean r4, Continuation<? super UgcVoiceLoader$requestUpdateVoiceV2$1> r5) {
        this.$voiceId = r1;
        this.$voiceName = r2;
        this.$voiceUri = r3;
        this.$isPublic = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new UgcVoiceLoader$requestUpdateVoiceV2$1(this.$voiceId, this.$voiceName, this.$voiceUri, this.$isPublic, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L11:
        com.larus.network.http.y r15 = (com.larus.network.http.a) r14;
        boolean r2 = r15 instanceof com.larus.network.http.y;
        if (r2 == false) goto L37;
        SpeakerVoice r3 = (SpeakerVoice) ((com.larus.network.http.a) r15).b;
        if (r3 == null) goto L37;
        UgcVoiceLoader r4 = UgcVoiceLoader.a;
        Iterator r5 = ((ArrayList) UgcVoiceLoader.e).iterator();
    L16:
        SpeakerVoice r6 = null;
        if (r5.hasNext() == false) goto L21;
        Object r7 = r5.next();
        if (Intrinsics.areEqual(((SpeakerVoice) r7).getId(), r3.getId()) == false) goto L16;
    L22:
        SpeakerVoice r8 = (SpeakerVoice) r7;
        if (r8 == null) goto L25;
        r8.setName(r3.getName());
        r8.setIcon(r3.getIcon());
        r8.setPrivateStatus(r3.getPrivateStatus());
    L25:
        Iterator r9 = ((ArrayList) UgcVoiceLoader.f).iterator();
    L27:
        if (r9.hasNext() == false) goto L31;
        Object r10 = r9.next();
        if (Intrinsics.areEqual(((SpeakerVoice) r10).getId(), r3.getId()) == false) goto L27;
    L32:
        SpeakerVoice r11 = (SpeakerVoice) r10;
        if (r11 == null) goto L35;
        r11.setName(r3.getName());
        r11.setIcon(r3.getIcon());
        r11.setPrivateStatus(r3.getPrivateStatus());
        r6 = r11;
    L35:
        if (r6 == null) goto L37;
        UgcVoiceLoader.u();
        goto L37
    L31:
        r10 = null;
        goto L32
    L21:
        r7 = null;
    L37:
        if (r2 == false) goto L39;
        long r12 = 1;
    L40:
        tx9.e0.c(Boxing.boxLong(r12));
        UgcVoiceLoader.A.postValue(r15);
        return Unit.INSTANCE;
    L39:
        r12 = 0;
        goto L40
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        JSONObject r13 = new JSONObject();
        String r16 = this.$voiceId;
        String r17 = this.$voiceName;
        String r18 = this.$voiceUri;
        boolean r19 = this.$isPublic;
        r13.put("ugc_voice_id", r16);
        r13.put(EasyGoDbTable.Server.NAME, r17);
        r13.put("icon", r18);
        r13.put("private_status", r19 ? 1 : 0);
        Unit r20 = Unit.INSTANCE;
        this.label = 1;
        r14 = HttpExtKt.k("Social", SpeakerVoice.class, "/alice/user_voice/update", r13, null, null, false, null, null, null, this, 1008);
        if (r14 != r0) goto L11;
        return r0;
    }
}

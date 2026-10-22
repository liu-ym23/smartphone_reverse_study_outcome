package com.larus.voice_setting.voice;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.network.http.HttpExtKt;
import com.miui.easygo.constant.EasyGoDbTable;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voice_setting.voice.UgcVoiceLoader$requestCreateUgcVoiceV2$1", f = "UgcVoiceLoader.kt", i = {}, l = {609}, m = "invokeSuspend", n = {}, s = {})
public final class UgcVoiceLoader$requestCreateUgcVoiceV2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $avatarUri;
    final /* synthetic */ boolean $isPublic;
    final /* synthetic */ String $localVoiceId;
    final /* synthetic */ String $voiceName;
    int label;

    public UgcVoiceLoader$requestCreateUgcVoiceV2$1(String r1, String r2, String r3, boolean r4, Continuation<? super UgcVoiceLoader$requestCreateUgcVoiceV2$1> r5) {
        this.$localVoiceId = r1;
        this.$voiceName = r2;
        this.$avatarUri = r3;
        this.$isPublic = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new UgcVoiceLoader$requestCreateUgcVoiceV2$1(this.$localVoiceId, this.$voiceName, this.$avatarUri, this.$isPublic, r8);
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
        if ((r15 instanceof com.larus.network.http.y) == false) goto L18;
        SpeakerVoice r2 = (SpeakerVoice) ((com.larus.network.http.a) r15).b;
        if (r2 == null) goto L18;
        String r3 = this.$localVoiceId;
        if (r2.getNameStatus() == 3) goto L18;
        UgcVoiceLoader r4 = UgcVoiceLoader.a;
        UgcVoiceLoader.g(r3, r2);
        ListProtector.add(UgcVoiceLoader.E, 0, r2);
    L18:
        UgcVoiceLoader.y.postValue(new r2a.c(r15, this.$localVoiceId, 4));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        JSONObject r5 = new JSONObject();
        String r6 = this.$voiceName;
        String r7 = this.$localVoiceId;
        String r8 = this.$avatarUri;
        boolean r9 = this.$isPublic;
        r5.put(EasyGoDbTable.Server.NAME, r6);
        r5.put("local_voice_id", r7);
        r5.put("icon", r8);
        r5.put("private_status", r9 ? 1 : 0);
        Unit r10 = Unit.INSTANCE;
        this.label = 1;
        r14 = HttpExtKt.k("Social", SpeakerVoice.class, "/alice/user_voice/create/v2", r5, null, null, false, null, null, null, this, 1008);
        if (r14 != r0) goto L11;
        return r0;
    }
}

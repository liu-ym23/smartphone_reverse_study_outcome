package com.larus.voice_setting.voice;

import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.IconItem;
import com.larus.network.http.AsyncThrowable;
import com.larus.network.http.HttpExtKt;
import com.larus.utils.livedata.NonStickyLiveData;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.RiskPreferenceSettings;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voice_setting.voice.UgcVoiceLoader$requestUploadVoice$1", f = "UgcVoiceLoader.kt", i = {}, l = {223, 269}, m = "invokeSuspend", n = {}, s = {})
public final class UgcVoiceLoader$requestUploadVoice$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $enterMethod;
    final /* synthetic */ String $filePath;
    final /* synthetic */ String $freeTalkContent;
    final /* synthetic */ IconItem $iconItem;
    final /* synthetic */ boolean $isFromVoiceCloneScheme;
    final /* synthetic */ String $languageCode;
    final /* synthetic */ String $localVoiceId;
    final /* synthetic */ String $previousPage;
    final /* synthetic */ boolean $replaceVoice;
    final /* synthetic */ String $voiceName;
    int label;

    public UgcVoiceLoader$requestUploadVoice$1(String r1, String r2, String r3, String r4, String r5, IconItem r6, boolean r7, String r8, String r9, boolean r10, Continuation<? super UgcVoiceLoader$requestUploadVoice$1> r11) {
        this.$filePath = r1;
        this.$localVoiceId = r2;
        this.$freeTalkContent = r3;
        this.$languageCode = r4;
        this.$voiceName = r5;
        this.$iconItem = r6;
        this.$replaceVoice = r7;
        this.$previousPage = r8;
        this.$enterMethod = r9;
        this.$isFromVoiceCloneScheme = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        return new UgcVoiceLoader$requestUploadVoice$1(this.$filePath, this.$localVoiceId, this.$freeTalkContent, this.$languageCode, this.$voiceName, this.$iconItem, this.$replaceVoice, this.$previousPage, this.$enterMethod, this.$isFromVoiceCloneScheme, r14);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L10;
        if (r0 == 1) goto L9;
        if (r0 != 2) goto L8;
        ResultKt.throwOnFailure(r19);
    L38:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r19);
        Object r1 = r19;
    L17:
        final com.larus.network.http.y r2 = (com.larus.network.http.a) r1;
        if ((r2 instanceof com.larus.network.http.y) == false) goto L35;
        r2a.h r3 = (r2a.h) ((com.larus.network.http.a) r2).b;
        if (r3 == null) goto L22;
        String r4 = r3.a();
    L23:
        if (r4 != null) goto L25;
    L28:
        boolean r16 = true;
    L29:
        if (r16 == false) goto L31;
        f2a.c r5 = com.larus.voice_setting.voice.utils.k.a.b("request upload file success, but uploadUri is empty");
        final String r14 = this.$localVoiceId;
        final String r6 = this.$enterMethod;
        r5.e(new f2(r2, r14, r6));
        r5.c.b = CollectionsKt.listOf("VoiceCreate");
        f2a.c.c(r5, null, 15);
        int r7 = y2a.a.a;
        JSONObject r8 = new JSONObject();
        boolean r9 = this.$isFromVoiceCloneScheme;
        String r10 = this.$enterMethod;
        r8.put("is_scheme", y2a.b.b(r9));
        r8.put("enter_method", y2a.b.a(r10));
        r8.put("result", "Fail");
        r8.put("reason", "AudioUploadFail");
        JSONObject r11 = new JSONObject();
        r11.put("message", "upload_uri is null or empty");
        Unit r12 = Unit.INSTANCE;
        r8.put("reason_detail", r11.toString());
        y2a.a.a(r8);
        NonStickyLiveData<r2a.c> r15 = UgcVoiceLoader.o;
        AsyncThrowable.Companion.getClass();
        r15.postValue(new r2a.c(new com.larus.network.http.f(AsyncThrowable.access$getDEFAULT$cp(), null), this.$localVoiceId, 4));
        goto L38
    L31:
        f2a.c r17 = com.larus.voice_setting.voice.utils.k.a.b("request upload file success");
        final String r18 = this.$localVoiceId;
        final String r20 = this.$enterMethod;
        r17.e(new g2(r18, r20));
        r17.c.b = CollectionsKt.listOf("VoiceCreate");
        f2a.c.c(r17, null, 15);
        UgcVoiceLoader r21 = UgcVoiceLoader.a;
        String r22 = this.$freeTalkContent;
        String r23 = this.$languageCode;
        String r24 = this.$localVoiceId;
        String r25 = this.$voiceName;
        IconItem r26 = this.$iconItem;
        boolean r27 = this.$replaceVoice;
        String r28 = this.$previousPage;
        String r29 = this.$enterMethod;
        boolean r110 = this.$isFromVoiceCloneScheme;
        this.label = 2;
        if (UgcVoiceLoader.e(r21, r4, r22, r23, r24, r25, r26, r27, r28, r29, r110, this) != r13) goto L38;
        return r13;
    L25:
        if (r4.length() == 0) goto L28;
        r16 = false;
        goto L29
    L22:
        r4 = null;
        goto L23
    L35:
        if ((r2 instanceof com.larus.network.http.f) == false) goto L38;
        FLogger r30 = FLogger.a;
        StringBuilder r31 = new StringBuilder("requestUploadVoice fail, error=");
        com.larus.network.http.f r32 = (com.larus.network.http.f) r2;
        r31.append(r32.d);
        r31.append(", localVoiceId=");
        r31.append(this.$localVoiceId);
        r31.append(", ");
        r30.e("UgcVoiceLoader", r31.toString(), r32.d);
        int r33 = y2a.a.a;
        JSONObject r34 = new JSONObject();
        boolean r35 = this.$isFromVoiceCloneScheme;
        String r111 = this.$enterMethod;
        r34.put("is_scheme", y2a.b.b(r35));
        r34.put("enter_method", y2a.b.a(r111));
        r34.put("result", "Fail");
        r34.put("reason", "AudioUploadFail");
        JSONObject r36 = new JSONObject();
        r36.put(LynxResourceModule.CODE_KEY, r32.d.getCode());
        r36.put("message", r32.d.getMessage());
        Unit r37 = Unit.INSTANCE;
        r34.put("reason_detail", r36.toString());
        y2a.a.a(r34);
        f2a.c r38 = com.larus.voice_setting.voice.utils.k.a.b("request upload file fail");
        final String r39 = this.$localVoiceId;
        final String r40 = this.$enterMethod;
        r38.e(new h2(r2, r39, r40));
        r38.c.b = CollectionsKt.listOf("VoiceCreate");
        f2a.c.c(r38, null, 15);
        UgcVoiceLoader.o.postValue(new r2a.c(new com.larus.network.http.f(r32.d, null), this.$localVoiceId, 4));
        UgcVoiceLoader.y.postValue(new r2a.c(new com.larus.network.http.f(r32.d, null), this.$localVoiceId, 4));
        goto L38
    L10:
        ResultKt.throwOnFailure(r19);
        f2a.c r41 = com.larus.voice_setting.voice.utils.k.a.b("request upload file");
        final String r42 = this.$localVoiceId;
        final String r43 = this.$voiceName;
        final String r44 = this.$enterMethod;
        r41.e(new e2(r42, r43, r44));
        r41.c.b = CollectionsKt.listOf("VoiceCreate");
        f2a.c.c(r41, null, 15);
        if (AppHost.a.isOversea() == false) goto L13;
        String r45 = "/alice/user_voice/upload";
    L14:
        String r46 = this.$filePath;
        Map r47 = MapsKt.mapOf(new Pair[]{TuplesKt.to("biz_type", RiskPreferenceSettings.AUTONOMY_FIRST), TuplesKt.to("file_type", "wav")});
        this.label = 1;
        r1 = HttpExtKt.f("Social", r2a.h.class, r45, LynxResourceModule.DATA_KEY, r46, r47, null, this, 64);
        if (r1 != r13) goto L17;
        return r13;
    L13:
        r45 = "/alice/upload/file";
        goto L14
    }
}

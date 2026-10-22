package com.obric.assistant.settings.voiceprint;

import com.larus.applog.api.IApplog;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.voiceprint.VoicePrintTrackHelper$clickEnhancedVoiceprintRecord$1", f = "VoicePrintTrackHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class VoicePrintTrackHelper$clickEnhancedVoiceprintRecord$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cardContentType;
    final /* synthetic */ String $cardType;
    int label;

    public VoicePrintTrackHelper$clickEnhancedVoiceprintRecord$1(String r1, String r2, Continuation<? super VoicePrintTrackHelper$clickEnhancedVoiceprintRecord$1> r3) {
        this.$cardType = r1;
        this.$cardContentType = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new VoicePrintTrackHelper$clickEnhancedVoiceprintRecord$1(this.$cardType, this.$cardContentType, r4);
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
        JSONObject r6 = new JSONObject();
        String r0 = this.$cardType;
        String r1 = this.$cardContentType;
        r6.put("action_type", "click_enhanced_voiceprint_record");
        r6.put("card_type", r0);
        if (r1 == null) goto L7;
        r6.put("card_content_type", r1);
    L7:
        IApplog.a.reportEvent("dora_card_click", r6);
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

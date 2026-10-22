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
@DebugMetadata(c = "com.obric.assistant.settings.voiceprint.VoicePrintTrackHelper$enterPage$1", f = "VoicePrintTrackHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class VoicePrintTrackHelper$enterPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $currentPage;
    final /* synthetic */ String $previousPage;
    int label;

    public VoicePrintTrackHelper$enterPage$1(String r1, String r2, Continuation<? super VoicePrintTrackHelper$enterPage$1> r3) {
        this.$currentPage = r1;
        this.$previousPage = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new VoicePrintTrackHelper$enterPage$1(this.$currentPage, this.$previousPage, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        JSONObject r5 = new JSONObject();
        String r0 = this.$currentPage;
        String r1 = this.$previousPage;
        r5.put("current_page", r0);
        r5.put("previous_page", r1);
        IApplog.a.reportEvent("enter_page", r5);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

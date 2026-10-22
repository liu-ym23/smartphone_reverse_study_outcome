package com.larus.doc.impl;

import android.app.Application;
import android.os.SystemClock;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.DocFragment$mobTtsEnd$1", f = "DocFragment.kt", i = {0, 1}, l = {2111, 2112}, m = "invokeSuspend", n = {"volume", "volume"}, s = {"I$0", "I$0"})
public final class DocFragment$mobTtsEnd$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $endMethod;
    int I$0;
    int label;
    final /* synthetic */ DocFragment this$0;

    public DocFragment$mobTtsEnd$1(DocFragment r1, String r2, Continuation<? super DocFragment$mobTtsEnd$1> r3) {
        this.this$0 = r1;
        this.$endMethod = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DocFragment$mobTtsEnd$1(this.this$0, this.$endMethod, r4);
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
        String r4 = null;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        int r2 = this.I$0;
        ResultKt.throwOnFailure(r13);
    L34:
        BotModel r14 = (BotModel) r13;
        long r3 = SystemClock.elapsedRealtime() - this.this$0.L1;
        com.larus.platform.service.o r5 = com.larus.platform.service.o.a;
        JSONObject r6 = new JSONObject();
        DocFragment r7 = this.this$0;
        String r8 = this.$endMethod;
        r6.put("page_token", r7.f);
        r6.put("start_method", "click_doc_play");
        r6.put("end_method", r8);
        r6.put("tts_speaker_volume", r2);
        r6.put("duration", r3);
        if (r14 == null) goto L39;
        SpeakerVoice r9 = r14.getVoiceType();
        if (r9 == null) goto L39;
        String r10 = r9.getStyleId();
    L40:
        r6.put("speaker_id", r10);
        if (r14 == null) goto L45;
        SpeakerVoice r11 = r14.getVoiceType();
        if (r11 == null) goto L45;
        String r12 = r11.getName();
    L46:
        r6.put("speaker_name", r12);
        if (r14 == null) goto L51;
        SpeakerVoice r15 = r14.getVoiceType();
        if (r15 == null) goto L51;
        r4 = r15.getId();
    L51:
        r6.put("voice_id", r4);
        Unit r16 = Unit.INSTANCE;
        r5.reportEvent("finish_tts", r6);
        return Unit.INSTANCE;
    L45:
        r12 = null;
    L39:
        r10 = null;
        goto L40
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        int r17 = this.I$0;
        ResultKt.throwOnFailure(r13);
    L23:
        List r18 = (List) r13;
        if (r18 == null) goto L26;
        String r110 = (String) CollectionsKt.firstOrNull(r18);
    L27:
        IBotRepoService r20 = zh8.a.e;
        if (r110 != null) goto L30;
        r110 = "";
    L30:
        this.I$0 = r17;
        this.label = 2;
        r13 = IBotRepoService.b.a(r20, r110, false, null, false, this, 28);
        if (r13 != r0) goto L33;
        return r0;
    L33:
        r2 = r17;
    L26:
        r110 = null;
        goto L27
    L10:
        ResultKt.throwOnFailure(r13);
        m58.y r111 = m58.y.a;
        m58.b r21 = m58.h.k;
        if (r21 == null) goto L13;
        Application r22 = r21.getApplication();
    L14:
        Integer r112 = r111.b(r22);
        if (r112 == null) goto L17;
        r17 = r112.intValue();
    L18:
        wc9.e r113 = (wc9.e) AuthModelDelegate.b.y().getValue();
        if (r113 == null) goto L26;
        this.I$0 = r17;
        this.label = 1;
        r13 = ic8.n.c(r113, this);
        if (r13 != r0) goto L23;
        return r0;
    L17:
        r17 = 0;
        goto L18
    L13:
        r22 = null;
        goto L14
    }
}

package com.larus.doc.impl;

import android.app.Application;
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
@DebugMetadata(c = "com.larus.doc.impl.DocFragment$mobStartTts$1", f = "DocFragment.kt", i = {0, 1}, l = {2135, 2136}, m = "invokeSuspend", n = {"volume", "volume"}, s = {"I$0", "I$0"})
final class DocFragment$mobStartTts$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int label;
    final /* synthetic */ DocFragment this$0;

    public DocFragment$mobStartTts$1(DocFragment r1, Continuation<? super DocFragment$mobStartTts$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DocFragment$mobStartTts$1(this.this$0, r3);
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
        com.larus.platform.service.o r3 = com.larus.platform.service.o.a;
        JSONObject r5 = new JSONObject();
        r5.put("page_token", this.this$0.f);
        r5.put("start_method", "click_doc_play");
        r5.put("tts_speaker_volume", r2);
        if (r14 == null) goto L39;
        SpeakerVoice r6 = r14.getVoiceType();
        if (r6 == null) goto L39;
        String r7 = r6.getStyleId();
    L40:
        r5.put("speaker_id", r7);
        if (r14 == null) goto L45;
        SpeakerVoice r8 = r14.getVoiceType();
        if (r8 == null) goto L45;
        String r9 = r8.getName();
    L46:
        r5.put("speaker_name", r9);
        if (r14 == null) goto L51;
        SpeakerVoice r15 = r14.getVoiceType();
        if (r15 == null) goto L51;
        r4 = r15.getId();
    L51:
        r5.put("voice_id", r4);
        Unit r16 = Unit.INSTANCE;
        r3.reportEvent("start_tts", r5);
        return Unit.INSTANCE;
    L45:
        r9 = null;
    L39:
        r7 = null;
        goto L40
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        int r10 = this.I$0;
        ResultKt.throwOnFailure(r13);
    L23:
        List r17 = (List) r13;
        if (r17 == null) goto L26;
        String r18 = (String) CollectionsKt.firstOrNull(r17);
    L27:
        IBotRepoService r11 = zh8.a.e;
        if (r18 != null) goto L30;
        r18 = "";
    L30:
        this.I$0 = r10;
        this.label = 2;
        r13 = IBotRepoService.b.a(r11, r18, false, null, false, this, 28);
        if (r13 != r0) goto L33;
        return r0;
    L33:
        r2 = r10;
    L26:
        r18 = null;
        goto L27
    L10:
        ResultKt.throwOnFailure(r13);
        m58.y r110 = m58.y.a;
        m58.b r12 = m58.h.k;
        if (r12 == null) goto L13;
        Application r20 = r12.getApplication();
    L14:
        Integer r111 = r110.b(r20);
        if (r111 == null) goto L17;
        r10 = r111.intValue();
    L18:
        wc9.e r112 = (wc9.e) AuthModelDelegate.b.y().getValue();
        if (r112 == null) goto L26;
        this.I$0 = r10;
        this.label = 1;
        r13 = ic8.n.c(r112, this);
        if (r13 != r0) goto L23;
        return r0;
    L17:
        r10 = 0;
        goto L18
    L13:
        r20 = null;
        goto L14
    }
}

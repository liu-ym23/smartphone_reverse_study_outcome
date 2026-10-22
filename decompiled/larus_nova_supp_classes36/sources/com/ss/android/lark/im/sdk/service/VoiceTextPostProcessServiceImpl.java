package com.ss.android.lark.im.sdk.service;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.voice.GetSpeechRecognitionPostProcessResultClientRequest;
import com.bytedance.lark.pb.voice.GetSpeechRecognitionPostProcessResultClientResponse;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichText;
import javax.inject.Inject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class VoiceTextPostProcessServiceImpl implements e {
    public final com.bytedance.lark.rustclient.api.l a;

    public static final class a {
    }

    static {
    }

    @Inject
    public VoiceTextPostProcessServiceImpl(com.bytedance.lark.rustclient.api.l r2) {
        Intrinsics.checkNotNullParameter(r2, "rustClient");
        this.a = r2;
    }

    @Override // com.ss.android.lark.im.sdk.service.e
    public final RichText a(String r13, String r14) {
        Intrinsics.checkNotNullParameter(r13, "chatId");
        Intrinsics.checkNotNullParameter(r14, "recognitionText");
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        long r2 = CastLongProtector.parseLong(r13);     // Catch: Throwable -> L5
        com.bytedance.lark.rustclient.api.d r15 = new com.bytedance.lark.rustclient.api.d(new GetSpeechRecognitionPostProcessResultClientRequest.Builder().context_id(String.valueOf(r2)).recognition_text(r14).scene(GetSpeechRecognitionPostProcessResultClientRequest.Scene.DOUBAO_IM), GetSpeechRecognitionPostProcessResultClientResponse.ADAPTER, Command.GET_SPEECH_RECOGNITION_POSTPROCESS_RESULT, null, null, null, null, 248);     // Catch: Throwable -> L5
        Object r16 = Result.constructor-impl((RichText) com.bytedance.lark.rustclient.api.t.c(com.bytedance.lark.rustclient.api.t.e(this.a.h(r15).execute(), VoiceTextPostProcessServiceImpl$postProcess$1$1.INSTANCE), null));     // Catch: Throwable -> L5
    L7:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L11;
        Log.e("VoiceTextPostProcessService", "postProcess failed", r17);
    L11:
        if (Result.isFailure-impl(r16) == true) goto L15;
        r0 = r16;
    L15:
        return (RichText) r0;
    L5:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}

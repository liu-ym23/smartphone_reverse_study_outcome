package com.ss.android.lark.keyboard.plugin.tool.voice.processor;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.audio.voiceinput.service.IAudioService;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class PartialUploadAudioData {
    public final IAudioService a;

    public static final class a {
    }

    static {
    }

    public PartialUploadAudioData(IAudioService r2) {
        Intrinsics.checkNotNullParameter(r2, "audioService");
        this.a = r2;
    }

    public final Message a(final c r12, final IGetDataCallback<String> r13) {
        Intrinsics.checkNotNullParameter(r12, "audioRecordData");
        Message r0 = r12.a;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        StringBuilder r3 = new StringBuilder("sendAudioData cid:");
        Message r4 = r12.a;
        final AudioContent r5 = null;
        if (r4 == null) goto L15;
        String r6 = r4.getcId();
    L16:
        r3.append(r6);
        r3.append("/ sequenceId:");
        r3.append(r12);
        r3.append(".sequenceId/$ uploadId:");
        r3.append(r12.c);
        Log.i("PartialUploadAudioData", r3.toString());
        Message r7 = r12.a;
        if (r7 == null) goto L19;
        r5 = (AudioContent) r7.getContent();
    L19:
        String r8 = r12.c;
        if (r8 != null) goto L22;
    L23:
        r1 = true;
    L24:
        if (r1 == true) goto L34;
        if (r5 == null) goto L34;
        if (fwa.a.a == null) goto L31;
        fwa.a.k++;
    L31:
        this.a.jc(r12.c, r12.b, r12.d.array(), r12.e, new PartialUploadAudioData$process$1(r5, r13, r12));
        return r12.a;
    L34:
        return r12.a;
    L22:
        if (r8.length() != 0) goto L24;
    L15:
        r6 = null;
        goto L16
    L11:
        return r12.a;
    L5:
        if (r0.getType() != Message.Type.AUDIO) goto L8;
        r2 = false;
        goto L9
    }
}

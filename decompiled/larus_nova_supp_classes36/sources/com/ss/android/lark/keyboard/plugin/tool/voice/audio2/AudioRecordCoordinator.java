package com.ss.android.lark.keyboard.plugin.tool.voice.audio2;

import android.widget.EditText;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.audio.voiceinput.service.IAudioService;
import com.ss.android.lark.audio.voiceinput.service.l;
import com.ss.android.lark.audio.voiceinput.utils.VoiceUtils;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.keyboard.event.k;
import com.ss.android.lark.keyboard.event.q;
import com.ss.android.lark.keyboard.plugin.tool.voice.processor.AudioRecordDataProcessor;
import com.ss.android.lark.keyboard.plugin.tool.voice.processor.AudioRecordDataProcessor$RecognizeWithUploadAudioDataConsumer$onSwitchLanguage$2$1;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichText;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class AudioRecordCoordinator {
    public final AudioRecordDataProcessor a;
    public String b;
    public String c;
    public final com.ss.android.lark.audio.voiceinput.d d;
    public final b e;

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.keyboard.plugin.tool.voice.c {
        public final /* synthetic */ AudioRecordCoordinator a;

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.c
        public final String a() {
            return this.a.b;
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.c
        public final void b() {
            AudioRecordDataProcessor r0 = this.a.a;
            if (r0 == null) goto L22;
            AudioRecordDataProcessor.UploadAudioDataConsumer r7 = r0.j;
            if (r7 != null) goto L7;
        L16:
            com.ss.android.lark.keyboard.b r1 = r0.i();
            if (r1 == null) goto L21;
            k r2 = r1.e();
            if (r2 == null) goto L21;
            r2.a(q.a.a, r2.b());
        L21:
            r0.j();
            goto L22
        L7:
            if (r7.b() == false) goto L9;
            Log.e("AudioRecordDataUpload", "[sendAudioMsg] invalid context");
            goto L16
        L9:
            com.ss.android.lark.keyboard.plugin.tool.voice.processor.b r3 = r7.b;
            if (r3 != null) goto L12;
            Log.e("AudioRecordDataUpload", "mAudioMsgInfo is null");
            goto L16
        L12:
            Message r4 = r3.a;
            if (r4 != null) goto L15;
            Log.e("AudioRecordDataUpload", "audioMessage is null, mAudioMsgInfo: cid = " + r3.d + ", fileName = " + r3.c);
            goto L16
        L15:
            String r5 = r3.c;
            String r6 = r3.d;
            int r8 = r3.e;
            r4.getContent().setUploadId(r7.c);
            Log.i("AudioRecordDataUpload", "[sendAudioMsg]strFileName:" + r5 + " cid:" + r6 + " mUploadId:" + r7.c);
            AudioRecordDataProcessor r9 = r7.f;
            AudioRecordDataProcessor.a(r9, new com.ss.android.lark.keyboard.plugin.tool.voice.processor.e(r9, r4, r5, r6, r8, r7));
        L22:
            this.a.b = "";
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.c
        public final void e() {
            AudioRecordDataProcessor r0 = this.a.a;
            if (r0 == null) goto L11;
            AudioRecordDataProcessor.UploadAudioDataConsumer r1 = r0.j;
            if (r1 == null) goto L7;
            r1.f();
        L7:
            AudioRecordDataProcessor.RecognizeWithUploadAudioDataConsumer r2 = r0.k;
            if (r2 == null) goto L10;
            int r3 = VoiceUtils.a;
            VoiceUtils.a(r2.f, r2.c);
        L10:
            r0.j();
        L11:
            this.a.b = "";
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.c
        public final String getUploadId() {
            return this.a.c;
        }

        public b(AudioRecordCoordinator r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.c
        public final void c(String r7, RichText r8) {
            Intrinsics.checkNotNullParameter(r7, "content");
            AudioRecordDataProcessor r0 = this.a.a;
            if (r0 == null) goto L30;
            Intrinsics.checkNotNullParameter(r7, "content");
            AudioRecordDataProcessor.RecognizeWithUploadAudioDataConsumer r9 = r0.k;
            if (r9 == null) goto L24;
            Intrinsics.checkNotNullParameter(r7, "text");
            com.ss.android.lark.keyboard.plugin.tool.voice.processor.b r1 = r9.b;
            if (r1 == null) goto L23;
            AudioRecordDataProcessor r3 = r9.j;
            Message r4 = r1.a;
            if (r4 == null) goto L22;
            AudioContent r2 = r4.getContent();
            r2.setUploadId(r9.c);
            String r5 = r2.getUploadId();
            if (r5 != null) goto L13;
        L16:
            boolean r6 = true;
        L18:
            if (r6 == true) goto L20;
            String r10 = r2.getUploadId();
            Intrinsics.checkNotNull(r10);
        L21:
            qob.a r11 = r3.c;
            Message r12 = r1.a;
            String r13 = r1.c;
            r11.f();
            r11.j(r12, r7, r13, r10);
            r9.b = null;
            goto L24
        L20:
            r2.setUploadId(null);
            r10 = r1.d;
            goto L21
        L13:
            if (r5.length() == 0) goto L16;
            r6 = false;
            goto L18
        L22:
            Log.e("AudioRecordDataProcessor", "[onSendAudioTextMsg] audioMessage is null");
            goto L24
        L23:
            Log.e("AudioRecordDataProcessor", "[onSendAudioTextMsg] audioMsgInfo is null");
        L24:
            com.ss.android.lark.keyboard.b r14 = r0.i();
            if (r14 == null) goto L29;
            k r15 = r14.e();
            if (r15 == null) goto L29;
            r15.a(q.a.a, r15.b());
        L29:
            r0.j();
        L30:
            this.a.b = "";
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.c
        public final void d(String r7, RichText r8, boolean r9) {
            Intrinsics.checkNotNullParameter(r7, "content");
            Intrinsics.checkNotNullParameter(r8, "richText");
            AudioRecordDataProcessor r2 = this.a.a;
            if (r2 == null) goto L22;
            Intrinsics.checkNotNullParameter(r7, "content");
            Intrinsics.checkNotNullParameter(r8, "richText");
            qob.a r0 = r2.c;
            String r1 = r0.h();
            String r4 = r2.c.d();
            r2.c.c();
            r0.o(r1, r4, r7, r8);
            if (r9 == false) goto L13;
            com.ss.android.lark.keyboard.b r10 = r2.i();
            if (r10 == null) goto L13;
            com.ss.android.lark.keyboard.keyboard2.b r11 = r10.L();
            if (r11 == null) goto L13;
            EditText r12 = r11.c();
            if (r12 == null) goto L13;
            r12.setText("");
        L13:
            com.ss.android.lark.keyboard.b r13 = r2.i();
            if (r13 == null) goto L18;
            k r14 = r13.e();
            if (r14 == null) goto L18;
            r14.a(q.a.a, r14.b());
        L18:
            AudioRecordDataProcessor.UploadAudioDataConsumer r15 = r2.j;
            if (r15 == null) goto L21;
            r15.f();
        L21:
            r2.j();
        L22:
            this.a.b = "";
        }
    }

    static {
    }

    public final void a(final String r12) {
        Intrinsics.checkNotNullParameter(r12, "languageKey");
        AudioRecordDataProcessor r1 = this.a;
        if (r1 == null) goto L16;
        final Function0<Unit> r5 = new AudioRecordCoordinator$switchLanguage$1(this);
        Intrinsics.checkNotNullParameter(r12, "languageKey");
        Intrinsics.checkNotNullParameter(r5, "afterSwitch");
        final AudioRecordDataProcessor.RecognizeWithUploadAudioDataConsumer r3 = r1.k;
        if (r3 == null) goto L17;
        Intrinsics.checkNotNullParameter(r12, "languageKey");
        Intrinsics.checkNotNullParameter(r5, "afterPrepared");
        if (r3.b() == false) goto L9;
        Log.i("AudioRecordDataRecognize", "[onSwitchLanguage] invalid context");
        return;
    L9:
        final com.ss.android.lark.keyboard.plugin.tool.voice.processor.b r9 = r3.b;
        if (r9 == null) goto L19;
        final AudioRecordDataProcessor r0 = r3.j;
        final String r6 = r9.c;
        final PolarisFileWrapper r8 = new PolarisFileWrapper(r6);
        final String r7 = r9.d;
        if (r8.exists() == false) goto L14;
        AudioRecordDataProcessor.a(r0, new AudioRecordDataProcessor$RecognizeWithUploadAudioDataConsumer$onSwitchLanguage$2$1(r3, r12, r5, r6, r7, r8, r9, r0));
        return;
    L14:
        Log.i("AudioRecordDataRecognize", "[onSwitchLanguage] audioFile is not exist:" + r8.getAbsolutePath());
        return;
    L19:
        return;
    L17:
        return;
    }

    public AudioRecordCoordinator(l r14, IAudioService r15, boolean r16, qob.a r17, String r18, String r19, boolean r20, boolean r21, com.ss.android.lark.audio.voiceinput.f r22) {
        Intrinsics.checkNotNullParameter(r14, "newAudio2TextPush");
        Intrinsics.checkNotNullParameter(r15, "audioService");
        Intrinsics.checkNotNullParameter(r17, "audioDataProcessorDependency");
        Intrinsics.checkNotNullParameter(r18, "scene");
        Intrinsics.checkNotNullParameter(r19, "psdaRecordToken");
        Intrinsics.checkNotNullParameter(r22, "callback");
        this.b = "";
        this.c = "";
        final AudioRecordDataProcessor r1 = new AudioRecordDataProcessor(r14, r15, r17, r16, r20);
        this.d = new com.ss.android.lark.audio.voiceinput.d(r1, r22, r16, r21, r18, r19, new AudioRecordCoordinator$1$1(this, r1));
        this.a = r1;
        this.e = new b(this);
    }
}

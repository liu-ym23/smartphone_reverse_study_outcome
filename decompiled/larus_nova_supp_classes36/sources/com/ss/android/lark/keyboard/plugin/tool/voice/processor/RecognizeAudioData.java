package com.ss.android.lark.keyboard.plugin.tool.voice.processor;

import android.text.TextUtils;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.audio.voiceinput.service.IAudioService;
import com.ss.android.lark.audio.voiceinput.service.l;
import com.ss.android.lark.audio.voiceinput.service.n;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.parser.internal.g0;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class RecognizeAudioData {
    public final l a;
    public final IAudioService b;
    public final String c;
    public String d;
    public String e;
    public f f;
    public Message g;
    public volatile String h;
    public volatile int i;
    public final b j;

    public static final class a {
    }

    public static final class b implements n {
        public final /* synthetic */ RecognizeAudioData a;

        public b(RecognizeAudioData r1) {
            this.a = r1;
        }

        public final void a(com.ss.android.lark.audio.voiceinput.service.a r17, boolean r18) {
            Intrinsics.checkNotNullParameter(r17, "result");
            RecognizeAudioData r2 = this.a;
            if (r2.g == null) goto L23;
            Log.i("RecognizeAudioData", "recognize result:" + r17.a() + " fromPush:" + r18 + " uploadId:" + r2.h + " mCurSequenceId:" + r2.i);
            Integer r3 = r17.b;
            if (r3 == null) goto L24;
            int r6 = r3.intValue();
            if (Intrinsics.areEqual(r17.a, r2.h) == true) goto L9;
            return;
        L9:
            if (r2.i >= r6) goto L11;
        L12:
            String r4 = fwa.a.a;
            fwa.a.c(r6, r17.d, r17.c);
            if (r2.i >= r6) goto L15;
            r2.i = r6;
        L15:
            f r5 = r2.f;
            if (r5 == null) goto L27;
            String r7 = r2.h;
            String r8 = r17.c;
            boolean r9 = r17.d;
            List r10 = r17.e;
            if (r10 == null) goto L20;
            int[] r11 = com.ss.android.lark.audio.voiceinput.utils.c.a(r10);
        L21:
            r5.a(new com.ss.android.lark.audio.voiceinput.c(r7, r6, r8, r9, r11, r17.f, r17.g, g0.e(r17.h, null), g0.e(r17.i, null), r17.j, r17.k));
            return;
        L20:
            r11 = null;
            goto L21
        L27:
            return;
        L11:
            if (r17.d == true) goto L12;
            return;
        L24:
            return;
        }
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r5v6, types: [com.ss.android.lark.keyboard.plugin.tool.voice.processor.RecognizeAudioData$process$1] */
    public final Message a(final c r26, IGetDataCallback<String> r27) {
        Intrinsics.checkNotNullParameter(r26, "audioRecordData");
        Message r2 = r26.a;
        int r3 = 0;
        if (r2 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == true) goto L53;
        String r6 = r26.c;
        if (r6 != null) goto L13;
    L16:
        boolean r7 = true;
    L17:
        if (r7 == true) goto L53;
        if (r2 != null) goto L22;
        return null;
    L22:
        this.g = r2;
        Log.i("RecognizeAudioData", "RecognizeAudioData message[chatId:" + r2.getChatId() + " cid:" + r2.getcId() + " msgId:" + r2.getId() + "] / sequenceId:" + r26.b + "/ capacity:" + r26.d.capacity() + " uploadId:" + r26.c);
        if (r26.b != 1) goto L25;
        boolean r8 = true;
    L26:
        boolean r9 = r26.e;
        if (r8 == true) goto L29;
        if (r9 == false) goto L37;
        int r18 = 2;
    L38:
        if (r9 == false) goto L40;
        Log.i("RecognizeAudioData", "send last request sequenceId:" + r26.b + " uploadId:" + r26.c);
    L40:
        String r4 = fwa.a.a;
        if (r8 == false) goto L43;
        fwa.a.p = System.currentTimeMillis();
    L46:
        if (TextUtils.isEmpty(this.d) == true) goto L48;
        String r10 = this.d.toLowerCase(Locale.ROOT);
    L49:
        this.d = r10;
        String r11 = tob.a.a;
        byte[] r12 = r26.d.array();
        Intrinsics.checkNotNullParameter(r12, "data");
        int r13 = r12.length;
        int r14 = 0;
    L50:
        if (r3 >= r13) goto L52;
        byte r15 = r12[r3];
        int r16 = r14 + 1;
        int r17 = r14 % 2;
        r3 = r3 + 1;
        r14 = r16;
        goto L50
    L52:
        this.b.Oc(r26.c, r26.b, this.d, this.e, r26.d.array(), r18, this.c, r26.f, r26.g, KeyboardVoiceFGUtils.a("im.messenger.auto_ner", null), com.ss.android.lark.keyboard.plugin.tool.voice.utils.b.b(), new RecognizeAudioData$process$1(this, r26));
        goto L53
    L48:
        r10 = "zh_ch";
        goto L49
    L43:
        if (r9 == false) goto L46;
        fwa.a.r = System.currentTimeMillis();
        goto L46
    L37:
        r18 = 0;
        goto L38
    L29:
        if (this.e.length() != 0) goto L31;
        boolean r19 = true;
    L32:
        if (r19 == false) goto L34;
        Log.i("RecognizeAudioData", "getCurrentLanguage: " + this.e);
        this.e = "un_auto";
    L34:
        r18 = 1;
        goto L38
    L31:
        r19 = false;
        goto L32
    L25:
        r8 = false;
        goto L26
    L13:
        if (r6.length() == 0) goto L16;
        r7 = false;
    L53:
        return r2;
    L5:
        if (r2.getType() != Message.Type.AUDIO) goto L8;
        r5 = false;
        goto L9
    }

    public RecognizeAudioData(l r2, IAudioService r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, "newAudio2TextPush");
        Intrinsics.checkNotNullParameter(r3, "audioService");
        Intrinsics.checkNotNullParameter(r4, "chatId");
        Intrinsics.checkNotNullParameter(r5, "deviceLocale");
        Intrinsics.checkNotNullParameter(r6, "userLocale");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.j = new b(this);
    }
}

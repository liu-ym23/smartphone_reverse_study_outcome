package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import android.content.Context;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.audio.voiceinput.VoiceInputSpeechScene;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class w {
    public final boolean a;
    public final boolean b;
    public final String c;
    public final com.ss.android.lark.audio.voiceinput.p d;
    public final String e;
    public final s f;
    public final String g;
    public final int h;
    public final boolean i;
    public final Function1<Context, CharSequence> j;
    public final boolean k;
    public final t l;
    public final Float m;
    public final com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.d n;
    public final String o;
    public final Map<String, String> p;
    public final Function0<Boolean> q;
    public final VoiceInputSpeechScene r;
    public final a0 s;
    public final boolean t;

    public w() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof w) == true) goto L8;
        return false;
    L8:
        w r6 = (w) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (this.k == r6.k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r6.p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r6.q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.r, r6.r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.s, r6.s) == true) goto L66;
        return false;
    L66:
        if (this.t == r6.t) goto L68;
        return false;
    L68:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.b == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (((((((((r2 + r3) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        String r5 = this.g;
        int r6 = 0;
        if (r5 != null) goto L13;
        int r7 = 0;
    L14:
        int r8 = (((r4 + r7) * 31) + this.h) * 31;
        if (this.i == false) goto L17;
        int r9 = 1231;
    L18:
        int r10 = (r8 + r9) * 31;
        Function1<Context, CharSequence> r11 = this.j;
        if (r11 != null) goto L21;
        int r12 = 0;
    L22:
        int r13 = (r10 + r12) * 31;
        if (this.k == false) goto L25;
        int r14 = 1231;
    L26:
        int r15 = (((r13 + r14) * 31) + this.l.hashCode()) * 31;
        Float r16 = this.m;
        if (r16 != null) goto L29;
        int r17 = 0;
    L30:
        int r18 = (r15 + r17) * 31;
        com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.d r19 = this.n;
        if (r19 != null) goto L33;
        int r20 = 0;
    L34:
        int r21 = (((((r18 + r20) * 31) + this.o.hashCode()) * 31) + this.p.hashCode()) * 31;
        Function0<Boolean> r22 = this.q;
        if (r22 != null) goto L37;
        int r23 = 0;
    L38:
        int r24 = (r21 + r23) * 31;
        VoiceInputSpeechScene r25 = this.r;
        if (r25 == null) goto L42;
        r6 = r25.hashCode();
    L42:
        int r26 = (((r24 + r6) * 31) + this.s.hashCode()) * 31;
        if (this.t == true) goto L47;
        r1 = 1237;
    L47:
        return r26 + r1;
    L37:
        r23 = r22.hashCode();
        goto L38
    L33:
        r20 = r19.hashCode();
        goto L34
    L29:
        r17 = r16.hashCode();
        goto L30
    L25:
        r14 = 1237;
        goto L26
    L21:
        r12 = r11.hashCode();
        goto L22
    L17:
        r9 = 1237;
        goto L18
    L13:
        r7 = r5.hashCode();
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "ImmersiveVoiceInputConfig(isEnableVoiceInputSdk=" + this.a + ", isAsrNerEnable=" + this.b + ", appLocale=" + this.c + ", voiceInputModeWithScene=" + this.d + ", psdaToken=" + this.e + ", resultConsumer=" + this.f + ", chatId=" + this.g + ", keyboardEntranceLayoutId=" + this.h + ", autoSendOnRecognizeFinish=" + this.i + ", onlyAsrRecognizingTipsProvider=" + this.j + ", hidePopupOnReleaseKeepSession=" + this.k + ", buttonConfig=" + this.l + ", customOvalHeightDp=" + this.m + ", popupContainerProvider=" + this.n + ", hitPointPageScene=" + this.o + ", extraAnalyticParams=" + this.p + ", canFindContainerFromActivity=" + this.q + ", speechScene=" + this.r + ", keyboardMenuConfig=" + this.s + ", markdownEnable=" + this.t + ')';
    }

    public w(boolean r17, String r18, com.ss.android.lark.audio.voiceinput.p r19, String r20, s r21, com.bytedance.ee.bear.middleground.comment.audio.voiceinput.b r22, Map r23, Function0 r24, VoiceInputSpeechScene r25, a0 r26, boolean r27, int r28) {
        if ((r28 & 16) == 0) goto L5;
        String r5 = "LARK-PSDA-messenger_record_audio";
    L7:
        if ((r28 & 128) == 0) goto L9;
        int r6 = 2131563336;
    L11:
        if ((r28 & 2048) == 0) goto L13;
        t r8 = new t(((VoiceTextSetting) SettingManager.getInstance().get(VoiceTextSetting.class)).chatPageVoiceButtonText);
    L15:
        if ((r28 & 8192) == 0) goto L17;
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.b r10 = null;
    L19:
        if ((r28 & 16384) == 0) goto L21;
        String r11 = "main";
    L23:
        if ((32768 & r28) == 0) goto L25;
        Map r12 = new LinkedHashMap();
    L27:
        if ((65536 & r28) == 0) goto L29;
        Function0 r13 = null;
    L31:
        if ((131072 & r28) == 0) goto L33;
        VoiceInputSpeechScene r14 = null;
    L35:
        if ((262144 & r28) == 0) goto L37;
        a0 r15 = new a0(3);
    L39:
        if ((r28 & 524288) == 0) goto L41;
        boolean r4 = false;
    L42:
        Intrinsics.checkNotNullParameter(r18, "appLocale");
        Intrinsics.checkNotNullParameter(r19, "voiceInputModeWithScene");
        Intrinsics.checkNotNullParameter(r5, "psdaToken");
        Intrinsics.checkNotNullParameter(r21, "resultConsumer");
        Intrinsics.checkNotNullParameter(r8, "buttonConfig");
        Intrinsics.checkNotNullParameter(r11, "hitPointPageScene");
        Intrinsics.checkNotNullParameter(r12, "extraAnalyticParams");
        Intrinsics.checkNotNullParameter(r15, "keyboardMenuConfig");
        this.a = true;
        this.b = r17;
        this.c = r18;
        this.d = r19;
        this.e = r5;
        this.f = r21;
        this.g = null;
        this.h = r6;
        this.i = false;
        this.j = null;
        this.k = false;
        this.l = r8;
        this.m = null;
        this.n = r10;
        this.o = r11;
        this.p = r12;
        this.q = r13;
        this.r = r14;
        this.s = r15;
        this.t = r4;
        return;
    L41:
        r4 = r27;
        goto L42
    L37:
        r15 = r26;
        goto L39
    L33:
        r14 = r25;
        goto L35
    L29:
        r13 = r24;
        goto L31
    L25:
        r12 = r23;
        goto L27
    L21:
        r11 = null;
        goto L23
    L17:
        r10 = r22;
        goto L19
    L13:
        r8 = null;
        goto L15
    L9:
        r6 = 0;
        goto L11
    L5:
        r5 = r20;
        goto L7
    }
}

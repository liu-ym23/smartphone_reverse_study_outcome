package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model;

import com.ss.android.lark.audio.recorder.AudioRecordSettings;
import com.ss.android.lark.audio.voiceinput.AudioPluginFeature;
import com.ss.android.lark.audio.voiceinput.t;
import com.ss.android.lark.log.Log;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public int a;
    public int b;
    public int c;
    public int d;

    public a() {
        this.a = -1;
        this.b = -1;
        this.c = -1;
        this.d = -1;
    }

    public final int a() {
        int r0 = t.b().getInt("key_asr_preemptive_optimize_token_count", -1);
        if (this.a != (-1)) goto L6;
        this.a = AudioRecordSettings.d().getTokenSetUpCount();
    L6:
        if (this.b != (-1)) goto L9;
        this.b = AudioRecordSettings.d().getTokenSetDownCount();
    L9:
        if (this.c != (-1)) goto L12;
        this.c = AudioRecordSettings.d().getTokenMaxCount();
    L12:
        if (this.d != (-1)) goto L14;
        this.d = AudioRecordSettings.d().getTokenInitCount();
    L14:
        if (r0 != (-1)) goto L31;
        AudioPluginFeature.a r1 = AudioPluginFeature.Companion;
        int r2 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.a;
        int r3 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.e();
        r1.getClass();
        AudioPluginFeature r4 = AudioPluginFeature.WITH_TEXT;
        if (r3 != r4.getIndex()) goto L18;
        AudioPluginFeature r5 = r4;
    L24:
        if (r5 != r4) goto L26;
    L29:
        r0 = this.d;
    L30:
        t.b().putInt("key_asr_preemptive_optimize_token_count", r0);
        goto L31
    L26:
        if (r5 == AudioPluginFeature.RECOGNIZE) goto L29;
        r0 = 0;
        goto L30
    L18:
        r5 = AudioPluginFeature.RECORD;
        if (r3 == r5.getIndex()) goto L24;
        AudioPluginFeature r6 = AudioPluginFeature.RECOGNIZE;
        if (r3 != r6.getIndex()) goto L24;
        r5 = r6;
    L31:
        return r0;
    }

    public final boolean b() {
        int r0 = a();
        Log.i("AsrPreemptiveOptimize", "needAsrPreemptive / lastTokenCount = " + r0);
        if (r0 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void c(boolean r5) {
        int r0 = a();
        if (r5 == false) goto L7;
        if (r0 > 0) goto L6;
        int r1 = this.d;
    L8:
        Log.i("AsrPreemptiveOptimize", "whenSendResult / lastTokenCount = " + r0 + " / newTokenCount = " + r1 + " hasAsrResult = " + r5);
        t.b().putInt("key_asr_preemptive_optimize_token_count", r1);
        return;
    L6:
        r1 = RangesKt.coerceAtMost(this.a + r0, this.c);
        goto L8
    L7:
        r1 = RangesKt.coerceAtLeast(r0 - this.b, 0);
        goto L8
    }
}

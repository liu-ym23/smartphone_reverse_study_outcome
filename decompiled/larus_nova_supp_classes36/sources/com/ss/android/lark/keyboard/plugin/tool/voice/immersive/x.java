package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.audio.voiceinput.service.IAudioService;
import com.ss.android.lark.chat.api.service.IChatService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class x {
    public final IAudioService a;
    public final com.ss.android.lark.audio.voiceinput.service.l b;
    public final com.ss.android.lark.audio.voiceinput.service.o c;
    public final Activity d;
    public final Fragment e;
    public final IChatService f;
    public final qob.a g;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof x) == true) goto L8;
        return false;
    L8:
        x r6 = (x) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
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
        if (Intrinsics.areEqual(null, null) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        Activity r1 = this.d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Fragment r5 = this.e;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        IChatService r8 = this.f;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (((r7 + r9) * 31) + 0) * 31;
        qob.a r11 = this.g;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return r10 + r2;
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ImmersiveVoiceInputDependency(audioService=" + this.a + ", newAudio2TextPush=" + this.b + ", speechRecognitionEventPush=" + this.c + ", hostActivity=" + this.d + ", hostFragment=" + this.e + ", chatService=" + this.f + ", mentionDependency=null, oldIAudioDataProcessorDependency=" + this.g + ')';
    }

    public /* synthetic */ x(IAudioService r9, com.ss.android.lark.audio.voiceinput.service.l r10, com.ss.android.lark.audio.voiceinput.service.o r11, Activity r12, Fragment r13) {
        this(r9, r10, r11, r12, r13, null, null);
    }

    public x(IAudioService r2, com.ss.android.lark.audio.voiceinput.service.l r3, com.ss.android.lark.audio.voiceinput.service.o r4, Activity r5, Fragment r6, IChatService r7, qob.a r8) {
        Intrinsics.checkNotNullParameter(r2, "audioService");
        Intrinsics.checkNotNullParameter(r3, "newAudio2TextPush");
        Intrinsics.checkNotNullParameter(r4, "speechRecognitionEventPush");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}

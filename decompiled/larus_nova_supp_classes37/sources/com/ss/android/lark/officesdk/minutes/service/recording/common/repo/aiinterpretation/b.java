package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation;

import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.feature.MmOfficeSdkFeature;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.MmAudioSaveType;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public static final /* synthetic */ int o = 0;
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a a;
    public final q b;
    public final Function1<HeadsetPromptSource, Unit> c;
    public final Function1<HeadsetPromptSource, Unit> d;
    public boolean e;
    public MmAudioSaveType f;
    public g g;
    public boolean h;
    public Integer i;
    public boolean j;
    public Boolean k;
    public long l;
    public long m;
    public final k n;

    public static final class a {
    }

    static {
    }

    public final boolean c() {
        return this.a.getFeatureService().h(MmOfficeSdkFeature.RecordingAIInterpreterCheckHeadphones);
    }

    public final void a(int r4) {
        Integer r0 = this.i;
        if (r0 != null) goto L6;
    L8:
        nub.b r1 = (nub.b) this.a.u(nub.b.class);
        if (r1 != null) goto L12;
        lvb.a.b("MmAIInterpretationAudioController", "[applyPlaybackVolume] rtc service is null, volume=" + r4);
        return;
    L12:
        r1.d(r4);
        this.i = Integer.valueOf(r4);
        lvb.a.e("MmAIInterpretationAudioController", "[applyPlaybackVolume] volume=" + r4 + ", changeToOrigin=" + this.h);
        return;
    L6:
        if (r0.intValue() != r4) goto L8;
    }

    public final void b(boolean r14, HeadsetPromptSource r15) {
        int r1 = 100;
        if (this.e == true) goto L8;
        k r16 = this.n;
        int r17 = l.a;
        if (r16.a(new j(false, CollectionsKt.listOf("main"), true, MmAIInterpretationAecPolicy.RESTORE), "recording_disabled") == false) goto L65;
        this.i = null;
        int r18 = h.a;
        a(100);
        return;
    L65:
        return;
    L8:
        g r0 = this.g;
        if (r0 == null) goto L11;
        String r2 = r0.a;
    L12:
        if (r2 != null) goto L15;
        r2 = "";
    L15:
        if (r2.length() != 0) goto L17;
        boolean r5 = true;
    L19:
        if (r5 == false) goto L22;
        lvb.a.b("MmAIInterpretationAudioController", "[applyPolicy] active language is empty");
        return;
    L22:
        boolean r6 = this.f.isSave();
        boolean r7 = this.b.a();
        boolean r8 = c();
        int r9 = c.a;
        MmAudioSaveType r10 = this.f;
        Intrinsics.checkNotNullParameter(r10, "audioSaveType");
        if (r8 == true) goto L25;
    L28:
        boolean r11 = false;
    L29:
        int r12 = l.a;
        Intrinsics.checkNotNullParameter(r2, "targetLanguage");
        if (StringsKt.isBlank(r2) == false) goto L32;
        j r13 = null;
    L40:
        if (r13 != null) goto L44;
        lvb.a.b("MmAIInterpretationAudioController", "[applyPolicy] rtc action is null, targetLanguage=".concat(r2));
        return;
    L44:
        if (this.n.a(r13, "recording_enabled") == true) goto L46;
        return;
    L46:
        this.i = null;
        int r3 = h.a;
        boolean r4 = this.h;
        if (r11 == true) goto L49;
        if (r4 == true) goto L49;
    L50:
        a(r1);
        lvb.a.e("MmAIInterpretationAudioController", "[applyPolicy] subChannels=" + r13.b + ", isSavingAudio=" + r6 + ", hasHeadset=" + r7 + ", forceHeadset=" + r8 + ", shouldMutePlayback=" + r11 + ", allowHeadsetPrompt=" + r14 + ", promptSource=" + r15);
        if (r13.c == false) goto L57;
        if (r14 == true) goto L54;
        return;
    L54:
        if (r15 != HeadsetPromptSource.AI_ENABLED) goto L56;
        this.m = System.currentTimeMillis();
    L56:
        this.c.invoke(r15);
        return;
    L57:
        if (r14 == false) goto L68;
        if (r8 == true) goto L69;
        if (r7 == false) goto L61;
        return;
    L61:
        if (r15 != HeadsetPromptSource.AI_ENABLED) goto L63;
        this.m = System.currentTimeMillis();
    L63:
        this.d.invoke(r15);
        return;
    L69:
        return;
    L68:
        return;
    L49:
        r1 = 0;
        goto L50
    L32:
        List r19 = CollectionsKt.listOf(r2);
        if (r11 == true) goto L38;
        if (r8 == false) goto L37;
        if (r6 == true) goto L38;
    L37:
        MmAIInterpretationAecPolicy r110 = MmAIInterpretationAecPolicy.TRANSCRIPT_ONLY;
    L39:
        r13 = new j(true, r19, r11, r110);
    L38:
        r110 = MmAIInterpretationAecPolicy.RESTORE;
        goto L39
    L25:
        if (r10 != MmAudioSaveType.SAVE) goto L28;
        if (r7 == true) goto L28;
        r11 = true;
        goto L29
    L17:
        r5 = false;
        goto L19
    L11:
        r2 = null;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r2, q r3, Function1<? super HeadsetPromptSource, Unit> r4, Function1<? super HeadsetPromptSource, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "mmUccApi");
        Intrinsics.checkNotNullParameter(r3, "audioRouteDetector");
        Intrinsics.checkNotNullParameter(r4, "notifyUseHeadset");
        Intrinsics.checkNotNullParameter(r5, "notifyRecommendHeadset");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.f = MmAudioSaveType.SAVE;
        this.n = new k(r2, "MmAIInterpretationAudioController");
    }

    public final void d(boolean r4, MmAudioSaveType r5, g r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r5, "currentAudioSaveType");
        StringBuilder r0 = new StringBuilder("[onAIInterpretationChanged] enabled=");
        r0.append(r4);
        r0.append(", audioSaveType=");
        r0.append(r5);
        r0.append(", language=");
        String r1 = null;
        if (r6 == null) goto L5;
        String r2 = r6.a;
    L6:
        r0.append(r2);
        r0.append(", allowHeadsetPrompt=");
        r0.append(r7);
        lvb.a.e("MmAIInterpretationAudioController", r0.toString());
        if (r4 == false) goto L12;
        if (r7 == false) goto L12;
        if (this.j == true) goto L12;
        boolean r8 = true;
    L13:
        if (r8 == false) goto L15;
        this.j = true;
    L15:
        g r3 = this.g;
        if (r3 == null) goto L18;
        String r9 = r3.a;
    L19:
        this.e = r4;
        this.f = r5;
        if (r4 == true) goto L23;
        r6 = null;
    L23:
        this.g = r6;
        if (r4 == false) goto L29;
        if (r6 == null) goto L28;
        r1 = r6.a;
    L28:
        if (Intrinsics.areEqual(r9, r1) == false) goto L29;
    L30:
        this.k = Boolean.valueOf(this.b.a());
        b(r8, HeadsetPromptSource.AI_ENABLED);
        return;
    L29:
        this.h = false;
        goto L30
    L18:
        r9 = null;
    L12:
        r8 = false;
        goto L13
    L5:
        r2 = null;
        goto L6
    }
}

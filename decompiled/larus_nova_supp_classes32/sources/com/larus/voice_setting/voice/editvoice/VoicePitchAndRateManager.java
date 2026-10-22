package com.larus.voice_setting.voice.editvoice;

import com.larus.im.bean.bot.MixVoice;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import hq9.d5;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class VoicePitchAndRateManager {
    public static final VoicePitchAndRateManager a = null;
    public static String b;

    public VoicePitchAndRateManager() {
    }

    static {
        a = new VoicePitchAndRateManager();
        b = NameKeys.UnloadStrategy_No_Strategy;
    }

    public static b1 b(List r7) {
        MixVoice r8 = (MixVoice) CollectionsKt.firstOrNull(r7);
        if (r8 == null) goto L22;
        SpeakerVoice r9 = r8.getVoiceItem();
        if (r9 == null) goto L24;
        boolean r2 = false;
        if (r9.getPitchF64() != 0.0f) goto L9;
        boolean r1 = true;
    L11:
        if (r1 == false) goto L13;
        float r3 = 0.0f;
    L15:
        if (r9.getSpeechRateF64() != 0.0f) goto L17;
        r2 = true;
    L17:
        if (r2 == false) goto L19;
        float r10 = 1.0f;
    L21:
        return new b1(r3, r10);
    L19:
        r10 = r9.getSpeechRateF64() / 10.0f;
        goto L21
    L13:
        r3 = r9.getPitchF64() / 10.0f;
        goto L15
    L9:
        r1 = false;
        goto L11
    L24:
        return null;
    L22:
        return null;
    }

    public static boolean a(List r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "voiceList");
        d5 r0 = z2.a.getVoiceSettingConvenienceConfig();
        boolean r1 = false;
        if (r0 == null) goto L5;
        boolean r2 = r0.b();
    L6:
        if (r2 == true) goto L8;
    L10:
        FLogger.a.i("VoicePitchAndRateManager", "[enableRememberSingleVoicePitchAndRate] caller is " + r6 + ", botId is " + b + ", voiceList size is " + r5.size() + ", rememberSingleVoice is " + r2);
        return r1;
    L8:
        if (r5.size() != 1) goto L10;
        r1 = true;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    public static Object c(List r7, Continuation r8) {
        Intrinsics.checkNotNullParameter(r7, "voiceList");
        boolean r2 = false;
        if (a(r7, "existsVoicePitchAndRate") == false) goto L53;
        MixVoice r0 = (MixVoice) CollectionsKt.firstOrNull(r7);
        if (r0 == null) goto L9;
        SpeakerVoice r1 = r0.getVoiceItem();
        if (r1 == null) goto L9;
        String r3 = r1.getId();
    L10:
        d1 r4 = d1.a;
        String r5 = b + '_' + r3;
        r4.getClass();
        if (r5 != null) goto L13;
    L16:
        boolean r6 = true;
    L17:
        if (r6 == true) goto L40;
        com.larus.cache.f r9 = (com.larus.cache.f) d1.c.getValue();
        if (r9 == null) goto L40;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L34
        monitor-enter(r9);     // Catch: Throwable -> L34
        r9.b();     // Catch: Throwable -> L31
        com.larus.cache.f.p(r5);     // Catch: Throwable -> L31
        com.larus.cache.f.d r11 = (com.larus.cache.f.d) r9.j.get(r5);     // Catch: Throwable -> L31
        if (r11 == null) goto L29;
        if (r11.c == false) goto L29;
        r2 = true;
        goto L29
    L29:
        monitor-exit(r9);     // Catch: Throwable -> L34
        Object r12 = Result.constructor-impl(Boolean.valueOf(r2));     // Catch: Throwable -> L34
    L36:
        Boolean r13 = Boolean.FALSE;
        if (Result.isFailure-impl(r12) == false) goto L39;
        r12 = r13;
    L39:
        r2 = ((Boolean) r12).booleanValue();
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
    L40:
        FLogger r15 = FLogger.a;
        StringBuilder r16 = new StringBuilder("[existsVoicePitchAndRate]  exists is ");
        r16.append(r2);
        r16.append(" ，voiceId is ");
        r16.append(r3);
        r16.append(", botId is ");
        r16.append(b);
        r16.append("，pitchF64 ");
        MixVoice r17 = (MixVoice) CollectionsKt.firstOrNull(r7);
        if (r17 == null) goto L45;
        SpeakerVoice r18 = r17.getVoiceItem();
        if (r18 == null) goto L45;
        Float r19 = Float.valueOf(r18.getPitchF64());
    L46:
        r16.append(r19);
        r16.append(", speechRateF64 ");
        MixVoice r20 = (MixVoice) CollectionsKt.firstOrNull(r7);
        if (r20 == null) goto L51;
        SpeakerVoice r21 = r20.getVoiceItem();
        if (r21 == null) goto L51;
        Float r22 = Float.valueOf(r21.getSpeechRateF64());
    L52:
        r16.append(r22);
        r15.i("VoicePitchAndRateManager", r16.toString());
    L51:
        r22 = null;
    L45:
        r19 = null;
        goto L46
    L13:
        if (r5.length() == 0) goto L16;
        r6 = false;
    L9:
        r3 = null;
    L53:
        if (r2 == false) goto L57;
        return BuildersKt.withContext(Dispatchers.getIO(), new VoicePitchAndRateManager$getVoicePitchAndRate$2(r7, null), r8);
    L57:
        return b(r7);
    }

    public static void d(List r7, b1 r8) {
        Intrinsics.checkNotNullParameter(r7, "voiceList");
        Intrinsics.checkNotNullParameter(r8, "pitchAndRate");
        if (a(r7, "saveVoicePitchAndRate") == false) goto L6;
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new VoicePitchAndRateManager$saveVoicePitchAndRate$1(r7, r8, null), 2, null);
        return;
    }
}

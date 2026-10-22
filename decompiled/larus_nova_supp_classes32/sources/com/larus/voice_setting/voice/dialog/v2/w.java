package com.larus.voice_setting.voice.dialog.v2;

import android.content.Context;
import android.os.Handler;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.asr.view.ChatSpeaker;
import com.larus.audio.quality.AudioCheckerResult;
import com.larus.media.MediaResourceManager;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.larus.voice_setting.impl.databinding.LarusDialogCreateUgcVoiceBinding;
import com.larus.voice_setting.voice.dialog.v2.viewmodel.UgcVoiceViewModel;
import com.obric.aivoice.core.data.NameKeys;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class w implements p78.a {
    public final /* synthetic */ UgcVoiceCreateFragment a;

    public w(UgcVoiceCreateFragment r1) {
        this.a = r1;
    }

    public final void a(final String r7) {
        f2a.c r0 = com.larus.voice_setting.voice.utils.k.a.b("checkAudioQuality fileSaveSuccess");
        LinkedHashMap r1 = new LinkedHashMap();
        UgcVoiceCreateFragment r2 = this.a;
        f2a.f r3 = new f2a.f("enter_from");
        String r4 = r2.k;
        String r5 = NameKeys.UnloadStrategy_No_Strategy;
        if (r4 != null) goto L5;
        r4 = NameKeys.UnloadStrategy_No_Strategy;
    L5:
        r1.put(r3, r4);
        f2a.f r6 = f2a.f.e;
        String r8 = r2.q;
        if (r8 != null) goto L8;
        r8 = NameKeys.UnloadStrategy_No_Strategy;
    L8:
        r1.put(r6, r8);
        r1.put(new f2a.f("language"), r2.o);
        f2a.f r9 = new f2a.f("title");
        String r10 = r2.j;
        if (r10 != null) goto L11;
        r10 = NameKeys.UnloadStrategy_No_Strategy;
    L11:
        r1.put(r9, r10);
        f2a.f r11 = new f2a.f("filePath");
        if (r7 == null) goto L15;
        r5 = r7;
    L15:
        r1.put(r11, r5);
        r0.d(r1);
        r0.c.d = "startRecord.checkAudioQuality";
        boolean r12 = false;
        List r13 = CollectionsKt.listOf(new String[]{this.a.m, "VoiceCreate"});
        f2a.g r14 = r0.c;
        r14.b = r13;
        r14.e = this.a.l;
        f2a.c.c(r0, null, 15);
        if (r7 != null) goto L18;
    L19:
        r12 = true;
    L20:
        if (r12 == false) goto L23;
        int r15 = y2a.a.a;
        JSONObject r16 = new JSONObject();
        UgcVoiceCreateFragment r17 = this.a;
        r16.put("is_scheme", y2a.b.b(r17.y));
        r16.put("enter_method", y2a.b.a(r17.l));
        r16.put("result", "Fail");
        r16.put("reason", "FileError");
        y2a.a.a(r16);
        ((UgcVoiceViewModel) this.a.v.getValue()).goTo(UgcVoiceViewModel.Action.Close);
        return;
    L23:
        Handler r18 = t0.a;
        final UgcVoiceCreateFragment r19 = this.a;
        r18.post(new v(r19, r7));
        return;
    L18:
        if (r7.length() != 0) goto L20;
        goto L19
    }

    public final void b(p78.b r9) {
        Intrinsics.checkNotNullParameter(r9, "checkAudioQualityResult");
        AudioCheckerResult r0 = r9.a;
        Integer r1 = r9.b;
        f2a.c r2 = com.larus.voice_setting.voice.utils.k.a.b("checkAudioQuality receive result");
        LinkedHashMap r3 = new LinkedHashMap();
        UgcVoiceCreateFragment r4 = this.a;
        f2a.f r5 = new f2a.f("enter_from");
        String r6 = r4.k;
        String r7 = NameKeys.UnloadStrategy_No_Strategy;
        if (r6 != null) goto L5;
        r6 = NameKeys.UnloadStrategy_No_Strategy;
    L5:
        r3.put(r5, r6);
        f2a.f r8 = f2a.f.e;
        String r10 = r4.q;
        if (r10 != null) goto L8;
        r10 = NameKeys.UnloadStrategy_No_Strategy;
    L8:
        r3.put(r8, r10);
        r3.put(new f2a.f("language"), r4.o);
        f2a.f r11 = new f2a.f("title");
        String r12 = r4.j;
        if (r12 == null) goto L12;
        r7 = r12;
    L12:
        r3.put(r11, r7);
        r3.put(new f2a.f("result"), String.valueOf(r0));
        r3.put(new f2a.f("return_value"), String.valueOf(r1));
        r2.d(r3);
        r2.c.d = "startRecord.checkAudioQuality";
        List r13 = CollectionsKt.listOf(new String[]{this.a.m, "VoiceCreate"});
        f2a.g r14 = r2.c;
        r14.b = r13;
        r14.e = this.a.l;
        f2a.c.c(r2, null, 15);
        AudioCheckerResult r15 = AudioCheckerResult.PASSED;
        if (r0 == r15) goto L31;
        int r16 = y2a.a.a;
        JSONObject r17 = new JSONObject();
        UgcVoiceCreateFragment r18 = this.a;
        r17.put("is_scheme", y2a.b.b(r18.y));
        r17.put("enter_method", y2a.b.a(r18.l));
        r17.put("result", "Fail");
        r17.put("reason", "InputFail");
        Intrinsics.checkNotNullParameter(r9, "result");
        AudioCheckerResult r19 = r9.a;
        if (r19 != null) goto L17;
        int r20 = -1;
    L18:
        switch(r20) {
            case -1: goto L29;
            case 0: goto L20;
            case 1: goto L28;
            case 2: goto L27;
            case 3: goto L26;
            case 4: goto L25;
            case 5: goto L24;
            case 6: goto L23;
            case 7: goto L22;
            case 8: goto L21;
            default: goto L20;
        };
    L21:
        String r21 = "AudioRecordSilenced";
    L30:
        r17.put("reason_detail", r21);
        y2a.a.a(r17);
        goto L31
    L22:
        r21 = "SAMIInitMetricError_" + r9.b;
        goto L30
    L23:
        r21 = "SAMIInitConfigError_" + r9.b;
        goto L30
    L24:
        r21 = "SAMIWERFailed_" + r9.b;
        goto L30
    L25:
        r21 = "SAMISNRFailed_" + r9.b;
        goto L30
    L26:
        r21 = "Passed";
        goto L30
    L27:
        r21 = "SAMINetworkError_" + r9.b;
        goto L30
    L28:
        r21 = "SAMIInternalError_" + r9.b;
        goto L30
    L29:
        r21 = "Unknown";
        goto L30
    L20:
        throw new NoWhenBranchMatchedException();
    L17:
        r20 = y2a.a.C0124a.a[r19.ordinal()];
    L31:
        final UgcVoiceCreateFragment r22 = this.a;
        final Context r23 = r22.getContext();
        if (r23 == null) goto L43;
        FLogger.a.i("CreateUgcVoiceDialog", "checkResult result = " + r0);
        if (r0 != r15) goto L37;
        return;
    L37:
        if (r0 != AudioCheckerResult.AUDIO_RECORD_SILENCED) goto L39;
        t0.e(new j(r22));
    L40:
        r22.S90().updateUgcVoiceCreatePageStatus(UgcVoiceCreateFragment.PageStatus.NORMAL_STATUS);
        Lazy r24 = MediaResourceManager.a;
        MediaResourceManager.a(r22.u);
        return;
    L39:
        t0.a.post(new k(r23));
        goto L40
    }

    public final void c(byte[] r3) {
        UgcVoiceCreateFragment r0 = this.a;
        LarusDialogCreateUgcVoiceBinding r1 = r0.e;
        if (r1 == null) goto L8;
        ChatSpeaker r2 = r1.g;
        if (r2 == null) goto L9;
        r2.d8(LifecycleOwnerKt.getLifecycleScope(r0), r3);
        return;
    L9:
        return;
    }
}

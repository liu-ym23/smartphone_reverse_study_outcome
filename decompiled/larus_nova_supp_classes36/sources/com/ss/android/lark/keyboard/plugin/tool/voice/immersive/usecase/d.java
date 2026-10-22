package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ss.android.lark.audio.voiceinput.CancelAsrTimeoutState;
import com.ss.android.lark.audio.voiceinput.VoiceInputMode;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioAsrLanguageSwitcher;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel;
import com.ss.android.lark.log.Log;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements View.OnTouchListener {
    public final /* synthetic */ VoiceActionAreaUseCase a;

    public d(VoiceActionAreaUseCase r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r6v4, types: [android.widget.EditText, com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText, com.ss.android.lark.keyboard.edittext2.widget.RichTextFunctionEditText] */
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r6, MotionEvent r7) {
        int r8 = r7.getActionMasked();
        if (r8 == 0) goto L15;
        if (r8 != 1) goto L6;
    L8:
        ViewParent r9 = r6.getParent();
        if (r9 == null) goto L11;
        r9.requestDisallowInterceptTouchEvent(false);
    L11:
        Log.i("VoiceActionAreaUseCase", "ACTION_UP or ACTION_CANCEL");
        VoiceActionAreaUseCase.c(this.a);
        r6.performClick();
        this.a.e().stopVoiceRecord();
        this.a.e().whenReleaseOrCancelTouch();
        if (this.a.e().isBackgroundAsrKeepSessionMode() == false) goto L14;
        Log.i("VoiceActionAreaUseCase", "dismiss popup");
        this.a.e().requestHidePopupKeepSession();
    L29:
        return true;
    L14:
        Log.i("VoiceActionAreaUseCase", "not dismiss popup");
        goto L29
    L6:
        if (r8 == 3) goto L8;
    L15:
        ViewParent r10 = r6.getParent();
        if (r10 == null) goto L18;
        r10.requestDisallowInterceptTouchEvent(true);
    L18:
        ?? r11 = this.a.b.a();
        ImmersiveVoiceViewModel r12 = this.a.e();
        CancelAsrTimeoutState r2 = CancelAsrTimeoutState.CancelByInputChange;
        if (r11.getEditableText().length() != 0) goto L21;
        boolean r3 = true;
    L22:
        r12.cancelAsrTimeOut(r2, !r3, false);
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a r13 = this.a.b;
        ((ConstraintLayout) r13.z.getValue()).setVisibility(0);
        ((View) r13.A.getValue()).setPivotX(((View) r13.A.getValue()).getWidth());
        ((View) r13.A.getValue()).setScaleX(0.9f);
        ((View) r13.A.getValue()).animate().scaleX(1.0f).setDuration(150).start();
        r13.i().setVisibility(4);
        r13.c().setVisibility(4);
        r13.j().setVisibility(4);
        r13.e().setVisibility(4);
        r13.g().setVisibility(4);
        r13.k().setVisibility(4);
        if (this.a.e().isVoiceInputMarkdownFg() == false) goto L25;
        sob.c.e(this.a.e().getInsertPeriodRichText(), this.a.e().addPeriodForRichTextIfNeed(r11.getEditableText().toString(), r11.getSelectionStart()));
    L26:
        String r14 = com.ss.android.lark.keyboard.plugin.tool.voice.utils.c.a(r11);
        this.a.e().setBeforeVoiceEditAsrResult(r14);
        sob.c.e(this.a.e().getBeforeInsetSelection(), new Pair(Integer.valueOf(r11.getSelectionStart()), Integer.valueOf(r11.getSelectionEnd())));
        ImmersiveVoiceViewModel r15 = this.a.e();
        com.ss.android.lark.audio.voiceinput.p r4 = new com.ss.android.lark.audio.voiceinput.p(VoiceInputMode.SecondVoice, this.a.e().getImmersiveVoiceMode().b);
        int r5 = AudioAsrLanguageSwitcher.i;
        if (r15.startVoiceRecord(r4, AudioAsrLanguageSwitcher.a.a(), r14) == false) goto L29;
        sob.d r16 = sob.d.a;
        String r17 = this.a.e().getCurrentRecordSourceId();
        Map r18 = MapsKt.emptyMap();
        r16.getClass();
        Intrinsics.checkNotNullParameter(r17, "sourceId");
        Intrinsics.checkNotNullParameter(r18, "extraAnalyticParams");
        sob.d.e("im_voice_input_click", r18, new Pair[]{new Pair("source_id", r17), new Pair("click", "voice_input_continue_mic")});
        goto L29
    L25:
        sob.c.e(this.a.e().getInsertPeriod(), this.a.e().addPeriodIfNeed(r11.getEditableText().toString(), r11.getSelectionStart()));
        goto L26
    L21:
        r3 = false;
        goto L22
    }
}

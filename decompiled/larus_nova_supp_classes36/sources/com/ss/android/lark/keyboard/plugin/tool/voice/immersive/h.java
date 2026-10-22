package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import androidx.lifecycle.Observer;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.SpannableStringUtils;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel;
import com.ss.android.lark.log.Log;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h<T> implements Observer {
    public final /* synthetic */ AsrInputVoiceView a;
    public final /* synthetic */ m b;
    public final /* synthetic */ ImmersiveVoiceViewModel c;

    public h(AsrInputVoiceView r1, m r2, ImmersiveVoiceViewModel r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    /* JADX WARN: Type inference failed for: r8v5, types: [android.widget.EditText, androidx.appcompat.widget.AppCompatEditText, com.ss.android.lark.keyboard.edittext2.widget.RichTextFunctionEditText] */
    public final void onChanged(Object r8) {
        if (((Boolean) r8).booleanValue() == false) goto L35;
        Log.i("AsrInputVoiceView", "asrFinished");
        ?? r9 = this.a.V6(this.b);
        if (r9 == 0) goto L30;
        AsrInputVoiceView r1 = this.a;
        Editable r2 = r9.getText();
        Lazy r3 = SpannableStringUtils.a;
        SpannableStringUtils.c(r2);
        if (r2 == null) goto L9;
        int r4 = r2.length();
    L10:
        int r5 = r4 - ((SpannableStringBuilder) r1.q.getSecond()).length();
        if (r2 == null) goto L18;
        if (r5 <= 0) goto L18;
        if (r2.length() < r5) goto L18;
        int r6 = r5 - 1;
        if (r2.charAt(r6) != ' ') goto L18;
        Log.i("AsrInputVoiceView", "remove asr result last empty char");
        r2.delete(r6, r5);
    L18:
        KeyboardVoiceFGUtils r7 = KeyboardVoiceFGUtils.a;
        if (KeyboardVoiceFGUtils.i() == true) goto L29;
        r9.setText(r2);
        StringBuilder r10 = new StringBuilder("when asrFinished, the result text.length: ");
        if (r2 == null) goto L23;
        int r11 = r2.length();
    L24:
        r10.append(r11);
        Log.i("AsrInputVoiceView", r10.toString());
        if (r2 == null) goto L29;
        if ((r2.length() - ((SpannableStringBuilder) r1.q.getSecond()).length()) < 0) goto L29;
        r9.setSelection(r2.length() - ((SpannableStringBuilder) r1.q.getSecond()).length());
        goto L29
    L23:
        r11 = -1;
    L29:
        r9.requestFocus();
        String.valueOf(r2);
        r9.setHint(r1.i);
        r1.k = r1.i;
        Log.i("AsrInputVoiceView", "current hint: " + r1.k.length());
        AsrInputVoiceView.c6(r1).unregisterListener();
        Log.i("AsrInputVoiceView", "unregisterListener over");
        AsrInputVoiceView.c6(r1).reportAsrEndEditContent(com.ss.android.lark.keyboard.plugin.tool.voice.utils.c.a(r9));
        goto L30
    L9:
        r4 = -100;
    L30:
        this.a.y.clear();
        if (this.a.F.getVisibility() == 8) goto L33;
        Log.i("AsrInputVoiceView", "touch through view visibility: " + this.a.F.getVisibility() + ", set touch through view gone");
        this.a.F.setVisibility(8);
    L33:
        AsrInputVoiceView.c6(this.a).clearSessionState();
        AsrInputVoiceView r12 = this.a;
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.c r0 = (com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.c) this.c.getAsrResultRichText().getValue();
        r12.getClass();
        return;
    }
}

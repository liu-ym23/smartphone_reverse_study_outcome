package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import android.text.SpannableStringBuilder;
import androidx.lifecycle.Observer;
import com.ss.android.lark.keyboard.edittext2.widget.RichTextFunctionEditText;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.SpannableStringUtils;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel;
import com.ss.android.lark.log.Log;
import kotlin.Lazy;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e<T> implements Observer {
    public final /* synthetic */ AsrInputVoiceView a;
    public final /* synthetic */ m b;
    public final /* synthetic */ ImmersiveVoiceViewModel c;

    public e(AsrInputVoiceView r1, m r2, ImmersiveVoiceViewModel r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onChanged(Object r10) {
        CharSequence r11 = (CharSequence) r10;
        Log.i("AsrInputVoiceView", "asrResult not rich text");
        boolean r0 = false;
        if (r11 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L11;
    L13:
        final Ref.ObjectRef r4 = new Ref.ObjectRef();
        r4.element = new SpannableStringBuilder();
        final RichTextFunctionEditText r5 = this.a.V6(this.b);
        if (r5 == null) goto L24;
        final AsrInputVoiceView r6 = this.a;
        ImmersiveVoiceViewModel r7 = this.c;
        ((SpannableStringBuilder) r4.element).append((CharSequence) r6.q.getFirst());
        if (r11 != null) goto L18;
    L19:
        r0 = true;
    L20:
        if (r0 == true) goto L22;
        ((SpannableStringBuilder) r4.element).append(r6.w);
    L22:
        ((SpannableStringBuilder) r4.element).append(r11);
        Lazy r12 = SpannableStringUtils.a;
        SpannableStringBuilder r13 = SpannableStringUtils.a(r6.d, (SpannableStringBuilder) r4.element, null, null);
        r4.element = r13;
        r13.append((CharSequence) r6.q.getSecond());
        sob.c.d(r7, "updateAsrResult", new AsrInputVoiceView$initObserver$1$1$1$1(r5, r4, r6));
        Log.i("AsrInputVoiceView", "resultSpan: " + ((SpannableStringBuilder) r4.element).length() + ", mTextBeforeRecord.first " + ((SpannableStringBuilder) r6.q.getFirst()).length() + " mTextBeforeRecord.second: " + ((SpannableStringBuilder) r6.q.getSecond()).length());
        return;
    L18:
        if (r11.length() != 0) goto L20;
    L24:
        return;
    L11:
        if (this.a.u != 0) goto L13;
        return;
    L5:
        if (r11.length() == 0) goto L8;
        r3 = false;
        goto L9
    }
}

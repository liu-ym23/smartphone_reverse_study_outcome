package p98;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.avlink.env.prompt.DoraEnvObservePromptInputDialog;
import com.larus.avlink.impl.databinding.FragmentTextInputDialogBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d implements TextWatcher {
    public final /* synthetic */ DoraEnvObservePromptInputDialog a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public d(DoraEnvObservePromptInputDialog r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r6) {
        DoraEnvObservePromptInputDialog r0 = this.a;
        if (r0.f == false) goto L5;
        return;
    L5:
        r0.f = true;
        if (r6 == null) goto L8;
        int r2 = r6.length();
    L9:
        if (r2 != 0) goto L22;
        Context r1 = this.a.getContext();
        if (r1 == null) goto L34;
        DoraEnvObservePromptInputDialog r3 = this.a;
        FragmentTextInputDialogBinding r4 = r3.d;
        if (r4 == null) goto L17;
        TextView r5 = r4.e;
        if (r5 == null) goto L17;
        r5.setClickable(false);
    L17:
        FragmentTextInputDialogBinding r7 = r3.d;
        if (r7 == null) goto L34;
        TextView r8 = r7.e;
        if (r8 == null) goto L34;
        r8.setTextColor(ContextCompat.getColor(r1, v19.c.b(2130972081, r1, 2131103143)));
    L34:
        DoraEnvObservePromptInputDialog r9 = this.a;
        if (r9.e > 0) goto L38;
        r9.f = false;
        return;
    L38:
        if (r6 == null) goto L40;
        int r10 = r6.length();
    L41:
        DoraEnvObservePromptInputDialog r11 = this.a;
        if (r10 <= r11.e) goto L55;
        FragmentTextInputDialogBinding r12 = r11.d;
        if (r12 == null) goto L48;
        TextView r13 = r12.c;
        if (r13 == null) goto L48;
        r13.setVisibility(0);
    L48:
        if (r6 == null) goto L50;
        r6.delete(this.a.e, r6.length());
    L50:
        StringBuilder r14 = new StringBuilder();
        r14.append(this.a.e);
        r14.append('/');
        r14.append(this.a.e);
        String r15 = r14.toString();
        int r16 = String.valueOf(this.a.e).length();
        SpannableString r17 = new SpannableString(r15);
        r17.setSpan(new ForegroundColorSpan(ColorProtector.parseColor("#FF3B30")), 0, r16, 33);
        FragmentTextInputDialogBinding r18 = this.a.d;
        if (r18 == null) goto L60;
        TextView r19 = r18.c;
        if (r19 == null) goto L60;
        r19.setText(r17);
    L60:
        this.a.f = false;
        return;
    L55:
        FragmentTextInputDialogBinding r20 = r11.d;
        if (r20 == null) goto L60;
        TextView r21 = r20.c;
        if (r21 == null) goto L60;
        r21.setVisibility(8);
        goto L60
    L40:
        r10 = 0;
        goto L41
    L22:
        Context r22 = this.a.getContext();
        if (r22 == null) goto L34;
        DoraEnvObservePromptInputDialog r23 = this.a;
        FragmentTextInputDialogBinding r24 = r23.d;
        if (r24 == null) goto L29;
        TextView r25 = r24.e;
        if (r25 == null) goto L29;
        r25.setClickable(true);
    L29:
        FragmentTextInputDialogBinding r26 = r23.d;
        if (r26 == null) goto L34;
        TextView r27 = r26.e;
        if (r27 == null) goto L34;
        r27.setTextColor(ContextCompat.getColor(r22, v19.c.b(2130972123, r22, 2131103203)));
        goto L34
    L8:
        r2 = 0;
        goto L9
    }
}

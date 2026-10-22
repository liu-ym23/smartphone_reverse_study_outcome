package com.obric.oui.forms;

import android.content.res.Resources;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$string;

/* JADX INFO: loaded from: classes3.dex */
public final class s implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OLineInputView f13369b;

    public /* synthetic */ s(OLineInputView r5, int r10) {
        this.f13368a = r10;
        this.f13369b = r5;
    }

    private final void a(CharSequence r5, int r10, int r11, int r12) {
    }

    private final void b(CharSequence r5, int r10, int r11, int r12) {
    }

    private final void c(CharSequence r5, int r10, int r11, int r12) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r5) {
        switch(this.f13368a) {
            case 0: goto L12;
            default: goto L4;
        };
    L4:
        OLineInputView r10 = this.f13369b;
        if (r5 != null) goto L7;
    L10:
        r10.e();
        return;
    L7:
        if (r5.length() == 0) goto L10;
        com.lynx.tasm.utils.d.t(r10.f13306r);
        com.lynx.tasm.utils.d.t(r10.f13305q);
        r10.F.f13351c = false;
        return;
    L12:
        OLineInputView r11 = this.f13369b;
        if (r11.F.g == null) goto L26;
        int r12 = 0;
        if (r5 != null) goto L17;
        int r13 = 0;
    L18:
        Integer r14 = r11.F.g;
        if (r14 == null) goto L22;
        r12 = r14.intValue();
    L22:
        if (r13 <= r12) goto L27;
        r11.F.getClass();
        return;
    L27:
        return;
    L17:
        r13 = r5.length();
        goto L18
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r5, int r10, int r11, int r12) {
        int r13 = this.f13368a;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r5, int r10, int r11, int r12) {
        switch(this.f13368a) {
            case 0: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        OLineInputView r13 = this.f13369b;
        if (r13.F.g == null) goto L31;
        Resources r14 = r13.getResources();
        int r15 = R$string.oui_form_counter;
        if (r5 != null) goto L10;
        String r16 = null;
    L11:
        SpannableString r17 = new SpannableString(r14.getString(r15, new Object[]{r16, String.valueOf(r13.F.g)}));
        if (r5 != null) goto L14;
        int r18 = 0;
    L15:
        Integer r19 = r13.F.g;
        if (r19 != null) goto L18;
        int r20 = 0;
    L19:
        if (r18 <= r20) goto L28;
        ForegroundColorSpan r21 = new ForegroundColorSpan(ContextCompat.getColor(r13.getContext(), R$color.Primary));
        if (r5 != null) goto L23;
    L22:
        int r22 = 0;
    L27:
        r17.setSpan(r21, 0, r22, 18);
        r13.getDivider().setBackgroundColor(ContextCompat.getColor(r13.getContext(), R$color.Primary));
    L29:
        r13.getTvCounter().setText(r17, TextView.BufferType.SPANNABLE);
        return;
    L23:
        String r23 = Integer.valueOf(r5.length()).toString();
        if (r23 == null) goto L22;
        r22 = r23.length();
        goto L27
    L28:
        r13.getDivider().setStyle(0);
        goto L29
    L18:
        r20 = r19.intValue();
        goto L19
    L14:
        r18 = r5.length();
        goto L15
    L10:
        r16 = Integer.valueOf(r5.length()).toString();
        goto L11
    }
}

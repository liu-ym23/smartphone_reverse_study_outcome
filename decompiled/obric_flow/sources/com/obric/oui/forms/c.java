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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f13330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f13331c;

    public /* synthetic */ c() {
        this.f13329a = 1;
    }

    private final void a(CharSequence r5, int r10, int r11, int r12) {
    }

    private final void b(CharSequence r5, int r10, int r11, int r12) {
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r5) {
        switch(this.f13329a) {
            case 0: goto L10;
            default: goto L4;
        };
    L4:
        ?? r10 = (Lambda) this.f13331c;
        if (r10 == 0) goto L13;
        r10.invoke(r5);
        return;
    L13:
        return;
    L10:
        if (((a) this.f13330b).f13325j == false) goto L14;
        OBoxInputView r11 = (OBoxInputView) this.f13331c;
        r11.getEditText().post(new b(r11, 1));
        return;
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r5, int r10, int r11, int r12) {
        int r13 = this.f13329a;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [kotlin.jvm.functions.Function4, kotlin.jvm.internal.Lambda] */
    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r5, int r10, int r11, int r12) {
        switch(this.f13329a) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        ?? r13 = (Lambda) this.f13330b;
        if (r13 == 0) goto L31;
        r13.invoke(r5, Integer.valueOf(r10), Integer.valueOf(r11), Integer.valueOf(r12));
        return;
    L31:
        return;
    L9:
        a r14 = (a) this.f13330b;
        if (r14.d == null) goto L32;
        OBoxInputView r15 = (OBoxInputView) this.f13331c;
        Resources r16 = r15.getResources();
        int r17 = R$string.oui_form_counter;
        if (r5 != null) goto L14;
        String r18 = null;
    L15:
        SpannableString r19 = new SpannableString(r16.getString(r17, new Object[]{r18, String.valueOf(r14.d)}));
        if (r5 != null) goto L18;
        int r20 = 0;
    L19:
        Integer r21 = r14.d;
        Intrinsics.checkNotNull(r21);
        if (r20 <= r21.intValue()) goto L29;
        ForegroundColorSpan r22 = new ForegroundColorSpan(ContextCompat.getColor(r15.getContext(), R$color.Primary));
        if (r5 != null) goto L24;
    L23:
        int r23 = 0;
    L28:
        r19.setSpan(r22, 0, r23, 18);
        goto L29
    L24:
        String r24 = Integer.valueOf(r5.length()).toString();
        if (r24 == null) goto L23;
        r23 = r24.length();
    L29:
        r15.getTvCounter().setText(r19, TextView.BufferType.SPANNABLE);
        return;
    L18:
        r20 = r5.length();
        goto L19
    L14:
        r18 = Integer.valueOf(r5.length()).toString();
        goto L15
    }

    public c(a r5, OBoxInputView r10) {
        this.f13329a = 0;
        this.f13330b = r5;
        this.f13331c = r10;
    }
}

package com.larus.avlink.env.diary.detail;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class p implements TextWatcher {
    public final /* synthetic */ DiaryFeedbackBottomSheetDialogFragment a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public p(DiaryFeedbackBottomSheetDialogFragment r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r3) {
        DiaryFeedbackBottomSheetDialogFragment r0 = this.a;
        int r1 = DiaryFeedbackBottomSheetDialogFragment.h;
        DoraEnvObserveDiaryDetailViewModel r2 = r0.S90();
        if (r3 == null) goto L5;
        String r4 = r3.toString();
    L6:
        if (r4 != null) goto L8;
        r4 = "";
    L8:
        r2.updateInputText(r4);
        return;
    L5:
        r4 = null;
        goto L6
    }
}

package com.ss.android.lark.conditional.access.device.ui;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.ss.android.lark.conditional.access.device.viewmodel.DeviceDeclareViewModel;
import com.tencent.qqmusic.third.api.contract.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements TextWatcher {
    public final /* synthetic */ UserScopeDeclareReasonEditFragment a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public b(UserScopeDeclareReasonEditFragment r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r3) {
        UserScopeDeclareReasonEditFragment r0 = this.a;
        int r1 = UserScopeDeclareReasonEditFragment.m;
        DeviceDeclareViewModel r2 = r0.X90();
        if (r3 == null) goto L6;
        String r4 = r3.toString();
        if (r4 == null) goto L6;
    L7:
        r2.setReason(r4);
        if (r3 == null) goto L10;
        int r5 = TextUtils.getTrimmedLength(r3);
    L11:
        this.a.Y90(r5);
        return;
    L10:
        r5 = 0;
    L6:
        r4 = BuildConfig.FLAVOR;
        goto L7
    }
}

package com.bytedance.android.livesdk.interactivity.roomintro.v2.adapter;

import android.text.Editable;
import android.text.TextWatcher;
import com.bytedance.android.live.broadcast.api.BroadcastSecurityApi;
import com.bytedance.android.livesdk.widget.TextCorrectionEditText;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i implements TextWatcher {
    public final /* synthetic */ TextCorrectionEditText a;
    public final /* synthetic */ a b;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r4) {
        boolean r0 = false;
        if (this.a.getAutomaticChanged() == false) goto L6;
        this.a.setAutomaticChanged(false);
        return;
    L6:
        a r5 = this.b;
        TextCorrectionEditText r1 = this.a;
        r5.getClass();
        if (r1 == null) goto L18;
        Editable r2 = r1.getText();
        if (r2 != null) goto L12;
    L13:
        r0 = true;
    L14:
        if (r0 == true) goto L19;
        ((BroadcastSecurityApi) com.bytedance.android.live.network.c.b().e(BroadcastSecurityApi.class)).textCorrection(r1.getText().toString()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(r5), k.a, l.a);
        return;
    L19:
        return;
    L12:
        if (r2.length() != 0) goto L14;
    }

    public i(TextCorrectionEditText r1, a r2) {
        this.a = r1;
        this.b = r2;
    }
}

package com.bytedance.android.live.liveinteract.linkpanel.dialog;

import android.content.DialogInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.liveinteract.linkpanel.vm.GuestApplyViewModel;
import com.bytedance.android.live.liveinteract.plantform.model.GetInfoBeforeAddPriceResponse;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements DialogInterface.OnDismissListener {
    public final /* synthetic */ IncreasePriceApplyDialog a;
    public final /* synthetic */ Observer b;
    public final /* synthetic */ Observer c;

    public a(IncreasePriceApplyDialog r1, b r2, c r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r2) {
        GuestApplyViewModel r3 = this.a.f;
        if (r3 == null) goto L7;
        LiveData<GetInfoBeforeAddPriceResponse> r4 = r3.getAfterIncreasePriceData();
        if (r4 == null) goto L7;
        r4.removeObserver(this.b);
    L7:
        GuestApplyViewModel r5 = this.a.f;
        if (r5 == null) goto L13;
        MutableLiveData<Boolean> r6 = r5.getAddPriceState();
        if (r6 == null) goto L14;
        r6.removeObserver(this.c);
        return;
    L14:
        return;
    }
}

package com.bytedance.android.live.profile.whitetag;

import com.bytedance.android.live.base.model.user.IBaseUser;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ WhiteCertSubDialogFragment a;

    public a(WhiteCertSubDialogFragment r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        IBaseUser r3 = (IBaseUser) r2;
        WhiteCertSubDialogFragment r4 = this.a;
        int r0 = WhiteCertSubDialogFragment.j;
        r4.T90();
    }
}

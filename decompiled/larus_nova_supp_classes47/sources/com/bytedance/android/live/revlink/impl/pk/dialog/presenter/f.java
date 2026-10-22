package com.bytedance.android.live.revlink.impl.pk.dialog.presenter;

import com.bytedance.android.live.base.model.user.IBaseUser;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f extends i11.c.a {
    public final /* synthetic */ j a;

    public f(j r1) {
        this.a = r1;
    }

    @Override // i11.c.a, i11.c.b
    public final void c(int r1, List<? extends IBaseUser> r2) {
        this.a.h.postValue(Boolean.TRUE);
    }
}

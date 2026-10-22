package com.bytedance.android.livesdk.interactivity.roomintro.v2.adapter;

import com.bytedance.android.live.broadcast.api.BroadcastSecurityApi;
import com.bytedance.android.livesdk.widget.TextCorrectionEditText;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h implements TextCorrectionEditText.b {
    public final /* synthetic */ a a;

    public h(a r1) {
        this.a = r1;
    }

    public final void ignoreCorrection(String r4) {
        Intrinsics.checkNotNullParameter(r4, "errorWord");
        this.a.getClass();
        if (r4 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == true) goto L13;
        ((BroadcastSecurityApi) com.bytedance.android.live.network.c.b().e(BroadcastSecurityApi.class)).ignoreCorrection(r4).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(b.a, c.a, d.a);
        return;
    L13:
        return;
    L5:
        if (r4.length() == 0) goto L8;
        r0 = false;
        goto L9
    }
}

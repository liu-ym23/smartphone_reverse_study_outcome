package com.bytedance.android.livesdk.dislike.action;

import android.content.Context;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.dislike.NotificationSettingBottomDialog;
import io.reactivex.functions.Consumer;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ c a;
    public final /* synthetic */ String b;

    public a(c r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        if (((cn2.c) ((BaseResponse) ((Response) r4)).data).a() != 0) goto L13;
        com.bytedance.android.livesdk.dislike.m r5 = this.a.e.c;
        if (r5 == null) goto L7;
        Context r6 = r5.getContext();
    L8:
        f2.i(r6, s1.B(2131920764), 0);
        NotificationSettingBottomDialog.b r7 = this.a.g;
        if (r7 == null) goto L11;
        r7.onSuccess(this.b, 1);
    L11:
        HashMap r8 = bn2.k.a;
        bn2.k.d("on", this.b, this.a.e.e);
        return;
    L7:
        r6 = null;
        goto L8
    }
}

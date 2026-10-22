package com.bytedance.android.livesdk.interactivity.roomintro.v2.adapter;

import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.widget.TextCorrectionEditText;
import com.bytedance.android.livesdkapi.depend.model.live.security.TextCorrection;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ a a;

    public j(a r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Response r3 = (Response) r2;
        TextCorrectionEditText r0 = this.a.c;
        if (r0 == null) goto L11;
        if (r3 == null) goto L8;
        TextCorrection r4 = (TextCorrection) ((BaseResponse) r3).data;
        if (r4 == null) goto L8;
        List r5 = r4.correctionResults;
    L9:
        r0.d(r5);
        return;
    L8:
        r5 = null;
        goto L9
    }
}

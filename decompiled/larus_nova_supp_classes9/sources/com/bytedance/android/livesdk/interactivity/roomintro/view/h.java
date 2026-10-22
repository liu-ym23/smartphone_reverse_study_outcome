package com.bytedance.android.livesdk.interactivity.roomintro.view;

import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.widget.TextCorrectionEditText;
import com.bytedance.android.livesdkapi.depend.model.live.security.TextCorrection;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ RoomIntroDialog a;

    public h(RoomIntroDialog r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Response r4 = (Response) r3;
        TextCorrectionEditText r0 = this.a.S90(2131371469);
        if (r4 == null) goto L7;
        TextCorrection r5 = (TextCorrection) ((BaseResponse) r4).data;
        if (r5 == null) goto L7;
        List r6 = r5.correctionResults;
    L8:
        r0.d(r6);
        return;
    L7:
        r6 = null;
        goto L8
    }
}

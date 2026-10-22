package r12;

import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.livesdk.gift.platform.format.jsb.FormatSendGiftResultModel;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ e a;

    public d(e r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        ApiServerException r5 = (Throwable) r4;
        FormatSendGiftResultModel r0 = new FormatSendGiftResultModel();
        r0.a(FormatSendGiftResultModel.Code.Failed);
        if ((r5 instanceof ApiException) == false) goto L8;
        r0.b(Integer.valueOf(((ApiException) r5).getErrorCode()));
        if ((r5 instanceof ApiServerException) == false) goto L7;
        r0.c(r5.getPrompt());
    L7:
        this.a.finishWithResult(r0);
        return;
    L8:
        this.a.finishWithFailure(new RuntimeException("2: " + r5.getMessage()));
    }
}

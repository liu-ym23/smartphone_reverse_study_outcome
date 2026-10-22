package ao0;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.livesdkapi.ILiveResponseExtraInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements ILiveResponseExtraInfo {
    public final /* synthetic */ e a;
    public final /* synthetic */ Throwable b;

    public final long getServerTimestamp() {
        BaseResponse r0 = this.b.getResponse();
        if (r0 == null) goto L8;
        R r1 = r0.extra;
        if (r1 == 0) goto L8;
        return ((Extra) r1).now;
    L8:
        return System.currentTimeMillis();
    }

    public final ILiveResponseExtraInfo.IStatusInfo getStatusInfo() {
        e r0 = this.a;
        int r1 = this.b.getErrorCode();
        String r2 = this.b.getMessage();
        BaseResponse r3 = this.b.getResponse();
        if (r3 == null) goto L7;
        RequestError r4 = r3.error;
        if (r4 == null) goto L7;
        String r5 = r4.prompts;
    L8:
        r0.getClass();
        return new a(r1, r2, r5);
    L7:
        r5 = null;
        goto L8
    }

    public b(e r1, Throwable r2) {
        this.a = r1;
        this.b = r2;
    }
}

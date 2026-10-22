package com.bytedance.android.live.broadcastgame.opengame.control.report;

import android.util.LruCache;
import com.bytedance.android.live.broadcastgame.opengame.network.l0;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ ReportSubmitControl a;

    public e(ReportSubmitControl r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        LruCache<String, byte[]> r0 = ReportPicUploader.a;
        ReportPicUploader.e(((l0) ((BaseResponse) ((Response) r3)).data).a(), String.valueOf(this.a.h));
        c r4 = this.a.b;
        if (r4 == null) goto L6;
        r4.G0();
        return;
    }
}

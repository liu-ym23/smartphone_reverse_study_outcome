package com.bytedance.android.live.broadcastgame.opengame.control.out_report;

import android.util.LruCache;
import com.bytedance.android.live.broadcastgame.opengame.control.report.ReportPicUploader;
import com.bytedance.android.live.broadcastgame.opengame.network.l0;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ ReportSubmitControl a;

    public b(ReportSubmitControl r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        LruCache<String, byte[]> r0 = ReportPicUploader.a;
        String r3 = ((l0) ((BaseResponse) ((Response) r2)).data).a();
        Intrinsics.checkNotNull(r3);
        ReportPicUploader.e(r3, "-1");
        com.bytedance.android.live.broadcastgame.opengame.control.report.c r4 = this.a.b;
        if (r4 == null) goto L6;
        r4.G0();
        return;
    }
}

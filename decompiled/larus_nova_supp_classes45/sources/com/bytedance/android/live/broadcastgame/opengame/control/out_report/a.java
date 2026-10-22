package com.bytedance.android.live.broadcastgame.opengame.control.out_report;

import com.bytedance.android.live.base.model.user.UploadResult;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements SingleObserver<Response<UploadResult>> {
    public final /* synthetic */ ReportSubmitControl a;
    public final /* synthetic */ String b;

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
    }

    public final void onError(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        if (this.a.getActivity() == null) goto L5;
        ExceptionUtils.handleException(this.a.getActivity(), r2);
    L5:
        com.bytedance.android.live.broadcastgame.opengame.control.report.c r3 = this.a.b;
        if (r3 == null) goto L9;
        r3.i();
        return;
    }

    public final void onSuccess(Object r3) {
        Response r4 = (Response) r3;
        Intrinsics.checkNotNullParameter(r4, "response");
        ((UploadResult) ((BaseResponse) r4).data).setPath(this.b);
        ReportSubmitControl r0 = this.a;
        UploadResult r5 = (UploadResult) ((BaseResponse) r4).data;
        r0.d = r5;
        com.bytedance.android.live.broadcastgame.opengame.control.report.c r1 = r0.b;
        if (r1 == null) goto L6;
        r1.J(r5);
        return;
    }

    public a(ReportSubmitControl r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}

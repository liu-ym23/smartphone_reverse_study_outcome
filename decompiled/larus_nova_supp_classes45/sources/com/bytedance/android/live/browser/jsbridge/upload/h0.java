package com.bytedance.android.live.browser.jsbridge.upload;

import android.app.ProgressDialog;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.model.user.UploadResult;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h0 implements SingleObserver<Response<UploadResult>> {
    public final /* synthetic */ String a;
    public final /* synthetic */ i0 b;

    public final void onError(Throwable r3) {
        Fragment r0 = this.b.b;
        if (r0 == null) goto L7;
        Context r1 = r0.getContext();
        if (r1 == null) goto L7;
        ExceptionUtils.handleException(r1, r3);
    L7:
        JSONObject r2 = new JSONObject();
        BaseMonitor.add(r2, LiveSlardarConstants.EXTRA_KEY_ERROR_MSG, r3.toString());
        LiveSlardarMonitor.monitorStatus("ttlive_upload_video_error", 21, r2);
        this.b.k();
    }

    public final void onSubscribe(Disposable r2) {
        this.b.a = r2;
    }

    public final void onSuccess(Object r5) {
        i0 r0 = this.b;
        UploadResult r6 = (UploadResult) ((BaseResponse) ((Response) r5)).data;
        String r1 = this.a;
        ProgressDialog r2 = r0.c;
        if (r2 == null) goto L13;
        i0.j(r2);
        r0.c = null;
    L13:
        String r7 = r6.getUri();     // Catch: Exception -> L10
        o30.c.b.getClass();     // Catch: Exception -> L10
        i0.a r3 = new i0.a(r7, o30.c.a(r1));     // Catch: Exception -> L10
        CallContext r8 = r0.d;     // Catch: Exception -> L10
        if (r8 == null) goto L8;
        r8.b("H5_uploadVideoStatus", r3);     // Catch: Exception -> L10
    L8:
        r0.finishWithResult(r3);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        JSONObject r4 = new JSONObject();
        BaseMonitor.add(r4, LiveSlardarConstants.EXTRA_KEY_ERROR_MSG, e.toString());
        LiveSlardarMonitor.monitorStatus("ttlive_upload_video_error", 31, r4);
        e.printStackTrace();
    }

    public h0(i0 r1, String r2) {
        this.b = r1;
        this.a = r2;
    }
}

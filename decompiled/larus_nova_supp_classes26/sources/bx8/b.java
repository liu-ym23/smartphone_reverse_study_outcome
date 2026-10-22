package bx8;

import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayDoFaceLive;
import com.larus.caijing_pay.impl.config.CJFaceServiceImpl;
import com.ss.android.bytedcert.callback.SDKCallBack;
import com.ss.android.bytedcert.net.BDResponse;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class b implements SDKCallBack.FaceLiveCallback {
    public final /* synthetic */ TTCJPayDoFaceLive.TTCJPayFaceLiveCallback a;
    public final /* synthetic */ CJFaceServiceImpl b;

    public /* synthetic */ b(TTCJPayDoFaceLive.TTCJPayFaceLiveCallback r1, CJFaceServiceImpl r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFaceLiveFinish(BDResponse r3) {
        CJFaceServiceImpl.E2(this.a, this.b, r3);
    }
}

package l20;

import com.bytedance.android.livehostapi.business.depend.xplay.IXplayMessageInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements IXplayMessageInterface.SendMsgListener {
    public final /* synthetic */ h10.b a;

    public b(d r1) {
        this.a = r1;
    }

    public final void onSendResult(boolean r2, int r3, String r4, String r5) {
        h10.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.onSendResult(r2, r3, r4, r5);
        return;
    }
}

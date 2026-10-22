package o7;

import android.app.Activity;
import android.content.Context;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import com.bytedance.android.annie.Annie;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i implements DownloadListener {
    public final /* synthetic */ Context a;
    public final /* synthetic */ WebView b;

    public i(Context r1, q7.b r10) {
        this.a = r1;
        this.b = r10;
    }

    @Override // android.webkit.DownloadListener
    public final void onDownloadStart(String r14, String r15, String r16, String r17, long r18) {
        Context r1 = this.a;
        if ((r1 instanceof Activity) == false) goto L5;
        Activity r10 = (Activity) r1;
    L6:
        if (r10 == null) goto L9;
        ((ca.b) Annie.getService$default(ca.b.class, null, 2, null)).m0(r10, this.b, r14, r15, r16, r17, r18);
        return;
    L9:
        return;
    L5:
        r10 = null;
        goto L6
    }
}

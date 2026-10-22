package ol0;

import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements IMiddlewareHostBusiness.TemplateCallback {
    public final /* synthetic */ d8a.b.a a;

    public a(d8a.b.a r1) {
        this.a = r1;
    }

    public final void onFailed(String r2) {
        d8a.b.a r0 = this.a;
        if (r0 == null) goto L6;
        r0.onFailed(r2);
        return;
    }

    public final void onSuccess(byte[] r2) {
        d8a.b.a r0 = this.a;
        if (r0 == null) goto L6;
        r0.onSuccess(r2);
        return;
    }
}

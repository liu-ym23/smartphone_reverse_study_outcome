package sn0;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements nn0.b.a {
    public final /* synthetic */ b a;
    public final /* synthetic */ pn0.d b;
    public final /* synthetic */ b.InterfaceC0274b c;

    @Override // nn0.b.a
    public final void onError(Throwable r5) {
        this.a.d(this.b.e(), "loadReviewListResource failed, throwable: " + r5);
        this.c.onFailed();
    }

    @Override // nn0.b.a
    public final void onSuccess(String r6) {
        this.a.d(this.b.e(), "loadReviewListResource success, filePath: " + r6);
        if (r6 == null) goto L18;
        b r0 = this.a;
        pn0.d r1 = this.b;
        b.InterfaceC0274b r2 = this.c;
        r0.getClass();
        System.currentTimeMillis();
        List r7 = (List) GsonHelper.get().fromJson(GsonHelper.get().newJsonReader(new PolarisFileReaderWrapper(r6)), new h().getType());     // Catch: Throwable -> L16
        List r3 = r7;     // Catch: Throwable -> L16
        if (r3 != null) goto L8;
    L11:
        boolean r4 = true;
    L12:
        if (r4 == true) goto L14;
        r0.c.a.clear();     // Catch: Throwable -> L16
        r0.c.a.addAll(r7);     // Catch: Throwable -> L16
        r2.onSuccess();     // Catch: Throwable -> L16
        return;
    L14:
        new Throwable("reviewList is null or empty!");     // Catch: Throwable -> L16
        r2.onFailed();     // Catch: Throwable -> L16
        return;
    L8:
        if (r3.isEmpty() == true) goto L11;
        r4 = false;
    L16:
        th = move-exception;
        r0.d(r1.e(), "parseReviewList failed, throwable = " + th);
        r2.onFailed();
        return;
    L18:
        b.InterfaceC0274b r8 = this.c;
        new Throwable("reviewList filePath is null!");
        r8.onFailed();
    }

    public d(b r1, pn0.d r2, e r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}

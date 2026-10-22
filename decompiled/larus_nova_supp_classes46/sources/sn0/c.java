package sn0;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements nn0.b.a {
    public final /* synthetic */ b a;
    public final /* synthetic */ pn0.d b;
    public final /* synthetic */ b.a c;
    public final /* synthetic */ String d;

    @Override // nn0.b.a
    public final void onError(Throwable r5) {
        this.a.d(this.b.e(), "loadGeckoLayoutConfig failed, fileName: " + this.d + ", throwable: " + r5);
        this.c.onFailed(r5);
    }

    @Override // nn0.b.a
    public final void onSuccess(String r6) {
        this.a.d(this.b.e(), "loadGeckoLayoutConfig success, filePath: " + r6);
        if (r6 == null) goto L9;
        b r0 = this.a;
        pn0.d r1 = this.b;
        b.a r2 = this.c;
        r0.getClass();
        LayoutConfigModel r7 = (LayoutConfigModel) GsonHelper.get().fromJson(GsonHelper.get().newJsonReader(new PolarisFileReaderWrapper(r6)), new g().getType());     // Catch: Throwable -> L7
        r0.d(r1.e(), "parseGeckoLayoutConfig success");     // Catch: Throwable -> L7
        r2.a(r7);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        r0.d(r1.e(), "parseGeckoLayoutConfig failed");
        r2.onFailed(th);
        return;
    L9:
        this.c.onFailed(new Throwable("loadGeckoLayoutConfig, filePath is null"));
    }

    public c(b r1, pn0.d r2, f r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}

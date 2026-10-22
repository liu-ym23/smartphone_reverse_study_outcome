package qn0;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements nn0.b.a {
    public final /* synthetic */ a a;
    public final /* synthetic */ pn0.d b;
    public final /* synthetic */ a.InterfaceC0260a c;
    public final /* synthetic */ Ref.ObjectRef d;

    @Override // nn0.b.a
    public final void onError(Throwable r5) {
        this.a.d(this.b.e(), "loadGeckoLayoutConfig failed, fileName: " + ((String) this.d.element) + ", throwable: " + r5);
        this.c.onFailed(r5);
    }

    @Override // nn0.b.a
    public final void onSuccess(String r6) {
        this.a.d(this.b.e(), "loadGeckoLayoutConfig success, filePath: " + r6);
        if (r6 == null) goto L9;
        a r0 = this.a;
        pn0.d r1 = this.b;
        a.InterfaceC0260a r2 = this.c;
        r0.getClass();
        LayoutConfigModel r7 = (LayoutConfigModel) GsonHelper.get().fromJson(GsonHelper.get().newJsonReader(new PolarisFileReaderWrapper(r6)), new f().getType());     // Catch: Throwable -> L7
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

    public e(a r1, pn0.d r2, c r3, Ref.ObjectRef r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}

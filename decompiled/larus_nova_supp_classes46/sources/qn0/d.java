package qn0;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements nn0.b.a {
    public final /* synthetic */ a a;
    public final /* synthetic */ pn0.d b;
    public final /* synthetic */ a.b c;

    @Override // nn0.b.a
    public final void onError(Throwable r5) {
        this.a.d(this.b.e(), "loadOffsetConfigMapResource failed, throwable: " + r5);
        this.c.onFailed();
    }

    @Override // nn0.b.a
    public final void onSuccess(String r8) {
        this.a.d(this.b.e(), "loadGeckoOffsetLayoutConfigMap success, filePath: " + r8);
        if (r8 == null) goto L32;
        a r0 = this.a;
        pn0.d r1 = this.b;
        a.b r2 = this.c;
        r0.getClass();
        pn0.h r9 = (pn0.h) GsonHelper.get().fromJson(GsonHelper.get().newJsonReader(new PolarisFileReaderWrapper(r8)), new g().getType());     // Catch: Throwable -> L30
        HashMap<String, String> r3 = null;
        if (r9 == null) goto L8;
        HashMap<String, HashMap<String, String>> r4 = r9.b();     // Catch: Throwable -> L30
    L9:
        if (r9 == null) goto L11;
        r3 = r9.a();     // Catch: Throwable -> L30
    L11:
        boolean r10 = true;
        if (r4 != null) goto L14;
    L17:
        boolean r6 = true;
    L18:
        if (r6 == true) goto L20;
        r0.c.a.clear();     // Catch: Throwable -> L30
        r0.c.a.putAll(r4);     // Catch: Throwable -> L30
        r2.onSuccess();     // Catch: Throwable -> L30
    L21:
        if (r3 != null) goto L23;
    L26:
        if (r10 == true) goto L28;
        r0.c.b.clear();     // Catch: Throwable -> L30
        r0.c.b.putAll(r3);     // Catch: Throwable -> L30
        r2.onSuccess();     // Catch: Throwable -> L30
        return;
    L28:
        new Throwable("offsetUIFeatureMap is null or empty!");     // Catch: Throwable -> L30
        r2.onFailed();     // Catch: Throwable -> L30
        return;
    L23:
        if (r3.isEmpty() == true) goto L26;
        r10 = false;
        goto L26
    L20:
        new Throwable("offsetConfigMap is null or empty!");     // Catch: Throwable -> L30
        r2.onFailed();     // Catch: Throwable -> L30
        goto L21
    L14:
        if (r4.isEmpty() == true) goto L17;
        r6 = false;
        goto L18
    L8:
        r4 = null;
    L30:
        th = move-exception;
        r0.d(r1.e(), "parseReviewList failed, throwable = " + th);
        r2.onFailed();
        return;
    L32:
        a.b r11 = this.c;
        new Throwable("offsetConfigMap filePath is null!");
        r11.onFailed();
    }

    public d(a r1, pn0.d r2, b r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}

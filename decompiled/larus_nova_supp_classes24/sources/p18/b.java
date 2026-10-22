package p18;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import j18.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b implements d {
    public final OPTrace a;
    public final a b;

    public static class a implements hyb.a {
        public final OPTrace a;

        public a(OPTrace r1) {
            this.a = r1;
        }

        public final void d(String r3, Object... r4) {
            this.a.d("OpenAPI_".concat(r3), r4);
        }

        public final void e(String r3, Object... r4) {
            this.a.e("OpenAPI_".concat(r3), r4);
        }

        public final void i(String r3, Object... r4) {
            this.a.i("OpenAPI_".concat(r3), r4);
        }

        public final void w(String r2, Object... r3) {
            this.a.w("OpenAPI_LKPluginManagerImpl", r3);
        }
    }

    public b() {
        this.a = null;
        OPTrace r0 = gyb.a.a().subTrace();
        this.a = r0;
        Log.e("LKEventContextImpl", "opTrace is null");
        if (this.b != null) goto L6;
        this.b = new a(r0);
        return;
    }
}

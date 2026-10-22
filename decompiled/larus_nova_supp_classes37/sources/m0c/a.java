package m0c;

import com.ss.android.lark.log.Log;
import javax.inject.Inject;
import javax.inject.Singleton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class a extends com.ss.android.lark.log.a {
    @Inject
    public a() {
    }

    public final void d(String r1, String r2) {
        if (r2 != null) goto L4;
        r2 = "";
    L4:
        Log.d(r1, r2);
    }

    public final void e(String r1, String r2) {
        if (r2 != null) goto L4;
        r2 = "";
    L4:
        Log.e(r1, r2);
    }

    public final void i(String r1, String r2) {
        if (r2 != null) goto L4;
        r2 = "";
    L4:
        Log.i(r1, r2);
    }

    public final void v(String r1, String r2) {
        if (r2 != null) goto L4;
        r2 = "";
    L4:
        Log.v(r1, r2);
    }

    public final void w(String r1, String r2) {
        if (r2 != null) goto L4;
        r2 = "";
    L4:
        Log.w(r1, r2);
    }
}

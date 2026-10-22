package u0b;

import android.content.Context;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.provider.interceptor.ChameleonAbsResInterceptor;
import com.ss.android.lark.officesdk.utils.di.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends a {
    @Override // u0b.a
    public final boolean d(Context r1, ChameleonConfig r2) {
        return true;
    }

    public b() {
    }

    @Override // u0b.a
    public final com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.d b(Context r3, ChameleonConfig r4, boolean r5, String r6) {
        j.e(ChameleonAbsResInterceptor.TAG, "getResource, use assert");
        return a(r3, r4, r5, r6);
    }
}

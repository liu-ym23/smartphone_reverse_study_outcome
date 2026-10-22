package u0b;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.GeckoConst;
import com.ss.android.lark.chameleon.ResConfig;
import com.ss.android.lark.chameleon.ResGeckoConfig;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.provider.interceptor.ChameleonAbsResInterceptor;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.vfs.VFSFile;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c extends a {
    public c() {
    }

    public final String e(ChameleonConfig r2) {
        if (r2 == null) goto L10;
        ResConfig r3 = r2.getResConfig();
        if (r3 == null) goto L10;
        ResGeckoConfig r4 = r3.getGeckoConfig();
        if (r4 == null) goto L10;
        HashMap<String, String> r5 = r4.getChannels();
        if (r5 == null) goto L10;
        return r5.get(GeckoConst.FULL_PACKAGE);
    L10:
        return null;
    }

    @Override // u0b.a
    public final boolean d(Context r1, ChameleonConfig r2) {
        int r3 = com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.c.a;
        return !TextUtils.isEmpty(com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.c.d(com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.c.i(r2, e(r2))));
    }

    @Override // u0b.a
    public final com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.d b(Context r5, ChameleonConfig r6, boolean r7, String r8) {
        int r9 = com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.c.a;
        String r10 = com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.c.d(com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.c.i(r6, e(r6)));
        j.e(ChameleonAbsResInterceptor.TAG, "getResource, fullPkg version: " + r10);
        VFSFile r0 = com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.c.i(r6, e(r6));     // Catch: Exception -> L13
        String r2 = BuildConfig.FLAVOR;
        if (r10 != null) goto L7;
        r10 = BuildConfig.FLAVOR;
    L7:
        String r3 = e(r6);     // Catch: Exception -> L13
        if (r3 == null) goto L11;
        r2 = r3;
    L11:
        return c(r6, r0, r10, r2);
    L13:
        e = move-exception;
        j.c(ChameleonAbsResInterceptor.TAG, "getResource error", e);
        return a(r5, r6, r7, null);
    }
}

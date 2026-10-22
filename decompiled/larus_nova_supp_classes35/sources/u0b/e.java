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
public final class e extends a {
    public e() {
    }

    public final String e(ChameleonConfig r2) {
        if (r2 == null) goto L10;
        ResConfig r3 = r2.getResConfig();
        if (r3 == null) goto L10;
        ResGeckoConfig r4 = r3.getGeckoConfig();
        if (r4 == null) goto L10;
        HashMap<String, String> r5 = r4.getChannels();
        if (r5 == null) goto L10;
        return r5.get(GeckoConst.HOTFIX);
    L10:
        return null;
    }

    @Override // u0b.a
    public final boolean d(Context r1, ChameleonConfig r2) {
        int r3 = com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.c.a;
        return !TextUtils.isEmpty(com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.c.d(com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.c.i(r2, e(r2))));
    }

    @Override // u0b.a
    public final com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.d b(Context r4, ChameleonConfig r5, boolean r6, String r7) {
        int r8 = com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.c.a;
        String r9 = com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.c.d(com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.c.i(r5, e(r5)));
        j.e(ChameleonAbsResInterceptor.TAG, "getResource, hotfix version: " + r9);
        VFSFile r10 = com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.c.i(r5, e(r5));     // Catch: Exception -> L13
        String r1 = BuildConfig.FLAVOR;
        if (r9 != null) goto L7;
        r9 = BuildConfig.FLAVOR;
    L7:
        String r2 = e(r5);     // Catch: Exception -> L13
        if (r2 == null) goto L11;
        r1 = r2;
    L11:
        return c(r5, r10, r9, r1);
    L13:
        e = move-exception;
        j.c(ChameleonAbsResInterceptor.TAG, "getResource error", e);
        return a(r4, r5, false, null);
    }
}

package u0b;

import android.content.Context;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.ResConfig;
import com.ss.android.lark.chameleon.ResGeckoConfig;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.provider.interceptor.ChameleonAbsResInterceptor;
import com.ss.android.lark.officesdk.utils.di.j;
import swb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d extends a {
    public final e b;
    public final c c;

    public d() {
        this.b = new e();
        this.c = new c();
    }

    @Override // u0b.a
    public final boolean d(Context r5, ChameleonConfig r6) {
        if (r6 == null) goto L11;
        ResConfig r2 = r6.getResConfig();
        if (r2 == null) goto L11;
        ResGeckoConfig r3 = r2.getGeckoConfig();
        if (r3 == null) goto L11;
        if (r3.getEnable() != true) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == true) goto L14;
        return false;
    L14:
        boolean r7 = this.b.d(r5, r6);
        boolean r8 = this.c.d(r5, r6);
        if (r7 == true) goto L20;
        if (r8 == true) goto L21;
        return false;
    L21:
        return true;
    L20:
        return true;
    L11:
        r4 = false;
        goto L12
    }

    @Override // u0b.a
    public final com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.d b(Context r6, ChameleonConfig r7, boolean r8, String r9) {
        boolean r10 = this.b.d(r6, r7);
        boolean r0 = this.c.d(r6, r7);
        if (r10 == false) goto L9;
        if (r0 == false) goto L9;
        com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.d r11 = this.b.b(r6, r7, r8, null);
        com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.d r12 = this.c.b(r6, r7, r8, null);
        j.e(ChameleonAbsResInterceptor.TAG, "getResource, there are both hotfix and fullPkg resource, compare version");
        if (g.b(r11.b, r12.b) >= 0) goto L8;
        j.e(ChameleonAbsResInterceptor.TAG, "getResource, use fullPkg");
        return r12;
    L8:
        j.e(ChameleonAbsResInterceptor.TAG, "getResource, use hotfix");
        return r11;
    L9:
        if (r10 == false) goto L11;
        j.e(ChameleonAbsResInterceptor.TAG, "getResource, use hotfix");
        return this.b.b(r6, r7, r8, null);
    L11:
        j.e(ChameleonAbsResInterceptor.TAG, "getResource, use fullPkg");
        return this.c.b(r6, r7, r8, null);
    }
}

package com.suite.lark.platform.feature.forward.doubao.assembly;

import android.graphics.drawable.Drawable;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    static {
    }

    public static String a() {
        String r2 = null;
        User r3 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();     // Catch: Throwable -> L32
        if (r3 == null) goto L7;
        String r4 = b0c.a.a(r3);     // Catch: Throwable -> L32
    L8:
        if (r4 == null) goto L9;
    L33:
        String r5 = UIHelper.getString(2131891910);     // Catch: Throwable -> L31
        String r6 = UIHelper.getString(2131891911);     // Catch: Throwable -> L31
        mpc.e r7 = (mpc.e) OfficeSDKManager.getHostGlobalService(mpc.e.class);     // Catch: Throwable -> L30
        if (r7 == null) goto L15;
        mpc.a r8 = r7.K0();     // Catch: Throwable -> L30
    L16:
        StringBuilder r9 = new StringBuilder("generateQuasiTitle: getDoubaoForwardItem iconDrawable==null? ");     // Catch: Throwable -> L30
        if (r8 == null) goto L19;
        Drawable r1 = r8.c;     // Catch: Throwable -> L30
    L20:
        if (r1 != null) goto L22;
        boolean r10 = true;
    L23:
        r9.append(r10);     // Catch: Throwable -> L30
        Log.i("DoubaoQuasiTitleHelper", r9.toString());     // Catch: Throwable -> L30
        if (r8 == null) goto L26;
        r2 = r8.b;     // Catch: Throwable -> L30
    L26:
        if (r2 == null) goto L27;
    L28:
        return r4 + r5 + r2 + r6;
    L22:
        r10 = false;
        goto L23
    L19:
        r1 = null;
        goto L20
    L15:
        r8 = null;
    L27:
        r2 = "";
    L39:
        return "";
    L7:
        r4 = null;
    L9:
        r4 = "";
        goto L33
    }
}

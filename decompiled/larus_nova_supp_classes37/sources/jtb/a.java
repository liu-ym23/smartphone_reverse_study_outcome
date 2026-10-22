package jtb;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements itb.a {
    public a() {
    }

    @Override // itb.a
    public final String i() {
        itb.a r0 = (itb.a) OfficeSDKManager.getHostGlobalService(itb.a.class);
        if (r0 == null) goto L6;
        String r1 = r0.i();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // itb.a
    public final boolean i1() {
        itb.a r0 = (itb.a) OfficeSDKManager.getHostGlobalService(itb.a.class);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.i1();
    }
}

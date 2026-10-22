package jtb;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c implements itb.d {
    public c() {
    }

    @Override // itb.d
    public final int H1(int r2, boolean r3, Integer r4) {
        itb.d r0 = (itb.d) OfficeSDKManager.getHostGlobalService(itb.d.class);
        if (r0 != null) goto L5;
        return r2;
    L5:
        return r0.H1(r2, r3, r4);
    }

    @Override // itb.d
    public final float v0(float r2, boolean r3, Float r4) {
        itb.d r0 = (itb.d) OfficeSDKManager.getHostGlobalService(itb.d.class);
        if (r0 != null) goto L5;
        return r2;
    L5:
        return r0.v0(r2, r3, r4);
    }
}

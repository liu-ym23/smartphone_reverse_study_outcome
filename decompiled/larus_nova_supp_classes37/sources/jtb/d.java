package jtb;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import itb.f;
import itb.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d implements itb.e {
    public d() {
    }

    @Override // itb.e
    public final boolean M0(FragmentActivity r2, g r3, f r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "config");
        Intrinsics.checkNotNullParameter(r4, "callback");
        itb.e r0 = (itb.e) OfficeSDKManager.getHostGlobalService(itb.e.class);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.M0(r2, r3, r4);
    }

    @Override // itb.e
    public final boolean f0(FragmentActivity r2, g r3, f r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "config");
        Intrinsics.checkNotNullParameter(r4, "callback");
        itb.e r0 = (itb.e) OfficeSDKManager.getHostGlobalService(itb.e.class);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.f0(r2, r3, r4);
    }
}

package r80;

import android.content.Context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g implements com.bytedance.android.live.core.utils.screen.a {
    public g() {
    }

    @Override // com.bytedance.android.live.core.utils.screen.a
    public final boolean b(Context r2) {
        return r2.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    L4:
        e = move-exception;
        e.printStackTrace();
        return false;
    }
}

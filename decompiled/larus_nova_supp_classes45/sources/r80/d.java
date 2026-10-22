package r80;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.core.utils.SystemPropertiesUtil;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements com.bytedance.android.live.core.utils.screen.a {
    public d() {
    }

    @Override // com.bytedance.android.live.core.utils.screen.a
    public final boolean b(Context r5) {
        String r1 = SystemPropertiesUtil.getProp("ro.hmct.notch_height");     // Catch: Exception -> L15
        String r2 = SystemPropertiesUtil.getProp("ro.hmct.notch_width");     // Catch: Exception -> L15
        if (TextUtils.equals(r1.trim(), "0") == true) goto L14;
        if (TextUtils.isEmpty(r1.trim()) == true) goto L14;
        if (TextUtils.equals(r2.trim(), "0") == true) goto L14;
        if (TextUtils.isEmpty(r2.trim()) == true) goto L14;
        return true;
    L14:
        return false;
    }
}

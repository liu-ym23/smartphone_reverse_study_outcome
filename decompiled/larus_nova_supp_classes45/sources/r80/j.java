package r80;

import android.content.res.Configuration;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import j40.o2;
import java.util.List;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j implements com.bytedance.android.live.core.utils.screen.b {
    public final List<String> a;

    @Override // com.bytedance.android.live.core.utils.screen.b
    public final boolean isFoldScreen() {
        if (StringsKt.equals("samsung", Build.BRAND, true) == true) goto L5;
    L7:
        String r0 = Build.MODEL;
        if (TextUtils.isEmpty(r0) == false) goto L10;
    L18:
        return false;
    L10:
        if (StringsKt.startsWith$default(r0, "SM-F9", false, 2, null) == false) goto L12;
    L17:
        return true;
    L12:
        if (StringsKt.startsWith$default(r0, "SM-W202", false, 2, null) == true) goto L17;
        if (StringsKt.startsWith$default(r0, "SM-W90", false, 2, null) == true) goto L17;
        if (this.a.contains(r0) == false) goto L18;
    L5:
        if (StringsKt.equals("winner", Build.DEVICE, true) == false) goto L7;
        return true;
    }

    public j() {
        this.a = (List) o2.a.getValue();
    }

    @Override // com.bytedance.android.live.core.utils.screen.b
    public final int a(Configuration r4) {
        if (r4 != null) goto L6;
        return -1;
    L6:
        if (isFoldScreen() == true) goto L8;
        return -1;
    L8:
        float r1 = (r4.screenHeightDp * 1.0f) / r4.screenWidthDp;
        ALogger.d("ttlive_ratio", new i(r4, r1));
        if (r1 >= 0.75f) goto L11;
        return -1;
    L11:
        if (r1 > 1.5f) goto L15;
        return 0;
    L15:
        return -1;
    }
}

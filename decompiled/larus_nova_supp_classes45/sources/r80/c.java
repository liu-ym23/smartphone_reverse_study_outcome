package r80;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.p5;
import j40.j0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class c implements com.bytedance.android.live.core.utils.screen.b, com.bytedance.android.live.core.utils.screen.a {
    public final p5 a;
    public final String b;

    @Override // com.bytedance.android.live.core.utils.screen.b
    public boolean isFoldScreen() {
        if (this.a.b() == true) goto L7;
        return false;
    L7:
        return this.a.c().contains(Build.MODEL);
    }

    public c() {
        this.a = j0.a.getValue();
        this.b = "dynamic_fold_screen_checker";
    }

    @Override // com.bytedance.android.live.core.utils.screen.b
    public int a(Configuration r3) {
        if (r3 != null) goto L6;
        return -1;
    L6:
        if (isFoldScreen() == true) goto L8;
        return -1;
    L8:
        ALogger.d(this.b, b.a);
        float r0 = (r3.screenHeightDp * 1.0f) / r3.screenWidthDp;
        if (r0 >= 0.75f) goto L11;
    L13:
        return 1;
    L11:
        if (r0 > 1.5f) goto L13;
        return 0;
    }

    @Override // com.bytedance.android.live.core.utils.screen.a
    public final boolean b(Context r2) {
        if (this.a.b() == true) goto L7;
        return false;
    L7:
        return this.a.a().contains(Build.MODEL);
    }
}

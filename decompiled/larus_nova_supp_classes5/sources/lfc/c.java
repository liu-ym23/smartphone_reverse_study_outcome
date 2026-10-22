package lfc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.ss.android.newmedia.redbadge.RedBadgerException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c implements kfc.a {
    public c() {
    }

    @Override // kfc.a
    public final List<String> b() {
        return Arrays.asList(new String[]{"com.asus.launcher", "com.lge.launcher", "com.lge.launcher2", "com.lge.launcher3"});
    }

    @Override // kfc.a
    public final void a(Context r4, ComponentName r5, int r6) throws RedBadgerException {
        if (r4 == null) goto L17;
        if (r5 != null) goto L6;
        return;
    L6:
        if (r6 >= 0) goto L8;
        r6 = 0;
    L8:
        Intent r1 = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        r1.putExtra("badge_count", r6);
        r1.putExtra("badge_count_package_name", r5.getPackageName());
        r1.putExtra("badge_count_class_name", r5.getClassName());
        r1.putExtra("badge_vip_count", 0);
        if (nfc.a.a(r4, r1) == false) goto L16;
        r4.sendBroadcast(r1);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        th.printStackTrace();
        throw new RedBadgerException(th.getMessage());
    L16:
        throw new RedBadgerException("unable to resolve intent: " + r1.toString());
    }
}

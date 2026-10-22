package lfc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.ss.android.newmedia.redbadge.RedBadgerException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class d implements kfc.a {
    public d() {
    }

    @Override // kfc.a
    public final List<String> b() {
        return new ArrayList(0);
    }

    @Override // kfc.a
    public final void a(Context r3, ComponentName r4, int r5) throws RedBadgerException {
        if (r3 == null) goto L16;
        if (r4 == null) goto L19;
        if (r5 >= 0) goto L7;
        r5 = 0;
    L7:
        Intent r0 = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        r0.putExtra("badge_count", r5);
        r0.putExtra("badge_count_package_name", r4.getPackageName());
        r0.putExtra("badge_count_class_name", r4.getClassName());
        if (nfc.a.a(r3, r0) == false) goto L15;
        r3.sendBroadcast(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
        throw new RedBadgerException(th.getMessage());
    L15:
        throw new RedBadgerException("unable to resolve intent: " + r0.toString());
    L19:
        return;
    }
}

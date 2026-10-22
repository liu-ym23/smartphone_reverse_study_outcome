package lfc;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.newmedia.redbadge.RedBadgerException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class t implements kfc.a {
    public t() {
    }

    @Override // kfc.a
    public final List<String> b() {
        return new ArrayList(0);
    }

    @Override // kfc.a
    public final void a(Context r3, ComponentName r4, int r5) throws RedBadgerException {
        if (r3 == null) goto L13;
        if (r4 == null) goto L16;
        if (r5 >= 0) goto L7;
        r5 = 0;
    L7:
        Bundle r0 = new Bundle();
        r0.putInt("app_badge_count", r5);
        r0.putString("app_badge_component_name", r4.flattenToString());
        r3.getContentResolver().call(UriProtector.parse("content://com.android.launcher3.cornermark.unreadbadge"), "setAppUnreadCount", null, r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
        throw new RedBadgerException(th.getMessage());
    L16:
        return;
    }
}

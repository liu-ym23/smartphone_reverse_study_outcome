package lfc;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.newmedia.redbadge.RedBadgerException;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class u implements kfc.a {
    public final Uri a;

    @Override // kfc.a
    public final List<String> b() {
        return Collections.singletonList("com.zui.launcher");
    }

    public u() {
        this.a = UriProtector.parse("content://com.android.badge/badge");
    }

    @Override // kfc.a
    public final void a(Context r3, ComponentName r4, int r5) throws RedBadgerException {
        if (r3 == null) goto L12;
        if (r4 == null) goto L15;
        if (r5 >= 0) goto L13;
        r5 = 0;
    L13:
        Bundle r6 = new Bundle();     // Catch: Throwable -> L9
        r6.putInt("app_badge_count", r5);     // Catch: Throwable -> L9
        r3.getContentResolver().call(this.a, "setAppBadgeCount", null, r6);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        th.printStackTrace();
        throw new RedBadgerException(th.getMessage());
    L15:
        return;
    }
}

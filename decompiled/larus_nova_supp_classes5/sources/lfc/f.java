package lfc;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.newmedia.redbadge.RedBadgerException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class f extends kfc.b {
    @Override // kfc.a
    public final List<String> b() {
        return Arrays.asList(new String[]{"com.huawei.android.launcher"});
    }

    public f() {
    }

    @Override // kfc.b
    public final int d(Context r5, ComponentName r6) throws RedBadgerException {
        if (r5 == null) goto L14;
        if (r6 == null) goto L14;
        Bundle r1 = new Bundle();
        r1.putString("package", r5.getPackageName());
        r1.putString("class", r6.getClassName());
        Bundle r7 = r5.getContentResolver().call(UriProtector.parse("content://com.huawei.android.launcher.settings/badge/"), "getbadgeNumber", null, r1);     // Catch: Throwable -> L11
        if (r7 == null) goto L13;
        return r7.getInt("badgenumber");
    L13:
        return -1;
    L11:
        th = move-exception;
        th.printStackTrace();
    L14:
        com.bytedance.push.utils.f.b("HWHomeBadger", "args is null");
        return -1;
    }

    @Override // kfc.a
    public final void a(Context r5, ComponentName r6, int r7) throws RedBadgerException {
        if (r5 == null) goto L14;
        if (r6 == null) goto L17;
        if (r7 >= 0) goto L8;
        r7 = 0;
    L8:
        Bundle r1 = new Bundle();
        r1.putString("package", r5.getPackageName());
        r1.putString("class", r6.getClassName());
        r1.putInt("badgenumber", r7);
        com.bytedance.push.utils.f.b("HWHomeBadger", "set badge number to " + r7);     // Catch: Throwable -> L11
        r5.getContentResolver().call(UriProtector.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", null, r1);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
        throw new RedBadgerException(th.getMessage());
    L17:
        return;
    }
}

package lfc;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.newmedia.redbadge.RedBadgerException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class h extends kfc.b {
    @Override // kfc.a
    public final List<String> b() {
        return Arrays.asList(new String[]{"com.hihonor.android.launcher"});
    }

    public h() {
    }

    @Override // kfc.b
    public final int d(Context r5, ComponentName r6) throws RedBadgerException {
        com.bytedance.push.utils.f.b("HonorHomeBadger", "getCurRedBadgeNumber");
        if (r5 == null) goto L14;
        if (r6 == null) goto L14;
        Bundle r1 = new Bundle();
        r1.putString("package", r5.getPackageName());
        r1.putString("class", r6.getClassName());
        Bundle r7 = r5.getContentResolver().call(UriProtector.parse("content://com.hihonor.android.launcher.settings/badge/"), "getbadgeNumber", null, r1);     // Catch: Throwable -> L11
        if (r7 == null) goto L13;
        return r7.getInt("badgenumber");
    L13:
        return -1;
    L11:
        th = move-exception;
        th.printStackTrace();
    L14:
        com.bytedance.push.utils.f.b("HonorHomeBadger", "args is null");
        return -1;
    }

    @Override // kfc.a
    public final void a(Context r4, ComponentName r5, int r6) throws RedBadgerException {
        if (r4 == null) goto L16;
        if (r5 == null) goto L19;
        if (r6 >= 0) goto L7;
        r6 = 0;
    L7:
        Bundle r0 = new Bundle();
        r0.putString("package", r4.getPackageName());
        r0.putString("class", r5.getClassName());
        r0.putInt("badgenumber", r6);
        Uri r7 = UriProtector.parse("content://com.hihonor.android.launcher.settings/badge/");     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r4.getContentResolver().getType(r7)) == false) goto L11;
        r7 = UriProtector.parse("content://com.huawei.android.launcher.settings/badge/");     // Catch: Throwable -> L13
    L11:
        r4.getContentResolver().call(r7, "change_badge", null, r0);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        th.printStackTrace();
        throw new RedBadgerException(th.getMessage());
    L19:
        return;
    }
}

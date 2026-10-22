package lfc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.newmedia.redbadge.RedBadgerException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class o implements kfc.a {
    public o() {
    }

    @Override // kfc.a
    public final List<String> b() {
        return Arrays.asList(new String[]{"com.smartisanos.launcher", "com.smartisanos.home"});
    }

    @Override // kfc.a
    public final void a(Context r4, ComponentName r5, int r6) throws RedBadgerException {
        if (r4 == null) goto L19;
        if (r5 == null) goto L25;
        if (r6 >= 0) goto L7;
        r6 = 0;
    L7:
        Intent r0 = new Intent("com.smartisanos.launcher.new_message");
        r0.putExtra("extra_packagename", r5.getPackageName());
        r0.putExtra("extra_componentname", r5.getClassName());
        r0.putExtra("extra_message_count", r6);
        if (nfc.a.a(r4, r0) == true) goto L20;
        Bundle r7 = new Bundle();
        r7.putInt("badge_num", r6);
        r4.getContentResolver().call(UriProtector.parse("content://com.smartisanos.launcher.badge"), "updateMessageBadge", null, r7);     // Catch: Throwable -> L17
        return;
    L18:
        throw new RedBadgerException("unable to resolve intent: " + r0.toString());
    L20:
        r4.sendBroadcast(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
        throw new RedBadgerException(th.getMessage());
    L25:
        return;
    }
}

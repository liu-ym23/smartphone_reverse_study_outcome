package lfc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.ss.android.newmedia.redbadge.RedBadgerException;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class j implements kfc.a {
    public j() {
    }

    @Override // kfc.a
    public final List<String> b() {
        return Arrays.asList(new String[]{"com.htc.launcher"});
    }

    @Override // kfc.a
    public final void a(Context r4, ComponentName r5, int r6) throws RedBadgerException {
        if (r4 == null) goto L19;
        if (r5 == null) goto L22;
        if (r6 >= 0) goto L7;
        r6 = 0;
    L7:
        Intent r0 = new Intent("com.htc.launcher.action.SET_NOTIFICATION");
        r0.putExtra("com.htc.launcher.extra.COMPONENT", r5.flattenToShortString());
        r0.putExtra("com.htc.launcher.extra.COUNT", r6);
        Intent r1 = new Intent("com.htc.launcher.action.UPDATE_SHORTCUT");
        r1.putExtra("packagename", r5.getPackageName());
        r1.putExtra(EffectConfiguration.KEY_COUNT, r6);
        if (nfc.a.a(r4, r0) == false) goto L10;
    L20:
        r4.sendBroadcast(r0);     // Catch: Throwable -> L16
        r4.sendBroadcast(r1);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        th.printStackTrace();
        throw new RedBadgerException(th.getMessage());
    L10:
        if (nfc.a.a(r4, r1) == true) goto L20;
        throw new RedBadgerException("unable to resolve intent: " + r1.toString());
    L22:
        return;
    }
}

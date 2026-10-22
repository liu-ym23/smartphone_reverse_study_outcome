package lfc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.ss.android.newmedia.redbadge.RedBadgerException;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b implements kfc.a {
    public b() {
    }

    @Override // kfc.a
    public final List<String> b() {
        return Arrays.asList(new String[]{"com.anddoes.launcher"});
    }

    @Override // kfc.a
    public final void a(Context r4, ComponentName r5, int r6) throws RedBadgerException {
        if (r4 == null) goto L16;
        if (r5 == null) goto L19;
        if (r6 >= 0) goto L7;
        r6 = 0;
    L7:
        Intent r0 = new Intent("com.anddoes.launcher.COUNTER_CHANGED");
        r0.putExtra("package", r5.getPackageName());
        r0.putExtra(EffectConfiguration.KEY_COUNT, r6);
        r0.putExtra("badgecount", r6);
        r0.putExtra("class", r5.getClassName());
        r4.sendBroadcast(r0);
        if (nfc.a.a(r4, r0) == false) goto L15;
        r4.sendBroadcast(r0);     // Catch: Throwable -> L11
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

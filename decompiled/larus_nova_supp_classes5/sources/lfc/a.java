package lfc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.ss.android.newmedia.redbadge.RedBadgerException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a implements kfc.a {
    public a() {
    }

    @Override // kfc.a
    public final List<String> b() {
        return Arrays.asList(new String[]{"org.adw.launcher", "org.adwfreak.launcher", "org.adw.launcher.one"});
    }

    @Override // kfc.a
    public final void a(Context r4, ComponentName r5, int r6) throws RedBadgerException {
        if (r4 == null) goto L16;
        if (r5 == null) goto L19;
        if (r6 >= 0) goto L7;
        r6 = 0;
    L7:
        Intent r0 = new Intent("org.adw.launcher.counter.SEND");
        r0.putExtra("PNAME", r5.getPackageName());
        r0.putExtra("CNAME", r5.getClassName());
        r0.putExtra("COUNT", r6);
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

package lfc;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.newmedia.redbadge.RedBadgerException;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class i implements kfc.a {
    public i() {
    }

    @Override // kfc.a
    public final List<String> b() {
        return Collections.singletonList("com.transsion.itel.launcher");
    }

    @Override // kfc.a
    public final void a(Context r4, ComponentName r5, int r6) throws RedBadgerException {
        Bundle r0 = new Bundle();
        r0.putString("package", r4.getPackageName());     // Catch: Exception -> L5
        r0.putString("class", r5.getClassName());     // Catch: Exception -> L5
        r0.putInt("badgenumber", r6);     // Catch: Exception -> L5
        r4.getContentResolver().call(UriProtector.parse("content://com.transsion.itel.launcher.unreadprovider"), "change_badge", null, r0);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        throw new RedBadgerException(e.getMessage(), e);
    }
}

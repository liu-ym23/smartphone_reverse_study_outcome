package oka;

import android.text.TextUtils;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.ZeusPluginStateListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a extends ZeusPluginStateListener {
    public a() {
    }

    public final void onPluginStateChange(String r1, int r2, Object... r3) {
        if (TextUtils.equals(r1, "com.obric.memorydata.plugin") == true) goto L6;
        return;
    L6:
        if (r2 == 9) goto L8;
        return;
    L8:
        List<Runnable> r4 = b.a;
        ArrayList r5 = (ArrayList) r4;
        if (r5.isEmpty() == true) goto L19;
        ArrayList r6 = new ArrayList(r4);
        r5.clear();
        Iterator r7 = r6.iterator();
    L13:
        if (r7.hasNext() == false) goto L19;
        ((Runnable) r7.next()).run();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.printStackTrace();
    L19:
        Zeus.unregisterPluginStateListener(this);
    }
}

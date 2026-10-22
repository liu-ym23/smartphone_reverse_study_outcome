package com.obric.aiagent.messenger.stub.permission;

import android.app.Application;
import androidx.core.content.ContextCompat;
import com.larus.common.apphost.AppHost;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(List r4) {
        Application r0 = AppHost.a.getApplication();
        List r5 = r4;
        if ((r5 instanceof Collection) == true) goto L5;
    L7:
        Iterator r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L23;
        if (ContextCompat.checkSelfPermission(r0, (String) r6.next()) != 0) goto L13;
        boolean r1 = true;
    L14:
        if (r1 == true) goto L9;
        return false;
    L13:
        r1 = false;
        goto L14
    L23:
        return true;
    L5:
        if (r5.isEmpty() == false) goto L7;
        return true;
    }
}

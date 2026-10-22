package com.obric.assistant.provider.hybrid;

import android.os.Bundle;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.ss.android.socialbase.downloader.constants.DBDefinition;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class e implements a {
    static {
    }

    public e() {
    }

    public Bundle call(String r4, Bundle r5) {
        if (r5 == null) goto L5;
        String r6 = r5.getString(DBDefinition.PACKAGE_NAME);
    L6:
        if (r6 != null) goto L8;
    L11:
        boolean r0 = true;
    L13:
        if (r0 == false) goto L16;
        FLogger.a.w("OpenLoginAbility", "no package name");
        return null;
    L16:
        FLogger.a.i("OpenLoginAbility", r6 + " call login");
        t0.e(new d());
        return null;
    L8:
        if (r6.length() == 0) goto L11;
        r0 = false;
        goto L13
    L5:
        r6 = null;
        goto L6
    }
}

package com.ss.android.lark.framework.assembly.logger;

import com.ss.android.lark.maintab.export.TabAppInfo;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements com.suite.component.logger.api.d {
    public final String a;

    public d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        this.a = r2;
    }

    public final void a(com.suite.component.logger.api.d.a r5, com.suite.component.logger.b r6, com.suite.component.logger.c r7) {
        Intrinsics.checkNotNullParameter(r5, "chain");
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "entity");
        String r0 = this.a;
        r7.getClass();
        Intrinsics.checkNotNullParameter("@userID", TabAppInfo.IMAGE_JSON_KEY);
        if (r7.p != null) goto L5;
        r7.p = new HashMap(4);
    L5:
        HashMap r2 = r7.p;
        if (r2 == null) goto L8;
        r2.put("@userID", r0);
    L8:
        r5.a(r6, r7);
    }
}

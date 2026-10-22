package com.larus.bmhome.view.actionbar.custom.router;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.larus.common.apphost.AppHost;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f implements b {
    public f() {
    }

    @Override // com.larus.bmhome.view.actionbar.custom.router.b
    public final boolean b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "schemaUrl");
        return StringsKt.contains$default(r5, "//flow/zproject/main", false, 2, null);
    }

    @Override // com.larus.bmhome.view.actionbar.custom.router.b
    public final boolean a(BaseContentWidget r2, String r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "schemaUrl");
        Intrinsics.checkNotNullParameter(r4, "commonArgs");
        Uri r5 = UriProtector.parse(r3);
        if (r2 == null) goto L6;
        Context r6 = r2.getContext();
        if (r6 == null) goto L6;
    L7:
        i r7 = SmartRouter.buildRoute(r6, r5.buildUpon().build().toString());
        r7.c.putExtras(r4);
        r7.d();
        return true;
    L6:
        r6 = AppHost.a.a().getCurrentActivity();
        goto L7
    }
}

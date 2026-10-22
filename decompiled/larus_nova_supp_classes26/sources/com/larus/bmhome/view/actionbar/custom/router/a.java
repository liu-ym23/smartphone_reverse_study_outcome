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
public final class a implements b {
    public a() {
    }

    @Override // com.larus.bmhome.view.actionbar.custom.router.b
    public final boolean b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "schemaUrl");
        return true;
    }

    @Override // com.larus.bmhome.view.actionbar.custom.router.b
    public final boolean a(BaseContentWidget r6, String r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "schemaUrl");
        Intrinsics.checkNotNullParameter(r8, "commonArgs");
        Uri r0 = UriProtector.parse(r7);
        if (r6 == null) goto L6;
        Context r9 = r6.getContext();
        if (r9 == null) goto L6;
    L7:
        Uri.Builder r1 = r0.buildUpon();
        String r2 = UriProtector.getQueryParameter(r0, "enter_method");
        if (r2 != null) goto L10;
    L13:
        boolean r3 = true;
    L14:
        if (r3 == false) goto L16;
        r1.appendQueryParameter("enter_method", "chat_action_bar");
    L16:
        i r10 = SmartRouter.buildRoute(r9, r1.appendQueryParameter("android_no_clear_top", "1").build().toString());
        r10.c.putExtras(r8);
        if (StringsKt.contains$default(r7, "//flow/create_digital_avatar", false, 2, null) == false) goto L19;
        r10.c.putExtra("click_create_replica_current_page", "create_feed");
        r10.d = 2130772399;
        r10.e = 2130772399;
    L19:
        r10.d();
        return true;
    L10:
        if (r2.length() == 0) goto L13;
        r3 = false;
    L6:
        r9 = AppHost.a.a().getCurrentActivity();
        goto L7
    }
}

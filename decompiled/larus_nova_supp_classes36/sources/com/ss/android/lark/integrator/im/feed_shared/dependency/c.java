package com.ss.android.lark.integrator.im.feed_shared.dependency;

import android.content.Context;
import com.ss.android.lark.im.base.browser.IImBrowserService;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements peb.b.c {
    public c() {
    }

    public final void a() {
    }

    public final void b(Context r2, String r3) {
        ((IImBrowserService) LarkContext.spiByDwarf(IImBrowserService.class)).openUrl(r2, r3);
    }
}

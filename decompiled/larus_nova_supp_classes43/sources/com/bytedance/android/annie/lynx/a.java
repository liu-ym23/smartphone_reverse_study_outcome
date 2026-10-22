package com.bytedance.android.annie.lynx;

import android.view.View;
import com.bytedance.android.annie.Annie;
import com.bytedance.ies.web.jsbridge2.u;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements j9.a {
    public final /* synthetic */ com.bytedance.android.annie.param.a a;

    @Override // j9.a
    public final List<com.bytedance.android.annie.card.base.b> a() {
        int r0 = j9.c.a;
        return ((l9.b) Annie.getService$default(l9.b.class, null, 2, null)).a();
    }

    public a(com.bytedance.android.annie.param.a r1) {
        this.a = r1;
    }

    @Override // j9.a
    public final List<u> b(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        ArrayList r0 = new ArrayList();
        com.bytedance.android.annie.param.a r1 = this.a;
        int r11 = j9.c.a;
        r0.addAll(j9.c.a(r1.getBizKey()));
        Intrinsics.checkNotNullParameter(r10, "lynxView");
        r0.addAll(((l9.b) Annie.getService$default(l9.b.class, null, 2, null)).b(r10));
        return r0;
    }
}

package com.bytedance.android.live.revlink.impl.multianchor.vm;

import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.multianchor.utils.AnchorLinkOptUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public static final /* synthetic */ int b = 0;
    public final com.bytedance.android.live.revlink.impl.global.c a;

    public static final class a {
    }

    static {
    }

    public final boolean a() {
        if (b51.b.c0.d().getEnable() == false) goto L12;
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a;
        if (r0 == null) goto L7;
        AnchorLinkOptUtils r1 = r0.vk();
    L8:
        if (r1 == null) goto L12;
        if (r1.d() != true) goto L12;
        return true;
    L7:
        r1 = null;
    L12:
        return false;
    }

    public final boolean b() {
        if (a() == true) goto L5;
    L7:
        return false;
    L5:
        if (b51.b.c0.d().K2() == false) goto L7;
        return true;
    }

    public f(LinkFakeGlobalService r1) {
        this.a = r1;
    }
}

package ib;

import android.content.Context;
import com.bytedance.android.anniex.web.AnnieXWebKit;
import com.bytedance.ies.bullet.base.BulletSdk;
import com.bytedance.ies.bullet.service.base.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static AnnieXWebKit a(Context r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "bid");
        boolean r0 = BulletSdk.a;
        BulletSdk.c(r10);
        if (h.V() == false) goto L11;
        s26.d r1 = s26.d.c;
        com.bytedance.ies.bullet.service.webkit.d r12 = s26.d.c.d(r11, b36.d.class);
        if ((r12 instanceof com.bytedance.ies.bullet.service.webkit.d) == false) goto L7;
        com.bytedance.ies.bullet.service.webkit.d r13 = r12;
    L8:
        if (r13 == null) goto L11;
        AnnieXWebKit r14 = new AnnieXWebKit(r11, r13);
        r14.d(r10);
        return r14;
    L7:
        r13 = null;
    L11:
        AnnieXWebKit r15 = new AnnieXWebKit(r11, new com.bytedance.ies.bullet.service.webkit.d(null, 3));
        r15.d(r10);
        return r15;
    }
}

package kb;

import android.net.Uri;
import com.bytedance.android.anniex.web.model.AnnieXWebModel;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.service.webkit.d;
import kotlin.jvm.internal.Intrinsics;
import t36.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public final com.bytedance.ies.bullet.service.webkit.a a;

    public c(AnnieXWebModel r10, d r11) {
        Intrinsics.checkNotNullParameter(r10, "webViewModel");
        Intrinsics.checkNotNullParameter(r11, "kitService");
        m16.b r0 = new m16.b();
        r11.getClass();
        Intrinsics.checkNotNullParameter(r10, "context");
        com.bytedance.ies.bullet.service.webkit.c r1 = r11.b;
        if (r1 == null) goto L6;
        com.bytedance.ies.bullet.service.webkit.a r12 = r1.a(r11, r10);
        if (r12 == null) goto L6;
    L7:
        this.a = r12;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.bytedance.ies.bullet.kit.web.impl.DefaultWebKitDelegate");
        com.bytedance.ies.bullet.kit.web.impl.c r13 = (com.bytedance.ies.bullet.kit.web.impl.c) r12;
        BulletContext r14 = r10.l;
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r13.c = r14;
        r13.x().c.h(r13.x());
        j r15 = r10.h;
        if (r15 == null) goto L14;
        t36.d r16 = r15.a;
        if (r16 == null) goto L14;
        Uri r17 = r16.getOriginUrl();
        if (r17 == null) goto L14;
        a r18 = new a(r17);
    L15:
        r0.d(a.class, r18);
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r13.d = r0;
        return;
    L14:
        r18 = null;
    L6:
        r12 = new com.bytedance.ies.bullet.kit.web.impl.c(r11);
        goto L7
    }
}

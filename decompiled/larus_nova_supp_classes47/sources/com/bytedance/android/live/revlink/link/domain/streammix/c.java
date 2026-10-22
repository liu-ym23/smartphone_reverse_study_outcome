package com.bytedance.android.live.revlink.link.domain.streammix;

import com.bytedance.android.livesdk.revenue.service.livecore.IRegion;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public static final boolean a(IRegion r6, IRegion r7) {
        if (r6 != null) goto L5;
        return false;
    L5:
        if (r7 != null) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(r6.getInteractId(), r7.getInteractId()) == true) goto L10;
        return false;
    L10:
        if (r6.getStatus() == r7.getStatus()) goto L12;
        return false;
    L12:
        if (r6.C1() != r7.C1()) goto L27;
        z41.g r1 = z41.g.o;
        r1.getClass();
        if (((Boolean) z41.g.d.getValue(r1, z41.g.a[2])).booleanValue() == true) goto L16;
    L23:
        return true;
    L16:
        if (r6.getX() == r7.getX()) goto L18;
        return false;
    L18:
        if (r6.getY() == r7.getY()) goto L20;
        return false;
    L20:
        if (r6.getWidth() == r7.getWidth()) goto L22;
        return false;
    L22:
        if (r6.getHeight() == r7.getHeight()) goto L23;
        return false;
    L27:
        return false;
    }

    public static final boolean b(m11.b r3, m11.b r4) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r4 != null) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(r3.c(), r4.c()) == true) goto L10;
        return false;
    L10:
        if (r3.d() == r4.d()) goto L12;
        return false;
    L12:
        if (r3.e() == r4.e()) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(r3.b(), r4.b()) == false) goto L20;
        return true;
    L20:
        return false;
    }
}

package com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource;

import c12.n;
import com.bytedance.android.live.core.resources.e;
import com.bytedance.android.live.core.resources.j;
import com.bytedance.android.live.core.resources.k;
import com.bytedance.android.live.core.resources.l;
import com.bytedance.android.live.core.resources.m;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftResourceFileCacheService;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class DefaultResourceSupport implements d {
    public final Lazy a;
    public final Lazy b;

    public static final class a {
    }

    static {
    }

    public DefaultResourceSupport() {
        this.a = LazyKt.lazy(DefaultResourceSupport$fileCacheService$2.INSTANCE);
        this.b = LazyKt.lazy(DefaultResourceSupport$assetServiceOptConfig$2.INSTANCE);
    }

    public static boolean h(e r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        String r1 = r3.getMD5();
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
        return false;
    L14:
        l r4 = r3.getResourceModel();
        if (r4 != null) goto L17;
        return false;
    L17:
        List r5 = m.a(r4);
        if (r5 != null) goto L20;
        return false;
    L20:
        if (r5.isEmpty() == true) goto L24;
        return true;
    L24:
        return false;
    L8:
        if (r1.length() == 0) goto L11;
        r2 = false;
        goto L12
    }

    public static boolean i(e r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        j r4 = r3.getH265ResourceModel();
        if (r4 != null) goto L8;
        return false;
    L8:
        String r1 = r4.getMd5();
        if (r1 != null) goto L11;
    L14:
        boolean r2 = true;
    L15:
        if (r2 == false) goto L17;
        return false;
    L17:
        l r5 = r4.getResourceModel();
        if (r5 != null) goto L20;
        return false;
    L20:
        List r6 = m.a(r5);
        if (r6 != null) goto L23;
        return false;
    L23:
        if (r6.isEmpty() == true) goto L27;
        return true;
    L27:
        return false;
    L11:
        if (r1.length() == 0) goto L14;
        r2 = false;
        goto L15
    }

    public final c12.e e(e r10, int r11) {
        if (h(r10) == true) goto L5;
        return null;
    L5:
        if (r10 == null) goto L7;
        l r0 = r10.getResourceModel();
    L8:
        if (r0 == null) goto L16;
        List r1 = m.a(r0);
        if (r1 == null) goto L16;
        Object[] r2 = r1.toArray(new String[0]);
        if (r2 == null) goto L15;
        String[] r3 = (String[]) r2;
    L17:
        if (r3 == null) goto L24;
        if (r10 == null) goto L24;
        if (r10.getMD5() == null) goto L24;
        long r4 = r10.getId();
        String r5 = r10.getMD5();
        Intrinsics.checkNotNull(r5);
        return new c12.e(r4, r3, r5, r11, (GiftResourceFileCacheService) this.a.getValue());
    L24:
        return null;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L16:
        r3 = null;
        goto L17
    L7:
        r0 = null;
        goto L8
    }

    public final n f(e r13, int r14) {
        if (r13 == null) goto L35;
        j r0 = r13.getH265ResourceModel();
        if (r0 == null) goto L35;
        String r1 = r0.getMd5();
        boolean r2 = true;
        if (r1 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == true) goto L23;
        l r4 = r0.getResourceModel();
        if (r4 == null) goto L23;
        List r5 = m.a(r4);
        if (r5 == null) goto L23;
        if (r5.isEmpty() == true) goto L23;
    L24:
        if (r2 == false) goto L35;
        l r6 = r0.getResourceModel();
        if (r6 == null) goto L35;
        List r7 = m.a(r6);
        if (r7 == null) goto L35;
        Object[] r8 = r7.toArray(new String[0]);
        if (r8 == null) goto L34;
        return new n(r13.getId(), (String[]) r8, r0.getMd5(), r0.getTtmd5(), r14, (GiftResourceFileCacheService) this.a.getValue());
    L34:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L23:
        r2 = false;
        goto L24
    L9:
        if (r1.length() == 0) goto L12;
        r3 = false;
    L35:
        return null;
    }

    public final c12.e g(e r11, int r13) {
        if (r11 == null) goto L35;
        k r0 = r11.getH265SuperResourceModel();
        if (r0 == null) goto L35;
        String r1 = r0.getMd5();
        boolean r2 = true;
        if (r1 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == true) goto L23;
        l r4 = r0.getResourceModel();
        if (r4 == null) goto L23;
        List r5 = m.a(r4);
        if (r5 == null) goto L23;
        if (r5.isEmpty() == true) goto L23;
    L24:
        if (r2 == false) goto L35;
        l r6 = r0.getResourceModel();
        if (r6 == null) goto L35;
        List r7 = m.a(r6);
        if (r7 == null) goto L35;
        Object[] r8 = r7.toArray(new String[0]);
        if (r8 == null) goto L34;
        return new c12.e(r11.getId(), (String[]) r8, r0.getMd5(), r13, (GiftResourceFileCacheService) this.a.getValue());
    L34:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L23:
        r2 = false;
        goto L24
    L9:
        if (r1.length() == 0) goto L12;
        r3 = false;
    L35:
        return null;
    }
}

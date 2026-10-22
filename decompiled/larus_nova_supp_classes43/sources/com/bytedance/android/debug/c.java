package com.bytedance.android.debug;

import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.exception.BaseGetResourceException;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements com.bytedance.kmp.livesdk.gift.platform.resourcemanager.c {
    public final /* synthetic */ DebugAssetsManager a;
    public final /* synthetic */ com.bytedance.android.live.core.resources.e b;
    public final /* synthetic */ com.bytedance.android.livesdk.gift.platform.business.effect.assets.f c;

    public static final class a implements yp2.a {
        public final /* synthetic */ c a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;

        public final void onSuccess() {
            com.bytedance.android.livesdk.gift.platform.business.effect.assets.f r0 = this.a.c;
            if (r0 == null) goto L6;
            r0.c(this.b, this.c);
            return;
        }

        public final void onFailure(Exception r10) {
            com.bytedance.android.livesdk.gift.platform.business.effect.assets.f r0 = this.a.c;
            if (r0 == null) goto L6;
            r0.onFailed(new Throwable(r10));
            return;
        }

        public a(c r1, long r10, String r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }
    }

    public final void a(long r10) {
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.f r0 = this.c;
        if (r0 == null) goto L6;
        r0.a(r10);
        return;
    }

    public final void b(BaseGetResourceException r10) {
        Intrinsics.checkNotNullParameter(r10, "t");
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.f r0 = this.c;
        if (r0 == null) goto L6;
        r0.onFailed(r10);
        return;
    }

    public final void onProgress(int r10) {
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.f r0 = this.c;
        if (r0 == null) goto L6;
        r0.onProgress(r10);
        return;
    }

    public final void c(long r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "path");
        DebugAssetsManager r0 = this.a;
        com.bytedance.android.live.core.resources.e r1 = this.b;
        r0.getClass();
        boolean r12 = true;
        if (r1 != null) goto L6;
    L8:
        if (r12 == false) goto L13;
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.f r13 = this.c;
        if (r13 == null) goto L30;
        r13.c(r10, r11);
        return;
    L30:
        return;
    L13:
        if (com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.effect.c.class).N2() == false) goto L26;
        com.bytedance.android.livesdk.revenue.service.effect.c r14 = com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.effect.c.class);
        com.bytedance.android.live.core.resources.e r15 = this.b;
        Map r16 = null;
        if (r15 == null) goto L19;
        com.bytedance.android.live.core.resources.h r17 = r15.getLokiExtraModel();
        if (r17 == null) goto L19;
        List r18 = r17.o8();
    L20:
        com.bytedance.android.live.core.resources.e r19 = this.b;
        if (r19 == null) goto L25;
        com.bytedance.android.live.core.resources.h r20 = r19.getLokiExtraModel();
        if (r20 == null) goto L25;
        r16 = com.bytedance.android.live.core.resources.i.a(r20);
    L25:
        r14.Bj(r18, r16, new a(this, r10, r11));
        return;
    L19:
        r18 = null;
        goto L20
    L26:
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.f r21 = this.c;
        if (r21 == null) goto L33;
        r21.onFailed(new Throwable("downloadable model support is not supported in this host."));
        return;
    L33:
        return;
    L6:
        if (r1.getLokiExtraModel() == null) goto L8;
        r12 = com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.effect.c.class).he(r1);
        goto L8
    }

    public c(DebugAssetsManager r1, com.bytedance.android.live.core.resources.e r10, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }
}

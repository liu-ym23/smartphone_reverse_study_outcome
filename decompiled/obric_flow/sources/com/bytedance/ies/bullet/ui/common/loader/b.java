package com.bytedance.ies.bullet.ui.common.loader;

import android.net.Uri;
import com.bytedance.ies.bullet.core.n;
import com.bytedance.ies.bullet.core.q;
import com.bytedance.ies.bullet.kit.web.m;
import com.bytedance.ies.bullet.secure.SccConfig;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ bd.a f6209c;

    public b(n r5, bd.a r10) {
        this.f6209c = r10;
        super(r5);
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void r(Uri r10, Throwable r11) {
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r11, "e");
        m r5 = (m) this.f6209c;
        SccConfig.SccLevel r12 = r5.f5571m;
        SccConfig.SccLevel r13 = SccConfig.SccLevel.f5894a;
        n r14 = this.f5349a;
        if (r12 != r13) goto L6;
        r5.destroy();
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r11, "e");
        r14.r(r10, r11);
        return;
    L6:
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r11, "e");
        r14.r(r10, r11);
    }
}

package com.bytedance.ies.bullet.ui.common.loader;

import android.net.Uri;
import android.os.Bundle;
import com.bytedance.ies.bullet.core.e;
import com.bytedance.ies.bullet.core.n;
import com.bytedance.ies.bullet.core.q;
import com.bytedance.ies.bullet.lynx.h;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.jvm.internal.Intrinsics;
import vc.d;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n f6208c;
    public final /* synthetic */ d d;
    public final /* synthetic */ c e;
    public final /* synthetic */ e f;
    public final /* synthetic */ Bundle g;

    public a(n r5, d r10, c r11, e r12, Bundle r13) {
        this.f6208c = r5;
        this.d = r10;
        this.e = r11;
        this.f = r12;
        this.g = r13;
        super(r5);
    }

    @Override // com.bytedance.ies.bullet.core.n
    public final void r(Uri r10, Throwable r11) {
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r11, "e");
        ((h) this.d).destroy();
        KitType r5 = KitType.d;
        n r12 = this.f6208c;
        this.e.f(this.f, this.g, r10, r5, r11, r12);
    }
}

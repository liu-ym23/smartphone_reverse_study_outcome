package com.bytedance.ies.bullet.core;

import android.net.Uri;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m implements n {
    @Override // com.bytedance.ies.bullet.core.n
    public void b() {
    }

    @Override // com.bytedance.ies.bullet.core.n
    public void f() {
    }

    @Override // com.bytedance.ies.bullet.core.n
    public vc.c getLynxClient() {
        return null;
    }

    @Override // com.bytedance.ies.bullet.core.n
    public void n() {
    }

    @Override // com.bytedance.ies.bullet.core.n
    public void o(Uri r5, com.bytedance.ies.bullet.service.base.h r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
    }

    @Override // com.bytedance.ies.bullet.core.n
    public void p(Uri r5, com.bytedance.ies.bullet.service.base.h r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
    }

    @Override // com.bytedance.ies.bullet.core.n
    public void q(Uri r5, Throwable r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r10, "e");
    }

    @Override // com.bytedance.ies.bullet.core.n
    public void r(Uri r5, Throwable r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r10, "e");
    }

    @Override // com.bytedance.ies.bullet.core.n
    public void s(Uri r5, hb.a r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
    }

    @Override // com.bytedance.ies.bullet.core.n
    public void u(Uri r5, com.bytedance.ies.bullet.core.container.e r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
    }

    @Override // com.bytedance.ies.bullet.core.n
    public void v(Uri r5, com.bytedance.ies.bullet.service.base.h r10, rd.e r11) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r11, "schemaModelUnion");
    }

    @Override // com.bytedance.ies.bullet.core.n
    public void w(Uri r5, com.bytedance.ies.bullet.service.base.h r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
    }
}

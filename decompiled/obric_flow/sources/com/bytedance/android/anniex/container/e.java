package com.bytedance.android.anniex.container;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends com.bytedance.ies.bullet.core.container.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnnieXContainer f3139a;

    public e(AnnieXContainer r5) {
        this.f3139a = r5;
        AnnieXContainer.access$getContextProviderFactory$p(r5);
    }

    @Override // com.bytedance.ies.bullet.core.container.e
    public final void c(com.bytedance.ies.bullet.lynx.impl.b r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        this.f3139a.sendEvent(r5);
    }

    @Override // com.bytedance.ies.bullet.core.container.e
    public final com.bytedance.ies.bullet.core.e getBulletContext() {
        return this.f3139a.getBulletContext();
    }

    @Override // com.bytedance.ies.bullet.core.container.e
    public final String getSessionId() {
        return this.f3139a.getContainerId();
    }
}

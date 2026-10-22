package com.ss.ugc.effectplatform.download;

import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class c implements e {
    public final /* synthetic */ Ref.ObjectRef a;

    @Override // com.ss.ugc.effectplatform.bridge.network.a
    public final void onProgress(int r1, long r2) {
    }

    @Override // com.ss.ugc.effectplatform.download.e
    public final void onStart() {
    }

    public c(Ref.ObjectRef r1) {
        this.a = r1;
    }

    @Override // com.ss.ugc.effectplatform.download.e
    public final void a(g r2) {
        if (r2.a() == true) goto L6;
        Ref.ObjectRef r0 = this.a;
        r0.element = r2.f;
        return;
    }
}

package com.larus.community.impl.detail.image;

import androidx.fragment.app.Fragment;
import com.larus.community.api.spi.ICommunityHostBehaviorProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c implements CreationFullscreenImageViewer.a {
    public final /* synthetic */ CreationDetailFullImageComponent a;

    public c(CreationDetailFullImageComponent r1) {
        this.a = r1;
    }

    @Override // com.larus.community.impl.detail.image.CreationFullscreenImageViewer.a
    public final void a(boolean r3) {
        int r0 = e29.d.a;
        Fragment r1 = s1a.a.c(this.a);
        Intrinsics.checkNotNullParameter(r1, "fragment");
        ICommunityHostBehaviorProvider r2 = e29.d.c();
        if (r2 == null) goto L6;
        r2.b(r1, r3);
        return;
    }
}

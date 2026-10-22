package com.ss.android.lark.integrator.im.impl.preview;

import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements ucb.a {
    public final /* synthetic */ OfficeUrlPreviewSessionImpl a;

    public e(OfficeUrlPreviewSessionImpl r1) {
        this.a = r1;
    }

    public final void a(Map<String, UrlCardPreviewEntity> r3) {
        Intrinsics.checkNotNullParameter(r3, "previewEntities");
        if (this.a.h.get() == false) goto L5;
        return;
    L5:
        this.a.f(r3, null);
    }
}

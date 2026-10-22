package com.suite.lark.platform.component.cta.newstyle;

import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements joc.b {
    public final /* synthetic */ CTADialogFragment a;

    public d(CTADialogFragment r1) {
        this.a = r1;
    }

    @Override // joc.b
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "url");
        if (this.a.getContext() == null) goto L6;
        ((eoc.a) ClaymoreServiceLoader.loadFirst(eoc.a.class)).a();
        return;
    }
}

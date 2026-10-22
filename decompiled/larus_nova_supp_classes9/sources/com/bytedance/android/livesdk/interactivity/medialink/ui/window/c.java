package com.bytedance.android.livesdk.interactivity.medialink.ui.window;

import io.reactivex.functions.Consumer;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ MediaMultiLinkAnchorWindowManager a;

    public c(MediaMultiLinkAnchorWindowManager r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        MediaMultiLinkAnchorWindowManager r0 = this.a;
        r0.onEvent((h1) r2);
    }
}

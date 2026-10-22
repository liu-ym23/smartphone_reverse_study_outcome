package com.bytedance.android.livesdk.interactivity.medialink.ui.window;

import io.reactivex.functions.Consumer;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ MediaMultiLinkAudienceWindowManager a;

    public j(MediaMultiLinkAudienceWindowManager r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        MediaMultiLinkAudienceWindowManager r0 = this.a;
        r0.onEvent((h1) r2);
    }
}

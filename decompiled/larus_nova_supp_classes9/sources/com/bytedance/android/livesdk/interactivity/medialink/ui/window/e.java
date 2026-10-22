package com.bytedance.android.livesdk.interactivity.medialink.ui.window;

import com.bytedance.android.livesdk.interactivity.medialink.ui.MediaMultiAnchorWindowV2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ MediaMultiAnchorWindowV2 a;

    public e(MediaMultiAnchorWindowV2 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        this.a.setCoverVisible(4);
    }
}

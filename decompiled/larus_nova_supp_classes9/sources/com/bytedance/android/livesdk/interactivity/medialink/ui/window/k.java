package com.bytedance.android.livesdk.interactivity.medialink.ui.window;

import com.bytedance.android.livesdk.interactivity.medialink.ui.MediaMultiAnchorWindowV2;
import com.bytedance.android.livesdk.interactivity.medialink.ui.q;
import io.reactivex.functions.Consumer;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ MediaMultiLinkAudienceWindowManager a;

    public k(MediaMultiLinkAudienceWindowManager r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Integer r5 = (Integer) r4;
        Iterator<MediaMultiAnchorWindowV2> r6 = this.a.d.iterator();
    L4:
        if (r6.hasNext() == false) goto L9;
        MediaMultiAnchorWindowV2 r0 = r6.next();
        e92.a.a();
        q r1 = r0.B;
        boolean r2 = e92.a.a();
        if (r1.c == r2) goto L4;
        r1.c = r2;
        r1.b();
        goto L4
    }
}

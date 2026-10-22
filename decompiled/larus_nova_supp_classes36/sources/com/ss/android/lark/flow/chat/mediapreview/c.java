package com.ss.android.lark.flow.chat.mediapreview;

import android.content.Context;
import android.util.AttributeSet;
import com.ss.android.lark.biz.officesdk.im.mediapreview.GallerySource;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kza.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@OfficeSDKUserScope
public final class c implements h {
    @Inject
    public c() {
    }

    public final FlowLargeImageView a(Context r5, GallerySource r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "source");
        AttributeSet r3 = null;
        FlowLargeImageView r0 = new FlowLargeImageView(r5, r3, 6, 0);
        r0.setMSource(r6);
        return r0;
    }
}

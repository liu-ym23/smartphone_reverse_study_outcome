package com.bytedance.android.live.revlink.impl.multianchor.feed;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b extends FrameLayout {
    public final String a;
    public final IRoom b;

    public final String getInteractId() {
        return this.a;
    }

    public final IRoom getRoom() {
        return this.b;
    }

    public b(Context r2, String r3, IRoom r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = r3;
        this.b = r4;
    }
}

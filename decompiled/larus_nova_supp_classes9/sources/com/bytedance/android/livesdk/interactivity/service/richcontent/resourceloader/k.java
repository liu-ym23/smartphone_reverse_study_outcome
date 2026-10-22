package com.bytedance.android.livesdk.interactivity.service.richcontent.resourceloader;

import android.graphics.drawable.NinePatchDrawable;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k implements a3.b {
    public final /* synthetic */ hk6.b.a a;

    public final void onFail() {
        hk6.b.a.a.a(this.a, "ResizableImageLoader load failed", null, 2);
    }

    public k(hk6.d r1) {
        this.a = r1;
    }

    public final void a(NinePatchDrawable r2) {
        Intrinsics.checkNotNullParameter(r2, "ninePatchDrawable");
        this.a.b(r2);
    }
}

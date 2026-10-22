package com.bytedance.android.livesdk.interactivity.service.richcontent.resourceloader;

import android.graphics.drawable.Drawable;
import com.bytedance.android.live.core.utils.s1;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ ob2.c a;
    public final /* synthetic */ hk6.b.a b;

    public d(ob2.c r1, hk6.d r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        Drawable r0 = s1.m(this.a.b.intValue());
        if (r0 == null) goto L5;
        com.bytedance.android.livesdk.interactivity.service.richcontent.config.a.a.error("download failed,use defaultBitmap:" + this.a.b, null);
        this.b.b(r0);
        return;
    L5:
        com.bytedance.android.livesdk.interactivity.service.richcontent.config.a.a.error("download failed,get defaultBitmap error", r5);
        this.b.a(r5.getMessage(), r5);
    }
}

package com.bytedance.android.livesdk.interactivity.service.richcontent.resourceloader;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bytedance.android.live.core.utils.s1;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ LiveImageResourceLoader a;
    public final /* synthetic */ ek6.a b;
    public final /* synthetic */ ob2.c c;
    public final /* synthetic */ ek6.d d;
    public final /* synthetic */ hk6.b.a e;

    public c(LiveImageResourceLoader r1, ak6.f r2, ob2.c r3, ek6.d r4, hk6.d r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void accept(Object r5) {
        Bitmap r6 = ((Bitmap) r5).copy(Bitmap.Config.ARGB_8888, false);
        if (r6 != null) goto L5;
        Drawable r7 = s1.m(this.c.b.intValue());
        if (r7 == null) goto L11;
        com.bytedance.android.livesdk.interactivity.service.richcontent.config.a.a.error("download success,use defaultBitmap:" + this.c.b, null);
        this.e.b(r7);
        return;
    L11:
        com.bytedance.android.livesdk.interactivity.service.richcontent.config.a.a.error("download success,defaultBitmap error:" + this.c.b, null);
        hk6.b.a.a.a(this.e, "bitmap is null", null, 2);
        return;
    L5:
        if (com.bytedance.android.livesdk.interactivity.service.richcontent.config.c.a(this.b) == false) goto L7;
        this.a.c(r6, this.c, this.d);
    L7:
        this.e.b(new BitmapDrawable(s1.getResources(), r6));
    }
}

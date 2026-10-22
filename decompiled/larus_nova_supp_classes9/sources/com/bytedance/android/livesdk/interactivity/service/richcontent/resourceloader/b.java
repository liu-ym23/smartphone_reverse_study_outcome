package com.bytedance.android.livesdk.interactivity.service.richcontent.resourceloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.interactivity.service.textrender.inject.IGiftImageGetter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements hk6.c<ob2.b> {
    public b() {
    }

    public final Drawable b(ek6.b r2, ak6.f r3, ek6.d r4) {
        ob2.b r5 = (ob2.b) r2;
        Intrinsics.checkNotNullParameter(r5, "resourceInfo");
        Intrinsics.checkNotNullParameter(r3, "loadConfig");
        Intrinsics.checkNotNullParameter(r4, "content");
        long r6 = r5.a;
        IGiftImageGetter r7 = (IGiftImageGetter) jc1.k.f(IGiftImageGetter.class);
        if (r7 == null) goto L14;
        py.k r8 = r7.getGiftImage(r6);
        if (r8 == null) goto L14;
        String r9 = jc1.k.n(IHostFrescoHelper.class).getImageFilePath(r8);
        if (r9 == null) goto L14;
        Bitmap r10 = BitmapFactory.decodeFile(r9);
        if (r10 == null) goto L14;
        return new BitmapDrawable(s1.getResources(), r10);
    L14:
        return null;
    }
}

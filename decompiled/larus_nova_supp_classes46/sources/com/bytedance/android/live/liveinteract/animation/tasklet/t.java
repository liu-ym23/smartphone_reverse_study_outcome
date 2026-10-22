package com.bytedance.android.live.liveinteract.animation.tasklet;

import android.net.Uri;
import android.text.TextUtils;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Predicate;
import com.facebook.imagepipeline.request.ImageRequest;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class t<T> implements Predicate {
    public final /* synthetic */ ImageRequest a;

    public t(ImageRequest r1) {
        this.a = r1;
    }

    public final boolean apply(Object r8) {
        CacheKey r9 = (CacheKey) r8;
        ImageRequest r0 = this.a;
        if (r0 == null) goto L9;
        Uri r1 = r0.getSourceUri();
        if (r1 == null) goto L9;
        String r2 = r1.toString();
        if (r2 == null) goto L9;
        String r3 = String.valueOf(r2.hashCode());
    L10:
        String r4 = r3;
        if (r4 != null) goto L13;
    L18:
        return false;
    L13:
        if (TextUtils.isEmpty(r4) == true) goto L18;
        if (StringsKt.indexOf$default(r9.toString(), r4, 0, false, 6, null) == (-1)) goto L18;
        return true;
    L9:
        r3 = null;
        goto L10
    }
}

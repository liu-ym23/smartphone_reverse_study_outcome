package com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap;

import com.bytedance.android.live.liveinteract.videotalk.avatarmix.e;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Predicate;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> implements Predicate {
    public final /* synthetic */ String a;

    public b(String r1) {
        this.a = r1;
    }

    public final boolean apply(Object r7) {
        String r8 = ((CacheKey) r7).getUriString();
        String r3 = null;
        if (r8 == null) goto L7;
        String r9 = StringsKt.substringAfter$default(r8, "://", null, 2, null);
        if (r9 == null) goto L7;
        String r10 = StringsKt.substringAfter$default(r9, "/", null, 2, null);
    L8:
        String r4 = this.a;
        if (r4.length() != 0) goto L11;
        boolean r5 = true;
    L12:
        if (r5 == false) goto L14;
        r4 = e.a;
    L14:
        if (r4 == null) goto L19;
        String r1 = StringsKt.substringAfter$default(r4, "://", null, 2, null);
        if (r1 == null) goto L19;
        r3 = StringsKt.substringAfter$default(r1, "/", null, 2, null);
    L19:
        return Intrinsics.areEqual(r10, r3);
    L11:
        r5 = false;
    L7:
        r10 = null;
        goto L8
    }
}

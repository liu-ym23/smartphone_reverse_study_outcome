package com.bytedance.android.livesdk.interactivity.service.richcontent.resourceloader;

import android.graphics.drawable.Drawable;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l implements hk6.a<ob2.g>, hk6.c<ob2.g> {
    public l() {
    }

    public final Drawable b(ek6.b r2, ak6.f r3, ek6.d r4) {
        Intrinsics.checkNotNullParameter((ob2.g) r2, "resourceInfo");
        Intrinsics.checkNotNullParameter(r3, "loadConfig");
        Intrinsics.checkNotNullParameter(r4, "content");
        py.k r5 = vh7.f.c(py.k.class);
        r5.setUrls(null);
        return a1.e(r5, false);
    }

    public final void a(ek6.b r2, ak6.f r3, ek6.d r4, hk6.d r5) {
        Intrinsics.checkNotNullParameter((ob2.g) r2, "resourceInfo");
        Intrinsics.checkNotNullParameter(r3, "loadConfig");
        Intrinsics.checkNotNullParameter(r4, "content");
        Intrinsics.checkNotNullParameter(r5, "callback");
        py.k r6 = vh7.f.c(py.k.class);
        r6.setUrls(null);
        Drawable r7 = a1.e(r6, false);
        if (r7 == null) goto L5;
        r5.b(r7);
        return;
    L5:
        hk6.b.a.a.a(r5, "drawable is null", null, 2);
    }
}

package com.bytedance.android.livesdk.interactivity.service.richcontent.resourceloader;

import android.graphics.drawable.Drawable;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements hk6.a<ob2.a>, hk6.c<ob2.a> {
    public a() {
    }

    public final Drawable b(ek6.b r2, ak6.f r3, ek6.d r4) {
        ob2.a r5 = (ob2.a) r2;
        Intrinsics.checkNotNullParameter(r5, "resourceInfo");
        Intrinsics.checkNotNullParameter(r3, "loadConfig");
        Intrinsics.checkNotNullParameter(r4, "content");
        py.k r6 = vh7.f.c(py.k.class);
        r6.setUrls(r5.a);
        return a1.e(r6, false);
    }

    public final void a(ek6.b r2, ak6.f r3, ek6.d r4, hk6.d r5) {
        ob2.a r6 = (ob2.a) r2;
        Intrinsics.checkNotNullParameter(r6, "resourceInfo");
        Intrinsics.checkNotNullParameter(r3, "loadConfig");
        Intrinsics.checkNotNullParameter(r4, "content");
        Intrinsics.checkNotNullParameter(r5, "callback");
        py.k r7 = vh7.f.c(py.k.class);
        r7.setUrls(r6.a);
        Drawable r8 = a1.e(r7, false);
        if (r8 == null) goto L5;
        r5.b(r8);
        return;
    L5:
        hk6.b.a.a.a(r5, "drawable is null", null, 2);
    }
}

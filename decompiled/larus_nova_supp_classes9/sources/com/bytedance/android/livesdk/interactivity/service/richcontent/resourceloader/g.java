package com.bytedance.android.livesdk.interactivity.service.richcontent.resourceloader;

import android.graphics.drawable.Drawable;
import com.bytedance.android.live.core.utils.s1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements hk6.c<ob2.d> {
    public g() {
    }

    public final Drawable b(ek6.b r2, ak6.f r3, ek6.d r4) {
        ob2.d r5 = (ob2.d) r2;
        Intrinsics.checkNotNullParameter(r5, "resourceInfo");
        Intrinsics.checkNotNullParameter(r3, "loadConfig");
        Intrinsics.checkNotNullParameter(r4, "content");
        return s1.m(r5.a);
    }
}

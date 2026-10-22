package com.larus.photopicker.v2.impl;

import androidx.fragment.app.Fragment;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Fragment a(Fragment r1, Class r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "clazz");
    L3:
        if (r1 == null) goto L8;
        if (r2.isInstance(r1) == true) goto L6;
        r1 = r1.getParentFragment();
        goto L3
    L6:
        return r1;
    L8:
        return null;
    }

    public static void b(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "msg");
        FLogger.a.d("MediaGalleryV2_" + r3, r4);
    }

    public static void c(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "msg");
        FLogger.a.e("MediaGalleryV2_" + r3, r4);
    }

    public static void d(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "msg");
        FLogger.a.i("MediaGalleryV2_" + r3, r4);
    }
}

package com.bytedance.android.annie.param;

import android.net.Uri;
import android.os.Bundle;
import com.bytedance.android.annie.scheme.convert.HybridTypeNew;
import com.bytedance.android.annie.scheme.vo.refactor.CardParamVoNew;
import com.bytedance.android.annie.scheme.vo.refactor.PageType;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[HybridTypeNew.values().length];
            r0[HybridTypeNew.H5.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    static {
    }

    public static HybridTypeNew b(Uri r1) {
        String r0 = UriProtector.getQueryParameter(r1, "hybrid_type");
        if (r0 == null) goto L9;
        if (Intrinsics.areEqual("lynx", r0) == false) goto L14;
        return HybridTypeNew.Lynx;
    L14:
        return HybridTypeNew.H5;
    L9:
        if (Intrinsics.areEqual("webcast_lynxview", r1.getHost()) == false) goto L12;
        return HybridTypeNew.Lynx;
    L12:
        return HybridTypeNew.H5;
    }

    @JvmStatic
    public static final CardParamVoNew a(Uri r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        HybridTypeNew r12 = b(r10);
        u8.a r0 = new u8.a(UriProtector.getQueryParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL), r10, r11, r12, null);
        CardParamVoNew r13 = new CardParamVoNew(0);
        r13.F(r0);
        com.bytedance.android.annie.scheme.helper.a.d(r13, "is_fullScreen", Boolean.TRUE);
        com.bytedance.android.annie.scheme.helper.a.d(r13, com.bytedance.android.ec.core.event.a.KEY_PAGE_TYPE, PageType.CARD);
        return r13;
    }
}

package com.ss.android.lark.officesdk.utils.di;

import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        @JvmStatic
        public static boolean a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "key");
            DependencyContainer r0 = DependencyContainer.a;
            ntb.h r1 = (ntb.h) DependencyContainer.a(ntb.h.class, null);
            if (r1 != null) goto L7;
            return false;
        L7:
            return r1.isEnable(r2);
        }
    }

    static {
    }
}

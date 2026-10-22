package com.ss.android.lark.officesdk.utils.di;

import android.content.Context;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        @JvmStatic
        public static boolean a(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            DependencyContainer r0 = DependencyContainer.a;
            ntb.f r1 = (ntb.f) DependencyContainer.a(ntb.f.class, null);
            if (r1 != null) goto L7;
            return false;
        L7:
            return r1.J(r2);
        }

        @JvmStatic
        public static boolean b(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            DependencyContainer r0 = DependencyContainer.a;
            ntb.f r1 = (ntb.f) DependencyContainer.a(ntb.f.class, null);
            if (r1 != null) goto L7;
            return false;
        L7:
            return r1.V(r2);
        }
    }

    static {
    }
}

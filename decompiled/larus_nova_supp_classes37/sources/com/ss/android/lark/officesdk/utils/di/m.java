package com.ss.android.lark.officesdk.utils.di;

import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class m {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        @JvmStatic
        public static ntb.r a() {
            DependencyContainer r0 = DependencyContainer.a;
            ntb.r r1 = (ntb.r) DependencyContainer.a(ntb.r.class, null);
            if (r1 == null) goto L6;
            return r1;
        L6:
            throw new IllegalStateException("PassportDependency is not injected");
        }
    }

    static {
    }
}

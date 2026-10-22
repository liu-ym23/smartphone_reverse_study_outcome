package com.ss.android.lark.officesdk.utils.di;

import android.app.Application;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        @JvmStatic
        public static Application a() {
            DependencyContainer r0 = DependencyContainer.a;
            ntb.e r1 = (ntb.e) DependencyContainer.a(ntb.e.class, null);
            if (r1 == null) goto L7;
            return r1.getApplication();
        L7:
            throw new IllegalStateException("IContextDependency not injected");
        }
    }

    static {
    }

    @JvmStatic
    public static final Application a() {
        return a.a();
    }
}

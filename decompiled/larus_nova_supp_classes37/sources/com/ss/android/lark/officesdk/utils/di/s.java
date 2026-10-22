package com.ss.android.lark.officesdk.utils.di;

import android.content.Context;
import android.widget.Toast;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import ntb.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class s {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        @JvmStatic
        public static void a(Context r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "message");
            DependencyContainer r0 = DependencyContainer.a;
            x r1 = (x) DependencyContainer.a(x.class, null);
            if (r1 == null) goto L5;
            r1.show(r2, r3);
            return;
        L5:
            Toast.makeText(r2, r3, 0).show();
        }
    }

    static {
    }
}

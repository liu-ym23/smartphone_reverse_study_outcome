package com.bytedance.android.annie.monitor.common.performance;

import com.bytedance.android.annie.ng.g;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {

    public static final class a implements Callable {
        public final /* synthetic */ Function0 a;

        public a(Function0 r10) {
            Intrinsics.checkNotNullParameter(r10, "function");
            this.a = r10;
        }

        @Override // java.util.concurrent.Callable
        public final /* synthetic */ Object call() {
            return this.a.invoke();
        }
    }

    public static final String a(String r1) {
        if (g.g == true) goto L5;
        return r1;
    L5:
        if (g.b().a.a == false) goto L11;
        String r10 = UriProtector.parse(r1).getPath();
        if (r10 != null) goto L12;
        return "";
    L12:
        return r10;
    L11:
        return r1;
    }
}

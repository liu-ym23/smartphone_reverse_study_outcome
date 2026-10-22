package com.ss.android.lark.officesdk.minutes.ui.style.contract;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface a {
    public static final C0072a a = null;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.style.contract.a$a, reason: collision with other inner class name */
    public static final class C0072a {
        public static final /* synthetic */ C0072a a = null;
        public static final C0073a b = null;

        /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.style.contract.a$a$a, reason: collision with other inner class name */
        public static final class C0073a implements a {
            public C0073a() {
            }

            @Override // com.ss.android.lark.officesdk.minutes.ui.style.contract.a
            public final void create(Context r2) {
                Intrinsics.checkNotNullParameter(r2, "context");
            }
        }

        public C0072a() {
        }

        static {
            a = new C0072a();
            b = new C0073a();
        }
    }

    static {
        a = C0072a.a;
    }

    void create(Context r1);
}

package com.ss.android.lark.officesdk.minutes.ui.style.contract;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface c {

    public static final class a implements c {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // com.ss.android.lark.officesdk.minutes.ui.style.contract.c
        public final boolean a() {
            return false;
        }

        @Override // com.ss.android.lark.officesdk.minutes.ui.style.contract.c
        public final void b(i r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
        }

        @Override // com.ss.android.lark.officesdk.minutes.ui.style.contract.c
        public final void c() {
        }

        @Override // com.ss.android.lark.officesdk.minutes.ui.style.contract.c
        public final void d() {
        }

        @Override // com.ss.android.lark.officesdk.minutes.ui.style.contract.c
        public final boolean e() {
            return false;
        }

        @Override // com.ss.android.lark.officesdk.minutes.ui.style.contract.c
        public final boolean f(i r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return false;
        }
    }

    boolean a();

    void b(i r1);

    void c();

    void d();

    boolean e();

    boolean f(i r1);
}

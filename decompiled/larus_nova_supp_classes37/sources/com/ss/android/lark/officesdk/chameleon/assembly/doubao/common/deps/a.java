package com.ss.android.lark.officesdk.chameleon.assembly.doubao.common.deps;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.permission.StoragePermissionUtils;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements ntb.b {

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.chameleon.assembly.doubao.common.deps.a$a, reason: collision with other inner class name */
    public static final class C0005a implements com.ss.android.lark.utils.h.e {
        public final /* synthetic */ Function1 a;

        public C0005a(Function1 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final /* synthetic */ void a(boolean r2) {
            this.a.invoke(Boolean.valueOf(r2));
        }
    }

    public a() {
    }

    @Override // ntb.b
    public final boolean P(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return StoragePermissionUtils.d(r2, 14);
    }

    @Override // ntb.b
    public final void n0(FragmentActivity r2, Function1 r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "callback");
        com.ss.android.lark.utils.h.b(r2, new C0005a(r3));
    }
}

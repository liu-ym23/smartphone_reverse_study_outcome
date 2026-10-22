package com.ss.android.lark.officesdk.minutes.ui.style.provider;

import android.content.Context;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.ui.entity.ToastType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class i implements qub.h {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ToastType.values().length];
            r0[ToastType.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[ToastType.ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[ToastType.WARNING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[ToastType.NORMAL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public i() {
    }

    @Override // qub.h
    public final void u(Context r3, rub.e r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "config");
        Integer r0 = r4.d;
        if (r0 != null) goto L18;
        ToastType r1 = r4.getType();
        int r2 = a.a[r1.ordinal()];
        if (r2 != 1) goto L7;
        r0 = 2131244770;
        goto L18
    L7:
        if (r2 != 2) goto L9;
        r0 = 2131244769;
        goto L18
    L9:
        if (r2 != 3) goto L11;
        r0 = 2131244771;
        goto L18
    L11:
        if (r2 != 4) goto L14;
        r0 = null;
        goto L18
    L14:
        throw new NoWhenBranchMatchedException();
    L18:
        if (r0 == null) goto L20;
        FlowToast.e(r3, r4.a, r0.intValue());
        return;
    L20:
        FlowToast.d(r3, r4.a);
    }
}

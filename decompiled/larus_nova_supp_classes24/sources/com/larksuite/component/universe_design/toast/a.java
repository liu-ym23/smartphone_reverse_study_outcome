package com.larksuite.component.universe_design.toast;

import com.ss.android.lark.compose.foundation.toast.FlowToast;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements FlowToast.c {
    public final /* synthetic */ UDToast.b a;

    public a(UDToast.b r1) {
        this.a = r1;
    }

    public final void a(com.ss.android.lark.compose.foundation.toast.b r2) {
        Intrinsics.checkNotNullParameter(r2, "toast");
        this.a.a(r2);
    }
}

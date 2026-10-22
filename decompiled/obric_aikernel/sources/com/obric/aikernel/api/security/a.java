package com.obric.aikernel.api.security;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public class a implements com.obric.aikernel.api.d {
    public a() {
    }

    public String a(Context r10, String r11, int r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "root");
        Intrinsics.checkNotNullParameter(r13, "hostType");
        return r11;
    }
}

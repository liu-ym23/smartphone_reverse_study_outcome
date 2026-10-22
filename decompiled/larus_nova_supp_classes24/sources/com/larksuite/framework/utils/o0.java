package com.larksuite.framework.utils;

import android.view.LayoutInflater;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class o0 {
    public static final LayoutInflater a(View r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return LayoutInflater.from(r1.getContext());
    }
}

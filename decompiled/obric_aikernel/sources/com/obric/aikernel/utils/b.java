package com.obric.aikernel.utils;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final String a(Bundle r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.getString("loraType");
    }
}

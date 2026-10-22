package com.obric.flow.di;

import android.app.Application;
import android.content.Context;
import com.lynx.tasm.utils.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static final uu.a a(final Application r5, final Context r10) {
        Intrinsics.checkNotNullParameter(r5, "application");
        Intrinsics.checkNotNullParameter(r10, "baseContext");
        return b.p(new AppServiceModuleKt$appServiceModule$1(r5, r10));
    }
}

package com.ss.android.lark.forsetiutils;

import android.content.Context;
import android.content.res.Resources;
import androidx.fragment.app.FragmentActivity;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.api.bean.ForsetiViewMode;
import com.ss.android.lark.forseti.widget.ForsetiNormalChainDraggingView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.Contexts;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public static final b a = null;
    public static final boolean b = false;

    public b() {
    }

    static {
        a = new b();
        b = ForsetiConfig.b();
    }

    public static ForsetiViewMode a(FragmentActivity r3) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        tua.b r4 = ((sua.a) ApiUtils.getApi(sua.a.class)).tryGetChainManager(r3);     // Catch: Throwable -> L7
        if (r4 == null) goto L14;
        return r4.H();
    L14:
        return null;
    L7:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Throwable r5 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
        if (r5 == null) goto L11;
        Log.e("getCurrentViewMode failed " + r5);
    L11:
        return null;
    }

    public static void c(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (b == true) goto L5;
        return;
    L5:
        sua.a r0 = (sua.a) ApiUtils.getApi(sua.a.class);
        FragmentActivity r3 = Contexts.findActivity(r2);
        if ((r3 instanceof FragmentActivity) == false) goto L8;
        FragmentActivity r4 = r3;
    L9:
        tua.b r5 = r0.tryGetChainManager(r4);
        if (r5 == null) goto L15;
        ForsetiNormalChainDraggingView r6 = r5.m();
        if (r6 == null) goto L16;
        r6.setVisibility(0);
        return;
    L16:
        return;
    L15:
        return;
    L8:
        r4 = null;
        goto L9
    }

    public static int b(int r1, Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Resources r3 = r2.getResources();
        return (int) ((r1 / WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density) + 0.5f);
    }
}

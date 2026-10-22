package com.bytedance.android.bst.api.ext;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.Log;
import android.view.View;
import com.byted.cast.sink.api.IServerListener;
import com.bytedance.android.btm.api.inner.ALogger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ExtKt {
    public static final String c(Throwable r10) {
        String r11 = Log.getStackTraceString(r10);
        int r0 = RangesKt.coerceAtMost(r11.length(), IServerListener.WHAT_BYTELINK_SINK_ERROR);
        if (r0 > 0) goto L7;
        return "";
    L7:
        return r11.substring(0, r0);
    }

    public static final Activity getActivity(View r10) {
        if (Intrinsics.areEqual(r10.getClass().getName(), "com.android.internal.policy.DecorView") == true) goto L5;
        Context r11 = r10.getContext();
    L8:
        if (r11 == null) goto L16;
        if ((r11 instanceof Activity) == true) goto L12;
        if ((r11 instanceof ContextWrapper) == false) goto L16;
        r11 = ((ContextWrapper) r11).getBaseContext();
        goto L8
    L12:
        return (Activity) r11;
    L16:
        return null;
    L5:
        return getActivity(r10.findViewById(R.id.content));
    }

    public static final void a(String r1, String r10) {
        b("SaasService", r1 + ' ' + r10);
    }

    public static final void b(String r10, final String r11) {
        ALogger r0 = ALogger.d;
        Function0<String> r1 = new ExtKt$bstLog$1(r11);
        r0.getClass();
        r0.o("BTMSDK_BST_".concat(r10), false, r1, null);
    }
}

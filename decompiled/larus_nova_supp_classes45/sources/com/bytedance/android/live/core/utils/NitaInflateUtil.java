package com.bytedance.android.live.core.utils;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class NitaInflateUtil {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(NitaInflateUtil$hostBusiness$2.INSTANCE);
    }

    @JvmStatic
    public static final View a(int r16, String r17, Activity r18, ViewGroup r19, boolean r21) {
        Intrinsics.checkNotNullParameter(r17, "nitaTag");
        Intrinsics.checkNotNullParameter(r18, "activity");
        long r13 = System.currentTimeMillis();
        ALogger.i("VSNitaInflate", r17 + " start to get view");
        Lazy r0 = a;
        if (((IMiddlewareHostBusiness) r0.getValue()) != null) goto L5;
    L13:
        ALogger.w("VSNitaInflate", r17 + "  hostBusiness is null or nitaTag is empty.");
        View r1 = LayoutInflater.from(r18).inflate(r16, r19, r21);
    L14:
        if (r1 != null) goto L16;
        r1 = LayoutInflater.from(r18).inflate(r16, r19, r21);
    L16:
        ALogger.i("VSNitaInflate", r17 + " get view duration: " + (System.currentTimeMillis() - r13) + "ms");
        return r1;
    L5:
        if (r17.length() <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L13;
        IMiddlewareHostBusiness r3 = (IMiddlewareHostBusiness) r0.getValue();
        if (r3 == null) goto L12;
        r1 = r3.tryGetPreLoadLiveLayouts(r16, r17, r18, r19, Boolean.valueOf(r21), Boolean.FALSE, null);
        goto L14
    L12:
        r1 = null;
        goto L14
    L7:
        r2 = false;
        goto L8
    }
}

package com.bytedance.android.live.room.util;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class AudienceInflateUtil {
    public static final Lazy a = null;
    public static final Lazy b = null;

    static {
        a = LazyKt.lazy(AudienceInflateUtil$nitaInflaterEnabled$2.INSTANCE);
        b = LazyKt.lazy(AudienceInflateUtil$hostBusiness$2.INSTANCE);
    }

    @JvmStatic
    public static final View a(AudienceViewInfo r7, Activity r8, ViewGroup r9) {
        Intrinsics.checkNotNullParameter("AudienceView", "logTag");
        Intrinsics.checkNotNullParameter(r7, "nitaViewInfo");
        Intrinsics.checkNotNullParameter(r8, "activity");
        return b("AudienceView", r7.getResId(), r7.getTag(), r8, r9, false, null);
    }

    @JvmStatic
    public static final View b(String r12, int r13, String r14, Activity r15, ViewGroup r16, boolean r17, LayoutInflater r18) {
        Intrinsics.checkNotNullParameter(r12, "logTag");
        Intrinsics.checkNotNullParameter(r14, "nitaTag");
        Intrinsics.checkNotNullParameter(r15, "activity");
        long r9 = System.currentTimeMillis();
        Lazy r3 = b;
        if (((IMiddlewareHostBusiness) r3.getValue()) != null) goto L5;
    L13:
        ALogger.w(r12, "hostBusiness is null or nitaInflaterEnabled is closed or activity is not LivePlayActivity");
        if (r18 == null) goto L19;
        View r4 = r18.inflate(r13, r16, r17);
        if (r4 == null) goto L19;
        View r1 = r4;
    L20:
        ALogger.i(r12, "NitaInflate: enabled: " + ((Boolean) a.getValue()).booleanValue() + ", duration: " + (System.currentTimeMillis() - r9) + "ms");
        return r1;
    L19:
        r1 = LayoutInflater.from(r15).inflate(r13, r16, r17);
        goto L20
    L5:
        if (((Boolean) a.getValue()).booleanValue() == false) goto L13;
        if (Intrinsics.areEqual(r15.getClass().getCanonicalName(), "com.ss.android.ugc.aweme.live.LivePlayActivity") == false) goto L9;
    L12:
        IMiddlewareHostBusiness r5 = (IMiddlewareHostBusiness) r3.getValue();
        Intrinsics.checkNotNull(r5);
        r1 = r5.tryGetPreLoadLiveLayouts(r13, r14, r15, r16, Boolean.valueOf(r17), Boolean.TRUE, r18);
        goto L20
    L9:
        if (Intrinsics.areEqual(r15.getClass().getCanonicalName(), "com.ss.android.ugc.aweme.live.LivePlayActivityV2") == true) goto L12;
        if (Intrinsics.areEqual(r15.getClass().getCanonicalName(), "com.ss.android.ugc.aweme.live.multitask.LivePlayShadowActivity") == false) goto L13;
        goto L12
    }
}

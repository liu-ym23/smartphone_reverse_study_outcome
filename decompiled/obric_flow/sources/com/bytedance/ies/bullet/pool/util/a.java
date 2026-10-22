package com.bytedance.ies.bullet.pool.util;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.bytedance.ies.bullet.core.c;
import com.bytedance.ies.bullet.core.e;
import com.bytedance.ies.bullet.service.base.CacheType;
import com.bytedance.ies.bullet.ui.common.BulletContainerView;
import java.util.LinkedHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import rb.b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public static final void a(ViewGroup r5, Function1 r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "resolve");
        ViewParent r11 = r5.getParent();
        if (r11 != null) goto L5;
        return;
    L5:
        if ((r11 instanceof ViewGroup) == true) goto L8;
        r11 = null;
    L8:
        if (r11 == null) goto L12;
        r10.invoke((ViewGroup) r11);
        return;
    }

    public static final void b(LinearLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        a(r5, new PoolUtilKt$removeParent$1(r5));
    }

    public static final void c(final BulletContainerView r10, final BulletContainerView r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r11, "originView");
        LinkedHashMap r5 = cd.a.f1171a;
        e r13 = r10.getBulletContext();
        c r14 = null;
        if (r13 == null) goto L5;
        String r15 = r13.getSessionId();
    L6:
        b r16 = cd.a.a(r15);
        Context r17 = r11.getContext();
        Intrinsics.checkNotNullParameter(Context.class, "clazz");
        r16.b(Context.class, new rb.a(r17, 0));
        Context r18 = r11.getContext();
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r18, "context");
        Context r19 = r10.getContext();
        if (r19 != null) goto L9;
    L14:
        MutableContextWrapper r20 = null;
    L15:
        if (r20 == null) goto L17;
        r20.setBaseContext(r18);
    L17:
        if (r12 == false) goto L24;
        CacheType r21 = CacheType.f5916a;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r21, "cacheType");
        e r22 = r10.getBulletContext();
        if (r22 == null) goto L21;
        r14 = r22.f5308w;
    L21:
        if (r14 == null) goto L24;
        r14.e = r21;
    L24:
        r11.release();
        Intrinsics.checkNotNullParameter(r10, "<this>");
        a(r10, new PoolUtilKt$removeParent$1(r10));
        a(r11, new PoolUtilKt$replaceView$1(r11, r10));
        return;
    L9:
        if ((r19 instanceof MutableContextWrapper) == true) goto L12;
        r19 = null;
    L12:
        if (r19 == null) goto L14;
        r20 = (MutableContextWrapper) r19;
        goto L15
    L5:
        r15 = null;
        goto L6
    }
}

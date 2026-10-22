package com.bytedance.android.anniex.container.util;

import android.content.Context;
import com.bytedance.android.anniex.container.AnnieXContainer;
import com.bytedance.ies.bullet.service.sdk.param.LaunchMode;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import xc.d;
import xc.e;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f3200a = null;

    static {
        f3200a = LazyKt.lazy(AnnieXContainerManager$containerMap$2.f3198a);
    }

    public static void a(String r10, LaunchMode r11, s3.b r12) {
        Intrinsics.checkNotNullParameter(r10, "bdxTag");
        Intrinsics.checkNotNullParameter(r11, "launchMode");
        if (a.f3199a[r11.ordinal()] != 1) goto L41;
        ArrayList r13 = new ArrayList();
        Lazy r5 = f3200a;
        Iterator r14 = ((LinkedHashMap) r5.getValue()).entrySet().iterator();
    L5:
        Context r15 = null;
        if (r14.hasNext() == false) goto L32;
        Map.Entry r16 = (Map.Entry) r14.next();
        s3.b r17 = (s3.b) ((WeakReference) r16.getValue()).get();
        if (r17 == null) goto L10;
        String r18 = r17.getBDXTag();
    L12:
        if (Intrinsics.areEqual(r18, r10) == false) goto L5;
        ConcurrentHashMap r19 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(e.class, "cls");
        e r20 = (e) yc.a.a(e.class, "default_bid");
        if (r20 == null) goto L20;
        d r21 = (d) r20.a(d.class);
        if (r21 == null) goto L20;
        Boolean r22 = r21.H0();
        if (r22 == null) goto L20;
        boolean r23 = r22.booleanValue();
    L21:
        if (r23 == true) goto L22;
        r13.add(r16.getKey());
        goto L5
    L22:
        s3.b r24 = (s3.b) ((WeakReference) r16.getValue()).get();
        if (r24 == null) goto L25;
        Context r25 = r24.getSystemContext();
    L26:
        if (r12 == null) goto L29;
        r15 = r12.getSystemContext();
    L29:
        if (Intrinsics.areEqual(r25, r15) == true) goto L5;
        r13.add(r16.getKey());
        goto L5
    L25:
        r25 = null;
    L20:
        r23 = true;
        goto L21
    L10:
        r18 = null;
        goto L12
    L32:
        Iterator r26 = r13.iterator();
    L34:
        if (r26.hasNext() == false) goto L57;
        String r27 = (String) r26.next();
        Intrinsics.checkNotNullParameter(r27, "containerId");
        WeakReference r28 = (WeakReference) ((LinkedHashMap) r5.getValue()).remove(r27);
        if (r28 == null) goto L38;
        s3.b r29 = (s3.b) r28.get();
    L39:
        if (r29 == null) goto L34;
        r29.close();
        r29.release();
        goto L34
    L38:
        r29 = null;
        goto L39
    L57:
        return;
    }

    public static final boolean b(AnnieXContainer r5) {
        Intrinsics.checkNotNullParameter(r5, "container");
        Set r10 = ((LinkedHashMap) f3200a.getValue()).entrySet();
        s3.b r11 = null;
        if (r10.isEmpty() == false) goto L6;
        r10 = null;
    L6:
        if (r10 == null) goto L13;
        Map.Entry r12 = (Map.Entry) CollectionsKt.last(r10);
        if (r12 == null) goto L13;
        WeakReference r13 = (WeakReference) r12.getValue();
        if (r13 == null) goto L13;
        r11 = (s3.b) r13.get();
    L13:
        return Intrinsics.areEqual(r11, r5);
    }
}

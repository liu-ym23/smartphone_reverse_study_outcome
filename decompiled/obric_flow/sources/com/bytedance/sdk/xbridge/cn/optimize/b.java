package com.bytedance.sdk.xbridge.cn.optimize;

import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f7355a = null;

    static {
        f7355a = LazyKt.lazy(OptimizeConfigKt$serialThreadPool$2.f7351a);
    }

    public static final IDLXBridgeMethod.XBridgeThreadType a(List r10, bj.a r11) {
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_CALL);
        if (r10 == null) goto L30;
        Iterator r12 = r10.iterator();
    L6:
        if (r12.hasNext() == false) goto L30;
        c r5 = (c) r12.next();
        HashSet r13 = r5.f7356a;
        boolean r14 = false;
        if (r13 == null) goto L19;
        Iterator r15 = r13.iterator();
    L10:
        boolean r16 = true;
    L12:
        if (r15.hasNext() == false) goto L20;
        String r17 = (String) r15.next();
        if (Intrinsics.areEqual(r17, "bdx_thread_opt_all_schema") == true) goto L10;
        if (StringsKt.g(r11.d(), r17) == true) goto L12;
        r16 = false;
    L20:
        if (r16 == false) goto L6;
        HashSet r18 = r5.f7357b;
        if (r18 != null) goto L25;
    L27:
        if (r14 == false) goto L30;
        return IDLXBridgeMethod.XBridgeThreadType.f7470b;
    L25:
        if (r18.contains(r11.f932a) != true) goto L27;
        r14 = true;
        goto L27
    L19:
        r16 = true;
    L30:
        return null;
    }
}

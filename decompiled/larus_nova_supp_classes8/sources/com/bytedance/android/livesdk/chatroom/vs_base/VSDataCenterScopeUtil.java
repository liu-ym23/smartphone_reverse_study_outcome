package com.bytedance.android.livesdk.chatroom.vs_base;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.scope.l;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import e33.k;
import java.util.concurrent.ConcurrentHashMap;
import ju2.a;
import ju2.g;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import pm1.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class VSDataCenterScopeUtil {
    public static final ConcurrentHashMap<Integer, a> a = null;

    static {
        a = new ConcurrentHashMap();
    }

    public static a a(DataCenter r6) {
        a r1 = null;
        if (r6.isCleared() == false) goto L5;
        return null;
    L5:
        LifecycleOwner r0 = r6.lifecycleOwner;
        if (r0 == null) goto L28;
        final int r2 = r0.hashCode();
        ConcurrentHashMap<Integer, a> r3 = a;
        if (r3.containsKey(Integer.valueOf(r2)) == true) goto L10;
        final Ref.ObjectRef r4 = new Ref.ObjectRef();
        g r5 = new g(h.d.b());
        Intrinsics.checkNotNullParameter(r5, "scope");
        Intrinsics.checkNotNullParameter(r6, "value");
        r5.e = r6;
        if (r6 != k.a) goto L14;
        String r7 = "dataCenter";
    L15:
        if (r7 != null) goto L27;
        r4.element = r5;
        a r8 = r3.putIfAbsent(Integer.valueOf(r2), (a) r4.element);
        if (r8 != null) goto L19;
        r8 = (a) r4.element;
    L19:
        r4.element = r8;
        if ((!l.b(r8)) == false) goto L22;
        r1 = r8;
    L22:
        if (r1 == null) goto L25;
        ALogger.d("VSDataCenterScopeUtil", "enter:" + r2);
        l.a(r1);
        r6.lifecycleOwner.getLifecycle().addObserver(new VSDataCenterScopeUtil$provideDataCenterScope$$inlined$let$lambda$1(r2, r4));
    L25:
        return (a) r4.element;
    L27:
        throw new UninitializedPropertyAccessException(r7);
    L14:
        r7 = null;
        goto L15
    L10:
        return r3.get(Integer.valueOf(r2));
    L28:
        return null;
    }

    public static a b(DataCenter r2, Widget r3) {
        if (r2 == null) goto L6;
        return a(r2);
    L6:
        if (r3 == null) goto L8;
        DataCenter r0 = r3.dataCenter;
    L9:
        if (r0 != null) goto L11;
        DataCenter r4 = r.d().c(null, 0);
        if (r4 != null) goto L15;
        return null;
    L15:
        return a(r4);
    L11:
        return a(r3.dataCenter);
    L8:
        r0 = null;
        goto L9
    }
}

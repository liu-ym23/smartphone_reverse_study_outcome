package com.bytedance.android.live.room.navi.userinfo_p.utils;

import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import ev1.o;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RoomUserInfoUtil {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Long c = null;

    static {
        a = LazyKt.lazy(RoomUserInfoUtil$nicknameStyle$2.INSTANCE);
        b = LazyKt.lazy(RoomUserInfoUtil$nicknameMaxCount$2.INSTANCE);
        c = (Long) o.a.getValue();
    }

    @JvmStatic
    public static final boolean a(DataCenter r1) {
        if (b(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Number) a.getValue()).intValue() != 1) goto L7;
        return true;
    }

    public static boolean b(DataCenter r2) {
        if (r2 == null) goto L6;
        Room r0 = z.o(r2);
        if (r0 == null) goto L6;
        String r1 = r0.isEcomCart();
    L8:
        if (Intrinsics.areEqual(r1, DataType.TRUE) == true) goto L10;
        return false;
    L10:
        if (z.e(r2, false) == true) goto L14;
        return true;
    L14:
        return false;
    L6:
        r1 = null;
        goto L8
    }

    @JvmStatic
    public static final boolean c(DataCenter r1) {
        if (z.k(r1) == false) goto L5;
    L12:
        return true;
    L5:
        if (z.i(r1) == true) goto L12;
        if (z.g(r1) == true) goto L12;
        if (z.h(r1) == true) goto L12;
        return false;
    }
}

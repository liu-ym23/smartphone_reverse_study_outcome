package com.bytedance.android.livesdk.impl;

import com.bytedance.android.livesdkapi.depend.model.live.room.RoomBaseSession;
import is2.d;
import is2.e;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements e {
    public static final Set<Function2<d, RoomBaseSession, Unit>> a = null;
    public static final a b = null;

    public a() {
    }

    static {
        b = new a();
        a = new LinkedHashSet();
    }

    public final void E3(Function2<? super d, ? super RoomBaseSession, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "hook");
        a.add(r2);
    }
}

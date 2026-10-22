package com.bytedance.android.livesdk.drawer.relax;

import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.ArrayList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t0 {
    public final Function0<Room> a;
    public final Function0<? extends ArrayList<String>> b;
    public final int c;

    public t0(Function0<Room> r2, Function0<? extends ArrayList<String>> r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "room");
        Intrinsics.checkNotNullParameter(r3, "roomIdList");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}

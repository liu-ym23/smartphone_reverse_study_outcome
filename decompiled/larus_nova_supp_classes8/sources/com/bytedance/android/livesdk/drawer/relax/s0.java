package com.bytedance.android.livesdk.drawer.relax;

import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.ArrayList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s0 {
    public final Function0<? extends ArrayList<Room>> a;
    public final Function0<? extends LiveSearchResultPageStatus> b;
    public final Function0<? extends LiveSearchErrorType> c;
    public final Function0<Boolean> d;
    public final Function0<Double> e;

    public s0(Function0<? extends ArrayList<Room>> r2, Function0<? extends LiveSearchResultPageStatus> r3, Function0<? extends LiveSearchErrorType> r4, Function0<Boolean> r5, Function0<Double> r6) {
        Intrinsics.checkNotNullParameter(r2, "searchRoomArray");
        Intrinsics.checkNotNullParameter(r3, "resultPageStatus");
        Intrinsics.checkNotNullParameter(r4, "errorType");
        Intrinsics.checkNotNullParameter(r5, "fromRecommend");
        Intrinsics.checkNotNullParameter(r6, "searchResultStartTime");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}

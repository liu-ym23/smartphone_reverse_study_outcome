package com.bytedance.android.anya.dsl;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.p;
import com.bytedance.android.anya.r;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k<VIEW_STATE extends MVIState<?>, STATE extends r, ACTION extends p> {
    public final LinkedHashMap<Class<? extends STATE>, Map<Class<? extends ACTION>, Function4<l0<VIEW_STATE>, VIEW_STATE, STATE, ACTION, Unit>>> a;

    public k(LinkedHashMap<Class<? extends STATE>, Map<Class<? extends ACTION>, Function4<l0<VIEW_STATE>, VIEW_STATE, STATE, ACTION, Unit>>> r1) {
        this.a = r1;
    }
}

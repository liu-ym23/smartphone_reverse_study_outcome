package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g1 extends s1 {
    public final IRoom d;
    public final s0 e;
    public final CompositeDisposable f;
    public final yz0.k g;

    public static final class a {
    }

    static {
    }

    public final void onStop() {
        ((LinkedHashMap) this.a).clear();
        this.f.clear();
    }

    public g1(yz0.k r2) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        this.g = r2;
        this.d = r2.getRoom();
        this.e = new s0();
        this.f = new CompositeDisposable();
    }

    public final void i(String r3, long r4, Map<String, String> r6) {
        Intrinsics.checkNotNullParameter(r3, "activityName");
        if (this.g.isAnchor() == true) goto L5;
        return;
    L5:
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("activity_name", r3);
        r0.put("effect_id", String.valueOf(r4));
        String r5 = this.g.getRoom().getAnchorId();
        if (r5 != null) goto L8;
        r5 = "'";
    L8:
        r0.put("anchor_id", r5);
        r0.put("room_id", String.valueOf(this.d.getId()));
        if (r6 == null) goto L11;
        r0.putAll(r6);
    L11:
        mz0.n r7 = new mz0.n();
        Map r8 = r7.a;
        Intrinsics.checkNotNullParameter(r8, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r8.putAll(r0);
        mz0.m r9 = new mz0.m();
        r9.b(LogCommon.PAGE_SOURCE_LOG);
        r9.b(LogCommon.ROOM);
        List r10 = r7.b;
        ArrayList r11 = (ArrayList) r10;
        r11.addAll(r9.a);
        cy0.e.a.getClass();
        cy0.j r13 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r14 = com.bytedance.android.scope.m.b(r13).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r14);
        ((f80.a) r14).w3("livesdk_gift_top_piaoping_effect_show", r7.a, r7.b);
    }
}

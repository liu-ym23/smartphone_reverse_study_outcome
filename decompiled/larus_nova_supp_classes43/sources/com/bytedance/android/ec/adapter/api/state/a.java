package com.bytedance.android.ec.adapter.api.state;

import android.os.Bundle;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.android.ec.model.ECUrlModel;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final boolean a;
    public final int b;
    public final boolean c;
    public final boolean d;
    public String e;
    public final String f;
    public final String g;
    public final String h;
    public final boolean i;
    public final boolean j;
    public final Function0<Boolean> k;
    public final int l;
    public final Map<String, String> m;
    public final Bundle n;
    public final int o;
    public final Map<String, String> p;
    public final Function0<Boolean> q;
    public final Function0<Boolean> r;
    public final Function0<Integer> s;
    public final ECUrlModel t;
    public final boolean u;
    public final int v;
    public final String w;
    public final Function0<Boolean> x;
    public final int y;
    public final ECEcomData z;

    /* JADX INFO: renamed from: com.bytedance.android.ec.adapter.api.state.a$a, reason: collision with other inner class name */
    public static final class C0113a {
    }

    static {
    }

    public final boolean a() {
        return ((Boolean) this.k.invoke()).booleanValue();
    }

    public a(int r16, boolean r17, boolean r18, String r19, String r20, String r21, String r22, boolean r23, boolean r24, Function0 r25, int r26, Map r27, Bundle r28, int r29, Map r30, Function0 r31, Function0 r32, Function0 r33, ECUrlModel r34, boolean r35, Function0 r36, ECEcomData r37) {
        Intrinsics.checkNotNullParameter(r19, "roomUniqueKey");
        Intrinsics.checkNotNullParameter(r20, BdpAwemeConstant.KEY_ROOM_ID);
        Intrinsics.checkNotNullParameter(r21, "roomAnchorId");
        Intrinsics.checkNotNullParameter(r22, "roomAnchorSecId");
        Intrinsics.checkNotNullParameter(r25, "isLoginFunc");
        Intrinsics.checkNotNullParameter(r27, "reportParams");
        Intrinsics.checkNotNullParameter(r28, "extra");
        Intrinsics.checkNotNullParameter(r30, "enterRoomParams");
        Intrinsics.checkNotNullParameter(r31, "isKtvFun");
        Intrinsics.checkNotNullParameter(r32, "isInInteractionGameFun");
        Intrinsics.checkNotNullParameter(r33, "panelHeight");
        Intrinsics.checkNotNullParameter(r36, "isRoomVisibleFunc");
        Intrinsics.checkNotNullParameter(r37, "ecomData");
        this.b = r16;
        this.c = r17;
        this.d = r18;
        this.e = r19;
        this.f = r20;
        this.g = r21;
        this.h = r22;
        this.i = r23;
        this.j = r24;
        this.k = r25;
        this.l = r26;
        this.m = r27;
        this.n = r28;
        this.o = r29;
        this.p = r30;
        this.q = r31;
        this.r = r32;
        this.s = r33;
        this.t = r34;
        this.u = r35;
        this.v = 0;
        this.w = null;
        this.x = r36;
        this.y = 0;
        this.z = r37;
        this.a = ((Boolean) r32.invoke()).booleanValue();
    }
}

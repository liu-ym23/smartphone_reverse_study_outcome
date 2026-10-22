package com.bytedance.android.live.revlink.impl.plantform;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.revlink.impl.multianchor.utils.AnchorLinkOptUtils;
import com.bytedance.android.live.revlink.impl.multianchor.utils.MultiEnterRoomTracer;
import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.live.revlink.impl.utils.t;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ AnchorLinkUserCenterV2 a;
    public final /* synthetic */ long b;
    public final /* synthetic */ String c;
    public final /* synthetic */ int d;

    public f(AnchorLinkUserCenterV2 r1, long r2) {
        this.a = r1;
        this.b = r2;
        this.c = "enter_room_backup";
        this.d = 4;
    }

    public final void accept(Object r9) {
        Throwable r10 = (Throwable) r9;
        long r5 = t.a(this.b);
        MultiEnterRoomTracer r0 = this.a.I();
        if (r0 == null) goto L5;
        r0.b(this.c, this.a.m, r5);
    L5:
        v r1 = this.a.J();
        if (r1 == null) goto L8;
        r1.z(7, this.a.E(), this.c, r5, r10);
    L8:
        this.a.j = null;
        if (Intrinsics.areEqual(this.c, "multi_anchor_link_widget_create") == false) goto L11;
    L12:
        AnchorLinkOptUtils r2 = this.a.C();
        if (r2 == null) goto L26;
        this.a.H();
        if (r2.e() == true) goto L17;
        return;
    L17:
        if ((r10 instanceof ApiServerException) == true) goto L19;
        r10 = null;
    L19:
        ApiServerException r12 = (ApiServerException) r10;
        if (r12 != null) goto L22;
    L23:
        this.a.b(this.d, "request_failed_retry");
        return;
    L22:
        if (r12.getErrorCode() != 31001) goto L23;
        return;
    L26:
        return;
    L11:
        if (Intrinsics.areEqual(this.c, "enter_room_preload") == true) goto L12;
    }
}

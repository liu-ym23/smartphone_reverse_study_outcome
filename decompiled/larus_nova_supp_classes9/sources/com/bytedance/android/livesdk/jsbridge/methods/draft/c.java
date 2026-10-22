package com.bytedance.android.livesdk.jsbridge.methods.draft;

import android.graphics.RectF;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public static final /* synthetic */ int b = 0;
    public final b a;

    public static final class a {
    }

    static {
    }

    public final jz.f a() {
        jz.f r0 = new jz.f();
        String r1 = this.a.a();
        if (r1 == null) goto L14;
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r0.c = r1;
        r0.a = this.a.getAnchor();
        r0.b = 2;
        RectF r4 = new RectF();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r0.e = r4;
        r0.f = this.a.getRoom();
        r0.g = true;
        r0.h = this.a.getStartTime();
        r0.i = this.a.getEndTime();
        r0.d = 360000;
        String r5 = m.a(this.a.c());
        if (r5 != null) goto L11;
        r5 = m.a(new Object());
        if (r5 != null) goto L11;
        throw new IllegalStateException("Required value was null.".toString());
    L11:
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        Intrinsics.checkNotNullParameter(this.a.getPromotionId(), "<set-?>");
        Intrinsics.checkNotNullParameter(this.a.getTitle(), "<set-?>");
        Map r2 = MapsKt.mapOf(new Pair[]{TuplesKt.to("anchor_id", this.a.b().a()), TuplesKt.to("draft_item_id", this.a.getVideoId()), TuplesKt.to("draft_from_source", "live_replay"), TuplesKt.to("is_ecom", this.a.b().f()), TuplesKt.to("room_id", this.a.getRoomId()), TuplesKt.to("enter_from", this.a.b().e()), TuplesKt.to("shoot_way", "live_replay"), TuplesKt.to("content_type", "live_replay"), TuplesKt.to("content_source", "live_replay_draft")});
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r0.j = r2;
        return r0;
    L14:
        throw new IllegalStateException("Required value was null.".toString());
    }

    public c(b r1) {
        this.a = r1;
    }
}

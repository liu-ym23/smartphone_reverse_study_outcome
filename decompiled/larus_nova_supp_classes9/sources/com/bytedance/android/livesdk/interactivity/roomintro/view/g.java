package com.bytedance.android.livesdk.interactivity.roomintro.view;

import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements nm3.a {
    public final /* synthetic */ RoomIntroDialog a;

    public final void a(List r2) {
        Intrinsics.checkNotNullParameter(r2, "selectedIndex");
    }

    public final void b(List<Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "selectedIndex");
    }

    public final void d(List<Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "selectedIndex");
    }

    public g(RoomIntroDialog r1) {
        this.a = r1;
    }

    public final void c(List<Integer> r6) {
        Intrinsics.checkNotNullParameter(r6, "selectedIndex");
        int r7 = ((Number) ListProtector.get(r6, 0)).intValue();
        if (r7 >= 0) goto L5;
        return;
    L5:
        if (r7 >= this.a.i.size()) goto L24;
        RoomIntroLabel r8 = (RoomIntroLabel) ListProtector.get(this.a.i, r7);
        this.a.h.add(r8);
        this.a.S90(2131388161).addView(this.a.W90(r8), Math.max(0, this.a.S90(2131388161).getChildCount() - 1));
        this.a.i.remove(r8);
        if (this.a.i.isEmpty() == false) goto L10;
        this.a.S90(2131388161).removeView(this.a.g);
    L10:
        RoomIntroDialog r9 = this.a;
        r9.getClass();
        LinkedHashMap r1 = new LinkedHashMap();
        b0 r2 = r9.f;
        if (r2 == null) goto L13;
        String r3 = r2.a();
    L14:
        r1.put("anchor_id", String.valueOf(r3));
        b0 r10 = r9.f;
        if (r10 != null) goto L17;
        String r11 = BuildConfig.FLAVOR;
    L21:
        r1.put("request_page", r11);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_room_detail_tag_add_success", r1, new Object[0]);
        return;
    L17:
        if (r10.a != null) goto L19;
        r11 = "live_start";
        goto L21
    L19:
        r11 = "live_room";
        goto L21
    L13:
        r3 = null;
        goto L14
    }
}

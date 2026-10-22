package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.Arrays;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c<T> implements SingleOnSubscribe {
    public final /* synthetic */ AbsAudienceToolbarButtonMoreDialog a;
    public final /* synthetic */ JSONArray b;

    public c(AbsAudienceToolbarButtonMoreDialog r1, JSONArray r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(SingleEmitter<Unit> r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        com.bytedance.android.livesdk.log.g r7 = com.bytedance.android.livesdk.log.u.l();
        Pair[] r1 = new Pair[2];
        r1[0] = TuplesKt.to("origin_buttons", this.b.toString());
        jp1.c r2 = this.a.a1();
        if (r2 == null) goto L15;
        jp1.d<Object> r3 = r2.d();
        if (r3 == null) goto L15;
        List<Integer> r4 = r3.c();
        if (r4 == null) goto L15;
        Object[] r5 = r4.toArray(new Integer[0]);
        if (r5 == null) goto L14;
        String r8 = Arrays.toString((Integer[]) r5);
        if (r8 == null) goto L15;
    L16:
        r1[1] = TuplesKt.to("pattern_widgets", r8);
        r7.sendLog("livesdk_more_panel_button_diff", MapsKt.mutableMapOf(r1), new Object[]{am2.x.class, Room.class});
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L15:
        r8 = "null";
        goto L16
    }
}

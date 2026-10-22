package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel;

import am2.x;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e<T> implements SingleOnSubscribe {
    public final /* synthetic */ boolean a;

    public e(boolean r1) {
        this.a = r1;
    }

    public final void subscribe(SingleEmitter<Unit> r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        Pair[] r0 = new Pair[2];
        r0[0] = TuplesKt.to("button_type", "extremely_smooth");
        if (this.a == false) goto L5;
        String r1 = "on";
    L6:
        r0[1] = TuplesKt.to("click_type", r1);
        Map r2 = MapsKt.mapOf(r0);
        j0.l().sendLog("livesdk_image_quality_button_click", r2, new Object[]{IRoom.class, x.class});
        return;
    L5:
        r1 = "off";
        goto L6
    }
}

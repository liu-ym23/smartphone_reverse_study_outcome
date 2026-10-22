package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.liteinteractonprocesser;

import am2.x;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends a {
    public final DataCenter b;

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.plugin.liteinteractonprocesser.a
    public final String a() {
        return "MobLogProcessor";
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.plugin.liteinteractonprocesser.a
    public final boolean b(long r4) {
        if (r4 != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public c(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.b = r2;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.plugin.liteinteractonprocesser.a
    public final void c(t42.a r4, com.bytedance.android.live.base.model.liteinteraction.a r5, CompositeDisposable r6) {
        Intrinsics.checkNotNullParameter(r4, "event");
        Intrinsics.checkNotNullParameter(r5, "actions");
        Intrinsics.checkNotNullParameter(r6, "cd");
        com.bytedance.android.live.base.model.liteinteraction.c r7 = r5.c();
        if (r7 == null) goto L25;
        String r8 = r7.a();
        if (r8 == null) goto L26;
        LinkedHashMap r0 = new LinkedHashMap();
        t42.b r9 = r4.a;
        if (r9 == null) goto L13;
        Long r10 = r9.a;
        if (r10 == null) goto L13;
        String r11 = String.valueOf(r10.longValue());
        if (r11 == null) goto L13;
    L14:
        r0.put("msg_id", r11);
        if (a0.d(this.b, false) == false) goto L17;
        String r13 = "1";
    L18:
        r0.put("is_anchor", r13);
        com.bytedance.android.live.base.model.liteinteraction.c r14 = r5.c();
        if (r14 == null) goto L23;
        Map r15 = r14.b();
        if (r15 == null) goto L23;
        r0.putAll(r15);
    L23:
        j0.l().sendLog(r8, r0, new Object[]{x.class, Room.class});
        return;
    L17:
        r13 = "0";
    L13:
        r11 = BuildConfig.FLAVOR;
        goto L14
    L26:
        return;
    }
}

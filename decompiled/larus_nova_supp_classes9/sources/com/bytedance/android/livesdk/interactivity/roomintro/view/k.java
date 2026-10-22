package com.bytedance.android.livesdk.interactivity.roomintro.view;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ RoomIntroDialog a;
    public final /* synthetic */ boolean b;

    public k(RoomIntroDialog r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r7) {
        Response r8 = (Response) r7;
        Integer r0 = ((com.bytedance.android.livesdk.interactivity.api.roomintro.api.b) ((BaseResponse) r8).data).j();
        if (r0 != null) goto L6;
    L30:
        String r1 = rm3.c.a;
        FragmentActivity r2 = this.a.getActivity();
        String r9 = ((com.bytedance.android.livesdk.interactivity.api.roomintro.api.b) ((BaseResponse) r8).data).c();
        if (r9 != null) goto L33;
        r9 = s1.B(2131923023);
    L33:
        rm3.c.g(r2, r9, 0, true, 16);
        return;
    L6:
        if (r0.intValue() != 0) goto L30;
        if (this.b == false) goto L29;
        RoomIntroDialog r10 = this.a;
        b0 r3 = r10.f;
        if (r3 == null) goto L28;
        Intrinsics.checkNotNull(r3);
        if (r3.a != null) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == false) goto L28;
        LinkedHashMap r5 = new LinkedHashMap();
        b0 r6 = r10.f;
        if (r6 == null) goto L19;
        String r11 = r6.a();
    L20:
        r5.put("anchor_id", String.valueOf(r11));
        b0 r13 = r10.f;
        if (r13 != null) goto L23;
        String r14 = BuildConfig.FLAVOR;
    L27:
        r5.put("request_page", r14);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_room_detail_revise_success", r5, new Object[0]);
        goto L28
    L23:
        if (r13.a != null) goto L25;
        r14 = "live_start";
        goto L27
    L25:
        r14 = "live_room";
        goto L27
    L19:
        r11 = null;
        goto L20
    L14:
        r4 = false;
    L28:
        String r15 = rm3.c.a;
        rm3.c.f(this.a.getActivity(), 2131919921, true, 16);
    L29:
        ALogger.i("com.bytedance.android.livesdk.interactivity.roomintro.view.RoomIntroDialog", "update room_intro succeed with switch " + this.b);
    }
}

package com.bytedance.android.live.revlink.impl.plantform;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.utils.t;
import com.bytedance.android.livesdk.link.model.r;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ AnchorLinkUserCenterV2 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;
    public final /* synthetic */ Function1 f;

    public e(AnchorLinkUserCenterV2 r1, long r2, Function1 r4) {
        this.a = r1;
        this.b = "enter_room_backup";
        this.c = r2;
        this.d = 4;
        this.e = 7;
        this.f = r4;
    }

    public final void accept(Object r9) {
        ExtraResponse<r, Extra> r2 = (ExtraResponse) r9;
        AnchorLinkUserCenterV2 r0 = this.a;
        String r1 = this.b;
        long r3 = t.a(this.c);
        int r5 = this.d;
        int r6 = this.e;
        Function1 r10 = this.f;
        if (r10 == null) goto L7;
        boolean r7 = true;
        if (((Boolean) r10.invoke(r2)).booleanValue() != true) goto L7;
    L8:
        r0.O(r1, r2, r3, r5, r6, r7);
        return;
    L7:
        r7 = false;
        goto L8
    }
}

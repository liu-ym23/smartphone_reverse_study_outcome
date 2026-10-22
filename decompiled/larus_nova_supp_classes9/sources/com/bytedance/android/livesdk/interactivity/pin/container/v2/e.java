package com.bytedance.android.livesdk.interactivity.pin.container.v2;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import g42.l;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ PinContainerHighlightProcessor a;
    public final /* synthetic */ l b;
    public final /* synthetic */ long c;
    public final /* synthetic */ ArrayList d;

    public e(PinContainerHighlightProcessor r1, l r2, long r3, ArrayList r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }

    public final void accept(Object r9) {
        Response r10 = (Response) r9;
        String r4 = ((BaseResponse) r10).logId;
        if (((BaseResponse) r10).statusCode != 0) goto L13;
        o32.a.a("remove all success");
        int r11 = com.bytedance.android.livesdk.interactivity.pin.container.v2.utils.a.a;
        l r13 = this.b;
        long r2 = this.c;
        Room r5 = this.a.w();
        Intrinsics.checkNotNullParameter(r13, "event");
        com.bytedance.android.livesdk.interactivity.pin.container.v2.utils.a.b("request_unpin", r13.a, r2, r4, r5, String.valueOf(r13.c));
        ArrayList r14 = this.d;
        if (r14 == null) goto L10;
        Iterator<T> r15 = r14.iterator();
    L8:
        if (r15.hasNext() == false) goto L10;
        this.a.z((HighlightItem) r15.next(), "deleted");
    L10:
        ((LinkedHashMap) this.a.j).clear();
        ((HashMap) this.a.n).clear();
        this.a.m.clear();
        if (this.a.i.isEmpty() == false) goto L29;
        this.a.B();
        return;
    L29:
        return;
    L13:
        o32.a.a("remove all failed, log_id: " + ((BaseResponse) r10).logId);
        RequestError r16 = ((BaseResponse) r10).error;
        if (r16 == null) goto L16;
        String r17 = r16.prompts;
    L18:
        if (r17 != null) goto L20;
    L23:
        boolean r1 = true;
    L24:
        if (r1 == true) goto L26;
        f2.c(r17, 0);
    L26:
        int r18 = com.bytedance.android.livesdk.interactivity.pin.container.v2.utils.a.a;
        com.bytedance.android.livesdk.interactivity.pin.container.v2.utils.a.c(this.b, null, this.c, r4, this.a.w());
        return;
    L20:
        if (StringsKt.isBlank(r17) == true) goto L23;
        r1 = false;
        goto L24
    L16:
        r17 = null;
        goto L18
    }
}

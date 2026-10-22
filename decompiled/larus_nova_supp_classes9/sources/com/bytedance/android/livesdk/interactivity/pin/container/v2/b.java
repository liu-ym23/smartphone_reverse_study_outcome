package com.bytedance.android.livesdk.interactivity.pin.container.v2;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.interactivity.api.pin.container.PinType;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ PinContainerHighlightProcessor a;
    public final /* synthetic */ g42.f b;
    public final /* synthetic */ PinType c;
    public final /* synthetic */ g42.h d;
    public final /* synthetic */ long e;

    public b(PinContainerHighlightProcessor r1, g42.f r2, PinType r3, g42.h r4, long r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void accept(Object r10) {
        g42.j r11 = (g42.j) r10;
        String r5 = r11.e;
        if (r11.c == false) goto L13;
        HighlightItem r0 = r11.d;
        if (r0 == null) goto L7;
        String r3 = this.b.c(r0);
    L8:
        o32.a.a("pin request success. pinTyp=" + this.c + " uniqueKey=" + r3 + " logId=" + r5);
        if (r11.a == false) goto L12;
        if (r0 == null) goto L12;
        this.a.s(this.b, r0);
        this.a.p().o(this.a);
    L12:
        int r1 = com.bytedance.android.livesdk.interactivity.pin.container.v2.utils.a.a;
        g42.h r2 = this.d;
        long r4 = this.e;
        String r6 = r11.e;
        Room r7 = this.a.w();
        Intrinsics.checkNotNullParameter(r2, "pinEvent");
        com.bytedance.android.livesdk.interactivity.pin.container.v2.utils.a.b("request_pin", r2.a, r4, r6, r7, String.valueOf(r2.c));
        return;
    L7:
        r3 = null;
        goto L8
    L13:
        o32.a.a("pin request failed. pinType=" + this.c + " logId=" + r5);
        String r13 = r11.b;
        if (r13 != null) goto L16;
    L19:
        boolean r8 = true;
    L20:
        if (r8 == true) goto L22;
        f2.c(r13, 0);
    L22:
        int r14 = com.bytedance.android.livesdk.interactivity.pin.container.v2.utils.a.a;
        g42.h r15 = this.d;
        long r9 = this.e;
        Room r16 = this.a.w();
        Intrinsics.checkNotNullParameter(r15, "pinEvent");
        com.bytedance.android.livesdk.interactivity.pin.container.v2.utils.a.a("request_pin", r15.a, null, r9, r5, r16, String.valueOf(r15.c));
        return;
    L16:
        if (StringsKt.isBlank(r13) == true) goto L19;
        r8 = false;
        goto L20
    }
}

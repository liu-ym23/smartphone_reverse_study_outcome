package com.bytedance.android.live.broadcastgame.opengame.lynx;

import com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod;
import com.bytedance.android.live.broadcastgame.opengame.utils.j;
import com.bytedance.android.live.core.utils.JsonUtil;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ LynxOpenPlugin a;
    public final /* synthetic */ x7a.h b;
    public final /* synthetic */ com.bytedance.android.live.lynx.api.d c;

    public f(LynxOpenPlugin r1, x7a.h r2, com.bytedance.android.live.lynx.api.d r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r11) {
        Integer r12 = (Integer) r11;
        String r13 = this.a.v;
        if (r13 != null) goto L5;
    L46:
        LynxOpenPlugin r14 = this.a;
        Map r0 = this.b.c;
        int r1 = BaseOpenMethod.g;
        r14.getClass();
        LynxOpenPlugin.H(r0, r1);
        return;
    L5:
        if (Intrinsics.areEqual(r13, "") == true) goto L46;
        int r15 = j.a;
        String r16 = this.a.v;
        if (r16 == null) goto L56;
        String r17 = j.d(r16);
        if (Intrinsics.areEqual(r17, "") == false) goto L13;
        LynxOpenPlugin r18 = this.a;
        Map r2 = this.b.c;
        int r3 = BaseOpenMethod.g;
        r18.getClass();
        LynxOpenPlugin.H(r2, r3);
        return;
    L13:
        a r19 = (a) JsonUtil.parse(r17, new e().getType());
        if (this.a.c == false) goto L16;
        String r4 = "anchor";
    L18:
        if (r19 == null) goto L38;
        List<a.e> r110 = r19.b();
        if (r110 == null) goto L38;
        Iterator<T> r111 = r110.iterator();
    L23:
        if (r111.hasNext() == false) goto L34;
        T r5 = r111.next();
        a.e r6 = (a.e) r5;
        if (Intrinsics.areEqual(r6.getType(), "panel") == true) goto L27;
    L31:
        boolean r7 = false;
    L32:
        if (r7 == false) goto L23;
    L35:
        a.e r8 = r5;
        if (r8 == null) goto L38;
        String r112 = r8.b();
    L39:
        if (r112 != null) goto L41;
    L43:
        String r9 = this.a.t + '/' + r112 + "/template.js";
        this.c.c(r112 + "/template.js", r9, this.a.x());
        com.bytedance.android.live.broadcastgame.opengame.panel.h r113 = this.a.z;
        if (r113 == null) goto L54;
        r113.i();
        return;
    L54:
        return;
    L41:
        if (StringsKt.endsWith$default(r112, "index", false, 2, null) != true) goto L43;
        r112 = r112.substring(0, StringsKt.lastIndexOf$default(r112, "/", 0, false, 6, null));
        goto L43
    L27:
        if (Intrinsics.areEqual(r6.a(), "introduce") == false) goto L31;
        if (Intrinsics.areEqual(r6.c(), r4) == false) goto L31;
        r7 = true;
        goto L32
    L34:
        r5 = (T) null;
    L38:
        r112 = null;
        goto L39
    L16:
        r4 = "audience";
        goto L18
    }
}

package com.bytedance.android.livesdk.chatroom.viewmodule.welfare;

import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdk.utils.u4;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class WelfareProjectCardAnimController {
    public q4.b a;
    public int b;
    public final View c;
    public final Function0<Unit> d;
    public final Function0<Unit> e;

    public static final class a {
    }

    static {
    }

    public WelfareProjectCardAnimController(View r2, Function0<Unit> r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "onShow");
        Intrinsics.checkNotNullParameter(r4, "onDismiss");
        this.c = r2;
        this.d = r3;
        this.e = r4;
    }

    public final void a(boolean r4, final int[] r5, final int r6) {
        Intrinsics.checkNotNullParameter(r5, "anchorViewPosition");
        final View r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        q4.b r1 = this.a;
        if (r1 != null) goto L8;
    L13:
        if (r4 == false) goto L15;
        q4.b r7 = u4.c(new WelfareProjectCardAnimController$dismiss$1(this, r5, r0, r6));
        r7.c();
        this.a = r7;
        return;
    L15:
        UtilityKotlinExtentionsKt.t(r0);
        this.e.invoke();
        return;
    L8:
        if (r1.b() != true) goto L13;
        q4.b r2 = this.a;
        if (r2 == null) goto L12;
        r2.a();
    L12:
        this.a = null;
        goto L13
    }

    public final void b(boolean r4, final int[] r5, final int r6) {
        Intrinsics.checkNotNullParameter(r5, "anchorViewPosition");
        final View r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        q4.b r1 = this.a;
        if (r1 != null) goto L8;
    L13:
        UtilityKotlinExtentionsKt.w(r0);
        if (r4 == false) goto L16;
        q4.b r7 = u4.c(new WelfareProjectCardAnimController$show$controller$1(this, r5, r0, r6));
        this.a = r7;
        ConcurrentHashMap r8 = q4.c.a;
        Intrinsics.checkNotNullParameter("WelfareCardShow", "key");
        Intrinsics.checkNotNullParameter(r7, "controller");
        q4.c.a.put("WelfareCardShow", r7);
        this.d.invoke();
        return;
    L16:
        ConcurrentHashMap r9 = q4.c.a;
        Intrinsics.checkNotNullParameter("WelfareCardShow", "key");
        q4.c.a.remove("WelfareCardShow");
        r0.setScaleX(1.0f);
        r0.setScaleY(1.0f);
        r0.setAlpha(1.0f);
        this.d.invoke();
        return;
    L8:
        if (r1.b() != true) goto L13;
        q4.b r2 = this.a;
        if (r2 == null) goto L12;
        r2.a();
    L12:
        this.a = null;
        goto L13
    }
}

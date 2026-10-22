package com.bytedance.android.livesdk.dslservice.lynxair;

import android.view.View;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import yt1.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h implements j {
    public final /* synthetic */ AnnieXLynxView a;

    @Override // yt1.j
    public final r a() {
        return null;
    }

    @Override // yt1.j
    public final View getTargetView() {
        return this.a;
    }

    public h(AnnieXLynxView r1) {
        this.a = r1;
    }

    @Override // yt1.j
    public final void b(String r4, Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r4, LiveEndPageData.TAG_NAME);
        if (r5 == null) goto L6;
        Map r6 = MapsKt.mapOf(TuplesKt.to("resp", r5));
        if (r6 == null) goto L6;
    L7:
        AnnieXLynxView r0 = this.a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "actionName");
        Intrinsics.checkNotNullParameter(r6, "realArguments");
        bb.a r1 = r0.d;
        if (r1 == null) goto L11;
        Intrinsics.checkNotNullParameter(r4, "actionName");
        Intrinsics.checkNotNullParameter(r6, "actionData");
        bb.c r2 = bb.c.a;
        AnnieXLynxView r3 = r1.a;
        r2.getClass();
        bb.c.b(r3, r1);
        r1.c.b(r4, r6, r1.b);
        return;
    L11:
        return;
    L6:
        r6 = MapsKt.emptyMap();
        goto L7
    }

    @Override // yt1.j
    public final void c(Map r3, int r4) {
        LynxViewUtilKt.a(this.a, "", r3, r4);
    }
}

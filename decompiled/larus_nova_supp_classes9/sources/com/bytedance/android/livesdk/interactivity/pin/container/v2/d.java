package com.bytedance.android.livesdk.interactivity.pin.container.v2;

import com.bytedance.android.livesdk.interactivity.api.settings.config.z;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements g42.d {
    public final /* synthetic */ PinContainerHighlightProcessor a;

    public d(PinContainerHighlightProcessor r1) {
        this.a = r1;
    }

    @Override // g42.d
    public final void a(HighlightItem r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "map");
        g42.d.a.d(this, r2, r3);
    }

    @Override // g42.d
    public final void b(HighlightItem r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "map");
        g42.d.a.g(this, r2, r3);
    }

    @Override // g42.d
    public final void c(HighlightItem r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "map");
        z.a r4 = z.a;
        DataCenter r0 = this.a.getDataCenter();
        r4.getClass();
        if (z.a.a(r0) == false) goto L5;
        String r5 = "public_screen_emphasize";
    L6:
        r3.put("show_area", r5);
        return;
    L5:
        r5 = "sticker";
        goto L6
    }

    @Override // g42.d
    public final void d(g42.h<?> r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r3, "map");
        g42.d.a.a(r2, r3);
    }

    @Override // g42.d
    public final void e(HighlightItem r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "map");
        g42.d.a.b(this, r2, r3);
    }

    @Override // g42.d
    public final void f(HighlightItem r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "map");
        g42.d.a.c(this, r2, r3);
    }

    @Override // g42.d
    public final void g(HighlightItem r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "map");
        g42.d.a.e(this, r2, r3);
    }

    @Override // g42.d
    public final void h(HighlightItem r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "map");
        g42.d.a.f(this, r2, r3);
    }
}

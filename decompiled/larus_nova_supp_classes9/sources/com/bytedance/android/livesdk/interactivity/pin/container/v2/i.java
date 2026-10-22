package com.bytedance.android.livesdk.interactivity.pin.container.v2;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i implements g42.e {
    public final View a;

    @Override // g42.e
    public final void c(DataCenter r1, g42.c r2, HighlightItem r3) {
        Intrinsics.checkNotNullParameter(r2, "pinContainer");
        Intrinsics.checkNotNullParameter(r3, "highlightItem");
    }

    @Override // g42.e
    public final int getContentHeight() {
        return this.a.getHeight();
    }

    @Override // g42.e
    public final int getMinHeight() {
        return UtilityKotlinExtentionsKt.i(72);
    }

    @Override // g42.e
    public final View getView() {
        return this.a;
    }

    public i(Context r2) {
        this.a = new View(r2);
    }

    @Override // g42.e
    public final void a(HighlightItem r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r2, "item");
    }

    @Override // g42.e
    public final void b(g42.c r2, HighlightItem r3) {
        Intrinsics.checkNotNullParameter(r2, "pinContainer");
        Intrinsics.checkNotNullParameter(r3, "item");
        g42.e.a.a(r2, r3);
    }

    @Override // g42.e
    public void update(g42.c r2, HighlightItem r3) {
        Intrinsics.checkNotNullParameter(r2, "pinContainer");
        Intrinsics.checkNotNullParameter(r3, "highlightItem");
        g42.e.a.update(this, r2, r3);
    }
}

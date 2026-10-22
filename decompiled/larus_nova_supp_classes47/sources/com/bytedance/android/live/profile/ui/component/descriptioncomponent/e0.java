package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import android.view.View;
import com.lynx.tasm.LynxView;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e0 extends b7.a {
    public final /* synthetic */ String a;

    public e0(String r1) {
        this.a = r1;
    }

    public final void onBeforeCreateRenderData(View r3) {
        Intrinsics.checkNotNullParameter(r3, "hybridView");
        super.onBeforeCreateRenderData(r3);
        if ((r3 instanceof LynxView) == false) goto L6;
        ((LynxView) r3).updateGlobalProps(MapsKt.mapOf(TuplesKt.to("my_live_extra", this.a)));
        return;
    }
}

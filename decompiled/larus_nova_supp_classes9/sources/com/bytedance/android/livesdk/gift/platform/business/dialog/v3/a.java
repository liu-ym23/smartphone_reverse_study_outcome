package com.bytedance.android.livesdk.gift.platform.business.dialog.v3;

import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements WidgetManager.IWidgetConfigHandler {
    public final /* synthetic */ GiftDialogFragmentV3 a;

    public a(GiftDialogFragmentV3 r1) {
        this.a = r1;
    }

    public final void onDestroy(Widget r2) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        if ((r2 instanceof f6.b) == false) goto L6;
        ((f6.b) r2).hp(null);
        return;
    }

    public final void onLoad(Widget r2) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        if ((r2 instanceof f6.b) == false) goto L6;
        ((f6.b) r2).hp(this.a.r);
        return;
    }

    public final void onUnload(Widget r2) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        if ((r2 instanceof f6.b) == false) goto L6;
        ((f6.b) r2).hp(null);
        return;
    }
}

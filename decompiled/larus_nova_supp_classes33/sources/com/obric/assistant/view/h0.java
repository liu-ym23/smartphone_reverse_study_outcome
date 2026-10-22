package com.obric.assistant.view;

import android.view.View;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class h0 implements View.OnAttachStateChangeListener {
    public final /* synthetic */ ObricUpdateBannerPopupWindow a;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
    }

    public h0(ObricUpdateBannerPopupWindow r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r4) {
        Intrinsics.checkNotNullParameter(r4, "v");
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("anchor detached, hostId=");
        r1.append(this.a.a);
        r1.append(", anchor=");
        this.a.getClass();
        r1.append(ObricUpdateBannerPopupWindow.j(r4));
        r0.i("ObricUpdateBannerPopupWindow", r1.toString());
        this.a.c();
    }
}

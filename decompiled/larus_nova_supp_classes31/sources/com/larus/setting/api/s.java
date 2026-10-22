package com.larus.setting.api;

import android.view.View;
import com.larus.bmhome.view.item.ItemTextToggle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class s implements ltb.a<mtb.f> {
    public final /* synthetic */ View a;
    public final /* synthetic */ boolean b;

    public final void onSuccess(Object r2) {
        Intrinsics.checkNotNullParameter((mtb.f) r2, "data");
    }

    public s(View r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onError(int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "errorMsg");
        ItemTextToggle r5 = this.a;
        if (r5 != null) goto L5;
        return;
    L5:
        if ((r5 instanceof ItemTextToggle) == false) goto L9;
        r5.setRestoring(true);
        this.a.getToggleView().setChecked(true ^ this.b);
        t19.s.a.g(this.a.getContext(), 2131897942, false);
        return;
    }
}

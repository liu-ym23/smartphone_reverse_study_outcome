package com.bytedance.android.anniex.ability;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k implements ue7.c {
    public final /* synthetic */ ra.a a;
    public final /* synthetic */ AnnieXLynxView b;

    public final Uri a() {
        return this.a.b;
    }

    public final String b() {
        return this.a.c;
    }

    public final Context context() {
        return this.b.getContext();
    }

    public final View i() {
        return this.b;
    }

    public k(ra.a r1, AnnieXLynxView r10) {
        this.a = r1;
        this.b = r10;
    }

    public final void sendEvent(String r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        AnnieXLynxView r0 = this.b;
        int r1 = AnnieXLynxView.B;
        r0.O(r10, r11, true);
    }
}

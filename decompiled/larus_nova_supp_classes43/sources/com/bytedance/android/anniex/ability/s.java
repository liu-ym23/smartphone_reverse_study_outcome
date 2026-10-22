package com.bytedance.android.anniex.ability;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.anniex.web.AnnieXWebKit;
import com.bytedance.android.anniex.web.model.AnnieXWebModel;
import com.bytedance.sdk.xbridge.cn.platform.web.WebBDXBridge;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class s implements ue7.c {
    public final /* synthetic */ AnnieXWebModel a;
    public final /* synthetic */ WebBDXBridge b;
    public final /* synthetic */ AnnieXWebKit c;

    public final Uri a() {
        Uri r0 = this.c.u;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.a.c;
    }

    public final String b() {
        return this.a.a;
    }

    public final Context context() {
        if (this.b.getContext() == null) goto L5;
        Context r0 = this.b.getContext();
        Intrinsics.checkNotNull(r0);
        return r0;
    L5:
        Context r1 = this.c.r;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("_context");
        return null;
    L10:
        return r1;
    }

    public final View i() {
        return this.c.e;
    }

    public final void sendEvent(String r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        this.c.p(r10, r11);
    }

    public s(AnnieXWebModel r1, WebBDXBridge r10, AnnieXWebKit r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }
}

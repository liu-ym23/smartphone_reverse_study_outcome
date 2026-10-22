package com.bytedance.android.ec.core.hybrid.utils;

import android.view.View;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f implements ti.l {
    public final View a;
    public final View b;
    public final /* synthetic */ pd.j c;

    public final void release() {
        this.c.release();
    }

    public final View b() {
        return this.b;
    }

    public final View getHybridView() {
        return this.a;
    }

    public f(pd.j r10) {
        this.c = r10;
        this.a = r10.getHybridView();
        this.b = r10.b();
    }

    public final void loadUrl(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        this.c.loadUrl(r10);
    }

    public final void updateBusinessGlobalProps(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        this.c.updateBusinessGlobalProps(r10);
    }

    public final void updateData(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        this.c.updateData(r10);
    }

    public final void updateGlobalProps(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        this.c.updateGlobalProps(r10);
    }

    public final void registerMethod(String r10, com.bytedance.ies.web.jsbridge2.f.b r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "provider");
        this.c.registerStatefulMethod(r10, r11);
    }

    public final void renderTemplate(String r10, Map<String, ? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        this.c.renderTemplate(r10, r11);
    }

    public final <T> void sendJsEvent(String r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "event");
        Intrinsics.checkNotNullParameter(r11, "params");
        this.c.sendJsEvent(r10, r11);
    }

    public final void updateScreenMetrics(int r1, int r10) {
        this.c.a();
    }

    public final <P, R> void registerMethod(String r10, com.bytedance.ies.web.jsbridge2.g<P, R> r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "method");
        this.c.registerStatelessMethod(r10, r11);
    }
}

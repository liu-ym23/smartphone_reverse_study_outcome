package c9;

import android.content.Context;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.card.AnnieCard;
import com.bytedance.android.annie.service.debug.DebugTatPosition;
import com.bytedance.android.live.browser.AnnieNGInitHelper;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements d {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    @Override // c9.d
    public final void E0(DebugTatPosition r10, AnnieNGInitHelper.a r11) {
        Intrinsics.checkNotNullParameter(r10, "position");
        Intrinsics.checkNotNullParameter(r11, "providerService");
        ((d) Annie.getService$default(d.class, null, 2, null)).E0(r10, r11);
    }

    @Override // c9.d
    public final void c0(Context r10, AnnieCard r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "annieCard");
        ((d) Annie.getService$default(d.class, null, 2, null)).c0(r10, r11);
    }

    @Override // c9.d
    public final void registerMethod(String r10, f.b r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "method");
        ((d) Annie.getService$default(d.class, null, 2, null)).registerMethod(r10, r11);
    }

    @Override // c9.d
    public final <P, R> void registerMethod(String r10, g<P, R> r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "method");
        ((d) Annie.getService$default(d.class, null, 2, null)).registerMethod(r10, r11);
    }
}

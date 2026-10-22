package com.bytedance.ai.applet.app.view;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class o {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public o() {
    }

    public static m a(Context r11) {
        Intrinsics.checkNotNullParameter(r11, "context");
        return new m(5, c(r11, "larus_appEntry_3rdPartyApp_menuOption_about", 2131894394), 2131235794, 5, true, null, null, null, 968);
    }

    public static m b(Context r11) {
        Intrinsics.checkNotNullParameter(r11, "context");
        return new m(6, c(r11, "larus_appEntry_3rdPartyApp_menuOption_report", 2131894396), 2131235796, 6, true, null, null, null, 968);
    }

    public static m d(Context r11) {
        Intrinsics.checkNotNullParameter(r11, "context");
        return new m(1, c(r11, "larus_appEntry_3rdPartyApp_menuOption_pin", 2131894397), 2131235797, 1, true, null, null, null, 968);
    }

    public static m e(Context r11) {
        Intrinsics.checkNotNullParameter(r11, "context");
        return new m(3, c(r11, "larus_appEntry_3rdPartyApp_menuOption_reload", 2131894398), 2131235798, 3, true, null, null, null, 968);
    }

    public static m f(Context r11) {
        Intrinsics.checkNotNullParameter(r11, "context");
        return new m(2, c(r11, "larus_appEntry_3rdPartyApp_menuOption_settings", 2131894399), 2131235799, 2, true, null, null, null, 968);
    }

    public static String c(Context r1, String r10, int r11) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r10, "targetKey");
        com.bytedance.ai.utils.l.a.getClass();
        return com.bytedance.ai.utils.l.d(r1, r10, r11);
    }
}

package com.lynx.tasm.navigator;

import android.content.Context;
import com.lynx.jsbridge.LynxModule;
import com.lynx.jsbridge.n;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.utils.j;
import jm.a;
import so.e;
import zn.b;

/* JADX INFO: loaded from: classes2.dex */
public class NavigationModule extends LynxModule {
    public static String NAME = "NavigationModule";

    public NavigationModule(Context r5) {
        super(r5);
    }

    @n
    public String getString() {
        return NAME;
    }

    @n
    public void goBack() {
        e r5 = new e(11);
        j.a().post(r5);
    }

    @n
    public void navigateTo(String r5, ReadableMap r10) {
        b r11 = new b(0, r5, r10);
        j.a().post(r11);
    }

    @n
    public void registerRoute(ReadableMap r5) {
        a r10 = new a(r5, 21);
        j.a().post(r10);
    }

    @n
    public void replace(String r5, ReadableMap r10) {
        b r11 = new b(1, r5, r10);
        j.a().post(r11);
    }

    public NavigationModule(Context r5, Object r10) {
        super(r5, r10);
    }
}

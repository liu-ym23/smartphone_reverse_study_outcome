package com.ss.android.lark.keyboard.edittext2.utils;

import com.ss.android.lark.KeyboardBaseModule;
import com.ss.android.lark.maintab.export.TabAppInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(String r1) {
        Intrinsics.checkNotNullParameter(r1, TabAppInfo.IMAGE_JSON_KEY);
        return KeyboardBaseModule.a().isFeatureGatingEnable(r1);
    }
}

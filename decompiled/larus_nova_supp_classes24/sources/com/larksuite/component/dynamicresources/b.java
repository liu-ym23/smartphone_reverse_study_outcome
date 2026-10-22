package com.larksuite.component.dynamicresources;

import com.ss.android.lark.component.appcontext.LarkAppContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public static final boolean a = false;

    static {
        a = LarkAppContext.inst().buildConfig().isUsPackage();
    }
}

package com.ss.android.lark.coremdbiz.facade.bizext;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class DefaultUserIdProvider implements Function0<String> {
    public static final DefaultUserIdProvider a = null;
    public static final Function0<String> b = null;

    public DefaultUserIdProvider() {
    }

    static {
        a = new DefaultUserIdProvider();
        b = DefaultUserIdProvider$delegate$1.INSTANCE;
    }

    public final Object invoke() {
        return (String) b.invoke();
    }
}

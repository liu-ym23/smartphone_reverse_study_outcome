package com.ss.android.lark.officesdk.chameleon.assembly.doubao.common.deps;

import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class m implements ntb.m {
    public m() {
    }

    @Override // ntb.m
    public final Locale getCurrentLocale() {
        yob.e.a().getClass();
        int r0 = com.ss.android.lark.language.service.impl.a.f;
        return com.ss.android.lark.language.service.impl.a.b.a.getLanguageSetting();
    }

    @Override // ntb.m
    public final String t() {
        yob.e.a().getClass();
        int r0 = com.ss.android.lark.language.service.impl.a.f;
        return com.ss.android.lark.language.service.impl.a.b.a.getCacheLanguageSetting().toLanguageTag();
    }
}

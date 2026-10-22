package com.obric.aikernel.middleware.impl.settings;

import android.content.Context;
import com.bytedance.news.common.settings.SettingsConfigProvider;
import com.bytedance.news.common.settings.internal.l;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class SettingsConfigProviderImpl implements SettingsConfigProvider {
    public SettingsConfigProviderImpl() {
    }

    private final boolean supportSettingsStack() {
        return AppContext.INSTANCE.isAdminMode();
    }

    @Override // com.bytedance.news.common.settings.SettingsConfigProvider
    public e4.b getConfig() {
        Context r10 = AppContext.INSTANCE.getContext();
        boolean r11 = l.c(r10);
        e4.b r12 = new e4.b.C0161b().b(r10).e(new SettingsRequestServiceImpl()).d(supportSettingsStack()).c(r11).f(false).a();
        Intrinsics.checkNotNullExpressionValue(r12, "Builder()\n            .c…lse)\n            .build()");
        return r12;
    }

    @Override // com.bytedance.news.common.settings.SettingsConfigProvider
    public e4.d getLazyConfig() {
        e4.d r10 = new e4.d.b().b(String.valueOf(AppContext.INSTANCE.getVersionCode())).a();
        Intrinsics.checkNotNullExpressionValue(r10, "Builder()\n            .u…)}\")\n            .build()");
        return r10;
    }
}

package com.obric.feature.miniapp.widget;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import ul.c;
import ul.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/obric/feature/miniapp/widget/LauncherGeckoConfigs;", "Lul/d;", "", "", "a", "Ljava/util/List;", "getAppRegisters", "()Ljava/util/List;", "appRegisters", "", "getHost", "()Ljava/lang/String;", "host", "", "isOversea", "()Z", "Lul/c;", "getAppConfigs", "appConfigs", "widget-sdk-4l_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class LauncherGeckoConfigs extends d {
    public static final LauncherGeckoConfigs INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f11388a = null;

    static {
        INSTANCE = new LauncherGeckoConfigs();
        f11388a = CollectionsKt.emptyList();
    }

    public LauncherGeckoConfigs() {
    }

    @Override // ul.d
    public List<c> getAppConfigs() {
        return CollectionsKt.listOf(LauncherWidgetGeckoAppConfig.INSTANCE);
    }

    @Override // ul.d
    public List getAppRegisters() {
        return f11388a;
    }

    @Override // ul.d
    public String getHost() {
        return "gecko.zijieapi.com";
    }

    public boolean isOversea() {
        return false;
    }
}

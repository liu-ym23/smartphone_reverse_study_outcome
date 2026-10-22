package com.obric.aiagent.product.platform.api.sleepmode;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/obric/aiagent/product/platform/api/sleepmode/IObricSleepModeManager;", "", "inSleepMode", "", "forceExitSleepMode", "", "pkgName", "", "event", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IObricSleepModeManager {
    void forceExitSleepMode(String r1, String r2);

    boolean inSleepMode();
}

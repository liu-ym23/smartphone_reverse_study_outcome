package com.obric.assistant.zeus.plugin;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/obric/assistant/zeus/plugin/DefaultObricMigrationHandler;", "Lcom/obric/assistant/zeus/plugin/IObricMigrationHandler;", "<init>", "()V", "isMigrationNeeded", "", "pluginPkg", "", "onInstallFinished", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultObricMigrationHandler implements IObricMigrationHandler {
    public DefaultObricMigrationHandler() {
    }

    public final boolean isMigrationNeeded(String r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginPkg");
        return false;
    }

    public final void onInstallFinished(String r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginPkg");
    }
}

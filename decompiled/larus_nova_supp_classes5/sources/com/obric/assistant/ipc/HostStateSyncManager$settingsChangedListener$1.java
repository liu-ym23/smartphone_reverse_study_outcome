package com.obric.assistant.ipc;

import com.obric.assistant.m;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class HostStateSyncManager$settingsChangedListener$1 implements m {
    public HostStateSyncManager$settingsChangedListener$1() {
    }

    public final void a(String r7) {
        BuildersKt.launch$default(HostStateSyncManager.g, null, null, new HostStateSyncManager$settingsChangedListener$1$onSettingsChanged$1(r7, null), 3, null);
    }
}

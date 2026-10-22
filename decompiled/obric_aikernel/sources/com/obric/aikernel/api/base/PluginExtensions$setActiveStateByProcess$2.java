package com.obric.aikernel.api.base;

import android.os.Bundle;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
final class PluginExtensions$setActiveStateByProcess$2 extends Lambda implements Function0<Bundle> {
    final /* synthetic */ boolean $active;
    final /* synthetic */ String $process;

    PluginExtensions$setActiveStateByProcess$2(String r10, boolean r11) {
        this.$process = r10;
        this.$active = r11;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Bundle invoke() {
        Bundle r10 = new Bundle();
        String r11 = this.$process;
        boolean r12 = this.$active;
        r10.putString("proc", r11);
        r10.putBoolean("active", r12);
        return r10;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Bundle invoke() {
        return invoke();
    }
}

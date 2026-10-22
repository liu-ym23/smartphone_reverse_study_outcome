package com.obric.assistant.interaction.impl.keyguard;

import com.obric.assistant.interaction.api.keyguard.BiometricState;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class KeyguardBiometricSettingImpl$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

    static {
        int[] r0 = new int[BiometricState.values().length];
        r0[BiometricState.DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
    L9:
        r0[BiometricState.DISABLED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
    L5:
        $EnumSwitchMapping$0 = r0;
    }
}

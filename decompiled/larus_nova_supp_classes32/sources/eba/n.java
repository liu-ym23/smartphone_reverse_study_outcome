package eba;

import com.obric.assistant.activation.presentation.runtime.manager.ActivationSource;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class n {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[ActivationSource.values().length];
        r0[ActivationSource.AI_KEY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
    L15:
        r0[ActivationSource.VOICE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
    L23:
        r0[ActivationSource.BREATH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
    L17:
        r0[ActivationSource.POWER_KEY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
    L19:
        r0[ActivationSource.POWER_KEY_TERMINAL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
    L8:
        a = r0;
    }
}

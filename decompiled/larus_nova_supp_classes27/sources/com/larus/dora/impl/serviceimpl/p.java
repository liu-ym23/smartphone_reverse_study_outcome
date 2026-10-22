package com.larus.dora.impl.serviceimpl;

import com.larus.dora.api.LightEffectStatus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class p {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[LightEffectStatus.values().length];
            r0[LightEffectStatus.TURN_ON.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[LightEffectStatus.SLOWLY_FLASHING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[LightEffectStatus.RAPID_FLASHING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[LightEffectStatus.TURN_OFF.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }
}

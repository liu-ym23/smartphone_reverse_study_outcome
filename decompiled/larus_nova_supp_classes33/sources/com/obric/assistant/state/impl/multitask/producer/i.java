package com.obric.assistant.state.impl.multitask.producer;

import com.obric.assistant.state.api.multitask.state.ObricInteractionType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class i {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ObricInteractionType.values().length];
            r0[ObricInteractionType.TextMode.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[ObricInteractionType.ManualHalfDuplex.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[ObricInteractionType.AutoHalfDuplex.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[ObricInteractionType.NullMode.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[ObricInteractionType.DefaultMode.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[ObricInteractionType.RealtimeCallMode.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    static {
    }
}

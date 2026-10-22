package com.obric.assistant.state.impl.multitask.consumer;

import com.obric.assistant.state.api.multitask.ForegroundInteractionPhase;
import com.obric.assistant.state.api.multitask.state.ObricInteractionType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public /* synthetic */ class InteractionProjectionServiceImpl$e {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[ForegroundInteractionPhase.values().length];
        r0[ForegroundInteractionPhase.Idle.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
    L45:
        r0[ForegroundInteractionPhase.Activate.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
    L61:
        r0[ForegroundInteractionPhase.Connecting.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
    L47:
        r0[ForegroundInteractionPhase.Listen.ordinal()] = 4;     // Catch: NoSuchFieldError -> L27
    L49:
        r0[ForegroundInteractionPhase.Thinking.ordinal()] = 5;     // Catch: NoSuchFieldError -> L28
    L37:
        r0[ForegroundInteractionPhase.Generating.ordinal()] = 6;     // Catch: NoSuchFieldError -> L29
    L51:
        r0[ForegroundInteractionPhase.Generated.ordinal()] = 7;     // Catch: NoSuchFieldError -> L30
    L15:
        a = r0;
        int[] r1 = new int[ObricInteractionType.values().length];
        r1[ObricInteractionType.RealtimeCallMode.ordinal()] = 1;     // Catch: NoSuchFieldError -> L31
    L43:
        r1[ObricInteractionType.AutoHalfDuplex.ordinal()] = 2;     // Catch: NoSuchFieldError -> L32
    L55:
        r1[ObricInteractionType.ManualHalfDuplex.ordinal()] = 3;     // Catch: NoSuchFieldError -> L33
    L41:
        r1[ObricInteractionType.TextMode.ordinal()] = 4;     // Catch: NoSuchFieldError -> L34
    L53:
        r1[ObricInteractionType.DefaultMode.ordinal()] = 5;     // Catch: NoSuchFieldError -> L35
    L39:
        r1[ObricInteractionType.NullMode.ordinal()] = 6;     // Catch: NoSuchFieldError -> L36
    L22:
        b = r1;
    }
}

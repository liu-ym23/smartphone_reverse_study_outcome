package com.obric.assistant.interaction.impl;

import com.obric.assistant.state.api.multitask.ForegroundInteractionPhase;
import com.obric.assistant.state.api.multitask.state.ObricInteractionType;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class AssistantInteractionService$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

    static {
        int[] r0 = new int[ObricInteractionType.values().length];
        r0[ObricInteractionType.TextMode.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
    L32:
        r0[ObricInteractionType.ManualHalfDuplex.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
    L42:
        r0[ObricInteractionType.AutoHalfDuplex.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
    L8:
        $EnumSwitchMapping$0 = r0;
        int[] r1 = new int[ForegroundInteractionPhase.values().length];
        r1[ForegroundInteractionPhase.Activate.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
    L34:
        r1[ForegroundInteractionPhase.Generating.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
    L44:
        r1[ForegroundInteractionPhase.Generated.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
    L28:
        r1[ForegroundInteractionPhase.Thinking.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
    L36:
        r1[ForegroundInteractionPhase.Idle.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
    L30:
        r1[ForegroundInteractionPhase.Connecting.ordinal()] = 6;     // Catch: NoSuchFieldError -> L26
    L38:
        r1[ForegroundInteractionPhase.Listen.ordinal()] = 7;     // Catch: NoSuchFieldError -> L27
    L16:
        $EnumSwitchMapping$1 = r1;
    }
}

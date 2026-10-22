package com.obric.assistant.live.service;

import com.obric.assistant.state.api.v2.core.bean.ObricInteractionScene;
import com.obric.assistant.state.api.v2.core.bean.ObricIslandStateType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public /* synthetic */ class ObricLiveService$b {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[ObricIslandStateType.values().length];
        r0[ObricIslandStateType.DEEP_THINK_START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
    L34:
        r0[ObricIslandStateType.DEEP_THINK_END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
    L48:
        r0[ObricIslandStateType.MSG_START.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
    L36:
        r0[ObricIslandStateType.MSG_END.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
    L38:
        r0[ObricIslandStateType.TTS_END.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
    L12:
        a = r0;
        int[] r1 = new int[ObricInteractionScene.values().length];
        r1[ObricInteractionScene.COMPLEX_TASK_SCENE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
    L32:
        r1[ObricInteractionScene.AIGC_GENERATION_SCENE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
    L42:
        r1[ObricInteractionScene.REALTIME_CALL_SCENE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
    L30:
        r1[ObricInteractionScene.DEEP_THINK_SCENE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L28
    L40:
        r1[ObricInteractionScene.DEFAULT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L29
    L18:
        b = r1;
    }
}

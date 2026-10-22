package com.obric.assistant.live.api;

import com.obric.assistant.state.api.v2.core.bean.ObricInteractionScene;
import com.obric.assistant.state.api.v2.core.bean.ObricIslandStateType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public /* synthetic */ class ObricLiveCardStrategy$a {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[ObricIslandStateType.values().length];
        r0[ObricIslandStateType.TTS_PLAYING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
    L40:
        r0[ObricIslandStateType.TTS_END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
    L56:
        r0[ObricIslandStateType.COMPLEX_TASK_ASK_USER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
    L42:
        r0[ObricIslandStateType.COMPLEX_TASK_TAKING_OVER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L25
    L44:
        r0[ObricIslandStateType.COMPLEX_TASK_CALL_USER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L26
    L34:
        r0[ObricIslandStateType.COMPLEX_TASK_OPERATING_VIRTUAL_SCREEN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L27
    L46:
        r0[ObricIslandStateType.COMPLEX_TASK_RECEIVE_USER_CLARIFY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L28
    L14:
        a = r0;
        int[] r1 = new int[ObricInteractionScene.values().length];
        r1[ObricInteractionScene.COMPLEX_TASK_SCENE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L29
    L38:
        r1[ObricInteractionScene.AIGC_GENERATION_SCENE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L30
    L50:
        r1[ObricInteractionScene.DEFAULT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L31
    L36:
        r1[ObricInteractionScene.REALTIME_CALL_SCENE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L32
    L48:
        r1[ObricInteractionScene.DEEP_THINK_SCENE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L33
    L20:
        b = r1;
    }
}

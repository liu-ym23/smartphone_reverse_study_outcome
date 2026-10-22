package com.larus.audio.audiov3.task.sami.v2;

import com.mammon.audiosdk.enums.SAMICoreCallBackEventType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public /* synthetic */ class SamiConnectionPoolImpl$b$a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[SAMICoreCallBackEventType.values().length];
        r0[SAMICoreCallBackEventType.TaskStarted.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
    L19:
        r0[SAMICoreCallBackEventType.TaskFailed.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
    L27:
        r0[SAMICoreCallBackEventType.SessionStarted.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
    L21:
        r0[SAMICoreCallBackEventType.SessionFinished.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
    L23:
        r0[SAMICoreCallBackEventType.SessionFailed.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
    L17:
        r0[SAMICoreCallBackEventType.WebSocketStateChanged.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
    L9:
        a = r0;
    }
}

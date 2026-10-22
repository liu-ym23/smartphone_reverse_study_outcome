package com.obric.memorydata.sdk.screencapture.event;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public /* synthetic */ class ScreenEvent$a$a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[ScreenEvent.EventType.values().length];
        r0[ScreenEvent.EventType.TOUCH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
    L13:
        r0[ScreenEvent.EventType.INPUT_METHOD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
    L19:
        r0[ScreenEvent.EventType.APP_STATE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
    L15:
        r0[ScreenEvent.EventType.ACCESSIBILITY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
    L7:
        a = r0;
    }
}

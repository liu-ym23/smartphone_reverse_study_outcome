package com.larus.community.impl.applet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public /* synthetic */ class AICreationAppletNavigator$c {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[AICreationAppletNavigator$AppletOpenSessionPolicy.values().length];
        r0[AICreationAppletNavigator$AppletOpenSessionPolicy.RESTORE_AI_CREATION_HOME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
    L13:
        r0[AICreationAppletNavigator$AppletOpenSessionPolicy.RETAIN_AI_CREATION_HOME_MEMORY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
    L19:
        r0[AICreationAppletNavigator$AppletOpenSessionPolicy.KEEP_CURRENT_STACK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
    L15:
        r0[AICreationAppletNavigator$AppletOpenSessionPolicy.RESET_STACK.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
    L7:
        a = r0;
    }
}

package com.larus.bmhome.interactionpanel.store;

import com.larus.bmhome.interactionpanel.InteractionPanelSource;
import com.larus.bmhome.interactionpanel.InteractionPanelSubmitResult;
import com.larus.bmhome.interactionpanel.source.InteractionPanelPayloadTarget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public /* synthetic */ class b$c {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;

    static {
        int[] r0 = new int[InteractionPanelPayloadTarget.values().length];
        r0[InteractionPanelPayloadTarget.MAIN_HOST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
    L29:
        r0[InteractionPanelPayloadTarget.THREAD_HOST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
    L6:
        a = r0;
        int[] r1 = new int[InteractionPanelSubmitResult.values().length];
        r1[InteractionPanelSubmitResult.FAILURE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
    L39:
        r1[InteractionPanelSubmitResult.SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
    L33:
        r1[InteractionPanelSubmitResult.CANCELLED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
    L11:
        b = r1;
        int[] r2 = new int[InteractionPanelSource.values().length];
        r2[InteractionPanelSource.MAIN_MESSAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
    L35:
        r2[InteractionPanelSource.GENERAL_INTERACTION_ASK_NOTIFY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
    L25:
        r2[InteractionPanelSource.THREAD_MESSAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
    L15:
        c = r2;
    }
}

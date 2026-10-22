package r3;

import com.bytedance.ai.applet.components.input.AppletChatPanelState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[AppletChatPanelState.values().length];
        r0[AppletChatPanelState.COLLAPSED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
    L13:
        r0[AppletChatPanelState.PREVIEW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
    L19:
        r0[AppletChatPanelState.EXPANDED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
    L15:
        r0[AppletChatPanelState.INVISIBLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
    L7:
        a = r0;
    }
}

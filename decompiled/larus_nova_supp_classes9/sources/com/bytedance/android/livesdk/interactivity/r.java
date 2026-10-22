package com.bytedance.android.livesdk.interactivity;

import com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.enums.PanelItemShowArea;
import com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.enums.PanelItemSymbol;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final /* synthetic */ class r {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[PanelItemShowArea.values().length];
        a = r0;
        r0[PanelItemShowArea.TOP.ordinal()] = 1;
        r0[PanelItemShowArea.MIDDLE.ordinal()] = 2;
        r0[PanelItemShowArea.BOTTOM.ordinal()] = 3;
        int[] r1 = new int[PanelItemSymbol.values().length];
        b = r1;
        r1[PanelItemSymbol.PIN_COMMENT_SYMBOL.ordinal()] = 1;
        r1[PanelItemSymbol.OPEN_PROFILE_SYMBOL.ordinal()] = 2;
        r1[PanelItemSymbol.SECRET_CHAT.ordinal()] = 3;
        r1[PanelItemSymbol.REPLY.ordinal()] = 4;
        r1[PanelItemSymbol.REPLY_AND_PIN_SYMBOL.ordinal()] = 5;
        r1[PanelItemSymbol.OPEN_VIDEO_SYMBOL.ordinal()] = 6;
        r1[PanelItemSymbol.OPEN_MICROAPP_SYMBOL.ordinal()] = 7;
        r1[PanelItemSymbol.LINK_MIC.ordinal()] = 8;
        r1[PanelItemSymbol.PIN_ROOMMESSAGE.ordinal()] = 9;
        r1[PanelItemSymbol.MARK_USER.ordinal()] = 10;
        r1[PanelItemSymbol.PUBLIC_SCREEN_STYLE_SYMBOL.ordinal()] = 11;
        r1[PanelItemSymbol.COMMENT_CONTROL_MODE.ordinal()] = 12;
        r1[PanelItemSymbol.CREATE_CHAT_CHANNEL.ordinal()] = 13;
        r1[PanelItemSymbol.PUBLIC_SCREEN_HELPER.ordinal()] = 14;
    }
}

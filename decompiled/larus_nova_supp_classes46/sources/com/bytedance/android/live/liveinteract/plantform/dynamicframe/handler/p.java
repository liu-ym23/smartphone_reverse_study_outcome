package com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler;

import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicGetType;
import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicUpdateType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final /* synthetic */ class p {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;
    public static final /* synthetic */ int[] d = null;
    public static final /* synthetic */ int[] e = null;

    static {
        int[] r0 = new int[DynamicUpdateType.values().length];
        a = r0;
        DynamicUpdateType r1 = DynamicUpdateType.GET_CLIENT_SETTINGS;
        r0[r1.ordinal()] = 1;
        DynamicUpdateType r2 = DynamicUpdateType.SWITCH_LAYOUT;
        r0[r2.ordinal()] = 2;
        DynamicUpdateType r4 = DynamicUpdateType.SETTING_PANEL_CLICK;
        r0[r4.ordinal()] = 3;
        DynamicUpdateType r6 = DynamicUpdateType.LINKMIC_SETTING_UPDATE;
        r0[r6.ordinal()] = 4;
        int[] r3 = new int[DynamicUpdateType.values().length];
        b = r3;
        DynamicUpdateType r8 = DynamicUpdateType.EDIT_MIC_POSITION;
        r3[r8.ordinal()] = 1;
        DynamicUpdateType r10 = DynamicUpdateType.FAST_MATCH;
        r3[r10.ordinal()] = 2;
        DynamicUpdateType r11 = DynamicUpdateType.OPEN_BEAUTY_PANEL;
        r3[r11.ordinal()] = 3;
        DynamicUpdateType r12 = DynamicUpdateType.UPDATE_ENLARGE_STATUS;
        r3[r12.ordinal()] = 4;
        DynamicUpdateType r13 = DynamicUpdateType.OPEN_CONTRIBUTION_LIST_PANEL;
        r3[r13.ordinal()] = 5;
        DynamicUpdateType r14 = DynamicUpdateType.INTERACT_PANEL_CLICK;
        r3[r14.ordinal()] = 6;
        int[] r5 = new int[DynamicUpdateType.values().length];
        c = r5;
        r5[DynamicUpdateType.APPLY.ordinal()] = 1;
        r5[DynamicUpdateType.APPLY_FAST_MATCH.ordinal()] = 2;
        r5[DynamicUpdateType.APPLY_PAID_PRIORITY.ordinal()] = 3;
        r5[DynamicUpdateType.FAST_MATCH_JUMP.ordinal()] = 4;
        r5[DynamicUpdateType.OPEN_SETTING_DIALOG.ordinal()] = 5;
        r5[DynamicUpdateType.UPDATE_WAITING_LIST_DATA.ordinal()] = 6;
        r5[DynamicUpdateType.AUDIENCE_APPLY_PANEL_LIFE_CYCLE.ordinal()] = 7;
        r5[DynamicUpdateType.MULTI_LINK_PANEL_LIFE_CYCLE.ordinal()] = 8;
        r5[DynamicUpdateType.LINK_SERVICE.ordinal()] = 9;
        r5[r1.ordinal()] = 10;
        r5[r2.ordinal()] = 11;
        r5[r6.ordinal()] = 12;
        r5[r4.ordinal()] = 13;
        r5[r8.ordinal()] = 14;
        r5[r10.ordinal()] = 15;
        r5[r11.ordinal()] = 16;
        r5[r12.ordinal()] = 17;
        r5[r13.ordinal()] = 18;
        r5[r14.ordinal()] = 19;
        int[] r7 = new int[DynamicGetType.values().length];
        d = r7;
        DynamicGetType r9 = DynamicGetType.INTERACT_PANEL_CONFIG;
        r7[r9.ordinal()] = 1;
        DynamicGetType r15 = DynamicGetType.KTV_ORDER_INFO;
        r7[r15.ordinal()] = 2;
        int[] r16 = new int[DynamicGetType.values().length];
        e = r16;
        r16[DynamicGetType.LINK_SERVICE.ordinal()] = 1;
        r16[DynamicGetType.SETTING_PANEL_CONFIG.ordinal()] = 2;
        r16[r9.ordinal()] = 3;
        r16[r15.ordinal()] = 4;
    }
}

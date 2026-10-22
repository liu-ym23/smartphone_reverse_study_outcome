package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/ToolbarBroadcastFunction;", "", "PAID_LIVE_TICKET", "COMMERCE", "TRANSFORM_WIDGET", "GROUP_PURCHASE", "MINI_APP", "WELFARE", "GAME_PROMOTE", "MIX_MINI_APP", "MINI_GAME", "LITTLE_GAME", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ToolbarBroadcastFunction extends Enum<ToolbarBroadcastFunction> {
    public static final ToolbarBroadcastFunction COMMERCE = null;
    public static final ToolbarBroadcastFunction GAME_PROMOTE = null;
    public static final ToolbarBroadcastFunction GROUP_PURCHASE = null;
    public static final ToolbarBroadcastFunction LITTLE_GAME = null;
    public static final ToolbarBroadcastFunction MINI_APP = null;
    public static final ToolbarBroadcastFunction MINI_GAME = null;
    public static final ToolbarBroadcastFunction MIX_MINI_APP = null;
    public static final ToolbarBroadcastFunction PAID_LIVE_TICKET = null;
    public static final ToolbarBroadcastFunction TRANSFORM_WIDGET = null;
    public static final ToolbarBroadcastFunction WELFARE = null;
    public static final /* synthetic */ ToolbarBroadcastFunction[] a = null;

    static {
        ToolbarBroadcastFunction r1 = new ToolbarBroadcastFunction("PAID_LIVE_TICKET", 0);
        PAID_LIVE_TICKET = r1;
        ToolbarBroadcastFunction r2 = new ToolbarBroadcastFunction("COMMERCE", 1);
        COMMERCE = r2;
        ToolbarBroadcastFunction r3 = new ToolbarBroadcastFunction("TRANSFORM_WIDGET", 2);
        TRANSFORM_WIDGET = r3;
        ToolbarBroadcastFunction r4 = new ToolbarBroadcastFunction("GROUP_PURCHASE", 3);
        GROUP_PURCHASE = r4;
        ToolbarBroadcastFunction r5 = new ToolbarBroadcastFunction("MINI_APP", 4);
        MINI_APP = r5;
        ToolbarBroadcastFunction r6 = new ToolbarBroadcastFunction("WELFARE", 5);
        WELFARE = r6;
        ToolbarBroadcastFunction r7 = new ToolbarBroadcastFunction("GAME_PROMOTE", 6);
        GAME_PROMOTE = r7;
        ToolbarBroadcastFunction r8 = new ToolbarBroadcastFunction("MIX_MINI_APP", 7);
        MIX_MINI_APP = r8;
        ToolbarBroadcastFunction r9 = new ToolbarBroadcastFunction("MINI_GAME", 8);
        MINI_GAME = r9;
        ToolbarBroadcastFunction r10 = new ToolbarBroadcastFunction("LITTLE_GAME", 9);
        LITTLE_GAME = r10;
        a = new ToolbarBroadcastFunction[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10};
    }

    public static ToolbarBroadcastFunction valueOf(String r1) {
        return (ToolbarBroadcastFunction) r27.a.a(ToolbarBroadcastFunction.class, r1);
    }

    public static ToolbarBroadcastFunction[] values() {
        return (ToolbarBroadcastFunction[]) a.clone();
    }

    public ToolbarBroadcastFunction(String r1, int r2) {
        super(r1, r2);
    }
}

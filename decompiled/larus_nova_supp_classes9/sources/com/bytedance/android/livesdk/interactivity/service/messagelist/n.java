package com.bytedance.android.livesdk.interactivity.service.messagelist;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final /* synthetic */ class n {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[IMessageListManager.MessageChangeType.values().length];
        a = r0;
        r0[IMessageListManager.MessageChangeType.INIT_LIST.ordinal()] = 1;
        r0[IMessageListManager.MessageChangeType.INSERT_BOTTOM.ordinal()] = 2;
        r0[IMessageListManager.MessageChangeType.INSERT_ITEM.ordinal()] = 3;
        r0[IMessageListManager.MessageChangeType.RELOAD_ALL.ordinal()] = 4;
        r0[IMessageListManager.MessageChangeType.REMOVE_RANGE.ordinal()] = 5;
    }
}

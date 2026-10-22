package com.bytedance.android.livesdk.interactivity.service.messagelist;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final /* synthetic */ class h {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[MessageListScrollManager.ScrollState.values().length];
        a = r0;
        r0[MessageListScrollManager.ScrollState.AutoScroll.ordinal()] = 1;
        r0[MessageListScrollManager.ScrollState.Focus.ordinal()] = 2;
        int[] r1 = new int[IMessageListManager.MessageChangeType.values().length];
        b = r1;
        r1[IMessageListManager.MessageChangeType.INSERT_ITEM.ordinal()] = 1;
        r1[IMessageListManager.MessageChangeType.REMOVE_RANGE.ordinal()] = 2;
    }
}

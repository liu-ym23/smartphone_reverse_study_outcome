package com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter;

import com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.FrequentChatShowMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final /* synthetic */ class f {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;

    static {
        int[] r0 = new int[FrequentChatShowMode.values().length];
        a = r0;
        FrequentChatShowMode r1 = FrequentChatShowMode.EDIT;
        r0[r1.ordinal()] = 1;
        FrequentChatShowMode r2 = FrequentChatShowMode.SORT;
        r0[r2.ordinal()] = 2;
        FrequentChatShowMode r4 = FrequentChatShowMode.READ;
        r0[r4.ordinal()] = 3;
        int[] r3 = new int[FrequentChatShowMode.values().length];
        b = r3;
        r3[r4.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
        r3[r1.ordinal()] = 3;
        int[] r5 = new int[FrequentChatShowMode.values().length];
        c = r5;
        r5[r4.ordinal()] = 1;
        r5[r2.ordinal()] = 2;
        r5[r1.ordinal()] = 3;
    }
}

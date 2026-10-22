package com.ss.android.lark.feed.shared.page.utils;

import com.bytedance.lark.pb.feed.v1.ThreadData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final /* synthetic */ class c {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[ThreadData.EntityType.values().length];
        r0[ThreadData.EntityType.THREAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L11:
        r0[ThreadData.EntityType.TOPIC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L15:
        r0[ThreadData.EntityType.MSG_THREAD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L6:
        a = r0;
    }
}

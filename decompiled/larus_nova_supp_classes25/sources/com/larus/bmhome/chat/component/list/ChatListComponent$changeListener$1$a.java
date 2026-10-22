package com.larus.bmhome.chat.component.list;

import com.larus.im.observer.MessageListState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public /* synthetic */ class ChatListComponent$changeListener$1$a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[MessageListState.values().length];
        r0[MessageListState.DELETE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
    L9:
        r0[MessageListState.REFRESH_ALL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
    L5:
        a = r0;
    }
}

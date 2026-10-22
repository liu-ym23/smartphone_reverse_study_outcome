package com.larus.common.account.douyin;

import androidx.lifecycle.MutableLiveData;
import com.larus.bmhome.auth.douyin.IAiChatOpenDouyinAuthService;
import com.larus.im.bean.message.Message;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a implements IAiChatOpenDouyinAuthService.b {
    public a() {
    }

    public final void a(boolean r4, Integer r5) {
        com.larus.common.account.douyin.ai.chat.a r0 = com.larus.common.account.douyin.ai.chat.a.a;
        if (r5 == null) goto L6;
        r5.intValue();
    L6:
        monitor-enter(r0);
        MutableLiveData<Message> r6 = com.larus.common.account.douyin.ai.chat.a.c;     // Catch: Throwable -> L14
        Message r1 = (Message) r6.getValue();     // Catch: Throwable -> L14
        r6.postValue(null);     // Catch: Throwable -> L14
        Iterator r7 = new ArrayList(com.larus.common.account.douyin.ai.chat.a.d).iterator();     // Catch: Throwable -> L14
    L9:
        if (r7.hasNext() == false) goto L12;
        ((ya8.a) r7.next()).a(r4, r1);     // Catch: Throwable -> L14
        goto L9
    L12:
        monitor-exit(r0);
        return;
    L14:
        th = move-exception;
        throw th;
    }
}

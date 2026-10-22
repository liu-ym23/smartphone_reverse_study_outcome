package com.ss.android.lark.newemoji.impl;

import com.bytedance.lark.pb.im.v1.Emoji;
import com.bytedance.lark.pb.im.v1.PushEmojis;
import com.bytedance.lark.rustclient.api.s;
import com.bytedance.lark.rustclient.api.t;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import io.reactivex.functions.Consumer;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ EmojiService2 a;

    public d(EmojiService2 r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        s r7 = (s) r6;
        Intrinsics.checkNotNull(r7);
        PushEmojis r8 = (PushEmojis) t.c(r7, EmojiService2$registerPushListener$1$1.INSTANCE);
        if (r8 == null) goto L23;
        EmojiService2 r0 = this.a;
        r0.getClass();
        Map<String, Emoji> r3 = r8.emojis;     // Catch: Exception -> L19
        Integer r9 = r8.version;     // Catch: Exception -> L19
        Log.i("EmojiService2", "onPushEmojis, version = " + r9 + ", map size = " + r3.size() + ", localVersion = " + r0.c.U9());     // Catch: Exception -> L19
        if (r9.intValue() <= r0.c.U9()) goto L24;
        Intrinsics.checkNotNull(r9);     // Catch: Exception -> L19
        int r2 = r9.intValue();     // Catch: Exception -> L19
        Intrinsics.checkNotNull(r3);     // Catch: Exception -> L19
        Set<qsb.a> r4 = r0.m(r2, r3);     // Catch: Exception -> L19
        if (r4 != null) goto L11;
    L14:
        boolean r5 = true;
    L15:
        if (r5 == false) goto L17;
        Log.i("EmojiService2", "onPushEmojis, nothing update");     // Catch: Exception -> L19
        return;
    L17:
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new c(r0, r4, r9));     // Catch: Exception -> L19
        return;
    L11:
        if (((HashSet) r4).isEmpty() == true) goto L14;
        r5 = false;
        goto L15
    L24:
        return;
    L19:
        e = move-exception;
        Log.e("EmojiService2", "onPushEmojis error", e);
        return;
    }
}

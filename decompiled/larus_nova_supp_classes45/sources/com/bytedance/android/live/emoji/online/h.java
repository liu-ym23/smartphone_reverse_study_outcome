package com.bytedance.android.live.emoji.online;

import bolts.Task;
import com.bytedance.android.live.core.log.ALogger;
import java.util.concurrent.Callable;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h<V> implements Callable {
    public final /* synthetic */ OnlineSmallEmojiResManager a;
    public final /* synthetic */ boolean b;

    public h(OnlineSmallEmojiResManager r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        OnlineSmallEmojiResManager r0 = this.a;
        boolean r1 = this.b;
        r0.getClass();
        String r2 = com.bytedance.android.live.emoji.utils.a.a().b.getString("key_small_emoji_md5", "");
        if (r2.length() != 0) goto L5;
        boolean r3 = true;
    L7:
        if (r3 == false) goto L10;
        ALogger.d("OnlineEmojiResManager", " preloadResourceInfo lastCacheMd5 empty");
        return;
    L10:
        if (r0.h == false) goto L13;
        if (r1 == true) goto L13;
        ALogger.d("OnlineEmojiResManager", " resource has loaded");
        return;
    L13:
        r0.h = true;
        r0.e = r2;
        r0.f = 1;
        Task.callInBackground(new f(r2)).continueWith(new g(r0, r2));
        return;
    L5:
        r3 = false;
        goto L7
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}

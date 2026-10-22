package com.bytedance.android.live.misc;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.emoji.AwemeEmojiProxy;
import com.bytedance.android.live.emoji.api.IAwemeEmojiProxy;
import com.bytedance.android.livesdk.performance.LiveSdkInitHelper;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class LiveService$$liveemojiimpl {

    public class a implements mc1.a.a<IService> {
        public a() {
        }
    }

    public LiveService$$liveemojiimpl() {
    }

    public static void oldRegisterService() {
    }

    public static void innerRegisterService() {
        jc1.k.l(IAwemeEmojiProxy.class, new AwemeEmojiProxy());
    }

    public static void lazyRegisterService() {
        a r0 = new a();
        mc1.a r2 = mc1.a.c.a;
        r2.getClass();
        mc1.a.b r4 = new mc1.a.b(r0);
        ((ConcurrentHashMap) r2.a).put(new Class[]{IAwemeEmojiProxy.class}[0], r4);
    }

    public static void registerService() {
        if (LiveSdkInitHelper.isEnableServiceOpt() == false) goto L5;
        lazyRegisterService();
    L6:
        oldRegisterService();
        return;
    L5:
        innerRegisterService();
        goto L6
    }
}

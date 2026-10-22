package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class z0 implements com.bytedance.android.livesdk.popup.manager.c {
    public final /* synthetic */ x0 a;
    public final /* synthetic */ boolean b;

    public static final class a implements Runnable {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r0 = com.bytedance.android.livesdk.interactivity.api.asr.utils.b.a;     // Catch: Throwable -> L4
            HashMap r1 = new HashMap();     // Catch: Throwable -> L4
            r1.put("room_id", com.bytedance.android.livesdk.interactivity.api.asr.utils.b.a());     // Catch: Throwable -> L4
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_voice_recognition_guide_bubble_show", r1, new Object[0]);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void waiting() {
    }

    public final void a() {
        this.a.f = null;
    }

    public final void b() {
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c("bubble show canOpenSettingDialog=" + this.b);
        MainThreadPostUtils.e(a.a);
    }

    public z0(x0 r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }
}

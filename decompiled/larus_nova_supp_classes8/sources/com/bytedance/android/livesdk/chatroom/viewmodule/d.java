package com.bytedance.android.livesdk.chatroom.viewmodule;

import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d extends g61.a.a {
    public final /* synthetic */ AudienceStickerWrapperWidget a;

    public static final class a implements Runnable {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            j70.f r0 = this.a.a.getElementType();     // Catch: Throwable -> L8
            if (r0 == null) goto L11;
            com.bytedance.android.livesdk.chatroom.ui.framework.a r1 = com.bytedance.android.livesdk.chatroom.ui.framework.utils.c.a(this.a.a.getComponentContext());     // Catch: Throwable -> L8
            if (r1 == null) goto L15;
            r1.vi(r0);     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public final boolean b() {
        Function0<Void> r0 = this.a.b;
        if (r0 == null) goto L5;
        r0.invoke();
        return true;
    L5:
        MainThreadPostUtils.b(new a(this));
        return true;
    }

    public d(AudienceStickerWrapperWidget r1) {
        this.a = r1;
    }
}

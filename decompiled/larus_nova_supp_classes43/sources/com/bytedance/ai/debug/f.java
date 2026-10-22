package com.bytedance.ai.debug;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface f {
    public static final a a = null;

    public static final class a implements f {
        public static final /* synthetic */ a b = null;

        static {
            b = new a();
        }

        public a() {
        }

        public final void a(View r10, boolean r11) {
            IAISDKDebugService.a.getClass();
            IAISDKDebugService.b r0 = IAISDKDebugService.Companion.c;
            if ((r0 instanceof IAISDKDebugService.b) == false) goto L5;
            IAISDKDebugService.b r1 = r0;
        L6:
            if (r1 == null) goto L9;
            r1.t(r10, r11);
            return;
        L9:
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    static {
        a = a.b;
    }
}

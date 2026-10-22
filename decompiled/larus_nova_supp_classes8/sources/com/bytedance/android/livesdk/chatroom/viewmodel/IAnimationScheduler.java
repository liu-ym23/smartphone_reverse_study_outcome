package com.bytedance.android.livesdk.chatroom.viewmodel;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.config.iw0;
import com.bytedance.android.livesdk.config.j11;
import com.bytedance.android.livesdk.config.pd;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface IAnimationScheduler {
    public static final Companion M0 = null;

    public static final class Companion {
        public static final /* synthetic */ Companion a = null;

        public Companion() {
        }

        static {
            a = new Companion();
        }

        public static boolean b() {
            Integer r0 = (Integer) iw0.a.getValue();
            if (r0 == null) goto L5;
            int r1 = r0.intValue();
        L6:
            if (r1 <= 0) goto L9;
            return true;
        L9:
            return false;
        L5:
            r1 = 0;
            goto L6
        }

        public static boolean c() {
            Integer r0 = (Integer) iw0.a.getValue();
            if (r0 == null) goto L5;
            int r1 = r0.intValue();
        L7:
            if (r1 <= 0) goto L9;
            boolean r2 = true;
        L23:
            j11 r3 = (j11) pd.a.getValue();     // Catch: Exception -> L16
            if (r3 == null) goto L15;
            if (r3.enable != true) goto L15;
        L18:
            boolean r4 = true;
        L19:
            if (r2 == true) goto L21;
            if (r4 == true) goto L21;
            return false;
        L21:
            return true;
        L15:
            r4 = false;
        L16:
            e = move-exception;
            SafetyGuard.a(null, e, "live animation center setting error.");
            goto L18
        L9:
            r2 = false;
            goto L23
        L5:
            r1 = 0;
            goto L7
        }

        public static IAnimationScheduler a(DataCenter r5) {
            IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
            ViewModel r1 = null;
            if (r0 == null) goto L9;
            o r6 = IRoomContextService.a.a(r0, r5, 0, 2);
            if (r6 == null) goto L9;
            com.bytedance.live.datacontext.j r7 = r6.x2();
            if (r7 == null) goto L9;
            ViewModel r8 = (ViewModel) r7.getValue();
        L11:
            if ((r8 instanceof IAnimationScheduler) == false) goto L15;
            r1 = r8;
        L15:
            return (IAnimationScheduler) r1;
        L9:
            r8 = null;
            goto L11
        }

        public static void d(DataCenter r4, final Function1 r5) {
            Intrinsics.checkNotNullParameter(r5, "callback");
            IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
            if (r0 == null) goto L10;
            o r6 = IRoomContextService.a.a(r0, r4, 0, 2);
            if (r6 == null) goto L11;
            com.bytedance.live.datacontext.j r7 = r6.x2();
            if (r7 == null) goto L12;
            r7.c(new IAnimationScheduler$Companion$use$1(r5));
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    static {
        M0 = Companion.a;
    }

    void enableShowAnim(boolean r1);

    void onToolbarLoaded();

    void registerListener(c r1);

    void requestAnimationAtOnce(a r1);

    void unRegisterListener(c r1);
}

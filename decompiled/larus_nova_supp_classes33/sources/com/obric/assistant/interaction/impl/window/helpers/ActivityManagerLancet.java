package com.obric.assistant.interaction.impl.window.helpers;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;
import com.obric.assistant.interaction.impl.window.WindowHost;
import me.ele.lancet.base.Origin;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class ActivityManagerLancet {
    private static final String TAG = "ActivityManagerLancet";

    public static class MoveTaskToFrontRunnable implements Runnable {
        private final int flags;

        @Override // java.lang.Runnable
        public void run() {
            com_obric_assistant_interaction_impl_window_helpers_ActivityManagerLancet$MoveTaskToFrontRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_obric_assistant_interaction_impl_window_helpers_ActivityManagerLancet$MoveTaskToFrontRunnable__run$___twin___() {
            WindowHost r0 = WindowHost.INSTANCE;
            boolean r1 = r0.isShowing();
            boolean r2 = r0.isStashed();
            FLogger.a.w(ActivityManagerLancet.TAG, "intercept moveTaskToFront with fake taskId=0, flags=" + this.flags + ", isShowing=" + r1 + ", isStashed=" + r2);
            r0.pop(WindowAnimationType.Slide);
        }

        public MoveTaskToFrontRunnable(int r1) {
            this.flags = r1;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_obric_assistant_interaction_impl_window_helpers_ActivityManagerLancet$MoveTaskToFrontRunnable_com_larus_apm_impl_protector_RunnableLancet_run(MoveTaskToFrontRunnable r1) {
            r1.com_obric_assistant_interaction_impl_window_helpers_ActivityManagerLancet$MoveTaskToFrontRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public ActivityManagerLancet() {
    }

    public static void handleFakeMoveTaskToFront(int r1) {
        t0.e(new MoveTaskToFrontRunnable(r1));
    }

    public void moveTaskToFront(int r1, int r2) {
        if (r1 == 0) goto L5;
        Origin.callVoid();
        return;
    L5:
        handleFakeMoveTaskToFront(r2);
    }
}

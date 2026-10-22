package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.ui.l9;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import com.ss.android.ugc.aweme.debug.LocalTestManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface IWidget extends q46.a, LifecycleOwnerCompat {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.IWidget$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static String $default$getLogTag(IWidget r0) {
            return r0.getClass().getName();
        }

        public static void INVOKEVIRTUAL_com_bytedance_android_livesdk_chatroom_viewmodule_IWidget_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(l9 r1) {
            if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
            DialogLancet.handleBlockedDialogShow(r1);
            return;
        L10:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
        L7:
            DialogLancet.beforeDialogShow(r1);
            r1.show();
            DialogLancet.afterDialogShow(r1);
        }

        public static void $default$logThrowable(IWidget r1, Throwable r2) {
            ALogger.stacktrace(6, r1.getLogTag(), r2.getStackTrace());
            LocalTestManager.a(new Class[]{wy.a.class});
        }

        public static void INVOKEINTERFACE_com_bytedance_android_livesdk_chatroom_viewmodule_IWidget_com_obric_assistant_interaction_impl_window_helpers_WindowManagerLancet_addView(WindowManager r0, View r1, ViewGroup.LayoutParams r2) {
            WindowManagerLancet.bindToAssistantWindowIfNeeded(r1, r2);
            r0.addView(r1, r2);
        }

        public static /* synthetic */ void lambda$logThrowable$0(WindowManager r0, View r1, View r2) {
            r0.removeView(r1);
        }
    }

    Context getContext();

    DataCenter getDataCenter();

    String getLogTag();
}

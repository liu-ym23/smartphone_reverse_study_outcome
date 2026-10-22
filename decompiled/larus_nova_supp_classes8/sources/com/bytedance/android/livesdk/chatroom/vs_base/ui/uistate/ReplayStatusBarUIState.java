package com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.DigHoleScreenUtil;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.livesdk.t8;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ReplayStatusBarUIState extends ir1.c {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/ui/uistate/ReplayStatusBarUIState$StatusBarType;", "", "Companion", "a", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface StatusBarType {
        public static final a Companion = null;
        public static final int STATUS_BAR_TYPE_HIDE = 1;
        public static final int STATUS_BAR_TYPE_SHOW = 0;
        public static final int STATUS_BAR_TYPE_TRANSPARENT = 2;

        public static final class a {
            public static final /* synthetic */ a a = null;

            public a() {
            }

            static {
                a = new a();
            }
        }

        static {
            Companion = a.a;
        }
    }

    public ReplayStatusBarUIState() {
    }

    public static View o(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static boolean q(FragmentActivity r6, boolean r7) {
        boolean r1 = true;
        if (r7 == false) goto L6;
    L16:
        int r8 = 1;
    L17:
        ALogger.d("ReplayStatusBarUIState", "statusBarType:statusBarType:" + r8 + ",landscapeScreen:" + r7);
        if (r8 == 0) goto L22;
        if (r8 == 2) goto L22;
        r1 = false;
    L22:
        ALogger.d("ReplayStatusBarUIState", "needShowStatusBar:needShow:" + r1 + ",landscapeScreen:" + r7);
        return r1;
    L6:
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L9;
        r8 = 2;
        goto L17
    L9:
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == false) goto L14;
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L14;
    L15:
        r8 = 0;
    L14:
        if (DigHoleScreenUtil.isNeedStatusBarAdapt(r6, true, false) == false) goto L16;
        goto L15
    }

    public static void p(FragmentActivity r3, Window r4, boolean r5) {
        if (q(r3, r5) == true) goto L32;
        if (r3 != null) goto L30;
        Window r6 = null;
    L23:
        t8.d(r6);     // Catch: Throwable -> L29
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.d().isSaas() == false) goto L37;
        ALogger.d("ReplayStatusBarUIState", "changeStatusBarVisibility:setFlags FLAG_FULLSCREEN");     // Catch: Throwable -> L29
        if (r4 == null) goto L38;
        r4.setFlags(1024, 1024);     // Catch: Throwable -> L29
        return;
    L39:
        return;
    L38:
        return;
    L37:
        return;
    L30:
        r6 = r3.getWindow();     // Catch: Throwable -> L29
        goto L23
    L32:
        t8.e(r3);     // Catch: Throwable -> L6
    L7:
        if (r4 == null) goto L16;
        View r7 = o(r4);
        if (StatusBarUtil.isStatusBarTransparent() == true) goto L11;
    L13:
        int r8 = o(r4).getSystemUiVisibility();
        com.bytedance.android.live.core.utils.statusbar.a.b.a();
        int r9 = r8 & (-1025);
    L14:
        r7.setSystemUiVisibility(r9);
        goto L16
    L11:
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.d().isSaas() == true) goto L13;
        int r10 = o(r4).getSystemUiVisibility();
        com.bytedance.android.live.core.utils.statusbar.a.b.a();
        r9 = r10 | 1024;
    L16:
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.d().isSaas() == false) goto L34;
        ALogger.d("ReplayStatusBarUIState", "changeStatusBarVisibility:clearFlags FLAG_FULLSCREEN");
        if (r4 == null) goto L35;
        r4.clearFlags(1024);
        return;
    L35:
        return;
    }

    public final int r(Context r3, DataCenter r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        int r0 = 0;
        Integer r6 = (Integer) r4.get("interaction_layer_margin_top", 0);
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == true) goto L5;
    L25:
        ALogger.d("ReplayStatusBarUIState", "topMargin:topMargin:" + r6 + ",landscapeScreen:" + r5 + ",isStatusBarTransparent:" + StatusBarUtil.isStatusBarTransparent() + ",STATUS_BAR_ADAPT_ENABLE:" + StatusBarUtil.STATUS_BAR_ADAPT_ENABLE + ",JUMP_FROM_LIVE_PLAY_ACTIVITY:" + StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY);
        return r6.intValue();
    L5:
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L25;
        if (StatusBarUtil.isStatusBarTransparent() == true) goto L9;
    L24:
        r6 = r0;
        goto L25
    L9:
        if (g() == false) goto L11;
        if (r5 == true) goto L24;
    L11:
        if (r3 == null) goto L22;
        boolean r7 = r3 instanceof Activity;
        if (r7 == false) goto L22;
        if (r7 == true) goto L16;
        Context r8 = null;
    L18:
        if (e5.j((Activity) r8) == false) goto L22;
        int r9 = StatusBarUtil.portraitStatusBarHeight;
        if (r9 <= 0) goto L22;
    L23:
        r0 = Integer.valueOf(r9);
        goto L24
    L16:
        r8 = r3;
    L22:
        r9 = StatusBarUtil.getStatusBarHeight(r3);
        StatusBarUtil.portraitStatusBarHeight = r9;
        goto L23
    }
}

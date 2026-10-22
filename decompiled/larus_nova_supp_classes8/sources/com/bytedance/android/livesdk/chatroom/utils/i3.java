package com.bytedance.android.livesdk.chatroom.utils;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.browser.jsbridge.event.RoomTopRightBannerEvent;
import com.bytedance.common.utility.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i3 {
    public static int a = 1;
    public static int b = 1;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r3) {
            float r4 = r3.getAnimatedFraction();
            ViewGroup.LayoutParams r0 = this.a.getLayoutParams();
            r0.width = (int) ((this.b * r4) + this.c);
            this.a.setLayoutParams(r0);
        }

        public a(View r1, int r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ int b;

        @Override // java.lang.Runnable
        public final void run() {
            boolean r0 = this.a;     // Catch: Throwable -> L7
            int r1 = this.b;     // Catch: Throwable -> L7
            if (r0 == false) goto L5;
            i3.b = r1;     // Catch: Throwable -> L7
        L12:
            return;
        L5:
            i3.a = r1;     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L15;
            throw th;
        }

        public b(boolean r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static int a(boolean r0) {
        if (r0 == false) goto L5;
        return b;
    L5:
        return a;
    }

    public static void b(final com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.d r3, final com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.g r4, final boolean r5) {
        if (((Boolean) com.bytedance.android.live.core.setting.v4.a.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        View r0 = r3.a;
        if (r0 != null) goto L8;
        return;
    L8:
        UIUtils.updateLayout(r0, com.bytedance.android.live.core.utils.s1.j(2131169110), -2);
        r3.a.post(new c3(r5, r3, r4));
    }

    public static void c(final com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.f r4, final com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.g r5, final boolean r6) {
        if (((Boolean) com.bytedance.android.live.core.setting.v4.a.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        View r0 = r4.b;
        View r1 = r4.c;
        if (r0 == null) goto L11;
        if (r1 == null) goto L12;
        UIUtils.updateLayoutMargin(r0, -3, -3, 0, -3);
        UIUtils.updateLayout(r1, 0, 0);
        r1.post(new d3(r6, r4, r5));
        return;
    L12:
        return;
    }

    public static void d(com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.f r3, com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.g r4, boolean r5) {
        View r0 = r3.c;
        if (r0 == null) goto L5;
        UIUtils.updateLayout(r0, com.bytedance.android.live.core.utils.s1.j(2131168878), -1);
    L5:
        r4.Yb(8);
        RoomTopRightBannerEvent r1 = new RoomTopRightBannerEvent();
        r1.setStatus(1);
        r1.setAnimationTime(250);
        View r6 = r3.b;
        r6.post(new e3(r1, r6, r5, r4));
    }

    public static void e(com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.d r1, final com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.g r2, final RoomTopRightBannerEvent r3, final boolean r4) {
        final View r5 = r1.a;
        if (r5 == null) goto L8;
        if (r2 == null) goto L9;
        r5.post(new f3(r3, r5, r4, r2));
        return;
    L9:
        return;
    }

    public static Animator f(View r3, RoomTopRightBannerEvent r4, int r5, boolean r6, long r7) {
        if (r3 != null) goto L5;
        return null;
    L5:
        int r8 = r4.getStatus();
        int r9 = -r5;
        if (r9 <= 0) goto L8;
        int r0 = com.bytedance.android.live.core.utils.s1.f(21.0f);
    L13:
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r1.addUpdateListener(new a(r3, r9, r0));
        r3.postDelayed(new b(r6, r8), r7);
        return r1;
    L8:
        r0 = r3.getLayoutParams().width;
        if (r0 != (-2)) goto L11;
    L12:
        r0 = r3.getWidth();
        goto L13
    L11:
        if (r0 != (-1)) goto L13;
        goto L12
    }
}

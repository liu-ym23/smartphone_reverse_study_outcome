package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.Window;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.message.model.TempStateAreaReachMessage;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class z3 {
    public static final /* synthetic */ int a = 0;

    public static final class a extends AnimatorListenerAdapter {
        public final /* synthetic */ View a;

        public a(View r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            ImageModel r4 = (ImageModel) com.bytedance.android.livesdk.sharedpref.g.c.getValue();
            ImageUtil.loadImage((ImageView) this.a, r4, 0);
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ AnimatorSet a;

        public b(AnimatorSet r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.start();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public static void e(View r3) {
        Intrinsics.checkNotNullParameter(r3, "iconView");
        if ((r3 instanceof HSImageView) == false) goto L6;
        HSImageView r0 = (HSImageView) r3;
        ObjectAnimator r1 = f(false, r0);
        ObjectAnimator r2 = f(true, r0);
        r1.addListener(new a(r3));
        AnimatorSet r4 = new AnimatorSet();
        r4.play(r1).before(r2);
        r3.postDelayed(new b(r4), 750);
        return;
    }

    public static void a(DataCenter r1, Window r2) {
        Intrinsics.checkNotNullParameter(r1, "dataCenter");
        if (r2 != null) goto L5;
        return;
    L5:
        if (com.bytedance.android.live.core.utils.z.e(r1, false) == false) goto L7;
        return;
    L7:
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == true) goto L9;
        return;
    L9:
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L20;
        com.bytedance.android.live.core.utils.statusbar.a.b.a();
        r2.addFlags(Integer.MIN_VALUE);
        r2.clearFlags(67108864);
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L14;
        r2.setStatusBarColor(0);
        return;
    L14:
        r2.setStatusBarColor(-16777216);
        return;
    }

    public static void c(DataCenter r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "dc");
        if (com.bytedance.android.live.core.utils.z.e(r6, false) == true) goto L18;
        HashMap r1 = new HashMap();
        String r3 = "1";
        if (((Boolean) r6.get("data_more_dialog_is_show_interact_more", Boolean.FALSE)).booleanValue() == false) goto L7;
        Object r2 = "1";
    L8:
        r1.put("is_connection_button", r2);
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(r6).isPaidLive() == true) goto L12;
        r3 = "0";
    L12:
        r1.put("is_paidlive", r3);
        r1.put("watch_paidlive_status", com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(r6).J0().q(r6));
        if (r7 == false) goto L15;
        String r8 = "portrait";
    L16:
        r1.put("vs_screen_type", r8);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_more_page_show", r1, new Object[]{am2.x.class, Room.class});
        return;
    L15:
        r8 = "landscape";
        goto L16
    L7:
        r2 = "0";
        goto L8
    }

    public static void d(DataCenter r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "dc");
        Room r5 = com.bytedance.android.live.core.utils.z.o(r3);
        HashMap r0 = new HashMap();
        User r1 = r5.getOwner();
        if (r1 == null) goto L6;
        String r2 = r1.getIdStr();
        if (r2 == null) goto L6;
    L7:
        r0.put("anchor_id", r2);
        r0.put("room_id", String.valueOf(r5.id));
        if (r4 == false) goto L10;
        String r6 = "animation";
    L11:
        r0.put("icon_type", r6);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_gift_icon_show", r0, new Object[0]);
        return;
    L10:
        r6 = "normal";
    L6:
        r2 = "0";
        goto L7
    }

    public static ObjectAnimator f(boolean r5, HSImageView r6) {
        if (r5 == true) goto L5;
        PropertyValuesHolder r7 = PropertyValuesHolder.ofFloat("scaleX", new float[]{1.0f, 0.8f, 0.6f, 0.4f, 0.2f, 0.0f});
        PropertyValuesHolder r0 = PropertyValuesHolder.ofFloat("scaleY", new float[]{1.0f, 0.8f, 0.6f, 0.4f, 0.2f, 0.0f});
        Interpolator r1 = PathInterpolatorCompat.create(1.0f, 1.0f, 0.0f, 0.0f);
    L6:
        ObjectAnimator r8 = ObjectAnimator.ofPropertyValuesHolder(r6, new PropertyValuesHolder[]{r7, r0});
        r8.setInterpolator(r1);
        r8.setDuration(300);
        return r8;
    L5:
        r7 = PropertyValuesHolder.ofFloat("scaleX", new float[]{0.0f, 0.2f, 0.4f, 0.6f, 0.8f, 1.0f});
        r0 = PropertyValuesHolder.ofFloat("scaleY", new float[]{0.0f, 0.2f, 0.4f, 0.6f, 0.8f, 1.0f});
        r1 = PathInterpolatorCompat.create(0.0f, 0.0f, 1.0f, 1.0f);
        goto L6
    }

    public static void b(DataCenter r6, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r7, boolean r8, boolean r9, int r10) {
        Intrinsics.checkNotNullParameter(r7, "button");
        ExtendedToolbarButton r0 = r7.m;
        ExtendedToolbarButton r2 = null;
        if ((r0 instanceof ExtendedToolbarButton.c) == true) goto L5;
        r0 = null;
    L5:
        ExtendedToolbarButton.c r1 = (ExtendedToolbarButton.c) r0;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.n != TempStateAreaReachMessage.ELEM_TYPE.OPEN_GAME.getType()) goto L42;
        LinkedHashMap r3 = new LinkedHashMap();
        r3.put("game_name", r7.f);
        ExtendedToolbarButton r4 = r7.m;
        if ((r4 instanceof ExtendedToolbarButton.c) == true) goto L13;
        r4 = null;
    L13:
        ExtendedToolbarButton.c r5 = (ExtendedToolbarButton.c) r4;
        if (r5 == null) goto L16;
        Long r11 = Long.valueOf(r5.m);
    L17:
        r3.put("game_id", String.valueOf(r11));
        r3.put("position", String.valueOf(r10));
        String r12 = "0";
        if (r8 == false) goto L20;
        Object r13 = "1";
    L21:
        r3.put("if_started_by_anchor", r13);
        r3.put("if_in_collection", "1");
        if (((ExtendedToolbarButton.c) r7.m).r == false) goto L24;
        r12 = "1";
    L24:
        r3.put("if_with_notification", r12);
        if (r9 == false) goto L27;
        String r14 = "in_gray";
    L28:
        r3.put("status", r14);
        ExtendedToolbarButton r15 = r7.m;
        if ((r15 instanceof ExtendedToolbarButton.c) == false) goto L32;
        r2 = r15;
    L32:
        ExtendedToolbarButton.c r16 = (ExtendedToolbarButton.c) r2;
        if (r16 == null) goto L37;
        String r17 = r16.o;
        if (r17 == null) goto L37;
        r3.put("game_category", r17);
    L37:
        if (r6 == null) goto L39;
        r3.put("room_live_type", String.valueOf(com.bytedance.android.live.broadcastgame.api.interactgame.j.a()));
    L39:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_game_audience_more_panel_game_show", r3, new Object[]{am2.x.class, Room.class});
        return;
    L27:
        r14 = "normal";
        goto L28
    L20:
        r13 = "0";
        goto L21
    L16:
        r11 = null;
        goto L17
    }
}

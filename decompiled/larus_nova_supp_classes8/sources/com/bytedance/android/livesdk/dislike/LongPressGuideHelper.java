package com.bytedance.android.livesdk.dislike;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.utils.k1;
import com.bytedance.android.livesdk.config.l70;
import com.bytedance.android.livesdk.log.filter.s0;
import com.bytedance.android.livesdk.utils.guide.LongPressGuideScene;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.DislikeConfig;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class LongPressGuideHelper {
    public static LongPressGuideScene a;
    public static Function1<? super String, Unit> b;
    public static int c;

    public static final class a implements Runnable {
        public final /* synthetic */ LongPressGuideView a;
        public final /* synthetic */ ViewGroup b;
        public final /* synthetic */ Function1 c;

        public a(LongPressGuideView r1, ViewGroup r2, Function1 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Function1 r0 = this.c;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            Unit r1 = (Unit) r0.invoke(this.a);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ Function1 a;

        public b(Function1 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (Intrinsics.areEqual(LongPressGuideHelper.b, this.a) == false) goto L9;
            this.a.invoke("autoDismiss");     // Catch: Throwable -> L6
            return;
        }
    }

    @JvmStatic
    public static final void a() {
        com.bytedance.android.livesdk.log.filter.o r0 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        String r3 = "";
        if (r0.getMap().containsKey("enter_from_merge") == false) goto L5;
        String r1 = (String) r0.getMap().get("enter_from_merge");
    L7:
        if (r0.getMap().containsKey("enter_method") == false) goto L9;
        String r4 = (String) r0.getMap().get("enter_method");
    L11:
        if (r0.getMap().containsKey("action_type") == false) goto L13;
        String r6 = (String) r0.getMap().get("action_type");
    L15:
        if (r0.getMap().containsKey("video_id") == false) goto L17;
        String r2 = (String) r0.getMap().get("video_id");
    L19:
        if (tb1.c.a == false) goto L21;
        r1 = k1.c();
    L21:
        HashMap r8 = new HashMap();
        r8.put("enter_from_merge", r1);
        r8.put("enter_method", r4);
        r8.put("action_type", r6);
        r8.put("event_page", "live_detail");
        r8.put("video_id", r2);
        s0 r5 = com.bytedance.android.livesdk.log.u.l().c(Room.class);
        if ((r5 instanceof s0) == false) goto L32;
        s0 r7 = r5;
        Map r9 = ((com.bytedance.android.livesdk.log.filter.a) r7).b;
        if (r9 == null) goto L32;
        if (r9.containsKey("anchor_id") != true) goto L32;
        String r10 = (String) ((com.bytedance.android.livesdk.log.filter.a) r7).b.get("anchor_id");
        if (r10 == null) goto L31;
        r3 = r10;
    L31:
        r8.put("to_user_id", r3);
    L32:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_feedback_entrance_long_press_notice", r8, new Object[]{am2.x.class, Room.class, am2.n.f()});
        return;
    L17:
        r2 = "";
        goto L19
    L13:
        r6 = "";
        goto L15
    L9:
        r4 = "";
        goto L11
    L5:
        r1 = "";
        goto L7
    }

    static {
    }

    @JvmStatic
    public static final void b(final ViewGroup r11, final Function1<? super View, Unit> r12) {
        if (r11 == null) goto L29;
        com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.b.Y;
        Boolean r1 = (Boolean) r0.getValue();
        Boolean r2 = Boolean.TRUE;
        if (Intrinsics.areEqual(r1, r2) == false) goto L6;
        return;
    L6:
        if (com.bytedance.android.livesdk.model.b.a().getStyle() == 0) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == true) goto L12;
        return;
    L12:
        if ((System.currentTimeMillis() - in1.b.b) > 3000) goto L14;
        c++;
    L15:
        int r4 = c;
        DislikeConfig r5 = com.bytedance.android.livesdk.model.b.a();
        if (r5 != null) goto L18;
        return;
    L18:
        if (r4 == r5.getSkipTimes()) goto L20;
        return;
    L20:
        if (((Boolean) l70.a.getValue()).booleanValue() == true) goto L22;
        Context r6 = r11.getContext();
        if (r6 != null) goto L27;
        return;
    L27:
        LongPressGuideView r7 = new LongPressGuideView(r6, null, 6, 0);
        r11.addView(r7, new ViewGroup.LayoutParams(-1, -1));
        r7.setClickCallback(new LongPressGuideHelper$notifyExitRoomByScroll$$inlined$apply$lambda$1(r11, r12));
        r7.setDesc(2131920135);
        r7.postDelayed(new a(r7, r11, r12), com.bytedance.android.livesdk.model.b.a().getDisappearTime());
        a();
        com.bytedance.android.livesdk.sharedpref.f.d(r0, r2);
        return;
    L22:
        if (c(LongPressGuideScene.RECOMMEND_LIVE, r11, s1.B(2131920135), new LongPressGuideHelper$notifyExitRoomByScroll$1(r12), com.bytedance.android.livesdk.model.b.a().getDisappearTime()) == false) goto L33;
        a();
        com.bytedance.android.livesdk.sharedpref.f.d(r0, r2);
        return;
    L33:
        return;
    L14:
        c = 0;
        goto L15
    L8:
        r3 = false;
        goto L9
    }

    @JvmStatic
    public static final boolean c(final LongPressGuideScene r6, final ViewGroup r7, CharSequence r8, final Function1<? super View, Unit> r9, long r10) {
        Intrinsics.checkNotNullParameter(r6, "scene");
        if (r7 != null) goto L5;
        return false;
    L5:
        LongPressGuideScene r1 = a;
        if (r1 != null) goto L8;
    L14:
        a = r6;
        final LongPressGuideView r2 = new LongPressGuideView(r7.getContext(), null, 6, 0);
        r7.addView(r2, new ViewGroup.LayoutParams(-1, -1));
        r2.setDesc(r8);
        final Function1<String, Unit> r11 = new LongPressGuideHelper$show$dismissCallback$1(r2, r7, r6);
        b = r11;
        r2.setClickCallback(new LongPressGuideHelper$show$1(r11, r9, r2));
        r2.postDelayed(new b(r11), r10);
        ALogger.i("LongPressGuideHelper", "show. scene=" + r6 + " dismissDelay=" + r10);
        return true;
    L8:
        if (r6.getPriority() > r1.getPriority()) goto L11;
        ALogger.i("LongPressGuideHelper", "failed to show. scene=" + r6 + " curScene=" + r1);
        return false;
    L11:
        Function1<? super String, Unit> r3 = b;
        if (r3 == null) goto L14;
        Unit r4 = (Unit) r3.invoke("interrupt by " + r6);
        goto L14
    }
}

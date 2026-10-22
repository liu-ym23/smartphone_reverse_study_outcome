package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenConst;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.chatroom.widget.SlideGuideView;
import com.bytedance.android.livesdk.chatroom.widget.TapGuideView;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenHelper;
import com.bytedance.android.livesdk.w8;
import com.bytedance.android.livesdk.widget.GestureDetectLayout;
import com.bytedance.android.livesdk.widget.n3;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/GestureGuideCompositeWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Ljo1/f;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GestureGuideCompositeWidget extends MiddlewareRoomWidget implements jo1.f {
    public b a;
    public a b;
    public com.bytedance.android.livesdk.chatroom.ui.framework.c c;
    public com.bytedance.android.livesdk.chatroom.ui.framework.d d;
    public TapGuideView e;

    public static final class a implements Runnable {
        public final /* synthetic */ GestureGuideCompositeWidget a;

        public a(GestureGuideCompositeWidget r1) {
            this.a = r1;
        }

        public final void a() {
            com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a.c;
            if (r0 == null) goto L5;
            Room r1 = r0.getRoom();
        L7:
            if (r1 == null) goto L16;
            com.bytedance.android.livesdk.chatroom.ui.framework.c r2 = this.a.c;
            if (r2 == null) goto L11;
            Room r3 = r2.getRoom();
        L12:
            if (r3 == null) goto L16;
            if (r3.isVrRoom() != true) goto L16;
            return;
        L11:
            r3 = null;
        L16:
            DataCenter r4 = ((Widget) this.a).dataCenter;
            if (r4 == null) goto L19;
            boolean r5 = ClearScreenHelper.h(r4);
        L20:
            if (r5 == false) goto L28;
            RoomContext r6 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r6 == null) goto L27;
            com.bytedance.live.datacontext.m r7 = r6.isInZoom();
            if (r7 == null) goto L27;
            if (((Boolean) r7.getValue()).booleanValue() == true) goto L28;
        L27:
            w8 r8 = new w8(n3.a, s1.B(2131915819));
            r8.e = 10L;
            r8.d = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/clear_screen_scale_guide.webp";
            r8.a = "live.pref.PREF_CLEARSCREEN_ZOOM_GUIDE";
            r8.b = 1;
            xs2.b.a().post(r8);
        L28:
            ALogger.d("ZOOM_GUIDE_TAG", "发送LiveShowGuideEvent，展示Guide");
            return;
        L19:
            r5 = false;
            goto L20
        L5:
            r1 = null;
            goto L7
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ GestureGuideCompositeWidget a;
        public final /* synthetic */ SharedPrefHelper b;

        public static final class a implements SlideGuideView.e {
            public final /* synthetic */ b a;

            public a(b r1) {
                this.a = r1;
            }

            @Override // com.bytedance.android.livesdk.chatroom.widget.SlideGuideView.e
            public final void onClick() {
                TapGuideView r0 = this.a.a.e;
                boolean r1 = false;
                if (r0 == null) goto L5;
                r0.setClickable(false);
            L5:
                GestureGuideCompositeWidget.wq(this.a.a);
                int r2 = gs1.a.a;
                DataCenter r3 = this.a.a.getDataCenter();
                if (r3 == null) goto L8;
                String r4 = com.bytedance.android.live.core.utils.a0.p(r3);
            L9:
                com.bytedance.android.livesdk.clearscreen.h r5 = gs1.a.a(r4);
                if (r5 == null) goto L18;
                com.bytedance.android.livesdk.chatroom.ui.framework.c r6 = this.a.a.c;
                if (r6 != null) goto L14;
            L16:
                r5.c(r1);
                return;
            L14:
                if (r6.dg() != true) goto L16;
                r1 = true;
                goto L16
            L18:
                return;
            L8:
                r4 = null;
                goto L9
            }
        }

        public b(GestureGuideCompositeWidget r1, SharedPrefHelper r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            SharedPrefHelper r0 = this.b;
            r0.l("live.pref.SHOW_CLEARSCREEN_MODE_CHECK_TIPS", 1);
            r0.a();
            GestureGuideCompositeWidget r1 = this.a;
            ClearScreenConst.GuideType r2 = ClearScreenConst.GuideType.CLEAR_MODE_CHECK;
            a r3 = new a(this);
            if (r1.e == null) goto L7;
            ViewGroup r4 = r1.xq();
            if (r4 == null) goto L7;
            r4.removeView(r1.e);
        L7:
            Context r5 = r1.getContext();
            if (r5 == null) goto L49;
            Integer r6 = wt2.a.a;
            TapGuideView r7 = new TapGuideView(r5);
            r1.e = r7;
            r7.a(r2);
            int r8 = k.a[r2.ordinal()];
            if (r8 != 1) goto L12;
            TapGuideView r9 = r1.e;
            if (r9 == null) goto L23;
            r9.setMultiLine(true);
        L23:
            TapGuideView r10 = r1.e;
            if (r10 == null) goto L26;
            r10.setAnimResourceGecko("tap_check_mode.zip");
        L26:
            RoomContext.a r11 = RoomContext.Companion;
            if (RoomContext.a.c(r11, null, 0, 3) == null) goto L37;
            RoomContext r12 = RoomContext.a.c(r11, null, 0, 3);
            if (r12 == null) goto L37;
            com.bytedance.live.datacontext.m r13 = r12.getCleanMode();
            if (r13 == null) goto L37;
            if (((Number) r13.getValue()).intValue() != ClearScreenConst.InteractType.PURE_CLEAR.getId()) goto L37;
            TapGuideView r14 = r1.e;
            if (r14 == null) goto L40;
            r14.setDestText(s1.B(2131915820));
        L40:
            TapGuideView r15 = r1.e;
            if (r15 == null) goto L43;
            r15.e();
        L43:
            TapGuideView r16 = r1.e;
            if (r16 == null) goto L46;
            r16.setClickListener(r3);
        L46:
            ViewGroup r17 = r1.xq();
            if (r17 == null) goto L49;
            r17.addView(r1.e);
        L37:
            TapGuideView r18 = r1.e;
            if (r18 == null) goto L40;
            r18.setDestText(s1.B(2131915821));
            goto L40
        L12:
            if (r8 != 2) goto L40;
            ALogger.d("CLEAR_GUIDE_TAG", "展示清屏引导");
            TapGuideView r19 = r1.e;
            if (r19 == null) goto L17;
            r19.setAnimResourceGecko("swipe_right.zip");
        L17:
            TapGuideView r20 = r1.e;
            if (r20 == null) goto L40;
            r20.setDestText("");
        L49:
            long r21 = 5000;
            ViewGroup r22 = r1.xq();
            if (r22 == null) goto L53;
            r22.postDelayed(new l(r1), r21);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final /* synthetic */ void onAbilityClear() {
        IAbility.-CC.$default$onAbilityClear(this);
    }

    public final ViewGroup xq() {
        com.bytedance.android.livesdk.chatroom.ui.framework.d r0 = this.d;
        if (r0 == null) goto L5;
        GestureDetectLayout r1 = r0.oh();
    L7:
        if ((r1 instanceof ViewGroup) == true) goto L10;
        return null;
    L10:
        return r1;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        h70.b r0 = getComponentContext();
        if (r0 == null) goto L5;
        ho1.a.p(r0, jo1.f.class, this);
    L5:
        this.c = ho1.a.d(getComponentContext());
        this.d = ho1.a.i(getComponentContext());
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        if (xq() != null) goto L5;
    L14:
        this.a = null;
        this.b = null;
        h70.b r0 = getComponentContext();
        if (r0 == null) goto L18;
        ho1.a.q(r0, jo1.f.class);
        return;
    L18:
        return;
    L5:
        if (this.a == null) goto L10;
        ViewGroup r1 = xq();
        if (r1 == null) goto L10;
        r1.removeCallbacks(this.a);
    L10:
        if (this.b == null) goto L14;
        ViewGroup r2 = xq();
        if (r2 == null) goto L14;
        r2.removeCallbacks(this.b);
        goto L14
    }

    public GestureGuideCompositeWidget() {
    }

    public static final void wq(GestureGuideCompositeWidget r4) {
        TapGuideView r0 = r4.e;
        if (r0 == null) goto L7;
        r0.f();
        ViewGroup r1 = r4.xq();
        if (r1 == null) goto L7;
        r1.postDelayed(new m(r4), 320);
    L7:
        com.bytedance.android.livesdk.e.b().d();
        Integer r5 = wt2.a.a;
    }

    @Override // jo1.f
    public final void J5(int r7) {
        if (r7 != 8) goto L19;
        Lazy r2 = ClearScreenHelper.a;
        if (ClearScreenHelper.h(((Widget) this).dataCenter) == false) goto L19;
        if (SharedPrefHelper.b(getContext()).h("live.pref.PREF_CLEARSCREEN_ZOOM_GUIDE", 0) == 0) goto L9;
    L25:
        if (r7 != 8) goto L49;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r8 = this.c;
        if (r8 == null) goto L31;
        boolean r1 = true;
        if (r8.dg() != true) goto L31;
    L33:
        if (wt2.a.e(Boolean.valueOf(r1)) == false) goto L49;
        if (wt2.a.c() == false) goto L49;
        SharedPrefHelper r9 = SharedPrefHelper.b(getContext());
        if (r9.h("live.pref.SHOW_CLEARSCREEN_MODE_CHECK_TIPS", 0) == 0) goto L39;
        return;
    L39:
        if (xq() != null) goto L41;
    L45:
        this.a = new b(this, r9);
        ViewGroup r10 = xq();
        if (r10 == null) goto L57;
        r10.postDelayed(this.a, 6000);
        return;
    L57:
        return;
    L41:
        if (this.a == null) goto L45;
        ViewGroup r0 = xq();
        if (r0 == null) goto L45;
        r0.removeCallbacks(this.a);
    L31:
        r1 = false;
    L49:
        if (xq() != null) goto L51;
        return;
    L51:
        if (this.a == null) goto L60;
        ViewGroup r11 = xq();
        if (r11 == null) goto L61;
        r11.removeCallbacks(this.a);
        return;
    L61:
        return;
    L60:
        return;
    L9:
        if (xq() != null) goto L11;
    L15:
        this.b = new a(this);
        ViewGroup r3 = xq();
        if (r3 == null) goto L25;
        r3.postDelayed(this.b, 30000);
        goto L25
    L11:
        if (this.b == null) goto L15;
        ViewGroup r4 = xq();
        if (r4 == null) goto L15;
        r4.removeCallbacks(this.b);
    L19:
        if (xq() == null) goto L25;
        if (this.b == null) goto L25;
        ViewGroup r5 = xq();
        if (r5 == null) goto L25;
        r5.removeCallbacks(this.b);
        goto L25
    }
}

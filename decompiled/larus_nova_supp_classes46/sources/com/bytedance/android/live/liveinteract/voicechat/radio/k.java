package com.bytedance.android.live.liveinteract.voicechat.radio;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.u1;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager;
import com.bytedance.android.live.liveinteract.utils.LynxJSRegisterUtil$registerImWrdsMessage$1;
import com.bytedance.android.live.liveinteract.utils.n0;
import com.bytedance.android.live.liveinteract.utils.o0;
import com.bytedance.android.live.liveinteract.utils.q0;
import com.bytedance.android.live.liveinteract.utils.w0;
import com.bytedance.android.live.liveinteract.videotalk.utils.b0;
import com.bytedance.android.livesdk.chatroom.model.interact.SubtitleEventType;
import com.bytedance.android.livesdk.config.pb0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.LiveRadioGiftCommentWallConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k {
    public jk0.e a;
    public com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c b;
    public final AtomicBoolean c;
    public boolean d;
    public boolean e;
    public final Context f;
    public final IRoom g;
    public final DataCenter h;
    public final ViewGroup i;
    public final com.bytedance.android.live.liveinteract.plantform.dynamicframe.b j;
    public final int k;
    public final ih0.b l;

    public static final class a implements Runnable {
        public final /* synthetic */ FrameLayout.LayoutParams a;
        public final /* synthetic */ View b;
        public final /* synthetic */ k c;

        public a(FrameLayout.LayoutParams r1, View r2, k r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            Integer r0 = Integer.valueOf(this.c.i.getWidth());
            if (r0.intValue() <= 0) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == true) goto L9;
            r0 = null;
        L9:
            if (r0 == null) goto L11;
            int r2 = r0.intValue();
        L12:
            ALogger.i("RadioStageContainerWidget", "adapterSize !isPortrait width:" + r2);
            FrameLayout.LayoutParams r3 = this.a;
            int r4 = r2 / 4;
            r3.leftMargin = r4;
            r3.rightMargin = r4;
            this.b.setLayoutParams(r3);
            return;
        L11:
            r2 = s1.y();
            goto L12
        L5:
            r1 = false;
            goto L6
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

    public final boolean b() {
        if (this.c.get() == true) goto L7;
        return false;
    L7:
        return true;
    }

    public final void c() {
        int r0 = w0.a;
        if (w0.d(this.g) == false) goto L10;
        IInteractService r1 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r1 == null) goto L9;
        ih0.b r2 = r1.dynamicService(this.h);
        if (r2 == null) goto L9;
        ih0.c r3 = r2.oo();
    L11:
        if (r3 == null) goto L20;
        View r4 = r3.getHybridView();
        if (r4 != null) goto L15;
        return;
    L15:
        if (r4.getVisibility() != 0) goto L22;
        View r5 = r3.getHybridView();
        if (r5 == null) goto L23;
        UtilityKotlinExtentionsKt.u(r5);
        return;
    L23:
        return;
    L22:
        return;
    L20:
        return;
    L9:
        r3 = null;
        goto L11
    L10:
        r3 = this.b;
        goto L11
    }

    public final void d() {
        ALogger.i("RadioStageContainerWidget", "onSubtitleStateStart onStart--");
        this.d = true;
        h("subtitle");
        JsonObject r0 = new JsonObject();
        r0.addProperty("type", Integer.valueOf(SubtitleEventType.STATE_START.ordinal()));
        f(r0);
    }

    public final void e() {
        ALogger.i("RadioStageContainerWidget", "onSubtitleStateStop onStop--");
        this.d = false;
        JsonObject r0 = new JsonObject();
        r0.addProperty("type", Integer.valueOf(SubtitleEventType.STATE_STOP.ordinal()));
        f(r0);
        i("subtitle");
    }

    public final void g() {
        int r0 = w0.a;
        if (w0.d(this.g) == false) goto L10;
        IInteractService r1 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r1 == null) goto L9;
        ih0.b r2 = r1.dynamicService(this.h);
        if (r2 == null) goto L9;
        ih0.c r3 = r2.oo();
    L11:
        if (r3 == null) goto L16;
        View r4 = r3.getHybridView();
        if (r4 == null) goto L16;
        if (r4.getVisibility() != 0) goto L16;
        return;
    L16:
        if (r3 == null) goto L22;
        View r5 = r3.getHybridView();
        if (r5 == null) goto L23;
        UtilityKotlinExtentionsKt.w(r5);
        return;
    L23:
        return;
    L22:
        return;
    L9:
        r3 = null;
        goto L11
    L10:
        r3 = this.b;
        goto L11
    }

    public final Context getContext() {
        return this.f;
    }

    public final void a(boolean r4) {
        int r0 = w0.a;
        if (w0.d(this.g) == false) goto L10;
        IInteractService r1 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r1 == null) goto L9;
        ih0.b r2 = r1.dynamicService(this.h);
        if (r2 == null) goto L9;
        ih0.c r3 = r2.oo();
    L11:
        if (r3 == null) goto L22;
        View r5 = r3.S0();
        if (r5 == null) goto L23;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if (r6 == null) goto L21;
        FrameLayout.LayoutParams r7 = (FrameLayout.LayoutParams) r6;
        if (r4 == true) goto L19;
        this.i.post(new a(r7, r5, this));
        return;
    L19:
        r7.leftMargin = s1.f(0.0f);
        r7.rightMargin = s1.f(0.0f);
        r5.setLayoutParams(r7);
        return;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L23:
        return;
    L22:
        return;
    L9:
        r3 = null;
        goto L11
    L10:
        r3 = this.b;
        goto L11
    }

    public final void f(JsonObject r5) {
        int r0 = w0.a;
        if (w0.d(this.g) == true) goto L7;
        JsonObject r1 = new JsonObject();
        r1.add("data", r5);
        r1.addProperty("type", "subtitle");
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r6 = this.b;
        if (r6 == null) goto L11;
        r6.sendJsEvent("onLinkmicStatusChange", r1);
        return;
    L11:
        return;
    L7:
        ih0.b r2 = this.l;
        if (r2 == null) goto L13;
        r2.Dk("radio", "subtitle", r5, false);
        return;
    }

    public final void h(String r14) {
        ALogger.i("RadioStageContainerWidget", "tryLoadMainCard start--".concat(r14));
        boolean r2 = false;
        if (this.c.compareAndSet(false, true) == false) goto L58;
        ALogger.i("RadioStageContainerWidget", "real LoadMainCard--".concat(r14));
        int r0 = w0.a;
        if (w0.d(this.g) == true) goto L54;
        DataCenter r1 = this.h;
        if (r1 == null) goto L54;
        Context r4 = this.f;
        int r6 = 108;
        if (((Boolean) pb0.a.getValue()).booleanValue() == true) goto L11;
    L13:
        int r7 = (r6 + 120) - 19;
        int r5 = e.a;
        u1 r8 = u1.a;
        String r9 = ((LiveRadioGiftCommentWallConfig) r8.getValue()).getTextContainerUrl();
        if (r9 != null) goto L16;
        r9 = "http://10.71.189.224:60006/pages/radio_message_text_contaienr/template.js?business_type=livelinkmic&business_group=livelinkmic";
    L16:
        Uri.Builder r10 = UriProtector.parse(r9).buildUpon();
        r10.appendQueryParameter("avatar_bottom", String.valueOf(r7));
        if (r14.equals("subtitle") == false) goto L19;
        r10.appendQueryParameter("subtitle_state", "1");
    L19:
        ALogger.i("RadioStageContainerWidget", "loadMessageMainCard initGuestSize:" + this.k);
        int r11 = this.k;
        AnnieXLynxView r12 = null;
        if (r11 <= 0) goto L23;
        r10.appendQueryParameter("radiolink_guest_size", String.valueOf(r11 - 1));
    L36:
        String r13 = r10.build().toString();
        String r15 = ((LiveRadioGiftCommentWallConfig) r8.getValue()).getTextContainerSchema();
        if (r15 != null) goto L39;
        r15 = "sslocal://webcast_lynxview?business_type=livelinkmic&business_group=livelinkmic&initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D";
    L39:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r16 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.q.b(r4, UriProtector.parse(r15).buildUpon().appendQueryParameter("url", r13).build(), new l(r9), System.currentTimeMillis(), r1, 32);
        int r17 = q0.a;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.b r18 = this.j;
        Intrinsics.checkNotNullParameter(r1, "dataCenter");
        r16.registerMethod("registerMessage", new LynxJSRegisterUtil$registerImWrdsMessage$1(r1, r18));
        r16.r1();
        r16.registerMethod("registerMessageLatch", new n0(r1));
        r16.registerMethod("registerWrds", new o0(r18, r1));
        ih0.c.a.a(r16, null, null, 7);
        this.b = r16;
        FrameLayout r3 = (FrameLayout) this.i.findViewById(2131370477);
        if (r3 == null) goto L42;
        r3.setVisibility(0);
    L42:
        ViewGroup.LayoutParams r19 = new ViewGroup.LayoutParams(-1, -1);
        if (r3 == null) goto L49;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r20 = this.b;
        if (r20 == null) goto L47;
        r12 = r20.h;
    L47:
        r3.addView(r12, r19);
    L49:
        if (this.f.getResources().getConfiguration().orientation != 1) goto L51;
        r2 = true;
    L51:
        ALogger.i("RadioStageContainerWidget", "loadMessageMainCard isPortrait:" + r2);
        if (r2 == true) goto L54;
        a(r2);
        goto L54
    L23:
        if (e.a() == false) goto L36;
        tf0.o r21 = b0.e();
        if ((r21 instanceof BaseMultiLinkWindowManager) == true) goto L27;
        r21 = null;
    L27:
        BaseMultiLinkWindowManager r22 = (BaseMultiLinkWindowManager) r21;
        if (r22 == null) goto L36;
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r23 = r22.h;
        if (r23 == null) goto L36;
        BehaviorSubject<List<tf0.e>> r24 = r23.b;
        if (r24 == null) goto L36;
        List r25 = (List) r24.getValue();
        if (r25 == null) goto L36;
        r10.appendQueryParameter("radiolink_guest_size", String.valueOf(r25.size() - 1));
        goto L36
    L11:
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L13;
        r6 = 108 + ((int) s1.G(StatusBarUtil.getStatusBarHeight(s1.getContext())));
    L54:
        jk0.e r26 = this.a;
        if (r26 == null) goto L59;
        r26.onStart(r14);
        return;
    L59:
        return;
    }

    public final void i(String r4) {
        ALogger.i("RadioStageContainerWidget", "tryUnLoadMainCard--".concat(r4));
        if (this.d == false) goto L5;
        return;
    L5:
        if (this.e == true) goto L38;
        ALogger.i("RadioStageContainerWidget", "real--unloadMessageMainCard");
        int r5 = w0.a;
        View r0 = null;
        if (w0.d(this.g) == false) goto L14;
        IInteractService r6 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r6 == null) goto L13;
        ih0.b r7 = r6.dynamicService(this.h);
        if (r7 == null) goto L13;
        ih0.c r8 = r7.oo();
    L15:
        if (r8 == null) goto L17;
        r8.release();
    L17:
        if (r8 == null) goto L21;
        View r1 = r8.S0();
        if (r1 == null) goto L21;
        ViewParent r2 = r1.getParent();
    L23:
        if ((r2 instanceof ViewGroup) == true) goto L25;
        r2 = null;
    L25:
        ViewGroup r3 = (ViewGroup) r2;
        if (r3 == null) goto L30;
        if (r8 == null) goto L29;
        r0 = r8.S0();
    L29:
        r3.removeView(r0);
    L30:
        this.c.set(false);
        FrameLayout r9 = (FrameLayout) this.i.findViewById(2131370477);
        if (r9 == null) goto L33;
        r9.setVisibility(8);
    L33:
        jk0.e r10 = this.a;
        if (r10 == null) goto L39;
        r10.onStop();
        return;
    L39:
        return;
    L21:
        r2 = null;
    L13:
        r8 = null;
        goto L15
    L14:
        r8 = this.b;
        goto L15
    }

    public k(Context r4, IRoom r5, DataCenter r6, ViewGroup r7, com.bytedance.android.live.liveinteract.plantform.dynamicframe.b r8, int r9, ih0.b r10, int r11) {
        if ((r11 & 32) == 0) goto L6;
        r8 = null;
    L6:
        if ((r11 & 64) == 0) goto L9;
        r9 = 0;
    L9:
        if ((r11 & 128) == 0) goto L11;
        r10 = null;
    L11:
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r7, "mLinkRootView");
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.i = r7;
        this.j = r8;
        this.k = r9;
        this.l = r10;
        this.c = new AtomicBoolean(false);
    }
}

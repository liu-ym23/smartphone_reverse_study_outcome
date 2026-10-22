package com.bytedance.android.live.platformplayer.layout;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.ui.VideoViewParams;
import com.bytedance.android.livesdk.chatroom.ui.v9;
import com.bytedance.android.livesdk.chatroom.utils.VSMediaUIConfigHelper;
import com.bytedance.android.livesdk.config.ih0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.utils.e6;
import com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a1 implements IRenderView.LayoutListener {
    public final /* synthetic */ LivePlayerWidget a;

    public static final class a implements Runnable {
        public final /* synthetic */ a1 a;
        public final /* synthetic */ VideoViewParams b;

        public a(a1 r1, VideoViewParams r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            if (this.a.a.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) goto L8;
            int r0 = e6.a;
            e6.b("live-layoutReady", this.b);
            DataCenter r1 = ((Widget) this.a.a).dataCenter;
            if (r1 == null) goto L9;
            r1.put("live_render_view_params", this.b);
            return;
        L9:
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

    public static final class b implements Runnable {
        public final /* synthetic */ a1 a;

        public b(a1 r1) {
            this.a = r1;
        }

        public final void a() {
            if (this.a.a.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) goto L29;
            LivePlayerWidget r0 = this.a.a;
            int r1 = LivePlayerWidget.V2;
            r0.getClass();
            boolean r2 = false;
            if (e5.n() == true) goto L16;
            AbsLivePlayerView r3 = r0.R8();
            if (r3 == null) goto L13;
            IRenderView r4 = r3.getRenderView();
            if (r4 == null) goto L13;
            View r5 = r4.getSelfView();
            if (r5 == null) goto L13;
            int r6 = com.bytedance.android.live.core.utils.a1.h(r5);
        L14:
            if (r6 <= 0) goto L25;
        L26:
            if (r2 == false) goto L30;
            LivePlayerWidget r7 = this.a.a;
            r7.M30(UIUtils.getScreenWidth(r7.getContext()), "pad size error");
            return;
        L30:
            return;
        L25:
            r2 = true;
        L13:
            r6 = 0;
            goto L14
        L16:
            AbsLivePlayerView r8 = r0.R8();
            if (r8 == null) goto L23;
            IRenderView r9 = r8.getRenderView();
            if (r9 == null) goto L23;
            View r10 = r9.getSelfView();
            if (r10 == null) goto L23;
            int r11 = com.bytedance.android.live.core.utils.a1.h(r10);
        L24:
            if (r11 <= 0) goto L26;
        L23:
            r11 = 0;
            goto L24
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

    public static final class c implements Runnable {
        public final /* synthetic */ a1 a;

        public c(a1 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String r0 = this.a.a.L;     // Catch: Throwable -> L8
            if (TextUtils.isEmpty(r0) == true) goto L11;
            v9 r1 = this.a.a.n;     // Catch: Throwable -> L8
            if (r1 == null) goto L15;
            r1.onSeiUpdate(0, r0, true);     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ a1 a;

        public d(a1 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LivePlayerWidget.ms(this.a.a, "onLayoutChanged", 0, 0, null, null, 30);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public a1(LivePlayerWidget r1) {
        this.a = r1;
    }

    public final void onLayoutReady(int r6, int r7, int r8, int r9) {
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
        if (r0 == null) goto L5;
        com.bytedance.android.livesdk.chatroom.o r1 = IRoomContextService.a.a(r0, null, 0, 3);
    L6:
        if (r1 == null) goto L11;
        com.bytedance.live.datacontext.n r2 = r1.T1();
        if (r2 == null) goto L11;
        r2.setValue(new Rect(r6, r7, r8, r9));
    L11:
        if (VSMediaUIConfigHelper.b(((Widget) this.a).dataCenter) == false) goto L28;
        if (FoldScreenUtils.f() == false) goto L15;
    L16:
        LivePlayerWidget r10 = this.a;
        int r11 = LivePlayerWidget.V2;
        if (r10.Rq(null) == true) goto L28;
        DataCenter r12 = ((Widget) this.a).dataCenter;
        if (r12 == null) goto L26;
        VideoViewParams r13 = (VideoViewParams) r12.get("live_render_view_params", null);
        if (r13 == null) goto L45;
        VideoViewParams r14 = new VideoViewParams(r13.a, r13.b, r13.c + r7, this.a.R8().getRenderView().getSelfView().getX());
        if ((!Intrinsics.areEqual(r14, r13)) == false) goto L28;
        this.a.R8().post(new a(this, r14));
        goto L28
    L45:
        return;
    L26:
        return;
    L15:
        if (PadConfigUtils.c() == true) goto L16;
    L28:
        if (VSMediaUIConfigHelper.b(((Widget) this.a).dataCenter) == true) goto L30;
    L32:
        StringBuilder r15 = new StringBuilder("onLayoutReady isSeiCropVideoEnable ");
        LivePlayerWidget r16 = this.a;
        int r17 = LivePlayerWidget.V2;
        r15.append(r16.zr());
        r15.append("; seiRaw ");
        r15.append(this.a.L);
        ALogger.d("VideoViewCropper", r15.toString());
        if (((Boolean) ih0.a.getValue()).booleanValue() == true) goto L35;
    L39:
        LivePlayerWidget r18 = this.a;
        if (r18.E2 == false) goto L46;
        r18.E2 = false;
        AbsLivePlayerView r19 = r18.R8();
        if (r19 == null) goto L47;
        r19.post(new d(this));
        return;
    L47:
        return;
    L46:
        return;
    L35:
        if (this.a.zr() == false) goto L39;
        if (TextUtils.isEmpty(this.a.L) == true) goto L39;
        this.a.R8().post(new c(this));
        goto L39
    L30:
        if (PadConfigUtils.c() == false) goto L32;
        this.a.R8().post(new b(this));
        goto L32
    L5:
        r1 = null;
        goto L6
    }
}

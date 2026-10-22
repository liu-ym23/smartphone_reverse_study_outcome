package com.bytedance.android.livesdk.chatroom.ui.record;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.business.IHostShare;
import com.bytedance.android.livesdk.chatroom.viewmodule.record.RecordDragContainer;
import com.bytedance.android.livesdk.chatroom.viewmodule.record.RecordDragParentView;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.config.wx0;
import com.bytedance.android.livesdk.utils.q6;
import com.bytedance.android.livesdk.utils.z0;
import com.bytedance.android.livesdkapi.depend.live.IQuickRecordPopupWindow;
import com.bytedance.android.uicomponent.loading.CircularProgressView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.text.SimpleDateFormat;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e extends PopupWindow implements IQuickRecordPopupWindow {
    public final CircularProgressView a;
    public final TextView b;
    public final RecordDragParentView c;
    public final RecordDragContainer d;
    public final FrameLayout e;
    public long f;
    public long g;
    public final Activity h;
    public final long i;
    public final String j;

    public static final class a {
    }

    public static final class b implements PopupWindow.OnDismissListener {
        public final /* synthetic */ e a;
        public final /* synthetic */ Function1 b;

        public b(e r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            e r0 = this.a;
            if (r0.g > 0) goto L5;
            r0.g = r0.f;
        L5:
            this.b.invoke(Long.valueOf(r0.g));
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ e a;

        public static final class a implements Runnable {
            public final /* synthetic */ c a;
            public final /* synthetic */ long b;
            public final /* synthetic */ long c;
            public final /* synthetic */ long d;
            public final /* synthetic */ Handler e;

            /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.record.e$c$a$a, reason: collision with other inner class name */
            public static final class RunnableC0025a implements Runnable {
                public final /* synthetic */ a a;

                public RunnableC0025a(a r1) {
                    this.a = r1;
                }

                public final void a() {
                    a r0 = this.a;
                    long r1 = Math.round(r0.a.a.f / r0.d);
                    a r2 = this.a;
                    long r3 = r1 * r2.d;
                    TextView r4 = r2.a.a.b;
                    if (r4 == null) goto L5;
                    r4.setText(q6.b(r3));
                L5:
                    a r5 = this.a;
                    e r6 = r5.a.a;
                    CircularProgressView r7 = r6.a;
                    if (r7 == null) goto L9;
                    r7.setProgress(r6.f / r5.c);
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
                public final /* synthetic */ a a;

                public b(a r1) {
                    this.a = r1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    e r0 = this.a.a.a;     // Catch: Throwable -> L4
                    PopupWindowLancet.handleDismissBeforeOrigin(r0);     // Catch: Throwable -> L4
                    r0.dismiss();     // Catch: Throwable -> L4
                    return;
                L4:
                    th = move-exception;
                    if (RunnableProtector.intercept(th) == false) goto L8;
                    return;
                L8:
                    throw th;
                }
            }

            public final void a() {
                this.a.a.f = System.currentTimeMillis() - this.b;
                ALogger.e("QuickRecordPopupWindow", "record time:" + this.a.a.f);
                e r0 = this.a.a;
                if (r0.f > this.c) goto L9;
                r0.b.post(new RunnableC0025a(this));
                long r1 = this.a.a.f;
                long r2 = this.d;
                long r3 = r1 % r2;
                if (r3 > (r2 / ((long) 2))) goto L8;
                r3 = r2 - r3;
            L8:
                this.e.postDelayed(this, r3);
                return;
            L9:
                Looper r4 = Looper.myLooper();
                if (r4 == null) goto L12;
                ThreadMethodProxy.quit(r4);
            L12:
                View r5 = this.a.a.getContentView();
                if (r5 == null) goto L17;
                r5.post(new b(this));
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

            public a(c r1, long r2, long r4, long r6, Handler r8) {
                this.a = r1;
                this.b = r2;
                this.c = r4;
                this.d = r6;
                this.e = r8;
            }
        }

        public c(e r1) {
            this.a = r1;
        }

        public final void a() {
            if (Looper.myLooper() != null) goto L5;
            Looper.prepare();
        L5:
            Handler r0 = new Handler();
            e r1 = this.a;
            long r5 = (r1.i + 1) * ((long) BubbleId.PadCast);
            r1.getClass();
            boolean r2 = false;
            float r3 = z0.b(false);
            if (r3 > 0) goto L8;
        L9:
            r2 = true;
        L10:
            if (r2 == false) goto L12;
            long r4 = 200;
        L13:
            long r10 = r4;
            r0.postDelayed(new a(this, System.currentTimeMillis(), r5, r10, r0), r10);
            Looper.loop();
            return;
        L12:
            r4 = 1000;
            goto L13
        L8:
            if (r3 < wx0.a.getValue().floatValue()) goto L10;
            goto L9
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

    static {
    }

    public final Activity getContext() {
        return this.h;
    }

    public final long getRecordTimes() {
        return this.f;
    }

    public final void setDismissListener(Function1<? super Long, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        setOnDismissListener(new b(this, r2));
    }

    public final void setRecordTimes(long r1) {
        this.f = r1;
    }

    public e(Activity r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "ownerDisplayName");
        this.h = r4;
        this.i = 15;
        this.j = r5;
        setContentView(LayoutInflater.from(r4).inflate(2131567244, null));
        View r6 = getContentView();
        com.bytedance.android.live.core.utils.statusbar.a.b.a();
        r6.setSystemUiVisibility(1024);
        this.e = (FrameLayout) getContentView().findViewById(2131389720);
        RecordDragParentView r7 = (RecordDragParentView) getContentView().findViewById(2131384840);
        this.c = r7;
        View r8 = LayoutInflater.from(r4).inflate(2131567245, null);
        CircularProgressView r0 = r8.findViewById(2131389721);
        this.a = r0;
        this.b = (TextView) r8.findViewById(2131389722);
        RecordDragContainer r9 = (RecordDragContainer) r8.findViewById(2131389919);
        this.d = r9;
        setAnimationStyle(2131954775);
        setWidth(-1);
        setHeight(-1);
        r7.a(0, UtilityKotlinExtentionsKt.i(12), 0);
        r9.setDragParentView(r7);
        r0.setOnClickListener(new d(this));
    }

    @Override // android.widget.PopupWindow
    public final void showAtLocation(View r8, int r9, int r10, int r11) {
        if (PopupWindowLancet.hasSubWindowToken(r8) == false) goto L6;
    L12:
        View r12 = k.n(IHostShare.class).getQuickRecordWatermark(this.h, this.j);
        if (r12 == null) goto L15;
        this.e.addView(r12);
    L15:
        this.a.setProgress(0.0f);
        TextView r13 = this.b;
        SimpleDateFormat r14 = q6.a;
        r13.setText(q6.b(this.i));
        this.c.b(this.d);
        this.d.setX(r10 - s1.f(52.0f));
        this.d.setY(s1.r() - s1.f(50.0f));
        this.f = 0;
        ThreadMethodProxy.start(new PthreadThreadV2(new c(this), "QuickRecordPopupWindow"));
        return;
    L6:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(this) == false) goto L8;
        super.showAtLocation(r8, r9, r10, r11);
        goto L12
    L8:
        OverlaySource r0 = PopupWindowLancet.resolveSource(r8);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(this, r8, r0, r9, r10, r11) == true) goto L12;
        super.showAtLocation(r8, r9, r10, r11);
        PopupWindowLancet.trackAfterShow(this, r0, r8);
        goto L12
    }
}

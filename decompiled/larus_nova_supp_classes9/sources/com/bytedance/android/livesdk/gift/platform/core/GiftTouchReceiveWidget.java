package com.bytedance.android.livesdk.gift.platform.core;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.r2;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/GiftTouchReceiveWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftTouchReceiveWidget extends LiveRecyclableWidget {
    public final a a;
    public final b b;

    public static final class a implements View.OnTouchListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r2, MotionEvent r3) {
            i12.e r4 = i12.o.b();
            if (r4 == null) goto L5;
            Object r5 = com.bytedance.android.scope.m.e.d(r4, com.bytedance.android.livesdk.gift.platform.core.scope.service.n.class);
        L6:
            com.bytedance.android.livesdk.gift.platform.core.scope.service.n r6 = (com.bytedance.android.livesdk.gift.platform.core.scope.service.n) r5;
            if (r6 == null) goto L11;
            r6.a();
            return false;
        L11:
            return false;
        L5:
            r5 = null;
            goto L6
        }
    }

    public static final class b implements View.OnTouchListener {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r2, MotionEvent r3) {
            i12.e r4 = i12.o.b();
            if (r4 == null) goto L5;
            Object r5 = com.bytedance.android.scope.m.e.d(r4, com.bytedance.android.livesdk.gift.platform.core.scope.service.d0.class);
        L6:
            com.bytedance.android.livesdk.gift.platform.core.scope.service.d0 r6 = (com.bytedance.android.livesdk.gift.platform.core.scope.service.d0) r5;
            if (r6 == null) goto L11;
            r6.c();
            r6.a();
            return false;
        L11:
            return false;
        L5:
            r5 = null;
            goto L6
        }
    }

    public static final class c implements r2 {
        public final /* synthetic */ GiftTouchReceiveWidget a;

        @Override // com.bytedance.android.livesdk.gift.platform.core.scope.service.r2
        public final void onEnd() {
            ViewGroup r0 = ((Widget) this.a).containerView;
            if (r0 == null) goto L6;
            r0.setOnTouchListener(null);
            return;
        }

        @Override // com.bytedance.android.livesdk.gift.platform.core.scope.service.r2
        public final void onStart() {
            GiftTouchReceiveWidget r0 = this.a;
            ViewGroup r1 = ((Widget) r0).containerView;
            if (r1 == null) goto L6;
            r1.setOnTouchListener(r0.a);
            return;
        }

        public c(GiftTouchReceiveWidget r1) {
            this.a = r1;
        }
    }

    public static final class d implements r2 {
        public final /* synthetic */ GiftTouchReceiveWidget a;

        @Override // com.bytedance.android.livesdk.gift.platform.core.scope.service.r2
        public final void onEnd() {
            ViewGroup r0 = ((Widget) this.a).containerView;
            if (r0 == null) goto L6;
            r0.setOnTouchListener(null);
            return;
        }

        @Override // com.bytedance.android.livesdk.gift.platform.core.scope.service.r2
        public final void onStart() {
            GiftTouchReceiveWidget r0 = this.a;
            ViewGroup r1 = ((Widget) r0).containerView;
            if (r1 == null) goto L6;
            r1.setOnTouchListener(r0.b);
            return;
        }

        public d(GiftTouchReceiveWidget r1) {
            this.a = r1;
        }
    }

    public final int getLayoutId() {
        return 2131566139;
    }

    public final void onInit(Object[] r1) {
    }

    public GiftTouchReceiveWidget() {
        this.a = a.a;
        this.b = b.a;
    }

    public final void onUnload() {
        i12.e r0 = i12.o.b();
        if (r0 == null) goto L5;
        Object r1 = com.bytedance.android.scope.m.e.d(r0, com.bytedance.android.livesdk.gift.platform.core.scope.service.n.class);
    L6:
        com.bytedance.android.livesdk.gift.platform.core.scope.service.n r2 = (com.bytedance.android.livesdk.gift.platform.core.scope.service.n) r1;
        if (r2 == null) goto L9;
        r2.c = null;
    L9:
        i12.e r3 = i12.o.b();
        if (r3 == null) goto L12;
        Object r4 = com.bytedance.android.scope.m.e.d(r3, com.bytedance.android.livesdk.gift.platform.core.scope.service.d0.class);
    L13:
        com.bytedance.android.livesdk.gift.platform.core.scope.service.d0 r5 = (com.bytedance.android.livesdk.gift.platform.core.scope.service.d0) r4;
        if (r5 == null) goto L17;
        r5.e = null;
        return;
    L17:
        return;
    L12:
        r4 = null;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public final void onLoad(Object[] r4) {
        i12.e r5 = i12.o.b();
        Object r0 = null;
        if (r5 == null) goto L5;
        Object r6 = com.bytedance.android.scope.m.e.d(r5, com.bytedance.android.livesdk.gift.platform.core.scope.service.n.class);
    L6:
        com.bytedance.android.livesdk.gift.platform.core.scope.service.n r7 = (com.bytedance.android.livesdk.gift.platform.core.scope.service.n) r6;
        if (r7 == null) goto L9;
        r7.c = new c(this);
    L9:
        i12.e r8 = i12.o.b();
        if (r8 == null) goto L12;
        r0 = com.bytedance.android.scope.m.e.d(r8, com.bytedance.android.livesdk.gift.platform.core.scope.service.d0.class);
    L12:
        com.bytedance.android.livesdk.gift.platform.core.scope.service.d0 r1 = (com.bytedance.android.livesdk.gift.platform.core.scope.service.d0) r0;
        if (r1 == null) goto L16;
        r1.e = new d(this);
        return;
    L16:
        return;
    L5:
        r6 = null;
        goto L6
    }
}

package com.bytedance.android.livesdk.clearscreen.gesture;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.ViewGroupUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenHelper;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.k;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.PublicScreenAreaPagerLayout;
import com.bytedance.android.livesdk.vscore_impl.component.tabs.MultiTabManagerImpl;
import com.bytedance.android.livesdk.widget.f0;
import com.bytedance.android.livesdk.widget.y;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import nm1.r;
import pm1.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ClickPS2ClearScreenGestureBehavior implements y {
    public static final /* synthetic */ int q = 0;
    public final com.bytedance.android.livesdk.widget.b.b a;
    public a b;
    public final int c;
    public final int d;
    public float e;
    public float f;
    public final Rect g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public List<? extends View> l;
    public k m;
    public final c n;
    public final Lazy o;
    public final DataCenter p;

    public interface a {
        void a(MotionEvent r1);
    }

    public static final class b {
    }

    public static final class c extends Handler {
        public final WeakReference<ClickPS2ClearScreenGestureBehavior> a;

        public c(ClickPS2ClearScreenGestureBehavior r2) {
            Intrinsics.checkNotNullParameter(r2, "behavior");
            this.a = new WeakReference(r2);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r4) {
            Intrinsics.checkNotNullParameter(r4, "msg");
            int r0 = r4.what;
            int r1 = ClickPS2ClearScreenGestureBehavior.q;
            if (r0 != 1) goto L11;
            WeakReference<ClickPS2ClearScreenGestureBehavior> r5 = this.a;
            if (r5 == null) goto L9;
            ClickPS2ClearScreenGestureBehavior r6 = r5.get();
            if (r6 == null) goto L9;
            r6.j = true;
        L9:
            ALogger.d("ClickPS2ClearScreenGestureBehavior", "触发长按点击了");
            return;
        L11:
            if (r0 != 2) goto L26;
            Object r7 = r4.obj;
            if ((r7 instanceof MotionEvent) == true) goto L15;
            r7 = null;
        L15:
            MotionEvent r8 = (MotionEvent) r7;
            if (r8 == null) goto L27;
            ALogger.d("ClickPS2ClearScreenGestureBehavior", "消费公屏的点击事件");
            WeakReference<ClickPS2ClearScreenGestureBehavior> r2 = this.a;
            if (r2 == null) goto L28;
            ClickPS2ClearScreenGestureBehavior r3 = r2.get();
            if (r3 == null) goto L29;
            a r9 = r3.b;
            if (r9 == null) goto L30;
            r9.a(r8);
            return;
        L30:
            return;
        L29:
            return;
        L28:
            return;
        L27:
            return;
        }
    }

    static {
    }

    public final f0 getConfig() {
        return this.a;
    }

    public static List d(View r4) {
        ArrayList r0 = new ArrayList();
        if ((r4 instanceof PublicScreenAreaPagerLayout) == false) goto L6;
        r0.add(r4);
    L6:
        if ((r4 instanceof ViewGroup) == true) goto L8;
        r4 = null;
    L8:
        ViewGroup r5 = (ViewGroup) r4;
        if (r5 == null) goto L21;
        Sequence r6 = UtilityKotlinExtentionsKt.g(r5);
        if (r6 == null) goto L21;
        Iterator r7 = r6.iterator();
    L14:
        if (r7.hasNext() == false) goto L21;
        List r1 = d((View) r7.next());
        if ((!r1.isEmpty()) == true) goto L19;
        r1 = null;
    L19:
        if (r1 == null) goto L14;
        r0.addAll(r1);
    L21:
        return r0;
    }

    public final boolean a(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "gestureDetectLayout");
        Intrinsics.checkNotNullParameter(r2, "gestureDetectLayout");
        return false;
    }

    public final boolean b(ViewGroup r3, MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r3, "gestureDetectLayout");
        Intrinsics.checkNotNullParameter(r4, "ev");
        Intrinsics.checkNotNullParameter(r3, "gestureDetectLayout");
        Intrinsics.checkNotNullParameter(r4, "ev");
        return false;
    }

    public final boolean c(ViewGroup r18, MotionEvent r19) {
        Intrinsics.checkNotNullParameter(r18, "gestureDetectLayout");
        Intrinsics.checkNotNullParameter(r19, "ev");
        int r3 = r19.getAction() & 255;
        k r5 = null;
        if (r3 != 0) goto L5;
        this.e = r19.getX();
        this.f = r19.getY();
        r19.getDownTime();
        this.h = false;
        this.i = false;
        this.k = false;
        this.j = false;
        this.m = null;
        r r4 = f.o();
        if (r4 == null) goto L75;
        r4.a();
        if (MultiTabManagerImpl.e.h(this.p) != true) goto L75;
        this.l = d(r18);
    L83:
        float r6 = this.e;
        float r8 = this.f;
        List<? extends View> r9 = this.l;
        if (r9 != null) goto L86;
        r9 = CollectionsKt.emptyList();
    L86:
        Iterator<? extends View> r10 = r9.iterator();
    L88:
        if (r10.hasNext() == false) goto L103;
        k r11 = (View) r10.next();
        boolean r12 = r11 instanceof k;
        if (r12 == true) goto L92;
        k r13 = null;
    L93:
        k r14 = r13;
        if (r14 == null) goto L88;
        if (r14.f() != true) goto L88;
        if (f(r18, r11, (int) r6, (int) r8) == false) goto L88;
        if (r12 == false) goto L102;
        r5 = r11;
    L102:
        this.m = r5;
        this.h = true;
        this.i = e(r18, r11, r6, r8);
        goto L103
    L92:
        r13 = r11;
    L103:
        ALogger.d("ClickPS2ClearScreenGestureBehavior", "是否点击了公屏：" + this.h + ", 是否点击了公屏上可点击的view：" + this.i);
        this.n.removeMessages(1);
        c r1 = this.n;
        r1.sendMessageAtTime(r1.obtainMessage(1), r19.getDownTime() + ((long) this.d));
    L104:
        return false;
    L75:
        List<? extends View> r7 = this.l;
        if (r7 != null) goto L78;
    L82:
        this.l = d(r18);
        Unit r15 = Unit.INSTANCE;
        goto L83
    L78:
        if ((!((ArrayList) r7).isEmpty()) == true) goto L81;
        r7 = null;
    L81:
        if (r7 != null) goto L83;
    L5:
        if (r3 == 1) goto L26;
        if (r3 != 2) goto L8;
        float r2 = r19.getX();
        float r16 = r19.getY();
        float r17 = r2 - this.e;
        float r20 = r16 - this.f;
        if (this.k == true) goto L104;
        if (Math.abs(r17) < this.c) goto L19;
    L22:
        boolean r21 = true;
    L23:
        this.k = r21;
        if (r21 == false) goto L104;
        this.n.removeMessages(1);
        goto L104
    L19:
        if (Math.abs(r20) >= this.c) goto L22;
        r21 = false;
        goto L23
    L8:
        if (r3 != 3) goto L10;
        this.n.removeMessages(1);
        goto L104
    L10:
        if (r3 != 5) goto L104;
        this.k = true;
        this.n.removeMessages(1);
        goto L104
    L26:
        this.n.removeMessages(1);
        if (this.h == true) goto L29;
    L54:
        boolean r22 = false;
    L55:
        StringBuilder r110 = new StringBuilder("ACTION_UP, 是否拦截公屏点击:");
        r110.append(r22);
        r110.append(", isInZoomMode:");
        DataCenter r111 = this.p;
        if (r111 == null) goto L58;
        Boolean r23 = (Boolean) r111.get("live_zoom_and_lock_notify", Boolean.FALSE);
    L59:
        r110.append(Intrinsics.areEqual(r23, Boolean.TRUE));
        r110.append(", isTouchPSLayout:");
        r110.append(this.h);
        r110.append(", isMove:");
        r110.append(this.k);
        r110.append(", isClickRvItem:");
        r110.append(this.i);
        r110.append(", isLongPress:");
        r110.append(this.j);
        r110.append(", isReceiveTouchEvent:");
        k r24 = this.m;
        if (r24 == null) goto L62;
        r5 = Boolean.valueOf(r24.f());
    L62:
        r110.append(r5);
        ALogger.d("ClickPS2ClearScreenGestureBehavior", r110.toString());
        if (r22 == false) goto L104;
        long r112 = SystemClock.uptimeMillis();
        MotionEvent r25 = MotionEvent.obtain(r112, r112, 3, 0.0f, 0.0f, 0);
        Iterator r26 = UtilityKotlinExtentionsKt.g(r18).iterator();
    L66:
        if (r26.hasNext() == false) goto L68;
        ((View) r26.next()).dispatchTouchEvent(r25);
        goto L66
    L68:
        c r27 = this.n;
        r27.dispatchMessage(r27.obtainMessage(2, r19));
        return true;
    L58:
        r23 = null;
        goto L59
    L29:
        if (this.k == true) goto L54;
        if (this.i == true) goto L54;
        if (this.j == true) goto L54;
        DataCenter r28 = this.p;
        if (r28 == null) goto L37;
        Boolean r29 = (Boolean) r28.get("live_zoom_and_lock_notify", Boolean.FALSE);
    L39:
        if (Intrinsics.areEqual(r29, Boolean.TRUE) == true) goto L54;
        RoomContext r30 = RoomContext.a.c(RoomContext.Companion, this.p, 0, 2);
        if (r30 == null) goto L47;
        m r31 = r30.getMatchRoomMultiCameraPanelShowing();
        if (r31 == null) goto L47;
        if (((Boolean) r31.getValue()).booleanValue() != true) goto L47;
        boolean r32 = true;
    L48:
        if (r32 == true) goto L54;
        k r33 = this.m;
        if (r33 == null) goto L54;
        if (r33.f() != true) goto L54;
        r22 = true;
    L47:
        r32 = false;
        goto L48
    L37:
        r29 = null;
        goto L39
    }

    public final boolean onTouchEvent(ViewGroup r3, MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r3, "gestureDetectLayout");
        Intrinsics.checkNotNullParameter(r4, "ev");
        Intrinsics.checkNotNullParameter(r3, "gestureDetectLayout");
        Intrinsics.checkNotNullParameter(r4, "ev");
        return false;
    }

    public ClickPS2ClearScreenGestureBehavior(View r2, Context r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "gestureDetectLayout");
        Intrinsics.checkNotNullParameter(r3, "ctx");
        this.p = r4;
        this.a = com.bytedance.android.livesdk.widget.b.b.c;
        this.c = ViewConfiguration.get(r3).getScaledTouchSlop();
        this.d = ViewConfiguration.getLongPressTimeout();
        this.e = Float.MIN_VALUE;
        this.f = Float.MIN_VALUE;
        this.g = new Rect();
        this.n = new c(this);
        this.o = LazyKt.lazy(ClickPS2ClearScreenGestureBehavior$whiteViewIds$2.INSTANCE);
    }

    public final boolean e(ViewGroup r5, View r6, float r7, float r8) {
        Intrinsics.checkNotNullParameter(r5, "gestureDetectLayout");
        Intrinsics.checkNotNullParameter(r6, "view");
        Intrinsics.checkNotNullParameter(r6, "$this$canClick");
        Intrinsics.checkNotNullParameter(r5, "gestureDetectLayout");
        if (r6.hasOnClickListeners() == true) goto L12;
        if (((Boolean) ClearScreenHelper.h.getValue()).booleanValue() == true) goto L7;
    L9:
        boolean r0 = false;
    L10:
        if (r0 == true) goto L12;
    L14:
        boolean r1 = false;
    L15:
        if (r1 == false) goto L18;
        return true;
    L18:
        if ((r6 instanceof ViewGroup) == true) goto L20;
        return false;
    L20:
        ViewGroup r9 = (ViewGroup) r6;
        int r2 = r9.getChildCount() - 1;
    L21:
        if (r2 < 0) goto L26;
        if (e(r5, r9.getChildAt(r2), r7, r8) == true) goto L24;
        r2 = r2 - 1;
        goto L21
    L24:
        return true;
    L26:
        return false;
    L7:
        if (((List) this.o.getValue()).contains(Integer.valueOf(r6.getId())) == false) goto L9;
        r0 = true;
    L12:
        if (f(r5, r6, (int) r7, (int) r8) == false) goto L14;
        r1 = true;
        goto L15
    }

    public final boolean f(ViewGroup r2, View r3, int r4, int r5) {
        ViewGroupUtils.getDescendantRect(r2, r3, this.g);
    L11:
        th = move-exception;
        this.g.setEmpty();
        throw th;
    L4:
        if (this.g.contains(r4, r5) == false) goto L8;
        if (r3.isShown() == false) goto L8;
        boolean r6 = true;
    L9:
        this.g.setEmpty();
        return r6;
    L8:
        r6 = false;
        goto L9
    }
}

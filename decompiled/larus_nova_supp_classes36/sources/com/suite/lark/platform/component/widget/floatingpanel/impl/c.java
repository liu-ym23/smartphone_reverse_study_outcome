package com.suite.lark.platform.component.widget.floatingpanel.impl;

import android.content.Context;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.p;
import com.ss.android.lark.keyboard.plugin.tool.face.Conf$StickerSetManagerPosition;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.suite.lark.platform.component.widget.floatingpanel.impl.container.FloatingPanelTopPageViewContainer;
import com.suite.lark.platform.component.widget.floatingpanel.impl.view.FloatingPanelView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import yoc.g;
import z5c.i0;
import z5c.y3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public static final /* synthetic */ int j = 0;
    public final Context a;
    public final com.suite.lark.platform.component.widget.floatingpanel.impl.container.b b;
    public final e c;
    public final Function2<Context, FloatingPanelView.g, FloatingPanelView> d;
    public FloatingCardItem<yoc.b> e;
    public final List<FloatingCardItem<yoc.c>> f;
    public final Lazy g;
    public final d h;
    public final Lazy i;

    public static final class a {
    }

    public static final class b implements e.b {
        public final /* synthetic */ Function0<Unit> a;

        @Override // com.suite.lark.platform.component.widget.floatingpanel.impl.e.b
        public final void a() {
            this.a.invoke();
        }

        public b(Function0<Unit> r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final void b() {
        Log.i("FloatingPanelPresenter", "dismissIfEmpty");
        if (this.e == null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L16;
        Log.i("FloatingPanelPresenter", "dismiss");
        if (c().isAttachedToWindow() == false) goto L14;
        Long r0 = FloatPanelHitPoint.a;
        if (r0 == null) goto L14;
        long r2 = r0.longValue();
        FloatPanelHitPoint.a = null;
        long r3 = Math.max(0, System.currentTimeMillis() - r2);
        Statistics.sendEvent("core_float_dialog_display", s5c.d.b.b(y3.q.a(Conf$StickerSetManagerPosition.STICKER_SET_SHOP), i0.c.a(String.valueOf(r3))).toJson());
    L14:
        c().l();
        this.b.dismiss();
        return;
    L16:
        return;
    L5:
        if (((ArrayList) this.f).isEmpty() == false) goto L7;
        r1 = true;
        goto L8
    }

    public final FloatingPanelView c() {
        return (FloatingPanelView) this.i.getValue();
    }

    public final void f() {
        Log.i("FloatingPanelPresenter", "onAnyCardRemoved");
        this.c.c("fallback_dismiss", 500, this.h);
    }

    public final void g() {
        Log.i("FloatingPanelPresenter", "removeBanner");
        FloatingCardItem<yoc.b> r0 = this.e;
        if (r0 == null) goto L5;
        this.c.b(r0.e);
    L5:
        this.e = null;
        if (c().i() == false) goto L9;
        f();
        return;
    }

    public static final void a(c r2) {
        r2.getClass();
        Log.i("FloatingPanelPresenter", "onAnyCardShown");
        r2.c.b("fallback_dismiss");
    }

    public final int d(FloatingCardItem<?> r3) {
        if (((ArrayList) this.f).isEmpty() == false) goto L5;
        return 0;
    L5:
        r3.a.getPriority();
        ((FloatingCardItem) CollectionsKt.first(this.f)).a.getPriority();
        return 0;
    }

    public final void i(int r6) {
        Log.i("FloatingPanelPresenter", "removeCardAtIndex, index: " + r6 + ", cardCount: " + ((ArrayList) this.f).size());
        FloatingCardItem r0 = (FloatingCardItem) ListProtector.remove(this.f, r6);
        c().j(r0.e);
        this.c.b(r0.e);
        f();
        if (r6 != 0) goto L18;
        boolean r1 = true;
        if ((!((ArrayList) this.f).isEmpty()) == false) goto L19;
        FloatingCardItem r7 = (FloatingCardItem) ListProtector.get(this.f, 0);
        Card r3 = r7.a;
        if ((r3 instanceof g) == false) goto L9;
        g r4 = (g) r3;
    L10:
        if (r4 != null) goto L12;
    L14:
        r1 = false;
    L15:
        if (r1 == false) goto L20;
        Log.i("FloatingPanelPresenter", "Remove invalid card, id: " + r7.e);
        i(0);
        return;
    L20:
        return;
    L12:
        if (r4.isValid() == true) goto L14;
    L9:
        r4 = null;
        goto L10
    L19:
        return;
    }

    public final void k(Function0<Unit> r3) {
        if (c().isAttachedToWindow() == true) goto L5;
        Long r0 = FloatPanelHitPoint.a;
        FloatPanelHitPoint.a = Long.valueOf(System.currentTimeMillis());
        Statistics.sendEvent("core_float_dialog_display", s5c.d.b.c(y3.q.a(Conf$StickerSetManagerPosition.STICKER_SET_CHAT_PANEL)));
    L5:
        this.b.c(c());
        this.b.b(r3);
    }

    public final void e(List<String> r3, int r4) {
        ArrayList r0 = (ArrayList) r3;
        if (r0.isEmpty() == false) goto L6;
        return;
    L6:
        if (r0.size() != r4) goto L14;
        Log.i("FloatingPanelPresenter", "removeAllCards");
        c().h();
        f();
        e r5 = this.c;
        ReentrantLock r6 = r5.a;
        r6.lock();
        r5.d.removeMessages(1);     // Catch: Throwable -> L11
        ((LinkedHashMap) r5.c).clear();     // Catch: Throwable -> L11
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L11
        r6.unlock();
        return;
    L11:
        th = move-exception;
        r6.unlock();
        throw th;
    L14:
        c().k(r3);
        Iterator<T> r8 = r3.iterator();
    L16:
        if (r8.hasNext() == false) goto L18;
        String r9 = (String) r8.next();
        this.c.b(r9);
        goto L16
    L18:
        f();
    }

    public final void h(int r14, String r15) {
        Intrinsics.checkNotNullParameter(r15, "id");
        Log.i("FloatingPanelPresenter", "removeCard, id: " + r15);
        Iterator r0 = ((ArrayList) this.f).iterator();
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r0.hasNext() == false) goto L14;
        FloatingCardItem r4 = (FloatingCardItem) r0.next();
        if (r4.f == r14) goto L8;
    L10:
        boolean r5 = false;
    L11:
        if (r5 == true) goto L15;
        r3 = r3 + 1;
    L15:
        if (r3 < 0) goto L17;
        i(r3);
        return;
    L17:
        ArrayList r6 = new ArrayList();
        int r16 = Math.min(((ArrayList) this.f).size(), 5);
    L18:
        if (r2 >= r16) goto L20;
        r6.add(((FloatingCardItem) ListProtector.get(this.f, r2)).e);
        r2 = r2 + 1;
        goto L18
    L20:
        Log.w("FloatingPanelPresenter", "removeCard, card not found, id: " + r15 + ", cards: " + ((ArrayList) this.f).size() + ", ids: " + CollectionsKt.joinToString$default(r6, null, null, null, 0, null, null, 63, null));
        return;
    L8:
        if (Intrinsics.areEqual(r4.g, r15) == false) goto L10;
        r5 = true;
        goto L11
    L14:
        r3 = -1;
        goto L15
    }

    public final void j(int r10, Function1<? super yoc.c, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r11, "filter");
        Log.i("FloatingPanelPresenter", "removeCards with condition");
        if (((ArrayList) this.f).isEmpty() == false) goto L5;
        return;
    L5:
        int r0 = ((ArrayList) this.f).size();
        ArrayList r1 = new ArrayList();
        int r2 = this.f.size();
        int r5 = 0;
        boolean r6 = true;
    L6:
        if (r5 >= r2) goto L28;
        FloatingCardItem r7 = (FloatingCardItem) ListProtector.get(this.f, r5);
        if (r7.f == r10) goto L10;
    L12:
        if (r6 == false) goto L24;
        Card r8 = r7.a;
        if ((r8 instanceof g) == false) goto L16;
        g r9 = (g) r8;
    L17:
        if (r9 != null) goto L19;
    L21:
        boolean r12 = false;
    L22:
        if (r12 == false) goto L24;
    L11:
        boolean r13 = true;
    L25:
        if (r13 == false) goto L27;
        r1.add(Integer.valueOf(r5));
    L27:
        r5 = r5 + 1;
        goto L6
    L19:
        if (r9.isValid() == true) goto L21;
        r12 = true;
        goto L22
    L16:
        r9 = null;
    L24:
        r6 = false;
        r13 = false;
        goto L25
    L10:
        if (((Boolean) r11.invoke(r7.a)).booleanValue() == false) goto L12;
    L28:
        ArrayList r14 = new ArrayList();
        Iterator r15 = p.a(r1).iterator();
    L30:
        if (r15.hasNext() == false) goto L32;
        int r3 = ((Number) r15.next()).intValue();
        r14.add(((FloatingCardItem) ListProtector.remove(this.f, r3)).e);
        goto L30
    L32:
        e(r14, r0);
    }

    public final void l(FloatingCardItem<?> r7, Function0<Unit> r8) {
        Log.i("FloatingPanelPresenter", "startTimerIfNeeded, itemId: " + r7.e);
        Card r0 = r7.a;
        if ((r0 instanceof yoc.d) == false) goto L5;
        yoc.d r1 = (yoc.d) r0;
    L6:
        if (r1 == null) goto L11;
        long r2 = r1.getDisplayDuration();
        if (r2 <= 0) goto L12;
        Log.i("FloatingPanelPresenter", "startTimer, itemId: " + r7.e + ", duration: " + r2);
        this.c.c(r7.e, r2, new b(r8));
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public c(Context r3, FloatingPanelTopPageViewContainer r4, e r5) {
        FloatingPanelPresenter$1 r0 = FloatingPanelPresenter$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "container");
        Intrinsics.checkNotNullParameter(r5, "timer");
        Intrinsics.checkNotNullParameter(r0, "viewFactory");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r0;
        this.f = new ArrayList();
        LazyThreadSafetyMode r6 = LazyThreadSafetyMode.NONE;
        this.g = LazyKt.lazy(r6, new FloatingPanelPresenter$viewDelegate$2(this));
        this.h = new d(this);
        this.i = LazyKt.lazy(r6, new FloatingPanelPresenter$rootView$2(this));
        r4.j = new com.suite.lark.platform.component.widget.floatingpanel.impl.b(this);
    }
}

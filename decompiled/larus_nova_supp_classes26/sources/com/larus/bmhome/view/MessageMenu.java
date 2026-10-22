package com.larus.bmhome.view;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.api.SelectionRangeType;
import com.larus.bmhome.chat.api.d0;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.bmhome.view.textview.impl.SelectorRestore;
import com.larus.chat.common.databinding.LarusLayoutMessageMenuBinding;
import com.larus.chat.common.databinding.LarusLayoutMessageMenuNewBinding;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.skydoves.balloon.ArrowOrientation;
import com.skydoves.balloon.ArrowPositionRules;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.BalloonAnimation;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import va8.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class MessageMenu implements st8.b.c {
    public static WeakReference<MessageMenu> x;
    public static final CopyOnWriteArraySet<WeakReference<Balloon>> y = null;
    public CustomMarkdownTextView a;
    public final BotModel b;
    public final Message c;
    public final Boolean d;
    public final Boolean e;
    public final Boolean f;
    public final Boolean g;
    public final Function1<Integer, Unit> h;
    public qt8.a i;
    public Balloon j;
    public RecyclerView k;
    public final MessageMenu$scrollListener$1 l;
    public boolean m;
    public boolean n;
    public boolean o;
    public long p;
    public final c q;
    public final Lazy r;
    public d0 s;
    public boolean t;
    public int u;
    public final Lazy v;
    public boolean w;

    public static final class a {
        public static void a() {
            WeakReference<MessageMenu> r0 = MessageMenu.x;
            if (r0 == null) goto L22;
            MessageMenu r1 = r0.get();
            if (r1 == null) goto L23;
            SelectorRestore r2 = null;
            if (r1.a.z() == false) goto L14;
            Balloon r3 = r1.j;
            if (r3 == null) goto L11;
            r3.h();
        L11:
            r1.j = null;
            tt8.b r4 = r1.a.m31getTextSelector();
            if (r4 == null) goto L14;
            r4.i();
        L14:
            Object r5 = r1.a.getTag(2131373650);
            if ((r5 instanceof SelectorRestore) == false) goto L17;
            r2 = (SelectorRestore) r5;
        L17:
            if (r2 == null) goto L24;
            Map<String, tt8.c> r6 = r2.b;
            if (r6 == null) goto L25;
            ((LinkedHashMap) r6).clear();
            return;
        L25:
            return;
        L24:
            return;
        L23:
            return;
        }

        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v3, types: [android.widget.TextView, com.larus.bmhome.view.textview.impl.SelectorTextView] */
        /* JADX WARN: Type inference failed for: r0v9 */
        public static boolean b(Activity r3) {
            Intrinsics.checkNotNullParameter(r3, "activity");
            WeakReference<MessageMenu> r0 = MessageMenu.x;
            if (r0 == null) goto L7;
            MessageMenu r1 = r0.get();
            if (r1 == null) goto L7;
            ?? r2 = r1.a;
        L8:
            if (r2 == 0) goto L10;
            Context r4 = r2.getContext();
        L12:
            if (Intrinsics.areEqual(r4, r3) == true) goto L14;
            MessageMenu.x = null;
        L14:
            if (r2 != 0) goto L16;
        L18:
            return false;
        L16:
            if (r2.z() != true) goto L18;
            return true;
        L10:
            r4 = null;
        L7:
            r2 = 0;
            goto L8
        }
    }

    public static final class b implements d0 {
        public final /* synthetic */ MessageMenu a;

        public b(MessageMenu r1) {
            this.a = r1;
        }

        public final void a(View r2, int r3, int r4) {
            d0 r0 = this.a.s;
            if (r0 == null) goto L6;
            r0.a(r2, r3, r4);
        L6:
            if (r4 != 1) goto L12;
            MessageMenu r5 = this.a;
            if (r5.o == false) goto L10;
            r5.n = true;
            MessageMenu.c(r5, false, true, false, 4);
            return;
        L10:
            r5.n = false;
            r5.onShow();
            return;
        }

        public final void b(SelectionRangeType r10, int r11, int r12, boolean r13, boolean r14, Rect r15, String r16) {
            Intrinsics.checkNotNullParameter(r10, "rangeType");
            Intrinsics.checkNotNullParameter(r16, "selectedText");
            d0 r1 = this.a.s;
            if (r1 == null) goto L6;
            r1.b(r10, r11, r12, r13, r14, r15, r16);
            return;
        }
    }

    public static final class c implements st8.c {
        public final /* synthetic */ MessageMenu a;

        public c(MessageMenu r1) {
            this.a = r1;
        }

        @Override // st8.c
        public final void a(ut8.i r2, boolean r3, int r4, int r5) {
            Intrinsics.checkNotNullParameter(r2, "selector");
            qt8.a r0 = this.a.i;
            if (r0 == null) goto L5;
            r0.a(r2, r3, r4, r5);
        L5:
            boolean r6 = false;
            if (r3 == false) goto L17;
            MessageMenu r7 = this.a;
            Balloon r8 = r7.j;
            if (r8 != null) goto L10;
        L13:
            r7.m = true;
            if (r8 == null) goto L16;
            r8.h();
        L16:
            this.a.j = null;
            return;
        L10:
            if (r8.g != true) goto L12;
            r6 = true;
        L12:
            if (r6 == true) goto L13;
            return;
        L17:
            MessageMenu r9 = this.a;
            if (r9.m == false) goto L23;
            r9.n = false;
            r9.o = true;
            r9.d();
            this.a.g();
            this.a.m = false;
            return;
        }
    }

    public static final class d implements ut8.f {
        public final /* synthetic */ o a;
        public final /* synthetic */ com.larus.bmhome.chat.component.bottom.reference.a b;

        @Override // ut8.f
        public final void a() {
            if (((com.larus.platform.model.chat.m0) nd8.b.a.getValue()).a() == true) goto L5;
            return;
        L5:
            com.larus.bmhome.chat.component.bottom.reference.a r0 = this.b;
            if (r0 != null) goto L8;
            return;
        L8:
            if (r0.i9() == false) goto L12;
            r0.sZ();
            return;
        }

        @Override // ut8.f
        public final boolean b(MotionEvent r5) {
            if (((com.larus.platform.model.chat.m0) nd8.b.a.getValue()).a() == true) goto L5;
            return true;
        L5:
            FLogger.a.i("MessageMenu", "outsideTouchInterceptor event=" + r5 + " inputViewAbility=" + this.a);
            if (r5 == null) goto L17;
            o r0 = this.a;
            if (r0 != null) goto L10;
        L12:
            boolean r6 = false;
        L13:
            if (r6 == false) goto L18;
            return false;
        L18:
            return true;
        L10:
            if (r0.xO(r5) != true) goto L12;
            r6 = true;
            goto L13
        L17:
            return true;
        }

        public d(o r1, com.larus.bmhome.chat.component.bottom.reference.a r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
        y = new CopyOnWriteArraySet();
    }

    public final void b() {
        Iterator<WeakReference<Balloon>> r0 = y.iterator();
        int r2 = 0;
    L3:
        int r4 = 1;
        if (r0.hasNext() == false) goto L12;
        Balloon r3 = r0.next().get();
        if (r3 != null) goto L8;
    L10:
        r4 = 0;
    L11:
        r2 = r2 + r4;
        goto L3
    L8:
        if (r3.g != true) goto L10;
    L12:
        if (r2 != 0) goto L14;
        return;
    L14:
        Iterator<T> r1 = y.iterator();
    L16:
        if (r1.hasNext() == false) goto L27;
        WeakReference r5 = (WeakReference) r1.next();
        Balloon r6 = (Balloon) r5.get();
        if (r6 != null) goto L20;
    L22:
        boolean r7 = false;
    L23:
        if (r7 == false) goto L16;
        Balloon r8 = (Balloon) r5.get();
        if (r8 == null) goto L16;
        r8.h();
        goto L16
    L20:
        if (r6.g != true) goto L22;
        r7 = true;
        goto L23
    }

    public final void d() {
        RecyclerView r0 = this.k;
        if (r0 == null) goto L5;
        r0.removeOnScrollListener(this.l);
    L5:
        RecyclerView r1 = this.k;
        if (r1 == null) goto L8;
        r1.addOnScrollListener(this.l);
    L8:
        boolean r2 = true;
        if (Intrinsics.areEqual(this.d, Boolean.TRUE) == false) goto L22;
        AppCompatTextView r3 = this.a;
        r3.getClass();
        LarusLayoutMessageMenuNewBinding r4 = LarusLayoutMessageMenuNewBinding.a(LayoutInflater.from(r3.getContext()));
        com.larus.utils.e1.x(r4.f);
        com.larus.utils.e1.o(r4.h);
        com.larus.utils.e1.o(r4.h);
        com.larus.utils.e1.o(r4.i);
        Message r5 = this.c;
        if (r5 != null) goto L13;
    L15:
        r2 = false;
    L16:
        if (r2 == false) goto L18;
        com.larus.utils.e1.o(r4.k);
    L18:
        this.a.A(this.q);
        this.a.x(this.q);
        Balloon r6 = this.j;
        if (r6 == null) goto L21;
        r6.h();
    L21:
        b();
    L36:
        tt8.b r7 = this.a.m31getTextSelector();
        if (r7 == null) goto L42;
        r7.E = this;
        return;
    L42:
        return;
    L13:
        if (com.larus.im.bean.message.a.p0(r5) != true) goto L15;
    L22:
        AppCompatTextView r8 = this.a;
        r8.getClass();
        Context r9 = r8.getContext();
        Context r10 = null;
        LinearLayoutCompat r11 = LayoutInflater.from(r9).inflate(2131562851, null, false);
        int r12 = R.id.copy;
        FrameLayout r13 = (FrameLayout) ViewBindings.findChildViewById(r11, R.id.copy);
        if (r13 == null) goto L41;
        r12 = 2131380252;
        FrameLayout r14 = (FrameLayout) ViewBindings.findChildViewById(r11, 2131380252);
        if (r14 == null) goto L41;
        LarusLayoutMessageMenuBinding r15 = new LarusLayoutMessageMenuBinding(r11, r13, r14);
        r14.setVisibility(8);
        this.a.A(this.q);
        this.a.x(this.q);
        Balloon r16 = this.j;
        if (r16 == null) goto L29;
        r16.h();
    L29:
        Intrinsics.checkNotNull(r9);
        Balloon.a r17 = new Balloon.a(r9);
        r17.n(Integer.MIN_VALUE);
        r17.j(Integer.MIN_VALUE);
        r17.z = 16.0f;
        r17.e(ArrowPositionRules.ALIGN_BALLOON);
        r17.f(Integer.MIN_VALUE);
        r17.d(ArrowOrientation.TOP);
        r17.p = 0.5f;
        r17.m();
        r17.w = TypedValue.applyDimension(1, 8.0f, Balloon.a.a(Resources.getSystem()));
        r17.v = ContextCompat.getColor(r9, v19.c.b(2130972082, r9, 2131103146));
        r17.i();
        r17.g(BalloonAnimation.FADE);
        r17.g0 = false;
        r17.h(false);
        Function1 r18 = new j3(this);
        Intrinsics.checkNotNullParameter(r18, "block");
        r17.O = new com.skydoves.balloon.j(r18);
        r17.l(new k3(this));
        AppCompatTextView r19 = this.a;
        if (r19 == null) goto L32;
        r10 = r19.getContext();
    L32:
        r17.c(v19.c.b(2130972060, r10, 2131243034));
        r17.k(r15);
        this.j = r17.b();
        Balloon r20 = this.j;
        if (r20 == null) goto L35;
        y.add(new WeakReference(r20));
    L35:
        b();
        r13.setOnClickListener(new l3(this));
        r14.setOnClickListener(new m3(this));
    L41:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }

    public final void g() {
        if (Intrinsics.areEqual(this.g, Boolean.FALSE) == false) goto L6;
        return;
    L6:
        if (this.w == false) goto L8;
        return;
    L8:
        AppCompatTextView r0 = this.a;
        r0.getClass();
        final View r1 = r0.getRootView();
        r1.post(new i3(this, r1));
    }

    @Override // st8.b.c
    public final void onShow() {
        if (this.n == false) goto L5;
        return;
    L5:
        this.o = true;
        FLogger.a.i("MessageMenu", "onShow");
        d();
        g();
    }

    @Override // st8.b.c
    public final void a(boolean r3) {
        c(this, r3, false, false, 6);
    }

    public final void e(String r2) {
        Intent r0 = new Intent(r2);
        ((LocalBroadcastManager) this.r.getValue()).sendBroadcast(r0);
    }

    public final void f(RecyclerView r4, o r5, com.larus.bmhome.chat.component.bottom.reference.a r6) {
        FLogger.a.i("MessageMenu", "show");
        this.k = r4;
        x = new WeakReference(this);
        Object r7 = this.a.getTag(2131373650);
        if ((r7 instanceof SelectorRestore) == false) goto L5;
        SelectorRestore r8 = (SelectorRestore) r7;
    L6:
        if (r8 == null) goto L10;
        Map<String, tt8.c> r9 = r8.b;
        if (r9 == null) goto L10;
        ((LinkedHashMap) r9).clear();
    L10:
        d();
        tt8.b r10 = this.a.m31getTextSelector();
        if (r10 == null) goto L13;
        r10.u = new d(r5, r6);
    L13:
        tt8.b r11 = this.a.m31getTextSelector();
        if (r11 == null) goto L16;
        r11.s = (b) this.v.getValue();
    L16:
        tt8.b r12 = this.a.m31getTextSelector();
        if (r12 == null) goto L19;
        r12.r((int) this.a.getClickX(), (int) this.a.getClickY(), this.u, this.t);
    L19:
        g();
        return;
    L5:
        r8 = null;
        goto L6
    }

    public static void c(MessageMenu r8, boolean r9, boolean r10, boolean r11, int r12) {
        boolean r1 = false;
        if ((r12 & 2) == 0) goto L6;
        r10 = false;
    L6:
        if ((r12 & 4) == 0) goto L8;
        r11 = false;
    L8:
        r8.getClass();
        if (r9 == true) goto L19;
        if (r10 == true) goto L19;
        long r2 = SystemClock.elapsedRealtime();
        if ((r2 - r8.p) <= 300) goto L19;
        r8.p = r2;
        Balloon r13 = r8.j;
        if (r13 != null) goto L16;
    L18:
        r8.o = r1;
        goto L19
    L16:
        if (r13.g != true) goto L18;
        r1 = true;
    L19:
        FLogger r14 = FLogger.a;
        StringBuilder r0 = new StringBuilder("onDismiss, fromClick=");
        r0.append(r9);
        r0.append(", fromSingleClickInSelectedArea=");
        r0.append(r10);
        r0.append(", isForce=");
        r0.append(r11);
        r0.append(", balloonShowing=");
        Balloon r15 = r8.j;
        if (r15 == null) goto L22;
        Boolean r16 = Boolean.valueOf(r15.g);
    L23:
        r0.append(r16);
        r0.append(", selectorShowing=");
        r0.append(r8.a.z());
        r0.append(", forbidShowAgain=");
        r0.append(r8.w);
        r14.i("MessageMenu", r0.toString());
        Balloon r17 = r8.j;
        if (r17 == null) goto L26;
        r17.h();
    L26:
        r8.j = null;
        if (r9 == false) goto L31;
        RecyclerView r18 = r8.k;
        if (r18 == null) goto L31;
        r18.removeOnScrollListener(r8.l);
    L31:
        if (r11 == true) goto L35;
        r8.b();
        return;
    L35:
        return;
    L22:
        r16 = null;
        goto L23
    }

    public /* synthetic */ MessageMenu(CustomMarkdownTextView r12, BotModel r13, Message r14, Boolean r15, Boolean r16, Function1 r17, int r18) {
        Boolean r1 = null;
        if ((r18 & 2) == 0) goto L5;
        BotModel r4 = null;
    L7:
        if ((r18 & 4) == 0) goto L9;
        Message r5 = null;
    L11:
        if ((r18 & 8) == 0) goto L13;
        Boolean r6 = Boolean.FALSE;
    L15:
        if ((r18 & 16) == 0) goto L17;
        Boolean r7 = Boolean.TRUE;
    L19:
        if ((r18 & 32) == 0) goto L21;
        Boolean r8 = Boolean.TRUE;
    L23:
        if ((r18 & 64) == 0) goto L25;
        r1 = Boolean.TRUE;
    L25:
        this(r12, r4, r5, r6, r7, r8, r1, r17);
        return;
    L21:
        r8 = null;
        goto L23
    L17:
        r7 = r16;
        goto L19
    L13:
        r6 = r15;
        goto L15
    L9:
        r5 = r14;
        goto L11
    L5:
        r4 = r13;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.larus.bmhome.view.MessageMenu$scrollListener$1] */
    public MessageMenu(CustomMarkdownTextView r2, BotModel r3, Message r4, Boolean r5, Boolean r6, Boolean r7, Boolean r8, Function1<? super Integer, Unit> r9) {
        Intrinsics.checkNotNullParameter(r2, "anchor");
        Intrinsics.checkNotNullParameter(r9, "callback");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.l = new MessageMenu$scrollListener$1(this);
        this.o = true;
        c r10 = new c(this);
        this.q = r10;
        this.r = LazyKt.lazy(new y2(this));
        this.u = 2;
        this.v = LazyKt.lazy(new h3(this));
        this.a.x(r10);
    }
}

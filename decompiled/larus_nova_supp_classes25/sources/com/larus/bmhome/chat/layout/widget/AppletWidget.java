package com.larus.bmhome.chat.layout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ai.widget.view.WidgetBoxView;
import com.larus.bmhome.chat.api.WidgetRenderDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common.apphost.AppHost;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.obric.assistant.spi.miniapp.IObricIntentWidgetPolicy;
import com.obric.assistant.spi.miniapp.ObricIntentWidgetUpdateMode;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class AppletWidget extends FrameLayout {
    public static final /* synthetic */ int y = 0;
    public int a;
    public float b;
    public float c;
    public float d;
    public float e;
    public com.larus.bmhome.chat.api.r f;
    public String g;
    public WidgetShowState h;
    public Function1<? super WidgetEvent, Unit> i;
    public String j;
    public c k;
    public com.larus.bmhome.chat.api.v0 l;
    public Job m;
    public final com.bytedance.ai.applet.base.log.i n;
    public kc8.n o;
    public kc8.e0 p;
    public View.OnLongClickListener q;
    public final CopyOnWriteArrayList<ic8.x> r;
    public final ImageView s;
    public final RelativeLayout t;
    public final RelativeLayout u;
    public final d v;
    public final Path w;
    public final RectF x;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/AppletWidget$WidgetEvent;", "", "<init>", "(Ljava/lang/String;I)V", "LAYOUT_FINISH", "SCROLL_TO_BOTTOM", "PAGE_UPDATE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final enum WidgetEvent extends Enum<WidgetEvent> {
        public static final WidgetEvent LAYOUT_FINISH = null;
        public static final WidgetEvent PAGE_UPDATE = null;
        public static final WidgetEvent SCROLL_TO_BOTTOM = null;
        public static final /* synthetic */ WidgetEvent[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<WidgetEvent> getEntries() {
            return b;
        }

        static {
            WidgetEvent r0 = new WidgetEvent("LAYOUT_FINISH", 0);
            LAYOUT_FINISH = r0;
            WidgetEvent r1 = new WidgetEvent("SCROLL_TO_BOTTOM", 1);
            SCROLL_TO_BOTTOM = r1;
            WidgetEvent r3 = new WidgetEvent("PAGE_UPDATE", 2);
            PAGE_UPDATE = r3;
            WidgetEvent[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static WidgetEvent[] values() {
            return (WidgetEvent[]) a.clone();
        }

        public static WidgetEvent valueOf(String r1) {
            return (WidgetEvent) r27.a.a(WidgetEvent.class, r1);
        }

        public WidgetEvent(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/AppletWidget$WidgetShowState;", "", "<init>", "(Ljava/lang/String;I)V", "LOADING", "FAIL", "SUCCESS", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final enum WidgetShowState extends Enum<WidgetShowState> {
        public static final WidgetShowState FAIL = null;
        public static final WidgetShowState LOADING = null;
        public static final WidgetShowState SUCCESS = null;
        public static final /* synthetic */ WidgetShowState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<WidgetShowState> getEntries() {
            return b;
        }

        static {
            WidgetShowState r0 = new WidgetShowState("LOADING", 0);
            LOADING = r0;
            WidgetShowState r1 = new WidgetShowState("FAIL", 1);
            FAIL = r1;
            WidgetShowState r3 = new WidgetShowState("SUCCESS", 2);
            SUCCESS = r3;
            WidgetShowState[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static WidgetShowState[] values() {
            return (WidgetShowState[]) a.clone();
        }

        public static WidgetShowState valueOf(String r1) {
            return (WidgetShowState) r27.a.a(WidgetShowState.class, r1);
        }

        public WidgetShowState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[ObricIntentWidgetUpdateMode.values().length];
            r0[ObricIntentWidgetUpdateMode.UPDATE_IN_PLACE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L20:
            r0[ObricIntentWidgetUpdateMode.RECREATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L26:
            r0[ObricIntentWidgetUpdateMode.DEFAULT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L8:
            a = r0;
            int[] r1 = new int[WidgetShowState.values().length];
            r1[WidgetShowState.LOADING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L22:
            r1[WidgetShowState.SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L28:
            r1[WidgetShowState.FAIL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L12:
            b = r1;
        }
    }

    public static final class c {
        public final String a;
        public final String b;
        public final Map<String, Object> c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            Map<String, Object> r5 = this.c;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "WidgetBindingKey(messageId=" + this.a + ", renderData=" + this.b + ", extra=" + this.c + ')';
        }

        public c(String r2, String r3, Map<String, ? extends Object> r4) {
            Intrinsics.checkNotNullParameter(r2, "messageId");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class d implements ic8.x {
        public final /* synthetic */ AppletWidget a;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[com.larus.bmhome.chat.bean.WidgetEvent.values().length];
                r0[com.larus.bmhome.chat.bean.WidgetEvent.SCROLL_TO_BOTTOM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[com.larus.bmhome.chat.bean.WidgetEvent.PAGE_UPDATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        @Override // ic8.x
        public final void a() {
            this.a.n.c("onPageStart: this = " + this);
            Iterator<T> r0 = this.a.r.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((ic8.x) r0.next()).a();
            goto L4
        }

        @Override // ic8.x
        public final void b() {
            this.a.n.c("onPageError: this = " + this);
            this.a.k(WidgetShowState.FAIL, false);
            Iterator<ic8.x> r0 = this.a.r.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().b();
            goto L4
        }

        @Override // ic8.x
        public final void c() {
            this.a.n.c("onPageFinish: this = " + this);
            this.a.k(WidgetShowState.SUCCESS, false);
            Iterator<ic8.x> r0 = this.a.r.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().c();
            goto L4
        }

        @Override // ic8.x
        public final void onDestroy() {
            Iterator<T> r0 = this.a.r.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((ic8.x) r0.next()).onDestroy();
            goto L4
        }

        @Override // ic8.x
        public final void onStart() {
            this.a.n.c("onStart: this = " + this);
            this.a.k(WidgetShowState.LOADING, false);
            Iterator<ic8.x> r0 = this.a.r.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().onStart();
            goto L4
        }

        public d(AppletWidget r1) {
            this.a = r1;
        }

        @Override // ic8.x
        public void onEvent(com.larus.bmhome.chat.bean.WidgetEvent r3) {
            Intrinsics.checkNotNullParameter(r3, "event");
            int r0 = a.a[r3.ordinal()];
            if (r0 != 1) goto L5;
            Function1<WidgetEvent, Unit> r1 = this.a.getWidgetEventCallback();
            if (r1 == null) goto L13;
            r1.invoke(WidgetEvent.SCROLL_TO_BOTTOM);
        L13:
            Iterator<T> r2 = this.a.r.iterator();
        L15:
            if (r2.hasNext() == false) goto L17;
            ((ic8.x) r2.next()).onEvent(r3);
            goto L15
        L17:
            return;
        L5:
            if (r0 != 2) goto L13;
            AppletWidget r4 = this.a;
            int r5 = AppletWidget.y;
            r4.f();
            Function1<WidgetEvent, Unit> r6 = this.a.getWidgetEventCallback();
            if (r6 == null) goto L13;
            r6.invoke(WidgetEvent.PAGE_UPDATE);
            goto L13
        }
    }

    static {
    }

    private final int getContentMaxWidth() {
        int r0 = this.a;
        kc8.n r1 = this.o;
        return Math.max((r0 - r1.a) - r1.c, 0);
    }

    public final void c() {
        this.w.reset();
        Path r0 = this.w;
        RectF r1 = this.x;
        float r3 = this.b;
        float r4 = this.c;
        float r5 = this.d;
        float r6 = this.e;
        r0.addRoundRect(r1, new float[]{r3, r3, r4, r4, r5, r5, r6, r6}, Path.Direction.CW);
        this.w.close();
        invalidate();
    }

    public final void f() {
        final View.OnLongClickListener r0 = this.q;
        if (r0 != null) goto L5;
        return;
    L5:
        com.larus.bmhome.chat.api.r r1 = this.f;
        if (r1 == null) goto L12;
        WidgetBoxView r2 = r1.a();
        if (r2 == null) goto L13;
        r2.post(new v(this, r0));
        return;
    L13:
        return;
    }

    public final void h() {
        int r0 = getContentMaxWidth();
        RelativeLayout r1 = this.t;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if (r2 == null) goto L19;
        r2.width = r0;
        r1.setLayoutParams(r2);
        RelativeLayout r3 = this.u;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        if (r4 == null) goto L17;
        r4.width = r0;
        r3.setLayoutParams(r4);
        com.larus.bmhome.chat.api.r r5 = this.f;
        if (r5 == null) goto L15;
        WidgetBoxView r6 = r5.a();
        if (r6 == null) goto L20;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if (r7 == null) goto L14;
        r7.width = r0;
        r6.setLayoutParams(r7);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L20:
        return;
    L15:
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.h != WidgetShowState.LOADING) goto L5;
        g(this.s);
        return;
    L5:
        this.s.clearAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.s.clearAnimation();
    }

    public final WidgetShowState getCurrentStatus() {
        return this.h;
    }

    public final int getMaxWidth() {
        return this.a;
    }

    public final com.larus.bmhome.chat.api.r getWidgetContainer() {
        return this.f;
    }

    public final Function1<WidgetEvent, Unit> getWidgetEventCallback() {
        return this.i;
    }

    public static final /* synthetic */ int a(AppletWidget r0) {
        return r0.getContentMaxWidth();
    }

    public static void g(ImageView r8) {
        RotateAnimation r7 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        r7.setDuration(600);
        r7.setRepeatCount(-1);
        r7.setRepeatMode(1);
        r7.setInterpolator(new LinearInterpolator());
        r8.startAnimation(r7);
    }

    public final void b(u r31) {
        Intrinsics.checkNotNullParameter(r31, "appletBindData");
        String r13 = r31.a;
        String r2 = r31.b;
        String r3 = r31.c;
        String r4 = r31.d;
        String r5 = r31.e;
        String r12 = r31.f;
        Fragment r11 = r31.g;
        int r9 = r31.h;
        Map<String, String> r10 = r31.i;
        Map<String, Object> r8 = r31.j;
        String r7 = r31.k;
        boolean r6 = r31.l;
        String r1 = r31.m;
        kc8.n r14 = r31.n;
        kc8.e0 r15 = r31.o;
        String r16 = r31.p;
        String r17 = r31.q;
        Map<String, Object> r0 = r31.r;
        Intrinsics.checkNotNullParameter(r13, "msgId");
        this.n.c("bindData: messageId = " + r13 + ", cardId = " + r7 + ", this = " + this);
        if (r14 != null) goto L5;
        r14 = new kc8.n(0, 0, 0, 0);
    L5:
        this.o = r14;
        setPadding(r14.a, r14.b, r14.c, r14.d);
        h();
        this.p = r15;
        int r18 = kc8.z0.a;
        com.larus.bmhome.chat.api.r r19 = this.f;
        if (r19 == null) goto L8;
        WidgetBoxView r20 = r19.a();
    L10:
        if (r20 == null) goto L12;
        r20.setTag(2131377375, r15);
    L12:
        d r21 = this.v;
        int r23 = getContentMaxWidth();
        LinkedHashMap r22 = new LinkedHashMap();
        r22.put("app_cold_start_time", Long.valueOf(((Number) AppHost.a.getAppStartTime().getSecond()).longValue() / ((long) 1000)));
        wc9.e r110 = IAIChatControlTraceService.a.h(IAIChatControlTraceService.a, r3);
        if (r110 == null) goto L17;
        Integer r111 = r110.E;
        if (r111 == null) goto L17;
        int r112 = r111.intValue();
    L18:
        r22.put("conversation_create_scene", Integer.valueOf(r112));
        if (r4 != null) goto L21;
        String r113 = "";
    L22:
        r22.put("section_id", r113);
        if (r0 == null) goto L25;
        r22.putAll(r0);
    L25:
        if (r16 != null) goto L27;
        r16 = "";
    L27:
        r22.put("origin_message_id", r16);
        com.larus.bmhome.chat.api.v0 r114 = new com.larus.bmhome.chat.api.v0(r13, r2, r3, r4, r5, r12, this, r21, r9, r23, r10, r8, r6, false, r1, r17, r22, 8192);
        if (r11 != null) goto L30;
        this.n.b("bindData: hostFragment is NULL", null);
        return;
    L30:
        c r24 = new c(r13, r12, r114.q);
        if (Intrinsics.areEqual(this.j, r13) == true) goto L33;
        boolean r25 = false;
        String r26 = this.j;
        if (r26 != null) goto L78;
    L81:
        boolean r27 = true;
    L82:
        if (r27 == true) goto L84;
        this.n.b("bindData: it is use again, msgId = " + r13 + ", it is " + this, null);
    L84:
        this.j = r13;
        this.k = r24;
        this.g = r12;
    L85:
        WidgetRenderDelegate r28 = WidgetRenderDelegate.a;
        if (r7 != null) goto L88;
    L95:
        String r115 = r13;
    L96:
        int r29 = r28.i(r115, getResources().getDimensionPixelOffset(v19.c.b(2130971179, null, 2131166727)));
        this.n.a("bindData currentStatus=" + this.h + ' ' + this + " widgetContainer=" + this.f + " height: " + r29 + ' ');
        this.t.getLayoutParams().height = r29;
        this.u.getLayoutParams().height = r29;
        Job r30 = this.m;
        if (r30 != null) goto L99;
    L101:
        if (r25 == false) goto L105;
        this.n.b("bindData: bindJob is Active", null);
        Job r32 = this.m;
        if (r32 == null) goto L105;
        Job.DefaultImpls.cancel$default(r32, null, 1, null);
    L105:
        this.m = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r11), this.n.b, null, new AppletWidget$bindData$1(r11, r114, this, null), 2, null);
        return;
    L99:
        if (r30.isActive() != true) goto L101;
        r25 = true;
        goto L101
    L88:
        if (r7.length() <= 0) goto L90;
        boolean r33 = true;
    L91:
        if (r33 == false) goto L93;
        r115 = r7;
    L94:
        if (r115 != null) goto L96;
    L93:
        r115 = null;
        goto L94
    L90:
        r33 = false;
        goto L91
    L78:
        if (r26.length() == 0) goto L81;
        r27 = false;
        goto L82
    L33:
        if (Intrinsics.areEqual(this.k, r24) == true) goto L74;
        this.n.c("bindData: update same message");
        com.larus.bmhome.chat.api.v0 r34 = com.larus.bmhome.chat.api.v0.a(r114, this.g, 131039);
        this.k = r24;
        this.g = r12;
        IObricIntentWidgetPolicy r35 = (IObricIntentWidgetPolicy) ServiceManager.get().getService(IObricIntentWidgetPolicy.class);
        if (r35 == null) goto L40;
        rga.a r36 = r35.resolve(r12);
        if (r36 == null) goto L40;
        r25 = false;
    L41:
        ObricIntentWidgetUpdateMode r37 = r36.a;
        if (this.f != null) goto L44;
        this.l = r114;
        return;
    L44:
        int r38 = b.a[r37.ordinal()];
        if (r38 != 1) goto L47;
        this.l = null;
        com.larus.bmhome.chat.api.r r39 = this.f;
        if (r39 == null) goto L110;
        r39.updateData(r12);
        return;
    L110:
        return;
    L47:
        if (r38 != 2) goto L49;
        this.n.c("bindData: recreate widget for updated render data");
        Job r40 = this.m;
        if (r40 == null) goto L56;
        Job.DefaultImpls.cancel$default(r40, null, 1, null);
    L56:
        this.l = null;
        com.larus.bmhome.chat.api.r r41 = this.f;
        if (r41 == null) goto L59;
        WidgetBoxView r42 = r41.a();
    L60:
        if (r42 == null) goto L62;
        r42.setTag(2131377375, null);
    L62:
        if (r42 == null) goto L64;
        r42.setOnLongClickListener(null);
    L64:
        WidgetRenderDelegate.a.d(r11, com.larus.bmhome.chat.api.v0.a(r34, null, 122879));
        if (r42 == null) goto L67;
        ViewParent r43 = r42.getParent();
    L68:
        if (r43 != this) goto L70;
        removeView(r42);
    L70:
        this.f = null;
        k(WidgetShowState.LOADING, true);
        goto L85
    L67:
        r43 = null;
        goto L68
    L59:
        r42 = null;
        goto L60
    L49:
        if (r38 != 3) goto L52;
        this.l = null;
        WidgetRenderDelegate.a.e(r11, r114);
        return;
    L52:
        throw new NoWhenBranchMatchedException();
    L40:
        r25 = false;
        r36 = new rga.a(0);
        goto L41
    L74:
        this.n.a("bindData: skip unchanged message");
        return;
    L21:
        r113 = r4;
    L17:
        r112 = 0;
        goto L18
    L8:
        r20 = null;
        goto L10
    }

    public final void d(View r4) {
        if (r4.getVisibility() != 8) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return;
    L9:
        if (r4.getMeasuredWidth() == getMeasuredWidth()) goto L11;
    L13:
        r4.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        return;
    L11:
        if (r4.getMeasuredHeight() != getMeasuredHeight()) goto L13;
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        r2.clipPath(this.w);
        super.dispatchDraw(r2);
    }

    public final void i(View.OnLongClickListener r2) {
        setOnLongClickListener(r2);
        com.larus.bmhome.chat.api.r r0 = this.f;
        if (r0 == null) goto L8;
        WidgetBoxView r1 = r0.a();
        if (r1 == null) goto L9;
        r1.setOnLongClickListener(r2);
        return;
    L9:
        return;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        r2.clipPath(this.w);
        super.onDraw(r2);
    }

    public final void setMaxWidth(int r1) {
        this.a = r1;
        h();
    }

    public final void setWidgetContainer(com.larus.bmhome.chat.api.r r1) {
        this.f = r1;
    }

    public final void setWidgetEventCallback(Function1<? super WidgetEvent, Unit> r1) {
        this.i = r1;
    }

    public final void k(WidgetShowState r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "showState");
        if (this.h != r2) goto L6;
        if (r3 == true) goto L6;
        return;
    L6:
        this.h = r2;
        int r4 = b.b[r2.ordinal()];
        if (r4 != 1) goto L9;
        com.larus.utils.e1.x(this.t);
        g(this.s);
        com.larus.utils.e1.o(this.u);
        return;
    L9:
        if (r4 != 2) goto L11;
        f();
        this.s.clearAnimation();
        com.larus.utils.e1.o(this.t);
        com.larus.utils.e1.o(this.u);
        GradientDrawable r5 = new GradientDrawable();
        r5.setColor(0);
        setBackground(r5);
        Function1<? super WidgetEvent, Unit> r6 = this.i;
        if (r6 == null) goto L21;
        r6.invoke(WidgetEvent.LAYOUT_FINISH);
        return;
    L21:
        return;
    L11:
        if (r4 != 3) goto L14;
        this.s.clearAnimation();
        com.larus.utils.e1.x(this.u);
        com.larus.utils.e1.o(this.t);
        return;
    L14:
        throw new NoWhenBranchMatchedException();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        d(this.t);
        d(this.u);
    }

    public final void j(Float r1, Float r2, Float r3, Float r4) {
        if (r1 == null) goto L4;
        this.b = r1.floatValue();
    L4:
        if (r2 == null) goto L6;
        this.c = r2.floatValue();
    L6:
        if (r3 == null) goto L8;
        this.d = r3.floatValue();
    L8:
        if (r4 == null) goto L10;
        this.e = r4.floatValue();
    L10:
        c();
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.x.set(0.0f, 0.0f, r1, r2);
        c();
    }

    public AppletWidget(Context r7, int r8, float r9, float r10, float r11, float r12) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7);
        this.a = r8;
        this.b = r9;
        this.c = r10;
        this.d = r11;
        this.e = r12;
        this.h = WidgetShowState.LOADING;
        this.n = new com.bytedance.ai.applet.base.log.i("AppletWidget", new com.bytedance.ai.applet.base.log.e(MapsKt.mapOf(TuplesKt.to("logId", com.bytedance.ai.applet.base.log.e.c + '-' + com.bytedance.ai.applet.base.log.e.d.incrementAndGet()))));
        this.o = new kc8.n(0, 0, 0, 0);
        this.r = new CopyOnWriteArrayList();
        ImageView r13 = new ImageView(r7);
        r13.setImageResource(2131243656);
        r13.setScaleType(ImageView.ScaleType.FIT_CENTER);
        RelativeLayout.LayoutParams r14 = new RelativeLayout.LayoutParams(r13.getResources().getDimensionPixelOffset(v19.c.b(2130971481, null, 2131167332)), r13.getResources().getDimensionPixelOffset(v19.c.b(2130971481, null, 2131167332)));
        r14.addRule(13);
        r13.setLayoutParams(r14);
        this.s = r13;
        RelativeLayout r15 = new RelativeLayout(r7);
        r15.setLayoutParams(new ViewGroup.LayoutParams(this.a, r15.getResources().getDimensionPixelOffset(v19.c.b(2130971179, null, 2131166727))));
        r15.setVisibility(0);
        r15.setBackgroundResource(2131102542);
        this.t = r15;
        RelativeLayout r16 = new RelativeLayout(r7);
        r16.setLayoutParams(new ViewGroup.LayoutParams(this.a, r16.getResources().getDimensionPixelOffset(v19.c.b(2130971179, null, 2131166727))));
        r16.setVisibility(8);
        r16.setBackgroundResource(2131102542);
        this.u = r16;
        ImageView r17 = new ImageView(r7);
        r17.setImageResource(2131243655);
        r17.setScaleType(ImageView.ScaleType.FIT_CENTER);
        RelativeLayout.LayoutParams r18 = new RelativeLayout.LayoutParams(r17.getResources().getDimensionPixelOffset(v19.c.b(2130971514, null, 2131167397)), r17.getResources().getDimensionPixelOffset(v19.c.b(2130971514, null, 2131167397)));
        r18.addRule(13);
        r17.setLayoutParams(r18);
        this.v = new d(this);
        r15.addView(r13);
        r16.addView(r17);
        addView(r15);
        addView(r16);
        this.w = new Path();
        this.x = new RectF();
    }

    public final void e(Fragment r21, String r22, String r23, String r24, String r25, String r26, int r27, boolean r28) {
        Intrinsics.checkNotNullParameter(r22, "messageId");
        this.n.c("onViewRecycled: messageId = " + r22 + ", this = " + this);
        this.j = null;
        this.k = null;
        this.l = null;
        Job r2 = this.m;
        if (r2 == null) goto L5;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L5:
        this.p = null;
        this.q = null;
        com.larus.bmhome.chat.api.r r3 = this.f;
        if (r3 == null) goto L8;
        WidgetBoxView r4 = r3.a();
    L9:
        int r5 = kc8.z0.a;
        if (r4 == null) goto L12;
        r4.setTag(2131377375, null);
    L12:
        i(null);
        this.r.clear();
        if (r4 == null) goto L15;
        ViewParent r6 = r4.getParent();
    L17:
        if (Intrinsics.areEqual(r6, this) == true) goto L28;
        com.bytedance.ai.applet.base.log.i r7 = this.n;
        String r0 = "onViewRecycled: messageId=" + r22 + ", this=" + this + ", widgetView is not added";
        r7.getClass();
        Intrinsics.checkNotNullParameter(r0, "msg");
        ThreadLocal r8 = com.bytedance.ai.applet.base.log.f.a;
        com.bytedance.ai.applet.base.log.e r9 = r7.b;
        if (r9.a.isEmpty() == false) goto L21;
        com.bytedance.ai.applet.base.log.b r10 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.d(r7.a, r0, null);
        return;
    L21:
        Map r11 = (Map) com.bytedance.ai.applet.base.log.f.a.get();
        com.bytedance.ai.applet.base.log.f.b(MapsKt.plus(com.bytedance.ai.applet.base.log.f.a(), r9.a));
        com.bytedance.ai.applet.base.log.b r12 = com.bytedance.ai.applet.base.log.a.a;     // Catch: Throwable -> L25
        com.bytedance.ai.applet.base.log.a.d(r7.a, r0, null);     // Catch: Throwable -> L25
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L25
        com.bytedance.ai.applet.base.log.f.b(r11);
        return;
    L25:
        th = move-exception;
        com.bytedance.ai.applet.base.log.f.b(r11);
        throw th;
    L28:
        if (r4 == null) goto L30;
        removeView(r4);
    L30:
        WidgetRenderDelegate.a.d(r21, new com.larus.bmhome.chat.api.v0(r22, r23, r24, r25, r26, this.g, this, this.v, r27, this.a, null, null, false, r28, null, null, null, 53248));
        return;
    L15:
        r6 = null;
        goto L17
    L8:
        r4 = null;
        goto L9
    }
}

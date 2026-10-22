package com.bytedance.android.livesdk.clearscreen.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.core.element.tetris.TetrisElement;
import com.bytedance.android.live.core.tetris.layer.core.element.widget.WidgetElement;
import com.bytedance.android.live.core.utils.x1;
import com.bytedance.android.live.core.widget.g;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenConst;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.clearscreen.h;
import com.bytedance.android.livesdk.clearscreen.i;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ClearScreenUtils {
    public boolean a;
    public final HashSet<i> b;
    public final HashSet<i> c;
    public final HashSet<i> d;
    public final HashSet<i> e;
    public final HashMap<String, i> f;
    public final HashMap<i, String> g;
    public final SparseArray<HashSet<String>> h;
    public final SparseArray<HashSet<String>> i;
    public final ArrayList<String> j;
    public final Lazy k;
    public long l;
    public final Lazy m;
    public final Lazy n;
    public final String o;

    public static final class a extends AnimatorListenerAdapter {
        public final /* synthetic */ i a;
        public final /* synthetic */ ClearScreenUtils b;
        public final /* synthetic */ boolean c;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r6) {
            Intrinsics.checkNotNullParameter(r6, "animation");
            if (this.c == false) goto L45;
            i r7 = this.a;
            ArrayList<String> r0 = this.b.j;
            r7.getClass();
            Intrinsics.checkNotNullParameter(r0, "clearGoneList");
            if (((Boolean) LiveInfraSettingKeys.LIVE_CLEAR_SCREEN_WIDGET_GONE_OPTIMIZE.getValue()).booleanValue() == true) goto L7;
            return;
        L7:
            if (((Boolean) LiveInfraSettingKeys.LIVE_CLEAR_SCREEN_WIDGET_GONE_OPTIMIZE_SWITCHER.getValue()).booleanValue() == false) goto L88;
            boolean r1 = r7.e;
            if (r1 == true) goto L21;
            WidgetElement r3 = r7.a;
            if ((r3 instanceof WidgetElement) == false) goto L21;
            if (r3 == null) goto L20;
            com.bytedance.android.livesdk.common.i r8 = (com.bytedance.android.livesdk.common.i) r3.f(com.bytedance.android.livesdk.common.i.class);
            if (r8 == null) goto L79;
            String r9 = r8.Lg();
            if (r9 == null) goto L80;
            r0.add(r9);
            return;
        L80:
            return;
        L79:
            return;
        L20:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.layer.core.element.widget.WidgetElement");
        L21:
            if (r1 == true) goto L82;
            TetrisElement r10 = r7.a;
            if ((r10 instanceof TetrisElement) == false) goto L83;
            if (r10 == null) goto L44;
            List r11 = r10.m;
            ArrayList r2 = new ArrayList();
            Iterator r12 = ((ArrayList) r11).iterator();
        L27:
            if (r12.hasNext() == false) goto L31;
            Object r4 = r12.next();
            if ((((Element) r4) instanceof WidgetElement) == false) goto L27;
            r2.add(r4);
            goto L27
        L31:
            Iterator r13 = r2.iterator();
        L33:
            if (r13.hasNext() == false) goto L89;
            WidgetElement r5 = (Element) r13.next();
            if (r5 == null) goto L42;
            com.bytedance.android.livesdk.common.i r14 = (com.bytedance.android.livesdk.common.i) r5.f(com.bytedance.android.livesdk.common.i.class);
            if (r14 == null) goto L33;
            String r15 = r14.Lg();
            if (r15 == null) goto L33;
            r0.add(r15);
            goto L33
        L42:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.layer.core.element.widget.WidgetElement");
        L89:
            return;
        L44:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.layer.core.element.tetris.TetrisElement");
        L83:
            return;
        L82:
            return;
        L88:
            return;
        L45:
            Room r16 = null;
            RoomContext r17 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r17 == null) goto L51;
            m r18 = r17.getRoom();
            if (r18 == null) goto L51;
            r16 = (Room) r18.getValue();
        L51:
            if (VrUtils.x(r16) == false) goto L58;
            if (this.a.c() == true) goto L58;
            if (VrUtils.B() == false) goto L58;
            this.a.e(0);
            return;
        L58:
            if (this.c == false) goto L60;
            return;
        L60:
            if (this.a.c() == false) goto L62;
            return;
        L62:
            if (((Boolean) ClearScreenHelper.g.getValue()).booleanValue() == false) goto L87;
            this.a.e(0);
            return;
        }

        public a(i r1, ClearScreenUtils r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class b extends AnimatorListenerAdapter {
        public final /* synthetic */ i a;
        public final /* synthetic */ float b;
        public final /* synthetic */ boolean c;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            if ((!Intrinsics.areEqual(this.a.a(), this.b)) == false) goto L13;
            i r4 = this.a;
            float r0 = this.b;
            if (r4.e == false) goto L9;
            View r5 = r4.c;
            if (r5 == null) goto L13;
            r5.setAlpha(r0);
            goto L13
        L9:
            v70.c r6 = r4.b;
            if (r6 == null) goto L13;
            r6.setAlpha(r0);
        L13:
            if (this.c == false) goto L16;
            this.a.e(8);
            return;
        L16:
            if (this.a.c() == true) goto L20;
            this.a.e(0);
            return;
        }

        public b(i r1, float r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public final long f() {
        return ((Number) this.k.getValue()).longValue();
    }

    public final HashMap<ClearScreenConst.InteractType, jg1.a> g() {
        return (HashMap) this.n.getValue();
    }

    public final boolean h() {
        return ((Boolean) this.m.getValue()).booleanValue();
    }

    public final void m() {
        Iterator<T> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        i r1 = (i) r0.next();
        ViewPropertyAnimator r2 = r1.f;
        if (r2 == null) goto L8;
        r2.setListener(null);
    L8:
        ViewPropertyAnimator r3 = r1.f;
        if (r3 == null) goto L4;
        r3.cancel();
        goto L4
    L11:
        this.c.clear();
        this.e.clear();
        this.d.clear();
        this.b.clear();
        this.g.clear();
        this.f.clear();
        if (wt2.a.g() == false) goto L14;
        HashMap<ClearScreenConst.InteractType, jg1.a> r4 = g();
        ClearScreenUtils$reset$2 r5 = ClearScreenUtils$reset$2.INSTANCE;
        CollectionsKt.removeAll(r4.entrySet(), r5);
    L15:
        int r6 = 0;
        this.a = false;
        this.j.clear();
        if (h() == false) goto L18;
        ALogger.i("ClearScreenManager", "CleanScreenUtils的reset方法");
    L18:
        int r7 = this.i.size();
        int r8 = 0;
    L19:
        if (r8 >= r7) goto L21;
        int r9 = this.i.keyAt(r8);
        this.i.get(r9).clear();
        r8 = r8 + 1;
        goto L19
    L21:
        int r10 = this.h.size();
    L22:
        if (r6 >= r10) goto L24;
        int r11 = this.h.keyAt(r6);
        this.h.get(r11).clear();
        r6 = r6 + 1;
        goto L22
    L24:
        return;
    L14:
        g().clear();
        goto L15
    }

    public ClearScreenUtils(String r1) {
        this.o = r1;
        this.b = new HashSet();
        this.c = new HashSet();
        this.d = new HashSet();
        this.e = new HashSet();
        this.f = new HashMap();
        this.g = new HashMap();
        this.h = new SparseArray();
        this.i = new SparseArray();
        this.j = new ArrayList();
        this.k = LazyKt.lazy(ClearScreenUtils$animDuration$2.INSTANCE);
        this.m = LazyKt.lazy(ClearScreenUtils$inTestChannel$2.INSTANCE);
        this.n = LazyKt.lazy(ClearScreenUtils$clearAssistants$2.INSTANCE);
    }

    public final Pair<Boolean, ClearScreenConst.InteractType> b(boolean r6) {
        Iterator<jg1.a> r0 = g().values().iterator();
    L4:
        if (r0.hasNext() == false) goto L25;
        jg1.a r1 = r0.next();
        if (r1 == null) goto L4;
        if (r1.e(new jg1.b.a()) != true) goto L4;
        if (r6 == false) goto L16;
        int r7 = gs1.a.a;
        h r8 = gs1.a.a(this.o);
        if (r8 == null) goto L14;
        r8.e(r1.getInteractType());
    L14:
        if (h() == false) goto L23;
        ALogger.d("ClearScreenManager", "被拦截，进入清屏，当前状态变为 " + r1.getInteractType());
    L23:
        return new Pair(Boolean.FALSE, r1.getInteractType());
    L16:
        int r9 = gs1.a.a;
        h r10 = gs1.a.a(this.o);
        if (r10 == null) goto L20;
        r10.e(ClearScreenConst.InteractType.INTERACT_SHOW);
    L20:
        if (h() == false) goto L23;
        ALogger.d("ClearScreenManager", "被拦截，退出清屏，当前状态变为 NON_CLEAR");
        goto L23
    L25:
        if (h() == false) goto L28;
        ALogger.d("ClearScreenManager", "没被拦截");
    L28:
        return new Pair(Boolean.TRUE, ClearScreenConst.InteractType.INTERACT_SHOW);
    }

    public final void i(boolean r5) {
        HashSet<i> r0 = this.b;
        if (r0 == null) goto L25;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L39;
        i r2 = (i) r1.next();
        if (r5 == false) goto L10;
        int r3 = 8;
    L11:
        r2.e(r3);
        ViewPropertyAnimator r4 = r2.b();
        if (r4 == null) goto L6;
        if (r5 == false) goto L15;
        float r6 = 0.0f;
    L16:
        ViewPropertyAnimator r7 = r4.alpha(r6);
        if (r7 == null) goto L6;
        ViewPropertyAnimator r8 = r7.setListener(null);
        if (r8 == null) goto L6;
        ViewPropertyAnimator r9 = r8.setDuration(f());
        if (r9 == null) goto L6;
        ViewPropertyAnimator r10 = r9.setInterpolator(new g());
        if (r10 == null) goto L6;
        r10.start();
        goto L6
    L15:
        r6 = 1.0f;
        goto L16
    L10:
        r3 = 0;
        goto L11
    L39:
        return;
    }

    public final void p(float r7) {
        HashSet<i> r0 = this.c;
        ArrayList r1 = new ArrayList();
        Iterator<i> r2 = r0.iterator();
    L3:
        boolean r3 = false;
        if (r2.hasNext() == false) goto L10;
        i r4 = r2.next();
        if (r4.d != ClearScreenConst.AnimType.TRANS) goto L8;
        r3 = true;
    L8:
        if (r3 == false) goto L3;
        r1.add(r4);
        goto L3
    L10:
        Iterator r5 = r1.iterator();
    L12:
        if (r5.hasNext() == false) goto L34;
        i r6 = (i) r5.next();
        if (this.j.size() == 0) goto L17;
        r6.d(this.j);
    L17:
        if (r6.e == false) goto L21;
        View r8 = r6.c;
        if (r8 == null) goto L24;
        int r9 = r8.getLeft();
    L25:
        float r10 = r9 + r7;
        if (r6.e == true) goto L27;
        v70.c r11 = r6.b;
        if (r11 == null) goto L12;
        r11.setX(r10);
        goto L12
    L27:
        View r12 = r6.c;
        if (r12 == null) goto L12;
        r12.setX(r10);
    L24:
        r9 = 0;
        goto L25
    L21:
        v70.c r13 = r6.b;
        if (r13 == null) goto L24;
        r9 = r13.a.getLeft();
        goto L25
    L34:
        if (this.j.size() == 0) goto L52;
        ClearScreenLogUtils.Companion r14 = ClearScreenLogUtils.a;
        ArrayList<String> r15 = this.j;
        r14.getClass();
        ClearScreenLogUtils.Companion.g(r15);
        this.j.clear();
        return;
    }

    public static boolean q(HashSet r4, i r5) {
        d90.d r0 = r5.i;
        DataCenter r1 = null;
        if (r0 != null) goto L12;
        Element<?> r2 = r5.a;
        if (r2 == null) goto L7;
        h70.b r3 = r2.k;
    L9:
        if ((r3 instanceof d90.d) == true) goto L11;
        r3 = null;
    L11:
        r0 = (d90.d) r3;
        goto L12
    L7:
        r3 = null;
    L12:
        boolean r6 = false;
        if (r4.contains(r5) == true) goto L15;
    L46:
        ALogger.d("ClearScreenManager", "shouldClearWhenScan " + r6 + "， view:" + r5.g);
        return r6;
    L15:
        if (gs1.b.a == false) goto L46;
        if (r0 == null) goto L46;
        MiddlewareRoomContext r7 = d90.e.l(r0);
        if (r7 == null) goto L46;
        m r8 = r7.getCleanMode();
        if (r8 == null) goto L46;
        Integer r9 = (Integer) r8.getValue();
        if (r9 == null) goto L46;
        if (r9.intValue() == ClearScreenConst.InteractType.SCROLL_CLEAR.getId()) goto L26;
        boolean r10 = true;
    L27:
        if (r10 != true) goto L46;
        DataCenter r11 = r5.h;
        if (r11 != null) goto L42;
        d90.d r12 = r5.i;
        if (r12 != null) goto L40;
        Element<?> r13 = r5.a;
        if (r13 == null) goto L35;
        h70.b r14 = r13.k;
    L37:
        if ((r14 instanceof d90.d) == true) goto L39;
        r14 = null;
    L39:
        r12 = (d90.d) r14;
        goto L40
    L35:
        r14 = null;
    L40:
        if (r12 == null) goto L44;
        r1 = r12.h;
    L44:
        if (ClearScreenHelper.i(r1) == false) goto L46;
        r6 = true;
        goto L46
    L42:
        r1 = r11;
        goto L44
    L26:
        r10 = false;
        goto L27
    }

    public final boolean c(i r4, SparseArray<HashSet<String>> r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "map");
        String r6 = this.g.get(r4);
        if (r6 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return false;
    L11:
        HashSet<String> r7 = r5.get(wt2.a.o());
        if (r7 == null) goto L19;
        Iterator<String> r8 = r7.iterator();
    L15:
        if (r8.hasNext() == false) goto L19;
        if (Intrinsics.areEqual(r6, r8.next()) == false) goto L15;
        return true;
    L19:
        return false;
    L5:
        if (r6.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final void k(int r2, j70.f r3) {
        Intrinsics.checkNotNullParameter(r3, "element");
        a(r2, r3, this.i);
    }

    public final void l(int r2, j70.f r3) {
        Intrinsics.checkNotNullParameter(r3, "element");
        a(r2, r3, this.h);
    }

    public static void a(int r1, j70.f r2, SparseArray r3) {
        Intrinsics.checkNotNullParameter(r2, "element");
        Intrinsics.checkNotNullParameter(r3, "map");
        if (r3.get(r1) != null) goto L5;
        r3.put(r1, new HashSet());
    L5:
        HashSet r4 = (HashSet) r3.get(r1);
        if (r4 == null) goto L9;
        r4.add(r2.a);
        return;
    }

    public static boolean e(int r2, j70.f r3, SparseArray r4) {
        Intrinsics.checkNotNullParameter(r3, "elementType");
        Intrinsics.checkNotNullParameter(r4, "map");
        if (r4.get(r2) != null) goto L5;
        return false;
    L5:
        Object r5 = r4.get(r2);
        Intrinsics.checkNotNull(r5);
        if (((HashSet) r5).contains(r3.a) == true) goto L8;
        return false;
    L8:
        return true;
    }

    public final void j(String r3, View r4, e0 r5) {
        Intrinsics.checkNotNullParameter(r3, "description");
        Intrinsics.checkNotNullParameter(r4, "view");
        i r0 = new i(r4, ClearScreenConst.AnimType.ALPHA, r3, r5);
        this.f.put(r3, r0);
        this.g.put(r0, r3);
    }

    public final void o(j70.f r5, View r6, e0 r7) {
        Intrinsics.checkNotNullParameter(r5, "elementType");
        Intrinsics.checkNotNullParameter(r6, "view");
        i r1 = new i(r6, ClearScreenConst.AnimType.ALPHA, r5.a, r7);
        this.f.put(r5.a, r1);
        this.g.put(r1, r5.a);
        int r8 = wt2.a.o();
        Intrinsics.checkNotNullParameter(r5, "elementType");
        if (e(r8, r5, this.i) == false) goto L6;
        this.b.add(r1);
    L6:
        if (q(this.b, r1) == false) goto L9;
        r1.e(0);
        return;
    }

    public final void n(Element<?> r4, ClearScreenConst.AnimType r5, boolean r6, Function1<? super Element<?>, Unit> r7) {
        Intrinsics.checkNotNullParameter(r4, "element");
        Intrinsics.checkNotNullParameter(r5, "animType");
        Intrinsics.checkNotNullParameter(r7, "otherAddView");
        i r0 = new i(r4, r5);
        r0.j = r6;
        this.f.put(r4.d.a, r0);
        this.g.put(r0, r4.d.a);
        int r8 = wt2.a.o();
        j70.f r9 = r4.d;
        Intrinsics.checkNotNullParameter(r9, "elementType");
        if (e(r8, r9, this.h) == true) goto L24;
        this.c.add(r0);
        if (h() == false) goto L7;
        ALogger.d("ClearScreenManager", "当前添加元素为 " + r0.g);
    L7:
        r7.invoke(r4);
        Room r10 = null;
        RoomContext r11 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r11 == null) goto L13;
        m r12 = r11.getRoom();
        if (r12 == null) goto L13;
        r10 = (Room) r12.getValue();
    L13:
        if (VrUtils.x(r10) == true) goto L15;
    L22:
        r0.e(0);
        goto L24
    L15:
        if (VrUtils.B() == false) goto L22;
        if (r11 == null) goto L22;
        m r13 = r11.getVrInImmersedMode();
        if (r13 == null) goto L22;
        if (((Boolean) r13.getValue()).booleanValue() != true) goto L22;
        r0.e(8);
    L24:
        if (q(this.c, r0) == false) goto L27;
        r0.e(8);
        return;
    }

    public final void d(i r9, float r10, boolean r11, boolean r12, ClearScreenConst.AnimType r13, long r14) {
        Intrinsics.checkNotNullParameter(r13, "animType");
        if (r9 == null) goto L7;
        List r15 = CollectionsKt.listOf(r9);
        if (r15 == null) goto L7;
        List r16 = r15;
    L8:
        ArrayList r0 = new ArrayList();
        Iterator r17 = r16.iterator();
    L9:
        boolean r2 = false;
        if (r17.hasNext() == false) goto L18;
        Object r1 = r17.next();
        i r4 = (i) r1;
        if (r12 == false) goto L14;
    L15:
        r2 = true;
    L16:
        if (r2 == false) goto L9;
        r0.add(r1);
        goto L9
    L14:
        if (r4.d != r13) goto L16;
    L18:
        Iterator r18 = r0.iterator();
    L20:
        if (r18.hasNext() == false) goto L93;
        i r3 = (i) r18.next();
        boolean r5 = r3.j;
        if (r5 == false) goto L31;
        if (r5 == false) goto L20;
        Element<?> r6 = r3.a;
        if (r6 == null) goto L29;
        com.bytedance.android.live.room.api.visibilitycontrol.b r7 = (com.bytedance.android.live.room.api.visibilitycontrol.b) r6.f(com.bytedance.android.live.room.api.visibilitycontrol.b.class);
        if (r7 == null) goto L29;
        boolean r8 = r7.canControlByClearScreenService();
    L30:
        if (r8 == false) goto L20;
    L29:
        r8 = true;
    L31:
        ViewPropertyAnimator r19 = r3.b();
        if (r19 == null) goto L34;
        r19.cancel();
    L34:
        int r20 = com.bytedance.android.livesdk.clearscreen.utils.b.a[r13.ordinal()];
        if (r20 != 1) goto L37;
        if (r11 == false) goto L59;
    L76:
        ViewPropertyAnimator r21 = r3.b();
        if (r21 == null) goto L91;
        if (r11 == false) goto L80;
        float r22 = r10;
    L81:
        ViewPropertyAnimator r23 = r21.translationX(r22);
        if (r23 == null) goto L91;
        ViewPropertyAnimator r24 = r23.setDuration(r14);
        if (r24 == null) goto L91;
        ViewPropertyAnimator r25 = r24.setInterpolator(new g());
        if (r25 == null) goto L91;
        ViewPropertyAnimator r26 = r25.setListener(new a(r3, this, r11));
        if (r26 == null) goto L91;
        r26.start();
        goto L91
    L80:
        r22 = 0.0f;
    L91:
        if (h() == false) goto L20;
        ALogger.i("ClearScreenManager", "当前要操作的元素内容 " + r3.g + ", enableCustom: " + r12 + ", animType: " + r13.getId() + ", isClear: " + r11);
        goto L20
    L59:
        if (this.j.size() == 0) goto L74;
        HashSet<i> r27 = this.c;
        ArrayList r28 = new ArrayList();
        Iterator<i> r29 = r27.iterator();
    L62:
        if (r29.hasNext() == false) goto L69;
        i r30 = r29.next();
        if (r30.d != ClearScreenConst.AnimType.TRANS) goto L66;
        boolean r31 = true;
    L67:
        if (r31 == false) goto L62;
        r28.add(r30);
        goto L62
    L66:
        r31 = false;
        goto L67
    L69:
        Iterator r32 = r28.iterator();
    L71:
        if (r32.hasNext() == false) goto L74;
        ((i) r32.next()).d(this.j);
    L74:
        if (this.j.size() == 0) goto L76;
        ClearScreenLogUtils.Companion r33 = ClearScreenLogUtils.a;
        ArrayList<String> r34 = this.j;
        r33.getClass();
        ClearScreenLogUtils.Companion.g(r34);
        this.j.clear();
        goto L76
    L37:
        if (r20 != 2) goto L39;
        if (r11 == true) goto L46;
        r3.e(0);
    L46:
        float r35 = 1 - (r10 / x1.h());
        ViewPropertyAnimator r36 = r3.b();
        if (r36 == null) goto L91;
        ViewPropertyAnimator r37 = r36.alpha(r35);
        if (r37 == null) goto L91;
        ViewPropertyAnimator r38 = r37.setDuration(r14);
        if (r38 == null) goto L91;
        ViewPropertyAnimator r39 = r38.setInterpolator(new g());
        if (r39 == null) goto L91;
        ViewPropertyAnimator r40 = r39.setListener(new b(r3, r35, r11));
        if (r40 == null) goto L91;
        r40.start();
        goto L91
    L39:
        if (r20 != 3) goto L91;
        if (r11 == false) goto L43;
        r3.e(8);
        goto L91
    L43:
        r3.e(0);
        goto L91
    L93:
        return;
    L7:
        r16 = this.c;
        goto L8
    }
}

package com.bytedance.android.livesdk.clearscreen;

import am2.x;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.tetris.widgets.y;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenConst;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenHelper;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenLogUtils;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenUtils;
import com.bytedance.android.livesdk.config.uk;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h implements jg1.b {
    public ViewGroup a;
    public ViewGroup.LayoutParams b;
    public View c;
    public int d;
    public final HashMap<ToolbarButton, Pair<j70.f, String>> e;
    public int f;
    public long g;
    public long h;
    public long i;
    public long j;
    public String k;
    public final String l;

    public final boolean g() {
        int r0 = this.f;
        if (r0 != 1) goto L5;
        return true;
    L5:
        if (r0 != 2) goto L7;
        return true;
    L7:
        if (r0 != 3) goto L9;
        return true;
    L9:
        if (r0 == 13) goto L16;
        return false;
    L16:
        return true;
    }

    public final void k() {
        long r0 = System.currentTimeMillis();
        int r2 = this.f;
        if (r2 != 2) goto L5;
        this.i += r0 - this.g;
    L12:
        int r1 = (int) this.h;
        if (r1 == 0) goto L15;
    L18:
        ClearScreenLogUtils.Companion r3 = ClearScreenLogUtils.a;
        int r4 = (int) this.i;
        int r7 = (int) this.j;
        r3.getClass();
        HashMap r5 = new HashMap();
        if (r1 != 0) goto L23;
        if (r4 != 0) goto L23;
        r5.put("simple_mode_duration", "0");
        r5.put("pure_mode_duration", "0");
        r5.put("duration", String.valueOf(r7));
    L24:
        RoomContext r6 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r6 == null) goto L30;
        com.bytedance.live.datacontext.m r8 = r6.getEnterClearType();
        if (r8 == null) goto L30;
        String r9 = (String) r8.getValue();
        if (r9 == null) goto L30;
    L31:
        r5.put("clear_type", r9);
        u.l().sendLog("livesdk_live_duration_under_screen_clear", r5, new Object[]{new x(), Room.class});
        return;
    L30:
        r9 = "";
    L23:
        r5.put("simple_mode_duration", String.valueOf(r1));
        r5.put("pure_mode_duration", String.valueOf(r4));
        r5.put("duration", String.valueOf(r1 + r4));
        goto L24
    L15:
        if (((int) this.i) != 0) goto L18;
        if (((int) this.j) != 0) goto L18;
        return;
    L5:
        if (r2 != 3) goto L8;
        this.h += r0 - this.g;
        goto L12
    L8:
        if (r2 != 13) goto L10;
        this.h += r0 - this.g;
        goto L12
    L10:
        if (r2 != 1) goto L12;
        this.j += r0 - this.g;
        goto L12
    }

    public final void l() {
        k();
        e(ClearScreenConst.InteractType.INTERACT_SHOW);
        if (uk.a.getValue().booleanValue() == false) goto L18;
        boolean r0 = gs1.b.a;
        HashMap<String, i> r1 = gs1.b.a(this.l).f;
        if (r1 == null) goto L9;
        i r2 = r1.get("T_ICON_CONTAINER");
        if (r2 == null) goto L9;
        View r3 = r2.c;
    L10:
        ViewGroup r4 = (ViewGroup) r3;
        if (r4 == null) goto L18;
        Sequence r5 = UtilityKotlinExtentionsKt.g(r4);
        if (r5 == null) goto L18;
        Iterator r6 = r5.iterator();
    L16:
        if (r6.hasNext() == false) goto L18;
        r4.removeView((View) r6.next());
    L9:
        r3 = null;
    L18:
        this.a = null;
        this.b = null;
        this.d = -1;
        this.c = null;
        this.k = "none";
        this.h = 0;
        this.i = 0;
        this.g = 0;
        this.j = 0;
        boolean r7 = gs1.b.a;
        gs1.b.a(this.l).m();
    }

    public h(String r1) {
        this.l = r1;
        this.d = -1;
        this.e = new HashMap();
        this.k = "none";
    }

    public static void h(SparseArray r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
        if (r2.get(1) != null) goto L6;
        r2.put(1, new HashSet());
    L6:
        if (r2.get(3) != null) goto L9;
        r2.put(3, new HashSet());
    L9:
        if (uk.a.getValue().booleanValue() == false) goto L14;
        if (r2.get(13) != null) goto L14;
        r2.put(13, new HashSet());
    L14:
        if (r2.get(2) != null) goto L17;
        r2.put(2, new HashSet());
        return;
    }

    public final void a(ClearScreenConst.InteractType r2) {
        Intrinsics.checkNotNullParameter(r2, "interactType");
        boolean r0 = gs1.b.a;
        HashMap<ClearScreenConst.InteractType, jg1.a> r1 = gs1.b.a(this.l).g();
        if (r1 == null) goto L6;
        jg1.a r3 = r1.remove(r2);
        return;
    }

    public final void b(jg1.a r3) {
        Intrinsics.checkNotNullParameter(r3, "assistant");
        boolean r0 = gs1.b.a;
        HashMap<ClearScreenConst.InteractType, jg1.a> r1 = gs1.b.a(this.l).g();
        if (r1 == null) goto L6;
        jg1.a r4 = r1.put(r3.getInteractType(), r3);
        return;
    }

    public final void c(boolean r14) {
        if (wt2.a.e(Boolean.valueOf(r14)) == true) goto L5;
    L9:
        boolean r15 = false;
    L10:
        if (r15 == true) goto L12;
        return;
    L12:
        int r16 = this.f;
        byte r4 = -1;
        if (r16 == 3) goto L22;
        if (r16 == 13) goto L22;
        if (r16 == 2) goto L18;
        int r6 = -1;
    L23:
        long r7 = System.currentTimeMillis();
        if (r16 != 2) goto L30;
        this.i += r7 - this.g;
        if (r6 != 3) goto L28;
        ClearScreenLogUtils.Companion r9 = ClearScreenLogUtils.a;
        String r10 = this.k;
        r9.getClass();
        ClearScreenLogUtils.Companion.e(r10);
    L28:
        if (r6 != 13) goto L34;
        ClearScreenLogUtils.Companion r11 = ClearScreenLogUtils.a;
        String r12 = this.k;
        r11.getClass();
        ClearScreenLogUtils.Companion.e(r12);
    L34:
        this.g = r7;
        ClearScreenLogUtils.Companion r8 = ClearScreenLogUtils.a;
        if (r16 != 2) goto L38;
        if (r6 != 3) goto L38;
    L40:
        r4 = 1;
    L47:
        r8.getClass();
        if (r4 != 1) goto L50;
        String r2 = "pure_to_simple";
    L52:
        HashMap r3 = new HashMap();
        r3.put("transform_type", r2);
        u.l().sendLog("livesdk_clear_mode_transform", r3, new Object[]{new x(), Room.class});
    L53:
        if (r16 < 0) goto L205;
        if (r6 < 0) goto L206;
        boolean r0 = gs1.b.a;
        ClearScreenUtils r1 = gs1.b.a(this.l);
        HashSet<String> r5 = r1.h.get(r16);
        HashSet<String> r13 = r1.h.get(r6);
        HashSet<String> r17 = r1.i.get(r16);
        HashSet<String> r18 = r1.i.get(r6);
        ArrayList r19 = new ArrayList();
        ArrayList r20 = new ArrayList();
        if (r5 == null) goto L67;
        Iterator<T> r21 = r5.iterator();
    L59:
        if (r21.hasNext() == false) goto L67;
        String r22 = (String) r21.next();
        if (r13 == null) goto L59;
        if (r13.contains(r22) == true) goto L59;
        i r23 = r1.f.get(r22);
        if (r23 == null) goto L59;
        ClearScreenConst.AnimType r110 = ClearScreenConst.AnimType.ALPHA;
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        r23.d = r110;
        r1.c.add(r23);
        r1.d.add(r23);
        r1.e.remove(r23);
        r20.add(r23);
    L67:
        if (r13 == null) goto L78;
        Iterator<T> r24 = r13.iterator();
    L70:
        if (r24.hasNext() == false) goto L78;
        String r25 = (String) r24.next();
        if (r5 == null) goto L70;
        if (r5.contains(r25) == true) goto L70;
        i r26 = r1.f.get(r25);
        if (r26 == null) goto L70;
        r1.c.remove(r26);
        r1.d.remove(r26);
        r1.e.add(r26);
        r19.add(r26);
    L78:
        if (r17 == null) goto L89;
        Iterator<T> r27 = r17.iterator();
    L81:
        if (r27.hasNext() == false) goto L89;
        String r28 = (String) r27.next();
        if (r18 == null) goto L81;
        if (r18.contains(r28) == true) goto L81;
        i r29 = r1.f.get(r28);
        if (r29 == null) goto L81;
        r1.b.remove(r29);
        r20.add(r29);
    L89:
        if (r18 == null) goto L102;
        Iterator<T> r30 = r18.iterator();
    L92:
        if (r30.hasNext() == false) goto L102;
        String r31 = (String) r30.next();
        if (r17 == null) goto L92;
        if (r17.contains(r31) == true) goto L92;
        i r32 = r1.f.get(r31);
        if (r32 != null) goto L100;
        r18.remove(r31);
    L100:
        if (r32 == null) goto L92;
        r1.b.add(r32);
        r19.add(r32);
    L102:
        Iterator r111 = r19.iterator();
    L104:
        if (r111.hasNext() == false) goto L131;
        i r33 = (i) r111.next();
        if (r33.e == false) goto L110;
        View r34 = r33.c;
        if (r34 == null) goto L113;
        int r35 = r34.getLeft();
    L114:
        float r36 = r35 * 1.0f;
        if (r33.e == false) goto L119;
        View r37 = r33.c;
        if (r37 == null) goto L122;
        r37.setX(r36);
    L122:
        r33.e(0);
        ViewPropertyAnimator r38 = r33.b();
        if (r38 == null) goto L104;
        ViewPropertyAnimator r39 = r38.alpha(1.0f);
        if (r39 == null) goto L104;
        ViewPropertyAnimator r40 = r39.setDuration(r1.f());
        if (r40 == null) goto L104;
        ViewPropertyAnimator r41 = r40.setInterpolator(new com.bytedance.android.live.core.widget.g());
        if (r41 == null) goto L104;
        r41.start();
        goto L104
    L119:
        v70.c r42 = r33.b;
        if (r42 == null) goto L122;
        r42.setX(r36);
    L113:
        r35 = 0;
        goto L114
    L110:
        v70.c r43 = r33.b;
        if (r43 == null) goto L113;
        r35 = r43.a.getLeft();
        goto L114
    L131:
        Iterator r112 = r20.iterator();
    L133:
        if (r112.hasNext() == false) goto L143;
        i r44 = (i) r112.next();
        r44.e(8);
        ViewPropertyAnimator r45 = r44.b();
        if (r45 == null) goto L133;
        ViewPropertyAnimator r46 = r45.alpha(0.0f);
        if (r46 == null) goto L133;
        ViewPropertyAnimator r47 = r46.setDuration(r1.f());
        if (r47 == null) goto L133;
        ViewPropertyAnimator r48 = r47.setInterpolator(new com.bytedance.android.live.core.widget.g());
        if (r48 == null) goto L133;
        r48.start();
        goto L133
    L143:
        int r113 = gs1.a.a;
        h r114 = gs1.a.a(r1.o);
        if (r114 == null) goto L207;
        r114.d(r6);
        return;
    L207:
        return;
    L206:
        return;
    L205:
        return;
    L50:
        if (r4 != 2) goto L53;
        r2 = "simple_to_pure";
    L38:
        if (r16 != 2) goto L41;
        if (r6 == 13) goto L40;
    L41:
        if (r16 != 3) goto L44;
        if (r6 != 2) goto L44;
    L46:
        r4 = 2;
    L44:
        if (r16 != 13) goto L47;
        if (r6 != 2) goto L47;
    L30:
        if (r16 != 3) goto L32;
        this.h += r7 - this.g;
        goto L34
    L32:
        if (r16 != 13) goto L34;
        this.h += r7 - this.g;
        goto L34
    L18:
        if (uk.a.getValue().booleanValue() == false) goto L20;
        r6 = 13;
        goto L23
    L20:
        r6 = 3;
    L22:
        r6 = 2;
        goto L23
    L5:
        if (wt2.a.c() == false) goto L9;
        if (g() == false) goto L9;
        r15 = true;
        goto L10
    }

    @Deprecated(message = "推荐使用另外一个传ClearType的方法，外部不要使用该方法")
    public final void d(int r6) {
        ClearScreenConst.InteractType[] r0 = ClearScreenConst.InteractType.values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L11;
        ClearScreenConst.InteractType r3 = r0[r2];
        if (r6 == r3.getId()) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        e(r3);
        return;
    }

    public final void e(ClearScreenConst.InteractType r8) {
        Intrinsics.checkNotNullParameter(r8, "status");
        this.f = r8.getId();
        RoomContext.a r0 = RoomContext.Companion;
        RoomContext r5 = RoomContext.a.c(r0, null, 0, 3);
        if (r5 == null) goto L7;
        com.bytedance.live.datacontext.m r6 = r5.getCleanMode();
        if (r6 == null) goto L7;
        r6.setValue(Integer.valueOf(r8.getId()));
    L7:
        RoomContext r1 = RoomContext.a.c(r0, null, 0, 3);
        if (r1 == null) goto L12;
        com.bytedance.live.datacontext.m r2 = r1.isCleanMode();
        if (r2 == null) goto L12;
        Lazy r3 = ClearScreenHelper.a;
        Intrinsics.checkNotNullParameter(r8, "type");
        r2.setValue(Boolean.valueOf(r8.getCanShowClearLayer()));
    L12:
        ILinkServiceExternal r4 = jc1.k.f(ILinkServiceExternal.class);
        if (r4 == null) goto L15;
        r4.notifyCleanModeChanged(r8.getId());
    L15:
        ILinkServiceExternal r7 = jc1.k.f(ILinkServiceExternal.class);
        if (r7 == null) goto L18;
        Lazy r9 = ClearScreenHelper.a;
        Intrinsics.checkNotNullParameter(r8, "type");
        r7.notifyIsCleanModeChanged(r8.getCanShowClearLayer());
    L18:
        Lazy r10 = ClearScreenHelper.a;
        Intrinsics.checkNotNullParameter(r8, "type");
        if (r8.getCanShowClearLayer() == false) goto L33;
        if (((Boolean) LiveInfraSettingKeys.LIVE_CLEAR_SCREEN_WIDGET_GONE_OPTIMIZE_SWITCHER.getValue()).booleanValue() == true) goto L24;
        xs2.b.a().post(new y(true, 1));
    L24:
        if (jc1.k.f(IPerformanceManager.class) != null) goto L26;
        return;
    L26:
        if (r8 != ClearScreenConst.InteractType.ORIGIN_CLEAR) goto L28;
    L31:
        jc1.k.n(IPerformanceManager.class).onEnterFullScreenClean();
        return;
    L28:
        if (r8 == ClearScreenConst.InteractType.PURE_CLEAR) goto L31;
        jc1.k.n(IPerformanceManager.class).onLeaveFullScreenClean();
        return;
    L33:
        if (r8 == ClearScreenConst.InteractType.INTERACT_SHOW) goto L35;
        return;
    L35:
        if (((Boolean) LiveInfraSettingKeys.LIVE_CLEAR_SCREEN_WIDGET_GONE_OPTIMIZE_SWITCHER.getValue()).booleanValue() == true) goto L38;
        xs2.b.a().post(new y(false, 1));
    L38:
        if (jc1.k.f(IPerformanceManager.class) == null) goto L45;
        jc1.k.n(IPerformanceManager.class).onLeaveFullScreenClean();
        return;
    }

    public final void f(e0 r6) {
        if (r6 == null) goto L6;
        DataCenter r0 = ((d90.d) r6).h;
        if (r0 == null) goto L6;
        View r1 = j(r0);
    L7:
        this.c = r1;
        if (r1 == null) goto L20;
        boolean r2 = gs1.b.a;
        gs1.b.a(this.l).k(3, new j70.f("T_ICON_CONTAINER", ""));
        if (uk.a.getValue().booleanValue() == false) goto L12;
        gs1.b.a(this.l).k(13, new j70.f("T_ICON_CONTAINER", ""));
    L12:
        HashMap<String, i> r3 = gs1.b.a(this.l).f;
        if (r3 == null) goto L21;
        i r4 = r3.get("T_ICON_CONTAINER");
        if (r4 == null) goto L22;
        View r5 = r4.c;
        if (r5 == null) goto L23;
        gs1.b.a(this.l).o(new j70.f("T_ICON_CONTAINER", ""), r5, r6);
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L6:
        r1 = null;
        goto L7
    }

    public final void i(boolean r5) {
        boolean r0 = gs1.b.a;
        HashMap<String, i> r1 = gs1.b.a(this.l).f;
        ViewParent r2 = null;
        if (r1 == null) goto L7;
        i r3 = r1.get("T_ICON_CONTAINER");
        if (r3 == null) goto L7;
        View r4 = r3.c;
    L8:
        ViewGroup r6 = (ViewGroup) r4;
        if (r5 == false) goto L40;
        View r7 = this.c;
        if (r7 != null) goto L13;
        return;
    L13:
        if (Intrinsics.areEqual(r7.getParent(), r6) == false) goto L15;
        return;
    L15:
        View r8 = this.c;
        if (r8 == null) goto L18;
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
    L19:
        this.b = r9;
        View r10 = this.c;
        if (r10 == null) goto L22;
        ViewParent r11 = r10.getParent();
    L24:
        if ((r11 instanceof ViewGroup) == false) goto L27;
        r2 = r11;
    L27:
        ViewGroup r12 = (ViewGroup) r2;
        this.a = r12;
        if (r12 == null) goto L30;
        int r13 = r12.indexOfChild(this.c);
    L31:
        this.d = r13;
        ViewGroup r14 = this.a;
        if (r14 == null) goto L35;
        r14.removeView(this.c);
    L35:
        if (uk.a.getValue().booleanValue() == false) goto L38;
        if (r6 == null) goto L38;
        UtilityKotlinExtentionsKt.w(r6);
    L38:
        if (r6 == null) goto L62;
        r6.addView(this.c);
        return;
    L62:
        return;
    L30:
        r13 = 1;
        goto L31
    L22:
        r11 = null;
        goto L24
    L18:
        r9 = null;
        goto L19
    L40:
        if (r6 == null) goto L64;
        Sequence r15 = UtilityKotlinExtentionsKt.g(r6);
        if (r15 == null) goto L65;
        Iterator r16 = r15.iterator();
    L45:
        if (r16.hasNext() == false) goto L66;
        View r17 = (View) r16.next();
        r6.removeView(r17);
        ViewGroup.LayoutParams r18 = this.b;
        if (r18 == null) goto L49;
        r17.setLayoutParams(r18);
    L49:
        int r19 = this.d;
        if (r19 == (-1)) goto L45;
        ViewGroup r20 = this.a;
        if (r20 == null) goto L45;
        r20.addView(r17, r19);
        goto L45
    L66:
        return;
    L65:
        return;
    L64:
        return;
    L7:
        r4 = null;
        goto L8
    }

    public final View j(DataCenter r6) {
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        c0 r7 = y3.m(r6);
        if (r7 == null) goto L28;
        x3 r8 = (x3) r7;
        Iterator<Map.Entry<ToolbarButton, Pair<j70.f, String>>> r0 = this.e.entrySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L25;
        Map.Entry<ToolbarButton, Pair<j70.f, String>> r1 = r0.next();
        ToolbarButton r2 = r1.getKey();
        Pair<j70.f, String> r3 = r1.getValue();
        if (r8.n(r2) == true) goto L11;
        if (uk.a.getValue().booleanValue() == false) goto L6;
    L11:
        boolean r4 = gs1.b.a;
        gs1.b.a(this.l).l(3, (j70.f) r3.getFirst());
        if (uk.a.getValue().booleanValue() == false) goto L15;
        gs1.b.a(this.l).l(13, (j70.f) r3.getFirst());
    L15:
        if (wt2.a.l() == false) goto L23;
        HashMap<String, i> r5 = gs1.b.a(this.l).f;
        if (r5 == null) goto L23;
        i r9 = r5.get(((j70.f) r3.getFirst()).a);
        if (r9 == null) goto L23;
        HashSet<i> r10 = gs1.b.a(this.l).c;
        if (r10 == null) goto L23;
        r10.remove(r9);
    L23:
        this.k = (String) r3.getSecond();
        Map<ExtendedToolbarButton, View> r11 = r8.c;
        ExtendedToolbarButton.h.getClass();
        HashMap r12 = (HashMap) r11;
        return (View) r12.get(ExtendedToolbarButton.a.a(r2));
    L25:
        return null;
    L28:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarManager");
    }
}

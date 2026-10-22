package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.livesdk.a8;
import com.bytedance.android.livesdk.chatroom.utils.l4;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ToolbarReasonTag;
import com.bytedance.android.livesdkapi.service.ILiveUxTracer;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class x3 implements c0 {
    public final boolean a;
    public DataCenter b;
    public final Map<ExtendedToolbarButton, View> c;
    public final Map<ExtendedToolbarButton, c0.b> d;
    public final Map<ExtendedToolbarButton, c0.b> e;
    public final Map<ExtendedToolbarButton, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s> f;
    public final Map<ExtendedToolbarButton, String> g;
    public final PublishSubject<c0.c> h;
    public final PublishSubject<c0.d> i;
    public com.bytedance.android.livesdk.chatroom.utils.c0 j;
    public final boolean k;
    public boolean l;
    public boolean m;
    public boolean n;

    public final void B() {
        if (this.l == false) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.chatroom.utils.c0 r0 = this.j;
        if (r0 != null) goto L8;
        return;
    L8:
        ArrayList<ExtendedToolbarButton> r1 = r0.h();
        if (r1 != null) goto L11;
        return;
    L11:
        int r2 = 0;
    L13:
        if (r2 >= r1.size()) goto L15;
        com.bytedance.android.livesdk.chatroom.utils.o1 r3 = com.bytedance.android.livesdk.chatroom.utils.o1.d();
        ExtendedToolbarButton r4 = (ExtendedToolbarButton) ListProtector.get(r1, r2);
        r3.getClass();
        com.bytedance.android.livesdk.chatroom.utils.o1.g("livesdk_toolbar_icon_show", r4, r2);
        r2 = r2 + 1;
        goto L13
    }

    public final boolean z() {
        List<ExtendedToolbarButton> r0 = l4.c;
        Iterator<ExtendedToolbarButton> r1 = l4.c.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        if (y(r1.next()) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public x3(boolean r2) {
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = new HashMap();
        this.f = new HashMap();
        this.g = new HashMap();
        this.h = PublishSubject.create();
        this.i = PublishSubject.create();
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        this.a = r2;
        if (r2 == false) goto L6;
        this.k = ((Boolean) com.bytedance.android.livesdk.chatroom.setting.j.a.getValue()).booleanValue();
        return;
    }

    public final void E(DataCenter r4) {
        if (r4 != null) goto L4;
        String r0 = "null";
    L6:
        if (this.a == false) goto L8;
        String r1 = "unfold";
    L9:
        String r2 = r1 + " tm dataCenter " + r0 + " tm:" + String.valueOf(hashCode());
        int r3 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.i0.a;
        Intrinsics.checkNotNullParameter(r2, "string");
        ALogger.i("NewToolbarLog", r2);
        this.b = r4;
        if (this.m == false) goto L18;
        if (r4 != null) goto L13;
        return;
    L13:
        if (((Boolean) r4.get("data_is_anchor", Boolean.FALSE)).booleanValue() == false) goto L15;
        boolean r5 = false;
    L16:
        this.l = r5;
        return;
    L15:
        r5 = ((Boolean) LiveInfraSettingKeys.LIVE_DYNAMIC_TOOLBAR_MODIFY_PERMUTATION.getValue()).booleanValue();
        goto L16
    L18:
        return;
    L8:
        r1 = "fold";
        goto L9
    L4:
        r0 = String.valueOf(r4.hashCode());
        goto L6
    }

    public final void H(boolean r5) {
        Iterator r0 = ((HashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L25;
        Map.Entry r1 = (Map.Entry) r0.next();
        Map<ExtendedToolbarButton, View> r2 = this.c;
        HashMap r3 = (HashMap) r2;
        if (((View) r3.get(r1.getKey())) == null) goto L4;
        C((ExtendedToolbarButton) r1.getKey(), (View) r1.getValue());
        if (r5 == false) goto L4;
        if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L4;
        ExtendedToolbarButton r4 = (ExtendedToolbarButton) r1.getKey();
        c0.b r6 = (c0.b) ((HashMap) this.e).get(r4);
        if (this.l == true) goto L17;
        if (((Boolean) a8.a.getValue()).booleanValue() == false) goto L17;
        r6 = (c0.b) ((HashMap) this.d).get(r4);
    L17:
        if (((HashMap) this.f).get(r4) == null) goto L21;
        if (r6 == null) goto L21;
        ((HashMap) this.f).remove(r4);
        r6.onHide(false);
    L21:
        if ((r6 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.t) == false) goto L4;
        if (this.b == null) goto L4;
        ((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.t) r6).onDestroy();
        goto L4
    L25:
        ((HashMap) this.c).clear();
        if (((Boolean) LiveInfraSettingKeys.FIX_TOOLBAR_MANAGER_LEAK_CONTEXT.getValue()).booleanValue() == false) goto L28;
        ((HashMap) this.f).clear();
    L28:
        if (r5 == false) goto L44;
        ((HashMap) this.d).clear();
        ((HashMap) this.e).clear();
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void c(ExtendedToolbarButton r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (com.bytedance.android.livesdk.config.setting.s.b() == true) goto L7;
    L9:
        q(true, r2);
        return;
    L7:
        if (r(r2, "show ") == false) goto L9;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final boolean g(ToolbarButton r2) {
        ExtendedToolbarButton.h.getClass();
        return x(ExtendedToolbarButton.a.a(r2));
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void h(ExtendedToolbarButton r4) {
        ((HashMap) this.g).remove(r4);
        this.i.onNext(new c0.d(r4, false));
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void i(ExtendedToolbarButton r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        r3.f().equals("FAST_GIFT");
        if (com.bytedance.android.livesdk.config.setting.s.b() == true) goto L7;
    L9:
        q(false, r3);
        return;
    L7:
        if (r(r3, "dismiss ") == false) goto L9;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final String j(ToolbarButton r2) {
        ExtendedToolbarButton.h.getClass();
        return u(ExtendedToolbarButton.a.a(r2));
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void m(com.bytedance.android.livesdk.chatroom.utils.c0 r2) {
        if ((r2 instanceof com.bytedance.android.livesdk.chatroom.utils.c0) == false) goto L6;
        this.j = r2;
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final boolean n(ToolbarButton r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        Map<ExtendedToolbarButton, View> r1 = this.c;
        ExtendedToolbarButton.h.getClass();
        HashMap r2 = (HashMap) r1;
        View r5 = (View) r2.get(ExtendedToolbarButton.a.a(r4));
        if (r5 != null) goto L8;
        return false;
    L8:
        if (r5.getVisibility() != 0) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void o(ToolbarButton r2) {
        ExtendedToolbarButton.h.getClass();
        h(ExtendedToolbarButton.a.a(r2));
    }

    public c0.b s(ExtendedToolbarButton r2) {
        return (c0.b) ((HashMap) this.d).get(r2);
    }

    public final c0.b t(ToolbarButton r2) {
        ExtendedToolbarButton.h.getClass();
        return s(ExtendedToolbarButton.a.a(r2));
    }

    public final String u(ExtendedToolbarButton r5) {
        if (r5 != null) goto L6;
        return "";
    L6:
        if (((HashMap) this.g).containsKey(r5) == true) goto L8;
        String r6 = r5.g();
        if (TextUtils.isEmpty(r6) == false) goto L12;
        return "";
    L12:
        Iterator r1 = ((HashMap) this.g).entrySet().iterator();
    L14:
        if (r1.hasNext() == false) goto L19;
        Map.Entry r2 = (Map.Entry) r1.next();
        if (TextUtils.equals(r6, ((ExtendedToolbarButton) r2.getKey()).g()) == false) goto L14;
        return (String) r2.getValue();
    L19:
        return "";
    L8:
        return (String) ((HashMap) this.g).get(r5);
    }

    public final int v(ExtendedToolbarButton r2) {
        com.bytedance.android.livesdk.chatroom.utils.c0 r0 = this.j;
        if (r0 != null) goto L5;
        return -1;
    L5:
        return r0.i(r2);
    }

    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s w(ExtendedToolbarButton r2) {
        Map<ExtendedToolbarButton, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s> r0 = this.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s) ((HashMap) r0).get(r2);
    }

    public final boolean x(ExtendedToolbarButton r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (((HashMap) this.g).containsKey(r5) == false) goto L9;
        return true;
    L9:
        if ((r5 instanceof ExtendedToolbarButton.b) == false) goto L11;
        return false;
    L11:
        String r1 = r5.g();
        if (TextUtils.isEmpty(r1) == false) goto L14;
        return false;
    L14:
        Iterator r0 = ((HashMap) this.g).keySet().iterator();
    L16:
        if (r0.hasNext() == false) goto L21;
        if (TextUtils.equals(r1, ((ExtendedToolbarButton) r0.next()).g()) == false) goto L16;
        return true;
    L21:
        return ((HashMap) this.g).containsKey(r5);
    }

    public final boolean y(ExtendedToolbarButton r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        View r4 = (View) ((HashMap) this.c).get(r3);
        if (r4 != null) goto L8;
        return false;
    L8:
        if (r4.getVisibility() != 0) goto L12;
        return true;
    L12:
        return false;
    }

    public final void A(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r6, c0.b r7) {
        ALogger.e("dzy-toolbar", "ToolbarManager#loadNetButton, buttonId = " + r6.toString());
        if (com.bytedance.android.livesdk.config.setting.s.b() == true) goto L5;
        return;
    L5:
        DataCenter r0 = this.b;
        if (r0 != null) goto L9;
        String r8 = "dataCenter is null, when tm:" + String.valueOf(hashCode());
        int r1 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.i0.a;
        Intrinsics.checkNotNullParameter(r8, "string");
        ALogger.e("NewToolbarLog", r8);
        HashMap<String, String> r9 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.q.a;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.q.a(r6.a, ToolbarReasonTag.TOOLBAR_MANAGER_ERROR, "dataCenter is null");
        return;
    L9:
        boolean r2 = ((Boolean) r0.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        boolean r3 = !this.a;
        Intrinsics.checkNotNullParameter(r6, "$this$toLocalExtData");
        ToolbarButton r4 = f3.b(r6, r2, r3);
        if (r4 == null) goto L12;
        ExtendedToolbarButton r5 = r4.extended();
    L13:
        if (r5 != null) goto L16;
        HashMap<String, String> r10 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.q.a;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.q.a(r6.a, ToolbarReasonTag.TOOLBAR_MANAGER_ERROR, "local button is null");
        return;
    L16:
        ((HashMap) this.f).put(r5, r6);
        if (((HashMap) this.c).get(r5) == null) goto L19;
    L21:
        p(r5, r7);
        return;
    L19:
        if (this.a == false) goto L21;
        String r11 = "view is null, when tm:" + String.valueOf(hashCode());
        int r12 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.i0.a;
        Intrinsics.checkNotNullParameter(r11, "string");
        ALogger.e("NewToolbarLog", r11);
        HashMap<String, String> r13 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.q.a;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.q.a(r6.a, ToolbarReasonTag.TOOLBAR_MANAGER_ERROR, "view is null");
        goto L21
    L12:
        r5 = null;
        goto L13
    }

    public final void C(ExtendedToolbarButton r2, View r3) {
        if (this.l == false) goto L5;
        return;
    L5:
        c0.b r4 = (c0.b) ((HashMap) this.d).get(r2);
        if (r4 == null) goto L12;
        DataCenter r0 = this.b;
        if (r0 == null) goto L10;
        r4.R9(r3, r0);
    L10:
        r3.setVisibility(8);
        r3.setOnClickListener(null);
        return;
    }

    public final void D(final ExtendedToolbarButton r8, final View r9) {
        final c0.b r0 = (c0.b) ((HashMap) this.d).get(r8);
        boolean r1 = true;
        LocalTestManager.a(new Class[]{wy.a.class});
        if (this.l == false) goto L5;
        return;
    L5:
        if (r0 != null) goto L7;
    L30:
        if (r0 != null) goto L34;
        r1 = false;
    L34:
        if ((r8 instanceof ExtendedToolbarButton.b) == false) goto L45;
        ToolbarButton r10 = ((ExtendedToolbarButton.b) r8).i;
        if (r10 != ToolbarButton.GIFT) goto L39;
        ALogger.i("ToolbarManager", "Gift onToolbarButtonReady(), behavior valid: " + r1);
        return;
    L39:
        if (r10 != ToolbarButton.FAST_GIFT) goto L42;
        ALogger.i("ToolbarManager", "FastGift onToolbarButtonReady(), behavior valid: " + r1);
        return;
    L42:
        if (r10 != ToolbarButton.COMMERCE) goto L48;
        ALogger.i("ToolbarManager", "Commerce onToolbarButtonReady(), behavior valid: " + r1);
        return;
    L48:
        return;
    L45:
        return;
    L7:
        if ((r0 instanceof c0.a) == true) goto L9;
        r9.setVisibility(0);
    L9:
        q(true, r8);
        if (r8 != ToolbarButton.COMMERCE.extended()) goto L12;
        ALogger.i("ToolbarPreload", "commerce new set");
    L12:
        r9.setOnClickListener(new v3(this, r8, r0));
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L15;
        r9.setOnLongClickListener(new w3(this, r9));
    L15:
        long r2 = SystemClock.uptimeMillis();
        DataCenter r5 = this.b;
        if (r5 == null) goto L27;
        r0.p4(r9, r5);
        if (this.k == false) goto L23;
        if (r8.e == false) goto L23;
        r0.Bh(((ExtendedToolbarButton.b) r8).i);
    L23:
        if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L27;
        if (((HashMap) this.f).get(r8) == null) goto L27;
        r0.SY((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s) ((HashMap) this.f).get(r8));
    L27:
        long r6 = SystemClock.uptimeMillis() - r2;
        if (r6 < 10) goto L30;
        jc1.k.f(ILiveUxTracer.class).traceDirectDuration("toolbar_loading_" + r8.f(), r6);
        goto L30
    }

    public final void F(ExtendedToolbarButton r4, int r5) {
        View r0 = (View) ((HashMap) this.c).get(r4);
        if (r0 == null) goto L31;
        if (r4 != null) goto L6;
        return;
    L6:
        if (((HashMap) this.d).get(r4) == null) goto L36;
        UIUtils.setViewVisibility(r0, r5);
        if (this.b == null) goto L21;
        if (r5 != 0) goto L21;
        if (TextUtils.equals(r4.f(), "GIFT") == false) goto L14;
    L19:
        this.b.put("data_toolbar_visible", r4.f());
        goto L21
    L14:
        if (TextUtils.equals(r4.f(), "FAST_GIFT") == true) goto L19;
        if (TextUtils.equals(r4.f(), "COMMERCE") == true) goto L19;
        if (TextUtils.equals(r4.f(), "GROUP_PURCHASE") == true) goto L19;
    L21:
        if ((r4 instanceof ExtendedToolbarButton.b) == false) goto L24;
        b(((ExtendedToolbarButton.b) r4).i, new pp1.m(r5));
    L24:
        if (this.a == false) goto L33;
        DataCenter r1 = this.b;
        if (r1 != null) goto L28;
        return;
    L28:
        if (((Boolean) r1.get("cmd_hide_other_toolbar", Boolean.FALSE)).booleanValue() == false) goto L35;
        this.b.put("cmd_toolbar_visibility_controller", new Pair(r4, Integer.valueOf(r5)));
        return;
    L35:
        return;
    L33:
        return;
    L36:
        return;
    }

    public final void G(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r5, c0.b r6) {
        if (com.bytedance.android.livesdk.config.setting.s.b() == true) goto L5;
        return;
    L5:
        DataCenter r0 = this.b;
        if (r0 != null) goto L8;
        return;
    L8:
        Boolean r1 = Boolean.FALSE;
        boolean r2 = ((Boolean) r0.get("data_is_anchor", r1)).booleanValue();
        boolean r3 = !this.a;
        Intrinsics.checkNotNullParameter(r5, "$this$toLocalExtData");
        ToolbarButton r4 = f3.b(r5, r2, r3);
        if (r4 == null) goto L11;
        ExtendedToolbarButton r7 = r4.extended();
    L12:
        if (r7 != null) goto L15;
        return;
    L15:
        if (r5.a == 26) goto L17;
    L19:
        f(r7, r6);
        if (((HashMap) this.f).get(r7) == null) goto L27;
        ((HashMap) this.f).remove(r7);
        if (this.l == false) goto L24;
        return;
    L24:
        if (r6 == null) goto L28;
        r6.onHide(r5.l.b);
        return;
    L28:
        return;
    L27:
        return;
    L17:
        if (((Boolean) this.b.get("data_has_interact_more", r1)).booleanValue() == false) goto L19;
        i(ToolbarButton.INTERACTION.extended());
        goto L19
    L11:
        r7 = null;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void a(ToolbarButton r2, String r3) {
        ExtendedToolbarButton.h.getClass();
        l(ExtendedToolbarButton.a.a(r2), r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void b(ToolbarButton r3, e r4) {
        ALogger.i("ToolbarCommand", r4.getClass().getSimpleName());
        Map<ExtendedToolbarButton, c0.b> r0 = this.d;
        ExtendedToolbarButton.h.getClass();
        HashMap r1 = (HashMap) r0;
        c0.b r5 = (c0.b) r1.get(ExtendedToolbarButton.a.a(r3));
        if (r5 == null) goto L6;
        r5.dv(r4);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void d(ToolbarButton r2, c0.b r3) {
        ExtendedToolbarButton.h.getClass();
        f(ExtendedToolbarButton.a.a(r2), r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void e(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r2, c0.b r3) {
        if (this.l == false) goto L6;
        return;
    L6:
        if (com.bytedance.android.livesdk.config.setting.s.b() == true) goto L9;
        return;
    L9:
        if (((HashMap) this.d).containsValue(r3) == false) goto L12;
        r3.Mr(r2);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void f(ExtendedToolbarButton r5, c0.b r6) {
        View r0 = (View) ((HashMap) this.c).get(r5);
        if (r0 == null) goto L5;
        C(r5, r0);
    L5:
        c0.b r1 = (c0.b) ((HashMap) this.d).remove(r5);
        if (r5.e == false) goto L13;
        DataCenter r2 = this.b;
        if (r2 == null) goto L10;
        r2.put("tool_bar_button_unload", r5);
    L10:
        if (r6 != null) goto L12;
        r6 = r1;
    L12:
        this.h.onNext(new c0.c(r5, r6, false));
    L13:
        q(false, r5);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void k(ToolbarButton r2, c0.b r3) {
        ExtendedToolbarButton.h.getClass();
        p(ExtendedToolbarButton.a.a(r2), r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void l(ExtendedToolbarButton r3, String r4) {
        ((HashMap) this.g).put(r3, r4);
        this.i.onNext(new c0.d(r3, true));
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public void p(ExtendedToolbarButton r4, c0.b r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        View r0 = (View) ((HashMap) this.c).get(r4);
        if (r0 == null) goto L7;
        C(r4, r0);
    L7:
        ((HashMap) this.d).put(r4, r5);
        if (r0 == null) goto L11;
        D(r4, r0);
    L11:
        if ((r4 instanceof ExtendedToolbarButton.b) == false) goto L26;
        ToolbarButton r1 = ((ExtendedToolbarButton.b) r4).i;
        if (r1 != ToolbarButton.GIFT) goto L16;
        ALogger.i("ttlive_gift", "load Gift icon");
    L21:
        DataCenter r2 = this.b;
        if (r2 == null) goto L24;
        r2.put("tool_bar_button_load", r4);
    L24:
        this.h.onNext(new c0.c(r4, r5, true));
        return;
    L16:
        if (r1 != ToolbarButton.FAST_GIFT) goto L19;
        ALogger.i("ttlive_gift", "load FastGift icon");
        goto L21
    L19:
        if (r1 != ToolbarButton.COMMERCE) goto L21;
        ALogger.i("ttlive_gift", "load commerce icon");
        goto L21
    }

    public final void q(boolean r3, ExtendedToolbarButton r4) {
        if (this.a == false) goto L14;
        com.bytedance.android.livesdk.chatroom.utils.c0 r0 = this.j;
        if (r0 == null) goto L14;
        if (this.l == false) goto L10;
        return;
    L10:
        if (r3 == false) goto L12;
        r0.a(this, r4);
        return;
    L12:
        r0.d(this, r4);
        return;
    L14:
        if (r3 == false) goto L16;
        int r1 = 0;
    L17:
        F(r4, r1);
        if (this.a == false) goto L22;
        int r2 = u3.a;
        u3.a("mutex is null when handle " + r4.f() + ", show: " + r3);
        return;
    L22:
        return;
    L16:
        r1 = 8;
        goto L17
    }

    public final boolean r(ExtendedToolbarButton r3, String r4) {
        if (this.l == false) goto L7;
        int r0 = com.bytedance.android.livesdk.config.setting.s.a;
        if (((Boolean) LiveInfraSettingKeys.LIVE_STOP_TOOLBAR_MANAGER_SHOW_DISMISS.getValue()).booleanValue() == false) goto L7;
    L8:
        ALogger.i("COMMON_SLOT_FILTER", "stop " + r4 + r3.f());
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L15;
        ALogger.stacktrace(4, "COMMON_SLOT_FILTER", ThreadMethodProxy.currentThread().getStackTrace());
        return true;
    L15:
        return true;
    L7:
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.j.a.contains(r3.f()) == true) goto L8;
        return false;
    }
}

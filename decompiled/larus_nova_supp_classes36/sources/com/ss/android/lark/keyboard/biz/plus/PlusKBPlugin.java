package com.ss.android.lark.keyboard.biz.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.lark.pb.basic.v1.Message;
import com.ss.android.lark.biz.im.api.extension.chat_window.h;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.ComponentType;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.chat.utils.ReplyActionUtils;
import com.ss.android.lark.keyboard.dependency.KeyboardAssemblerModule;
import com.ss.android.lark.keyboard.event.k;
import com.ss.android.lark.keyboard.event.q;
import com.ss.android.lark.keyboard.keyboard2.KeyboardMenuItemKey;
import com.ss.android.lark.keyboard.keyboard2.PanelMenuItem;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.statistics.chat.ChatHitPointExtraParams;
import cya.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class PlusKBPlugin extends PanelMenuItem implements d5b.c, com.ss.android.lark.keyboard.base.b {
    public final boolean d;
    public final com.ss.android.lark.biz.im.api.extension.chat_window.b e;
    public View f;
    public FrameLayout g;
    public boolean h;
    public View i;
    public final ArrayList<d5b.a> j;
    public Function0<Unit> k;
    public final Set<d5b.c.a> l;
    public final Lazy m;
    public final PanelMenuItem.InitialStrategy n;
    public final Set<Object> o;
    public final KeyboardMenuItemKey p;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final int a() {
        return 2131238374;
    }

    public static void J() {
        ChatHitPointExtraParams.IsFullScreen r0 = ChatHitPointExtraParams.IsFullScreen.FALSE;
        int r1 = xob.a.a;
        Intrinsics.checkNotNullParameter("im_chat_input_plus_view", "keyEvent");
        Intrinsics.checkNotNullParameter(r0, "param");
        Map r2 = ChatParamUtils.e();
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L13;
        Statistics.sendEvent("im_chat_input_plus_view", s5c.b.a(r2, r0).toJson());
        return;
    L13:
        return;
    L5:
        if (r2.isEmpty() == true) goto L8;
        r3 = false;
        goto L9
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void v() {
        Iterator<T> r0 = this.l.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((d5b.c.a) r0.next()).onDestroy();
        goto L4
    }

    public final i H() {
        cya.c r0 = n().L();
        if ((r0 instanceof cya.c) == false) goto L9;
        cya.c r1 = r0;
        if (r1.a().c(2) == true) goto L8;
        return null;
    L8:
        return (i) r1.a().d().a.a(i.h);
    L9:
        return null;
    }

    public final PartialReplyInfo c() {
        i r0 = H();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.g;
    }

    public final String d() {
        i r0 = H();
        if (r0 == null) goto L6;
        String r1 = r0.a;
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public final Message.PartialReplyInfo f() {
        i r0 = H();
        if (r0 == null) goto L5;
        PartialReplyInfo r1 = r0.g;
    L7:
        return ReplyActionUtils.e(r1);
    L5:
        r1 = null;
        goto L7
    }

    public Activity getActivity() {
        return n().l().getContext();
    }

    public final String h() {
        i r0 = H();
        if (r0 == null) goto L6;
        String r1 = r0.b;
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public final void i() {
        n().H().h();
    }

    public final Fragment l() {
        return n().l().d;
    }

    public final void m() {
        k.a.a(n().e(), q.a.a);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final Integer q() {
        return 2131914268;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.PanelMenuItem
    public final PanelMenuItem.InitialStrategy C() {
        return this.n;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final KeyboardMenuItemKey g() {
        return this.p;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.o
    public final void A(boolean r7) {
        eya.b r0 = (eya.b) this.m.getValue();
        if (r0 == null) goto L5;
        r0.d7(r7);
    L5:
        View r1 = null;
        if (r7 == false) goto L35;
        this.k.invoke();
        if (this.h == true) goto L22;
        this.h = true;
        View r8 = this.f;
        if (r8 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mIcon");
    L13:
        r1.setSelected(true);
        Iterator<d5b.a> r9 = this.j.iterator();
    L15:
        if (r9.hasNext() == false) goto L17;
        r9.next().c();
        goto L15
    L17:
        Iterator<T> r10 = this.l.iterator();
    L19:
        if (r10.hasNext() == false) goto L21;
        ((d5b.c.a) r10.next()).onStart();
        goto L19
    L21:
        J();
    L43:
        int r11 = xob.a.a;
        Context r12 = this.e.a.requireContext();
        String r2 = this.e.c.getId();
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r2, "chatId");
        xob.a.b(new Pair[]{new Pair("chat_id", r2), new Pair("click", "switch_menu"), new Pair("target", "none"), new Pair("keyboard_status", xob.a.a(r12))});
        return;
    L12:
        r1 = r8;
        goto L13
    L22:
        View r13 = this.f;
        if (r13 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mIcon");
    L26:
        r1.setSelected(true);
        Iterator<d5b.a> r14 = this.j.iterator();
    L28:
        if (r14.hasNext() == false) goto L30;
        r14.next().c();
        goto L28
    L30:
        Iterator<T> r15 = this.l.iterator();
    L32:
        if (r15.hasNext() == false) goto L34;
        ((d5b.c.a) r15.next()).a();
        goto L32
    L34:
        J();
        goto L43
    L25:
        r1 = r13;
        goto L26
    L35:
        View r16 = this.f;
        if (r16 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mIcon");
    L39:
        r1.setSelected(false);
        Iterator<T> r17 = this.l.iterator();
    L41:
        if (r17.hasNext() == false) goto L43;
        ((d5b.c.a) r17.next()).onStop();
        goto L41
    L38:
        r1 = r16;
        goto L39
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.PanelMenuItem
    public final View G(ViewGroup r8) {
        Intrinsics.checkNotNullParameter(r8, "container");
        CollectionsKt.sortWith(this.j, d.a);
        View r9 = LayoutInflater.from(r8.getContext()).inflate(2131561737, r8, false);
        this.i = r9;
        if (r9 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        r9 = null;
    L5:
        this.g = (FrameLayout) r9.findViewById(2131380313);
        eya.b r10 = (eya.b) this.m.getValue();
        if (r10 == null) goto L22;
        com.ss.android.lark.keyboard.dependency.a r2 = KeyboardAssemblerModule.a();
        Chat r3 = this.e.c;
        FrameLayout r4 = this.g;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mMoreItemsPanel");
        r4 = null;
    L11:
        h r6 = this.e.e;
        if (r6 == null) goto L14;
        ComponentType r7 = r6.a;
    L15:
        eya.a r5 = r2.getLocationPanelItemConfig(r3, this, r4, r7);
        if (r5 == null) goto L18;
        r10.J4(r5);
    L18:
        Map r11 = ChatParamUtils.a(this.e.c, ChatCoreModule.a().getLoginDependency().getUserId(), this.e.d);
        FrameLayout r12 = this.g;
        if (r12 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mMoreItemsPanel");
        r12 = null;
    L21:
        r10.c7(r12, r11);
        goto L22
    L14:
        r7 = null;
    L22:
        View r13 = this.i;
        if (r13 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        return null;
    L26:
        return r13;
    }

    public final void k(xb5.c r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.l.add(r2);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void w(boolean r2) {
        View r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mIcon");
        r0 = null;
    L5:
        r0.setEnabled(r2);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void x(com.ss.android.lark.keyboard.keyboard2.i r2) {
        Intrinsics.checkNotNullParameter(r2, "iconHolder");
        Intrinsics.checkNotNullParameter(r2, "iconHolder");
        View r3 = r2.a;
        this.f = r3;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mIcon");
        r3 = null;
    L5:
        r3.setActivated(this.d);
    }

    public PlusKBPlugin(boolean r2, com.ss.android.lark.biz.im.api.extension.chat_window.b r3) {
        Intrinsics.checkNotNullParameter(r3, "pluginContext");
        this.d = r2;
        this.e = r3;
        this.j = new ArrayList();
        this.k = PlusKBPlugin$mOnPluginClickListener$1.INSTANCE;
        this.l = new LinkedHashSet();
        this.m = LazyKt.lazy(new PlusKBPlugin$plusExtension$2(this));
        Lazy r4 = ChatCoreModule.a;
        this.n = PanelMenuItem.InitialStrategy.Lazy;
        this.o = new LinkedHashSet();
        this.p = KeyboardMenuItemKey.Plus;
    }

    @Override // com.ss.android.lark.keyboard.base.b
    public final void e(int r3, Intent r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        Iterator<T> r0 = this.j.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((d5b.a) r0.next()).a(r4, r3);
        goto L4
    }
}

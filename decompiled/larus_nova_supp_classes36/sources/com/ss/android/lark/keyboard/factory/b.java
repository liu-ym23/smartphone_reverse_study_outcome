package com.ss.android.lark.keyboard.factory;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard;
import com.ss.android.lark.biz.im.api.extension.chat_window.d;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.keyboard.KeyboardViewModel;
import com.ss.android.lark.keyboard.base.IKeyboardSwitcherPlugin;
import com.ss.android.lark.keyboard.base.g;
import com.ss.android.lark.keyboard.base.inputinner.Direction;
import com.ss.android.lark.keyboard.base.inputinner.DirectionInParent;
import com.ss.android.lark.keyboard.biz.emoji.c;
import com.ss.android.lark.keyboard.biz.mention.i;
import com.ss.android.lark.keyboard.biz.plus.MorePlugin;
import com.ss.android.lark.keyboard.biz.voice.inject.f;
import com.ss.android.lark.keyboard.editor.FlowChatKeyboardEditor;
import com.ss.android.lark.keyboard.editor.inject.InputInnerController;
import com.ss.android.lark.keyboard.editor.input.SendPluginController;
import com.ss.android.lark.keyboard.editor.input.k;
import com.ss.android.lark.keyboard.keyboard2.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import wnb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class b {
    public final com.ss.android.lark.biz.im.api.extension.chat_window.b a;
    public final List<ChatWindowKeyboard.a> b;
    public final LinkedHashMap<String, d<m>> c;
    public final LinkedHashMap<String, d<d5b.a>> d;
    public final Set<Object> e;
    public final LinkedHashMap<String, d<? extends com.ss.android.lark.keyboard.base.d<?>>> f;
    public final LinkedHashMap<String, d<? extends g<?>>> g;
    public final LinkedHashMap<String, d<IKeyboardSwitcherPlugin>> h;
    public final LinkedHashMap<String, d<uxa.a>> i;
    public final LinkedHashMap<String, d<? extends wnb.b<?>>> j;

    public final void b() {
        com.ss.android.lark.biz.im.api.extension.chat_window.b r0 = this.a;
        com.ss.android.lark.keyboard.b r2 = r0.b;
        if (r2 != null) goto L5;
        return;
    L5:
        List<ChatWindowKeyboard.a> r3 = this.b;
        a r4 = (a) this;
        Intrinsics.checkNotNullParameter(r0, "pluginContext");
        Intrinsics.checkNotNullParameter(r3, "callbacks");
        r0.e = r4.m;
        r4.n = new MorePlugin(r0);
        ArrayList r5 = new ArrayList();
        r5.add(new i(r0));
        r5.add(new c(r4.m.d, r0, r4.l));
        r5.add(new xnb.c(r0));
        d<m> r6 = r4.n;
        Intrinsics.checkNotNull(r6);
        r5.add(r6);
        Iterator r7 = r5.iterator();
    L7:
        if (r7.hasNext() == false) goto L9;
        d<m> r8 = (d) r7.next();
        String r9 = r8.getName();
        Intrinsics.checkNotNullParameter(r9, "name");
        Intrinsics.checkNotNullParameter(r8, "plugin");
        r4.c.put(r9, r8);
        goto L7
    L9:
        Iterator r10 = new ArrayList().iterator();
    L11:
        if (r10.hasNext() == false) goto L13;
        d<d5b.a> r11 = (d) r10.next();
        String r12 = r11.getName();
        Intrinsics.checkNotNullParameter(r12, "name");
        Intrinsics.checkNotNullParameter(r11, "plusItem");
        r4.d.put(r12, r11);
        goto L11
    L13:
        d<? extends wnb.b<?>>[] r13 = {new com.ss.android.lark.keyboard.biz.mention.inject.i(r4.k, r0), new com.ss.android.lark.keyboard.biz.attachment.inject.a(r4.k, r0), new com.ss.android.lark.keyboard.biz.camera.inject.a(r4.k, r0), new f(r4.k, r0), new com.ss.android.lark.keyboard.biz.plus.inject.a(r4.k, r0), new com.ss.android.lark.keyboard.biz.send.inject.b(r4.k, r0), new aob.b(r4.k, r0), new com.ss.android.lark.keyboard.biz.send.inject.a(r4.k, r0), new com.ss.android.lark.keyboard.biz.mention.inject.d(r4.k, r0), new com.ss.android.lark.keyboard.biz.mention.inject.g(r4.k, r0), new com.ss.android.lark.keyboard.biz.emoji.inject.b(r4.k, r0), new ynb.d(r4.k, r0), new com.ss.android.lark.keyboard.biz.p000float.inject.b(r4.k, r0)};
        int r1 = 0;
    L14:
        if (r1 >= 13) goto L16;
        d<? extends wnb.b<?>> r14 = r13[r1];
        String r15 = r14.getName();
        Intrinsics.checkNotNullParameter(r15, "name");
        Intrinsics.checkNotNullParameter(r14, "plugin");
        r4.j.put(r15, r14);
        r1 = r1 + 1;
        goto L14
    L16:
        Iterator<T> r16 = this.b.iterator();
    L18:
        if (r16.hasNext() == false) goto L20;
        ((ChatWindowKeyboard.a) r16.next()).g(r2);
        goto L18
    L20:
        LinkedHashMap<String, d<? extends com.ss.android.lark.keyboard.base.d<?>>> r17 = this.f;
        LinkedHashMap<String, d<IKeyboardSwitcherPlugin>> r18 = this.h;
        LinkedHashMap<String, d<uxa.a>> r19 = this.i;
        LinkedHashMap<String, d<? extends wnb.b<?>>> r20 = this.j;
        Intrinsics.checkNotNullParameter(r2, "keyBoard");
        Intrinsics.checkNotNullParameter(r17, "inputBottomPlugins");
        Intrinsics.checkNotNullParameter(r18, "switcherPlugins");
        Intrinsics.checkNotNullParameter(r19, "sendPlugins");
        Intrinsics.checkNotNullParameter(r20, "inputInnerPlugins");
        com.ss.android.lark.keyboard.keyboard2.b r21 = r2.L();
        SendPluginController r110 = null;
        if ((r21 instanceof k) == false) goto L32;
        Iterator<T> r22 = r18.values().iterator();
        if (r22.hasNext() == false) goto L25;
        Object r23 = r22.next();
        ((d) r23).isEnable();
    L26:
        d r24 = (d) r23;
        if (r24 == null) goto L32;
        IKeyboardSwitcherPlugin r25 = (IKeyboardSwitcherPlugin) r24.getPlugin();
        if (r25 == null) goto L32;
        ((k) r21).l(r25);
        goto L32
    L25:
        r23 = null;
    L32:
        if ((r21 instanceof FlowChatKeyboardEditor) == false) goto L159;
        Collection<d<? extends com.ss.android.lark.keyboard.base.d<?>>> r26 = r17.values();
        ArrayList r27 = new ArrayList();
        Iterator<T> r28 = r26.iterator();
    L35:
        if (r28.hasNext() == false) goto L37;
        Object r111 = r28.next();
        ((d) r111).isEnable();
        r27.add(r111);
        goto L35
    L37:
        Iterator r29 = r27.iterator();
    L39:
        if (r29.hasNext() == false) goto L46;
        com.ss.android.lark.keyboard.base.d<?> r30 = (com.ss.android.lark.keyboard.base.d) ((d) r29.next()).getPlugin();
        if (r30 == null) goto L39;
        FlowChatKeyboardEditor r112 = (FlowChatKeyboardEditor) r21;
        r112.getClass();
        Intrinsics.checkNotNullParameter(r30, "plugin");
        com.ss.android.lark.keyboard.editor.inject.b r113 = r112.k;
        if (r113 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("inputBottomController");
        r113 = null;
    L45:
        r113.getClass();
        Intrinsics.checkNotNullParameter(r30, "plugin");
        r30.e();
        r30.c();
        Map<com.ss.android.lark.keyboard.base.d.a<?>, com.ss.android.lark.keyboard.base.d<?>> r31 = r113.b;
        r30.getKey();
        r31.put(null, r30);
        View r32 = r30.a();
        Map<com.ss.android.lark.keyboard.base.d.a<?>, View> r114 = r113.c;
        r30.getKey();
        r114.put(null, r32);
        r113.e.addView(r32);
        r32.setVisibility(8);
        goto L39
    L46:
        Collection<d<uxa.a>> r33 = r19.values();
        ArrayList r34 = new ArrayList();
        Iterator<T> r35 = r33.iterator();
    L48:
        if (r35.hasNext() == false) goto L50;
        Object r36 = r35.next();
        ((d) r36).isEnable();
        r34.add(r36);
        goto L48
    L50:
        Iterator r37 = r34.iterator();
    L52:
        if (r37.hasNext() == false) goto L59;
        uxa.a r38 = (uxa.a) ((d) r37.next()).getPlugin();
        if (r38 == null) goto L52;
        FlowChatKeyboardEditor r39 = (FlowChatKeyboardEditor) r21;
        r39.getClass();
        Intrinsics.checkNotNullParameter(r38, "plugin");
        SendPluginController r40 = r39.j;
        if (r40 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("sendPluginController");
        r40 = r110;
    L58:
        r40.getClass();
        Intrinsics.checkNotNullParameter(r38, "sendPlugin");
        r38.onCreate();
        int r41 = r38.c();
        View r115 = r38.a();
        ((HashMap) r40.d).put(Integer.valueOf(r41), r38);
        ((HashMap) r40.e).put(Integer.valueOf(r41), r115);
        r110 = null;
        goto L52
    L59:
        Collection<d<? extends wnb.b<?>>> r42 = r20.values();
        ArrayList r43 = new ArrayList();
        Iterator<T> r44 = r42.iterator();
    L61:
        if (r44.hasNext() == false) goto L63;
        Object r45 = r44.next();
        ((d) r45).isEnable();
        r43.add(r45);
        goto L61
    L63:
        Iterator r46 = r43.iterator();
    L65:
        if (r46.hasNext() == false) goto L159;
        wnb.b<?> r47 = (wnb.b) ((d) r46.next()).getPlugin();
        if (r47 == null) goto L65;
        FragmentActivity r48 = r4.a.a.getActivity();
        if ((r48 instanceof FragmentActivity) == false) goto L71;
        FragmentActivity r116 = r48;
    L205:
        Result.Companion r49 = Result.Companion;     // Catch: Throwable -> L74
        Object r50 = Result.constructor-impl(r2.L().c());     // Catch: Throwable -> L74
    L77:
        if (Result.isFailure-impl(r50) == false) goto L79;
        r50 = null;
    L79:
        EditText r210 = (EditText) r50;
        KeyboardViewModel r51 = j2b.d.a(r4.a);
        if (r51 == null) goto L84;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.keyboard.a r52 = r51.getDependency();
        if (r52 == null) goto L84;
        q4b.a r53 = r52.getMessageSender();
    L86:
        if ((r53 instanceof j4b.a) == false) goto L88;
        final j4b.a r54 = (j4b.a) r53;
    L89:
        if (r54 == null) goto L91;
        Function1<String, Unit> r211 = new FlowChatKeyboardPluginFactory$onAttachToKeyboardEditor$7$1$removeMessage$1$1(r54);
    L93:
        if ((r47 instanceof wnb.a) == false) goto L95;
        wnb.a r55 = (wnb.a) r47;
    L96:
        if (r55 == null) goto L98;
        com.ss.android.lark.biz.im.api.extension.chat_window.b r117 = r4.a;
        Fragment r118 = r117.a;
        String r212 = r117.c.getId();
        com.ss.android.lark.biz.im.api.extension.chat_window.b r119 = r4.a;
        r55.f(new wnb.d(r118, r116, r210, r212, r119.c, r119.d, r4.k, r53, r211));
    L98:
        FlowChatKeyboardEditor r56 = (FlowChatKeyboardEditor) r21;
        r56.getClass();
        Intrinsics.checkNotNullParameter(r47, "plugin");
        InputInnerController r57 = r56.l;
        if (r57 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("inputInnerController");
        r57 = null;
    L101:
        r57.getClass();
        Intrinsics.checkNotNullParameter(r47, "plugin");
        r47.setKeyboard(r57.a);
        r47.e(r57);
        wnb.b.a<?> r58 = r47.getKey();
        Direction r59 = r47.getDirection();
        ViewGroup r120 = (ViewGroup) ((Map) r57.j.getValue()).get(r59);
        if (r120 == null) goto L65;
        r57.e.put(r58, r47);
        r57.g.put(r58, r59);
        View r121 = r47.a();
        r57.f.put(r58, r121);
        ViewParent r122 = r121.getParent();
        if ((r122 instanceof ViewGroup) == false) goto L107;
        ViewGroup r123 = (ViewGroup) r122;
    L108:
        if (r123 == null) goto L110;
        r123.removeView(r121);
    L110:
        e r124 = r47.b();
        if (r121.getLayoutParams() == null) goto L113;
        int r125 = r121.getLayoutParams().width;
    L118:
        if (r121.getLayoutParams() != null) goto L120;
        int r126 = -2;
    L122:
        if (r59 != Direction.InnerEndVertical) goto L124;
    L127:
        FrameLayout.LayoutParams r127 = new FrameLayout.LayoutParams(r125, r126);
        r127.leftMargin = r124.a;
        r127.topMargin = r124.b;
        r127.rightMargin = r124.c;
        r127.bottomMargin = r124.d;
        if (r47.c() != DirectionInParent.TOP) goto L130;
        int r128 = 48;
    L131:
        r127.gravity = r128;
        ViewGroup.MarginLayoutParams r129 = r127;
    L132:
        r121.setLayoutParams(r129);
        r120.addView(r121);
        int r130 = InputInnerController.b.a[r47.d().ordinal()];
        if (r130 != 1) goto L135;
        r121.setVisibility(8);
        goto L65
    L135:
        if (r130 == 2) goto L152;
        if (r130 != 3) goto L150;
        if (r59 != Direction.InnerTop) goto L144;
        r121.setVisibility(8);
        if (r47.i() == false) goto L65;
        r57.a(r58);
        goto L65
    L144:
        if (r47.i() == false) goto L146;
        int r60 = 0;
    L147:
        r121.setVisibility(r60);
        goto L65
    L146:
        r60 = 8;
        goto L147
    L150:
        throw new NoWhenBranchMatchedException();
    L152:
        if (r59 != Direction.InnerTop) goto L155;
        r121.setVisibility(8);
        r57.a(r58);
        goto L65
    L155:
        r121.setVisibility(0);
        goto L65
    L130:
        r128 = 80;
        goto L131
    L124:
        if (r59 == Direction.InnerStart) goto L127;
        ViewGroup.MarginLayoutParams r131 = new ViewGroup.MarginLayoutParams(r125, r126);
        r131.leftMargin = r124.a;
        r131.topMargin = r124.b;
        r131.rightMargin = r124.c;
        r131.bottomMargin = r124.d;
        r129 = r131;
        goto L132
    L120:
        r126 = r121.getLayoutParams().height;
        goto L122
    L113:
        if (r59 != Direction.TopMiddle) goto L115;
        r125 = -1;
        goto L118
    L115:
        r125 = -2;
        goto L118
    L107:
        r123 = null;
        goto L108
    L95:
        r55 = null;
        goto L96
    L91:
        r211 = null;
        goto L93
    L88:
        r54 = null;
    L84:
        r53 = null;
    L74:
        th = move-exception;
        Result.Companion r61 = Result.Companion;
        r50 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L77
    L71:
        r116 = null;
    L159:
        com.ss.android.lark.keyboard.keyboard2.b r62 = r2.L();
        if ((r62 instanceof com.ss.android.lark.keyboard.base.i) == false) goto L162;
        com.ss.android.lark.keyboard.base.i r63 = (com.ss.android.lark.keyboard.base.i) r62;
    L163:
        if (r63 == null) goto L175;
        Collection<d<? extends g<?>>> r64 = this.g.values();
        ArrayList r65 = new ArrayList();
        Iterator<T> r66 = r64.iterator();
    L167:
        if (r66.hasNext() == false) goto L169;
        Object r67 = r66.next();
        ((d) r67).isEnable();
        r65.add(r67);
        goto L167
    L169:
        Iterator r68 = r65.iterator();
    L171:
        if (r68.hasNext() == false) goto L175;
        g<?> r69 = (g) ((d) r68.next()).getPlugin();
        if (r69 == null) goto L171;
        r63.r(r69);
    L175:
        Iterator<Map.Entry<String, d<m>>> r70 = this.c.entrySet().iterator();
    L177:
        if (r70.hasNext() == false) goto L181;
        Map.Entry<String, d<m>> r71 = r70.next();
        r71.getValue().isEnable();
        m r72 = (m) r71.getValue().getPlugin();
        if (r72 == null) goto L177;
        r2.H().G(r72);
        goto L177
    L181:
        com.ss.android.lark.keyboard.keyboard2.d r73 = r2.H();
        com.ss.android.lark.keyboard.keyboard2.g.a.getClass();
        r73.q(com.ss.android.lark.keyboard.keyboard2.g.a.c);
        r73.m();
        Collection<d<d5b.a>> r74 = this.d.values();
        ArrayList r75 = new ArrayList();
        Iterator<T> r76 = r74.iterator();
    L183:
        if (r76.hasNext() == false) goto L185;
        Object r77 = r76.next();
        ((d) r77).isEnable();
        r75.add(r77);
        goto L183
    L185:
        ArrayList r78 = new ArrayList();
        Iterator r79 = r75.iterator();
    L187:
        if (r79.hasNext() == false) goto L191;
        d5b.a r80 = (d5b.a) ((d) r79.next()).getPlugin();
        if (r80 == null) goto L187;
        r78.add(r80);
        goto L187
    L191:
        com.ss.android.lark.keyboard.biz.plus.a r81 = r4.n;
        if (r81 == null) goto L194;
        r81.b(r78);
        r81.a(this.e);
    L194:
        Iterator<T> r82 = this.b.iterator();
    L196:
        if (r82.hasNext() == false) goto L198;
        ((ChatWindowKeyboard.a) r82.next()).a();
        goto L196
    L198:
        com.ss.android.lark.keyboard.keyboard2.b r83 = r2.L();
        if ((r83 instanceof com.ss.android.lark.keyboard.base.i) == false) goto L201;
        com.ss.android.lark.keyboard.base.i r132 = (com.ss.android.lark.keyboard.base.i) r83;
    L202:
        if (r132 == null) goto L248;
        r132.v();
        return;
    L248:
        return;
    L201:
        r132 = null;
        goto L202
    L162:
        r63 = null;
        goto L163
    }

    public final void a(Collection<Object> r3) {
        Intrinsics.checkNotNullParameter(r3, "interceptors");
        this.e.addAll(r3);
        com.ss.android.lark.keyboard.biz.plus.a r0 = ((a) this).n;
        if ((r0 instanceof com.ss.android.lark.keyboard.biz.plus.a) == false) goto L5;
        com.ss.android.lark.keyboard.biz.plus.a r1 = r0;
    L6:
        if (r1 == null) goto L9;
        r1.a(r3);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public b(j2b.c r2, List r3) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        Intrinsics.checkNotNullParameter(r3, "callbacks");
        this.a = r2;
        this.b = r3;
        this.c = new LinkedHashMap(10);
        this.d = new LinkedHashMap(5);
        this.e = new LinkedHashSet();
        this.f = new LinkedHashMap(5);
        this.g = new LinkedHashMap(5);
        this.h = new LinkedHashMap(1);
        this.i = new LinkedHashMap(2);
        this.j = new LinkedHashMap(5);
    }
}

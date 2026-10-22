package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.tool;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ErrorReason;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ToolbarReasonTag;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.ContainerContextEnv;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.debug.NewToolbarDebugDialogFragment;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.f0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.l;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.q;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.f3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILiveEnterRoomCallback;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILivePreviewBusinessBridge;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILivePreviewBusinessInject;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import ev1.p;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import pp1.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class BottomToolbarHandler extends yo1.b {
    public final HashMap<Integer, Boolean> e;
    public final HashMap<Integer, Disposable> f;
    public final Lazy g;
    public final Lazy h;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ ILivePreviewBusinessBridge a;
        public final /* synthetic */ s b;

        public a(ILivePreviewBusinessBridge r1, s r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Unit r4 = (Unit) r3;
            this.a.sendLogger("livesdk_toolbar_icon_show", new BottomToolbarHandler$loadBehavior$$inlined$also$lambda$1$1(this));
        }
    }

    public static final class b implements View.OnLongClickListener {
        public final /* synthetic */ BottomToolbarHandler a;
        public final /* synthetic */ View b;
        public final /* synthetic */ s c;

        public b(BottomToolbarHandler r1, View r2, s r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r4) {
            NewToolbarDebugDialogFragment r5 = new NewToolbarDebugDialogFragment();
            ContainerContextEnv r0 = this.a.d;
            Intrinsics.checkNotNullParameter(r0, "env");
            r5.e = r0;
            FragmentActivity r1 = ContextUtil.contextToFragmentActivity(this.b.getContext());
            if (r1 != null) goto L6;
            return false;
        L6:
            FragmentManager r2 = r1.getSupportFragmentManager();
            String r3 = this.c.toString();
            LandscapeRestrictionOperation r6 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r5, r3, r6);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, r5, r6) == true) goto L16;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
        L10:
            r5.show(r2, r3);
            return true;
        L16:
            return true;
        }
    }

    @Override // yo1.b
    public final boolean o() {
        return false;
    }

    @Override // yo1.b, zo1.d
    public final void a() {
        Intrinsics.checkNotNullParameter("onRoomExit", "event");
        Iterator<Map.Entry<Integer, c0.b>> r0 = this.a.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        Map.Entry<Integer, c0.b> r1 = r0.next();
        s r2 = new s();
        r2.a = r1.getKey().intValue();
        f0 r3 = r2.l;
        Boolean r4 = this.e.get(r1.getKey());
        if (r4 == null) goto L8;
        boolean r5 = r4.booleanValue();
    L9:
        r3.b = r5;
        Unit r6 = Unit.INSTANCE;
        u(r2);
        goto L4
    L8:
        r5 = false;
        goto L9
    L10:
        HashMap<Integer, Disposable> r7 = this.f;
        if ((!r7.isEmpty()) == true) goto L14;
        r7 = null;
    L14:
        if (r7 == null) goto L19;
        Iterator<Map.Entry<Integer, Disposable>> r8 = r7.entrySet().iterator();
    L17:
        if (r8.hasNext() == false) goto L19;
        r8.next().getValue().dispose();
    L19:
        this.f.clear();
        this.a.clear();
        this.e.clear();
    }

    public BottomToolbarHandler(final ContainerContextEnv r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        super(r2);
        this.e = new HashMap();
        this.f = new HashMap();
        this.g = LazyKt.lazy(new BottomToolbarHandler$isInPreview$2(r2));
        this.h = LazyKt.lazy(new BottomToolbarHandler$toolbarManager$2(this));
    }

    @Override // zo1.e
    public final c0.b j(int r2) {
        return this.a.get(Integer.valueOf(r2));
    }

    @Override // yo1.b
    public final boolean p(final s r17) {
        Intrinsics.checkNotNullParameter(r17, "data");
        final int r7 = r17.a;
        a0 r0 = this.d.getToolbarConfig(r7);
        Function1<String, Unit> r1 = new BottomToolbarHandler$loadBehavior$reportErrorAction$1(this, r17);
        if (r0 != null) goto L6;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a r2 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b;
        r2.g(r17.a, r2.e(), "NotFoundConfig");
        r1.invoke(ErrorReason.NOT_FOUND_TOOLBAR_CONFIG.getValue());
        return false;
    L6:
        final ToolbarButton r12 = r0.l(this.b, false);
        if (r12 != null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a r3 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b;
        r3.g(r17.a, r3.e(), "NotFoundButton");
        r1.invoke(ErrorReason.NOT_FOUND_TOOLBAR_BUTTON.getValue());
        return false;
    L11:
        if (r0.m() == true) goto L13;
    L19:
        u(r17);
        final c0.b r13 = n(r17);
        if (r13 != null) goto L22;
    L92:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a r4 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b;
        r4.g(r17.a, r4.e(), "BehaviorIsNull");
        r1.invoke(ErrorReason.TOOLBAR_BEHAVIOR_IS_NULL.getValue());
        return false;
    L22:
        if ((r13 instanceof l) == true) goto L92;
        this.a.put(Integer.valueOf(r7), r13);
        this.e.put(Integer.valueOf(r7), Boolean.valueOf(r17.l.b));
        View r14 = this.d.k(r17);
        if (r14 != null) goto L28;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a r5 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b;
        r5.g(r17.a, r5.e(), "ViewIsNull");
        HashMap<String, String> r6 = q.a;
        q.a(r7, ToolbarReasonTag.CONFIG_ERROR, "view is null return");
        return false;
    L28:
        ot2.d r8 = this.d.c;
        if ((r8 instanceof ILivePreviewBusinessBridge.Provider) == true) goto L31;
        r8 = null;
    L31:
        ILivePreviewBusinessBridge.Provider r9 = (ILivePreviewBusinessBridge.Provider) r8;
        if (r9 == null) goto L34;
        ILivePreviewBusinessBridge r10 = r9.provide();
    L35:
        if (r10 != null) goto L37;
    L39:
        ILivePreviewBusinessBridge r15 = null;
    L41:
        if ((r13 instanceof ILivePreviewBusinessInject) == true) goto L43;
        c0.b r11 = null;
    L44:
        ILivePreviewBusinessInject r16 = (ILivePreviewBusinessInject) r11;
        if (r16 == null) goto L48;
        if (r15 == null) goto L48;
        final ILiveEnterRoomCallback r18 = r16.onBindBridge(r15);
    L50:
        if (((Boolean) this.g.getValue()).booleanValue() == false) goto L55;
        if (r15 != null) goto L53;
        q("获取enterRoom Bridge 为空");
    L53:
        if (r18 != null) goto L55;
        q("获取enterRoomCallback 为空");
    L55:
        final ILivePreviewBusinessBridge r19 = r15;
        r14.setOnClickListener(new BottomToolbarHandler$loadBehavior$1(this, r12, r18, r19, r17, r13, r7));
        if (v.a() == false) goto L58;
        r14.setOnLongClickListener(new b(this, r14, r17));
    L58:
        DataCenter r20 = this.c;
        if (r20 != null) goto L61;
    L69:
        DataCenter r21 = this.c;
        if (r21 == null) goto L73;
        r13.p4(r14, r21);
        r13.Bh(r12);
        r13.SY(r17);
    L73:
        if (p.c(this.c) == true) goto L75;
    L80:
        int r22 = 0;
    L82:
        if (r14.getVisibility() != 0) goto L84;
        v(r17, r22);
    L85:
        x3 r23 = (x3) this.h.getValue();
        if (r23 == null) goto L89;
        r23.A(r17, r13);
    L89:
        if (r17.m == true) goto L91;
        r(r17, true);
    L91:
        return true;
    L84:
        q("view not visible");
        goto L85
    L75:
        if (r17.a != NewToolbarButtonConstants.ToolbarMorePanel.INSTANCE.getId()) goto L80;
        Intrinsics.checkNotNullParameter(r17, "data");
        q("hideView " + r17);
        this.d.h(r17);
        c0.b r24 = this.a.get(Integer.valueOf(r17.a));
        r22 = 0;
        if (r24 == null) goto L79;
        r24.onHide(false);
    L79:
        v(r17, 8);
        goto L82
    L61:
        if (com.bytedance.android.live.core.utils.a0.c(r20) != true) goto L69;
        if (r14.getVisibility() != 0) goto L69;
        if (r15 == null) goto L69;
        Disposable r25 = this.f.get(Integer.valueOf(r17.a));
        if (r25 == null) goto L68;
        r25.dispose();
    L68:
        this.f.put(Integer.valueOf(r17.a), RxUtilKt.h(r15.observeVHSelect()).subscribe(new a(r15, r17)));
    L48:
        r18 = null;
        goto L50
    L43:
        r11 = r13;
        goto L44
    L37:
        if (((Boolean) this.g.getValue()).booleanValue() == false) goto L39;
        r15 = r10;
        goto L41
    L34:
        r10 = null;
        goto L35
    L13:
        if (j(r7) == null) goto L19;
        if (this.d.c(r7) == false) goto L18;
        q("getOrCreateBehavior " + r17 + " is showing");
        r1.invoke(ErrorReason.TOOLBAR_VIEW_IS_SHOWING.getValue());
        return false;
    L18:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a r26 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b;
        r26.g(r17.a, r26.e(), "ExistedButNotShow");
        goto L19
    }

    @Override // yo1.b
    public final void s(s r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        q("unload " + r4);
        this.d.h(r4);
        u(r4);
        c0.b r0 = this.a.remove(Integer.valueOf(r4.a));
        this.e.remove(Integer.valueOf(r4.a));
        v(r4, 8);
        x3 r1 = (x3) this.h.getValue();
        if (r1 == null) goto L5;
        r1.G(r4, r0);
    L5:
        r(r4, false);
    }

    @Override // yo1.b
    public final void t(s r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        c0.b r0 = j(r3.a);
        if (r0 == null) goto L8;
        r0.Mr(r3);
        x3 r1 = (x3) this.h.getValue();
        if (r1 == null) goto L9;
        r1.e(r3, r0);
        return;
    L9:
        return;
    }

    public final void u(s r4) {
        int r0 = r4.a;
        View r1 = this.d.l(r0);
        c0.b r2 = j(r0);
        if (r2 == null) goto L11;
        if (r1 == null) goto L11;
        DataCenter r3 = this.c;
        if (r3 == null) goto L8;
        r2.R9(r1, r3);
        r2.onHide(r4.l.b);
    L8:
        r1.setOnClickListener(null);
        Disposable r5 = this.f.remove(Integer.valueOf(r4.a));
        if (r5 == null) goto L13;
        r5.dispose();
        return;
    L13:
        return;
    L11:
        q("unload " + r4 + " behavior is null");
    }

    public final void v(s r5, int r6) {
        ToolbarButton r0 = f3.b(r5, false, false);
        DataCenter r1 = this.c;
        if (r1 == null) goto L7;
        if (r6 != 0) goto L7;
        if (r0 == null) goto L7;
        r1.put("data_toolbar_visible", r0.name());
    L7:
        int r7 = r5.a;
        m r2 = new m(r6);
        Intrinsics.checkNotNullParameter(r2, "command");
        c0.b r8 = j(r7);
        if (r8 == null) goto L10;
        r8.dv(r2);
    L10:
        if (r0 == null) goto L17;
        DataCenter r9 = this.c;
        if (r9 != null) goto L14;
        return;
    L14:
        if (((Boolean) r9.get("cmd_hide_other_toolbar", Boolean.FALSE)).booleanValue() == false) goto L19;
        this.c.put("cmd_toolbar_visibility_controller", new Pair(r0.extended(), Integer.valueOf(r6)));
        return;
    L19:
        return;
    }
}

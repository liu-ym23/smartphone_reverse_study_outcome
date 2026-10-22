package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.log.c;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ErrorReason;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ToolbarReasonTag;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.ContainerContextEnv;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.ListActionEnum;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.ToolbarQuickLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.d0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.q;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.z;
import com.bytedance.android.livesdk.config.fv0;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import zo1.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ToolbarOperateManager {
    public final Lazy a;
    public ap1.a b;
    public ComponentConfigManager c;
    public final HashMap<ot2.a, ContainerContextEnv> d;
    public final ArrayList<s> e;
    public final HashMap<Integer, Disposable> f;
    public z g;
    public final DataCenter h;

    public static final class a implements c {
        public final /* synthetic */ s a;
        public final /* synthetic */ String b;

        public a(s r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final String generate() {
            return this.a + " is only horizon " + this.b;
        }
    }

    public static final class b implements c {
        public final /* synthetic */ s a;
        public final /* synthetic */ String b;

        public b(s r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final String generate() {
            return this.a + " is only portrait " + this.b;
        }
    }

    public ToolbarOperateManager(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.h = r2;
        this.a = LazyKt.lazy(new ToolbarOperateManager$isAnchor$2(this));
        this.d = new HashMap();
        this.e = new ArrayList();
        this.f = new HashMap();
    }

    public final void a(final s r4) {
        Intrinsics.checkNotNullParameter(r4, "toolbarButton");
        if (c(r4, "toMore") == true) goto L5;
        return;
    L5:
        ComponentConfigManager r1 = this.c;
        if (r1 == null) goto L14;
        Intrinsics.checkNotNullParameter(r4, "toolbarButton");
        a0 r0 = r1.a.get(r4.a);
        if (r0 == null) goto L10;
        boolean r2 = r0.o();
    L12:
        if (r2 != true) goto L14;
        d("more", r4, new ToolbarOperateManager$addToMorePanel$1(this, r4), null);
        return;
    L10:
        r2 = false;
    L14:
        g(ListActionEnum.ADD, ot2.a.b.a, r4);
    }

    public final void b(s r5) {
        Intrinsics.checkNotNullParameter(r5, "toolbarButton");
        if (c(r5, "toToolbar") == true) goto L6;
        HashMap<String, String> r0 = q.a;
        q.a(r5.a, ToolbarReasonTag.NORMAL, " by orientation check");
        int r1 = d0.a;
        d0.a(String.valueOf(r5.a), this.h, r5.l.b, ErrorReason.ORIENTATION_CHECK.getValue(), null);
        return;
    L6:
        g(ListActionEnum.ADD, ot2.a.a.a, r5);
    }

    public final boolean f(s r5) {
        Intrinsics.checkNotNullParameter(r5, "toolbarButton");
        Boolean r1 = o3.j(this.h).isPortraitInteraction();
        if (r1 == null) goto L5;
        boolean r2 = r1.booleanValue();
    L7:
        if (fv0.a.getValue().getToolbarShowOpt() == false) goto L14;
        if (r2 == false) goto L14;
        if (((Boolean) this.a.getValue()).booleanValue() == true) goto L14;
        Set<Integer> r3 = ToolbarQuickLoader.a;
        Intrinsics.checkNotNullParameter(r5, "toolbarButton");
        if (ToolbarQuickLoader.a.contains(Integer.valueOf(r5.a)) == false) goto L14;
        return true;
    L14:
        return false;
    L5:
        r2 = true;
        goto L7
    }

    public final void h(s r3) {
        Intrinsics.checkNotNullParameter(r3, "toolbarButton");
        this.e.remove(r3);
        Disposable r0 = this.f.remove(Integer.valueOf(r3.a));
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        g(ListActionEnum.REMOVE, ot2.a.a.a, r3);
    }

    public final boolean c(s r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "toolbarButton");
        Intrinsics.checkNotNullParameter(r7, "action");
        Boolean r0 = (Boolean) this.h.get("data_is_portrait", Boolean.TRUE);
        if (r6.g != 2) goto L14;
        if (r0.booleanValue() == false) goto L14;
        if (r6.a == 38) goto L9;
    L11:
        ALogger.d(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b.getTAG(), new a(r6, r7));
        return false;
    L9:
        if (e5.n() == false) goto L11;
        return true;
    L14:
        if (r6.g == 1) goto L16;
    L19:
        return true;
    L16:
        if (r0.booleanValue() == true) goto L19;
        ALogger.d(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b.getTAG(), new b(r6, r7));
        return false;
    }

    public final List<s> e(ot2.a r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "containerType");
        Intrinsics.checkNotNullParameter(r4, "key");
        ContainerContextEnv r5 = this.d.get(r3);
        if (r5 == null) goto L10;
        Intrinsics.checkNotNullParameter(r4, "key");
        f<s> r6 = r5.e;
        if (r6 == null) goto L7;
        List<s> r7 = r6.b(r4);
    L8:
        if (r7 == null) goto L10;
        return r7;
    L7:
        r7 = null;
    L10:
        return new ArrayList();
    }

    public final void g(ListActionEnum r10, ot2.a r11, s r12) {
        boolean r1 = true;
        boolean r0 = !Intrinsics.areEqual(r11, ot2.a.a.a);
        r12.l.a = Boolean.valueOf(r0);
        Boolean r2 = (Boolean) this.h.get("data_is_anchor", Boolean.FALSE);
        ListActionEnum r3 = ListActionEnum.ADD;
        if (r10 != r3) goto L5;
        boolean r5 = true;
    L6:
        ContainerContextEnv r13 = this.d.get(r11);
        if (r13 == null) goto L54;
        f<s> r6 = r13.e;
        if (r6 == null) goto L56;
        int r7 = e.a[r10.ordinal()];
        if (r7 != 1) goto L13;
        ComponentConfigManager r8 = r13.a;
        if (r8 != null) goto L27;
    L32:
        ALogger.i(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b.getTAG(), r12 + " stop load");
    L33:
        r1 = false;
    L34:
        if (r10 != r3) goto L36;
    L37:
        c0.b r14 = r13.j(r12.a);
        String r15 = r12.toString();
        String r16 = "";
        if (r14 == null) goto L40;
        String r17 = r14.getClass().getSimpleName();
    L41:
        StringBuilder r4 = new StringBuilder(" in ");
        if (r0 == false) goto L45;
        String r18 = "more";
    L49:
        r4.append(r18);
        String r19 = r4.toString();
        if (r5 == false) goto L52;
        String r9 = "load";
    L53:
        ALogger.i(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b.getTAG(), "realInvokeFunc " + r15 + ' ' + r9 + ' ' + r17 + ' ' + r19);
        return;
    L52:
        r9 = "unload";
        goto L53
    L45:
        if (r5 == false) goto L48;
        if (r1 == false) goto L48;
        r16 = "move to more";
    L48:
        r18 = "toolbar".concat(r16);
        goto L49
    L40:
        r17 = "";
        goto L41
    L36:
        if (r10 == ListActionEnum.REMOVE) goto L37;
        return;
    L27:
        if (r8.a(r12, r2.booleanValue(), r0, r13.f) != true) goto L32;
        if (r6.f(r12) == false) goto L31;
        ALogger.i(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b.getTAG(), r12 + " add success");
        goto L33
    L31:
        ALogger.i(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b.getTAG(), r12 + " add to more");
        goto L34
    L13:
        if (r7 == 2) goto L22;
        if (r7 != 3) goto L33;
        if (r6.m(r12) == false) goto L20;
        ALogger.i(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b.getTAG(), r12 + " update");
        goto L33
    L20:
        ALogger.e(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b.getTAG(), "error, updating an unload behavior.");
        goto L33
    L22:
        if (r6.i(r12) == false) goto L33;
        ALogger.i(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b.getTAG(), r12 + "  remove success");
        goto L33
    L56:
        return;
    L54:
        int r110 = d0.a;
        d0.a(String.valueOf(r12.a), this.h, r12.l.b, ErrorReason.FIND_CONTAINER_IS_NULL.getValue(), null);
        Unit r111 = Unit.INSTANCE;
        return;
    L5:
        r5 = false;
        goto L6
    }

    public final void d(final String r11, final s r12, final Function1<? super s, Unit> r13, final Function1<? super s, Unit> r14) {
        Intrinsics.checkNotNullParameter(r11, "actionName");
        Intrinsics.checkNotNullParameter(r12, "toolbarButton");
        Intrinsics.checkNotNullParameter(r13, "action");
        final long r7 = System.currentTimeMillis();
        final int r0 = r12.a;
        q.c = r0;
        if (r12.l.b == false) goto L8;
        Disposable r1 = this.f.remove(Integer.valueOf(r0));
        if (r1 == null) goto L7;
        r1.dispose();
    L7:
        this.f.put(Integer.valueOf(r0), com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b.c(r0, new ToolbarOperateManager$checkThenDo$taskDispose$1(this, r0)));
    L8:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a r2 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b;
        ALogger.i(r2.getTAG(), "checkThenDoAction " + r11 + " - " + r12 + " - " + r7);
    L16:
        e = move-exception;
        ALogger.e(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b.getTAG(), "Handle data Crash.");
        if (v.a() == true) goto L21;
        HashMap<String, String> r15 = q.a;
        q.b("Load " + r12.a + " Component Crash.");
        SafetyGuard.a(null, e, "NewToolbarLog Action Crash");
        return;
    L21:
        throw e;
    L10:
        if (this.g != null) goto L12;
        r2.g(r2.i(), r2.d(), "CheckManagerNewNull");     // Catch: Exception -> L16
    L12:
        z r3 = this.g;     // Catch: Exception -> L16
        if (r3 == null) goto L24;
        r3.f(r11, r12, new ToolbarOperateManager$checkThenDo$1(r11, r12, r7, r13), new ToolbarOperateManager$checkThenDo$2(r12, r14, r11, r7));     // Catch: Exception -> L16
        return;
    }
}

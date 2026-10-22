package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.h21;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.toolbar.ToolbarBehaviorData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ToolbarOperateManager {
    public final Lazy a;
    public k b;
    public final ArrayList<s> c;
    public final DataCenter d;

    public final boolean e() {
        return ((Boolean) this.a.getValue()).booleanValue();
    }

    public ToolbarOperateManager(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.d = r2;
        this.a = LazyKt.lazy(new ToolbarOperateManager$isAnchor$2(this));
        this.c = new ArrayList();
    }

    public final void a(final s r4) {
        Intrinsics.checkNotNullParameter(r4, "toolbarButton");
        if (c(r4, "toMore") == true) goto L6;
        return;
    L6:
        if (((Boolean) h21.a.getValue()).booleanValue() == false) goto L15;
        k r1 = this.b;
        if (r1 == null) goto L15;
        Intrinsics.checkNotNullParameter(r4, "toolbarButton");
        a0 r0 = r1.a.get(r4.a);
        if (r0 == null) goto L12;
        boolean r2 = r0.o();
    L13:
        if (r2 != true) goto L15;
        d("more", r4, new ToolbarOperateManager$addToMorePanel$1(this, r4));
        return;
    L12:
        r2 = false;
    L15:
        f(true, true, r4, new ToolbarOperateManager$addToMorePanel$2(y3.f(this.d)));
    }

    public final void b(s r4) {
        Intrinsics.checkNotNullParameter(r4, "toolbarButton");
        if (c(r4, "toToolbar") == true) goto L6;
        HashMap<String, String> r0 = q.a;
        q.a(r4.a, ToolbarReasonTag.NORMAL, " by orientation check");
        return;
    L6:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r1 = y3.m(this.d);
        if (r1 == null) goto L11;
        f(false, true, r4, new ToolbarOperateManager$addToToolbar$1((x3) r1));
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarManager");
    }

    public final void g(s r4) {
        Intrinsics.checkNotNullParameter(r4, "toolbarButton");
        f(true, false, r4, new ToolbarOperateManager$removeFromMorePanel$1(y3.f(this.d)));
    }

    public final void h(s r3) {
        Intrinsics.checkNotNullParameter(r3, "toolbarButton");
        this.c.remove(r3);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r1 = y3.m(this.d);
        if (r1 == null) goto L7;
        f(false, false, r3, new ToolbarOperateManager$removeFromToolbar$1((x3) r1));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarManager");
    }

    public final boolean c(s r7, String r8) {
        Boolean r0 = (Boolean) this.d.get("data_is_portrait", Boolean.TRUE);
        if (r7.g != 2) goto L14;
        if (r0.booleanValue() == false) goto L14;
        if (r7.a == 38) goto L9;
    L11:
        ALogger.d("NewToolbarLog", r7 + " is only horizon " + r8);
        return false;
    L9:
        if (e5.n() == false) goto L11;
        return true;
    L14:
        if (r7.g == 1) goto L16;
    L19:
        return true;
    L16:
        if (r0.booleanValue() == true) goto L19;
        ALogger.d("NewToolbarLog", r7 + " is only portrait " + r8);
        return false;
    }

    public final void d(final String r11, final s r12, final Function1<? super s, Unit> r13) {
        Intrinsics.checkNotNullParameter(r11, "actionName");
        Intrinsics.checkNotNullParameter(r12, "toolbarButton");
        Intrinsics.checkNotNullParameter(r13, "action");
        final long r7 = System.currentTimeMillis();
        HashMap<String, String> r0 = q.a;
        q.c = r12.a;
        ALogger.i("NewToolbarLog", "checkThenDoAction " + r11 + " - " + r12 + " - " + r7);
        Lazy r1 = ToolbarComponentCheckManager.a;
        DataCenter r2 = this.d;
        final Function0<Unit> r9 = new ToolbarOperateManager$checkThenDo$1(r11, r12, r7, r13);
        final Function1<String, Unit> r14 = new ToolbarOperateManager$checkThenDo$2(r12, r11, r7);
        Intrinsics.checkNotNullParameter(r12, "model");
        Intrinsics.checkNotNullParameter(r9, "loadButton");
        Intrinsics.checkNotNullParameter(r14, "stopLoadCallback");
        ToolbarComponentCheckManager.h(r2, new ToolbarComponentCheckManager$doubleCheckThenLoad$1(r12, r9, r14), new ToolbarComponentCheckManager$doubleCheckThenLoad$2(r12, r9, r14));
    }

    public final void f(boolean r22, boolean r23, s r24, Function2<? super s, ? super com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b, Unit> r25) {
        k r10 = this.b;
        if (r10 == null) goto L60;
        r24.l.a = Boolean.valueOf(r22);
        if (r23 == false) goto L7;
        String r1 = "cmd_specific_behavior_loaded";
    L8:
        String r11 = r1;
        if (r23 == false) goto L11;
        Function3 r2 = new ToolbarOperateManager$realInvokeFunc$1$getBehaviorFunc$1(r10);
    L12:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b r12 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b) r2.invoke(r24, Boolean.valueOf(r22), Boolean.valueOf(e()));
        String r18 = "null";
        if (r12 == null) goto L45;
        r25.invoke(r24, r12);
        boolean r3 = e();
        Intrinsics.checkNotNullParameter(r24, "toolbarButton");
        a0 r4 = r10.a.get(r24.a);
        if (r4 == null) goto L20;
        String r5 = r4.i(r22, r3);
        if (r5 == null) goto L20;
        String r6 = r5;
    L21:
        String r20 = "more";
        String r19 = "toolbar";
        this.d.put(r11, new ToolbarBehaviorData(r6, r22, r24.l.b, r24.a, r24.d, r24.c));
        if (r23 == false) goto L26;
        boolean r7 = e();
        Intrinsics.checkNotNullParameter(r24, "toolbarButton");
        Intrinsics.checkNotNullParameter(r12, "behavior");
        a0 r0 = r10.a.get(r24.a);
        if (r0 == null) goto L29;
        r0.a(r10.c(r24, r22, r7));
    L29:
        com.bytedance.android.livesdk.sharedpref.e<Long> r8 = b.a;
        boolean r9 = e();
        Intrinsics.checkNotNullParameter(r24, "toolbarButton");
        if (r23 == false) goto L32;
        String r13 = "load";
    L33:
        String r14 = String.valueOf(r24.a);
        if (r22 == false) goto L36;
        String r15 = r20;
    L37:
        if (r9 == false) goto L39;
        String r16 = SourceType.ANCHOR;
    L41:
        if (r24.l.b == false) goto L43;
        String r17 = "msg";
    L44:
        xs2.b.a().post(new zg1.h("ToolbarCheck", "path: " + r13 + ' ' + r14 + ' ' + r15 + ' ' + r16 + ' ' + r17));
    L46:
        String r21 = r24.toString();
        if (r12 == null) goto L50;
        r18 = r12.getClass().getSimpleName();
    L50:
        String r26 = r18;
        if (r22 == false) goto L53;
        String r110 = r20;
    L54:
        String r27 = " in ".concat(r110);
        if (r23 == false) goto L57;
        String r28 = "load";
    L58:
        ALogger.i("NewToolbarLog", "realInvokeFunc " + r21 + ' ' + r28 + ' ' + r26 + ' ' + r27);
        return;
    L57:
        r28 = "unload";
        goto L58
    L53:
        r110 = r19;
        goto L54
    L43:
        r17 = "room";
        goto L44
    L39:
        r16 = SourceType.DEFAULT;
        goto L41
    L36:
        r15 = r19;
        goto L37
    L32:
        r13 = "unload";
        goto L33
    L26:
        boolean r29 = e();
        Intrinsics.checkNotNullParameter(r24, "toolbarButton");
        Intrinsics.checkNotNullParameter(r12, "behavior");
        a0 r30 = r10.a.get(r24.a);
        if (r30 == null) goto L29;
        r30.b(r10.c(r24, r22, r29));
    L20:
        r6 = "null";
        goto L21
    L45:
        r20 = "more";
        r19 = "toolbar";
        r12 = null;
        goto L46
    L11:
        r2 = new ToolbarOperateManager$realInvokeFunc$1$getBehaviorFunc$2(r10);
        goto L12
    L7:
        r1 = "cmd_specific_behavior_un_loaded";
        goto L8
    }
}

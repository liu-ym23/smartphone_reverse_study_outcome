package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.tool;

import bp1.j;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ErrorReason;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ToolbarReasonTag;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.ListActionEnum;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.d0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.q;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.config.pg;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveToolbarData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import zo1.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class BottomToolbarContainerDataManager extends zo1.a {
    public static final /* synthetic */ int g = 0;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final DataCenter e;
    public final Function1<Integer, Boolean> f;

    public final int r() {
        int r1 = 5;
        if (((Boolean) this.b.getValue()).booleanValue() == false) goto L16;
        o r0 = j.b(this.e);
        if (r0 == null) goto L15;
        m r2 = r0.getRoom();
        if (r2 == null) goto L15;
        IRoom r3 = (IRoom) r2.getValue();
        if (r3 == null) goto L15;
        ILiveToolbarData r4 = r3.getToolbarData();
        if (r4 == null) goto L15;
        Integer r5 = r4.getMaxCount();
        if (r5 == null) goto L15;
        int r6 = r5.intValue();
    L26:
        if (r6 == 0) goto L28;
    L33:
        int r7 = Math.max(r6, 0);
        if (v.a() == false) goto L39;
        pg r8 = pg.a;
        if (((Number) r8.getValue()).intValue() > 0) goto L38;
        return r7;
    L38:
        return ((Integer) r8.getValue()).intValue();
    L39:
        return r7;
    L28:
        if (((Boolean) this.d.getValue()).booleanValue() == false) goto L33;
        u("max slot size is 0.");
        if (((Boolean) this.b.getValue()).booleanValue() == false) goto L32;
        r1 = 4;
    L32:
        r6 = r1;
    L15:
        r6 = 4;
        goto L26
    L16:
        o r9 = j.b(this.e);
        if (r9 == null) goto L25;
        m r10 = r9.getRoom();
        if (r10 == null) goto L25;
        IRoom r11 = (IRoom) r10.getValue();
        if (r11 == null) goto L25;
        ILiveToolbarData r12 = r11.getToolbarData();
        if (r12 == null) goto L25;
        r6 = r12.getMaxCountLandscape();
    L25:
        r6 = 5;
        goto L26
    }

    @Override // zo1.f
    public final boolean f(s r10) {
        final s r11 = r10;
        Intrinsics.checkNotNullParameter(r11, "data");
        Function1<String, Unit> r0 = new BottomToolbarContainerDataManager$addModel$errorReport$1(this, r11);
        i r1 = n();
        Object r2 = null;
        if (r1 == null) goto L5;
        List r3 = r1.a;
    L7:
        if (r3 != null) goto L9;
        u("showing list empty.");
        q(r11.a, "list empty");
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a r4 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b;
        r4.g(r11.a, r4.e(), "ListEmpty");
        r0.invoke(ErrorReason.SHOWING_LIST_EMPTY.getValue());
        return false;
    L9:
        Iterator r5 = r3.iterator();
    L11:
        if (r5.hasNext() == false) goto L18;
        Object r6 = r5.next();
        if (((s) r6).f != r11.f) goto L15;
        boolean r7 = true;
    L16:
        if (r7 == false) goto L11;
    L19:
        s r8 = (s) r6;
        if (r8 == null) goto L23;
        u(r11 + " try replace same group " + r8);
        return t(r8, r11, "same group");
    L23:
        if (r3.size() >= r()) goto L26;
        u("add " + r11 + " when space enough.");
        o(r11);
        return true;
    L26:
        if (r3.size() != r()) goto L43;
        Iterator r9 = r3.iterator();
        if (r9.hasNext() == false) goto L39;
        r2 = r9.next();
        if (r9.hasNext() == false) goto L39;
        int r12 = s(((s) r2).f);
    L34:
        Object r13 = r9.next();
        int r14 = s(((s) r13).f);
        if (r12 <= r14) goto L38;
        r2 = r13;
        r12 = r14;
    L38:
        if (r9.hasNext() == true) goto L34;
    L39:
        s r15 = (s) r2;
        if (r15 == null) goto L42;
        u("try replace with lowest data " + r15);
        return t(r15, r11, "lowest");
    L42:
        u("list null error. size = " + r());
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a r16 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b;
        r16.g(r11.a, r16.e(), "list null error. ");
        r0.invoke(ErrorReason.REPLACE_LIST_EMPTY.getValue());
        return false;
    L43:
        u("over size error. size = " + r());
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a r17 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b;
        r17.g(r11.a, r17.e(), "over size error.");
        r0.invoke(ErrorReason.REPLACE_LIST_OVER_SIZE.getValue());
        return false;
    L15:
        r7 = false;
        goto L16
    L18:
        r6 = null;
        goto L19
    L5:
        r3 = null;
        goto L7
    }

    @Override // zo1.a, zo1.f
    public final Integer getComponentByGroupId(int r4) {
        i r0 = n();
        if (r0 == null) goto L19;
        AbstractCollection r1 = r0.a;
        if (r1 == null) goto L19;
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L15;
        Object r3 = r2.next();
        if (((s) r3).f != r4) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == false) goto L8;
    L16:
        s r6 = (s) r3;
        if (r6 == null) goto L19;
        int r7 = r6.a;
    L21:
        return Integer.valueOf(r7);
    L12:
        r5 = false;
        goto L13
    L15:
        r3 = null;
    L19:
        r7 = -1;
        goto L21
    }

    @Override // zo1.f
    public final boolean i(s r12) {
        s r13 = r12;
        Intrinsics.checkNotNullParameter(r13, "data");
        i r0 = n();
        Object r1 = null;
        if (r0 == null) goto L5;
        Boolean r2 = Boolean.valueOf(r0.b(r13, ListActionEnum.REMOVE));
    L6:
        i r3 = e();
        if (r3 == null) goto L9;
        Boolean r4 = Boolean.valueOf(r3.b(r13, ListActionEnum.REMOVE));
    L10:
        Boolean r5 = Boolean.TRUE;
        if (Intrinsics.areEqual(r2, r5) == false) goto L14;
        u("remove " + r13 + " from showing list.");
    L14:
        if (Intrinsics.areEqual(r4, r5) == false) goto L17;
        u("remove " + r13 + " from ready list.");
    L17:
        if (Intrinsics.areEqual(r2, r5) == false) goto L56;
        i r14 = e();
        if (r14 == null) goto L21;
        Collection r15 = r14.a;
    L22:
        if (r15 != null) goto L24;
    L26:
        if (r15 == null) goto L56;
        List r16 = CollectionsKt.sortedWith(r15, new a(this));
        if (r16 == null) goto L56;
        Iterator r17 = r16.iterator();
    L31:
        if (r17.hasNext() == false) goto L53;
        Object r6 = r17.next();
        s r7 = (s) r6;
        i r8 = n();
        if (r8 == null) goto L47;
        AbstractCollection r9 = r8.a;
        if (r9 == null) goto L47;
        Iterator r10 = r9.iterator();
    L38:
        if (r10.hasNext() == false) goto L45;
        Object r11 = r10.next();
        if (r7.f != ((s) r11).f) goto L42;
        boolean r18 = true;
    L43:
        if (r18 == false) goto L38;
    L46:
        s r19 = (s) r11;
    L48:
        if (r19 != null) goto L50;
        boolean r20 = true;
    L51:
        if (r20 == false) goto L31;
        r1 = r6;
        goto L53
    L50:
        r20 = false;
        goto L51
    L42:
        r18 = false;
        goto L43
    L45:
        r11 = null;
    L47:
        r19 = null;
    L53:
        s r21 = (s) r1;
        if (r21 == null) goto L56;
        u("find " + r21 + " from ready list, then load");
        o(r21);
        goto L56
    L24:
        if ((!r15.isEmpty()) != true) goto L26;
        u("try load data from ready list.");
        goto L26
    L21:
        r15 = null;
    L56:
        Boolean r110 = Boolean.TRUE;
        if (Intrinsics.areEqual(r2, r110) == false) goto L59;
    L60:
        return true;
    L59:
        if (Intrinsics.areEqual(r4, r110) == true) goto L60;
        return false;
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    @Override // zo1.f
    public final boolean m(s r5) {
        s r6 = r5;
        Intrinsics.checkNotNullParameter(r6, "data");
        i r0 = e();
        Boolean r1 = null;
        if (r0 == null) goto L5;
        Boolean r2 = Boolean.valueOf(r0.b(r6, ListActionEnum.UPDATE));
    L6:
        i r3 = n();
        if (r3 == null) goto L9;
        r1 = Boolean.valueOf(r3.b(r6, ListActionEnum.UPDATE));
    L9:
        u("update " + r6);
        Boolean r7 = Boolean.TRUE;
        if (Intrinsics.areEqual(r2, r7) == false) goto L12;
    L15:
        return true;
    L12:
        if (Intrinsics.areEqual(r1, r7) == true) goto L15;
        return false;
    L5:
        r2 = null;
        goto L6
    }

    public final void o(s r3) {
        i r0 = e();
        if (r0 == null) goto L5;
        r0.b(r3, ListActionEnum.REMOVE);
    L5:
        i r1 = n();
        if (r1 == null) goto L8;
        r1.b(r3, ListActionEnum.ADD);
    L8:
        p(r3, true);
    }

    public final int s(int r4) {
        List r0 = (List) this.c.getValue();
        if (r0.isEmpty() == false) goto L5;
        u("priority list is empty");
    L5:
        int r1 = r0.indexOf(Integer.valueOf(r4));
        if (r1 != (-1)) goto L10;
        u("cant find priority by group id :" + r4);
        return 0;
    L10:
        return r0.size() - r1;
    }

    public final void u(String r4) {
        ALogger.i(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b.b(), "data " + r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BottomToolbarContainerDataManager(DataCenter r4, Function1<? super Integer, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r5, "checkViewFunc");
        this.e = r4;
        this.f = r5;
        this.b = LazyKt.lazy(new BottomToolbarContainerDataManager$isPortrait$2(this));
        this.c = LazyKt.lazy(new BottomToolbarContainerDataManager$priorityList$2(this));
        this.d = LazyKt.lazy(BottomToolbarContainerDataManager$needForceDefault$2.INSTANCE);
        i r6 = new i(new ArrayList(), new ArrayList());
        Intrinsics.checkNotNullParameter("showing", "key");
        Intrinsics.checkNotNullParameter(r6, "list");
        this.a.put("showing", r6);
        i r7 = new i(new ArrayList(), new ArrayList());
        Intrinsics.checkNotNullParameter("ready", "key");
        Intrinsics.checkNotNullParameter(r7, "list");
        this.a.put("ready", r7);
    }

    public final void p(s r3, boolean r4) {
        if (((Boolean) this.f.invoke(Integer.valueOf(r3.a))).booleanValue() == r4) goto L6;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a r5 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b;
        r5.g(r3.a, r5.e(), "CheckViewError");
        return;
    }

    public final void q(int r6, String r7) {
        i r0 = n();
        String r1 = "";
        if (r0 == null) goto L6;
        String r2 = r0.a();
        if (r2 == null) goto L6;
    L7:
        i r3 = e();
        if (r3 == null) goto L13;
        String r4 = r3.a();
        if (r4 == null) goto L13;
        r1 = r4;
    L13:
        HashMap<String, String> r5 = q.a;
        q.a(r6, ToolbarReasonTag.MUTEX_ERROR, " " + r7 + " slot_size:" + r() + " Showings:" + r2 + "  WouldShow:" + r1);
        return;
    L6:
        r2 = "";
        goto L7
    }

    public final boolean t(s r8, s r9, String r10) {
        if (s(r8.f) > s(r9.f)) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L18;
        u("replace from " + r8 + " to " + r9);
        if ((!Intrinsics.areEqual(r9, r8)) == false) goto L17;
        i r1 = n();
        if (r1 == null) goto L13;
        r1.b(r8, ListActionEnum.REMOVE);
    L13:
        i r2 = e();
        if (r2 == null) goto L16;
        r2.b(r8, ListActionEnum.ADD);
    L16:
        p(r8, false);
    L17:
        o(r9);
        q(r8.a, r10 + " priority is lower than " + r9 + ", so hide it.");
        return true;
    L18:
        u(r9 + " priority below " + r8);
        i r3 = n();
        if (r3 == null) goto L21;
        r3.b(r9, ListActionEnum.REMOVE);
    L21:
        i r4 = e();
        if (r4 == null) goto L24;
        r4.b(r9, ListActionEnum.ADD);
    L24:
        p(r9, false);
        q(r9.a, r10 + " priority is lower than " + r8 + ", so not show.");
        int r5 = d0.a;
        d0.a(String.valueOf(r9.a), this.e, r9.l.b, ErrorReason.LOW_PRIORITY.getValue(), r10 + " priority is lower than " + r8 + ", so not show.");
        return false;
    L5:
        r0 = false;
        goto L7
    }
}

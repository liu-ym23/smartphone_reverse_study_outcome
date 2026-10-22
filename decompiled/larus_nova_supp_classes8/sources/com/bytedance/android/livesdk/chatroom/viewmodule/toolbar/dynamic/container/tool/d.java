package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.tool;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import bp1.j;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.livesdk.chatroom.utils.o1;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ErrorReason;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ToolbarReasonTag;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.ToolbarQuickLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.d0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.q;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.f3;
import com.bytedance.android.livesdk.config.fv0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import zo1.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements h {
    public final LinkedList<f> a;
    public final ot2.d b;
    public final DataCenter c;

    @Override // zo1.d
    public final void a() {
        Intrinsics.checkNotNullParameter("onRoomExit", "event");
    }

    @Override // zo1.h
    public final boolean c(int r1) {
        View r2 = l(r1);
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.getVisibility() != 0) goto L7;
        return true;
    }

    public final void e(String r4) {
        ALogger.i(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b.b(), "view " + r4);
    }

    @Override // zo1.h
    public final int g(int r5) {
        View r6 = l(r5);
        if (r6 == null) goto L17;
        ViewGroup r0 = this.b.getContainerView();
        if (r0 == null) goto L25;
        Sequence r1 = UtilityKotlinExtentionsKt.g(r0);
        if (r1 == null) goto L26;
        Iterator r2 = r1.iterator();
        int r3 = 0;
    L10:
        if (r2.hasNext() == false) goto L27;
        View r4 = (View) r2.next();
        if (Intrinsics.areEqual(r6, r4) == true) goto L13;
        if (r4.getVisibility() != 0) goto L10;
        r3 = r3 + 1;
        goto L10
    L13:
        return r3;
    L27:
        return -1;
    L26:
        return -1;
    L25:
        return -1;
    L17:
        return -1;
    }

    @Override // zo1.h
    public final void h(s r4) {
        Intrinsics.checkNotNullParameter(r4, "model");
        e(r4 + " view gone");
        View r0 = l(r4.a);
        if (r0 == null) goto L6;
        this.b.onChildViewChanged(false, r4.a, r0);
        UtilityKotlinExtentionsKt.t(r0);
        return;
    }

    @Override // zo1.h
    public final View k(s r10) {
        Intrinsics.checkNotNullParameter(r10, "model");
        int r0 = r10.a;
        View r1 = l(r0);
        if (r1 != null) goto L17;
        DataCenter r2 = this.c;
        if (r2 == null) goto L9;
        Boolean r3 = (Boolean) r2.get("data_is_anchor", Boolean.FALSE);
        if (r3 == null) goto L9;
        boolean r4 = r3.booleanValue();
    L10:
        ToolbarButton r5 = f3.b(r10, r4, false);
        if (r5 != null) goto L13;
        e(r10 + " get ToolbarButton null.");
    L13:
        r1 = this.b.createCustomView(r10.a, r5);
        if (r1 != null) goto L16;
        int r6 = d0.a;
        d0.a(String.valueOf(r10.a), this.c, r10.l.b, ErrorReason.TOOLBAR_ITEM_VIEW_IS_NULL.getValue(), null);
        r1 = null;
    L40:
        if (r1 != null) goto L43;
        HashMap<String, String> r7 = q.a;
        q.a(r10.a, ToolbarReasonTag.MUTEX_ERROR, "create view is null");
        e(r10 + " create view is null.");
        return null;
    L43:
        if (r1.getParent() != null) goto L50;
        int r8 = r10.a;
        int r9 = this.b.attachToContainer(r8, r1);
        if (r9 < 0) goto L47;
        this.b.onChildViewChanged(true, r8, r1);
    L47:
        e(r10 + " view attach to parent at " + r9);
        if (r9 >= 0) goto L51;
        HashMap<String, String> r11 = q.a;
        q.a(r10.a, ToolbarReasonTag.VIEW_CONTAINER, "view index error");
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a r12 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b;
        r12.g(r10.a, r12.e(), "ViewIndexError");
        int r13 = d0.a;
        d0.a(String.valueOf(r10.a), this.c, r10.l.b, ErrorReason.TOOLBAR_ITEM_VIEW_ATTACH_FAILED.getValue(), null);
    L51:
        e(r10 + " view showed.");
        m r14 = j.a(null, 3).e();
        if (r14 != null) goto L54;
    L58:
        r1.setVisibility(0);
        return r1;
    L54:
        if (((Boolean) r14.getValue()).booleanValue() != true) goto L58;
        if (r1.getVisibility() == 0) goto L58;
        o1 r15 = o1.d();
        DataCenter r16 = this.c;
        int r17 = r10.a;
        r15.getClass();
        o1.e(r16, "livesdk_toolbar_icon_show", r17, r9, r10);
        goto L58
    L50:
        r9 = -1;
        goto L51
    L16:
        this.a.add(new f(r0, r1));
        e("add " + r10 + " view");
    L19:
        if ((r1 instanceof ViewGroup) == false) goto L40;
        Intrinsics.checkNotNullParameter(r10, "toolbarButton");
        Boolean r18 = o3.j(this.c).isPortraitInteraction();
        if (r18 == null) goto L23;
        boolean r19 = r18.booleanValue();
    L25:
        if (fv0.a.getValue().getToolbarShowOpt() == false) goto L32;
        if (r19 == false) goto L32;
        if (a0.d(this.c, false) == true) goto L32;
        Set<Integer> r20 = ToolbarQuickLoader.a;
        Intrinsics.checkNotNullParameter(r10, "toolbarButton");
        if (ToolbarQuickLoader.a.contains(Integer.valueOf(r10.a)) == false) goto L32;
        boolean r21 = true;
    L33:
        if (r21 == false) goto L40;
        if (r10.m == false) goto L37;
        Set<Integer> r22 = ToolbarQuickLoader.a;
        ToolbarQuickLoader.a((ViewGroup) r1, r10);
        goto L40
    L37:
        ViewGroup r23 = (ViewGroup) r1;
        if ((r23.getChildAt(0) instanceof ImageView) == false) goto L40;
        r23.removeViewAt(0);
    L32:
        r21 = false;
        goto L33
    L23:
        r19 = true;
    L9:
        r4 = false;
        goto L10
    L17:
        e(r0 + " view exist");
        goto L19
    }

    @Override // zo1.h
    public final View l(int r5) {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((f) r1).a != r5) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        f r2 = (f) r1;
        if (r2 != null) goto L15;
        return null;
    L15:
        return r2.b;
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    public d(ot2.d r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "viewContainer");
        this.b = r2;
        this.c = r3;
        this.a = new LinkedList();
    }
}

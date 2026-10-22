package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new;

import ap1.a;
import bp1.j;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.k;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.f3;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ BottomToolbarViewModel a;
    public final /* synthetic */ ToolbarOperateManager b;

    public b(BottomToolbarViewModel r1, ToolbarOperateManager r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r13) {
        Long r14 = (Long) r13;
        BottomToolbarViewModel r15 = this.a;
        a r0 = r15.g;
        if (r0 == null) goto L5;
        r0.printStatsTime(r15.b());
    L5:
        k r16 = j.a(this.a.j, 2);
        if (r16 == null) goto L22;
        n r17 = r16.b();
        if (r17 == null) goto L22;
        List r18 = (List) r17.getValue();
        if (r18 == null) goto L22;
        ArrayList r3 = new ArrayList();
        Iterator<T> r19 = r18.iterator();
    L13:
        if (r19.hasNext() == false) goto L23;
        T r4 = r19.next();
        s r5 = (s) r4;
        if (r5.l.b == false) goto L17;
    L19:
        boolean r6 = false;
    L20:
        if (r6 == false) goto L13;
        r3.add(r4);
        goto L13
    L17:
        if (this.a.f.c(r5, "enter") == false) goto L19;
        r6 = true;
    L23:
        ArrayList<s> r110 = this.b.e;
        HashSet r7 = new HashSet();
        if (r3 == null) goto L42;
        Iterator<T> r8 = r3.iterator();
    L27:
        if (r8.hasNext() == false) goto L42;
        s r9 = (s) r8.next();
        ToolbarButton r10 = f3.b(r9, this.a.b(), false);
        Iterator<s> r11 = r110.iterator();
    L30:
        if (r11.hasNext() == false) goto L37;
        s r12 = r11.next();
        if (r12.a != r9.a) goto L34;
        boolean r111 = true;
    L35:
        if (r111 == false) goto L30;
    L38:
        s r20 = r12;
        if (r10 == null) goto L27;
        if (r20 != null) goto L27;
        r7.add(Integer.valueOf(r9.a));
        goto L27
    L34:
        r111 = false;
        goto L35
    L37:
        r12 = null;
    L42:
        HashSet r1 = new HashSet();
        Iterator<s> r112 = r110.iterator();
    L44:
        if (r112.hasNext() == false) goto L48;
        s r2 = r112.next();
        if (this.a.isComponentShowing(r2.a) == true) goto L44;
        r1.add(Integer.valueOf(r2.a));
        goto L44
    L48:
        o r113 = j.b(this.a.j);
        if (r113 == null) goto L55;
        m r114 = r113.isCleanMode();
        if (r114 == null) goto L55;
        if (((Boolean) r114.getValue()).booleanValue() != true) goto L55;
        r1.clear();
        ALogger.i(a.b.getTAG(), "check when is in clear mode");
    L55:
        a.b.h(r3, r7, r1, this.a.b());
        return;
    L22:
        r3 = null;
        goto L23
    }
}

package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import android.util.SparseArray;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.o6;
import com.bytedance.android.livesdk.y7;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarComponentCheckInterface;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class z implements n {
    public final HashSet<Integer> b;
    public final SparseArray<ToolbarComponentCheckInterface> c;
    public final HashMap<a, Runnable> d;
    public final String e;

    public static final class a {
        public final int a;
        public final int b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L10;
            a r4 = (a) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b;
        }

        public final String toString() {
            return "ToolbarComponentKey(id=" + this.a + ", groupId=" + this.b + ")";
        }

        public a(int r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ z a;
        public final /* synthetic */ s b;
        public final /* synthetic */ Function0 c;
        public final /* synthetic */ Function1 d;

        public b(z r1, s r2, Function0 r3, Function1 r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.e(this.b, this.c, this.d);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ z a;
        public final /* synthetic */ s b;
        public final /* synthetic */ Function0 c;
        public final /* synthetic */ Function1 d;

        public c(z r1, s r2, Function0 r3, Function1 r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.e(this.b, this.c, this.d);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.n
    public final void a() {
        ALogger.i(this.e, "CheckManager clear check list");
        this.c.clear();
        this.d.clear();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.n
    public final void clear() {
        ALogger.i(this.e, "CheckManager clear");
        this.c.clear();
        this.b.clear();
    }

    public z() {
        this.b = new HashSet();
        this.c = new SparseArray();
        this.d = new HashMap();
        this.e = "NewToolbarLogV2";
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.n
    public final boolean c(int r6) {
        Iterator<T> r0 = this.d.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((a) r1).a != r6) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L4;
    L12:
        if (r1 != null) goto L21;
        return false;
    L21:
        return true;
    L8:
        r4 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.n
    public final void d(NewToolbarButtonConstants r3) {
        Intrinsics.checkNotNullParameter(r3, "toolbarButton");
        Map.Entry<a, Runnable> r0 = g(r3.getId());
        if (r0 == null) goto L5;
        Runnable r1 = this.d.remove(r0.getKey());
    L5:
        this.c.remove(r3.getId());
    }

    public final Map.Entry<a, Runnable> g(int r4) {
        Iterator<Map.Entry<a, Runnable>> r0 = this.d.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Map.Entry<a, Runnable> r1 = r0.next();
        if (r1.getKey().a != r4) goto L4;
        return r1;
    L8:
        return null;
    }

    public final void h(NewToolbarButtonConstants r2) {
        Intrinsics.checkNotNullParameter(r2, "model");
        this.b.add(Integer.valueOf(r2.getId()));
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.n
    public final void b(NewToolbarButtonConstants r4, ToolbarComponentCheckInterface r5) {
        Intrinsics.checkNotNullParameter(r4, "toolbarButton");
        Intrinsics.checkNotNullParameter(r5, "service");
        ALogger.i(this.e, "register filter - " + r4);
        this.c.put(r4.getId(), r5);
        Map.Entry<a, Runnable> r6 = g(r4.getId());
        if (r6 == null) goto L8;
        Runnable r7 = this.d.remove(r6.getKey());
        if (r7 == null) goto L9;
        r7.run();
        return;
    L9:
        return;
    }

    public final void e(s r3, Function0<Unit> r4, Function1<? super String, Unit> r5) {
        ToolbarComponentCheckInterface r0 = this.c.get(r3.a);
        if (r0 == null) goto L5;
        Boolean r6 = Boolean.valueOf(r0.checkThenLoad(r3, r4, r5));
    L6:
        Boolean r1 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r6, r1)) == false) goto L10;
        r4.invoke();
    L10:
        if (Intrinsics.areEqual(r6, r1) == false) goto L13;
        ALogger.i(this.e, "component handle! - " + r3);
        return;
    L13:
        if (Intrinsics.areEqual(r6, Boolean.FALSE) == false) goto L15;
        ALogger.i(this.e, "component don't handle! - " + r3);
        return;
    L15:
        if (r6 != null) goto L20;
        ALogger.i(this.e, "no component filter - " + r3);
        return;
    L20:
        return;
    L5:
        r6 = null;
        goto L6
    }

    public final void f(String r5, s r6, Function0<Unit> r7, Function1<? super String, Unit> r8) {
        Intrinsics.checkNotNullParameter(r5, "actionName");
        Intrinsics.checkNotNullParameter(r6, "model");
        Intrinsics.checkNotNullParameter(r7, "loadButton");
        Intrinsics.checkNotNullParameter(r8, "stopLoadCallback");
        if (((Boolean) y7.a.getValue()).booleanValue() == false) goto L11;
        int r0 = r6.f;
        Iterator<T> r1 = this.d.keySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L11;
        a r2 = (a) r1.next();
        if (r0 != r2.b) goto L6;
        this.d.remove(r2);
    L11:
        if (this.b.contains(Integer.valueOf(r6.a)) == true) goto L13;
    L15:
        boolean r3 = false;
    L16:
        if (r3 == false) goto L32;
        Iterator<T> r4 = this.d.keySet().iterator();
    L19:
        if (r4.hasNext() == false) goto L24;
        if (((a) r4.next()).b != r6.f) goto L19;
        ALogger.e(this.e, "delayListNew same groupId is error");
        goto L19
    L24:
        if (Intrinsics.areEqual(r5, "refresh") == true) goto L26;
    L31:
        this.d.put(new a(r6.a, r6.f), new c(this, r6, r7, r8));
        ALogger.i(this.e, "put " + r6 + " to delay list");
        return;
    L26:
        if (((Boolean) o6.a.getValue()).booleanValue() == false) goto L31;
        a r9 = new a(r6.a, r6.f);
        if (this.d.containsKey(r9) == false) goto L30;
        ALogger.i(this.e, "refresh but no register, model: " + r6);
        return;
    L30:
        ALogger.i(this.e, "refresh, put " + r6 + " to delay list");
        this.d.put(r9, new b(this, r6, r7, r8));
        return;
    L32:
        e(r6, r7, r8);
        return;
    L13:
        if (this.c.get(r6.a) != null) goto L15;
        r3 = true;
        goto L16
    }
}

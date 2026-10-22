package com.bytedance.android.livesdk.downloader;

import com.bytedance.android.live.revenue.common.h;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.exception.BaseGetResourceException;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.f;
import com.bytedance.revenue.platform.api.core.rx.l;
import com.bytedance.revenue.platform.api.core.rx.p;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class NewGiftResourceManager implements e, com.bytedance.kmp.livesdk.gift.platform.resourcemanager.a<String> {
    public static NewGiftResourceManager m;
    public final Map<Long, f> a;
    public final com.bytedance.kmp.livesdk.gift.platform.resourcemanager.d b;
    public final List<com.bytedance.kmp.livesdk.gift.platform.resourcemanager.b> c;
    public final ArrayDeque<com.bytedance.android.livesdk.gift.platform.business.effect.assets.e> d;
    public int e;
    public int f;
    public int g;
    public final Lazy h;
    public final Lazy i;
    public int j;
    public boolean k;
    public final ed6.a<com.bytedance.android.livesdk.gift.platform.business.effect.assets.e> l;

    public static final class a {
    }

    public static final class b implements Comparator<com.bytedance.android.livesdk.gift.platform.business.effect.assets.e> {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r8, com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r9) {
            com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r10 = r8;
            com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r11 = r9;
            if (r10 == null) goto L17;
            if (r11 == null) goto L17;
            long r0 = r11.d - r10.d;
            if (r0 <= 0) goto L10;
            return 1;
        L10:
            if (r0 >= 0) goto L12;
        L11:
            return -1;
        L12:
            long r5 = r11.e - r10.e;
            if (r5 > 0) goto L11;
            if (r5 >= 0) goto L17;
            return 1;
        L17:
            return 0;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ NewGiftResourceManager a;
        public final /* synthetic */ com.bytedance.android.livesdk.gift.platform.business.effect.assets.e b;

        public c(NewGiftResourceManager r1, com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r9) {
            Unit r10 = (Unit) r9;
            NewGiftResourceManager r11 = this.a;
            com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r0 = this.b;
            r11.getClass();
            Intrinsics.checkNotNullParameter(r0, "request");
            long r1 = r0.i;
            String r3 = r11.o(r0);
            f r4 = r11.a.get(Long.valueOf(r1));
            if (r4 == null) goto L8;
            Iterator r5 = r4.b().iterator();
        L6:
            if (r5.hasNext() == false) goto L8;
            ((com.bytedance.kmp.livesdk.gift.platform.resourcemanager.c) r5.next()).c(r0.i, r3);
        L8:
            r11.a.remove(Long.valueOf(r1));
            Iterator r12 = ((ArrayList) r11.c).iterator();
        L10:
            if (r12.hasNext() == false) goto L12;
            ((com.bytedance.kmp.livesdk.gift.platform.resourcemanager.b) r12.next()).c(r0.i, r0);
            goto L10
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ Function0 a;

        public d(Function0 r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            this.a.invoke();
        }
    }

    static {
    }

    public final void j() {
        this.k = false;
    }

    public final void k() {
        this.k = true;
    }

    public final com.bytedance.kmp.livesdk.gift.platform.resourcemanager.cache.a a() {
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.d r0 = this.b;
        Intrinsics.checkNotNull(r0);
        return r0.a;
    }

    public final void clear() {
        this.a.clear();
    }

    public final void p() {
    L3:
        if (this.l.a.peek() == null) goto L15;
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r0 = (com.bytedance.android.livesdk.gift.platform.business.effect.assets.e) this.l.a.poll();
        if (r0 == null) goto L3;
        f r1 = this.a.get(Long.valueOf(r0.i));
        if (r1 == null) goto L3;
        Iterator r2 = r1.b().iterator();
    L12:
        if (r2.hasNext() == false) goto L14;
        ((com.bytedance.kmp.livesdk.gift.platform.resourcemanager.c) r2.next()).a(r0.i);
        goto L12
    L14:
        this.a.remove(Long.valueOf(r0.i));
        goto L3
    }

    public final void q() {
        if (this.l.a.isEmpty() == false) goto L5;
        return;
    L5:
        int r0 = this.g;
        if (r0 >= 1) goto L13;
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.d r1 = this.b;
        Intrinsics.checkNotNull(r1);
        r0 = r1.e;
        if (r0 > 0) goto L13;
        r0 = 3;
    L13:
        if (this.e >= r0) goto L15;
    L28:
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.d r2 = this.b;
        Intrinsics.checkNotNull(r2);
        if (r2.f <= 0) goto L34;
        int r3 = this.f;
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.d r4 = this.b;
        Intrinsics.checkNotNull(r4);
        if (r3 < r4.f) goto L34;
        p();
        this.f = 0;
        return;
    L34:
        int r5 = this.j;
        if (r5 > 0) goto L37;
    L39:
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r6 = (com.bytedance.android.livesdk.gift.platform.business.effect.assets.e) this.l.a.poll();
        if (r6 != null) goto L46;
        if (this.l.a.isEmpty() == true) goto L57;
        q();
        return;
    L57:
        return;
    L46:
        if (this.k == true) goto L48;
    L51:
        com.bytedance.live.kmp.util.c r7 = com.bytedance.live.kmp.util.c.a;
        r6.f = System.currentTimeMillis();
        if (e(r6) == false) goto L54;
        l r8 = l.a;
        Observable r9 = Observable.just(Unit.INSTANCE);
        int r10 = p.a;
        r9.observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this, r6));
        q();
        return;
    L54:
        this.e++;
        n(r6);
        return;
    L48:
        if (r6.d != 1) goto L51;
        s(new NewGiftResourceManager$onCancel$1(this, r6), null);
        q();
        return;
    L37:
        if (this.e < r5) goto L39;
        return;
    L15:
        if (this.j <= 0) goto L27;
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r11 = (com.bytedance.android.livesdk.gift.platform.business.effect.assets.e) this.l.a.peek();
        if (r11 != null) goto L19;
    L25:
        boolean r12 = false;
    L26:
        if (r12 == true) goto L28;
        return;
    L19:
        if (r11.a != true) goto L25;
        int r13 = this.j;
        if (r13 <= 0) goto L25;
        if (this.e >= (r0 + r13)) goto L25;
        r12 = true;
        goto L26
    }

    public final void r() {
        this.d.iterator();
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.d r0 = this.b;
        Intrinsics.checkNotNull(r0);
        if (r0.g == false) goto L7;
        p();
        return;
    L7:
        if (this.d.firstOrNull() == null) goto L19;
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r1 = (com.bytedance.android.livesdk.gift.platform.business.effect.assets.e) this.d.removeFirstOrNull();
        if (r1 == null) goto L7;
        f r2 = this.a.get(Long.valueOf(r1.i));
        if (r2 == null) goto L7;
        Iterator r3 = r2.b().iterator();
    L16:
        if (r3.hasNext() == false) goto L18;
        ((com.bytedance.kmp.livesdk.gift.platform.resourcemanager.c) r3.next()).a(r1.i);
        goto L16
    L18:
        this.a.remove(Long.valueOf(r1.i));
        goto L7
    }

    public final void t() {
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.d r0 = this.b;
        Intrinsics.checkNotNull(r0);
        if (r0.g == false) goto L6;
        q();
        return;
    L6:
        int r1 = this.e;
        int r2 = this.g;
        if (r2 >= 1) goto L13;
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.d r3 = this.b;
        Intrinsics.checkNotNull(r3);
        r2 = r3.e;
        if (r2 > 0) goto L13;
        r2 = 3;
    L13:
        if (r1 < r2) goto L15;
        return;
    L15:
        if (this.d.isEmpty() == true) goto L47;
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.d r4 = this.b;
        Intrinsics.checkNotNull(r4);
        if (r4.f <= 0) goto L23;
        int r5 = this.f;
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.d r6 = this.b;
        Intrinsics.checkNotNull(r6);
        if (r5 < r6.f) goto L23;
        r();
        this.f = 0;
        return;
    L23:
        int r7 = this.j;
        if (r7 > 0) goto L26;
    L28:
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r8 = (com.bytedance.android.livesdk.gift.platform.business.effect.assets.e) this.d.removeFirstOrNull();
        if (r8 != null) goto L35;
        if (this.d.isEmpty() == true) goto L35;
        t();
        return;
    L35:
        if (this.k == false) goto L40;
        Intrinsics.checkNotNull(r8);
        if (r8.a == true) goto L40;
        s(new NewGiftResourceManager$onCancel$1(this, r8), null);
        t();
        return;
    L40:
        Intrinsics.checkNotNull(r8);
        com.bytedance.live.kmp.util.c r9 = com.bytedance.live.kmp.util.c.a;
        r8.f = System.currentTimeMillis();
        if (e(r8) == false) goto L43;
        t();
        return;
    L43:
        this.e++;
        n(r8);
        return;
    L26:
        if (this.e < r7) goto L28;
        return;
    }

    public final void f() {
        clear();
        r();
    }

    public NewGiftResourceManager(com.bytedance.kmp.livesdk.gift.platform.resourcemanager.d r3) {
        this.a = new LinkedHashMap();
        this.c = new ArrayList();
        this.d = new ArrayDeque();
        this.h = LazyKt.lazy(NewGiftResourceManager$downloaderManagerTypeOpt$2.INSTANCE);
        this.i = LazyKt.lazy(NewGiftResourceManager$resManagerAnrOpt$2.INSTANCE);
        this.l = new ed6.a(new b());
        this.b = r3;
        Intrinsics.checkNotNull(r3);
        if (r3.g == false) goto L6;
        this.a = new ConcurrentHashMap();
        return;
    }

    public final void d(int r1) {
        this.g = r1;
    }

    public final boolean e(com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (r4.a() != 1) goto L9;
        return true;
    L9:
        if (r4.a() != 2) goto L11;
        return false;
    L11:
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.d r0 = this.b;
        Intrinsics.checkNotNull(r0);
        String r5 = uy0.a.a(r0.a.b(r4));
        return com.bytedance.android.live.revenue.core.util.f.a(uy0.b.class).Y4(r5 + ".fetched");
    }

    public final void g(com.bytedance.kmp.livesdk.gift.platform.resourcemanager.b r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (((ArrayList) this.c).contains(r2) == true) goto L8;
        ((ArrayList) this.c).add(r2);
        return;
    }

    public final void i(int r1) {
        this.j = r1;
    }

    public final void n(com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r4) {
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.d r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        fd6.b r1 = null;
        if (r0 == null) goto L10;
        fd6.a r2 = r0.b;
        if (r2 == null) goto L10;
        Intrinsics.checkNotNull(r0);
        fd6.b r3 = r2.a(r4, r0);
    L12:
        if ((r3 instanceof fd6.b) == false) goto L15;
        r1 = r3;
    L15:
        if (r1 != null) goto L17;
        return;
    L17:
        r4.g = true;
        r1.a(r4, this);
        return;
    L10:
        r3 = null;
        goto L12
    }

    public final String o(com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r4) {
        Intrinsics.checkNotNullParameter(r4, "request");
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.d r0 = this.b;
        Intrinsics.checkNotNull(r0);
        String r1 = uy0.a.a(r0.a.b(r4));
        if (r4.m == true) goto L11;
        StringBuilder r2 = new StringBuilder();     // Catch: Exception -> L6
        r2.append(r1);     // Catch: Exception -> L6
        int r3 = h.a;     // Catch: Exception -> L6
        r2.append(h.a(r4.j[0]));     // Catch: Exception -> L6
        return r2.toString();
    L6:
        e = move-exception;
        e.printStackTrace();
        return r1;
    L11:
        return r1;
    }

    public static final void m(final NewGiftResourceManager r3, final com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r4) {
        r3.getClass();
        Function0<Unit> r0 = new NewGiftResourceManager$retryFetchResource$1(r3, r4);
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.d r5 = r3.b;
        Intrinsics.checkNotNull(r5);
        r3.s(r0, Long.valueOf(r5.d * BubbleId.PadCast));
    }

    public final void b(final com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r3, Object r4) {
        Intrinsics.checkNotNullParameter(r3, "request");
        Intrinsics.checkNotNullParameter((String) r4, "s");
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.d r5 = this.b;
        Intrinsics.checkNotNull(r5);
        String r6 = uy0.a.a(r5.a.b(r3));
        com.bytedance.android.live.revenue.core.util.f.a(uy0.b.class).L(r6 + ".fetched");
        s(new NewGiftResourceManager$onResult$1(this, r3), null);
    }

    public final void c(com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r8, com.bytedance.kmp.livesdk.gift.platform.resourcemanager.c r9) {
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.d r0 = this.b;
        Intrinsics.checkNotNull(r0);
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r1 = null;
        if (r0.g == false) goto L28;
        if (this.k == false) goto L10;
        if (r8.d != 1) goto L10;
        r9.a(r8.i);
        return;
    L10:
        if (e(r8) == false) goto L12;
        r9.c(r8.i, o(r8));
        return;
    L12:
        long r3 = r8.i;
        if (this.a.containsKey(Long.valueOf(r3)) == false) goto L25;
        f r2 = this.a.get(Long.valueOf(r3));
        if (r2 == null) goto L17;
        r1 = r2.b;
    L17:
        if (r1 != null) goto L19;
        return;
    L19:
        if (r1.d >= r8.d) goto L24;
        r8.c();
        this.l.a.remove(r1);
        this.l.a.add(r8);
        f r4 = new f(r8);
        Intrinsics.checkNotNull(r2);
        List r10 = r2.b();
        Intrinsics.checkNotNullParameter(r10, "list");
        List r11 = r10;
        if ((!r11.isEmpty()) == false) goto L23;
        ((CopyOnWriteArrayList) r4.a).addAll(r11);
    L23:
        r4.a(r9);
        this.a.remove(Long.valueOf(r3));
        this.a.put(Long.valueOf(r3), r4);
        return;
    L24:
        r1.c();
        Intrinsics.checkNotNull(r2);
        r2.a(r9);
        return;
    L25:
        f r5 = new f(r8);
        r5.a(r9);
        this.a.put(Long.valueOf(r3), r5);
        r8.c();
        this.l.a.add(r8);
        q();
        return;
    L28:
        if (this.k == false) goto L34;
        if (r8.a == true) goto L34;
        r9.a(r8.i);
        return;
    L34:
        if (e(r8) == false) goto L37;
        r9.c(r8.i, o(r8));
        return;
    L37:
        long r6 = r8.i;
        if (this.k == false) goto L49;
        if (this.a.containsKey(Long.valueOf(r6)) == false) goto L49;
        if (r8.a == false) goto L49;
        f r7 = this.a.get(Long.valueOf(r6));
        Intrinsics.checkNotNull(r7);
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r12 = r7.b;
        if (r12 == null) goto L49;
        if (r12.a == true) goto L49;
        this.a.remove(Long.valueOf(r6));
    L49:
        if (this.a.containsKey(Long.valueOf(r6)) == true) goto L51;
        f r13 = new f(r8);
        r13.a(r9);
        this.a.put(Long.valueOf(r6), r13);
        r8.c();
        if (r8.a == false) goto L66;
        this.d.addFirst(r8);
    L67:
        t();
        return;
    L66:
        this.d.add(r8);
        goto L67
    L51:
        if (r8.a == false) goto L60;
        f r14 = this.a.get(Long.valueOf(r6));
        if (r14 == null) goto L55;
        r1 = r14.b;
    L55:
        if (r1 != null) goto L57;
    L59:
        r8.c();
        this.d.addFirst(r8);
        goto L60
    L57:
        if (this.d.contains(r1) == false) goto L59;
        this.d.remove(r1);
    L60:
        f r15 = this.a.get(Long.valueOf(r6));
        if (r15 == null) goto L74;
        r15.a(r9);
        return;
    }

    public final String h(com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r4, boolean r5) {
        if (e(r4) == true) goto L5;
        if (r5 == false) goto L12;
        long r0 = r4.i;
        if (this.a.containsKey(Long.valueOf(r0)) == true) goto L13;
        f r6 = new f(r4);
        this.a.put(Long.valueOf(r0), r6);
        r4.c();
        n(r4);
        return null;
    L13:
        return null;
    L12:
        return null;
    L5:
        return o(r4);
    }

    public final void l(final com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r3, final BaseGetResourceException r4) {
        Intrinsics.checkNotNullParameter(r3, "request");
        Intrinsics.checkNotNullParameter(r4, "e");
        if (e(r3) == true) goto L5;
        s(new NewGiftResourceManager$onFailure$2(this, r3, r4), null);
        return;
    L5:
        if (((Boolean) this.i.getValue()).booleanValue() == false) goto L8;
        s(new NewGiftResourceManager$onFailure$1(this), null);
        return;
    L8:
        this.e--;
        t();
    }

    public final void s(Function0<Unit> r6, Long r7) {
        if (r7 != null) goto L4;
    L6:
        l r8 = l.a;
        Observable r9 = Observable.just(Unit.INSTANCE);
    L7:
        int r0 = p.a;
        r9.observeOn(AndroidSchedulers.mainThread()).subscribe(new d(r6));
        return;
    L4:
        if (r7.longValue() <= 0) goto L6;
        l r1 = l.a;
        long r2 = r7.longValue();
        int r10 = p.a;
        Scheduler r11 = Schedulers.computation();
        r9 = Observable.timer(r2, TimeUnit.MILLISECONDS, r11);
        goto L7
    }
}

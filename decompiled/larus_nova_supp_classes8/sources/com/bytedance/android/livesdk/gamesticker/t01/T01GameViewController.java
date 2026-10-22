package com.bytedance.android.livesdk.gamesticker.t01;

import com.bytedance.android.livesdk.chatroom.model.p3;
import com.bytedance.android.livesdk.chatroom.model.q3;
import com.bytedance.android.livesdk.chatroom.model.r3;
import com.bytedance.android.livesdk.chatroom.model.t0;
import com.bytedance.android.livesdk.chatroom.model.t3;
import com.bytedance.android.livesdk.gamesticker.t01.anim.h;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class T01GameViewController {
    public t3 a;
    public List<r3> b;
    public int c;
    public Disposable d;
    public p3 e;
    public int f;
    public Disposable g;
    public int h;
    public int i;
    public boolean j;
    public final T01GameStickerView k;

    public static final class a {
        public long a;
        public final long b;
        public final Function0<Unit> c;

        public a(long r2, Function0<Unit> r4) {
            Intrinsics.checkNotNullParameter(r4, "action");
            this.b = r2;
            this.c = r4;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ T01GameViewController a;

        public b(T01GameViewController r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            this.a.getClass();
            this.a.k.h(true);
        }
    }

    public final void a() {
        p3 r0 = this.e;
        if (r0 == null) goto L5;
        int r1 = r0.b();
    L7:
        if (r1 <= 0) goto L12;
        this.f = 8;
        Disposable r2 = Observable.timer(r1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this));
        if (r2 == null) goto L13;
        this.g = r2;
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r1 = 0;
        goto L7
    }

    public T01GameViewController(T01GameStickerView r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.k = r2;
        this.c = -1;
        this.h = -1;
        this.i = -1;
    }

    public final void b(t0 r23) {
        Intrinsics.checkNotNullParameter(r23, "info");
        q3 r1 = r23.a();
        if (r1 == null) goto L116;
        int r2 = r1.b();
        q3 r3 = r23.a();
        if (r3 == null) goto L7;
        t3 r4 = r3.d();
    L9:
        if (r4 == null) goto L19;
        String r7 = r4.b();
        if (r7 != null) goto L14;
    L17:
        boolean r8 = true;
    L18:
        if (r8 == true) goto L19;
    L20:
        if (r4 != null) goto L22;
        return;
    L22:
        q3 r9 = r23.a();
        if (r9 == null) goto L25;
        List r10 = r9.c();
    L26:
        if (r10 != null) goto L28;
        List<r3> r11 = null;
    L29:
        if (r11 != null) goto L31;
        return;
    L31:
        int r12 = r11.size();
        List<r3> r13 = this.b;
        if (r13 != null) goto L34;
    L37:
        boolean r14 = true;
    L38:
        this.a = r4;
        this.b = r11;
        int r15 = this.c;
        if (r15 == (-1)) goto L44;
        if (r15 != r2) goto L44;
        if (r14 == true) goto L44;
        this.c = r2;
        T01GameStickerView r5 = this.k;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r4, "roleInfo");
        Intrinsics.checkNotNullParameter(r11, "liveInfos");
        r5.j.a(new h(r4, r11));
        r5.g();
    L76:
        q3 r6 = r23.a();
        if (r6 == null) goto L88;
        List r16 = r6.a();
        if (r16 == null) goto L88;
        Iterator r17 = r16.iterator();
    L82:
        if (r17.hasNext() == false) goto L86;
        Object r18 = r17.next();
        if (Intrinsics.areEqual(((p3) r18).c(), "portrait") == false) goto L82;
    L87:
        p3 r19 = (p3) r18;
    L89:
        this.e = r19;
        if (r19 == null) goto L92;
        int r20 = r19.a();
    L93:
        int r21 = this.h;
        if (r21 == (-1)) goto L102;
        if (r21 == r20) goto L102;
        if (this.i != 0) goto L102;
        Disposable r22 = this.g;
        if (r22 == null) goto L101;
        r22.dispose();
    L101:
        this.g = null;
        this.k.k(true);
        a();
    L102:
        this.h = r20;
        return;
    L92:
        r20 = -1;
        goto L93
    L86:
        r18 = null;
    L88:
        r19 = null;
    L44:
        this.c = r2;
        Disposable r24 = this.d;
        if (r24 == null) goto L47;
        r24.dispose();
    L47:
        List<a> r25 = c(r11);
        if (((ArrayList) r25).size() != 1) goto L50;
        ((a) ListProtector.get(r25, 0)).c.invoke();
        goto L76
    L50:
        List<a> r26 = c(r11);
        ArrayList r27 = (ArrayList) r26;
        Iterator r28 = r27.iterator();
        long r110 = 0;
    L52:
        if (r28.hasNext() == false) goto L54;
        r110 = r110 + ((a) r28.next()).b;
        goto L52
    L54:
        long r111 = 1 + r110;
        ArrayList r29 = new ArrayList();
        int r112 = r27.size();
        int r113 = 0;
    L55:
        if (r113 >= r112) goto L60;
        if (r113 != 0) goto L58;
        ListProtector.add(r29, r113, 0L);
    L59:
        ((a) ListProtector.get(r26, r113)).a = ((Number) ListProtector.get(r29, r113)).longValue();
        Long r30 = (Long) ListProtector.get(r29, r113);
        r113 = r113 + 1;
        r112 = r112;
        goto L55
    L58:
        int r31 = r113 - 1;
        ListProtector.add(r29, r113, Long.valueOf(((a) ListProtector.get(r26, r31)).b + ((Number) ListProtector.get(r29, r31)).longValue()));
        goto L59
    L60:
        this.j = true;
        Iterator r32 = r27.iterator();
    L62:
        if (r32.hasNext() == false) goto L69;
        Object r33 = r32.next();
        if (((a) r33).a != 0) goto L66;
        boolean r34 = true;
    L67:
        if (r34 == false) goto L62;
    L70:
        a r35 = (a) r33;
        if (r35 == null) goto L75;
        Function0<Unit> r36 = r35.c;
        if (r36 == null) goto L75;
        Unit r37 = (Unit) r36.invoke();
    L75:
        this.d = Observable.intervalRange(0, r111, 0, 1, TimeUnit.SECONDS).repeat().filter(new com.bytedance.android.livesdk.gamesticker.t01.b(r29)).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this, r26));
        goto L76
    L66:
        r34 = false;
        goto L67
    L69:
        r33 = null;
        goto L70
    L34:
        if (r12 != r13.size()) goto L37;
        r14 = false;
        goto L38
    L28:
        r11 = CollectionsKt.sortedWith(r10, new com.bytedance.android.livesdk.gamesticker.t01.a());
        goto L29
    L25:
        r10 = null;
        goto L26
    L14:
        if (r7.length() == 0) goto L17;
        r8 = false;
    L19:
        r4 = null;
        goto L20
    L7:
        r4 = null;
        goto L9
    }

    public final List<a> c(List<r3> r8) {
        ArrayList r0 = new ArrayList();
        int r1 = r8.size();
        final int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        Long r4 = ((r3) ListProtector.get(r8, r2)).b();
        if (r4 == null) goto L7;
        long r5 = r4.longValue();
    L8:
        r0.add(new a(r5, new T01GameViewController$transformInfoToTask$1(this, r2)));
        r2 = r2 + 1;
        goto L3
    L7:
        r5 = 10;
        goto L8
    L9:
        return r0;
    }
}

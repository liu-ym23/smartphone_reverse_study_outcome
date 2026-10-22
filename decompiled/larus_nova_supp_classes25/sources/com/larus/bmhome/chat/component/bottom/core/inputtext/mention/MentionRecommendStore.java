package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import android.os.SystemClock;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import hq9.v2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class MentionRecommendStore {
    public static final MentionRecommendStore a = null;
    public static final Gson b = null;
    public static final Lazy c = null;
    public static final CoroutineScope d = null;
    public static final Object e = null;
    public static a f;
    public static c g;
    public static b h;
    public static long i;

    public static final class a {
        public final String a;
        public final f0 b;

        public a(String r2, f0 r3) {
            Intrinsics.checkNotNullParameter(r2, "userId");
            Intrinsics.checkNotNullParameter(r3, "data");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b {
        public final String a;
        public final v2 b;
        public final boolean c;
        public final boolean d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            v2 r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = (r0 + r2) * 31;
            int r4 = 1231;
            if (this.c == false) goto L9;
            int r5 = 1231;
        L10:
            int r6 = (r3 + r5) * 31;
            if (this.d == true) goto L15;
            r4 = 1237;
        L15:
            return r6 + r4;
        L9:
            r5 = 1237;
            goto L10
        L5:
            r2 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "RequestKey(userId=" + this.a + ", session=" + this.b + ", includeContacts=" + this.c + ", includeGroups=" + this.d + ')';
        }

        public b(String r2, v2 r3, boolean r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r2, "userId");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class c {
        public final b a;
        public final Deferred<f0> b;

        public c(b r2, Deferred<f0> r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, "deferred");
            this.a = r2;
            this.b = r3;
        }
    }

    public MentionRecommendStore() {
    }

    static {
        a = new MentionRecommendStore();
        b = new Gson();
        c = LazyKt.lazy(new a1());
        d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        e = new Object();
    }

    public static f0 c(String r3) {
        String r4 = ((Keva) c.getValue()).getString(r3, null);
        if (r4 != null) goto L17;
        return null;
    L17:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        Object r5 = Result.constructor-impl((z0) b.fromJson(r4, z0.class));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r5) == false) goto L12;
        r5 = null;
    L12:
        z0 r6 = (z0) r5;
        if (r6 != null) goto L15;
        return null;
    L15:
        f0 r7 = r6.a();
        FLogger.a.i("MentionRecommendStore", "[readDisk] contacts=" + r7.b.size() + ", drives=" + r7.a.size() + ", conversations=" + r7.d.size());
        return r7;
    L7:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public static b e(qp8.e r6, boolean r7) {
        String r1 = AccountService.a.getUserId();
        LarkSocialExp.a.getClass();
        v2 r2 = LarkSocialExp.a();
        boolean r3 = false;
        if (r7 == true) goto L5;
    L9:
        boolean r8 = false;
    L10:
        if (r7 == false) goto L15;
        if (LarkSocialExp.f() == false) goto L15;
        r3 = true;
    L15:
        return new b(r1, r2, r8, r3);
    L5:
        if (LarkSocialExp.e() == false) goto L9;
        if ((!StringsKt.isBlank((CharSequence) r6.d.invoke())) == false) goto L9;
        r8 = true;
        goto L10
    }

    public static c f(qp8.e r12, boolean r13) {
        b r14 = e(r12, r13);
        final c r2 = null;
        if (StringsKt.isBlank(r14.a) == false) goto L5;
        return null;
    L5:
        long r3 = SystemClock.elapsedRealtime();
        Object r1 = e;
        monitor-enter(r1);
        c r5 = g;     // Catch: Throwable -> L36
        if (r5 != null) goto L10;
    L20:
        final MentionRecommendStore r6 = a;     // Catch: Throwable -> L36
        if (Intrinsics.areEqual(h, r14) == false) goto L27;
        long r7 = i;     // Catch: Throwable -> L36
        if (r7 <= 0) goto L27;
        if ((r3 - r7) >= 3000) goto L27;
        FLogger.a.d("MentionRecommendStore", "[startOrJoin] drop throttled request, interval=" + (r3 - i));     // Catch: Throwable -> L36
    L33:
        r5 = r2;
    L34:
        monitor-exit(r1);
        return r5;
    L27:
        c r0 = g;     // Catch: Throwable -> L36
        if (r0 == null) goto L32;
        Deferred<f0> r4 = r0.b;     // Catch: Throwable -> L36
        if (r4 == null) goto L32;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);     // Catch: Throwable -> L36
    L32:
        h = r14;     // Catch: Throwable -> L36
        i = r3;     // Catch: Throwable -> L36
        Deferred r15 = BuildersKt.async$default(d, null, null, new MentionRecommendStore$startOrJoin$1$3$deferred$1(r6, r12, r14, null), 3, null);     // Catch: Throwable -> L36
        r2 = new c(r14, r15);     // Catch: Throwable -> L36
        g = r2;     // Catch: Throwable -> L36
        r15.invokeOnCompletion(new b1(r2, r6));     // Catch: Throwable -> L36
        goto L33
    L10:
        if (Intrinsics.areEqual(r5.a, r14) == true) goto L12;
    L14:
        boolean r8 = false;
    L15:
        if (r8 == true) goto L18;
        r5 = null;
    L18:
        if (r5 == null) goto L20;
        FLogger.a.d("MentionRecommendStore", "[startOrJoin] join running request");     // Catch: Throwable -> L36
        goto L34
    L12:
        if (r5.b.isActive() == false) goto L14;
        r8 = true;
    L36:
        th = move-exception;
        throw th;
    }

    public static void g(String r9, f0 r10) {
        Keva r0 = (Keva) c.getValue();
        Gson r1 = b;
        int r2 = z0.a;
        Intrinsics.checkNotNullParameter(r10, "data");
        List<com.larus.bmhome.chat.component.bottom.core.inputtext.mention.c> r3 = r10.b;
        ArrayList r4 = new ArrayList();
        Iterator<T> r5 = r3.iterator();
    L3:
        com.larus.bmhome.chat.component.bottom.core.inputtext.mention.a r6 = null;
        if (r5.hasNext() == false) goto L10;
        com.larus.bmhome.chat.component.bottom.core.inputtext.mention.c r7 = (com.larus.bmhome.chat.component.bottom.core.inputtext.mention.c) r5.next();
        if (r7 == null) goto L8;
        int r8 = com.larus.bmhome.chat.component.bottom.core.inputtext.mention.a.a;
        qp8.c r11 = r7.a;
        Intrinsics.checkNotNullParameter(r11, "contact");
        r6 = new com.larus.bmhome.chat.component.bottom.core.inputtext.mention.a(r11.a, r11.b, r11.c, r11.d);
    L8:
        if (r6 == null) goto L3;
        r4.add(r6);
        goto L3
    L10:
        List<c1> r12 = r10.c;
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r12.iterator();
    L12:
        if (r14.hasNext() == false) goto L19;
        c1 r15 = (c1) r14.next();
        if (r15 == null) goto L16;
        int r16 = e1.a;
        e1 r17 = e1.a.a(r15);
    L17:
        if (r17 == null) goto L12;
        r13.add(r17);
        goto L12
    L16:
        r17 = null;
        goto L17
    L19:
        List<c1> r18 = r10.a;
        ArrayList r19 = new ArrayList();
        Iterator<T> r20 = r18.iterator();
    L21:
        if (r20.hasNext() == false) goto L28;
        c1 r21 = (c1) r20.next();
        if (r21 == null) goto L25;
        int r22 = e1.a;
        e1 r23 = e1.a.a(r21);
    L26:
        if (r23 == null) goto L21;
        r19.add(r23);
        goto L21
    L25:
        r23 = null;
        goto L26
    L28:
        List<c1> r110 = r10.d;
        ArrayList r24 = new ArrayList();
        Iterator<T> r111 = r110.iterator();
    L30:
        if (r111.hasNext() == false) goto L37;
        c1 r25 = (c1) r111.next();
        if (r25 == null) goto L34;
        int r26 = e1.a;
        e1 r27 = e1.a.a(r25);
    L35:
        if (r27 == null) goto L30;
        r24.add(r27);
        goto L30
    L34:
        r27 = null;
        goto L35
    L37:
        r0.storeString(r9, GsonProtectorUtils.toJson(r1, new z0(r4, r13, r19, r24)));
    }

    public static final Object b(MentionRecommendStore r4, Function1 r5, Continuation r6) {
        r4.getClass();
        if ((r6 instanceof MentionRecommendStore$loadCatching$1) == false) goto L7;
        MentionRecommendStore$loadCatching$1 r0 = (MentionRecommendStore$loadCatching$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L15;
        if (r2 != 1) goto L14;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L19 CancellationException -> L22
    L24:
    L21:
        return r7;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r7);
        r0.label = 1;     // Catch: Throwable -> L19 CancellationException -> L22
        r7 = r5.invoke(r0);     // Catch: Throwable -> L19 CancellationException -> L22
        if (r7 != r8) goto L24;
        return r8;
    L22:
        e = move-exception;
        throw e;
    L19:
        r7 = null;
    L7:
        r0 = new MentionRecommendStore$loadCatching$1(r4, r6);
        goto L8
    }

    public final Object d(qp8.e r7, boolean r8, Continuation<? super f0> r9) {
        if ((r9 instanceof MentionRecommendStore$refresh$1) == false) goto L7;
        MentionRecommendStore$refresh$1 r0 = (MentionRecommendStore$refresh$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        f0 r4 = null;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r8 = r0.Z$0;
        c r11 = (c) r0.L$1;
        qp8.e r5 = (qp8.e) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L35:
        f0 r12 = (f0) r10;
        if (r12 == null) goto L43;
        b r13 = r11.a;
        a.getClass();
        if (Intrinsics.areEqual(r13, e(r5, r8)) == true) goto L40;
        return null;
    L40:
        return r12;
    L43:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        c r14 = f(r7, r8);
        if (r14 != null) goto L31;
        Object r15 = e;
        monitor-enter(r15);
        a r16 = f;     // Catch: Throwable -> L28
        if (r16 != null) goto L21;
    L26:
        monitor-exit(r15);
        return r4;
    L21:
        if (Intrinsics.areEqual(r16.a, AccountService.a.getUserId()) == true) goto L24;
        r16 = null;
    L24:
        if (r16 == null) goto L26;
        r4 = r16.b;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;
    L31:
        Deferred<f0> r6 = r14.b;
        r0.L$0 = r7;
        r0.L$1 = r14;
        r0.Z$0 = r8;
        r0.label = 1;
        Object r17 = r6.await(r0);
        if (r17 != r2) goto L34;
        return r2;
    L34:
        r5 = r7;
        r11 = r14;
        r10 = r17;
    L7:
        r0 = new MentionRecommendStore$refresh$1(this, r9);
        goto L8
    }

    public static final Object a(MentionRecommendStore r22, qp8.e r23, b r24, Continuation r25) {
        qp8.e r0 = r23;
        b r1 = r24;
        r22.getClass();
        if ((r25 instanceof MentionRecommendStore$fetchAndCache$1) == false) goto L7;
        MentionRecommendStore$fetchAndCache$1 r3 = (MentionRecommendStore$fetchAndCache$1) r25;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        boolean r7 = true;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        String r8 = (String) r3.L$2;
        r1 = (b) r3.L$1;
        qp8.e r9 = (qp8.e) r3.L$0;
        ResultKt.throwOnFailure(r2);
        String r10 = r8;
        r0 = r9;
        Object r11 = r2;
    L17:
        Pair r12 = (Pair) r11;
        List r13 = (List) r12.component1();
        f0 r14 = (f0) r12.component2();
        if (r13 != null) goto L22;
        if (r14 != null) goto L22;
        FLogger.a.w("MentionRecommendStore", "[fetchAndCache] both requests failed");
    L132:
        return null;
    L22:
        if (Intrinsics.areEqual(r1, e(r0, r1.d)) == true) goto L24;
        FLogger.a.i("MentionRecommendStore", "[fetchAndCache] discard result after account or IM capability changed");
        goto L132
    L24:
        Object r15 = e;
        monitor-enter(r15);
        a r16 = f;     // Catch: Throwable -> L136
        if (r16 != null) goto L29;
    L35:
        f0 r17 = null;
    L36:
        monitor-exit(r15);
        if (r17 != null) goto L39;
        r17 = c(r10);
    L39:
        if (r17 == null) goto L41;
        List<com.larus.bmhome.chat.component.bottom.core.inputtext.mention.c> r18 = r17.b;
    L42:
        if (r18 != null) goto L44;
        r18 = CollectionsKt.emptyList();
    L44:
        ArrayList r19 = new ArrayList();
        Iterator<T> r20 = r18.iterator();
    L46:
        if (r20.hasNext() == false) goto L56;
        com.larus.bmhome.chat.component.bottom.core.inputtext.mention.c r110 = (com.larus.bmhome.chat.component.bottom.core.inputtext.mention.c) r20.next();
        if (r110 == null) goto L52;
        qp8.c r111 = r110.a;
        if (r111 == null) goto L52;
        String r112 = r111.a;
    L53:
        if (r112 == null) goto L46;
        r19.add(r112);
    L52:
        r112 = null;
        goto L53
    L56:
        if (r13 == null) goto L61;
        List r113 = r13;
        ArrayList r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
        Iterator r115 = r113.iterator();
    L59:
        if (r115.hasNext() == false) goto L62;
        r114.add(((qp8.c) r115.next()).a);
    L62:
        FLogger r116 = FLogger.a;
        StringBuilder r117 = new StringBuilder("[fetchAndCache] contacts previous=");
        r117.append(r19);
        r117.append(", fresh=");
        r117.append(r114);
        r117.append(", changed=");
        if (r114 != null) goto L65;
    L67:
        boolean r21 = false;
    L68:
        r117.append(r21);
        r116.i("MentionRecommendStore", r117.toString());
        if (r14 == null) goto L74;
        List<c1> r26 = r14.a;
        if (r26 == null) goto L74;
    L73:
        List<c1> r118 = r26;
        if (r13 == null) goto L85;
        List r27 = r13;
        ArrayList r119 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r27, 10));
        Iterator r28 = r27.iterator();
    L82:
        if (r28.hasNext() == false) goto L84;
        r119.add(new com.larus.bmhome.chat.component.bottom.core.inputtext.mention.c((qp8.c) r28.next(), null));
        goto L82
    L84:
        List r120 = r119;
    L92:
        if (r1.d == false) goto L100;
        if (r14 == null) goto L96;
        List<c1> r29 = r14.c;
        if (r29 == null) goto L96;
    L101:
        List<c1> r121 = r29;
        if (r14 == null) goto L107;
        List<c1> r30 = r14.d;
        if (r30 == null) goto L107;
    L112:
        f0 r31 = new f0(r118, r120, r121, r30, 16);
        Object r32 = e;
        monitor-enter(r32);
    L133:
        th = move-exception;
        throw th;
    L115:
        if (Intrinsics.areEqual(h, r1) == false) goto L130;
        MentionRecommendStore r33 = a;     // Catch: Throwable -> L133
        boolean r122 = r1.d;     // Catch: Throwable -> L133
        r33.getClass();     // Catch: Throwable -> L133
        if (Intrinsics.areEqual(r1, e(r0, r122)) == false) goto L130;
        f = new a(r10, r31);     // Catch: Throwable -> L133
        g(r10, r31);     // Catch: Throwable -> L133
        Unit r34 = Unit.INSTANCE;     // Catch: Throwable -> L133
        monitor-exit(r32);
        FLogger r35 = FLogger.a;
        StringBuilder r36 = new StringBuilder("[fetchAndCache] contacts=");
        r36.append(r31.b.size());
        r36.append(", drives=");
        r36.append(r31.a.size());
        r36.append(", conversations=");
        r36.append(r31.d.size());
        r36.append(", contactsFailed=");
        if (r13 != null) goto L124;
        boolean r37 = true;
    L125:
        r36.append(r37);
        r36.append(", recommendFailed=");
        if (r14 == null) goto L129;
        r7 = false;
    L129:
        r36.append(r7);
        r35.i("MentionRecommendStore", r36.toString());
        return r31;
    L124:
        r37 = false;
    L130:
        monitor-exit(r32);
    L107:
        if (r17 == null) goto L109;
        r30 = r17.d;
    L110:
        if (r30 != null) goto L112;
        r30 = CollectionsKt.emptyList();
        goto L112
    L109:
        r30 = null;
    L96:
        if (r17 == null) goto L98;
        r29 = r17.c;
    L99:
        if (r29 != null) goto L101;
    L98:
        r29 = null;
    L100:
        r29 = CollectionsKt.emptyList();
        goto L101
    L85:
        if (r17 == null) goto L87;
        List<com.larus.bmhome.chat.component.bottom.core.inputtext.mention.c> r38 = r17.b;
    L88:
        if (r38 != null) goto L90;
        r38 = CollectionsKt.emptyList();
    L90:
        r120 = r38;
        goto L92
    L87:
        r38 = null;
    L74:
        if (r17 == null) goto L76;
        r26 = r17.a;
    L77:
        if (r26 != null) goto L73;
        r26 = CollectionsKt.emptyList();
        goto L73
    L76:
        r26 = null;
        goto L77
    L65:
        if (Intrinsics.areEqual(r114, r19) == true) goto L67;
        r21 = true;
        goto L68
    L61:
        r114 = null;
        goto L62
    L41:
        r18 = null;
        goto L42
    L29:
        if (Intrinsics.areEqual(r16.a, r10) == true) goto L32;
        r16 = null;
    L32:
        if (r16 == null) goto L35;
        r17 = r16.b;     // Catch: Throwable -> L136
    L136:
        th = move-exception;
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        r10 = r1.a;
        MentionRecommendStore$fetchAndCache$2 r39 = new MentionRecommendStore$fetchAndCache$2(r1, r0, null);
        r3.L$0 = r0;
        r3.L$1 = r1;
        r3.L$2 = r10;
        r3.label = 1;
        r11 = SupervisorKt.supervisorScope(r39, r3);
        if (r11 != r5) goto L17;
        return r5;
    L7:
        r3 = new MentionRecommendStore$fetchAndCache$1(r22, r25);
        goto L8
    }
}

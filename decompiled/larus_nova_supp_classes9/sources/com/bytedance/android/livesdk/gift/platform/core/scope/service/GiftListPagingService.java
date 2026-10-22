package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftListRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.UpdateLoadMoreState;
import com.bytedance.android.livesdk.gift.platform.core.giftlist.GiftListPanelRepository;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisode;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftListPagingService implements com.bytedance.android.scope.o {
    public final HashMap<Integer, a> a;
    public b b;
    public final HashMap<String, Boolean> c;
    public final GiftListPanelRepository d;

    public static final class a {
        public Disposable a;
        public b b;
        public final int c;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftListPagingService$a$a, reason: collision with other inner class name */
        public static final class C0070a<T> implements Consumer {
            public final /* synthetic */ a a;
            public final /* synthetic */ Function1 b;

            public C0070a(a r1, Function1 r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void accept(Object r2) {
                Long r3 = (Long) r2;
                Function1 r4 = this.b;
                b r0 = this.a.b;
                Intrinsics.checkNotNull(r0);
                r4.invoke(r0);
                a r5 = this.a;
                Disposable r1 = r5.a;
                if (r1 == null) goto L6;
                r1.dispose();
                r5.a = null;
                return;
            }
        }

        public a(int r1) {
            this.c = r1;
        }

        public final void a(Function1<? super b, Unit> r4) {
            Intrinsics.checkNotNullParameter(r4, "request");
            if (this.b != null) goto L5;
            return;
        L5:
            this.a = Observable.timer(this.c, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new C0070a(this, r4));
        }
    }

    public static final class b {
        public final long a;
        public final long b;
        public final int c;
        public final boolean d;
        public final String e;
        public final String f;
        public final IEpisode g;
        public final long h;
        public final int i;

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof b) == false) goto L24;
            b r7 = (b) r6;
            if (this.a == r7.a) goto L8;
            return false;
        L8:
            if (this.b == r7.b) goto L10;
            return false;
        L10:
            if (this.c == r7.c) goto L12;
            return false;
        L12:
            if (this.d == r7.d) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.f, r7.f) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.g, r7.g) == true) goto L20;
            return false;
        L20:
            if (this.h == r7.h) goto L22;
            return false;
        L22:
            if (this.i == r7.i) goto L37;
            return false;
        L37:
            return true;
        L24:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v17 */
        /* JADX WARN: Type inference failed for: r0v18 */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v6, types: [int] */
        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            long r3 = this.b;
            int r2 = (((r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.c) * 31;
            boolean r4 = this.d;
            ?? r5 = r4;
            if (r4 == false) goto L5;
            r5 = 1;
        L5:
            int r6 = (r2 + r5) * 31;
            String r7 = this.e;
            int r8 = 0;
            if (r7 == null) goto L8;
            int r9 = r7.hashCode();
        L9:
            int r10 = (r6 + r9) * 31;
            String r11 = this.f;
            if (r11 == null) goto L12;
            int r13 = r11.hashCode();
        L13:
            int r14 = (r10 + r13) * 31;
            IEpisode r15 = this.g;
            if (r15 == null) goto L16;
            r8 = r15.hashCode();
        L16:
            int r16 = (r14 + r8) * 31;
            long r17 = this.h;
            return ((r16 + ((int) (r17 ^ (r17 >>> 32)))) * 31) + this.i;
        L12:
            r13 = 0;
            goto L13
        L8:
            r9 = 0;
            goto L9
        }

        public final String toString() {
            return "GiftListRequestParam(roomId=" + this.a + ", toRoomId=" + this.b + ", scene=" + this.c + ", isAnchor=" + this.d + ", secAnchorId=" + this.e + ", secToUserId=" + this.f + ", episode=" + this.g + ", giftId=" + this.h + ", roomType=" + this.i + ")";
        }

        public b(long r1, long r3, int r5, boolean r6, String r7, String r8, IEpisode r9, long r10, int r13) {
            this.a = r1;
            this.b = r3;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r8;
            this.g = r9;
            this.h = r10;
            this.i = r13;
        }
    }

    public static final class c extends ca0.w {
        public final /* synthetic */ GiftListPagingService a;
        public final /* synthetic */ String b;

        public final void a() {
            this.a.c.put(this.b, Boolean.FALSE);
        }

        public final void b(List<? extends com.bytedance.android.livesdk.gift.model.w1> r3) {
            Intrinsics.checkNotNullParameter(r3, "giftPages");
            this.a.c.put(this.b, Boolean.FALSE);
        }

        public c(GiftListPagingService r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public final void onStart() {
    }

    public final void onStop() {
        Iterator<Map.Entry<Integer, a>> r0 = this.a.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        a r1 = r0.next().getValue();
        Disposable r3 = r1.a;
        if (r3 == null) goto L4;
        r3.dispose();
        r1.a = null;
        goto L4
    L8:
        this.b = null;
    }

    public GiftListPagingService(GiftListPanelRepository r2) {
        Intrinsics.checkNotNullParameter(r2, "giftListPanelRepository");
        this.d = r2;
        this.a = new HashMap();
        this.c = new HashMap();
    }

    public final void h(b r4) {
        Intrinsics.checkNotNullParameter(r4, "param");
        this.b = r4;
        Iterator<Map.Entry<Integer, a>> r1 = this.a.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        a r2 = r1.next().getValue();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "param");
        r2.b = r4;
        goto L4
    }

    public final void a(final ReceiverType r7, List<Integer> r8) {
        Intrinsics.checkNotNullParameter(r7, "receiverType");
        Intrinsics.checkNotNullParameter(r8, "pageTypeList");
        if (((com.bytedance.android.livesdk.gift.configmodel.o0) nz1.b.b.getValue(null, nz1.b.a[0])).P8() == true) goto L5;
        return;
    L5:
        Iterator<T> r9 = r8.iterator();
    L7:
        if (r9.hasNext() == false) goto L30;
        final int r0 = ((Number) r9.next()).intValue();
        int r1 = ((com.bytedance.android.livesdk.gift.configmodel.o0) nz1.b.b.getValue(null, nz1.b.a[0])).w6();
        if (r1 <= 0) goto L7;
        if (c(r7, r0, -1) == false) goto L7;
        a r4 = this.a.get(Integer.valueOf(r0));
        if (r4 != null) goto L18;
        r4 = new a(r1);
        b r2 = this.b;
        if (r2 == null) goto L17;
        h(r2);
    L17:
        this.a.put(Integer.valueOf(r0), r4);
    L18:
        Disposable r3 = r4.a;
        if (r3 != null) goto L21;
    L23:
        boolean r5 = false;
    L24:
        if (r5 == false) goto L25;
        Disposable r6 = r4.a;
        if (r6 == null) goto L29;
        r6.dispose();
        r4.a = null;
    L29:
        r4.a(new GiftListPagingService$autoRequestRemainGifts$$inlined$forEach$lambda$2(r0, this, r7));
        goto L7
    L25:
        r4.a(new GiftListPagingService$autoRequestRemainGifts$$inlined$forEach$lambda$1(r0, this, r7));
        goto L7
    L21:
        if (r3.isDisposed() == true) goto L23;
        r5 = true;
        goto L24
    }

    public final boolean d(int r2, long r3) {
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.g() == false) goto L5;
        StringBuilder r0 = new StringBuilder();
        r0.append(r2);
        r0.append(r3);
        String r4 = r0.toString();
    L6:
        Boolean r5 = this.c.get(r4);
        if (r5 != null) goto L10;
        r5 = Boolean.FALSE;
    L10:
        return r5.booleanValue();
    L5:
        r4 = String.valueOf(r2);
        goto L6
    }

    public final boolean c(ReceiverType r3, int r4, long r5) {
        Intrinsics.checkNotNullParameter(r3, "receiverType");
        Intrinsics.checkNotNullParameter(r3, "receiverType");
        com.bytedance.android.livesdk.gift.platform.core.giftlist.k r6 = this.d.d(r3, r4, r5);
        if (r6 != null) goto L5;
    L13:
        return false;
    L5:
        if ((!r6.c.isEmpty()) == false) goto L13;
        List<com.bytedance.android.livesdk.gift.model.c1> r7 = r6.c;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator<T> r9 = r7.iterator();
    L8:
        if (r9.hasNext() == false) goto L11;
        r8.add(Long.valueOf(((com.bytedance.android.livesdk.gift.model.c1) r9.next()).getId()));
        goto L8
    L11:
        if (((Number) CollectionsKt.last(r8)).longValue() == r6.d) goto L13;
        return true;
    }

    public final void f(ReceiverType r8, int r9, long r10) {
        Intrinsics.checkNotNullParameter(r8, "receiverType");
        b r2 = this.b;
        if (r2 == null) goto L6;
        g(r2, r8, r9, r10);
        return;
    }

    public final void g(b r28, ReceiverType r29, int r30, long r31) {
        Intrinsics.checkNotNullParameter(r29, "receiverType");
        com.bytedance.android.livesdk.gift.platform.core.giftlist.k r2 = this.d.d(r29, r30, r31);
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.g() == false) goto L5;
        StringBuilder r4 = new StringBuilder();
        r4.append(r30);
        r4.append(r31);
        String r5 = r4.toString();
    L6:
        String r6 = r5;
        if (r2 != null) goto L9;
    L26:
        uz1.a r1 = com.bytedance.android.livesdk.gift.platform.core.utils.b0.b();
        if (r1 == null) goto L29;
        r1.a(new UpdateLoadMoreState(false, r30, Long.valueOf(r31)));
    L29:
        this.c.put(r6, Boolean.FALSE);
        return;
    L9:
        if (r2.c.isEmpty() == true) goto L26;
        if (((com.bytedance.android.livesdk.gift.model.c1) CollectionsKt.last(r2.c)).getId() == r2.d) goto L26;
        uz1.a r7 = com.bytedance.android.livesdk.gift.platform.core.utils.b0.b();
        if (r7 == null) goto L16;
        r7.a(new UpdateLoadMoreState(true, r30, Long.valueOf(r31)));
    L16:
        this.c.put(r6, Boolean.TRUE);
        List<com.bytedance.android.livesdk.gift.model.c1> r8 = r2.c;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r10 = r8.iterator();
    L18:
        if (r10.hasNext() == false) goto L20;
        r9.add(Long.valueOf(((com.bytedance.android.livesdk.gift.model.c1) r10.next()).getId()));
        goto L18
    L20:
        int r3 = r9.indexOf(Long.valueOf(r2.d));
        Integer r11 = ((com.bytedance.android.livesdk.gift.configmodel.o0) nz1.b.b.getValue(null, nz1.b.a[0])).g1().get(String.valueOf(r30));
        if (r11 == null) goto L23;
        int r13 = r11.intValue();
    L24:
        List r18 = r9.subList(r3 + 1, Math.min(r9.size(), r3 + r13));
        GiftListRepo.k(new c(this, r6), r28.a, r28.b, r28.c, 12, r28.d, r28.e, r28.f, r28.g, r28.h, r28.i, r18, null, Integer.valueOf(r30), r31, null, null, false, 233472);
        return;
    L23:
        r13 = 50;
        goto L24
    L5:
        r5 = String.valueOf(r30);
        goto L6
    }
}

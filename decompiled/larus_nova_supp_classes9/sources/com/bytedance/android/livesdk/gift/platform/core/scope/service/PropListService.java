package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import android.text.TextUtils;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.RefreshPropList;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class PropListService implements xc6.e, com.bytedance.android.scope.o {
    public final List<com.bytedance.android.livesdk.gift.model.l2> a;
    public final CompositeDisposable b;
    public final i12.e c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/scope/service/PropListService$ExpirePropShowType;", BuildConfig.FLAVOR, "TOAST", "RED_DOT", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ExpirePropShowType extends Enum<ExpirePropShowType> {
        public static final ExpirePropShowType RED_DOT = null;
        public static final ExpirePropShowType TOAST = null;
        public static final /* synthetic */ ExpirePropShowType[] a = null;

        static {
            ExpirePropShowType r1 = new ExpirePropShowType("TOAST", 0);
            TOAST = r1;
            ExpirePropShowType r2 = new ExpirePropShowType("RED_DOT", 1);
            RED_DOT = r2;
            a = new ExpirePropShowType[]{r1, r2};
        }

        public static ExpirePropShowType valueOf(String r1) {
            return (ExpirePropShowType) r27.a.a(ExpirePropShowType.class, r1);
        }

        public static ExpirePropShowType[] values() {
            return (ExpirePropShowType[]) a.clone();
        }

        public ExpirePropShowType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b<T> implements ObservableOnSubscribe {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;

        public b(String r1, String r2, int r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void subscribe(ObservableEmitter<List<com.bytedance.android.livesdk.gift.model.l2>> r7) {
            Intrinsics.checkNotNullParameter(r7, "it");
            int r8 = com.bytedance.android.livesdk.utils.u2.a;
            com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.w0.c(com.bytedance.android.livesdk.utils.u2.a(this.a), this.b, this.c, com.bytedance.android.livesdk.utils.u2.a(this.d));
        }
    }

    static {
    }

    public final void onStart() {
    }

    public final void onStop() {
        this.b.clear();
    }

    public final void d() {
        HashSet<Long> r0 = ay1.b.t();
        Iterator r1 = ((ArrayList) this.a).iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        com.bytedance.android.livesdk.gift.model.l2 r2 = (com.bytedance.android.livesdk.gift.model.l2) r1.next();
        if (r2.getReddotTip() == false) goto L4;
        if (r0.contains(Long.valueOf(r2.getId())) == true) goto L4;
        r0.add(Long.valueOf(r2.getId()));
        goto L4
    L10:
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        com.bytedance.tools.kcp.spongepreference.runtime.a r3 = ay1.b.M;
        KProperty[] r4 = ay1.b.a;
        r3.setValue(null, r4[46], r0);
        ay1.b.C(false);
        String r5 = com.bytedance.android.live.base.model.user.o.a(com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b());
        HashMap<String, String> r6 = ay1.b.s();
        r6.put(r5, String.valueOf(System.currentTimeMillis()));
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        ay1.b.Y.setValue(null, r4[62], r6);
    }

    public final boolean h() {
        HashSet<Long> r0 = ay1.b.t();
        Iterator r1 = ((ArrayList) this.a).iterator();
    L4:
        if (r1.hasNext() == false) goto L12;
        com.bytedance.android.livesdk.gift.model.l2 r2 = (com.bytedance.android.livesdk.gift.model.l2) r1.next();
        if (r2.getReddotTip() == false) goto L4;
        if (r0.contains(Long.valueOf(r2.getId())) == true) goto L4;
        return true;
    L12:
        return ay1.b.v();
    }

    public PropListService(i12.e r2) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        this.c = r2;
        this.a = new ArrayList();
        this.b = new CompositeDisposable();
    }

    public final com.bytedance.android.livesdk.gift.model.l2 f(Long r9) {
        if (r9 != null) goto L5;
        return null;
    L5:
        Iterator r1 = ((ArrayList) this.a).iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        com.bytedance.android.livesdk.gift.model.l2 r2 = (com.bytedance.android.livesdk.gift.model.l2) r1.next();
        if (r2.getId() != r9.longValue()) goto L7;
        return r2;
    L11:
        return null;
    }

    public final boolean g(ExpirePropShowType r24) {
        Intrinsics.checkNotNullParameter(r24, "type");
        String r2 = com.bytedance.android.live.base.model.user.o.a(com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b());
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return false;
    L5:
        HashMap<String, String> r3 = ay1.b.s();
        HashMap r5 = (HashMap) ay1.b.Z.getValue(null, ay1.b.a[63]);
        long r9 = 0;
        if (ay1.b.s().containsKey(r2) == true) goto L9;
        r3.put(r2, String.valueOf(0));
        r5.put(r2, String.valueOf(0));
    L9:
        if (r24 != ExpirePropShowType.RED_DOT) goto L51;
        long r1 = CastLongProtector.parseLong(r3.get(r2));     // Catch: Throwable -> L13
    L15:
        if (r1 >= 0) goto L17;
    L50:
        return false;
    L17:
        if (((System.currentTimeMillis() / 86400000) - (r1 / 86400000)) >= 1) goto L19;
        return false;
    L19:
        Iterator r4 = ((ArrayList) this.a).iterator();
    L21:
        if (r4.hasNext() == false) goto L50;
        com.bytedance.android.livesdk.gift.model.l2 r6 = (com.bytedance.android.livesdk.gift.model.l2) r4.next();
        if (r6.getNextExpire() <= 0) goto L21;
        long r7 = (r6.getNextExpire() - (System.currentTimeMillis() / 1000)) - r6.getNowTimeDiff();
        if (r6.getGift().getDiamondCount() <= 0) goto L21;
        if (r7 >= (((long) 2) * 86400000)) goto L21;
        return true;
    L13:
        r1 = 0;
        goto L15
    L51:
        long r19 = CastLongProtector.parseLong((String) r5.get(r2));     // Catch: Throwable -> L32
    L34:
        if (r19 < 0) goto L50;
        if (((System.currentTimeMillis() / 86400000) - (r19 / 86400000)) >= 1) goto L38;
        return false;
    L38:
        Iterator r8 = ((ArrayList) this.a).iterator();
    L40:
        if (r8.hasNext() == false) goto L50;
        com.bytedance.android.livesdk.gift.model.l2 r10 = (com.bytedance.android.livesdk.gift.model.l2) r8.next();
        if (r10.getNextExpire() <= r9) goto L49;
        long r15 = (r10.getNextExpire() - (System.currentTimeMillis() / 1000)) - r10.getNowTimeDiff();
        if (r10.getGift().getDiamondCount() <= 0) goto L49;
        if (r15 >= (((long) 2) * 86400000)) goto L49;
        r5.put(r2, String.valueOf(System.currentTimeMillis()));
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        ay1.b.Z.setValue(null, ay1.b.a[63], r5);
        return true;
    L49:
        r9 = 0;
    L32:
        r19 = 0;
        goto L34
    }

    public final void i(List<? extends com.bytedance.android.livesdk.gift.model.l2> r13) {
        Intrinsics.checkNotNullParameter(r13, "propList");
        ((ArrayList) this.a).clear();
        ((ArrayList) this.a).addAll(r13);
        Intrinsics.checkNotNullParameter(r13, "propList");
        HashMap r0 = (HashMap) ay1.b.u0.getValue(null, ay1.b.a[87]);
        r0.clear();
        com.bytedance.android.livesdk.revenue.service.room.c r1 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r1 == null) goto L23;
        com.bytedance.android.livesdk.revenue.room.a r2 = r1.getRoomContext();
        if (r2 == null) goto L23;
        String r4 = String.valueOf(iz.a.a(vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).b()));
        com.bytedance.live.datacontext.m r3 = r2.getRoom();
        if (r3 == null) goto L23;
        IRoom r5 = (IRoom) r3.getValue();
        if (r5 == null) goto L23;
        String r6 = r5.getAnchorId();
        if (r6 == null) goto L23;
        Iterator<T> r7 = r13.iterator();
    L16:
        if (r7.hasNext() == false) goto L22;
        com.bytedance.android.livesdk.gift.model.l2 r8 = (com.bytedance.android.livesdk.gift.model.l2) r7.next();
        if (r8.getPropType() != 1) goto L16;
        if (r8.getPropDefSubType() != 1) goto L16;
        r0.put(r4 + '-' + r6, Boolean.TRUE);
        goto L16
    L22:
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        ay1.b.u0.setValue(null, ay1.b.a[87], r0);
    L23:
        uz1.a r9 = com.bytedance.android.livesdk.gift.platform.core.utils.b0.a();
        if (r9 == null) goto L34;
        r9.a(new RefreshPropList(r13, false));
        return;
    }

    public final void a(String r8, String r9, int r10, String r11) {
        Intrinsics.checkNotNullParameter(r8, "roomId");
        Intrinsics.checkNotNullParameter(r9, "toUserId");
        Intrinsics.checkNotNullParameter(r11, "toRoomId");
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.w0.c(com.bytedance.android.livesdk.utils.u2.a(r8), r9, r10, com.bytedance.android.livesdk.utils.u2.a(r11));
    }

    public final Observable<List<com.bytedance.android.livesdk.gift.model.l2>> c(String r2, String r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "roomId");
        Intrinsics.checkNotNullParameter(r3, "toUserId");
        Intrinsics.checkNotNullParameter(r5, "toRoomId");
        return Observable.create(new b(r2, r3, r4, r5));
    }
}

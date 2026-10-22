package com.bytedance.android.livesdk.gift.grouplive.component.viewmodel;

import com.bytedance.android.anya.BaseMVIComposableViewModel;
import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.e;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.p;
import com.bytedance.android.anya.t;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.gift.grouplive.component.GroupComponentDataStore;
import com.bytedance.android.livesdk.gift.grouplive.component.GroupComponentState;
import com.bytedance.android.livesdk.gift.grouplive.component.c;
import com.bytedance.android.livesdk.gift.grouplive.component.i;
import com.bytedance.android.livesdk.gift.grouplive.component.k;
import com.bytedance.android.livesdk.gift.grouplive.component.l;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.revenue.room.RevPadOrientation;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.o;
import fa0.b;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends BaseMVIComposableViewModel<GroupComponentState, c> implements o {
    public final CompositeDisposable v;
    public final GroupComponentDataStore w;
    public final k x;
    public final com.bytedance.android.livesdk.revenue.room.a y;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.grouplive.component.viewmodel.a$a, reason: collision with other inner class name */
    public static final class C0012a<T> implements Consumer {
        public final /* synthetic */ a a;

        public C0012a(a r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            RevPadOrientation r9 = (RevPadOrientation) r8;
            a r10 = this.a;
            GroupComponentDataStore r1 = r10.w;
            t r2 = r1.t;
            KProperty[] r3 = GroupComponentDataStore.D;
            ty1.c r4 = (ty1.c) r2.getValue(r1, r3[15]);
            GroupComponentState.Style r5 = this.a.w.R();
            GroupComponentDataStore r6 = this.a.w;
            r10.K0(new l(r4, r5, ((Number) r6.q.getValue(r6, r3[12])).intValue()));
        }
    }

    public final Set<BaseMVIDataStore<?>> I() {
        return SetsKt.setOf(this.w);
    }

    public final void onStop() {
        k r0 = this.x;
        i r1 = (i) m.e.d(r0, i.class);
        if (r1 == null) goto L5;
        r1.a.onNext(new b(false, false, 0));
    L5:
        this.v.clear();
    }

    public final void onStart() {
        if (PadConfigUtils.c() == true) goto L5;
        return;
    L5:
        if (((Boolean) qy1.a.c.getValue(null, qy1.a.a[1])).booleanValue() == false) goto L13;
        Observable r0 = this.y.getPadOrientation();
        if (r0 == null) goto L14;
        Disposable r1 = r0.subscribe(new C0012a(this));
        if (r1 == null) goto L15;
        RxUtilKt.c(r1, this.v);
        return;
    L15:
        return;
    L14:
        return;
    }

    public final MVIState F(l0 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$createState");
        return new GroupComponentState();
    }

    public final void J0(e r5, MVIState r6) {
        final GroupComponentState r7 = (GroupComponentState) r6;
        Intrinsics.checkNotNullParameter(r5, "$this$reduce");
        Intrinsics.checkNotNullParameter(r7, "state");
        r5.e(this.w.s(), new GroupComponentViewModel$reduce$1(r7));
        r5.e(this.w.F(), new GroupComponentViewModel$reduce$2(r7));
        r5.e(this.w.q(), new GroupComponentViewModel$reduce$3(r7));
        r5.e(this.w.J(), new GroupComponentViewModel$reduce$4(r7));
        r5.e(this.w.y(), new GroupComponentViewModel$reduce$5(r7));
        r5.e(this.w.I(), new GroupComponentViewModel$reduce$6(r7));
        GroupComponentDataStore r0 = this.w;
        ReadOnlyProperty r1 = r0.m;
        KProperty[] r2 = GroupComponentDataStore.D;
        r5.e((t) r1.getValue(r0, r2[8]), new GroupComponentViewModel$reduce$7(r7));
        GroupComponentDataStore r3 = this.w;
        r5.e((t) r3.n.getValue(r3, r2[9]), new GroupComponentViewModel$reduce$8(r7));
        GroupComponentDataStore r4 = this.w;
        r5.e((t) r4.o.getValue(r4, r2[10]), new GroupComponentViewModel$reduce$9(r7));
    }

    public final void X(com.bytedance.android.anya.o r4, p r5) {
        c r6 = (c) r5;
        Intrinsics.checkNotNullParameter(r4, "$this$handleAction");
        Intrinsics.checkNotNullParameter(r6, "action");
        if ((r6 instanceof com.bytedance.android.livesdk.gift.grouplive.component.a) == false) goto L8;
        k r7 = this.x;
        i r8 = (i) m.e.d(r7, i.class);
        if (r8 == null) goto L11;
        com.bytedance.android.livesdk.gift.grouplive.component.a r9 = (com.bytedance.android.livesdk.gift.grouplive.component.a) r6;
        boolean r0 = r9.a;
        boolean r1 = r9.b;
        int r10 = r9.c;
        r8.a.onNext(new b(r0, r1, r10));
        return;
    L11:
        return;
    L8:
        if ((r6 instanceof com.bytedance.android.livesdk.gift.grouplive.component.b) == false) goto L13;
        com.bytedance.android.livesdk.gift.grouplive.component.b r11 = (com.bytedance.android.livesdk.gift.grouplive.component.b) r6;
        this.w.n(r11.a, r11.b);
        return;
    }

    public a(GroupComponentDataStore r2, k r3, com.bytedance.android.livesdk.revenue.room.a r4) {
        Intrinsics.checkNotNullParameter(r2, "dataStore");
        Intrinsics.checkNotNullParameter(r3, "scope");
        Intrinsics.checkNotNullParameter(r4, "roomContext");
        super(CollectionsKt.emptyList());
        this.w = r2;
        this.x = r3;
        this.y = r4;
        f0();
        this.v = new CompositeDisposable();
    }
}

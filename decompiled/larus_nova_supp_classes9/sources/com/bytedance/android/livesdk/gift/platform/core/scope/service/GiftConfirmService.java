package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import android.app.Dialog;
import android.content.Context;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftConfirmService implements com.bytedance.android.scope.o {
    public Dialog a;
    public final Context b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/scope/service/GiftConfirmService$ConfirmResult;", BuildConfig.FLAVOR, "CONFIRM", "CANCEL", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ConfirmResult extends Enum<ConfirmResult> {
        public static final ConfirmResult CANCEL = null;
        public static final ConfirmResult CONFIRM = null;
        public static final /* synthetic */ ConfirmResult[] a = null;

        static {
            ConfirmResult r1 = new ConfirmResult("CONFIRM", 0);
            CONFIRM = r1;
            ConfirmResult r2 = new ConfirmResult("CANCEL", 1);
            CANCEL = r2;
            a = new ConfirmResult[]{r1, r2};
        }

        public static ConfirmResult valueOf(String r1) {
            return (ConfirmResult) r27.a.a(ConfirmResult.class, r1);
        }

        public static ConfirmResult[] values() {
            return (ConfirmResult[]) a.clone();
        }

        public ConfirmResult(String r1, int r2) {
            super(r1, r2);
        }
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public GiftConfirmService(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.b = r2;
    }

    public static String c(com.bytedance.android.livesdk.gift.model.h1 r4) {
        String r0 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).getCurrentUserId();
        if (r4.getBizType() != 0) goto L6;
        return r4.getId() + r0;
    L6:
        if (r4.getBizType() != 1) goto L16;
        StringBuilder r1 = new StringBuilder();
        com.bytedance.android.livesdk.gift.model.t0 r5 = r4.getGoodsBizItem();
        if (r5 == null) goto L14;
        com.bytedance.android.livesdk.gift.model.h r6 = r5.a();
        if (r6 == null) goto L14;
        com.bytedance.android.livesdk.gift.model.u0 r7 = r6.c();
        if (r7 == null) goto L14;
        Long r8 = Long.valueOf(r7.a());
    L15:
        r1.append(r8);
        r1.append(r0);
        return r1.toString();
    L14:
        r8 = null;
        goto L15
    L16:
        return BuildConfig.FLAVOR;
    }

    public final Observable<ConfirmResult> a(com.bytedance.android.livesdk.gift.model.h1 r15, u1 r16, long r17, String r19, String r20) {
        Intrinsics.checkNotNullParameter(r16, "giftPanelLogService");
        Intrinsics.checkNotNullParameter(r19, "giftName");
        Intrinsics.checkNotNullParameter(r20, "uniqueKey");
        if (r15 == null) goto L37;
        if (r15.getId() == 0) goto L37;
        HashSet r8 = (HashSet) ay1.b.A0.getValue(null, ay1.b.a[93]);
        if (r15.getGiftConfirmInfo() == null) goto L22;
        com.bytedance.android.livesdk.gift.model.f0 r3 = r15.getGiftConfirmInfo();
        Intrinsics.checkNotNull(r3);
        String r4 = c(r15);
        if (r3.c() != 1) goto L16;
        if (((Set) k0.b.getValue(null, k0.a[0])).contains(r4) == false) goto L16;
        return Observable.just(ConfirmResult.CONFIRM);
    L16:
        if (r3.c() == 0) goto L18;
        Intrinsics.checkNotNullParameter(r15, "gift");
        Intrinsics.checkNotNullParameter(r16, "giftPanelLogService");
        Intrinsics.checkNotNullParameter(r3, "giftConfirmInfo");
        return Observable.create(new i0(this, r3, r16, r15)).subscribeOn(AndroidSchedulers.mainThread()).observeOn(Schedulers.computation());
    L18:
        return Observable.just(ConfirmResult.CONFIRM);
    L22:
        if (nz1.a.k().a() == false) goto L35;
        if (r17 <= nz1.a.k().b()) goto L35;
        if (r8.contains(r20) == true) goto L35;
        HashSet r9 = new HashSet();
        r9.addAll(r8);
        Unit r0 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r19, "giftName");
        Intrinsics.checkNotNullParameter(r20, "uniqueKey");
        Intrinsics.checkNotNullParameter(r9, "uniqueKeyCache");
        Dialog r1 = this.a;
        if (r1 == null) goto L33;
        if (r1.isShowing() != true) goto L33;
        return Observable.just(ConfirmResult.CANCEL);
    L33:
        return Observable.create(new j0(this, r17, r19, r9, r20)).subscribeOn(AndroidSchedulers.mainThread()).observeOn(Schedulers.computation());
    L35:
        return Observable.just(ConfirmResult.CONFIRM);
    L37:
        return Observable.just(ConfirmResult.CONFIRM);
    }
}

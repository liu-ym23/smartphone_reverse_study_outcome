package com.bytedance.android.livesdk.gift.blindbox;

import android.animation.ObjectAnimator;
import android.content.Context;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.gift.model.e0;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.model.y1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.topview.i;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.SelectedStatus;
import com.bytedance.android.livesdk.gift.platform.business.l;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.model.k;
import com.bytedance.android.livesdk.gift.platform.core.model.n;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class BlindBoxGiftPlugin extends l {
    public final PublishSubject<Boolean> e;
    public Long f;
    public final CompositeDisposable g;
    public List<Long> h;
    public com.bytedance.android.livesdk.gift.blindbox.a i;
    public boolean j;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ BlindBoxGiftPlugin a;

        public a(BlindBoxGiftPlugin r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Long r4 = (Long) r3;
            List<Long> r5 = this.a.h;
            Intrinsics.checkNotNullParameter(r5, "giftIds");
            JSONObject r0 = new JSONObject();
            c.f(r0, "gift_ids", r5);
            c.e("ttlive_blind_box_gift_list", 0, r0);
            jy0.b.a("ttlive_blind_box", "ttlive_blind_box_gift_list " + r0);
        }
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.f
    public final void c() {
        this.i = null;
        this.g.clear();
        super.c();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.f
    public final boolean o(AbsPanel<?> r1, int r2, int r3, IBaseUser r4, boolean r5, List<? extends IBaseUser> r6, n r7, k r8, k r9, l1 r10, com.bytedance.android.livesdk.gift.model.n r11, String r13, int r14, String r15, com.bytedance.android.livesdk.gift.platform.core.model.a r16) {
        Intrinsics.checkNotNullParameter(r4, "toUser");
        Intrinsics.checkNotNullParameter(r7, "showInfo");
        return false;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.h
    public final i<Pair<Boolean, Boolean>> E() {
        return new i(RxUtilKt.e(this.e), new BlindBoxGiftPlugin$provideTopViewController$1(this));
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.f
    public final void q() {
        Disposable r0 = Observable.timer(5, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
        this.g.add(r0);
    }

    public final com.bytedance.android.livesdk.gift.blindbox.a I() {
        Context r0 = getContext();
        if (this.i != null) goto L7;
        if (r0 == null) goto L7;
        this.i = new com.bytedance.android.livesdk.gift.blindbox.a(r0, this.b);
    L7:
        return this.i;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.h
    public final void onDestroy() {
        super.onDestroy();
        this.i = null;
        this.g.clear();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.f
    public final void d(AbsPanel r7) {
        if (this.j == false) goto L12;
        this.j = false;
        if (b.b(r7) == null) goto L12;
        com.bytedance.android.livesdk.gift.blindbox.a r0 = I();
        if (r0 == null) goto L12;
        float[] r2 = {0.0f, 20.0f, -20.0f, 12.0f, -8.0f, 3.0f, 0.0f};
        ObjectAnimator r3 = r0.j;
        if (r3 == null) goto L11;
        r3.cancel();
    L11:
        ObjectAnimator r1 = ObjectAnimator.ofFloat(r0.i, "rotation", Arrays.copyOf(r2, 7));
        r1.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
        r1.setDuration(840);
        r1.start();
        r0.j = r1;
    L12:
        super.d(r7);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.h
    public final void g(w1 r4) {
        Intrinsics.checkNotNullParameter(r4, "page");
        if (r4.getPageType() != 1) goto L20;
        List<h1> r5 = r4.getGifts();
        ArrayList r0 = new ArrayList();
        Iterator<T> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L13;
        h1 r1 = b.a((h1) r6.next());
        if (r1 == null) goto L10;
        Long r2 = Long.valueOf(r1.getId());
    L11:
        if (r2 == null) goto L6;
        r0.add(r2);
        goto L6
    L10:
        r2 = null;
        goto L11
    L13:
        this.h = r0;
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.f
    public final void y(p2 r13) {
        Intrinsics.checkNotNullParameter(r13, "result");
        List<y1> r0 = r13.getGifts();
        h1 r1 = null;
        if (r0 == null) goto L9;
        Sequence r2 = CollectionsKt.asSequence(r0);
        if (r2 == null) goto L9;
        Sequence r3 = SequencesKt.mapNotNull(r2, BlindBoxGiftPlugin$onGiftSendSucceed$info$1.INSTANCE);
        if (r3 == null) goto L9;
        e0 r4 = (e0) SequencesKt.firstOrNull(r3);
    L10:
        h2 r5 = GiftManagerKt.l(r13.getGiftId());
        if ((r5 instanceof h1) == true) goto L13;
        r5 = null;
    L13:
        h1 r6 = (h1) r5;
        if (r6 == null) goto L16;
        r1 = b.a(r6);
    L16:
        if (r1 == null) goto L29;
        if (r4 == null) goto L23;
        GiftContext r7 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r7 == null) goto L23;
        com.bytedance.live.datacontext.k<Pair<Long, e0>> r8 = r7.getUpdateGiftBanner();
        if (r8 == null) goto L23;
        r8.post(TuplesKt.to(Long.valueOf(r13.getGiftId()), r4));
    L23:
        Intrinsics.checkNotNullParameter(r13, "response");
        JSONObject r9 = new JSONObject();
        c.f(r9, "gift_id", String.valueOf(r13.getGiftId()));
        List<y1> r10 = r13.getGifts();
        if (r10 == null) goto L27;
        String r11 = CollectionsKt.joinToString$default(r10, null, null, null, 0, null, BlindBoxTracingKt$logBlindBoxGiftSendSuccess$extra$1$1.INSTANCE, 31, null);
        if (r11 == null) goto L27;
    L28:
        c.f(r9, "gift_banner", r11);
        c.e("ttlive_blind_box_gift_send_success", 0, r9);
        jy0.b.a("ttlive_blind_box", "ttlive_blind_box_gift_send_success " + r9);
    L27:
        r11 = BuildConfig.FLAVOR;
    L29:
        long r14 = r13.getGiftId();
        Long r15 = this.f;
        if (r15 != null) goto L33;
    L41:
        super.y(r13);
        return;
    L33:
        if (r14 != r15.longValue()) goto L41;
        if (r4 == null) goto L41;
        if (r4.animate == false) goto L38;
        this.j = true;
    L38:
        com.bytedance.android.livesdk.gift.blindbox.a r16 = I();
        if (r16 == null) goto L41;
        r16.g(r4);
        r16.k = Long.valueOf(r13.getGiftId());
    L9:
        r4 = null;
        goto L10
    }

    public BlindBoxGiftPlugin(DataCenter r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r2, r3);
        this.e = PublishSubject.create();
        this.g = new CompositeDisposable();
        this.h = CollectionsKt.emptyList();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.f
    public final boolean x(AbsPanel<?> r5, SelectedStatus r6, Integer r7) {
        Intrinsics.checkNotNullParameter(r6, "selectedStatus");
        h1 r8 = b.b(r5);
        if (r8 == null) goto L5;
        Long r0 = Long.valueOf(r8.getId());
    L6:
        this.f = r0;
        if (r8 == null) goto L12;
        e0 r1 = r8.getGiftBanner();
        com.bytedance.android.livesdk.gift.blindbox.a r2 = I();
        if (r2 == null) goto L11;
        r2.g(r1);
        r2.k = this.f;
    L11:
        this.e.onNext(Boolean.TRUE);
        Intrinsics.checkNotNullParameter(r8, "gift");
        JSONObject r3 = new JSONObject();
        c.f(r3, "gift_ids", String.valueOf(r8.getId()));
        c.e("ttlive_blind_box_gift_select", 0, r3);
        jy0.b.a("ttlive_blind_box", "ttlive_blind_box_gift_select " + r3);
    L13:
        this.j = false;
        Intrinsics.checkNotNullParameter(r6, "selectedStatus");
        return false;
    L12:
        this.e.onNext(Boolean.FALSE);
        goto L13
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.f
    public final boolean A(AbsPanel<?> r1, int r2, int r3, IBaseUser r4, boolean r5, List<? extends IBaseUser> r6, boolean r7, n r8, k r9, k r10, l1 r11, com.bytedance.android.livesdk.gift.model.n r13, String r14, String r15, com.bytedance.android.livesdk.gift.platform.core.model.a r16) {
        Intrinsics.checkNotNullParameter(r4, "toUser");
        Intrinsics.checkNotNullParameter(r8, "showInfo");
        h1 r17 = b.b(r1);
        if (r17 == null) goto L7;
        c.d(r17);
        return false;
    L7:
        return false;
    }
}

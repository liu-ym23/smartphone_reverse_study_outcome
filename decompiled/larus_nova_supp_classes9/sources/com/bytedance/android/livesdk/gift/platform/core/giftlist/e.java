package com.bytedance.android.livesdk.gift.platform.core.giftlist;

import ca0.w;
import ca0.x;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftListRepo;
import com.bytedance.android.livesdk.utils.u2;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e<T> implements ObservableOnSubscribe {
    public final /* synthetic */ w a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ String g;
    public final /* synthetic */ String h;

    public static final class a extends x {
        public final /* synthetic */ ObservableEmitter b;

        public final void b(List<? extends w1> r3) {
            Intrinsics.checkNotNullParameter(r3, "giftPages");
            ObservableEmitter r0 = this.b;
            List r1 = CollectionsKt.toList(r3);
            if (r1 != null) goto L6;
            r1 = com.bytedance.revenue.platform.api.core.c.a(new w1[0]);
        L6:
            r0.onNext(r1);
            super.b(r3);
        }

        public a(ObservableEmitter r1, w r2) {
            this.b = r1;
            super(r2);
        }
    }

    public e(String r2, String r3, int r4, int r5, String r6, String r7) {
        this.a = null;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = false;
        this.g = r6;
        this.h = r7;
    }

    public final void subscribe(ObservableEmitter<List<w1>> r13) {
        Intrinsics.checkNotNullParameter(r13, "it");
        a r1 = new a(r13, this.a);
        int r14 = u2.a;
        GiftListRepo.i(r1, u2.a(this.b), u2.a(this.c), this.d, this.e, this.f, this.g, this.h, null);
    }
}

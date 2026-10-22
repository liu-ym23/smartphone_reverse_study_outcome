package com.bytedance.android.livesdk.gift.platform.core.scope.service.sort;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.gift.model.a2;
import com.bytedance.android.livesdk.gift.platform.core.h;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.f1;
import com.bytedance.android.scope.o;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.JsonElement;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vh7.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements o {
    public final CompositeDisposable a;
    public final boolean b;
    public final f1 c;
    public final d01.a d;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.core.scope.service.sort.a$a, reason: collision with other inner class name */
    public static final class C0072a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            JsonElement r7 = (JsonElement) r6;
            this.a.getClass();
            com.bytedance.android.livesdk.gift.platform.core.scope.service.sort.b r8 = (com.bytedance.android.livesdk.gift.platform.core.scope.service.sort.b) GsonHelper.getDefault().fromJson(r7.getAsJsonObject(), com.bytedance.android.livesdk.gift.platform.core.scope.service.sort.b.class);     // Catch: Exception -> L5
        L6:
            if (r8 == null) goto L22;
            a2 r0 = (a2) f.c(a2.class);
            String r1 = r8.d();
            String r2 = BuildConfig.FLAVOR;
            if (r1 != null) goto L11;
            r1 = BuildConfig.FLAVOR;
        L11:
            r0.setScene(r1);
            List<Long> r3 = r8.c();
            if (r3 != null) goto L14;
            r3 = new ArrayList();
        L14:
            r0.setGiftIds(r3);
            r0.setStartTime(r8.e());
            r0.setEndTime(r8.a());
            String r9 = r8.b();
            if (r9 == null) goto L18;
            r2 = r9;
        L18:
            r0.setExtra(r2);
            this.a.c.g(CollectionsKt.arrayListOf(new a2[]{r0}));
            return;
        L22:
            return;
        L5:
            r8 = null;
            goto L6
        }
    }

    static {
    }

    public final void onStart() {
        if (this.b == false) goto L6;
        RxUtilKt.c(this.d.o6("gift_sort_info").subscribe(new b(this)), this.a);
        return;
    }

    public final void onStop() {
        this.a.clear();
    }

    public a(f1 r2, d01.a r3) {
        Intrinsics.checkNotNullParameter(r2, "giftListSortService");
        Intrinsics.checkNotNullParameter(r3, "seiService");
        this.c = r2;
        this.d = r3;
        this.a = new CompositeDisposable();
        this.b = ((Boolean) h.j0.getValue(null, h.a[60])).booleanValue();
    }
}

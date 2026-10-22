package com.bytedance.android.livesdk.gift.platform.format.service;

import ca0.w;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.scope.o;
import com.google.gson.Gson;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class FormatGiftListService implements o {
    public final Lazy a;
    public final List<w1> b;
    public final CompositeDisposable c;
    public final Gson d;
    public boolean e;
    public final i12.e f;
    public final com.bytedance.android.livesdk.revenue.service.room.c g;

    public final void onStart() {
    }

    public final void onStop() {
        this.c.dispose();
        this.c.clear();
    }

    public final void a(w r5) {
        if (((ArrayList) this.b).isEmpty() == true) goto L5;
        r5.b(this.b);
        return;
    L5:
        if (this.e == false) goto L7;
        r5.b(this.b);
        return;
    L7:
        this.e = true;
        this.c.add(Single.create(new d(this)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this, r5), new f(this, r5)));
    }

    public FormatGiftListService(i12.e r2, com.bytedance.android.livesdk.revenue.service.room.c r3) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "revRoomService");
        this.f = r2;
        this.g = r3;
        this.a = LazyKt.lazy(FormatGiftListService$addHeaderEnable$2.INSTANCE);
        this.b = new ArrayList();
        this.c = new CompositeDisposable();
        this.d = GsonHelper.get();
    }
}

package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import com.bytedance.android.live.base.model.user.IBaseUser;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements com.bytedance.android.scope.o {
    public final CompositeDisposable a;
    public String b;
    public final yz0.k c;

    public final void onStart() {
        a(this, null, null, "enter_room", 3);
    }

    public final void onStop() {
        this.a.dispose();
    }

    public d(yz0.k r2) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        this.c = r2;
        this.a = new CompositeDisposable();
    }

    public static void a(d r3, Function1 r4, Function0 r5, String r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r4 = null;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r5 = null;
    L9:
        if ((r7 & 4) == 0) goto L11;
        r6 = com.bytedance.android.livesdk.gift.model.e.FETCH_FROM_GIFT_PANEL;
    L11:
        r3.getClass();
        Intrinsics.checkNotNullParameter(r6, "scene");
        if (((Boolean) e.b.getValue(null, e.a[0])).booleanValue() == true) goto L15;
        if (r5 == null) goto L24;
        Unit r8 = (Unit) r5.invoke();
        return;
    L24:
        return;
    L15:
        IBaseUser r9 = r3.c.getRoom().getOwner();
        if (r9 == null) goto L21;
        String r0 = r9.getUserId();
        if (r0 == null) goto L21;
        Intrinsics.checkNotNullParameter(r9, "$this$secUidExt");
        r3.a.add(vh6.c.b(ds2.a.class).queryAnchorStickerStatus(r0, r9.getCastSecUid(), r6).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(r3, r4), new c(r5)));
        return;
    L21:
        if (r5 == null) goto L27;
        Unit r10 = (Unit) r5.invoke();
        return;
    }
}

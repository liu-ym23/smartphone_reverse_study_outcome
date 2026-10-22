package com.bytedance.android.livesdk.gift.grouplive.component;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.scope.o;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i implements o {
    public final PublishSubject<fa0.b> a;
    public final PropertyOwner<fa0.a> b;
    public final h c;
    public final yz0.k d;

    public final void onStart() {
        h r0 = this.c;
        r0.getClass();
        Intrinsics.checkNotNullParameter(this, "service");
        r0.b = this;
        PublishSubject<fa0.b> r1 = this.a;
        if (r1 == null) goto L8;
        Disposable r2 = r1.subscribe(new g(r0));
        if (r2 == null) goto L9;
        RxUtilKt.c(r2, r0.c);
        return;
    L9:
        return;
    }

    public final void onStop() {
        h r0 = this.c;
        r0.c.clear();
        r0.b = null;
    }

    public final void a(fa0.a r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        PropertyOwner<fa0.a> r1 = this.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "t");
        r1.a(r4);
        if (this.d.isAnchor() == false) goto L6;
        com.bytedance.android.livesdk.sharedpref.e<String> r2 = j.a;
        String r3 = this.d.getRoom().getIdStr();
        Intrinsics.checkNotNullParameter(r3, "roomId");
        Intrinsics.checkNotNullParameter(r4, "state");
        j.b.clear();
        JSONObject r0 = new JSONObject();
        r0.put("room_id", r3);
        r0.put("type", r4.getType());
        r0.put("payload", r4.c);
        com.bytedance.android.livesdk.sharedpref.e<String> r5 = j.a;
        String r6 = r0.toString();
        r5.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r5, r6);
        return;
    }

    public i(h r2, yz0.k r3) {
        Intrinsics.checkNotNullParameter(r2, "externalService");
        Intrinsics.checkNotNullParameter(r3, "roomDataService");
        this.c = r2;
        this.d = r3;
        this.a = PublishSubject.create();
        this.b = new PropertyOwner(new fa0.a(0));
    }
}

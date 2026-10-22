package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.DialogInterface;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.ToolbarBehaviorApi;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PaidLiveData;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PaidProductData;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i4 implements DialogInterface.OnClickListener {
    public final /* synthetic */ h4 a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ i4 a;
        public final /* synthetic */ DialogInterface b;

        public a(i4 r1, DialogInterface r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            com.bytedance.android.live.network.response.e r3 = (com.bytedance.android.live.network.response.e) r2;
            ALogger.i(this.a.a.a, "roomToolbar success");
            Room r4 = this.a.a.c;
            if (r4 == null) goto L9;
            PaidLiveData r5 = r4.getPaidLiveData();
            if (r5 == null) goto L9;
            PaidProductData r6 = r5.getPaidProductData();
            if (r6 == null) goto L9;
            r6.bringProductFlag = 1;
        L9:
            this.a.a.g();
            this.b.dismiss();
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ i4 a;

        public b(i4 r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            String r0 = this.a.a.a;
            ALogger.e(r0, "roomToolbar error", (Throwable) r3);
        }
    }

    public i4(h4 r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r4, int r5) {
        ToolbarBehaviorApi r6 = (ToolbarBehaviorApi) com.bytedance.android.live.network.c.b().e(ToolbarBehaviorApi.class);
        Room r0 = this.a.c;
        if (r0 == null) goto L5;
        long r1 = r0.id;
    L6:
        r6.roomToolbar(r1, 1, 1).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this, r4), new b(this));
        return;
    L5:
        r1 = 0;
        goto L6
    }
}

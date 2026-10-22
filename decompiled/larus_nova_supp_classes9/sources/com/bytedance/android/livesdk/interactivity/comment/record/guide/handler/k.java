package com.bytedance.android.livesdk.interactivity.comment.record.guide.handler;

import android.content.Context;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k<T> implements ObservableOnSubscribe {
    public final /* synthetic */ l a;
    public final /* synthetic */ String b;

    public static final class a implements jz.b {
        public final /* synthetic */ ObservableEmitter a;

        public a(ObservableEmitter r1) {
            this.a = r1;
        }
    }

    public k(l r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(ObservableEmitter<Boolean> r8) {
        Intrinsics.checkNotNullParameter(r8, "emmit");
        DataCenter r0 = this.a.a.b;
        User r1 = null;
        if (r0 == null) goto L5;
        Room r2 = z.o(r0);
    L6:
        IMiddlewareHostBusiness r3 = jc1.k.f(IMiddlewareHostBusiness.class);
        if (r3 == null) goto L18;
        Context r4 = this.a.b;
        jz.f r5 = new jz.f();
        String r6 = this.b;
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r5.c = r6;
        if (r2 == null) goto L11;
        r1 = r2.getOwner();
    L11:
        r5.a = r1;
        r5.b = 2;
        r5.f = r2;
        DataCenter r7 = this.a.a.b;
        boolean r9 = false;
        if (r7 != null) goto L14;
    L16:
        r5.g = r9;
        com.bytedance.android.livesdk.interactivity.comment.record.guide.n r10 = this.a.a;
        r5.h = r10.d;
        r5.i = r10.e;
        Unit r11 = Unit.INSTANCE;
        r3.publishVideo(r4, r5, new a(r8));
        return;
    L14:
        if (z.e(r7, false) != true) goto L16;
        r9 = true;
        goto L16
    L18:
        return;
    L5:
        r2 = null;
        goto L6
    }
}

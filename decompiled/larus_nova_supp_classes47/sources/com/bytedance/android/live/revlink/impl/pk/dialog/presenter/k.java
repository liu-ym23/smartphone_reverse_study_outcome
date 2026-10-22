package com.bytedance.android.live.revlink.impl.pk.dialog.presenter;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPkPrecisionMatchInviteContract$View;
import com.bytedance.android.live.revlink.impl.pk.dialog.fragment.InteractPkPrecisionMatchInviteFragment;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k extends x31.n {
    public Disposable d;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ k a;
        public final /* synthetic */ int b;
        public final /* synthetic */ long c;
        public final /* synthetic */ int d;
        public final /* synthetic */ String e;
        public final /* synthetic */ long f;

        public a(k r1, int r2, long r3, int r5, String r6, long r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }

        public final void accept(Object r12) {
            ExtraResponse r13 = (ExtraResponse) r12;
            InteractDialogPkPrecisionMatchInviteContract$View r14 = (InteractDialogPkPrecisionMatchInviteContract$View) this.a.c;
            if (r14 == null) goto L5;
            r14.ca0(this.b);
        L5:
            com.bytedance.android.live.revlink.impl.global.c r15 = com.bytedance.android.live.revlink.impl.global.b.k();
            if (r15 == null) goto L8;
            w31.e r16 = r15.getPrecisionMatchMonitor();
        L9:
            w31.e r0 = r16;
            if (r0 == null) goto L13;
            r0.a(this.b, this.c, this.d, this.e, this.f, null, "click");
            return;
        L13:
            return;
        L8:
            r16 = null;
            goto L9
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ k a;
        public final /* synthetic */ int b;
        public final /* synthetic */ long c;
        public final /* synthetic */ int d;
        public final /* synthetic */ String e;
        public final /* synthetic */ long f;

        public b(k r1, int r2, long r3, int r5, String r6, long r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }

        public final void accept(Object r12) {
            Throwable r8 = (Throwable) r12;
            this.a.d(r8);
            InteractDialogPkPrecisionMatchInviteContract$View r13 = (InteractDialogPkPrecisionMatchInviteContract$View) this.a.c;
            if (r13 == null) goto L5;
            r13.ba0(r8);
        L5:
            com.bytedance.android.live.revlink.impl.global.c r14 = com.bytedance.android.live.revlink.impl.global.b.k();
            if (r14 == null) goto L8;
            w31.e r15 = r14.getPrecisionMatchMonitor();
        L9:
            w31.e r0 = r15;
            if (r0 == null) goto L13;
            r0.a(this.b, this.c, this.d, this.e, this.f, r8, "click");
            return;
        L13:
            return;
        L8:
            r15 = null;
            goto L9
        }
    }

    public k(InteractPkPrecisionMatchInviteFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
    }

    public final void e(int r14, long r15, int r17, String r18, long r19) {
        Intrinsics.checkNotNullParameter(r18, "flexActivityId");
        Observable<ExtraResponse<Object, Extra>> r0 = r31.b.a(r31.a.a).a(r14, r15, r17, r18, r19);
        if (r0 == null) goto L8;
        ObservableSubscribeProxy r1 = (ObservableSubscribeProxy) r0.as(c());
        if (r1 == null) goto L9;
        r1.subscribe(new a(this, r14, r15, r17, r18, r19), new b(this, r14, r15, r17, r18, r19));
        return;
    L9:
        return;
    }
}

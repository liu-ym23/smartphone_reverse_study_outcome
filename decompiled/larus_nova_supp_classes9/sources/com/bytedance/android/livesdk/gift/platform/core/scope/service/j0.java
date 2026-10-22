package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import android.content.DialogInterface;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.topbar.GiftCommonHintView;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j0<T> implements ObservableOnSubscribe {
    public final /* synthetic */ GiftConfirmService a;
    public final /* synthetic */ long b;
    public final /* synthetic */ String c;
    public final /* synthetic */ HashSet d;
    public final /* synthetic */ String e;

    public static final class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ j0 a;
        public final /* synthetic */ ObservableEmitter b;

        public a(j0 r1, ObservableEmitter r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r3, int r4) {
            r3.dismiss();
            this.b.onNext(GiftConfirmService.ConfirmResult.CONFIRM);
            j0 r5 = this.a;
            r5.d.add(r5.e);
            HashSet r6 = this.a.d;
            KProperty[] r7 = ay1.b.a;
            Intrinsics.checkNotNullParameter(r6, "<set-?>");
            ay1.b.A0.setValue(null, ay1.b.a[93], r6);
        }
    }

    public static final class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ ObservableEmitter a;

        public b(ObservableEmitter r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
            this.a.onNext(GiftConfirmService.ConfirmResult.CANCEL);
        }
    }

    public static final class c implements DialogInterface.OnDismissListener {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r1) {
        }
    }

    public j0(GiftConfirmService r1, long r2, String r4, HashSet r5, String r6) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }

    public final void subscribe(ObservableEmitter<GiftConfirmService.ConfirmResult> r8) {
        Intrinsics.checkNotNullParameter(r8, "emitter");
        cs2.b r0 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.ui.d.class).yn(this.a.b, 6);
        GiftCommonHintView r1 = new GiftCommonHintView(this.a.b);
        r1.setTitle(com.bytedance.android.live.core.utils.s1.C(2131921142, new Object[]{String.valueOf(this.b), this.c}));
        r1.setSubTitle(com.bytedance.android.live.core.utils.s1.B(2131921141));
        GiftConfirmService r2 = this.a;
        r0.a.setContentView(r1);
        r0.a.a(0, 2131921140, new a(this, r8));
        r0.a.a(1, 2131921139, new b(r8));
        r0.a.setOnDismissListener(c.a);
        r2.a = r0.h();
    }
}

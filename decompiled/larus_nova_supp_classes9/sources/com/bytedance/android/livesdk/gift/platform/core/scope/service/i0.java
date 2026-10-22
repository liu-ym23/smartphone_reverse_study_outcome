package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.bdlocation.BuildConfig;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i0<T> implements ObservableOnSubscribe {
    public final /* synthetic */ GiftConfirmService a;
    public final /* synthetic */ com.bytedance.android.livesdk.gift.model.f0 b;
    public final /* synthetic */ u1 c;
    public final /* synthetic */ com.bytedance.android.livesdk.gift.model.h1 d;

    public static final class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ i0 a;
        public final /* synthetic */ ObservableEmitter b;

        public a(i0 r1, ObservableEmitter r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r7, int r8) {
            i0 r9 = this.a;
            r9.c.K0(2, r9.d.getId(), this.a.d.getBizType(), "cancel");
            r7.dismiss();
            this.b.onNext(GiftConfirmService.ConfirmResult.CANCEL);
        }
    }

    public static final class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ i0 a;
        public final /* synthetic */ ObservableEmitter b;

        public b(i0 r1, ObservableEmitter r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r7, int r8) {
            i0 r9 = this.a;
            r9.c.K0(2, r9.d.getId(), this.a.d.getBizType(), "confirm");
            i0 r10 = this.a;
            GiftConfirmService r0 = r10.a;
            com.bytedance.android.livesdk.gift.model.h1 r11 = r10.d;
            r0.getClass();
            com.bytedance.tools.kcp.spongepreference.runtime.a r1 = k0.b;
            KProperty[] r2 = k0.a;
            Set r3 = (Set) r1.getValue(null, r2[0]);
            String r13 = GiftConfirmService.c(r11);
            if (r3.contains(r13) == true) goto L5;
            r3.add(r13);
            Intrinsics.checkNotNullParameter(r3, "<set-?>");
            r1.setValue(null, r2[0], r3);
        L5:
            r7.dismiss();
            this.b.onNext(GiftConfirmService.ConfirmResult.CONFIRM);
        }
    }

    public i0(GiftConfirmService r1, com.bytedance.android.livesdk.gift.model.f0 r2, u1 r3, com.bytedance.android.livesdk.gift.model.h1 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void subscribe(ObservableEmitter<GiftConfirmService.ConfirmResult> r8) {
        Intrinsics.checkNotNullParameter(r8, "emitter");
        Context r0 = this.a.b;
        com.bytedance.android.livesdk.widget.x0.d r1 = new com.bytedance.android.livesdk.widget.x0.d();
        r1.b = r0;
        r1.a = 4;
        String r2 = this.b.a();
        a r3 = new a(this, r8);
        com.bytedance.android.livesdk.widget.x0.c[] r4 = r1.g;
        com.bytedance.android.livesdk.widget.x0.c r5 = r4[1];
        if (r5 != null) goto L5;
        r5 = new com.bytedance.android.livesdk.widget.x0.c();
        r4[1] = r5;
    L5:
        r5.a = r2;
        r5.b = r3;
        String r6 = this.b.b();
        b r7 = new b(this, r8);
        com.bytedance.android.livesdk.widget.x0.c[] r9 = r1.g;
        com.bytedance.android.livesdk.widget.x0.c r10 = r9[0];
        if (r10 != null) goto L8;
        r10 = new com.bytedance.android.livesdk.widget.x0.c();
        r9[0] = r10;
    L8:
        r10.a = r6;
        r10.b = r7;
        r1.c = this.b.e();
        r1.d = this.b.d();
        r1.l = false;
        com.bytedance.android.livesdk.widget.x0 r11 = new com.bytedance.android.livesdk.widget.x0(r1.b, r1);
        if (DialogLancet.shouldBlockDialogShow(r11) == false) goto L16;
        DialogLancet.handleBlockedDialogShow(r11);
    L13:
        this.c.K0(1, this.d.getId(), this.d.getBizType(), BuildConfig.FLAVOR);
        return;
    L16:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L12:
        DialogLancet.beforeDialogShow(r11);
        r11.show();
        DialogLancet.afterDialogShow(r11);
        goto L13
    }
}

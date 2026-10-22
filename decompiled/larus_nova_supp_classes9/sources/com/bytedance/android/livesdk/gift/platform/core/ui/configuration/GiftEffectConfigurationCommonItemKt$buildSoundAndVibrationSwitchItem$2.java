package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"showCloseEffectConfirmDialog", BuildConfig.FLAVOR, "onResult", "Lkotlin/Function1;", BuildConfig.FLAVOR, "invoke"}, k = 3, mv = {1, 4, 3})
public final class GiftEffectConfigurationCommonItemKt$buildSoundAndVibrationSwitchItem$2 extends Lambda implements Function1<Function1<? super Boolean, ? extends Unit>, Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $isAnchor;

    public static final class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ Function1 a;

        public a(Function1 r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r2, int r3) {
            this.a.invoke(Boolean.TRUE);
            r2.dismiss();
        }
    }

    public static final class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ Function1 a;

        public b(Function1 r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r2, int r3) {
            this.a.invoke(Boolean.FALSE);
            r2.dismiss();
        }
    }

    public static final class c implements DialogInterface.OnCancelListener {
        public final /* synthetic */ Function1 a;

        public c(Function1 r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r2) {
            this.a.invoke(Boolean.FALSE);
        }
    }

    public GiftEffectConfigurationCommonItemKt$buildSoundAndVibrationSwitchItem$2(Context r1, boolean r2) {
        this.$context = r1;
        this.$isAnchor = r2;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Function1) r1);
        return Unit.INSTANCE;
    }

    public final void invoke(Function1<? super Boolean, Unit> r6) {
        Intrinsics.checkNotNullParameter(r6, "onResult");
        Context r0 = this.$context;
        x0.d r1 = new x0.d();
        r1.b = r0;
        r1.a = 0;
        r1.a = 4;
        if (this.$isAnchor == false) goto L5;
        String r2 = com.bytedance.android.livesdk.gift.platform.core.h.j().b();
    L6:
        r1.d = r2;
        a r3 = new a(r6);
        x0.c[] r4 = r1.g;
        x0.c r5 = r4[0];
        if (r5 != null) goto L9;
        r5 = new x0.c();
        r4[0] = r5;
    L9:
        r5.a = "确认关闭";
        r5.b = r3;
        b r7 = new b(r6);
        x0.c[] r8 = r1.g;
        x0.c r9 = r8[1];
        if (r9 != null) goto L12;
        r9 = new x0.c();
        r8[1] = r9;
    L12:
        r9.a = "取消";
        r9.b = r7;
        r1.h = new c(r6);
        if (this.$isAnchor == true) goto L15;
        r1.c = com.bytedance.android.livesdk.gift.platform.core.h.j().c();
    L15:
        x0.b.g(new x0(r1.b, r1));
        return;
    L5:
        r2 = com.bytedance.android.livesdk.gift.platform.core.h.j().a();
        goto L6
    }
}

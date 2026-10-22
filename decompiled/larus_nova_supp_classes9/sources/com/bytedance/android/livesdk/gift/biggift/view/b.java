package com.bytedance.android.livesdk.gift.biggift.view;

import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.core.model.b0;
import com.bytedance.android.livesdk.gift.platform.core.model.t;
import com.bytedance.android.scope.m;
import i12.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements CustomGiftHintDialog.a {
    public final /* synthetic */ CustomGiftView a;
    public final /* synthetic */ BigGiftComboDialog b;

    @Override // com.bytedance.android.livesdk.gift.biggift.view.CustomGiftHintDialog.a
    public final void a() {
        this.b.d(BigGiftComboDialog.DismissType.NORMAL);
    }

    @Override // com.bytedance.android.livesdk.gift.biggift.view.CustomGiftHintDialog.a
    public final void b() {
        UtilityKotlinExtentionsKt.t(this.a);
        UtilityKotlinExtentionsKt.w(BigGiftComboDialog.a(this.b));
        View r0 = this.b.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mDummy");
    L5:
        UtilityKotlinExtentionsKt.w(r0);
        View r1 = this.b.c;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mComboTitle");
    L8:
        a1.l(r1, UtilityKotlinExtentionsKt.i(28));
        BigGiftComboDialog.b(this.b);
        StringBuilder r2 = new StringBuilder("confirm dialog continue send id");
        i12.e r3 = o.b();
        Long r4 = null;
        b0 r5 = null;
        if (r3 == null) goto L11;
        Object r6 = m.e.d(r3, GiftExtraRepo.class);
    L12:
        GiftExtraRepo r7 = (GiftExtraRepo) r6;
        if (r7 == null) goto L21;
        t r8 = this.b.v.a;
        if (r8 == null) goto L17;
        r5 = r8.i();
    L17:
        if (r5 == null) goto L19;
        long r9 = r5.b;
    L20:
        r4 = r7.s(r9);
        goto L21
    L19:
        r9 = 0;
    L21:
        r2.append(r4);
        jy0.b.d("CustomSpecialGiftEffects", r2.toString());
        this.b.v.a();
        return;
    L11:
        r6 = null;
        goto L12
    }

    public b(CustomGiftView r1, BigGiftComboDialog r2) {
        this.a = r1;
        this.b = r2;
    }
}

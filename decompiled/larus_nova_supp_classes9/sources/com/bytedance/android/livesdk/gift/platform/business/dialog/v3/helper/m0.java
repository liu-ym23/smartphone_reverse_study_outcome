package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import android.graphics.Bitmap;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.q3;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.GiftIconMaskView;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m0 {
    public static final a e = null;
    public vz1.e a;
    public Disposable b;
    public final rz1.b c;
    public final GiftIconMaskView d;

    public static final class a {
        public a() {
        }

        public static boolean a(vz1.e r11) {
            Intrinsics.checkNotNullParameter(r11, "iconModel");
            long r0 = r11.b;
            GiftContext r2 = com.bytedance.android.livesdk.gift.util.b.b();
            com.bytedance.android.livesdk.gift.model.g0 r3 = null;
            if (r2 == null) goto L9;
            com.bytedance.live.datacontext.m<GiftContext.a> r4 = r2.getLastSendGiftId();
            if (r4 == null) goto L9;
            GiftContext.a r5 = (GiftContext.a) r4.getValue();
            if (r5 == null) goto L9;
            Long r6 = Long.valueOf(r5.a);
        L11:
            if (r6 != null) goto L14;
        L15:
            if (r6 != null) goto L18;
        L20:
            boolean r1 = false;
        L21:
            if (r1 == false) goto L24;
            return false;
        L24:
            if (r11.e == false) goto L26;
            return false;
        L26:
            h1 r7 = r11.a;
            if (r7.getSweepLightCount() != 0) goto L29;
        L73:
            return false;
        L29:
            if (r7.isHasSweepLight() == true) goto L73;
            if (((HashSet) ay1.b.p.getValue(null, ay1.b.a[18])).contains(String.valueOf(r7.getId())) == false) goto L34;
            return false;
        L34:
            h1 r13 = r11.a;
            if (r13 == null) goto L62;
            i12.e r8 = i12.o.b();
            if (r8 == null) goto L40;
            Object r9 = com.bytedance.android.scope.m.e.d(r8, GiftExtraRepo.class);
        L41:
            GiftExtraRepo r10 = (GiftExtraRepo) r9;
            if (r10 == null) goto L44;
            r3 = r10.q(r13.getId());
        L44:
            if (r3 == null) goto L62;
            com.bytedance.android.livesdk.gift.model.k0 r14 = r13.getGiftPreviewInfo();
            if (r14 != null) goto L48;
        L50:
            boolean r15 = false;
        L52:
            if (r3.getSubscribeGiftPackInfo() == null) goto L58;
            q3 r16 = r3.getSubscribeGiftPackInfo();
            Intrinsics.checkNotNull(r16);
            if (r16.getRelatedGiftId() == 0) goto L58;
            if (r15 == false) goto L58;
        L61:
            boolean r17 = true;
        L63:
            if (r17 == false) goto L65;
            return false;
        L65:
            String r18 = ay1.b.l().get(String.valueOf(r7.getId()));
            if (r18 == null) goto L68;
            int r19 = CastIntegerProtector.parseInt(r18);
        L70:
            if (r19 < r7.getSweepLightCount()) goto L72;
            return false;
        L72:
            return true;
        L68:
            r19 = 0;
        L58:
            if (r3.getGiftBuffInfos().isEmpty() == true) goto L62;
            if (ay1.b.j().contains(String.valueOf(r13.getId())) == false) goto L62;
        L48:
            if (r14.getLockStatus() != com.bytedance.android.livesdk.gift.model.k0.UNLOCKED) goto L50;
            r15 = true;
            goto L52
        L40:
            r9 = null;
        L62:
            r17 = false;
            goto L63
        L18:
            if (r6.longValue() != r0) goto L20;
            r1 = true;
            goto L21
        L14:
            if (r6.longValue() == 0) goto L20;
        L9:
            r6 = null;
            goto L11
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ m0 a;
        public final /* synthetic */ Function0 b;

        public b(m0 r1, Function0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            rz1.b r0 = this.a.c;
            r0.a((Bitmap) r2);
            this.a.c.c(this.b);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ m0 a;

        public c(m0 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            this.a.d.setVisibility(8);
        }
    }

    static {
        e = new a();
    }

    public final void a(Function0<Unit> r3) {
        vz1.e r0 = this.a;
        if (r0 == null) goto L5;
        py.k r1 = r0.o;
    L6:
        this.b = a1.k(r1).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this, r3), new c(this));
        return;
    L5:
        r1 = null;
        goto L6
    }

    public m0(rz1.b r2, GiftIconMaskView r3) {
        Intrinsics.checkNotNullParameter(r2, "giftImageMaskHelper");
        Intrinsics.checkNotNullParameter(r3, "giftImageMaskView");
        this.c = r2;
        this.d = r3;
    }
}

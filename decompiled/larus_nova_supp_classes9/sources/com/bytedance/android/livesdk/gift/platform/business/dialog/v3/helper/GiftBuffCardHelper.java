package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.android.livesdk.gift.configmodel.v1;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.model.ImageType;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftBuffCardBusinessState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftBuffCardViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftDIYCardBusinessState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftDIYViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftListBusinessState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftVerticalState;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.e1;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import w20.u7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftBuffCardHelper {
    public static final Companion a = null;

    public static final class Companion {
        public Companion() {
        }

        public static vz1.i f(com.bytedance.android.livesdk.gift.model.n r14) {
            Intrinsics.checkNotNullParameter(r14, "card");
            if ((r14 instanceof sz1.a) == false) goto L57;
            sz1.a r0 = (sz1.a) r14;
            if (TextUtils.isEmpty(r0.getLocalIconBitmap()) == true) goto L57;
            byte[] r15 = Base64.decode(r0.getLocalIconBitmap(), 0);
            Bitmap r16 = BitmapFactory.decodeByteArray(r15, 0, r15.length);
            u7.a r1 = r0.getGiftCellFrame();
            if (r1 == null) goto L49;
            Float r2 = r1.c();
            if (r2 == null) goto L11;
            int r3 = (int) r2.floatValue();
        L12:
            if (r3 < 0) goto L17;
            Float r4 = r1.c();
            if (r4 == null) goto L17;
            int r5 = (int) r4.floatValue();
        L18:
            Float r6 = r1.d();
            if (r6 == null) goto L21;
            int r7 = (int) r6.floatValue();
        L22:
            if (r7 < 0) goto L27;
            Float r8 = r1.d();
            if (r8 == null) goto L27;
            int r9 = (int) r8.floatValue();
        L28:
            Float r10 = r1.b();
            if (r10 == null) goto L31;
            int r11 = (int) r10.floatValue();
        L33:
            if ((r11 + r5) > r16.getWidth()) goto L49;
            Float r13 = r1.a();
            if (r13 == null) goto L37;
            int r17 = (int) r13.floatValue();
        L39:
            if ((r17 + r9) > r16.getHeight()) goto L49;
            Float r18 = r1.b();
            if (r18 == null) goto L43;
            int r19 = (int) r18.floatValue();
        L44:
            Float r20 = r1.a();
            if (r20 == null) goto L47;
            int r21 = (int) r20.floatValue();
        L48:
            Bitmap r23 = Bitmap.createBitmap(r16, r5, r9, r19, r21, null, false);
        L50:
            ImageType r24 = ImageType.BitMap;
            if (r23 != null) goto L53;
            Bitmap r25 = r16;
        L55:
            return new vz1.i(r24, null, null, r25, 6);
        L53:
            r25 = r23;
            goto L55
        L47:
            r21 = 0;
            goto L48
        L43:
            r19 = 0;
            goto L44
        L37:
            r17 = 0;
            goto L39
        L31:
            r11 = 0;
        L27:
            r9 = 0;
            goto L28
        L21:
            r7 = 0;
        L17:
            r5 = 0;
            goto L18
        L11:
            r3 = 0;
        L49:
            r23 = null;
        L57:
            if (r14.getGiftCellIcon() == null) goto L67;
            py.k r26 = r14.getDynamicGiftIcon();
            if (r26 == null) goto L65;
            if (r26.isValid() != true) goto L65;
            return new vz1.i(ImageType.DynamicImage, r14.getGiftCellIcon(), r14.getDynamicGiftIcon(), null, 8);
        L65:
            return new vz1.i(ImageType.ImageModel, r14.getGiftCellIcon(), null, null, 12);
        L67:
            return new vz1.i(null, null, null, null, 15);
        }

        public static boolean a(com.bytedance.android.livesdk.gift.model.n r3, com.bytedance.android.livesdk.gift.model.n r4) {
            if (r3 != null) goto L5;
            return false;
        L5:
            if (r4 != null) goto L8;
            return false;
        L8:
            if (gz1.c.h(gz1.c.g(r3), gz1.c.g(r4)) == false) goto L10;
            return true;
        L10:
            if (TextUtils.isEmpty(r3.getCardName()) == false) goto L12;
        L16:
            return false;
        L12:
            if (TextUtils.isEmpty(r4.getCardName()) == true) goto L16;
            if (TextUtils.equals(r3.getCardName(), r4.getCardName()) == false) goto L16;
            return true;
        }

        public static vz1.i d(py.k r7, py.k r8) {
            if (r8 == null) goto L5;
            ImageType r0 = ImageType.DynamicImage;
        L7:
            return new vz1.i(r0, r7, r8, null, 8);
        L5:
            r0 = ImageType.ImageModel;
            goto L7
        }

        public static p0 e(com.bytedance.android.anya.j0 r7, GiftVerticalState r8) {
            Intrinsics.checkNotNullParameter(r7, "$this$getDIYInfo");
            Intrinsics.checkNotNullParameter(r8, "verticalState");
            com.bytedance.android.anya.internal.p r9 = r7.getContext();
            com.bytedance.android.anya.internal.p.b r10 = r9.a(r9.b(r9.c(GiftPanelState.class), GiftBuffCardHelper$Companion$getDIYInfo$1$tmp$1.INSTANCE), GiftBuffCardHelper$Companion$getDIYInfo$1$tmp$2.INSTANCE);
            boolean r0 = false;
            Object r1 = 0;
            com.bytedance.android.anya.internal.c r11 = (com.bytedance.android.anya.v) r10.a.invoke();
            if (r11 == null) goto L27;
            com.bytedance.android.anya.internal.c r2 = r11;
            Object r3 = r11.c();     // Catch: Throwable -> L23
            int r4 = r11.c;     // Catch: Throwable -> L23
            Object r5 = ((LinkedHashMap) r7.d).get(r11);     // Catch: Throwable -> L23
            if (r5 == null) goto L11;
            r1 = r5;
        L11:
            if (r4 <= ((Number) r1).intValue()) goto L13;
            r0 = true;
        L13:
            com.bytedance.android.anya.k0<GiftDIYViewState, ?> r6 = com.bytedance.android.anya.j0.a.a;     // Catch: Throwable -> L23
            r6.getClass();     // Catch: Throwable -> L23
            com.bytedance.android.anya.r r13 = ((GiftDIYViewState) r3).toBusinessState(r6);     // Catch: Throwable -> L23
            if ((r13 instanceof GiftDIYCardBusinessState.DIYSelected) == false) goto L18;
            com.bytedance.android.livesdk.gift.model.n r14 = (com.bytedance.android.livesdk.gift.model.n) com.bytedance.android.anya.h.b(((GiftDIYCardBusinessState.DIYSelected) r13).getDiyCard().getDiyCardInfo());     // Catch: Throwable -> L23
            Companion r15 = GiftBuffCardHelper.a;     // Catch: Throwable -> L23
            com.bytedance.android.livesdk.gift.model.n r16 = (com.bytedance.android.livesdk.gift.model.n) com.bytedance.android.anya.h.b(((GiftDIYCardBusinessState.DIYSelected) r13).getDiyCard().getDiyCardInfo());     // Catch: Throwable -> L23
            r15.getClass();     // Catch: Throwable -> L23
            p0 r17 = new p0(r14, f(r16), ((GiftDIYCardBusinessState.DIYSelected) r13).getOriginId());     // Catch: Throwable -> L23
            r7.c.put(r11, Integer.valueOf(r2.c));
            return r17;
        L18:
            if (r0 == false) goto L20;
            r7.a();     // Catch: Throwable -> L23
        L20:
            r7.c.put(r11, Integer.valueOf(r2.c));
            return null;
        L23:
            th = move-exception;
            r7.c.put(r11, Integer.valueOf(r2.c));
            throw th;
        L27:
            return null;
        }

        public static h1 g(com.bytedance.android.anya.j0.a r1, GiftVerticalState r2) {
            Intrinsics.checkNotNullParameter(r1, "$this$getSelectedGift");
            Intrinsics.checkNotNullParameter(r2, "verticalState");
            com.bytedance.android.anya.r r3 = r2.toBusinessState(r1);
            if ((r3 instanceof GiftListBusinessState.GiftSelected) == false) goto L7;
            vz1.e r4 = ((GiftListBusinessState.GiftSelected) r3).getIconModel();
            if (r4 == null) goto L7;
            return r4.a;
        L7:
            return null;
        }

        public static o0 h(l1 r8, h1 r9) {
            if (r8 != null) goto L5;
            return null;
        L5:
            h2 r0 = GiftManagerKt.l(r8.getBuffGiftId());
            if (r0 == null) goto L9;
            py.k r1 = r0.getImage();
            if (r1 == null) goto L9;
        L10:
            py.k r3 = r1;
            py.k r4 = r8.getDynamicGiftIcon();
            if (r9 == null) goto L13;
            long r2 = r9.getId();
        L15:
            return new o0(r8, r3, r4, r2);
        L13:
            r2 = 0;
        L9:
            r1 = (py.k) vh7.f.c(py.k.class);
            goto L10
        }

        public static p0 i(com.bytedance.android.livesdk.gift.model.n r4, h1 r5) {
            if (r4 != null) goto L5;
            return null;
        L5:
            vz1.i r1 = f(r4);
            if (r5 == null) goto L8;
            long r2 = r5.getId();
        L10:
            return new p0(r4, r1, r2);
        L8:
            r2 = 0;
            goto L10
        }

        public static Pair b(int r0, py.k r1, py.k r2) {
            return TuplesKt.to(Integer.valueOf(r0), d(r1, r2));
        }

        public static o0 c(com.bytedance.android.anya.j0 r11, e1 r13, GiftVerticalState r14) {
            Intrinsics.checkNotNullParameter(r11, "$this$getBuffInfo");
            Intrinsics.checkNotNullParameter(r13, "giftListService");
            Intrinsics.checkNotNullParameter(r14, "verticalState");
            com.bytedance.android.anya.internal.p r15 = r11.getContext();
            com.bytedance.android.anya.internal.p.b r16 = r15.a(r15.b(r15.c(GiftPanelState.class), GiftBuffCardHelper$Companion$getBuffInfo$1$tmp$1.INSTANCE), GiftBuffCardHelper$Companion$getBuffInfo$1$tmp$2.INSTANCE);
            boolean r0 = false;
            Object r1 = 0;
            com.bytedance.android.anya.internal.c r17 = (com.bytedance.android.anya.v) r16.a.invoke();
            if (r17 == null) goto L38;
            com.bytedance.android.anya.internal.c r2 = r17;
            Object r3 = r17.c();     // Catch: Throwable -> L34
            int r4 = r17.c;     // Catch: Throwable -> L34
            Object r5 = ((LinkedHashMap) r11.d).get(r17);     // Catch: Throwable -> L34
            if (r5 == null) goto L11;
            r1 = r5;
        L11:
            if (r4 <= ((Number) r1).intValue()) goto L13;
            r0 = true;
        L13:
            com.bytedance.android.anya.k0<GiftBuffCardViewState, ?> r6 = com.bytedance.android.anya.j0.a.a;     // Catch: Throwable -> L34
            r6.getClass();     // Catch: Throwable -> L34
            com.bytedance.android.anya.r r7 = ((GiftBuffCardViewState) r3).toBusinessState(r6);     // Catch: Throwable -> L34
            if ((r7 instanceof GiftBuffCardBusinessState.BuffSelected) == false) goto L29;
            h2 r8 = GiftManagerKt.l(((l1) com.bytedance.android.anya.h.b(((GiftBuffCardBusinessState.BuffSelected) r7).getBuffCard().getBuffInfo())).getBuffGiftId());     // Catch: Throwable -> L34
            l1 r9 = (l1) com.bytedance.android.anya.h.b(((GiftBuffCardBusinessState.BuffSelected) r7).getBuffCard().getBuffInfo());     // Catch: Throwable -> L34
            if (r8 == null) goto L21;
            py.k r10 = r8.getImage();     // Catch: Throwable -> L34
            if (r10 == null) goto L21;
        L20:
            py.k r18 = r10;
            py.k r19 = ((l1) com.bytedance.android.anya.h.b(((GiftBuffCardBusinessState.BuffSelected) r7).getBuffCard().getBuffInfo())).getDynamicGiftIcon();     // Catch: Throwable -> L34
            GiftBuffCardHelper.a.getClass();     // Catch: Throwable -> L34
            h1 r110 = g(r6, r14);     // Catch: Throwable -> L34
            if (r110 == null) goto L25;
            long r20 = r110.getId();     // Catch: Throwable -> L34
        L26:
            o0 r111 = new o0(r9, r18, r19, r20);     // Catch: Throwable -> L34
            r11.c.put(r17, Integer.valueOf(r2.c));
            return r111;
        L25:
            r20 = 0;
        L21:
            r10 = (py.k) vh7.f.c(py.k.class);     // Catch: Throwable -> L34
            goto L20
        L29:
            if (r0 == false) goto L31;
            r11.a();     // Catch: Throwable -> L34
        L31:
            r11.c.put(r17, Integer.valueOf(r2.c));
            return null;
        L34:
            th = move-exception;
            r11.c.put(r17, Integer.valueOf(r2.c));
            throw th;
        L38:
            return null;
        }

        public static boolean j(l1 r6, h1 r7, boolean r8, com.bytedance.android.livesdk.gift.platform.core.giftlist.i r9, e1 r10) {
            Intrinsics.checkNotNullParameter(r6, "buffInfo");
            Intrinsics.checkNotNullParameter(r7, "originGift");
            Intrinsics.checkNotNullParameter(r9, "giftListRepository");
            Intrinsics.checkNotNullParameter(r10, "giftListService");
            if (r8 == false) goto L17;
            Intrinsics.checkNotNullParameter(r6, "buffInfo");
            Intrinsics.checkNotNullParameter(r7, "originGift");
            h2 r11 = GiftManagerKt.l(r6.getBuffGiftId());
            if (r11 != null) goto L8;
        L15:
            return false;
        L8:
            if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.i(r11.getPrimaryEffectId()) == false) goto L11;
            return true;
        L11:
            if (com.bytedance.android.livesdk.gift.platform.core.a0.c() == false) goto L13;
            return true;
        L13:
            if (com.bytedance.android.livesdk.gift.platform.business.i.m().getEnable() == false) goto L15;
            return true;
        L17:
            long r13 = r6.getBuffGiftId();
            h1 r14 = GiftManagerKt.a;
            Intrinsics.checkNotNullParameter(r10, "giftListService");
            Intrinsics.checkNotNullParameter(r9, "giftListRepository");
            h1 r15 = null;
            if (r13 <= 0) goto L21;
            r15 = r9.o4(r13, null);
        L21:
            if (r15 != null) goto L23;
            return false;
        L23:
            GiftPanelBizBoostUtils.E.getClass();
            if (((Boolean) GiftPanelBizBoostUtils.v.getValue()).booleanValue() == false) goto L26;
        L32:
            return true;
        L26:
            if (((v1) GiftPanelBizBoostUtils.w.getValue()).getEnable() == true) goto L32;
            if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.i(r15.getPrimaryEffectId()) == false) goto L31;
            return true;
        L31:
            return false;
        }
    }

    static {
        a = new Companion();
    }
}

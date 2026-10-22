package com.bytedance.android.livesdk.gift.platform.core.utils;

import android.text.SpannableString;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.message.i5;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profit.dress.api.OpenAssetPlayErrorType;
import com.bytedance.android.livesdk.gift.effect.model.EffectMessage;
import com.bytedance.android.livesdk.gift.model.f1;
import com.bytedance.android.livesdk.gift.model.g1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdk.gift.model.q2;
import com.bytedance.android.livesdk.gift.model.r3;
import com.bytedance.android.livesdk.gift.model.s3;
import com.bytedance.android.livesdk.gift.model.t3;
import com.bytedance.android.livesdk.gift.model.y1;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.AssetsService;
import com.bytedance.android.livesdk.message.model.i6;
import com.bytedance.android.livesdk.message.model.k6;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdk.message.model.qj;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final o7 a(o7 r4) {
        Intrinsics.checkNotNullParameter(r4, "originMessage");
        o7 r0 = vh7.f.c(o7.class);
        m0 r1 = vh7.f.c(m0.class);
        m0 r2 = r4.getCommonData();
        if (r2 == null) goto L5;
        long r3 = r2.getRoomId();
    L6:
        r1.setRoomId(r3);
        r1.setMessageId(r4.getMessageId());
        r1.setShowMsg(true);
        m0 r5 = r4.getCommonData();
        if (r5 == null) goto L10;
        String r6 = r5.getDescribe();
        if (r6 == null) goto L10;
    L11:
        r1.setDescribe(r6);
        m0 r7 = r4.getCommonData();
        if (r7 == null) goto L14;
        a5 r8 = r7.getDisplayText();
    L15:
        r1.setDisplayText(r8);
        r0.setCommonData(r1);
        r0.setFromUser(r4.getFromUser());
        r0.setTrayDisplayText(r4.getTrayDisplayText());
        r0.setTrayInfo(r4.getTrayInfo());
        r0.setRepeatCount(r4.getRepeatCount());
        r0.setFanTicketCount(r4.getFanTicketCount());
        r0.setRoomFanTicketCount(r4.getRoomFanTicketCount());
        r0.setGiftId(r4.getGiftId());
        r0.setToUser(r4.getToUser());
        r0.setComboCount(r4.getComboCount());
        r0.setGroupCount(r4.getGroupCount());
        r0.setGroupId(r4.getGroupId());
        r0.setLocal(r4.isLocal());
        r0.setRepeatEnd(r4.getRepeatEnd());
        r0.setLogId(r4.getLogId());
        r0.setTraceId(r4.getTraceId());
        r0.setAssetEffectMixInfo(r4.getAssetEffectMixInfo());
        List r9 = r4.getToUserIdStrings();
        if (r9 != null) goto L18;
        r9 = new ArrayList();
    L18:
        r0.setToUserIdString(r9);
        r0.setSendGiftTime(r4.getSendGiftTime());
        r0.setForceDisplayEffects(r4.getForceDisplayEffects());
        r0.setGift(r4.getGift());
        r0.setClientGiftSource(r4.getClientGiftSource());
        r0.setCount(r4.getCount());
        r0.setAnchorGift(r4.getAnchorGift());
        r0.setSendTogetherInfo(r4.getSendTogetherInfo());
        r0.setExtraEffectInfo(r4.getExtraEffectInfo());
        r0.setMultiSendEffectLevel(r4.getMultiSendEffectLevel());
        r0.setSeriesGiftData(r4.getSeriesGiftData());
        r0.setDiyItemInfoList(r4.getDiyItemInfoList());
        return r0;
    L14:
        r8 = null;
    L10:
        r6 = BuildConfig.FLAVOR;
        goto L11
    L5:
        r3 = 0;
        goto L6
    }

    public static EffectMessage c(i6 r17) {
        s3 r2 = null;
        long r3 = 0;
        if (r17.getAssetId() != 0) goto L5;
        return null;
    L5:
        String r1 = ((AssetsService) com.bytedance.android.live.revenue.core.util.f.a(AssetsService.class)).H0(r17.getAssetId());
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L12
        if (StringUtils.isEmpty(r17.getTracking()) == true) goto L9;
        Map r4 = com.bytedance.android.live.revenue.common.q.a(new JSONObject(r17.getTracking()));     // Catch: Throwable -> L12
    L10:
        Object r5 = Result.constructor-impl(r4);     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r5) == false) goto L17;
        r5 = null;
    L17:
        Map r11 = (Map) r5;
        if (r11 == null) goto L50;
        String r6 = (String) r11.get("effect_source");
        if (r6 != null) goto L22;
    L49:
        return null;
    L22:
        if (Intrinsics.areEqual(r6, "livevip_package") == true) goto L24;
    L28:
        a5 r7 = r17.getText();
        Map r8 = r17.getTextPieceOverrides();
        m0 r9 = r17.getCommonData();
        if (r9 == null) goto L31;
        IBaseUser r10 = r9.getUser();
    L32:
        if (r10 == null) goto L48;
        if (r7 != null) goto L37;
        if (r8 == null) goto L48;
    L37:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.h.o.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[13])).booleanValue() == true) goto L39;
    L44:
        a5 r13 = r17.getText();
        if (r13 != null) goto L47;
        return null;
    L47:
        t3 r14 = new t3(r13, (int) r17.getTextWidth(), (int) r17.getTextHeight(), r10, r17.getFinishSelfSchema(), r11);
    L51:
        EffectMessage r15 = new EffectMessage();
        Long r16 = qj.a(r17);
        if (r16 == null) goto L54;
        r3 = r16.longValue();
    L54:
        r15.a = r3;
        List r18 = r17.getImageList();
        List r19 = r17.getTextList();
        Intrinsics.checkNotNullParameter(r18, "imageInfoList");
        Intrinsics.checkNotNullParameter(r19, "textInfoList");
        ArrayList r20 = new ArrayList();
        ArrayList r21 = new ArrayList();
        Iterator r23 = r18.iterator();
    L56:
        if (r23.hasNext() == false) goto L58;
        f1 r24 = (f1) r23.next();
        r20.add(new q2(r24.getPlaceholderKey(), r24.getMixImage()));
        goto L56
    L58:
        Iterator r25 = r19.iterator();
    L60:
        if (r25.hasNext() == false) goto L62;
        g1 r26 = (g1) r25.next();
        r21.add(new r3(r26.getPlaceholderKey(), r26.getContent(), Long.valueOf(r26.getFontSize()), r26.getFontColor()));
        goto L60
    L62:
        r15.q = new com.bytedance.android.livesdk.gift.model.a(r20, r21, r14, r2);
        r15.b = r17.getAssetId();
        ((HashMap) r15.B).putAll(r17.getMaps());
        r15.w = r17.isLocalExt();
        r15.d = r1;
        r15.z = r17.getCommonData();
        r15.L = 2;
        return r15;
    L39:
        if (r17.getDressId().length() <= 0) goto L41;
        boolean r27 = true;
    L42:
        if (r27 == false) goto L44;
        r2 = new s3(r17.getDressId(), r7, r8, r10, r17.getFinishSelfSchema(), r11);
        r14 = null;
        goto L51
    L41:
        r27 = false;
    L48:
        com.bytedance.android.live.revenue.core.util.f.a(yt0.a.class).getPrivilegeSlardarMonitor().e(r17.getDressId(), 0, OpenAssetPlayErrorType.SomeIsNull, "user=" + r10 + ", textValues=" + r8 + ", fullText=" + r7);
        goto L49
    L31:
        r10 = null;
        goto L32
    L24:
        if (g02.a.e() == true) goto L28;
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.g.k.getValue(null, com.bytedance.android.livesdk.gift.platform.core.g.a[8])).booleanValue() == true) goto L28;
    L50:
        r14 = null;
        goto L51
    L9:
        r4 = null;
    L12:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    public static EffectMessage d(k6 r7) {
        Long r0 = qj.a(r7);
        ArrayList r1 = null;
        long r2 = 0;
        if (r0 != null) goto L6;
    L8:
        String r3 = ((AssetsService) com.bytedance.android.live.revenue.core.util.f.a(AssetsService.class)).H0(r7.getAssetId());
        new SpannableString(BuildConfig.FLAVOR);
        EffectMessage r4 = new EffectMessage();
        Long r5 = qj.a(r7);
        if (r5 == null) goto L11;
        r2 = r5.longValue();
    L11:
        r4.a = r2;
        r4.b = r7.getAssetId();
        r4.d = r3;
        r4.g = true;
        r4.h = r7.getToUser();
        r4.i = r7.getFromUser();
        r7.getShowMessage();
        ((HashMap) r4.B).putAll(r7.getMaps());
        r7.getShowPanel();
        r4.n = r7.getLogId();
        r4.w = r7.isLocalExt();
        r4.z = r7.getCommonData();
        r4.L = 1;
        List r6 = r7.getRequiredAssets();
        if (r6 == null) goto L17;
        List r8 = r6;
        r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r9 = r8.iterator();
    L15:
        if (r9.hasNext() == false) goto L17;
        r1.add(Long.valueOf(((Number) r9.next()).intValue()));
    L17:
        r4.M = r1;
        r4.s = r7.getDiyItemInfo();
        r4.N = r7.getScene();
        r4.O = true;
        return r4;
    L6:
        if (r0.longValue() != 0) goto L8;
        return null;
    }

    public static boolean g(EffectMessage r7) {
        Intrinsics.checkNotNullParameter(r7, "msg");
        int r0 = r7.v;
        if (r0 == 0) goto L5;
        return false;
    L5:
        r7.v = r0 + 1;
        if (u.e(r7) != null) goto L8;
        return false;
    L8:
        Map r1 = (Map) com.bytedance.android.livesdk.gift.platform.business.effect.a.C.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.a.a[27]);
        if (r1 != null) goto L11;
        return false;
    L11:
        Object r2 = r1.get(String.valueOf(r7.l));
        if (r2 == null) goto L22;
        double r3 = ((Double) r2).doubleValue();
        if (r3 != 0.0d) goto L16;
        return false;
    L16:
        long r4 = (long) r3;
        String r5 = ((AssetsService) com.bytedance.android.live.revenue.core.util.f.a(AssetsService.class)).H0(r4);
        if (TextUtils.isEmpty(r5) == false) goto L19;
        return false;
    L19:
        r7.b = r4;
        r7.d = r5;
        r7.g = true;
        return true;
    L22:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
    }

    public static boolean h(EffectMessage r6) {
        Intrinsics.checkNotNullParameter(r6, "msg");
        int r0 = r6.v;
        if (r0 == 0) goto L5;
        return false;
    L5:
        r6.v = r0 + 1;
        h2 r1 = GiftManagerKt.l(r6.l);
        if (r1 != null) goto L8;
        return false;
    L8:
        String r3 = ((AssetsService) com.bytedance.android.live.revenue.core.util.f.a(AssetsService.class)).H0(r1.getPrimaryEffectId());
        if (TextUtils.isEmpty(r3) == false) goto L11;
        return false;
    L11:
        r6.b = r1.getPrimaryEffectId();
        r6.d = r3;
        r6.g = true;
        return true;
    }

    public static EffectMessage b(NormalGiftMessage r13, IBaseUser r14) {
        String r0 = null;
        if (r13 == null) goto L5;
        o7 r1 = r13.r();
    L6:
        if (r1 != null) goto L8;
    L61:
        return null;
    L8:
        if (r1.getMessageId() == 0) goto L61;
        if (r1.getFromUser() == null) goto L61;
        h2 r2 = u.f(r1);
        if (r2 != null) goto L15;
        return null;
    L15:
        String r3 = ((AssetsService) com.bytedance.android.live.revenue.core.util.f.a(AssetsService.class)).H0(r2.getPrimaryEffectId());
        IBaseUser r6 = r1.getToUser();
        String r9 = BuildConfig.FLAVOR;
        if (r6 == null) goto L35;
        IBaseUser r7 = r1.getToUser();
        if (r7 == null) goto L24;
        String r8 = r7.getIdString();
        if (r8 == null) goto L24;
        Long r10 = StringsKt.toLongOrNull(r8);
        if (r10 == null) goto L24;
        long r11 = r10.longValue();
    L26:
        if (r11 <= 0) goto L35;
        if (r14 == null) goto L34;
        IBaseUser r4 = r1.getToUser();
        if (r4 == null) goto L32;
        r0 = r4.getIdString();
    L32:
        if (Intrinsics.areEqual(r0, r14.getIdString()) == true) goto L35;
    L34:
        int r15 = com.bytedance.android.live.revenue.common.f0.a;
        String r16 = s1.getResources().getString(2131917167, new Object[]{com.bytedance.android.live.revenue.common.f0.a(r1.getToUser(), g02.a.e())});
    L38:
        ArrayList r5 = new ArrayList();
        if (r1.getToUserIdStrings().isEmpty() == true) goto L41;
    L49:
        Iterator r17 = r1.getToUserIdStrings().iterator();
    L51:
        if (r17.hasNext() == false) goto L53;
        r5.add((String) r17.next());
    L53:
        EffectMessage r18 = new EffectMessage();
        r18.a = r1.getMessageId();
        r18.C = r1.getGift();
        r18.D = r1.getClientGiftSource();
        r18.b = r2.getPrimaryEffectId();
        r18.c = r2.getDiamondCount();
        r18.d = r3;
        r18.g = r1.isUrgent();
        r18.h = r1.getToUser();
        r18.i = r1.getFromUser();
        r18.j = r16;
        r18.k = r1.getTextEffect();
        r18.l = r2.getId();
        r18.m = r1.getRepeatCount();
        r18.n = r1.getLogId();
        r18.w = r1.isLocal();
        r18.o = r1.isBannedInEffect();
        r18.q = com.bytedance.android.livesdk.gift.model.b.a(r1.getAssetEffectMixInfo());
        r18.p = r1.getTrayInfo();
        r18.u = r2.getType();
        r18.r = r1.getInteractGiftInfo();
        ((HashMap) r18.B).putAll(r1.getMaps());
        r18.s = r1.getDiyItemInfoList();
        r18.t = r1.getAnchorGift();
        r18.x = r1.getSendGiftTime();
        r18.y = r1.getTraceId();
        r18.A = r5;
        r18.z = r1.getCommonData();
        r18.E = r1.getSendTogetherInfo();
        r18.F = r1.getExtraEffectInfo();
        r18.P = r1.getSeriesGiftData();
        r18.G = r1.getMultiSendEffectLevel();
        IBaseUser r19 = r1.getFromUser();
        if (r19 == null) goto L58;
        py.d r110 = r19.getUserHonor();
        if (r110 == null) goto L58;
        int r111 = r110.getLevel();
    L59:
        r18.J = r111;
        r18.H = true;
        r18.K = r13.i;
        r18.L = 0;
        return r18;
    L58:
        r111 = 0;
        goto L59
    L41:
        if (r1.getToUser() == null) goto L49;
        IBaseUser r20 = r1.getToUser();
        if (r20 == null) goto L48;
        String r21 = r20.getIdString();
        if (r21 == null) goto L48;
        r9 = r21;
    L48:
        r5.add(r9);
    L24:
        r11 = 0;
    L35:
        r16 = r2.getDescribe();
        if (r16 != null) goto L38;
        r16 = BuildConfig.FLAVOR;
        goto L38
    L5:
        r1 = null;
        goto L6
    }

    public static am2.f0 f(p2 r19, long r20, long r23) {
        Intrinsics.checkNotNullParameter(r19, "result");
        h2 r7 = GiftManagerKt.l(r19.getGiftId());
        if (r7 == null) goto L5;
        int r0 = r7.getDiamondCount();
    L6:
        long r5 = r19.getGiftId();
        long r8 = r19.getPropId();
        l2 r10 = r19.getProp();
        r19.getSendType();
        return new am2.f0(r5, r7, r8, r10, r23, r23 * r20, r20, r0);
    L5:
        r0 = 0;
        goto L6
    }

    @JvmStatic
    public static final o7 e(long r5, p2 r7, IBaseUser r8, IBaseUser r9) {
        Intrinsics.checkNotNullParameter(r7, "result");
        o7 r0 = vh7.f.c(o7.class);
        m0 r1 = vh7.f.c(m0.class);
        r1.setRoomId(r5);
        r1.setMessageId(r7.getMsgId());
        r1.setShowMsg(true);
        r1.setDescribe(r7.getDescribe());
        r1.setDisplayText(r7.getDisplayText());
        r0.setCommonData(r1);
        a5 r6 = r7.getDisplayText();
        IBaseUser r2 = null;
        if (r6 == null) goto L32;
        List r10 = r6.getPieces();
        if (r10 == null) goto L32;
        if ((!r10.isEmpty()) == true) goto L10;
        r10 = null;
    L10:
        if (r10 == null) goto L32;
        Iterator r11 = r10.iterator();
    L13:
        if (r11.hasNext() == false) goto L32;
        c5 r3 = (c5) r11.next();
        i5 r4 = r3.getUserValue();
        if (r4 == null) goto L17;
        IBaseUser r13 = r4.getUser();
    L18:
        if (r13 == null) goto L13;
        i5 r14 = r3.getUserValue();
        if (r14 == null) goto L22;
        IBaseUser r15 = r14.getUser();
    L23:
        String r16 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b().getIdString();
        if (r15 == null) goto L26;
        String r17 = r15.getIdString();
    L28:
        if (Intrinsics.areEqual(r17, r16) == false) goto L13;
        i5 r18 = r3.getUserValue();
        if (r18 == null) goto L32;
        r2 = r18.getUser();
        goto L32
    L26:
        r17 = null;
        goto L28
    L22:
        r15 = null;
        goto L23
    L17:
        r13 = null;
    L32:
        if (r2 == null) goto L34;
        r0.setFromUser(r2);
    L37:
        List<y1> r19 = r7.getGifts();
        if (r19 != null) goto L40;
    L42:
        r0.setRepeatCount(r7.getRepeatCount());
        r0.setFanTicketCount(r7.getFanTicketCount());
        r0.setRoomFanTicketCount(r7.getRoomFanTicketCount());
        r0.setGiftId(r7.getGiftId());
        r0.setToUser(r8);
        r0.setComboCount(r7.getComboCount());
        r0.setGroupCount(r7.getGroupCount());
        r0.setGroupId(r7.getGroupId());
        r0.setLocal(true);
        r0.setLocalInsertMsg(true);
        r0.setLogId(r7.getLogId());
        r0.setTraceId(r7.getTraceId());
        r0.setAssetEffectMixInfo(((y1) ListProtector.get(r7.getGifts(), 0)).getAssetEffectMixInfo());
        r0.setToUserIdString(r7.getToUserIds());
        r0.setSendGiftTime(r7.getSendGiftTime());
        r0.setForceDisplayEffects(r7.getForceDisplayEffects());
        r0.setGift(r7.getGift());
        r0.setClientGiftSource(r7.getClientGiftSource());
        r0.setCount(r7.getCount());
        r0.setAnchorGift(r7.getAnchorGift());
        r0.setSendTogetherInfo(r7.getSendTogetherInfo());
        r0.setExtraEffectInfo(r7.getExtraEffectInfo());
        r0.setMultiSendEffectLevel(r7.getMultiSendEffectLevel());
        r0.setSeriesGiftData(r7.getSeriesGiftData());
        return r0;
    L40:
        if (r19.isEmpty() == true) goto L42;
        r0.setTrayDisplayText(((y1) ListProtector.get(r19, 0)).getTrayDisplayText());
        r0.setTrayInfo(((y1) ListProtector.get(r19, 0)).getGiftTrayInfo());
        goto L42
    L34:
        if (r9 == null) goto L36;
        r0.setFromUser(r9);
        goto L37
    L36:
        r0.setFromUser(com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b());
        goto L37
    }
}

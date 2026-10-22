package s72;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.profit.fansclub.g;
import com.bytedance.android.live.profit.fansclub.o;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.service.settings.LiveRoomVisionDegradeConfigHelper;
import com.bytedance.android.livesdk.message.model.MemberMessage;
import com.bytedance.android.livesdk.message.model.va;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import gm2.q;
import java.util.Map;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d {
    public d() {
    }

    public static k32.a a(va r27, boolean r28) {
        String r0 = r27.getActionContent();
        r27.F0();
        IBaseUser r1 = r27.getUser();
        if (r1 == null) goto L5;
        String r3 = r1.getIdString();
        String r4 = q.a(r1, r28);
        r1.getLevel();
        k r5 = r1.getAvatarThumbKt();
        if (r5 != null) goto L9;
    L11:
        String r6 = BuildConfig.FLAVOR;
        k r8 = null;
    L13:
        if (r1.getUserHonor() != null) goto L15;
    L19:
        String r9 = BuildConfig.FLAVOR;
        int r10 = 0;
        k r11 = null;
    L20:
        int r13 = r27.e();
        if (r27.e() <= 100) goto L23;
        int r14 = r13 % 10;
        int r15 = (r13 / IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW) % 10;
    L24:
        o r7 = yt0.c.c();
        if (r7 != null) goto L27;
    L37:
        k r16 = null;
        int r17 = 0;
    L38:
        r27.getTimestamp();
        r27.getReceiveTime();
        r1.getGender();
        IMiddlewareUserService r2 = jc1.k.f(IMiddlewareUserService.class);
        if (r2 == null) goto L41;
        String r18 = r2.user().n();
    L42:
        k r29 = r16;
        long r19 = 0;
        if (r27.r() != null) goto L45;
        ALogger.i("MemberMessageAdapter", "effect config is null");
    L50:
        long r110 = 40000;
    L52:
        if (r27.r() != null) goto L54;
        ALogger.i("MemberMessageAdapter", "effect config is null");
    L57:
        long r23 = 0;
    L60:
        if (TextUtils.isEmpty(r18) == false) goto L62;
    L64:
        long r20 = r110;
        if (r27.getBaseMessage() == null) goto L67;
        r19 = r27.getBaseMessage().getMessageId();
    L67:
        long r25 = r19;
        MemberMessage.b r21 = r27.r();
        if (r21 != null) goto L70;
    L102:
        long r111 = r20;
    L103:
        k32.a r24 = new k32.a(r3, r4, r6);
        r24.f = r0;
        r24.d = r8;
        r24.e = r11;
        r24.g = r9;
        r24.h = r14;
        r24.i = r13;
        r24.j = r15;
        r24.m = r29;
        r24.k = r21;
        r24.o = r23;
        r24.s = r27.getBuriedPoint();
        r24.p = r111;
        r24.q = r25;
        r24.r = r27.isFromRtcRoom();
        return r24;
    L70:
        if (((rb2.b) LiveRoomVisionDegradeConfigHelper.a.getValue()).degradeEnterEffect == false) goto L102;
        r111 = r20;
        if (r21.getType() != 8) goto L103;
        if (r21.getExtra() == null) goto L103;
        Map r26 = r21.getExtra();
        rb2.a r30 = (rb2.a) LiveRoomVisionDegradeConfigHelper.b.getValue();
        String r31 = (String) r26.get("effect_source");
        if (TextUtils.equals(r31, "honor_level") == false) goto L90;
        if (r30.b() == null) goto L90;
        if (r10 < 25) goto L84;
        if (r10 >= 32) goto L84;
        String r33 = r30.b().get("25");
    L100:
        if (TextUtils.isEmpty(r33) == true) goto L103;
        r21.k(qy.a.a(r33));
    L84:
        if (r10 < 32) goto L87;
        if (r10 >= 61) goto L87;
        r33 = r30.b().get("32");
    L87:
        if (r10 < 61) goto L98;
        r33 = r30.b().get("61");
    L98:
        r33 = BuildConfig.FLAVOR;
    L90:
        if (TextUtils.equals(r31, "fansclub") == false) goto L98;
        if (r30.a() == null) goto L98;
        if (r17 != 10) goto L96;
        r33 = r30.a().get("10");
        goto L100
    L96:
        if (r10 <= 10) goto L98;
        r33 = r30.a().get("11");
        goto L100
    L62:
        if (TextUtils.equals(r3, r18) == false) goto L64;
        r110 = 90000;
        goto L64
    L54:
        long r210 = r27.r().o();
        if (r210 >= 0) goto L58;
        ALogger.i("MemberMessageAdapter", "valid time is negative");
        goto L57
    L58:
        r23 = r210;
        goto L60
    L45:
        r110 = r27.r().n();
        if (r110 >= 0) goto L48;
        ALogger.i("MemberMessageAdapter", "remote priority is negative");
        goto L50
    L48:
        if (r110 != 0) goto L52;
        ALogger.i("MemberMessageAdapter", "server did not dispatch remote priority");
        goto L50
    L41:
        r18 = BuildConfig.FLAVOR;
        goto L42
    L27:
        if (r7.P5(r1) == null) goto L37;
        g r34 = r7.P5(r1);
        com.bytedance.android.live.profit.fansclub.b r35 = r34.a;
        if (r35 != null) goto L31;
        r35 = r34.c;
    L31:
        if (r35 == null) goto L37;
        int r36 = r35.b;
        com.bytedance.android.live.profit.fansclub.a r112 = r35.d;
        if (r112 == null) goto L35;
        k r113 = r112.b;
    L36:
        r35.c.a.getValue();
        r17 = r36;
        r16 = r113;
        goto L38
    L35:
        r113 = null;
        goto L36
    L23:
        r14 = -1;
        r15 = 0;
        goto L24
    L15:
        if (r1.getUserHonor().getNewImIconWithLevel() == null) goto L19;
        if (Lists.isEmpty(r1.getUserHonor().getNewImIconWithLevel().getUrls()) == true) goto L19;
        r9 = (String) ListProtector.get(r1.getUserHonor().getNewImIconWithLevel().getUrls(), 0);
        r10 = r1.getUserHonor().getLevel();
        r11 = r1.getUserHonor().getNewImIconWithLevel();
        goto L20
    L9:
        if (CollectionUtils.isEmpty(r5.getUrls()) == true) goto L11;
        r6 = (String) ListProtector.get(r5.getUrls(), 0);
        r8 = r1.getAvatarThumbKt();
        goto L13
    L5:
        return new k32.a(BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR);
    }
}

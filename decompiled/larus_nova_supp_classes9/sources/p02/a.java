package p02;

import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.gift.configmodel.n1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.platform.business.b;
import com.bytedance.android.livesdk.gift.platform.business.e;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.message.model.k6;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public final boolean a;
    public final boolean b;

    public a() {
        this.a = ((fy1.a) e.d.getValue(null, e.a[2])).a();
        this.b = ((n1) b.z.getValue(null, b.a[24])).a();
    }

    public static com.bytedance.android.livesdk.gift.platform.business.tray.a b(k6 r9, IBaseUser r10) {
        String r0 = r9.getCommonData().getDescribe();
        if (r9.getToUser() != null) goto L5;
    L11:
        com.bytedance.android.livesdk.gift.platform.business.tray.a r1 = new com.bytedance.android.livesdk.gift.platform.business.tray.a(r9.getCommonData().getMessageId(), 0, false);
        r1.t = r9;
        NormalGiftMessage.GiftType r3 = NormalGiftMessage.GiftType.normal;
        if (r9.getFromUser() == null) goto L14;
        String r4 = GsonProtectorUtils.toJson(GsonHelper.get(), r9.getFromUser());
    L15:
        r1.r = r4;
        r1.c = r0;
        r1.f = r10;
        r1.e = r9.getFromUser();
        r1.v = false;
        r1.P = r9.isRtcRoomMessage();
        return r1;
    L14:
        r4 = BuildConfig.FLAVOR;
        goto L15
    L5:
        if (r9.getToUser().getIdString().isEmpty() == false) goto L11;
        if (r10 != null) goto L8;
    L10:
        r10 = r9.getToUser();
        r0 = s1.getContext().getResources().getString(2131917167, new Object[]{r10.getNickName()});
        goto L11
    L8:
        if (r9.getToUser().getIdString().equals(r10.getIdString()) == false) goto L10;
        goto L10
    }

    public final NormalGiftMessage a(o7 r19, h2 r20, IBaseUser r21, boolean r23) {
        String r1 = r20.getDescribe();
        long r2 = r19.getComboCount();
        long r4 = r19.getGroupCount();
        String r7 = null;
        boolean r8 = true;
        if (r19.getRepeatEnd() == 1) goto L5;
        String r6 = null;
    L14:
        if (r7 != null) goto L16;
        r7 = BuildConfig.FLAVOR;
    L16:
        if (r6 != null) goto L19;
        r6 = BuildConfig.FLAVOR;
    L19:
        if (r19.getToUser() != null) goto L21;
    L27:
        String r9 = r1;
        IBaseUser r3 = r21;
    L28:
        long r13 = r19.getCommonData().getMessageId();
        r19.getGroupCount();
        NormalGiftMessage.GiftType r11 = NormalGiftMessage.GiftType.normal;
        ArrayList r14 = new ArrayList();
        if (r19.getToUserIdStrings().size() <= 0) goto L31;
        r14.addAll(r19.getToUserIdStrings());
    L33:
        if (r23 == false) goto L35;
        NormalGiftMessage r15 = new NormalGiftMessage(r13, r19.getGiftId());
    L36:
        r15.r = r7;
        r15.q = r6;
        if (r19.getRepeatEnd() == 1) goto L40;
        r8 = false;
    L40:
        r15.p = r8;
        r15.x(r2);
        r15.k = r4;
        r15.l = r19.getGroupId();
        r15.o = r20.getImage();
        r15.c = r9;
        r15.e = r19.getFromUser();
        r15.f = r3;
        r15.g = r20.getDiamondCount();
        r15.s = r20.getSpecialEffects();
        r15.t = r19;
        r15.d = r19.getTrayDisplayText();
        r15.v = r19.isLocal();
        r15.u = r19.getGiftIMPriority();
        r15.j = r19.getMaps();
        r15.w = r20;
        r15.C = r14;
        r15.G = r19.getSendGiftTime();
        r15.D = r19.getSendTogetherInfo();
        r15.E = r19.getExtraEffectInfo();
        if ((r15 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == true) goto L43;
        r15.I = r15.u();
    L43:
        r15.J = this.a;
        r15.F = r19.getSeriesGiftData();
        r15.P = r19.isRtcRoomMessage();
        return r15;
    L35:
        r15 = new com.bytedance.android.livesdk.gift.platform.business.tray.a(r13, r19.getGiftId(), true);
        goto L36
    L31:
        if (r3 == null) goto L33;
        r14.add(r3.getIdString());
        goto L33
    L21:
        if (TextUtils.isEmpty(r19.getToUser().getIdString()) == true) goto L27;
        if (r21 != null) goto L24;
    L26:
        r3 = r19.getToUser();
        r9 = s1.getContext().getResources().getString(2131917167, new Object[]{r3.getNickName()});
        goto L28
    L24:
        if (TextUtils.equals(r19.getToUser().getIdString(), r21.getIdString()) == false) goto L26;
    L5:
        if (this.b == true) goto L7;
        r7 = GsonProtectorUtils.toJson(GsonHelper.get(), r19.getFromUser());
    L7:
        r6 = r19.getCommonData().getDescribe();
        if (r6 == null) goto L14;
        String[] r10 = r6.split(":");
        if (r10.length <= 1) goto L14;
        r6 = r10[1];
        goto L14
    }
}

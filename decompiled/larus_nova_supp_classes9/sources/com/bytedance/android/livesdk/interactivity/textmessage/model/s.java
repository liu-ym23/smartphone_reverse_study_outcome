package com.bytedance.android.livesdk.interactivity.textmessage.model;

import android.text.Spannable;
import android.text.SpannableString;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.message.model.qa;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import java.util.Objects;
import zg1.q2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class s extends com.bytedance.android.livesdk.interactivity.api.entity.a<qa> {
    @Override // com.bytedance.android.livesdk.interactivity.api.entity.a
    public final void L() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.a
    public final void M() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.a
    public final void O() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.a, com.bytedance.android.livesdk.interactivity.api.entity.f
    public final String h() {
        return "#fe2c55";
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.a
    public final void K() {
        q2 r0 = new q2(1);
        r0.b = this.b;
        xs2.b.a().post(r0);
    }

    public final String P() {
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
        String r1 = null;
        if (r0 != null) goto L5;
    L7:
        IRoom r2 = null;
    L9:
        if (IRoom.Companion.isValid(r2) == false) goto L11;
        String r3 = r2.getOwner().getIdString();
    L13:
        if (this.b.getUser() != null) goto L15;
    L20:
        long r4 = this.b.getDiamondCount();
        int r5 = ((int) ((this.b.getSendTime() + (this.b.getDelayTime() * 1000)) - com.bytedance.android.livesdk.utils.ntp.e.a())) / IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW;
        String r6 = r3.b();
        if (r5 <= 0) goto L27;
        if (r5 >= 60) goto L29;
        return s1.C(2131922005, new Object[]{r1, Long.valueOf(r4), r6, this.b.getTitle(), Integer.valueOf(r5)});
    L29:
        return s1.C(2131922006, new Object[]{r1, Long.valueOf(r4), r6, this.b.getTitle(), Integer.valueOf(r5 / 60)});
    L27:
        return s1.C(2131922007, new Object[]{r1, Long.valueOf(r4), r6, this.b.getTitle()});
    L15:
        if (Objects.equals(this.b.getUser().getIdString(), r3) == false) goto L17;
        r1 = s1.B(2131914626);
        goto L20
    L17:
        r1 = this.b.getUser().getNickName();
        if (r1 != null) goto L20;
        r1 = BuildConfig.FLAVOR;
        goto L20
    L11:
        r3 = BuildConfig.FLAVOR;
        goto L13
    L5:
        if (r0.getRoomDataContext(null, 0).getRoom() == null) goto L7;
        r2 = (IRoom) r0.getRoomDataContext(null, 0).getRoom().getValue();
        goto L9
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final tb2.d w() {
        tb2.d r0 = new tb2.d();
        r0.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(P()));
        return r0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.a, com.bytedance.android.livesdk.interactivity.api.entity.f
    public final IBaseUser x() {
        return this.b.getUser();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final Spannable g() {
        com.bytedance.android.livesdk.log.j0.l().b("livesdk_packetcommentarea_show");
        return new SpannableString(P());
    }

    public s(qa r1) {
        super(r1);
    }
}

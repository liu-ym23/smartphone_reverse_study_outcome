package com.bytedance.android.live.liveinteract.voicechat.radio;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.voicechat.radio.context.RadioStageContext;
import com.bytedance.android.live.liveinteract.voicechat.subtitle.LinkmicSubtitleBusinessWidget;
import com.bytedance.android.live.liveinteract.voicechat.subtitle.LinkmicSubtitleStatus;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/radio/RadioSubtitleBusinessWidget;", "Lcom/bytedance/android/live/liveinteract/voicechat/subtitle/LinkmicSubtitleBusinessWidget;", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RadioSubtitleBusinessWidget extends LinkmicSubtitleBusinessWidget {
    public jk0.d z;

    @Override // com.bytedance.android.live.liveinteract.voicechat.subtitle.LinkmicSubtitleBusinessWidget
    public final boolean Kq() {
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.subtitle.LinkmicSubtitleBusinessWidget
    public final boolean hr() {
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.subtitle.LinkmicSubtitleBusinessWidget
    public final boolean yq() {
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.subtitle.LinkmicSubtitleBusinessWidget
    public final ArrayList<ILinkPlayerInfoBridge> Bq() {
        LinkPlayerInfo r0 = new LinkPlayerInfo();
        com.bytedance.live.datacontext.m r1 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r1 == null) goto L8;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L8;
        IBaseUser r3 = r2.getOwner();
        if (r3 == null) goto L8;
    L9:
        r0.setUser(r3);
        r0.setInteractId(tc0.c.h().f);
        r0.isEnlarged = true;
        ArrayList<ILinkPlayerInfoBridge> r4 = new ArrayList();
        r4.add(r0);
        return r4;
    L8:
        r3 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getUser();
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.subtitle.LinkmicSubtitleBusinessWidget
    public final void Mq() {
        jk0.d r0 = this.z;
        if (r0 == null) goto L6;
        r0.c();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.subtitle.LinkmicSubtitleBusinessWidget
    public final void Nq() {
        jk0.d r0 = this.z;
        if (r0 == null) goto L6;
        r0.e();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.subtitle.LinkmicSubtitleBusinessWidget
    public final void Pq() {
        jk0.d r0 = this.z;
        if (r0 == null) goto L6;
        r0.d();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.subtitle.LinkmicSubtitleBusinessWidget
    public final void Qq() {
        jk0.d r0 = this.z;
        if (r0 == null) goto L6;
        r0.f();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.subtitle.LinkmicSubtitleBusinessWidget
    public final void Rq() {
        jk0.d r0 = this.z;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.subtitle.LinkmicSubtitleBusinessWidget
    public final void Sq() {
        jk0.d r0 = this.z;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.subtitle.LinkmicSubtitleBusinessWidget
    public final void Wq() {
        jk0.d r0 = this.z;
        if (r0 == null) goto L10;
        a r1 = r0.g();
        if (r1 == null) goto L11;
        vb6.g r2 = r1.b;
        if (r2 == null) goto L12;
        r2.a1(this);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.subtitle.LinkmicSubtitleBusinessWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onCreate() {
        ALogger.i("RadioStageContainerWidget", "[RadioSubtitleBusinessWidget][AudioSubtitle] onCreate");
        this.h.put("radiolink_stage_is_insert", Boolean.TRUE);
        super.onCreate();
        Aq().getStatus().setValue(LinkmicSubtitleStatus.CHECK_IN);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.subtitle.LinkmicSubtitleBusinessWidget
    public final void xq() {
        jk0.d r0 = this.z;
        if (r0 == null) goto L10;
        a r1 = r0.g();
        if (r1 == null) goto L11;
        vb6.g r2 = r1.b;
        if (r2 == null) goto L12;
        r2.X0(this, true);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.subtitle.LinkmicSubtitleBusinessWidget
    public final boolean zq() {
        if (((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.subtitle.LinkmicSubtitleBusinessWidget
    public final Boolean Iq() {
        if (gh0.a.d() == false) goto L21;
        jk0.d r0 = this.z;
        if (r0 == null) goto L19;
        a r1 = r0.g();
        if (r1 == null) goto L19;
        vb6.g r2 = r1.b;
        if (r2 == null) goto L17;
        yb6.e r3 = r2.j();
        if (r3 == null) goto L17;
        yb6.n r4 = r3.K();
        if (r4 == null) goto L17;
        boolean r5 = true;
        if (r4.e != true) goto L17;
    L22:
        return Boolean.valueOf(r5);
    L17:
        r5 = false;
    L19:
        return null;
    L21:
        return Boolean.FALSE;
    }

    public RadioSubtitleBusinessWidget() {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.subtitle.LinkmicSubtitleBusinessWidget
    public final void Yq(JsonObject r2) {
        Intrinsics.checkNotNullParameter(r2, "extraObject");
        jk0.c r0 = RadioStageContext.Companion.a();
        if (r0 == null) goto L6;
        r0.il(r2);
        return;
    }
}

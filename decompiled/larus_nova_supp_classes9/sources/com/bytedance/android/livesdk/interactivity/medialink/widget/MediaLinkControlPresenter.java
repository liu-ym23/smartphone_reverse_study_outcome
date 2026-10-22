package com.bytedance.android.livesdk.interactivity.medialink.widget;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.live.user.api.IUserServiceV2;
import com.bytedance.android.live.user.api.UserSetting;
import com.bytedance.android.livesdk.chatroom.model.interact.LinkInitResult;
import com.bytedance.android.livesdk.chatroom.presenter.n;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.user.h;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.Single;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class MediaLinkControlPresenter extends n<IView> {
    public final Room e;
    public final boolean f;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/widget/MediaLinkControlPresenter$IView;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/IWidget;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface IView extends IWidget {
        void OF();

        /* synthetic */ Context getContext();
    }

    public final void g0() {
        StringBuilder r0 = new StringBuilder("room linkMap=");
        Room r1 = this.e;
        z5 r2 = null;
        if (r1 == null) goto L5;
        Map r3 = r1.getLinkMap();
    L6:
        r0.append(r3);
        r0.append(' ');
        Room r4 = this.e;
        if (r4 == null) goto L9;
        r2 = r4.getLinkerDetail();
    L9:
        r0.append(r2);
        ALogger.i("ttlive_link", r0.toString());
        Room r5 = this.e;
        if (r5 == null) goto L45;
        LinkInitResult r6 = r5.linkInitResult;
        if (r6 == null) goto L46;
        ALogger.e("ttlive_link", "attach initResult=" + r6.getLinkMicId() + " accessToken=" + r6.getAccessToken() + " initScene=" + r5.linkMicScene);
        if (TextUtils.isEmpty(r6.getAccessToken()) == false) goto L16;
        return;
    L16:
        if (r6.getLinkMicId() <= 0) goto L18;
    L19:
        ((n) this).c.put("data_voice_chat_room_shoot_way", "direct_shoot");
        tc0.c r7 = tc0.c.h();
        if (TextUtils.isEmpty(r6.getLinkMicIdStr()) == false) goto L22;
        r7.f = String.valueOf(r6.getLinkMicId());
        r7.e = String.valueOf(r6.getLinkMicId());
    L23:
        r7.j = r6.getVendor();
        r7.k = r6.getRtcExtInfo();
        r7.m = r6.getLiveCoreExtInfo();
        if (r6.getMultiLiveCoreInfo() == null) goto L27;
        r7.r = r6.getMultiLiveCoreInfo();
    L27:
        if (r6.getMultiRtcInfo() == null) goto L29;
        r7.n = r6.getMultiRtcInfo();
    L29:
        tc0.c.h().E = r6.isSupportVideo();
        hd0.c.f().k(2);
        if (UserSetting.b() == false) goto L36;
        IUserServiceV2 r8 = k.f(IUserServiceV2.class);
        if (r8 == null) goto L43;
        Single r9 = r8.updateCurrentUser(((n) this).c, "MediaLinkControlPresenter");
        if (r9 == null) goto L43;
        r9.subscribe(new h());
    L43:
        ((n) this).c.put("data_room_shoot_way_exact", "live_take_page");
        return;
    L36:
        IUserService r10 = k.f(IUserService.class);
        if (r10 == null) goto L43;
        com.bytedance.android.livesdk.user.f r11 = r10.user();
        if (r11 == null) goto L43;
        Single r13 = r11.j();
        if (r13 == null) goto L43;
        r13.subscribe(new h());
        goto L43
    L22:
        r7.e = r6.getLinkMicIdStr();
        r7.f = r6.getLinkMicIdStr();
        goto L23
    L18:
        if (TextUtils.isEmpty(r6.getLinkMicIdStr()) == false) goto L19;
        return;
    L46:
        return;
    L45:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final /* bridge */ /* synthetic */ void c0(IWidget r1) {
        IView r2 = (IView) r1;
        g0();
    }

    public MediaLinkControlPresenter(Room r1, boolean r2) {
        this.e = r1;
        this.f = r2;
    }
}

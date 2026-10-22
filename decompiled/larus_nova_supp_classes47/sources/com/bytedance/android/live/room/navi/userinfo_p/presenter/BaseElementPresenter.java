package com.bytedance.android.live.room.navi.userinfo_p.presenter;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.dsl.api.IDSLManagerService;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdk.user.j;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.forest.model.PreloadType;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Iterator;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vlc.l;
import yt1.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/presenter/BaseElementPresenter;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseElementPresenter implements l, Observer<KVData> {
    public final CompositeDisposable a;
    public final vlc.d b;
    public final boolean c;
    public final boolean d;
    public final m91.c e;

    public void onMessage(tlc.d r1) {
    }

    public final DataCenter a() {
        return this.e.getDataCenter();
    }

    public void e() {
        this.a.clear();
        vlc.d r0 = this.b;
        if (r0 == null) goto L5;
        r0.removeMessageListener(this);
    L5:
        DataCenter r1 = a();
        if (r1 == null) goto L9;
        r1.removeObserver(this);
        return;
    }

    public final IRoom b() {
        DataCenter r0 = a();
        if (r0 != null) goto L5;
        return null;
    L5:
        return (IRoom) r0.get("data_room", null);
    }

    public final boolean c() {
        if (a0.i(a()) == false) goto L5;
    L14:
        return true;
    L5:
        if (a0.f(a()) == true) goto L14;
        if (a0.h(a()) == true) goto L14;
        if (a0.g(a()) == true) goto L14;
        if (((IMiddlewareRoomService) k.n(IMiddlewareRoomService.class)).isNewFeedStyle(a()) == true) goto L14;
        return false;
    }

    public final boolean d() {
        if (g() == false) goto L5;
    L9:
        return false;
    L5:
        if (((IMiddlewareRoomService) k.n(IMiddlewareRoomService.class)).isNewFeedStyle(a()) == false) goto L7;
    L8:
        return true;
    L7:
        if (((IMiddlewareRoomService) k.n(IMiddlewareRoomService.class)).isNewStyleForTTLite(a()) == false) goto L9;
        goto L8
    }

    public final boolean g() {
        if (a0.i(a()) == false) goto L5;
    L12:
        return true;
    L5:
        if (a0.h(a()) == true) goto L12;
        if (a0.f(a()) == true) goto L12;
        if (a0.g(a()) == true) goto L12;
        return false;
    }

    public BaseElementPresenter(m91.c r3) {
        Intrinsics.checkNotNullParameter(r3, "userInfoAbility");
        this.e = r3;
        this.a = new CompositeDisposable();
        DataCenter r4 = a();
        vlc.d r0 = null;
        if (r4 == null) goto L5;
        r0 = (vlc.d) r4.get("data_message_manager", null);
    L5:
        this.b = r0;
        DataCenter r5 = a();
        if (r5 == null) goto L10;
        Boolean r6 = (Boolean) r5.get("data_is_anchor", Boolean.FALSE);
        if (r6 == null) goto L10;
        boolean r7 = r6.booleanValue();
    L11:
        this.c = r7;
        DataCenter r8 = a();
        if (r8 == null) goto L16;
        Boolean r9 = (Boolean) r8.get("data_is_portrait", Boolean.TRUE);
        if (r9 == null) goto L16;
        boolean r10 = r9.booleanValue();
    L17:
        this.d = r10;
        return;
    L16:
        r10 = true;
    L10:
        r7 = false;
        goto L11
    }

    public final void f(Map<String, String> r12) {
        IRoom r0 = b();
        if (r0 == null) goto L41;
        IBaseUser r1 = r0.getOwner();
        if (r1 == null) goto L46;
        UserProfileEvent r2 = new UserProfileEvent(r1.getIdString());
        r2.mSource = "anchor_profile";
        r2.setClickUserPosition("live_open_top_left_anchor");
        r2.setReportType("data_card_anchor");
        r2.setExtraFollowParams(j.b(LiveFollowScene.PROFILE_USER_INFO));
        if (r12 == null) goto L14;
        Iterator<Map.Entry<String, String>> r13 = r12.entrySet().iterator();
    L11:
        if (r13.hasNext() == false) goto L14;
        Map.Entry<String, String> r3 = r13.next();
        r2.addProfileClickUserExtraLog(r3.getKey(), r3.getValue());
    L14:
        if (r1.getBorder() == null) goto L24;
        py.f r14 = r1.getBorder();
        String r4 = null;
        if (r14 == null) goto L18;
        String r15 = r14.getDressId();
    L19:
        if (r15 == null) goto L24;
        py.f r16 = r1.getBorder();
        if (r16 == null) goto L23;
        r4 = r16.getDressId();
    L23:
        r2.wearId = r4;
        goto L24
    L18:
        r15 = null;
    L24:
        xs2.b.a().post(r2);
        ((IMiddlewareRoomService) k.n(IMiddlewareRoomService.class)).userInfoAutoAntiDeterioration();
        Integer r17 = (Integer) ev1.e.a.getValue();
        if (r17 != null) goto L28;
        return;
    L28:
        if (r17.intValue() != 2) goto L42;
        Integer r18 = (Integer) ev1.f.a.getValue();
        if (r18 != null) goto L33;
        return;
    L33:
        if (r18.intValue() != 1) goto L43;
        String r5 = ns0.d.a;
        q r19 = new q("shop_card_slice", r5);
        IDSLManagerService r6 = k.f(IDSLManagerService.class);
        if (r6 != null) goto L37;
        return;
    L37:
        if (r6.hasLocalGlobalCache(r19) == true) goto L45;
        ALogger.i("Live_LynxAir", "start preload.");
        int r110 = com.bytedance.android.anniex.api.b.a;
        Intrinsics.checkNotNullParameter(r5, "url");
        com.bytedance.ies.bullet.forest.f r111 = ForestLoader.a;
        ForestLoader.k(null, r5, false, null, PreloadType.LYNX, true, "AnnieX_card", null, 641);
        return;
    L45:
        return;
    L43:
        return;
    L42:
        return;
    L46:
        return;
    }

    public final /* bridge */ /* synthetic */ void onChanged(Object r1) {
        KVData r2 = (KVData) r1;
    }
}

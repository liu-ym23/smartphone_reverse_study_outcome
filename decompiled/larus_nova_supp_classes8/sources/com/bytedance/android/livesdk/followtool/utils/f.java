package com.bytedance.android.livesdk.followtool.utils;

import android.content.Context;
import android.net.Uri;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.core.utils.g2;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.config.LiveSettingKeys;
import com.bytedance.android.livesdk.config.rh1;
import com.bytedance.android.livesdk.coupon.CouponDialogWidget;
import com.bytedance.android.livesdk.followtool.api.RelationSyncHostFollow;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ Room a;
    public final /* synthetic */ Lifecycle b;
    public final /* synthetic */ CouponDialogWidget c;
    public final /* synthetic */ Context d;

    public f(Room r1, Lifecycle r2, CouponDialogWidget r3, Context r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r12) {
        Response r13 = (Response) r12;
        if (r13 == null) goto L86;
        Disposable r1 = XTFollowSyncUtils.a;
        Room r2 = this.a;
        Lifecycle r3 = this.b;
        CouponDialogWidget r4 = this.c;
        Uri r5 = null;
        if (r3.getCurrentState() != Lifecycle.State.RESUMED) goto L47;
        if (r4 == null) goto L10;
        Boolean r6 = r4.c;
    L11:
        if (r4 == null) goto L16;
        if (r6 == null) goto L47;
        if (Intrinsics.areEqual(r6, Boolean.TRUE) == true) goto L47;
    L16:
        com.bytedance.android.livesdk.f.d().getClass();
        if (com.bytedance.android.livesdk.f.e() == true) goto L47;
        if (r2.getRoomId() == XTFollowSyncUtils.b) goto L47;
        IUserService r7 = k.f(IUserService.class);
        if (r7 == null) goto L47;
        if (r7.user().isLogin() == false) goto L47;
        if (r2.isMatchRoom() == true) goto L47;
        if (r2.isMergeVSRoom() == true) goto L47;
        if (r2.isMediaRoom() == true) goto L47;
        RoomContext r8 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r8 == null) goto L41;
        m r9 = r8.isCleanMode();
        if (r9 == null) goto L41;
        if (((Boolean) r9.getValue()).booleanValue() == true) goto L47;
    L41:
        XTFollowSyncPrefs.m.getClass();
        g2.d r10 = XTFollowSyncPrefs.k;
        KProperty[] r11 = XTFollowSyncPrefs.c;
        int r14 = ((Number) r10.b(r11[7])).intValue();
        SettingKey<rh1> r15 = LiveSettingKeys.LIVE_STOCK_OF_FOLLOW_FREQ;
        if (r14 >= ((rh1) r15.getValue()).followFrequencyTotalCnt) goto L47;
        if (((Number) XTFollowSyncPrefs.l.b(r11[8])).intValue() >= ((rh1) r15.getValue()).followFrequencyWeekCnt) goto L47;
        boolean r16 = true;
    L48:
        if (r16 == true) goto L51;
        return;
    L51:
        if (((BaseResponse) r13).statusCode != 0) goto L83;
        Object r17 = ((BaseResponse) r13).data;
        if (r17 == null) goto L84;
        RelationSyncHostFollow r18 = (RelationSyncHostFollow) r17;
        Intrinsics.checkNotNull(r18);
        if (r18.getNeedFollowPopup() == false) goto L88;
        IBrowserService r19 = k.f(IBrowserService.class);
        if (r19 == null) goto L89;
        w30.a r20 = r19.getStorageProcessor(this.d);
        String r21 = "1";
        if (r18.getUserFollowScope() == false) goto L63;
        String r22 = "1";
    L65:
        if (r18.getUserFollowSwitch() == true) goto L68;
        r21 = "0";
    L68:
        r20.setStorage("user_follow_switch", r21);
        r20.setStorage("user_follow_scope", r22);
        r20.setStorage("host_user_infos", JsonUtil.toJSONString(r18.getUserInfos()));
        r5 = UriProtector.parse((String) LiveConfigSettingKeys.SAAS_STOCK_OF_FOLLOW_AUTH_RELATIONS_SCHEMA.getValue());     // Catch: Exception -> L71
    L72:
        if (r5 == null) goto L90;
        ALogger.i("XTFollowSyncUtils", "openUrl" + r5);
        ILiveService r110 = TTLiveService.getLiveService();
        if (r110 != null) goto L78;
        return;
    L78:
        if (r110.handleSchema(this.d, r5) == false) goto L85;
        Disposable r111 = XTFollowSyncUtils.a;
        XTFollowSyncUtils.b = this.a.getRoomId();
        XTFollowSyncPrefs.m.getClass();
        g2.d r112 = XTFollowSyncPrefs.k;
        KProperty[] r0 = XTFollowSyncPrefs.c;
        r112.c(r0[7], Integer.valueOf(((Number) r112.b(r0[7])).intValue() + 1));
        g2.e r113 = XTFollowSyncPrefs.l;
        r113.c(r0[8], Integer.valueOf(((Number) r113.b(r0[8])).intValue() + 1));
        return;
    L85:
        return;
    L90:
        return;
    L71:
        ALogger.e("XTFollowSyncUtils", "openUrl fail");
        goto L72
    L63:
        r22 = "0";
        goto L65
    L89:
        return;
    L88:
        return;
    L84:
        return;
    L83:
        return;
    L10:
        r6 = null;
    L47:
        r16 = false;
        goto L48
    }
}

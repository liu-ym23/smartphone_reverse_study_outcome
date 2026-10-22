package com.bytedance.android.livesdk.interactivity.impl.exitroom.controller;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.room.l;
import com.bytedance.android.livesdk.chatroom.utils.p0;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.config.LiveInitSettingKeys;
import com.bytedance.android.livesdk.config.b3;
import com.bytedance.android.livesdk.config.j61;
import com.bytedance.android.livesdk.interactivity.api.exitroom.ICloseInterceptorService;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.RankInfoList;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class QuitRoomGuideController implements m32.b {
    public volatile m32.a a;

    public static final class a {
    }

    static {
    }

    public QuitRoomGuideController() {
    }

    @Override // m32.b
    public final boolean a(Runnable r19, DataCenter r20, Context r21, Room r23, Bundle r24, boolean r25, l r26, final Function0<Unit> r27) {
        Intrinsics.checkNotNullParameter(r19, "afterInterceptRunnable");
        Intrinsics.checkNotNullParameter(r27, "drawerOpenFunc");
        if (r23 != null) goto L5;
    L7:
        List r5 = pg1.b.a;
        b3 r6 = LiveInitSettingKeys.get_LIVE_DRAWER_ENTRANCE_REDESIGN();
        if (r6 != null) goto L10;
        r6 = new b3();
    L10:
        int r7 = r6.a();
        if (r7 == 0) goto L16;
        if (r7 == 2) goto L16;
        if (r7 == 3) goto L16;
        boolean r8 = false;
    L17:
        if (r8 == true) goto L19;
        return false;
    L19:
        if (r23 != null) goto L21;
    L23:
        if (r23 == null) goto L25;
        boolean r9 = r23.isMergeVSRoom();
    L26:
        ALogger.i(ICloseInterceptorService.TAG_QUIT_DIALOG, "showRoomQuitDialog() >>> isDrawerEnable: " + p0.b(r23) + "\tisSlideUpShowing: " + r25 + "\tisVSRoom: " + r9);
        if (p0.b(r23) == false) goto L105;
        if (r25 == true) goto L105;
        ICloseInterceptorService r3 = (ICloseInterceptorService) k.f(ICloseInterceptorService.class);
        monitor-enter(this);
        IUser r11 = null;
        if (this.a == null) goto L36;
        m32.a r10 = this.a;     // Catch: Throwable -> L102
        monitor-exit(this);
    L42:
        if (((j61) LiveConfigSettingKeys.LIVE_NEW_REMAIN_DIALOG_CONFIG.getValue()).c() == false) goto L49;
        if (r3 == null) goto L49;
        if (r10 == null) goto L49;
        if (r9 == false) goto L47;
    L54:
        return false;
    L47:
        if (r3.showNewVerRoomQuitDialog(r21, r20, r19, r10, r26, new QuitRoomGuideController$showRoomQuitDialog$1(r27)) == false) goto L54;
        return true;
    L49:
        mp2.a r4 = new mp2.a(r21);
        e r13 = com.bytedance.android.livesdk.sharedpref.b.e0;
        if (TextUtils.equals((String) r13.getValue(), "true") == false) goto L52;
        boolean r14 = true;
    L53:
        if (r14 == true) goto L54;
        if (r26 == null) goto L57;
        r26.l();
    L57:
        SettingKey r15 = LiveInfraSettingKeys.LIVE_RANK_INFO_LIST;
        if (r15.getValue() != null) goto L60;
    L64:
        List r16 = Arrays.asList(new String[]{"https://p1-webcast-dycdn.byteimg.com/img/webcast/6690142627768568584~tplv-resize:400:400.jpeg", "https://p3-dy.byteimg.com/aweme/1080x1080/24023000230ca9e85dd48.jpeg", "https://p9-dy.byteimg.com/aweme/720x720/1cb25000672c8dded103b.jpeg", "https://p9-dy.byteimg.com/aweme/720x720/2ce9d0006872c3f3d5886.jpeg", "https://p3-dy.byteimg.com/aweme/720x720/2409f0005bf8faaa4e78b.jpeg"});
    L65:
        if (r16 != null) goto L67;
    L85:
        r4.h.setVisibility(0);
    L86:
        r4.setCancelable(true);
        r4.setCanceledOnTouchOutside(true);
        if (DialogLancet.shouldBlockDialogShow(r4) == false) goto L108;
        DialogLancet.handleBlockedDialogShow(r4);
    L91:
        r4.f.setOnClickListener(new com.bytedance.android.livesdk.interactivity.impl.exitroom.controller.a(r4, r19));
        b r0 = new b(r27, r4, r23);
        r4.g.setOnClickListener(r0);
        r4.a.setOnClickListener(r0);
        if (r23 == null) goto L94;
        r11 = r23.author();
    L94:
        if (r11 == null) goto L113;
        HashMap r1 = new HashMap();
        r1.put("room_id", String.valueOf(r23.id));
        IUser r2 = r23.author();
        if (r2 == null) goto L99;
        String r17 = r2.getUserId();
        if (r17 == null) goto L99;
    L100:
        r1.put("anchor_id", r17);
        u.l().sendLog("livesdk_exit_room_pop_show", r1, new Object[0]);
        return true;
    L99:
        r17 = BuildConfig.FLAVOR;
        goto L100
    L113:
        return true;
    L108:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L106
    L90:
        DialogLancet.beforeDialogShow(r4);
        r4.show();
        DialogLancet.afterDialogShow(r4);
        goto L91
    L67:
        if (r16.size() <= 2) goto L86;
        int r18 = r16.size() - 1;
        int r110 = (r18 + 0) + 1;
        if (r18 < 0) goto L81;
        if (3 > r110) goto L81;
        if (r18 <= 2) goto L81;
        int[] r28 = new int[r110];
        int r111 = 0;
    L76:
        if (r111 >= (0 + r110)) goto L78;
        r28[r111 + 0] = r111;
        r111 = r111 + 1;
        goto L76
    L78:
        int[] r112 = new int[3];
        Random r113 = new Random();
        int r114 = 0;
    L79:
        if (r114 >= 3) goto L82;
        int r115 = r110 - 1;
        int r116 = Math.abs(r113.nextInt() % r110);
        r112[r114] = r28[r116];
        r28[r116] = r28[r115];
        r114 = r114 + 1;
        r110 = r115;
    L82:
        if (r112 == null) goto L86;
        ImageLoader.bindImage(r4.b, (String) ListProtector.get(r16, r112[0]));
        ImageLoader.bindImage(r4.c, (String) ListProtector.get(r16, r112[1]));
        ImageLoader.bindImage(r4.d, (String) ListProtector.get(r16, r112[2]));
    L81:
        r112 = null;
        goto L82
    L60:
        if (((RankInfoList) r15.getValue()).getMoreAnchorUrls() == null) goto L64;
        if (((RankInfoList) r15.getValue()).getMoreAnchorUrls().size() <= 0) goto L64;
        r16 = ((RankInfoList) r15.getValue()).getMoreAnchorUrls();
        goto L65
    L52:
        f.d(r13, "true");
        r14 = false;
        goto L53
    L36:
        ICloseInterceptorService r29 = (ICloseInterceptorService) k.f(ICloseInterceptorService.class);     // Catch: Throwable -> L102
        if (r29 != null) goto L39;
        r10 = null;
    L40:
        monitor-exit(this);
        goto L42
    L39:
        this.a = r29.createNewQuitRoomShowInterceptor();     // Catch: Throwable -> L102
        r10 = this.a;     // Catch: Throwable -> L102
    L102:
        th = move-exception;
        throw th;
    L105:
        return false;
    L25:
        r9 = false;
        goto L26
    L21:
        if (r23.isMediaRoom() != true) goto L23;
        return false;
    L16:
        r8 = true;
        goto L17
    L5:
        if (r23.isMatchRoom() != true) goto L7;
        return false;
    }
}

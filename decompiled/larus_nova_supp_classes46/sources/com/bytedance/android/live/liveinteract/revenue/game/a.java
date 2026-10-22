package com.bytedance.android.live.liveinteract.revenue.game;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.wrds.LinkWRDSHelper;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.wrds.LinkMicRoomDataSyncModel;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public e a;
    public final CompositeDisposable b;
    public Long c;
    public final ne0.c d;
    public final boolean e;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.revenue.game.a$a, reason: collision with other inner class name */
    public static final class C0082a {
    }

    static {
    }

    public final String b() {
        Long r0 = this.c;
        oi0.a.C0247a r1 = oi0.a.a;
        r1.getClass();
        if (r0 != null) goto L6;
    L8:
        r1.getClass();
        if (r0 != null) goto L12;
    L14:
        return null;
    L12:
        if (r0.longValue() != 1) goto L14;
        return "seat_expand";
    L6:
        if (r0.longValue() != 2) goto L8;
        return "seat_collapse";
    }

    public final boolean c() {
        ne0.g r0 = this.d.a();
        if (r0 == null) goto L5;
        int r1 = ti0.e.a;
        Boolean r2 = (Boolean) r0.a("danmu_game_is_on");
    L7:
        return Intrinsics.areEqual(r2, Boolean.TRUE);
    L5:
        r2 = null;
        goto L7
    }

    public final void a(boolean r15) {
        long r1 = 0;
        long r3 = 0L;
        String r5 = "";
        if (c() == true) goto L59;
        if (r15 == false) goto L59;
        if (this.e == true) goto L68;
        ALogger.d("DanmuGameController", "startObserveMicSeatStatus");
        this.c = 0L;
        e r0 = this.a;
        if (r0 == null) goto L51;
        long r7 = r0.h;
        long r12 = 15;
        if (r7 != r12) goto L51;
        int r2 = r0.i;
        long r8 = 1;
        if (r2 != 0) goto L14;
        Room r4 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        String r10 = null;
        if (r4 == null) goto L24;
        z5 r6 = r4.getLinkerDetail();
        if (r6 == null) goto L24;
        Integer r9 = Integer.valueOf(r6.getUiLayout());
    L25:
        Room r13 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        if (r13 == null) goto L30;
        z5 r14 = r13.getLinkerDetail();
        if (r14 == null) goto L30;
        r10 = r14.getClientUiInfo();
    L30:
        if (r9 != null) goto L33;
    L41:
        this.c = r3;
    L42:
        LinkMicRoomDataSyncModel r11 = LinkWRDSHelper.b();
        if (r11 == null) goto L51;
        dc2.c r16 = r11.getTalkRoomListUserInfoPb();
        if (r16 == null) goto L51;
        Observable r17 = r16.d;
        if (r17 == null) goto L51;
        Disposable r18 = r17.subscribe(new b(this));
        if (r18 == null) goto L51;
        RxUtilKt.c(r18, this.b);
        goto L51
    L33:
        if (r9.intValue() != 15) goto L41;
        r1 = JSONObjectProtectorUtils.getLong(JSONObjectProtectorUtils.getJSONObject(new JSONObject(r10), "video_chat_dynamic_1v7"), "Status");     // Catch: Exception -> L36
    L37:
        oi0.a.a.getClass();
        if (r1 != 2) goto L40;
        r8 = 2;
    L40:
        r3 = Long.valueOf(r8);
    L36:
        ALogger.e("DanmuGameController", "startObserveMicSeatStatus, parse clientUiInfo failed");
    L24:
        r9 = null;
        goto L25
    L14:
        if (r2 != 1) goto L42;
        if (r7 != r12) goto L18;
        oi0.a.a.getClass();
        r3 = 1L;
    L18:
        this.c = r3;
    L51:
        ALogger.i("DanmuGameController", "danmu game start: " + this.a);
        LinkedHashMap r19 = new LinkedHashMap();
        e r20 = this.a;
        if (r20 == null) goto L57;
        String r21 = r20.b;
        if (r21 == null) goto L57;
        r5 = r21;
    L57:
        r19.put("game_id", r5);
        TalkRoomLogUtils.O(b(), 31, r19, false, 17);
        String r22 = qi0.a.a;
        qi0.a.h = System.currentTimeMillis();
    L68:
        ne0.c r23 = this.d;
        int r24 = ti0.e.a;
        r23.b("danmu_game_is_on", Boolean.valueOf(r15));
        return;
    L59:
        if (c() == false) goto L68;
        if (r15 == true) goto L68;
        ALogger.i("DanmuGameController", "danmu game end: " + this.a);
        LinkedHashMap r25 = new LinkedHashMap();
        e r26 = this.a;
        if (r26 == null) goto L67;
        String r27 = r26.b;
        if (r27 == null) goto L67;
        r5 = r27;
    L67:
        r25.put("game_id", r5);
        TalkRoomLogUtils.N(b(), 31, r25, 0, 17);
        String r28 = qi0.c.b;
        qi0.c.m(this.a);
        ALogger.d("DanmuGameController", "stopObserveMicSeatStatus");
        this.c = 0L;
        this.b.clear();
        goto L68
    }

    public a(Context r2, ne0.c r3, DataCenter r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "mStore");
        Intrinsics.checkNotNullParameter(r4, "mDataCenter");
        this.d = r3;
        this.e = r5;
        this.b = new CompositeDisposable();
        this.c = 0L;
    }
}

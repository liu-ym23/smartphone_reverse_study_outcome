package com.bytedance.android.livesdk.followtool.utils;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.g2;
import com.bytedance.android.live.core.utils.z0;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.config.LiveSettingKeys;
import com.bytedance.android.livesdk.followtool.api.RelationSyncSwitch;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d<T, R> implements Function {
    public final /* synthetic */ Context a;

    public d(Context r1) {
        this.a = r1;
    }

    public final Object apply(Object r12) {
        h80.c r13 = (h80.c) r12;
        Intrinsics.checkNotNullParameter(r13, "it");
        RelationSyncSwitch r14 = (RelationSyncSwitch) z0.b(r13);
        if (((Boolean) LiveSettingKeys.LIVE_STOCK_OF_FOLLOW_SHOW.getValue()).booleanValue() == false) goto L6;
        if (r14 == null) goto L8;
        Boolean r0 = Boolean.valueOf(r14.getAnchorLiveSync());
    L9:
        boolean r1 = false;
        if (r0 == null) goto L12;
        boolean r2 = r0.booleanValue();
    L13:
        if (r14 == null) goto L48;
        if (r2 == true) goto L17;
    L42:
        if (r2 == false) goto L47;
        if (r14.getFollowerSync() == false) goto L47;
        return Observable.just(Boolean.TRUE);
    L47:
        return Observable.just(Boolean.FALSE);
    L17:
        if (r14.getFollowerSync() == true) goto L42;
        Disposable r3 = XTFollowSyncUtils.a;
        XTFollowSyncPrefs r4 = XTFollowSyncPrefs.m;
        r4.getClass();
        g2.b r5 = XTFollowSyncPrefs.j;
        KProperty[] r6 = XTFollowSyncPrefs.c;
        if (((Number) r5.b(r6[6])).intValue() >= 1) goto L21;
        XTFollowSyncPrefs.g.c(r6[3], 0);
        XTFollowSyncPrefs.h.c(r6[4], 0);
        XTFollowSyncPrefs.i.c(r6[5], 0);
        r5.c(r6[6], 1);
    L21:
        ALogger.d("XTFollowSyncUtils", "canShowFollowDialog today:" + r4.d() + " total:" + r4.e());
        if (XTFollowSyncUtils.c() == true) goto L35;
        long r7 = XTFollowSyncUtils.b;
        IRoomService r8 = k.f(IRoomService.class);
        if (r8 == null) goto L32;
        Room r9 = r8.getCurrentRoom();
        if (r9 == null) goto L32;
        if (r7 != r9.getRoomId()) goto L32;
    L36:
        if (r1 == false) goto L42;
        Context r10 = this.a;
        if (r14.getFollowerScope() == false) goto L40;
        String r15 = "api";
    L49:
        return XTFollowSyncUtils.b(r10, "watch", r15);
    L40:
        r15 = "scope";
    L32:
        if (r4.d() >= 1) goto L36;
        if (r4.e() >= 5) goto L36;
    L35:
        r1 = true;
        goto L36
    L48:
        return Observable.just(Boolean.FALSE);
    L12:
        r2 = false;
    L8:
        r0 = null;
        goto L9
    L6:
        if (r14 == null) goto L8;
        r0 = Boolean.valueOf(r14.getFollowedSync());
        goto L9
    }
}

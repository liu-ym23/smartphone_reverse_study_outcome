package com.bytedance.android.live.room.report;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.api.userinfo.event.ReportConstant$BusinessSource;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.common.utility.NetworkUtils;
import io.reactivex.Observable;
import ita.i;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public static boolean e() {
        IUserService r0 = k.f(IUserService.class);
        if (r0 == null) goto L10;
        com.bytedance.android.livesdk.user.f r1 = r0.user();
        if (r1 == null) goto L10;
        if (r1.isLogin() != true) goto L10;
        return true;
    L10:
        ReportTracer.f("current user isn't login");
        Bundle r2 = new Bundle();
        IUserService r3 = k.f(IUserService.class);
        if (r3 == null) goto L19;
        com.bytedance.android.livesdk.user.f r4 = r3.user();
        if (r4 == null) goto L20;
        Activity r5 = com.bytedance.android.live.core.utils.a.d();
        l.a r6 = new l.a();
        r6.a = s1.B(2131915990);
        r6.c = -1;
        r6.e = "live_detail";
        r6.g = "user_report";
        r6.d = "popup";
        r6.h = r2;
        Observable r7 = r4.login(r5, new l(r6));
        if (r7 == null) goto L21;
        r7.subscribe(new b());
        return false;
    L21:
        return false;
    L20:
        return false;
    L19:
        return false;
    }

    public static boolean f() {
        Activity r0 = com.bytedance.android.live.core.utils.a.d();
        int r1 = i.a;
        if (NetworkUtils.isNetworkAvailable(r0) == true) goto L6;
        f2.b(2131920669, 0);
        int r2 = d.a;
        Intrinsics.checkNotNullParameter("network is unavailable", Constants.OperatorKey.MSG);
        ALogger.i("ReportServiceTrack", "network is unavailable");
        ReportTracer.f("network is unavailable");
        return false;
    L6:
        return true;
    }

    static {
    }

    public static boolean a(IBaseUser r5) {
        if (r5 != null) goto L4;
        d.a("targetUser is null");
        ReportTracer.f("targetUser is null");
    L17:
        return false;
    L4:
        String r0 = r5.getIdString();
        if (r0 == null) goto L7;
        Long r1 = StringsKt.toLongOrNull(r0);
    L8:
        if (r1 != null) goto L11;
    L18:
        return true;
    L11:
        if (r1.longValue() != 0) goto L18;
        Intrinsics.checkNotNullParameter(r5, "$this$secUidExt");
        if (d(r5.getCastSecUid()) == false) goto L18;
        if (d(r5.getWebcastUid()) == false) goto L18;
        d.a("targetUser id is null, or targetUser secUid is 0");
        ReportTracer.f("targetUser id is null, or targetUser secUid is 0");
        goto L17
    L7:
        r1 = null;
        goto L8
    }

    public static boolean b(IRoom r5) {
        if (r5 != null) goto L4;
    L20:
        d.a("room is null, or room id is 0");
        ReportTracer.f("room is null, or room id is 0");
    L21:
        return false;
    L4:
        if (r5.getId() == 0) goto L20;
        Long r0 = StringsKt.toLongOrNull(r5.getOwnerUserIdString());
        if (r0 != null) goto L10;
    L11:
        IBaseUser r6 = r5.getOwner();
        if (r6 == null) goto L14;
        Intrinsics.checkNotNullParameter(r6, "$this$secUidExt");
        String r7 = r6.getCastSecUid();
    L16:
        if (d(r7) == true) goto L19;
        return true;
    L19:
        d.a("room ownerUserId is 0, or room owner secUid is empty");
        ReportTracer.f("room ownerUserId is 0, or room owner secUid is empty");
        goto L21
    L14:
        r7 = null;
        goto L16
    L10:
        if (r0.longValue() == 0) goto L19;
        goto L11
    }

    public static boolean d(String r0) {
        if (r0 != null) goto L5;
    L6:
        return true;
    L5:
        if (TextUtils.isEmpty(r0) == true) goto L6;
        return false;
    }

    public static boolean c(ReportConstant$BusinessSource r1, IBaseUser r2, IRoom r3) {
        Intrinsics.checkNotNullParameter(r1, "businessSource");
        Map<String, String> r4 = ReportTracer.a;
        ReportTracer.b(ReportTracer.EventName.params_check);
        if (f() == true) goto L5;
        return false;
    L5:
        if (e() == true) goto L8;
        return false;
    L8:
        if (a(r2) == true) goto L10;
        return false;
    L10:
        if (b(r3) == false) goto L16;
        return true;
    L16:
        return false;
    }
}

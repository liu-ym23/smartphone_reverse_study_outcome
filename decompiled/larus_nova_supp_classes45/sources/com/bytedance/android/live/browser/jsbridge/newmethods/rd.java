package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.service.IVSReportService;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.abs.IRoomData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class rd extends q<da, ea> {
    public final Activity a;
    public final DataCenter b;

    public final Activity getActivity() {
        return this.a;
    }

    public rd(Activity r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.a = r2;
        this.b = r3;
    }

    public final void invoke(Object r13, CallContext r14) {
        da r15 = (da) r13;
        Intrinsics.checkNotNullParameter(r15, "params");
        Intrinsics.checkNotNullParameter(r14, "context");
        Activity r3 = this.a;
        if (r3 == null) goto L34;
        DataCenter r16 = this.b;
        Room r0 = com.bytedance.android.live.core.utils.z.a;
        Intrinsics.checkNotNullParameter(r16, "$this$vsCompatRoom");
        IRoomData r2 = com.bytedance.android.live.core.utils.z.q(r16);
        if (r2 == null) goto L33;
        String r1 = r15.e();
        if (r1 != null) goto L9;
        String r5 = "-1";
    L10:
        String r6 = r15.c();
        String r4 = r15.a();
        if (r4 == null) goto L13;
        long r7 = CastLongProtector.parseLong(r4);
    L14:
        Integer r8 = r15.getType();
        if (r8 == null) goto L17;
        int r9 = r8.intValue();
    L18:
        zg1.u r17 = new zg1.u(r5, r6, r7, r9, null);
        String r11 = r15.e();
        if (r11 != null) goto L21;
        r11 = "-1";
    L21:
        UserProfileEvent r12 = new UserProfileEvent(r11);
        r12.mSource = r15.g();
        r12.forceNoRotate = true;
        r12.requestPage = r15.f();
        r12.reportType = r15.b();
        r12.mCommentReportModel = r17;
        User r18 = new User();
        String r19 = r15.e();
        if (r19 != null) goto L24;
        r19 = "0";
    L24:
        r18.setIdStr(r19);
        String r110 = r15.d();
        Intrinsics.checkNotNull(r110);
        r18.setCastSecUid(r110);
        IVSReportService r111 = (IVSReportService) jc1.k.n(IVSReportService.class);
        String r112 = r15.e();
        if (r112 != null) goto L27;
        String r21 = "-1";
    L28:
        Boolean r113 = (Boolean) this.b.get("data_is_portrait");
        if (r113 != null) goto L31;
        r113 = Boolean.FALSE;
    L31:
        r111.report(r2, r3, r21, false, r12, r18, r113.booleanValue(), this.b);
        return;
    L27:
        r21 = r112;
        goto L28
    L17:
        r9 = 1;
        goto L18
    L13:
        r7 = -1;
        goto L14
    L9:
        r5 = r1;
        goto L10
    L33:
        throw new IllegalStateException("got vs compat room failed");
    }
}

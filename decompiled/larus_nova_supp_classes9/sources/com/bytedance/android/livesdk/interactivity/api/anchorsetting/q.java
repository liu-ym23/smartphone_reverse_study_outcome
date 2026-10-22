package com.bytedance.android.livesdk.interactivity.api.anchorsetting;

import android.widget.RadioGroup;
import com.bytedance.android.live.broadcast.api.model.ScreenChatSettingGetResponse;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q<T> implements Consumer {
    public final /* synthetic */ PrivilegeSettingDetailDialog a;

    public q(PrivilegeSettingDetailDialog r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        PrivilegeSettingDetailDialog r0 = this.a;
        com.bytedance.android.live.broadcast.api.model.c0 r6 = ((ScreenChatSettingGetResponse) ((BaseResponse) ((Response) r5)).data).getData();
        int r1 = PrivilegeSettingDetailDialog.l;
        if (r6 == null) goto L5;
        RadioGroup r2 = (RadioGroup) r0.S90(2131373959);
        Integer r3 = r0.h.get(r6.c());
        Intrinsics.checkNotNull(r3);
        r2.check(r3.intValue());
        RadioGroup r4 = (RadioGroup) r0.S90(2131373957);
        Integer r7 = r0.j.get(r6.b());
        Intrinsics.checkNotNull(r7);
        r4.check(r7.intValue());
        RadioGroup r8 = (RadioGroup) r0.S90(2131373972);
        Integer r9 = r0.i.get(r6.a());
        Intrinsics.checkNotNull(r9);
        r8.check(r9.intValue());
        com.bytedance.android.livesdk.sharedpref.e r10 = com.bytedance.android.livesdk.sharedpref.b.f1;
        Integer r11 = r6.c();
        r10.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r10, r11);
        com.bytedance.android.livesdk.sharedpref.e r13 = com.bytedance.android.livesdk.sharedpref.b.h1;
        Integer r14 = r6.b();
        r13.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r13, r14);
        com.bytedance.android.livesdk.sharedpref.e r15 = com.bytedance.android.livesdk.sharedpref.b.g1;
        Integer r16 = r6.a();
        r15.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r15, r16);
        return;
    L5:
        r0.getClass();
    }
}

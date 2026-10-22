package com.bytedance.android.live.profile.servicewidget;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.v;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.m;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import zg1.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ ProfileServiceWidget a;
    public final /* synthetic */ v2 b;

    public a(ProfileServiceWidget r1, v2 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r7) {
        Response r8 = (Response) r7;
        Intrinsics.checkNotNullParameter(r8, "response");
        v r0 = os0.b.b(this.a.getDataCenter());
        if (r0 == null) goto L8;
        m r1 = r0.h();
        if (r1 == null) goto L8;
        r1.setValue(Boolean.TRUE);
    L8:
        if (((BaseResponse) r8).statusCode != 0) goto L32;
        v r9 = os0.b.b(((Widget) this.a).dataCenter);
        if (r9 == null) goto L31;
        m r2 = r9.getProfileStyle();
        if (r2 == null) goto L18;
        v2 r3 = this.b;
        if (r3 == null) goto L16;
        int r4 = (int) r3.b;
    L17:
        r2.setValue(Integer.valueOf(r4));
        goto L18
    L16:
        r4 = 0;
    L18:
        m r5 = r9.g();
        long r6 = 0;
        if (r5 == null) goto L25;
        v2 r10 = this.b;
        if (r10 == null) goto L23;
        long r12 = r10.c;
    L24:
        r5.setValue(Long.valueOf(r12));
        goto L25
    L23:
        r12 = 0;
    L25:
        m r13 = r9.a();
        if (r13 == null) goto L31;
        v2 r14 = this.b;
        if (r14 == null) goto L30;
        r6 = r14.d;
    L30:
        r13.setValue(Long.valueOf(r6));
    L31:
        f2.c("操作成功", 0);
        return;
    L32:
        f2.c("服务异常，请稍后重试", 0);
    }
}

package com.bytedance.android.livesdk.interactivity.interactive;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f1<T> implements Consumer {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ Function2 b;

    public f1(Function1 r1, Function2 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r6) {
        Response r7 = (Response) r6;
        c1 r0 = (c1) ((BaseResponse) r7).data;
        if (r0 == null) goto L7;
        boolean r2 = true;
        if (r0.b() != true) goto L7;
    L8:
        String r1 = null;
        if (r2 == false) goto L14;
        Function1 r3 = this.a;
        c1 r8 = (c1) ((BaseResponse) r7).data;
        if (r8 == null) goto L13;
        r1 = r8.a();
    L13:
        r3.invoke(r1);
        f2.c("发布成功", 0);
        return;
    L14:
        this.b.invoke(0, "发布失败");
        RequestError r9 = ((BaseResponse) r7).error;
        if (r9 == null) goto L17;
        r1 = r9.prompts;
    L17:
        f2.c(r1, 0);
        int r10 = h1.a;
        Intrinsics.checkNotNullParameter("send comment failed, status code = 200, success = false}", "msg");
        ALogger.i("VSMsgBoard", "send comment failed, status code = 200, success = false}");
        return;
    L7:
        r2 = false;
        goto L8
    }
}

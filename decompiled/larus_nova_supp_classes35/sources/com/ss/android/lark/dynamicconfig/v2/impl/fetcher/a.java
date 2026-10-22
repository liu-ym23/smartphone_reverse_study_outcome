package com.ss.android.lark.dynamicconfig.v2.impl.fetcher;

import com.bytedance.lark.pb.basic.v1.InitSDKRequest;
import com.bytedance.lark.pb.settings.v1.PushCommonSettingsUpdated;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.g;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements g.b {
    public final /* synthetic */ f a;
    public final /* synthetic */ e b;

    public a(com.ss.android.lark.framework.assembly.rust.e.a r2) {
        this.b = e.a.a;
        this.a = r2;
    }

    public final void a(byte[] r6) {
        Log.d("DomainFetcherImpl", "onCommonDomainPushing, fromServerPipe = false, offlinePush = false");     // Catch: IOException -> L19
        InitSDKRequest.EnvV2 r7 = ((PushCommonSettingsUpdated) PushCommonSettingsUpdated.ADAPTER.decode(r6)).env_v2;     // Catch: IOException -> L19
        this.b.getClass();     // Catch: IOException -> L19
        final InitSDKRequest.EnvV2 r3 = e.c();     // Catch: IOException -> L19
        if (r3 != null) goto L6;
        Log.e("DomainFetcherImpl", "client evn is illegal.");     // Catch: IOException -> L19
        com.ss.android.lark.framework.assembly.rust.e.a r8 = this.a;     // Catch: IOException -> L19
        if (r8 == null) goto L24;
        com.ss.android.lark.framework.assembly.rust.e.a r9 = r8;     // Catch: IOException -> L19
        r9.a(new ErrorResult("client evn is illegal."));     // Catch: IOException -> L19
    L24:
        return;
    L6:
        if (r3.brand.equalsIgnoreCase(r7.brand) == true) goto L8;
    L12:
        Log.e("DomainFetcherImpl", "client evn is not match with ser env.");     // Catch: IOException -> L19
        com.ss.android.lark.framework.assembly.rust.e.a r10 = this.a;     // Catch: IOException -> L19
        if (r10 == null) goto L24;
        com.ss.android.lark.framework.assembly.rust.e.a r11 = r10;     // Catch: IOException -> L19
        r11.a(new ErrorResult("client evn is not match with ser env."));     // Catch: IOException -> L19
        goto L24
    L8:
        if (r3.type != r7.type) goto L12;
        if (r3.unit.equalsIgnoreCase(r7.unit) == false) goto L12;
        e.a(this.b, r3, new DomainFetcherImpl$1$1(this, r3));     // Catch: IOException -> L19
    L19:
        e = move-exception;
        Log.e("DomainFetcherImpl", "common decode resp err, e: ", e);
        com.ss.android.lark.framework.assembly.rust.e.a r0 = this.a;
        if (r0 == null) goto L28;
        com.ss.android.lark.framework.assembly.rust.e.a r1 = r0;
        r1.a(new ErrorResult(e));
        return;
    }
}

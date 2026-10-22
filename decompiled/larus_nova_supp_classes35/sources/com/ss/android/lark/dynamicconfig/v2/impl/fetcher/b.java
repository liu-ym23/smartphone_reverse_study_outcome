package com.ss.android.lark.dynamicconfig.v2.impl.fetcher;

import android.text.TextUtils;
import com.bytedance.lark.pb.settings.v1.PushUserSettingsUpdated;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.appsetting.api.AppSettingApiModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.g;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements g.b {
    public final /* synthetic */ f a;
    public final /* synthetic */ e b;

    public b(com.ss.android.lark.framework.assembly.rust.e.a r2) {
        this.b = e.a.a;
        this.a = r2;
    }

    public final void a(byte[] r10) {
        Log.d("DomainFetcherImpl", "onUserDomainPushing, fromServerPipe = false, offlinePush = false");     // Catch: IOException -> L17
        PushUserSettingsUpdated r11 = (PushUserSettingsUpdated) PushUserSettingsUpdated.ADAPTER.decode(r10);     // Catch: IOException -> L17
        final String r3 = AppSettingApiModule.a().getUid();     // Catch: IOException -> L17
        if (r11.user_id.longValue() > 0) goto L6;
    L13:
        Log.e("DomainFetcherImpl", "uid is illegal, forbid fetch user domain.");     // Catch: IOException -> L17
        com.ss.android.lark.framework.assembly.rust.e.a r12 = this.a;     // Catch: IOException -> L17
        if (r12 == null) goto L22;
        com.ss.android.lark.framework.assembly.rust.e.a r13 = r12;     // Catch: IOException -> L17
        r13.a(new ErrorResult("uid is illegal, forbid fetch user domain."));     // Catch: IOException -> L17
    L22:
        return;
    L6:
        if (TextUtils.isEmpty(r3) == true) goto L13;
        if (TextUtils.equals(r11.user_id.toString(), r3) == false) goto L10;
        e.b(this.b, new DomainFetcherImpl$2$1(this, r3));     // Catch: IOException -> L17
        goto L22
    L10:
        Log.e("DomainFetcherImpl", "uid not equal, forbid fetch user domain.");     // Catch: IOException -> L17
        com.ss.android.lark.framework.assembly.rust.e.a r14 = this.a;     // Catch: IOException -> L17
        if (r14 == null) goto L22;
        com.ss.android.lark.framework.assembly.rust.e.a r15 = r14;     // Catch: IOException -> L17
        r15.a(new ErrorResult("uid not equal, forbid fetch user domain."));     // Catch: IOException -> L17
    L17:
        e = move-exception;
        Log.e("DomainFetcherImpl", "user decode resp err, e: ", e);
        com.ss.android.lark.framework.assembly.rust.e.a r0 = this.a;
        if (r0 == null) goto L26;
        com.ss.android.lark.framework.assembly.rust.e.a r1 = r0;
        r1.a(new ErrorResult(e));
        return;
    }
}

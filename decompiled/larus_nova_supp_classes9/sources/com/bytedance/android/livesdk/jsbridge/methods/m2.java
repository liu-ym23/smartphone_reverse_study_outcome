package com.bytedance.android.livesdk.jsbridge.methods;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.bdlocation.BuildConfig;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m2 implements n56.c {
    public final WeakReference<Context> a;

    public m2(WeakReference<Context> r1) {
        this.a = r1;
    }

    public void call(n56.f r5, JSONObject r6) throws Exception {
        if ((this.a.get() instanceof Activity) == false) goto L5;
        jc1.k.f(IHostApp.class).startBindPhoneDialogFragment((Activity) this.a.get(), BuildConfig.FLAVOR, BuildConfig.FLAVOR, new l2());
        r6.put("code", 1);
        return;
    L5:
        r6.put("code", 0);
    }
}

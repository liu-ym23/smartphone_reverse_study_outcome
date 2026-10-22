package com.ss.android.deviceregister.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.bdinstall.oaid.impl.IDeviceIdManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
final class e extends c<IDeviceIdManager> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f15133a;

    e(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        super("com.coolpad.deviceidsupport");
        this.f15133a = ZeusTransformUtils.wrapperContext(r4, "com.obric.memorydata.plugin");
    }

    static /* synthetic */ Context a(e r0) {
        return r0.f15133a;
    }

    @Override // com.ss.android.deviceregister.a.c
    public Intent a(Context r3) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intent r4 = new Intent();
        r4.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        return r4;
    }

    @Override // com.ss.android.deviceregister.a.c
    public w.b<IDeviceIdManager, String> a() {
        return new AnonymousClass1(this);
    }

    @Override // com.ss.android.deviceregister.a.c, com.ss.android.deviceregister.a.n
    public n.a c(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
    L9:
        th = move-exception;
        th.printStackTrace();
    L12:
        return super.c(r4);
    L4:
        if (Build.VERSION.SDK_INT < 17) goto L12;
        String r0 = Settings.Global.getString(r4.getContentResolver(), "coolos.oaid");     // Catch: Throwable -> L9
        if (TextUtils.isEmpty(r0) == true) goto L12;
        n.a r1 = new n.a();     // Catch: Throwable -> L9
        r1.f15141a = r0;     // Catch: Throwable -> L9
        return r1;
    }
}

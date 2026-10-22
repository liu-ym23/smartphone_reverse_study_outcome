package com.ss.android.lark.integrator.ccm.assembly;

import android.content.Context;
import cmb.f;
import com.larksuite.framework.launch.task.AsyncLaunchTask;
import com.ss.android.lark.integrator.ccm.spacekit.SpacekitSdkWrapper;
import fo5.d;
import hmb.a;
import hmb.b;
import hmb.c;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class DocDownloadTask extends AsyncLaunchTask {
    public DocDownloadTask() {
    }

    public final void a(final Context r4) {
        f.a().getClass();
        SpacekitSdkWrapper r0 = SpacekitSdkWrapper.b.a;
        r0.getClass();
        Flowable.just("").observeOn(d.c()).map(new a(r4)).subscribe(new b(), new c());
        f.a().getClass();
        r0.getClass();
        com.bytedance.ee.bear.appsetting.c.a.a.b();
    }
}

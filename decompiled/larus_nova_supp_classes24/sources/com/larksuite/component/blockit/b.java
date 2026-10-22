package com.larksuite.component.blockit;

import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.larksuite.component.blockit.entity.BlockEntity;
import com.larksuite.component.blockit.sync.BlockSync;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.openplatform.base.container.api.entity.OPContainerBundle;
import com.ss.android.lark.opmonitor.service.OPMonitor;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import com.ss.android.lark.utils.ApiUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public volatile com.larksuite.component.blockit.a a;

    public static final class a {
        public static final b a = null;

        static {
            a = new b();
        }
    }

    public b() {
    }

    public final void b() {
        if (this.a != null) goto L13;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.a != null) goto L8;
        com.larksuite.component.blockit.a r1 = (com.larksuite.component.blockit.a) ClaymoreServiceLoader.loadFirst(com.larksuite.component.blockit.a.class);     // Catch: Throwable -> L10
        Log.i("BlockitInstance", "init block: " + r1);     // Catch: Throwable -> L10
        this.a = r1;     // Catch: Throwable -> L10
        this.a.a();     // Catch: Throwable -> L10
        ry7.a.a = r1;     // Catch: Throwable -> L10
        d r0 = (d) ApiUtils.getApi(d.class);     // Catch: Throwable -> L10
        int r2 = BlockSync.a.a;     // Catch: Throwable -> L10
        r0.g();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    }

    public static OPMonitor a(ncb.b r2, OPContainerBundle r3, BlockEntity r4) {
        OPMonitor r0 = new OPMonitor("op_blockit_event", r2);
        if (r3 == null) goto L14;
        monitor-enter(r3);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (r3.a != null) goto L8;
        r3.a = gyb.a.a();     // Catch: Throwable -> L11
    L8:
        OPTrace r5 = r3.a;     // Catch: Throwable -> L11
        monitor-exit(r3);
        r0.tracing(r5).addCategoryValue("host", null).addCategoryValue("container_id", null).addCategoryValue("app_type", "block");
    L14:
        if (r4 == null) goto L16;
        r0.addCategoryValue("app_id", r4.getAppID()).addCategoryValue("application_id", r4.getAppID()).addCategoryValue("block_id", r4.getBlockID()).addCategoryValue("block_type_id", r4.getBlockTypeID());
    L16:
        return r0;
    }
}

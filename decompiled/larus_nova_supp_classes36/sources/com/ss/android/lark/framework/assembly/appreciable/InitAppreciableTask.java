package com.ss.android.lark.framework.assembly.appreciable;

import android.app.Application;
import android.content.Context;
import com.bytedance.framwork.core.monitor.MonitorUtils;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.appcontext.applifecycle.a0;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.rustinfrabridge.netstate.api.NetworkLevelListener;
import com.ss.android.lark.rustinfrabridge.netstate.impl.LarkNetworkLevelManager;
import com.ss.android.lark.rustinfrabridge.netstate.impl.d;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.LarkContext;
import java.util.HashSet;
import java.util.List;
import org.json.JSONObject;
import xva.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class InitAppreciableTask extends AbstractLaunchTask {
    public final a c;
    public final b d;

    public class a implements c {
        public a() {
        }

        public final void a(String r1, JSONObject r2) {
            Statistics.sendEvent(r1, r2);
        }

        public final void b(String r1, JSONObject r2, JSONObject r3, JSONObject r4) {
            MonitorUtils.monitorEvent(r1, r2, r3, r4);
        }
    }

    public class b implements xva.b {
        public b() {
        }

        public final void d(String r1, String r2) {
            Log.d(r1, r2);
        }

        public final void e(String r2, Throwable r3) {
            Log.e("AppreciableKit", r2, r3);
        }

        public final void i(String r1, String r2) {
            Log.i(r1, r2);
        }
    }

    public InitAppreciableTask() {
        this.c = new a();
        this.d = new b();
    }

    public final void a(Context r8) {
        HashSet r4 = new HashSet();
        AppreciableKit r0 = AppreciableKit.getInstance();
        Application r1 = LarkContext.getApplication();
        int r9 = a0.b;
        r0.init(r1, new xva.a(), CoreThreadPool.getDefault().getScheduleThreadPool(), r4, this.d, this.c);
        AppLifecycle.a.a.c(new cjb.a());
        NetworkLevelListener r10 = new cjb.b();
        List r2 = d.a;
        d.b.a.getClass();
        Object r3 = LarkNetworkLevelManager.d;
        LarkNetworkLevelManager.a.a().w0(r10);
    }
}

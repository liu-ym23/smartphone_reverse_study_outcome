package com.ss.android.lark.framework.assembly.rust;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.Command;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.larksuite.framework.launch.task.ILaunchTask;
import com.ss.android.lark.framework.assembly.logger.InitLogTask;
import com.ss.android.lark.framework.assembly.sp.InitUniStoreTask;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.rustinfrabridge.appstatesync.service.IAppStateSyncService;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Singleton
public class InitRustSdkTask extends AbstractLaunchTask {
    public final Provider<com.bytedance.lark.sdk.refactor.n> c;
    public final Provider<IAppStateSyncService> d;

    public class a implements com.ss.android.lark.sdk.e {
        public a() {
        }

        public final String a(String r1) {
            return f0.a(r1);
        }

        public final void b(JSONObject r2) {
            Statistics.sendEvent("lark_rust_ffi_userid_check_dev", r2);
        }

        public final void w(String r2) {
            Log.w("sdk", r2);
        }
    }

    public class b implements com.ss.android.lark.sdk.d {
        public final /* synthetic */ Context a;
        public final /* synthetic */ InitRustSdkTask b;

        public final void b() {
        }

        public final boolean d() {
            if (com.larksuite.framework.utils.z.e(this.a) == true) goto L6;
            return false;
        L6:
            return true;
        }

        public final boolean e() {
            if (com.larksuite.framework.utils.z.e(this.a) == false) goto L6;
            return true;
        L6:
            return false;
        }

        public final String getUserId() {
            return ((yzb.b) e0c.k.a(LarkContext.getApplication(), yzb.b.class)).d();
        }

        public final Long a(String r2) {
            return ((com.bytedance.lark.sdk.refactor.n) this.b.c.get()).a(r2);
        }

        public final boolean c(Command r2) {
            if (r2 != Command.SET_DEVICE) goto L5;
        L10:
            return true;
        L5:
            if (r2 == Command.MAKE_USER_ONLINE) goto L10;
            if (r2 == Command.GET_INIT_SETTINGS) goto L10;
            return false;
        }

        public b(InitRustSdkTask r1, Context r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public final List<Class<? extends ILaunchTask>> i() {
        ArrayList r0 = new ArrayList();
        r0.add(InitLogTask.class);
        r0.add(InitUniStoreTask.class);
        return r0;
    }

    public final void a(Context r2) {
        int r0 = c0.a;
        com.ss.android.lark.sdk.i.a = new a();
        com.ss.android.lark.sdk.i.b = new b(this, r2);
        com.ss.android.lark.sdk.i.c = new j();
        com.ss.android.lark.appcontext.applifecycle2.api.a.c(new i(this));
    }

    @Inject
    public InitRustSdkTask(Provider<com.bytedance.lark.sdk.refactor.n> r1, Provider<IAppStateSyncService> r2) {
        this.c = r1;
        this.d = r2;
    }
}

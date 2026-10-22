package org.chromium;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.frameworks.baselib.network.http.util.i;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ttnet.org.chromium.base.Logger;
import hx5.a;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class CronetClient$1 extends a {
    final /* synthetic */ CronetClient this$0;
    final /* synthetic */ Context val$context;
    final /* synthetic */ SharedPreferences.Editor val$editor;

    public void run() {
        org_chromium_CronetClient$1_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void org_chromium_CronetClient$1__run$___twin___() {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetClient", "processname is " + i.b(this.val$context) + " clear count ");
    L5:
        this.val$editor.putInt("ttnet_crash_times", 0);
        this.val$editor.apply();
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void org_chromium_CronetClient$1_com_larus_apm_impl_protector_RunnableLancet_run(CronetClient$1 r1) {
        r1.org_chromium_CronetClient$1__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public CronetClient$1(CronetClient r1, long r2, long r4, Context r6, SharedPreferences.Editor r7) {
        this.this$0 = r1;
        this.val$context = r6;
        this.val$editor = r7;
        super(r2, r4);
    }
}

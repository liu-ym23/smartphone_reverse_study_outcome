package com.ss.android.lark.integrator.ccm.dependency.di;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.ee.bear.dto.DocAppUserConfig;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.integrator.ccm.spacekit.SpacekitSdkWrapper;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class t1 implements com.bytedance.ee.bear.basesdk.apisupport.o {
    public final Context a;

    public final void a() {
        ((com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class)).Q0();
        cmb.f.a().getClass();
        Iterator r0 = ((CopyOnWriteArrayList) SpacekitSdkWrapper.b.a.b).iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        ((on4.r) r0.next()).onInit();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        if (DevEnvUtil.isDebugMode(LarkContext.getApplication()) == true) goto L12;
        Log.e("SpacekitSdkWrapper", "dispatchInited", e);
        goto L4
    L12:
        throw e;
    }

    public final void b() {
        final Context r0 = this.a;
        Flowable.just(Boolean.FALSE).observeOn(fo5.d.c()).map(new hmb.d(r0)).subscribe(new hmb.e(), new hmb.f());
        long r1 = SystemClock.uptimeMillis();
        ((com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class)).M0();
        long r2 = r1 - 0;
        JSONObject r3 = new JSONObject();
        r3.put("cost_time", r2);     // Catch: JSONException -> L5
    L7:
        Statistics.sendEvent("docs_dev_performance_lark_launch_docs_init", r3);
        if (com.larksuite.framework.utils.z.e(this.a) == false) goto L26;
        User r4 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        if (r4 == null) goto L24;
        String r5 = r4.getSession();
        com.bytedance.ee.bear.lark.dependency.k r6 = (com.bytedance.ee.bear.lark.dependency.k) org.koin.java.a.a(com.bytedance.ee.bear.lark.dependency.k.class);
        String r7 = r6.a(((com.bytedance.ee.bear.lark.dependency.b) org.koin.java.a.a(com.bytedance.ee.bear.lark.dependency.b.class)).getTenantCode());
        String r8 = HttpUrl.parse(r7).host();
        ArrayList r9 = new ArrayList();
        r9.add(r8);
        r9.add(r6.getMainDomain());
        DocAppUserConfig r10 = r6.b();
        if (r10 != null) goto L15;
        jb5.b.b(r7, r5, r9);
        return;
    L15:
        List r11 = r10.getDocDomains();
        if (r11 != null) goto L18;
    L20:
        jb5.b.b(r7, r5, r9);
        return;
    L18:
        if (r11.isEmpty() == true) goto L20;
        r9.addAll(r11);
        goto L20
    L24:
        return;
    L26:
        return;
    L5:
        e = move-exception;
        tt5.a.d("DocLaunch", e.toString());
        goto L7
    }

    public t1() {
        this.a = LarkContext.getApplication();
    }
}

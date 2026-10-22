package com.ss.android.lark.integrator.ccm.spacekit;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.ee.bear.dto.DocAppUserConfig;
import com.bytedance.ee.bear.integrator.cookies.SessionInfo;
import com.bytedance.ee.bear.lark.dependency.v;
import com.bytedance.ee.bear.lark.selector.DocModuleInner;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.space.doc.v1.MGetDocFeedsRequest;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.z;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.ccm_api.SpacekitConst;
import com.ss.android.lark.doc.entity.DocFeed;
import com.ss.android.lark.doc.entity.DocType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.MapsKt;
import okhttp3.HttpUrl;
import on4.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class SpacekitSdkWrapper {
    public final c a;
    public final List<r> b;
    public final List<gmb.a> c;

    public class a implements Runnable {
        public final /* synthetic */ List a;

        @Override // java.lang.Runnable
        public final void run() {
            qa5.b.a.a.a.b().g(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(List r1) {
            this.a = r1;
        }
    }

    public static class b {
        public static final SpacekitSdkWrapper a = null;

        static {
            a = new SpacekitSdkWrapper();
        }
    }

    public final void c() {
        Log.i("SpacekitSdkWrapper", "DocsImpl.checkAndInit ");
        c r0 = this.a;
        getContext();
        r0.a(0);
    }

    public SpacekitSdkWrapper() {
        this.a = new c();
        this.b = new CopyOnWriteArrayList();
        this.c = new CopyOnWriteArrayList();
        eu5.b.a = LarkContext.getApplication();
    }

    private Application getContext() {
        return LarkContext.getApplication();
    }

    public static String a(String r3) {
        LinkedHashMap r0 = new LinkedHashMap();
        yob.e.a().getClass();
        int r1 = com.ss.android.lark.language.service.impl.a.f;
        r0.put("lang", com.ss.android.lark.language.service.impl.a.b.a.b());
        return av5.c.b(r3, r0, false);
    }

    public static boolean b(String r3) {
        if (((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).isLogin() == true) goto L6;
        return false;
    L6:
        int r0 = jl5.a.a;
        User r1 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        if (r1 == null) goto L9;
        String r2 = r1.getTenantCode();
    L10:
        if (r2 != null) goto L12;
        r2 = "";
    L12:
        String r4 = gcb.b.a(r2);
        String r5 = jcb.b.c().a("docs_api");
        return qa5.b.a.a.a.b().c(r4, r5, r3);
    L9:
        r2 = null;
        goto L10
    }

    public static int d(DocType r1) {
        int r2 = DocModuleInner.a.a[r1.ordinal()];
        if (r2 != 2) goto L5;
        int r3 = 2131254526;
    L25:
        return kac.a.b(r3);
    L5:
        if (r2 != 3) goto L7;
        r3 = 2131254491;
        goto L25
    L7:
        if (r2 != 4) goto L9;
        r3 = 2131254513;
        goto L25
    L9:
        if (r2 != 5) goto L11;
        r3 = 2131254516;
        goto L25
    L11:
        if (r2 != 6) goto L13;
        r3 = 2131254533;
        goto L25
    L13:
        if (r2 != 8) goto L15;
        r3 = 2131254502;
        goto L25
    L15:
        if (r2 == 10) goto L17;
        r3 = 2131254550;
        goto L25
    L17:
        r3 = 2131254529;
        goto L25
    }

    public static void h(List r2) {
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new a(r2));
    }

    public static void k(DocAppUserConfig r2) {
        if (qa5.b.a() == true) goto L5;
        return;
    L5:
        if (r2.getUrlRegex().isEmpty() == false) goto L7;
        Log.i("SpacekitSdkWrapper", "update url regex fail url regex is empty");
    L7:
        com.bytedance.ee.bear.basesdk.apisupport.g r0 = qa5.b.a.a.a.i();
        com.bytedance.ee.bear.basesdk.apisupport.g r1 = r0;
        r1.a(r2.getUrlRegex());
        tt5.a.h("SpacekitSdkWrapper", "update url regex success");
    }

    public final void f(int r11) {
        Log.i("SpacekitSdkWrapper", "DocsImpl.onLoginStatusChangedEvent, event: " + r11);
        if (r11 != SpacekitConst.LoginEvent.Login.ordinal()) goto L53;
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        r0.getClass();
        tt5.a.h("AppSetting", "clear cache");
        cn4.a r2 = r0.b;
        ((ConcurrentHashMap) r2.b).clear();
        ((ConcurrentHashMap) r2.c).clear();
        Iterator r1 = ((ConcurrentSkipListSet) r0.a).iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        ((com.bytedance.ee.bear.appsetting.m) r1.next()).onClear();
        goto L6
    L8:
        com.bytedance.ee.bear.appsetting.c.a.a.b();
        if (qa5.b.a() == false) goto L53;
        Log.i("SpacekitSdkWrapper", "DocsImpl.trySetAccountInfo ");
        if (((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).isLogin() == false) goto L53;
        String r3 = jl5.a.a();
        User r4 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        if (r4 == null) goto L16;
        Map r5 = r4.getSessionWithDomainMap();
        if (r5 == null) goto L16;
    L17:
        if (r5 != null) goto L19;
        tt5.a.k("SpacekitSdkWrapper", "sessionInfoMap is null");
        HashMap r6 = new HashMap();
    L27:
        if (TextUtils.isEmpty(r3) == false) goto L29;
        Log.e("SpacekitSdkWrapper", "set account info fail due to session is null");
        goto L53
    L29:
        com.bytedance.ee.bear.lark.dependency.k r7 = (com.bytedance.ee.bear.lark.dependency.k) org.koin.java.a.a(com.bytedance.ee.bear.lark.dependency.k.class);
        String r8 = ((com.bytedance.ee.bear.lark.dependency.b) org.koin.java.a.a(com.bytedance.ee.bear.lark.dependency.b.class)).getTenantCode();
        if (qa5.b.a() == false) goto L32;
        qa5.b.a.a.a.h().a(jmb.d.a());
    L32:
        String r9 = r7.a(r8);
        String r10 = HttpUrl.parse(r9).host();
        ArrayList r12 = new ArrayList();
        r12.add(r10);
        r12.add(r7.getMainDomain());
        if (z.e(getContext()) == true) goto L45;
        DocAppUserConfig r13 = r7.c();
        jb5.b.c(r9, r3, r12, r13.getDocDomains());
        x18.b r14 = ((v) org.koin.java.a.a(v.class)).getLarkHttpClient();
        if (r14 == null) goto L44;
        ArrayList r15 = new ArrayList();
        Iterator r16 = r6.keySet().iterator();
    L39:
        if (r16.hasNext() == false) goto L43;
        SessionInfo r17 = (SessionInfo) r6.get((String) r16.next());
        if (r17 == null) goto L39;
        r15.add(jb5.b.a(r17.getSession(), r17.getSessionName(), r17.getHostUrl()));
        goto L39
    L43:
        CoreThreadPool.getBackgroundHandler().post(new jb5.a(r14, r9, r15));
    L44:
        k(r13);
        goto L53
    L45:
        DocAppUserConfig r18 = r7.b();
        if (r18 != null) goto L48;
        jb5.b.b(r9, r3, r12);
    L50:
        if (qa5.b.a() == false) goto L53;
        qa5.b.a.a.a.i().b(jcb.b.c().a("passport"));
        goto L53
    L48:
        jb5.b.c(r9, r3, r12, r18.getDocDomains());
        k(r18);
        goto L50
    L19:
        HashMap r19 = new HashMap(r5.size());
        Iterator r20 = r5.keySet().iterator();
    L21:
        if (r20.hasNext() == false) goto L25;
        String r21 = (String) r20.next();
        com.ss.android.lark.passport.signinsdk_api.account.SessionInfo r22 = (com.ss.android.lark.passport.signinsdk_api.account.SessionInfo) r5.get(r21);
        if (r22 == null) goto L21;
        r19.put(r21, new SessionInfo(r22.getHostUrl(), r22.getSessionName(), r22.getSession()));
        goto L21
    L25:
        r6 = r19;
    L16:
        r5 = MapsKt.emptyMap();
    L53:
        if (qa5.b.a() == false) goto L67;
        Log.i("SpacekitSdkWrapper", "LarkSpacekitSdk fully initiated, flow the event");
        qa5.b.a.a.a.h().onLoginStatusChangedEvent(r11);
        return;
    }

    public final void i(int r3) {
        Log.i("SpacekitSdkWrapper", "DocsImpl.preloadDocSdk ");
        c r0 = this.a;
        getContext();
        r0.a(r3);
    }

    public static String e(String r2, String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L5;
        HashMap r0 = new HashMap();
        r0.put("docId", r3);
    L7:
        return av5.c.b(r2, r0, false);
    L5:
        r0 = null;
        goto L7
    }

    public static boolean g(String r1, Map r2) {
        if (b(r1) == false) goto L6;
        String r3 = a(r1);
        return qa5.b.a.a.a.b().open(r3, r2);
    L6:
        return false;
    }

    public final void j(final String r3, final IGetDataCallback<DocFeed> r4) {
        List r0 = Collections.singletonList(r3);
        IGetDataCallback<ibb.a> r1 = new AnonymousClass10(this, r4, r3);
        MGetDocFeedsRequest.Builder r5 = new MGetDocFeedsRequest.Builder().ids(r0);
        SdkSender.asynSendRequestNonWrap(Command.MGET_DOC_FEEDS, r5, r1, new h());
    }
}

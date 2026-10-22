package com.ss.android.lark.framework.assembly.rust;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.DomainSettings;
import com.bytedance.lark.pb.basic.v1.InitSDKRequest;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.utils.j0;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.dynamicconfig.v2.interfaces.IGlobalDomainConfigService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.utils.LarkContext;
import dagger.hilt.EntryPoints;
import dagger.hilt.dwarf.spi.DwarfSPIEntryPoint;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements Runnable {

    public class a implements com.ss.android.lark.dynamicconfig.v2.impl.fetcher.f {
        public a() {
        }

        public final void a(ErrorResult r3) {
            Log.e("ImSdkInit", "receive DomainSettingPush failed, err: " + r3);
        }

        public final void b(String r10, int r11, String r12, String r13, DomainSettings r14) {
            Log.i("ImSdkInit", "updateDomainSetting start, push chain. uid: " + j0.a(r10));
            if (r14 == null) goto L35;
            User r0 = ((yzb.b) e0c.k.a(LarkContext.getApplication(), yzb.b.class)).getForegroundUser();
            if (r0 == null) goto L7;
            String r1 = r0.userId;
        L8:
            Log.i("ImSdkInit", "uid: " + j0.a(r10) + " currentUid: " + j0.a(r1));
            if (TextUtils.equals(r10, r1) == false) goto L17;
            Log.i("ImSdkInit", "sync execute start, before domain update.");
            HashMap r2 = new HashMap();
            List r3 = r14.pairs;
            if (r3 == null) goto L16;
            Iterator r4 = r3.iterator();
        L14:
            if (r4.hasNext() == false) goto L16;
            DomainSettings.Pair r5 = (DomainSettings.Pair) r4.next();
            r2.put(r5.alias_str, r5.domains);
        L16:
            jcb.b.c().h0(r2);
            Log.i("ImSdkInit", "sync execute finish.");
        L17:
            IGlobalDomainConfigService r6 = (IGlobalDomainConfigService) ((DwarfSPIEntryPoint) EntryPoints.get(gcb.a.a().getContext(), DwarfSPIEntryPoint.class)).dwarfSPI().get(IGlobalDomainConfigService.class);
            if (InitSDKRequest.EnvType.fromValue(r11) != null) goto L20;
            InitSDKRequest.EnvType r7 = gcb.a.a().getEnvType();
        L21:
            InitSDKRequest.EnvType r8 = r7;
            if (TextUtils.isEmpty(r12) == false) goto L24;
            String r9 = gcb.a.a().getUserUnit();
        L26:
            if (TextUtils.isEmpty(r13) == false) goto L28;
            String r15 = gcb.a.a().getTenantBrand();
        L29:
            r6.K0(r10, r8, r9, r15, r14);
            if (TextUtils.equals(r10, r1) == false) goto L32;
            Log.i("ImSdkInit", "updateFastDomainCache, after domain update");
            gcb.a.b();
        L32:
            Log.i("ImSdkInit", "receive PUSH_INIT_SETTINGS success:env=" + r11 + ", unit=" + r12 + ", brand=" + r13 + ", ");
            return;
        L28:
            r15 = r13;
            goto L29
        L24:
            r9 = r12;
            goto L26
        L20:
            r7 = InitSDKRequest.EnvType.fromValue(r11);
            goto L21
        L7:
            r1 = "";
            goto L8
        }
    }

    public static void a() {
        com.ss.android.lark.dynamicconfig.v2.impl.fetcher.e r0 = com.ss.android.lark.dynamicconfig.v2.impl.fetcher.e.a.a;
        a r1 = new a();
        Log.d("DomainFetcherImpl", "observeDomain");
        com.ss.android.lark.sdk.g r2 = com.ss.android.lark.sdk.g.e.a;
        r2.b(Command.PUSH_COMMON_SETTINGS_UPDATED, new com.ss.android.lark.dynamicconfig.v2.impl.fetcher.a(r1));
        r2.b(Command.PUSH_USER_SETTINGS_UPDATED, new com.ss.android.lark.dynamicconfig.v2.impl.fetcher.b(r1));
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public e() {
    }
}

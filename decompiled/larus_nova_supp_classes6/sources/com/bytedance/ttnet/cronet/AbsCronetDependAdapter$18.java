package com.bytedance.ttnet.cronet;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;
import sx5.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class AbsCronetDependAdapter$18 extends ThreadPlus {
    final /* synthetic */ AbsCronetDependAdapter this$0;
    final /* synthetic */ String val$idc;
    final /* synthetic */ String val$logid;
    final /* synthetic */ String val$region;
    final /* synthetic */ String val$regionLegacyUser;
    final /* synthetic */ String val$secUid;
    final /* synthetic */ String val$source;

    public void run() {
        com_bytedance_ttnet_cronet_AbsCronetDependAdapter$18_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_bytedance_ttnet_cronet_AbsCronetDependAdapter$18__run$___twin___() {
        CronetDataStorageAccess.inst().onStoreIdcChanged(this.val$idc, this.val$region, this.val$source, this.val$regionLegacyUser, this.val$secUid, this.val$logid);
        b r0 = b.g();
        String r1 = this.val$region;
        String r2 = this.val$source;
        String r3 = this.val$regionLegacyUser;
        String r4 = this.val$secUid;
        if (r0.k != null) goto L5;
        return;
    L5:
        if (r0.l == true) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r1) == false) goto L10;
        return;
    L10:
        if (TextUtils.isEmpty(r2) == false) goto L13;
        return;
    L13:
        if (r0.a.equalsIgnoreCase(r1) == true) goto L15;
    L19:
        r0.d = r4;
        r0.a = r1;
        r0.b = r2;
        r0.c = r3;
        if (Logger.debug() == false) goto L22;
        Logger.d("StoreRegionManager", "saveStoreRegionForCronet region:" + r0.a + " source:" + r0.b + " sec uid:" + r0.d);
    L22:
        SharedPreferences.Editor r5 = r0.k.getSharedPreferences("ttnet_store_region", 0).edit();
        r5.putString("store_region", r0.a);
        r5.putString("store_region_src", r0.b);
        r5.putString("store_sec_uid", r0.d);
        r5.apply();
        return;
    L15:
        if (r0.b.equalsIgnoreCase(r2) == false) goto L19;
        if (r0.d.equalsIgnoreCase(r4) == false) goto L19;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_bytedance_ttnet_cronet_AbsCronetDependAdapter$18_com_larus_apm_impl_protector_RunnableLancet_run(AbsCronetDependAdapter$18 r1) {
        r1.com_bytedance_ttnet_cronet_AbsCronetDependAdapter$18__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public AbsCronetDependAdapter$18(AbsCronetDependAdapter r1, String r2, String r3, String r4, String r5, String r6, String r7) {
        this.this$0 = r1;
        this.val$idc = r2;
        this.val$region = r3;
        this.val$source = r4;
        this.val$regionLegacyUser = r5;
        this.val$secUid = r6;
        this.val$logid = r7;
    }
}

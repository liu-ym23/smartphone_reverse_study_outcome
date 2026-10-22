package w64;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.badger.BadgerCore;
import com.bytedance.badger.collect.impl.api.BadgerCollectApi;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.collect.impl.manager.PseudoCodeManager;
import com.bytedance.badger.collect.impl.pseudo.model.PseudoCodeResult;
import com.bytedance.badger.collect.impl.utils.KLog;
import com.bytedance.badger.collect.impl.utils.NetworkTypeUtils;
import com.bytedance.badger.collect.impl.utils.SimUtils;
import com.bytedance.badger.data.BadgerResult;
import com.bytedance.badger.data.DataString;
import com.bytedance.badger.j;
import com.bytedance.badger.module.BadgerModuleBase;
import com.bytedance.badger.network.d0;
import com.bytedance.badger.network.z0;
import com.bytedance.badger.v.w;
import com.bytedance.badger.z.u0;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c extends u0 {
    public c() {
    }

    public static JSONObject c(PseudoCodeResult r3, Context r4) {
        JSONObject r0 = new JSONObject();
        r0.putOpt("AppID", Integer.valueOf(BadgerCollectApi.getAppId()));
        r0.putOpt("AC", NetworkTypeUtils.getNetworkStatus(r4));
        r0.putOpt("CarrierCode", Integer.valueOf(SimUtils.getSimType(r4)));
        r0.putOpt("UserPseudoCode", r3.data);
        r0.putOpt("OS", "android");
        r0.putOpt("Time", Long.valueOf(System.currentTimeMillis()));
        r0.putOpt("VersionCode", "0.2.0-rc.18.3-bugfix-badger");
        BadgerCore.Companion.getClass();
        r0.putOpt("DeviceID", j.a().getDeviceId());
        r0.putOpt("Province", "");
        r0.putOpt("ErrorMsg", r3.errorMsg);
        return r0;
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    public final BadgerResult a(Context r17, BadgerModuleBase.BadgerRequestData r18) {
        CountDownLatch r12 = new CountDownLatch(1);
        AtomicInteger r13 = new AtomicInteger(0);
        Ref.ObjectRef r14 = new Ref.ObjectRef();
        r14.element = null;
        long r8 = System.currentTimeMillis();
        PseudoCodeManager.getInstance().executeMobilePseudoCode(new a(this, r13, r14, r17, r18, r8, r12));
        com.bytedance.badger.v.d.f0.getClass();
        com.bytedance.badger.v.g r2 = com.bytedance.badger.v.d.i;
        KProperty r3 = com.bytedance.badger.v.d.a[8];
        w r4 = (w) r2.a();
        if (r12.await(r4.a, r4.b) == true) goto L5;
        r13.compareAndSet(0, 2);
        throw new RuntimeException("Timeout");
    L5:
        if (((JSONObject) r14.element) != null) goto L8;
        r14.element = new JSONObject();
    L8:
        return new BadgerResult.Success(new DataString(String.valueOf((JSONObject) r14.element)));
    }

    public static final void d(c r2, Context r3, PseudoCodeResult r4, BadgerModuleBase.BadgerRequestData r5, long r6) {
        r2.getClass();
        if (TextUtils.isEmpty(r4.data) == true) goto L9;
        boolean r7 = u0.b(Long.valueOf(r5.getToken()), new DataString(c(r4, r3).toString()), System.currentTimeMillis() - r6);
        if (r7 == false) goto L7;
        z0 r8 = d0.a;
        d0.b(23, z64.h.b.a, new b(), false);
        return;
    L7:
        KLog.w(Constants.TAGS.PSEUDO, "error status: " + r7);
        return;
    }
}

package qh0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.business.depend.IStartLiveVerifyCallback;
import com.bytedance.android.livehostapi.business.depend.LiveCertResult;
import com.bytedance.android.livehostapi.business.depend.LiveCertStatus;
import com.bytedance.android.livesdkapi.eventbus.LiveRealStartEvent;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k implements IStartLiveVerifyCallback {
    public final /* synthetic */ h a;

    public final void agreeToStartLive(HashMap<String, String> r1) {
    }

    public final void onStartVerifyPage() {
    }

    public final void onCancel() {
        this.a.e.invoke();
    }

    public k(h r1) {
        this.a = r1;
    }

    public final void onLiveVerfifyResult(LiveCertResult r4) {
        StringBuilder r0 = new StringBuilder("onVerifySuccess in ServerPermissionHandler, certstatus = ");
        Integer r1 = null;
        if (r4 == null) goto L7;
        LiveCertStatus r2 = r4.getStatus();
        if (r2 == null) goto L7;
        Integer r3 = Integer.valueOf(r2.getCertStatus());
    L8:
        r0.append(r3);
        r0.append(", manualStatus = ");
        if (r4 == null) goto L13;
        LiveCertStatus r5 = r4.getStatus();
        if (r5 == null) goto L13;
        Integer r6 = Integer.valueOf(r5.getManualStatus());
    L14:
        r0.append(r6);
        r0.append(", ageRange = ");
        if (r4 == null) goto L19;
        LiveCertStatus r7 = r4.getStatus();
        if (r7 == null) goto L19;
        r1 = Integer.valueOf(r7.getAgeRange());
    L19:
        r0.append(r1);
        ALogger.e("IStartLiveVerifyCallback", r0.toString());
        if (r4 != null) goto L22;
    L24:
        this.a.e.invoke();
        return;
    L22:
        if (r4.isVerify() != true) goto L24;
        this.a.d.invoke();
        return;
    L13:
        r6 = null;
    L7:
        r3 = null;
        goto L8
    }

    public final void onVerifyResult(LiveRealStartEvent r4) {
        if (((Boolean) vm2.d.m.getValue(null, vm2.d.a[11])).booleanValue() == false) goto L5;
        return;
    L5:
        ALogger.e("IStartLiveVerifyCallback", "onVerifySuccess in ServerPermissionHandler");
        if (r4 != null) goto L8;
    L10:
        this.a.e.invoke();
        return;
    L8:
        if (r4.isVerified() != true) goto L10;
        this.a.d.invoke();
    }
}

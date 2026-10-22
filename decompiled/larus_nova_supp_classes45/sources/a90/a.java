package a90;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.base.abtest.ClientABTestKey;
import com.bytedance.android.live.browser.jsbridge.newmethods.ba;
import com.bytedance.android.live.browser.jsbridge.newmethods.ca;
import com.bytedance.android.live.core.verify.utils.IIdentityVerifyService;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livehostapi.business.IHostOCRApiProxy;
import com.bytedance.android.livehostapi.business.IHostOCRPreloadApiProxy;
import com.bytedance.android.livesdk.config.tj;
import com.bytedance.android.livesdk.model.n;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class a implements IIdentityVerifyService {

    /* JADX INFO: renamed from: a90.a$a, reason: collision with other inner class name */
    public static final class C0000a implements com.bytedance.android.live.core.verify.utils.a.d {
        public final /* synthetic */ IIdentityVerifyService.a a;

        public C0000a(IIdentityVerifyService.a r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.core.verify.utils.a.d
        public final void a(String r11) {
            ba r0 = (ba) this.a;
            ca r1 = r0.a;
            IIdentityVerifyService r2 = r0.b;
            JsonObject r3 = r0.c;
            String r4 = r0.d;
            JsonObject r5 = r0.e;
            r1.getClass();
            JsonObject r6 = new JsonObject();
            r6.addProperty("live_certification_setting_face_identify", r11);
            n r7 = (n) tj.a.getValue();
            if (r7 == null) goto L13;
            boolean r8 = r2.hostOCRSdkReady();
            if (r8 == false) goto L7;
            String r9 = r7.b();
        L8:
            r6.addProperty("live_certification_setting_info_input", r9);
            r6.addProperty("live_certification_setting_show_artificial_entrance", Boolean.valueOf(r7.a()));
            if (r8 == false) goto L11;
            int r12 = r7.c();
        L12:
            r6.addProperty("live_certification_setting_manual_use_ocr", Integer.valueOf(r12));
            r6.addProperty("live_certification_setting_use_reflection", Boolean.valueOf(r7.d()));
            r3.add(r4, r6);
            r2.mobReadSetting(r2.getFaceIdentify(), r11);
            goto L13
        L11:
            r12 = 0;
            goto L12
        L7:
            r9 = "default";
        L13:
            r5.add("data", r3);
            r1.finishWithResult(r5);
        }
    }

    public static final class b implements com.bytedance.android.live.core.verify.utils.a.g {
        @Override // com.bytedance.android.live.core.verify.utils.a.g
        public final void onVerify(boolean r1, Map<String, Object> r2) {
        }

        public b() {
        }
    }

    public static final class c implements com.bytedance.android.live.core.verify.utils.a.f {
        public c() {
        }

        @Override // com.bytedance.android.live.core.verify.utils.a.f
        public final Observable<Response<w80.a>> a(Map<String, String> r2) {
            Intrinsics.checkNotNullParameter(r2, "m");
            throw null;
        }
    }

    public a() {
    }

    @Override // com.bytedance.android.live.core.verify.utils.IIdentityVerifyService
    public String getFaceIdentify() {
        com.bytedance.android.live.base.abtest.b.a r0 = com.bytedance.android.live.base.abtest.b.b;
        ClientABTestKey<String> r1 = com.bytedance.android.live.base.abtest.a.a;
        r0.getClass();
        return (String) com.bytedance.android.live.base.abtest.b.a.a(r1);
    }

    @Override // com.bytedance.android.live.core.verify.utils.IIdentityVerifyService
    public boolean hostOCRSdkReady() {
        IHostOCRApiProxy r0 = k.f(IHostOCRApiProxy.class);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isSDKReady();
    }

    @Override // com.bytedance.android.live.core.verify.utils.IIdentityVerifyService
    public boolean supportTryPreload() {
        IHostOCRPreloadApiProxy r0 = k.f(IHostOCRPreloadApiProxy.class);
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.supportTryPreload() == false) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.core.verify.utils.IIdentityVerifyService
    public String getRealFaceIdentify() {
        return com.bytedance.android.live.core.verify.utils.a.d();
    }

    @Override // com.bytedance.android.live.core.verify.utils.IIdentityVerifyService
    public int getRealVerifyType() {
        return com.bytedance.android.live.core.verify.utils.a.g();
    }

    @Override // com.bytedance.android.live.core.verify.utils.IIdentityVerifyService
    public String getVerifiedConfirmPageSource() {
        return com.bytedance.android.live.core.verify.utils.a.h(com.bytedance.android.live.core.verify.utils.a.g());
    }

    @Override // com.bytedance.android.live.core.verify.utils.IIdentityVerifyService
    public void mobReadSetting(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "realType");
        IHostOCRPreloadApiProxy r0 = k.f(IHostOCRPreloadApiProxy.class);
        if (r0 == null) goto L6;
        r0.mobReadSetting(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.core.verify.utils.IIdentityVerifyService
    public void getRealFaceIdentifySync(Context r2, boolean r3, IIdentityVerifyService.a r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "getRealFaceIdentifySyncInterface");
        com.bytedance.android.live.core.verify.utils.a.e(r2, r3, new C0000a(r4));
    }

    @Override // com.bytedance.android.live.core.verify.utils.IIdentityVerifyService
    public void verify(Activity r13, w80.a r14, String r15, Bundle r16, int r17, String r18, boolean r19, IIdentityVerifyService.c r21, IIdentityVerifyService.b r22, boolean r23, boolean r24) {
        Intrinsics.checkNotNullParameter(r21, "onVerifyCallBack");
        Intrinsics.checkNotNullParameter(r22, "getZhiMaSubmitInterface");
        com.bytedance.android.live.core.verify.utils.a.o(r13, r14, r15, r16, r17, r18, r19, new b(), new c(), r23, r24);
    }
}

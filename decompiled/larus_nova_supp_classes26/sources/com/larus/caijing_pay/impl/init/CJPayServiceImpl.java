package com.larus.caijing_pay.impl.init;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayUtils;
import com.bytedance.applet.impl.e0;
import com.bytedance.applet.impl.f0;
import com.larus.caijing_pay.api.ICJPayService;
import com.larus.camera.impl.utils.n;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.ss.android.bytedcert.flow.cert.BytedCertFlowParams;
import com.ss.android.bytedcert.flow.face.FaceDetectFlowParams;
import com.ss.android.bytedcert.manager.BytedCertManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J`\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2:\u0010\u000b\u001a6\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0016J|\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\n2:\u0010\u000b\u001a6\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0016J^\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0017\u001a\u00020\r2:\u0010\u0018\u001a6\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0016J7\u0010\u0012\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\n2#\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001aH\u0016Jh\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\n2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2:\u0010\u000b\u001a6\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0016J@\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\"0\t2\u0006\u0010#\u001a\u00020$H\u0016JP\u0010%\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\n2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\"0\t2\u0006\u0010#\u001a\u00020(H\u0016¨\u0006*"}, d2 = {"Lcom/larus/caijing_pay/impl/init/CJPayServiceImpl;", "Lcom/larus/caijing_pay/api/ICJPayService;", "<init>", "()V", "routeSign", "", "context", "Landroid/content/Context;", "sdkInfo", "", "", "onResult", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "code", "msg", "pay", "service", "subway", "referer", "ext", "payType", "payFinishCallback", "papiId", "Lkotlin/Function1;", "", "isSuccess", "outerBDPay", "extraInfo", "startBytedCert", "userInfo", "themeData", "", "callback", "Lcom/larus/caijing_pay/api/BytedCertCallbackWrapper;", "doFaceLive", "identityCode", "identityName", "Lcom/larus/caijing_pay/api/FaceLiveCallbackWrapper;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJPayServiceImpl implements ICJPayService {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public CJPayServiceImpl() {
    }

    @Override // com.larus.caijing_pay.api.ICJPayService
    public final void b(Context r4, Map r5, n r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "sdkInfo");
        FLogger.a.i("CJPayServiceImpl", "routeSign called");
        TTCJPayUtils.Companion.getInstance().routeSign(r4, r5, null, new k(r6));
    }

    @Override // com.larus.caijing_pay.api.ICJPayService
    public final void a(FragmentActivity r10, String r11, int r12, e0 r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        TTCJPayUtils.Companion r0 = TTCJPayUtils.Companion;
        r0.getInstance().setContext(r10);
        r0.getInstance().pay(r11, r12, "", "", "", new j(r13));
    }

    @Override // com.larus.caijing_pay.api.ICJPayService
    public final void c(FragmentActivity r10, String r11, Map r12, f0 r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "sdkInfo");
        Intrinsics.checkNotNullParameter(r12, "extraInfo");
        FLogger.a.i("CJPayServiceImpl", "outerBDPay called");
        TTCJPayUtils.Companion.getInstance().outerBDPay(r10, r11, r12, null, null, true, new h(r13));
    }

    @Override // com.larus.caijing_pay.api.ICJPayService
    public final void d(final Context r2, Map r3, Map r4, final com.larus.live.impl.ttlivesdk.k.c r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "userInfo");
        Intrinsics.checkNotNullParameter(r4, "themeData");
        Intrinsics.checkNotNullParameter(r5, "callback");
        BytedCertFlowParams.Builder r6 = new BytedCertFlowParams.Builder(r2);
        r6.setCertInfo(r3);
        r6.setCertInfo("use_new_api", "true");
        r6.setShowLoading(true);
        r6.setCertResultCallback(new f(r5));
        r6.setWebEventCallback(new g(r2));
        BytedCertManager.getInstance().startBytedCert(r6.build());
    }

    @Override // com.larus.caijing_pay.api.ICJPayService
    public final void e(Context r8, int r9, String r10, String r11, Function2 r12) {
        Intrinsics.checkNotNullParameter(r8, "context");
        LinkedHashMap r0 = new LinkedHashMap();
        o r1 = o.a;
        r0.put("iid", r1.getInstallId());
        r0.put("did", r1.getDeviceId());
        r0.put("channel", AppHost.a.getBuildChannel());
        FLogger.a.i("CJPayServiceImpl", "pay called, service: " + r9 + ", subway: , referer: , ext: " + r11);
        TTCJPayUtils.Companion.getInstance().setContext(r8).setRiskInfoParams(r0).pay(r10, r9, "", "", r11, new i(r12));
    }

    @Override // com.larus.caijing_pay.api.ICJPayService
    public final void f(Context r2, String r3, String r4, Map r5, Map r6, final com.larus.live.impl.ttlivesdk.k.b r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "identityCode");
        Intrinsics.checkNotNullParameter(r4, "identityName");
        Intrinsics.checkNotNullParameter(r5, "userInfo");
        Intrinsics.checkNotNullParameter(r6, "themeData");
        Intrinsics.checkNotNullParameter(r7, "callback");
        FaceDetectFlowParams.Builder r8 = new FaceDetectFlowParams.Builder(r2);
        r8.setCertInfo(r5);
        r8.setCertInfo("use_new_api", "true");
        r8.setShowLoading(true);
        r8.setFaceLiveCallback(new CJPayServiceImpl$doFaceLive$1$1(r7));
        BytedCertManager.getInstance().doFaceLive(r8.build());
    }
}

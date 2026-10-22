package t3;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.device.scan.AbsScanCodeMethodIDL;
import com.bytedance.ai.bridge.service.ScanCodeCallback;
import com.bytedance.ai.bridge.service.ScanCodeResult;
import com.bytedance.ai.event.MessageIndication;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a2 implements ScanCodeCallback {
    public final /* synthetic */ f3.h<AbsScanCodeMethodIDL.b> a;

    public a2(f3.h<AbsScanCodeMethodIDL.b> r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ai.bridge.service.ScanCodeCallback
    public final void onFail(String r10) {
        Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
        com.bytedance.ai.utils.g r0 = com.bytedance.ai.utils.g.a;
        StringBuilder r1 = new StringBuilder("call failed, errNo=");
        f3.a r11 = f3.a.f;
        r1.append(r11.a);
        r1.append(", msg=");
        r1.append(r10);
        r0.e("AISDK_JSB_ScanCodeMethod", r1.toString());
        f3.h.a.a(this.a, r10, r11, null, 10);
    }

    @Override // com.bytedance.ai.bridge.service.ScanCodeCallback
    public final void onSuccess(ScanCodeResult r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_RESULT);
        com.bytedance.ai.utils.g.a.i("AISDK_JSB_ScanCodeMethod", "call success");
        f3.h<AbsScanCodeMethodIDL.b> r0 = this.a;
        Intrinsics.checkNotNullParameter(AbsScanCodeMethodIDL.b.class, "<this>");
        BaseModel r1 = k3.c.a(AbsScanCodeMethodIDL.b.class);
        AbsScanCodeMethodIDL.b r11 = (AbsScanCodeMethodIDL.b) r1;
        r11.setCharacterSet(r10.getCharacterSet());
        r11.setPath(r10.getPath());
        r11.setRawData(r10.getRawData());
        r11.setResult(r10.getResult());
        r11.setScanType(r10.getScanType());
        f3.h.a.b(r0, (ResultModel) r1);
    }
}

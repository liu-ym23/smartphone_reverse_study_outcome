package com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web;

import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.bridge.Message;
import com.ss.android.lark.officewebview.quality.jsbauth.BridgeAuthType;
import com.ss.android.lark.utils.e0;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class j implements xwb.f<String, OfficeWebView> {
    public final /* synthetic */ MmEndWindowWebHelper a;

    @Override // xwb.f
    public final /* synthetic */ boolean shouldRunInUIThread() {
        return true;
    }

    @Override // xwb.f
    public final BridgeAuthType authType() {
        return BridgeAuthType.Public;
    }

    public j(MmEndWindowWebHelper r1) {
        this.a = r1;
    }

    @Override // xwb.f
    public final void a(Object r7, xwb.d r8, String r9, OfficeWebView r10) {
        Intrinsics.checkNotNullParameter(r8, "callback");
        int r11 = bwb.b.a;
        MmUiLogScene r12 = MmUiLogScene.WEB;
        bwb.b.f(r12, "onReady", "data=" + ((String) r7), this.a.f());
        MmEndWindowWebHelper r13 = this.a;
        r13.getClass();
        MmViewTypeToJS r14 = new MmViewTypeToJS("regular");
        Message r15 = new Message();
        r15.setCallbackID("common.viewType");
        r15.setData(e0.c(r14));
        String r16 = e0.c(r15);
        StringCompanionObject r17 = StringCompanionObject.INSTANCE;
        String r18 = String.format("LarkWebViewJavaScriptBridge.nativeCallBack(%s);", Arrays.copyOf(new Object[]{r16}, 1));
        bwb.b.f(r12, "sendViewTypeToWeb", "script=" + r18, r13.f());
        OfficeWebView r19 = r13.g;
        if (r19 == null) goto L5;
        r19.evaluateJavascript(r18, null);
    L5:
        MmEndWindowWebHelper r20 = this.a;
        r20.getClass();
        JSONObject r21 = new JSONObject();
        r21.put("left", 0);
        r21.put("top", 0);
        r21.put("right", 0);
        r21.put("bottom", 0);
        String r22 = r21.toString();
        Message r4 = new Message();
        r4.setCallbackID("common.updateSafeArea");
        r4.setData(r22);
        String r23 = String.format("LarkWebViewJavaScriptBridge.nativeCallBack(%s);", Arrays.copyOf(new Object[]{e0.c(r4)}, 1));
        bwb.b.f(r12, "pushCommonSafeArea", "script=" + r23, r20.f());
        OfficeWebView r24 = r20.g;
        if (r24 == null) goto L9;
        r24.evaluateJavascript(r23, null);
        return;
    }
}

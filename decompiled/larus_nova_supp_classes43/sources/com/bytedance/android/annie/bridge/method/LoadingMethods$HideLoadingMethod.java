package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.method.abs.ShowLoadingResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "hideLoading")
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0013\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0011\u0010\u0010B\u0011\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0011\u0010\u0014J\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0094\u0002J\b\u0010\t\u001a\u00020\u0007H\u0014R$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"com/bytedance/android/annie/bridge/method/LoadingMethods$HideLoadingMethod", "Lcom/bytedance/ies/web/jsbridge2/f;", "Lorg/json/JSONObject;", "", "params", "Lcom/bytedance/ies/web/jsbridge2/CallContext;", "context", "", "invoke", "onTerminate", "Lcom/bytedance/android/annie/container/fragment/q;", "fragment", "Lcom/bytedance/android/annie/container/fragment/q;", "getFragment", "()Lcom/bytedance/android/annie/container/fragment/q;", "setFragment", "(Lcom/bytedance/android/annie/container/fragment/q;)V", "<init>", "Lm16/b;", "providerFactory", "(Lm16/b;)V", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class LoadingMethods$HideLoadingMethod extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> {
    private com.bytedance.android.annie.container.fragment.q fragment;

    public static final class a {
        public final /* synthetic */ LoadingMethods$HideLoadingMethod a;

        public final void a() {
            ShowLoadingResultModel r0 = new ShowLoadingResultModel();
            r0.a(ShowLoadingResultModel.Code.Success);
            r0.b("SUCCESS");
            LoadingMethods$HideLoadingMethod.access$finishWithResult(this.a, r0);
        }

        public a(LoadingMethods$HideLoadingMethod r1) {
            this.a = r1;
        }
    }

    public void onTerminate() {
    }

    public final com.bytedance.android.annie.container.fragment.q getFragment() {
        return this.fragment;
    }

    public LoadingMethods$HideLoadingMethod(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "providerFactory");
        com.bytedance.android.annie.container.fragment.q r11 = (com.bytedance.android.annie.container.fragment.q) r10.c(com.bytedance.android.annie.container.fragment.q.class);
        if (r11 == null) goto L6;
        this.fragment = r11;
        return;
    }

    public final void setFragment(com.bytedance.android.annie.container.fragment.q r1) {
        this.fragment = r1;
    }

    public LoadingMethods$HideLoadingMethod(com.bytedance.android.annie.container.fragment.q r1) {
        this.fragment = r1;
    }

    public static final /* synthetic */ void access$finishWithResult(LoadingMethods$HideLoadingMethod r0, Object r1) {
        r0.finishWithResult(r1);
    }

    public void invoke(JSONObject r10, CallContext r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        com.bytedance.android.annie.container.fragment.q r12 = this.fragment;
        if ((r12 instanceof com.bytedance.android.annie.container.fragment.q) == true) goto L6;
        r12 = null;
    L6:
        if (r12 == null) goto L8;
        v7.b r13 = r12.getLoadingFragment();
    L9:
        ((a9.h) Annie.getService$default(a9.h.class, null, 2, null)).E1(r11.getContext(), r13, new JSONObject(), new a(this));
        return;
    L8:
        r13 = null;
        goto L9
    }

    public /* bridge */ /* synthetic */ void invoke(Object r1, CallContext r10) {
        invoke((JSONObject) r1, r10);
    }
}

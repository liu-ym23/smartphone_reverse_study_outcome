package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.RegisterWrdsResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class u2 extends w20.h5<b, RegisterWrdsResultModel> implements com.bytedance.android.live.browser.jsbridge.e {
    public final DataCenter a;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/u2$b;", "Lw20/hd;", "", "", "typeList", "Ljava/util/List;", "getTypeList", "()Ljava/util/List;", "setTypeList", "(Ljava/util/List;)V", "listenerId", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setListenerId", "(Ljava/lang/String;)V", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b extends w20.hd {

        @SerializedName("listener_id")
        private String listenerId;

        @SerializedName("type_list")
        private List<String> typeList;

        public b() {
        }

        public final String b() {
            return this.listenerId;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.browser.jsbridge.e
    public final void onClean() {
    }

    public final void onTerminate() {
        ALogger.i("DynamicUnRegisterWrdsMethod", "onTerminate");
    }

    public u2(DataCenter r1) {
        this.a = r1;
    }

    public final void invoke(Object r6, CallContext r7) {
        b r8 = (b) r6;
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r7, "context");
        if (((Boolean) com.bytedance.android.live.core.setting.u0.a.getValue()).booleanValue() == false) goto L33;
        String r9 = r8.b();
        if (r9 == null) goto L34;
        IInteractService r0 = jc1.k.f(IInteractService.class);
        if (r0 == null) goto L13;
        ih0.b r1 = r0.dynamicService(this.a);
        if (r1 == null) goto L13;
        vlc.l r2 = r1.U6(r9);
    L14:
        List<String> r11 = r8.a();
        if (r11 == null) goto L24;
        Iterator<T> r12 = r11.iterator();
    L18:
        if (r12.hasNext() == false) goto L24;
        String r3 = (String) r12.next();
        DataCenter r4 = this.a;
        if (r4 == null) goto L18;
        vlc.d r5 = (vlc.d) r4.get("data_message_manager", null);
        if (r5 == null) goto L18;
        r5.removeMessageListener(r3, r2);
        ALogger.d("DynamicUnRegisterWrdsMethod", "removeWRDSListener, clazz: " + r3 + ", listenerID " + r9);
    L24:
        finishWithSuccess();
        return;
    L13:
        r2 = null;
        goto L14
    L34:
        return;
    }
}

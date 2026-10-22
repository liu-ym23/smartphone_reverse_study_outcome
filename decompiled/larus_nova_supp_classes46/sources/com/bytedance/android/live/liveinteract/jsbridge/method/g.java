package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g extends com.bytedance.ies.web.jsbridge2.f<b, Unit> implements com.bytedance.android.live.browser.jsbridge.e {
    public final DataCenter a;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/liveinteract/jsbridge/method/g$b;", "", "", "", "typeList", "Ljava/util/List;", "b", "()Ljava/util/List;", "setTypeList", "(Ljava/util/List;)V", "listenerId", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setListenerId", "(Ljava/lang/String;)V", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class b {

        @SerializedName("listener_id")
        private String listenerId;

        @SerializedName("type_list")
        private List<String> typeList;

        public b() {
        }

        public final String a() {
            return this.listenerId;
        }

        public final List<String> b() {
            return this.typeList;
        }
    }

    static {
    }

    public final void onClean() {
    }

    public final void onTerminate() {
        ALogger.i("DynamicUnRegisterMessageMethod", "onTerminate");
    }

    public g(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "mDataCenter");
        this.a = r2;
    }

    public final void invoke(Object r9, CallContext r10) {
        b r11 = (b) r9;
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r10, "context");
        if (((Boolean) com.bytedance.android.live.core.setting.t0.a.getValue()).booleanValue() == false) goto L39;
        String r12 = r11.a();
        if (r12 == null) goto L40;
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 == null) goto L13;
        ih0.b r1 = r0.dynamicService(this.a);
        if (r1 == null) goto L13;
        vlc.l r2 = r1.U6(r12);
    L14:
        List<String> r13 = r11.b();
        if (r13 == null) goto L33;
        Iterator<T> r14 = r13.iterator();
    L18:
        if (r14.hasNext() == false) goto L33;
        String r3 = (String) r14.next();
        MessageType[] r4 = MessageType.values();
        int r5 = r4.length;
        int r6 = 0;
    L20:
        if (r6 >= r5) goto L18;
        if (com.bytedance.android.livesdk.message.linker.m.a(r4[r6], r3) == false) goto L32;
        vlc.d r7 = (vlc.d) this.a.get("data_message_manager", null);
        if (r7 == null) goto L26;
        r7.removeMessageListener(r3, r2);
    L26:
        DataCenter r8 = this.a;
        if (r8 == null) goto L31;
        HashMap r15 = (HashMap) r8.get("multilink_jsb_message_filter", null);
        if (r15 == null) goto L31;
        Integer r16 = (Integer) r15.remove(r3);
    L31:
        ALogger.d("DynamicUnRegisterMessageMethod", "removeMessageListener: method is: " + r3 + ", listenerId: " + r12);
    L32:
        r6 = r6 + 1;
    L33:
        finishWithSuccess();
        return;
    L13:
        r2 = null;
        goto L14
    L40:
        return;
    }
}

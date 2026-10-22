package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import w20.aa;
import w20.z9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class DynamicRegisterMessageMethod extends com.bytedance.ies.web.jsbridge2.f<b, RegisterMessageResultModel> implements com.bytedance.android.live.browser.jsbridge.e {
    public d a;
    public final String b;
    public final DataCenter c;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/liveinteract/jsbridge/method/DynamicRegisterMessageMethod$RegisterMessageResultModel;", "Lw20/aa;", "Lcom/bytedance/android/live/liveinteract/jsbridge/method/DynamicRegisterMessageMethod$RegisterMessageResultModel$Code;", "code", "Lcom/bytedance/android/live/liveinteract/jsbridge/method/DynamicRegisterMessageMethod$RegisterMessageResultModel$Code;", "getCode", "()Lcom/bytedance/android/live/liveinteract/jsbridge/method/DynamicRegisterMessageMethod$RegisterMessageResultModel$Code;", "setCode", "(Lcom/bytedance/android/live/liveinteract/jsbridge/method/DynamicRegisterMessageMethod$RegisterMessageResultModel$Code;)V", "Lcom/google/gson/JsonObject;", "data", "Lcom/google/gson/JsonObject;", "a", "()Lcom/google/gson/JsonObject;", "b", "(Lcom/google/gson/JsonObject;)V", "", "msg", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "<init>", "()V", "Code", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class RegisterMessageResultModel implements aa {

        @SerializedName("code")
        private Code code;

        @SerializedName("data")
        private JsonObject data;

        @SerializedName("msg")
        private String msg;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/liveinteract/jsbridge/method/DynamicRegisterMessageMethod$RegisterMessageResultModel$Code;", "", "Lw20/z9;", "", "getCode", "value", "I", "getValue", "()I", "Success", "Failed", "NO_PERMISSION", "NOT_REGISTER", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
        public static final enum Code extends Enum<Code> implements z9 {
            public static final Code Failed = null;
            public static final Code NOT_REGISTER = null;
            public static final Code NO_PERMISSION = null;
            public static final Code Success = null;
            public static final /* synthetic */ Code[] a = null;
            private final int value;

            static {
                Code r1 = new Code("Success", 0, 1);
                Success = r1;
                Code r2 = new Code("Failed", 1, 0);
                Failed = r2;
                Code r3 = new Code("NO_PERMISSION", 2, -1);
                NO_PERMISSION = r3;
                Code r4 = new Code("NOT_REGISTER", 3, -2);
                NOT_REGISTER = r4;
                a = new Code[]{r1, r2, r3, r4};
            }

            public static Code valueOf(String r1) {
                return (Code) r27.a.a(Code.class, r1);
            }

            public static Code[] values() {
                return (Code[]) a.clone();
            }

            public int getCode() {
                return this.value;
            }

            public final int getValue() {
                return this.value;
            }

            public Code(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public RegisterMessageResultModel() {
        }

        public final JsonObject a() {
            return this.data;
        }

        public final void b(JsonObject r1) {
            this.data = r1;
        }
    }

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/liveinteract/jsbridge/method/DynamicRegisterMessageMethod$b;", "", "", "", "typeList", "Ljava/util/List;", "a", "()Ljava/util/List;", "setTypeList", "(Ljava/util/List;)V", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class b {

        @SerializedName("type_list")
        private List<String> typeList;

        public b() {
        }

        public final List<String> a() {
            return this.typeList;
        }
    }

    static {
        new HashMap();
    }

    public final void onClean() {
        DataCenter r0 = this.c;
        if (r0 == null) goto L5;
        vlc.d r1 = (vlc.d) r0.get("data_message_manager", null);
    L6:
        if (r1 == null) goto L8;
        r1.removeMessageListener(this.a);
    L8:
        DataCenter r2 = this.c;
        if (r2 == null) goto L13;
        HashMap r3 = (HashMap) r2.get("multilink_jsb_message_filter", null);
        if (r3 == null) goto L13;
        r3.clear();
    L13:
        int r4 = com.bytedance.android.live.browser.utils.j.a;
        com.bytedance.android.live.browser.utils.j.a(getCallContext());
        int r5 = com.bytedance.android.live.browser.utils.n.a;
        com.bytedance.android.live.browser.utils.n.b(getCallContext());
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void onTerminate() {
        ALogger.i("DynamicRegisterMessageMethod", "onTerminate");
        onClean();
    }

    public DynamicRegisterMessageMethod(DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "mDataCenter");
        this.c = r3;
        this.b = String.valueOf(System.currentTimeMillis());
    }

    public final void invoke(Object r9, CallContext r10) {
        b r11 = (b) r9;
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r10, "context");
        DataCenter r0 = this.c;
        HashMap r1 = null;
        if (r0 == null) goto L5;
        vlc.d r2 = (vlc.d) r0.get("data_message_manager", null);
    L6:
        DataCenter r3 = this.c;
        if (r3 == null) goto L9;
        r1 = (HashMap) r3.get("multilink_jsb_message_filter", null);
    L9:
        if (r1 != null) goto L11;
        r1 = new HashMap();
        this.c.put("multilink_jsb_message_filter", r1);
    L11:
        List<String> r12 = r11.a();
        if (r12 == null) goto L29;
        Iterator<T> r13 = r12.iterator();
    L15:
        if (r13.hasNext() == false) goto L29;
        String r4 = (String) r13.next();
        if (r1.containsKey(r4) == true) goto L15;
        r1.put(r4, 1);
        MessageType[] r5 = MessageType.values();
        int r6 = r5.length;
        int r7 = 0;
    L19:
        if (r7 >= r6) goto L15;
        MessageType r8 = r5[r7];
        if (com.bytedance.android.livesdk.message.linker.m.a(r8, r4) == true) goto L22;
        r7 = r7 + 1;
        goto L19
    L22:
        ALogger.i("DynamicRegisterMessageMethod", "registerMessage, messageType: " + r8.getKey());
        if (this.a != null) goto L25;
        this.a = new d(r10);
    L25:
        if (r2 == null) goto L27;
        r2.addMessageListener(r8.getIntType(), this.a);
    L27:
        int r14 = com.bytedance.android.live.browser.utils.n.a;
        com.bytedance.android.live.browser.utils.n.c(r10, Integer.valueOf(r8.getIntType()), this.a);
    L29:
        com.bytedance.android.live.browser.utils.j.b(r10, this);
        RegisterMessageResultModel r15 = new RegisterMessageResultModel();
        r15.b(new JsonObject());
        JsonObject r16 = r15.a();
        if (r16 == null) goto L32;
        r16.addProperty("listener_id", this.b);
    L32:
        IInteractService r17 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r17 == null) goto L37;
        ih0.b r18 = r17.dynamicService(this.c);
        if (r18 == null) goto L37;
        r18.oe(this.b, this.a);
    L37:
        finishWithResult(r15);
        return;
    L5:
        r2 = null;
        goto L6
    }
}

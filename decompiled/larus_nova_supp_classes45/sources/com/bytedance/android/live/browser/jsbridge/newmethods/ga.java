package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.RegisterMessageLatchResultModel;
import com.bytedance.android.live.browser.webview.config.LiveHybridSettingKeys;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.message.model.yf;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.android.livesdkapi.message.ExternalMessageInject;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class ga extends w20.f5<w20.gd, RegisterMessageLatchResultModel> implements com.bytedance.android.live.browser.jsbridge.e {
    public final vlc.d a;
    public final List<vlc.l> b;
    public final HashMap<vlc.l, Object> c;
    public final MessageHub d;

    public static final class a implements vlc.l {
        public final /* synthetic */ t9.b a;
        public final /* synthetic */ String b;
        public final /* synthetic */ CallContext c;

        /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.newmethods.ga$a$a, reason: collision with other inner class name */
        public static final class C0116a<T> implements Consumer {
            public final /* synthetic */ a a;

            public C0116a(a r1) {
                this.a = r1;
            }

            public final void accept(Object r3) {
                tlc.d r4 = (tlc.d) r3;
                if ((r4 instanceof BaseMessage) == true) goto L5;
                r4 = null;
            L5:
                BaseMessage r5 = (BaseMessage) r4;
                if (r5 == null) goto L16;
                byte[] r6 = r5.rawPayload;
                if (r6 == null) goto L17;
                a r0 = this.a;     // Catch: Exception -> L13
                this.a.c.b("H5_commonMessageLatch", UtilityKotlinExtentionsKt.o(new Pair[]{TuplesKt.to("data", r0.a.a(r6, r0.b).toString()), TuplesKt.to("messageType", this.a.b)}));
                return;
            L18:
                return;
            L17:
                return;
            }
        }

        public a(t9.b r1, String r2, CallContext r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void onMessage(tlc.d r2) {
            Observable.just(r2).observeOn(Schedulers.io()).subscribe(new C0116a(this));
        }
    }

    @Override // com.bytedance.android.live.browser.jsbridge.e
    public final void onClean() {
        Iterator r0 = ((ArrayList) this.b).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        vlc.l r1 = (vlc.l) r0.next();
        vlc.d r2 = this.a;
        if (r2 == null) goto L4;
        r2.removeMessageListener(r1);
        goto L4
    L8:
        Iterator r3 = ((ArrayList) this.b).iterator();
    L10:
        if (r3.hasNext() == false) goto L19;
        vlc.l r4 = (vlc.l) r3.next();
        Object r5 = this.c.get(r4);
        if ((r5 instanceof Integer) == true) goto L13;
        MessageHub r6 = this.d;
        if (r6 == null) goto L10;
        r6.removeMessageListener(String.valueOf(r5), r4);
        goto L10
    L13:
        MessageHub r7 = this.d;
        if (r7 == null) goto L10;
        r7.removeMessageListener(((Number) r5).intValue(), r4);
        goto L10
    L19:
        this.c.clear();
        int r8 = com.bytedance.android.live.browser.utils.j.a;
        com.bytedance.android.live.browser.utils.j.a(getCallContext());
        int r9 = com.bytedance.android.live.browser.utils.n.a;
        com.bytedance.android.live.browser.utils.n.b(getCallContext());
    }

    public final void onTerminate() {
        onClean();
    }

    public ga(DataCenter r2, MessageHub r3) {
        this.d = r3;
        vlc.d r4 = null;
        if (r2 == null) goto L5;
        r4 = (vlc.d) r2.get("data_message_manager", null);
    L5:
        this.a = r4;
        this.b = new ArrayList();
        this.c = new HashMap();
    }

    public final void invoke(Object r13, CallContext r14) {
        w20.gd r15 = (w20.gd) r13;
        Intrinsics.checkNotNullParameter(r15, "params");
        Intrinsics.checkNotNullParameter(r14, "context");
        String r0 = r15.c();
        if (r0 != null) goto L5;
        j(RegisterMessageLatchResultModel.Code.Failed, "message name not provided");
        return;
    L5:
        String r7 = r15.a();
        if (r7 != null) goto L8;
        j(RegisterMessageLatchResultModel.Code.Failed, "definition not provided");
        return;
    L8:
        MessageType[] r1 = MessageType.values();
        int r2 = r1.length;
        int r4 = 0;
    L10:
        if (r4 >= r2) goto L19;
        MessageType r5 = r1[r4];
        String r6 = StringsKt.removePrefix(StringsKt.removePrefix(r5.getWsMethod(), "WebcastContentOpen"), "Webcast");
        if (LiveHybridSettingKeys.LIVE_LYNX_DYNAMIC_MESSAGE_NEW_JUDGE.getValue().booleanValue() == false) goto L14;
        boolean r8 = StringsKt.endsWith$default(r0, "." + r6, false, 2, null);
    L15:
        if (r8 == true) goto L16;
        r4 = r4 + 1;
        goto L10
    L16:
        k(r0, r7, r14, r6, Integer.valueOf(r5.getIntType()));
        return;
    L14:
        r8 = StringsKt.endsWith$default(r0, r6, false, 2, null);
        goto L15
    L19:
        if (LiveHybridSettingKeys.LIVE_LYNX_DYNAMIC_MESSAGE.getValue().booleanValue() == false) goto L35;
        String r3 = r15.b();
        if (r3 != null) goto L23;
    L30:
        List r16 = StringsKt.split$default(r0, new char[]{'.'}, false, 0, 6, null);
        if ((!r16.isEmpty()) == false) goto L34;
        String r17 = "Webcast" + ((String) ListProtector.get(r16, r16.size() - 1));
    L33:
        String r9 = r17;
        ExternalMessageInject r18 = ExternalMessageInject.getInstance();
        ArrayList r11 = new ArrayList();
        r11.add(new ExternalMessageInject.InjectInfo(r9, yf.class));
        Unit r12 = Unit.INSTANCE;
        r18.inject(r11);
        k(r0, r7, r14, r9, null);
    L36:
        com.bytedance.android.live.browser.utils.j.b(r14, this);
        finishWithSuccess();
        return;
    L34:
        j(RegisterMessageLatchResultModel.Code.Failed, "message method not found");
        return;
    L23:
        if (r3.length() <= 0) goto L25;
        boolean r19 = true;
    L26:
        if (r19 != true) goto L30;
        r17 = r15.b();
        if (r17 != null) goto L33;
        r17 = "";
        goto L33
    L25:
        r19 = false;
        goto L26
    L35:
        j(RegisterMessageLatchResultModel.Code.Failed, "message not found in client");
        goto L36
    }

    public final void j(RegisterMessageLatchResultModel.Code r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "code");
        Intrinsics.checkNotNullParameter(r6, "msg");
        finishWithRawResult(UtilityKotlinExtentionsKt.o(new Pair[]{TuplesKt.to("code", r5), TuplesKt.to("msg", r6)}));
    }

    public final void k(String r4, String r5, CallContext r6, String r7, Integer r8) {
        Intrinsics.checkNotNullParameter(r4, "messageName");
        Intrinsics.checkNotNullParameter(r5, "definition");
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "messageMethod");
        t9.c r0 = com.bytedance.android.annie.a.c(t9.c.class);
        JsonElement r9 = GsonProtectorUtils.parse(new JsonParser(), r5);
        if ((r9 instanceof JsonObject) == true) goto L5;
        r9 = null;
    L5:
        JsonObject r11 = (JsonObject) r9;
        if (r11 != null) goto L9;
        j(RegisterMessageLatchResultModel.Code.Failed, "definition not a json-string");
        return;
    L9:
        t9.b r12 = r0.M0(r11);
        if (r12 != null) goto L14;
        j(RegisterMessageLatchResultModel.Code.Failed, "failed to obtain decoder");
        return;
    L14:
        if (r12.b(r4, null) == true) goto L17;
        j(RegisterMessageLatchResultModel.Code.Failed, "cannot decode " + r4 + " with specified definition");
        return;
    L17:
        im2.d.e.getClass();
        im2.d.a.d(r7);
        a r1 = new a(r12, r4, r6);
        ((ArrayList) this.b).add(r1);
        vlc.d r13 = this.a;
        if (r13 == null) goto L22;
        if (r8 == null) goto L21;
        r13.addMessageListener(r8.intValue(), r1);
    L31:
        if (r8 == null) goto L33;
        com.bytedance.android.live.browser.utils.n.c(r6, r8, r1);
    L34:
        finishWithSuccess();
        return;
    L33:
        com.bytedance.android.live.browser.utils.n.c(r6, r7, r1);
        goto L34
    L21:
        r13.addMessageListener(r7, r1);
        goto L31
    L22:
        if (r8 == null) goto L27;
        MessageHub r14 = this.d;
        if (r14 == null) goto L26;
        r14.addMessageListener(r8.intValue(), r1);
    L26:
        this.c.put(r1, r8);
        goto L31
    L27:
        MessageHub r15 = this.d;
        if (r15 == null) goto L30;
        r15.addMessageListener(r7, r1);
    L30:
        this.c.put(r1, r7);
        goto L31
    }
}

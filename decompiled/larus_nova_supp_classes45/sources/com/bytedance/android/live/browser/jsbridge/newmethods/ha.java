package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.annotations.SerializedName;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class ha extends com.bytedance.ies.web.jsbridge2.f<a, Unit> implements com.bytedance.android.live.browser.jsbridge.e {
    public vlc.l a;
    public final ArrayList<Integer> b;
    public final ArrayList<String> c;
    public final DataCenter d;
    public final MessageHub e;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/ha$a;", "", "", "", "typeList", "Ljava/util/List;", "a", "()Ljava/util/List;", "setTypeList", "(Ljava/util/List;)V", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("type_list")
        private List<String> typeList;

        public a() {
        }

        public final List<String> a() {
            return this.typeList;
        }
    }

    public static final class b implements vlc.l {
        public final /* synthetic */ CallContext a;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ b a;
            public final /* synthetic */ tlc.d b;

            public a(b r1, tlc.d r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void accept(Object r4) {
                tlc.d r5 = (tlc.d) r4;
                int r0 = com.bytedance.android.live.browser.jsbridge.d.a;
                String r1 = null;
                if ((r5 instanceof BaseMessage) == true) goto L5;
                r5 = null;
            L5:
                BaseMessage r6 = (BaseMessage) r5;
                if (r6 == null) goto L8;
                r1 = r6.getMessageMethod();
            L8:
                String r7 = com.bytedance.android.live.browser.jsbridge.d.b(r1);
                this.b.setMessageMethod(r7);
                JSONObject r2 = new JSONObject();
                r2.put("data_v2", GsonProtectorUtils.toJson(GsonHelper.getLynxWorkaround(), this.b));
                r2.put("messageType", r7);
                this.a.a.b("H5_commonMessage", r2);
            }
        }

        public b(CallContext r1) {
            this.a = r1;
        }

        public final void onMessage(tlc.d r3) {
            Observable.just(r3).observeOn(Schedulers.io()).subscribe(new a(this, r3));
        }
    }

    @Override // com.bytedance.android.live.browser.jsbridge.e
    public final void onClean() {
        DataCenter r0 = this.d;
        if (r0 == null) goto L7;
        vlc.d r1 = (vlc.d) r0.get("data_message_manager", null);
        if (r1 == null) goto L7;
        r1.removeMessageListener(this.a);
    L7:
        Iterator<Integer> r2 = this.b.iterator();
    L9:
        if (r2.hasNext() == false) goto L15;
        Integer r3 = r2.next();
        vlc.l r4 = this.a;
        if (r4 == null) goto L9;
        MessageHub r5 = this.e;
        if (r5 == null) goto L9;
        r5.removeMessageListener(r3.intValue(), r4);
        goto L9
    L15:
        Iterator<String> r6 = this.c.iterator();
    L17:
        if (r6.hasNext() == false) goto L23;
        String r7 = r6.next();
        vlc.l r8 = this.a;
        if (r8 == null) goto L17;
        MessageHub r9 = this.e;
        if (r9 == null) goto L17;
        r9.removeMessageListener(r7, r8);
        goto L17
    L23:
        int r11 = com.bytedance.android.live.browser.utils.j.a;
        com.bytedance.android.live.browser.utils.j.a(getCallContext());
        int r12 = com.bytedance.android.live.browser.utils.n.a;
        com.bytedance.android.live.browser.utils.n.b(getCallContext());
    }

    public final void onTerminate() {
        onClean();
    }

    public ha(DataCenter r1, MessageHub r2) {
        this.d = r1;
        this.e = r2;
        this.b = new ArrayList();
        this.c = new ArrayList();
    }

    public final void invoke(Object r18, CallContext r19) {
        a r2 = (a) r18;
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r19, "context");
        DataCenter r3 = this.d;
        if (r3 == null) goto L36;
        vlc.d r4 = (vlc.d) r3.get("data_message_manager", null);
        List<String> r5 = r2.a();
        if (r5 == null) goto L63;
        Iterator<T> r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L63;
        String r7 = (String) r6.next();
        String r8 = "Webcast" + r7;
        String r9 = "WebcastOpen" + r7;
        String r11 = "WebcastContentOpen" + r7;
        MessageType[] r12 = MessageType.values();
        int r13 = r12.length;
        int r14 = 0;
    L10:
        if (r14 >= r13) goto L27;
        MessageType r15 = r12[r14];
        String r16 = r15.getWsMethod();
        if (Intrinsics.areEqual(r16, r7) == true) goto L22;
        if (Intrinsics.areEqual(r16, r8) == true) goto L22;
        if (Intrinsics.areEqual(r16, r9) == true) goto L22;
        if (Intrinsics.areEqual(r16, r11) == true) goto L22;
        r14 = r14 + 1;
    L22:
        if (this.a != null) goto L24;
        this.a = new ia(r19);
    L24:
        if (r4 == null) goto L26;
        r4.addMessageListener(r15.getIntType(), this.a);
    L26:
        int r17 = com.bytedance.android.live.browser.utils.n.a;
        com.bytedance.android.live.browser.utils.n.c(r19, Integer.valueOf(r15.getIntType()), this.a);
        boolean r21 = true;
    L28:
        if (r21 == true) goto L8;
        if (this.a != null) goto L32;
        this.a = new ja(r19);
    L32:
        if (r4 == null) goto L34;
        r4.addMessageListener(r8, this.a);
    L34:
        int r22 = com.bytedance.android.live.browser.utils.n.a;
        com.bytedance.android.live.browser.utils.n.c(r19, r8, this.a);
        goto L8
    L27:
        r21 = false;
    L63:
        com.bytedance.android.live.browser.utils.j.b(r19, this);
        finishWithSuccess();
        return;
    L36:
        if (this.e == null) goto L63;
        List<String> r23 = r2.a();
        if (r23 == null) goto L63;
        Iterator<T> r24 = r23.iterator();
    L41:
        if (r24.hasNext() == false) goto L63;
        String r25 = (String) r24.next();
        String r26 = "Webcast" + r25;
        MessageType[] r27 = MessageType.values();
        int r28 = r27.length;
        int r110 = 0;
    L43:
        if (r110 >= r28) goto L52;
        MessageType r111 = r27[r110];
        if (Intrinsics.areEqual(r111.getWsMethod(), r26) == true) goto L46;
        if (Intrinsics.areEqual(r111.getWsMethod(), r25) == true) goto L49;
        r110 = r110 + 1;
        goto L43
    L49:
        j(this.e, r111, r19);
    L50:
        boolean r29 = true;
    L53:
        if (r29 == true) goto L41;
        MessageHub r31 = this.e;
        if (this.a != null) goto L57;
        this.a = new ka(r19);
    L57:
        vlc.l r32 = this.a;
        if (r32 == null) goto L62;
        this.c.add(r26);
        if (r31 == null) goto L62;
        r31.addMessageListener(r26, r32);
    L62:
        int r33 = com.bytedance.android.live.browser.utils.n.a;
        com.bytedance.android.live.browser.utils.n.c(r19, r26, this.a);
        goto L41
    L46:
        j(this.e, r111, r19);
        goto L50
    L52:
        r29 = false;
        goto L53
    }

    public final void j(MessageHub r4, MessageType r5, CallContext r6) {
        if (this.a != null) goto L5;
        this.a = new b(r6);
    L5:
        vlc.l r0 = this.a;
        if (r0 == null) goto L10;
        this.b.add(Integer.valueOf(r5.getIntType()));
        if (r4 == null) goto L10;
        r4.addMessageListener(r5.getIntType(), r0);
    L10:
        int r7 = com.bytedance.android.live.browser.utils.n.a;
        com.bytedance.android.live.browser.utils.n.c(r6, Integer.valueOf(r5.getIntType()), this.a);
    }
}

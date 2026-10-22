package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class y extends com.bytedance.ies.web.jsbridge2.f<a, Unit> implements com.bytedance.android.live.browser.jsbridge.e {
    public vlc.l a;
    public final ArrayList<Integer> b;
    public final DataCenter c;
    public final MessageHub d;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/liveinteract/jsbridge/method/y$a;", "", "", "", "typeList", "Ljava/util/List;", "a", "()Ljava/util/List;", "setTypeList", "(Ljava/util/List;)V", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class a {

        @SerializedName("type_list")
        private List<String> typeList;

        public a() {
        }

        public final List<String> a() {
            return this.typeList;
        }
    }

    public final void onClean() {
        DataCenter r0 = this.c;
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
        MessageHub r5 = this.d;
        if (r5 == null) goto L9;
        r5.removeMessageListener(r3.intValue(), r4);
        goto L9
    L15:
        int r6 = com.bytedance.android.live.browser.utils.j.a;
        com.bytedance.android.live.browser.utils.j.a(getCallContext());
        int r7 = com.bytedance.android.live.browser.utils.n.a;
        com.bytedance.android.live.browser.utils.n.b(getCallContext());
    }

    public final void onTerminate() {
        onClean();
    }

    public y(DataCenter r1, MessageHub r2) {
        this.c = r1;
        this.d = r2;
        this.b = new ArrayList();
    }

    public final void invoke(Object r9, CallContext r10) {
        a r11 = (a) r9;
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r10, "context");
        DataCenter r0 = this.c;
        if (r0 == null) goto L5;
        vlc.d r1 = (vlc.d) r0.get("data_message_manager", null);
    L7:
        if (r1 == null) goto L25;
        vlc.d r2 = (vlc.d) this.c.get("data_message_manager", null);
        List<String> r12 = r11.a();
        if (r12 == null) goto L45;
        Iterator<T> r13 = r12.iterator();
    L12:
        if (r13.hasNext() == false) goto L45;
        String r3 = (String) r13.next();
        MessageType[] r4 = MessageType.values();
        int r5 = r4.length;
        int r6 = 0;
    L14:
        if (r6 >= r5) goto L12;
        MessageType r7 = r4[r6];
        if (com.bytedance.android.livesdk.message.linker.m.a(r7, r3) == true) goto L18;
        r6 = r6 + 1;
        goto L14
    L18:
        if (this.a != null) goto L20;
        this.a = new z(r10);
    L20:
        if (r2 == null) goto L22;
        r2.addMessageListener(r7.getIntType(), this.a);
    L22:
        int r8 = com.bytedance.android.live.browser.utils.n.a;
        com.bytedance.android.live.browser.utils.n.c(r10, Integer.valueOf(r7.getIntType()), this.a);
    L45:
        com.bytedance.android.live.browser.utils.j.b(r10, this);
        finishWithSuccess();
        return;
    L25:
        if (this.d == null) goto L45;
        List<String> r14 = r11.a();
        if (r14 == null) goto L45;
        Iterator<T> r15 = r14.iterator();
    L30:
        if (r15.hasNext() == false) goto L45;
        String r16 = (String) r15.next();
        MessageType[] r17 = MessageType.values();
        int r18 = r17.length;
        int r19 = 0;
    L32:
        if (r19 >= r18) goto L30;
        MessageType r20 = r17[r19];
        if (com.bytedance.android.livesdk.message.linker.m.a(r20, r16) == true) goto L35;
        r19 = r19 + 1;
        goto L32
    L35:
        MessageHub r21 = this.d;
        if (this.a != null) goto L38;
        this.a = new a0(r10);
    L38:
        vlc.l r22 = this.a;
        if (r22 == null) goto L43;
        this.b.add(Integer.valueOf(r20.getIntType()));
        if (r21 == null) goto L43;
        r21.addMessageListener(r20.getIntType(), r22);
    L43:
        int r23 = com.bytedance.android.live.browser.utils.n.a;
        com.bytedance.android.live.browser.utils.n.c(r10, Integer.valueOf(r20.getIntType()), this.a);
        goto L30
    L5:
        r1 = null;
        goto L7
    }
}

package com.bytedance.android.live.liveinteract.jsbridge.method;

import android.view.View;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.browser.jsbridge.base.RegisterWrdsResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.message.wrds.MultiPreviewSyncDataType;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import w20.h5;
import w20.hd;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b1 extends h5<hd, RegisterWrdsResultModel> implements com.bytedance.android.live.browser.jsbridge.e {
    public final String a;
    public a1 b;
    public z0 c;
    public final Set<String> d;
    public final MessageHub e;
    public final Function2<String, Object, Unit> f;
    public final String g;
    public final Map<String, Map<String, List<Object>>> h;

    public final void onClean() {
        a1 r0 = this.b;
        if (r0 == null) goto L7;
        MessageHub r1 = this.e;
        if (r1 == null) goto L7;
        r1.removeWRDSListener(MultiPreviewSyncDataType.ROOM_LINK_MIC_SYNC_DATA, r0);
    L7:
        Iterator<T> r2 = this.d.iterator();
    L9:
        if (r2.hasNext() == false) goto L14;
        String r3 = (String) r2.next();
        MessageHub r4 = this.e;
        z0 r5 = this.c;
        if (r4 == null) goto L9;
        if (r5 == null) goto L9;
        r4.removeMessageListener(r3, r5);
        goto L9
    L14:
        int r6 = com.bytedance.android.live.browser.utils.j.a;
        com.bytedance.android.live.browser.utils.j.a(getCallContext());
        int r7 = com.bytedance.android.live.browser.utils.n.a;
        com.bytedance.android.live.browser.utils.n.b(getCallContext());
        CallContext r8 = getCallContext();
        if (((Boolean) com.bytedance.android.live.core.setting.r0.a.getValue()).booleanValue() == false) goto L28;
        if (r8 == null) goto L29;
        View r9 = r8.d;
        if (r9 == null) goto L30;
        r9.setTag(2131378197, null);
        return;
    L30:
        return;
    L29:
        return;
    }

    public final void onTerminate() {
        onClean();
    }

    public /* synthetic */ b1(MessageHub r4) {
        this(r4, null, "", new LinkedHashMap());
    }

    public final void invoke(Object r17, CallContext r18) {
        hd r2 = (hd) r17;
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r18, "context");
        List r3 = r2.a();
        if (r3 == null) goto L55;
        Iterator r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L55;
        String r5 = (String) r4.next();
        char r6 = 0;
        if (StringsKt.endsWith$default(r5, "SyncData", false, 2, null) == true) goto L9;
        Intrinsics.checkNotNullParameter(r5, "clazz");
        Intrinsics.checkNotNullParameter(r18, "context");
        if (StringsKt.startsWith$default(r5, "Webcast", false, 2, null) == true) goto L44;
        r5 = "Webcast" + r5;
    L44:
        MessageHub r7 = this.e;
        if (r7 == null) goto L50;
        tlc.d r8 = MessageHub.DefaultImpls.getLatestWRDSMessage$default(r7, r5, null, 2, null);
        if (r8 == null) goto L50;
        ALogger.i(this.a, "wrds v2 key: " + r5 + " get dataSync, msgId: " + r8.getMessageId() + ", isFromWrds: " + com.ss.ugc.live.sdk.msg.utils.a.b(r8));
        Schedulers.io().scheduleDirect(new y0(r8, this, r5, r18));
    L50:
        if (this.c != null) goto L52;
        this.c = new z0(this, r18);
    L52:
        if (r7 == null) goto L54;
        ALogger.i(this.a, "register wrds v2 key: " + r5 + " get dataSync, clazz: " + r5);
        z0 r9 = this.c;
        Intrinsics.checkNotNull(r9);
        r7.addMessageListener(r5, r9);
        this.d.add(r5);
    L54:
        int r10 = com.bytedance.android.live.browser.utils.n.a;
        com.bytedance.android.live.browser.utils.n.c(r18, r5, this.c);
        goto L6
    L9:
        Intrinsics.checkNotNullParameter(r5, "clazz");
        Intrinsics.checkNotNullParameter(r18, "context");
        if (this.b != null) goto L12;
        this.b = new a1(this, r5, r18);
    L12:
        a1 r11 = this.b;
        if (r11 == null) goto L6;
        Map<String, List<Object>> r12 = this.h.get(this.g);
        MultiPreviewSyncDataType[] r13 = MultiPreviewSyncDataType.values();
        int r14 = r13.length;
        int r15 = 0;
    L15:
        if (r15 >= r14) goto L6;
        MultiPreviewSyncDataType r16 = r13[r15];
        String r19 = r16.getSyncKey();
        if (Intrinsics.areEqual(r19, r5) == false) goto L40;
        if (r12 == null) goto L23;
        List<Object> r110 = r12.get(r19);
        if (r110 == null) goto L23;
        r110.add(r11);
    L25:
        MessageHub r111 = this.e;
        if (r111 == null) goto L28;
        r111.addWRDSListener(r16, r11, true);
    L28:
        int r112 = com.bytedance.android.live.browser.utils.n.a;
        a1 r113 = this.b;
        if (((Boolean) com.bytedance.android.live.core.setting.r0.a.getValue()).booleanValue() == false) goto L40;
        if (r18 == null) goto L40;
        View r114 = r18.d;
        if (r114 == null) goto L40;
        Object r20 = r114.getTag(2131378197);
        if ((r20 instanceof LinkedHashSet) == true) goto L36;
        r20 = null;
    L36:
        LinkedHashSet r21 = (LinkedHashSet) r20;
        if (r21 != null) goto L39;
        r21 = new LinkedHashSet();
        r114.setTag(2131378197, r21);
    L39:
        r21.add(new Pair(r16, r113));
    L23:
        if (r12 == null) goto L25;
        Object[] r115 = new Object[1];
        r115[r6] = r11;
        List<Object> r116 = r12.put(r19, CollectionsKt.arrayListOf(r115));
    L40:
        r15 = r15 + 1;
        r6 = 0;
    L55:
        com.bytedance.android.live.browser.utils.j.b(r18, this);
        finishWithSuccess();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b1(MessageHub r2, Function2<? super String, Object, Unit> r3, String r4, Map<String, Map<String, List<Object>>> r5) {
        Intrinsics.checkNotNullParameter(r4, "hybridCardHashCode");
        Intrinsics.checkNotNullParameter(r5, "wrdsDataUpdateListenerMap");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.a = "RegisterWrdsFeedMethod";
        this.d = new LinkedHashSet();
    }

    public static final void j(b1 r3, tlc.d r4, String r5, CallContext r6) {
        r3.getClass();
        JSONObject r0 = new JSONObject();
        r0.put("sync_data", GsonProtectorUtils.toJson(GsonHelper.get(), r4));
        r0.put("class_name", r5);
        ALogger.i(r3.a, "sendJsEvent wrds v2 message " + r4 + ", json " + r0);
        r6.b("H5_wrds", r0);
    }
}

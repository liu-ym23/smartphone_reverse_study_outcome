package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.view.View;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.browser.jsbridge.base.RegisterWrdsResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFrequencyOptConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonObject;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.processors.PublishProcessor;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class wa extends w20.h5<w20.hd, RegisterWrdsResultModel> implements com.bytedance.android.live.browser.jsbridge.e {
    public final String a;
    public qa b;
    public oa c;
    public final PublishProcessor<com.ss.ugc.live.sdk.message.wrsc.data.a> d;
    public final CompositeDisposable e;
    public final MultiLinkFrequencyOptConfig f;
    public final String g;
    public final DataCenter h;

    @Override // com.bytedance.android.live.browser.jsbridge.e
    public final void onClean() {
        ALogger.i(this.a, "RegisterWrdsMethod onClean");
        this.e.clear();
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.h, 0, 2);
        if (r0 == null) goto L7;
        ylc.e r1 = com.bytedance.android.livesdk.chatroom.utils.n3.g(r0);
        qa r2 = this.b;
        if (r2 == null) goto L7;
        Intrinsics.checkNotNullParameter(r2, "listener");
        r1.i(r2);
    L7:
        DataCenter r3 = this.h;
        if (r3 == null) goto L12;
        vlc.d r4 = (vlc.d) r3.get("data_message_manager", null);
        if (r4 == null) goto L12;
        ALogger.i(this.a, "removeMessageListener! listener " + this.c);
        r4.removeMessageListener(this.c);
    L12:
        int r5 = com.bytedance.android.live.browser.utils.j.a;
        com.bytedance.android.live.browser.utils.j.a(getCallContext());
        int r6 = com.bytedance.android.live.browser.utils.n.a;
        com.bytedance.android.live.browser.utils.n.b(getCallContext());
        CallContext r7 = getCallContext();
        if (((Boolean) com.bytedance.android.live.core.setting.r0.a.getValue()).booleanValue() == false) goto L19;
        if (r7 == null) goto L20;
        View r8 = r7.d;
        if (r8 == null) goto L21;
        r8.setTag(2131378196, null);
        return;
    L21:
        return;
    L20:
        return;
    }

    public final void onTerminate() {
        onClean();
    }

    public wa(DataCenter r3) {
        this.h = r3;
        this.a = "RegisterWrdsMethod";
        this.d = new PublishProcessor();
        this.e = new CompositeDisposable();
        this.f = (MultiLinkFrequencyOptConfig) com.bytedance.android.live.core.setting.v2.a.getValue();
        this.g = String.valueOf(System.currentTimeMillis());
    }

    public final void invoke(Object r13, CallContext r14) {
        w20.hd r15 = (w20.hd) r13;
        Intrinsics.checkNotNullParameter(r15, "params");
        Intrinsics.checkNotNullParameter(r14, "context");
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, this.h, 0, 2);
        if (r1 == null) goto L111;
        List<String> r16 = r15.a();
        if (r16 == null) goto L87;
        Iterator<T> r17 = r16.iterator();
    L9:
        if (r17.hasNext() == false) goto L87;
        String r2 = (String) r17.next();
        Object r6 = null;
        if (StringsKt.endsWith$default(r2, "SyncData", false, 2, null) == true) goto L12;
        Intrinsics.checkNotNullParameter(r2, "clazz");
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r1, "roomContext");
        if (this.h != null) goto L71;
        com.bytedance.android.live.core.utils.f2.g();
        Unit r3 = Unit.INSTANCE;
    L71:
        DataCenter r4 = this.h;
        if (r4 == null) goto L9;
        vlc.d r5 = (vlc.d) r4.get("data_message_manager", null);
        if (StringsKt.startsWith$default(r2, "Webcast", false, 2, null) == true) goto L76;
        r2 = "Webcast" + r2;
    L76:
        if (r5 == null) goto L81;
        tlc.d r7 = bc2.d.a(r5, r2);
        if (r7 == null) goto L81;
        ALogger.i(this.a, "wrds v2 key: " + r2 + " get dataSync, msgId: " + r7.getMessageId() + ", isFromWrds: " + com.ss.ugc.live.sdk.msg.utils.a.b(r7));
        Schedulers.io().scheduleDirect(new na(r7, this, r2, r14));
    L81:
        if (this.c != null) goto L83;
        this.c = new oa(this, r2, r14);
    L83:
        ALogger.i(this.a, "registerMessage! key: " + r2 + " get dataSync, listener " + this.c + ", im " + r5);
        if (r5 == null) goto L86;
        r5.addMessageListener(r2, this.c);
    L86:
        int r8 = com.bytedance.android.live.browser.utils.n.a;
        com.bytedance.android.live.browser.utils.n.c(r14, r2, this.c);
        goto L9
    L12:
        Intrinsics.checkNotNullParameter(r2, "clazz");
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r1, "roomContext");
        ylc.e r9 = com.bytedance.android.livesdk.chatroom.utils.n3.g(r1);
        Intrinsics.checkNotNullParameter(r2, "key");
        com.ss.ugc.live.sdk.message.wrsc.data.a r11 = r9.e(r2);
        if (r11 == null) goto L16;
        ALogger.i(this.a, "wrds key: " + r2 + " get dataSync, version: " + r11.a + ", bizLogId: " + r11.c);
        Schedulers.io().scheduleDirect(new pa(r11, this, r14));
    L16:
        if (this.b != null) goto L18;
        this.b = new qa(this, r2, r14);
        this.e.add(this.d.onBackpressureLatest().groupBy(ra.a).flatMap(new ua(this)).subscribe(new va(this, r14)));
    L18:
        IKtvService r12 = jc1.k.f(IKtvService.class);
        if (r12 == null) goto L24;
        Pair r18 = r12.getRoomWrdsListenerData();
        if (r18 == null) goto L24;
        Map r19 = (Map) r18.getSecond();
        if (r19 == null) goto L24;
    L25:
        IKtvService r21 = jc1.k.f(IKtvService.class);
        String r22 = "";
        if (r21 == null) goto L31;
        Pair r23 = r21.getRoomWrdsListenerData();
        if (r23 == null) goto L31;
        String r24 = (String) r23.getFirst();
        if (r24 == null) goto L31;
    L32:
        Map r25 = (Map) r19.get(r24);
        if (r25 == null) goto L37;
        List r26 = (List) r25.get(r2);
        if (r26 == null) goto L37;
        qa r27 = this.b;
        Intrinsics.checkNotNull(r27);
        r26.add(r27);
    L55:
        qa r28 = this.b;
        Intrinsics.checkNotNull(r28);
        r9.a(r2, r28);
        int r29 = com.bytedance.android.live.browser.utils.n.a;
        qa r31 = this.b;
        if (((Boolean) com.bytedance.android.live.core.setting.r0.a.getValue()).booleanValue() == false) goto L9;
        if (r14 == null) goto L9;
        View r32 = r14.d;
        if (r32 == null) goto L9;
        Object r33 = r32.getTag(2131378196);
        if ((r33 instanceof LinkedHashSet) == false) goto L64;
        r6 = r33;
    L64:
        LinkedHashSet r34 = (LinkedHashSet) r6;
        if (r34 != null) goto L67;
        r34 = new LinkedHashSet();
        r32.setTag(2131378196, r34);
    L67:
        r34.add(r31);
    L37:
        IKtvService r35 = jc1.k.f(IKtvService.class);
        if (r35 == null) goto L43;
        Pair r36 = r35.getRoomWrdsListenerData();
        if (r36 == null) goto L43;
        Map r37 = (Map) r36.getSecond();
        if (r37 == null) goto L43;
    L44:
        IKtvService r38 = jc1.k.f(IKtvService.class);
        if (r38 == null) goto L52;
        Pair r39 = r38.getRoomWrdsListenerData();
        if (r39 == null) goto L52;
        String r41 = (String) r39.getFirst();
        if (r41 == null) goto L52;
        r22 = r41;
    L52:
        Map r42 = (Map) r37.get(r22);
        if (r42 == null) goto L55;
        qa r43 = this.b;
        Intrinsics.checkNotNull(r43);
        List r44 = (List) r42.put(r2, CollectionsKt.arrayListOf(new Object[]{r43}));
    L43:
        r37 = new LinkedHashMap();
    L31:
        r24 = "";
    L24:
        r19 = new LinkedHashMap();
    L87:
        com.bytedance.android.live.browser.utils.j.b(r14, this);
        RegisterWrdsResultModel r110 = new RegisterWrdsResultModel();
        r110.b(new JsonObject());
        JsonObject r111 = r110.a();
        if (r111 == null) goto L90;
        r111.addProperty("listener_id", this.g);
    L90:
        IInteractService r112 = jc1.k.f(IInteractService.class);
        if (r112 == null) goto L95;
        ih0.b r113 = r112.dynamicService(this.h);
        if (r113 == null) goto L95;
        r113.oe(this.g, this.c);
    L95:
        finishWithResult(r110);
        return;
    }

    public static final void j(wa r2, com.ss.ugc.live.sdk.message.wrsc.data.a r3, CallContext r4) {
        r2.getClass();
        JSONObject r5 = new JSONObject();
        r5.put("sync_data", GsonProtectorUtils.toJson(GsonHelper.getLynxWorkaround(), r3.e));
        int r0 = com.bytedance.android.live.browser.jsbridge.d.a;
        r5.put("class_name", com.bytedance.android.live.browser.jsbridge.d.a(r3.g));
        r4.b("H5_wrds", r5);
    }

    public static final void k(wa r1, tlc.d r2, String r3, CallContext r4) {
        r1.getClass();
        JSONObject r5 = new JSONObject();
        r5.put("sync_data", GsonProtectorUtils.toJson(GsonHelper.getLynxWorkaround(), r2));
        r5.put("class_name", com.bytedance.android.live.browser.jsbridge.d.a(r3));
        r4.b("H5_wrds", r5);
    }
}

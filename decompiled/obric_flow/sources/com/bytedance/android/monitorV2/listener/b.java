package com.bytedance.android.monitorV2.listener;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.android.monitorV2.event.HybridEvent$EventPhase;
import com.bytedance.common.wschannel.WsConstants;
import java.util.HashSet;
import k5.k;
import ko.r;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f3610b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet f3611a;

    public b() {
        this.f3611a = SetsKt.hashSetOf(new String[]{"navigationStart", "performance", "perf"});
    }

    public final void a(com.bytedance.android.monitorV2.event.c r37, String r38) {
        HashSet r5 = this.f3611a;
        String r10 = r37.f3554a;
        if (r5.contains(r10) == false) goto L28;
        JSONObject r11 = new JSONObject();
        qo.a.m(r11, r37.d);
        Intrinsics.checkNotNullParameter(r11, "<this>");
        r r12 = new r(r11);
        JSONObject r13 = r11.optJSONObject("nativeBase");
        JSONObject r14 = qo.a.d(r13, "bid_info");
        JSONObject r15 = r11.optJSONObject("containerBase");
        String r16 = qo.a.p("bid", r14);
        String r17 = qo.a.p("setting_bid", r14);
        String r18 = qo.a.p("config_bid", r14);
        String r19 = qo.a.s("container_name", null, r15);
        String r110 = qo.a.s("schema", null, r15);
        String r20 = qo.a.s("version", null, r15);
        String r21 = qo.a.s("view_type", null, r15);
        String r22 = qo.a.s("biz", null, r15);
        String r23 = qo.a.s("core_view_type", null, r15);
        String r24 = qo.a.s("core_component", null, r15);
        String r111 = qo.a.p("url", r13);
        String r25 = k.a(r111);
        String r112 = qo.a.p("virtual_aid", r13);
        String r26 = qo.a.p("container_type", r13);
        String r27 = qo.a.p(WsConstants.KEY_SDK_VERSION, r13);
        String r113 = qo.a.p("page_version", r13);
        String r34 = "";
        if (Intrinsics.areEqual(r26, "web") == false) goto L7;
        String r33 = r113;
        String r114 = qo.a.p("web_version", r13);
    L11:
        String r35 = r114;
        if (Intrinsics.areEqual(r26, "web") == false) goto L14;
        r34 = qo.a.p("webview_type", r13);
    L14:
        String r28 = r34;
        JSONObject r29 = new JSONObject();
        if (HybridEvent$EventPhase.f3537a == ((HybridEvent$EventPhase) r37.f3555b.f18728b)) goto L17;
        qo.a.l(r29, "bid", r16);
        qo.a.l(r29, "setting_bid", r17);
        qo.a.l(r29, "container_bid", r18);
    L17:
        qo.a.l(r29, "container_name", r19);
        qo.a.l(r29, "schema", r110);
        qo.a.l(r29, "version", r20);
        qo.a.l(r29, "view_type", r21);
        qo.a.l(r29, "biz", r22);
        qo.a.l(r29, "core_view_type", r23);
        qo.a.l(r29, "core_component", r24);
        qo.a.l(r29, "stage", r38);
        qo.a.l(r29, "event_type", r10);
        qo.a.l(r29, "full_url", r111);
        qo.a.l(r29, "format_url", r25);
        qo.a.l(r29, "virtual_aid", r112);
        qo.a.l(r29, "engine_type", r26);
        qo.a.l(r29, WsConstants.KEY_SDK_VERSION, r27);
        qo.a.l(r29, "page_version", r33);
        qo.a.l(r29, "engine_version", r35);
        qo.a.l(r29, "webview_type", r28);
        Object r30 = r12.f("containerBase.context.annie_is_card");
        Intrinsics.checkNotNullParameter(r29, "<this>");
        Intrinsics.checkNotNullParameter("annie_is_card", STGroup.DICT_KEY);
        if (r30 == null) goto L24;
        Intrinsics.checkNotNullParameter(r29, "<this>");
        Intrinsics.checkNotNullParameter("annie_is_card", STGroup.DICT_KEY);
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L22
        Result.m124constructorimpl(r29.put("annie_is_card", r30));     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
    L24:
        u4.d.c("hybrid_monitor_sdk_trace", r29);
        return;
    L7:
        r33 = r113;
        if (Intrinsics.areEqual(r26, "lynx") == false) goto L10;
        r114 = qo.a.p("lynx_version", r13);
        goto L11
    L10:
        r114 = "";
        goto L11
    }
}

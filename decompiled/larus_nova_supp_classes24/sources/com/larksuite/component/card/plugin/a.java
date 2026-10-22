package com.larksuite.component.card.plugin;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.openplatform.v1.GetUuidRequest;
import com.bytedance.lark.pb.openplatform.v1.GetUuidResponse;
import com.larksuite.component.card.action.InteractiveHandler;
import com.larksuite.component.card.monitor.UniversalCardMonitorData;
import com.larksuite.component.card.monitor.UniversalCardMonitorUtils;
import com.larksuite.component.card.protocol.context.action.CardActionService;
import com.larksuite.component.ui.toast.LKUIToast;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {

    /* JADX INFO: renamed from: com.larksuite.component.card.plugin.a$a, reason: collision with other inner class name */
    public static final class C0025a {
    }

    public static final class b<T> implements SdkSender.IParser {
        public static final b<T> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object parse(byte[] r3) {
            return "c-" + ((GetUuidResponse) GetUuidResponse.ADAPTER.decode(r3)).uuid;
        }
    }

    static {
    }

    public static /* synthetic */ void b(String r10, Context r11, String r12, OPTrace r13, UniversalCardMonitorData r14, String r15, boolean r16) {
        a(r10, r11, r12, false, "", r13, r14, r15, r16, null);
    }

    public static void a(String r13, Context r14, String r15, boolean r16, String r17, OPTrace r19, UniversalCardMonitorData r110, String r20, boolean r21, Bundle r22) {
        Intrinsics.checkNotNullParameter(r13, "url");
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r15, "cardId");
        Intrinsics.checkNotNullParameter(r17, "chatId");
        Intrinsics.checkNotNullParameter(r110, "monitorData");
        if (TextUtils.isEmpty(r13) == false) goto L5;
    L7:
        boolean r3 = false;
    L9:
        if (r3 == false) goto L15;
        Log.i("LynxCardOpenUrl", "url unsupport");
        int r0 = UniversalCardMonitorUtils.a;
        ncb.c r1 = ncb.c.l;
        Intrinsics.checkNotNullParameter(r1, "monitorCode");
        Intrinsics.checkNotNullParameter(r110, "monitorData");
        if (TextUtils.isEmpty(r15) == true) goto L17;
        fyb.e r2 = com.larksuite.component.card.monitor.b.a;
        com.larksuite.component.card.monitor.b.c.a(r1).addCategoryValue(CardActionService.CARD_ID, r15).addMap(r110.getMonitorCategoryMap()).addCategoryValue("component_tag", r20).addCategoryValue("is_universal_card", Boolean.TRUE).addCategoryValue("is_streaming_mode", Boolean.valueOf(r21)).tracing(r19).flush();
        return;
    L17:
        return;
    L15:
        String r4 = (String) SdkSender.syncSend(Command.GET_UUID, new GetUuidRequest.Builder(), b.a);
        InteractiveHandler r5 = new InteractiveHandler();
        String r6 = InteractiveHandler.b(r13, r4);
        Log.d("LynxCardOpenUrl", "url with trigger code:" + r13);
        r5.c(r4, r15);
        ty7.a.a().openUrl(r14, r6, false, false, Boolean.valueOf(r16), r17, r22);
        UniversalCardMonitorUtils.f(r15, r19, r110, r20, r21);
        return;
    L5:
        if (r13.toLowerCase().startsWith("lark://msgcard/unsupported_action") == false) goto L7;
        LKUIToast.show(r14, 2131891987);
        r3 = true;
        goto L9
    }
}

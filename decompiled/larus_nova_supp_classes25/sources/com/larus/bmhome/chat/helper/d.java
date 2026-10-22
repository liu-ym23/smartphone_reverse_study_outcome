package com.larus.bmhome.chat.helper;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.router.SmartRouter;
import com.larus.im.bean.conversation.ForkConversationRequest;
import com.larus.im.bean.conversation.ForkType;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d implements IIMCallback<wc9.e> {
    public final /* synthetic */ Context a;
    public final /* synthetic */ Function1<wc9.e, Unit> b;
    public final /* synthetic */ Bundle c;
    public final /* synthetic */ ForkConversationRequest d;

    public final boolean mustInMain() {
        return true;
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.e("ChatRouterHelper", "conversation fork failed: " + r4);
        t19.s r5 = t19.s.a;
        Context r0 = this.a;
        r5.getClass();
        t19.s.b(r0, 2131901132, false);
    }

    public final void onSuccess(Object r5) {
        wc9.e r6 = (wc9.e) r5;
        boolean r0 = false;
        if (r6 != null) goto L5;
        t19.s r7 = t19.s.a;
        Context r1 = this.a;
        r7.getClass();
        t19.s.b(r1, 2131901132, false);
        return;
    L5:
        Function1<wc9.e, Unit> r2 = this.b;
        if (r2 == null) goto L8;
        r2.invoke(r6);
    L8:
        this.c.putString("argConversationId", r6.a);
        this.c.putBoolean("arg_need_to_show_ime", false);
        Bundle r8 = this.c;
        if (this.d.getForkType() != ForkType.AUTO_ROUTE) goto L11;
        r0 = true;
    L11:
        r8.putBoolean("conversation_fork_auto_route_reanswer", r0);
        this.c.putString("conversation_fork_ext", new JSONObject(this.d.getExt()).toString());
        String r9 = (String) this.d.getExt().get("reply_mode");
        if (r9 != null) goto L14;
    L19:
        Context r10 = this.a;
        if (z2.a.enableChatWithTab() == false) goto L22;
        String r3 = "//flow/chat_page";
    L23:
        com.bytedance.router.i r11 = SmartRouter.buildRoute(r10, r3);
        r11.c.addFlags(67108864);
        r11.c.putExtras(this.c);
        r11.d();
        return;
    L22:
        r3 = "//flow/chat_page_bridge";
        goto L23
    L14:
        if ((!StringsKt.isBlank(r9)) == true) goto L17;
        r9 = null;
    L17:
        if (r9 == null) goto L19;
        this.c.putString("reply_mode", r9);
        goto L19
    }

    public d(Context r1, Function1<? super wc9.e, Unit> r2, Bundle r3, ForkConversationRequest r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}

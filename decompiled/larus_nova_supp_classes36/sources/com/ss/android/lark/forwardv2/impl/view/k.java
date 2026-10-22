package com.ss.android.lark.forwardv2.impl.view;

import android.os.Bundle;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.forwardv2.impl.statistics.AppreciablePerformance;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.widget.richtext.RichText;
import java.io.Serializable;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final /* synthetic */ class k implements Runnable {
    public final /* synthetic */ d0 a;
    public final /* synthetic */ List b;
    public final /* synthetic */ RichText c;

    public /* synthetic */ k(d0 r1, List r2, RichText r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d0 r1 = this.a;
        List<SearchBaseInfo> r2 = this.b;
        RichText r3 = this.c;
        r1.getClass();
        Log.i("TemplateForwardView", "on proceedForward");
        Bundle r4 = r1.m;
        if (r4 == null) goto L7;
        Serializable r5 = r4.getSerializable("key_message");
        if ((r5 instanceof Message) == false) goto L7;
        Message r6 = (Message) r5;
        hib.d r7 = com.ss.android.lark.forwardv2.e.a;
        hib.d r8 = com.ss.android.lark.forwardv2.e.a.a();
        r6.getChatId();
        r8.getTargetType();
        int r9 = -1;
    L8:
        String r10 = AppreciablePerformance.a;
        if (r6 != null) goto L11;
    L13:
        boolean r11 = false;
    L14:
        if (r6 != null) goto L16;
    L18:
        int r12 = 0;
    L19:
        AppreciablePerformance.a = AppreciableKit.start$default(AppreciableKit.Companion.getInstance(), Biz.Messenger, Scene.Chat, Event.forward_message, "ForwardPickFragment", true, null, null, MapsKt.mapOf(new Pair[]{TuplesKt.to("message_type", Integer.valueOf(r12)), TuplesKt.to("chat_type", Integer.valueOf(r9)), TuplesKt.to("is_crypto", Boolean.valueOf(r11))}), null, 256, null);
        r1.d.i2(r1.c.getContext(), r2, r3);
        return;
    L16:
        if (r6.getType() == null) goto L18;
        r12 = r6.getType().getNumber();
        goto L19
    L11:
        if (r6.isSecret() == false) goto L13;
        r11 = true;
    L7:
        r6 = null;
        r9 = 0;
        goto L8
    }
}

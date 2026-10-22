package com.larus.bmhome.chat.component.title;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import by7.e;
import ce8.c;
import com.larus.bmhome.chat.g4;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.b3;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.service.z1;
import com.larus.ui.arch.component.internal.attach.a;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class y0 implements View.OnClickListener {
    public final /* synthetic */ ChatTitleComponent a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public /* synthetic */ y0(ChatTitleComponent r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r12) {
        ChatTitleComponent r0 = this.a;
        String r2 = this.b;
        String r10 = this.c;
        int r1 = ChatTitleComponent.P1;
        g4 r3 = r0.e4();
        if (r3 == null) goto L7;
        Intrinsics.checkNotNull(r12);
        boolean r13 = r3.j(r12);
        boolean r4 = true;
        if (r13 != true) goto L7;
    L8:
        if (r4 == false) goto L11;
        return;
    L11:
        if (c.a() == false) goto L13;
        t19.s r14 = t19.s.a;
        Context r5 = r0.getContext();
        String r6 = AppHost.a.getApplication().getString(2131901003);
        r14.getClass();
        t19.s.t(r5, r6);
        return;
    L13:
        r0.T4();
        z1 r15 = z1.a;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        b3.a.b(a.b(r0, r0), r2, null, null, null, null, false, null, 252);
        RecommendFrom r7 = r0.f1().d;
        e r8 = null;
        if (r7 == null) goto L16;
        String r9 = r7.b;
    L17:
        RecommendFrom r11 = r0.f1().d;
        if (r11 == null) goto L20;
        String r16 = r11.a;
    L21:
        JSONObject r17 = ChatControlTrace.b.Xb(r0.f1().d);
        if (r10 == null) goto L24;
        r17.put("bot_id", r10);
    L24:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Fragment r18 = a.b(r0, r0);
        if ((r18 instanceof e) == false) goto L27;
        r8 = (e) r18;
    L27:
        tx9.c0.d(r16, r9, null, r17, r8, 32383);
        return;
    L20:
        r16 = null;
        goto L21
    L16:
        r9 = null;
    L7:
        r4 = false;
        goto L8
    }
}

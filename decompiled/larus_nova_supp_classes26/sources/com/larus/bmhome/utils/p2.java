package com.larus.bmhome.utils;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.fragment.app.Fragment;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.i;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import ei9.c;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import t1a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class p2 implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ View a;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        if (q2.b == true) goto L40;
        FLogger r0 = FLogger.a;
        StringBuilder r2 = new StringBuilder("mainBotFirstShown by view: ");
        r2.append(this.a.getClass().getSimpleName());
        r2.append(", act: ");
        r2.append(this.a.getContext().getClass().getSimpleName());
        r2.append(", fragment: ");
        Fragment r3 = com.larus.utils.e1.k(this.a);
        if (r3 != null) goto L7;
        String r4 = "null";
    L8:
        r2.append(r4);
        r0.i("MainBotPageShowMobHelper", r2.toString());
        b r1 = c.a(this.a);
        if (r1 == null) goto L11;
        de8.c r5 = (de8.c) r1.a(de8.c.class);
    L12:
        String r6 = "";
        if (r5 == null) goto L15;
        String r7 = r5.k();
    L16:
        boolean r8 = false;
        if (r5 != null) goto L19;
    L21:
        boolean r9 = false;
    L22:
        if (r9 == false) goto L24;
    L27:
        int r10 = 1;
    L28:
        if (r5 == null) goto L30;
        r6 = r5.r();
    L30:
        long r11 = System.currentTimeMillis();
        IFlowSdkDepend r12 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r12 == null) goto L33;
        r12.r();
        long r13 = mc9.a.a.g();
    L34:
        JSONObject r14 = new JSONObject();
        r14.put("enter_method", r7);
        r14.put("is_cold_launch", r10);
        r14.put("start_type", i.a.b());
        r14.put("enter_url", r6);
        r14.put("duration", r11 - r13);
        com.larus.platform.service.o.a.reportEvent("main_bot_page_show", r14);
        if (r6.length() <= 0) goto L37;
        r8 = true;
    L37:
        if (r8 == false) goto L39;
        com.larus.platform.service.g.a.monitorEventForSlardar("main_bot_page_show", r14, null, null);
    L39:
        q2.b = true;
        q2.a = true;
        goto L40
    L33:
        r13 = 0;
        goto L34
    L24:
        if (q2.a == false) goto L27;
        r10 = 0;
        goto L28
    L19:
        if (r5.w() != true) goto L21;
        r9 = true;
        goto L22
    L15:
        r7 = "";
        goto L16
    L11:
        r5 = null;
        goto L12
    L7:
        r4 = r3.getClass().getSimpleName();
        Intrinsics.checkNotNull(r4);
    L40:
        return true;
    }

    public p2(View r1) {
        this.a = r1;
    }
}

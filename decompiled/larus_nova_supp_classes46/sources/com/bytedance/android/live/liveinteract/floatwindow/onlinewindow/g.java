package com.bytedance.android.live.liveinteract.floatwindow.onlinewindow;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerKickOutContent;
import com.bytedance.android.livesdkapi.floatview.FloatWindowConfig;
import com.bytedance.android.livesdkapi.floatview.IInnerFloatWindowManager;
import com.bytedance.android.livesdkapi.service.IMiddlewareInnerLiveFloatWindowService;
import com.bytedance.kmp.live.livelink.api.multilink.api.LinkSecurityApi;
import io.reactivex.functions.Consumer;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ LinkmicOnlineFloatWindowManager a;
    public final /* synthetic */ Integer b;

    public g(LinkmicOnlineFloatWindowManager r1, Integer r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r10) {
        Long r11 = (Long) r10;
        this.a.getClass();
        rx1.g r0 = LinkmicOnlineFloatWindowManager.m();
        View r1 = null;
        if (r0 == null) goto L7;
        rx1.f r2 = r0.a;
        if (r2 == null) goto L7;
        View r3 = r2.c;
    L9:
        if ((r3 instanceof b) == false) goto L12;
        r1 = r3;
    L12:
        b r4 = (b) r1;
        if (r4 == null) goto L21;
        TextView r5 = r4.l;
        if (r5 == null) goto L17;
        r5.setVisibility(8);
    L17:
        ViewGroup r6 = r4.g;
        if (r6 == null) goto L21;
        r6.setVisibility(0);
    L21:
        if (((int) r11.longValue()) != 5) goto L59;
        LinkmicOnlineFloatWindowManager r7 = this.a;
        if (r7.i == true) goto L60;
        IInnerFloatWindowManager.DefaultImpls.dismissFloatWindow$default(r7, 0, null, false, 6, null);
        Integer r12 = this.b;
        int r8 = ILinkerKickOutContent.LinkmicActionSource.ActionSourceSmallWindowToPKKicked.ordinal();
        if (r12 != null) goto L28;
    L29:
        Integer r13 = this.b;
        int r9 = LinkSecurityApi.CheckAudienceLinkersAction.CheckAudienceLinkersAction_Leave.ordinal();
        if (r13 != null) goto L33;
    L35:
        LinkmicOnlineFloatWindowManager r14 = this.a;
        int r15 = r14.J;
        if (r15 != 8) goto L38;
    L43:
        FloatWindowConfig r16 = new FloatWindowConfig(true);
        HashMap<String, String> r17 = r14.O;
        String r18 = "";
        if (r17 == null) goto L47;
        String r19 = r17.get("enter_from_merge");
        if (r19 == null) goto L47;
    L48:
        r16.setEnterFromMerge(r19);
        HashMap<String, String> r20 = r14.O;
        if (r20 == null) goto L54;
        String r21 = r20.get("enter_method");
        if (r21 == null) goto L54;
        r18 = r21;
    L54:
        r16.setEnterMethod(r18);
        IMiddlewareInnerLiveFloatWindowService r22 = jc1.k.f(IMiddlewareInnerLiveFloatWindowService.class);
        if (r22 == null) goto L62;
        r22.showLiveSteamFloatWindow(r14.m, r16);
        return;
    L62:
        return;
    L47:
        r19 = "";
        goto L48
    L38:
        if (r15 == 12) goto L43;
        if (r15 == 4) goto L43;
        if (r15 == 16) goto L43;
        return;
    L33:
        if (r13.intValue() != r9) goto L35;
    L57:
        LinkmicOnlineFloatWindowManager r110 = this.a;
        r110.i = true;
        r110.l();
        return;
    L28:
        if (r12.intValue() == r8) goto L57;
    L60:
        return;
    L59:
        return;
    L7:
        r3 = null;
        goto L9
    }
}

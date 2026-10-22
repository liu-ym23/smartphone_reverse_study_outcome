package com.larus.bmhome.chat.component.title;

import android.content.Context;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.ixigua.lib.track.TrackParams;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.d;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.s3;
import com.larus.platform.model.TriggerLoginScene;
import com.larus.platform.model.downgrade.FlowDowngradeToastConfig;
import com.larus.platform.service.i3;
import com.larus.platform.service.z2;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import s1a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class b0 implements Function1 {
    public final /* synthetic */ ChatTitleComponent a;

    public /* synthetic */ b0(ChatTitleComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r11) {
        ChatTitleComponent r0 = this.a;
        int r1 = ChatTitleComponent.P1;
        Intrinsics.checkNotNullParameter((TextView) r11, "it");
        IFlowSdkDepend r12 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        boolean r2 = false;
        if (r12 == null) goto L7;
        r12.getAccountService();
        if (d.a.M() != true) goto L7;
        boolean r13 = true;
    L9:
        if (r13 == false) goto L32;
        z2 r14 = z2.a;
        FlowDowngradeToastConfig r4 = r14.getFlowDowngradeToastConfig();
        String r5 = null;
        if (r4 == null) goto L13;
        String r6 = r4.getTrafficDegradationLogInDisableCn();
    L14:
        if (r6 != null) goto L16;
    L17:
        r2 = true;
    L18:
        if (r2 == false) goto L27;
        Fragment r15 = a.c(r0);
        if (r15 == null) goto L25;
        Context r16 = r15.getContext();
        if (r16 == null) goto L25;
        String r17 = r16.getString(2131910604);
        if (r17 == null) goto L25;
    L31:
        t19.s.j(t19.s.a, AppHost.a.getApplication(), r17, null, false, 28);
        tx9.s1.c("chat");
        return Unit.INSTANCE;
    L25:
        r17 = "";
        goto L31
    L27:
        FlowDowngradeToastConfig r18 = r14.getFlowDowngradeToastConfig();
        if (r18 == null) goto L30;
        r5 = r18.getTrafficDegradationLogInDisableCn();
    L30:
        r17 = String.valueOf(r5);
        goto L31
    L16:
        if (r6.length() != 0) goto L18;
    L13:
        r6 = null;
        goto L14
    L32:
        i3 r19 = i3.a;
        s3.a.a(TriggerLoginScene.TRIGGER_LOGIN_CHAT_LIST_GUIDE_BANNER, 2);
        JSONObject r110 = new JSONObject();
        Intrinsics.checkNotNullParameter(r110, "params");
        if (com.larus.utils.o0.d("chat") == false) goto L35;
        r110.put("current_page", "chat");
    L35:
        TrackParams r111 = new TrackParams().merge(r110);
        by7.a r3 = new by7.a("login_guide_banner_click");
        r3.a.merge(r111);
        r3.b();
        return Unit.INSTANCE;
    L7:
        r13 = false;
        goto L9
    }
}

package com.larus.bmhome.chat.model.repo;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.home.impl.sdk.ChatServiceImpl;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.TextContent;
import com.larus.im.bean.message.a;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class x0 implements Function0 {
    public final /* synthetic */ Message a;

    public /* synthetic */ x0(Message r1) {
        this.a = r1;
    }

    public final Object invoke() {
        Message r0 = this.a;
        Regex r1 = com.larus.bmhome.chat.bean.d.a;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        TextContent r2 = a.P(r0);
        if (r2 == null) goto L23;
        String r3 = r2.text;
        if (r3 == null) goto L23;
        if (r3.length() <= 0) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == true) goto L13;
        r3 = null;
    L13:
        String r5 = r3;
        if (r5 == null) goto L23;
        IFlowSdkDepend r6 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r6 == null) goto L23;
        r6.P();
        Fragment r7 = ChatServiceImpl.a.f();
        if (r7 == null) goto L23;
        ICoreInputAbility r8 = s1a.a.g(r7).getAbility(ICoreInputAbility.class);
        if (r8 == null) goto L23;
        ICoreInputAbility.b.d(r8, r5, true, true, null, null, false, 56);
        goto L23
    L9:
        r4 = false;
    L23:
        return Unit.INSTANCE;
    }
}

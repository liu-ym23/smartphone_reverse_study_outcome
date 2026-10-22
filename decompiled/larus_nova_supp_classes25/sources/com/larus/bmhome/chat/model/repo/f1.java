package com.larus.bmhome.chat.model.repo;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.home.impl.sdk.ChatServiceImpl;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import s1a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class f1 implements Function0 {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ String b;

    public /* synthetic */ f1(boolean r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        boolean r0 = this.a;
        String r2 = this.b;
        if (r0 == false) goto L12;
        IFlowSdkDepend r1 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r1 == null) goto L12;
        r1.P();
        Fragment r3 = ChatServiceImpl.a.f();
        if (r3 == null) goto L12;
        ICoreInputAbility r4 = a.g(r3).getAbility(ICoreInputAbility.class);
        if (r4 == null) goto L12;
        ICoreInputAbility.b.d(r4, r2, true, true, null, null, false, 56);
    L12:
        return Unit.INSTANCE;
    }
}

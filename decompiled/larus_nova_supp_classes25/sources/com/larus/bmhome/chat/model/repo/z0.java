package com.larus.bmhome.chat.model.repo;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.home.impl.sdk.ChatServiceImpl;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import s1a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class z0 implements Function0 {
    public final /* synthetic */ List a;

    public /* synthetic */ z0(List r1) {
        this.a = r1;
    }

    public final Object invoke() {
        List r0 = this.a;
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if ((r3 instanceof ai8.h) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        ai8.h r4 = (ai8.h) CollectionsKt.lastOrNull(r1);
        if (r4 == null) goto L29;
        String r5 = r4.a;
        if (r5 == null) goto L29;
        if (r5.length() <= 0) goto L15;
        boolean r6 = true;
    L16:
        if (r6 == true) goto L19;
        r5 = null;
    L19:
        String r7 = r5;
        if (r7 == null) goto L29;
        IFlowSdkDepend r8 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r8 == null) goto L29;
        r8.P();
        Fragment r9 = ChatServiceImpl.a.f();
        if (r9 == null) goto L29;
        ICoreInputAbility r10 = a.g(r9).getAbility(ICoreInputAbility.class);
        if (r10 == null) goto L29;
        ICoreInputAbility.b.d(r10, r7, true, true, null, null, false, 56);
        goto L29
    L15:
        r6 = false;
    L29:
        return Unit.INSTANCE;
    }
}

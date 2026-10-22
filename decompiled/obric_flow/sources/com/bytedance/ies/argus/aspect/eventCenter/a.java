package com.bytedance.ies.argus.aspect.eventCenter;

import com.bytedance.ies.argus.bean.ArgusGlobalAspect;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ies.argus.bean.a f4991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f4992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f4993c;

    public a(b r5, ArgusGlobalAspect r10, com.bytedance.ies.argus.strategy.provider.client.e r11) {
        Intrinsics.checkNotNullParameter(r10, "aspect");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        this.f4993c = r5;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r10, "aspect");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        com.bytedance.ies.argus.bean.a r12 = new com.bytedance.ies.argus.bean.a(r10, r11);
        r5.f4994a.getClass();
        this.f4991a = r12;
        new LinkedHashMap();
        this.f4992b = new ArrayList();
    }

    public static final void a(a r10) {
        if (r10.f4992b.isEmpty() == true) goto L6;
        BuildersKt.launch$default((CoroutineScope) r10.f4993c.f4996c.getValue(), null, null, new BaseEventCenter$VerifyHandler$executeReportTask$2(r10, null), 3, null);
        return;
    L6:
        Lazy r5 = com.bytedance.ies.argus.base.b.f5014a;
        com.bytedance.ies.argus.base.b.d(r10.f4991a);
    }
}

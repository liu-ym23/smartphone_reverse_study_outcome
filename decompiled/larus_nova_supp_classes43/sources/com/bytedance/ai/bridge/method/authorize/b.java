package com.bytedance.ai.bridge.method.authorize;

import f3.h;
import java.util.UUID;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class b implements Function1 {
    public final /* synthetic */ String a;
    public final /* synthetic */ UUID b;
    public final /* synthetic */ h c;
    public final /* synthetic */ OpenSettingMethod d;

    public /* synthetic */ b(String r1, UUID r10, h r11, OpenSettingMethod r12) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
    }

    public final Object invoke(Object r12) {
        String r0 = this.a;
        UUID r1 = this.b;
        h r10 = this.c;
        OpenSettingMethod r11 = this.d;
        String r13 = (String) r12;
        int r14 = OpenSettingMethod.b;
        if (r13 != null) goto L5;
        r11.getClass();
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new OpenSettingMethod$resolveLatestSetting$1(r0, r1, r10, null), 3, null);
        return Unit.INSTANCE;
    L5:
        if (a.a.a(r0, r1) == false) goto L10;
        h.a.a(r10, r13, null, null, 14);
    L10:
        return Unit.INSTANCE;
    }
}

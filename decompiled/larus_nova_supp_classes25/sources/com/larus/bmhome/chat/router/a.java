package com.larus.bmhome.chat.router;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class a implements Function0 {
    public final /* synthetic */ String a;

    public /* synthetic */ a(String r1) {
        this.a = r1;
    }

    public final Object invoke() {
        String r0 = this.a;
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new OpenFileUrlLinkRouterInterceptor$onInterceptRoute$4$1(r0, null), 3, null);
        return Unit.INSTANCE;
    }
}

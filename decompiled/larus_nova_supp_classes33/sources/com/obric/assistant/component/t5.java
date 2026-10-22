package com.obric.assistant.component;

import com.obric.memorydata.sdk.entity.search.SearchError;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class t5 implements Runnable {
    public final /* synthetic */ float a;
    public final /* synthetic */ float b;
    public final /* synthetic */ OrionChatWindowComponent c;

    public /* synthetic */ t5(float r1, float r2, OrionChatWindowComponent r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        float r0 = this.a;
        float r1 = this.b;
        OrionChatWindowComponent r2 = this.c;
        int r3 = OrionChatWindowComponent.T;
        if (r0 != r1) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == true) goto L9;
        r2.h3().setDuration((long) (Math.abs(r0 - r1) * SearchError.ERR_UNKNOWN));
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new OrionChatWindowComponent$startAnimator$1(r2, r0, r1, null), 3, null);
        return;
    L9:
        return;
    L5:
        r4 = false;
        goto L6
    }
}

package com.larus.bmhome.chat.component.bottom.core.inputtext;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h1 implements com.larus.platform.api.b {
    public final /* synthetic */ MultiTypeMentionPanelController a;

    public h1(MultiTypeMentionPanelController r1) {
        this.a = r1;
    }

    public final void a(com.larus.platform.api.c r8) {
        Intrinsics.checkNotNullParameter(r8, "event");
        MultiTypeMentionPanelController r9 = this.a;
        r9.C.a();
        BuildersKt.launch$default(r9.f, Dispatchers.getMain().getImmediate(), null, new MultiTypeMentionPanelController$invalidateAccount$1(r9, null), 2, null);
    }

    public final void b(com.larus.platform.api.c r8) {
        Intrinsics.checkNotNullParameter(r8, "event");
        MultiTypeMentionPanelController r9 = this.a;
        r9.C.a();
        BuildersKt.launch$default(r9.f, Dispatchers.getMain().getImmediate(), null, new MultiTypeMentionPanelController$invalidateAccount$1(r9, null), 2, null);
    }
}

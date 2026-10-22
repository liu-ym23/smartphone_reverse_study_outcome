package com.larus.bmhome.chat.component.bottom.talk;

import android.os.Bundle;
import android.os.Handler;
import com.larus.bmhome.chat.component.cvs.y;
import ic8.n;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class j implements y.a<wc9.e> {
    public final /* synthetic */ ChatContinueTalkComponent a;

    public j(ChatContinueTalkComponent r1) {
        this.a = r1;
    }

    public final void c(Object r12) {
        final wc9.e r13 = (wc9.e) r12;
        Intrinsics.checkNotNullParameter(r13, "new");
        if (n.d(r13) == false) goto L15;
        ChatContinueTalkComponent r0 = this.a;
        r0.s = r13.a;
        r0.t = r13;
        Bundle r1 = ((de8.c) s1a.d.a(r0).f(de8.c.class)).b;
        if (r1 == null) goto L7;
        String r2 = r1.getString("as_container");
    L9:
        if (Intrinsics.areEqual(r2, "FLOAT_CHAT") == false) goto L13;
        final ChatContinueTalkComponent r14 = this.a;
        ((Handler) r14.u.getValue()).postDelayed(new i(r14), 500);
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new ChatContinueTalkComponent$continueTalk$6(r14, null), 3, null);
        com.larus.bmhome.chat.component.showcase.y r15 = (com.larus.bmhome.chat.component.showcase.y) r14.p.getValue();
        if (r15 == null) goto L16;
        r15.Ta();
        return;
    L16:
        return;
    L13:
        final ChatContinueTalkComponent r3 = this.a;
        r3.F2().setOnClickListener(new ChatContinueTalkComponent$setOnClick$1(r3, r13));
        return;
    L7:
        r2 = null;
        goto L9
    }
}

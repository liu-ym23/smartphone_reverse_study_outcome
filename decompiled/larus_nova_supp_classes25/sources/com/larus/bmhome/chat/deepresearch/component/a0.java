package com.larus.bmhome.chat.deepresearch.component;

import android.view.View;
import com.larus.bmhome.chat.deepresearch.PodcastClickType;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a0 implements ne8.n {
    public final /* synthetic */ DeepReSearchContentComponent a;

    public a0(DeepReSearchContentComponent r1) {
        this.a = r1;
    }

    @Override // ne8.n
    public final void a(View r5, PodcastClickType r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, "type");
        final DeepReSearchContentComponent r7 = this.a;
        if (r6 != PodcastClickType.ROOT) goto L5;
        boolean r8 = true;
    L6:
        Function0<Unit> r0 = new x(r7);
        Function0<Unit> r1 = new y(r7);
        Function0<Unit> r2 = new z(r7);
        Map<String, Long> r3 = DeepReSearchContentComponent.M;
        r7.H3(r8, r0, r1, r2);
        return;
    L5:
        r8 = false;
        goto L6
    }
}

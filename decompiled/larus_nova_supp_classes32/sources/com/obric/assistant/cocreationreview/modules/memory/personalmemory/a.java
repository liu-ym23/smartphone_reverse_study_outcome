package com.obric.assistant.cocreationreview.modules.memory.personalmemory;

import android.view.View;
import com.obric.assistant.cocreationreview.j5;
import com.obric.assistant.cocreationreview.k5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a implements k5<g> {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    @Override // com.obric.assistant.cocreationreview.k5
    public final View a(j5 r2, com.obric.assistant.cocreationreview.a r3) {
        Intrinsics.checkNotNullParameter(r2, "buildContext");
        Intrinsics.checkNotNullParameter((g) r3, "record");
        View r4 = new View(r2.getContext());
        r4.setVisibility(8);
        return r4;
    }
}
